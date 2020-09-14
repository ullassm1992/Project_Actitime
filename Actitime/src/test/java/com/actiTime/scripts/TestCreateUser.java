package com.actiTime.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.TaskListPage;

public class TestCreateUser extends BaseTest
{
	@Test
	public  void test_createuser() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException 
	{
        
		
		LoginPage lp = new LoginPage(wd);
		lp.user_name(FWUtils.read_xl_data("createuser", 1, 0));
		lp.password(FWUtils.read_xl_data("createuser", 1, 1));
		lp.login();
		Thread.sleep(1000);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(wd);
		
		FWUtils.verifytitlepage(wd, FWUtils.read_xl_data("createuser", 1, 3));
		Thread.sleep(5000);
		
		etp.clickontask();
		
		FWUtils.verifytitlepage(wd, FWUtils.read_xl_data("createuser", 1, 4));
		Thread.sleep(1000);

		TaskListPage tlp=new TaskListPage(wd);
		
		tlp.clickonaddnew();
		tlp.clickonnewcustomer();
		tlp.entercustomer("Mr John");
		tlp.createcustomer();
	//	tlp.checkcustomer("Ullas Surya Mutt");
		etp.clickonlogout();
		
		
		
	
    }

}

		
		