package com.simpli;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveFromFavoritesServlet
 */
public class RemoveFromFavoritesServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String crossingId = request.getParameter("crossingId");
		if (crossingId != null && !crossingId.isEmpty()) {
			int railwayCrossingId = Integer.parseInt(crossingId);
			// Perform the database operation to remove the crossing from favorites
			RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
			crossingDAO.removeFromFavorites(railwayCrossingId); // Implement this method in RailwayCrossingDAO
		}
		// Redirect back to the userHome.jsp page
		response.sendRedirect("userHome.jsp");
	}

}
