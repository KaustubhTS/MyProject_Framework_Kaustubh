package base;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import exceptions.ElementException;
import utils.WaitUtil;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By locator) {
		try {
			WaitUtil.waitForVisibility(driver, locator).click();
		} catch (NoSuchElementException e) {

			throw new ElementException("Failed to click on element: " + locator, e);
		}
	}

	public void type(By locator, String text) {
		try {
			
			WaitUtil.waitForVisibility(driver, locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			
			throw new ElementException("Failed to type into element: " + locator, e);
		}
	}

	public String getText(By locator) {
		try {
			
			return WaitUtil.waitForVisibility(driver, locator).getText();
		} catch (NoSuchElementException e) {
			
			throw new ElementException("Failed to get text from element: " + locator, e);
		}
	}
}
