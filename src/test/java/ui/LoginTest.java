package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver.Options;

public class LoginTest {

	public static String browser = "Chrome"; // Externel Configuration - XLS, CSV.
	// public static FirefoxDriver driver;
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*ChromeOptions chromeOptions = new ChromeOptions();

		// Set desired capabilities to accept insecure content
	    DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		capabilities.setCapability("acceptInsecureCerts", true);*/
		
		
		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--allow-running-insecure-content");
		  options.addArguments("--unsafely-treat-insecure-origin-as-secure=https://inno-app-ammrys.vercel.app/login"); 
		  options.addArguments("--ignore-certificate-errors");
		  options.addArguments("--allow-insecure-localhost");
		  options.setAcceptInsecureCerts(true);
		  options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		
		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		}

		// WebDriverManager.chromedriver().setup();

		// ChromeDriver driver = new ChromeDriver();

		
		
		 

		

		driver.get("https://inno-app-ammrys.vercel.app/");
		// driver.findElement(By.id("user-name")).sendKeys("standard_user");
		// driver.findElement(By.id("password")).sendKeys("secret_sauce");
		// driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/main/div[1]/div[1]/div/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(
				By.xpath("//*[@id=\"__next\"]/div/div/div/main/div[1]/div/div[2]/div[2]/div[2]/form/div[1]/input"))
				.sendKeys("miguel.henao@mdmtogo.com");
		driver.findElement(
				By.xpath("//*[@id=\"__next\"]/div/div/div/main/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/div/input"))
				.sendKeys("Abc@12345");
		driver.findElement(
				By.xpath("//*[@id=\"__next\"]/div/div/div/main/div[1]/div/div[2]/div[2]/div[2]/form/div[4]/button"))
				.click();

		// driver.close();

	}

}
