/**
 * 
 */

package com.mashreeqdigital.qa.test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mashreeqdigital.qa.base.TestBase;
import com.mashreeqdigital.qa.pages.ContactUsPage;
import com.mashreeqdigital.qa.pages.HomePage;


/**
 * @author mohitpuri
 *
 */
public class HomePageTest extends TestBase {

	HomePage homePage;
	ContactUsPage contactUs;
	
	public HomePageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
	}
	
	
//	
//	@Test(priority = 1)
//	public void verifyNavigationBar()
//	
//	{ 
//		homePage=new HomePage();
//		boolean navigDis=homePage.NavigationBarDisplayed();
//		Assert.assertTrue(navigDis, navigDis ? "Value is match" : "Value is not matchss");
//
//	}
//	@Test(priority = 2)
//	public void clickOnContactUsLink()
//	
//	{ 
//		homePage=new HomePage();
//		boolean display = homePage.displayValue();
//		Assert.assertTrue(display, display ? "Value is match" : "Value is not matchs");
//	}
//	
//	
//	
//	
//	@Test(priority = 3)
//	public void verifyNewsFeedLabel()
//	
//	{ 
//		homePage=new HomePage();
//		homePage.verifyNewsFeed();
//		
//
//	}
	@Test
	public void clickContactUsLink()
	
	{ 
		homePage=new HomePage();
		contactUs=new ContactUsPage();
		homePage.clickContactUs();
		System.out.println("Contact Us Screen");
		contactUs.clickOnSubmit();
		contactUs.displayValue();
		contactUs.verifySubProduct();
		contactUs.verifyMobileNumer();

	}
	
	
@AfterMethod
	public void tearDown()
	{
		// driver.quit();
	}
}
