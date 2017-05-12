package com.test.servlet.math;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mul")
public class MultiplyServlet extends MathServlet {

	private static final long serialVersionUID = -3860326292257827380L;

	@Override
	protected void mathOperation(int a, int b, HttpServletResponse response) throws IOException {
	
		response.getWriter().append("Product is: " + (a * b));
	}

}
