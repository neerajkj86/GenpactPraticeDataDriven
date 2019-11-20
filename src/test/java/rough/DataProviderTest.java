package rough;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest 
{
	
	
	@Parameters({"browser"})
	@Test
	public void doLogin(String b) throws Throwable
	{
		
		Date d = new Date();
		System.out.println("Browser name is "+b +"--" +d);
		
		Thread.sleep(3000);
		
		
	}

	
	
}
