package com.artbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

		response.sendRedirect("dashboard.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		Map<Integer, ArtBox> artBoxCollection = storage.getAll();

		if (artBoxCollection.isEmpty()) {
			out.println("Sorry! Database is empty!");
		}

		for(Map.Entry<Integer, ArtBox> en: artBoxCollection.entrySet()) {
			out.println("id = " + en.getKey() + " " + en.getValue().toString() + "<br>");
		}
	}
}