package tests;

import biblioteca.Biblioteca;
import exceptions.BuscaFalhouException;
import biblioteca.Cliente;
import biblioteca.Emprestimo;
import exceptions.ClienteComPendenciaException;
import biblioteca.Endereco;
import exceptions.ItemIndisponivelException;
import biblioteca.Livro;
import biblioteca.Periodico;
import java.time.LocalDate;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;


/** Classe que implementa testes de métodos da classe Biblioteca
 *
 * @version 1.1
 * @since release 1
 */
public class BibliotecaTest {
    
    @Test
    public void testProcurarItemDeveRetornarItem() {
        Biblioteca biblioteca = Biblioteca.getInstance();

        Livro lucidez = new Livro("Jornada do Elefante", "Cia das letras", "xxxx",
                "Jose Saramago", 2008, 250);

        biblioteca.addItens(lucidez);

       assertEquals(lucidez, biblioteca.procurarItem("Jornada do Elefante"));

    }
    
    @Test (expected = BuscaFalhouException.class)
    public void testProcurarItemDeveLancarExcecao() {
        Biblioteca biblioteca = Biblioteca.getInstance();

        biblioteca.procurarItem("Jangada de Pedra");
    }

    @Test
    public void testProcuraClienteDeveRetornarCliente() {
        Biblioteca biblioteca = Biblioteca.getInstance();

        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        biblioteca.addClientes(luis);

        assertEquals(luis, biblioteca.procurarCliente("1234567-77"));
    }

    @Test(expected = BuscaFalhouException.class)
    public void testProcuraClienteDeveLancarExcecao() {
        Biblioteca biblioteca = Biblioteca.getInstance();


        biblioteca.procurarCliente("Luis Alberto");
    }

    @Test
    public void testTotalMultasPendentes() {
        Biblioteca biblioteca = Biblioteca.getInstance();

        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        Cliente lais = new Cliente("Lais Silva", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        biblioteca.addClientes(luis);
        biblioteca.addClientes(lais);

        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        Livro cegueira = new Livro("Ensaio sobre a cegueira", "Cia das letras", "xxxx",
                "Jose Saramago", 1995, 250);

        biblioteca.addItens(lucidez);
        biblioteca.addItens(cegueira);

        luis.realizarEmprestimo(biblioteca.getItens().get(0), LocalDate.of(2022,8,1));
        lais.realizarEmprestimo(biblioteca.getItens().get(1), LocalDate.of(2022,8,1));

        luis.devolverItem(0, LocalDate.of(2022,8,9));
        lais.devolverItem(0, LocalDate.of(2022,8,9));


        assertEquals(1.00, biblioteca.totalMultasPendentes());
    }
    
    @Test (expected = ClienteComPendenciaException.class)
    public void testRemoveClienteComPendenciaDeveLancarExcecao() {
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        biblioteca.addClientes(luis);

        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        luis.realizarEmprestimo(lucidez, LocalDate.of(2022,8,1));

        luis.devolverItem(0, LocalDate.of(2022,8,18));
        
        biblioteca.removeCliente(luis);
    }
    
    @Test (expected = ItemIndisponivelException.class)
    public void testRemoveItemIndisponivelDeveLancarExcecao() {
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        biblioteca.addClientes(luis);

        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        luis.realizarEmprestimo(lucidez, LocalDate.of(2022,8,1));
        
        biblioteca.removeItem(lucidez);
    }
    
    @Test
    public void testListarLivrosNomeDeveRetornarArrayList() {
        
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        Livro livro1 = new Livro("Livro 1", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        Livro livro2 = new Livro("Livro 2", "Cia das letras", "xxxx",
                "Jose Saramago", 1995, 250);

        biblioteca.addItens(livro1);
        biblioteca.addItens(livro2);
        
        ArrayList<Livro> teste = new ArrayList<>();
        
        teste.add(livro1);
        teste.add(livro2);
        
        
        assertEquals(teste, biblioteca.listarLivrosNome("livro"));
    }
    
    @Test
    public void testListarLivrosAutorDeveRetornarArrayList() {
        
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        Livro livro3 = new Livro("Livro 3", "Cia das letras", "xxxx",
                "Aloisio", 2004, 250);

        Livro livro4 = new Livro("Livro 4", "Cia das letras", "xxxx",
                "Aloisio", 1995, 250);

        biblioteca.addItens(livro3);
        biblioteca.addItens(livro4);
        
        ArrayList<Livro> teste = new ArrayList<>();
        
        teste.add(livro3);
        teste.add(livro4);
        
        
        assertEquals(teste, biblioteca.listarLivrosAutor("Aloisio"));
    }
    
    @Test
    public void testListarPeriodicosNomeDeveRetornarArrayList() {
        
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        Periodico periodico1 = new Periodico("Periodico 1", "Cia das letras", 1,
                2, "11/11/2000");

        Periodico periodico2 = new Periodico("Periodico 2", "Cia das letras", 1,
                2, "11/12/2000");

        biblioteca.addItens(periodico1);
        biblioteca.addItens(periodico2);
        
        ArrayList<Periodico> teste = new ArrayList<>();
        
        teste.add(periodico1);
        teste.add(periodico2);
        
        
        assertEquals(teste, biblioteca.listarPeriodicosNome("peri"));
    }
    
    @Test
    public void testBuscaEmprestimosEmAbertoDeveRetornarArrayList() {
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));
        
        Cliente lais = new Cliente("Lais Silva", "1234567-78", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        biblioteca.addClientes(luis);
        biblioteca.addClientes(lais);

        Livro aberto1 = new Livro("Aberto 1", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);
        
        Livro aberto2 = new Livro("Aberto 2", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);
        
        Livro fechado = new Livro("Aberto 2", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);
        
        luis.realizarEmprestimo(aberto1, LocalDate.of(2022,8,1));
        luis.realizarEmprestimo(aberto2, LocalDate.of(2022,8,1));
        lais.realizarEmprestimo(fechado, LocalDate.of(2022,8,1));
        
        lais.devolverItem(0, LocalDate.of(2022,8,2));
        
        ArrayList<Emprestimo> teste = new ArrayList<>();
        
        teste.add(luis.getEmprestimos().get(0));
        teste.add(luis.getEmprestimos().get(1));
        
        assertEquals(teste, biblioteca.buscaEmprestimosEmAberto());
    }
}
