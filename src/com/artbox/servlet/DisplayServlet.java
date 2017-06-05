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

@WebServlet("/list")
public class DisplayServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;

	public DisplayServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		Map<Integer, ArtBox> artBoxCollection = storage.getAll();

		request.setAttribute("products", artBoxCollection.entrySet());

		String message = "";
		if (artBoxCollection.isEmpty()) {
			message = "Sorry! Database is empty!";
			request.setAttribute("message", message);
			request.setAttribute("textColor", "textColorRed");
		}

		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}