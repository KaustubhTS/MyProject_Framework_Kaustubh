package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ScreenshotUtil placeholder - no implementation per user request.
 */
public class ScreenshotUtil {
	
	private static void createScreenshotFolder()
	{

	    File folder =
	            new File(System.getProperty("user.dir") + "/screenshots");

	    if(!folder.exists())
	    {
	        folder.mkdir();
	    }
	}
	
	
	

	public static String captureScreenshot(WebDriver driver, String testName) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String fileName = testName + "_" + timeStamp + ".png";

		String path = System.getProperty("user.dir") + "/screenshots/" + fileName;

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			File destFile = new File(path);

			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			System.out.println("Screenshot failed: " + e.getMessage());
		}

		return path;
	}
	
	
	public static String captureElementScreenshot( WebElement element,String elementName)
	{

	    String timeStamp =
	            new SimpleDateFormat("yyyyMMdd_HHmmss")
	                    .format(new Date());

	    String path =
	            System.getProperty("user.dir")
	                    + "/screenshots/"
	                    + elementName
	                    + "_" + timeStamp + ".png";

	    try {

	        File src = element.getScreenshotAs(OutputType.FILE);

	        FileUtils.copyFile(src, new File(path));

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return path;
	}

}
