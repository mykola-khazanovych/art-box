package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.util.Validator;
import com.artbox.model.ArtBoxEntity;
import com.artbox.storage.ArtBoxStorage;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;
	private HttpServletResponse response;

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.response = response;
		
		final String REQUEST_PARAMETER_ART_BOX_THEME = "theme";
		final String REQUEST_PARAMETER_ART_BOX_RECOMMENDED_AGE = "age";
		final String REQUEST_PARAMETER_ART_BOX_COST = "cost";
		
		String theme = request.getParameter(REQUEST_PARAMETER_ART_BOX_THEME);
		String age = request.getParameter(REQUEST_PARAMETER_ART_BOX_RECOMMENDED_AGE);
		String cost = request.getParameter(REQUEST_PARAMETER_ART_BOX_COST);
		
		boolean isParameterVaild = Validator.validateNonNullOrEmptyInput(theme, age, cost);

		if (isParameterVaild) {
			this.addArtBoxItem(theme, age, cost);
		} else {
			response.getWriter().append("Please enter non-null/non-empty input values of request parameters!");
			response.flushBuffer();
		}
	}

	private boolean addArtBoxItem(String theme, String stringAge, String stringCost) throws ServletException, IOException {

		short age = Short.parseShort(stringAge);
		float cost = Float.parseFloat(stringCost);
		
		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		boolean operationSuccessful = storage.add( new ArtBoxEntity(theme, age, cost));

		if (operationSuccessful) {
				response.getWriter().append("ArtBox (\"" + theme + "\", for " + age + " year(s) age, with price " + cost
						+ " UAH) has been successfully added!");
				response.flushBuffer();
		} else {
				response.getWriter().append("ERROR occured during ArtBox (\"" + theme + "\", for " + age
						+ " year(s) age, with price " + cost + " UAH) adding!");
				response.flushBuffer();
		}

		return operationSuccessful;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}