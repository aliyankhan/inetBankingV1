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

public class BasicWebDriverMethods {

	
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
		
		
		
		driver.get("https://www.saucelabs.com");
		driver.manage().window().maximize();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.navigate().forward();
		
		
		
		
		
		
		

		
		
	}

}

