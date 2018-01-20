package com.demo.pasta.store.data.entity;

public class Sauce {

	private String name;
	private Double price;

	public Sauce(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sauce [name=").append(name).append(", price=").append(price).append("]");
		return builder.toString();
	}

}
