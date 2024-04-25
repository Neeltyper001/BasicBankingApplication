package com.queries;

public interface RegisterQueries {

    public final String CHECK_USERNAME_FOR_REGISTER_QUERY = "SELECT username,account_no from users WHERE username = ?";
    public final String CHECK_ACCOUNT_NO_FOR_REGISTER_QUERY = "SELECT username,account_no from users WHERE account_no = ?";
    public final String REGISTER_USER_QUERY = "INSERT into users (fullname,username,password,account_no) VALUES (?,?,?,?)";
    public final String REGISTER_ACCOUNT_QUERY = "INSERT INTO accounts (account_no,account_balance,security_pin) VALUES (?,?,?)";
}
