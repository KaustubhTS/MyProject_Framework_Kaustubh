package exceptions;

public class APIExceptions extends RuntimeException  {
	
	public APIExceptions(String message) {
		super(message);
		
	}

	public APIExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}

}
