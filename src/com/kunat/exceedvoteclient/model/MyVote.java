package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="myvote")
public class MyVote{
		@Element(name="votes")
        public BallotHistory ballot;
        public String toString() {
                return "";
        }

}