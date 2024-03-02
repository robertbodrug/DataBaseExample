package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection connection;
    private static final Database database = new Database();
    private Database(){
        try{
            connection = DriverManager.getConnection("jdbc:h2:mem:");

        }
        catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static Database getInstance(){
     return database;
    }
}

