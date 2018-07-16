package com.practice.creational.prototype;


import java.util.ArrayList;

public class PrototypeTester {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		ArrayList<Item> items=  new ArrayList<>();
		
		Item apple= new Item("apple", 100.00);
		Item orange= new Item("orange", 50.00);
		Item banana= new Item("banana", 10.00);
		
		items.add(apple);
		items.add(orange);
		items.add(banana);
		
		Order order = new Order();
		order.setItems(items);
		order.setState("Created");
		order.setAmount(calculateOrderAmount(items));
		
		System.out.println(order.toString());
		
		Order order1= (Order) order.clone();
		
		System.out.println(order1.toString());
		
		
	}

	private static double calculateOrderAmount(ArrayList<Item> items) {
		double orderAmount = 0.0;
		for (Item item : items) {
			orderAmount += item.getAmount();
		}
		return orderAmount;
	}

}
