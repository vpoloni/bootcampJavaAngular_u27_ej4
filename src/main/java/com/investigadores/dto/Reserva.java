package com.investigadores.dto;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "investigador")
	Investigadores investigador;

	@ManyToOne
	@JoinColumn(name = "equipo")
	Equipos equipo;

	Timestamp comienzo;
	Timestamp fin;

	// constructores
	public Reserva() {

	}

	public Reserva(int id, Investigadores investigador, Equipos equipo, Timestamp comienzo, Timestamp fin) {

		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investigadores getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigadores investigador) {
		this.investigador = investigador;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public Timestamp getComienzo() {
		return comienzo;
	}

	public void setComienzo(Timestamp comienzo) {
		this.comienzo = comienzo;
	}

	public Timestamp getFin() {
		return fin;
	}

	public void setFin(Timestamp fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}
}
