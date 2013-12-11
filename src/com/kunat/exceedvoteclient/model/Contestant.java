package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="contestantList")
public class Contestant {
	@Element(name="contestantID")
	public long id;
	@Element(name="name")
	public String name;
	@Element(name="description")
	public String description;
	
}
