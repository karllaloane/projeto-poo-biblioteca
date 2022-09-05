package tests;

import biblioteca.Biblioteca;
import biblioteca.BuscaFalhouException;
import biblioteca.Cliente;
import biblioteca.Endereco;
import biblioteca.Livro;
import java.time.LocalDate;
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
}
