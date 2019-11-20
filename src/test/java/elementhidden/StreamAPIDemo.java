package elementhidden;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamAPIDemo {

	public static void main(String[] args) 
	{
		
WebDriver driver ;
		
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement ele = driver.findElement(By.name("country"));
		Select select = new Select(ele);
		
		//select.getOptions().stream().anyMatch(i->i.getText().equalsIgnoreCase("INDIA"));
		
		select.getOptions().stream().forEach(i->System.out.println(i.getText()));

//		List<WebElement> list = select.getOptions();
//		
//		for (WebElement item : list)
//
//		{
//			if( item.getText().equalsIgnoreCase("INDIA"));
//            select.selectByVisibleText("INDIA");
//			
//			
//			break;
//				
//		}
		
		
		
		
		
		

	}

}
