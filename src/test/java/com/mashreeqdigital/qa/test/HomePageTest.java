/**
 * 
 */

package com.mashreeqdigital.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
	
	
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		htmlReporter=new ExtentHtmlReporter("extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	//Test Case 1 - The navigation bar should be visible on desktop devices
	@Test(priority = 1)
	public void verifyNavigationBar()
	
	{ 
		extent.createTest("Test To verify the Navigation Links in the Page");
		homePage=new HomePage();
		boolean navigDis=homePage.NavigationBarDisplayed();
		Assert.assertTrue(navigDis, navigDis ? "Value is match" : "Value does not match");

	}
	//Test Case 2- The navigation bar should be visible on desktop devices and display 9 items
	@Test(priority = 2)
	public void validateNavigationValues()
	
	{ 
		homePage=new HomePage();
		boolean display = homePage.displayValue();
		Assert.assertTrue(display, display ? "Value is match" : "Value does not match");
	}
	
	//Test Case 3 -The Mashreq News should be displayed on the homepage
	@Test(priority = 3)
	public void verifyNewsFeedLabel()
	
	{ 
		homePage=new HomePage();
		boolean newsFeed=homePage.verifyNewsFeed();
		Assert.assertTrue(newsFeed, newsFeed ? "Value is match" : "Value does not match");		

	}
	
	//Test Case 4 - Navigate us to Contact Us form and perform the Validations
	@Test(priority=4)
	public void clickContactUsLink()

	{
		homePage = new HomePage();
		contactUs = new ContactUsPage();
		homePage.clickContactUs();
		contactUs.clickOnSubmit();
		contactUs.displayValue();
		contactUs.verifySubProduct();
		contactUs.verifyMobileNumer();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
}
