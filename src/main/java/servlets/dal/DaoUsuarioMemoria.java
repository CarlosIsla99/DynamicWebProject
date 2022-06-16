package servlets.dal;

import java.util.TreeMap;

import servlets.modelos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {
	private static final TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "javier@gmail.com", "admin"));
		usuarios.put(2L, new Usuario(2L, "isla.carlos.99@gmail.com", "1411"));
		usuarios.put(3L, new Usuario(3L, "juan@gmail.com", "contra"));
	}

	// SINGLETON
	private DaoUsuarioMemoria() {
	}

	private static final DaoUsuarioMemoria INSTANCIA = new DaoUsuarioMemoria();

	public static DaoUsuarioMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public void insertar(Usuario usuario) {
		Long id = usuarios.size() > 0 ? usuarios.lastKey() + 1L : 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void borrar(Long id) {
		usuarios.remove(id);
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
//		for(Usuario usuario: usuarios.values()) {
//			if(usuario.getEmail().equals(email)) {
//				return usuario;
//			}
//		}
//		
//		return null;

		return usuarios.values().parallelStream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
	}
}
