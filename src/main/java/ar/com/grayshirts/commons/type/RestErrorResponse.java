package ar.com.grayshirts.commons.type;

/**
 * Useful DTO to send an error REST response. Contains the HTTP status code
 * and an error code.
 */
public class RestErrorResponse extends RestResponse {

    private String errorCode;

    public RestErrorResponse() { }

    public RestErrorResponse(int statusCode, String message, String errorCode) {
        super(statusCode, message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
