package biblioteca;

import java.io.Serializable;

/** Classe que representa um endereço e implementa a interface Serializable
 * Armazena: cep, cidade, bairro, rua e numero.
 *
 * @since release 1
 * @version 1
 */
public class Endereco implements Serializable{

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

    /** Construtor que recebe parâmetros e realiza as respectivas atribuições
     * 
     * @param cep
     * @param cidade
     * @param bairro
     * @param rua
     * @param numero 
     */
    public Endereco(String cep, String cidade, String bairro, String rua, int numero) {
            super();
            this.cep = cep;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.numero = numero;
    }

    /** Método que retorna o CEP do endereço
     * 
     * @return cep - String
     */
    public String getCep() {
            return cep;
    }
    /**
     * Método que permite atribuir uma String ao CEP
     * @param cep - String 
     */
    public void setCep(String cep) {
            this.cep = cep;
    }
    /** Método que retorna a cidade
     * 
     * @return cidade - String
     */
    public String getCidade() {
            return cidade;
    }
    /** Método que permite atribuir valor à cidade
     * 
     * @param cidade - String
     */
    public void setCidade(String cidade) {
            this.cidade = cidade;
    }
    /** Método que retorna o bairro do endereço
     * 
     * @return bairro - String
     */
    public String getBairro() {
            return bairro;
    }
    /** Método que permite atribuir valor ao atributo bairro
     * 
     * @param bairro - String
     */
    public void setBairro(String bairro) {
            this.bairro = bairro;
    }
    /** Método que retorna a rua do endereço
     *  
     * @return rua - String
     */
    public String getRua() {
            return rua;
    }
    /** Método que permite alterar a rua do endereço
     * 
     * @param rua - String
     */
    public void setRua(String rua) {
            this.rua = rua;
    }
    /** Método que retorna o número do endereço
     * 
     * @return numero - int
     */
    public int getNumero() {
            return numero;
    }
    /** Método que permite atribuir um valor ao número do endereço
     * 
     * @param numero - int
     */
    public void setNumero(int numero) {
            this.numero = numero;
    }

    /** Método que retorna uma String com os dados armazenados no objeto
     * 
     * @return String
     */
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
