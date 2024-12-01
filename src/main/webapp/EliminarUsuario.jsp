<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.edutecno.modelo.Usuario,com.edutecno.DAO.UsuarioDAO" %>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Eliminar Usuario</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-4">Eliminar Usuario</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% for (Usuario usuario : usuarios) { %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getNombre() %></td>
                    <td><%= usuario.getCorreo() %></td>
                    <td>
                        <form action="EliminarUsuarioServlet" method="post">
                            <input type="hidden" name="id" value="<%= usuario.getId() %>">
                            <button type="submit" class="btn btn-danger">Eliminar</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
