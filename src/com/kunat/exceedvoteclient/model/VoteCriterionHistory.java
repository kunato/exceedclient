package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name="criterion")
/**
 * VoteCriterionHistory is a xml object using in history activity.
 * @author Kunat Pipatanakul
 *  
 */
public class VoteCriterionHistory {
	@Element(name="id")
	public int id;
	@Element(name="name")
	public String name;
}
