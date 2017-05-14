package com.artbox.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Validator {
	public static boolean validate(String firstInputParameter, String secondInputParameter,
			HttpServletResponse response) {

		if (firstInputParameter == null || secondInputParameter == null) {
			try {
				response.getWriter().append("Please enter non-null input values 'a' and 'b'!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

		if (firstInputParameter.isEmpty() || secondInputParameter.isEmpty()) {
			try {
				response.getWriter().append("Please enter non-empty input values 'a' and 'b'!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

		return true;
	}
}
