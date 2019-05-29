/**
 * 
 */

package com.mashreeqdigital.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
@Listeners(com.mashreeqdigital.qa.base.TestNGListeners.class)

public class HomePageTest extends TestBase {

	HomePage homePage;
	ContactUsPage contactUs;
	
	
	SoftAssert sAssert=new SoftAssert();
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		htmlReporter = new ExtentHtmlReporter("Extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	//Test Case 1 - The navigation bar should be visible on desktop devices
	@Test
	public void verifyNavigationBar()
	
	{ 
		extent.attachReporter(htmlReporter);
		testEvent = extent.createTest("Navigate Bar Verification", "This test is to check the Navigation Bar on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage=new HomePage();
		boolean navigDis=homePage.NavigationBarDisplayed();
		sAssert.assertTrue(navigDis, navigDis ? "Value is match" : "Value does not match");
		log.info("Navigation bar is present");
		testEvent.pass("Navigation Bar is present on the page");
		sAssert.assertAll();

	}
	//Test Case 2- The navigation bar should be visible on desktop devices and display 9 items
	@Test(priority = 2)
	public void validateNavigationValues()
	
	{ 
		extent.attachReporter(htmlReporter);
		testEvent=extent.createTest("Navigate Bar Links Verification", "This test is to check the Navigation Bar Links on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage=new HomePage();
		boolean display = homePage.displayValue();
		sAssert.assertTrue(display, display ? "Value is match" : "Value does not match");
		log.info("Navigation Value is present on the Page");
		testEvent.pass("All the 9 Navigation Links are present on the page");
		sAssert.assertAll();
	}
	
	//Test Case 3 -The Mashreq News should be displayed on the homepage
	@Test(priority = 3)
	public void verifyNewsFeedLabel()
	
	{ 
		extent.attachReporter(htmlReporter);
		testEvent=extent.createTest("Mashreeq News Feed", "This test is to check theMashreeq News Feed on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage=new HomePage();
		boolean newsFeed=homePage.verifyNewsFeed();
		sAssert.assertTrue(newsFeed, newsFeed ? "Value is match" : "Value does not match");
		log.info("News Feed is present on the page");
		testEvent.pass("Mashreeq News Feed is Present on the page");
		sAssert.assertAll();

	}
	
	//Test Case 4 - Navigate us to Contact Us form and perform the Validations
	@Test(priority= 4)
	public void clickContactUsLink()

	{
		extent.attachReporter(htmlReporter);
		testEvent=extent.createTest("Verify Contact Us Link Page ", "This test is to check the Contact Us form on the page");
		testEvent.log(Status.INFO, "This TEST has been started(status, details)");
		
		homePage = new HomePage();
		contactUs = new ContactUsPage();
		homePage.clickContactUs();
		sAssert.assertEquals(true, false,"Succesfully Clicked on Contact U Linbk in the page");
		log.info("Succesfull click on contact us Link on the page");
		testEvent.pass("Click on Contact Us Link on the Page");
		
		contactUs.clickOnSubmit();
		sAssert.assertEquals(true, false,"Succesfully Clicked on Submit Button");
		log.info("Succesfull click on Submit Vutton on Contact us page");
		testEvent.pass("Click on Submit Button in Contact UsPage");
		
		contactUs.displayValue();
		sAssert.assertEquals(true, false,"Value propertly Displayed");
		log.info("Succesfully able to see all 4 values in the dropdown");
		testEvent.pass("I am looking to field is a dropdown with 4 choices");
		
		log.info("Sub Product Field is initially Empy in the page");
		testEvent.pass("Select Sub Product field is initially empty");
		contactUs.verifySubProduct();
		sAssert.assertEquals(true, false,"Loans in dropdown and simultaneously cvalue populate in sub product");
		log.info("Select the Loans in dropdown and simultaneously cvalue populate in sub product");
		testEvent.pass("Selecting the Product “Loans” from the dropdown and it populates the Select Sub Product sdropdown with 6 options");
		
		contactUs.verifyMobileNumer();
		sAssert.assertEquals(true, false,"Mobile Number is verified");
		log.info("Succesfull verify the value for mobile number");
		testEvent.pass("Succesfully Verify the value for mobile number field");
		sAssert.assertAll();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus())
        {
			testEvent.log(Status.FAIL, result.getThrowable());
            try 
            {
                TakesScreenshot ts=(TakesScreenshot)driver;
                File source=ts.getScreenshotAs(OutputType.FILE);
                String timestamp = String.valueOf(new Date().getTime());
                FileUtils.copyFile(source, new File("./ScreenShots/"+result.getName()+ timestamp +".png"));          
            } 
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }               
        }
		
		
		//To quit the Browser
		driver.quit();
		//Calling Flush writes Everything to the Log File
		extent.flush();
	}
}
