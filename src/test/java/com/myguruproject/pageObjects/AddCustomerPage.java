package com.myguruproject.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




 public class AddCustomerPage{
	
	 WebDriver ldriver;
		
		public AddCustomerPage(WebDriver rdriver){
			ldriver =rdriver;
			PageFactory.initElements(rdriver, this);
		}
	
    @FindBy(how=How.XPATH, using="//p[text()='Add New Customer']") 
    @CacheLookup 
    WebElement textMessage;
	
	@FindBy(how=How.NAME, using="name") 
	@CacheLookup 
	WebElement txtname;
	
	/*@FindBy(how=How.XPATH, using="//input[@value='m']") 
	@CacheLookup 
	WebElement clickradioButton;*/
	
	@FindBy(how=How.XPATH, using="//input[@value='f']") 
	@CacheLookup 
	WebElement clickradButton;
	
	@FindBy(how=How.ID, using="dob") 
	@CacheLookup 
	WebElement Date;
	
	@FindBy(how=How.NAME, using="addr") 
	@CacheLookup 
	WebElement addressField;
	
	@FindBy(how=How.NAME, using="city") 
	@CacheLookup 
	WebElement cityField;
	
	@FindBy(how=How.NAME, using="state") 
	@CacheLookup 
	WebElement stateField;
	
	@FindBy(how=How.NAME, using="pinno") 
	@CacheLookup 
	WebElement pinnoField;
	
	@FindBy(how=How.NAME, using="telephoneno") 
	@CacheLookup 
	WebElement phonenoField;
	
	@FindBy(how=How.NAME, using="emailid") 
	@CacheLookup 
	WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="password") 
	@CacheLookup 
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub") 
	@CacheLookup 
	WebElement clickSubmit;
	
    
	public boolean getMessage() {
		return textMessage.isDisplayed();
	}
	
	public void getName(String name) {
		txtname.sendKeys(name);
	}
	
	public boolean clickRadio() {

		return clickradButton.isSelected();
	}
	
	/*public void clickRadio(String female) {
           clickradButton.sendKeys(Keys.RETURN);
	}*/
	
	public void getDate(String date) {
		Date.sendKeys(date);
	}
	
	public void getAddress(String address) {
		addressField.sendKeys(address);
	}
	
	public void getCity(String city) {
		cityField.sendKeys(city);
	}
	
	public void getStateName(String state) {
		stateField.sendKeys(state);;
	}
	
	public void getPinno(int i) {
		pinnoField.sendKeys(String.valueOf(i));
	}
	
	public void getPhonno(int j) {
		phonenoField.sendKeys(String.valueOf(j));
	}
	
	public void setEmail(String email1) {
		txtEmail.sendKeys(email1);;
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubnitButton() {
		clickSubmit.sendKeys(Keys.RETURN);
	}

}
