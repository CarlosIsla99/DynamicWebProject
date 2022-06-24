package servlets.dal;

import servlets.modelos.Coche;

class DaoCocheExcepcion implements DaoCoche {

	@Override
	public Iterable<Coche> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coche obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Coche objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Coche objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean obtenerReservadoPorId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFalseWhenNoReserva(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrueReserva(Long id) {
		// TODO Auto-generated method stub
		
	}


}
