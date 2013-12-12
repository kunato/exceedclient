package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="contestant")
/**
 * VoteContestantHistory using in history activity.
 * @author Kunat Pipatanakul
 */
public class VoteContestantHistory {
	@Element(name="id")
	public int id;
	@Element(name="score")
	public int score;
	@Element(name="name")
	public String name;
	
}
