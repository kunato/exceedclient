package com.kunat.exceedvoteclient.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="votes")
/**
 * BallotHistory model for xml using in History.
 * @author Kunat Pipatanakul
 *
 */
public class BallotHistory{
	@ElementList(name="vote",inline=true)
	List<VoteHistory> scoreCards = new ArrayList<VoteHistory>();
	public BallotHistory(){
		
	}
	public List<VoteHistory> voteHistories(){
		return scoreCards;
	}
}