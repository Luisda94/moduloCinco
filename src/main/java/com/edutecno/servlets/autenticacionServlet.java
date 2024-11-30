package com.edutecno.servlets;
import com.edutecno.dao.*;
import com.edutecno.modelo.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class autenticacionServlet
 */
@WebServlet("/autenticacionServlet")
public class autenticacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autenticacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 String correo = request.getParameter("correo");
	        String contrasena = request.getParameter("contrasena");

	        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	        Usuario usuario = usuarioDAO.iniciarSesion(correo, contrasena);

	        if (usuario != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("usuario", usuario);
	            response.sendRedirect("consulta.jsp");
	        } else {
	            request.setAttribute("error", "Credenciales inválidas.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    }
	}


