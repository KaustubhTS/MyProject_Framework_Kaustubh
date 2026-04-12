package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class loggerUtil {
	
	private static ThreadLocal<Logger> logger = new ThreadLocal<>();

	public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
	

}
