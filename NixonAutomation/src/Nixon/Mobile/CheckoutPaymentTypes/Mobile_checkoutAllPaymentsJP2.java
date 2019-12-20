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

public class Mobile_checkoutAllPaymentsJP2 {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[6];

		
		Payment[0] = "Visa"; 
		Payment[1] = "MasterCard"; 
		Payment[2] ="American Express"; 
		Payment[3] = "Discover"; 
		Payment[4] = "JCB";
		Payment[5] = "Pay On Arrival";

		for (int i = 0; i < Payment.length; i++) {

			String url = "jp_ja_";

			Utils.videoStart("Regression", "MobileCheckout\\JP\\" + url + Payment[i]);

			MobileUtils.MobileTestiPhone("https://storefront:Nixonat701@stg.nixon.com/jp/ja");
			
			MobileUtils.MobileAddtoCart();
			
			MobileUtils.Cart2PaymentJP("nixonautomation@gmail.com", "Christopher", "Barreto", "6 Chome-6-2 Nishishinjuku",
					"Shinjuku City", "1600023", "7604056763", 3);

			switch (Payment[i]) {

			
			  case "Visa": MobileUtils.MobileCreditCardPaymentJPEU("4111111111111111",
			  "123"); System.out.println(Payment[i]); break;
			  
			  case "MasterCard":
			  MobileUtils.MobileCreditCardPaymentJPEU("5555555555554444", "123");
			  System.out.println(Payment[i]); break;
			  
			  case "American Express":
			  MobileUtils.MobileCreditCardPaymentJPEU("378734493671000", "1234");
			  System.out.println(Payment[i]); break;
			 
			case "JCB":
				MobileUtils.MobileCreditCardPaymentJPEU("30000000000111", "123");
				System.out.println("JCB");
				break;

			case "COD":
				MobileUtils.codPayment();
				System.out.println("COD");
				break;
			}
			MobileUtils.MobileOrderConfirmation();
			MobileUtils.quitBrowser();
			Utils.videoEnd();
		}
		
	}
}
