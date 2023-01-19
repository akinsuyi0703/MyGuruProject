package com.myguruproject.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
    @FindBy(xpath="//input[@name='uid']") 
    @CacheLookup 
    WebElement txtUsername;
	
	@FindBy(name="password") 
	@CacheLookup 
	WebElement txtPassword;
	
	@FindBy(name="btnLogin") 
	@CacheLookup 
	WebElement btnButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup 
	WebElement clickLogout;
	
	public void setUsername(String uname) {
		
		txtUsername.sendKeys(uname);
	}
	
    public void setPassword(String pass) {
		
		txtPassword.sendKeys(pass);
	}

    public void clickSubmit() {
	
	    btnButton.sendKeys(Keys.RETURN);
   }
    
    public void clickLogoutLink() {
    	
	    clickLogout.sendKeys(Keys.RETURN);
}
	
}
