package com.java.examples.marker.inter.face;


public class ClassNotImplementingClone  {
  private String Id;

//Modified clone() method in  class
@Override
protected Object clone() throws CloneNotSupportedException {
	ClassNotImplementingClone cloned = (ClassNotImplementingClone)super.clone();
	return cloned;
}

  
  
public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}
}
