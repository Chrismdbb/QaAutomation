package desktop.CheckoutPaymentTypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;
import ReusableMethods.Utils;

public class checkoutAllPaymentsEU_FR extends ReusableMethod {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[4];
		Payment[0] = "Paypal"; 
		Payment[1] = "Visa";
		Payment[2] = "MasterCard";
		Payment[3] = "Amex";

		for (int i = 0; i < Payment.length; i++) {

			Utils.CheckoutStep1("https://storefront:nix2015@stg.nixon.com/fr/fr");

			Utils.Cart2Payment("nixonautomation@gmail.com", "Christopher", "Barreto", "185 avenue de Pascouaou",
					"Soorts-Hossegor", "40150", "7604056763", "Hossegor");

			switch (Payment[i]) {

			case "Paypal":
				Utils.PaypalPayment();
				break;

			case "Visa":
				Utils.CreditCardPaymentInternational("4111111111111111", "123");
				break;

			case "MasterCard":
				Utils.CreditCardPaymentInternational("5555555555554444", "123");
				break;

			case "American Express":
				Utils.CreditCardPaymentInternational("378734493671000", "1234");
				break;
			}

			Utils.ConfirmationScreenshot("CheckoutAllPayments", "EU_STG_Orders", Payment[i]);

		}

	}

}
