package com.java.examples.design.pattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;



public class SerializationTest {
static DemoSingletonTest instanceOne = DemoSingletonTest.getInstance();

public static void main(String[] args) {
	try {
		// Serialize to a file
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
				"filename.ser"));
		out.writeObject(instanceOne);
		out.close();

		instanceOne.setI(20);
      DemoSingletonTest inst=DemoSingletonTest.getInstance();
      System.out.println(inst.getI());
		// Serialize to a file
		ObjectInput in = new ObjectInputStream(new FileInputStream(
				"filename.ser"));
		DemoSingletonTest instanceTwo = (DemoSingletonTest) in.readObject();
		in.close();

		System.out.println(instanceOne.getI());
		System.out.println(instanceTwo.getI());

	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
