package com.practice.structural.flyweight;

public class FlyweightTester {

	public static void main(String[] args) {

		double radius = 2.0;
		double length = 2.0;
		double breadth = 3.0;

		Circle cir = (Circle) ShapeFactory.getShape(ShapeType.CIRCLE);
		cir.setRadius(radius);
		System.out.println("Circle Area : " + cir.calculateArea());

		Rectangle rect = (Rectangle) ShapeFactory.getShape(ShapeType.RECTANGLE);
		rect.setBreadth(breadth);
		rect.setLength(length);
		System.out.println("Rectangle Area : " + rect.calculateArea());

		Square sq = (Square) ShapeFactory.getShape(ShapeType.SQUARE);
		sq.setLength(length);
		System.out.println("Square Area : " + sq.calculateArea());
		
		Circle cir1 = (Circle) ShapeFactory.getShape(ShapeType.CIRCLE);
		cir1.setRadius(3);
		System.out.println("Circle Area : " + cir1.calculateArea());
		System.out.println("cir hash code : " + cir.hashCode());
		System.out.println("cir1 hash code : " + cir1.hashCode());
		System.out.println("cir==cir1 : " + cir.equals(cir1));
		
		Rectangle rect1 = (Rectangle) ShapeFactory.getShape(ShapeType.RECTANGLE);
		System.out.println("rect hash code : " + rect.hashCode());
		System.out.println("rect1 hash code : " + rect1.hashCode());
		
	}

}
