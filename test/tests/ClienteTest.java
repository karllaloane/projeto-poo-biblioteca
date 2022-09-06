
package tests;

import biblioteca.Cliente;
import biblioteca.Endereco;
import exceptions.ItemIndisponivelException;
import biblioteca.Livro;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/** Classe que implementa testes de métodos da classe Cliente
 *
 * @since release 1
 * @version 1.1
 */
public class ClienteTest {
    @Test (expected = ItemIndisponivelException.class)
    public void testRealizaEmprestimoComItemEmprestadoELancaException() {

        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        Cliente lais = new Cliente("Lais Silva", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        Livro cegueira = new Livro("Ensaio sobre a cegueira", "Cia das letras", "xxxx",
                "Jose Saramago", 1995, 250);

        luis.realizarEmprestimo(cegueira, LocalDate.now());

        lais.realizarEmprestimo(cegueira, LocalDate.now());

    }

    @Test (expected = ItemIndisponivelException.class)
    public void testRealizaEmprestimoComItemReservadoDeveLancarException() {

        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        Cliente lais = new Cliente("Lais Silva", "1234567-78", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        lucidez.registrarReserva(luis, LocalDate.now());

        lais.realizarEmprestimo(lucidez, LocalDate.now());
    }
    
    @Test (expected = DateTimeException.class)
    public void testDevolveItemComDataAnteriorAoEmprestimoELancaException() {
        Cliente lais = new Cliente("Lais Silva", "1234567-78", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);
        
        lais.realizarEmprestimo(lucidez, LocalDate.now());
        
        lais.devolverItem(0, LocalDate.of(2010, Month.MARCH, 1));
    }
}
