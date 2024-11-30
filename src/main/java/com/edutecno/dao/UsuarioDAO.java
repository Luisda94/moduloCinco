package com.edutecno.dao;

import com.edutecno.modelo.Usuario;

public class UsuarioDAO {

	    boolean registrarUsuario(Usuario usuario);
	    Usuario iniciarSesion(String correo, String contrasena);
	    List<Usuario> listarUsuarios();
	    boolean modificarUsuario(Usuario usuario);
	    boolean eliminarUsuario(int id);
	

}
