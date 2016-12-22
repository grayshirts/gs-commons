package ar.com.grayshirts.commons.type;

import java.io.Serializable;

/**
 * Useful DTO to send a REST response. Contains the HTTP status code.
 */
public class RestResponse implements Serializable {

    private int statusCode;
    private String message;

    public RestResponse() { }

    public RestResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
