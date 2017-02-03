package com.java.examples.inheritence;

public class TestInheritence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//private methods never use runtime polymorphism.
		Base base=new Sub();
		 base.callBoth();
		 
		 Sub sub=new Sub();
		 sub.callBoth();

	}

}
