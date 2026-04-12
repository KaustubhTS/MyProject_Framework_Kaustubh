package factory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import exceptions.BrowserExceptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser) {

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-save-password-bubble");
			chromeOptions.addArguments("--disable-notifications");

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			chromeOptions.setExperimentalOption("prefs", prefs);

			if (Boolean.parseBoolean(System.getProperty("headless"))) {
				chromeOptions.addArguments("--headless=new");
			}

			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.addArguments("--disable-notifications");

			if (Boolean.parseBoolean(System.getProperty("headless"))) {
				firefoxOptions.addArguments("-headless");
			}

			driver.set(new FirefoxDriver(firefoxOptions));
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();

			EdgeOptions edgeOptions = new EdgeOptions();
			driver.set(new EdgeDriver(edgeOptions));
			if (Boolean.parseBoolean(System.getProperty("headless"))) {
				edgeOptions.addArguments("-headless");
			}

			driver.set(new EdgeDriver(edgeOptions));
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		try {
			if (driver.get() != null) {
				driver.get().quit();
				driver.remove();

			}
		} catch (Exception e) {
			throw new BrowserExceptions("Driver not quit properly", e);
		}
	}
}