package com.java.examples.algos;

class LongestPalindrom {
	
	public static void main(String[] args) {
		String checkStr="abeb";
		System.out.println(checkPalindrom(checkStr));
	}
	
	private static String checkPalindrom(String str) {
		
		int strLength=str.length();
		int pos=0;
		int maxLenght=1;
		
		for(int i =0;i<strLength;i++) {
			
			for(int j=i;j<strLength;j++) {
				boolean isPalind=true;
				int mid=(j-i+1)/2;
				
//				boolean isEven=true;
//				if ((j-i+1)%2==0) {
//					mid=(j-i+1)/2;
//					isEven=true;
//				}else {
//					mid=(j-i+2)/2;
//					isEven=false;
//				}
				
				//check for palindrome
				for(int k=0;k<mid;k++) {
					if(str.charAt(i+k)!=str.charAt(j-k))
						isPalind=false;
				}
				
				if( isPalind && maxLenght < (j-i+1)) {
					pos=i;
					maxLenght=j-i+1;
					System.out.println("the pos is "+pos);
					System.out.println("maxlen ::: "+maxLenght);
//					if(isEven) {
//						maxLenght=j-i+1;
//						System.out.println(isEven+" ::: "+ (j-i+1));
//						
//					}else {
//						maxLenght=j-i+1;
//						System.out.println(isEven+" ::: "+ (j-i+1));
//					}
				}
				
			}
			
		}
		
		String palins=palindromeStr(str,pos,maxLenght);
		
		
		return palins;
	}

	private static String palindromeStr(String str, int pos, int maxLenght) {
		
		String temp ="";
		for(int i=pos;i<pos+maxLenght;i++) {
			System.out.print(str.charAt(i));
			temp=temp+str.charAt(i);
		}
        System.out.println();
		return temp;
	}
	
}