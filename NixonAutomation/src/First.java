import java.net.URL;
	import java.util.ArrayList;

	import org.testng.annotations.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.openqa.selenium.support.ui.Select;
public class First {
	

	


		
		@Test void test() throws Exception {
			//Below is the boilerplate for saucelabs 
		    
		/*	DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
			
		    caps.setCapability("name", "Header Links Test - Windows");
		    caps.setCapability("tags", "WIN10");
		    caps.setCapability("build", "");
		    WebDriver driver = new RemoteWebDriver(
		    new URL("http://pduffy:24a07ed1-4637-4f4c-bda5-05e13f8b9b56@ondemand.saucelabs.com:80/wd/hub"),
		        caps); 
		*/

	// ----------------this is the boiler plate for Selenium web driver	---------------------
						System.setProperty ("webdriver.chrome.driver","C:\\Users\\christopher.barreto\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
						WebDriver driver = new ChromeDriver();//this is used to run test locally
						// Helps differentiate tests in the console
						System.out.println("--------------------------Test Header Links--------------------------------------------");
	//--------------------------------------------------------------This opens Prana.com & closes Pop Up  and Clicks Sign in button in header -----------------
				        driver.manage().window().maximize();
						
				        String baseUrl = "https:www.prana.com";
				        
				        // launch Chrome and direct it to the Base URL
				        driver.get(baseUrl);
				       
				      //Webdriver will wait for the element to load
				       
				        WebDriverWait wait = new WebDriverWait(driver, 10);
				       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mrNlPopupClose")));
				        
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN IN")));
				       
				        
				// get the actual value of the title of the HomePage , Set expectedTitle to Home Page title string
				         String actualTitle = driver.getTitle();
				         String expectedTitle = "Yoga, Travel, & Adventure Clothes With A Conscience | prAna";

				// Checks if the actual title of page matched the expected Title        
				         if (actualTitle.contentEquals(expectedTitle)){
				             System.out.println("The Site is up - PASSED");
				         } else {
				             //below comment prints actual title
				         	//System.out.print(actualTitle); 
				         	System.err.println("Test failed to confirm Homepage");
				         }
	//-----------------below tells the driver to find Customer Service link in footer and move to it -Scrolling to bottom of page----------
				         WebElement customerCare = driver.findElement(By.className("header-customer-care-link"));
				         Actions actions = new Actions(driver);
				         actions.moveToElement(customerCare);
				         actions.perform();
				         
				          customerCare.click(); // click Customer Service Link
				          actualTitle = driver.getTitle();
				          String csTitle = "Customer Care | prAna"; // sets a title string
				          
				       // if the title string equals the same title the driver pulled print success message and return to Homepage
				         if (actualTitle.contentEquals(csTitle)) { 
				        	  System.out.println("Customer Care Footer header link- PASSED");
				        	       
				        	      driver.navigate().back(); // this navigates back to homepage
				        	      
				        	     String currentURL = driver.getCurrentUrl();// gets current URL
				        	     String expectedURL = "https://www.prana.com/";// sets the string for expected URL 
				        	
				        	  if(currentURL.contentEquals(expectedURL)) { // if the new URL we are on matches expected HP URL then
				        	 System.out.println("Back to Homepage from Customer Service Header - PASSED");}
				        	 
				        	  else{System.err.println("Back to Homepage from Customer Service - FAILED");} // if we arent on Homepage fail the test
				          }
				         
				          else {System.err.println("Customer Care Header Link - FAILED");}   //else failed			         
		
	//--------------------------------Select and open Click to chat Header  Desktop ------------------------------------------------
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         WebElement arrow = driver.findElement(By.className("icon-down-arrow-icon"));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement clickToChat =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(2) > a"));
				         clickToChat.click();
				      
				         driver.switchTo().frame(1); //switch to zendesk chat frame
				         
		   
					        if (driver.findElements(By.xpath("//div[3]/div[2]/div/div")).size() > 0)
					         { // if all those fields are present then print out below and switch back to the 
					        	  System.out.println("Click to Chat Header link - PASSED");
					        	  System.out.println("Click to Chat Widget UP - PASSED");
					        	  //switches back to original frame Homepage
					        	  } 
					        	     
					         else {System.out.println("Click to Chat header Linked - FAILED");}   
				         
				         
				    /*    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("input_name")));
				        WebElement Name = driver.findElement(By.xpath("//input"));
				        Name.sendKeys("Christopher");
				         
				         
				         if (driver.findElements(By.id("___$_31__profile__name")).size() > 0)
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("Click to Chat Header link - PASSED");
				        	  System.out.println("Click to Chat Widget UP - PASSED");
				        	      } 
				        	     
				         else {System.out.println("Click to Chat header Linked - FAILED");}     */
				         
	//--------------------------------Select and open Contact Us  Header  Desktop ------------------------------------------------
					        driver.switchTo().defaultContent(); 
					        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement ContactUs =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(3) > a"));
				         ContactUs.click();
				         
				         actualTitle = driver.getTitle();
				         String contactTitle = "Customer Care | prAna";
				         
				         if (actualTitle.contentEquals(contactTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("Contact Us Header link - PASSED");
				        	  System.out.println("Contact Us Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("Contact Us header Linked - FAILED");}   			 			         
				         driver.navigate().back();
				         
				         
	//--------------------------------Select and open Shipping and Delivery Header  Desktop ------------------------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         arrow = driver.findElement(By.className("icon-down-arrow-icon"));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement shipping =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(4) > a"));
				         shipping.click();
				         
				         actualTitle = driver.getTitle();
				         String shippingTitle = "Shipping & Returns | prAna";
				          
				         if (actualTitle.contentEquals(shippingTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("Shipping & Delivery Header link - PASSED");
				        	  System.out.println("Shipping & Delivery Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("Shipping & Delivery header Linked - FAILED");}   			 			         
				         driver.navigate().back();
				         
				         
	//--------------------------------Select and open Returns & Exchanges Header  Desktop ------------------------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         arrow = driver.findElement(By.className("icon-down-arrow-icon"));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement returns =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(5) > a"));
				         returns.click();
				         
				        String actualURL = driver.getCurrentUrl();
				        
				          
				         if (actualURL.contains("#returns"))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("Returns & Exchanges Header link - PASSED");
				        	  System.out.println("Returns & Exchanges Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("Returns & Exchanges header Linked - FAILED");}   			 			         
				         driver.navigate().back();
				         
				         
	//--------------------------------Select and open International Shipping Header  Desktop ------------------------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         arrow = driver.findElement(By.className("icon-down-arrow-icon"));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement intshipping =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(6) > a"));
				         intshipping.click();
				         
				         actualTitle = driver.getTitle();
				         String intTitle = "Shipping Returns International | prAna";
				          
				         if (actualTitle.contentEquals(intTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("International Shipping Header link - PASSED");
				        	  System.out.println("International Shipping Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("International Shipping header Linked - FAILED");}   			 			         
				         driver.navigate().back();
				         
				         
	//--------------------------------Select and open International Returns Header  Desktop ------------------------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         arrow = driver.findElement(By.className("icon-down-arrow-icon"));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement intReturns =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(7) > a"));
				         intReturns.click();
				         
				        actualURL = driver.getCurrentUrl();
				         
				          
				         if (actualURL.contains("#returns"))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("International Returns Header link - PASSED");
				        	  System.out.println("International Returns Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("International Returns header Linked - FAILED");}   			 			         
				         driver.navigate().back(); 
		
		
	//--------------------------------Select and open Faq Header  Desktop ------------------------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-customer-care-link")));
				         arrow = driver.findElement(By.className("icon-down-arrow-icon"));
				         actions.moveToElement(arrow);
				         actions.perform();
				         arrow.click();
				         
				         WebElement faq =  driver.findElement(By.cssSelector("#c-drop > li:nth-child(8) > a"));
				         faq.click();
				         
				        actualTitle = driver.getTitle();
				        String  faqTitle = "FAQ | prAna";
				          
				         if (actualTitle.contentEquals(faqTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("FAQ Header link - PASSED");
				        	  System.out.println("FAQ Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("FAQ header Linked - FAILED");}   			 			         
				         driver.navigate().back(); 	
		
	//-------------------------------------------------- Select Prana Homepage link in header-----------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo-link")));
				         WebElement logo = driver.findElement(By.className("logo-link"));
				         actions.moveToElement(logo);
				         actions.perform();
				         logo.click();
				         
				         actualURL = driver.getCurrentUrl();
				        
				          
				         if (actualURL.contentEquals("https://www.prana.com/"))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("Logo Header link - PASSED");
				        	  
				        	      } 
				        	     
				         else {System.err.println("Logo Header Linked - FAILED");}   			 			         

				         
	//------------------------------ select Gift Cards link in Header --------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo-link")));
				         WebElement giftCards = driver.findElement(By.className("icon-gift-card-icon"));
				         actions.moveToElement(giftCards);
				         actions.perform();
				         giftCards.click();
				         
				            actualTitle = driver.getTitle();
				          String giftCardTitle = "prAna Gift Card - The Perfect Gift | prAna";
				        
				          
				         if (actualTitle.contentEquals(giftCardTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("Gift Card Header link - PASSED");
				        	  System.out.println("Gift Card Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("Gift Card Header Linked - FAILED");}   			 			         
				         driver.navigate().back(); 			         
				         
	//------------------------------ select Sign In Link in Header --------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo-link")));
				         WebElement signIn = driver.findElement(By.linkText("SIGN IN"));
				         actions.moveToElement(signIn);
				         actions.perform();
				         signIn.click();
				         
				            actualTitle = driver.getTitle();
				          String signInTitle = "Customer Login | prAna";
				        
				          
				         if (actualTitle.contentEquals(signInTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("SIGN IN Header link - PASSED");
				        	  System.out.println("SIGN IN Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("SIGN IN Header Linked - FAILED");}   			 			         
				         driver.navigate().back(); 
				         
	 //------------------------------ select CART Link in Header --------------------------------
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo-link")));
				         WebElement myBasket = driver.findElement(By.className("mygoods"));
				         actions.moveToElement(myBasket);
				         actions.perform();
				         myBasket.click();
				         
				            actualTitle = driver.getTitle();
				          String myBasketTitle = "Basket | prAna";
				        
				          
				         if (actualTitle.contentEquals(myBasketTitle))
				         { // if all those fields are present then print out below and switch back to the 
				        	  System.out.println("My Basket Header link - PASSED");
				        	  System.out.println("My Basket Page is Up - PASSED");
				        	      } 
				        	     
				         else {System.err.println("My Basket Header Linked - FAILED");}   			 			         
				         driver.navigate().back(); 
				         
				         System.out.println("**************************************End Test*******************************************");
				         driver.quit();
		
		}			         
		}
		
		

	
	


