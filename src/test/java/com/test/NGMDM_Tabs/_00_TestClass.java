package com.test.NGMDM_Tabs;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.BasicUtils.LaunchBrowsers;
import com.test.BasicUtils.Modules;

public class _00_TestClass 
{
	static LaunchBrowsers browsers = new LaunchBrowsers();
	
	@Test
	public void test1() throws Exception
	{
		System.out.println("___________________________________test1");
	}
	
	@Test
	public void test2() throws Exception
	{
		System.out.println("___________________________________test2");
		WebDriver driver = browsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void test3() throws Exception
	{
		System.out.println("___________________________________test3");
		WebDriver driver = browsers.launchBrowser("firefox");
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void test4() throws Exception
	{
		System.out.println("___________________________________test4");
		WebDriver driver = browsers.launchBrowser("phantomjs");
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		driver.quit();
	}

}
