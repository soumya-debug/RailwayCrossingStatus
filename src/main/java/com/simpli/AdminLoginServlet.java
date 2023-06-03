package com.simpli;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String ADMIN_ID = "soumya.rout@gmail.com";
    private static final String ADMIN_PASSWORD = "soumyarout";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && email.equals(ADMIN_ID) && password != null && password.equals(ADMIN_PASSWORD)) {
            response.sendRedirect("adminHome.jsp");
        } else {
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
    }

}
