package com.kunat.exceedvoteclient.model;

/**
 * Created with IntelliJ IDEA.
 * User: kunato
 * Date: 12/3/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
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
