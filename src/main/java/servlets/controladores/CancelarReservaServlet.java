package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dal.DaoReserva;
import servlets.dal.DaoReservaMemoria;

import java.io.IOException;

@WebServlet("/admin/borrarReserva")
public class CancelarReservaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoReserva DAO = DaoReservaMemoria.getInstancia();

    public CancelarReservaServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		DAO.borrar(id);
		
		request.setAttribute("alertatexto", "Se ha cancelado la reserva");
		request.setAttribute("alertanivel", "success");
		
		request.getRequestDispatcher("/admin/misReservas").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
