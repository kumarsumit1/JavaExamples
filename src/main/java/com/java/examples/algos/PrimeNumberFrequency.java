package com.java.examples.algos;

import java.util.*;
import java.util.Map.Entry;


public class PrimeNumberFrequency {

	public static void main(String[] args) {

		Integer[] primlst = { 1,2, 11, 11, 11,12, 18,23, 11, 37, 37, 51, 51, 51, 51, 51 };

		primeFreq(primlst);

	}

	private static Map primeFreq(Integer[] lst) {
		HashMap<Integer, Integer> pFreq = new HashMap<Integer, Integer>();
		for (Integer num : lst) {
			boolean ret=isPrime(num);
			System.out.println("num :"+ num+ " is isprime :"+ret);
			
			if (ret ) {
				if (pFreq.containsKey(num)) {
					int val=pFreq.get(num);
					pFreq.put(num, val+1);
				}else {
					pFreq.put(num, 1);
				}
				
			}
		}
		
		for ( Entry<Integer, Integer> iter:pFreq.entrySet()) {
			System.out.println(iter.getKey()+" : "+ iter.getValue());
		}

		return null;

	}

	private static boolean isPrime(Integer num) {

		if (num > 0 && num <= 2) {
			return true;
		}
        //System.out.println("num sqr is : "+Math.sqrt(num));
		for (int i = 3; i <Math.sqrt(num); i++) {
			int remVal = num % i;
			if (remVal == 0) {
				return false;
			}
		}

		return true;
	}

}
