package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dal.DaoReserva;
import servlets.dal.DaoReservaMemoria;

import java.io.IOException;

@WebServlet("/admin/misReservas")
public class ReservasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoReserva DAO = DaoReservaMemoria.getInstancia();

    public ReservasServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("reservas", DAO.obtenerTodos());	
		request.getRequestDispatcher("/WEB-INF/vistas/reservas.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
