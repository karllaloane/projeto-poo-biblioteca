
package tests;

import biblioteca.Cliente;
import biblioteca.Endereco;
import biblioteca.Livro;
import java.time.LocalDate;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author gabrielsilvestre
 */
public class ItemAcervoTest {
    @Test
    public void testRegistrarReservaComSucesso() {

        Livro cegueira = new Livro("Ensaio sobre a cegueira", "Cia das letras", "xxxx",
                "Jose Saramago", 1995, 250);

        Cliente lais = new Cliente("Lais Silva", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        assertEquals(true, cegueira.registrarReserva(lais, LocalDate.now()));

    }

    @Test
    public void testRegistrarReservaComErro() {

        Livro cegueira = new Livro("Ensaio sobre a cegueira", "Cia das letras", "xxxx",
                "Jose Saramago", 1995, 250);

        Cliente lais = new Cliente("Lais Silva", "1234567-77", "32112233",
                "luisf@luis.com", new Endereco(null, null, null, null, 0));

        cegueira.registrarReserva(lais, LocalDate.now());

        assertEquals(false, cegueira.registrarReserva(lais, LocalDate.now()));

    }
    
}
