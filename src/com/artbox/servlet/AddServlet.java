package com.artbox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.model.ArtBox;
import com.artbox.builder.ArtBoxBuilder;
import com.artbox.storage.ArtBoxStorage;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 485135717800530684L;

	private static final String ART_BOX_THEME = "theme";
	private static final String ART_BOX_RECOMMENDED_AGE = "age";
	private static final String ART_BOX_COST = "cost";

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("add.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theme = request.getParameter(ART_BOX_THEME);
		String ageStr = request.getParameter(ART_BOX_RECOMMENDED_AGE);
		String costStr = request.getParameter(ART_BOX_COST);

		String message;
		String textColor;

		try {

			int age = Integer.parseInt(ageStr);
			float cost = Float.parseFloat(costStr);

			ArtBoxStorage artboxStorage = ArtBoxStorage.getInstance();
			ArtBox artBox = new ArtBoxBuilder().theme(theme).age(age).cost(cost).build();

			message = "Error! Artbox can't be added!";
			textColor = "textColorRed";

			if (artboxStorage.add(artBox)) {

				message = "Success! Artbox '" + theme + "' has been added!";
				textColor = "textColorGreen";
			}

		} catch (NumberFormatException nfe) {

			message = "Error! Number format error! Please enter correct values for ArtBox'es 'theme', 'age' and 'cost'!";
			textColor = "textColorRed";
		}
		request.setAttribute("message", message);
		request.setAttribute("textColor", textColor);
        request.getRequestDispatcher("/add.jsp").forward(request, response);
	}
}