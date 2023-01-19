package com.myguruproject.testCases;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myguruproject.utilities.HelperClass;
import com.myguruproject.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig rc=new ReadConfig();
	
	
	public String baseURL=rc.getBaseURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;//initiated webDriver
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter sparkReporter;
    
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		Reporter.log("Trying to start browser and getting application ready", true);
		
		logger=LogManager.getLogger(BaseClass.class);
	   
		
		if(br.equals("chrome")) 
		{
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();//instantiate WebDriver
		
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		
		}
		else if(br.equals("edge"))
		{
		    WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
		Reporter.log("Browser and Application is up and running", true);
		
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	@BeforeSuite
	public void initialiseExtentReport() throws IOException {
		
		Reporter.log("Setting up reports and Test Started", true);
		
		extent = new ExtentReports();
		File file = new File("report.html");
		sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.loadXMLConfig(new File("./src/test/resources/extent-config.xml"));
	    extent.attachReporter(sparkReporter);
	    Reporter.log("Setting Done- Test can be Started", true);
		
	    
	    test=extent.createTest("LoginTest");
       
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));

}
	
	@AfterSuite
	public void generateExtentReports() throws IOException {
		
		extent.flush();
		Reporter.log("Test Completed >>>> A report generated", true);
		Desktop.getDesktop().browse(new File("report.html").toURI());//open the file in the desktop default browse
	}
	
	@AfterMethod
	public void closeDown(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end", true);
		
         Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
		
		   test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
	}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
		   test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			
		   test.skip("Test Skip", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
			
		}
	
		
		
		
		  //extent.flush();
		  
		  //Reporter.log("Test Completed >>>> A report generated", true);
		  //Desktop.getDesktop().browse(new File("report.html").toURI());//open the file in the desktop default browse
		 
		

	}
	
	 public static boolean isAlertPresent() { //user defined method created to check alert is present or not
		    
		  try {
	     driver.switchTo().alert();
	     return true;
	}
	     catch(NoAlertPresentException e){
		 return false;
	}
	  }	
		//user define function for random emailid or ramdomdata for new customers how to generate it dynamically
		
		public String randomstring() {
			String generatedstring=RandomStringUtils.randomAlphabetic(8);//predefined class in java to generate randon string
			return(generatedstring);
		}
		public static String randomnumeric() {
			String generatedString2=RandomStringUtils.randomNumeric(5);//predefined class in java to generate randon string
			return(generatedString2);
		}

}
