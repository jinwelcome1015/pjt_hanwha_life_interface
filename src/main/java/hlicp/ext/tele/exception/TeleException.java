package hlicp.ext.tele.exception;

public class TeleException extends RuntimeException {

    private static final long serialVersionUID = -4414584356923172176L;


    public TeleException() {
    }

    public TeleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeleException(String message) {
        super(message);
    }

    public TeleException(Throwable cause) {
        super(cause);
    }
}