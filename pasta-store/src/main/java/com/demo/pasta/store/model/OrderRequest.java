package com.demo.pasta.store.model;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

	String pasta;
	List<String> sauces = new ArrayList<String>();
	
	public OrderRequest() {
		super();
	}
	
	public OrderRequest(String pasta, List<String> sauces) {
		super();
		this.pasta = pasta;
		this.sauces = sauces;
	}
	
	public String getPasta() {
		return pasta;
	}
	public void setPasta(String pasta) {
		this.pasta = pasta;
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
		builder.append("OrderRequest [pasta=").append(pasta).append(", sauces=").append(sauces).append("]");
		return builder.toString();
	}
	
	
	
	
	
}
