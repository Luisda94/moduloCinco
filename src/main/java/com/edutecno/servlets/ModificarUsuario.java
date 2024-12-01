package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1546165895427753954L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String nuevoPassword = request.getParameter("password");
        String nuevaFechaNacimiento = request.getParameter("fechaNacimiento");

        boolean actualizado = modificarUsuario(username, nuevoPassword, nuevaFechaNacimiento);

        if (actualizado) {
            response.sendRedirect("ListarUsuarios.jsp?mensaje=Usuario actualizado");
        } else {
            response.sendRedirect("modificarUsuario.jsp?error=Error al actualizar");
        }
    }

    private boolean modificarUsuario(String username, String password, String fechaNacimiento) {
        // Simulación de modificación (reemplazar con DAO)
        return true;
    }
}
