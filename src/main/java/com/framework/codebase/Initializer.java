package com.framework.codebase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Initializer {

    //public static WebDriver driver;
	public static AppiumDriver driver;
    static File file;

   static ExtentSparkReporter htmlReporter;
    static ExtentReports extent = new ExtentReports();
    static ExtentTest test1;

    /**
     * Generate Report
     *
     */
    public static void startReport() {
        String filepath = file.getAbsolutePath();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        htmlReporter = new ExtentSparkReporter(filepath +"\\reports"+ "\\ActiTime_"+timeStamp+".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void genReport(){
        startReport();
    }

    @BeforeMethod
    public void createtest(Method method){
        test1 = extent.createTest(method.getName(), "test to validate search box");
    }

    @BeforeSuite
    public void config() {

        file = new File("");
    }

    /**
     * Create Browser instance
     * @throws MalformedURLException 
     */
    @BeforeSuite
    public static void init() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() + File.separator + "Lib" + File.separator + "chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    	DesiredCapabilities caps = new DesiredCapabilities();

    	caps.setCapability("automationName", "UiAutomator2");

    	caps.setCapability("platformName", "Android"); //Give Device ID  caps.setCapability("platformName", "Android");

    	caps.setCapability("platformVersion", "11");
    	
    	caps.setCapability("deviceName", "OPPO");
    	
    	caps.setCapability("udid", "6c4bda0a");
    	caps.setCapability("appPackage", "com.example.inypay");

    	caps.setCapability("appActivity", "com.example.inypay.MainActivity");

    	caps.setCapability("noReset", "true");
    	caps.setCapability("newCommandTimeout", 4000);
    	//Instantiate Appium Driver

    
    	driver  = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

    
    }
    

    @AfterTest
    public void down()
    {
        driver.quit();
    }

    @AfterMethod
    public void flushReport(){
        extent.flush();
    }


}
