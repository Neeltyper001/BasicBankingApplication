package com.queries;

public interface LoginQueries {

    public final String CHECK_USERNAME_FOR_LOGIN_QUERY = "SELECT username,password,account_no from users where username = ?";
    public final String GET_USER_ACCOUNT_AMOUNT = "SELECT account_balance from accounts where account_no = ?";
}
