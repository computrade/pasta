package com.demo.pasta.store.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

	protected Logger logger;

	public GlobalExceptionHandlingControllerAdvice() {
		logger = LoggerFactory.getLogger(getClass());
	}

	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "Pasta not Found,Check your request.")
	@ExceptionHandler(PastaNotFoundException.class)
	public void notFound() {
		logger.error("Request raised a PastaNotFoundExceptionClass");
	}
	
	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Some parameters are missing in the request. Check your request.")
	@ExceptionHandler(BadRequestException.class)
	public void badRequest() {
		logger.error("Request raised a BadRequestException");
	}
	
	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "The recipe was not found in the food2fork api.")
	@ExceptionHandler(RecipeNotFoundException.class)
	public void recipeNotFound() {
		logger.error("The recipe was not found in the food2fork api");
	}


}