package com.demo.pasta.store.model;

import java.util.ArrayList;
import java.util.List;

public class SauceResponse {
	
	long id;
	List<String> sauces = new ArrayList<String>();
	
	public SauceResponse(long id, List<String> sauces) {
		super();
		this.id = id;
		this.sauces = sauces;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<String> getSauces() {
		return sauces;
	}
	public void setSauces(List<String> sauces) {
		this.sauces = sauces;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SauceResponse [id=").append(id).append(", sauces=").append(sauces).append("]");
		return builder.toString();
	}
	
}
