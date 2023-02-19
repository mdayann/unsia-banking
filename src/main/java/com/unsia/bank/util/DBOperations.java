package com.unsia.bank.util;

import java.sql.*;

public class DBOperations {

    public void addAccountDB(String accountNo, String name, double balance) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        Connection conn = dbConnection.connect();

        String sql = "INSERT INTO account (account_no, name, balance) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, accountNo);
        statement.setString(2, name);
        statement.setDouble(3, balance);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new account was inserted successfully!");
        }

        conn.close();

    }

    public void getAccountDB() throws  SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection conn = dbConnection.connect();

        String sql = "SELECT * FROM account";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;

        while (result.next()){
            String accountNo = result.getString("account_no");
            String name = result.getString("name");
            double balance = result.getDouble("balance");

            String output = "Account #%d: %s - %s - %s";
            System.out.println(String.format(output, ++count, accountNo, name, balance));
        }

        conn.close();

    }
}
