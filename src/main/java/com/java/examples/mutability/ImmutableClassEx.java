package com.java.examples.mutability;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    To create immutable class in java, you have to do following steps.

    Declare the class as final so it can’t be extended.
    Make all fields private so that direct access is not allowed.
    Don’t provide setter methods for variables
  -->  Make all mutable fields final so that it’s value can be assigned only once.
  -->  Initialize all the fields via a constructor performing deep copy. Or for date instantiate a new date object
    Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference. Or for date return 
    a new object .
    
-->    Collections.unmodifiableMap(testMap) also can be used instead of cloning but in this case if we try to change any element it throws an error.
    Hence exception handling should be taken care of .
 */

public final class ImmutableClassEx {
	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int id=10;
		Date dt=new Date();
		//Make sure the Immutable class is final
		ImmutableClass ce = new ImmutableClass(id,s,h1,dt);
		
		//Lets see whether its copy by field or reference
		System.out.println(s==ce.getName());
		System.out.println(h1 == ce.getTestMap());
		System.out.println(dt==ce.getDate());
		//print the ce values
		System.out.println("ce id:"+ce.getId());
		System.out.println("ce name:"+ce.getName());
		System.out.println("ce testMap:"+ce.getTestMap());
		System.out.println("the date is : "+ce.getDate());
		//change the local variable values
		//If you do shallow copying in the constructor then all these values will be modified
		id=20;
		s="modified";
		h1.put("3", "third");
		dt.setYear(2012);
		//print the values again
		System.out.println("ce id after local variable change:"+ce.getId());
		System.out.println("ce name after local variable change:"+ce.getName());
		System.out.println("ce testMap after local variable change:"+ce.getTestMap());
		System.out.println(" The date after local variable change :"+ce.getDate());
		//The hashmap will change if we have not returned the cloned value or the new instance of Date object
		Map<String, String> hmTest = ce.getTestMap();
		hmTest.put("4", "new");		
		System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());
		
		Date fetchedDt=ce.getDate();
		fetchedDt.setYear(2010);
		System.out.println(" the changed date is :"+ce.getDate());
		
		//Test for Why Immutable class should be final
		//if you don't make it final, then it is possible for someone to extend a class and create a subclass that 
		//is mutable (either by adding new mutable fields, or overriding methods in a way that enables you to mutate
		//protected fields of the original immutable class). 
		//This is also the reason why String and other such immutable class are final .This can cause a 
		//grave security flaw.
		
		Mutable obj = new Mutable(4);
        Immutable immObj = (Immutable)obj;              
        System.out.println(immObj.getValue());
        obj.setValue(8);
        System.out.println(immObj.getValue());
	}

}
