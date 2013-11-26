package com.kunat.exceedvoteclient;

import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class RequestConnection extends AsyncTask<String,Void,String>{
	private MyActivity rootActivity; 
	public RequestConnection(MyActivity rootActivity){
		this.rootActivity = rootActivity;
		
	}
	@Override
	protected String doInBackground(String... params) {
		if(params.length > 0){
	        String url = params[0];
	        String username = params[1];
	        String password = params[2];

	        try
	        {
	            AndroidHttpClient httpClient = AndroidHttpClient.newInstance("test user agent");

	            URL urlObj = new URL(url);
	            HttpHost host = new HttpHost(urlObj.getHost(), urlObj.getPort(), urlObj.getProtocol());
	            AuthScope scope = new AuthScope(urlObj.getHost(), urlObj.getPort());
	            UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);

	            CredentialsProvider cp = new BasicCredentialsProvider();
	            cp.setCredentials(scope, creds);
	            HttpContext credContext = new BasicHttpContext();
	            credContext.setAttribute(ClientContext.CREDS_PROVIDER, cp);

	            HttpGet job = new HttpGet(url);
	            HttpResponse response = httpClient.execute(host,job,credContext);
	            StatusLine status = response.getStatusLine();
	            HttpEntity entity = response.getEntity();
	            String s_response = EntityUtils.toString(entity);
	            Log.d("tag", s_response);
	            httpClient.close();
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }

	    }
	    return "OK";
	}
	
	protected void onPostExecute(String result) {
        rootActivity.changeActivity();
    }

}
