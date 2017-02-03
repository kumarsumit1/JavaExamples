package com.java.examples.clone;

	

public class PointOne {
	private Integer x;
	private Integer y;

  void test(){
	   System.out.println("hi in one");
	
   }
  PointOne(int x,int y){
	  this.x = x;
		this.y =y;
  }
	
	public PointOne(PointOne point){
		this.x = point.x;
		this.y = point.y;
	}

	@Override
	public String toString() {
		return "PointOne [x=" + x + ", y=" + y + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public PointOne copyPoint(PointOne point) throws CloneNotSupportedException
	{
		if(!(point instanceof Cloneable))
		{
			throw new CloneNotSupportedException("Invalid cloning");
		}
		//Can do multiple other things here
		return new PointOne(point.x, point.y);
	}
	
	
}
