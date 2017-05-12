package com.test.servlet.math;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.servlet.util.Validator;

/**
 * Servlet implementation abstract class MathServlet
 */

@WebServlet("/")
public abstract class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MathServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstInputParameter = request.getParameter("a");
		String secondInputParameter = request.getParameter("b");

		this.validateInputArguments(firstInputParameter, secondInputParameter, response);

		int a = Integer.valueOf(firstInputParameter);
		int b = Integer.valueOf(secondInputParameter);

		try {

			this.mathOperation(a, b, response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected abstract void mathOperation(int a, int b, HttpServletResponse response) throws IOException;

	private void validateInputArguments(String firstInputParameter, String secondInputParameter,
			HttpServletResponse response) throws IOException {

		boolean argumentsAreValid = Validator.validate(firstInputParameter, secondInputParameter, response);
		if (!argumentsAreValid) {
			response.flushBuffer();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
