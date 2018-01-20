package com.demo.pasta.store.model;

import java.util.ArrayList;
import java.util.List;

public class PastaResponseHolder {
	
	long id;
	List<String> pastas = new ArrayList<String>();
	
	public PastaResponseHolder(long id, List<String> pastas) {
		super();
		this.id = id;
		this.pastas = pastas;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<String> getPastas() {
		return pastas;
	}
	public void setPastas(List<String> pastas) {
		this.pastas = pastas;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PastaResponse [id=").append(id).append(", pastas=").append(pastas).append("]");
		return builder.toString();
	}
	



}
