package ar.com.grayshirts.commons.type;

/**
 * Useful DTO to send an error REST response. Contains the HTTP status code
 * and an error code.
 */
public class RestErrorResponse extends RestResponse {

    private String error;

    public RestErrorResponse() { }

    public RestErrorResponse(int status, String message, String error) {
        super(status, message);
        this.error = error;
    }

    public String toString() {
        return super.toString() + ",error='" + error + "'";
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
