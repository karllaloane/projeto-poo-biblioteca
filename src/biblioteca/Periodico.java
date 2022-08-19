package biblioteca;


public class Periodico extends ItemAcervo{

    private int volume;
    private int numero;
    private String dataPublicacao;
    private int diasEmprestimo = 5;

    public Periodico(String titulo, String editora, int volume, int numero, String dataPublicacao) {
            super(titulo, editora);
            this.volume = volume;
            this.numero = numero;
            this.dataPublicacao = dataPublicacao;
    }

    /**************************************************************************************************/

    public int getVolume() {
            return volume;
    }

    public void setVolume(int volume) {
            this.volume = volume;
    }

    public int getNumero() {
            return numero;
    }

    public void setNumero(int numero) {
            this.numero = numero;
    }

    public String getDataPublicacao() {
            return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
            this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int retornaDiasEmprestimo() {
            return this.diasEmprestimo;
    }

    @Override
    public String toString() {
            return super.toString() +
                            ", Volume: " + volume +
                            ", Numero: " + numero +
                            ", Data de publicacao: '" + dataPublicacao + '\'' +
                            ", Dias de emprestimo: " + diasEmprestimo;
    }
}
