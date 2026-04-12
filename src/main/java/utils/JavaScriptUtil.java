package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * JavaScriptUtil placeholder - no implementation per user request.
 */
public class JavaScriptUtil {
	private WebDriver driver;
    private JavascriptExecutor js;

    public JavaScriptUtil(WebDriver driver)
    {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    /*
     Click element using JavaScript
     */
    public void clickElement(WebElement element)
    {
        js.executeScript("arguments[0].click();", element);
    }

    /*
     Scroll to element
     */
    public void scrollIntoView(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
     Scroll page by pixels
     */
    public void scrollByPixels(int x, int y)
    {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    /*
     Scroll to bottom of page
     */
    public void scrollToBottom()
    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /*
     Scroll to top
     */
    public void scrollToTop()
    {
        js.executeScript("window.scrollTo(0,0)");
    }

    /*
     Set value to input field
     */
    public void setInputValue(WebElement element, String value)
    {
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    /*
     Highlight element (debugging)
     */
    public void highlightElement(WebElement element)
    {
        js.executeScript(
            "arguments[0].style.border='3px solid red'",
            element);
    }

    /*
     Get page title
     */
    public String getTitle()
    {
        return (String) js.executeScript("return document.title");
    }

    /*
     Get page URL
     */
    public String getURL()
    {
        return (String) js.executeScript("return document.URL");
    }

    /*
     Refresh page
     */
    public void refreshPage()
    {
        js.executeScript("history.go(0)");
    }

    /*
     Generate alert
     */
    public void generateAlert(String message)
    {
        js.executeScript("alert('" + message + "')");
    }

    /*
     Zoom page
     */
    public void zoomPage(int percentage)
    {
        js.executeScript("document.body.style.zoom='" + percentage + "%'");
    }
    
    
//    Click using JS when Selenium fails
//    Useful when:ElementClickInterceptedException
    
    public void jsClick(WebElement element)
    {
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToCenter(WebElement element)
    {
        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            element);
    }
    
    public String getInnerText(WebElement element)
    {
        return (String) js.executeScript(
            "return arguments[0].innerText;",
            element);
    }
    
    public void removeAttribute(WebElement element, String attribute)
    {
        js.executeScript(
            "arguments[0].removeAttribute('" + attribute + "')",
            element);
    }
    
    public WebElement getShadowElement(WebElement shadowHost, String cssSelector)
    {
        return (WebElement) js.executeScript(
            "return arguments[0].shadowRoot.querySelector('" + cssSelector + "')",
            shadowHost);
    }
    
}
