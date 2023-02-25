package com.example.librarymanager.service;

import com.example.librarymanager.model.dto.BookDTO;
import com.example.librarymanager.model.dto.TicketBookDTO;
import com.example.librarymanager.model.entity.*;
import com.example.librarymanager.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketBookServiceImpl implements TicketBookService {

    @Autowired
    private TicketBookRepository ticketBookRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    private BorrowerService borrowerService;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private WalletService walletService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TypeRepository typeRepository;


    @Override
    public TicketBook getById(int id) {
        return ticketBookRepository.findById(id);
    }
    @Override
    public List<TicketBook> getAll1() {

        List<TicketBook> list = ticketBookRepository.findAll();
        for (TicketBook ticketBook : list) {
            bookRepository.findBooksByTicketBookId(ticketBook.getId());
        }
        return list;
    }

    @Override
    public List<TicketBook> getAll() {
        return null;
    }

    @Override
    public String lostBookTicket(TicketBookDTO dto,int quantity) {
        List<BookDTO> bookDTOList= dto.getBookList();

        for (BookDTO bookDTO : bookDTOList) {
//        bookDTO
        }
        return null;
    }

    public double totalprice(List<BookDTO> bookDTOList) {
        double sum = 0;
        for (BookDTO bookDTO : bookDTOList) {
            sum += bookDTO.getQuantityTransactions() * bookDTO.getPrice();
        }
        return sum;
    }

    @Transactional
    @Override
    public String buyBook(TicketBookDTO dto) {
        if (dto.getId() != null) return "ticket đã tồn tại trong hệ thống";
        TicketBook newTicket = new TicketBook();
        ticketBookRepository.save(newTicket);

        LocalDate currentDate = LocalDate.now();
        newTicket.setCreatAt(currentDate);

        ModelMapper mapper = new ModelMapper();
//        List<Book> bookList = dto.getBookList().stream().map(bookDTO -> mapper.map(bookDTO, Book.class))
//                .peek(book -> book.setTicketBooks(newTicket))
//                .collect(Collectors.toList());
        bookRepository.saveAll(bookList);
        newTicket.setBooks(bookList);
        newTicket.setServicez(Servicez.BUY);
        newTicket.setCreatAt(currentDate);
        newTicket.setStatus("Nhận sách thành công.");
        newTicket.setNote("người dùng mua vào ngày " + currentDate);
        double totalPrice = totalprice(dto.getBookList());
        newTicket.setTotalPrice(totalPrice);

        if (!borrowerRepository.existsByPhone(dto.getBorrower().getPhone())) {
            //logic lên người thuê chưa tồn tại trong hệ thống. thanh toán
            Borrower newBorrower = borrowerService.creatBorrower(dto.getBorrower());
            if (newBorrower.getWallet().getBalance() == 0 || newBorrower.getWallet().getBalance() < totalPrice)
                newBorrower.getWallet().setBalance(totalPrice);

            Wallet walletCenter = walletRepository.findByAccountNum("123123");

            walletCenter.setBalance(walletCenter.getBalance() + totalPrice);
            newBorrower.getWallet().setBalance(newBorrower.getWallet().getBalance() - totalPrice);
            walletRepository.save(walletCenter);
            borrowerRepository.save(newBorrower);
            newTicket.setBorrower(newBorrower);
        } else {
            //logic với người đã tồn tại trong hệ thống
            Borrower borrower = borrowerRepository.findByPhone(dto.getBorrower().getPhone());
            if (borrower.getWallet().getBalance() == 0 || borrower.getWallet().getBalance() < totalPrice) {
                borrower.getWallet().setBalance(borrower.getWallet().getBalance() + totalPrice);
            }
            borrower.getWallet().setBalance(borrower.getWallet().getBalance() - totalPrice);

            Wallet walletCenter = walletRepository.findByAccountNum("123123");
            walletCenter.setBalance(walletCenter.getBalance() + totalPrice);
            walletRepository.saveAll(Arrays.asList(walletCenter, borrower.getWallet()));

            borrowerRepository.save(borrower);
            newTicket.setBorrower(borrower);
        }
        return "mua thành công";
    }

    @Transactional
    @Override
    public String rentBook(TicketBookDTO dto) {
        if (dto.getId() != null) return "ticket đã tồn tại trong hệ thống";

        TicketBook newTicket = new TicketBook();
        ticketBookRepository.save(newTicket);

        LocalDate currentDate = LocalDate.now();
        newTicket.setCreatAt(currentDate);

        LocalDate returnDate = currentDate.plusDays(dto.getReturnDay());
        newTicket.setReturnDay(returnDate);

        ModelMapper mapper = new ModelMapper();
        List<Book> bookList = dto.getBookList().stream().map(bookDTO -> mapper.map(bookDTO, Book.class))
                .peek(book -> book.setTicketBook(newTicket))
                .collect(Collectors.toList());
        bookRepository.saveAll(bookList);
//        List<BookDTO> bookDTOS = dto.getBookList();
//        List<Book> bookList = new ArrayList<>();
//        for (BookDTO bookDTO : bookDTOS) {
//            Book book = new Book();
//            book.setName(bookDTO.getName());
//            book.setAuthor(bookDTO.getAuthor());
//            book.setQuantity(bookDTO.getQuantityTransactions());
//            book.setPrice((bookDTO.getPrice()));
//            book.setType(typeRepository.findById(bookDTO.getType().getId()).get());
//            book.setTicketBook(newTicket);
//            bookRepository.save(book);
////            bookList.add(book);
//        }

        newTicket.setBooks(bookList);
        newTicket.setServicez(Servicez.RENT);
        newTicket.setCreatAt(currentDate);
        newTicket.setStatus("Nhận sách thành công. chưa thanh toán");
        newTicket.setNote("người dùng mượn từ ngày " + currentDate +
                "\nDự kiếntrả vào ngày + " + returnDate);

        if (!borrowerRepository.existsByPhone(dto.getBorrower().getPhone())) {
            //logic lên người thuê chưa tồn tại trong hệ thống
            Borrower newBorrower = borrowerService.creatBorrower(dto.getBorrower());

            borrowerRepository.save(newBorrower);
            newTicket.setBorrower(newBorrower);
        } else {
            //logic với người đã tồn tại trong hệ thống
            Borrower borrower = borrowerRepository.findByPhone(dto.getBorrower().getPhone());
            borrowerRepository.save(borrower);
            newTicket.setBorrower(borrower);
        }

        return "thêm phiếu thành công vào hệ thống";

    }

    @Override
    public String returnBook(TicketBookDTO dto) {
        TicketBook ticketBook = ticketBookRepository.findById(dto.getId()).get();
        LocalDate returnDate = LocalDate.now();
        long dates = ChronoUnit.DAYS.between(ticketBook.getCreatAt(), returnDate);
        ticketBook.setTotalPrice(dates * 10000);
        Borrower borrower = ticketBook.getBorrower();

        if (borrower.getWallet().getBalance() == 0 || borrower.getWallet().getBalance() < ticketBook.getTotalPrice()) {
            borrower.getWallet().setBalance(borrower.getWallet().getBalance() + ticketBook.getTotalPrice());
        }
        borrower.getWallet().setBalance(borrower.getWallet().getBalance() - ticketBook.getTotalPrice());

        Wallet walletCenter = walletRepository.findByAccountNum("123123");

        walletCenter.setBalance(walletCenter.getBalance() + ticketBook.getTotalPrice());
        walletRepository.saveAll(Arrays.asList(walletCenter, borrower.getWallet()));
        ticketBook.setNote(ticketBook.getNote() + "\n đã trả sách vào " + returnDate);
        ticketBookRepository.save(ticketBook);
        borrowerRepository.save(borrower);
        return "đã thanh toán thành công";
    }

    @Override
    public String updateTicket(TicketBookDTO dto) {
        return null;
    }

    @Override
    public String deleteTicket(int id) {
        return null;
    }


}
