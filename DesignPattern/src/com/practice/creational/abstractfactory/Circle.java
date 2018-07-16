package com.practice.creational.abstractfactory;

public class Circle implements Shape {

	double radius;
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return 3.141*getRadius();
	}

}
