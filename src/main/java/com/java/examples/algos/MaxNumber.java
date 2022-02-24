package com.java.examples.algos;

import java.util.*;


public class MaxNumber {

	
	public static void main(String[] args) {
		
		Integer test=5478;
		
		Integer[] numLst=new Integer[4];
		
		//System.out.println(test/10);
		
		//System.out.println(test%10);
		int i=0;
		while( test>0) {
			
			if (test>10) {
			numLst[i]=test%10;
			test=test/10;
			i++;
			}else {
				numLst[i]=test;
				break;
			}
		}
		
		for (Integer in:numLst) {
			System.out.println("In :: "+in);
		}
		
		//Sort the array
		//Arrays.sort(numLst,Collections.reverseOrder());
		Arrays.sort(numLst);
		int maxNum=0;	
		int idx=0;
		for (Integer in:numLst) {
			System.out.println("srtd :: "+in);
			maxNum=(int) (maxNum+in*Math.pow(10, idx));
			idx++;
		}
       System.out.println(maxNum);
	}
	
	

}
