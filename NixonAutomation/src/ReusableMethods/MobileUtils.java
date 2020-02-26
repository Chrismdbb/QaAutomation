package ReusableMethods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileUtils {

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static Actions action;

	// sets the size of the emulator/viewport
	public static void MobileTestiPhone(String Url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\christopher.barreto\\Drivers\\chromedriver80.exe");

		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone 6/7/8 Plus");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		driver = new ChromeDriver(chromeOptions);

		// launch Chrome and direct it to the Base URL
		driver.get(Url);
	}

	public static void MobileSignIn(String email, String password) throws InterruptedException {
		WebElement Menu = driver.findElement(By.cssSelector(".header_menu-hamburger-icon--mobile"));
		Menu.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".level-1_item .user-account-login_text-v2")).click();

		// Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dwfrm_login")));

		// WebElement MLogin = driver.findElement(By.id("dwfrm_login"));
		WebElement MLogin = driver.findElement(By.xpath("//form[@id='dwfrm_login']/fieldset/div/input"));
		MLogin.sendKeys(email);

		WebElement MPass = driver.findElement(By.id("dwfrm_login_password"));
		MPass.sendKeys(password);

		driver.findElement(By.cssSelector(".btn-primary:nth-child(2)")).click();
	}

	public static void quitBrowser() {
		driver.close();
	}

	public static void MobileNewUser() throws InterruptedException {
		WebElement Menu = driver.findElement(By.cssSelector(".header_menu-hamburger-icon--mobile"));
		Menu.click();

		wait = new WebDriverWait(driver, 100);

		driver.findElement(By.cssSelector(".level-1_item .user-account-login_text-v2")).click();
		// driver.findElement(By.xpath("(//a[@id='menuLink1']/span)[2]")).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dwfrm_login_register")));
		driver.findElement(By.id("dwfrm_login_register")).click();

		Random rand = new Random();
		int randomnumber = rand.nextInt(100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dwfrm_profile_customer_firstname")));

		driver.findElement(By.id("dwfrm_profile_customer_firstname")).sendKeys("Christopher");
		driver.findElement(By.id("dwfrm_profile_customer_lastname")).sendKeys("Barreto");

		WebElement Email = driver.findElement(By.id("dwfrm_profile_customer_email"));
		Email.sendKeys("Chrismdbb+" + randomnumber + "@gmail.com");

		WebElement EmailConfirm = driver.findElement(By.id("dwfrm_profile_customer_emailconfirm"));
		EmailConfirm.sendKeys("Chrismdbb+" + randomnumber + "@gmail.com");

		WebElement Password = driver.findElement(By.id("dwfrm_profile_login_password"));
		Password.sendKeys("1qaz@WSX");

		WebElement PasswordConfirm = driver.findElement(By.id("dwfrm_profile_login_passwordconfirm"));
		PasswordConfirm.sendKeys("1qaz@WSX");

		try {
			// driver.findElement(By.cssSelector(".input-checkbox
			// .control-indicator:nth-child(1)")).click();
			// driver.findElement(By.cssSelector(".form-row:nth-child(7)
			// .control-indicator")).click();
			// driver.findElement(By.cssSelector(".form-row:nth-child(8)
			// .control-indicator")).click();
			// driver.findElement(By.cssSelector(".input-checkbox
			// .control-indicator:nth-child(2)")).click();
			driver.findElement(By.xpath("//form[@id='RegistrationForm']/fieldset[2]/div[5]/label/span[2]")).click();
			driver.findElement(By.xpath("//form[@id='RegistrationForm']/fieldset[2]/div[6]/label/span[2]")).click();

			// driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset[2]/div[7]/button")).click();
			WebElement form = driver.findElement(By.id("dwfrm_profile_login_passwordconfirm"));
			form.submit();

		} catch (Exception e) {
			WebElement form = driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset[2]/div[7]/button"));
			form.submit();
		}

		Thread.sleep(3000);
	}

	public static void MobileAddtoCart() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
			driver.findElement(By.className("modal-close")).click();
		}

		Thread.sleep(2000);
		driver.findElement(By.className("header_menu--mobile")).click();
		Thread.sleep(2000);

		/* driver.findElement(By.className("label-text")).click(); */
		
		driver.findElement(By.xpath("//nav[@id='navigation']/ul/li[2]/div/button/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//nav[@id='navigation']/ul/li[2]/div[2]/ul/li[2]/a/span")).click();

		Actions action = new Actions(driver);

		Thread.sleep(8000);
		if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag

			Thread.sleep(5000);
			action.moveToElement(driver.findElement((By.className("modal-close"))));

			driver.findElement(By.className("modal-close")).click();
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a/img")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,15)");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='add-to-cart']")));
		WebElement Button = driver.findElement(By.xpath("//button[@id='add-to-cart']"));

		action.moveToElement(Button);

		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("mini-cart")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	public static void MobileCheckoutStep1(String email, String firstName, String lastName, String addressLine1,
			String city, String postalCode, String phoneNumber, String state) {

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

	public static void MobileCreditCardPayment(String ccNumber, String CVV) throws InterruptedException {

		driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);

		String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim();
		Thread.sleep(2000);

		if (!value.equals(ccNumber)) {
			driver.findElement(By.id("inputcardNumberField")).clear();
			driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);
		}

		driver.findElement(By.id("inputcardCodeField")).sendKeys(CVV);

		Select ccMonth = new Select(driver.findElement(By.name("month")));
		ccMonth.selectByVisibleText("10");

		Select ccYear = new Select(driver.findElement(By.name("year")));
		ccYear.selectByVisibleText("2022");

		Thread.sleep(2500);

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
	
	public static void MobileCreditCardPaymentJPEU (String ccNumber, String CVV) throws InterruptedException {

		driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);

		String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim();
		Thread.sleep(2000);

		if (!value.equals(ccNumber)) {
			driver.findElement(By.id("inputcardNumberField")).clear();
			driver.findElement(By.id("inputcardNumberField")).sendKeys(ccNumber);
		}

		driver.findElement(By.id("inputcardCodeField")).sendKeys(CVV);

		Select ccMonth = new Select(driver.findElement(By.name("month")));
		ccMonth.selectByVisibleText("10");

		Select ccYear = new Select(driver.findElement(By.name("year")));
		ccYear.selectByVisibleText("2022");

		Thread.sleep(2500);

		try {
			driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@id='CREDIT_CARD']/input")).click();
		}

			Thread.sleep(3000);
		    driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).isDisplayed();
			driver.findElement(By.cssSelector(".terms-conditions-form .control-indicator")).click();
		
		     driver.findElement(By.cssSelector(".place-order-button")).click();
	}

	public static void MobileOrderConfirmation() throws InterruptedException {

		Thread.sleep(4000);
		try {
		WebElement element = driver.findElement(By.id("tt-comment-capture"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.visibility='hidden'", element);
		Thread.sleep(5000);} catch (Exception e) {}
	}

	public static void PaypalPayment(String email, String password) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/div[2]/div/label/span")).click();

		driver.findElement(By.cssSelector(".paypal-button")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-submit-btn")));

		Thread.sleep(10000); //// input[@id='confirmButtonTop']
		driver.findElement(By.id("payment-submit-btn")).click();
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
		Thread.sleep(5000);
	}

	public static void APPayment(String email, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver,10);
		Actions action = new Actions(driver);
		
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//div[2]/div[3]/div[1]/label/span[1]")).click();
		driver.findElement(By.xpath("//div[2]/div[3]/div/label/span")).click();
		
		driver.findElement(By.id("test_afterpayContinue")).click();


		Thread.sleep(5000);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-schedule__modal-footer")));
		WebElement Continue = driver.findElement(By.className("payment-schedule__modal-footer"));
		Thread.sleep(5000);
		action.moveToElement(Continue).perform();
		Continue.click();

		driver.findElement(By.className("checkbox__tick")).click();
		driver.findElement(By.xpath("//span[contains(.,'Confirm')]")).click();
		Thread.sleep(5000);
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
	
	public static void Cart2PaymentJP(String email, String firstName, String lastName, String addressLine1, String city,
			String postalCode, String phoneNumber, int state) throws InterruptedException {

		driver.findElement(By.cssSelector(".checkout-buttons > .primary-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputshipping-email")));
		driver.findElement(By.id("inputshipping-email")).sendKeys(email);
		driver.findElement(By.id("inputshipping-firstNameField")).sendKeys(firstName);
		driver.findElement(By.id("inputshipping-lastNameField")).sendKeys(lastName);
		driver.findElement(By.id("inputshipping-address1Field")).sendKeys(addressLine1);
		driver.findElement(By.id("inputshipping-cityField")).sendKeys(city);
		driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys(postalCode);
		Thread.sleep(1000);
		driver.findElement(By.name("phone")).sendKeys(phoneNumber);
		driver.findElement(By.name("phone")).sendKeys(phoneNumber);
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
	
}