package servlets.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.modelos.Coche;

import java.io.IOException;

@WebServlet("/admin/formulario")
public class ReservaFormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ReservaFormServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Coche coche = Globales.DAO.obtenerPorId(Long.parseLong(id));
		request.setAttribute("coche", coche);

		request.getRequestDispatcher("/WEB-INF/vistas/reservaFormulario.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		int potencia = Integer.parseInt(request.getParameter("potencia"));
		int cilindrada = Integer.parseInt(request.getParameter("cilindrada"));
		
		String accion = "";
		
		Coche coche = new Coche(null, matricula, marca, modelo, color, potencia, cilindrada);
		
		try {
			if(id == null || id.trim().length() == 0) {
				Globales.DAO.insertar(coche);
				accion = "añadido";
			} else {
				coche.setId(Long.parseLong(id));
				Globales.DAO.modificar(coche);
				accion = "modificado";
			}
			
			request.setAttribute("alertatexto", "Se ha " + accion + " el registro correctamente");
			request.setAttribute("alertanivel", "success");
			
		} catch (Exception e) {
			request.setAttribute("alertatexto", "La opción de " + accion + " no ha funcionado");
			request.setAttribute("alertanivel", "danger");
		}
			
		request.getRequestDispatcher("/admin/coches").forward(request, response);
		
	}

}
