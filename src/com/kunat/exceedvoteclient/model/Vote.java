package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="vote")
/**
 * Vote using in vote process
 * @author Kunat Pipatanakul
 *
 */
public class Vote{
		@Element(name="contestants")
        public Ballot ballot;
        public Vote(Ballot ballot){
			this.ballot = ballot;
        	
        }
        public String toString() {
                return "";
        }

}