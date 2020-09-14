package com.actiTime.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LicensesPage;
import com.actiTime.pages.LoginPage;

public class TestProductEdition extends BaseTest
{
	@Test
	public  void test_productedition()throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		String page = "Productedition";
		
		LoginPage lp = new LoginPage(wd);
		Thread.sleep(1000);
		
		String un=FWUtils.read_xl_data(page, 1, 0);
		String pw=FWUtils.read_xl_data(page, 1, 1);
		System.out.println(un + " " + pw);
		lp.user_name(un);
		lp.password(pw);
		lp.login();
		
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(wd);
		
        String expETTP= FWUtils.read_xl_data(page, 1, 3);
        
        Thread.sleep(1000);
		
		FWUtils.verifytitlepage(wd, expETTP);
		
		etp.clickonsettings();
		etp.clickonlicenses();
		
		
		LicensesPage lcp = new LicensesPage(wd);
		
		String expLICP= FWUtils.read_xl_data(page, 1, 4);
		Thread.sleep(1000);
		FWUtils.verifytitlepage(wd,expLICP);
		
		String expEdition= FWUtils.read_xl_data(page, 1, 5);
		
		
		lcp.checkproductedition(expEdition);
		
		etp.clickonlogout();
		
		
	
		
		
		
		
		
	}

}
