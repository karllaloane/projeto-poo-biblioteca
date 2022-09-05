package tests;

import biblioteca.Cliente;
import biblioteca.Endereco;
import biblioteca.ItemAcervo;
import biblioteca.Livro;
import biblioteca.Periodico;
import java.time.LocalDate;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


/** Classe que implementa testes de métodos da classe Emprestimo
 *
 * @since release 1
 * @version 1.1
 */
public class EmprestimoTest {
    @Test
    public void testCalcularMultaLivro() {

        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));


        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        luis.realizarEmprestimo(lucidez, LocalDate.of(2022,8,1));

        luis.devolverItem(0, LocalDate.of(2022,8,18));

        assertEquals(5.00, luis.getEmprestimos().get(0).calcularMulta());
    }
    
    @Test
    public void testCalcularMultaPeriodico() {

        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));


        ItemAcervo periodico = new Periodico("Periodico", "Revista", 3, 2, "10/2/2012");

        luis.realizarEmprestimo(periodico, LocalDate.of(2022,8,1));

        luis.devolverItem(0, LocalDate.of(2022,8,18));

        assertEquals(6.00, luis.getEmprestimos().get(0).calcularMulta());
    }

    @Test
    public void testRenovarComSucesso() {
        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));


        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        luis.realizarEmprestimo(lucidez, LocalDate.of(2022,8,1));

        assertEquals(true, luis.getEmprestimos().get(0).renovar(LocalDate.of(2022,8,5)));
    }

    @Test
    public void testRenovarComFalhaRenovacoesExcedidas() {
        Cliente luis = new Cliente("Luis Felipe", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));


        Livro lucidez = new Livro("Ensaio sobre a lucidez", "Cia das letras", "xxxx",
                "Jose Saramago", 2004, 250);

        luis.realizarEmprestimo(lucidez, LocalDate.of(2022,8,1));
        luis.getEmprestimos().get(0).renovar(LocalDate.of(2022,8,5));
        luis.getEmprestimos().get(0).renovar(LocalDate.of(2022,8,10));
        luis.getEmprestimos().get(0).renovar(LocalDate.of(2022,8,15));

        assertEquals(false, luis.getEmprestimos().get(0).renovar(LocalDate.of(2022,8,20)));
    }
}
