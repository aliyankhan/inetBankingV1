package com.inetbanking.testCases;

import java.io.IOException;


import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPAGE;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPAGE lp = new LoginPAGE(driver);
		lp.setUsername(username);
		logger.info("username is entered...");
		lp.setPassword(password);
		logger.info("Password is entered...");
		lp.clickSubmit();
		
		
		Thread.sleep(3000);
		
		logger.info("providing customer details...");
		
		AddCustomerPage addcust = new AddCustomerPage(driver); 
		addcust.clickAddNewCustomer();
		addcust.custName("Aliyan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "2000");
		Thread.sleep(3000);
		addcust.custaddress("Pakistan");
		addcust.custcity("Karachi");
		addcust.custstate("SND");
		addcust.custpinno("755000");
		addcust.custtelephoneno("090078601");
		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true) 
		{
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else {
			logger.info("testcase is failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
		
	}
	
	

}
