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
import com.investigadores.dto.Facultad;
import com.investigadores.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServideImpl;

	// listar todos facultades
	@GetMapping("/facultad")
	public List<Facultad> listarFacultads() {
		return facultadServideImpl.listarFacultades();
	}

	// crear nueva facultad
	@PostMapping("/facultad")
	public Facultad crearFacultad(@RequestBody Facultad facultad) {
		return facultadServideImpl.guardarFacultad(facultad);
	}

	// listar facultad por id
	@GetMapping("/facultad/{id}")
	public Facultad listarFacultadXID(@PathVariable(name = "id") int id) {

		Facultad facultadPorId = new Facultad();
		facultadPorId = facultadServideImpl.listarFacultadXID(id);
		return facultadPorId;
	}

	// actualizar facultad
	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name = "id") int id, @RequestBody Facultad facultad) {

		Facultad facultadSeleccionada = new Facultad();
		Facultad facultadActualizada = new Facultad();

		// obtenemos facultad de la DB
		facultadSeleccionada = facultadServideImpl.listarFacultadXID(id);

		// seteamos nuevos valores
		facultadSeleccionada.setNombre(facultad.getNombre());

		// actualizamos facultad en la DB
		facultadActualizada = facultadServideImpl.actualizarFacultad(facultadSeleccionada);

		return facultadActualizada;
	}

	// eliminamos almacén por id
	@DeleteMapping("/facultad/{id}")
	public void eliminarFacultad(@PathVariable(name = "id") int id) {
		facultadServideImpl.eliminarFacultad(id);
	}

}
