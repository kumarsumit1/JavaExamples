package com.java.examples.design.pattern.creation.abstarct.factory;

import com.java.examples.design.pattern.creational.factory.CarType;





public class CarFactory
{
private CarFactory() {
	//Prevent instantiation
}

public static Car buildCar(CarType type)
{
	Car car = null;
	Location location = Location.USA; //Read location property somewhere from configuration
	//Use location specific car factory
	switch(location)
	{
		case USA:
		car = USACarFactory.buildCar(type);
		break;
		case ASIA:
		car = AsiaCarFactory.buildCar(type);
		break;
		default:
		car = DefaultCarFactory.buildCar(type);
	}
return car;
}
}
