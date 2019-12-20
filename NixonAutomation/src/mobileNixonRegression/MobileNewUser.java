package mobileNixonRegression;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ReusableMethods.MobileReusableMethod;
import ReusableMethods.MobileUtils;
import ReusableMethods.Utils;

public class MobileNewUser {
	@Test
	void test() throws Exception {

		String[] Url;
		Url = new String[5];

		Url[0] = "https://storefront:Nixonat701@stg.nixon.com/us/en";
		Url[1] = "https://storefront:Nixonat701@stg.nixon.com/ca/en";
		Url[2] = "https://storefront:Nixonat701@stg.nixon.com/au/en";
		Url[3] = "https://storefront:Nixonat701@stg.nixon.com/fr/fr";
		Url[4] = "https://storefront:Nixonat701@stg.nixon.com/jp/ja";

		for (int i = 0; i < Url.length; i++) {
			Utils.videoStart("Regression", "MobileNewUser\\"
					+ (Url[i].substring(Url[i].lastIndexOf("m/")).replace("/", "_").replace("m_", " ") + "_"));

			MobileUtils.MobileTestiPhone(Url[i]);
			MobileUtils.MobileNewUser();

			MobileUtils.quitBrowser();

			Utils.videoEnd();

		}

	}

}
