package base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.TestUtil;



public class TestBase {

	
	
	
	public static WebDriver driver;
	
	public static Properties config = new Properties();
	
	public static Properties OR = new Properties();
	
	public static FileInputStream fis;
	
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	
	public static Date d = new Date();
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	
	public static WebDriverWait wait;
	
	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	public static ExtentTest test ;
	
	
	
	@BeforeSuite
	public void setup()
	{
		
		
		
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		log.info("This is the information log");
		
		
		
		
		
		
		
		
		if (driver ==null)
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
				config.load(fis);
				log.info("config file loaded !!");	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		if (config.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (config.getProperty("browser").equalsIgnoreCase("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("chrome driver is launched !!");	
			driver.get(config.getProperty("testsiteurl"));
			log.info("Application is loaded !!");	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 5);
				}
		
		if (extent==null){
			try {
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\target\\surefire-reports\\extent_"+TestUtil.getCurrentDateTime()+".html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//initialize ExtentReports and attach the HtmlReporter
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
		
	}
		
		
		public boolean iselementPresent (By by)
		
		{
			try {
				driver.findElement(by);
				return true ;
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				
				return false;
			}
			
			
			
		}
		
		
		public void click(String Locator)
		{
			
			if (Locator.endsWith("_CSS"))
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).click();
			
			else if (Locator.endsWith("_XPATH")) 
				driver.findElement(By.xpath(OR.getProperty(Locator))).click();
			
			
			
			test.info("Click on : " +Locator); // this step will be added in the extent report which is very important for logging
		}
		
		public void type(String Locator,String value )
		{
			if (Locator.endsWith("_CSS"))
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).sendKeys(value);
			
			else if  (Locator.endsWith("_XPATH"))
				driver.findElement(By.xpath(OR.getProperty(Locator))).sendKeys(value);
			
			test.info("Typing in : " + Locator + " entered value as " + value);
		}
		
		
public static WebElement dropdown;
		public void select (String Locator ,String value)
		
		{
			
			if (Locator.endsWith("_CSS"))
				dropdown =driver.findElement(By.cssSelector(OR.getProperty(Locator)));
			else if (Locator.endsWith("_XPATH"))
				dropdown=driver.findElement(By.xpath(OR.getProperty(Locator)));
			
			Select select = new Select(dropdown);
			
			select.selectByVisibleText(value);
			
			test.info("selecting from dropdown : " + Locator + " selected value as " + value);
			
			
			
			
			
		}
		
		
		
	
	
	@AfterSuite
	public void teardown()
	{
		if (driver != null)
		{
			driver.quit();
		}
		
		extent.flush();
		
	}
	
	
	
	
}
