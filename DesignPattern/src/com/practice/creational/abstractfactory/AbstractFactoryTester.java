package com.practice.creational.abstractfactory;

public class AbstractFactoryTester {

	public static void main(String[] args) {

		Circle circle = (Circle) ShapeFactory.getShape(new CircleFactory(2));
		Square square = (Square) ShapeFactory.getShape(new SquareFactory(5));
		Rectangle rectangle = (Rectangle) ShapeFactory.getShape(new RectangleFactory(2, 3));

		System.out.println("circle radius" + circle.getRadius() + " area : " + circle.calculateArea());
		System.out.println("Square length" + square.getLength() + " area : " + square.calculateArea());
		System.out.println("Rectangle length : " + rectangle.getLength() + " : breadth : " + rectangle.getBreadth()
				+ " area : " + rectangle.calculateArea());

	}

}
