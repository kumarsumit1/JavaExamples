package com.java.examples.design.pattern.creation.abstarct.factory;

import com.java.examples.design.pattern.creational.factory.CarType;



public class LuxuryCar extends Car
{
	public LuxuryCar(Location location)
	{
		super(CarType.LUXURY, location);
		construct();
	}

	@Override
	protected void construct() {
		System.out.println("Building luxury car");
		//add accessories
	}
}

