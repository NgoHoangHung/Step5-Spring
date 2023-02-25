package com.example.librarymanager.service;

import com.example.librarymanager.model.dto.BorrowerDTO;
import com.example.librarymanager.model.entity.Borrower;
import com.example.librarymanager.model.entity.Wallet;
import com.example.librarymanager.repository.BorrowerRepository;
import com.example.librarymanager.repository.WalletRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private WalletServiceImpl walletService;

    @Override
    public Borrower getById(int id) {
        return null;
    }

    @Override
    public List<Borrower> getAll() {
        return null;
    }


    @Override
    public Borrower creatBorrower(BorrowerDTO dto) {
        if (!borrowerRepository.existsByPhone(dto.getPhone())) {
            ModelMapper mapper = new ModelMapper();
            Borrower newborrower = new Borrower();
            newborrower.setName(dto.getName());
            newborrower.setPhone(dto.getPhone());
            newborrower.setCccd(dto.getCccd());
            if (dto.getWallet() == null || !walletRepository.existsByBorrower_Phone(dto.getPhone())) {
                Wallet input = new Wallet();
                input.setAccountNum(walletService.generateID());
                input.setBalance(0);
                walletRepository.save(input);
                newborrower.setWallet(input);
            } else {
                newborrower.setWallet(mapper.map(dto.getWallet(), Wallet.class));
            }
            borrowerRepository.save(newborrower);
            return newborrower;
        }
        return null;
    }

    @Override
    public String updateBorrower(BorrowerDTO dto) {
        return null;
    }

    @Override
    public String deleteBorrower(int id) {
        return null;
    }
}
