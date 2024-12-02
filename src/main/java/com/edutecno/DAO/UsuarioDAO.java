package com.edutecno.DAO;

import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final Connection conn;

    public UsuarioDAO() throws SQLException {
        this.conn = ConexionDB.getConexion();
    }

    public void crearUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO public.usuario (nombre, correo, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Usuario> buscarUsuarios(String keyword) {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombre LIKE ? OR correo LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            stmt.setString(1, searchKeyword);
            stmt.setString(2, searchKeyword);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    usuarios.add(new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contrasena"),
                            rs.getDate("fecha_nacimiento")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public boolean guardar(Usuario usuario) {
        boolean usuarioGuardado = false;

        String sql = "INSERT INTO public.usuario (nombre, correo, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setDate(4, usuario.getFechaNacimiento());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                usuarioGuardado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioGuardado;
    }
}
