package com.demo.pasta.store.util;

import java.util.List;

import com.demo.pasta.store.exception.BadRequestException;

public class PastaUtils {

	public static void validateStringIsNotNullOrEmpty(final String s) {
		// Null-safe, short-circuit evaluation.
		if (s == null || s.trim().isEmpty()) {
			throw new BadRequestException("input String is not expected to be empty.");
		}
	}

	public static void validateListIsNotNullOrEmpty(List<?> list) {

		// Null-safe, short-circuit evaluation.
		if (list == null || list.isEmpty()) {
			throw new BadRequestException("input List is not expected to be empty.");
		}

	}

}
