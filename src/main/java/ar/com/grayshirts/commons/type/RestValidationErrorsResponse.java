package ar.com.grayshirts.commons.type;

import java.util.List;
import java.util.stream.Collectors;

public class RestValidationErrorsResponse extends RestErrorResponse {

	private List<ValidationError> errors;

	public RestValidationErrorsResponse() { }

	public RestValidationErrorsResponse(int statusCode, String message, String errorCode, List<ValidationError> errors) {
		super(statusCode, message, errorCode);
		this.errors = errors;
	}

    public String toString() {
        return super.toString() +
            ",errors=[" +
                errors.stream().map(e->"{"+e.toString()+"}").collect(Collectors.joining(",")) +
            "]";
    }

	public List<ValidationError> getErrors() {
		return errors;
	}
	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}
}
