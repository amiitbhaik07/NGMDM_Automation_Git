package test.BasicUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasicUtils
{		
	private static Logger logger = Logger.getLogger(BasicUtils.class);
	private WebDriverWait wait, waitForAppearance;
	private WebDriver driver;
	
	public BasicUtils(WebDriver driver)
	{
		try
		{
			PropertyConfigurator.configure("log4j.properties");			
		}
		catch(Exception e)
		{
			System.err.println("### Unable to Configure Log4j System Properly ###");
		}		
		this.driver = driver;
		wait = new WebDriverWait(driver, Constants.defaultTimeoutSeconds);
		waitForAppearance = new WebDriverWait(driver,Constants.ifVisibleTimeoutSeconds);
	}
	
	public void waitForPreloaderDisappear() throws Exception
	{
		logger.trace("Waiting for Pre-loader to Disappear");
		pause(Constants.preLoaderDefaultPauseMillis);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.preLoaderXpath)));
		logger.trace("Waited for Pre-loader to Disappear");
	}
	
	public void waitForPreloaderAppear() throws Exception
	{
		logger.trace("Waiting for Pre-loader to Disappear");
		pause(Constants.preLoaderDefaultPauseMillis);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.preLoaderXpath)));
		logger.trace("Waited for Pre-loader to Disappear");
	}
	
	private void waitForElementPresence(String xpath) throws Exception
	{
		waitForPreloaderDisappear();
		logger.trace("Waiting for Presence of Element Located XPath = " + xpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		logger.trace("Waited for Presence of Element Located XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
	}
	
	private void waitForElementPresence_id(String id) throws Exception
	{
		waitForPreloaderDisappear();
		logger.trace("Waiting for Presence of Element Located ID = " + id);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		logger.trace("Waited for Presence of Element Located ID = " + id);
		pause(Constants.defaultPauseMillis);
	}
	
	private void waitForElementDisappearance(String xpath) throws Exception
	{
		pause(Constants.defaultPauseMillis);
		logger.trace("Waiting for Disappearance of Element Located XPath = " + xpath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		logger.trace("Waited for Disappearance of Element Located XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
	}
	
	private void waitForElementDisappearance_id(String id) throws Exception
	{
		pause(Constants.defaultPauseMillis);
		logger.trace("Waiting for Disappearance of Element Located ID = " + id);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
		logger.trace("Waited for Disappearance of Element Located ID = " + id);
		pause(Constants.defaultPauseMillis);
	}
	
	public void waitForPageToLoad() throws Exception
	{
	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(
	    new Function<WebDriver, Boolean>()
	    {
	        public Boolean apply(WebDriver driver) 
	        {
	            System.out.println("Current Window State : " + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete");
	        }
	    }
	    );
	}
	
	public void waitForPageToLoad1() throws Exception
	{
		waitForPreloaderDisappear();
		Boolean readyStateComplete = false;
        while (!readyStateComplete)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
            String status = (String) executor.executeScript("return document.readyState");
            System.out.println(status);
            readyStateComplete = status.equals("complete");
        }
	}
	
	public long getXOffset() throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageXOffset;");
		return value;
	}
	
	public long getYOffset() throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		return value;
	}
	
	public boolean isWebElementInViewPort(String xpath) throws Exception 
	{
		logger.debug("Checking if ELement is in View Port : XPath = " + xpath);
		waitForElementPresence(xpath);
		WebElement w = driver.findElement(By.xpath(xpath));
	    Dimension weD = w.getSize();	//
	    Point weP = w.getLocation();
	    Dimension d = driver.manage().window().getSize();
	    int x = d.getWidth()+(int)getXOffset()-75; //if(x>150){x=x-100;}
	    int y = d.getHeight()+(int)getYOffset()-75; //if(y>150){y=y-100;}
	    int x2 = weD.getWidth() + weP.getX();
	    int y2 = weD.getHeight() + weP.getY();
	    boolean result = (x2 <= x && y2 <= y);
	    //System.out.println("Window : " + x + " , " + y + " for XPath = " + xpath);
	    logger.debug("Window : " + x + " , " + y + " for XPath = " + xpath + " \t\t\t" + "WebElement : " + x2 + " , " + y2 + " for XPath = " + xpath);
	    //System.out.println("WebElement : " + x2 + " , " + y2 + " for XPath = " + xpath);
	    if(result)
	    {
	    	logger.debug("Element is in View Port : XPath = " + xpath);
	    	return result;
	    }
	    else
	    {
	    	logger.debug("First validation Failed for XPath = " + xpath);
	    	
	    	logger.debug("Element is NOT in View Port : XPath = " + xpath);
	    }
	    return result;
	}
	
	public boolean isWebElementInViewPort_id(String id) throws Exception 
	{
		logger.debug("Checking if ELement is in View Port : XPath = " + id);
		waitForElementPresence_id(id);
		WebElement w = driver.findElement(By.id(id));
	    Dimension weD = w.getSize();	//
	    Point weP = w.getLocation();
	    Dimension d = driver.manage().window().getSize();
	    int x = d.getWidth(); if(x>150){x=x-100;}
	    int y = d.getHeight(); if(y>150){y=y-100;}
	    int x2 = weD.getWidth() + weP.getX();
	    int y2 = weD.getHeight() + weP.getY();
	    boolean result = (x2 <= x && y2 <= y);
	    //System.out.println("Window : " + x + " , " + y + " for XPath = " + xpath);
	    //System.out.println("WebElement : " + x2 + " , " + y2 + " for XPath = " + xpath);
	    logger.debug("Window : " + x + " , " + y + " for XPath = " + id + " \t\t\t" + "WebElement : " + x2 + " , " + y2 + " for XPath = " + id);
	    if(result)
	    {
	    	logger.debug("Element is in View Port : ID = " + id);
	    }
	    else
	    {
	    	logger.debug("Element is NOT in View Port : ID = " + id);
	    }
	    return result;
	}
	
	
	
	
	
	
	
	public boolean isRewrite()
	{	
		try
		{
			waitForPageToLoad1();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String url = getCurrentUrl().trim();
		if(url.contains("#"))
		{
			logger.info("It is a Re-Write Page : " + url);
			return true;
		}
		else
		{
			logger.info("It is a NON - Re-Write Page : " + url);
			return false;
		}
	}
	
	public String getTimeStamp()
	{
		logger.trace("Getting Simple Date Format");
		return new SimpleDateFormat("dd_MMM_HH_mm_ss").format(new Date());
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void refreshPage()
	{
		try
		{
			driver.navigate().refresh();
		}
		catch(Exception e){}
	}
	
	public void quitDriver()
	{
		driver.quit();
	}
	
	public void closeDriver(WebDriver driver)
	{
		driver.close();
	}
	
	public void pressEnterUsingActions() throws Exception
	{
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void pressSpaceUsingActions(String xpath) throws Exception
	{
		new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).sendKeys(Keys.SPACE).build().perform();
	}
	
	public boolean knowIfAppears(String xpath)
	{
		try
		{
			waitForPageToLoad();
			waitForAppearance.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return true;
		}
		catch(Exception e){}
		return false;
	}
	
	public boolean knowIfAppears_id(String id)
	{
		try
		{
			waitForAppearance.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			return true;
		}
		catch(Exception e){}
		return false;
	}
		
	public void waitForElementVisible(String xpath) throws Exception
	{
		logger.trace("Waiting for Element Visible : XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		logger.debug("Successfully Waited for Element Visible : XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
	}
	
	public void waitForElementVisible_id(String id) throws Exception
	{
		logger.trace("Waiting for Element Visible : ID = " + id);
		pause(Constants.defaultPauseMillis);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		pause(Constants.defaultPauseMillis);
		logger.debug("Successfully Waited for Element Visible : ID = " + id);
	}
	
	public void waitForElementClickable(String xpath) throws Exception
	{
		logger.trace("Waiting for Element Clickable : XPath = " + xpath);
		waitForPreloaderDisappear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		logger.debug("Successfully Waited for Element Clickable : XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
	}
	
	public void waitForElementClickable_id(String id) throws Exception
	{
		logger.trace("Waiting for Element Clickable : ID = " + id);
		waitForPreloaderDisappear();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		pause(Constants.defaultPauseMillis);
		logger.debug("Successfully Waited for Element Clickable : ID = " + id);
	}
	
	
	public void scrollIntoView(String xpath) throws Exception
	{
		logger.trace("Waiting for Scroll Into View : XPath = " + xpath);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		waitForElementPresence(xpath);
		//uncommented following line on 1st august 4.15 pm, as for scrolling, it was throwing error if it was not visible on screen
		//waitForElementVisible(xpath);
		WebElement element = driver.findElement(By.xpath(xpath));
		//jse.executeScript("arguments[0].scrollIntoView(true)", element);
		jse.executeScript("Element.prototype.documentOffsetTop = function () {return this.offsetTop + ( this.offsetParent ? this.offsetParent.documentOffsetTop() : 0 );}; var top = arguments[0].documentOffsetTop() - ( window.innerHeight / 2 );window.scrollTo( 0, top );", element);
		logger.debug("Successfully Scrolled Into View : XPath = " + xpath);
	}
	
	public void scrollIntoView_id(String id) throws Exception
	{
		logger.trace("Waiting for Scroll Into View : ID = " + id);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		waitForElementPresence_id(id);
		waitForElementVisible_id(id);
		WebElement element = driver.findElement(By.id(id));
		//jse.executeScript("arguments[0].scrollIntoView(true)", element);
		jse.executeScript("Element.prototype.documentOffsetTop = function () {return this.offsetTop + ( this.offsetParent ? this.offsetParent.documentOffsetTop() : 0 );}; var top = arguments[0].documentOffsetTop() - ( window.innerHeight / 2 );window.scrollTo( 0, top );", element);
		logger.debug("Successfully Scrolled Into View : XPath = " + id);
	}
	
	public void justNavigate(String url)
	{
		try
		{
			logger.trace("Navigating to URL = " + url);
			driver.get(url);
			logger.info("Successfully Navigated to URL = " + url);
		}
		catch(Exception e)
		{
			logger.trace("Navigating to URL = " + url);
			driver.navigate().to(url);
			logger.info("Successfully Navigated to URL = " + url);
		}
	}
	
	public void pause(int time) throws Exception
	{
		logger.debug("Pausing for " + time + " milliseconds");
		Thread.sleep(time);
		logger.debug("Successfully Paused for " + time + " milliseconds");
	}
	
	public void clearBrowserCache()
	{
		logger.trace("Clearing Browser Cache");
		driver.manage().deleteAllCookies();
		logger.debug("Successfully Cleared Browser Cache");
	}
	
	public String getText(String xpath) throws Exception
	{
		logger.trace("Getting Text from XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		pause(Constants.defaultPauseMillis);
		String uiText = "";		
		WebElement w = getWebElement(xpath);
		
		//Fetch text from Angular JS application
		try
		{
			String ngModelAttribute = w.getAttribute("ng-model");
			if(ngModelAttribute!=null && !(ngModelAttribute.trim().equals("")))
			{
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
				String text = javascriptExecutor.executeScript("return angular.element(arguments[0]).scope()."+ngModelAttribute+";", w).toString();
				return text;
			}				
		}
		catch(Exception e){}
		
		uiText = w.getText();
		logger.trace("Got text '"+uiText+"' From UI on XPath = " + xpath);
		try
		{
			if(uiText.equalsIgnoreCase("") || uiText==null)
			{
				logger.trace("As text from UI was '"+uiText+"' so getting text from 'innerHTML' attribute on XPath = " + xpath);
				uiText = driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
				logger.trace("Got text '"+uiText+"' from 'innerHTML' attribute from UI on XPath = " + xpath);
			}
		}
		catch(Exception e){}		
		//Edited 1st august 2017 ; to remove white spaces
		if(uiText != null)
		{
			uiText = uiText.trim();
		}
		logger.debug("Successfully got Text '"+uiText+"' from XPath = " + xpath);
		return uiText;
	}
	
	public String getText_id(String id) throws Exception
	{
		logger.trace("Getting Text from ID = " + id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		pause(Constants.defaultPauseMillis);
		String uiText = "";
		waitForElementVisible_id(id);
		WebElement w = driver.findElement(By.id(id));		
		//Fetch text from Angular JS application
		try
		{
			String ngModelAttribute = w.getAttribute("ng-model");
			if(ngModelAttribute!=null && !(ngModelAttribute.trim().equals("")))
			{
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
				String text = javascriptExecutor.executeScript("return angular.element(arguments[0]).scope()."+ngModelAttribute+";", w).toString();
				return text;
			}				
		}
		catch(Exception e){}
		
		uiText = driver.findElement(By.id(id)).getText();
		logger.trace("Got text '"+uiText+"' From UI on ID = " + id);
		try
		{
			if(uiText.equalsIgnoreCase("") || uiText==null)
			{
				logger.trace("As text from UI was '"+uiText+"' so getting text from 'innerHTML' attribute on ID = " + id);
				uiText = driver.findElement(By.id(id)).getAttribute("innerHTML");
				logger.trace("Got text '"+uiText+"' from 'innerHTML' attribute from UI on ID = " + id);
			}
		}
		catch(Exception e){}
		logger.debug("Successfully got Text '"+uiText+"' from ID = " + id);
		return uiText;
	}
	
	public String getHiddenText(String xpath) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,30);		
		WebElement w = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));		
		String ngModelAttribute = w.getAttribute("ng-model");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		String text = javascriptExecutor.executeScript("return angular.element(arguments[0]).scope()."+ngModelAttribute+";", w).toString();
		return text;	
	}
	
	public void exactMatch1(String xpath, String text) throws Exception
	{
		logger.debug("Verifying Exact Match for '"+text+"' in XPath = " +xpath);
		waitForElementPresence(xpath);
		waitForElementVisible(xpath);
		String uiText = getText(xpath);
		Assert.assertEquals(uiText, text);
		logger.debug("Successfully Verified Exact Match for '"+text+"' in XPath = " +xpath);
	}
	
	public void identicalMatch1(String xpath, String text) throws Exception
	{
		logger.debug("Verifying Identical Match for '"+text+"' in XPath = " +xpath);
		waitForElementPresence(xpath);
		waitForElementVisible(xpath);
		String uiText = getText(xpath);		
		Assert.assertEquals(uiText, text);
		logger.debug("Successfully Identical Exact Match for '"+text+"' in XPath = " +xpath);
	}
	
	public void click(String xpath) throws Exception
	{
		logger.trace("Clicking on Element : XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		waitForElementVisible(xpath);
		waitForElementClickable(xpath);
		for(int i=0; i<Constants.actionTryCount; i++)
		{
			try
			{
				waitForPreloaderDisappear();
				driver.findElement(By.xpath(xpath)).click();
				waitForPreloaderDisappear();
				break;
			}
			catch(Exception e){
				logger.warn("Error in Try number "+(i+1)+" Clicking on Element : XPath = " + xpath);
				switch(i)
				{
					case 0: {scrollIntoView(xpath);break;}
					case 1: {scrollDown(Constants.defaultVerticalScrollPixel);break;}
					case 2: {scrollUp(2*Constants.defaultVerticalScrollPixel);break;}
					case 3: {scrollDown(Constants.defaultVerticalScrollPixel);scrollLeft(Constants.defaultHorizontalScrollPixel);break;}
					case 4: {scrollRight(2*Constants.defaultHorizontalScrollPixel);break;}
					case 5: {scrollLeft(Constants.defaultHorizontalScrollPixel); new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();break;}
					default : throw new Exception(e);
				}
				pause(Constants.actionTryGapMillis);				
			}
		}
		logger.info("Successfully Clicked on Element : XPath = " + xpath);
	}
	
	public void click_id(String id) throws Exception
	{
		logger.trace("Clicking on Element : ID = " + id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		waitForElementVisible_id(id);
		waitForElementClickable_id(id);
		for(int i=0; i<Constants.actionTryCount; i++)
		{
			try
			{
				driver.findElement(By.id(id)).click();
				waitForPreloaderDisappear();
				break;
			}
			catch(WebDriverException e){
				logger.warn("Error in Try number "+(i+1)+" Clicking on Element : XPath = " + id);
				switch(i)
				{
				case 0: {scrollIntoView_id(id);break;}
				case 1: {scrollDown(Constants.defaultVerticalScrollPixel);break;}
				case 2: {scrollUp(2*Constants.defaultVerticalScrollPixel);break;}
				case 3: {scrollDown(Constants.defaultVerticalScrollPixel);scrollLeft(Constants.defaultHorizontalScrollPixel);break;}
				case 4: {scrollRight(2*Constants.defaultHorizontalScrollPixel);break;}
				case 5: {scrollLeft(Constants.defaultHorizontalScrollPixel); new Actions(driver).moveToElement(driver.findElement(By.id(id))).click().build().perform();break;}
				default : throw new Exception(e);
				}
				pause(Constants.actionTryGapMillis);				
			}
		}
		logger.debug("Successfully Clicked on Element : ID = " + id);
	}	
	
	public void scrollLeft(int offsetInPixels) throws Exception
	{
		logger.trace("Waiting for Scroll Left : Offset = " + offsetInPixels);
		waitForPreloaderDisappear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(-"+offsetInPixels+",0)");
		logger.debug("Successfully Scrolled Left by Offset = " + offsetInPixels);
	}
	
	public void scrollRight(int offsetInPixels) throws Exception
	{
		logger.trace("Waiting for Scroll Right : Offset = " + offsetInPixels);
		waitForPreloaderDisappear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll("+offsetInPixels+",0)");
		logger.debug("Successfully Scrolled Right by Offset = " + offsetInPixels);
	}
	
	public void scrollUp(int offsetInPixels) throws Exception
	{
		logger.trace("Waiting for Scroll Up : Offset = " + offsetInPixels);
		waitForPreloaderDisappear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,-"+offsetInPixels+")");
		logger.debug("Successfully Scrolled Up by Offset = " + offsetInPixels);
	}
	
	public void scrollDown(int offsetInPixels) throws Exception
	{
		logger.trace("Waiting for Scroll Down : Offset = " + offsetInPixels);
		waitForPreloaderDisappear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,"+offsetInPixels+")");
		logger.debug("Successfully Scrolled Down by Offset = " + offsetInPixels);
	}
	
	public void switchToChildWindow(String windowName) throws Exception
	{
		logger.debug("Switching to Child Window : " + windowName);
		driver.switchTo().window(windowName);
		logger.debug("Successfully Switched to Child Window : " + windowName);
	}
	
	public void switchBackToParent() throws Exception
	{
		logger.debug("Switching back to Parent Window");
		driver.switchTo().defaultContent();
		logger.debug("Successfully Switched back to Parent Window");
	}
	
	public void switchToIframe(String iFrameXpath) throws Exception
	{
		logger.debug("Switching to IFrame : XPath = " + iFrameXpath);
		driver.switchTo().frame(getWebElement(iFrameXpath));
		logger.debug("Successfully Switched to IFrame : XPath = " + iFrameXpath);
	}
	
	public void switchToIframe_id(String id) throws Exception
	{
		logger.debug("Switching to IFrame : ID = " + id);
		waitForElementPresence_id(id);
		waitForElementVisible_id(id);
		driver.switchTo().frame(driver.findElement(By.id(id)));
		logger.debug("Successfully Switched to IFrame : ID = " + id);
	}
	
	public void takeScreenshot() throws Exception
	{
		logger.trace("Taking Screenshot");
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "\\Screenshots\\"+getTimeStamp()+".jpg"));
		logger.debug("Successfully took Screenshot");
	}
	
	public void ngclick(String xpath) throws Exception
	{
		logger.trace("NG-Clicking on Element : XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		//waitForElementVisible(xpath);
		//waitForElementClickable(xpath);
		
		/*waitForPreloaderDisappear();
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
		waitForPreloaderDisappear();*/
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));

		logger.debug("Successfully NG-Clicked on Element : XPath = " + xpath);
	}
	
	public void ngclick_id(String id) throws Exception
	{
		
	}
	
	public void doubleClick(String xpath) throws Exception
	{
		logger.trace("Performing Double Click on Element XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		waitForElementClickable(xpath);
		try
		{
			logger.trace("Performing Double Click on Element XPath = " + xpath);
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).doubleClick().build().perform();
			waitForPreloaderDisappear();
		}
		catch(Exception e)
		{
			logger.trace("Second Try : Performing Double Click on Element XPath = " + xpath);
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath)), 0, 0).doubleClick().build().perform();
			waitForPreloaderDisappear();
		}
		logger.debug("Successfully performed Double Click on Element XPath = " + xpath);
	}
	
	public void doubleClick_id(String id) throws Exception
	{
		logger.trace("Performing Double Click on Element ID = " + id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		waitForElementClickable_id(id);
		try
		{
			logger.trace("Performing Double Click on Element ID = " + id);
			new Actions(driver).moveToElement(driver.findElement(By.id(id))).doubleClick().build().perform();
			waitForPreloaderDisappear();
		}
		catch(Exception e)
		{
			logger.trace("Second Try : Performing Double Click on Element ID = " + id);
			new Actions(driver).moveToElement(driver.findElement(By.id(id)), 0, 0).doubleClick().build().perform();
			waitForPreloaderDisappear();
		}
		logger.debug("Successfully performed Double Click on Element ID = " + id);
	}
	
	public void typeText(String xpath, String text) throws Exception
	{
		logger.trace("Typing text '"+text+"' on XPath = "+xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		waitForElementClickable(xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		logger.info("Successfully typed text '"+text+"' on XPath = "+xpath);
	}
	
	public void typeText_id(String id, String text) throws Exception
	{
		logger.trace("Typing text '"+text+"' on ID = "+id);
		pause(Constants.defaultPauseMillis);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		waitForElementClickable_id(id);
		driver.findElement(By.id(id)).sendKeys(text);	
		logger.debug("Successfully typed text '"+text+"' on ID = "+id);
	}
	
	public void typeTextAutopopulate(String xpath, String text) throws Exception
	{
		logger.trace("Auto Typing text '"+text+"' on XPath = "+xpath);
		clearText(xpath);		
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		pause(1500);
		String xpath1 = xpath + "/following::a";
		waitForElementClickable(xpath1);
		driver.findElement(By.xpath(xpath1)).click();		
		logger.debug("Successfully typed text '"+text+"' on XPath = "+xpath);
	}
	
	public void clearText(String xpath) throws Exception
	{
		logger.trace("Clear text on XPath = "+xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		waitForElementClickable(xpath);
		driver.findElement(By.xpath(xpath)).click();
		pause(Constants.defaultPauseMillis);
		driver.findElement(By.xpath(xpath)).clear();
		logger.debug("Successfully cleared text on XPath = "+xpath);
	}
	
	public void clearText_id(String id) throws Exception
	{
		logger.trace("Clear text on ID = "+id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		waitForElementClickable_id(id);
		driver.findElement(By.id(id)).click();
		pause(Constants.defaultPauseMillis);
		driver.findElement(By.id(id)).clear();
		logger.debug("Successfully cleared text on ID = "+id);
	}
	
	public void clearUpdateText(String xpath, String text) throws Exception
	{
		logger.trace("Typing text '"+text+"' on XPath = "+xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		logger.trace("Clicking on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).click();
		logger.trace("Successfully Clicked on Element XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
		logger.trace("Clearing text from Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).clear();
		logger.trace("Successfully cleared text from Element XPath = " + xpath);
		pause(Constants.defaultPauseMillis);
		logger.trace("Entering text '"+text+"' on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		logger.debug("Successfully typed text '"+text+"' on XPath = "+xpath);
	}
	
	public void clearUpdateText_id(String id, String text) throws Exception
	{
		logger.trace("Typing text '"+text+"' on ID = "+id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		logger.trace("Clicking on Element ID = " + id);
		driver.findElement(By.id(id)).click();
		logger.trace("Successfully Clicked on Element ID = " + id);
		pause(Constants.defaultPauseMillis);
		logger.trace("Clearing text from Element ID = " + id);
		driver.findElement(By.id(id)).clear();
		logger.trace("Successfully cleared text from Element ID = " + id);
		pause(Constants.defaultPauseMillis);
		logger.trace("Entering text '"+text+"' on Element ID = " + id);
		driver.findElement(By.id(id)).sendKeys(text);		
		logger.debug("Successfully typed text '"+text+"' on ID = "+id);
	}
	
	public void updateText(String xpath, String text) throws Exception
	{
		logger.trace("Updating text '"+text+"' on XPath = "+xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		logger.trace("Clicking on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).click();
		pause(Constants.defaultPauseMillis);
		driver.findElement(By.xpath(xpath)).click();
		pause(Constants.defaultPauseMillis);
		logger.trace("Successfully Clicked on Element XPath = " + xpath);
		logger.trace("Entering text '"+text+"' on Element XPath = " + xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
		logger.debug("Successfully updated text '"+text+"' on XPath = "+xpath);
	}
	
	public void updateText_id(String id, String text) throws Exception
	{
		logger.trace("Updating text '"+text+"' on ID = "+id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		logger.trace("Clicking on Element ID = " + id);
		driver.findElement(By.id(id)).click();
		pause(Constants.defaultPauseMillis);
		driver.findElement(By.id(id)).click();
		pause(Constants.defaultPauseMillis);
		logger.trace("Successfully cleared text from Element ID = " + id);
		logger.trace("Entering text '"+text+"' on Element ID = " + id);
		driver.findElement(By.id(id)).sendKeys(text);		
		logger.debug("Successfully updated text '"+text+"' on ID = "+id);
	}
	
	public void validateContains(String xpath, String text) throws Exception
	{
		logger.trace("Validating text on XPath = "+xpath+" Contains '"+text+"'");
		scrollIntoView(xpath);
		pause(Constants.defaultPauseMillis);
		String uiText = getText(xpath);
		logger.trace("Got text '"+uiText+"' for Element XPath = " + xpath);
		if(uiText.contains(text))
		{
			logger.debug("Successfully Validated text on XPath = "+xpath+" Contains '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Does Not Contain '"+text+"' ; XPath = "+xpath;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validateContains_id(String id, String text) throws Exception
	{
		logger.trace("Validating text on ID = "+id+" Contains '"+text+"'");
		scrollIntoView_id(id);
		pause(Constants.defaultPauseMillis);
		String uiText = getText_id(id);
		logger.trace("Got text '"+uiText+"' for Element ID = " + id);
		if(uiText.contains(text))
		{
			logger.debug("Successfully Validated text on ID = "+id+" Contains '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Does Not Contain '"+text+"' ; ID = "+id;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validateDoesNotContain(String xpath, String text) throws Exception
	{
		logger.trace("Validating text on XPath = "+xpath+" Does Not Contain '"+text+"'");
		scrollIntoView(xpath);
		pause(Constants.defaultPauseMillis);
		String uiText = getText(xpath);
		logger.trace("Got text '"+uiText+"' for Element XPath = " + xpath);
		if(!uiText.contains(text))
		{
			logger.debug("Successfully Validated text on XPath = "+xpath+" Does Not Contain '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Contains '"+text+"' ; XPath = "+xpath;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validateDoesNotContain_id(String id, String text) throws Exception
	{
		logger.trace("Validating text on ID = "+id+" Does Not Contain '"+text+"'");
		scrollIntoView_id(id);
		pause(Constants.defaultPauseMillis);
		String uiText = getText_id(id);
		logger.trace("Got text '"+uiText+"' for Element ID = " + id);
		if(!uiText.contains(text))
		{
			logger.debug("Successfully Validated text on ID = "+id+" Does Not Contain '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' Contains '"+text+"' ; ID = "+id;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validate(String xpath, String text) throws Exception
	{
		logger.trace("Validating text on XPath = "+xpath+" is Equal to '"+text+"'");
		scrollIntoView(xpath);
		pause(Constants.defaultPauseMillis);
		String uiText = getText(xpath);
		logger.trace("Got text '"+uiText+"' for Element XPath = " + xpath);
		if(uiText.equals(text))
		{
			logger.debug("Successfully Validated text on XPath = "+xpath+" is Equal to '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' is Not Equal to '"+text+"' ; XPath = "+xpath;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public void validate_id(String id, String text) throws Exception
	{
		logger.trace("Validating text on ID = "+id+" is Equal to '"+text+"'");
		scrollIntoView_id(id);
		pause(Constants.defaultPauseMillis);
		String uiText = getText_id(id);
		logger.trace("Got text '"+uiText+"' for Element ID = " + id);
		if(uiText.equals(text))
		{
			logger.debug("Successfully Validated text on ID = "+id+" is Equal to '"+text+"'");
		}
		else
		{
			String errorMsg = "Text on UI '"+uiText+"' is Not Equal to '"+text+"' ; ID = "+id;
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
	}
	
	public boolean isElementPresent(String xpath) throws Exception
	{
		logger.trace("Checking whether Element is present : XPath = " + xpath);
		try
		{
			driver.findElement(By.xpath(xpath));
			logger.debug("Element is Present on XPath = " + xpath);
			return true;
		}
		catch(Exception e)
		{
			logger.debug("Element is Not Present on XPath = " + xpath);
			return false;
		}
	}
	
	public boolean isElementPresent_id(String id) throws Exception
	{
		logger.trace("Checking whether Element is present : ID = " + id);		
		try
		{
			driver.findElement(By.id(id));
			logger.debug("Element is Present on ID = " + id);
			return true;
		}
		catch(Exception e)
		{
			logger.debug("Element is Not Present on ID = " + id);
			return false;
		}
	}
	
	public boolean isEnabled(String xpath) throws Exception
	{
		logger.trace("Checking whether Element is Enabled : XPath = " + xpath);
		WebElement w = driver.findElement(By.xpath(xpath));
		if(w.isEnabled())
		{
			logger.debug("Element is Enabled on XPath = " + xpath);
			return true;
		}
		else
		{
			logger.debug("Element is NOT Enabled on XPath = " + xpath);
			return false;
		}
	}
	
	public boolean isEnabled_id(String id) throws Exception
	{
		logger.trace("Checking whether Element is Enabled : ID = " + id);
		WebElement w = driver.findElement(By.id(id));
		if(w.isEnabled())
		{
			logger.debug("Element is Enabled on ID = " + id);
			return true;
		}
		else
		{
			logger.debug("Element is NOT Enabled on ID = " + id);
			return false;
		}
	}
	
	public void validateIfPresent(String xpath) throws Exception
	{
		logger.trace("Validating if Element is Present on XPath = " + xpath);
		waitForElementPresence(xpath);
		Assert.assertTrue(isElementPresent(xpath));
		logger.info("Element is successfully Present on XPath = " + xpath);
	}
	
	public void validateIfPresent_id(String id) throws Exception
	{
		logger.trace("Validating if Element is Present on ID = " + id);
		waitForElementPresence_id(id);
		Assert.assertTrue(isElementPresent_id(id));
		logger.debug("Element is successfully Present on ID = " + id);
	}
	
	public void validateIfNotPresent(String xpath) throws Exception
	{
		logger.trace("Validating if Element is NOT Present for '"+Constants.notPresenceTimeoutMillis+"' milliseconds on XPath = " + xpath);
		Long curr = System.currentTimeMillis();
		while(System.currentTimeMillis() - curr < Constants.notPresenceTimeoutMillis)
		{
			Assert.assertTrue(! isElementPresent(xpath));
			logger.trace("Element is still present XPath = " + xpath);
		}
		logger.debug("Element is successfully NOT Present for '"+Constants.notPresenceTimeoutMillis+"' milliseconds on XPath = " + xpath);
	}
	
	public void validateIfNotPresent_id(String id) throws Exception
	{
		logger.debug("Validating if Element is NOT Present for '"+Constants.notPresenceTimeoutMillis+"' milliseconds on ID = " + id);
		Long curr = System.currentTimeMillis();
		while(System.currentTimeMillis() - curr < Constants.notPresenceTimeoutMillis)
		{
			Assert.assertTrue(! isElementPresent_id(id));
		}
		logger.debug("Element is successfully NOT Present for '"+Constants.notPresenceTimeoutMillis+"' milliseconds on ID = " + id);
	}
	
	public void validateIfEnabled(String xpath) throws Exception
	{
		logger.debug("Validating if Element is Enabled on XPath = " + xpath);
		Assert.assertTrue(isEnabled(xpath));
		logger.debug("Element is Enabled on XPath = " + xpath);		
	}
	
	public void validateIfEnabled_id(String id) throws Exception
	{
		logger.debug("Validating if Element is Enabled on ID = " + id);
		Assert.assertTrue(isEnabled_id(id));
		logger.debug("Element is Enabled on ID = " + id);		
	}
	
	public void validateIfDisabled(String xpath) throws Exception
	{
		logger.debug("Validating if Element is Disabled on XPath = " + xpath);
		waitForElementPresence(xpath);
		Assert.assertFalse(isEnabled(xpath));
		logger.debug("Element is Disabled on XPath = " + xpath);		
	}
	
	public void validateIfDisabled_id(String id) throws Exception
	{
		logger.debug("Validating if Element is Disabled on ID = " + id);
		waitForElementPresence(id);
		Assert.assertFalse(isEnabled_id(id));
		logger.debug("Element is Disabled on ID = " + id);	
	}
	
	public void waitForElementDisappear(String xpath) throws Exception
	{
		logger.debug("Waiting for Element to Disappear on XPath = " + xpath);
		waitForPreloaderDisappear();
		waitForElementDisappearance(xpath);
		logger.debug("Element has successfully Disappeared on XPath = " + xpath);
	}
	
	public void waitForElementDisappear_id(String id) throws Exception
	{
		logger.debug("Waiting for Element to Disappear on ID = " + id);
		waitForPreloaderDisappear();
		waitForElementDisappearance_id(id);
		logger.debug("Element has successfully Disappeared on ID = " + id);
	}
	
	public void waitForElementPresent(String xpath) throws Exception
	{
		logger.debug("Waiting for Element to be Present on XPath = " + xpath);
		waitForPreloaderDisappear();
		waitForElementPresence(xpath);
		logger.debug("Element is successfully present on XPath = " + xpath);
	}
	
	public void waitForElementPresent_id(String id) throws Exception
	{
		logger.debug("Waiting for Element to be Present on ID = " + id);
		waitForPreloaderDisappear();
		waitForElementPresence_id(id);
		logger.debug("Element is successfully present on XPath = " + id);
	}
	
	public void selectOption(String xpath, String visibleText) throws Exception
	{
		logger.debug("Selecting Option value '"+visibleText+"' on XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(visibleText);
		logger.info("Successfully Selected Option value '"+visibleText+"' on XPath = " + xpath);
	}
	
	public void selectOptionWhereValueLike(String xpath, String partOfVisibleText) throws Exception
	{
		logger.debug("Selecting Option where value like '"+partOfVisibleText+"' on XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		//new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(partOfVisibleText);
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		List<WebElement> allOptions = select.getOptions();
		String singleOptionText = "";
		boolean selectedFlag = false;
		for(WebElement singleOption : allOptions)
		{
			singleOptionText = singleOption.getText().trim();
			if(singleOptionText.contains(partOfVisibleText))
			{
				select.selectByValue(singleOptionText);
				selectedFlag = true;
				break;
			}
		}
		if(! selectedFlag)
		{
			throw new Exception("No option present having value like '"+partOfVisibleText+"' in Select Box having XPath = " + xpath);
		}
		logger.debug("Successfully Selected Option value '"+singleOptionText+"' on XPath = " + xpath);
	}
	
	public void selectOption_id(String id, String visibleText) throws Exception
	{
		logger.debug("Selecting Option value '"+visibleText+"' on ID = " + id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		new Select(driver.findElement(By.id(id))).selectByVisibleText(visibleText);
		logger.debug("Successfully Selected Option value '"+visibleText+"' on ID = " + id);
	}
	
	public void mouseOver(String xpath) throws Exception
	{
		logger.debug("Performing Mouse Hover on XPath = " + xpath);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort(xpath))
		{
			scrollIntoView(xpath);
		}
		new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
		logger.debug("Successfully Performed Mouse Hover on XPath = " + xpath);
	}
	
	public void mouseOver_id(String id) throws Exception
	{
		logger.debug("Performing Mouse Hover on ID = " + id);
		waitForPreloaderDisappear();
		if(! isWebElementInViewPort_id(id))
		{
			scrollIntoView_id(id);
		}
		new Actions(driver).moveToElement(driver.findElement(By.id(id))).build().perform();
		logger.debug("Successfully Performed Mouse Hover on ID = " + id);
	}
	
	public String randomNumber(int startIndex, int endIndex) throws Exception
	{
		int random = (int) ( startIndex + (endIndex-startIndex)*Math.random() );
		return random+"";
	}
	
	public boolean ifLogic(String xpath, String text)
	{
		logger.debug("Implementing IF logic for XPath = " + xpath);
		try
		{
			String uiText = new WebDriverWait(driver, Constants.ifLogicTimeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
			logger.debug("Text is : " + uiText);
			if(uiText.equals(text))
			{
				logger.debug("UI text equals text");
				return true;
			}
		}
		catch(Exception e){}
		logger.debug("Returning False");
		return false;
	}
	
	public boolean ifLogic_id(String id, String text)
	{
		try
		{
			String uiText = new WebDriverWait(driver, Constants.ifLogicTimeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(By.id(id))).getText();
			if(uiText.equals(text))
			{
				return true;
			}
		}
		catch(Exception e){}
		return false;
	}
	
	public WebElement getWebElement(String xpath) throws Exception
	{
		waitForElementPresence(xpath);
		waitForElementVisible(xpath);
		return driver.findElement(By.xpath(xpath));
	}
	
	public String getAttribute(String xpath, String attributeName) throws Exception
	{
		WebElement element = getWebElement(xpath);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
}
