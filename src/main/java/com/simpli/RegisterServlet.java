package com.simpli;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve the form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Create a new User object
		User user = new User(name, email, password);

		// Store the user in the database
		UserDAO userDAO = new UserDAO();
		userDAO.registerUser(user);

		// Redirect to a success page or perform any other necessary actions
		response.sendRedirect("userLogin.jsp");
	}

}
