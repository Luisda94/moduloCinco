package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        if (correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            response.getWriter().println("Por favor ingrese ambos campos.");
            return;
        }

        if (authenticateUser(correo, contrasena)) {
            request.getSession().setAttribute("usuario", correo);
            response.sendRedirect("horoscopo.jsp");
        } else {
            response.getWriter().println("Usuario o contraseña incorrectos.");
        }
    }

    private boolean authenticateUser(String correo, String contrasena) {
        boolean isAuthenticated = false;
        String dbUrl = "jdbc:postgresql://localhost:5432/DBHoroscopoChino";
        String dbUser = "postgres";
        String dbPassword = "Hat422";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String sql = "SELECT contrasena FROM usuario WHERE correo = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, correo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next() && comparePasswords(contrasena, rs.getString("contrasena"))) {
                        isAuthenticated = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    private boolean comparePasswords(String enteredPassword, String storedPassword) {
        String hashedEnteredPassword = hashPassword(enteredPassword);
        return hashedEnteredPassword != null && hashedEnteredPassword.equals(storedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
