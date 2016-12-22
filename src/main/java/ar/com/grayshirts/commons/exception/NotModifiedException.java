package ar.com.grayshirts.commons.exception;

/**
 * Launched when a content expected to be modified is not updated.
 */
public class NotModifiedException extends BusinessException {

    public NotModifiedException() {
        super("No content modified.");
    }

    public NotModifiedException(String message) {
        super(message);
    }
}
