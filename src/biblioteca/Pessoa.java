package biblioteca;

import java.io.Serializable;

/** Classe que representa uma pessoa e implementa o protocolo Serializable.
 * Armazena os seguintes atributos: o número total de pessoas, 
 * ID da pessoa; nome; CPF; telefone; e-mail; e endereço.
 * 
 * @version 1.0
 * @since release 1
 */
public class Pessoa implements Serializable{
    private static int numPessoa;
    
    private int ID;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;

    /** Construtor que não recebe parâmetros, nem realiza atribuições
     * 
     */
    public Pessoa() {

    }

    /** Construtor que recebe parâmetros e realiza as respectivas atribuições
     * 
     * @param nome - String
     * @param cpf - String
     * @param telefone - String
     * @param email - String
     * @param endereco - Endereco
     */
    public Pessoa(String nome, String cpf, String telefone, String email, Endereco endereco) {
            numPessoa++;
            this.ID = numPessoa;
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.email = email;
            this.endereco = endereco;
    }

    /** Método que retorna o ID da pessoa
     * 
     * @return ID - int - número do ID
     */
    public int getID() {
            return ID;
    }
    
    /** Método que retorna o nome da pessoa
     * 
     * @return nome - String
     */
    public String getNome() {
            return nome;
    }

    /** Método que permite atribuir um nome à pessoa
     * 
     * @param nome - String
     */
    public void setNome(String nome) {
            this.nome = nome;
    }

    /** Método que retorna o CPF da pessoa
     * 
     * @return cpf - String
     */
    public String getCpf() {
            return cpf;
    }

    /** Método que atribui um CPF à pessoa
     * 
     * @param cpf - String
     */
    public void setCpf(String cpf) {
            this.cpf = cpf;
    }

    /** Método que retorna o telefone da pessoa
     * 
     * @return telefone - String
     */
    public String getTelefone() {
            return telefone;
    }

    /** Método que permite atribuir um telefone à pessoa
     * 
     * @param telefone - String
     */
    public void setTelefone(String telefone) {
            this.telefone = telefone;
    }

    /** Método que retorna o e-mail da pessoa
     * 
     * @return email - String
     */
    public String getEmail() {
            return email;
    }

    /** Método que permite atribuir um e-mail à pessoa
     * 
     * @param email - String
     */
    public void setEmail(String email) {
            this.email = email;
    }

    /** Método que retorna o endereço da pessoa
     * 
     * @return endereco - Endereco
     */
    public Endereco getEndereco() {
            return endereco;
    }

    /** Método que permite atribuir um endereço à pessoa
     * 
     * @param endereco - Endereco
     */
    public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
    }
    
    /** Método que permite alterar o atributo estático do número de pessoas
     * 
     * @param numPessoa - int
     */
    public static void setNumPessoa(int numPessoa){
        Pessoa.numPessoa = numPessoa;
    }

    /** Método que retorna os dados armazenados 
     * 
     * @return String com os dados dos atributos
     */
    @Override
    public String toString() {
            return "Pessoa: \n" +
                            "ID: '" + ID + '\'' +
                            "Nome: '" + nome + '\'' +
                            ", CPF: '" + cpf + '\'' +
                            ", Telefone: '" + telefone + '\'' +
                            ", E-mail: '" + email + '\'' +
                            ", Endereco: " + endereco;
    }
}

