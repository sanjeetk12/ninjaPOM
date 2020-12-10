package com.qa.ninja.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ninja.base.Basepage;
import com.qa.ninja.utils.Constants;
import com.qa.ninja.utils.ElementUtil;


public class Accountpage extends Basepage {
	public WebDriver driver;
	private ElementUtil elementUtil;
	
	private By getacountheaders=By.cssSelector("div #content h2");
	private By searchtext=By.cssSelector("div#search input[type='text']");
	private By searchclick=By.cssSelector("div#search button[type='button']");
	private By sarchresults=By.cssSelector(".product-layout .product-thumb");
	private By searchitem=By.cssSelector(".product-thumb h4 a");
	public Accountpage(WebDriver driver)
	{
		this.driver=driver;
		 elementUtil = new ElementUtil(this.driver);
	}
	public String getAccountpagetitle() {
		
		//return driver.getTitle();
		return elementUtil.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}
	
	public List<String>  getaccountheaders(){
		List<String> accountlist=new ArrayList <>();
		List <WebElement> headers=elementUtil.getElements(getacountheaders);
		
		for (WebElement e: headers) {
			
			accountlist.add(e.getText());
		
		}
		return accountlist;
	}
	
	public int getaccountheaderscount() {
		
		return elementUtil.getElements(getacountheaders).size();
	}
	
	public boolean dosearch(String productname)
	{
		elementUtil.getElement(searchtext).sendKeys(productname);
		elementUtil.getElement(searchclick).click();
		List<WebElement> resultlist=driver.findElements(searchitem);
		resultlist.size();
		if(resultlist.size()>0)
		{
			return true;
			
		}
		else 
		{
			return false;
		}
	}
	
	public void Productinfopage() {
		
	}
	}


