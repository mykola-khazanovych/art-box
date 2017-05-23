package com.artbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artbox.util.ParamUtils;
import com.artbox.model.ArtBox;
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

		
		String theme = request.getParameter(ART_BOX_THEME);
		String ageStr = request.getParameter(ART_BOX_RECOMMENDED_AGE);
		String costStr = request.getParameter(ART_BOX_COST);
		
		String message;
	
		
		try {
			//TODO: Check whether parse method validate null and empty value(s)
			int age = Integer.parseInt(ageStr);
			float cost = Float.parseFloat(costStr);
			
			boolean isValid = ParamUtils.isNotBlank(theme, age, cost);
			
			if(isValid) {
				
				message = "Error! Artbox can't be added!";
				
				ArtBoxStorage artboxStorage = ArtBoxStorage.getInstance();
				ArtBox artBox = new ArtBox(theme, age, cost);
				
				if(artboxStorage.add(artBox)) {
					
					message = "Success! Artbox has been added!";
				}
				
			} else {
				message = "Error! Parametrs can't be empty or zero!";
			}
			
		} catch (NumberFormatException nfe) {
			message = "Error! Number format error!";
		}
		
		PrintWriter out = response.getWriter();
		out.println(message);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}