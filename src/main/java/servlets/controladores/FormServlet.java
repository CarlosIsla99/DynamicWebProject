package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dal.DaoCoche;
import servlets.dal.DaoCocheMemoria;
import servlets.modelos.Coche;

import java.io.IOException;

@WebServlet("/formulario")
public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoCoche DAO = DaoCocheMemoria.getInstancia();

    public FormServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String accion = "Añadir";
		
		if (id != null) {
			Coche coche = DAO.obtenerPorId(Long.parseLong(id));
			accion = "Editar";
			
			request.setAttribute("coche", coche);
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
