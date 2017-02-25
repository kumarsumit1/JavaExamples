package com.java.examples.inheritence;

public class TestInheritence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// private methods never use runtime polymorphism.

		Base base = new Base();
		base.callBoth();

		Sub sub = new Sub();
		sub.foo();

		Base Subbase = new Sub();
		Subbase.callBoth();

		//Overriden variable is not possible in java however it can be made to 'hide'. http://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.4.8
		//So the thumb rule is variables from left while method from the right .		
		System.out.println("the value of base is :"+base.baseVar2 + " and ");	base.bar();		
		
		System.out.println("the value of sub is :"+sub.baseVar2 + " and ");	sub.bar()	;
		
		//Notice the difference here while the variable will be used of Base the method will print the value of Sub
		System.out.println("the value of Subbase is :"+Subbase.baseVar2+ " and ");Subbase.bar();
		
		
		
		//sub class is instance of both sub and base class both
		//while base class is instance of base class only.
		
		System.out.println("The object base is instance of Base : "	+ (base instanceof Base));

		System.out.println("The object base is instance of Sub " + (base instanceof Sub));

		System.out.println("The object sub is instance of Base " + (sub instanceof Base));

		System.out.println("The object sub is instance of Sub "+ (sub instanceof Sub));

		System.out.println("The object Subbase is instance of Base "+ (Subbase instanceof Base));

		System.out.println("The object Subbase is instance of Sub "	+ (Subbase instanceof Sub));
		
		//This is important , since no object has been instantiated hence it will give false
		Sub sub2=null;
		System.out.println("The object sub2 is instance of Sub "	+ (sub2 instanceof Sub));

		//Down casting of ojbects
		
		//Sub downSub=new Base(); --> This is not allowed and will throw compilation error
		
		Sub downSub=(Sub) new Base(); //This is allowed but will throw ClassCastException run time !
		
	}

}
