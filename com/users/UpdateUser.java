package com.users;

import com.accounts.Account;
import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.queries.UserQueries;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser implements UserQueries {

    public static void updatePin(String pin,int accountNo){
        if(pin.length() > 4 || pin.length() <4){
            JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Pin should be of length 4");
            return;
        }
        String hashedPin = BCrypt.hashpw(pin,BCrypt.gensalt(10));
        try{
            PreparedStatement updatePinStatement = DbConnection.getConnection().prepareStatement(UPDATE_USER_PIN);
            updatePinStatement.setString(1,hashedPin);
            updatePinStatement.setInt(2,accountNo);

            int rowsAffected = updatePinStatement.executeUpdate();

            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Pin updated successfully");
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Couldn't update the pin");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void updatePassword(String password, String username){
        String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt(10));
        try{
            PreparedStatement updatePasswordStatement = DbConnection.getConnection().prepareStatement(UPDATE_USER_PASSWORD);
            updatePasswordStatement.setString(1,hashedPassword);
            updatePasswordStatement.setString(2,username);

            int rowsAffected = updatePasswordStatement.executeUpdate();

            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Password updated successfully");
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Couldn't update the password");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
