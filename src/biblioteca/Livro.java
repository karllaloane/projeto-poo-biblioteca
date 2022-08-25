
package biblioteca;

import java.io.Serializable;


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

    /**************************************************************************************************/

    public String getIsbn() {
            return isbn;
    }

    public void setIsbn(String isbn) {
            this.isbn = isbn;
    }

    public String getAutor() {
            return autor;
    }

    public void setAutor(String autor) {
            this.autor = autor;
    }

    public int getAnoPublicacao() {
            return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
    }

    public int getNumPaginas() {
            return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
            this.numPaginas = numPaginas;
    }

    @Override
    public int retornaDiasEmprestimo() {
            return this.diasEmprestimo;
    }

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

