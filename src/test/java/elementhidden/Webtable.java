package elementhidden;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		
WebDriver driver ;
		
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
	List <WebElement> rownums=	driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		
	List <WebElement> colsnums=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td"));
		
		
	System.out.println("Number of rows are" +rownums.size());
	
	System.out.println("Number of cols are" +colsnums.size());
	
	
	for (int rows=1;rows<=rownums.size();rows++)
		
	{
		for (int cols =1;cols <=colsnums.size();cols++)
		{
			System.out.print(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()+" ");
		}
		
		System.out.println();
	}
		
	
	
	
	
	
	
	
	
	
	
	driver.close();
	
	
	
	
	


	}

}
