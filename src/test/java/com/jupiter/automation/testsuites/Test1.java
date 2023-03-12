 package com.jupiter.automation.testsuites;

import com.framework.codebase.Initializer;
import com.jupiter.automation.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Test1 extends Initializer {

    /**
     * @param url,username,password
     *
     * Description: Verify login function with valid regular user details
     */
    @Test()
    public void Test1() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickPayLater();
        
  }
    
   
    
    


    
   
}
