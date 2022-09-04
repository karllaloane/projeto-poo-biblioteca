package biblioteca;

import java.io.Serializable;

/**
 * Classe criada para representar um periódico da biblioteca, que herda da classe
 * ItemAcervo e armazena: o volume; o número; a data de publicação; e quantos
 * dias o item pode permanecer emprestado.
 * 
 * @version 1.0
 * @since release 1
 * 
 */
public class Periodico extends ItemAcervo implements Serializable{

    private int volume;
    private int numero;
    private String dataPublicacao;
    private int diasEmprestimo = 5;

    /** Construtor que recebe parâmetros e realiza as respectivas atribuições
     * 
     * @param titulo - String
     * @param editora - String
     * @param volume - int
     * @param numero - int
     * @param dataPublicacao - String
     */
    public Periodico(String titulo, String editora, int volume, int numero, String dataPublicacao) {
            super(titulo, editora);
            this.volume = volume;
            this.numero = numero;
            this.dataPublicacao = dataPublicacao;
    }

    //------------------------------------------------------------------------//

    /**
     * Método que retorna o número do volume do periódico
     *
     * @return volume - int - número do volume
     */
    public int getVolume() {
            return volume;
    }

    /** Método que permite atribuir um número ao volume
     * 
     * @param volume - int
     */
    public void setVolume(int volume) {
            this.volume = volume;
    }

    /** Método que retorna o número do periódico
     * 
     * @return numero - int- número do periódico
     */
    public int getNumero() {
            return numero;
    }

    /** Método que permite atribuir um valor ao número do periódico
     * 
     * @param numero - int
     */
    public void setNumero(int numero) {
            this.numero = numero;
    }

    /** Método que retorna a data de publicação do periódico
     * 
     * @return dataPublicacao - String - data de publicação
     */
    public String getDataPublicacao() {
            return dataPublicacao;
    }

    /** Método que permite atribuir valor à data de publicação
     * 
     * @param dataPublicacao - String
     */
    public void setDataPublicacao(String dataPublicacao) {
            this.dataPublicacao = dataPublicacao;
    }

    /** Método que retorna o número de dias que o periódico pode permanecer 
     * emprestado.
     * 
     * @return diasEmprestimo - int - número de dias que o item pode permanecer emprestado.
     */
    @Override
    public int retornaDiasEmprestimo() {
            return this.diasEmprestimo;
    }

    /** Método toString que retorna os atributos do periódico.
     * 
     * @return String - atributos do objeto
     */
    @Override
    public String toString() {
            return super.toString() +
                            ", Volume: " + volume +
                            ", Numero: " + numero +
                            ", Data de publicacao: '" + dataPublicacao + '\'' +
                            ", Dias de emprestimo: " + diasEmprestimo;
    }
}
