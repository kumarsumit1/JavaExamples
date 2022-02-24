package com.java.examples.algos;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fib=genFibonacci(9);
		for( int item:fib) {
			System.out.println(item);
		}

	}

	private static int[] genFibonacci(int num) {
		
		int[] fib=new int[num];
		
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<num;i++) {
			fib[i]=fib[i-1]+fib[i-2];
		}
		
		return fib;
	}

}
