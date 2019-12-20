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

public class Mobile_checkoutAllPaymentsUS2 {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[2];
		/*
		 * Payment[0] = "Visa"; Payment[1] = "MasterCard"; Payment[2] =
		 * "American Express"; Payment[3] = "Discover";
		 */
		Payment[0] = "Paypal";
		Payment[1] = "AfterPay";

		for (int i = 0; i < Payment.length; i++) {

			String url = "us_en_";

			Utils.videoStart("Regression", "MobileCheckout\\US\\" + url + Payment[i]);

			MobileUtils.MobileTestiPhone("https://storefront:Nixonat701@stg.nixon.com/us/en");
			MobileUtils.MobileAddtoCart();
			MobileUtils.MobileCheckoutStep1("Christopher.Barreto@nixon.com", "Christopher", "Barreto",
					"701 N. Coast Hwy", "Encinitas", "92024", "7604056763", "California");

			switch (Payment[i]) {

			/*
			 * case "Visa": MobileUtils.MobileCreditCardPayment("4111111111111111", "123");
			 * System.out.println(Payment[i]); break;
			 * 
			 * case "MasterCard": MobileUtils.MobileCreditCardPayment("5555555555554444",
			 * "123"); System.out.println(Payment[i]); break;
			 * 
			 * case "American Express":
			 * MobileUtils.MobileCreditCardPayment("378734493671000", "1234");
			 * System.out.println(Payment[i]); break;
			 * 
			 * case "Discover": MobileUtils.MobileCreditCardPayment("6011111111111117",
			 * "123"); System.out.println(Payment[i]); break;
			 */

			case "Paypal":
				MobileUtils.PaypalPayment("christopher.barreto+us@nixon.com", "Welcome123");
				System.out.println(Payment[i]);
				break;

			case "AfterPay":
				MobileUtils.APPayment("Chrismdbb@gmail.com", "!Panem@1991");
				System.out.println(Payment[i]);
				break;

			}
			MobileUtils.MobileOrderConfirmation();
			MobileUtils.quitBrowser();
			Utils.videoEnd();
		}
	}
}
