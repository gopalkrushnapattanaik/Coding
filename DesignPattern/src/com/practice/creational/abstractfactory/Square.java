package com.practice.creational.abstractfactory;

public class Square implements Shape {

	double length;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double calculateArea() {

		return getLength() * getLength();
	}

}
