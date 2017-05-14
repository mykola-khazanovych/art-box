package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.util.Validator;

@WebServlet("/div")
public class DivideServlet extends HttpServlet{

	private static final long serialVersionUID = 485135717800530684L;

	public DivideServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstInputParameter = request.getParameter("a");
		String secondInputParameter = request.getParameter("b");

	//	Validator.validate(firstInputParameter, secondInputParameter, response);

		int a = Integer.valueOf(firstInputParameter);
		int b = Integer.valueOf(secondInputParameter);
		
		if(b == 0){
			response.getWriter().append("Please enter non-zero divider!");
			response.flushBuffer();
		}

		response.getWriter().append("Division is: " + (a / b));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}