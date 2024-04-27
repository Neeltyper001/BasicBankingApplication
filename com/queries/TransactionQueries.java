package com.queries;

public interface TransactionQueries {

    public final String DEBIT_QUERY = "UPDATE accounts SET account_balance = account_balance - ? where account_no = ?";
    public final String CREDIT_QUERY = "UPDATE accounts SET account_balance = account_balance + ? where account_no = ?";
    public final String CHECK_PIN_QUERY = "SELECT security_pin from accounts where account_no = ?";
    public final String CHECK_USER_ACCOUNT_NO = "SELECT account_no from accounts where account_no = ?";
}
