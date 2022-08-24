package biblioteca;


public class Endereco {

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;

    public Endereco(String cep, String cidade, String bairro, String rua, int numero, String complemento) {
            super();
            this.cep = cep;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.numero = numero;
            this.complemento = complemento;
    }

//    public Endereco(String cep, String cidade, String bairro, String rua, String complemento) {
//            super();
//            this.cep = cep;
//            this.cidade = cidade;
//            this.bairro = bairro;
//            this.rua = rua;
//            this.complemento = complemento;
//    }

    public Endereco(String cep, String cidade, String bairro, String rua, int numero) {
            super();
            this.cep = cep;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.numero = numero;
    }

//    public Endereco(String cep, String cidade, String bairro, String rua) {
//            super();
//            this.cep = cep;
//            this.cidade = cidade;
//            this.bairro = bairro;
//            this.rua = rua;
//    }

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
    public String getComplemento() {
            return complemento;
    }
    public void setComplemento(String complemento) {
            this.complemento = complemento;
    }

    @Override
    public String toString() {
            return "Endereco: " +
                            ", Rua: '" + rua + '\'' +
                            ", Numero: " + numero +
                            ", Complemento: '" + complemento + '\'' +
                            ", Bairro: '" + bairro + '\'' +
                            ", CEP: '" + cep + '\'' +
                            ", Cidade: '" + cidade + '\'';
    }
}
