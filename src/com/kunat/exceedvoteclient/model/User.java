package com.kunat.exceedvoteclient.model;

/**
 * User object use for saving authentication.
 * @author Kunat Pipatanakul
 */
public class User {
    String username;
    String password;
    public User(String username, String password){

        this.username = username;
        this.password = password;
    }
    public String getUsername(){
    	return username;
    }
    public String getPassword(){
    	return password;
    }
}
