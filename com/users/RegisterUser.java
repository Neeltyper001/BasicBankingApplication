package com.users;

import com.accounts.RegisterAccounts;
import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.queries.RegisterQueries;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUser implements RegisterQueries {

    private static ResultSet usernameResultSet;
    private static ResultSet accountNoResultSet;
    private static PreparedStatement registerUserStatement;
    private static PreparedStatement getSingleUserStatement;
    private static PreparedStatement getSingleUserAccountStatement;
    public static void registeUser(String fullname, String username, String password,String accountNo, String pinNo){
        try{
            int accountNum = Integer.parseInt(accountNo);
            RegisterUser.getSingleUserStatement = DbConnection.getConnection().prepareStatement(CHECK_USERNAME_FOR_REGISTER_QUERY);
            RegisterUser.getSingleUserAccountStatement = DbConnection.getConnection().prepareStatement(CHECK_ACCOUNT_NO_FOR_REGISTER_QUERY);
            RegisterUser.getSingleUserStatement.setString(1,username);
            RegisterUser.getSingleUserAccountStatement.setString(1,accountNo);
            RegisterUser.usernameResultSet = RegisterUser.getSingleUserStatement.executeQuery();
            RegisterUser.accountNoResultSet = RegisterUser.getSingleUserAccountStatement.executeQuery();

            boolean userExists = usernameResultSet.next();
            System.out.println(userExists);
            boolean accountExists = accountNoResultSet.next();

            if(userExists){
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"The username already exists try different username!");
            }

            else{
                if(accountExists){
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(), "Same account number have already been registered by a user!");
                    return;
                }

                String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt(10));
                String hashedPin = BCrypt.hashpw(pinNo, BCrypt.gensalt(10));

                System.out.println(hashedPassword);
                System.out.println(hashedPin);

                // it basically calls the function of register account class to register the number
                RegisterAccounts.registerUserAccount(accountNum,hashedPin);

                registerUserStatement = DbConnection.getConnection().prepareStatement(REGISTER_USER_QUERY);
                registerUserStatement.setString(1,fullname);
                registerUserStatement.setString(2,username);
                registerUserStatement.setString(3,hashedPassword);
                registerUserStatement.setInt(4,accountNum);

                int insertionResult = registerUserStatement.executeUpdate();

                if(insertionResult > 0){
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"User Registered Succesfully!!" );
                }

                else{
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Cannot register the user" );
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
