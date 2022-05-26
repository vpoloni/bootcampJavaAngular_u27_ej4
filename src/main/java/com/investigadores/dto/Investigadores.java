package com.investigadores.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "investigadores")
public class Investigadores {

	// atributos
	@Id
	private String id;
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "facultad")
	Facultad facultad;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Reserva> reserva;

	// constructores
	public Investigadores() {

	}

	public Investigadores(String id, String nombre, Facultad facultad, List<Reserva> reserva) {

		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	// getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	// método toString
	@Override
	public String toString() {
		return "Investigadores [id=" + id + ", nombre=" + nombre + "]";
	}

}
