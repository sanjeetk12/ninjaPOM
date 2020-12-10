package com.qa.ninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ninja.base.Basepage;
import com.qa.ninja.utils.Constants;
import com.qa.ninja.utils.ElementUtil;


public class Registrationpage extends Basepage {
private WebDriver driver;
private ElementUtil elementUtil;
private By firstname= By.xpath("//input [@name='firstname']");
private By lastname= By.xpath("//input [@name='lastname']");
private By email=By.xpath("//input [@name='email']");
private By Telephone=By.xpath("//input [@name='telephone']");
private By password=By.xpath("//input [@name='password']");
private By confirmpassword=By.xpath("//input [@name='confirm']");
private By Subcribe=By.xpath("//input [@type='radio' and @value='1' and @name='newsletter']");
private By agreecheckbox=By.xpath("//input [@name='agree']");
private By continuebtn=By.xpath("//input [@value='Continue']");
private By accountSuccessMessg = By.cssSelector("#content h1");
private By logoutLink = By.linkText("Logout");
private By registerLink = By.linkText("Register");

public Registrationpage(WebDriver driver) {
this.driver=driver;
elementUtil = new ElementUtil(this.driver);
	}

public  boolean accountregistration(String firstname,String lastname,String email,String Telephone,String password) {
	
	elementUtil.doSendKeys(this.firstname, firstname);
	elementUtil.doSendKeys(this.lastname, lastname);
	elementUtil.doSendKeys(this.email, email);
	elementUtil.doSendKeys(this.Telephone, Telephone);
	elementUtil.doSendKeys(this.password, password);
	elementUtil.doSendKeys(this.confirmpassword,password );
	elementUtil.doClick(Subcribe);
	elementUtil.doClick(agreecheckbox);
	elementUtil.doClick(continuebtn);

	String text = elementUtil.doGetText(accountSuccessMessg);
	if(text.contains(Constants.ACCOUNT_SUCCESS_MESSG)) {
		elementUtil.doClick(logoutLink);
		elementUtil.doClick(registerLink);

		return true;
	}
	return false;
}


}
