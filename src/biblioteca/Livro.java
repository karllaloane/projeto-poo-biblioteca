
package biblioteca;

import java.io.Serializable;

/** Classe criada para representar um livro da biblioteca, que herda da classe
 * ItemAcervo e armazena: o código ISBN do livro; o autor; o ano de publicação;
 * o número de páginas; e o número de dias que o livro pode ficar emprestado.
 * 
 * @version 1.0
 * @since release 1
 */
public class Livro extends ItemAcervo implements Serializable {
	
    private String isbn;
    private String autor;
    private int anoPublicacao;
    private int numPaginas;
    private int diasEmprestimo = 7;

    public Livro(String titulo, String editora, String isbn, String autor, int anoPublicacao, int numPaginas) {
            super(titulo, editora);
            this.isbn = isbn;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
            this.numPaginas = numPaginas;
    }

    //------------------------------------------------------------------------//

    /** Método que retorna o código ISBN do livro
     * 
     * @return String - código ISBN
     */
    public String getIsbn() {
            return isbn;
    }

    /** Método que define o código ISBN do livro
     * 
     * @param isbn - String - código ISBN do livro
     */
    public void setIsbn(String isbn) {
            this.isbn = isbn;
    }

    /** Método que retorna o autor do livro
     * 
     * @return String - nome do autor
     */
    public String getAutor() {
            return autor;
    }

    /** Método que define o autor do livro
     * 
     * @param autor - String - nome do autor
     */
    public void setAutor(String autor) {
            this.autor = autor;
    }

    /** Método que retorna o ano de publicação do livro
     * 
     * @return ano de publicação - int
     */
    public int getAnoPublicacao() {
            return anoPublicacao;
    }

    /** Método que define o ano de publicação do livro
     * 
     * @param anoPublicacao - int - ano de publicação
     */
    public void setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
    }

    /** Método que retorna o número de páginas do livro
     * 
     * @return int - número de páginas do livro
     */
    public int getNumPaginas() {
            return numPaginas;
    }

    /** Método que define o número de páginas do livro
     * 
     * @param numPaginas - int - número de páginas
     */
    public void setNumPaginas(int numPaginas) {
            this.numPaginas = numPaginas;
    }

    /** Método que implementa o método abstrato da classe ItemAcervo e retorna
     * o número de dias que o livro pode permanecer emprestado
     * 
     * @return int - número de dias que o livro pode permanecer emprestado
     */
    @Override
    public int retornaDiasEmprestimo() {
            return this.diasEmprestimo;
    }

    /** Método toString que retorna os dados do livro
     * 
     * @return String com dados do livro
     */
    @Override
    public String toString() {
            return 	super.toString() +
                            ", ISBN: '" + isbn + '\'' +
                            ", Autor: '" + autor + '\'' +
                            ", Ano: " + anoPublicacao +
                            ", Paginas: " + numPaginas +
                            ", Dias de Emprestimo: " + diasEmprestimo;
    }
}

