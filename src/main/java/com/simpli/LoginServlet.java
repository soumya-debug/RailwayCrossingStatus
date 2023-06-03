package com.simpli;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve the form data
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Check if the provided credentials are valid
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			// Authentication successful
			// You can store user details in session for further use
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// Redirect to a success page or perform any other necessary actions
			response.sendRedirect("userHome.jsp");
		} else {
			// Authentication failed
			// Redirect to an error page or display an error message
			response.sendRedirect("userRegister.jsp?error=1");
		}
	}
}
