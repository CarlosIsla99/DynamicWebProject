package servlets.dal;

import java.util.TreeMap;

import servlets.modelos.*;

public class DaoCocheMemoria implements DaoCoche {
	
	private static final TreeMap<Long, Coche> coches = new TreeMap<>();
	
	static {
		coches.put(1L, new Coche(1L, "1263GGF", "Audi", "R8", "Gris", 570, 4163));
		coches.put(2L, new Coche(2L, "2314TSR", "BMW","I8", "Blanco", 231, 1497));
		coches.put(3L, new Coche(3L, "9637SHV", "Mercedes", "C180", "Negro", 156, 1595));
	}
	
	private DaoCocheMemoria() {
	}

	private static final DaoCocheMemoria INSTANCIA = new DaoCocheMemoria();

	public static DaoCocheMemoria getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Coche> obtenerTodos() {
		return coches.values();
	}
	
	@Override
	public Coche obtenerPorId(Long id) {
		return coches.get(id);
	}

	@Override
	public void insertar(Coche coche) {
		Long id = coches.size() > 0 ? coches.lastKey() + 1L : 1L;
		coche.setId(id);
		coches.put(coche.getId(), coche);
	}

	@Override
	public void modificar(Coche coche) {
		coches.put(coche.getId(), coche);
	}

	@Override
	public void borrar(Long id) {
		coches.remove(id);	
	}

}
