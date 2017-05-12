package com.test.servlet.math;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/div")
public class DivideServlet extends MathServlet {
	
	private static final long serialVersionUID = -7788488297965784175L;

	@Override
	protected void mathOperation(int a, int b, HttpServletResponse response) throws IOException {
		
		try{
		response.getWriter().append("Division is: " + (a / b));}
		catch(ArithmeticException ae){
			response.getWriter().append("Please input non-zero divider!");
		}
	}

}
