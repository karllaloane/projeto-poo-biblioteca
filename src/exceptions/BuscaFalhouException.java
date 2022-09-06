package exceptions;

/** Classe representa uma exceção que herda da classe RuntimeException
 * 
 * @version 1.0
 * @since release 2
 */
public class BuscaFalhouException extends RuntimeException {
    /** Construtor que recebe uma String com a mensagem da exceção
     * 
     * @param msg - String
     */
    public BuscaFalhouException(String msg) {
        super(msg);
    }
}