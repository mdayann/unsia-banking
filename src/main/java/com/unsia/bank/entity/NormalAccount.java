package com.unsia.bank.entity;

import com.unsia.bank.exception.InsufficientBalanceException;

import java.util.Calendar;
import java.util.Date;

public class NormalAccount extends Account {
    static final String TYPE = "Normal";

    public NormalAccount() {}

    public NormalAccount(String accountNo, String name) {
        super(accountNo, name);
    }

    public NormalAccount(String accountNo, String name, double balance) {
        super(accountNo, name, balance);
    }

    @Override
    public void withdraw(double amount)  {
        if (amount > balance) {
            throw new InsufficientBalanceException("There is not enough balance.");
        }
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
