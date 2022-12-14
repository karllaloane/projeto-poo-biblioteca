package biblioteca;

import exceptions.ItemIndisponivelException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/** Classe que representa um empréstimo, que armazena o número máximo de renovações,
 * a quantidade de vezes que um empréstimo foi renovado, o total de empréstimos realizados; 
 * o ID, o valor da multa por atraso, se a multa foi paga e se o empréstimo gerou multa;
 * a data do empréstimo, a data prevista de devolução e a data em que esta efetivamento ocorreu;
 * o cliente que realizou o empréstimo e o item objeto do empréstimo.
 * @version 1.0
 * @since release 1
 * 
 */
public class Emprestimo implements Publicavel, Serializable{
	
    private static int maxRenovacao = 3;
    private int quantRenovado = 0;

    private double valorMulta;
    private boolean multaPaga;
    private boolean estaMultado;
    
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista; //manter ou deixar apenas dataDevolucao
    private LocalDate dataDevolucao;

    private Cliente cliente;
    private ItemAcervo item;

    /** Construtor que recebe parâmetros e realiza a atribuição correlata
     * 
     * @param cliente
     * @param item
     * @param dataEmprestimo 
     */
    public Emprestimo(Cliente cliente, ItemAcervo item, LocalDate dataEmprestimo) {

            this.quantRenovado = 0;
            this.cliente = cliente;
            this.item = item;
            this.item.setDisponivel(false);
            this.dataEmprestimo = dataEmprestimo;
            dataDevolucaoPrevista = this.dataEmprestimo.plusDays(item.retornaDiasEmprestimo());
            setMultaPaga(true);
            setEstaMultado(false);
    }

    /** Método que calcula o valor da multa devida pelo atraso na devolução do item
     * 
     * @return double - valor da multa
     */
    public double calcularMulta() {

            this.valorMulta = this.item.getMultaDiaria() * this.dataDevolucaoPrevista.until(dataDevolucao, ChronoUnit.DAYS);

            if(valorMulta > 0) {
                    setMultaPaga(false);
                    setEstaMultado(true);
            } else {
                this.valorMulta = 0;
            }

            return this.valorMulta;
    }

    /** Método para renovar o empréstimo
     * 
     * @param data - LocalDate que indica a data da renovação
     * @return true, se a renovação deu certo; false, caso contrário.
     */
    public boolean renovar(LocalDate data) {
        
        if(this.dataDevolucaoPrevista.isBefore(data))
            throw new ItemIndisponivelException("Impossível renovar em data posterior"
                        + " a data de devolução prevista!\n"
                        + "Proceda à devolução do item!");
        
        if(this.dataEmprestimo.isAfter(data))
            throw new DateTimeException("A data informada é anterior ao empréstimo\n");

        if(quantRenovado < maxRenovacao) { //arrumar melhor jeito de guardar a quant de emprestimos

            quantRenovado++;

            //manter a devolucao como sendo data do dia + dias emprestimo
            //ou dataPrevista + dias emprestimo ?
            dataDevolucaoPrevista = this.dataDevolucaoPrevista.plusDays(item.retornaDiasEmprestimo());

            return true;

        }

        // lancar excecao?
        //JOption
        //System.out.println("Numero de renovacoes excedido");
        return false;
    }



    //----------------------------------------------------------------------//

    /** Método que retorna a quantidade de vezes que o empréstimo foi renovado
     * 
     * @return int - número de renovações
     */
    public int getQuantidadeRenovacao() {
            return quantRenovado;
    }

    /** Método que define a quantidade de vezes que o empréstimo foi renovado
     * 
     * @param quantidadeRenovacao - int
     */
    public void setQuantidadeRenovacao(int quantidadeRenovacao) {
            this.quantRenovado = quantidadeRenovacao;
    }

    /** Método que retorna o valor da multa
     * 
     * @return double - valor da multa
     */
    public double getValorMulta() {
            return valorMulta;
    }

    /** Método que define o valor da multa
     * 
     * @param valorMulta - double
     */
    public void setValorMulta(double valorMulta) {
            this.valorMulta = valorMulta;
    }
    
    
    /** Método que retorna o boolean armazenado em MultaPaga
     * 
     * @return boolean - true, se a multa foi paga; false, caso contrário.
     */
    public boolean isMultaPaga() {
            return multaPaga;
    }

    /** Método que define o valor booleano de MultaPaga
     * 
     * @param multaPaga - boolean
     */
    public void setMultaPaga(boolean multaPaga) {
            this.multaPaga = multaPaga;
    }

    /** Método que retorna o Cliente
     * 
     * @return Cliente que realizou o empréstimo
     */
    public Cliente getCliente() {
            return cliente;
    }

    /** Método que define o Cliente que realizou o empréstimo
     *  
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
            this.cliente = cliente;
    }

    /** Método que retorna o Item objeto do empréstimo
     * 
     * @return ItemAcervo - item emprestado
     */
    public ItemAcervo getItem() {
            return item;
    }

    /** Método que define o item objeto do empréstimo
     * 
     * @param item - ItemAcervo
     */
    public void setItem(ItemAcervo item) {
            this.item = item;
    }

    /** Método que retorna a data em que o empréstimo foi efetuado
     * 
     * @return LocalDate - data 
     */
    public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
    }

    /** Método que define a data em que o empréstimo foi realizado
     * 
     * @param dataEmprestimo - LocalDate
     */
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
            this.dataEmprestimo = dataEmprestimo;
    }

    /** Método que retorna se o empréstimo gerou multa
     * 
     * @return true, se gerou; false, caso contrário.
     */
    public boolean getEstaMultado() {
            return estaMultado;
    }

    /** Método que define o valor do atributo estaMultado
     * 
     * @param estaMultado - boolean
     */
    public void setEstaMultado(boolean estaMultado) {
            this.estaMultado = estaMultado;
    }

    /** Método que retorna a data prevista de devolução do item
     * 
     * @return LocalDate - data prevista de devolução
     */
    public LocalDate getDataDevolucaoPrevista() {
            return dataDevolucaoPrevista;
    }

    /** Método que define a data prevista de devolução do item
     * 
     * @param data - LocalDate
     */
    public void setDataDevolucao(LocalDate data) {
            this.dataDevolucao = data;
    }

    /** Método que retorna a data em que o item foi devolvido
     * 
     * @return LocalDate - data 
     */
    public LocalDate getDataDevolucao() {
            return dataDevolucao;
    }
       
    /** Método toString que retorna os dados do Emprestimo
     * 
     * @return String
     */
    @Override
    public String retornaDados() {
            return "Emprestimo: " +
                            "Item: " + item +
                            ", Cliente: " + cliente +
                            ", Renovacoes: " + quantRenovado +
                            ", Data do Emprestimo: " + dataEmprestimo +
                            ", Data de Devolucao: " + dataDevolucao +
                            '}';
    }
}
