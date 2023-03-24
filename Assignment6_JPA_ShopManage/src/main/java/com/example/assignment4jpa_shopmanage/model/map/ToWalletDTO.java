package com.example.assignment4jpa_shopmanage.model.map;

import com.example.assignment4jpa_shopmanage.model.dto.WalletDTO;
import com.example.assignment4jpa_shopmanage.model.entity.Wallet;

public class ToWalletDTO {
    public WalletDTO toWalletDTO(Wallet input){
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setAccountNumber(input.getAccountNumber());
        walletDTO.setAccountNumber(input.getAccountNumber());
        return walletDTO;
    }
}
