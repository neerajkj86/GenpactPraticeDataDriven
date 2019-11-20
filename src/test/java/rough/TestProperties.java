package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws Throwable 
	{
		
		
		Properties config = new Properties();
		
		//System.out.println(System.getProperty("user.dir"));
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		
		config.load(fis);
		
		System.out.println(config.getProperty("browser"));
		
		Properties OR = new Properties();
		
 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		
		OR.load(fis);
		
		System.out.println(OR.getProperty("bmlBtn_CSS"));
		
		
		
		
		
		

	}

}
