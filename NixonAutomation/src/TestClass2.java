import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;
import ReusableMethods.Utils;

import org.openqa.selenium.WebDriver;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.media.Format;
import net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record;

import org.testng.annotations.AfterTest;

public class TestClass2 {

	ATUTestRecorder recorder;
	
	@SuppressWarnings("unused")
	@BeforeTest
	public void setup() throws Exception {

	Utils.videoStart( "Video", "SUPERTEST");
	}
	
	
	
	@Test
	public void test() throws Exception {
		String[] Payment;	
	Payment = new String[1];



	Payment[0] = "AfterPay";
		

	Utils.CheckoutStep1("https://storefront:nix2015@stg.nixon.com/us/en");

	Utils.Cart2Payment("nixonautomation@gmail.com", "Christopher", "Barreto", "701 S. coast Highway",
			"Encinitas", "92024", "7604056763", "California");

	Utils.CreditCardPaymentTest("4111 1111 1111 1111", "123");
	System.out.println(Payment[0]);
	
	Utils.ConfirmationScreenshot("CheckoutAllPayments", "US_STG_Orders", Payment[0]);
	
	

	}

	@AfterTest
	public void end() throws Exception{
	Utils.videoEnd();
	
	}
	
}