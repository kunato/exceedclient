package com.kunat.exceedvoteclient.model;

import java.util.List;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
@Root(name="contestants")
/**
 * List of Contestant using in VoteActivity. 
 * @author Kunat Pipatanakul
 *
 */
public class ContestantList {
	@ElementList(name="contestant",inline=true)
	private List<Contestant> c_list;

	public List<Contestant> getContestantList() {
		return c_list;
	}

	public void setContestantList(List<Contestant> c_list) {
		this.c_list = c_list;
	} 
}
