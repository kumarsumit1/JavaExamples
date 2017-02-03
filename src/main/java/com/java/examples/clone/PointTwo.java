package com.java.examples.clone;

	

public class PointTwo extends PointOne{
	private Integer z;

	public PointTwo(PointTwo point){
		super(point); //Call Super class constructor here
		this.z = point.z;
	}

	public PointTwo(int i, int j, int k) {
		super(i,j);
		this.z = k;
	}

	 void test(){
		   System.out.println("hi in two");
	   }
	@Override
	public String toString() {
		return "PointTwo [z=" + z + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public Integer getZ() {
		return z;
	}

	public void setZ(Integer z) {
		this.z = z;
	}
	
}
