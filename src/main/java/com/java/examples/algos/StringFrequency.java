package com.java.examples.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class StringFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testStr = "TestStrSTR";

		char[] charArr = new char[testStr.length()];
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (int i = 0; i < testStr.length(); i++) {
			charArr[i] = testStr.charAt(i);
		}

		// charArr = testStr.toCharArray();

		for (char i : charArr) {
			System.out.println(i);
			if (charMap.containsKey(i)) {
				int val = charMap.get(i);
				charMap.put(i, ++val);  //notice the pre-increment
			} else {
				charMap.put(i, 1);
			}
		}

		System.out.println(charArr);
		
		for ( Entry<Character, Integer> charVar:charMap.entrySet()) {
			System.out.println(charVar.getKey()+" count is :: "+charVar.getValue());

		}
		
		//sort the hashmap on keys, way 1:
		Map<Character,Integer> sortedMap=new TreeMap<Character, Integer>(charMap);
		
		for (Entry<Character,Integer> sortedChar:sortedMap.entrySet()) {
			System.out.println(sortedChar.getKey()+" counter is "+sortedChar.getValue());
		}
		
		//sort the hashmap , way 2:
		 Set<Character> keyst = charMap.keySet();
		 List<Character> keylst = new ArrayList<Character>();
		 for ( Character cr: keyst) {
			keylst.add(cr); 
		 }
		 
		 //Collections.sort(keylst);
		 Collections.reverse(keylst);
		 
		 for( Character keys:keylst) {
			 System.out.println(keys+" the val is "+charMap.get(keys));
		 }
		 

	}

}
