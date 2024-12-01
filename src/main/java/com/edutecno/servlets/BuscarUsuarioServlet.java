package com.edutecno.servlets;

import com.edutecno.DAO.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
	
@WebServlet("/BuscarUsuarioServlet")
public class BuscarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        UsuarioDAO dao = null;
        try {
            dao = new UsuarioDAO();
        } catch (SQLException e) {
            // Si no puedes inicializar el DAO, maneja la excepción aquí
            e.printStackTrace();
            // Puedes redirigir a una página de error si lo prefieres
            request.setAttribute("error", "Error al conectar con la base de datos.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        List<Usuario> usuarios = dao.buscarUsuarios(keyword);
        
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("BuscarUsuario.jsp").forward(request, response);
    }
}
