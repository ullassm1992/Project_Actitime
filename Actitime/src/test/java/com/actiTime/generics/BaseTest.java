package com.actiTime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant
{
	public static WebDriver wd;
	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
	}
	public static int fail_count=0;
	public static int pass_count=0; 
	
	
	@BeforeClass
	@Parameters(value={"browser"})
	public  void openbrowser(@Optional ("chrome") String browser)
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
		wd.get(URL);
	}
	
	@AfterMethod
	public void closebrowser(ITestResult res)
	{
		int status = res.getStatus();
		String script_name = res.getName();
		if(status==2)
		{
			fail_count++;
			String path = PHOTO_PATH+script_name+".png";
		  FWUtils.take_screenshot(wd, path);
		}
		else {
			pass_count++;
		}
		wd.close();
		
	}
	
	@AfterSuite
	public void updateresult()
	{
		FWUtils.set_xl_data("result", 1, 0, pass_count);
		FWUtils.set_xl_data("result", 1, 1, fail_count);
		Reporter.log("Pass test scripts :"+pass_count, true);
		Reporter.log("Fail test scripts :"+fail_count, true);
		
	}
	
	
	

}

