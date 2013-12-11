package com.kunat.exceedvoteclient.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
@Root(name="contestants")
public class CriterionList {
	@ElementList(name="contestant",inline=true)
	private List<Criterion> c_list;

	public List<Criterion> getCriterions() {
		return c_list;
	}

	public void setCriterions(List<Criterion> c_list) {
		this.c_list = c_list;
	} 
}