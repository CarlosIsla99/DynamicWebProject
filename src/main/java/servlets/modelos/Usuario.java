package servlets.modelos;

import java.util.Objects;

public class Usuario {
	public enum Roles {ADMIN, CLIENTE};
	
	private Long id;
	private String email;
	private String password;
	private String telefono;
	private Roles rol;
	
	public Usuario(Long id, String email, String password, String telefono, Roles rol) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setTelefono(telefono);
		setRol(rol);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, rol, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && rol == other.rol
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", telefono=" + telefono + ", rol="
				+ rol + "]";
	}

}
