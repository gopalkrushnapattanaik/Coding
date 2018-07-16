package com.practice.creational.factory;

public class FactoryTester {

	public static void main(String[] args) {
	
			Shape circle =ShapeFactory.getShape(ShapeType.CIRCLE);
			Shape rectangle =ShapeFactory.getShape(ShapeType.RECTANGLE);
			Shape square= ShapeFactory.getShape(ShapeType.SQUARE);		
	
	}

}
