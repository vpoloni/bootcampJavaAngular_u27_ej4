package com.investigadores.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.investigadores.dto.Equipos;
import com.investigadores.service.EquiposServiceImpl;

@RestController
@RequestMapping("/api")
public class EquiposController {

	@Autowired
	EquiposServiceImpl equiposServideImpl;

	@GetMapping("/equipos")
	public List<Equipos> listarEquipos() {
		return equiposServideImpl.listarEquipos();
	}

	@PostMapping("/equipos")
	public Equipos crearEquipo(@RequestBody Equipos equipos) {
		return equiposServideImpl.guardarEquipo(equipos);
	}

	@GetMapping("/equipos/{id}")
	public Equipos listarEquipoXID(@PathVariable(name = "id") String id) {

		Equipos equiposPorId = new Equipos();
		equiposPorId = equiposServideImpl.listarEquipoXID(id);
		return equiposPorId;
	}

	@PutMapping("/equipos/{id}")
	public Equipos actualizarEquipos(@PathVariable(name = "id") String id, @RequestBody Equipos equipos) {

		Equipos equiposSeleccionado = new Equipos();
		Equipos equiposActualizado = new Equipos();

		equiposSeleccionado = equiposServideImpl.listarEquipoXID(id);

		equiposSeleccionado.setId(equipos.getId());
		equiposSeleccionado.setNombre(equipos.getNombre());
		equiposSeleccionado.setFacultad(equipos.getFacultad());

		equiposActualizado = equiposServideImpl.actualizarEquipo(equiposSeleccionado);

		return equiposActualizado;
	}

	@DeleteMapping("/equipos/{id}")
	public void eliminarEquipos(@PathVariable(name = "id") String id) {
		equiposServideImpl.eliminarEquipo(id);
	}

}
