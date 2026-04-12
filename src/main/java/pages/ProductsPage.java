package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ProductsPage extends BasePage {

	private By productNames = By.xpath("//div[@class='inventory_list']//descendant::a/div");
	private By productPrices = By.xpath("//div[@class='inventory_list']//descendant::div/div[@class='inventory_item_price']");
	private By addToCartButtons = By.xpath("//div[@class='inventory_list']//button");
	private By shoppingCartLink	 =By.xpath("//a[@class='shopping_cart_link']");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickShoppingCart() {
		click(shoppingCartLink);
	}

	public List<WebElement> getAllProducts() { 
		return getElements(productNames);
	}

	public void addProductToCart(String productName) {

		List<WebElement> products = getElements(productNames);
		List<WebElement> buttons = getElements(addToCartButtons);

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equalsIgnoreCase(productName)) {
				buttons.get(i).click();
				break;
			}
		}
	}

}
