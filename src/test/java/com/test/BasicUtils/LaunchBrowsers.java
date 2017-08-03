package com.test.BasicUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchBrowsers 
{
	static String url;	
	//public static Logger logger = Logger.getLogger(LaunchBrowsers.class);
	private static Logger logger = Logger.getLogger(LaunchBrowsers.class);
	
	public LaunchBrowsers()
	{
		loadPropertyFile();
	}
	
	public void loadPropertyFile()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try
		{
			input = new FileInputStream("common.properties");
			prop.load(input);
		}
		catch(Exception e){}
		url = prop.getProperty("hubUrl");
	}
	
	public WebDriver launchBrowser(String browserName) throws Exception
	{
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			//System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path",".\\lib\\phantomjs.exe");
			logger.info("Launching Phantomjs Local browser");
			WebDriver driver = new PhantomJSDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("htmlunit"))
		{
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
			logger.info("Launching HTML-Unit Local browser");
			WebDriver driver = new HtmlUnitDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette",".\\lib\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver",".\\lib\\geckodriver.exe");
			logger.info("Launching Firefox Local browser");
			FirefoxProfile fp = new FirefoxProfile(new File("C:\\Users\\abhaik\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\cv1ng57o.default"));
			WebDriver driver = new FirefoxDriver(fp);
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
			logger.info("Launching Chrome Local browser");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("iexplore"))
		{
			//System.setProperty("webdriver.ie.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver",".\\lib\\IEDriverServer.exe");
			logger.info("Launching IE Local browser");
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else
		{
			throw new Exception("Browser Name '"+browserName.trim()+"' not defined in System");
		}
	}
	
	
	public WebDriver launchBrowser(String browserName, String version, Platform platform) throws Exception 
	{
		DesiredCapabilities cap;
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			cap=DesiredCapabilities.phantomjs();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Phantomjs Grid browser");
			WebDriver driver = new RemoteWebDriver(new URL(url),cap);
			driver.manage().window().maximize();
			return driver;
		}
		if(browserName.trim().equalsIgnoreCase("htmlunit"))
		{
			cap=DesiredCapabilities.htmlUnit();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Phantomjs Grid browser");
			WebDriver driver = new RemoteWebDriver(new URL(url),cap);
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Firefox Grid browser");
			WebDriver driver = new RemoteWebDriver(new URL(url),cap);
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Chrome Grid browser");
			WebDriver driver = new RemoteWebDriver(new URL(url),cap);
			driver.manage().window().maximize();
			return driver;
		}
		else if(browserName.trim().equalsIgnoreCase("iexplore"))
		{
			cap=DesiredCapabilities.internetExplorer();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching IE Grid browser");
			WebDriver driver = new RemoteWebDriver(new URL(url),cap);
			driver.manage().window().maximize();
			return driver;
		}
		else
		{
			throw new Exception("Browser Name '"+browserName+"' not defined in System");
		}
	}
	

}
