package com.utils;
import com.dbconnection.DbConnection;
import com.utils.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionThread implements Runnable{

    private DbConfig dbConfig = new DbConfig();
    private static Connection connection;

    @Override
    public void run(){
        try{
         Class.forName(dbConfig.getDriver());
            System.out.println("Drivers loaded successfully");
            DbConnectionThread.connection  = DriverManager.getConnection(dbConfig.getURL(), dbConfig.getUsername(), dbConfig.getPassword());
            System.out.println("Connection established successfully");
            DbConnection.setConnection(connection);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
