package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class DriverHook {
	
	ConfigReader configReader = ConfigReader.getInstance();// create instance of ConfigReader to read properties
	
	@Before
    public void setup() {
       DriverFactory.initDriver(configReader.getBrowser("browser")); // initialize driver based on config
       DriverFactory.getDriver().get(configReader.getUrl("url"));// launch browser
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();   // close browser
    }
}