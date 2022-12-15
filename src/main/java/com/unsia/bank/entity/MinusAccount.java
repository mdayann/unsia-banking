package com.unsia.bank.entity;

import java.util.Calendar;
import java.util.Date;

public class MinusAccount extends Account {
    static final String TYPE = "Minus";

    public MinusAccount() {}

    public MinusAccount(String accountNo, String name) {
        super(accountNo, name);
    }

    public MinusAccount(String accountNo, String name, double balance) {
        super(accountNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance = balance - amount;
        Transaction transaction = new Transaction();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        transaction.setTransactionDate(Account.DATE_FORMAT.format(date));
        transaction.setTransactionTime(Account.TIME_FORMAT.format(date));
        transaction.setAmount(amount);
        transaction.setBalance(balance);
        transaction.setType(Account.WITHDRAW);
        transactions.add(transaction);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
