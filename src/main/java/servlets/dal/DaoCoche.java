package servlets.dal;

import servlets.modelos.*;

public interface DaoCoche extends Dao<Coche> {
	
	boolean obtenerReservadoPorId(Long id);
	
	void setFalseWhenNoReserva(Long id);
	
	void setTrueReserva(Long id);
}
