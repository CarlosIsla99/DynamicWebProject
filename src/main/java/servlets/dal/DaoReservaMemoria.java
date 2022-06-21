package servlets.dal;

import java.time.LocalDateTime;
import java.util.TreeMap;

import servlets.modelos.Reserva;

public class DaoReservaMemoria implements DaoReserva {
	private static final TreeMap<Long, Reserva> reservas = new TreeMap<>();

	static {
		reservas.put(1L, new Reserva(1L, "Cliente", "cliente@gmail.com", LocalDateTime.of(2022, 06, 29, 20, 0), 2, "Esto es una reserva de un cliente"));
	}

	// SINGLETON
	private DaoReservaMemoria() {}

	private static final DaoReservaMemoria INSTANCIA = new DaoReservaMemoria();

	public static DaoReservaMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Reserva> obtenerTodos() {
		return reservas.values();
	}

	@Override
	public Reserva obtenerPorId(Long id) {
		return reservas.get(id);
	}

	@Override
	public void insertar(Reserva reserva) {
		Long id = reservas.size() > 0 ? reservas.lastKey() + 1L : 1L;
		reserva.setId(id);
		reservas.put(id, reserva);
	}

	@Override
	public void modificar(Reserva reserva) {
		reservas.put(reserva.getId(), reserva);
	}

	@Override
	public void borrar(Long id) {
		reservas.remove(id);
	}


}
