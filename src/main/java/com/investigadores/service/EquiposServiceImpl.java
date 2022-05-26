package com.investigadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investigadores.dao.IEquiposDAO;
import com.investigadores.dto.Equipos;

@Service
public class EquiposServiceImpl implements IEquiposService {

	@Autowired
	IEquiposDAO iEquiposDAO;

	@Override
	public List<Equipos> listarEquipos() {
		return iEquiposDAO.findAll();
	}

	@Override
	public Equipos guardarEquipo(Equipos equipos) {
		return iEquiposDAO.save(equipos);
	}

	@Override
	public Equipos listarEquipoXID(String id) {
		return iEquiposDAO.findById(id).get();
	}

	@Override
	public Equipos actualizarEquipo(Equipos equipos) {
		return iEquiposDAO.save(equipos);
	}

	@Override
	public void eliminarEquipo(String id) {
		iEquiposDAO.deleteById(id);

	}

}
