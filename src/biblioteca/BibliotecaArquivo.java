
package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author karll
 */
public class BibliotecaArquivo {
    private File clienteFile;
    private File emprestimoFile;
    private File itemFile;

    public BibliotecaArquivo() throws IOException{
        clienteFile = new File("cliente.txt");
        emprestimoFile = new File("emprestimo.txt");
        itemFile = new File("acervo.txt");
        
        if(!clienteFile.exists()){
            this.clienteFile.createNewFile();
        }
        if(!emprestimoFile.exists()){
            this.emprestimoFile.createNewFile();
        }
        if(!itemFile.exists()){
            this.itemFile.createNewFile();
        }
    }
    
    public ArrayList<Emprestimo> getListaEmprestimo() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();;
        ObjectInputStream objIS = null;
        
        if (emprestimoFile.length() > 0) {
            objIS = new ObjectInputStream(new FileInputStream(emprestimoFile));
            emprestimos = (ArrayList<Emprestimo>) objIS.readObject();
            //System.out.println("Emprestimos nao esta vazio! size > " + emprestimos.size());
        }
        
        return emprestimos;        
    }
    
    public ArrayList<Cliente> getListaCliente() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Cliente> clientes = new ArrayList<>();
        ObjectInputStream objIS = null;
        
        if (clienteFile.length() > 0) {
            objIS = new ObjectInputStream(new FileInputStream(clienteFile));
            clientes = (ArrayList<Cliente>) objIS.readObject();
            //System.out.println("Cliente nao esta vazio! size > " + clientes.size() + " - " + clienteFile.length());
        }
        
        return clientes;        
    }
    
    public ArrayList<ItemAcervo> getListaAcervo() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<ItemAcervo> acervo;
        ObjectInputStream objIS = null;
        
        if (itemFile.length() > 0) {
            objIS = new ObjectInputStream(new FileInputStream(itemFile));
            acervo = (ArrayList<ItemAcervo>) objIS.readObject();
            //System.out.println("Acervo nao esta vazio! size > " + acervo.size() + " - " + itemFile.length());
        } else {
            acervo = new ArrayList<>();
        }
        
        return acervo;        
    }
    
    public void gravarEmprestimo(ArrayList<Emprestimo> emprestimo) throws IOException{
        FileOutputStream caminho = new FileOutputStream("emprestimo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(caminho);
	oos.writeObject(emprestimo);
	oos.close();
        oos.flush();
        caminho.flush();
	caminho.close();
    }
    
    public void gravarCliente(ArrayList<Cliente> cliente) throws IOException{
        FileOutputStream caminho = new FileOutputStream("cliente.txt");
        ObjectOutputStream oos = new ObjectOutputStream(caminho);
	oos.writeObject(cliente);
	oos.close();
        oos.flush();
        caminho.flush();
	caminho.close();
    }
    
    public void gravarAcervo(ArrayList<ItemAcervo> item) throws IOException{
        FileOutputStream caminho = new FileOutputStream("acervo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(caminho);
	oos.writeObject(item);
	oos.close();
        oos.flush();
        caminho.flush();
	caminho.close();
    }
    
}
