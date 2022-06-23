package servlets.controladores;

import java.io.IOException;

import servlets.dal.DaoUsuario;
import servlets.dal.DaoUsuarioMemoria;
import servlets.modelos.Usuario;
import servlets.modelos.Usuario.Roles;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final DaoUsuario DAO = DaoUsuarioMemoria.getInstancia();
	private static final long serialVersionUID = 1587748451045724579L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String contra1 = request.getParameter("contra1");
		String contra2 = request.getParameter("contra2");
		String tel = request.getParameter("tel");
		
		Usuario usuario = new Usuario(null, email, contra1, tel, Roles.CLIENTE);
		
		if(usuario.getErrores().size() > 0 || (contra1.equals(contra2)) == false) {
			request.setAttribute("alertatexto", "No se ha podido registrar. Revise los datos.");
			request.setAttribute("alertanivel", "danger");			
			request.setAttribute("usuario", usuario);
			
			request.setAttribute("error", "Las contraseñas no coinciden");
			
			request.getRequestDispatcher("/WEB-INF/vistas/register.jsp").forward(request, response);
			return;
		}
		
		DAO.insertar(usuario);
		response.sendRedirect("login");

	}

}
