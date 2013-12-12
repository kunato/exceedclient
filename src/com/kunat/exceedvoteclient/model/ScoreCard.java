package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="contestant")
public class ScoreCard {
	@Element(name="id")
	public int id;
	@Element(name="score")
	public int score;
	public ScoreCard(int id , int score){
		this.id = id;
		this.score = score;
		
	}
}
