package com.demo.pasta.store.exception;

public class RecipeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public RecipeNotFoundException(String message) {
		super(message);
	}

	public RecipeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecipeNotFoundException(Throwable cause) {
		super(cause);
	}

}
