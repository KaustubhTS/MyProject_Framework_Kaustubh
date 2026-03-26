package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.LoginActions;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginSteps {
	
	 WebDriver driver = DriverFactory.getDriver();
	    LoginPage loginPage = new LoginPage(driver);
	    LoginActions loginActions = new LoginActions(driver);

	    @Given("User logs in with {string} and {string}")
	    public void user_logs_in(String username, String password) {
	        loginActions.login(username, password);
	    }

	    @Then("Login should be {string}")
	    public void login_should_be(String status) {

	        if (status.equalsIgnoreCase("success")) {
	            Assert.assertTrue(loginPage.isLoginSuccessful());
	        } else {
	            Assert.assertTrue(loginPage.isLoginFailed());
	        }
	    }


}
