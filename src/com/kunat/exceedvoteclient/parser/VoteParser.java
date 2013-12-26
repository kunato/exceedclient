package com.kunat.exceedvoteclient.parser;

import java.io.IOException;
import java.io.OutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.util.Log;

import com.kunat.exceedvoteclient.model.Vote;

public class VoteParser {

	public static String parseVote(Vote vote) {
		Serializer serializer = new Persister();
		String result = "";
		OutputStream output = new OutputStream()
	    {
	        private StringBuilder string = new StringBuilder();
	        @Override
	        public void write(int b) throws IOException {
	            this.string.append((char) b );
	        }

	        
	        public String toString(){
	            return this.string.toString();
	        }
	    };
		try {
			
			serializer.write(vote, output);
			result = output.toString();
			Log.d("Vote",result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
