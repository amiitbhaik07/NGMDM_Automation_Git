package test.BasicUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Modules 
{	
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	private WebDriver driver;
	
	
	public Modules(WebDriver driver)
	{
		basic = new BasicUtils(driver);
		this.driver = driver;
	}
	
	public void quitDriver()
	{
		basic.quitDriver(driver);
	}
	
	public void closeDriver()
	{
		basic.closeDriver(driver);
	}
	
	public boolean isRewrite()
	{
		WebDriverWait wait = new WebDriverWait(driver,150);		
		try
		{
			basic.waitForPageToLoad1();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String url = basic.getCurrentUrl().trim();
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
	
	public void sfdcClickLoginCancelButtonIfAppears() throws Exception
	{
		if(basic.knowIfAppears(ObjectRepository.sfdc_changePasswordCancel_button))
		{
			basic.click(ObjectRepository.sfdc_changePasswordCancel_button);
		}
	}
	
	public void selectReasonDropdownIfAppears() throws Exception
	{
		if(basic.knowIfAppears(ObjectRepository.value_124))
		{
			if(isRewrite())
			{
				basic.click(ObjectRepository.value_125);
				basic.click(ObjectRepository.value_126);
			}
			else
			{
				basic.click(ObjectRepository.value_125);
				basic.click(ObjectRepository.value_126);
			}
			logger.info("Successfully selected Reason Dropdown on Review and Submit Page");
		}
		else
		{
			logger.info("Reason dropdown not present on Review and Submit Page, continuing script execution");
		}
	}
	
	public void sfdcLogin(String username, String password) throws Exception
	{
		basic.clearBrowserCache();
		basic.justNavigate(ObjectRepository.salesforce_url);
		String uname = username+"@cisco.com."+Constants.sfdc_sandbox;
		basic.typeText(ObjectRepository.sfdc_username_tb, uname);
		basic.typeText(ObjectRepository.sfdc_password_tb, password);
		basic.click(ObjectRepository.sfdc_login_button);
		sfdcClickLoginCancelButtonIfAppears();
		logger.info("SFDC Login Successful for '"+uname+"' / '"+password+"' for URL : " + ObjectRepository.salesforce_url);
	}
	
	public void sfdcCreateOpportunityWithThaymore(String optyName) throws Exception
	{
		sfdcLogin(Constants.defaultSfdcAm_US, "cisco123");
		basic.click(ObjectRepository.createNew_tabdropdown);
		basic.click(ObjectRepository.sfdc_opportunity_link);
		basic.click(ObjectRepository.sfdc_continue_button);
		basic.typeText(ObjectRepository.value_43, "GOOGLE INC - Corp IT");
		basic.click(ObjectRepository.accName_autoPopulated);
		basic.typeText(ObjectRepository.value_44, optyName);
		basic.click(ObjectRepository.value_45);
		basic.typeText(ObjectRepository.value_46, "500");
		basic.selectOption(ObjectRepository.value_47, "2 - Qualification");
		basic.selectOption(ObjectRepository.value_3, "Commit");
		basic.selectOption(ObjectRepository.value_4, "1-Tier");
		basic.selectOption(ObjectRepository.value_5, "8x8");
		//basic.selectOption(ObjectRepository.theaterDropdown, "EMEAR");
		basic.click(ObjectRepository.value_6);
		basic.selectOption(ObjectRepository.value_7, "New Installation");
		basic.click(ObjectRepository.value_8);
		logger.info("Saved first page in SFDC");
		basic.pause(15000);
		basic.waitForElementVisible(ObjectRepository.value_112);
		basic.selectOption(ObjectRepository.value_112, "GOOGLE ACCESS US thaymore");
		basic.click(ObjectRepository.value_113);
		basic.click(ObjectRepository.value_50);
		basic.click(ObjectRepository.value_114);
		basic.click_id(ObjectRepository.value_52);
		basic.updateText_id(ObjectRepository.value_52, "100");
		basic.click(ObjectRepository.value_53);
		logger.info("Waiting 60 seconds to click on Create Quote button");
		basic.pause(35000);
		basic.click(ObjectRepository.sfdc_createQuote_button);
		logger.info("Successfully clicked on Create Quote button");
		basic.pause(15000);
		basic.waitForElementVisible(ObjectRepository.sfdc_createQuote_label);
	}
	
	public void sfdcCreateOpportunity_Emear(String optyName) throws Exception
	{
		sfdcLogin(Constants.defaultSfdcAm_EMEAR, "cisco123");
		basic.click(ObjectRepository.createNew_tabdropdown);
		basic.click(ObjectRepository.sfdc_opportunity_link);
		basic.click(ObjectRepository.sfdc_continue_button);
		basic.typeText(ObjectRepository.value_43, "ACCIDENT EXCHANGE GROUP PLC");
		basic.click(ObjectRepository.accName_autoPopulated);
		basic.typeText(ObjectRepository.value_44, optyName);
		basic.click(ObjectRepository.value_45);
		basic.typeText(ObjectRepository.value_46, "500");
		basic.selectOption(ObjectRepository.value_47, "2 - Qualification");
		basic.selectOption(ObjectRepository.value_3, "Commit");
		basic.selectOption(ObjectRepository.value_4, "1-Tier");
		basic.selectOption(ObjectRepository.value_5, "8x8");
		basic.click(ObjectRepository.value_6);
		basic.selectOption(ObjectRepository.inCiscoCapitalEngaged, "No-Not Required");
		basic.selectOption(ObjectRepository.value_7, "New Installation");
		basic.click(ObjectRepository.value_8);
		logger.info("Saved first page in SFDC");
		basic.pause(15000);
		basic.waitForElementVisible(ObjectRepository.value_112);
		basic.selectOption(ObjectRepository.value_112, "UK_COM_TAM_NORTH_MM_4 beheard");
		basic.click(ObjectRepository.value_113);
		basic.click(ObjectRepository.value_50);
		basic.click(ObjectRepository.value_114);
		basic.click_id(ObjectRepository.value_52);
		basic.updateText_id(ObjectRepository.value_52, "100");
		basic.click(ObjectRepository.value_53);
		logger.info("Waiting 60 seconds to click on Create Quote button");
		basic.pause(35000);
		basic.click(ObjectRepository.sfdc_createQuote_button);
		logger.info("Successfully clicked on Create Quote button");
		basic.pause(15000);
		basic.waitForElementVisible(ObjectRepository.sfdc_createQuote_label);
	}
	
	public void sfdcFillCreateQuotePage() throws Exception
	{
		sfdcFillCreateQuotePage(false);
	}
	
	public void sfdcFillCreateQuotePage(boolean isRnsd) throws Exception
	{
		basic.click(ObjectRepository.sfdc_createQuote_label);
		basic.pause(5000);
		if(isRewrite())
		{
			if(isRnsd)
			{
				basic.click(ObjectRepository.value_189);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.value_115);
				logger.info("Clicked on Transactional Radio button");
			}
			basic.selectOption(ObjectRepository.value_116, "Global Price List in US Dollars");
			basic.selectOption(ObjectRepository.value_117, "Cisco");
			basic.selectOption(ObjectRepository.value_118, "Outsource");
			basic.click(ObjectRepository.value_119);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
		else
		{
			if(isRnsd)
			{				
				basic.click(ObjectRepository.rnsd_radio);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.transactional_radio);
				logger.info("Clicked on Transactional Radio button");
			}			
			basic.click(ObjectRepository.proceList_dropdown);
			basic.click(ObjectRepository.priceList_USD_value);
			basic.click(ObjectRepository.buyMethod_dropdown);
			basic.click(ObjectRepository.buyMethod_Cisco_value);
			basic.click(ObjectRepository.dealCategory_dropdown);
			basic.click(ObjectRepository.dealCategory_Outsource_value);
			basic.click(ObjectRepository.createDeal_button);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
	}
	
	
	public void sfdcFillCreateQuotePage_EMEAR(boolean isRnsd) throws Exception
	{
		basic.click(ObjectRepository.sfdc_createQuote_label);
		basic.pause(5000);
		if(isRewrite())
		{
			if(isRnsd)
			{
				basic.click(ObjectRepository.value_189);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.value_115);
				logger.info("Clicked on Transactional Radio button");
			}
			basic.selectOption(ObjectRepository.value_116, "Global Price List EMEA Availability");
			basic.selectOption(ObjectRepository.value_117, "Cisco");
			basic.selectOption(ObjectRepository.value_118, "Outsource");
			basic.click(ObjectRepository.value_119);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
		else
		{
			if(isRnsd)
			{				
				basic.click(ObjectRepository.rnsd_radio);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.transactional_radio);
				logger.info("Clicked on Transactional Radio button");
			}			
			basic.click(ObjectRepository.proceList_dropdown);
			basic.click(ObjectRepository.priceList_USD_value);
			basic.click(ObjectRepository.buyMethod_dropdown);
			basic.click(ObjectRepository.buyMethod_Cisco_value);
			basic.click(ObjectRepository.dealCategory_dropdown);
			basic.click(ObjectRepository.dealCategory_Outsource_value);
			basic.click(ObjectRepository.createDeal_button);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
	}
	
	public void quotingSetPreferences() throws Exception
	{
		logger.info("Setting Quoting Preferences");
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.waitForElementClickable(ObjectRepository.sfdc_setQuotePreferences_link);
		basic.click(ObjectRepository.sfdc_setQuotePreferences_link);
		basic.pause(5000);
		basic.waitForElementClickable(ObjectRepository.sfdc_selfService_radio);
		basic.click(ObjectRepository.sfdc_selfService_radio);
		basic.pause(5000);
		basic.waitForElementClickable(ObjectRepository.value_122);
		basic.click(ObjectRepository.value_122);
		logger.info("Successfully Set Quoting Preferences");
	}
	
	public void addDefaultProduct() throws Exception
	{
		addDefaultProduct(Constants.defaultProductQty);
	}
	
	public void addDefaultProduct(int qty) throws Exception
	{
		addSpecificProductWithQty(Constants.defaultProduct, qty);
	}
	
	public void addDefaultService() throws Exception
	{
		addDefaultService(Constants.defaultServiceQty);
	}
	
	public void addDefaultService(int qty) throws Exception
	{
		addSpecificServiceWithQty(Constants.defaultService, qty);
		if(basic.knowIfAppears(ObjectRepository.service_duration_tb))
		{
			basic.typeText(ObjectRepository.service_duration_tb, "6");
			basic.click(ObjectRepository.service_add_button);
		}		
	}
	
	public void addDefaultSubscription() throws Exception
	{
		addSpecificSubscriptionWithQty(Constants.defaultSubscription, 1);
	}
	
	public void addDefaultNSDiscount() throws Exception
	{
		addSpecificNSDiscount(Constants.defaultProductDiscount, Constants.defaultServiceDiscount, Constants.defaultSubscriptionDiscount);
	}
	
	
	public void addSpecificProductWithQty(String product, int qty) throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, product);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, ""+qty);
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added product '"+product+"' with quantity '"+qty+"'");
	}
	
	public void addSpecificServiceWithQty(String service, int qty) throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, service);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, ""+qty);
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added service '"+service+"' with quantity '"+qty+"'");
	}
	
	public void addSpecificSubscriptionWithQty(String subscription, int qty) throws Exception
	{
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, subscription);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, ""+qty);
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.value_64);
		if(basic.knowIfAppears(ObjectRepository.username_tb))
		{
			basic.typeText(ObjectRepository.username_tb, "sunchand");
			basic.typeText(ObjectRepository.password_tb, "cisco123");
			basic.click(ObjectRepository.login_button);
		}
		basic.click(ObjectRepository.value_65);
		if(basic.knowIfAppears(ObjectRepository.value_66))
		{
			basic.click(ObjectRepository.value_66);
		}		
		basic.click(ObjectRepository.value_67);
		basic.typeText(ObjectRepository.value_67, "100");
		basic.click(ObjectRepository.value_68);
		basic.click(ObjectRepository.value_69);
		basic.click(ObjectRepository.value_70);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added subscription '"+subscription+"' with quantity '"+qty+"'");
	}
	
	public void saveAndContinueFromItemsTab() throws Exception
	{
		basic.click(ObjectRepository.saveAndCont_itemsTab_button);
		basic.pause(2000);
		basic.waitForPreloaderDisappear();
		basic.waitForPageToLoad1();
		basic.pause(500);
		basic.waitForPreloaderDisappear();
		for(int i=0; i<Constants.actionTryCount; i++)
		{
			if(basic.knowIfAppears("//*[@kdfpage='discountscreditstab']"))
			{
				break;
			}
			else
			{
				basic.pause(2000);
				basic.click(ObjectRepository.saveAndCont_itemsTab_button);
				logger.info("Error in Try number '"+(i+1)+"' upon clicking Save and Continue on Items Tab");
			}
		}
		logger.info("Clicked on Save and Continue on Items tab");
	}
	
	public void addDefaultTradeInItems() throws Exception
	{
		addSpecificTradeInItems("Cisco");
	}
	
	/*public int knowWhichXpathAppears(String xpath1, String xpath2) throws Exception
	{
		logger.info("Knowing which xpath appears");
		basic.waitForPageToLoad();
		logger.info("Waited for page to load");
		try
		{
			driver.findElement(By.xpath(xpath1));
			logger.info("First Xpath appears on UI");
			return 1;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath(xpath2));
			logger.info("Second Xpath appears on UI");
			return 2;
		}
	}*/
	
	public void addSpecificTradeInItems(String tradeInItem) throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.click(ObjectRepository.value_71);
		basic.click(ObjectRepository.value_72);
		basic.click(ObjectRepository.value_73);
		basic.click(ObjectRepository.value_74);
		basic.click(ObjectRepository.value_75);
		basic.clearUpdateText(ObjectRepository.value_75, tradeInItem);
		basic.click(ObjectRepository.value_76);
		basic.doubleClick(ObjectRepository.value_75);
		basic.click(ObjectRepository.value_75);
		basic.click(ObjectRepository.value_77);
		basic.click(ObjectRepository.value_78);
		basic.typeText(ObjectRepository.value_78, "10");
		basic.click(ObjectRepository.value_79);
		basic.click(ObjectRepository.value_80);
		logger.info("Added Tradein Item : " + tradeInItem);
	}
	
	
	public void sfdcAddDefaultOnPremSku() throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, Constants.defaultOnPremSku);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, "1");
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.value_64);
		basic.typeText(ObjectRepository.username_tb, "sunchand");
		basic.typeText(ObjectRepository.password_tb, "cisco123");
		basic.click(ObjectRepository.login_button);
		basic.click(ObjectRepository.value_197);
		basic.click(ObjectRepository.value_198);
		basic.typeText(ObjectRepository.value_198, "100");
		basic.click(ObjectRepository.value_199);
		basic.click(ObjectRepository.value_69);
		basic.click(ObjectRepository.value_70);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added default OA SKU : " + Constants.defaultOnPremSku);
	}
	
	
	public void addSpecificNSDiscount(int productDiscount, int serviceDiscount, int subscriptionDiscount) throws Exception
	{
		basic.click(ObjectRepository.value_81);
		if(productDiscount!=0)
		{
			basic.clearUpdateText(ObjectRepository.productDiscount_tb, ""+productDiscount);
		}
		if(serviceDiscount!=0)
		{
			basic.clearUpdateText(ObjectRepository.serviceDiscount_tb, ""+serviceDiscount);
		}
		if(subscriptionDiscount!=0)
		{
			basic.clearUpdateText(ObjectRepository.subscriptionDiscount_tb, ""+subscriptionDiscount);
		}
		basic.click(ObjectRepository.value_84);
		basic.pause(6000);
		basic.click(ObjectRepository.value_85);
		basic.pause(6000);
		logger.info("Added NS Discount : Product = '"+productDiscount+"', Service = '"+serviceDiscount+"', Subscription = '"+subscriptionDiscount+"'");
	}
	
	public void saveAndContinueFromDiscountsTab() throws Exception
	{
		basic.click(ObjectRepository.saveAndCont_dnc_button);
		logger.info("Clicked on Save and Continue on Discounts and Credits tab");
	}
	
	public void saveAndContinueFromRnSTab() throws Exception
	{
		selectReasonDropdownIfAppears();
		basic.click(ObjectRepository.finishAndSave_rns_page);
		logger.info("Clicked on Save and Continue on Review and Submit tab");
	}
	
	public void submitQuoteForApprovalFromRnSTab() throws Exception
	{
		selectReasonDropdownIfAppears();
		basic.click(ObjectRepository.submitQuoteForApproval_rns_page);
		logger.info("Clicked on Submit Quote for Approval on Review and Submit tab");
	}
	
	public void continueToQualForm() throws Exception
	{
		basic.click(ObjectRepository.value_90);
		basic.click(ObjectRepository.value_91);
		logger.info("Continued to Qual Form");
	}
	
	public String getDealIDFromSFDCQualFormUI() throws Exception
	{
		String dealID = basic.getText(ObjectRepository.value_92);
		logger.info("Got Deal ID from UI : " + dealID);
		return dealID;
	}
	
	public String getDealIDFromCCW() throws Exception
	{
		String dealID = null;
		if(isRewrite())
		{
			dealID = basic.getText(ObjectRepository.value_233);
		}
		else
		{
			dealID = basic.getText(ObjectRepository.dealId_nonrw_ccw_text);
		}		
		logger.info("Got Deal ID from UI : " + dealID);
		return dealID;
	}
	
	public void saveAndContinueFromQualForm() throws Exception
	{
		basic.click(ObjectRepository.value_107);
		logger.info("Clicked on Save and Continue on Qual Form after filling all fields");
	}
	
	public void submitDealForQualification(boolean isRnsd) throws Exception
	{
		if(isRnsd)
		{
			basic.click(ObjectRepository.yesRadioButton_submitPage);
		}
		basic.click(ObjectRepository.value_108);
		basic.click(ObjectRepository.value_109);
		basic.click(ObjectRepository.value_110);
		logger.info("Successfully submitted the deal");
	}
	
	public void sfdcAssert_DT2_SubmissionPage() throws Exception
	{
		basic.validateIfPresent(ObjectRepository.value_131);
		basic.validateIfPresent(ObjectRepository.value_132);
		basic.validateIfPresent(ObjectRepository.value_133);
		basic.validateIfPresent(ObjectRepository.value_134);
		basic.validateIfPresent(ObjectRepository.value_135);
		basic.validateIfPresent(ObjectRepository.value_136);
		basic.validateIfPresent(ObjectRepository.value_137);
		basic.validateIfPresent(ObjectRepository.value_138);
		logger.info("Deal Type 2 validation successful");
	}
	
	private String createDealType5_Product_Service_CommonFlow(int flow) throws Exception
	{
		//Flow : 1=USD, 2=CAD
		String random="", dealName="";
		
		switch(flow)
		{
			case 1: 
			{	clearCacheNavigateAndLoginToCCW("mariar");
				createQuoteFromCCW();
				random = basic.randomNumber(10000, 99999);
				dealName = "NGMDM_DNT_Automation_DealType5_USD_" + random;
				fillCreateQuotePageDefault(dealName);
				fillAboutTheDealPage("Outsource", "Internal Business Use", "Global Price List US Availability");
				break;
			}
			case 2: 
			{
				clearCacheNavigateAndLoginToCCW("dajackson");
				createQuoteFromCCW();
				random = basic.randomNumber(10000, 99999);
				dealName = "NGMDM_DNT_Automation_DealType5_CAD_" + random;
				fillCreateQuotePageDefault(dealName);
				fillAboutTheDealPage("Outsource", "Internal Business Use", "Global Canada Price List in CANADIAN Dollars");
				break;
			}
		}
		
		fillQuoteInitiationPageDefaultAndContinue();
		addDefaultProduct();
		addDefaultService();
		saveAndContinueFromItemsTab();
		saveAndContinueFromDiscountsTab();
		String dealId = getDealIDFromCCW();
		System.out.println(dealId);
		submitQuoteForApprovalFromRnSTab();	
		viewSubmittedQuote_CCW();
		
		//Fetch AM
		DBUtils db = new DBUtils();
		Connection con = db.getConnection();
		String am = db.fetchAM(con, dealId);
		
		if(am!=null)
		{
			clearCacheNavigateAndLoginToCCW(am);
			advanceSearchAndOpenDeal_dealsReferencingYouAs(dealId);
		}
		else
		{
			clearCacheNavigateAndLoginToCCW("sunchand");
			advanceSearchAndOpenDeal_dealsForWhichDealIdIsKnown(dealId);
		}		
		reopenDealCCW();
		saveAndContinueFromItemsTab();
		addDefaultNSDiscount();
		saveAndContinueFromDiscountsTab();
		verifyAmAndForecastingPositionPresent();
		saveAndContinueFromRnSTab();
		continueToQualForm();
		fillQualForm_ID_11();
		saveAndContinueFromQualForm();
		submitDealForQualification(false);
		return dealId+","+dealName;
	}
	
	
	public void verifyAmAndForecastingPositionPresent() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.notNullAmValue_rnsPage))
		{
			//AM is NOT stamped
			selectDefaultAMCCW();
		}
		
		if(! basic.knowIfAppears(ObjectRepository.salesHierarchy_rns))
		{
			//Forecasting Position is not present
			changeForecastingPosition();
		}
	}
	
	public void changeForecastingPosition() throws Exception
	{
		basic.click(ObjectRepository.value_241);
		basic.waitForElementPresent(ObjectRepository.value_242);
		basic.selectOptionWhereValueLike(ObjectRepository.value_242, "CORP_IT US");
		basic.click(ObjectRepository.value_243);
		basic.waitForPreloaderAppear();
		basic.waitForPreloaderDisappear();
		basic.refreshPage();
		basic.waitForElementPresent(ObjectRepository.salesHierarchy_rns);
	}
	
	
	private String commonFlowInDealCreation(String optyNameInput, boolean isRnsd, int mapping) throws Exception
	{
		//Theater : 1=GSP, 2=EMEAR
		return commonFlowInDealCreation(optyNameInput, isRnsd, mapping, 1);
	}
	
	private String commonFlowInDealCreation(String optyNameInput, boolean isRnsd, int mapping, int theater) throws Exception
	{
		int qfFormId = 11;
		String optyName = "";
		if(isRnsd)
			optyName = optyNameInput + "_RNSD";
		else
			optyName = optyNameInput + "_Transactional";
		optyName = optyName + "_" + basic.randomNumber(10000, 99999);
		
		if(theater==1)	//GSP
		{
			sfdcCreateOpportunityWithThaymore(optyName);
			sfdcFillCreateQuotePage(isRnsd);
		}
		else if(theater==2)		//EMEAR
		{
			sfdcCreateOpportunity_Emear(optyName);
			sfdcFillCreateQuotePage_EMEAR(isRnsd);
		}
		
		
		
		//sfdcQuotingSetPreferences();
		
		switch(mapping)
		{
			case 1: //Product Only
			{
				addDefaultProduct();
				saveAndContinueFromItemsTab();
				qfFormId = 12;
				break;
			}
			case 2: //Service Only
			{
				addDefaultService();
				saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 3: //Subscription Only
			{
				addDefaultSubscription();
				saveAndContinueFromItemsTab();
				qfFormId = 12;
				break;
			}
			case 4: //Product and Service
			{
				addDefaultProduct();
				addDefaultService();
				saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 5: //Product, Service and Subscription
			{
				addDefaultProduct();
				addDefaultService();
				addDefaultSubscription();
				saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 6: //Product, Service, Subscription and Trade-in Items
			{
				addDefaultProduct();
				addDefaultService();
				addDefaultSubscription();
				if(! isRnsd)
					addDefaultTradeInItems();
				else
					saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 7: //Import Estimate
			{
				importEstimate(ObjectRepository.estimateId);
				if(! isRnsd)
					addDefaultTradeInItems();
				else
					saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 8: //Product, Service, Subscription, UCS, Offer Attribution
			{
				addDefaultProduct();
				addDefaultService();
				addDefaultSubscription();
				addSpecificProductWithQty(Constants.defaultUcsSku, 1);
				addSpecificServiceWithQty(Constants.defaultOaSku, 1); 
				saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 9: //FV Assessment
			{
				addDefaultProduct(99999);
				addDefaultService(9999999);
				saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 10: //Product, Service, Subscription, UCS, Offer Attribution, On-Prem
			{
				addDefaultProduct();
				addDefaultService();
				addDefaultSubscription();
				addSpecificProductWithQty(Constants.defaultUcsSku, 1);
				addSpecificServiceWithQty(Constants.defaultOaSku, 1); 
				sfdcAddDefaultOnPremSku();
				saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
			case 11: //Product, Service and Trade-in Items
			{
				addDefaultProduct();
				addDefaultService();
				if(! isRnsd)
					addDefaultTradeInItems();
				else
					saveAndContinueFromItemsTab();
				qfFormId = 11;
				break;
			}
		}

		addSpecificNSDiscount(75, 75, 75);
		saveAndContinueFromDiscountsTab();
		
		saveAndContinueFromRnSTab();
		continueToQualForm();
		String dealID = getDealIDFromSFDCQualFormUI();
		sfdcFillQualForm(qfFormId);
		saveAndContinueFromQualForm();
		submitDealForQualification(isRnsd);
		sfdcAssert_DT2_SubmissionPage();
		return dealID+","+optyName;
	}
	
		
	public String createDefaultDealType2_ProductOnly(boolean isRnsd) throws Exception
	{		
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_ProductOnly", isRnsd, 1);
	}
	
	public String createDefaultDealType2_ServiceOnly(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_ServiceOnly", isRnsd, 2);
	}
	
	public String createDefaultDealType2_Product_Service(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_ProductService", isRnsd, 4);
	}
	
	public String createDefaultDealType2_Product_Service_Subscription(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_ProductServiceSubscription", isRnsd, 5);
	}	
	
	public String createDefaultDealType2_Product_Service_Subscription_TradeIn(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_ProductServiceSubscriptionTradein", isRnsd, 6);
	}	
	
	public String createDefaultDealType2_FullFletched(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_FullFledged", isRnsd, 7);
	}
	
	public String createDealType2_Product_Service_Subscription_UCS_OA(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_Product_Service_Subscription_UCS_OA", isRnsd, 8);
	}
	
	public String createDealType2_FV_Assessment(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_FV_Assessment", isRnsd, 9);
	}
	
	public String createDealType2_Product_Service_Subscription_UCS_OA_OnPrem(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_Product_Service_Subscription_UCS_OA_OnPrem", isRnsd, 10);
	}
	
	public String createDefaultDealType2_Product_Service_Tradein(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_ProductServiceTradein", isRnsd, 11);
	}
	
	public String createDealType2_Product_Service_EMEAR(boolean isRnsd) throws Exception
	{
		return commonFlowInDealCreation("NGMDM_DNT_Automation_DealType2_EMEAR_ProductService", isRnsd, 4, 2);
	}
	
	
	
	
	
	public String createDealType5_Product_Service_USD() throws Exception
	{
		return createDealType5_Product_Service_CommonFlow(1);
	}
	
	
	public String createDealType5_Product_Service_CAD() throws Exception
	{
		return createDealType5_Product_Service_CommonFlow(2);
	}
	
	
	public void importEstimate(String estimateId) throws Exception
	{
		logger.info("Importing Estimate ID : " + estimateId);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.click(ObjectRepository.sfdc_moreActions_dropdown);
		basic.click(ObjectRepository.sfdc_importSavedConfig_link);
		basic.click(ObjectRepository.sfdc_savedconfigurationimport1_button);		
		if(basic.knowIfAppears(ObjectRepository.username_tb))
		{
			basic.click(ObjectRepository.username_tb);
			basic.typeText(ObjectRepository.username_tb, "thaymore");
			basic.click(ObjectRepository.password_tb);
			basic.typeText(ObjectRepository.password_tb, "cisco123");
			basic.click(ObjectRepository.login_button);
		}
		basic.click(ObjectRepository.sfdc_txtEstimateSearchTxt_textbox);
		basic.typeText(ObjectRepository.sfdc_txtEstimateSearchTxt_textbox, estimateId);
		basic.click(ObjectRepository.sfdc_btnSearchImportConfigMenu_button);
		basic.pause(8000);
		basic.click(ObjectRepository.sfdc_estimateSearchResult_radio);
		basic.click(ObjectRepository.sfdc_importEstimate_button);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);	
		logger.info("Successfully Imported Estimate ID : " + estimateId);
	}


	public void importEstimateCCW(String estimateId) throws Exception
	{
		logger.info("Importing Estimate ID : " + estimateId);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.click(ObjectRepository.sfdc_moreActions_dropdown);
		basic.click(ObjectRepository.sfdc_importSavedConfig_link);
		basic.click(ObjectRepository.sfdc_savedconfigurationimport1_button);
		basic.click(ObjectRepository.sfdc_txtEstimateSearchTxt_textbox);
		basic.typeText(ObjectRepository.sfdc_txtEstimateSearchTxt_textbox, estimateId);
		basic.click(ObjectRepository.value_244);
		basic.click(ObjectRepository.value_245);
		basic.click(ObjectRepository.sfdc_btnSearchImportConfigMenu_button);
		basic.click(ObjectRepository.value_246);
		basic.click(ObjectRepository.value_247);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Imported Estimate ID : " + estimateId);
	}
	
	
	
	
	
	
	//Modules for Qual Form
	
	public void sfdcFillQualForm(int qualFormId) throws Exception
	{
		logger.info("Filling Qual Form ID = " + qualFormId);
		switch(qualFormId)
		{
		case 1: fillQualForm_ID_1();break;
		case 3: fillQualForm_ID_3();break;
		case 5: fillQualForm_ID_5();break;
		case 7: fillQualForm_ID_7();break;
		case 9: fillQualForm_ID_9();break;
		case 11: fillQualForm_ID_11();break;
		case 12: fillQualForm_ID_12();break;
		}
	}
	
	public void fillQualForm_ID_1() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_128);
		basic.click(ObjectRepository.value_129);
		logger.info("Successfully filled Qual Form ID = 1");
	}
	
	public void fillQualForm_ID_3() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		logger.info("Successfully filled Qual Form ID = 3");
	}
	
	public void fillQualForm_ID_5() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		logger.info("Successfully filled Qual Form ID = 5");
	}
	
	public void fillQualForm_ID_7() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		logger.info("Successfully filled Qual Form ID = 7");
	} 
	
	public void fillQualForm_ID_9() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		logger.info("Successfully filled Qual Form ID = 9");
	} 
	
	public void fillQualForm_ID_11() throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_96, "test");
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_99, "test");
		basic.typeText(ObjectRepository.value_100, "test");
		basic.click(ObjectRepository.value_101);
		basic.click(ObjectRepository.value_102);
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		logger.info("Successfully filled Qual Form ID = 11");
	}
	
	public void fillQualForm_ID_12() throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_96, "test");
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_99, "test");
		basic.typeText(ObjectRepository.value_100, "test");
		basic.click(ObjectRepository.value_101);
		basic.click(ObjectRepository.value_102);
		basic.click(ObjectRepository.value_128);
		basic.click(ObjectRepository.value_128);
		basic.click(ObjectRepository.value_129);
		logger.info("Successfully filled Qual Form ID = 12");
	}
	
	
	
	
	public void clearCacheNavigateAndLoginToCCW(String user) throws Exception
	{
		logger.info("Logging in to CCW with user : " + user);
		basic.clearBrowserCache();
		basic.justNavigate(ObjectRepository.ccw_proxy_url);
		basic.typeText(ObjectRepository.username_tb, ObjectRepository.ccwProxyUsername);
		basic.typeText(ObjectRepository.password_tb, ObjectRepository.ccwProxyPassword);
		basic.click(ObjectRepository.login_button);
		basic.typeText(ObjectRepository.value_209, user);
		basic.click(ObjectRepository.value_210);
		logger.info("Successfully logged in to CCW with user : " + user);
	}
	
	public void createQuoteFromCCW() throws Exception
	{
		basic.click(ObjectRepository.value_211);
		logger.info("Clicked on Create Quote button in CCW");
		basic.pause(2000);
		basic.waitForPageToLoad1();
	}
	
	public void fillCreateQuotePageDefault(String dealName) throws Exception
	{
		basic.click(ObjectRepository.value_212);		
		basic.typeText(ObjectRepository.value_212, dealName);
		basic.selectOption(ObjectRepository.value_213, "Other (Other)");
		basic.click(ObjectRepository.value_214);
		basic.typeText(ObjectRepository.value_214, "glwalker");
		basic.click(ObjectRepository.value_215);
		basic.click(ObjectRepository.value_216);
		basic.typeText(ObjectRepository.value_216, "google");
		basic.click(ObjectRepository.value_217);
		basic.click(ObjectRepository.value_218);
		basic.click(ObjectRepository.value_219);
		basic.click(ObjectRepository.value_220);
		basic.click(ObjectRepository.value_221);
		basic.click(ObjectRepository.value_222);
		basic.pause(2000);
		basic.waitForPageToLoad1();
		logger.info("Filled Create Quote Page CCW");
	}
	
	public void fillAboutTheDealPageDefault() throws Exception
	{
		fillAboutTheDealPage("Outsource", "Internal Business Use", "Global Price List US Availability");
	}
	
	
	
	public void fillAboutTheDealPage(String dealCategory, String intendedUse, String priceList) throws Exception
	{
		basic.click(ObjectRepository.value_223);
		basic.typeText(ObjectRepository.value_223, "NGMDM_DNT_Automation_DealType5");
		if(isRewrite())
		{
			basic.selectOption(ObjectRepository.dealCategoryDropdown, dealCategory);
			basic.selectOption(ObjectRepository.intendedUseDropdown, intendedUse);
			basic.selectOption(ObjectRepository.priceListDropdown, priceList);
			basic.click(ObjectRepository.calenderIcon);
			basic.click(ObjectRepository.calenderNextMonth);
			basic.click(ObjectRepository.calenderNextMonthDate);
		}
		else
		{
			basic.click(ObjectRepository.intendedUseDropdown);
			basic.click("//*[starts-with(@kdfid,'intendedUse_') and @kdfapp='Quoting' and @kdfpage='aboutTheDeal' and contains(text(),'"+intendedUse+"')]");
			basic.click(ObjectRepository.dealCategoryDropdown);
			basic.click("//*[starts-with(@kdfid,'dealCategory_') and @kdfapp='Quoting' and @kdfpage='aboutTheDeal' and contains(text(),'"+dealCategory+"')]");
			basic.click(ObjectRepository.priceListDropdown);
			basic.click("//*[starts-with(@kdfid,'erpPriceListId_') and @kdfapp='Quoting' and @kdfpage='aboutTheDeal' and contains(text(),'"+priceList+"')]");
		}		
		basic.click(ObjectRepository.saveAndContinueFromAboutTheDealPage);
		basic.pause(2000);
		basic.waitForPageToLoad1();
		logger.info("Filled About the Deal Page with values : Deal Category = '"+dealCategory+"' , Intended Use = '"+intendedUse+"' , Price List = '"+priceList+"'");
	}
	
	public void fillQuoteInitiationPageDefaultAndContinue() throws Exception
	{
		basic.pause(2000);
		basic.waitForPageToLoad1();
		basic.pause(2000);
		basic.waitForPreloaderDisappear();
		fillQuoteInitiationPage("Cisco");
		saveAndContinueFromQIP();
		basic.pause(2000);
		basic.waitForPageToLoad1();
	}
	
	public void fillQuoteInitiationPage(String buyMethod) throws Exception
	{
		selectBuyMethod(buyMethod);
	}
	
	public void selectBuyMethod(String buyMethod) throws Exception
	{
		if(isRewrite())
		{
			basic.selectOption(ObjectRepository.value_231, buyMethod);
		}
		else
		{
			basic.click(ObjectRepository.buyMethod_CCW_dropdown);
			logger.info("Clicked on Buy Method Dropdown");
			
			for(int i=0; i<5; i++)
			{
				if(!basic.knowIfAppears("//a[contains(@kdfid,'fulfillmentSelect_') and @kdfapp='Quoting' and @kdfpage='initialQuote' and text()='"+buyMethod+"']"))
				{
					basic.pause(1500);
					basic.click(ObjectRepository.buyMethod_CCW_dropdown);
					basic.pause(500);
					logger.warn("Try No : '"+(i+1)+"' in clicking element : " + "//a[contains(@kdfid,'fulfillmentSelect_') and @kdfapp='Quoting' and @kdfpage='initialQuote' and text()='"+buyMethod+"']");
				}
				else
				{
					break;
				}
			}
			
			basic.click("//a[contains(@kdfid,'fulfillmentSelect_') and @kdfapp='Quoting' and @kdfpage='initialQuote' and text()='"+buyMethod+"']");
		}
		logger.info("Selected Buy Method : " + buyMethod);
	}
	
	public void saveAndContinueFromQIP() throws Exception
	{
		if(isRewrite())
		{
			basic.click(ObjectRepository.value_232);
		}
		else
		{
			basic.click(ObjectRepository.saveAndContinueFromQIP);
		}
		logger.info("Clicked on Save and Continue on CCW Quote Initiation Page");
	}
	
	public void importDefaultEstimateCCWAndContinue() throws Exception
	{
		importEstimateCCW(ObjectRepository.estimateId);
		saveAndContinueFromItemsTab();
	}
	
	
	
	public void viewSubmittedQuote_CCW() throws Exception
	{
		basic.click(ObjectRepository.value_138);
		logger.info("Clicked on View Submitted Quote");
	}
	
	private void advanceSearchAndOpenDeal(String dealId, String parameter) throws Exception
	{
		basic.click(ObjectRepository.value_235);
		basic.selectOption(ObjectRepository.value_236, parameter);
		basic.typeText(ObjectRepository.value_237, dealId);
		basic.click(ObjectRepository.value_238);
		basic.click(ObjectRepository.value_239);
	}
	
	public void advanceSearchAndOpenDeal_dealsForWhichDealIdIsKnown(String dealId) throws Exception
	{
		advanceSearchAndOpenDeal(dealId, Constants.dealsForWhichDealIdIsKnown);
	}
	public void advanceSearchAndOpenDeal_dealsReferencingYouAs(String dealId) throws Exception
	{
		advanceSearchAndOpenDeal(dealId, Constants.dealsReferencingYouAs);
	}
	public void advanceSearchAndOpenDeal_dealsWhereIAmAnApprover(String dealId) throws Exception
	{
		advanceSearchAndOpenDeal(dealId, Constants.dealsWhereIAmAnApprover);
	}
	public void advanceSearchAndOpenDeal_dealsPendingMyApproval(String dealId) throws Exception
	{
		advanceSearchAndOpenDeal(dealId, Constants.dealsPendingMyApproval);
	}
	
	public void reopenDealCCW() throws Exception
	{
		basic.click(ObjectRepository.reopenDeal_rns_page);
		basic.click(ObjectRepository.value_240);
	}
	
	public void selectDefaultAMCCW() throws Exception
	{
		selectDifferentAMCCW("thaymore");
	}
	
	public void selectDifferentAMCCW(String amCecId) throws Exception
	{
		basic.click(ObjectRepository.value_248);
		basic.click(ObjectRepository.value_249);
		basic.click("//*[@kdfid='amEmailId' and @kdfapp='Quoting' and @kdfpage='reviewAndSubmit']/following::a[@kdfid='amEmailId_' and contains(text(),'"+amCecId+"')]");
		basic.click(ObjectRepository.value_251);
		basic.click(ObjectRepository.value_252);
		basic.click(ObjectRepository.value_253);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	public void ngmdmLogin(String userName) throws Exception
	{
		//Thread t1 = new Thread();		
		//Runnable t2 = new Runnable();		
		//WebDriver driver = new FirefoxDriver();
		
		basic.clearBrowserCache();
		basic.justNavigate(ObjectRepository.mdmProxy_Url);
		//basic.pause(8000);
		basic.typeText(ObjectRepository.username_tb, ObjectRepository.mdmProxyUsername);
		basic.typeText(ObjectRepository.password_tb, ObjectRepository.mdmProxyPassword);
		basic.click(ObjectRepository.login_button);
		//basic.pause(5000);
		basic.typeText(ObjectRepository.proxyId_tb, userName);
		basic.click(ObjectRepository.proxyIdSubmit_button);
	}
	
	public void openDealIDUsingAdvancedSearch(String dealId) throws Exception
	{
		advanceSearchDealID(dealId);
		basic.click(ObjectRepository.dealID_link);
	}
	
	public void advanceSearchDealID(String dealId) throws Exception
	{
		advanceSearchDealID(dealId, null, null);
	}
	public void advanceSearchDealID(String dealId, String dealStatus, String dealType) throws Exception
	{
		basic.click(ObjectRepository.advancedSearch_link);
		if(dealId!=null)
		{
			if(! dealId.trim().equals(""))
			{
				basic.typeText(ObjectRepository.dealID_textbox, dealId);
			}
		}
		if(dealStatus!=null)
		{
			if(! dealStatus.trim().equals(""))
			{
				basic.selectOption(ObjectRepository.value_312, dealStatus);
			}
		}
		if(dealType!=null)
		{
			if(! dealType.trim().equals(""))
			{
				basic.selectOption(ObjectRepository.value_314, dealType);
			}
		}
		basic.click(ObjectRepository.advancedSearch_button);
	}

}
