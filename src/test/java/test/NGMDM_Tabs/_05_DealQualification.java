package test.NGMDM_Tabs;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.Modules;

public class _05_DealQualification
{	
	@Test
	public void qfId1() throws Exception
	{
		System.out.println("First Change");
		System.out.println("Second Change");
		System.out.println("_______________qfId1");
		WebDriver driver = LaunchBrowsers.launchBrowser("firefox");
		Modules m = new Modules(driver);
		m.sfdcCreateOpportunityWithThaymore("QF_Form_ID_1");
		m.sfdcFillCreateQuotePage(false);
		m.quotingSetPreferences();
		m.addDefaultProduct();
		m.saveAndContinueFromItemsTab();
		m.addSpecificNSDiscount(20, 0, 0);
		m.saveAndContinueFromDiscountsTab();
		m.selectReasonDropdownIfAppears();
		m.saveAndContinueFromRnSTab();
		m.continueToQualForm();
		String dealID = m.getDealIDFromSFDCQualFormUI();
		m.sfdcFillQualForm(1);
		m.saveAndContinueFromQualForm();
		m.submitDealForQualification(false);
		m.sfdcAssert_DT2_SubmissionPage();		
		System.out.println("Success : " + dealID);
	}
}
