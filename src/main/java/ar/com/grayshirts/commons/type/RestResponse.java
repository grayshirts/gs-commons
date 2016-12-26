package ar.com.grayshirts.commons.type;

import java.io.Serializable;

/**
 * Useful DTO to send a REST response. Contains the HTTP status code.
 */
public class RestResponse implements Serializable {

    private int status;
    private String message;

    public RestResponse() { }

    public RestResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
