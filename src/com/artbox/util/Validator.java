package com.artbox.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Validator {
	public static boolean validate(String theme, String age, String cost,
			HttpServletResponse response) {

		if (theme == null || age == null || cost == null) {
			try {
				response.getWriter().append("Please enter non-null input values 'Theme of ArtBox',"
						+ "'Recommended age' and 'Cost of purchase (w/o delivery)'!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

		if (theme.isEmpty() || age.isEmpty() || cost.isEmpty()) {
			try {
				response.getWriter().append("Please enter non-empty  input values 'Theme of ArtBox',"
						+ "'Recommended age' and 'Cost of purchase (w/o delivery)'!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

		return true;
	}
}
