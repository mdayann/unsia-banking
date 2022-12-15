package com.unsia.bank.entity;

import java.util.ArrayList;
import java.util.List;

public interface Bank {
    //Create an account.
    public void addAccount(String accountNo, String name);

    //Create an account.
    public void addAccount(String accountNo, String name, double balance);

    //Create an account.
    public void addAccount(String accountNo, String name, String kind);

    //Create an account.
    public void addAccount(String accountNo, String name, double balance, String kind);

    //Find the account by account number.
    public Account getAccount(String accountNo);

    //Find the account by owner name.
    public List<Account> findAccountByName(String name);

    //Return all accounts.
    public List<Account> getAccounts();
}
