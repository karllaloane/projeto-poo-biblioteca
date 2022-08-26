package biblioteca;

/** Classe representa uma exceção que herda da classe RuntimeException
 * 
 * @version 1.0
 * @since release 2
 */
public class BuscaFalhouException extends RuntimeException {
    public BuscaFalhouException(String msg) {
        super(msg);
    }
}