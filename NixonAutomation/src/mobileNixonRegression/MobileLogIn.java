package mobileNixonRegression;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReusableMethods.MobileReusableMethod;
import ReusableMethods.MobileUtils;
import ReusableMethods.Utils;

public class MobileLogIn {



	@Test
	void test() throws Exception {

		String[] Url;
		Url = new String[5];

		Url[0] = "https://storefront:nix2015@stg.nixon.com/us/en";
		Url[1] = "https://storefront:nix2015@stg.nixon.com/ca/en";
		Url[2] = "https://storefront:nix2015@stg.nixon.com/jp/ja";
		Url[3] = "https://storefront:nix2015@stg.nixon.com/au/en";
		Url[4] = "https://storefront:nix2015@stg.nixon.com/fr/fr";

		for (int i = 0; i < Url.length; i++) {

			Utils.videoStart("Regression", "MobileLogin\\" + (Url[i].substring(Url[i].lastIndexOf("m/")).replace("/", "_").replace("m_"," " )+"_"));

			MobileUtils.MobileTestiPhone(Url[i]);
			MobileUtils.MobileSignIn("Christopher.Barreto@nixon.com", "Welcome123");

			MobileUtils.quitBrowser();
			Utils.videoEnd();

		}
	}

}