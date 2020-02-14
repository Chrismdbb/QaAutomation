package Nixon.Desktop.NewsletterSignup;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ReusableMethods.Utils;

public class FooterSignUp2 {

	@Test
	void test() throws Exception {
		
		String[] Country;
		Country = new String[5];

		Country[0] = "fr";
		Country[1] = "ca";
		Country[2] = "au";
		Country[3] = "us";
		Country[4] = "jp";

		for (int i = 0; i < Country.length; i++) {
		
			if(!Country[i].contentEquals(Country[4]))	
			
			Utils.videoStart("Regression", "\\FooterNewsletter\\" + Country[i]);	
			
			Utils.OpenBrowser("https://storefront:Nixonat701@stg.nixon.com/" + Country[i] + "/en");
		
			Utils.IncorrectFormatFooterNewsletterSignup();
			Utils.AlreadyRegisteredFooterNewsletterSignup();
		
			Utils.quitbrowser();
		
			Utils.OpenBrowser("https://storefront:Nixonat701@stg.nixon.com/" + Country[i] + "/en");
		
			Utils.NewEmailFooterNewsletterSignup();
			
			Utils.quitbrowser();
		
			Utils.videoEnd();
		
			if(i==4) {
				Utils.videoStart("Regression", "\\FooterNewsletter\\" + Country[i]);	
				
				Utils.OpenBrowser("https://storefront:Nixonat701@stg.nixon.com/" + Country[i] + "/ja");
			
				Utils.IncorrectFormatFooterNewsletterSignup();
				Utils.AlreadyRegisteredFooterNewsletterSignup();
			
				Utils.quitbrowser();
			
				Utils.OpenBrowser("https://storefront:Nixonat701@stg.nixon.com/" + Country[i] + "/ja");
			
				Utils.NewEmailFooterNewsletterSignup();
				
				Thread.sleep(1000);
				
				Utils.videoEnd();	
				
				Thread.sleep(1000);
				
				Utils.quitbrowser();
			
				
			}	
	}
}
}
