package com.queries;

public interface LoginQueries {

    public final String CHECK_USERNAME_FOR_LOGIN_QUERY = "SELECT username,password from users where username = ?";
}
