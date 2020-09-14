package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	  // declare & lazy initialization
	
		@FindBy(xpath="//input[@id='username']")
		private WebElement untb;
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement pwtb;
		
		@FindBy(xpath="//input[@id='keepLoggedInCheckBox']")
		private WebElement lgcb;
		
		@FindBy(xpath="//div[text()='Login ']")
		private WebElement lgb;
		
		@FindBy(xpath="//span[@class='errormsg']")
		private WebElement errormessg;
		
		 // constructor 
		public LoginPage(WebDriver wd)
		{
			PageFactory.initElements(wd, this); //page factory is responsible for lazy initialization of webelements corresponding page
		}
		
		public void user_name(String un)
		{
			untb.sendKeys(un);
		}
		public void password(String pw)
		{
			pwtb.sendKeys(pw);
		}
		public void login()
		{
			lgb.click();
		}
		
		public void logincheckbox()
		{
			lgcb.click();
		}
		
		public void checkerrormessage()
		{
			Assert.assertTrue(errormessg.isDisplayed());
			Reporter.log(errormessg.getText(), true);
			
			
		}
	    

}
