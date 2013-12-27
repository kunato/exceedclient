package com.kunat.exceedvoteclient.parser;


import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.util.Log;

import com.kunat.exceedvoteclient.model.ContestantList;
/**
 * ContestantParser used for parseContestant from string
 * @author Kunat Pipatanakul
 *
 */
public class ContestantParser {
	public static ContestantList parseContestant(String result){
		Serializer serializer = new Persister();
        ContestantList c = null;
		try {
			c = serializer.read(ContestantList.class, result);
		
        
		} catch (Exception e) {
			Log.d("ERROR",e.getMessage());
			e.printStackTrace();
		}
		return c;
	}
}
