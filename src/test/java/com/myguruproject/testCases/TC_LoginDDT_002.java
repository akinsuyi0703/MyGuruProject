package com.myguruproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myguruproject.pageObjects.HomePage;
import com.myguruproject.pageObjects.LoginPage;
import com.myguruproject.utilities.ExcelDataSupllier;
import com.myguruproject.utilities.HelperClass;

public class TC_LoginDDT_002 extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupllier.class)
	public void loginDDT(String uname, String pass) throws InterruptedException {
		
		logger.info("URL is opened");
		test=extent.createTest("Login to guru99Demo");
		
	    lp=new LoginPage(driver);
		
		test.info("Starting Application");
		lp.setUsername(uname);
		logger.info("Entered username");
		
		lp.setPassword(pass);
		logger.info("Entered password");
		
		lp.clickSubmit();
		Thread.sleep(3000);
		test.pass("Login successfully");
		
		hp =new HomePage(driver);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();// this command focus on main page
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			hp.clickLogout();
			Thread.sleep(3000);
			logger.info("login passed");
		    driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();//focus on login
		}
		
		
		
		
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			
			Assert.assertTrue(true);
			test.info("Login Test passed");
		}
		else {
			Assert.assertTrue(false);
			test.info("Login Test failed");
		}
		HelperClass.captureScreenshot(driver);
			
		
	}
		
	}


