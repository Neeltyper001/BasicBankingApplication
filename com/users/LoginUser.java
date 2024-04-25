package com.users;

import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.mysql.cj.log.Log;
import com.queries.LoginQueries;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser implements LoginQueries {
    private static ResultSet resultSet;
    private static PreparedStatement getSingleUserStatement;
    private static LoginResponse loginResponse;

    public static class LoginResponse{
        private static double amount;
        private static boolean loginStatus;

        public static double getAmount(){
            return LoginResponse.amount;
        }

        public static boolean getLoginStatus(){
            return LoginResponse.loginStatus;
        }

    }

    public static LoginResponse loginUser(String username, String password){

        try{
            LoginUser.getSingleUserStatement = DbConnection.getConnection().prepareStatement(CHECK_USERNAME_FOR_LOGIN_QUERY);
            LoginUser.getSingleUserStatement.setString(1,username);
            LoginUser.resultSet = getSingleUserStatement.executeQuery();

            boolean userFound = resultSet.next();

            if(userFound){
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                int dbUserAccountNo = Integer.parseInt(resultSet.getString("account_no"));


                if(dbUsername.equals(username) && BCrypt.checkpw(password,dbPassword)){
                    PreparedStatement getUserAccountAmount = DbConnection.getConnection().prepareStatement(GET_USER_ACCOUNT_AMOUNT);
                    getUserAccountAmount.setInt(1,dbUserAccountNo);
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Welcome "+username);

                    LoginResponse.amount = dbUserAccountNo;
                    LoginResponse.loginStatus = userFound;
                    return loginResponse;
                }

                else{
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid password!!");
                    LoginResponse.loginStatus = false;
                    LoginResponse.amount = 0;
                    return loginResponse;
                }
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid username!!");
                LoginResponse.loginStatus = false;
                LoginResponse.amount = 0;
                    return loginResponse;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            LoginResponse.loginStatus = false;
            LoginResponse.amount = 0;
                return loginResponse;
        }
    }


}
