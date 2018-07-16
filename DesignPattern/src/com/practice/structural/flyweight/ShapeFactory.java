package com.practice.structural.flyweight;

import java.util.HashMap;

public class ShapeFactory {

	private static final HashMap<ShapeType, Shape> shapes = new HashMap<ShapeType, Shape>();

	//shape factory creates the shapes using thread safe double locking mechanism
	public static Shape getShape(ShapeType type) {

		Shape shape = shapes.get(type);

		if (shape == null) {

			synchronized (ShapeFactory.class) {
				switch (type) {

				case CIRCLE:
					shape = (shape == null) ? new Circle() : shapes.get(type);
					break;
				case RECTANGLE:
					shape = (shape == null) ? new Rectangle() : shapes.get(type);
					break;
				case SQUARE:
					shape = (shape == null) ? new Square() : shapes.get(type);
					break;
				}
				shapes.put(type, shape);

			}
		}

		return shape;

	}
}
