package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dal.DaoCoche;
import servlets.dal.DaoCocheMemoria;

import java.io.IOException;

@WebServlet("/coches")
public class CochesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoCoche DAO = DaoCocheMemoria.getInstancia();

    public CochesServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("coches", DAO.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/coches.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
