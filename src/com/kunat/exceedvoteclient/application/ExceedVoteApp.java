package com.kunat.exceedvoteclient.application;

import android.app.Application;

import com.kunat.exceedvoteclient.activity.LoginActivity;
import com.kunat.exceedvoteclient.activity.MyActivity;
import com.kunat.exceedvoteclient.helper.LoginConnection;
import com.kunat.exceedvoteclient.helper.RequestConnection;
import com.kunat.exceedvoteclient.model.User;

public class ExceedVoteApp extends Application{
	
	User user;
    public void login(String username,String password,LoginActivity activity){
        user = new User(username,password);
        new LoginConnection(activity).execute("http://se.cpe.ku.ac.th:8000/",user.getUsername(),user.getPassword());
    }
    public User getUser(){
    	return user;
    }
    public void request(String url,MyActivity activity){
    	new RequestConnection(activity).execute("http://se.cpe.ku.ac.th:8000/"+url,user.getUsername(),user.getPassword());
    }

	

}
