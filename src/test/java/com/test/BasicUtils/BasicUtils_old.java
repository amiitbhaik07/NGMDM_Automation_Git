package com.test.BasicUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasicUtils_old
{	
	private static int defaultTimeoutSeconds = 333;
	private static long notPresenceTimeoutMillis = 30000;
	private static long ifLogicTimeoutSeconds = 30;
	private static int actionTryCount = 5;
	private static int actionTryGapMillis = 5000;	
	private static Logger logger = Logger.getLogger(BasicUtils_old.class);
	private static String preLoaderXpath = "//img[contains(@src,'preloader')]";
	private WebDriverWait wait;
		
	public BasicUtils_old()
	{
		try
		{
			PropertyConfigurator.configure("log4j.properties");			
		}
		catch(Exception e)
		{
			System.err.println("### Unable to Configure Log4j System Properly ###");
		}	
	}
	
	private void defaultPause() throws Exception
	{
		Thread.sleep(250);
	}
	
	private void waitForElementPresence(WebDriver driver, String xpath) throws Exception
	{
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		logger.info("Waiting for Pre-loader to Disappear");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(preLoaderXpath)));
		logger.debug("Waiting for Presence of Element Located XPath = " + xpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		logger.debug("Waited for Presence of Element Located XPath = " + xpath);
		defaultPause();
	}
	
	private void waitForElementPresence_id(WebDriver driver, String id) throws Exception
	{
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		logger.info("Waiting for Pre-loader to Disappear");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(preLoaderXpath)));
		logger.debug("Waiting for Presence of Element Located ID = " + id);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		logger.debug("Waited for Presence of Element Located ID = " + id);
		defaultPause();
	}
	
	private void waitForElementDisappearance(WebDriver driver, String xpath) throws Exception
	{
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		logger.debug("Waiting for Disappearance of Element Located XPath = " + xpath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		logger.debug("Waited for Disappearance of Element Located XPath = " + xpath);
		defaultPause();
	}
	
	private void waitForElementDisappearance_id(WebDriver driver, String id) throws Exception
	{
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		logger.debug("Waiting for Disappearance of Element Located ID = " + id);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
		logger.debug("Waited for Disappearance of Element Located ID = " + id);
		defaultPause();
		
	}
	
	private void findElementWithLabel(WebDriver driver, String xpath)
	{
		driver.findElement(byLabel(""));
	}
	
	public static By byLabel(final String label)
	{
	  return new By() {
	    @Override
	    public List<WebElement> findElements(final SearchContext context)
	    {
	      final String xpath =
	         "//*[@id = //label[text() = \"" + label + "\"]/@for]";
	      return ((FindsByXPath) context).findElementsByXPath(xpath);
	    }
	 
	    @Override
	    public WebElement findElement(final SearchContext context)
	    {
	      String xpath =
	        "id(//label[text() = \"" + label + "\"]/@for)";
	      return ((FindsByXPath) context).findElementByXPath(xpath);
	    }
	 
	    @Override
	    public String toString()
	    {
	      return "ByLabel: " + label;
	    }
	  };
	}
	
	
	
	
	
	
	
	
	
	
	public String getTimeStamp()
	{
		logger.trace("Getting Simple Date Format");
		return new SimpleDateFormat("dd_MMM_HH_mm_ss").format(new Date());
	}
		
	public void waitForElementVisible(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Waiting for Element Visible : XPath = " + xpath);
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		logger.info("Successfully Waited for Element Visible : XPath = " + xpath);
		defaultPause();
	}
	
	public void waitForElementVisible_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Waiting for Element Visible : ID = " + id);
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		defaultPause();
		logger.info("Successfully Waited for Element Visible : ID = " + id);
	}
	
	public void waitForElementClickable(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Waiting for Element Clickable : XPath = " + xpath);
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		logger.info("Successfully Waited for Element Clickable : XPath = " + xpath);
		defaultPause();
	}
	
	public void waitForElementClickable_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Waiting for Element Clickable : ID = " + id);
		wait = new WebDriverWait(driver, defaultTimeoutSeconds);
		defaultPause();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		defaultPause();
		logger.info("Successfully Waited for Element Clickable : ID = " + id);
	}
	
	public void scrollIntoView(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Waiting for Scroll Into View : XPath = " + xpath);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		waitForElementPresence(driver, xpath);
		waitForElementVisible(driver, xpath);
		WebElement element = driver.findElement(By.xpath(xpath));
		//jse.executeScript("arguments[0].scrollIntoView(true)", element);
		jse.executeScript("Element.prototype.documentOffsetTop = function () {return this.offsetTop + ( this.offsetParent ? this.offsetParent.documentOffsetTop() : 0 );}; var top = arguments[0].documentOffsetTop() - ( window.innerHeight / 2 );window.scrollTo( 0, top );", element);
		logger.info("Successfully Scrolled Into View : XPath = " + xpath);
	}
	
	public void scrollIntoView_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Waiting for Scroll Into View : ID = " + id);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		waitForElementPresence_id(driver, id);
		WebElement element = driver.findElement(By.id(id));
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
		logger.info("Successfully Scrolled Into View : ID = " + id);
	}
	
	public void justNavigate(WebDriver driver, String url)
	{
		try
		{
			logger.debug("Navigating to URL = " + url);
			driver.get(url);
			logger.info("Successfully Navigated to URL = " + url);
		}
		catch(Exception e)
		{
			logger.debug("Navigating to URL = " + url);
			driver.navigate().to(url);
			logger.info("Successfully Navigated to URL = " + url);
		}
	}
	
	public void pause(int time) throws Exception
	{
		logger.info("Pausing for " + time + " milliseconds");
		Thread.sleep(time);
		logger.info("Successfully Paused for " + time + " milliseconds");
	}
	
	public void clearBrowserCache(WebDriver driver)
	{
		logger.debug("Clearing Browser Cache");
		driver.manage().deleteAllCookies();
		logger.info("Successfully Cleared Browser Cache");
	}
	
	public String getText(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Getting Text from XPath = " + xpath);
		scrollIntoView(driver, xpath);
		defaultPause();
		String uiText = "";
		uiText = driver.findElement(By.xpath(xpath)).getText();
		logger.debug("Got text '"+uiText+"' From UI on XPath = " + xpath);
		try
		{
			if(uiText.equalsIgnoreCase("") || uiText==null)
			{
				logger.debug("As text from UI was '"+uiText+"' so getting text from 'innerHTML' attribute on XPath = " + xpath);
				uiText = driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
				logger.debug("Got text '"+uiText+"' from 'innerHTML' attribute from UI on XPath = " + xpath);
			}
		}
		catch(Exception e){}
		logger.info("Successfully got Text '"+uiText+"' from XPath = " + xpath);
		return uiText;
	}
	
	public String getText_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Getting Text from ID = " + id);
		scrollIntoView_id(driver, id);
		defaultPause();
		String uiText = "";
		uiText = driver.findElement(By.id(id)).getText();
		logger.debug("Got text '"+uiText+"' From UI on ID = " + id);
		try
		{
			if(uiText.equalsIgnoreCase("") || uiText==null)
			{
				logger.debug("As text from UI was '"+uiText+"' so getting text from 'innerHTML' attribute on ID = " + id);
				uiText = driver.findElement(By.id(id)).getAttribute("innerHTML");
				logger.debug("Got text '"+uiText+"' from 'innerHTML' attribute from UI on ID = " + id);
			}
		}
		catch(Exception e){}
		logger.info("Successfully got Text '"+uiText+"' from ID = " + id);
		return uiText;
	}
	
	public void exactMatch1(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.info("Verifying Exact Match for '"+text+"' in XPath = " +xpath);
		waitForElementPresence(driver, xpath);
		waitForElementVisible(driver, xpath);
		String uiText = getText(driver, xpath);
		Assert.assertEquals(uiText, text);
		logger.info("Successfully Verified Exact Match for '"+text+"' in XPath = " +xpath);
	}
	
	public void identicalMatch1(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.info("Verifying Identical Match for '"+text+"' in XPath = " +xpath);
		waitForElementPresence(driver, xpath);
		waitForElementVisible(driver, xpath);
		String uiText = getText(driver, xpath);		
		Assert.assertEquals(uiText, text);
		logger.info("Successfully Identical Exact Match for '"+text+"' in XPath = " +xpath);
	}
	
	public void click(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Clicking on Element : XPath = " + xpath);
		
		scrollIntoView(driver, xpath);
		waitForElementVisible(driver, xpath);
		waitForElementClickable(driver, xpath);
		//driver.findElement(By.xpath(xpath)).click();
		for(int i=0; i<actionTryCount; i++)
		{
			try
			{
				driver.findElement(By.xpath(xpath)).click();
			}
			catch(WebDriverException e){
				logger.warn("Error in Try number "+(i+1)+" Clicking on Element : XPath = " + xpath);
				pause(actionTryGapMillis);
			}
		}
		logger.info("Successfully Clicked on Element : XPath = " + xpath);
	}
	
	public void click_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Clicking on Element : ID = " + id);
		scrollIntoView_id(driver, id);
		waitForElementVisible_id(driver, id);
		waitForElementClickable_id(driver, id);
		//driver.findElement(By.id(id)).click();
		for(int i=0; i<actionTryCount; i++)
		{
			try
			{
				driver.findElement(By.id(id)).click();
			}
			catch(WebDriverException e){
				logger.warn("Error in Try number "+(i+1)+" Clicking on Element : ID = " + id);
				pause(actionTryGapMillis);
			}
		}
		logger.info("Successfully Clicked on Element : ID = " + id);
	}	
	
	public void scrollLeft(WebDriver driver, String offset) throws Exception
	{
		logger.debug("Waiting for Scroll Left : Offset = " + offset);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(-"+offset+",0)");
		logger.info("Successfully Scrolled Left by Offset = " + offset);
	}
	
	public void scrollRight(WebDriver driver, String offset) throws Exception
	{
		logger.debug("Waiting for Scroll Right : Offset = " + offset);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll("+offset+",0)");
		logger.info("Successfully Scrolled Right by Offset = " + offset);
	}
	
	public void scrollUp(WebDriver driver, String offset) throws Exception
	{
		logger.debug("Waiting for Scroll Up : Offset = " + offset);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,-"+offset+")");
		logger.info("Successfully Scrolled Up by Offset = " + offset);
	}
	
	public void scrollDown(WebDriver driver, String offset) throws Exception
	{
		logger.debug("Waiting for Scroll Down : Offset = " + offset);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,"+offset+")");
		logger.info("Successfully Scrolled Down by Offset = " + offset);
	}
	
	public void switchToChildWindow(WebDriver driver, String windowName) throws Exception
	{
		logger.info("Switching to Child Window : " + windowName);
		driver.switchTo().window(windowName);
		logger.info("Successfully Switched to Child Window : " + windowName);
	}
	
	public void switchBackToParent(WebDriver driver) throws Exception
	{
		logger.info("Switching back to Parent Window");
		driver.switchTo().defaultContent();
		logger.info("Successfully Switched back to Parent Window");
	}
	
	public void switchToIframe(WebDriver driver, String xpath) throws Exception
	{
		logger.info("Switching to IFrame : XPath = " + xpath);
		waitForElementPresence(driver, xpath);
		waitForElementVisible(driver, xpath);
		driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
		logger.info("Successfully Switched to IFrame : XPath = " + xpath);
	}
	
	public void switchToIframe_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Switching to IFrame : ID = " + id);
		waitForElementPresence_id(driver, id);
		waitForElementVisible_id(driver, id);
		driver.switchTo().frame(driver.findElement(By.id(id)));
		logger.info("Successfully Switched to IFrame : ID = " + id);
	}
	
	public void takeScreenshot(WebDriver driver) throws Exception
	{
		logger.debug("Taking Screenshot");
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "\\Screenshots\\"+getTimeStamp()+".jpg"));
		logger.info("Successfully took Screenshot");
	}
	
	public void ngclick(WebDriver driver, String xpath) throws Exception
	{
		
	}
	
	public void ngclick_id(WebDriver driver, String id) throws Exception
	{
		
	}
	
	public void doubleClick(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Performing Double Click on Element XPath = " + xpath);
		scrollIntoView(driver, xpath);
		waitForElementClickable(driver, xpath);
		try
		{
			logger.debug("Performing Double Click on Element XPath = " + xpath);
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).doubleClick().build().perform();
		}
		catch(Exception e)
		{
			logger.debug("Second Try : Performing Double Click on Element XPath = " + xpath);
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath)), 0, 0).doubleClick().build().perform();
		}
		logger.info("Successfully performed Double Click on Element XPath = " + xpath);
	}
	
	public void doubleClick_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Performing Double Click on Element ID = " + id);
		scrollIntoView_id(driver, id);
		waitForElementClickable_id(driver, id);
		try
		{
			logger.debug("Performing Double Click on Element ID = " + id);
			new Actions(driver).moveToElement(driver.findElement(By.id(id))).doubleClick().build().perform();
		}
		catch(Exception e)
		{
			logger.debug("Second Try : Performing Double Click on Element ID = " + id);
			new Actions(driver).moveToElement(driver.findElement(By.id(id)), 0, 0).doubleClick().build().perform();
		}
		logger.info("Successfully performed Double Click on Element ID = " + id);
	}
	
	public void typeText(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.debug("Typing text '"+text+"' on XPath = "+xpath);
		scrollIntoView(driver, xpath);
		waitForElementClickable(driver, xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		logger.info("Successfully typed text '"+text+"' on XPath = "+xpath);
	}
	
	public void typeText_id(WebDriver driver, String id, String text) throws Exception
	{
		logger.debug("Typing text '"+text+"' on ID = "+id);
		scrollIntoView_id(driver, id);
		waitForElementClickable_id(driver, id);
		driver.findElement(By.id(id)).sendKeys(text);		
		logger.info("Successfully typed text '"+text+"' on ID = "+id);
	}
	
	public void typeTextAutopopulate(WebDriver driver, String xpath, String text) throws Exception
	{
		
	}
	
	public void typeTextAutopopulate_id(WebDriver driver, String id, String text) throws Exception
	{
		
	}
	
	public void clearText(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Clear text on XPath = "+xpath);
		scrollIntoView(driver, xpath);
		waitForElementClickable(driver, xpath);
		driver.findElement(By.xpath(xpath)).click();
		defaultPause();
		driver.findElement(By.xpath(xpath)).clear();
		logger.info("Successfully cleared text on XPath = "+xpath);
	}
	
	public void clearText_id(WebDriver driver, String id) throws Exception
	{
		
	}
	
	public void clearUpdateText(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.debug("Typing text '"+text+"' on XPath = "+xpath);
		scrollIntoView(driver, xpath);
		logger.debug("Clicking on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).click();
		logger.debug("Successfully Clicked on Element XPath = " + xpath);
		defaultPause();
		logger.debug("Clearing text from Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).clear();
		logger.debug("Successfully cleared text from Element XPath = " + xpath);
		defaultPause();
		logger.debug("Entering text '"+text+"' on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		logger.info("Successfully typed text '"+text+"' on XPath = "+xpath);
	}
	
	public void clearUpdateText_id(WebDriver driver, String id, String text) throws Exception
	{
		logger.debug("Typing text '"+text+"' on ID = "+id);
		scrollIntoView_id(driver, id);
		logger.debug("Clicking on Element ID = " + id);
		driver.findElement(By.id(id)).click();
		logger.debug("Successfully Clicked on Element ID = " + id);
		defaultPause();
		logger.debug("Clearing text from Element ID = " + id);
		driver.findElement(By.id(id)).clear();
		logger.debug("Successfully cleared text from Element ID = " + id);
		defaultPause();
		logger.debug("Entering text '"+text+"' on Element ID = " + id);
		driver.findElement(By.id(id)).sendKeys(text);		
		logger.info("Successfully typed text '"+text+"' on ID = "+id);
	}
	
	public void updateText(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.debug("Updating text '"+text+"' on XPath = "+xpath);
		scrollIntoView(driver, xpath);
		logger.debug("Clicking on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).click();
		defaultPause();
		driver.findElement(By.xpath(xpath)).click();
		defaultPause();
		logger.debug("Successfully Clicked on Element XPath = " + xpath);
		logger.debug("Entering text '"+text+"' on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		logger.info("Successfully updated text '"+text+"' on XPath = "+xpath);
	}
	
	public void updateText_id(WebDriver driver, String id, String text) throws Exception
	{
		logger.debug("Updating text '"+text+"' on ID = "+id);
		scrollIntoView_id(driver, id);
		logger.debug("Clicking on Element ID = " + id);
		driver.findElement(By.id(id)).click();
		defaultPause();
		driver.findElement(By.id(id)).click();
		defaultPause();
		logger.debug("Successfully cleared text from Element ID = " + id);
		logger.debug("Entering text '"+text+"' on Element ID = " + id);
		driver.findElement(By.id(id)).sendKeys(text);		
		logger.info("Successfully updated text '"+text+"' on ID = "+id);
	}
	
	public void validateContains(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.debug("Validating text on XPath = "+xpath+" Contains '"+text+"'");
		scrollIntoView(driver, xpath);
		defaultPause();
		String uiText = getText(driver, xpath);
		logger.debug("Got text '"+uiText+"' for Element XPath = " + xpath);
		if(uiText.contains(text))
		{
			logger.info("Successfully Validated text on XPath = "+xpath+" Contains '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Does Not Contain '"+text+"' ; XPath = "+xpath;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validateContains_id(WebDriver driver, String id, String text) throws Exception
	{
		logger.debug("Validating text on ID = "+id+" Contains '"+text+"'");
		scrollIntoView_id(driver, id);
		defaultPause();
		String uiText = getText_id(driver, id);
		logger.debug("Got text '"+uiText+"' for Element ID = " + id);
		if(uiText.contains(text))
		{
			logger.info("Successfully Validated text on ID = "+id+" Contains '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Does Not Contain '"+text+"' ; ID = "+id;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validateDoesNotContain(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.debug("Validating text on XPath = "+xpath+" Does Not Contain '"+text+"'");
		scrollIntoView(driver, xpath);
		defaultPause();
		String uiText = getText(driver, xpath);
		logger.debug("Got text '"+uiText+"' for Element XPath = " + xpath);
		if(!uiText.contains(text))
		{
			logger.info("Successfully Validated text on XPath = "+xpath+" Does Not Contain '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Contains '"+text+"' ; XPath = "+xpath;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validateDoesNotContain_id(WebDriver driver, String id, String text) throws Exception
	{
		logger.debug("Validating text on ID = "+id+" Does Not Contain '"+text+"'");
		scrollIntoView_id(driver, id);
		defaultPause();
		String uiText = getText_id(driver, id);
		logger.debug("Got text '"+uiText+"' for Element ID = " + id);
		if(!uiText.contains(text))
		{
			logger.info("Successfully Validated text on ID = "+id+" Does Not Contain '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Contains '"+text+"' ; ID = "+id;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validate(WebDriver driver, String xpath, String text) throws Exception
	{
		logger.debug("Validating text on XPath = "+xpath+" is Equal to '"+text+"'");
		scrollIntoView(driver, xpath);
		defaultPause();
		String uiText = getText(driver, xpath);
		logger.debug("Got text '"+uiText+"' for Element XPath = " + xpath);
		if(uiText.equals(text))
		{
			logger.info("Successfully Validated text on XPath = "+xpath+" is Equal to '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' is Not Equal to '"+text+"' ; XPath = "+xpath;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validate_id(WebDriver driver, String id, String text) throws Exception
	{
		logger.debug("Validating text on ID = "+id+" is Equal to '"+text+"'");
		scrollIntoView_id(driver, id);
		defaultPause();
		String uiText = getText_id(driver, id);
		logger.debug("Got text '"+uiText+"' for Element ID = " + id);
		if(uiText.equals(text))
		{
			logger.info("Successfully Validated text on ID = "+id+" is Equal to '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' is Not Equal to '"+text+"' ; ID = "+id;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public boolean isElementPresent(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Checking whether Element is present : XPath = " + xpath);
		try
		{
			driver.findElement(By.xpath(xpath));
			logger.info("Element is Present on XPath = " + xpath);
			return true;
		}
		catch(Exception e)
		{
			logger.info("Element is Not Present on XPath = " + xpath);
			return false;
		}
	}
	
	public boolean isElementPresent_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Checking whether Element is present : ID = " + id);
		try
		{
			driver.findElement(By.id(id));
			logger.info("Element is Present on ID = " + id);
			return true;
		}
		catch(Exception e)
		{
			logger.info("Element is Not Present on ID = " + id);
			return false;
		}
	}
	
	public boolean isEnabled(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Checking whether Element is Enabled : XPath = " + xpath);
		WebElement w = driver.findElement(By.xpath(xpath));
		if(w.isEnabled())
		{
			logger.info("Element is Enabled on XPath = " + xpath);
			return true;
		}
		else
		{
			logger.info("Element is NOT Enabled on XPath = " + xpath);
			return false;
		}
	}
	
	public boolean isEnabled_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Checking whether Element is Enabled : ID = " + id);
		WebElement w = driver.findElement(By.id(id));
		if(w.isEnabled())
		{
			logger.info("Element is Enabled on ID = " + id);
			return true;
		}
		else
		{
			logger.info("Element is NOT Enabled on ID = " + id);
			return false;
		}
	}
	
	public void validateIfPresent(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Validating if Element is Present on XPath = " + xpath);
		waitForElementPresence(driver, xpath);
		Assert.assertTrue(isElementPresent(driver, xpath));
		logger.info("Element is successfully Present on XPath = " + xpath);
	}
	
	public void validateIfPresent_id(WebDriver driver, String id) throws Exception
	{
		logger.debug("Validating if Element is Present on ID = " + id);
		waitForElementPresence_id(driver, id);
		Assert.assertTrue(isElementPresent_id(driver, id));
		logger.info("Element is successfully Present on ID = " + id);
	}
	
	public void validateIfNotPresent(WebDriver driver, String xpath) throws Exception
	{
		logger.debug("Validating if Element is NOT Present for '"+notPresenceTimeoutMillis+"' milliseconds on XPath = " + xpath);
		Long curr = System.currentTimeMillis();
		while(System.currentTimeMillis() - curr < notPresenceTimeoutMillis)
		{
			Assert.assertTrue(! isElementPresent(driver, xpath));
			logger.debug("Element is still present XPath = " + xpath);
		}
		logger.info("Element is successfully NOT Present for '"+notPresenceTimeoutMillis+"' milliseconds on XPath = " + xpath);
	}
	
	public void validateIfNotPresent_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Validating if Element is NOT Present for '"+notPresenceTimeoutMillis+"' milliseconds on ID = " + id);
		Long curr = System.currentTimeMillis();
		while(System.currentTimeMillis() - curr < notPresenceTimeoutMillis)
		{
			Assert.assertTrue(! isElementPresent_id(driver, id));
		}
		logger.info("Element is successfully NOT Present for '"+notPresenceTimeoutMillis+"' milliseconds on ID = " + id);
	}
	
	public void validateIfEnabled(WebDriver driver, String xpath) throws Exception
	{
		logger.info("Validating if Element is Enabled on XPath = " + xpath);
		Assert.assertTrue(isEnabled(driver, xpath));
		logger.info("Element is Enabled on XPath = " + xpath);		
	}
	
	public void validateIfEnabled_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Validating if Element is Enabled on ID = " + id);
		Assert.assertTrue(isEnabled_id(driver, id));
		logger.info("Element is Enabled on ID = " + id);		
	}
	
	public void validateIfDisabled(WebDriver driver, String xpath) throws Exception
	{
		logger.info("Validating if Element is Disabled on XPath = " + xpath);
		waitForElementPresence(driver, xpath);
		Assert.assertFalse(isEnabled(driver, xpath));
		logger.info("Element is Disabled on XPath = " + xpath);		
	}
	
	public void validateIfDisabled_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Validating if Element is Disabled on ID = " + id);
		waitForElementPresence(driver, id);
		Assert.assertFalse(isEnabled_id(driver, id));
		logger.info("Element is Disabled on ID = " + id);	
	}
	
	public void waitForElementDisappear(WebDriver driver, String xpath) throws Exception
	{
		logger.info("Waiting for Element to Disappear on XPath = " + xpath);
		waitForElementDisappearance(driver, xpath);
		logger.info("Element has successfully Disappeared on XPath = " + xpath);
	}
	
	public void waitForElementDisappear_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Waiting for Element to Disappear on ID = " + id);
		waitForElementDisappearance_id(driver, id);
		logger.info("Element has successfully Disappeared on ID = " + id);
	}
	
	public void waitForElementPresent(WebDriver driver, String xpath) throws Exception
	{
		logger.info("Waiting for Element to be Present on XPath = " + xpath);
		waitForElementPresence(driver, xpath);
		logger.info("Element is successfully present on XPath = " + xpath);
	}
	
	public void waitForElementPresent_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Waiting for Element to be Present on ID = " + id);
		waitForElementPresence_id(driver, id);
		logger.info("Element is successfully present on XPath = " + id);
	}
	
	public void selectOption(WebDriver driver, String xpath, String visibleText) throws Exception
	{
		logger.info("Selecting Option value '"+visibleText+"' on XPath = " + xpath);
		scrollIntoView(driver, xpath);
		new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(visibleText);
		logger.info("Successfully Selected Option value '"+visibleText+"' on XPath = " + xpath);
	}
	
	public void selectOption_id(WebDriver driver, String id, String visibleText) throws Exception
	{
		logger.info("Selecting Option value '"+visibleText+"' on ID = " + id);
		scrollIntoView_id(driver, id);
		new Select(driver.findElement(By.id(id))).selectByVisibleText(visibleText);
		logger.info("Successfully Selected Option value '"+visibleText+"' on ID = " + id);
	}
	
	public void mouseOver(WebDriver driver, String xpath) throws Exception
	{
		logger.info("Performing Mouse Hover on XPath = " + xpath);
		scrollIntoView(driver, xpath);
		new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
		logger.info("Successfully Performed Mouse Hover on XPath = " + xpath);
	}
	
	public void mouseOver_id(WebDriver driver, String id) throws Exception
	{
		logger.info("Performing Mouse Hover on ID = " + id);
		scrollIntoView_id(driver, id);
		new Actions(driver).moveToElement(driver.findElement(By.id(id))).build().perform();
		logger.info("Successfully Performed Mouse Hover on ID = " + id);
	}
	
	public String randomNumber(int startIndex, int endIndex) throws Exception
	{
		int random = (int) ( startIndex + (endIndex-startIndex)*Math.random() );
		return random+"";
	}
	
	public boolean ifLogic(WebDriver driver, String xpath, String text)
	{
		logger.info("Implementing IF logic for XPath = " + xpath);
		try
		{
			String uiText = new WebDriverWait(driver, ifLogicTimeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
			logger.info("Text is : " + uiText);
			if(uiText.equals(text))
			{
				logger.info("UI text equals text");
				return true;
			}
		}
		catch(Exception e){}
		logger.info("Returning False");
		return false;
	}
	
	public boolean ifLogic_id(WebDriver driver, String id, String text)
	{
		try
		{
			String uiText = new WebDriverWait(driver, ifLogicTimeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(By.id(id))).getText();
			if(uiText.equals(text))
			{
				return true;
			}
		}
		catch(Exception e){}
		return false;
	}
}
