package model.mail.exceptions;

public class ServiceLocatorException extends Exception {
	
	public ServiceLocatorException(){
		super();
	}

	public ServiceLocatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceLocatorException(String message) {
		super(message);
	}

}
