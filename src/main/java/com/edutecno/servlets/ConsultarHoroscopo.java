package com.edutecno.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.edutecno.DAO.HoroscopoDAO;
import com.edutecno.modelo.Horoscopo;

@WebServlet("/ConsultarHoroscopo")
public class ConsultarHoroscopo extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4141111051640448515L;
	/**
	 * 
	 */
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("usuario");

        // Verificar que el usuario esté autenticado
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String fechaNacimiento = request.getParameter("fechaNacimiento");

        // Obtener la lista de horóscopos
        HoroscopoDAO horoscopoDAO = new HoroscopoDAO();
        List<Horoscopo> listaHoroscopo = horoscopoDAO.obtenerHoroscopo();
        

        // Calcular el signo según la fecha
        String signo = calcularSigno(fechaNacimiento, listaHoroscopo);

        request.setAttribute("horoscopo", signo);
        request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
    }

    private String calcularSigno(String fechaNacimiento, List<Horoscopo> listaHoroscopo) {
        // Simulación del cálculo de signo (reemplazar con lógica real)
        for (Horoscopo h : listaHoroscopo) {
            if (h.getFechaInicio().before(java.sql.Date.valueOf(fechaNacimiento)) &&
                h.getFechaFin().after(java.sql.Date.valueOf(fechaNacimiento))) {
                return h.getSigno();
            }
        }
        return "Signo no encontrado";
    }
}
