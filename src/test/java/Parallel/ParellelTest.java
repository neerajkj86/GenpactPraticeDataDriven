package Parallel;

import org.testng.annotations.Test;

public class ParellelTest extends BaseClass 
{
	@Test(invocationCount = 3,threadPoolSize = 3)
	public void executeTest()
	{
		driver =getDriver("chrome");
		
		SetWebdriver(driver);
		getDriver().get("https://www.google.com");
		
	System.out.println(driver.getTitle());
	
	driver.quit();
		
		
	}

}
