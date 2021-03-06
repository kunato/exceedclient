package com.kunat.exceedvoteclient.helper;

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
import com.kunat.exceedvoteclient.activity.LoginActivity;

import android.app.ProgressDialog;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
/**
 * Background task for Login to server.
 * @author Kunat Pipatanakul
 *
 */
public class LoginConnection extends AsyncTask<String,Void,String>{
	private LoginActivity rootActivity;
	private ProgressDialog pd; 
	public LoginConnection(LoginActivity rootActivity){
		this.rootActivity = rootActivity;
		
	}
	protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(rootActivity);
        pd.setIndeterminate(true);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Working");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        pd.show();

	}
	@Override
	protected String doInBackground(String... params) {
		if(params.length > 0){
	        String url = params[0];
	        String username = params[1];
	        String password = params[2];

	        try
	        {	
	        	
	            AndroidHttpClient httpClient = AndroidHttpClient.newInstance("ExceedVote connection");

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
	            Log.d("TAG", status.getStatusCode()+"");
	            if(status.getStatusCode() != 200){
	            	Log.d("ERROR",EntityUtils.toString(response.getEntity()));
	            	return "error";
	            }
	            HttpEntity entity = response.getEntity();
	            String s_response = EntityUtils.toString(entity);
	            httpClient.close();
	            return s_response;
	        }
	        catch(Exception e){
	        	Log.d("TAG",e.getMessage());
	            return "error";
	        }

	    }
	    return "error";
	}
	
	protected void onPostExecute(String result) {
		if(pd!=null){
			pd.dismiss();
		}
		rootActivity.changeActivity(result);
    }

}
