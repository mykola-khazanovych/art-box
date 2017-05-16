package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.storage.ArtBoxStorage;
import com.artbox.util.Validator;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;
	private HttpServletResponse response;

	public RemoveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.response = response;

		final String REQUEST_PARAMETER_ART_BOX_ID = "id";
		String id = request.getParameter(REQUEST_PARAMETER_ART_BOX_ID);

		boolean inputParameterIsVaild = Validator.validateNonNullOrEmptyInput(id);

		if (inputParameterIsVaild) {
			this.remove(id);
		} else {
			response.getWriter().append("Please enter non-null/non-empty input value of request parameter!");
			response.flushBuffer();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean remove(String stringId) throws ServletException, IOException{

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		short id = Short.parseShort(stringId);
		boolean operationSuccessful = storage.remove(id);

		if (operationSuccessful) {
				response.getWriter().append("ArtBox with id=" + id + " has been successfully removed!");
				response.flushBuffer();
		} else {
				response.getWriter().append("ERROR! There is no ArtBox with id" + id + " in the storage!");
				response.flushBuffer();
		}
		
		return operationSuccessful;
	}
}