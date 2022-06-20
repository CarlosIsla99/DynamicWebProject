package servlets.dal;

// El objetivo de esta fábrica es crear objetos de DAOs específicos (memoria, mysql, oracle)
// Tendrá métodos getDaoEntidad()
public class DaoFabrica {
	private DaoCoche daoCoche;
	
	// Esta fábrica concretamente genera sólo un objeto de DAO por cada entidad
	// Con ello está creando el objeto como si fuera un Singleton
	public DaoFabrica(String tipoDao) {
		switch(tipoDao) {
		case "memoria":
			daoCoche = DaoCocheMemoria.getInstancia();
			break;
	//	case "excepcion":
	//		daoCoche = new DaoCocheExcepcion();
	//		break;
		default:
			throw new DalException("No conozco ese tipo " + tipoDao);
		}
	}
	
	// Como no se hace un new en cada get, siempre devuelve el mismo objeto
	public DaoCoche getDaoCoche() {
		return daoCoche;
	}
}
