package test.BasicUtils;

import org.openqa.selenium.WebDriver;

public class AngularJS 
{
	public static void main(String args[]) throws Exception
	{
		LaunchBrowsers lb = new LaunchBrowsers();
		WebDriver driver = lb.launchBrowser("firefox");
		BasicUtils b = new BasicUtils(driver);
		b.justNavigate("https://pwbenchng-stage.cloudapps.cisco.com/pwbench/#/home");
		b.typeText("//*[@id='userInput']", "ujegarak");
		b.typeText("//*[@id='passwordInput']", "496357C!sco00");
		b.click("//*[@id='login-button']");
		b.click("//*[@id='globalContent']/div[2]/div/div[2]/div[2]/div[2]/a");		
	}

}
