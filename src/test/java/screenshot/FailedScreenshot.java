package screenshot;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class FailedScreenshot extends TestBase
{
	
	@BeforeTest
	public void init ()
	{
	  setup();
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	@Test
	public void takesScreenShot()
	{
		Assert.fail("Getting failed");
	}
	

}
