package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name="criterion")
public class VoteCriterionHistory {
	@Element(name="id")
	public int id;
}
