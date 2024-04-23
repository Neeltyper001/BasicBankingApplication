package com.main;
import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;


public class CoreClass {
    private DbConnection dbConnection;
    private MainFrame mainFrame;

    public CoreClass(){
        System.out.println("We are here!!");
         this.dbConnection = new DbConnection();
         this.mainFrame = new MainFrame();
    }
}
