package com.example.assignment4jpa_shopmanage.model.dto;

import lombok.Data;

@Data
public class ShopDTO {
    private int id;
    private String nameShop;
    private String phone;

    private WalletDTO walletDTO;

}
