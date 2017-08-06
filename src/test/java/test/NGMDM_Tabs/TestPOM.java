package test.NGMDM_Tabs;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.LaunchBrowsers;
import test.PageObjects.LoginPage;

public class TestPOM 
{
	
	@Test
	public void test() throws Exception
	{
		WebDriver driver = LaunchBrowsers.launchBrowser();
		BasicUtils basic = new BasicUtils(driver);
		
		new LoginPage(basic)
					._03_ngmdmLogin("duabhish")
					._02_regularSearchDealID("")
					;
	}
	
	/*@Test
	public void test() throws Exception
	{
		WebDriver driver = LaunchBrowsers.launchBrowser();
		BasicUtils basic = new BasicUtils(driver);
							
		new LoginPage(basic)
					._01_sfdcLogin("thaymore", "cisco123")
					._01_createNewParentOpportunity()
					._02_1_fillAndSaveNewOpportunitySFDCPageDefault("optyName")
					._01_proceedWithDefaultValuesAndContinue()
					._01_createQuoteFromOpty()
					._01_clickRadioButton(false)
					._02_selectDefaultPriceList()
					._03_selectDefaultBuyMethod()
					._04_selectDefaultDealCategory()
					._08_clickCreateQuoteButton()
					._01_quotingSetPreferences()
					._02_addDefaultProduct()
					._03_addDefaultService()
					._11_addTradeInItems()
					._01_addDefaultTradeInItems()
					._03_saveAndContinueFromTradeInItemsPage()
					._01_addDefaultNSDiscount()
					._03_saveAndContinueFromDiscountsTab()
					._03_finishAndSaveFromRnSTab()
					._01_continueToQualForm()
					._02_fillQualForm_ID_1()
					._09_saveAndContinueFromQualForm()
					._01_submitDealForQualification(false)
					._01_AssertDealSuccessPage()
					;
		
		
		new LoginPage(basic)
					._01_sfdcLogin("thaymore", "cisco123")
					._01_createNewParentOpportunity()
					._02_1_fillAndSaveNewOpportunitySFDCPageDefault("test")
					._01_proceedWithDefaultValuesAndContinue()
					._01_createQuoteFromOpty()
					._01_clickRadioButton(false)
					._02_selectDefaultPriceList()
					._03_selectDefaultBuyMethod()
					._04_selectDefaultDealCategory()
					._08_clickCreateQuoteButton()
					._01_quotingSetPreferences()
					._02_addDefaultProduct()
					._03_addDefaultService()
					._11_addTradeInItems()
					._01_addDefaultTradeInItems()
					._03_saveAndContinueFromTradeInItemsPage()
					._01_addDefaultNSDiscount()
					._03_saveAndContinueFromDiscountsTab()
					._03_finishAndSaveFromRnSTab()
					._01_continueToQualForm()
					._07_fillQualForm_ID_11()
					._09_saveAndContinueFromQualForm()
					._01_submitDealForQualification(false)
					._01_AssertDealSuccessPage()
					;
					;
		
	}*/

}
