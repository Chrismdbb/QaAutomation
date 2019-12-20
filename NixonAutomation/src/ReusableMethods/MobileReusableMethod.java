package ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileReusableMethod {
	public static WebDriver driver;
	
	

	        
	       
	     
	
      
       static public void Takescreenshots(String Folder, String Folder2, String Screenshot) throws IOException {
   		// tells the driver ss is the name of the screenshot function
   		TakesScreenshot ss = (TakesScreenshot) driver;
   		// setting the file source type in Selenium
   		java.io.File source = ss.getScreenshotAs(OutputType.FILE);
   		// Copying the Screenshot taken to the correct path for
   		FileUtils.copyFile(source,
   				new File("C:\\Users\\christopher.barreto\\Desktop\\Automation.ScreenShots\\Mobile\\" + Folder + "\\"+ Folder2 + "\\" + Screenshot + ".png"));  
       }
       
   	public void quitbrowser() {
		driver.close();
	}

   	
   	
   	
}
