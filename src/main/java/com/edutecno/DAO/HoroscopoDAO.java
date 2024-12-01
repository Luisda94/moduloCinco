package com.edutecno.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.ConexionDB;

public class HoroscopoDAO {
	 private Connection conn;

	    public HoroscopoDAO() {
    conn = ConexionDB.getConexion();
}

public List<Horoscopo> obtenerHoroscopo() throws SQLException {
    List<Horoscopo> lista = new ArrayList<>();
    String query = "SELECT * FROM public.horoscopo";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);

    while (rs.next()) {
        Horoscopo horoscopo = new Horoscopo();
        horoscopo.setSigno(rs.getString("animal"));
        horoscopo.setFechaInicio(rs.getDate("fecha_inicio"));
        horoscopo.setFechaFin(rs.getDate("fecha_fin"));
        lista.add(horoscopo);
    }

    return lista;
}
}
