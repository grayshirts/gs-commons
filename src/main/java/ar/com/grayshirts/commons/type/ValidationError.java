package ar.com.grayshirts.commons.type;

import java.io.Serializable;

public class ValidationError implements Serializable {

	private String field;
	private String message;

	public ValidationError() { }

	public ValidationError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String toString() {
	    return "field='" + field + "',message='" + message + "'";
    }

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
