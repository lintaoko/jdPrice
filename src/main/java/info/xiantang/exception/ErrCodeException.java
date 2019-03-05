package info.xiantang.exception;

public class ErrCodeException extends RuntimeException {
    public ErrCodeException() {
    }

    public ErrCodeException(String message) {
        super(message);
    }

    public ErrCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrCodeException(Throwable cause) {
        super(cause);
    }

    public ErrCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
