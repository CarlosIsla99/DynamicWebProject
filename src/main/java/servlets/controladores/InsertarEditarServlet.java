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

@WebServlet("/insertarEditar")
public class InsertarEditarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final DaoCoche DAO = DaoCocheMemoria.getInstancia();
	
    public InsertarEditarServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		int potencia = Integer.parseInt(request.getParameter("potencia"));
		int cilindrada = Integer.parseInt(request.getParameter("cilindrada"));
		
		Coche coche = new Coche(null, matricula, marca, modelo, color, potencia, cilindrada);
		
		if(id == null || id.trim().length() == 0) {
			DAO.insertar(coche);
		} else {
			coche.setId(Long.parseLong(id));
			DAO.modificar(coche);
		}
		
		response.sendRedirect(request.getContextPath() + "/coches");
		
	}

}
