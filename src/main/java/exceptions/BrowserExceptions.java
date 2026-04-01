package exceptions;

public class BrowserExceptions extends RuntimeException  {

	public BrowserExceptions(String message) {
		super(message);
	}
	
	
	public BrowserExceptions(String message, Throwable cause) {
		super(message, cause);
	}

}
