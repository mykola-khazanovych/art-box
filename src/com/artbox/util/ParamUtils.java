package com.artbox.util;

public class Validator {

	public static boolean isBlank(String... param) {
		
		for (String s : param) {
			if (s == null) {
				return true;
			}
		}
		
		for (String s : param) {
			if (s.isEmpty()) {
				return true;
			}
		}

		return false;
	}
}
