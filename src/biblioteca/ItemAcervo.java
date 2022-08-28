package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

/** Classe abstrata que representa um item do acervo da biblioteca
 * São armazenados nela: o total de itens do acervo, o número do ID, título, editora,
 * se o item está ou não reservado e emprestado, os dados da reserva, caso esteja reservado,
 * bem como o valor da multa diária por atraso na devolução do item
 * @version 1.0
 * @since release 1
 * 
 */
public abstract class ItemAcervo implements Serializable{
	
    private static int totalItens;
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

    //---------------------------------------------------------------------//

    /** Método que realiza o registro de reserva do item, realizando a verificação
     * se o item já está reservado e/ou se o cliente já está com o item
     * 
     * @param c - Cliente que pretende reservar o item
     * @param data - LocalDate - data em que a reserva está sendo feito
     * @return true, caso a reserva seja efetuada; false, caso contrário.
     */
    public boolean registrarReserva(Cliente c, LocalDate data) {
            if(this.isReservado()) {
                    //System.out.println("O livro ja esta reservado");
                    return false;
            }
            
            for(Emprestimo e: c.getEmprestimos()) {
                if(e.getItem().getTitulo().equals(this.getTitulo()) && e.getDataDevolucao() == null)
                    throw new ClienteComPendenciaException("O cliente já está com este item");
            }
            
            this.setReserva(new Reserva(c, data));
            this.setReservado(true);

            return true;
    }

    /** Método abstrato que deve ser implementado pelas classes-filhas para retornar
     * o número de dias que o item pode ficar emprestado
     * 
     * @return int - número de dias que o item pode permanecer em empréstimo
     */
    public abstract int retornaDiasEmprestimo();

    /** Método que retorna o título do item.
     * 
     * @return titulo - String que representa o título do item
     */
    public String getTitulo() {
            return titulo;
    }

    /** Método que define o título do item
     * 
     * @param titulo - String
     */
    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }
    
    /** Método que retorna o ID do item
     * 
     * @return id - int - id do item
     */
    public int getId() {
            return id;
    }

    /** Método que define o id do item
     * 
     * @param id - id pretendido para o item
     */
    public void setId(int id) {
            this.id = id;
    }

    /** Método que retorna a editora do item
     * 
     * @return editora - String 
     */
    public String getEditora() {
            return editora;
    }

    /** Método que define a editora do item
     * 
     * @param editora - String
     */
    public void setEditora(String editora) {
            this.editora = editora;
    }

    /** Método que retorna o objeto da reserva do item
     * 
     * @return Reserva
     */
    public Reserva getReserva() {
            return reserva;
    }

    /** Método que define o objeto Reserva do item
     * 
     * @param reserva - objeto da classe Reserva
     */
    public void setReserva(Reserva reserva) {
            this.reserva = reserva;
    }

    /** Método que retorna o valor da multa diária por atraso na devolução do item
     * 
     * @return multaDiaria - double
     */
    public double getMultaDiaria() {
            return multaDiaria;
    }
    
    /** Método que retorna se o item está disponível (não está emprestado) ou não
     * 
     * @return true, se disponível; false, caso contrário;
     */
    public boolean isDisponivel() {
            return disponivel;
    }

    /** Método que define se o item está disponível ou não
     * 
     * @param disponivel - boolean - true, se disponível; false, caso contrário;
     */
    public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
    }

    /** Método que retorna se o item está reservado ou não
     * 
     * @return reservado - boolean - true, se sim; false, caso contrário.
     */
    public boolean isReservado() {
            return reservado;
    }

    /** Método que define se o item está ou não reservado
     * 
     * @param reservado - boolean - true, se reservado; false, caso contrário
     */
    public void setReservado(boolean reservado) {
            this.reservado = reservado;
    }

    /** Método toString que retorna os dados do item
     * 
     * @return String - concatenação dos dados do item
     */
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
