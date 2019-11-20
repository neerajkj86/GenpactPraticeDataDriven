package screenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class CustomListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result)
	{
	
		System.out.println("Welcome to Start");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Welcome to failure");
		TestBase.CaputurScreenshot();
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	
	
	
	
}
