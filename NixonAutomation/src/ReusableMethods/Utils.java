package ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.IIOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Utils {

	private static final Function visibility = null;

	public static ATUTestRecorder recorder;

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static Actions action;

	public static void OpenBrowser(String Url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\christopher.barreto\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// launch Chrome and direct it to the Base URL
		driver.get(Url);

		wait = new WebDriverWait(driver, 100);

		action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
			driver.findElement(By.className("modal-close")).click();
		}
	}

	public static void CheckoutStep1(String Url) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\christopher.barreto\\Drivers\\chromedriver80.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// launch Chrome and direct it to the Base URL
		driver.get(Url);

		wait = new WebDriverWait(driver, 100);

		action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
			driver.findElement(By.className("modal-close")).click();
		}
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".level-1_item:nth-child(2) .level-1_link-text")));

		WebElement subElement = driver.findElement(By.cssSelector(".level-1_item:nth-child(1) .level-1_link-text"));

		action.moveToElement(subElement).perform();
		//a[contains(.,'Shop All')]
		
		driver.findElement(By.xpath(
				"//a[contains(.,'Shop All')]"))
				.click();
		
		//driver.findElement(By.cssSelector(".level-1_item:nth-child(2) .level-2_item:nth-child(3) .level-3_item:nth-child(2) "
			//	+ " .label-text")).click();

		Thread.sleep(10000);

		if (driver.findElement(By.cssSelector("#modal-email .modal-close")).isDisplayed()) { // if the tag options
																								// is not displayed
			driver.findElement(By.cssSelector("#modal-email .modal-close")).click();
		}

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".product-tile-image")).click();

		// driver.findElement(By.xpath("//li[3]/div/div[2]/div/a/img")).click();

		driver.findElement(By.id("add-to-cart")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("add-to-cart")).click();
			
			Thread.sleep(2000);	
		
		Thread.sleep(2000);

		driver.findElement(By.id("mini-cart")).click();
	}

	public static void Cart2Payment(String email, String firstName, String lastName, String addressLine1, String city,
			String postalCode, String phoneNumber, String state) {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		try {
			if (driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).isDisplayed()) {
				driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
			}

		}

		catch (Exception e) {
			driver.findElement(By.xpath("//a[contains(text(),'Paiement')]")).click();

		}

		driver.findElement(By.id("inputshipping-email")).sendKeys(email);
		driver.findElement(By.id("inputshipping-firstNameField")).sendKeys(firstName);
		driver.findElement(By.id("inputshipping-lastNameField")).sendKeys(lastName);
		driver.findElement(By.id("inputshipping-address1Field")).sendKeys(addressLine1);
		driver.findElement(By.id("inputshipping-cityField")).sendKeys(city);
		driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys(postalCode);
		driver.findElement(By.id("inputshipping-phoneField")).sendKeys(phoneNumber);

		try {
			if (driver.findElement(By.id("dropDownshipping-stateDropDownField")).isDisplayed()) {
				Select drpState = new Select(driver.findElement(By.id("dropDownshipping-stateDropDownField")));
				drpState.selectByVisibleText(state);
			}
		} catch (Exception e) {
		}

		try {
			if (driver.findElement(By.xpath("//input[@value='Continue to Payment']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@value='Continue to Payment']")).click();
			}
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@id='shippingForm']/div[2]/div/input")).click();
		}

	}

	public static void Cart2PaymentJP(String email, String firstName, String lastName, String addressLine1, String city,
			String postalCode, String phoneNumber, int state) {

		driver.findElement(By.cssSelector(".checkout-buttons > .primary-button")).click();
		;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputshipping-email")));
		driver.findElement(By.id("inputshipping-email")).sendKeys(email);
		driver.findElement(By.id("inputshipping-firstNameField")).sendKeys(firstName);
		driver.findElement(By.id("inputshipping-lastNameField")).sendKeys(lastName);
		driver.findElement(By.id("inputshipping-address1Field")).sendKeys(addressLine1);
		driver.findElement(By.id("inputshipping-cityField")).sendKeys(city);
		driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys(postalCode);
		driver.findElement(By.id("inputshipping-phoneField")).sendKeys(phoneNumber);
		driver.findElement(By.id("inputshipping-firstNamePronunciationField")).sendKeys(firstName);
		driver.findElement(By.id("inputshipping-lastNamePronunciationField")).sendKeys(lastName);

		try {

			if (driver.findElement(By.id("dropDownshipping-stateDropDownField")).isDisplayed()) {
				Select drpState = new Select(driver.findElement(By.id("dropDownshipping-stateDropDownField")));
				drpState.selectByIndex(state);
			}
		} catch (NoSuchElementException e) {
		}

		driver.findElement(By.xpath("//div[@id='shippingForm']/div[2]/div/input")).click();

	}

	public static void CreditCardPayment(String ccNumber, String CVV) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);

		String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim(); // .getAttribute("value").trim();
		Thread.sleep(2000);
		System.out.print(value);

		if (!value.equals(ccNumber)) {
			driver.findElement(By.id("inputcardNumberField")).clear();
			driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);
		}

		driver.findElement(By.id("inputcardCodeField")).sendKeys(CVV);

		Select ccMonth = new Select(driver.findElement(By.id("month")));
		ccMonth.selectByVisibleText("10");

		Select ccYear = new Select(driver.findElement(By.id("year")));
		ccYear.selectByVisibleText("2022");

		try {
			driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@id='CREDIT_CARD']/input")).click();
		}

		try {
			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).click();
		} catch (Exception e) {
		}

		driver.findElement(By.cssSelector(".place-order-button")).click();

		Thread.sleep(2500);

	}

	public static void CreditCardPaymentTest(String ccNumber, String CVV) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);

		String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim();
		Thread.sleep(2000);

		if (!value.equals(ccNumber)) {
			driver.findElement(By.id("inputcardNumberField")).clear();
			driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);
		}

		driver.findElement(By.id("inputcardCodeField")).sendKeys(CVV);

		Select ccMonth = new Select(driver.findElement(By.id("month")));
		ccMonth.selectByVisibleText("10");

		Select ccYear = new Select(driver.findElement(By.id("year")));
		ccYear.selectByVisibleText("2022");

		try {
			driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@id='CREDIT_CARD']/input")).click();
		}

		try {
			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).click();
		} catch (Exception e) {
		}

		driver.findElement(By.cssSelector(".place-order-button")).click();

	}

	public static void CreditCardPaymentInternational(String ccNumber, String CVV) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);

		String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim();
		Thread.sleep(2000);

		if (!value.equals(ccNumber)) {
			driver.findElement(By.id("inputcardNumberField")).clear();
			driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);
		}

		driver.findElement(By.id("inputcardCodeField")).sendKeys(CVV);

		Select ccMonth = new Select(driver.findElement(By.id("month")));
		ccMonth.selectByVisibleText("10");

		Select ccYear = new Select(driver.findElement(By.id("year")));
		ccYear.selectByVisibleText("2022");

		try {
			driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@id='CREDIT_CARD']/input")).click();
		}

		try {
			driver.findElement(By.cssSelector("terms-conditions-form")).isDisplayed();
			driver.findElement(By.cssSelector(".terms-conditions-form")).click();
		} catch (Exception e) {

		}

		driver.findElement(By.xpath("//input[@value='Place Order']")).click();

	}

	public static void PaypalPayment() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/div[2]/div/label/span")).click();

		driver.findElement(By.cssSelector(".paypal-button")).click();

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys("christopher.barreto+us@nixon.com");
		driver.findElement(By.id("btnNext")).click();

		driver.findElement(By.id("password")).sendKeys("Welcome123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(5000); //// input[@id='confirmButtonTop']
		WebElement Continue = driver.findElement(By.className("CheckoutButton_buttonWrapper_2VloF"));
		Thread.sleep(2000);
		action.moveToElement(Continue).perform();
		
		try{driver.findElement(By.className("CheckoutButton_buttonWrapper_2VloF")).click();
		}
		catch (Exception e) {
			driver.findElement(By.id("confirmButtonTop")).click();	
		}
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Place
		// Order']"))).click();
		// driver.findElement(By.xpath("//input[@value='Place Order']")).click();
		//driver.findElement(By.id("confirmButtonTop")).click();
		

		try { // driver.findElement(By.className("terms-conditions-form")).click();
			driver.findElement(By.cssSelector(".terms-conditions-form  .control-indicator")).click();
		} catch (Exception e) {
		}
		;

		driver.findElement(By.cssSelector(".place-order-button")).click();

	}

	public static void APPayment(String email, String password) throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[2]/div[3]/div[1]/label/span[1]")).click();

		driver.findElement(By.id("test_afterpayContinue")).click();

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		Thread.sleep(3000);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);

		driver.findElement(By.xpath("//button")).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-child(2)")));
		WebElement Continue = driver.findElement(By.cssSelector("button:nth-child(2)"));
		Thread.sleep(5000);
		action.moveToElement(Continue).perform();
		Continue.click();

		driver.findElement(By.cssSelector("#termsAgreed")).click();
		driver.findElement(By.xpath("//span[contains(.,'Confirm')]")).click();
	}

	public static void ConfirmationScreenshot(String Folder, String folderChild, String Screenshot)
			throws InterruptedException, IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("confirmation-number")));

		WebElement element = driver.findElement(By.id("tt-comment-capture"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", element);
		Thread.sleep(5000);

		// tells the driver ss is the name of the screenshot function
		TakesScreenshot ss = (TakesScreenshot) driver; // setting the file source type in Selenium
		java.io.File source = ss.getScreenshotAs(OutputType.FILE);
		// Copying the Screenshot taken to the correct path for
		FileUtils.copyFile(source, new File("C:\\Users\\christopher.barreto\\Desktop\\Automation.ScreenShots\\Desktop\\"
				+ Folder + "\\" + folderChild + "\\" + Screenshot + ".png"));

		driver.close();
	}

	public static void codPayment() throws InterruptedException, IOException {
		{

			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[2]/div[2]/div/label/span")).click();

			driver.findElement(By.cssSelector(".continue-cod-payment")).click();

			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).click();
			driver.findElement(By.cssSelector(".place-order-button")).click();

		}
	}

	public static void geoClose() {

		if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
			driver.findElement(By.className("modal-close")).click();

		}
	}

	public static void AlreadyRegisteredFooterNewsletterSignup()
			throws IOException, InterruptedException {

		String UsedEmail = "Christopher.Barreto@gmail.com";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,2500)");
		
		Thread.sleep(2500);

		WebElement EFooterField = driver.findElement(By.id("email-alert-address"));
		WebElement Submit = driver.findElement(By.xpath("//*[@id=\"email-alert-signup\"]/div[3]/input"));

		EFooterField.click();
		EFooterField.sendKeys(UsedEmail);
		
		
		try {
		    driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(1) > .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(1) > .control-indicator")).click();
			
			driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(2) > .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(2) > .control-indicator")).click();
			
			Submit.click();
			
		} catch (Exception e) {
		}

		js.executeScript("javascript:window.scrollBy(0,50)");
		
		Thread.sleep(2000);
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 15);
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "dialog-container")));
		 */

	}

	public static void IncorrectFormatFooterNewsletterSignup() throws IOException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,2500)");
		
		Thread.sleep(2500);

		WebElement EFooterField = driver.findElement(By.id("email-alert-address"));
		WebElement Submit = driver.findElement(By.xpath("//*[@id=\"email-alert-signup\"]/div[3]/input"));

		String FakeEmail = "Christopher";

		EFooterField.click();
		EFooterField.sendKeys(FakeEmail);
		Submit.click();

		js.executeScript("javascript:window.scrollBy(0,50)");
		
		Thread.sleep(2000);
		
		EFooterField.clear();

	}

	public static void NewEmailFooterNewsletterSignup() throws IOException, InterruptedException {

		Random rand = new Random();
		int randomnumber = rand.nextInt(100000);

		String NewEmail = "Christopher" + randomnumber + "Barreto@nixon.com";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,2500)");
		
		Thread.sleep(2500);

		WebElement EFooterField = driver.findElement(By.id("email-alert-address"));
		WebElement Submit = driver.findElement(By.xpath("//*[@id=\"email-alert-signup\"]/div[3]/input"));

		EFooterField.click();
		EFooterField.sendKeys(NewEmail);
		Submit.click();
		
		try {
		    driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(1) > .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(1) > .control-indicator")).click();
			
			driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(2) > .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".email-sign-up-submit-container > .control:nth-child(2) > .control-indicator")).click();
			
			Submit.click();
			
		} catch (Exception e) {
		}

		
		js.executeScript("javascript:window.scrollBy(0,50)");
		
		Thread.sleep(3500);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content-asset']/p")));
		

	}

	public static void quitbrowser() {
		driver.quit();
	}

	public static void screenshot(String folder, String folderChild, String screenshot) throws IOException {
		// tells the driver ss is the name of the screenshot function
		TakesScreenshot ss = (TakesScreenshot) driver; // setting the file source type in Selenium
		java.io.File source = ss.getScreenshotAs(OutputType.FILE);
		// Copying the Screenshot taken to the correct path for
		FileUtils.copyFile(source, new File("C:\\Users\\christopher.barreto\\Desktop\\Automation.ScreenShots\\Desktop\\"
				+ folder + "\\" + folderChild + "\\" + screenshot + ".png"));

	}

	public static void videoStart(String folderChild, String name) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yy");
		Date date = new Date();
		// Created object of ATUTestRecorder
		// Provide path to store videos and file name Format //+dateFormat.format(date)
		recorder = new ATUTestRecorder(
				"C:\\Users\\christopher.barreto\\Desktop\\Automation.ScreenShots\\" + folderChild,
				name + dateFormat.format(date), false);
		// To start video recording.
		recorder.start();
	}

	public static void videoEnd() throws Exception {
		recorder.stop();

	}

	public static void RegisteredSignIn(String userName, String password) {
		driver.findElement(By.cssSelector(".user-account-login_text-v2")).click();

		WebElement email = driver.findElement(By.xpath("//form[@id='dwfrm_login']/fieldset/div/input"));// *[@id="dwfrm_login_username_"*]
		WebElement pass = driver.findElement(By.id("dwfrm_login_password"));

		email.sendKeys(userName);
		pass.sendKeys(password);

		driver.findElement(By.cssSelector(".btn-primary:nth-child(2)")).click();

	}

	public static void CheckTitle(String Title) {
		String ActualTitle = driver.getTitle();
		String url = driver.getCurrentUrl();

		if (ActualTitle.equals(Title)) {
			System.out.println("Page" + Title + " is up + Registered Log on have passed");
		}

	}
	
	public static void Klarna(String dobID) throws InterruptedException {
		try {driver.findElement(By.xpath("//span[contains(.,'Pay later')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".continue-klarna-payment")).click();
		Thread.sleep(3000);
		}catch (Exception e) {}
		
		
		try {
			 driver.switchTo().frame(6);
			driver.findElement(By.id("purchase-approval-date-of-birth")).isDisplayed();
		     Thread.sleep(2000);
			 driver.findElement(By.id("purchase-approval-date-of-birth")).sendKeys(dobID);
		     driver.findElement(By.id("purchase-approval-continue")).click();}
		catch(Exception e) {}
		
		try {
			 driver.findElement(By.name("nationalIdentificationNumber")).isDisplayed(); 
			 Thread.sleep(2000);
			 driver.findElement(By.id("purchase-approval-national-identification-number")).sendKeys(dobID);		
			 driver.findElement(By.id("purchase-approval-continue")).click();}
		catch(Exception e) {}
		
	  /*	if (driver.findElement(By.id("purchase-approval-date-of-birth")).isDisplayed())
		   {driver.switchTo().frame(6);
			driver.findElement(By.id("purchase-approval-date-of-birth")).sendKeys(dobID);
		    driver.findElement(By.id("purchase-approval-continue")).click();
		   }
		
		if(driver.findElement(By.id("purchase-approval-national-identification-number")).isDisplayed()) {
			driver.switchTo().frame(6);
		   driver.findElement(By.id("purchase-approval-national-identification-number")).sendKeys(dobID);		
		   driver.findElement(By.id("purchase-approval-continue")).click();
		}*/
		Thread.sleep(10000);
		
		   driver.switchTo().defaultContent();
			
		    driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).click();

		driver.findElement(By.cssSelector(".place-order-button")).click();
}
	public static void Scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,15)");
	}
	
	}


