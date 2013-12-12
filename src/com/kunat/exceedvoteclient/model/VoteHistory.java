package com.kunat.exceedvoteclient.model;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="vote")
/**
 * VoteHistory is xml object using in history activity.
 * @author Kunat Pipatanakul
 *
 */
public class VoteHistory {
	@Element(name="criterion")
	public VoteCriterionHistory voteCriterionHistory;
	@Element(name="contestant")
	public VoteContestantHistory voteContestantHistory;
	//@ElementList(name="contestant",inline=true)
	//public List<VoteContestantHistory> voteContestantHistory;
}
