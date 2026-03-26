package actions;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class LoginActions {

	private LoginPage page;

    public LoginActions(WebDriver driver) {
        this.page = new LoginPage(driver);
    }

	public void login(String user, String pass) {
		page.enterUsername(user);
		page.enterPassword(pass);
		page.clickLogin();
	}

}
