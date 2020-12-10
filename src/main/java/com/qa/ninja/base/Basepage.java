package com.qa.ninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	public WebDriver driver ;
	public  Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public WebDriver initi_driver(String browser) {
		
		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			
		}
		
		else if(browser.equals("firefox")) {
			

			WebDriverManager.firefoxdriver().setup();;
			tlDriver.set(new FirefoxDriver());
		}
		
		else {
			
			System.out.println("Enter correct browser"+ browser);
		}
		
		return getDriver();
	}

	
	public Properties  init_prop()
	{
		File file = new File("./src/main/java/com/qa/ninja/config/config.properties");
		FileInputStream fileInput = null;
		try {
			 fileInput =new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 prop = new Properties();
		
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	public String getScreeshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	
}

