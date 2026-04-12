package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.LoginActions;
import actions.ProductsPageActions;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginAndAddItemsToCart {

	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	LoginActions loginActions = new LoginActions(driver);
	ProductsPageActions productsPageActions = new ProductsPageActions(driver);
	
	private boolean isLoginSuccessful;

	@Given("User logs in with {string} and {string}")
	public void user_logs_in(String username, String password) {
		isLoginSuccessful = loginActions.login(username, password);
	}

	@Then("Login should be {string}")
	public void login_should_be(String status) {

		if (status.equalsIgnoreCase("success")) {
			Assert.assertTrue(isLoginSuccessful);
		} else {
			Assert.assertFalse(isLoginSuccessful);
		}
	}

	@Then("User adds product {string}")
	public void user_adds_product(String product) {
		productsPageActions.addItemIfLoginSuccess(isLoginSuccessful, product);
		productsPageActions.clickShoppingCart();
	}



	
}
