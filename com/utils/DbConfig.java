package com.utils;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DbConfig {
    private  String driver;
    private  String databaseName;
    private  String URL;
    private  String username;
    private  String password;
    private FileReader fileReader;
    private Properties properties;

    public DbConfig(){
        try{
            this.fileReader = new FileReader("src/com/env/config.txt");
            this.properties = new Properties();
            this.properties.load(fileReader);
            setDbConfig();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setDbConfig(){
        this.databaseName = this.properties.getProperty("databaseName");
        this.URL = this.properties.getProperty("URL");
        this.username = this.properties.getProperty("username");
        this.password = this.properties.getProperty("password");
        this.driver = this.properties.getProperty("driver");
    }

    public String getDatabaseName(){
        return this.databaseName;
    }
    public String getURL(){
        return this.URL;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public String getDriver(){
        return this.driver;
    }
}
