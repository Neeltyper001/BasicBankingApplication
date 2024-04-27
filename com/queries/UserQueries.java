package com.queries;

public interface UserQueries {

    public final String UPDATE_USER_PASSWORD = "UPDATE users SET password = ? where username = ?";
    public final String UPDATE_USER_PIN = "UPDATE accounts SET security_pin = ? where account_no = ?";
}
