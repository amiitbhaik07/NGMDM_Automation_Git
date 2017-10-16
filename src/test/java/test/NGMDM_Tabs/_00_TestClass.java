package test.NGMDM_Tabs;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.Modules;

public class _00_TestClass 
{		
	@Test
	public void test1() throws Exception
	{
		System.out.println("___________________________________test1");
		//throw new Exception("fail1");
	}
	
	
	@Test
	public void test2() throws Exception
	{
		System.out.println("___________________________________test2");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		throw new Exception("fail2");
	}
	
	@Test
	public void test3() throws Exception
	{
		System.out.println("___________________________________test3");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		throw new Exception("fail3");
	}
	
	@Test
	public void test4() throws Exception
	{
		System.out.println("___________________________________test4");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in");
		throw new Exception("fail4");
	}
	
	@Test
	public void test5() throws Exception
	{
		System.out.println("___________________________________test5");
		//throw new Exception("Test Failed");
	}
	
	@Test
	public void test6() throws Exception
	{
		System.out.println("___________________________________test6");
		//throw new Exception("Test Failed");
	}
	
	@Test
	public void test7() throws Exception
	{
		System.out.println("___________________________________test4");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.ultimatix.net");
		throw new Exception("fail7");
	}
	
	@Test
	public void test8() throws Exception
	{
		System.out.println("___________________________________test4");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		throw new Exception("fail8");
	}
	
	
}
