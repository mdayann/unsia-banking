package com.unsia.bank.entity;

public class Transaction {
    private String transactionDate;
    private String transactionTime;
    private String type;
    private double amount;
    private double balance;

    public Transaction(String transactionDate, String transactionTime, String type, double amount, double balance) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public Transaction() {

    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(transactionDate);
        sb.append("|");
        sb.append(transactionTime);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(Account.NUMBER_FORMAT.format(amount));
        sb.append("|");
        sb.append(Account.NUMBER_FORMAT.format(balance));

        return sb.toString();
    }
}
