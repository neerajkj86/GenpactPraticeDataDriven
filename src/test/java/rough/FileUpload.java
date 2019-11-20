package rough;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

    public class FileUpload {

	public static void main(String[] args) throws Throwable 
	{
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/keyboard-events/");
		
		driver.findElement(By.xpath("//*[@id=\"browseFile\"]")).click();
		
		Robot robot = new Robot();
		
		Thread.sleep(2000); 
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_CANCEL);
		
		

	}

}
