package biblioteca;

public class ItemIndisponivelException extends RuntimeException {
    public ItemIndisponivelException(String msg) {
        super(msg);
    }
}