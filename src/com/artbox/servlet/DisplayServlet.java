package com.artbox.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
		Set<Map.Entry<Integer, ArtBox>> ArtBoxCollection = storage.getDatabase();

		if (ArtBoxCollection.isEmpty()) {
			response.getWriter().append("Sorry! Database is empty!");
			response.flushBuffer();
		}

		Iterator<Map.Entry<Integer, ArtBox>> iter = ArtBoxCollection.iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, ArtBox> en = (Map.Entry<Integer, ArtBox>) iter.next();
			response.getWriter().append("id = " + en.getKey() + " " + en.getValue().toString() + "</p>");
			response.flushBuffer();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}