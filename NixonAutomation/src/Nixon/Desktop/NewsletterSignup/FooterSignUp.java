package Nixon.Desktop.NewsletterSignup;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ReusableMethods.ReusableMethod;

public class FooterSignUp extends ReusableMethod {

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

			String[] TestType;
			TestType = new String[3];

			TestType[0] = "Fake Email";
			TestType[1] = "Already Registered";
			TestType[2] = "Correct Email Address";

			String Urls = "https://storefront:nix2015@stg.nixon.com/" + Country[j] + "/en";

			Random rand = new Random();
			int randomnumber = rand.nextInt(100000);

			String UsedEmail = "Christopher.Barreto@gmail.com";
			String FakeEmail = "Christopher";
			String NewEmail = "Christopher" + randomnumber + "Barreto@nixon.com";

			openbrowser(Urls);

			if (driver.findElement(By.className("modal-close")).isDisplayed()) { // if the tag options is not displayed
				driver.findElement(By.className("modal-close")).click();
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,2500)");

			WebElement EFooterField = driver.findElement(By.id("email-alert-address"));
			WebElement Submit = driver.findElement(By.xpath("//*[@id=\"email-alert-signup\"]/div[3]/input"));

			WebDriverWait wait = new WebDriverWait(driver, 20);

			for (int i = 0; i < TestType.length; i++) {

				if (i == 0) {
					EFooterField.click();
					EFooterField.sendKeys(FakeEmail);
					Submit.click();

					Takescreenshots("EmailSignup", TestType[i]);

					js.executeScript("javascript:window.scrollBy(0,50)");

				}

				else if (i == 1) {
					EFooterField.clear();
					EFooterField.sendKeys(UsedEmail);
					Submit.click();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-container")));
					js.executeScript("javascript:window.scrollBy(0,50)");

					Takescreenshots("EmailSignup", TestType[i]);

					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-container")));
							
					
					
					driver.switchTo().frame(1);	
					
					//driver.findElement(By.cssSelector(".ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-icon-only.ui-dialog-titlebar-close")).click();
					
					driver.findElement(By.xpath("//*[@id=\"ext-gen44\"]/body/div[10]/div[1]/button")).click();
					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-container")));

				}

				else if (i == 2) {
					EFooterField.clear();
					EFooterField.sendKeys(NewEmail);
					Submit.click();

					js.executeScript("javascript:window.scrollBy(0,50)");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-container")));

					Takescreenshots2(Country[i], "EmailSignup", TestType[i]);
				}

			}
			quitbrowser();
		}
	}

}
