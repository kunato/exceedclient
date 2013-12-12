package com.kunat.exceedvoteclient.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="criterion")
/**
 * Criterion using in MainActivity.
 * @author Kunat Pipatanakul
 *
 */
public class Criterion{
	@Element(name="id")
    public int id;
	@Element(name="name")
    public String name;
    @Element(name="type")
    public int type;
    
   
    
    public Criterion() {
            
    }
    
    public Criterion(String name) {
            this.name = name;
    }
    
    public int getId() {
            return id;
    }

    public void setId(int id) {
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