package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.TestBase;
import utilities.TestUtil;

public class CustomListener extends TestBase implements ITestListener 
{
	
	public void onTestStart(ITestResult result) 
	{
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		try {
			test.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		
		
		try {
			TestUtil.captureScreenshot();
			
			test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
		
	}

	public void onFinish(ITestResult result) 
	{
		
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
		
		try {
			
			test.skip("test skipped", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
		
	}
	

	
	
}
