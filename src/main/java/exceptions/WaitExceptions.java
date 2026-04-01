package exceptions;

public class WaitExceptions extends RuntimeException  {

	
	public WaitExceptions(String message )
	{
		super(message);
	}
	
	
	public WaitExceptions(String message, Throwable cause) {
		super(message, cause);
	
	}

	
}
