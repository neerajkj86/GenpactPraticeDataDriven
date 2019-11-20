package screenshot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver ;

	public static Properties config = new Properties();
	
	public static Properties OR = new Properties();
	
	public static void setup()
	{
          WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
	}

	
	
	
	
       public static void CaputurScreenshot(Method m){
    	   
    	   Date d = new Date();
    	   
    	   
    	   
    	   String screenshotName=d.toString().replace(":", "_").replace(" ", "_") +".jpg";
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	
	File src=	ts.getScreenshotAs(OutputType.FILE);
	
	
	File dest = new File(System.getProperty("user.dir")+"\\target\\Screenshot\\"+screenshotName+m.getName());

	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
       
       
       
       
       }
       
       
       
       
       public static void CaputurScreenshot(WebElement ele)

       {
    	   
    	   Date d = new Date();
    	   
    	   String screenshotName=d.toString().replace(":", "_").replace(" ", "_") +".jpg";
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	
	File src=	ts.getScreenshotAs(OutputType.FILE);
	
	
	File dest = new File(System.getProperty("user.dir")+"\\target\\Screenshot\\"+screenshotName);

	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
       
       
       
       
       }
       
       
       
       
       
       
       
       
       
       
       public static void Highlight(WebElement ele)
       {
    	   
    	  JavascriptExecutor js  = (JavascriptExecutor)driver;
    	  
    	  js.executeScript("arguments[0].style.border='2px solid red'", ele);
    	   
    	   
       }
       
       
//         public static void type (String locator ,String value)
//         {
//        	 WebElement ele =driver.findElement(By.xpath(locator));
//        	 ele.sendKeys(value);
//        	 
//         }
       
       
       
       
       
       
       
       
       
}