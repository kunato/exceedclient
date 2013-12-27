package com.kunat.exceedvoteclient.parser;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.kunat.exceedvoteclient.model.CriterionList;
/**
 * CriteriaParser used for parseCriterion from string
 * @author Kunat Pipatanakul
 *
 */
public class CriteriaParser {
	public static CriterionList parseCriterion(String result){
		Serializer serializer = new Persister();
        CriterionList c = null;
		try {
			c = serializer.read(CriterionList.class, result);
		
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
