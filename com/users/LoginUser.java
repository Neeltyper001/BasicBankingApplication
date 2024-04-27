package com.users;

import com.accounts.Account;
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

    public static Account loginUser(String username, String password){
            Account account = new Account(0,false,0);

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
                    ResultSet userAccountAmount = getUserAccountAmount.executeQuery();
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Welcome "+username);

                    if(userAccountAmount.next()){
                        System.out.println("Got loginResponse amount");
                        account.setAccountNum(dbUserAccountNo);
                        account.setLoginStatus(true);
                        account.setAmount(userAccountAmount.getDouble("account_balance"));
                        return account;
                    }

                    else{
                        System.out.println("Didn't get it");
                        return account;
                    }
                }

                else{
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid password!!");
                    return account;
                }
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid username!!");
                return account;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return account;
        }
    }

}
