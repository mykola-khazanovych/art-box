package com.artbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.util.Validator;
import com.artbox.model.ArtBox;
import com.artbox.storage.ArtBoxStorage;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;

	private static final String ART_BOX_THEME = "theme";
	private static final String ART_BOX_RECOMMENDED_AGE = "age";
	private static final String ART_BOX_COST = "cost";

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stringTheme = request.getParameter(ART_BOX_THEME);
		String stringAge = request.getParameter(ART_BOX_RECOMMENDED_AGE);
		String stringCost = request.getParameter(ART_BOX_COST);

		if (Validator.isBlank(stringTheme, stringAge, stringCost)) {

			response.getWriter().append("Please enter non-null/non-empty input values of request parameters!");
			response.flushBuffer();
			
		} else {
			
			PrintWriter out = response.getWriter();

			int age = 0;
			float cost = 0;
			try {
				age = Short.parseShort(stringAge);
				cost = Float.parseFloat(stringCost);
			} catch (NumberFormatException nfe) {
				out.println("You've entered incorrect 'recommended age' and/or 'cost' values!");
				nfe.printStackTrace();
				response.flushBuffer();
				this.destroy();
			}

			ArtBoxStorage storage = ArtBoxStorage.getInstance();
			if (storage.add(new ArtBox(stringTheme, age, cost))) {

				out.println("ArtBox (\"" + stringTheme + "\", for " + age + " year(s) age, with price " + cost
						+ " UAH) has been successfully added!");
				response.flushBuffer();

			} else {
				out.println("ERROR occured during ArtBox (\"" + stringTheme + "\", for " + age
						+ " year(s) age, with price " + cost + " UAH) adding!");
				response.flushBuffer();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}