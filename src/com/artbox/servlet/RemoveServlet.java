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

	public RemoveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		boolean inputParameterIsVaild = Validator.validateNonNullOrEmptyInput(id);

		if (inputParameterIsVaild) {
			this.remove(id, response);
		} else {
			this.destroy();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean remove(String id, HttpServletResponse response) {

		ArtBoxStorage storage = ArtBoxStorage.getInstance();
		short idShort = Short.parseShort(id);
		boolean operationSuccessful = false;

		synchronized (storage) {
			operationSuccessful = storage.remove(idShort);
		}

		this.getMessage(id, operationSuccessful, response);
		
		return operationSuccessful;
	}

	private void getMessage(String id, boolean operationSuccessful, HttpServletResponse response) {

		if (operationSuccessful) {
			try {
				response.getWriter().append("ArtBox with id=" + id + " has been successfully removed!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().append("ERROR! There is no ArtBox with id" + id + " in the storage!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}