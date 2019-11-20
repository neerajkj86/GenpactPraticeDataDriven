package elementhidden;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementPresent {

	
	public static WebDriver driver ;
	
	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		System.out.println(isElmentPresent("//*[@id='javaa]"));
		
		//List <WebElement> radio=driver.findElements(By.id("male"));
		
		driver.close();
		

	}
	
	
	
	//TO ensure that elemement is present or not 
	
	// to optimize this method we have to pass By class object as an parameter otherwise we have to create 8 different methods for each locoator
//	public static boolean isElmentPresent(String Locator)
//	{
//		
////		try {
////			driver.findElement(By.xpath(Locator));
////			return true;
////			
////		} catch (Throwable t) {
////			
////			return false;
////			
////		}
//		
//		//Method 2 
//		
//	int size =	driver.findElements(By.xpath(Locator)).size();
//		
//	if (size ==0)
//	{
//		return false ;
//	}
//		
//	else 
//		return true;
//		
//	}

	
	public static boolean isElmentPresent(By by)
	{
		
//		try {
//			driver.findElement(By.xpath(Locator));
//			return true;
//			
//		} catch (Throwable t) {
//			
//			return false;
//			
//		}
		
		//Method 2 
		
	int size =	driver.findElements(By(by)).size();
		
	if (size ==0)
	{
		return false ;
	}
		
	else 
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
