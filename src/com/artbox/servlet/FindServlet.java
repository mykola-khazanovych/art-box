package com.artbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBox;
import com.artbox.storage.ArtBoxStorage;

@WebServlet("/find")
public class FindServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;
	private static final String ART_BOX_THEME = "theme";

	public FindServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theme = request.getParameter(ART_BOX_THEME);

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		ArtBox findArtBox = storage.findByTheme(theme);

		String message = "ERROR! There is no ArtBox with entered theme \'" + theme + "\' in the storage!";
		if (findArtBox != null) {
			message = "<i>" + "ArtBox with theme \"" + theme + "\" has been find!" + "</i>" + "<br>"
					+ findArtBox.toString();
		}

		PrintWriter out = response.getWriter();
		out.println(message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}