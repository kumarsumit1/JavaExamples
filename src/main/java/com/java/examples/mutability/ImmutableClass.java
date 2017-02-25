package com.java.examples.mutability;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//Class should be final
public final class ImmutableClass {
	//All var should be final
    private final int id;
	private final String name;
	private final HashMap<String,String> testMap;	
	private final Date date;
	//No setters
	public Date getDate() {
	//	return new Date(date.getTime());
		return date;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	/**
	 * Accessor function for mutable objects
	 */
	public Map<String, String> getTestMap() {
		return testMap;
	//	return (HashMap<String, String>) testMap.clone();
		//return  Collections.unmodifiableMap(testMap);
	}

	/**
	 * Constructor performing Deep Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	
	/*public ImmutableClass(int i, String n, HashMap<String,String> hm,Date dt){
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=i;
		this.name=n;
		this.date=new Date(dt.getTime());
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap=tempMap;
	}*/
	
	//TODO
	//comment the constructor providing deep copy and uncomment the constructor providing shallow copy.
	//Also uncomment the return statement in getTestMap() method that returns the actual object reference and then execute the program once again
	
	/**
	 * Constructor performing Shallow Copy
	 * @param i
	 * @param n
	 * @param hm
	 */

	
	public ImmutableClass(int i, String n, HashMap<String,String> hm,Date dt){
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id=i;
		this.name=n;
		this.testMap=hm;
		this.date=dt;
	}
	
	

}
