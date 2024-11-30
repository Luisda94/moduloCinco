package com.edutecno.modelo;

import java.sql.Date;

public class Horoscopo {
    private int id;
    private String signo;
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
