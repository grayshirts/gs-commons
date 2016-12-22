package ar.com.grayshirts.commons.exception;

/**
 * Exception for business validation logic from services, related with
 * entities but not just domain validations.
 */
public class BusinessValidationException extends BusinessException {

    public BusinessValidationException(String message) {
        super(message);
    }
}
