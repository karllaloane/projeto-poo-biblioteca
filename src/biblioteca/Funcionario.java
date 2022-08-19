package biblioteca;

public class Funcionario extends Pessoa{
    
    private String login;
    private String senha;
    
    public Funcionario(String nome, String cpf, String telefone, String email, Endereco endereco, String login, String senha) {
            super(nome, cpf, telefone, email, endereco);
            this.login = login;
            this.senha = senha;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public String getSenha(){
        return this.senha;
    }
}
