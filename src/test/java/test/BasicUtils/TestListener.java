package test.BasicUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener 
{
	WebDriver driver = null;
	String filePath = System.getProperty("user.dir")+"\\Screenshots\\";
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	public void onTestSuccess(ITestResult result) 
	{
		try
		{
			if(LaunchBrowsers.quitBrowserOnSuccess)
        	{
				driver = (WebDriver)result.getAttribute("driver");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Closing Browser");
        		driver.quit();
        	}
        }
        catch(Exception e){}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");		
		System.out.println("____________________===========================______________________ "+result.getThrowable());    	
		String fileName = "", methodName = result.getName().toString().trim();    	
    	
    	//Object currentClass = result.getInstance();
        WebDriver driver = null;
        
        try
        {
        	driver = (WebDriver)result.getAttribute("driver");
        	if(driver!=null)
        	{
        		fileName = filePath + (LaunchBrowsers.timeStamp + "\\") + result.getInstanceName().replace("test.", "").replace(".", "\\") + "\\" + methodName + ".jpg";
        		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        		try
        		{
        			FileUtils.copyFile(scrFile, new File(fileName));
        			System.out.println("***Placed screen shot in "+fileName+" ***");
        		} 
        		catch(IOException e) 
        		{
        			e.printStackTrace();
        		}
        	}
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        try
        {
        	driver = (WebDriver)result.getAttribute("driver");
        	if(LaunchBrowsers.quitBrowserOnFailure)
        	{
        		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Closing Browser");
        		driver.quit();
        	}
        	else if(driver instanceof PhantomJSDriver)
        	{
        		driver.quit();
        	}
        }
        catch(Exception e){}
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
