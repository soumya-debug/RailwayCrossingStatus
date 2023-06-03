package com.simpli;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCrossing")
public class DeleteCrossingServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve the crossing ID from the request
		int crossingId = Integer.parseInt(request.getParameter("id"));

		// Perform the delete operation (implement your logic)
		RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
		crossingDAO.deleteCrossing(crossingId);

		// Redirect to the admin homepage after the deletion
		response.sendRedirect("adminHome.jsp");
	}
}
