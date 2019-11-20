package Parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
	public WebDriver driver ;
	
	public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver()
	{
		return dr.get();
		
	}
	
	public void SetWebdriver (WebDriver driver) 
	{
		
		dr.set(driver);
		
	}



	public WebDriver getDriver(String browser)
	
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}
	

}
