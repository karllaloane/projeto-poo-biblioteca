
package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/** Classe criada para leitura/escrita de arquivos e persistência de dados
 * 
 * @version 1.0
 * @since release 1
 *
 * @author karlla
 */
public class BibliotecaArquivo {
    private File clienteFile;
    private File itemFile;

    
    public BibliotecaArquivo() throws IOException{
        clienteFile = new File("cliente.txt");
        itemFile = new File("acervo.txt");
        
        if(!clienteFile.exists()){
            this.clienteFile.createNewFile();
        }
        if(!itemFile.exists()){
            this.itemFile.createNewFile();
        }
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
