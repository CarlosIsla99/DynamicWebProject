package servlets.dal;

// El objetivo de esta f�brica es crear objetos de DAOs espec�ficos (memoria, mysql, oracle)
// Tendr� m�todos getDaoEntidad()
public class DaoFabrica {
	private DaoUsuario daoUsuario;
	
	// Esta f�brica concretamente genera s�lo un objeto de DAO por cada entidad
	// Con ello est� creando el objeto como si fuera un Singleton
	public DaoFabrica(String tipoDao) {
		switch(tipoDao) {
		case "memoria":
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			break;
		case "excepcion":
			daoUsuario = new DaoUsuarioExcepcion();
			break;
		default:
			throw new DalException("No conozco ese tipo " + tipoDao);
		}
	}
	
	// Como no se hace un new en cada get, siempre devuelve el mismo objeto
	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
}
