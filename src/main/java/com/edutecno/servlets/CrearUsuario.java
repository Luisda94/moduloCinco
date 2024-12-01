package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1336109970326208433L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir parámetros del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        // Lógica para guardar el usuario en la base de datos
        boolean usuarioCreado = guardarUsuario(username, password, fechaNacimiento);

        if (usuarioCreado) {
            response.sendRedirect("login.jsp?mensaje=Usuario registrado exitosamente");
        } else {
            response.sendRedirect("registro.jsp?error=Error al registrar el usuario");
        }
    }

    private boolean guardarUsuario(String username, String password, String fechaNacimiento) {
        // Simulación de guardado (reemplazar por DAO)
        return true;
    }
}
