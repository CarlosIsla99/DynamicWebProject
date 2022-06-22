package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dal.DaoReserva;
import servlets.dal.DaoReservaMemoria;
import servlets.modelos.Reserva;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/admin/reservaFormulario")
public class ReservaFormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoReserva DAO = DaoReservaMemoria.getInstancia();

    public ReservaFormServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String accion = "Realizar";
		
		if (id != null) {
			Reserva reserva = DAO.obtenerPorId(Long.parseLong(id));
			accion = "Modificar";
			
			request.setAttribute("reserva", reserva);
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/vistas/reservaFormulario.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		LocalDateTime datetime = LocalDateTime.parse(request.getParameter("datetime"));
		int numPersonas = Integer.parseInt(request.getParameter("numPersonas"));
		String comentario = request.getParameter("comentario");
		
		if(comentario.length() == 0 || comentario == null) {
			comentario = "'Sin comentario'";
		}
		
		String accion = "";
		
		Reserva reserva = new Reserva(null, nombre, email, datetime, numPersonas, comentario);
		
		if(reserva.getErrores().size() > 0) {
			request.setAttribute("alertatexto", "No se ha podido realizar la reserva. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			
			request.setAttribute("reserva", reserva);
			
			request.getRequestDispatcher("/WEB-INF/vistas/reservaFormulario.jsp").forward(request, response);
			return;
		}

		try {
			if(id == null || id.trim().length() == 0) {
				DAO.insertar(reserva);
				accion = "realizada";
			} else {
				reserva.setId(Long.parseLong(id));
				DAO.modificar(reserva);
				accion = "modificada";
			}
			
			request.setAttribute("alertatexto", "Reserva " + accion + " correctamente");
			request.setAttribute("alertanivel", "success");
			
		} catch (Exception e) {
			request.setAttribute("alertatexto", "La reserva no ha podido ser " + accion);
			request.setAttribute("alertanivel", "danger");
		}
			
		request.getRequestDispatcher("/admin/misReservas").forward(request, response);
		
	}

}
