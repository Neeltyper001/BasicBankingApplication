package com.accounts;

import com.dbconnection.DbConnection;
import com.gui.main.MainFrame;
import com.queries.TransactionQueries;
import com.users.LoginUser;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account implements TransactionQueries {

    private double amount;
    private boolean loginStatus;
    private int accountNum;

    public Account(double amount, boolean loginStatus, int accountNum) {
        this.amount = amount;
        this.loginStatus = loginStatus;
        this.accountNum = accountNum;

    }

    public boolean getLoginStatus() {
        return this.loginStatus;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccountNum(int accountNum) {

        this.accountNum = accountNum;
    }

    public boolean debitAmount(double amount){
        try{
            if(amount > this.amount){
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Insufficient balance to withdraw amount");
                return false;
            }
            DbConnection.getConnection().setAutoCommit(false);
            PreparedStatement debitStatement = DbConnection.getConnection().prepareStatement(DEBIT_QUERY);
            // to be proceeded
            debitStatement.setDouble(1,amount);
            debitStatement.setInt(2,this.accountNum);
            int rowsAffected = debitStatement.executeUpdate();

            if(rowsAffected > 0){
                DbConnection.getConnection().commit();
                DbConnection.getConnection().setAutoCommit(true);
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Amount withdrawn successfully");
                this.amount = this.amount - amount;
                return true;
            }
            else{
                DbConnection.getConnection().rollback();
                DbConnection.getConnection().setAutoCommit(true);
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Amount cannot be withdrawn");
                return false;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean creditAmount(double amount){
        try{
            DbConnection.getConnection().setAutoCommit(false);
            PreparedStatement debitStatement = DbConnection.getConnection().prepareStatement(CREDIT_QUERY);
            // to be proceeded
            debitStatement.setDouble(1,amount);
            debitStatement.setInt(2,this.accountNum);
            int rowsAffected = debitStatement.executeUpdate();

            if(rowsAffected > 0){
                DbConnection.getConnection().commit();
                DbConnection.getConnection().setAutoCommit(true);
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Amount deposited successfully");
                this.amount = this.amount + amount;
                return true;
            }
            else{
                DbConnection.getConnection().rollback();
                DbConnection.getConnection().setAutoCommit(true);
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Amount cannot be withdrawn");
                return false;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean transferAmount(String amountTransfer , String receipentsAccountNo){
        double amount = Double.parseDouble(amountTransfer);

        if(amount > this.getAmount()){
            JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Insufficient balance to transfer amount");
            return false;
        }

        int receipentsAccountNum = Integer.parseInt(receipentsAccountNo);
        try{
            PreparedStatement checkReceipentsAccountStatement = DbConnection.getConnection().prepareStatement(CHECK_USER_ACCOUNT_NO);
            checkReceipentsAccountStatement.setInt(1,receipentsAccountNum);

            ResultSet receipentsUserAccountResultSet = checkReceipentsAccountStatement.executeQuery();

            boolean isValidAccountNum = receipentsUserAccountResultSet.next();

            if(isValidAccountNum){
                DbConnection.getConnection().setAutoCommit(false);
                PreparedStatement debitStatement = DbConnection.getConnection().prepareStatement(DEBIT_QUERY);
                PreparedStatement creditStatement = DbConnection.getConnection().prepareStatement(CREDIT_QUERY);
                debitStatement.setDouble(1,amount);
                debitStatement.setInt(2,this.accountNum);
                creditStatement.setDouble(1,amount);
                creditStatement.setInt(2,receipentsAccountNum);

                int rowsAffectedAfterDebit = debitStatement.executeUpdate();
                if(rowsAffectedAfterDebit > 0){
                    int rowsAffectedAfterCredit = creditStatement.executeUpdate();

                    if(rowsAffectedAfterCredit >0){
                        DbConnection.getConnection().commit();
                        DbConnection.getConnection().setAutoCommit(true);
                        JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Amount transfer successfully");
                        this.amount = this.amount - amount;
                        return true;
                    }

                    else{
                        DbConnection.getConnection().rollback();
                        DbConnection.getConnection().setAutoCommit(true);
                        return false;
                    }
                }
                return false;
            }

            else{
                JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid receipents account number");
                DbConnection.getConnection().setAutoCommit(true);
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean transactionOperationType(String transactionType,String amount){
        boolean transactionStatus = false;
        switch (transactionType){
            case "debit" : transactionStatus =  this.debitAmount(Double.parseDouble(amount));break;
            case "credit": transactionStatus =  this.creditAmount(Double.parseDouble(amount));break;
            default:
                System.out.println("default case");
        }

        return transactionStatus;
    }
}
