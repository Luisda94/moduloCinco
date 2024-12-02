package com.edutecno.DAO;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAO {
    private final Connection conn;

    public HoroscopoDAO() throws SQLException {
        this.conn = ConexionDB.getConexion();
    }

    public List<Horoscopo> obtenerHoroscopos() throws SQLException {
        List<Horoscopo> lista = new ArrayList<>();
        String query = "SELECT * FROM public.horoscopo";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Horoscopo horoscopo = new Horoscopo();
                horoscopo.setId(rs.getInt("id"));
                horoscopo.setSigno(rs.getString("signo"));
                horoscopo.setFechaInicio(rs.getDate("fecha_inicio"));
                horoscopo.setFechaFin(rs.getDate("fecha_final"));
                lista.add(horoscopo);
            }
        }
        return lista;
    }
}
