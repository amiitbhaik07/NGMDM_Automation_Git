package test.BasicUtils;

import org.openqa.selenium.WebDriver;

import com.sun.jna.Platform;

public class TestDownloadOnNode 
{
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = LaunchBrowsers.launchBrowser("firefox", 37, Platform.WINDOWS);
		
		driver.get("https://www.google.co.in");
	}

}
