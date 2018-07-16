package com.practice.creational.prototype;

import java.util.List;

public class Order implements Cloneable {

	private int orderId = hashCode();
	private List<Item> items;
	private String state;
	private double amount;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Object clone() throws CloneNotSupportedException {

		Order order = new Order();
		order.setItems(this.getItems());
		order.setAmount(this.getAmount());
		order.setState("INITIAL");
		return order;

	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append(this.orderId).append(" "+ this.getState()).append(this.getAmount());

		return sb.toString();

	}
}
