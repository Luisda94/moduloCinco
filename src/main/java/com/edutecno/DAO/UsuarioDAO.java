package com.edutecno.DAO;

import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.*;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() throws SQLException {
        conn = ConexionDB.getConnection();
    }

    public void crearUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO public.usuario (nombre, correo, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getCorreo());
        stmt.setString(3, usuario.getContrasena());
        stmt.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
        stmt.executeUpdate();
    }

    public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
        String query = "SELECT * FROM public.usuario WHERE correo = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, correo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setContrasena(rs.getString("contrasena"));
            usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            return usuario;
        }
        return null;
    }
}

