package utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WaitUtil placeholder - no implementation per user request.
 */
public class WaitUtil {
	private static final int DEFAULT_TIMEOUT = 20;
	private static final int POLLING_TIME = 2;

	/*
	 * Wait for element visibility
	 */
	public static WebElement waitForVisibility(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * Wait for element clickable
	 */
	public static WebElement waitForClickable(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/*
	 * Wait for element presence in DOM
	 */
	public static WebElement waitForPresence(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/*
	 * Wait for element invisibility
	 */
	public static boolean waitForInvisibility(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/*
	 * Wait for text to appear
	 */
	public static boolean waitForText(WebDriver driver, By locator, String text) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	/*
	 * Wait for page title
	 */
	public static boolean waitForTitle(WebDriver driver, String title) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.titleContains(title));
	}

	/*
	 * Wait for page load
	 */
	public static void waitForPageLoad(WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
	}

	/*
	 * Fluent wait
	 */
	public static WebElement fluentWait(WebDriver driver, By locator) {

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(locator);
			}
		});
	}
}
