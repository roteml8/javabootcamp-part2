package ajbc.webservice.rest.api_demo.models;

public class ErrorMessage {
	
	private String message;
	private String linkToDocs;
	private InternalErrorCode errorCode;
	
	public ErrorMessage(String message, String linkToDocs, InternalErrorCode errorCode) {
		this.message = message;
		this.linkToDocs = linkToDocs;
		this.errorCode = errorCode;
	}
	
	public ErrorMessage() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLinkToDocs() {
		return linkToDocs;
	}

	public void setLinkToDocs(String linkToDocs) {
		this.linkToDocs = linkToDocs;
	}

	public InternalErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(InternalErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
