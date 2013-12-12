package com.kunat.exceedvoteclient.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="contestants")
public class Ballot{
	@ElementList(name="contestant",inline=true)
	List<ScoreCard> scoreCards = new ArrayList<ScoreCard>();
	public Ballot(){
		
	}
	public void addScoreCard(ScoreCard sc){
		scoreCards.add(sc);
	}
	public List<ScoreCard> getScoreCards(){
		return scoreCards;
	}
}