package ar.edu.iua.orden.model.exeptions;

public class InvalidPriceException extends Exception{
	public InvalidPriceException() {
		super();
	}

	public InvalidPriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidPriceException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPriceException(String message) {
		super(message);
	}

	public InvalidPriceException(Throwable cause) {
		super(cause);
	}

}
