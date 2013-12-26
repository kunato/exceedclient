package com.kunat.exceedvoteclient.application;

import android.app.Application;

import com.kunat.exceedvoteclient.activity.LoginActivity;
import com.kunat.exceedvoteclient.activity.MyActivity;
import com.kunat.exceedvoteclient.activity.VoteActivity;
import com.kunat.exceedvoteclient.helper.LoginConnection;
import com.kunat.exceedvoteclient.helper.RequestConnection;
import com.kunat.exceedvoteclient.helper.VoteConnection;
import com.kunat.exceedvoteclient.model.ContestantList;
import com.kunat.exceedvoteclient.model.CriterionList;
import com.kunat.exceedvoteclient.model.MyVote;
import com.kunat.exceedvoteclient.model.User;
import com.kunat.exceedvoteclient.model.Vote;
import com.kunat.exceedvoteclient.parser.ContestantParser;
import com.kunat.exceedvoteclient.parser.CriteriaParser;
import com.kunat.exceedvoteclient.parser.HistoryParser;
import com.kunat.exceedvoteclient.parser.VoteParser;
/**
 * ExceedApp a main controller.
 * @author Kunat Pipatanakul
 *
 */
public class ExceedVoteApp extends Application{
	String host = "http://10.0.2.2:9000/exceedvote/api/v1/";
	//String host = "http://158.108.228.54:8080/exceedvote/api/v1/";
	User user;
	public void hostSet(String host){
		this.host = host;
	}
    public void login(String username,String password,LoginActivity activity){
        user = new User(username,password);
        new LoginConnection(activity).execute(host+"myvote",user.getUsername(),user.getPassword());
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
    public ContestantList getContestantListFromString(String result){
    	return ContestantParser.parseContestant(result);
    }
    public CriterionList getCriterionListFromString(String result){
    	return CriteriaParser.parseCriterion(result);
    }
    public MyVote getMyVoteFromString(String result){
    	return HistoryParser.parseHistory(result);
    }
    public String getStringFromVoteObject(Vote vote){
    	return VoteParser.parseVote(vote);
    }
	

}
