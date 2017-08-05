package test.BasicUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.Reporter;

public class LaunchBrowsers 
{
	static String hubUrl;
	static String defaultBrowserName;
	static boolean runOnGrid=false;
	static boolean quitBrowserOnFailure = true;
	static boolean quitBrowserOnSuccess = true;
	static Properties prop = new Properties();	
	private static Logger logger = Logger.getLogger(LaunchBrowsers.class);
	static InputStream input;
	public static final String timeStamp = new SimpleDateFormat("dd_MMM---hh_mm_ss_a").format(new Date());
	
	public static void loadPropertyFile()
	{
		try
		{
			input = new FileInputStream("common.properties");
			prop.load(input);
		}
		catch(Exception e){}
		
		hubUrl = prop.getProperty("hubUrl");
		defaultBrowserName = prop.getProperty("browserName");
		
		try
		{
			if(prop.getProperty("runOnGrid")!=null)
			{
				if(prop.getProperty("runOnGrid").trim().equalsIgnoreCase("true") && hubUrl!=null)
				{
					if(! hubUrl.trim().equalsIgnoreCase(""))
					{
						runOnGrid = true;
					}
				}
			}
		}
		catch(Exception e){
			runOnGrid = false;
		}
		
		try
		{
			if(prop.getProperty("quitBrowserOnFailure")!=null)
			{
				if(prop.getProperty("quitBrowserOnFailure").trim().equalsIgnoreCase("false"))
				{
					quitBrowserOnFailure = false;
				}
			}
			
			if(prop.getProperty("quitBrowserOnSuccess")!=null)
			{
				if(prop.getProperty("quitBrowserOnSuccess").trim().equalsIgnoreCase("false"))
				{
					quitBrowserOnSuccess = false;
				}
			}
		}
		catch(Exception e){}
		
		if(runOnGrid)
		{
			logger.info("Browser Configuration Detected : Grid Execution with '"+defaultBrowserName+"' on HUB : " + hubUrl);
		}
		else
		{
			logger.info("Browser Configuration Detected : Local Execution with '"+defaultBrowserName+"'");
		}
		
		System.out.println("Property File Loaded Successfully");
	}
	
	public static WebDriver launchBrowser() throws Exception
	{
		loadPropertyFile();
		System.out.println("===============Launching Browser : " + defaultBrowserName);
		if(runOnGrid)
		{
			//Grid Execution
			return launchBrowser(defaultBrowserName, "50", Platform.WINDOWS);
		}
		else
		{
			//Local Execution
			return launchBrowser(defaultBrowserName);
		}
	}
	
	public static WebDriver launchBrowser(String browserName) throws Exception
	{
		loadPropertyFile();
		WebDriver driver = null;
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			//System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path",".\\lib\\phantomjs.exe");
			logger.info("Launching Phantomjs Local browser");
			driver = new PhantomJSDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("htmlunit"))
		{
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
			logger.info("Launching HTML-Unit Local browser");
			driver = new HtmlUnitDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			logger.info("Launching Firefox Local browser");
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette",".\\lib\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver",".\\lib\\geckodriver.exe");
			FirefoxProfile fp = new FirefoxProfile(new File("C:\\Users\\abhaik\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\cv1ng57o.default"));
			driver = new FirefoxDriver(fp);
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
			logger.info("Launching Chrome Local browser");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("iexplore"))
		{
			//System.setProperty("webdriver.ie.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver",".\\lib\\IEDriverServer.exe");
			logger.info("Launching IE Local browser");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else
		{
			throw new Exception("Browser Name '"+browserName.trim()+"' not defined in System");
		}
		
		Reporter.getCurrentTestResult().setAttribute("driver", driver);
		return driver;
	}
	
	
	public static WebDriver launchBrowser(String browserName, String version, Platform platform) throws Exception 
	{
		loadPropertyFile();
		DesiredCapabilities cap;
		WebDriver driver = null;
		
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			cap=DesiredCapabilities.phantomjs();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Phantomjs Grid browser");
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("htmlunit"))
		{
			cap=DesiredCapabilities.htmlUnit();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Phantomjs Grid browser");
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Firefox Grid browser");
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			driver.manage().window().maximize();
			Reporter.getCurrentTestResult().setAttribute("driver", driver);
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching Chrome Grid browser");
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			driver.manage().window().maximize();
		}
		else if(browserName.trim().equalsIgnoreCase("iexplore"))
		{
			cap=DesiredCapabilities.internetExplorer();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			logger.info("Launching IE Grid browser");
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			driver.manage().window().maximize();
		}
		else
		{
			throw new Exception("Browser Name '"+browserName+"' not defined in System");
		}
		
		Reporter.getCurrentTestResult().setAttribute("driver", driver);
		return driver;
	}
	

}
