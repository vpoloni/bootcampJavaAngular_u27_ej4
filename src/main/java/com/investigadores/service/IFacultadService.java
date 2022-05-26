package com.investigadores.service;

import java.util.List;

import com.investigadores.dto.Facultad;

public interface IFacultadService {
	
	// READ todas facultades
	public List<Facultad> listarFacultades();

	// CREATE nueva facultad
	public Facultad guardarFacultad(Facultad facultad);

	// READ facultad por id
	public Facultad listarFacultadXID(int id);

	// UPDATE facultad
	public Facultad actualizarFacultad(Facultad facultad);

	// DELETE facultad
	public void eliminarFacultad(int id);

}
