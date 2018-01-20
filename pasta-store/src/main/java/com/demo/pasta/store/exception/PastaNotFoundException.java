package com.demo.pasta.store.exception;

public class PastaNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public PastaNotFoundException(String message) {
		super(message);
	}

	public PastaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PastaNotFoundException(Throwable cause) {
		super(cause);
	}

}
