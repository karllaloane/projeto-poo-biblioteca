package biblioteca;

import frames.*;

public class BibliotecaApp {

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        Biblioteca biblio = Biblioteca.getInstance();
        String info = biblio.getNome() + " - " + biblio.getCnpj();
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin tela = new TelaLogin();
                tela.setInfoBiblioteca(info);
                tela.setVisible(true);
            }
        });
    }
    
}
