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
	private static final String ART_BOX_ID = "id";

	public RemoveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stringId = request.getParameter(ART_BOX_ID);

		if (Validator.isBlank(stringId)) {
			response.getWriter().append("Please enter non-null/non-empty input value of request parameter!");
			response.flushBuffer();
		} else {
			ArtBoxStorage storage = ArtBoxStorage.getInstance();
			
			int id = 0;
			try {
			id = Integer.parseInt(stringId);
			} catch (NumberFormatException nfe) {
				response.getWriter().append("You've entered incorrect 'id' value!");
				nfe.printStackTrace();
				response.flushBuffer();
				this.destroy();
			}
			
			if (storage.removeById(id)) {
					response.getWriter().append("ArtBox with id=" + id + " has been successfully removed!");
					response.flushBuffer();
			} else {
					response.getWriter().append("ERROR! There is no ArtBox with id" + id + " in the storage!");
					response.flushBuffer();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}