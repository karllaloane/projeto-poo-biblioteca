package biblioteca;

import frames.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/** Classe principal do aplicativo
 * 
 * @version 1.0
 */
public class BibliotecaApp {

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        
        Biblioteca biblioteca = Biblioteca.getInstance();
        String info = biblioteca.getNome() + " - " + biblioteca.getCnpj();
        
        try {
            BibliotecaArquivo bArquivo = new BibliotecaArquivo();
            
            try {
                biblioteca.setClientes(bArquivo.getListaCliente());
                biblioteca.setItens(bArquivo.getListaAcervo());
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BibliotecaApp.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Falha na persistĂȘncia de dados!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BibliotecaApp.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Falha na persistĂȘncia de dados!", "Error", JOptionPane.ERROR_MESSAGE);
            }
  
        } catch (IOException ex) {
            //Logger.getLogger(BibliotecaApp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha na persistĂȘncia de dados!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        ItemAcervo.setTotalItens(biblioteca.getItens().size());
        Pessoa.setNumPessoa(biblioteca.getClientes().size());

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                TelaPrincipal tela = new TelaPrincipal(biblioteca);
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
                
                
                tela.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        try {
                            BibliotecaArquivo bArquivo = new BibliotecaArquivo();
                            
                            try {
                                bArquivo.gravarCliente(biblioteca.getClientes());
                                bArquivo.gravarAcervo(biblioteca.getItens());
                                
                            } catch (IOException ex) {
                                Logger.getLogger(BibliotecaApp.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, "Falha na persistĂȘncia de dados!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(BibliotecaApp.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Falha na persistĂȘncia de dados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                });
            }
        }); 
    }
    
}
