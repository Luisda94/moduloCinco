package com.edutecno.DAO;

import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Usuario> obtenerUsuarios(String keyword) {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection()) {
            String sql = "SELECT * FROM usuario WHERE nombre LIKE ? OR correo LIKE ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // Preparamos el parámetro para la búsqueda
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contrasena"),
                            rs.getDate("fecha_nacimiento")
                    );
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
	/*
	 * public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
	 * String query = "SELECT * FROM public.usuario WHERE correo = ?";
	 * PreparedStatement stmt = conn.prepareStatement(query); stmt.setString(1,
	 * correo); ResultSet rs = stmt.executeQuery();
	 * 
	 * if (rs.next()) { Usuario usuario = new Usuario();
	 * usuario.setId(rs.getInt("id")); usuario.setNombre(rs.getString("nombre"));
	 * usuario.setCorreo(rs.getString("correo"));
	 * usuario.setContrasena(rs.getString("contrasena"));
	 * usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento")); return usuario; }
	 * return null; }
	 */

    public List<Usuario> buscarUsuarios(String keyword) {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombre LIKE ? OR correo LIKE ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String searchKeyword = "%" + keyword + "%";
            stmt.setString(1, searchKeyword);
            stmt.setString(2, searchKeyword);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contrasena"),
                            rs.getDate("fecha_nacimiento")
                    );
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejo básico de errores
        }
        return usuarios;
    }
}

