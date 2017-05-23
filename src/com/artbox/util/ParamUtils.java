package com.artbox.util;

public class ParamUtils {

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

	public static boolean isNotBlank(String theme, int age, float cost) {

		
		return true;
		
	}
}
