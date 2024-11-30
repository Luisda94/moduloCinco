package com.edutecno.modelo;
import java.sql.Date;

public class Usuario {

	    private int id;
	    private String nombre;
	    private String correo;
	    private String contrasena;
	    private Date fechaacimiento;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		public Date getFechaacimiento() {
			return fechaacimiento;
		}
		public void setFechaacimiento(Date fechaacimiento) {
			this.fechaacimiento = fechaacimiento;
		}

}
