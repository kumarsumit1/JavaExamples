package com.java.examples.collection.set;

public class Dog implements Comparable<Dog>{

	int size;
	 
	public Dog(int s) {
		size = s;
	}
 
	public String toString() {
		return size + "";
	}
 
	// TODO @Override
	public int compareTo(Dog o) {
	        return size - o.size;
	}
}
