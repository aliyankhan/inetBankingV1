package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPAGE {
	
	WebDriver ldriver;
	
	
	public LoginPAGE(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		//PageFactory.initElements(this, rdriver);
		
	}

	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
		
	}
	
	public void clickSubmit() 
	{
		
		btnLogin.click();
	}
	
	public void clickLogout() 
	{
		lnkLogout.click();
	}
	
	
	
}
