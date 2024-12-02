package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.SQLException;

import com.edutecno.DAO.UsuarioDAO;
import com.edutecno.modelo.Usuario;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1336109970326208433L;
	private String fechaacimiento;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir parámetros del formulario
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String fechaacimiento = request.getParameter("fechaNacimiento");

        // Lógica para guardar el usuario en la base de datos
        boolean usuarioCreado = guardarUsuario(correo, contrasena, fechaacimiento);
        if (usuarioCreado) {
            response.sendRedirect("login.jsp?mensaje=Usuario registrado exitosamente");
        } else {
            response.sendRedirect("registro.jsp?error=Error al registrar el usuario");
        }
    }

	private boolean guardarUsuario(String nombre, String correo, String contrasena) {
        boolean usuarioCreado = false;
        
        // Crear una nueva instancia de Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        usuario.setFechaNacimiento(java.sql.Date.valueOf(fechaacimiento));

        // Crear un objeto DAO para interactuar con la base de datos
        UsuarioDAO usuarioDAO = null;
		try {
			usuarioDAO = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Guardar el usuario en la base de datos
        usuarioCreado = usuarioDAO.guardar(usuario);

        return usuarioCreado;
    }
}
