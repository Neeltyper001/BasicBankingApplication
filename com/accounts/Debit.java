package com.accounts;

import com.dbconnection.DbConnection;
import com.queries.TransactionQueries;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Debit implements TransactionQueries {

    public static void debitAmount(double amount, int accountNo){
        try{
            PreparedStatement debitAmountStatement = DbConnection.getConnection().prepareStatement(DEBIT_QUERY);
//            debitAmountStatement.setString();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
