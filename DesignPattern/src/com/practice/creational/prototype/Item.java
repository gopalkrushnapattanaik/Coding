package com.practice.creational.prototype;

public class Item {
	
	private int itemId= hashCode();
	private String description;
	private double amount;
	
	public Item(String description, double amount) {
		this.description= description;
		this.amount=amount;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
