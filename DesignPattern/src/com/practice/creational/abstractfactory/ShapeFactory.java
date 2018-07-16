package com.practice.creational.abstractfactory;

public class ShapeFactory {

	public static Shape getShape(ShapeAbstractFactory factory) {
		
		return factory.getShape();
		
	}
}
