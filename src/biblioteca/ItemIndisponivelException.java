package biblioteca;

/** Classe criada para representar uma exceção de item indisponível, que herda
 * de RuntimeException
 * 
 * @version 1.0
 * @since release 1
 */
public class ItemIndisponivelException extends RuntimeException {
    public ItemIndisponivelException(String msg) {
        super(msg);
    }
}