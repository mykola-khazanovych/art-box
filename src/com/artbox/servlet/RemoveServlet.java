package com.artbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.storage.ArtBoxStorage;

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
		int id;
		String message;

		try {

			id = Integer.parseInt(stringId);
			ArtBoxStorage storage = ArtBoxStorage.getInstance();

			message = "ERROR! There is no ArtBox with id" + id + " in the storage!";
			if (storage.removeById(id)) {
				message = "ArtBox with id=" + id + " has been successfully removed!";
			}
			
		} catch (NumberFormatException nfe) {
			message = "You've entered incorrect 'id' value!";
		}

		PrintWriter out = response.getWriter();
		out.println(message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}