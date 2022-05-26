package com.investigadores.service;

import java.util.List;
import com.investigadores.dto.Equipos;

public interface IEquiposService {

	public List<Equipos> listarEquipos();

	public Equipos guardarEquipo(Equipos equipos);

	public Equipos listarEquipoXID(String id);

	public Equipos actualizarEquipo(Equipos equipos);

	public void eliminarEquipo(String id);

}
