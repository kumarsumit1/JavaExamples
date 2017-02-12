package com.java.examples.collections.hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

public class SortByKeyExample1 {

    public static void main(String[] args) {

        Map<String, String> unsortMap = new HashMap<String, String>();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......By Key");
        Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
        printMap(treeMap);
        
        //Using comparator
        
     

	    //For Java 8, try this lambda
		Map<Integer, String> treeMapC = new TreeMap<Integer, String>((Comparator<? super Integer>) (o1, o2) -> o2.compareTo(o1));
		//TODO Fix this
		//treeMapC.putAll(unsortMap);

        printMap(treeMap);
   // Java 8 stream API
        Map<String, String> result = new LinkedHashMap<>();

        //sort by key, a,b,c..., and put it into the "result" map 
       //   Stream<Entry<String, String>> sortedMap = unsortMap.entrySet().stream()
      //  		                                    .sorted(Map.Entry.<String, Integer>comparingByKey())
       // 		                                    .forEachOrdered(x->result.put(x.getKey() , x.getValue()));
    }

    //pretty print a map
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
				+ " Value : " + entry.getValue());
        }
    }

}