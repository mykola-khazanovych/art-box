package com.artbox.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBox;
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String stringId = request.getParameter(ART_BOX_ID);
		int id;
		String message;
		String textColor;

		try {

			id = Integer.parseInt(stringId);
			ArtBoxStorage storage = ArtBoxStorage.getInstance();
			Map<Integer, ArtBox> artBoxCollection = storage.getAll();

			request.setAttribute("products", artBoxCollection.entrySet());

			message = "ERROR! There is no ArtBox with id" + id + " in the storage!";
			textColor = "textColorRed";
			if (storage.removeById(id)) {
				message = "ArtBox with id=" + id + " has been successfully removed!";
				textColor = "textColorGreen";
				
			}
			
		} catch (NumberFormatException nfe) {
			message = "You've entered incorrect 'id' value! = " + stringId;
			textColor = "textColorRed";
		}

		request.setAttribute("message", message);
		request.setAttribute("textColor", textColor);
		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}
}