package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	
	public static String browser = "Chrome";     //Externel Configuration - XLS, CSV.
	//public static FirefoxDriver driver;
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(browser.equals("Firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			
			 driver = new FirefoxDriver();
		}
		else if(browser.equals("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			
			 driver = new ChromeDriver();
		}
		else if(browser.equals("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			
			 driver = new EdgeDriver();
			
		}
		
		
		
		driver.get("https://developer.salesforce.com/signup");
	//WebElement password = driver.findElement(By.id("password"));
	//driver.findElement(with(By.tagName("input")).above(password)).sendKeys("Testing");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("aliyan");
		
		
	}

}

