package desktop.CheckoutPaymentTypes;

/*import java.awt.Window;
import java.io.File;
import java.util.Set;*/
import java.util.concurrent.TimeUnit;



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
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;

public class checkoutAllPaymentsUSA2 extends ReusableMethod {

	@Test
	void test() throws Exception {
		

		String[] Payment;
		Payment = new String[6];

		Payment[0] = "Visa";
		/*Payment[1] = "MasterCard";
		Payment[2] = "American Express";
		Payment[3] = "Discover";
		Payment[4] = "Paypal";
		Payment[5] = "AfterPay";*/


		for (int i = 0; i < Payment.length; i++) {

			String Url = "https://storefront:nix2015@stg.nixon.com/us/en";

			WebDriver driver;

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\christopher.barreto\\Drivers\\chromedriver_V76.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			// launch Chrome and direct it to the Base URL
			driver.get(Url);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			  if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
			  driver.findElement(By.className("modal-close")).click(); }
			 

			WebElement subElement = driver.findElement(By.cssSelector(".level-1_item:nth-child(1) .level-1_link-text"));
			Actions action = new Actions(driver);

			action.moveToElement(subElement).perform();

			driver.findElement(By.cssSelector(
					".level-1_item:nth-child(1) .level-2_item:nth-child(4) .level-3_item:nth-child(1)  .label-text"))
					.click();

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (driver.findElement(By.cssSelector("#modal-email .modal-close")).isDisplayed()) { // if the tag options
																									// is not displayed
				driver.findElement(By.cssSelector("#modal-email .modal-close")).click();
			}

			driver.findElement(By.xpath("//li[3]/div/div[2]/div/a/img")).click();

			driver.findElement(By.id("add-to-cart")).click(); // check if its available and if not -- then select another
																// swatch *******

			driver.findElement(By.id("mini-cart")).click();
			
			
			
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

			driver.findElement(By.id("inputshipping-email")).sendKeys("NixonAutomation@gmail.com");
			driver.findElement(By.id("inputshipping-firstNameField")).sendKeys("Christopher");
			driver.findElement(By.id("inputshipping-lastNameField")).sendKeys(" Automation Test");
			driver.findElement(By.id("inputshipping-address1Field")).sendKeys("3668 Harvard Drive");
			driver.findElement(By.id("inputshipping-cityField")).sendKeys("oceanside");
			driver.findElement(By.id("inputshipping-postalCodeField")).sendKeys("92056");
			driver.findElement(By.id("inputshipping-phoneField")).sendKeys("7604056763");

			// driver.findElement(By.id("dropDownshipping-stateDropDownField")).click();

			Select drpState = new Select(driver.findElement(By.id("dropDownshipping-stateDropDownField")));
			drpState.selectByVisibleText("California");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//input[@value='Continue to Payment']")).click();

			if (i == 0) {

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.findElement(By.id("inputcardNumberField")).sendKeys("4111111111111111");

				String value = driver.findElement(By.id("inputcardNumberField")).getAttribute("value").trim();
				Thread.sleep(2000);
				System.out.println(value);
				

				if (!value.equals("4111111111111111")) {
					driver.findElement(By.id("inputcardNumberField")).clear();
					driver.findElement(By.id("inputcardNumberField")).sendKeys("4111 1111 1111 1111");
				}

				driver.findElement(By.id("inputcardCodeField")).sendKeys("123");

				Select ccMonth = new Select(driver.findElement(By.id("month")));
				ccMonth.selectByVisibleText("10");

				Select ccYear = new Select(driver.findElement(By.id("year")));
				ccYear.selectByVisibleText("2021");

				driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).click();

				driver.findElement(By.xpath("//input[@value='Place Order']")).click();

			}

			
			  else if (i == 1) {
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.id("inputcardNumberField")).
			  sendKeys("5555 5555 5555 4444"); String value =
			  driver.findElement(By.id("inputcardNumberField")).getAttribute("value");
			  
			  Thread.sleep(2000);
			  
			  if (!value.equals("5555 5555 5555 4444")) {
			  driver.findElement(By.id("inputcardNumberField")).clear();
			  driver.findElement(By.id("inputcardNumberField")).
			  sendKeys("5555 5555 5555 4444"); }
			  driver.findElement(By.id("inputcardCodeField")).sendKeys("123");
			  
			  Select ccMonth = new Select(driver.findElement(By.id("month")));
			  ccMonth.selectByVisibleText("10");
			  
			  Select ccYear = new Select(driver.findElement(By.id("year")));
			  ccYear.selectByVisibleText("2021");
			  
			  driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).
			  click();
			  
			  driver.findElement(By.xpath("//input[@value='Place Order']")).click();
			  
			  }
			  
			  else if (i == 2) {
			  
			  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			  
			  driver.findElement(By.id("inputcardNumberField")).
			  sendKeys("3787 344936 71000");
			  
			  String value =
			  driver.findElement(By.id("inputcardNumberField")).getAttribute("value");
			  Thread.sleep(2000);
			  
			  if (!value.equals("3787 344936 71000")) {
			  driver.findElement(By.id("inputcardNumberField")).clear();
			  driver.findElement(By.id("inputcardNumberField")).sendKeys("378734493671000")
			  ; }
			  
			  driver.findElement(By.id("inputcardCodeField")).sendKeys("1234");
			  
			  Select ccMonth = new Select(driver.findElement(By.id("month")));
			  ccMonth.selectByVisibleText("10");
			  
			  Select ccYear = new Select(driver.findElement(By.id("year")));
			  ccYear.selectByVisibleText("2021");
			  
			  driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).
			  click();
			  
			  driver.findElement(By.xpath("//input[@value='Place Order']")).click();
			  
			  }
			  
			  else if (i == 3) {
			  
			  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			  
			  driver.findElement(By.id("inputcardNumberField")).
			  sendKeys("6011 1111 1111 1117");
			  
			  String value =
			  driver.findElement(By.id("inputcardNumberField")).getAttribute("value");
			  
			  Thread.sleep(2000);
			  
			  if (!value.equals("6011 1111 1111 1117")) {
			  driver.findElement(By.id("inputcardNumberField")).clear();
			  driver.findElement(By.id("inputcardNumberField")).sendKeys("6011111111111117"
			  ); }
			  
			  driver.findElement(By.id("inputcardCodeField")).sendKeys("123");
			  
			  Select ccMonth = new Select(driver.findElement(By.id("month")));
			  ccMonth.selectByVisibleText("10");
			  
			  Select ccYear = new Select(driver.findElement(By.id("year")));
			  ccYear.selectByVisibleText("2021");
			  
			  driver.findElement(By.xpath("//input[@value='Continue to Order Review']")).
			  click();
			  
			  driver.findElement(By.xpath("//input[@value='Place Order']")).click();
			  
			  }
			 

			  else if (i == 4) {
				
				// //label[contains(.,'PayPal')]
				 
				 Thread.sleep(2000);
				driver.findElement(By.xpath("//div[2]/div[2]/div/label/span")).click();

				driver.findElement(By.cssSelector(".paypal-button")).click();

				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

				driver.findElement(By.id("email")).sendKeys("christopher.barreto+us@nixon.com");
				driver.findElement(By.id("btnNext")).click();

				driver.findElement(By.id("password")).sendKeys("Welcome123");
				driver.findElement(By.id("btnLogin")).click();

				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmButtonTop")));

				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id='confirmButtonTop']")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Place Order']")));
				driver.findElement(By.xpath("//input[@value='Place Order']")).click();

			}

			 else if (i == 5) {

				driver.findElement(By.xpath("//div[2]/div[3]/div[1]/label/span[1]")).click();

				driver.findElement(By.id("test_afterpayContinue")).click();

				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

				driver.findElement(By.cssSelector(".input")).clear();
				driver.findElement(By.cssSelector(".input")).sendKeys("Chrismdbb@gmail.com");

				driver.findElement(By.xpath("//button")).click();

				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".input")));
				driver.findElement(By.cssSelector(".input")).sendKeys("!Panem@1991");
				driver.findElement(By.xpath("//button")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-child(2)")));
				WebElement Continue = driver.findElement(By.cssSelector("button:nth-child(2)"));
				Thread.sleep(5000);
				action.moveToElement(Continue).perform();
				Continue.click();

				driver.findElement(By.cssSelector("#termsAgreed")).click();
				driver.findElement(By.xpath("//span[contains(.,'Confirm')]")).click();

			}
			
		
		    
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("confirmation-number")));

			WebElement element = driver.findElement(By.id("tt-comment-capture"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", element);
			Thread.sleep(5000);

			Takescreenshots2("CheckoutAllPayments", "US_STG_Orders", Payment[i]);

			quitbrowser();

		}

	}

}

