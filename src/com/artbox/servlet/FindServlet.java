package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBoxEntity;
import com.artbox.storage.ArtBoxStorage;
import com.artbox.util.Validator;

@WebServlet("/find")
public class FindServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;
	private HttpServletResponse response;

	public FindServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.response = response;

		final String REQUEST_PARAMETER_ART_BOX_THEME = "theme";
		String theme = request.getParameter(REQUEST_PARAMETER_ART_BOX_THEME);

		boolean inputParameterIsVaild = Validator.validateNonNullOrEmptyInput(theme);

		if (inputParameterIsVaild) {
			this.find(theme);
		} else {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean find(String theme) throws ServletException, IOException {

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		boolean operationSuccessful = false;

		ArtBoxEntity findArtBox = storage.find(theme);
		if (findArtBox != null) {
			operationSuccessful = true;
		}

		if (operationSuccessful) {
				response.getWriter().append("ArtBox with theme \"" + theme +
						"\" has been find!" + "</p>" + findArtBox.toString());
				response.flushBuffer();
		} else {
				response.getWriter().append("ERROR! There is no ArtBox with theme \"" + theme + "\" in the storage!");
				response.flushBuffer();
		}

		return operationSuccessful;
	}
}