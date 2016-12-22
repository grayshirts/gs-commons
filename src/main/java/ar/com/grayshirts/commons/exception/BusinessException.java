package ar.com.grayshirts.commons.exception;

/**
 * Exception for business logic from services.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
