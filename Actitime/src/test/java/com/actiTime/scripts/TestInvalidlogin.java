package com.actiTime.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actiTime.generics.BaseTest1;
import com.actiTime.generics.FWUtils;
import com.actiTime.pages.LoginPage;

public class TestInvalidlogin extends BaseTest1

{
	@Test
	public void test_invalidlogin() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException 
	{
		
		
		LoginPage lp = new LoginPage(wd);
		String expLogin= FWUtils.read_xl_data("Validlogin", 1, 2);
	    
		Thread.sleep(1000);
	    FWUtils.verifytitlepage(wd, expLogin);
	    
	    int rowcount = FWUtils.read_rowcount("Invalidlogin");
	    
	    for(int i=1 ; i<=rowcount ;i++)
	    {
	    	String un= FWUtils.read_xl_data("Invalidlogin", i, 0);
	    	String pw= FWUtils.read_xl_data("Invalidlogin", i, 1);
	    	lp.user_name(un);
	    	lp.password(pw);
	    	lp.logincheckbox();
	    	lp.login();
	    	Thread.sleep(500);
	    	lp.checkerrormessage();	
	    	
	    }
	    
		
		
	}
	

}

