package com.accounts;

import com.dbconnection.DbConnection;
import com.queries.RegisterQueries;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterAccounts implements RegisterQueries {

    private static PreparedStatement registerAccountQuery;

    public static void registerUserAccount(int accountNo , String pinNo){
        try{
            RegisterAccounts.registerAccountQuery = DbConnection.getConnection().prepareStatement(REGISTER_ACCOUNT_QUERY);
            RegisterAccounts.registerAccountQuery.setInt(1,accountNo);
            RegisterAccounts.registerAccountQuery.setDouble(2,0);
            RegisterAccounts.registerAccountQuery.setString(3,pinNo);

            int result = RegisterAccounts.registerAccountQuery.executeUpdate();

            if(result > 0){
                System.out.println("User account created succesfully");
            }
            else{
                System.out.println("Cannot create the user account");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
