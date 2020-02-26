import java.awt.Window;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;
import ReusableMethods.Utils;
import atu.testrecorder.ATUTestRecorder;

public class TestClass2 {

	ATUTestRecorder recorder;
	
	@Test
	void test() throws Exception {
	

	
	
	String Url = "https://www.nixon.com/us/en/time-teller/A045-511-00.html";

	WebDriver driver;

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\christopher.barreto\\Drivers\\chromedriver80.exe");
	driver = new ChromeDriver();

	driver.manage().window().maximize();

	// launch Chrome and direct it to the Base URL
	driver.get(Url);

	WebDriverWait wait = new WebDriverWait(driver, 100);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement header1 = driver.findElement(By.tagName("h1"));
	System.out.println(header1);

	
}
}