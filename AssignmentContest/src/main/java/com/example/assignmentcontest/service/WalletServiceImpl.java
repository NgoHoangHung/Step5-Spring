package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.WalletDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletServiceImpl implements WalletService {
    @Override
    public List<WalletDTO> getListWalletDTO() {
        return null;
    }

    @Override
    public String insertWallet(WalletDTO walletDTO) {
        return null;
    }

    @Override
    public String editWallet(String phone, WalletDTO walletDTO) {
        return null;
    }
}
