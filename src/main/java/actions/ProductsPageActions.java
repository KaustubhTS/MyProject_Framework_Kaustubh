package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import logger.loggerUtil;
import pages.ProductsPage;

public class ProductsPageActions {
	private ProductsPage productsPage;

	private static final Logger log = loggerUtil.getLogger(ProductsPageActions.class);

	public ProductsPageActions(WebDriver driver) {
		this.productsPage = new ProductsPage(driver);
	}

	public void addItemIfLoginSuccess(boolean status, String product) {

		if (status) {
			productsPage.addProductToCart(product);
			log.info("Product {} added", product);
		} else {
			log.info("Skipping add to cart because login failed");
		}
	}
	
	public void clickShoppingCart() {
		productsPage.clickShoppingCart();
		log.info("Clicked on shopping cart");
	}
}
