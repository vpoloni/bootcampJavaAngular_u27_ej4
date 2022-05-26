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
import com.investigadores.dto.Reserva;
import com.investigadores.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServideImpl;

	@GetMapping("/reserva")
	public List<Reserva> listarReserva() {
		return reservaServideImpl.listarReserva();
	}

	@PostMapping("/reserva")
	public Reserva crearEquipo(@RequestBody Reserva reserva) {
		return reservaServideImpl.guardarReserva(reserva);
	}

	@GetMapping("/reserva/{id}")
	public Reserva listarEquipoXID(@PathVariable(name = "id") int id) {

		Reserva reservaPorId = new Reserva();
		reservaPorId = reservaServideImpl.listarReservaXID(id);
		return reservaPorId;
	}

	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") int id, @RequestBody Reserva reserva) {

		Reserva reservaSeleccionada = new Reserva();
		Reserva reservaActualizada = new Reserva();

		reservaSeleccionada = reservaServideImpl.listarReservaXID(id);

		reservaSeleccionada.setComienzo(reserva.getComienzo());
		reservaSeleccionada.setFin(reserva.getFin());
		reservaSeleccionada.setInvestigador(reserva.getInvestigador());
		reservaSeleccionada.setEquipo(reserva.getEquipo());
		
		reservaActualizada = reservaServideImpl.actualizarReserva(reservaSeleccionada);

		return reservaActualizada;
	}

	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable(name = "id") int id) {
		reservaServideImpl.eliminarReserva(id);
	}

}
