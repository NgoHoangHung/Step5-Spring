package com.example.assignment4jpa_shopmanage.model.dto;

import com.example.assignment4jpa_shopmanage.model.entity.Wallet;


public class CustomerDTO {
    private String name;
    private String phone;
    private Wallet wallet;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWallet(Wallet wallet) {
        Wallet tmp = new Wallet();
        tmp.setId(wallet.getId());
        tmp.setAccountNumber(wallet.getAccountNumber());
        tmp.setBank(wallet.getBank());
        this.wallet = tmp;
    }

    public CustomerDTO(String name, String phone, Wallet wallet) {
        this.name = name;
        this.phone = phone;
        Wallet tmp = new Wallet();
        tmp.setId(wallet.getId());
        tmp.setAccountNumber(wallet.getAccountNumber());
        tmp.setBank(wallet.getBank());
        this.wallet = tmp;
    }

    public CustomerDTO() {
    }
}
