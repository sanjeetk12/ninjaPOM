package com.qa.hubspot.tests;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ninja.base.Basetest;
import com.qa.ninja.pages.Accountpage;
import com.qa.ninja.utils.Constants;
import com.qa.ninja.utils.Excelutil;

import junit.framework.Assert;

public class accountpagetest extends Basetest{
	
	@BeforeClass
	public void pagesetup() {
		
	page=login.dologin(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	
	
	@Test(priority =1)
public void verifypagetitle()
{
	String acctitle=page.getAccountpagetitle();
	System.out.println(acctitle);
	Assert.assertEquals(acctitle, Constants.ACCOUNTS_PAGE_TITLE);


}
	@Test(priority =2)
public void verifyheadercount() {
	int pagecount=page.getaccountheaderscount();
	System.out.println(pagecount);
	Assert.assertEquals(pagecount, Constants.ACCOUNTS_PAGE_COUNT);

}
@Test(priority =1)
public void verifyheaders() {
	List<String> pagehead=page.getaccountheaders();
	System.out.println(pagehead);
	Assert.assertEquals(pagehead, Constants.getAccountSectionsList());
}
@Test(priority =4)

public void verifysearchvalue() {
	Assert.assertTrue(page.dosearch("Imac"));
	
}
	

}

