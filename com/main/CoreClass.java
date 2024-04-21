package com.main;
import com.dbconnection.DbConnection;
public class CoreClass {
    private DbConnection dbConnection;
    public CoreClass(){
        System.out.println("We are here!!");
        DbConnection dbConnection = new DbConnection();

    }
}
