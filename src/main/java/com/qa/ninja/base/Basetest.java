package com.qa.ninja.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.ninja.pages.Accountpage;
import com.qa.ninja.pages.Registrationpage;
import com.qa.ninja.pages.loginpage;

public class Basetest {
	
	public WebDriver driver;
	public loginpage login;
	public Accountpage page;
	public Basepage bpage;
	public Registrationpage  respage;
	public Properties prop;
	
	
	@BeforeTest
	public void launchurl() {
		bpage = new Basepage();
		prop=bpage.init_prop();		
		String browser=prop.getProperty("browser");
		driver=bpage.initi_driver(browser);
		
		login = new loginpage(driver);
		
		driver.get(prop.getProperty("url"));
		
		
	}
}
