package desktopNixonRegression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;

public class NewUser extends ReusableMethod {
	@Test
	void test() throws Exception {

		String[] Urls;
		Urls = new String[6];

		Urls[0] = "https://www.nixon.com/us/en";
		Urls[1] = "https://www.nixon.com/ca/en";
		Urls[2] = "https://www.nixon.com/au/en";
		Urls[3] = "https://www.nixon.com/jp/ja";
		Urls[4] = "https://www.nixon.com/fr/fr";
		Urls[5] = "https://www.nixon.com/uk/en";

		String[] Sign_up;
		Sign_up = new String[6];

		Sign_up[0] = "SignUp Page US";
		Sign_up[1] = "SignUp Page CA";
		Sign_up[2] = "SignUp Page AU";
		Sign_up[3] = "SignUp Page JP";
		Sign_up[4] = "SignUp Page FR";
		Sign_up[5] = "SignUp Page UK";

		String[] MyAccount;
		MyAccount = new String[6];

		MyAccount[0] = "My Account Page US";
		MyAccount[1] = "My Account Page CA";
		MyAccount[2] = "My Account Page AU";
		MyAccount[3] = "My Account Page JP";
		MyAccount[4] = "My Account Page FR";
		MyAccount[5] = "My Account Page UK";

		for (int i = 0; i < Urls.length; i++) {
			System.out.println(Urls.length);

			openbrowser(Urls[i]);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
				driver.findElement(By.className("modal-close")).click();
			}
			
			Createuser();

			Takescreenshots("NewUser", Sign_up[i]);
			Takescreenshots("NewUser", MyAccount[i]);

			quitbrowser();
		}
	}
}