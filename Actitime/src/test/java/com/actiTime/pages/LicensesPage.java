package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensesPage
{
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]")
	private WebElement productedition;
	
	@FindBy(xpath="//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issuedate;
	
	public LicensesPage(WebDriver wd)
	{
		PageFactory.initElements(wd, this);
	}
	
	public void checkproductedition(String expected)
	{
		String actual = productedition.getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Expected product edition : "+expected , true);
	    Reporter.log("Actual product edition : "+actual , true);
	    Reporter.log("Test case pass",true);
		
	}
	public void checkissuedate(String expected)
	{
		String actual = issuedate.getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Expected issue date : "+expected , true);
	    Reporter.log("Actual issue date : "+actual , true);
	    Reporter.log("Test case pass",true);
	}

}
