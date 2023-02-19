package com.unsia.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String DB_URL = "jdbc:postgresql://localhost:5432/unsia";
    private final String DB_USER = "postgres";
    private final String DB_PASSWORD = "postgres";

    public Connection connect() {


        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {

        DBConnection dbConnection = new DBConnection();

        dbConnection.connect();
    }
}
