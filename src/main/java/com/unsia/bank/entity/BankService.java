package com.unsia.bank.entity;

import com.unsia.bank.exception.DuplicateAccountException;

import java.util.ArrayList;
import java.util.List;

public class BankService implements Bank {

    private List<Account> accounts = new ArrayList<Account>();

    @Override
    public void addAccount(String accountNo, String name) {
        Account account = getAccount(accountNo);
        if (account != null) throw new DuplicateAccountException("Duplicated account.");
        accounts.add(new NormalAccount(accountNo, name));
    }

    @Override
    public void addAccount(String accountNo, String name, double balance) {
        Account account = getAccount(accountNo);
        if (account != null) throw new DuplicateAccountException("Duplicated account.");
        accounts.add(new NormalAccount(accountNo, name, balance));
    }

    @Override
    public void addAccount(String accountNo, String name, String type) {
        Account account = getAccount(accountNo);
        if (account != null) throw new DuplicateAccountException("Duplicated account.");
        if (type != null && type.equals("-")) {
            accounts.add(new MinusAccount(accountNo, name));
        } else {
            accounts.add(new NormalAccount(accountNo, name));
        }
    }

    @Override
    public void addAccount(String accountNo, String name, double balance, String type) {
        Account account = getAccount(accountNo);
        if (account != null) throw new DuplicateAccountException("Duplicated account.");
        if (type != null && type.equals("-")) {
            accounts.add(new MinusAccount(accountNo, name, balance));
        } else {
            accounts.add(new NormalAccount(accountNo, name, balance));
        }

    }

    @Override
    public Account getAccount(String accountNo) {
        int totalAccount = accounts.size();
        for (int i = 0; i < totalAccount; i++) {
            if (accountNo.equals(accounts.get(i).getAccountNo())) {
                return accounts.get(i);
            }
        }

        return null;
    }

    @Override
    public List<Account> findAccountByName(String name) {
        List<Account> matched = new ArrayList<Account>();
        int totalAccount = accounts.size();
        for (int i = 0; i < totalAccount; i++) {
            if (name.equals(accounts.get(i).getName())) {
                matched.add(accounts.get(i));
            }
        }

        return matched;
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }
}
