package com.actiTime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest1 implements IAutoConstant
{
	public static WebDriver wd;
	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
	}
	
	
	@BeforeClass
	@Parameters({"browser"})
	public  void openbrowser(String browser)
	{
		if (browser.equals("chrome"))
		{
			wd = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			wd =new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			wd=new InternetExplorerDriver();
		}
		
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void openapplication()
	{
		wd.get("http://localhost/login.do");
	}
	
	
	
	
	
	@AfterClass
	public  void closebrowser()
	{
		wd.close();
	}

}
