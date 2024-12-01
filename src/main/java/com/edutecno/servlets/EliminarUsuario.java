package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7253566768462152733L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        boolean eliminado = eliminarUsuario(username);

        if (eliminado) {
            response.sendRedirect("listarUsuarios.jsp?mensaje=Usuario eliminado");
        } else {
            response.sendRedirect("listarUsuarios.jsp?error=Error al eliminar usuario");
        }
    }

    private boolean eliminarUsuario(String username) {
        // Simulación de eliminación (reemplazar con DAO)
        return true;
    }
}
