package testcases;



import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class OpenAccountTest extends TestBase {

@Test(dataProviderClass =TestUtil.class,dataProvider = "dp",priority=3)	
public void OpenAccountTest(Hashtable<String, String> data) throws InterruptedException
{
	click("openaccount_CSS");
	
	select("customer_CSS",data.get("customer"));
	
	select("currency_CSS",data.get("currency"));
	
	click ("process_CSS");
	
	Thread.sleep(3000);
	
Alert alert=wait.until(ExpectedConditions.alertIsPresent());

alert.accept();


	
	
}



}
