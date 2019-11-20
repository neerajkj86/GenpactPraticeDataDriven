package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase
{
	
	@Test(priority =1)
	public void loginAsBankManager() throws Throwable
	{
		
		log.info("Login Test !!");	
		test =extent.createTest("Login As Bank Manager");
		test.info("Tryint to login as Bank manager");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).click();
		
		click("bmlBtn_CSS");
		
		
		
		//test.info("element is loacted here in extent report");
	
		Thread.sleep(3000);
		
		Assert.assertTrue(iselementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login not successfull");
		
           //Assert.fail("Forcefully failed to check extent report");		
		
		log.info("Login Successfully checked !!");	
		
		//test.info("Login as bank manager is successfull");
		
		//Assert.fail("Bank Manager Login is also Forcefully failed");
		
		//test.fail("Login as bank manager is successfull for Extent Report");
	
		
		
		
		
		
		
		
	}

}
