package com.practice.structural.flyweight;

public class Rectangle implements Shape {

	double length;
	double breadth;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	@Override
	public double calculateArea() {

		return getLength() * getBreadth();
	}

}
