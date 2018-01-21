package com.demo.pasta.store.model;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
	
	long id;
	Double price;
	List<String> cook = new ArrayList<String>();
	String image;
	List<String> ingredients = new ArrayList<String>();
	
	public OrderResponse() {
		
	}
	
	public OrderResponse(long id, Double price, List<String> cook, String image, List<String> ingredients) {
		super();
		this.id = id;
		this.price = price;
		this.cook = cook;
		this.image = image;
		this.ingredients = ingredients;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<String> getCook() {
		return cook;
	}
	public void setCook(List<String> cook) {
		this.cook = cook;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderResponse [id=").append(id).append(", price=").append(price).append(", cook=").append(cook)
				.append(", image=").append(image).append(", ingredients=").append(ingredients).append("]");
		return builder.toString();
	}

	
	
	
}
