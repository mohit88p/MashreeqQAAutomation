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
import com.aventstack.extentreports.Status;
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
		extent.attachReporter(htmlReporter);
		extent.createTest("Navigate Bar Verification", "This test is to check the Navigation Bar on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage=new HomePage();
		boolean navigDis=homePage.NavigationBarDisplayed();
		Assert.assertTrue(navigDis, navigDis ? "Value is match" : "Value does not match");
		
		testEvent.pass("Navigation Bar is present on the page");

	}
	//Test Case 2- The navigation bar should be visible on desktop devices and display 9 items
	@Test(priority = 2)
	public void validateNavigationValues()
	
	{ 
		extent.attachReporter(htmlReporter);
		extent.createTest("Navigate Bar Links Verification", "This test is to check the Navigation Bar Links on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage=new HomePage();
		boolean display = homePage.displayValue();
		Assert.assertTrue(display, display ? "Value is match" : "Value does not match");
		
		testEvent.pass("All the 9 Navigation Links are present on the page");
	}
	
	//Test Case 3 -The Mashreq News should be displayed on the homepage
	@Test(priority = 3)
	public void verifyNewsFeedLabel()
	
	{ 
		extent.attachReporter(htmlReporter);
		extent.createTest("Mashreeq News Feed", "This test is to check theMashreeq News Feed on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage=new HomePage();
		boolean newsFeed=homePage.verifyNewsFeed();
		Assert.assertTrue(newsFeed, newsFeed ? "Value is match" : "Value does not match");	
		
		testEvent.pass("Mashreeq News Feed is Present on the page");

	}
	
	//Test Case 4 - Navigate us to Contact Us form and perform the Validations
	@Test(priority=4)
	public void clickContactUsLink()

	{
		extent.attachReporter(htmlReporter);
		extent.createTest("Verify Contact Us Link Page ", "This test is to check the Contact Us form on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage = new HomePage();
		contactUs = new ContactUsPage();
		homePage.clickContactUs();
		testEvent.pass("Click on Contact Us Link on the Page");
		
		contactUs.clickOnSubmit();
		testEvent.pass("Click on Submit Button in Contact UsPage");
		
		contactUs.displayValue();
		testEvent.pass("I am looking to field is a dropdown with 4 choices");
		
		testEvent.pass("Select Sub Product field is initially empty");
		contactUs.verifySubProduct();
		testEvent.pass("Selecting the Product “Loans” from the dropdown and it populates the Select Sub Product sdropdown with 6 options");
		
		contactUs.verifyMobileNumer();
		testEvent.pass("Succesfully Verify the value for mobile number field");

	}

	@AfterMethod
	public void tearDown() {
		//To quit the Browser
		driver.quit();
		//Calling Flush writes Everything to the Log File
		extent.flush();
	}
}
