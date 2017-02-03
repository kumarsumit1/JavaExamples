package com.java.examples.collections.hash;

import java.util.HashMap;
import java.util.Map.Entry;

/* Q : Sort a Map<Key, Value> on the values ?
 
Java 8 offers a new answer: convert the entries into a stream, and use the comparator combinators from Map.Entry:

Stream<Map.Entry<K,V>> sorted =
    map.entrySet().stream()
       .sorted(Map.Entry.comparingByValue());

This will let you consume the entries sorted in ascending order of value. If you want descending value, simply reverse the comparator:

Stream<Map.Entry<K,V>> sorted =
    map.entrySet().stream()
       .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));

If the values are not comparable, you can pass an explicit comparator:

Stream<Map.Entry<K,V>> sorted =
    map.entrySet().stream()
       .sorted(Map.Entry.comparingByValue(comparator));

You can then proceed to use other stream operations to consume the data. For example, if you want the top 10 in a new map:

Map<K,V> topTen =
    map.entrySet().stream()
       .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
       .limit(10)
       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));




 */


class Dog {
	String color;
 
	Dog(String c) {
		color = c;
	}
	public String toString(){	
		return color + " dog";
	}
	public int hashCode() {
		return color.length();
	}
	
	public boolean equals(Object o) {
		return ((Dog) o).color == this.color;
	}
}
 
public class TestHashMap {
	public static void main(String[] args) {
		HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");
 
		hashMap.put(d1, 10);
		hashMap.put(d2, 15);
		hashMap.put(d3, 5);
		hashMap.put(d4, 20);
 
		//print size
		System.out.println(hashMap.size());
 
		//loop HashMap
		for (Entry<Dog,Integer> entry :hashMap.entrySet()) {
			System.out.println(entry.getKey().toString() + " - " + entry.getValue());
		}
	}
}