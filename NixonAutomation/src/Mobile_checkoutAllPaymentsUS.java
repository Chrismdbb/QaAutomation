

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ReusableMethods.MobileReusableMethod;

public class Mobile_checkoutAllPaymentsUS extends MobileReusableMethod {

	@Test
	void test() throws Exception {

		String Email = "Christopher.Barreto@nixon.com";
		String Fname = "Christopher";
		String Lname = " Automation Test";
		String USadd = "3668 Harvard Drive";
		String UScity = "oceanside";
		String Pcode = "92056";
		String Phone = "7604056763";

		String[] Payment;
		Payment = new String[6];

		Payment[0] = "Visa";
		Payment[1] = "MasterCard";
		Payment[2] = "American Express"; 
	    Payment[3] = "Discover"; 
		Payment[4] = "Paypal";   
		Payment[5] = "AfterPay";
		 
		String Urls = "https://storefront:nix2015@stg.nixon.com/us/en";

		for (int i = 0; i < Payment.length; i++) {
			MobileTestiPhone(Urls);
			
			WebDriverWait wait = new WebDriverWait(driver, 1000);

			if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
				driver.findElement(By.className("modal-close")).click();
			}

			Thread.sleep(2000);
			driver.findElement(By.className("header_menu--mobile")).click();
			Thread.sleep(1000);

			driver.findElement(By.className("label-text")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[1]/div[2]/ul/li[2]/a")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-close")));

			Thread.sleep(5000);

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement((By.className("modal-close"))));

			if (driver.findElement(By.className("exit-email-sign-up-input-container")).isDisplayed()) { // if the tag
																										// options
				// is not displayed
				driver.findElement(By.className("modal-close")).click();
			}

			driver.findElement(By.xpath("//li[2]/div/div[2]/div/a/img")).click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,15)");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='add-to-cart']")));
			WebElement Button = driver.findElement(By.xpath("//button[@id='add-to-cart']"));

			action.moveToElement(Button);
			
			driver.findElement(By.id("add-to-cart")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("mini-cart")).click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

			js.executeScript("javascript:window.scrollBy(0,465)");

			driver.findElement(By.id("inputshipping-email")).sendKeys(Email);
			driver.findElement(By.id("inputshipping-firstNameField")).sendKeys(Fname);
			driver.findElement(By.id("inputshipping-lastNameField")).sendKeys(Lname);
			driver.findElement(By.id("inputshipping-address1Field")).sendKeys(USadd);
			driver.findElement(By.id("inputshipping-cityField")).sendKeys(UScity);
			driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys(Pcode);
			driver.findElement(By.id("inputshipping-phoneField")).sendKeys(Phone);

			// driver.findElement(By.id("dropDownshipping-stateDropDownField")).click();

			Select drpState = new Select(driver.findElement(By.id("dropDownshipping-stateDropDownField")));
			drpState.selectByVisibleText("California");

			driver.findElement(By.xpath("//input[@value='Continue to Payment']")).click();

			if (i == 0) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.findElement(By.id("inputcardNumberField")).sendKeys("4111 1111 1111 1111");

				String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value");

				Thread.sleep(2000);

				if (!value.equals("4111 1111 1111 1111")) {
					driver.findElement(By.id("inputcardNumberField")).clear();
					driver.findElement(By.id("inputcardNumberField")).sendKeys("4111 1111 1111 1111");
				}

				driver.findElement(By.id("inputcardCodeField")).sendKeys("123");

				Select ccMonth = new Select(driver.findElement(By.id("month")));
				ccMonth.selectByVisibleText("10");

				Select ccYear = new Select(driver.findElement(By.id("year")));
				ccYear.selectByVisibleText("2021");

				driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.className("review-order-submit")).click();

			}

			else if (i == 1) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				driver.findElement(By.id("inputcardNumberField")).sendKeys("5555 5555 5555 4444");
				String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value");

				Thread.sleep(2000);

				if (!value.equals("5555 5555 5555 4444")) {
					driver.findElement(By.id("inputcardNumberField")).clear();
					driver.findElement(By.id("inputcardNumberField")).sendKeys("5555 5555 5555 4444");
				}
				driver.findElement(By.id("inputcardCodeField")).sendKeys("123");

				Select ccMonth = new Select(driver.findElement(By.id("month")));
				ccMonth.selectByVisibleText("10");

				Select ccYear = new Select(driver.findElement(By.id("year")));
				ccYear.selectByVisibleText("2021");

				driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();

				driver.findElement(By.className("review-order-submit")).click();

			}

			else if (i == 2) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				driver.findElement(By.id("inputcardNumberField")).sendKeys("3787 344936 71000");

				String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value");
				Thread.sleep(2000);

				if (!value.equals("3787 344936 71000")) {
					driver.findElement(By.id("inputcardNumberField")).clear();
					driver.findElement(By.id("inputcardNumberField")).sendKeys("378734493671000");
				}

				driver.findElement(By.id("inputcardCodeField")).sendKeys("1234");

				Select ccMonth = new Select(driver.findElement(By.id("month")));
				ccMonth.selectByVisibleText("10");

				Select ccYear = new Select(driver.findElement(By.id("year")));
				ccYear.selectByVisibleText("2021");

				driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();

				driver.findElement(By.className("review-order-submit")).click();

			}

			else if (i == 3) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				driver.findElement(By.id("inputcardNumberField")).sendKeys("6011 1111 1111 1117");

				String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value");

				Thread.sleep(2000);

				if (!value.equals("6011 1111 1111 1117")) {
					driver.findElement(By.id("inputcardNumberField")).clear();
					driver.findElement(By.id("inputcardNumberField")).sendKeys("6011111111111117");
				}

				driver.findElement(By.id("inputcardCodeField")).sendKeys("123");

				Select ccMonth = new Select(driver.findElement(By.id("month")));
				ccMonth.selectByVisibleText("10");

				Select ccYear = new Select(driver.findElement(By.id("year")));
				ccYear.selectByVisibleText("2021");

				driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();

				driver.findElement(By.className("review-order-submit")).click();

			}

			
			  if (i == 4) {
			  
			  Thread.sleep(2000);
			  
			  WebElement Paypal =
			  driver.findElement(By.xpath("//div[2]/div[2]/div[1]/label/span[1]")); //[1]
			  
			  js.executeScript("javascript:window.scrollBy(0,100)");
			  
			  action.moveToElement(Paypal); Paypal.click();
			  
			  driver.findElement(By.className("paypal-button-img")).click();
			  
			  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			  
			  driver.findElement(By.id("email")).sendKeys(
			  "christopher.barreto+us@nixon.com");
			  driver.findElement(By.id("btnNext")).click();
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			  
			  driver.findElement(By.id("password")).sendKeys("Welcome123");
			  driver.findElement(By.id("btnLogin")).click();
			  
			  Thread.sleep(5000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
			  "confirmButtonTop"))); js.executeScript("javascript:window.scrollBy(0,100)");
			  
			  Thread.sleep(10000); js.executeScript("javascript:window.scrollBy(0,100)");
			  driver.findElement(By.xpath("//input[@id='confirmButtonTop']")).click();
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.
			  xpath("//input[@value='Place Order']")));
			  driver.findElement(By.className("review-order-submit")).click();
			  
			  }
			 

			 if (i == 5) {
				Thread.sleep(2000);
				js.executeScript("javascript:window.scrollBy(0,100)");
				 
				driver.findElement(By.xpath("//div[2]/div[3]/div/label/span")).click();

				driver.findElement(By.id("test_afterpayContinue")).click();

				Thread.sleep(4000);

				driver.findElement(By.name("email")).clear();
				driver.findElement(By.name("email")).sendKeys("Chrismdbb@gmail.com");

				driver.findElement(By.xpath("//button")).click();

				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".input")));
				driver.findElement(By.cssSelector(".input")).sendKeys("!Panem@1991");
				driver.findElement(By.xpath("//button")).click();
				
				Thread.sleep(5000);
				
				/* driver.findElement(By.xpath("//button[contains('Okay, got it!')]")); */
				
				driver.findElement(By.cssSelector("body > div.main > section.view-section.ng-scope > section > form > div > payment-schedule > section > due-today > section > div > div.modal-payment-up-front.hide-outline.ng-scope > button")).click();
				
				/*
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				 * "button:nth-child(2)"))); WebElement Continue =
				 * driver.findElement(By.cssSelector("button:nth-child(2)"));
				 * Thread.sleep(5000); action.moveToElement(Continue).perform();
				 * Continue.click();
				 */

				driver.findElement(By.cssSelector("#termsAgreed")).click();
				driver.findElement(By.xpath("//span[contains(.,'Confirm')]")).click();

			}

				Thread.sleep(3000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("confirmation-number")));

				WebElement element = driver.findElement(By.id("tt-comment-capture"));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", element);
				Thread.sleep(2000);


				  WebElement Linc3 =
				  driver.findElement(By.className("dialog_window"));
				  ((JavascriptExecutor)
				  driver).executeScript("arguments[0].style.visibility='hidden'", Linc3);


				Takescreenshots("Nixon.Mobile.CheckoutAllPayments", "US_STG_Orders", Payment[i]);
				
				quitbrowser();
		}

	}

}
