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

import ReusableMethods.MobileReusableMethod;
import ReusableMethods.Utils;

public class Mobile_checkoutAllPaymentsCA extends MobileReusableMethod {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[3];

		Payment[0] = "MasterCard";
		Payment[1] = "AfterPay";
		Payment[2] = "Visa";

		for (int i = 0; i < Payment.length; i++) {
			
			String url = "CA_EN";
			
			Utils.videoStart("Regression", "MobileCheckout\\CA\\" + url+ Payment[i]);

			Utils.CheckoutStep1("https://storefront:Nixonat701@stg.nixon.com/ca/en");

			Utils.Cart2Payment("nixonautomation@gmail.com", "Christopher", "Barreto", "701 S. coast Highway",
					"Niagara Falls", "2000", "7604056763", "Queensland");

			switch (Payment[i]) {
			
			
			case "Visa":
				Utils.CreditCardPayment("4111111111111111", "123");
				break;
			
			case "MasterCard":
				Utils.CreditCardPayment("5555555555554444", "123");
				break;


				
			}

			Utils.ConfirmationScreenshot("CheckoutAllPayments", "CA_STG_Orders", Payment[i]);

		}



	}
}