package com.actiTime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FWUtils implements IAutoConstant
{
	public static void verifytitlepage(WebDriver wd, String expected)
	{
		
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.titleContains(expected));
		String actual=wd.getTitle();
		Assert.assertEquals(actual, expected);
	    Reporter.log("Expexted title : "+expected , true);
	    Reporter.log("Actual title : "+actual , true);
	    Reporter.log("Test case pass",true);
		
		
	}
	
	public static String read_xl_data( String sheetname , int row , int cell) throws EncryptedDocumentException, FileNotFoundException, IOException
	{   
		String data="";
		try
		{
		   Workbook w = WorkbookFactory.create(new FileInputStream(FILE_PATH));
		   data=w.getSheet(sheetname).getRow(row).getCell(cell).toString();
		}
	catch(Exception e)
		{
		   e.printStackTrace();
		}
		
		return data;
	}
	
	public static int read_rowcount(String sheetname)
	{
		int rowcount=0;
		try
		{
		   Workbook w = WorkbookFactory.create(new FileInputStream(FILE_PATH));
		   rowcount=w.getSheet(sheetname).getLastRowNum();
		}
	catch(Exception e)
		{
		   e.printStackTrace();
		}
		
		return rowcount;
		
	}
	
	public static void take_screenshot(WebDriver wd,String path)
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot)wd;
		
		File src =ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void set_xl_data(String sheetname, int row , int cell,int data)
	{try {
		Workbook w =WorkbookFactory.create(new FileInputStream(RESULT_PATH));
		w.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(data);
		w.write(new FileOutputStream(RESULT_PATH));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	
}
