package com.investigadores.service;

import java.util.List;

import com.investigadores.dto.Investigadores;

public interface IInvestigadoresService {
	
	// READ todos investigadoreses
	public List<Investigadores> listarInvestigadores();

	// CREATE nuevo investigador
	public Investigadores guardarInvestigador(Investigadores investigadores);

	// READ investigador por id
	public Investigadores listarInvestigadorXID(String id);

	// UPDATE investigador
	public Investigadores actualizarInvestigador(Investigadores investigadores);

	// DELETE investigador
	public void eliminarInvestigadores(String id);

}
