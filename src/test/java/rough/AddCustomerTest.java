package rough;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProvider = "getData",priority=2,dependsOnMethods = "loginAsBankManager")
	public void addCustomer(String firstName ,String lastName,String postCode,String Alerttext) throws InterruptedException
	{
		
		String path =System.getProperty("user.dir");
		
		System.out.println(path);
		
		
		
		test =extent.createTest("Adding a new Customer"); // here we are creating a test for Extent report
		test.info("Tryint to create a New Customer");
		
		
		
		click("addCustBtn_CSS");
		
		
		
		log.info("Add Customer TOp Button is clicked");
		
		
		type("firstname_CSS", firstName);
		
		
		log.info("First Name is fetched");
		
		
		type("lastname_XPATH", lastName);
		
		
		
		
		log.info("last Name is fetched");
		
		
		type("postcode_CSS", postCode);
		
		log.info("postcode  is fetched");
		
		click("addbtn_CSS");
		
		log.info("Bottom Add cutomer button is clicked");
		//test.info("element is loacted here in extent for Add customer screen");

		 //Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		
Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue( alert.getText().contains(Alerttext));
	
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
