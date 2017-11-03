package kdfMigration;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class TestClass 
{
	
	@Test
	public void abcd() throws Exception
	{
		WebDriver driver = LaunchBrowsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		
		basic.justNavigate("https://pwbenchng-stage.cloudapps.cisco.com/pwbench/#/homeDashboard");
		basic.typeText("//*[@id='userInput']", "ujegarak");
		basic.click("//form[@id='login-form']/input[@value='Next']");
		basic.typeText("//*[@id='passwordInput']", "496357C!sco111");
		basic.click("//form[@id='login-form']/input[@id='login-button']");
		basic.click("//*[@id='globalContent']/div[2]/div/div[2]/div[2]/div[2]/a");
		basic.click("//*[@id='globalContent']/header/div[2]/div/div/div/ul/li[3]/a");
		basic.typeText("//div[@class='layout-row']/div/md-input-container/input[@ng-model='itemName']", "CTS-T3-TBLTOP-R=");
		basic.click("//*[@ng-model='nonXaasPriceListId']");
		basic.click("//*[@ng-hide='itemSearchError.length > 0']/md-option[@value='1129']/div");
		basic.click("//*[@id='globalContent']/div[2]/div/div[2]/div/div/div/div/div/div[2]/md-content/div/div/div[1]/div[4]/div[6]/a/span");
		
		//String xpath = "//input[@ng-model='nonXaasSimulationDetails.originalListPriceWithCurrenyCode']";
		
		
		
		ArrayList<String> myData = new ArrayList<String>();
		
		myData.add(basic.getText("//input[@ng-model='itemName']"));
		myData.add(basic.getText("//input[contains(@ng-model,'BasePrice')]"));
		myData.add(basic.getText("//input[contains(@ng-model,'EffectiveUplift')]"));
		myData.add(basic.getText("//input[contains(@ng-model,'ForexRate')]"));
		myData.add(basic.getText("//input[contains(@ng-model,'RoundingRule')]"));
		myData.add(basic.getText("//input[contains(@ng-model,'ListPrice')]"));
		
		
		
		System.out.println("===================================================================================================================");
		
		for(String a : myData)
		{
			System.out.println(a);
		}		
		
		System.out.println("===================================================================================================================");
		
		
		
		
	}
	
	
	




}
