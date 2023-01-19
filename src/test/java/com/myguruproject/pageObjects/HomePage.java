package com.myguruproject.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage{
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver){
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath="//a[text()='New Customer']") 
	@CacheLookup 
	WebElement newCustomer;
	
	@FindBy(xpath="//div[@id='site-name']/a")@CacheLookup WebElement demoSite;
	
	@FindBy(xpath="//a[text()='New Tours']") @CacheLookup WebElement newTours;
	
	@FindBy(xpath="//a[text()='Log out']")@CacheLookup WebElement logOffButton;
	
	
	public void clickNewcustomer() {
		newCustomer.sendKeys(Keys.RETURN);
	}
	
	public boolean validateDemosite() {
		
		return demoSite.isDisplayed();
	}
	public void clickOnTour() {
		
		newTours.sendKeys(Keys.RETURN);
	}
	public void clickLogout() {
		logOffButton.sendKeys(Keys.ENTER);
	}

}
