package screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ScreenshotcompletePage extends TestBase {

	
	
	public static void main(String[] args) throws Throwable {
	
		
        TestBase.setup();
        
		Thread.sleep(3000);
		
		TestBase.CaputurScreenshot();
		
		WebElement ele =driver.findElement(By.xpath("//*[@id='search']"));
		
		TestBase.Highlight(ele);
		
		Thread.sleep(3000);
		
		TestBase.CaputurScreenshot(ele);
		
		System.out.println("captured");
		
		//driver.findElement(RelativeLocator.withTagName("").above(element);
		
	
	driver.close();
	
		
		
	}

}
