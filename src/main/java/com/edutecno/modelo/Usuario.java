package com.edutecno.modelo;
import java.sql.Date;

public class Usuario {

	    private int id;
	    private String nombre;
	    private String correo;
	    private String contrasena;
	    private Date fechaNacimiento;
	    private int horoscopoId; 
	
	    
	    /**
		 * @param id
		 * @param nombre
		 * @param correo
		 * @param contrasena
		 * @param fechaNacimiento
		 */
		public Usuario(int id, String nombre, String correo, String contrasena, Date fechaNacimiento) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.correo = correo;
			this.contrasena = contrasena;
			this.fechaNacimiento = fechaNacimiento;
		}
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
		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(Date fechaacimiento) {
			this.fechaNacimiento = fechaacimiento;
		}
		/**
		 * @return the horoscopoId
		 */
		public int getHoroscopoId() {
			return horoscopoId;
		}
		/**
		 * @param horoscopoId the horoscopoId to set
		 */
		public void setHoroscopoId(int horoscopoId) {
			this.horoscopoId = horoscopoId;
		}

}
