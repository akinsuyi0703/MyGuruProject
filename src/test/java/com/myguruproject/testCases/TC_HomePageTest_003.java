package com.myguruproject.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.myguruproject.pageObjects.HomePage;
import com.myguruproject.pageObjects.LoginPage;



public class TC_HomePageTest_003 extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	
	@Test//(groups="Sanity")
	public void verifyHomePage() throws InterruptedException {
		
		lp= new LoginPage(driver);
		
		lp.setUsername(username);
		
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		hp=new HomePage(driver);
		
		hp.validateDemosite();
		
		hp.clickOnTour();
		Thread.sleep(2000);
		
		String actTitle=driver.getTitle();
		
		String expTitle="Welcome: Mercury Tours";
		
		Assert.assertEquals(actTitle,expTitle);
		
	}
	

}
