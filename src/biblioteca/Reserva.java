package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Publicavel, Serializable{
	private LocalDate dataReserva;
	private Cliente cliente;
	
	public Reserva(Cliente cliente, LocalDate dataReserva) {
		this.cliente = cliente;
		this.dataReserva = dataReserva; // ver como vai pegar e guardar data
	}

	//**************************************************************************************************//

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String retornaDados() {
		// TODO Auto-generated method stub
		return "Reserva: \n" +
				"Data: " + dataReserva +
				", Cliente: " + cliente;
	}
}

