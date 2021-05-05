package com.java.examples.exception;



public class TryCatch {
	
	
	public static void main( String[] args){
		
		String i=tryCatch();
		System.out.println("--------------"+i+"-----------------");
		
	}

	private static String tryCatch() {
		String str="str";
		String strarr[]={"one","two","three"};
		try{
			System.out.println(strarr[7]);
		//	System.out.println(str);
			return "try";
		} catch( Exception ex) {
			ex.printStackTrace();
			System.out.println("catch");
			return "catch";
		}finally{
			System.out.println("finally");
			return "finally";
		}
		
		//return "last";
	}
}
//Condition 1 . Only one return statement is allowed within try block and in the main block i.e if return is in try block then return in main block will not be allowed.
//               Will throw code unreachable error
//Condition 2 . return in both try and finally is allowed but with a warning and the return of finally will get called before exiting the program.
//Condition 3 . if return is in try,catch,finally then the return of finally will get called before exiting.