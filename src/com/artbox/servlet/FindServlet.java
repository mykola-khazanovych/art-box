package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBox;
import com.artbox.storage.ArtBoxStorage;
import com.artbox.util.ParamUtils;

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

		if (Validator.isBlank(theme)) {
			response.getWriter().append("Please enter non-null/non-empty input value of request parameter!");
			response.flushBuffer();
		} else {
			ArtBoxStorage storage = ArtBoxStorage.getInstance();
			ArtBox findArtBox = storage.findByTheme(theme);

			if (findArtBox != null) {
					response.getWriter().append("ArtBox with theme \"" + theme +
							"\" has been find!" + "</p>" + findArtBox.toString());
					response.flushBuffer();
			} else {
					response.getWriter().append("ERROR! There is no ArtBox with theme \"" + theme + "\" in the storage!");
					response.flushBuffer();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}