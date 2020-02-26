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
import ReusableMethods.MobileUtils;
import ReusableMethods.Utils;

public class Mobile_checkoutAllPaymentsCA extends MobileReusableMethod {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[2];

		Payment[0] = "Visa";
		Payment[1] = "MasterCard";
		//Payment[2] = "Paypal";

		for (int i = 0; i < Payment.length; i++) {
			
			String url = "CA_EN";
			Utils.videoStart("Regression", "MobileCheckout\\CA\\" + url+ Payment[i]);
			
			MobileUtils.MobileTestiPhone("https://storefront:Nixonat701@stg.nixon.com/ca/en");
			MobileUtils.MobileAddtoCart();
			MobileUtils.MobileCheckoutStep1("NixonAutomation+CA@gmail.com", "Christopher", "Barreto", "701 S. coast Highway",
					"Niagara Falls", "L2G3V9", "7604056763", "Alberta");

			switch (Payment[i]) {
			
			
			case "Visa":
				MobileUtils.MobileCreditCardPayment("4111111111111111", "123");
				break;
			
			case "MasterCard":
				MobileUtils.MobileCreditCardPayment("5555555555554444", "123");
				break;


				
			}
			Utils.videoEnd();
			MobileUtils.quitBrowser();

		}

	}
}