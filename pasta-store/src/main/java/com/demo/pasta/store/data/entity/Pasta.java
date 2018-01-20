package com.demo.pasta.store.data.entity;

import java.util.List;


public class Pasta {

	private String name;
	private List<String> sauces;
	private List<String> howtocook;
	private Double price;
	
	public Pasta() {
	
	}
	
	public Pasta(String name, List<String> sauces, List<String> howtocook, Double price) {
		super();
		this.name = name;
		this.sauces = sauces;
		this.howtocook = howtocook;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSauces() {
		return sauces;
	}
	public void setSauces(List<String> sauces) {
		this.sauces = sauces;
	}
	public List<String> getHowtocook() {
		return howtocook;
	}
	public void setHowtocook(List<String> howtocook) {
		this.howtocook = howtocook;
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
		builder.append("Pasta [name=").append(name).append(", sauces=").append(sauces).append(", howtocook=")
				.append(howtocook).append(", price=").append(price).append("]");
		return builder.toString();
	}



}
