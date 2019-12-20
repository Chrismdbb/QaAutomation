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


public class Mobile_checkoutAllPaymentsEU {

	@Test
	void test() throws Exception {
		
		String[] Payment;
		Payment = new String[4];
		
		Payment[0] = "Visa";
		Payment[1] = "MasterCard";
		Payment[2] ="American Express";
		Payment[3] = "Paypal";
		
		
	
		for (int i = 0; i < Payment.length; i++) {
			
			String url = "fr_en_";

			Utils.videoStart("Regression", "MobileCheckout\\" + url+ Payment);

			MobileUtils.MobileTestiPhone("https://storefront:Nixonat701@stg.nixon.com/fr/en");
			MobileUtils.MobileAddtoCart();
			MobileUtils.MobileCheckoutStep1("Christopher.Barreto@nixon.com","Christopher", "Barreto","185 avenue de Pascouaou",
					"Soorts-Hossegor","40150","7604056763","France");
			
			switch (Payment[i]) {
			
			case "Visa":
				MobileUtils.MobileCreditCardPayment("4111 1111 1111 1111", "123");
				break;
			
			case "MasterCard":
				MobileUtils.MobileCreditCardPayment("5555555555554444", "123");
				break;

			case "American Express":
				MobileUtils.MobileCreditCardPayment("378734493671000", "1234");
				System.out.println(Payment[i]);
				break;
				
				
			case "Paypal":
				MobileUtils.PaypalPayment("christopher.barreto+it@nixon.com", "Welcome123");
				System.out.println(Payment[i]);
				break;	
			
				
			}
			
			Utils.videoEnd();
			MobileUtils.quitBrowser();
			
		
	}
	
	}
	
}	
	
	

