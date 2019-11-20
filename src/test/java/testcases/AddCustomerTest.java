package testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp",priority=2)
	public void AddCustomerTest(Hashtable<String, String> data) throws InterruptedException
	{
		
		
		
		
		
		test =extent.createTest("Adding a new Customer"); // here we are creating a test for Extent report
		test.info("Tryint to create a New Customer");
		
		
		
		click("addCustBtn_CSS");
		
		
		
		log.info("Add Customer TOp Button is clicked");
		
		
		type("firstname_CSS", data.get("firstName"));
		
		
		log.info("First Name is fetched");
		
		
		type("lastname_XPATH", data.get("lastName"));
		
		log.info("last Name is fetched");
		
		
		type("postcode_CSS", data.get("postCode"));
		
		log.info("postcode  is fetched");
		
		click("addbtn_CSS");
		
		log.info("Bottom Add cutomer button is clicked");
		//test.info("element is loacted here in extent for Add customer screen");

		 
		
Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue( alert.getText().contains(data.get("Alerttext")));
	
	Thread.sleep(5000); // to check whether it clicked on alert 
		
		alert.accept();
		
		
		test.pass("Customer is added successfully");
		
		
		
		
		
		
		
		
//Assert.fail("Test case is forcefully failed");	
		
	}
	
	
//	
//	@DataProvider
//	public Object [][] getData(){
//		
//		String sheetName = "AddCutomerTest";
//		
//		int rows=excel.getRowCount(sheetName);
//		
//		int cols =excel.getColumnCount(sheetName);
//		
//		//How to initalize multidimentional array is 
//		//int [][] arr = new int [4][5];
//		
//		Object [][] data = new Object [rows-1][cols];
//		
//		for (int i=2;i<=rows;i++)
//		{
//			for (int j=0;j<cols;j++)
//			{
//			data[i-2][j]=excel.getCellData(sheetName, j, i);
//			}
//		}
//		
//		return data;
//		
//	}

}
