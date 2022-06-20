package servlets.controladores;

import java.io.IOException;
import java.util.Properties;

import servlets.dal.DalException;
import servlets.dal.DaoCoche;
import servlets.dal.DaoFabrica;

public class Globales {
	
	static final DaoCoche DAO;
	private static final String CONFIGURACION = "configuracion.properties"; 
	
	static {
		try {
			Properties props = new Properties();
			props.load(Globales.class.getClassLoader().getResourceAsStream(CONFIGURACION));
			
			String tipo = props.getProperty("dal.tipodao");
			
			DAO = new DaoFabrica(tipo).getDaoCoche();
		} catch (IOException e) {
			throw new DalException("No se ha podido obtener la configuración");
		}
	}
}
