package com.qa.hubspot.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ninja.base.Basetest;
import com.qa.ninja.pages.Registrationpage;
import com.qa.ninja.pages.loginpage;
import com.qa.ninja.utils.Constants;
import com.qa.ninja.utils.Excelutil;

public class Registrationtest extends Basetest{

	
	@BeforeClass
	public void regpagesetup() {
		
		respage=login.doregister();
		
		
	}
	@DataProvider
	public Object[][] doregister() {
		Object data [][]=Excelutil.gettestdata(Constants.SHEET_NAME);
		return data;
		
		
	}
	@Test(dataProvider="doregister")
	public void accountreg(String firstname,String lastname,String email,String Telephone,String password) {
		
		respage.accountregistration(firstname, lastname, email, Telephone, password);
	}
	
	
}
