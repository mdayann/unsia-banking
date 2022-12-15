package com.unsia.bank.entity;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Account {
    private String accountNo;
    private String name;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<Transaction>();

    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    static final String DEPOSIT = "Deposit";
    static final String WITHDRAW = "Withdrawal";
    static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();

    public Account() {
    }

    public Account(String accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        Transaction transaction = new Transaction();
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        transaction.setTransactionDate(DATE_FORMAT.format(date));
        transaction.setTransactionTime(TIME_FORMAT.format(date));
        transaction.setAmount(amount);
        transaction.setBalance(balance);
        transaction.setType(DEPOSIT);
        transactions.add(transaction);
    }

    public abstract void withdraw(double amount);

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract String getType();

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(accountNo);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(balance);

        return sb.toString();
    }
}
