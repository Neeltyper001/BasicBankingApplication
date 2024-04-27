package com.dbconnection;
import com.utils.DbConnectionThread;
import java.sql.Connection;
public class DbConnection {

    private static Connection connection;
    public DbConnection(){
        DbConnectionThread dbConnectionThread = new DbConnectionThread();
        Thread thread = new Thread(dbConnectionThread);
        thread.start();
    }

    public static void setConnection(Connection connection){
         DbConnection.connection = connection;
    }

    public static Connection getConnection(){
        return DbConnection.connection;
    }
}
