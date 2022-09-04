package biblioteca;

import java.io.Serializable;


public class Endereco implements Serializable{

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

    public Endereco(String cep, String cidade, String bairro, String rua, int numero) {
            super();
            this.cep = cep;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.numero = numero;
    }

    public String getCep() {
            return cep;
    }
    public void setCep(String cep) {
            this.cep = cep;
    }
    public String getCidade() {
            return cidade;
    }
    public void setCidade(String cidade) {
            this.cidade = cidade;
    }
    public String getBairro() {
            return bairro;
    }
    public void setBairro(String bairro) {
            this.bairro = bairro;
    }
    public String getRua() {
            return rua;
    }
    public void setRua(String rua) {
            this.rua = rua;
    }
    public int getNumero() {
            return numero;
    }
    public void setNumero(int numero) {
            this.numero = numero;
    }

    @Override
    public String toString() {
            return "Endereco: " +
                            ", Rua: '" + rua + '\'' +
                            ", Numero: " + numero +
                            ", Bairro: '" + bairro + '\'' +
                            ", CEP: '" + cep + '\'' +
                            ", Cidade: '" + cidade + '\'';
    }
}
