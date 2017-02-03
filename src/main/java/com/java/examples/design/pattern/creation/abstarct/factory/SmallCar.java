package com.java.examples.design.pattern.creation.abstarct.factory;

import com.java.examples.design.pattern.creational.factory.CarType;



public class SmallCar extends Car {

	public SmallCar(Location location) {
		super(CarType.SMALL, location);
		construct();
	}
	

	@Override
	protected void construct() {
		System.out.println("Building Small car");

	}

	
}
