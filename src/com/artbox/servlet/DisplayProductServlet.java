package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBoxStorage;

@WebServlet("/list")
public class DisplayProductServlet extends HttpServlet{

	private static final long serialVersionUID = 485135717800530684L;

	public DisplayProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.displayProduct(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void displayProduct(HttpServletResponse response){
		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		storage.printDatabase(response);
	}

}