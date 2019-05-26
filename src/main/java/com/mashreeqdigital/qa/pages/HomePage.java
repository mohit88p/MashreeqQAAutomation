/**
 * 
 */
package com.mashreeqdigital.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


/**
 * @author mohitpuri
 * This class will land us to home page pf Mashreeq in the application
 */
public class HomePage extends com.mashreeqdigital.qa.base.TestBase {
	
	
	@FindBy(xpath = "//div[@class='leftLinks']")
	WebElement navigationBar;
	
	@FindBy(xpath="//span[@class='glyphicon-cu glyphicon glyphicon-earphone']")
	WebElement contactPage;
	
	@FindBy(xpath="//h3[ contains(text(),'Mashreq News')]")
	WebElement newsFeed;
	
	@FindBy(xpath="(//a[@class='masterTooltip'])[3]")
	WebElement contactUsLinks;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean NavigationBarDisplayed()
	{
		return navigationBar.isDisplayed();
		
	}
	
	public boolean verifyNewsFeed()
	{
		return newsFeed.isDisplayed();
	}
	
	public void clickContactUs()
	{
		contactUsLinks.click();
	}
	
	
	
	public boolean displayValue()
	{
		List<WebElement> liElements = driver.findElements(By.xpath("//div[@class='leftLinks']//li"));
        System.out.println(liElements);

        for(int i=1; i < liElements.size(); i++)
        {
        	 
            if(verifyNavigationBarLinks(liElements.get(i).getText())) {
            	System.out.println("Match"+ " " + liElements.get(i).getText());
            }
            else
            {
            	System.out.println("Not Match" + " " + liElements.get(i).getText());
            	return false;
            }

        }
        return true;
		
	}
	
	public Boolean verifyNavigationBarLinks(String value)
	{
		String[] expected= {"Corporate","Business","International","Private Banking","Al Islami","Gold","Mashreq Securities","Mashreq Capital","Mashreq Global Services"};
		//Lists
		boolean contains = Arrays.asList(expected).contains(value);;
		return contains;
	}
	
	

}
