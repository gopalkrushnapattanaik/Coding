package com.practice.creational.abstractfactory;

public class CircleFactory implements ShapeAbstractFactory {
	
	private double radius;
	
	public CircleFactory(double radius) {
		this.radius=radius;
	}

	@Override
	public Shape getShape() {
		Circle circle= new Circle();
		circle.setRadius(radius);
		return circle;
	}

}
