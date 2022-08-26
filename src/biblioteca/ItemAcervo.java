package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class ItemAcervo implements Serializable{
	
    private static int totalItens = 0;
    private int id;
    private String titulo;
    private String editora;
    private boolean reservado;
    private boolean disponivel;
    private Reserva reserva;
    private double multaDiaria = (double) 0.50; //Pensar em uma melhor forma de armazenar

    public ItemAcervo() {

    }

    public ItemAcervo(String titulo, String editora) {
            setDisponivel(true);
            setReservado(false);
            totalItens++;
            this.id = totalItens;
            this.titulo = titulo;
            this.setEditora(editora);
    }

    /**************************************************************************************************/

    public boolean registrarReserva(Cliente c, LocalDate data) {
            if(this.isReservado()) {
                    //System.out.println("O livro ja esta reservado");
                    return false;
            }
            
            for(Emprestimo e: c.getEmprestimosAtuais()) {
                if(e.getItem().equals(this))
                    throw new ClienteComPendenciaException("O cliente já está com este item");
            }
            
            this.setReserva(new Reserva(c, data));
            this.setReservado(true);

            return true;
    }

    public abstract int retornaDiasEmprestimo();

    public String getTitulo() {
            return titulo;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getEditora() {
            return editora;
    }

    public void setEditora(String editora) {
            this.editora = editora;
    }

    public Reserva getReserva() {
            return reserva;
    }

    public void setReserva(Reserva reserva) {
            this.reserva = reserva;
    }

    public double getMultaDiaria() {
            return multaDiaria;
    }

    public boolean isDisponivel() {
            return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
    }

    public boolean isReservado() {
            return reservado;
    }

    public void setReservado(boolean reservado) {
            this.reservado = reservado;
    }

    @Override
    public String toString() {
            return "Item:" +
                            "ID: " + id +
                            ", Titulo: '" + titulo + '\'' +
                            ", Editora: '" + editora + '\'' +
                            ", Reservado: " + reservado +
                            ", Disponivel: " + disponivel +
                            ", Reserva: " + reserva +
                            ", Multa diaria: " + multaDiaria;
    }
}
