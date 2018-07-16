package com.practice.creational.abstractfactory;

public class SquareFactory implements ShapeAbstractFactory {

	private double length;
	
	public SquareFactory(double length) {
		this.length=length;
	}
	@Override
	public Shape getShape() {
		Square sq= new Square();
		sq.setLength(length);
		return sq;
	}

}
