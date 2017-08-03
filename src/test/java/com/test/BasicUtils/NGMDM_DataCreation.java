package com.test.BasicUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NGMDM_DataCreation 
{
	static Connection con;
	static Statement stmt;
	static LaunchBrowsers browsers;
	static String browserName = "firefox";
	
	@BeforeTest
	public void dbconnection() throws Exception
	{
		browsers = new LaunchBrowsers();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb","sys as sysdba", "amiitonoma07");
		//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb","abhaik", "abhaik");
		stmt = con.createStatement();
	}
	
	@AfterTest
	public void disconnect() throws Exception
	{
		stmt.close();
		con.close();
	}
	
	/*
	@Test
	public static void _07AppDec_TC09_Verify_assuror_is_able_to_condiitonaly_approve_deals_new() throws Exception
	{
	System.out.println("_07AppDec_TC09_Verify_assuror_is_able_to_condiitonaly_approve_deals_new");
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.justNavigate(ObjectRepository.salesforce_url);
	basic.typeText(ObjectRepository.sfdc_username_tb, "beheard@cisco.com.qtr");
	basic.typeText(ObjectRepository.sfdc_password_tb, "cisco123");
	basic.click(ObjectRepository.sfdc_login_button);
	if(basic.ifLogic(ObjectRepository.value_111, "Click to Open Sidebar"))
	{
	basic.click(ObjectRepository.value_111);
	}
	basic.click(ObjectRepository.createNew_tabdropdown);
	basic.click(ObjectRepository.sfdc_opportunity_link);
	basic.click(ObjectRepository.sfdc_continue_button);
	basic.typeText(ObjectRepository.value_43, "ACCIDENT EXCHANGE GROUP PLC");
	String random = basic.randomNumber(10000, 99999);
	basic.typeText(ObjectRepository.value_44, "NGMDM_Automation_DNT_DealType2_EMEAR_" + random);
	basic.click(ObjectRepository.value_45);
	basic.typeText(ObjectRepository.value_46, "500");
	basic.selectOption(ObjectRepository.value_47, "2 - Qualification");
	basic.selectOption(ObjectRepository.value_3, "Commit");
	basic.selectOption(ObjectRepository.value_4, "1-Tier");
	basic.selectOption(ObjectRepository.inCiscoCapitalEngaged, "No-Not Required");
	basic.selectOption(ObjectRepository.value_5, "8x8");
	basic.click(ObjectRepository.value_6);
	basic.selectOption(ObjectRepository.value_7, "New Installation");
	basic.click(ObjectRepository.value_8);
	basic.pause(25000);
	basic.waitForElementVisible(ObjectRepository.value_112);
	basic.selectOption(ObjectRepository.value_112, "UK_COM_TAM_NORTH_MM_4 beheard");
	basic.click(ObjectRepository.value_113);
	basic.click(ObjectRepository.value_50);
	basic.click(ObjectRepository.value_114);
	basic.click_id(ObjectRepository.value_52);
	basic.updateText_id(ObjectRepository.value_52, "100");
	basic.click(ObjectRepository.value_53);
	basic.pause(60000);
	basic.click(ObjectRepository.sfdc_createQuote_button);
	basic.selectOption(ObjectRepository.value_116, "Global Price List EMEA Availability");
	basic.click(ObjectRepository.value_115);
	basic.selectOption(ObjectRepository.value_117, "Cisco");
	basic.selectOption(ObjectRepository.value_118, "Outsource");
	basic.click(ObjectRepository.value_119);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.waitForElementClickable(ObjectRepository.sfdc_setQuotePreferences_link);
	basic.click(ObjectRepository.sfdc_setQuotePreferences_link);
	basic.pause(10000);
	basic.waitForElementClickable(ObjectRepository.sfdc_selfService_radio);
	basic.click(ObjectRepository.sfdc_selfService_radio);
	basic.pause(15000);
	basic.waitForElementClickable(ObjectRepository.value_122);
	basic.click(ObjectRepository.value_122);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, "CISCO1921DC/K9");
	basic.click(ObjectRepository.sfdc_skuQty_tb);
	basic.typeText(ObjectRepository.sfdc_skuQty_tb, "1");
	basic.click(ObjectRepository.sfdc_addSku_button);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, "CON-SNT3-LAP1252A");
	basic.click(ObjectRepository.sfdc_skuQty_tb);
	basic.typeText(ObjectRepository.sfdc_skuQty_tb, "1");
	basic.click(ObjectRepository.sfdc_addSku_button);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.click(ObjectRepository.value_71);
	basic.click(ObjectRepository.saveAndCont_itemsTab_button);
	basic.click(ObjectRepository.value_81);
	basic.clearUpdateText(ObjectRepository.productDiscount_tb, "60");
	basic.clearUpdateText(ObjectRepository.serviceDiscount_tb, "60");
	basic.clearUpdateText(ObjectRepository.subscriptionDiscount_tb, "60");
	basic.click(ObjectRepository.value_84);
	basic.click(ObjectRepository.value_85);
	basic.click(ObjectRepository.saveAndCont_dnc_button);
	if(basic.ifLogic(ObjectRepository.value_124, "This Quote contains serviceable items without any services attached. Kindly provide a reason in the ‘Please provide reason to not purchase services’ section"))
	{
	basic.click(ObjectRepository.value_125);
	basic.click(ObjectRepository.value_126);
	}
	basic.click(ObjectRepository.value_89);
	basic.click(ObjectRepository.value_90);
	basic.click(ObjectRepository.value_91);
	basic.click(ObjectRepository.value_191);
	String DealID = basic.getText(ObjectRepository.value_92);
	basic.click(ObjectRepository.value_94);
	basic.click(ObjectRepository.value_192);
	basic.typeText(ObjectRepository.value_93, "6");
	basic.click(ObjectRepository.value_103);
	basic.click(ObjectRepository.value_104);
	basic.click(ObjectRepository.value_193);
	basic.click(ObjectRepository.value_97);
	basic.click(ObjectRepository.value_98);
	basic.typeText(ObjectRepository.value_96, "test");
	basic.typeText(ObjectRepository.value_100, "test");
	basic.typeText(ObjectRepository.value_99, "test");
	basic.click(ObjectRepository.value_101);
	basic.click(ObjectRepository.value_102);
	basic.click(ObjectRepository.value_105);
	basic.click(ObjectRepository.value_106);
	basic.click(ObjectRepository.value_107);
	basic.click(ObjectRepository.value_108);
	basic.click(ObjectRepository.value_109);
	basic.click(ObjectRepository.value_110);
	basic.validateIfPresent(ObjectRepository.value_131);
	basic.validateIfPresent(ObjectRepository.value_132);
	basic.validateIfPresent(ObjectRepository.value_133);
	basic.validateIfPresent(ObjectRepository.value_138);
	basic.validateIfPresent(ObjectRepository.value_134);
	basic.validateIfPresent(ObjectRepository.value_135);
	basic.validateIfPresent(ObjectRepository.value_136);
	basic.validateIfPresent(ObjectRepository.value_137);
	basic.pause(150000);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "duabhish");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.click(ObjectRepository.advancedSearch_link);
	basic.typeText(ObjectRepository.dealID_textbox, DealID);
	basic.click(ObjectRepository.advancedSearch_button);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_255);
	basic.click(ObjectRepository.value_256);
	basic.click(ObjectRepository.value_257);
	basic.selectOption(ObjectRepository.value_258, "Service Pricing");
	basic.typeTextAutopopulate(ObjectRepository.value_259, "ngazaleh");
	basic.typeText(ObjectRepository.value_260, "test");
	basic.click(ObjectRepository.value_261);
	basic.validateIfPresent(ObjectRepository.value_262);
	basic.click(ObjectRepository.value_263);
	basic.click(ObjectRepository.value_264);
	basic.validateContains(ObjectRepository.value_265, "Sent");
	basic.pause(150000);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "ngazaleh");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.click(ObjectRepository.advancedSearch_link);
	basic.typeText(ObjectRepository.dealID_textbox, DealID);
	basic.click(ObjectRepository.advancedSearch_button);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_255);
	basic.click(ObjectRepository.value_256);
	basic.click(ObjectRepository.value_266);
	basic.selectOption(ObjectRepository.value_267, "Conditionally Approve");
	basic.typeText(ObjectRepository.value_268, "test");
	basic.click(ObjectRepository.value_269);
	basic.validateDoesNotContain(ObjectRepository.value_270, "Assurance in Process");
	}
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@AfterMethod
	public void tearDown(ITestResult result, WebDriver driver)
	{
		System.out.println("In After Method");
		driver.get("https://www.google.com");
		// Here will compare if test is failing then only it will enter into if condition
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			try
			{
				// Create refernce of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all
				// screenshot in our project home directory and
				// result.getName() will return name of test case so that
				// screenshot name will be same
				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
		// close application
		driver.quit();
	}*/
	
	public void insertIntoDb(String str) throws Exception
	{
		String[] arr = str.split(",");
		String dealID = arr[0];
		String dealName = arr[1];
		int result = stmt.executeUpdate("insert into ngmdm_deals_q1_fy18 values ( '"+dealID+"', '"+dealName+"',  to_date(to_char(sysdate, 'dd-MON-yyyy hh24:mi:ss'), 'dd-MM-YYYY hh24:mi:ss'), 'N')");
	}
	
	
	
	
	
	
	
	
	@Test
	public void qfId1() throws Exception
	{
		System.out.println("_______________qfId1");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		m.sfdcCreateOpportunityWithThaymore("QF_Form_ID_1");
		m.sfdcFillCreateQuotePage(false);
		m.quotingSetPreferences();
		m.addDefaultProduct();
		m.saveAndContinueFromItemsTab();
		m.addSpecificNSDiscount(20, 0, 0);
		m.saveAndContinueFromDiscountsTab();
		m.selectReasonDropdownIfAppears_RNS_page();
		m.saveAndContinueFromRnSTab();
		m.continueToQualForm();
		String dealID = m.getDealIDFromSFDCQualFormUI();
		m.sfdcFillQualForm(1);
		m.saveAndContinueFromQualForm();
		m.submitDealForQualification(false);
		m.sfdcAssert_DT2_SubmissionPage();
		
		System.out.println("Success : " + dealID);
	}
	
	
	
	
	
	/*@Test
	public void test1() throws Exception
	{
		System.out.println("_______________ createDealType5_Product_Service_USD");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		//String str = m.createDealType5_Product_Service_CAD();
		String str = m.createDealType5_Product_Service_USD();
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
	}*/
	
	
	
	
	/*@Test
	public void test2() throws Exception
	{
		System.out.println("_______________ createDealType5_Product_Service_USD");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		//String str = m.createDealType5_Product_Service_CAD();
		String str = m.createDealType5_Product_Service_USD();
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
	}*/
	
	/*@Test
	public void test3() throws Exception
	{
		System.out.println("_______________ createDefaultDealType2_Product_Service");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		//String str = m.createDealType5_Product_Service_CAD();
		String str = m.createDefaultDealType2_Product_Service(true);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
	}
	
	@Test
	public void test4() throws Exception
	{
		System.out.println("_______________ createDefaultDealType2_Product_Service");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		//String str = m.createDealType5_Product_Service_CAD();
		String str = m.createDefaultDealType2_Product_Service(true);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
	}*/
	
	/*@Test
	public void test3() throws Exception
	{
		System.out.println("_______________13");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		//String str = m.createDealType5_Product_Service_CAD();
		String str = m.createDealType2_Product_Service_EMEAR(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
	}*/
	
	
	/*
	@Test
	public void test2() throws Exception
	{
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		basic.justNavigate("https://www.irctc.co.in");
	}*/
	
	
	
	
	
	
	
	/*@Test
	public void test1() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType5_Product_Service();
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		
	}*/
	
	
	
	
	
	
	/*
	@Test
	public void test2() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test3() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	
	
	@Test
	public void test4() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test5() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test6() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test7() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test8() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test9() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDealType2_Product_Service_Subscription_UCS_OA(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}*/
	
	/*
	@Test
	public void test10() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test11() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test12() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test13() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test14() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test15() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test16() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test17() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test18() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test19() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test20() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	
	@Test
	public void test21() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test22() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test23() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test24() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test25() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test26() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test27() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test28() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test29() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test30() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test31() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test32() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test33() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test34() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test35() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test36() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test37() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test38() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test39() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test40() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test41() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test42() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test43() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test44() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test45() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test46() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test47() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test48() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test49() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test50() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test51() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test52() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(true);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test53() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test54() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test55() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test56() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test57() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test58() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test59() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test60() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test61() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test62() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test63() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test64() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test65() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test66() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test67() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test68() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test69() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test70() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test71() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test72() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test73() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test74() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test75() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test76() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test77() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test78() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test79() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test80() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test81() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test82() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test83() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test84() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test85() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test86() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test87() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test88() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test89() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test90() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test91() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test92() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test93() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test94() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test95() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test96() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test97() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		//String str = m.createDefaultDealType2_Product_Service_Subscription_TradeIn(false);
		//String str = m.createDefaultDealType2_FullFletched(false);
		//m.quitDriver();
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test98() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test99() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	@Test
	public void test100() throws Exception
	{
		System.out.println("_______________");
		WebDriver driver = browsers.launchBrowser(browserName);
		Modules m = new Modules(driver);
		String str = m.createDefaultDealType2_Product_Service(false);
		insertIntoDb(str);
		System.out.println("Success");
		m.quitDriver();
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Test
	public static void _Deal_type_5_Transactional() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser(browserName);
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.navigateAndLoginToCCW("mariar");
	m.createQuoteFromCCW();
	m.fillCreateQuotePageDefault();
	m.fillAboutTheDealPageDefault();
	m.fillQuoteInitiationPageDefaultAndContinue();
	//m.importDefaultEstimateCCWAndContinue();
	m.addDefaultProduct();
	m.addDefaultService();
	m.addDefaultSubscription();
	m.saveAndContinueFromItemsTab();
	String DealID = m.getDealIDFromCCW();
	m.saveAndContinueFromDiscountsTab();
	m.selectReasonDropdownIfAppears_RNS_page();
	m.saveAndContinueFromRnSTab();
	m.viewSubmittedQuote_CCW();
	
	
	basic.pause(20000);
	basic.justNavigate(ObjectRepository.value_208);
	basic.click(ObjectRepository.value_209);
	String am = "annkaise";
	basic.typeText(ObjectRepository.value_209, am);
	basic.click(ObjectRepository.value_210);
	basic.click(ObjectRepository.value_235);
	basic.selectOption(ObjectRepository.value_236, "Deals Referencing You as CAM/ICAM/AM");
	basic.typeText(ObjectRepository.value_237, DealID);
	basic.click(ObjectRepository.value_238);
	basic.click(ObjectRepository.value_239);
	basic.click(ObjectRepository.value_89);
	basic.click(ObjectRepository.value_240);
	basic.click(ObjectRepository.saveAndCont_itemsTab_button);
	basic.click(ObjectRepository.value_81);
	basic.click(ObjectRepository.sfdc_productDiscount_tb);
	basic.clearUpdateText(ObjectRepository.sfdc_productDiscount_tb, "60");
	basic.click(ObjectRepository.sfdc_serviceDiscount_tb);
	basic.clearUpdateText(ObjectRepository.sfdc_serviceDiscount_tb, "60");
	basic.click(ObjectRepository.sfdc_subscriptionDiscount_tb);
	basic.clearUpdateText(ObjectRepository.sfdc_subscriptionDiscount_tb, "60");
	basic.click(ObjectRepository.value_84);
	basic.click(ObjectRepository.value_85);
	basic.click(ObjectRepository.saveAndCont_dnc_button);
	basic.click(ObjectRepository.value_241);
	basic.click(ObjectRepository.value_242);
	basic.selectOption(ObjectRepository.value_242, "GOOGLE CORP_IT CANADA " + am);
	basic.click(ObjectRepository.value_243);
	basic.click(ObjectRepository.value_89);
	basic.click(ObjectRepository.value_90);
	basic.click(ObjectRepository.value_91);
	basic.click(ObjectRepository.value_94);
	basic.click(ObjectRepository.value_94);
	basic.click(ObjectRepository.value_95);
	basic.click(ObjectRepository.value_93);
	basic.typeText(ObjectRepository.value_93, "6");
	basic.click(ObjectRepository.value_103);
	basic.click(ObjectRepository.value_104);
	basic.click(ObjectRepository.value_97);
	basic.click(ObjectRepository.value_97);
	basic.click(ObjectRepository.value_98);
	basic.click(ObjectRepository.value_96);
	basic.typeText(ObjectRepository.value_96, "test");
	basic.click(ObjectRepository.value_100);
	basic.typeText(ObjectRepository.value_100, "test");
	basic.click(ObjectRepository.value_99);
	basic.typeText(ObjectRepository.value_99, "test");
	basic.click(ObjectRepository.value_101);
	basic.click(ObjectRepository.value_102);
	basic.click(ObjectRepository.value_105);
	basic.click(ObjectRepository.value_105);
	basic.click(ObjectRepository.value_106);
	basic.click(ObjectRepository.value_107);
	basic.click(ObjectRepository.value_108);
	basic.click(ObjectRepository.value_109);
	basic.waitForElementVisible(ObjectRepository.value_138);
	basic.click(ObjectRepository.value_110);
	}
	*/
	
	
}
	
