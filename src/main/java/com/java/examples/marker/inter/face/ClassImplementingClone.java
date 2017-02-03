package com.java.examples.marker.inter.face;


public class ClassImplementingClone implements Cloneable {
  private String Id;

//Modified clone() method in  class
@Override
protected Object clone() throws CloneNotSupportedException {
	ClassImplementingClone cloned = (ClassImplementingClone)super.clone();
	System.out.println("ClassImplementingClone works");
	return cloned;
}

  
  
public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}
}
