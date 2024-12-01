<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.edutecno.modelo.Usuario" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta Horóscopo Chino</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Consulta tu Horóscopo Chino</h2>
        <% 
            HttpSession session = request.getSession(false);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario == null) {
                response.sendRedirect("login.jsp?error=Debe iniciar sesión para acceder.");
            } else {
        %>
        <div class="mt-4">
            <h4>Hola, <%= usuario.getNombre() %>!</h4>
            <p>Fecha de nacimiento: <%= usuario.getFechaNacimiento() %></p>
            <p>Tu signo en el horóscopo chino es: <strong><%= usuario.getAnimal() %></strong></p>
        </div>
        <a href="LogoutServlet" class="btn btn-danger mt-3">Cerrar Sesión</a>
        <% } %>
    </div>
</body>
</html>
