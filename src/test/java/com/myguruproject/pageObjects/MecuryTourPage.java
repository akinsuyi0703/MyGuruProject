package com.myguruproject.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myguruproject.testCases.BaseClass;



public class MecuryTourPage extends BaseClass{
	
	
	
	public MecuryTourPage(WebDriver driver) {
	     BaseClass.driver=driver;//instead of using this keyword i use the webdriver in baseclass since we extends it in this class that's why i use BaseClass.driver
	     PageFactory.initElements(driver, this);
	} 
	
	
		@FindBy(xpath="//img[@alt='Mercury Tours']")@CacheLookup WebElement mecuryTourImage;
	
	
		@FindBy(linkText="REGISTER") @CacheLookup WebElement mecuryTours;
	
	
    public boolean validateMecuryTourImage() {
    	
    	return mecuryTourImage.isDisplayed();
    
    }
    
    public void clickRegisterButton() {
    	mecuryTours.sendKeys(Keys.RETURN);
    }
    
    public void goBack() {
    	driver.navigate().back();
    }
    
    public void goBackBack() {
    	driver.navigate().back();
    }
}
