package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage 
{
	@FindBy(xpath="//div[@class='popup_menu_button popup_menu_button_settings']")
	private WebElement setting;
	
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement licenses ;
	
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement task;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logout;
	
	public EnterTimeTrackPage(WebDriver wd)
	{
		PageFactory.initElements(wd, this);
	}
	
	public void clickonsettings()
	{
		setting.click();
	}
	
	public void clickonlicenses()
	{
		licenses.click();
	}
	
	public void clickontask()
	{
		task.click();
	}
		
	public void clickonlogout()
	{
		logout.click();
	}

}
