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

import test.BasicUtils.BasicUtils;
import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.Modules;
import test.PageObjects.LoginPage;

public class _05_DealQualification
{	
	@Test
	public void qfId1() throws Exception
	{
		/*System.out.println("First Change");
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
		System.out.println("Success : " + dealID);*/
		
		
		
		WebDriver driver = LaunchBrowsers.launchBrowser();
		BasicUtils basic = new BasicUtils(driver);
		new LoginPage(basic)
					._02_1_sfdcLoginDefaultAM_US()
					._01_createNewParentOpportunity()
					._02_1_fillAndSaveNewOpportunitySFDCPageDefault("QualFormId1")
					._01_proceedWithDefaultValuesAndContinue()
					._01_createQuoteFromOpty()
					._00_proceedWithDefaultValues(false)
					._01_quotingSetPreferences()
					._02_addDefaultProduct()
					._12_saveAndContinueFromItemsTab()
					._02_addSpecificNSDiscount(20, 0, 0)
					._03_saveAndContinueFromDiscountsTab()
					._03_finishAndSaveFromRnSTab()
					._01_continueToQualForm()
					._02_fillQualForm_ID_1()
					._09_saveAndContinueFromQualForm()
					._01_submitDealForQualification(false)
					._01_AssertDealSuccessPage()
					;
	}
}
