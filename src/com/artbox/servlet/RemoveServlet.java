package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBoxStorage;
import com.artbox.util.Validator;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;

	public RemoveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Validator.validate(id, response);

		if (Validator.validate(id, response)) {
			this.remove(id, response);
		} else {
			this.destroy();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean remove(String id, HttpServletResponse response) {

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		short idShort = Short.parseShort(id);
		boolean operationSuccessful = false;
		
		synchronized(storage){
		operationSuccessful = storage.remove(idShort);}
		
		if (operationSuccessful) {
			this.getMessage(id, response);
		}

		return operationSuccessful;
	}

	private void getMessage(String id, HttpServletResponse response) {
		try {
			response.getWriter().append("ArtBox with id" + id + " has been successfully removed!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}