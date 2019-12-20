package Nixon.Desktop.NewsletterSignup;

import org.testng.annotations.Test;

import ReusableMethods.Utils;

public class FooterSignUp2 {

	@Test
	void test() throws Exception {
		
		String[] Country;
		Country = new String[5];

		Country[0] = "us";
		Country[1] = "ca";
		Country[2] = "au";
		Country[3] = "fr";
		Country[4] = "us";

		for (int j = 0; j < Country.length; j++) {
		
		Utils.OpenBrowser("https://storefront:nix2015@stg.nixon.com/" + Country[j] + "/en");
		
		Utils.allFooterSignUppossibilities(Country[j]);
		
		Utils.quitbrowser();
		
		
	}
}
}
