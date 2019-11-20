package Selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {

	public static WebDriver driver ;
	public static void main(String[] args) 
	{
		
		
WebDriverManager.chromedriver().setup();
ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

threadLocal.set(34);

		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.google.com/");
		
		System.out.println("First Window Title is "+driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		System.out.println("New Window Title is "+driver.getTitle());
		driver.quit();
		
		
	}

}
