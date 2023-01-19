package com.myguruproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myguruproject.pageObjects.AddCustomerPage;
import com.myguruproject.pageObjects.HomePage;
import com.myguruproject.pageObjects.LoginPage;
import com.myguruproject.utilities.HelperClass;

public class TC_AddCustomerTest_004 extends BaseClass{
	LoginPage lp;
	HomePage hp;
	AddCustomerPage add;
	
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		
		lp=new LoginPage(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		hp=new HomePage(driver);
		hp.clickNewcustomer();
		
		add =new AddCustomerPage(driver);
		
		add.getMessage();
		add.getName("peter");
		add.clickRadio();
		add.getDate("07/12/1980");
		add.getAddress("30 Stanton Street");
		add.getCity("Sango");
		add.getStateName("Lagos");
		add.getPinno(345261);
		add.getPhonno(34764528);
		String email=randomstring()+"@gmail.com";//randomstring() method in baseClass
		add.setEmail(email);
		add.setPassword("abcr@12");
		add.clickSubnitButton();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
			
		}
		else {
			HelperClass.captureScreenshot(driver);
			Assert.assertTrue(false);
			
				
			}
			
		}
	

}
