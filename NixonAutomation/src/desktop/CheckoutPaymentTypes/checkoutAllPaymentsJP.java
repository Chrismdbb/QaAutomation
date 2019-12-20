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

import ReusableMethods.MobileReusableMethod;
import ReusableMethods.ReusableMethod;
import ReusableMethods.Utils;

import org.openqa.selenium.Keys;

public class checkoutAllPaymentsJP extends ReusableMethod {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[5];

		Payment[0] = "Visa";
		Payment[1] = "MasterCard";
		Payment[2] = "Amex";
		Payment[3] = "JCB";
		Payment[4] = "Pay On Arrival";


		for (int i = 0; i < Payment.length; i++) {
			
			Utils.CheckoutStep1("https://storefront:nix2015@stg.nixon.com/jp/ja");

			Utils.Cart2PaymentJP ("nixonautomation@gmail.com", "Christopher", "Barreto", "701 S. coast Highway",
					"Encinitas", "9202412", "7604056763", 3);

			switch (Payment[i]) {
			case "Visa":
				Utils.CreditCardPayment("4111111111111111", "123");
				System.out.println("Visa");
				break;

			case "MasterCard":
				Utils.CreditCardPayment("5555555555554444",  "123");
				System.out.println("MC");
				break;

			case "American Express":
				Utils.CreditCardPayment("341111111111111", "1234");
				System.out.println("Amex");
				break;

			case "JCB":
				Utils.CreditCardPayment("30000000000111", "123");
				System.out.println("JCB");
				break;

			case "COD":
				Utils.codPayment();
				System.out.println("COD");
				break;
			}

			Utils.ConfirmationScreenshot("CheckoutAllPayments", "US_STG_Orders", Payment[i]);

		}

	}

}
