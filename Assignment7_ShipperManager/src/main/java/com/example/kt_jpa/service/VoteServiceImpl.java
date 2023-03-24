package com.example.kt_jpa.service;

import com.example.kt_jpa.model.dto.VoteDTO;
import com.example.kt_jpa.model.entities.Orderr;
import com.example.kt_jpa.model.entities.Shiper;
import com.example.kt_jpa.model.entities.Vote;
import com.example.kt_jpa.model.entities.Wallet;
import com.example.kt_jpa.repository.OrderrRepository;
import com.example.kt_jpa.repository.ShipperRepository;
import com.example.kt_jpa.repository.VoteRepository;
import com.example.kt_jpa.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteServiceImpl implements VoteService {
    @Autowired
    private OrderrRepository orderrRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote getVoteById(int id) {
        return null;
    }

    @Override
    public String insertVote(VoteDTO dto) {
        Vote input = new Vote();
        input.setRate(dto.getRate());
        input.setMessage(dto.getMessage());
        voteRepository.save(input);
            Orderr orderr = orderrRepository.findById(dto.getOrder_id()).get();
            Shiper shiper = orderr.getShiper();

        if (input.getRate() < 3) {

            double penaty = orderr.getPrice()*0.05;
            orderr.setPrice(orderr.getPrice() + penaty);
            Wallet wallet = shiper.getWallet();
            wallet.setBalance(wallet.getBalance() - penaty);
            orderrRepository.save(orderr);
            walletRepository.save(wallet);
            shipperRepository.save(shiper);
        }
        return "đã vote thành công";
    }
}
