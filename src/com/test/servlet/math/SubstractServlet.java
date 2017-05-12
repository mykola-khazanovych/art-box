package com.test.servlet.math;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubstractServlet
 */
@WebServlet("/sub")
public class SubstractServlet extends MathServlet{

	private static final long serialVersionUID = 485135717800530684L;

	@Override
	protected void mathOperation(int a, int b, HttpServletResponse response) throws IOException {
		
		response.getWriter().append("Substract is: " + (a - b));
	}}