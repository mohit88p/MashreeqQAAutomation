/**
 * 
 */
package com.mashreeqdigital.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.mashreeqdigital.qa.util.TestUtil;

/**
 * @author mohitpuri
 *
 */
public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization()
	{
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
			driver=new FirefoxDriver();
		}else if(browserName.equals("safari"))
		{
			driver=new SafariDriver();
		}else if(browserName.equals("opera"))
		{
			
			driver=new OperaDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
