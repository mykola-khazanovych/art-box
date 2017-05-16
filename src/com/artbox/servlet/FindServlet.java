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

	public FindServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theme = request.getParameter("theme");

		boolean inputParameterIsVaild = Validator.validateNonNullOrEmptyInput(theme);

		if (inputParameterIsVaild) {
			this.find(theme, response);
		} else {
			this.destroy();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean find(String theme, HttpServletResponse response) {

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		boolean operationSuccessful = false;
		ArtBoxEntity findArtBox = null;

		synchronized (storage) {

			findArtBox = storage.find(theme);
			if (findArtBox != null) {
				operationSuccessful = true;
			}
		}

		this.getMessage(theme, operationSuccessful, response);

		if (operationSuccessful) {
			this.printItem(findArtBox, response);
		}

		return operationSuccessful;
	}

	private void getMessage(String theme, boolean operationSuccessful, HttpServletResponse response) {

		if (operationSuccessful) {
			try {
				response.getWriter().append("ArtBox with theme \"" + theme + "\" has been find!").append("</p>");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().append("ERROR! There is no ArtBox with theme \"" + theme + "\" in the storage!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void printItem(ArtBoxEntity item, HttpServletResponse response) {
		try {
			response.getWriter().append(item.toString());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}