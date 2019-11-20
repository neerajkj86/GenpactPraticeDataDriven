package rough;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest2 
{
	
	@Test(dataProvider = "getData")
	public void doLogin(String b) throws Throwable
	{
		Date d = new Date();
		System.out.println("Browser name is "+b+"---"+d);
		
		Thread.sleep(3000);
		
		
	}

	@DataProvider(parallel = true)
	public Object[][] getData()
	{
		Object[][] data = new Object[2][1]; 
		
		data[0][0] = "Chrome";
		
		data[1][0] = "Firefox";
		
		return data;
		
	}
	
}
