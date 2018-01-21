package com.demo.pasta.store.exception;

public class SauceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public SauceNotFoundException(String message) {
		super(message);
	}

	public SauceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SauceNotFoundException(Throwable cause) {
		super(cause);
	}

}
