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
            LoginUser.getSingleUserStatement = DbConnection.getConnection().prepareStatement(CHECK_USERNAME_FOR_LOGIN_QUERY);
            LoginUser.getSingleUserStatement.setString(1,username);
            LoginUser.resultSet = getSingleUserStatement.executeQuery();

            boolean userFound = resultSet.next();

            if(userFound){
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if(dbUsername.equals(username) && BCrypt.checkpw(password,dbPassword)){
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Welcome "+username);
                }

                else{
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid password!!");
                }
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid username!!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
