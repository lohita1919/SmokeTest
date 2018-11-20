package com.project.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class BaseTest
{
	public static WebDriver driver;
	public static String path = "./config.properties";
	public static Properties prop;
	public WebElement e;
	

	public void openBrowser(String browser) throws Exception
	
	{
		if(prop==null)
		{
			prop= new Properties();
			File f = new File (path);
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		}
		
		if(prop.getProperty(browser).equalsIgnoreCase("CHROME"))
		{
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,prop.getProperty("chromedriver_exe"));
			driver= new ChromeDriver();
		}
		else if(prop.getProperty(browser).equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefox_exe"));
			driver=new FirefoxDriver();
		}
		
		else if(prop.getProperty(browser).equalsIgnoreCase("IE"))
		{
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,prop.getProperty("iedriver_exe"));
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		
		String log4jConfpath ="log4j.properties";
		PropertyConfigurator.configure(log4jConfpath);
	}
	
	public void navigate(String url) 
	{
			driver.get(prop.getProperty(url));
	}
	
	public void text(String elelocatorKey, String value)
	{
		//driver.findElement(By.id(prop.getProperty(eleLocator_id))).sendKeys(value);
		getElement(elelocatorKey).sendKeys(value);
	}
	public void clickElement(String elelocatorKey)
	{
		//driver.findElement(By.xpath(prop.getProperty(eleLocator_xpath))).click();
		getElement(elelocatorKey).click();
	}
	
	public WebElement getElement(String element)
	{
		
		
		if(element.endsWith("_id"))
		{
			e=driver.findElement(By.id(prop.getProperty(element)));
		}
		
		else if (element.endsWith("_xpath"))
		{
			e=driver.findElement(By.xpath(prop.getProperty(element)));
		}
		else if(element.endsWith("_name"))
		{
			e=driver.findElement(By.name(prop.getProperty(element)));
		}
		else if(element.endsWith("_className"))
		{
			e=driver.findElement(By.className(prop.getProperty(element)));
		}
		
		return e;
		
	}
	
	
}
