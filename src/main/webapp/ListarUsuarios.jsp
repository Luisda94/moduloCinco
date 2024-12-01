<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.edutecno.modelo.Usuario,com.edutecno.DAO.UsuarioDAO" %>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-4">Lista de Usuarios</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Fecha Nacimiento</th>
                </tr>
            </thead>
            <tbody>
                <% if (usuarios != null && !usuarios.isEmpty()) { %>
                    <% for (Usuario usuario : usuarios) { %>
                        <tr>
                            <td><%= usuario.getId() %></td>
                            <td><%= usuario.getNombre() %></td>
                            <td><%= usuario.getCorreo() %></td>
                            <td><%= usuario.getFechaNacimiento() %></td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr><td colspan="4">No se encontraron resultados.</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>