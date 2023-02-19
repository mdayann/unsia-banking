package com.unsia.bank;

import com.unsia.bank.entity.Account;
import com.unsia.bank.entity.Bank;
import com.unsia.bank.entity.BankService;
import com.unsia.bank.entity.Transaction;
import com.unsia.bank.util.DBOperations;

import java.sql.SQLException;
import java.util.List;

public class UnsiaBankApplication {

    static final String ACCOUNTS_HEADING = "AccountNo|Owner|Balance";
    static final String TRANSACTIONS_HEADING = "Date|Time|D/W|Amount|Balance";

    public static void main(String[] args) throws SQLException {

        DBOperations dbOperations = new DBOperations();

        //Create test accounts
        Bank bank = new BankService();
        bank.addAccount("101", "Dayan");
        dbOperations.addAccountDB("101","Dayan",0);

        bank.addAccount("202", "Norman");
        dbOperations.addAccountDB("202","Norman",0);

        bank.addAccount("303", "Ema");
        dbOperations.addAccountDB("303","Ema",0);

        bank.addAccount("404", "Rey");
        dbOperations.addAccountDB("404","Rey",0);

        bank.addAccount("505", "Dayan");
        dbOperations.addAccountDB("505","Dayan",0);

        bank.addAccount("606", "Credit", "-");
        dbOperations.addAccountDB("606","Credit",1400000);

        System.out.println("---------------------------------\n");

        //Get Account From Database
        dbOperations.getAccountDB();

        System.out.println("---------------------------------\n");

        //1. Print out the total account list.
        System.out.println("1. Print out the total account list.");
        List<Account> accounts = bank.getAccounts();
        int totalAccount = bank.getAccounts().size();
        System.out.println(ACCOUNTS_HEADING);
        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("---------------------------------\n");

        //2. Deposit 100000 into 101 account.
        System.out.println("2. Deposit 100000 into 101 account.");
        Account dayan = bank.getAccount("101");
        dayan.deposit(100000);
        System.out.println(ACCOUNTS_HEADING);
        System.out.println(dayan);

        System.out.println("---------------------------------\n");
//
        //3. Withdraw 50000 from 101 account.
        System.out.println("3. Withdraw 50000 from 101 account.");
        dayan.withdraw(50000);
        System.out.println(ACCOUNTS_HEADING);
        System.out.println(dayan);

        System.out.println("---------------------------------\n");

        //4. Print transaction history of the 101 account.
        System.out.println("4. Print transaction history of the 101 account.");
        List<Transaction> transactions = dayan.getTransactions();
        System.out.println(TRANSACTIONS_HEADING);
        for (Transaction transaction : transactions) {
            System.out.println(transactions);
        }

        System.out.println("---------------------------------\n");

        //5. Find your account by customer name.
        System.out.println("5. Find Dayan Account.");
        List<Account> matched = bank.findAccountByName("Dayan");
        System.out.println(ACCOUNTS_HEADING);
        for (Account account : matched) {
            System.out.println(account);
        }

        //Pre-6 Deposit into 404
        System.out.println("Pre-6. Deposit 100000 into 404 account.");
        Account rey = bank.getAccount("404");
        rey.deposit(100000);
        System.out.println(ACCOUNTS_HEADING);
        System.out.println(rey);

        System.out.println("---------------------------------\n");


        //6.Withdraw 50000 from 404 account.
        System.out.println("6.Withdraw 50000 from 404 account.");
        rey.withdraw(50000);
        System.out.println(ACCOUNTS_HEADING);
        System.out.println(rey);

        System.out.println("---------------------------------\n");


        //7.Withdraw 50000 from 606 account.
        System.out.println("6.Withdraw 50000 from 606 account.");
        Account credit = bank.getAccount("606");
        credit.withdraw(50000);
        System.out.println(ACCOUNTS_HEADING);
        System.out.println(credit);

        System.out.println("---------------------------------\n");


        //7.Exception Withdraw 50000 from 505 account.
        System.out.println("7.Withdraw 50000 from 505 account.");
        Account newDayan = bank.getAccount("505");
        newDayan.withdraw(50000);
        System.out.println(ACCOUNTS_HEADING);
        System.out.println(newDayan);


    }
}