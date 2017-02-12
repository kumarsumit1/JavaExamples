package com.java.examples.file.reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class scannerExample {

	public static void main(String[] args) {
		
		  File sqlFile = new File("","");
		  try (Scanner scan = new Scanner(sqlFile).useDelimiter(";")){
			  while(scan.hasNextLine()){
					String query=scan.nextLine().trim().replace(";", "");
					if (!query.trim().isEmpty()) {
						System.out.println(query);
					}
					query.concat("");
					query.length();
			  }
			  
		  }catch (FileNotFoundException e) {				
				e.printStackTrace();
			} 

	}

}
