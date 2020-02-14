package desktop.CheckoutPaymentTypes;

/*import java.awt.Window;
import java.io.File;
import java.util.Set;*/

import org.testng.annotations.Test;

import ReusableMethods.Utils;

public class checkoutAllPaymentsUSA {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[6];

		Payment[0] = "Visa";
		Payment[1] = "MasterCard";
		Payment[2] = "American Express";
		Payment[3] = "Discover";
		Payment[4] = "Paypal";
		Payment[5] = "AfterPay";

		for (int i = 0; i < Payment.length; i++) {

			Utils.CheckoutStep1("https://storefront:Nixonat701@stg.nixon.com/us/en");

			Utils.Cart2Payment("nixonautomation@gmail.com", "Christopher", "Barreto", "701 S. coast Highway",
					"Encinitas", "92024", "7604056763", "California");

			switch (Payment[i]) {

			case "Visa":
				Utils.CreditCardPayment("4111111111111111", "123");
				System.out.println(Payment[i]);
				break;

			case "MasterCard":
				Utils.CreditCardPayment("5555555555554444", "123");
				System.out.println(Payment[i]);
				break;

			case "American Express":
				Utils.CreditCardPayment("378734493671000", "1234");
				System.out.println(Payment[i]);
				break;

			case "Discover":
				Utils.CreditCardPayment("6011111111111117", "123");
				System.out.println(Payment[i]);
				break;
				
			case "Paypal":
				Utils.PaypalPayment();
				System.out.println(Payment[i]);
				break;
			

			case "AfterPay":
				Utils.APPayment("Chrismdbb@gmail.com", "!Panem@1991");
				System.out.println(Payment[i]);
				break;
			}

			Utils.ConfirmationScreenshot("CheckoutAllPayments", "US_STG_Orders", Payment[i]);

		}

	}

}
