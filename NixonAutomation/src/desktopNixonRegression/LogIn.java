package desktopNixonRegression;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ReusableMethods.Utils;

import ReusableMethods.ReusableMethod;

public class LogIn extends ReusableMethod {

			@Test
			void test() throws Exception {

				String[] Urls;
				Urls = new String[6];

				Urls[0] = "https://stg.nixon.com/us/en";
				Urls[1] = "https://stg.nixon.com/ca/en";
				Urls[2] = "https://stg.nixon.com/au/en";
				Urls[3] = "https://stg.nixon.com/jp/ja";
				Urls[4] = "https://stg.nixon.com/fr/fr";
				Urls[5] = "https://stg.nixon.com/uk/en";

				String[] Titles;
			    Titles = new String[6];
			    Titles[0] = "My Nixon Account | Nixon US";
			    Titles[1] = "My Nixon Account | Nixon CA";
			    Titles[2] = "My Nixon Account | Nixon AU";
			    Titles[3] = "My Nixon Account";
			    Titles[4] = "My Nixon Account | Nixon FR";
			    Titles[5] = "My Nixon Account | Nixon UK";
				
				
				
				for (int i = 0; i < Urls.length; i++) {
					Utils.OpenBrowser(Urls[i]);
					
					Utils.RegisteredSignIn("Christopher.Barreto@nixon.com", "Welcome123");

					Utils.CheckTitle(Titles[i]);

					Utils.quitbrowser();

				}

			}

}
