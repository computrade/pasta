package com.demo.pasta.store.model;

import com.demo.pasta.store.data.entity.Pasta;

public class PastaResponse {
	
	long id;
	Pasta pasta = new Pasta();
	
	public PastaResponse() {
		
	}
	
	
	
	public PastaResponse(long id, Pasta pasta) {
		super();
		this.id = id;
		this.pasta = pasta;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	



}
