package com.demo.pasta.store.exception;

public class BadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}

}
