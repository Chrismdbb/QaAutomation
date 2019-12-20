package Nixon.Mobile.CheckoutPaymentTypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ReusableMethods.MobileUtils;
import ReusableMethods.Utils;
import ReusableMethods.MobileReusableMethod;


public class Mobile_checkoutAllPaymentsAU  {
	

	@Test
	void test() throws Exception {
		
		String[] Payment;
		Payment = new String[3];
		
		Payment[0] = "Visa";
		Payment[1] = "MasterCard";
		Payment[2] = "AfterPay";
		
		
	
		for (int i = 0; i < Payment.length; i++) {
			
			String url = "au_en_";

			Utils.videoStart("Regression", "MobileCheckout\\" + url+ Payment);

			MobileUtils.MobileTestiPhone("https://storefront:Nixonat701@stg.nixon.com/au/en");
			MobileUtils.MobileAddtoCart();
			MobileUtils.MobileCheckoutStep1("Christopher.Barreto@nixon.com","Christopher", "Barreto","701 N. Coast Hwy",
					"Syndey","2000","7604056763","Queensland");
			
			switch (Payment[i]) {
			
			case "Visa":
				MobileUtils.MobileCreditCardPayment("4111 1111 1111 1111", "123");
				break;
			
			case "MasterCard":
				MobileUtils.MobileCreditCardPayment("5555555555554444", "123");
				break;

			case "AfterPay":
				Utils.APPayment("Christopher.Barreto@nixon.com", "!Panem@1991");
				break;
				
			
				
			}
			
			Utils.videoEnd();
			MobileUtils.quitBrowser();
			
		
	}
	
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
 * @Test void test() throws Exception {
 * 
 * String Email = "Christopher.Barreto@nixon.com"; String Fname = "Christopher";
 * String Lname = " Automation Test"; String add = "1/9 Ramly Drive"; String
 * city = "Burleigh Heads"; String Pcode = "4220"; String Phone = "7604056763";
 * 
 * String[] Payment; Payment = new String[2];
 * 
 * Payment[0] = "Visa"; Payment[1] = "MasterCard";
 * 
 * String Urls = "https://storefront:nix2015@stg.nixon.com/au/en";
 * 
 * for (int i = 0; i < Payment.length; i++) {
 * MobileUtils.MobileTestiPhone(Urls);
 * 
 * WebDriverWait wait = new WebDriverWait(driver, 20);
 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 * 
 * if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if
 * the tag options is not displayed
 * driver.findElement(By.className("modal-close")).click(); }
 * 
 * Thread.sleep(2000);
 * driver.findElement(By.className("header_menu--mobile")).click();
 * Thread.sleep(1000);
 * 
 * driver.findElement(By.className("label-text")).click(); Thread.sleep(1000);
 * driver.findElement(By.xpath(
 * "//*[@id=\"navigation\"]/ul/li[1]/div[2]/ul/li[2]/a")).click();
 * 
 * Actions action = new Actions(driver);
 * 
 * driver.findElement(By.xpath("//li[1]/div/div[2]/div/a/img")).click();
 * 
 * 
 * if (driver.findElement(By.className("exit-email-sign-up-input-container")).
 * isDisplayed()) { // if the tag
 * action.moveToElement(driver.findElement((By.className("modal-close"))));
 * driver.findElement(By.className("modal-close")).click(); }
 * 
 * JavascriptExecutor js = (JavascriptExecutor) driver;
 * js.executeScript("javascript:window.scrollBy(0,15)");
 * 
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//button[@id='add-to-cart']"))); WebElement Button =
 * driver.findElement(By.xpath("//button[@id='add-to-cart']"));
 * 
 * action.moveToElement(Button);
 * 
 * driver.findElement(By.id("add-to-cart")).click(); Thread.sleep(2000);
 * driver.findElement(By.id("mini-cart")).click(); Thread.sleep(2000);
 * driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
 * driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
 * 
 * js.executeScript("javascript:window.scrollBy(0,465)");
 * 
 * driver.findElement(By.id("inputshipping-email")).sendKeys(Email);
 * driver.findElement(By.id("inputshipping-firstNameField")).sendKeys(Fname);
 * driver.findElement(By.id("inputshipping-lastNameField")).sendKeys(Lname);
 * driver.findElement(By.id("inputshipping-address1Field")).sendKeys(add);
 * driver.findElement(By.id("inputshipping-cityField")).sendKeys(city);
 * driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys(Pcode);
 * driver.findElement(By.id("inputshipping-phoneField")).sendKeys(Phone);
 * 
 * // driver.findElement(By.id("dropDownshipping-stateDropDownField")).click();
 * 
 * Select drpState = new
 * Select(driver.findElement(By.id("dropDownshipping-stateDropDownField")));
 * drpState.selectByVisibleText("Queensland");
 * 
 * driver.findElement(By.xpath("//input[@value='Continue to Payment']")).click()
 * ;
 * 
 * if (i == 0) {
 * 
 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 * driver.findElement(By.id("inputcardNumberField")).
 * sendKeys("4111 1111 1111 1111");
 * 
 * String value =
 * driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim(
 * ); Thread.sleep(2000);
 * 
 * if (!value.equals("4111 1111 1111 1111")) {
 * driver.findElement(By.id("inputcardNumberField")).clear();
 * driver.findElement(By.id("inputcardNumberField")).sendKeys("4111111111111111"
 * ); }
 * 
 * driver.findElement(By.id("inputcardCodeField")).sendKeys("123");
 * 
 * Select ccMonth = new Select(driver.findElement(By.id("month")));
 * ccMonth.selectByVisibleText("10");
 * 
 * Select ccYear = new Select(driver.findElement(By.id("year")));
 * ccYear.selectByVisibleText("2021");
 * 
 * driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).
 * click();
 * 
 * driver.findElement(By.xpath("//input[@value='Place Order']")).click();
 * 
 * }
 * 
 * else if (i == 1) {
 * 
 * Thread.sleep(3000);
 * 
 * driver.findElement(By.id("inputcardNumberField")).
 * sendKeys("5555 5555 5555 4444"); String value =
 * driver.findElement(By.id("inputcardNumberField")).getAttribute("value");
 * 
 * Thread.sleep(2000);
 * 
 * if (!value.equals("5555 5555 5555 4444")) {
 * driver.findElement(By.id("inputcardNumberField")).clear();
 * driver.findElement(By.id("inputcardNumberField")).
 * sendKeys("5555 5555 5555 4444"); }
 * driver.findElement(By.id("inputcardCodeField")).sendKeys("123");
 * 
 * Select ccMonth = new Select(driver.findElement(By.id("month")));
 * ccMonth.selectByVisibleText("10");
 * 
 * Select ccYear = new Select(driver.findElement(By.id("year")));
 * ccYear.selectByVisibleText("2021");
 * 
 * driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).
 * click();
 * 
 * driver.findElement(By.xpath("//input[@value='Place Order']")).click();
 * 
 * }
 * 
 * Thread.sleep(3000);
 * 
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
 * "confirmation-number")));
 * 
 * WebElement element = driver.findElement(By.id("tt-comment-capture"));
 * ((JavascriptExecutor)
 * driver).executeScript("arguments[0].style.visibility='hidden'", element);
 * Thread.sleep(2000);
 * 
 * 
 * WebElement Linc3 = driver.findElement(By.className("dialog_window"));
 * ((JavascriptExecutor)
 * driver).executeScript("arguments[0].style.visibility='hidden'", Linc3);
 * 
 * 
 * Takescreenshots("Nixon.Mobile.CheckoutAllPayments", "CA_STG_Orders",
 * Payment[i]);
 * 
 * quitbrowser();
 * 
 * } } }
 * 
 * 
 */