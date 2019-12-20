package ReusableMethods;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethod {
	public static WebDriver driver;

//	public static Actions action = new Actions(driver);
//	static WebDriver driver;

	static public void Takescreenshots(String Folder, String Screenshot) throws IOException {
		// tells the driver ss is the name of the screenshot function
		TakesScreenshot ss = (TakesScreenshot) driver;
		// setting the file source type in Selenium
		java.io.File source = ss.getScreenshotAs(OutputType.FILE);
		// Copying the Screenshot taken to the correct path for
		FileUtils.copyFile(source, new File("C:\\Users\\christopher.barreto\\Desktop\\Automation.ScreenShots\\Desktop\\"
				+ Folder + "\\" + Screenshot + ".png"));
	}

	static public void Takescreenshots2(String Folder, String Folderchild, String Screenshot) throws IOException {
		// tells the driver ss is the name of the screenshot function
		TakesScreenshot ss = (TakesScreenshot) driver;
		// setting the file source type in Selenium
		java.io.File source = ss.getScreenshotAs(OutputType.FILE);
		// Copying the Screenshot taken to the correct path for
		FileUtils.copyFile(source, new File("C:\\Users\\christopher.barreto\\Desktop\\Automation.ScreenShots\\Desktop\\"
				+ Folder + "\\" + Folderchild + "\\" + Screenshot + ".png"));

	}

	public static void openbrowser(String Url) {
		// this is the boiler plate for selenium web driver to instantiate the Chrome
		// driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\christopher.barreto\\Drivers\\chromedriver_V76.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// launch Chrome and direct it to the Base URL
		driver.get(Url);

	}

	public void quitbrowser() {
		driver.close();
	}

	

	public void CheckTitle(String Title) {
		String ActualTitle = driver.getTitle();
		String url = driver.getCurrentUrl();

		if (ActualTitle.equals(Title)) {
			System.out.println("Page" + Title + " is up + Registered Log on have passed");
		}
		

	}

	/*
	 * public static void rand() { Random rand = new Random(); int randomnumber =
	 * rand.nextInt(100000);
	 * 
	 * 
	 * }
	 */

	public static void Createuser() {
		Random rand = new Random();
		int randomnumber = rand.nextInt(100000);

		Actions action = new Actions(driver);

		driver.findElement(By.className("user-account-login_text-v2")).click();
		driver.findElement(By.xpath("//button[@name='dwfrm_login_register']")).click();
		driver.findElement(By.id("dwfrm_profile_customer_firstname")).sendKeys("Christopher");
		driver.findElement(By.id("dwfrm_profile_customer_lastname")).sendKeys("Barreto");

		WebElement Email = driver.findElement(By.id("dwfrm_profile_customer_email"));
		Email.sendKeys("NixonAutomation+" + randomnumber + "@gmail.com");

		WebElement EmailConfirm = driver.findElement(By.id("dwfrm_profile_customer_emailconfirm"));
		EmailConfirm.sendKeys("NixonAutomation+" + randomnumber + "@gmail.com");

		WebElement Password = driver.findElement(By.id("dwfrm_profile_login_password"));
		Password.sendKeys("1qaz@WSX");

		WebElement PasswordConfirm = driver.findElement(By.id("dwfrm_profile_login_passwordconfirm"));
		PasswordConfirm.sendKeys("1qaz@WSX");

		String url = driver.getCurrentUrl();

		if (url.contains("jp/ja")) {
			driver.findElement(By.id("dwfrm_profile_customer_lastNamePronunciation")).sendKeys("Barreto");
			driver.findElement(By.id("dwfrm_profile_customer_firstNamePronunciation")).sendKeys("Christopher");
		}

		else if (url.contains("fr/fr")) {

			driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset[2]/div[9]/button")).click();
			driver.findElement(By.cssSelector(".form-row:nth-child(7) .control-indicator")).click();
			driver.findElement(By.cssSelector(".form-row:nth-child(8) .control-indicator")).click();
			driver.findElement(By.cssSelector(".form-row:nth-child(9) .control-indicator")).click();

		}

		else if (url.contains("uk/en")) {

			driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset[2]/div[9]/button")).click();
			driver.findElement(By.cssSelector(".form-row:nth-child(7) .control-indicator")).click();
			driver.findElement(By.cssSelector(".form-row:nth-child(8) .control-indicator")).click();
			driver.findElement(By.cssSelector(".form-row:nth-child(9) .control-indicator")).click();
		}

		driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset[2]/div[7]/button")).click();
	}

	public static void RegisteredInfo() {
		driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@nixon.com");
		driver.findElement(By.id("inputshipping-firstNameField")).sendKeys("Christopher");
		driver.findElement(By.id("inputshipping-lastNameField")).sendKeys("Nixon Test");
		driver.findElement(By.id("inputshipping-address1Field")).sendKeys("701 Nixon Test Street");
		driver.findElement(By.id("inputshipping-cityField")).sendKeys("Test City");
		driver.findElement(By.id("dropDownshipping-stateDropDownField")).sendKeys("NixonAutomation@nixon.com");
		driver.findElement(By.xpath("//div[7]/div[2]/div/select")).click();
		driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys("92024");
		driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@nixon.com");
		driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@nixon.com");
		driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@nixon.com");
		driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@nixon.com");
		driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@nixon.com");
	}

}
