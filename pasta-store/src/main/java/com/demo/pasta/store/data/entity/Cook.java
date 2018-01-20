package com.demo.pasta.store.data.entity;

public class Cook {

	private String metadata;
	private String instruction;
	
	
	public Cook(String metadata, String instruction) {
		super();
		this.metadata = metadata;
		this.instruction = instruction;
	}

	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cook [metadata=").append(metadata).append(", instruction=").append(instruction).append("]");
		return builder.toString();
	}


}
