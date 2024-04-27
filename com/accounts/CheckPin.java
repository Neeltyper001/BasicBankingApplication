package com.accounts;

import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.queries.TransactionQueries;
import com.users.LoginUser;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckPin implements TransactionQueries {

    public static boolean CheckPin( Account account , String pinNo ){
        try{
            PreparedStatement checkPinStatement = DbConnection.getConnection().prepareStatement(CHECK_PIN_QUERY);
            checkPinStatement.setInt(1, account.getAccountNum());
            ResultSet checkPinResultSet = checkPinStatement.executeQuery();
            boolean isValidResponse = checkPinResultSet.next();

            if(isValidResponse){
                if(BCrypt.checkpw(pinNo,checkPinResultSet.getString("security_pin"))){
                    return true;
                }

                else{
                    return false;
                }
            }

            else{
                return false;
            }
        }catch (SQLException e){
            return false;
        }

    }
}
