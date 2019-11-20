package rough;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoToTop {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.jabong.com/men/clothing/polos-tshirts/?source=topnav_men");
		
		
		// Default height
		Long defaultScroll= (Long) ((JavascriptExecutor) driver).executeScript(" return window.scrollY");
		
		System.out.println("Default scroll height: "+defaultScroll);
		
		// To scroll till the end of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		// Get scroll height after scrolling till end
		Long currentScroll= (Long) ((JavascriptExecutor) driver).executeScript(" return window.scrollY");
		
		System.out.println("Current scroll height after scrolling: "+currentScroll);
		
		// Locating back to top button
		WebElement backToTop= driver.findElement(By.id("back-to-top"));
		
		// Click on back to top button
		backToTop.click();
		
		// Sleep is required to wait till it goes to top
		Thread.sleep(5000);
		
		// Get scroll height after scrolling till end
		Long currentScrollHeightAfterClickingOnBackToTop= (Long) ((JavascriptExecutor) driver).executeScript(" return window.scrollY");
				
		System.out.println("Current scroll height after clicking on back to top button: "+currentScrollHeightAfterClickingOnBackToTop);
		
		driver.quit();
	}
}