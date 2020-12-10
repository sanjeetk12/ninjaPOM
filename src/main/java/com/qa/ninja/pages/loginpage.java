package com.qa.ninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ninja.base.Basepage;
import com.qa.ninja.utils.Constants;
import com.qa.ninja.utils.ElementUtil;

public class loginpage extends Basepage{
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public loginpage(WebDriver driver) {
		
		this.driver=driver;
		
		elementUtil = new ElementUtil(this.driver);
	}
	 private By username=By.name("email");
	 private By password=By.name("password");
	 private By loginbutton=By.xpath("//input[@type='submit'] [@value='Login']");
	 private By forgotbutton=By.linkText("Forgotten Password123");
	 private By Registerbutton=By.linkText("Register");
	 private By logout =By.linkText("Logout");
	 private By login =By.linkText("Login");

	 public Boolean IsforgotpasswordExists()
	 {
		 
		//return driver.findElement(forgotbutton).isDisplayed();
		 return elementUtil.getElement(forgotbutton).isDisplayed();
	 }
	 
	 public String getloginpagetitle() {
			
			//return driver.getTitle();
			return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		}
	 public Accountpage dologin(String un,String pwd) {
		 
		 
		 elementUtil.getElement(username).sendKeys(un);
		 elementUtil.getElement(password).sendKeys(pwd);
		 elementUtil.getElement(loginbutton).click();
		 return new Accountpage(driver);
	 }
	 
	 /*   public Accountpage dologin(String username,String password) {
	 
	 
	 elementUtil.getElement(this.username).sendKeys(username);
	 elementUtil.getElement(this.password).sendKeys(password);
	 elementUtil.getElement(loginbutton).click();
	 elementUtil.getElement(logout).click();
	 elementUtil.getElement(login).click();
	return new Accountpage(driver);

			
		
 }*/
	 

	 public Registrationpage doregister() {
		 elementUtil.doClick(Registerbutton);
		 return new Registrationpage(driver);
	 }
	
	
}