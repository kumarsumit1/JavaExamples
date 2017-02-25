package com.java.examples.serial.serialization.inheritence;

public class Test {
   
	public static void main(String[] args){
		SuperClass spc=new SuperClass();
		spc.setId(1);
		spc.setValue("OK");
		modifyVal(spc);
		//spc=modifyVal(spc.getId(),spc.getValue());
		System.out.println(spc.getId());
		
	}
   
	private static void modifyVal(SuperClass spc) {
		
		spc.setId(25);
		spc.setValue("Object");
		
	}

	private static SuperClass modifyVal(int id,String val){
		SuperClass spc=new SuperClass();		
		id=20;
		val="test";
		spc.setId(id);
		spc.setValue(val);
		System.out.println("in modifyVal function ::"+spc.getId());
		return spc;
	}
   
}
