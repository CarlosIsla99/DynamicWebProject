package servlets.dal;

public class DaoFabrica {
	private DaoCoche daoCoche;
	private DaoReserva daoReserva;
	private DaoUsuario daoUsuario;
	
	public DaoFabrica(String tipoDao) {
		switch(tipoDao) {
		case "memoria":
			daoCoche = DaoCocheMemoria.getInstancia();
			daoReserva = DaoReservaMemoria.getInstancia();
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			break;
		case "excepcion":
			daoCoche = new DaoCocheExcepcion();
			daoReserva = new DaoReservaExcepcion();
			daoUsuario = new DaoUsuarioExcepcion();
			break;
		default:
			throw new DaoException("No conozco ese tipo " + tipoDao);
		}
	}
	
	public DaoCoche getDaoCoche() {
		return daoCoche;
	}
	
	public DaoReserva getDaoReserva() {
		return daoReserva;
	}
	
	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
}
