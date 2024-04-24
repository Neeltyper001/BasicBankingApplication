package com.users;

import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.queries.RegisterQueries;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUser implements RegisterQueries {

    private static ResultSet resultSet;
    private static PreparedStatement registerUserStatement;
    private static PreparedStatement getSingleUserStatement;
    public static void registeUser(String fullname, String username, String password,String accountNo, String pinNo){
        try{
            getSingleUserStatement = DbConnection.getConnection().prepareStatement(CHECK_USERNAME_QUERY);
            getSingleUserStatement.setString(1,username);
            RegisterUser.resultSet = getSingleUserStatement.executeQuery();
            String result = resultSet.getString("username");
            System.out.println(result);
            if(resultSet.next()){
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"The username already exists try different username!");

            }

            else{
                int accountNum = Integer.parseInt(accountNo);
                if(resultSet.getInt("account_no") == accountNum){
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(), "Same account number have already been registered by a user!");
                    return;
                }

                String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt(10));
                String hashedPin = BCrypt.hashpw(pinNo, BCrypt.gensalt(10));

                System.out.println(hashedPassword);
                System.out.println(hashedPin);

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
