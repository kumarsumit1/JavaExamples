package com.java.examples.sop;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class SystemOutPrintln {

	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new FileOutputStream("log.txt")));
			System.out.println("Now the output is redirected!");
			
			
			Object ne=new Object();
		} catch(Exception e) {}

	}

}
