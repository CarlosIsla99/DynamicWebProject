package servlets.modelos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
	
	private Long id;
	private String nombre;
	private String email;
	private LocalDateTime fechaHora;
	private Integer numeroPersonas;
	private String comentario;
	
	public Reserva(Long id, String nombre, String email, LocalDateTime fechaHora, Integer numeroPersonas,
			String comentario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.fechaHora = fechaHora;
		this.numeroPersonas = numeroPersonas;
		this.comentario = comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentario, email, fechaHora, id, nombre, numeroPersonas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(comentario, other.comentario) && Objects.equals(email, other.email)
				&& Objects.equals(fechaHora, other.fechaHora) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numeroPersonas, other.numeroPersonas);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", nombre=" + nombre + ", email=" + email + ", fechaHora=" + fechaHora
				+ ", numeroPersonas=" + numeroPersonas + ", comentario=" + comentario + "]";
	}
	
	
	


}
