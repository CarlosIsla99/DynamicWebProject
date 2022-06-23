package servlets.dal;

import servlets.modelos.*;

public interface DaoCoche extends Dao<Coche> {
	boolean obtenerReservadoPorId(Long id);
}
