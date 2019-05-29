/**
 * 
 */
package com.mashreeqdigital.qa.pages;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mashreeqdigital.qa.util.TestUtil;


/**
 * @author mohitpuri
 * This class will land us to home page pf Mashreeq in the application
 */
public class ContactUsPage extends com.mashreeqdigital.qa.base.TestBase {
	
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//*[contains(@class,'ng-invalid') ]")
	WebElement invalidContacts;
	
	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobileEditField;
	
	@FindBy(xpath = "//input[@id='mobile']/..//span")
	WebElement errorMessage;
	
	public ContactUsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnSubmit()
	{
		submitBtn.click();
		
	}
	
	public void displayValue()
	{
		List<WebElement> liElements = driver.findElements(By.xpath("//Select[contains(@class,'ng-invalid')]"));
        for(int i=0; i < liElements.size(); i++)
        { 
             int count = -1 ;
             Select archiveList = new Select(driver.findElement(By.id(liElements.get(i).getAttribute("name"))));
             String selectedValue = archiveList.getFirstSelectedOption().getText();
             List<WebElement> options = archiveList.getOptions();
             for (WebElement option : options) {
            	 count++;
             }
             System.out.println(selectedValue +" "+ "counts" +" "+ count);
             System.out.println(selectedValue  + " " +  "is Required");
        }
        
        List<WebElement> inputElements = driver.findElements(By.xpath("//input[contains(@class,'ng-invalid')]"));
        for(int i=0; i < inputElements.size(); i++)
        { 
        	 System.out.println(inputElements.get(i).getAttribute("name") +" " + "is Required");  
        }
		
	}
	
	public void displayCounts()
	{
		
		List<WebElement> liElements = driver.findElements(By.xpath("//Select[contains(@class,'ng-invalid')]"));
        for(int i=0; i < liElements.size(); i++)
        { 
             int count = -1 ;
             Select archiveList = new Select(driver.findElement(By.id(liElements.get(i).getAttribute("name"))));
             String selectedValue = archiveList.getFirstSelectedOption().getText();
             List<WebElement> options = archiveList.getOptions();
             for (WebElement option : options) {
            	 count++;
             }
             System.out.println(selectedValue +" "+ "counts" +" "+ count);
            
        }
		
	}
	
	public void verifySelectedPRoduct()
	{
			 Select archiveList = new Select(driver.findElement(By.id("need")));
             String selectedValue = archiveList.getFirstSelectedOption().getText();
             if(selectedValue=="-- Select Product--")
             {
            	 System.out.println("Value has not selected for Sub Product");
             }
             else
             {
            	 System.out.println("Value has been selected for Sub Product");
             }
        
		
	}
	
	    public void verifySubProduct()
	    {
		     Select archiveList = new Select(driver.findElement(By.id("need")));
             archiveList.selectByVisibleText("Loans");
             Select productList = new Select(driver.findElement(By.id("product")));
             String selectedValue = productList.getFirstSelectedOption().getText();
             List<WebElement> options = productList.getOptions();
             int count = -1 ;
             for (WebElement option : options) {
            	 count++;
             }
             productList.selectByVisibleText("Auto Loan");
             System.out.println(selectedValue +" "+ "counts" +" "+ count);
      }
	    
	    public void verifyMobileNumer()
	    {
	    	String [] val = {"123456", "12345678" , "1234567"};
	    	for(int i = 0 ; i < val.length ; i++) {
	    	mobileEditField.clear();
	    	mobileEditField.sendKeys(val[i]);
	    	System.out.println(errorMessage.getText());
	    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    }
	    }
}
