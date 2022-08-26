package biblioteca;

/** Classe que representa uma exceção que herda da classe RuntimeException
 *@version 1.0
 * @since release 2
 */
public class ClienteComPendenciaException extends RuntimeException {
    public ClienteComPendenciaException(String msg) {
        super(msg);
    }
}
