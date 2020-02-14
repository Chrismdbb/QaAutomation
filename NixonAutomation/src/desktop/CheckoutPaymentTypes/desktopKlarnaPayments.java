package desktop.CheckoutPaymentTypes;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;
import ReusableMethods.Utils;

public class desktopKlarnaPayments extends ReusableMethod {

	@Test
	void test() throws Exception {

		 String Emails = "Christopher.Barreto@nixon.com";
		String fName = "Christopher";
		String lName = "Barreto";
		
		String[] country = {"UK","Germany","Austria","Denmark","Netherlands","Sweden","Finland"};	

		String[] Urls = { 
						 /*1*/"https://storefront:Nixonat701@dev.nixon.com/uk/en",
						 /*2*/"https://storefront:Nixonat701@dev.nixon.com/de/en",
						/*3*/"https://storefront:Nixonat701@dev.nixon.com/at/en",
						/*4*/"https://storefront:Nixonat701@dev.nixon.com/dk/en",
						/*5*/"https://storefront:Nixonat701@dev.nixon.com/nl/en",
						/*6*/"https://storefront:Nixonat701@dev.nixon.com/se/en",
						/*7*/"https://storefront:Nixonat701@dev.nixon.com/fi/en",
				  };
		 
		 String[] address = { 
				            /*1*/"13 New Burlington St",
				            /*2*/"Marzellenstraße 13-17",
				            /*3*/"Klarna-Straße 1/2/3",
				            /*4*/"Sæffgate 56,1 mf",
				            /*5*/"Neherkade 1 XI",
				            /*6*/"Stårgatan 1",
				            /*7*/"Kiväärikatu 10", 
				 	}; 
		
		 String[] city = {
				 			/*1*/"London",
				           /*2*/"Köln", 
				           /*3*/"Hausmannstätten",
				           /*4*/"Verde",
				           /*5*/ "Gravenhage",
				           /*6*/ "Stocholm",
				           /*7*/ "Pori", 
		 		  };
		 
		 String[] zip = {
				         /*1*/"W133BG",
				         /*2*/"50668",
				         /*3*/"8071",
				         /*4*/"6800",
				         /*5*/"2521VA",
				         /*6*/"11354",
				         /*7*/ "28100"
				 };
		 
		 String[] phone = {
				 		   /*1*/"01895808221",
				 		   /*2*/"+49 221 130710",
				 		   /*3*/"0676 2600000",
				 		   /*4*/"20 123 456",
				 		   /*5*/"0612345678",
				 		   /*6*/ "0765260000",
				 		   /*7*/"0401234567",
		 		};
		         
		  String[] dobID = { 
				  			/*1*/ "03061991",
				  			/*2*/ "03061991",
				  			/*3*/ "03061991",
				  			/*4*/ "0801363945",
				  			/*5*/ "03061991",
				  			/*6*/ "19770111-6050",
				  			/*7*/ "190122-829F",       
		           };
 
		
		for (  int i = 0; i < Urls.length; i++) {
			Utils.videoStart("Desktop\\CheckoutAllPayments\\Klarna",country[i]);
			Utils.CheckoutStep1(Urls[i]);
			Utils.Cart2Payment(Emails, fName, lName, address[i],
					city[i], zip[i], phone[i], country[i]);
			
			Thread.sleep(5000);
			Utils.Scroll();
			Utils.Klarna(dobID[i]);
			
			Utils.quitbrowser();
			Utils.videoEnd();
		}
	}
}