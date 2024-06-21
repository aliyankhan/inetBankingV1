package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.log4j.Level;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPAGE;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException 
	{
		
		logger.setLevel(Level.ALL);
		
		LoginPAGE lp = new LoginPAGE(driver);
		lp.setUsername(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // to go to main page
			Assert.assertTrue(false);
			logger.error("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		
		// i ko 1 is lie lya hai q k excelsheet ki 0th row header hoti hai is lie usey use nhi kerte
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount; j++) 
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1, 0 
			}
		}
		
		
		return logindata;
	}
}
