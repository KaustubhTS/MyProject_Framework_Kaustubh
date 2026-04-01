package exceptions;

import org.openqa.selenium.WebElement;

public class ElementException extends FrameworkExceptions {

    public ElementException(String message) {
        super(message);
    }

    public ElementException(String message, Throwable cause) {
        super(message, cause);
    }
}