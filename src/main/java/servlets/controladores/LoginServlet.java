package servlets.controladores;

import java.io.IOException;

import servlets.dal.DaoUsuario;
import servlets.dal.DaoUsuarioMemoria;
import servlets.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final DaoUsuario DAO = DaoUsuarioMemoria.getInstancia();
	private static final long serialVersionUID = 1587748451045724579L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuarioValidado = validarUsuario(email, password);
		
		if(usuarioValidado != null) {
			request.getSession().setAttribute("usuario", usuarioValidado);
			response.sendRedirect("admin/coches");
		} else {
			request.setAttribute("error", "Email o contraseña incorrectos");
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

	private Usuario validarUsuario(String email, String password) {
		
		Usuario usuarioEncontrado = DAO.obtenerPorEmail(email);
		
		if(usuarioEncontrado != null && password.equals(usuarioEncontrado.getPassword())) {
			
			return usuarioEncontrado;
		}
		
		return null;
	}

}
