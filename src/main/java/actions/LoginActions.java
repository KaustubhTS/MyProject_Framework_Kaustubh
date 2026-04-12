package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import logger.loggerUtil;
import pages.LoginPage;

public class LoginActions {
	private static final Logger log = loggerUtil.getLogger(LoginActions.class);
	private LoginPage page;

    public LoginActions(WebDriver driver) {
        this.page = new LoginPage(driver);
    }
    
    
    public boolean login(String username, String password) {

        log.info("Login Test Started for User '{}'", username);

        page.enterUsername(username);
        page.enterPassword(password);
        page.clickLogin();
        
       

        boolean status = page.isLoginSuccessful();

        log.info("Login status for {} = {}", username, status);  
        log.info("Login Test Ended");

        return status;
    }
	
	public boolean loginStatus(String username, String password) {
		page.enterUsername(username);
		page.enterPassword(password);
		page.clickLogin();

        return page.isLoginSuccessful();
    }

}
