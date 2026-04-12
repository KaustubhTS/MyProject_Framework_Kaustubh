package hooks;

import org.apache.logging.log4j.ThreadContext;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class DriverHook {
	
	ConfigReader configReader = ConfigReader.getInstance();// create instance of ConfigReader to read properties
	
	@Before
    public void setup(Scenario scenario) {
       DriverFactory.initDriver(configReader.getBrowser("browser")); // initialize driver based on config
       DriverFactory.getDriver().get(configReader.getUrl("url"));// launch browser
       ThreadContext.put("testName", scenario.getName());
	   ThreadContext.put("threadId", Thread.currentThread().getName());
    }
	
	

    @After
    public void tearDown()  {
    	ThreadContext.clearAll();
        DriverFactory.quitDriver();   // close browser
    }
}