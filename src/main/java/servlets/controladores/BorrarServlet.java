package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.dal.DaoCoche;
import servlets.dal.DaoCocheMemoria;

import java.io.IOException;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoCoche DAO = DaoCocheMemoria.getInstancia();

    public BorrarServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		DAO.borrar(id);
		
		response.sendRedirect(request.getContextPath() + "/coches");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
