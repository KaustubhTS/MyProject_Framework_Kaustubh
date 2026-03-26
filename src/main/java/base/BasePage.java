package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import utils.WaitUtil;

public class BasePage {
	
	protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

	    public void click(By locator) {
	        WaitUtil.waitForVisibility(driver, locator).click();
	    }

	    public void type(By locator, String text) {
	        WaitUtil.waitForVisibility(driver, locator).sendKeys(text);
	    }

	    public String getText(By locator) {
	        return WaitUtil.waitForVisibility(driver, locator).getText();
	    }

}
