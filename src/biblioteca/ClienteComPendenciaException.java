package biblioteca;

/** Classe que representa uma exceção que herda da classe RuntimeException
 *@version 1.0
 * @since release 2
 */
public class ClienteComPendenciaException extends RuntimeException {
    /** Construtor que recebe uma String com a mensagem da exceção
     * 
     * @param msg - String
     */
    public ClienteComPendenciaException(String msg) {
        super(msg);
    }
}
