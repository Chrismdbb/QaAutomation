package newRelic_NodeJS_Scripts;

public class TimeTeller_Checkout {

/* This is for Node.JS just to save info

/*

var By =$driver.By;
var assert = require('assert');

$browser.get('https://www.nixon.com/time-teller/A045-511-00.html').then(function(){

  // Check Title and make sure it matches whats expected
   $browser.sleep(1000);
   return $browser.getTitle().then(function(title){
   if (title === "Time Teller | All Gold / Gold | Stainless Steel | Men's & Women's | Nixon US"){
       console.log("Time Teller Gold PDP up");
   }

   else console.log("Time Teller PDP US page is not valid");

}).then(function(){

   //driver adds an item to cart
    $browser.findElement($driver.By.id("add-to-cart")).click();
    console.log("click add to cart");

}).then(function(){

    //driver takes a screenshot on PDP with Item in cart
    $browser.takeScreenshot();

}).then(function(){

    console.log("PDP screenshot taken");
    //driver clicks on minicart
    $browser.findElement($driver.By.id("mini-cart")).click()

}).then(function(){  
  
  $browser.takeScreenshot();
  
}).then(function(){
   console.log("Cart Screenshot Taken")

   if  ($browser.findElement($driver.By.xpath("//a[contains(text(),'Checkout')]")).isDisplayed())
       {$browser.findElement($driver.By.xpath("//a[contains(text(),'Checkout')]")).click()       
   }

  else console.log("[ERROR] Checkout button is not present in cart");

}).then(function(){

        $browser.findElement($driver.By.id("inputshipping-email")).sendKeys("Christopher.Barreto@nixon.com");
        $browser.findElement($driver.By.id("inputshipping-firstNameField")).sendKeys("Christopher");
        $browser.findElement($driver.By.id("inputshipping-lastNameField")).sendKeys("Barreto");
        $browser.findElement($driver.By.id("inputshipping-address1Field")).sendKeys("701 S. coast Hwy");
        $browser.findElement($driver.By.id("inputshipping-cityField")).sendKeys("Encinitas");
        $browser.findElement($driver.By.id("inputshipping-postalCodeField")).sendKeys("92024");
        $browser.findElement($driver.By.id("inputshipping-phoneField")).sendKeys("7604056763");
        $browser.findElement($driver.By.id("dropDownshipping-stateDropDownField")).sendKeys("CA");

}).then(function(){

    $browser.takeScreenshot();

}).then(function(){
 
   if ($browser.findElement($driver.By.xpath("//input[@value='Continue to Payment']")).isDisplayed()) {
				
        $browser.findElement($driver.By.xpath("//input[@value='Continue to Payment']")).click();
   }
   else	 console.log("[ERROR]Continue to Payment button is not present")		

}).then(function(){

        $browser.findElement($driver.By.id("inputcardNumberField")).sendKeys("4111111111111111");
        $browser.findElement($driver.By.id("inputcardCodeField")).sendKeys("123");
        $browser.findElement($driver.By.id("month")).sendKeys("1");
        $browser.findElement($driver.By.id("year")).sendKeys("2022");

        try{$browser.findElement($driver.By.xpath("//input[@value='Continue to Order Review']")).click();

        } catch( Exception) {
                console.log("[ERROR] Unable to Continue from Credit Card in Checkout")
        }
}).then(function(){
        console.log("Visa Credit Card input is working")
        if( $browser.findElement($driver.By.id("orderReview")).isDisplayed()){
          console.log("success to order review");      
        }
        else console.log("[ERROR] unable to see -Place Order-");
});
   
});	
	
	
	
*/	
}
