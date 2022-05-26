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
import com.investigadores.dto.Investigadores;
import com.investigadores.service.InvestigadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadoresController {

	@Autowired
	InvestigadoresServiceImpl investigadoresServideImpl;

	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores() {
		return investigadoresServideImpl.listarInvestigadores();
	}

	@PostMapping("/investigadores")
	public Investigadores crearInvestigador(@RequestBody Investigadores investigadores) {
		return investigadoresServideImpl.guardarInvestigador(investigadores);
	}

	@GetMapping("/investigadores/{id}")
	public Investigadores listarInvestigadorXID(@PathVariable(name = "id") String id) {

		Investigadores investigadoresPorId = new Investigadores();
		investigadoresPorId = investigadoresServideImpl.listarInvestigadorXID(id);
		return investigadoresPorId;
	}

	@PutMapping("/investigadores/{id}")
	public Investigadores actualizarInvestigadores(@PathVariable(name = "id") String id,
			@RequestBody Investigadores investigadores) {

		Investigadores investigadoresSeleccionado = new Investigadores();
		Investigadores investigadoresActualizado = new Investigadores();

		investigadoresSeleccionado = investigadoresServideImpl.listarInvestigadorXID(id);

		investigadoresSeleccionado.setId(investigadores.getId());
		investigadoresSeleccionado.setNombre(investigadores.getNombre());
		investigadoresSeleccionado.setFacultad(investigadores.getFacultad());

		investigadoresActualizado = investigadoresServideImpl.actualizarInvestigador(investigadoresSeleccionado);

		return investigadoresActualizado;
	}

	@DeleteMapping("/investigadoreses/{id}")
	public void eliminarInvestigadores(@PathVariable(name = "id") String id) {
		investigadoresServideImpl.eliminarInvestigadores(id);
	}

}
