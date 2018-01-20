package com.demo.pasta.store.data.entity;


public class RecommendedSauce {

	private String pasta;
	private String sauce;
	public String getPasta() {
		return pasta;
	}
	public void setPasta(String pasta) {
		this.pasta = pasta;
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecommendedSauce [pasta=").append(pasta).append(", sauce=").append(sauce).append("]");
		return builder.toString();
	}

	

	

	
	

}
