	

package com.java.examples.design.pattern.creational.factory;

public class SmallCar extends Car {

	SmallCar() {
		super(CarType.SMALL);
		construct();
	}

	@Override
	protected void construct() {
		System.out.println("Building small car");
		// add accessories
	}
}
