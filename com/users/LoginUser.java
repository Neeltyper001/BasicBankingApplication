package com.users;

import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.queries.LoginQueries;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser implements LoginQueries {
    private static ResultSet resultSet;
    private static PreparedStatement getSingleUserStatement;

    public static void loginUser(String username, String password){

        try{
            LoginUser.getSingleUserStatement = DbConnection.getConnection().prepareStatement(CHECK_USERNAME_QUERY);
            LoginUser.getSingleUserStatement.setString(1,username);
            LoginUser.resultSet = getSingleUserStatement.executeQuery();

            if(resultSet.next()){
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if(dbUsername.equals(username) && BCrypt.checkpw(password,dbPassword)){
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Welcome "+username);
                }

                else{
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid Credentials!!");
                }
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Some error occured!!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
