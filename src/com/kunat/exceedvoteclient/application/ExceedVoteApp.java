package com.kunat.exceedvoteclient.application;

import android.app.Application;

import com.kunat.exceedvoteclient.activity.LoginActivity;
import com.kunat.exceedvoteclient.activity.MyActivity;
import com.kunat.exceedvoteclient.activity.VoteActivity;
import com.kunat.exceedvoteclient.helper.LoginConnection;
import com.kunat.exceedvoteclient.helper.RequestConnection;
import com.kunat.exceedvoteclient.helper.VoteConnection;
import com.kunat.exceedvoteclient.model.User;

public class ExceedVoteApp extends Application{
	String host = "http://10.0.2.2:9000/exceedvote/api/v1/";
	User user;
	public void hostSet(String host){
		this.host = host;
	}
    public void login(String username,String password,LoginActivity activity){
        user = new User(username,password);
        new LoginConnection(activity).execute("http://10.0.2.2:9000/"+"authorized",user.getUsername(),user.getPassword());
    }
    public User getUser(){
    	return user;
    }
    public void request(String url,MyActivity activity){
    	new RequestConnection(activity).execute(host+url,user.getUsername(),user.getPassword());
    }
    public void vote(String url,VoteActivity activity,String data){
    	new VoteConnection(activity).execute(host+"criterion/"+url,user.getUsername(),user.getPassword(),data);
    }
	

}
