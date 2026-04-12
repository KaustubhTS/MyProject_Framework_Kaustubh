package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utils.AlertUtil;

public class LoginPage extends BasePage {

	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By errorMsg = By.cssSelector("h3[data-test='error']");
	AlertUtil alertUtil = new AlertUtil(driver);

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String user) {
		type(username, user);

	}

	public void enterPassword(String pass) {
		type(password, pass);

	}

	public void clickLogin() {

		click(loginBtn);

	}

	public boolean isLoginSuccessful() {
		return driver.getCurrentUrl().contains("inventory");
	}

	public boolean isLoginFailed() {
		// First check if element exists to avoid NoSuchElementException
		return !driver.findElements(errorMsg).isEmpty() && driver.findElement(errorMsg).isDisplayed();
	}
}