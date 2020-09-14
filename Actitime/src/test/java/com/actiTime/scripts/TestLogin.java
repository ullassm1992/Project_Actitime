package com.actiTime.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;

public class TestLogin extends BaseTest
{
	@Test
	public  void test_login() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException 
	{
		
		
		
		
		LoginPage lp = new LoginPage(wd);
		String expLogin= FWUtils.read_xl_data("Validlogin", 1, 2);
		
		Thread.sleep(1000);
		
		FWUtils.verifytitlepage(wd, expLogin);
		
		
		
		String un=FWUtils.read_xl_data("Validlogin", 1, 0);
		String pw=FWUtils.read_xl_data("Validlogin", 1, 1);
		
		System.out.println(un + pw);
		
		lp.user_name(un);
		lp.password(pw);
		lp.logincheckbox();
		lp.login();
		
		EnterTimeTrackPage etp= new EnterTimeTrackPage(wd);
		Thread.sleep(1000);
		String expETTP= FWUtils.read_xl_data("Validlogin", 1, 3);
		
		FWUtils.verifytitlepage(wd, expETTP);
		
		etp.clickonlogout();
		
		
		
		
		
		
		
	}

}
