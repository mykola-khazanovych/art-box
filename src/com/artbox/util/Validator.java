package com.artbox.util;

public class Validator {

	public static boolean validateNonNullOrEmptyInput(String... param) {
		
		for (String s : param) {
			if (s == null) {
				return false;
			}
		}
		
		for (String s : param) {
			if (s.isEmpty()) {
				return false;
			}
		}

		return true;
	}
}
