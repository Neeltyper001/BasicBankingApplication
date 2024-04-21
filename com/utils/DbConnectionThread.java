package com.utils;
import com.utils.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionThread implements Runnable{

    private DbConfig dbConfig = new DbConfig();
    private Connection connection;

    @Override
    public void run(){
        try{
         Class.forName(dbConfig.getDriver());
            System.out.println("Drivers loaded successfully");
            this.connection  = DriverManager.getConnection(dbConfig.getURL(), dbConfig.getUsername(), dbConfig.getPassword());
            System.out.println("Connection established successfully");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public Connection getConnectionResult(){
        return this.connection;
    }
}
