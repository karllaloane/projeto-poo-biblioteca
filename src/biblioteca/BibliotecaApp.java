package biblioteca;

import frames.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class BibliotecaApp {

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        Biblioteca biblio = Biblioteca.getInstance();
        String info = biblio.getNome() + " - " + biblio.getCnpj();
        
        Cliente luis = new Cliente("Luis Felipe", "123456777", "32112233",
                "luisf@luis.com", new Endereco("76777999", "Goiânia", "Centro", "Amarela", 23));
        biblio.addClientes(luis);

        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);
        biblio.addItens(lucidez);

        Livro l = new Livro("O Hobbit", "Editora", "ERF345",
                "Tolkien", 2004, 250);
        biblio.addItens(l);
        
        l = new Livro("O Senhor dos Aneis", "Editora", "ERF343455",
                "Tolkien", 2004, 250);
        biblio.addItens(l);
        
        Emprestimo e = luis.realizarEmprestimo(lucidez, LocalDate.of(2022,8,1));
        
        biblio.addHistoricoEmprestimos(e);

        
        //luis.devolverItem(0, LocalDate.of(2022,8,18));
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //TelaLogin tela = new TelaLogin();
                //tela.setInfoBiblioteca(info);
                //tela.setVisible(true);
                
                TelaPrincipal tela = new TelaPrincipal(biblio);
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
                
                tela.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("fechou!");
                    }
                });
            }
        }); 
    }
    
}
