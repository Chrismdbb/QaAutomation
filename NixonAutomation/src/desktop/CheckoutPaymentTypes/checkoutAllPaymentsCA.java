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

public class checkoutAllPaymentsCA extends ReusableMethod {

	@Test
	void test() throws Exception {

		String[] Payment;
		Payment = new String[2];

		Payment[0] = "Visa";
		Payment[1] = "MasterCard";


		for (int i = 0; i < Payment.length; i++) {

				Utils.CheckoutStep1("https://storefront:Nixonat701@stg.nixon.com/ca/en");
				Utils.Cart2Payment("NixonAutomation+CA@gmail.com", "Christopher", "Barreto", "701 S. coast Highway",
						"Niagara Falls", "L2G3V9", "7604056763", "Alberta");

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

