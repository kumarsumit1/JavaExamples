package com.java.examples.design.pattern.creation.abstarct.factory;

import com.java.examples.design.pattern.creational.factory.CarType;



public class TestFactoryPattern
{
	public static void main(String[] args)
	{
		System.out.println(CarFactory.buildCar(CarType.SMALL));
		System.out.println(CarFactory.buildCar(CarType.SEDAN));
		System.out.println(CarFactory.buildCar(CarType.LUXURY));
	}
}
