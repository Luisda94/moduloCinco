package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6203744777742066869L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Lógica de autenticación
        if ("admin".equals(username) && "1234".equals(password)) {
            request.getSession().setAttribute("usuario", username);
            response.sendRedirect("horoscopo.jsp");
        } else {
            response.getWriter().println("Usuario o contraseña incorrectos");
        }
    }
}

