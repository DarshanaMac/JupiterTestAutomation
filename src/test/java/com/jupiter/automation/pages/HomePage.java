package com.jupiter.automation.pages;

import com.aventstack.extentreports.Status;
import com.framework.codebase.CodeBase;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends CodeBase {
    //AndroidDriver<WebElement> driver;
 
    public HomePage() {
        //this.driver = driver;
        PageFactory.initElements(driver, this);   
    }
 
   public void clickPayLater() throws InterruptedException {
	   Thread.sleep(10000);
	   driver.findElement(MobileBy.xpath("//android.view.View[@content-desc=\"ProductList0\"]")).click();
	   test1.log(Status.PASS, "ELEMENT CLICKED "+"AA");
   }
   
 
}
