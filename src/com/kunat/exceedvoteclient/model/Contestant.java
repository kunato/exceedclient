package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="contestant")
/**
 * Contestant model for xml convert using in VoteActivity 
 * @author Kunat Pipatanakul
 *
 */
public class Contestant {
	@Element(name="id")
	public int id;
	@Element(name="name")
	public String name;
	@Element(name="description")
	public String description;
	
}
