package com.practice.creational.factory;

public class ShapeFactory {

	public static Shape getShape(ShapeType shapetype) {
		Shape shape = null;
		
		switch (shapetype) {
		case CIRCLE:
			shape = new Circle();
		case RECTANGLE:
			shape = new Rectangle();
		case SQUARE:
			shape = new Square();

		}

		return shape;
	}

}
