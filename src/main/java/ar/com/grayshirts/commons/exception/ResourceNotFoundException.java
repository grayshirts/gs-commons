package ar.com.grayshirts.commons.exception;

/**
 * Launched when a resource doesn't exist or was deleted.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
