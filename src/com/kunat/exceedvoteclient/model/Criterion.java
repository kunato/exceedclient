package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="criterion")
public class Criterion{
	@Element(name="id")
    public Long id;
	@Element(name="name")
    public String name;
    //@Element(name="type")
    //public int type;
    
   
    
    public Criterion() {
            
    }
    
    public Criterion(String name) {
            this.name = name;
    }
    
    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    
   

    public String toString() {
            return "";
    }
    
}