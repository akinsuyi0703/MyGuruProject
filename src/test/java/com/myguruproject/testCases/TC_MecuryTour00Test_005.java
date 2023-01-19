package com.myguruproject.testCases;

import org.testng.annotations.Test;
import com.myguruproject.pageObjects.HomePage;
import com.myguruproject.pageObjects.LoginPage;
import com.myguruproject.pageObjects.MecuryTourPage;

public class TC_MecuryTour00Test_005 extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	MecuryTourPage mtp;
	
	@Test//(groups="Regression")
	public void registerPage() {
	LoginPage lp=new LoginPage(driver);
	lp.setUsername(username);
	lp.setPassword(password);
	lp.clickSubmit();
	
	hp=new HomePage(driver);
	
	hp.validateDemosite();
	
	hp.clickOnTour();
	
	mtp=new MecuryTourPage(driver);
	
	mtp.validateMecuryTourImage();
	
	mtp.clickRegisterButton();
	
	mtp.goBack();
	
	mtp.goBackBack();

}
}