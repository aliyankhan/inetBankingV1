package com.inetbanking.testCases;


import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPAGE;

public class TC_LoginTest_001 extends BaseClass{

	
	
	
	@Test
	public void loginTest() throws IOException {
		
		
	
	
		logger.info("URL is opened");
		
		LoginPAGE lp = new LoginPAGE(driver);
		
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered Password");
		
		String title = driver.getTitle();
		System.out.print(title);
		
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage1234")) 
		{
			Assert.assertTrue(true);
			logger.info("LoginTest is passed");
		}
		else 
		{
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("LoginTest is failed.");
		}
		
		
	}
}
