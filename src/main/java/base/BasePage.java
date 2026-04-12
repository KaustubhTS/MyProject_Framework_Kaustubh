package base;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import exceptions.ElementException;
import utils.WaitUtil;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void click(By locator) {
		try {
			WaitUtil.waitForVisibility(driver, locator).click();
		} catch (NoSuchElementException e) {

			throw new ElementException("Failed to click on element: " + locator, e);
		}
	}

	protected void type(By locator, String text) {
		try {
			
			WaitUtil.waitForVisibility(driver, locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			
			throw new ElementException("Failed to type into element: " + locator, e);
		}
	}

	protected String getText(By locator) {
		try {
			
			return WaitUtil.waitForVisibility(driver, locator).getText();
		} catch (NoSuchElementException e) {
			
			throw new ElementException("Failed to get text from element: " + locator, e);
		}
	}
	
	protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    // Find multiple elements
    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

}
