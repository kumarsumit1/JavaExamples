package com.java.examples.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicStringOperation {

	public static void main(String[] args) {
		//How size and concatenate is implemented in String
		String str = "helloslkhellodjladfjhello";
		   //for toCharArray() mehtod we Cannot use Arrays.copyOf because of class initialization order issues
		   //  System.arraycopy() is used instead 		
		    int len=siz(str.toCharArray());
		   //once we have the size of charc array ,we put the next string (another set of charc Array) next to it 
		   
		
		//Occurrences of substring in a string
		
		Pattern p = Pattern.compile("hello");
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()){
		    count +=1;
		}
		System.out.println(count);     
		//Another way
		System.out.println(str.split(p.toString(), -1).length-1);
		

	}

	private static int siz(char[] ca) {
		return ca.length;
	}

}
