package com.java.examples.collections.hash;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Dogs {
	String color;
 
	Dogs(String c) {
		color = c;
	}
 
	public boolean equals(Object o) {
		return ((Dogs) o).color == this.color;
	}
 
	public int hashCode() {
		return color.length();
	}
 
	public String toString(){	
		return color + " dog";
	}
}
 
public class TestLinkedHashMap {
	public static void main(String[] args) {
 
		Dogs d1 = new Dogs("red");
		Dogs d2 = new Dogs("black");
		Dogs d3 = new Dogs("white");
		Dogs d4 = new Dogs("white");
 
		LinkedHashMap<Dogs, Integer> linkedHashMap = new LinkedHashMap<Dogs, Integer>();
		linkedHashMap.put(d4, 20);
		linkedHashMap.put(d1, 10);
		linkedHashMap.put(d2, 15);
		linkedHashMap.put(d3, 5);
		linkedHashMap.put(d4, 20);
 
		for (Entry<Dogs, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}		
	}
}