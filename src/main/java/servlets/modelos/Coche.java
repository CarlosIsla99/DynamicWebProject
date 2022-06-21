package servlets.modelos;

import java.util.Objects;

import servlets.bibliotecas.Validaciones;
import servlets.dal.DaoException;

public class Coche {
	
	Long id;
	String matricula;
	String marca;
	String modelo;
	String color;
	int potencia;
	int cilindrada;
	
	public Coche() {
		super();
	}

	public Coche(Long id, String matricula, String marca, String modelo, String color, int potencia, int cilindrada) {
		setId(id);
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setColor(color);
		setPotencia(potencia);
		setCilindrada(cilindrada);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (!Validaciones.validarMatricula(matricula)) {
			throw new DaoException("Matrícula no válida");
		}
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca == null || marca.trim().length() < 3 || marca.matches(".*\\d.*")) {
			throw new DaoException("La marca debe tener al menos 3 letras");
		}
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo == null || modelo.trim().length() == 0) {
			throw new DaoException("El modelo no puede estar vacío");
		}
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color == null || color.trim().length() == 0) {
			throw new DaoException("Debes elegir un color");
		}
		this.color = color;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		if(potencia <= 0) {
			throw new DaoException("Introduce una potencia mayor que 0");
		}
		this.potencia = potencia;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		if(cilindrada <= 0) {
			throw new DaoException("Introduce una cilindrada mayor que 0");
		}
		this.cilindrada = cilindrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cilindrada, color, id, marca, matricula, modelo, potencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return cilindrada == other.cilindrada && Objects.equals(color, other.color) && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(modelo, other.modelo) && potencia == other.potencia;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + ", potencia=" + potencia + ", cilindrada=" + cilindrada + "]";
	}
	
	

}
