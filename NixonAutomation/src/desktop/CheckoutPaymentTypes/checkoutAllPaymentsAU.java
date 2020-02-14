package desktop.CheckoutPaymentTypes;

import java.awt.Window;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;
import ReusableMethods.Utils;

public class checkoutAllPaymentsAU extends ReusableMethod {

	

			@Test
			void test() throws Exception {

				String[] Payment;
				Payment = new String[3];

				Payment[0] = "Visa";
				Payment[1] = "MasterCard";
				Payment[2] = "AfterPay";
				
				
				for (int i = 0; i < Payment.length; i++) {
					
					
					Utils.videoStart("Regression", "MobileCheckout\\"+ Payment[i] + "AU_EN");

					Utils.CheckoutStep1("https://storefront:Nixonat701@stg.nixon.com/au/en");

					Utils.Cart2Payment("nixonautomation@gmail.com", "Christopher", "Barreto", "1/9 Ramley Dr.",
							"Burleigh Heads", "4220", "7604056763", "Queensland");

					switch (Payment[i]) {
					
					case "Visa":
						Utils.CreditCardPayment("4111111111111111", "123");
						break;

					case "MasterCard":
						Utils.CreditCardPayment("5555555555554444", "123");
						break;

					case "AfterPay":
						Utils.APPayment("Christopher.Barreto@nixon.com", "!Panem@1991");
						break;
						
					
						
						
					}
					
					Utils.videoEnd();		
			}
			}		
}	