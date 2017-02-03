package com.java.examples.clone;

public class CopyConstructorTest
{
	public static void main(String[] args)
	{
		PointOne one = new PointOne(1,2);
		PointTwo two = new PointTwo(3,4,5);
		PointOne thre=new PointTwo(6,7,8);
		one.test();
		two.test();
		thre.test();

		PointOne clone1 = new PointOne(one);
		PointOne clone2 = new PointOne(two);
        
		//Let check for class types
		System.out.println(clone1.getClass());
		System.out.println(clone2.getClass());
		System.out.println(clone1);
		System.out.println(clone2);
		System.out.println(two.getZ());
	}
}
