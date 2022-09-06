package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

/** Classe que representa uma reserva da biblioteca, que armazena: a data da reserva e
 * o cliente que a realizou.
 * 
 * 
 * @since release 1
 * @version 1.0
 * 
 */
public class Reserva implements Publicavel, Serializable{
	private LocalDate dataReserva;
	private Cliente cliente;
	
        /** Construtor que recebe parâmetros e realiza as respectivas atribuições
         * 
         * @param cliente - Cliente
         * @param dataReserva - LocalDate
         */
	public Reserva(Cliente cliente, LocalDate dataReserva) {
		this.cliente = cliente;
		this.dataReserva = dataReserva; // ver como vai pegar e guardar data
	}

	//---------------------------------------------------------------------//

        /** Método que retorna a data da reserva
         * 
         * @return dataReserva - LocalDate
         */
	public LocalDate getDataReserva() {
		return dataReserva;
	}

        /** Método que permite atribuir um valor à data da reserva
         * 
         * @param dataReserva - LocalDate
         */
	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

        /** Método que retorna o cliente da reserva
         * 
         * @return cliente - Cliente
         */
	public Cliente getCliente() {
		return cliente;
	}

        /** Método que permite atribuir um cliente à reserva
         * 
         * @param cliente - Cliente
         */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

        /** Método que retorna os dados da Reserva
         * 
         * @return String
         */
	@Override
	public String retornaDados() {
		// TODO Auto-generated method stub
		return "Reserva: \n" +
				"Data: " + dataReserva +
				", Cliente: " + cliente;
	}
}

