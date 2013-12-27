package com.kunat.exceedvoteclient.parser;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.util.Log;

import com.kunat.exceedvoteclient.model.MyVote;
/**
 * HistoryParser used for parseHistory from string
 * @author Kunat Pipatanakul
 *
 */
public class HistoryParser {

	public static MyVote parseHistory(String result) {
		MyVote c = null;
		Serializer serializer = new Persister();
		try {
			c = serializer.read(MyVote.class, result);
		} catch (Exception e) {
			Log.d("ERROR",e.getMessage());
			e.printStackTrace();
		}
		return c;
	}

}
