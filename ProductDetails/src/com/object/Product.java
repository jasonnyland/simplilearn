package com.object;

public class Product {
	String name;
	String description;
	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + "]";
	}
	
}
