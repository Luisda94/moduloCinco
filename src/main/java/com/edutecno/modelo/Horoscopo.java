package com.edutecno.modelo;

import java.sql.Date;

public class Horoscopo {
    private int id;
    private String signo;
    public void setId(int id) {
		this.id = id;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	private Date fechaInicio;
    private Date fechaFin;
	public int getId() {
		return id;
	}
	public String getSigno() {
		return signo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}

}
