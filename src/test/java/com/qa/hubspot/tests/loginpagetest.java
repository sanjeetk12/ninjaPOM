package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ninja.base.Basetest;
import com.qa.ninja.utils.Constants;
import com.qa.ninja.utils.Excelutil;

public class loginpagetest extends Basetest{ 

	@Test (priority =1)
	public void gettitle()
	{
		
		String actualtext=login.getloginpagetitle();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority =2 )
	public void verifysignuptext()
	{
		Assert.assertTrue(login.IsforgotpasswordExists());
		
	}
	
	@Test (priority =3)
	public void logintest() {
	
	login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
/*	@DataProvider
	public Object[][] dologin() {
		Object data [][]=Excelutil.gettestdata("Sheet2");
		return data;
		
	}
	
	@Test( dataProvider="dologin")
	public void logintest(String username,String password) {
	
	login.dologin(username, password);
	
}*/
}