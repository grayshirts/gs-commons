package ar.com.grayshirts.commons.type;

import java.util.List;

public class RestValidationErrorsResponse extends RestErrorResponse {

	private List<ValidationError> errors;

	public RestValidationErrorsResponse() { }

	public RestValidationErrorsResponse(int statusCode, String message, String errorCode, List<ValidationError> errors) {
		super(statusCode, message, errorCode);
		this.errors = errors;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}
	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}
}
