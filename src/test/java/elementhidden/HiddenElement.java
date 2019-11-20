package elementhidden;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author JainNe
 *   element is not clickable exception
 *   reasons : 
 *   1. overlapping of t he elemnts 
 *   2. lets assume we are trying to click on a image and suddenly a chatbot or alert pop up is coming on the page 
 *    solution : 
 *    1.somtimes we have to java script executor 
 *    2. somtimes it works like first we have to mouse hower using action class and then click on it.
 *    3 somtimes using different locator in different browser works
 *
 * elemet is not visible exception : 
 * 1. reason : web elemt is present in the dom but it is not visible to user or elemnt is not randored properly.
 *  like somtimes element is hidden
 *  sometimes we have to scroll on a page and then only the element is visible or somthing like that.
 *  
 *  
 *  elemnt is not present exception : 
 *  1.  syncronization issue 
 *  2. duplicate elements with same locator 
 *  3. elemt is inside a frame however we are using correct locator also.
 *  somtimes element is is changing dynamically on run time ...
 *
 */
public class HiddenElement {

	public static void main(String[] args) 
	{
		
		WebDriver driver ;
		
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		
		List <WebElement> radio=driver.findElements(By.id("male"));
		
		int  count = radio.size();
		
		System.out.println(radio.size());
		
		for (int i=0;i<count ;i++)
		{
			if (radio.get(i).getLocation().getX()!=0)
			{
				radio.get(i).click();
				break;
			}
		}
		
		
		
		
		
	//	driver.findElement(By.id("male")).click();
		
//		int x = driver.findElement(By.id("male")).getLocation().getX();
//		
//		int y =driver.findElement(By.id("male")).getLocation().getY();
//		
		
//         Rectangle rect = driver.findElement(By.id("male")).getRect();
//         
//         System.out.println(rect.getHeight());
//       
//      System.out.println (rect.getWidth());	
           
           
      // Dimension abc=  driver.findElement(By.id("male")).getSize();
		
//       System.out.println(abc.getHeight());
//       
//       System.out.println (abc.getWidth());
//		
		
		
		
//		System.out.println(x);
//		
//		System.out.println(y);
		
		
		
		

	}

}
