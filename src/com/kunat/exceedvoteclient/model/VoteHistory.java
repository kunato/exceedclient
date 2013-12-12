package com.kunat.exceedvoteclient.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="vote")
public class VoteHistory {
	@Element(name="criterion")
	public VoteCriterionHistory voteCriterionHistory;
	@Element(name="contestant")
	public VoteContestantHistory voteContestantHistory;
	//@ElementList(name="contestant",inline=true)
	//public List<VoteContestantHistory> voteContestantHistory;
}
