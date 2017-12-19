package com.java.examples.string;

import java.util.Objects;

public class StringLiterals {
	
	
	public static void main (String[] args){
		String s1="one";
		String str2=new String("one");
		String s3=s1;
		String s4="one";
		//The process of adding string to String Constant Pool is called string interning.
		//by default string literals are added to string constant Pool
		//However one can add new String instances by calling intern() function.
		String str5=new String("one").intern();
		
		//comparing string literal
		if (s1==s4)
		    System.out.println("s1==s4");  		    
		else
		    System.out.println("s1!=s4");

		//comparing string literal and instance of string
		if (s1==str2)
		    System.out.println("s1==str2");           
		else
		    System.out.println("s1!=str2");

		//comparing string literal with assignment operator
		if (s1==s3)
		    System.out.println("s1==s3");         
		else
		    System.out.println("s1!=s3");

		
		//comparing string literal and string intern
		if (s1==str5)
		    System.out.println("s1==str5");           
		else
		    System.out.println("s1!=str5");
		
		//Exception scenario 
		String nullString1 = null;
		String nullString2 = null;

		// Evaluates to true
		if(	nullString1 == nullString2)
			System.out.println("Equality works for null strings");
		else
			System.out.println("Equality doesn't work for null strings");;

		//For null check comparison use Objects.equals
		System.out.println("Null check comparision :: "+ Objects.equals(nullString1, nullString2));	
		//Equality comparison does not have null check
		// Throws an Exception
	//	nullString1.equals(nullString2);
		
	}
}