package com.queries;

public interface RegisterQueries {

    public final String CHECK_USERNAME_QUERY = "SELECT username,account_no from users where username = ?";
    public final String REGISTER_USER_QUERY = "INSERT into users (fullname,username,password,account_no) VALUES (?,?,?,?)";
}
