package controle;

import biblioteca.*;
import java.util.ArrayList;

public class Login {
    
    //busca o funcionario pelo login, e retorna o funcionario caso encontre
    public Funcionario buscaLogin(String login, ArrayList<Funcionario> func){
        for(Funcionario aux : func){
            if(aux.getLogin().equals(login))
                return aux;
        }
        return null;
    }
    
}
