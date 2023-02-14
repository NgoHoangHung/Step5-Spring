package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.ShipperDTO;
import com.example.assignmentcontest.model.dto.WalletDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletService {
    public List<WalletDTO> getListWalletDTO();

    public String insertWallet(WalletDTO walletDTO);

    public String editWallet(String phone, WalletDTO walletDTO);

}
