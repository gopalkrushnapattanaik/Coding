package com.practice.creational.abstractfactory;

public class RectangleFactory implements ShapeAbstractFactory {

	private double length;
	private double breadth;
	
	public RectangleFactory(double length,double breadth) {
		this.length=length;
		this.breadth=breadth;
	}
	
	@Override
	public Shape getShape() {
		
		Rectangle rect= new Rectangle();
		rect.setBreadth(breadth);
		rect.setLength(length);
		return rect;
	}

}
