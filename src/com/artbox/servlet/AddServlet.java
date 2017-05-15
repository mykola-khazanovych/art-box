package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.util.Validator;
import com.artbox.model.ArtBoxEntity;
import com.artbox.model.ArtBoxStorage;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theme = request.getParameter("theme");
		String age = request.getParameter("age");
		String cost = request.getParameter("cost");

		if (Validator.validate(theme, age, cost, response)) {
			this.addArtBoxItem(theme, age, cost, response);
		} else {
			this.destroy();
		}

	}

	private boolean addArtBoxItem(String theme, String age, String cost, HttpServletResponse response) {

		ArtBoxEntity artBoxItem = this.createArtBoxItem(theme, age, cost);
		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		boolean operationSuccessful = false;

		synchronized (this) {
			operationSuccessful = storage.add(artBoxItem);
		}

		this.getMessage(theme, age, cost, operationSuccessful, response);

		return operationSuccessful;
	}

	private ArtBoxEntity createArtBoxItem(String theme, String stringAge, String stringCost) {

		short age = Short.parseShort(stringAge);
		float cost = Float.parseFloat(stringCost);
		return new ArtBoxEntity(theme, age, cost);
	}

	private void getMessage(String theme, String age, String cost, boolean operationSuccessful,
			HttpServletResponse response) {

		if (operationSuccessful) {
			try {
				response.getWriter().append("ArtBox (\"" + theme + "\", for " + age + " year(s) age, with price " + cost
						+ " UAH) has been successfully added!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().append("ERROR occured during ArtBox (\"" + theme + "\", for " + age
						+ " year(s) age, with price " + cost + " UAH) adding!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}