package com.java.examples.design.pattern.creation.abstarct.factory;

import com.java.examples.design.pattern.creational.factory.CarType;



public class SedanCar extends Car {

	public SedanCar( Location location) {
		super(CarType.SEDAN, location);
		construct();
	}

	@Override
	protected void construct() {
		System.out.println("Building Sedan Car");

	}

}
