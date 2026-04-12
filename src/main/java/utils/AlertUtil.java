package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertUtil {
	private WebDriver driver;
	private WebDriverWait wait;

	public AlertUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/*
	 * Wait until alert appears
	 */
	public Alert waitForAlert() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/*
	 * Accept alert
	 */
	public void acceptAlert() {
		waitForAlert().accept();
	}

	/*
	 * Dismiss alert
	 */
	public void dismissAlert() {
		waitForAlert().dismiss();
	}

	/*
	 * Get alert text
	 */
	public String getAlertText() {
		return waitForAlert().getText();
	}

	/*
	 * Send text to alert (Prompt alerts)
	 */
	public void sendTextToAlert(String text) {
		Alert alert = waitForAlert();
		alert.sendKeys(text);
	}

	/*
	 * Check if alert is present
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/*
	 * Accept alert if present
	 */
	public void acceptAlertIfPresent() {
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	/*
	 * Dismiss alert if present
	 */
	public void dismissAlertIfPresent() {
		if (isAlertPresent()) {
			driver.switchTo().alert().dismiss();
		}
	}
}
