package com.investigadores.service;

import java.util.List;
import com.investigadores.dto.Reserva;

public interface IReservaService {

	public List<Reserva> listarReserva();

	public Reserva guardarReserva(Reserva reserva);

	public Reserva listarReservaXID(int id);

	public Reserva actualizarReserva(Reserva reserva);

	public void eliminarReserva(int id);

}
