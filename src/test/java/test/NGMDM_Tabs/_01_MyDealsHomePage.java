package test.NGMDM_Tabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.MainClass;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class _01_MyDealsHomePage
{	
	
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("================================================================================================== before suite 01");
	}
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("================================================================================================== after suite 01");
	}
	
	
	@Test
	public void test1() throws Exception
	{
		System.out.println("___________________________________test1");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.ultimatix.net");
		throw new Exception("fail10");
	}
	
	
	@Test
	public void test2() throws Exception
	{
		System.out.println("___________________________________test1");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.erail.info");
		throw new Exception("fail11");
	}
	
	
	@Test
	public void test3() throws Exception
	{
		System.out.println("___________________________________test1");
		WebDriver driver = LaunchBrowsers.launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.stackoverflow.com");
		throw new Exception("fail11");
	}
	
	
	
	
	
	
	@Test
	public static void _01MyDHPge_TC01_Verify_Data_displayed_by_default_for_DDA_Admin() throws Exception
	{
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		Reporter.getCurrentTestResult().setAttribute("driver", driver);
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("duabhish");
		basic.validateIfPresent(ObjectRepository.value_2);
	}

	
	@Test
	public static void _01MyDHPge_TC02_Verify_Data_displayed_by_default_for_DDA() throws Exception
	{
		
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");		 
		Reporter.getCurrentTestResult().setAttribute("driver", driver);
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("pauclark");
		basic.validateIfPresent(ObjectRepository.value_2);
	}

	
	@Test
	public static void _01MyDHPge_TC03_Verify_Data_displayed_by_default_for_Approver() throws Exception
	{
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("micjohns");
		basic.validateIfPresent(ObjectRepository.value_271);
	}

	
	@Test
	public static void _01MyDHPge_TC04_Verify_Data_displayed_by_default_for_Assuror() throws Exception
	{
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("ngazaleh");
		basic.validateIfPresent(ObjectRepository.value_272);
	}

	
	@Test
	public static void _01MyDHPge_TC05_Verify_Executive_summary_for_deals_displayed_on_My_deal_home_page() throws Exception
	{
		System.out.println("______________________ 01MyDHPge_TC05_Verify_Executive_summary_for_deals_displayed_on_My_deal_home_page");
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("duabhish");
		m.advanceSearchDealID("61001372");		
		basic.pause(8000);
		String productDD = basic.getText(ObjectRepository.value_273);
		String serviceDD = basic.getText(ObjectRepository.value_274);
		basic.scrollIntoView(ObjectRepository.value_275);
		String country = basic.getText(ObjectRepository.value_275);
		basic.scrollIntoView(ObjectRepository.value_276);
		String optyName = basic.getText(ObjectRepository.value_276);
		String optyOwner = basic.getText(ObjectRepository.value_277);
		String accName = basic.getText(ObjectRepository.value_278);
		String recentSubmission = basic.getText(ObjectRepository.value_279);
		basic.scrollIntoView(ObjectRepository.value_280);
		String dealNetPrice = basic.getText(ObjectRepository.value_280);
		basic.scrollIntoView(ObjectRepository.dealID_link);
		basic.click(ObjectRepository.dealID_link);
		basic.click(ObjectRepository.value_281);
		basic.click(ObjectRepository.value_12);
		String netProduct = basic.getText(ObjectRepository.value_282);
		String netTss = basic.getText(ObjectRepository.value_283);
		String netTotal = basic.getText(ObjectRepository.value_284);
		String discountProduct = basic.getText(ObjectRepository.value_285);
		String discountTss = basic.getText(ObjectRepository.value_286);
		String discountTotal = basic.getText(ObjectRepository.value_287);
		String marginProduct = basic.getText(ObjectRepository.value_288);
		String marginTss = basic.getText(ObjectRepository.value_289);
		String marginTotal = basic.getText(ObjectRepository.value_290);
		basic.click(ObjectRepository.value_291);
		basic.click(ObjectRepository.value_292);
		basic.validate(ObjectRepository.value_293, "Executive Summary");
		basic.validateContains(ObjectRepository.value_294, productDD);
		basic.validateContains(ObjectRepository.value_295, serviceDD);
		basic.validateContains(ObjectRepository.value_296, country);
		basic.validate(ObjectRepository.value_297, optyName);
		basic.validate(ObjectRepository.value_298, optyOwner);
		basic.validateIfPresent(ObjectRepository.value_299);
		basic.validate(ObjectRepository.value_300, accName);
		basic.scrollIntoView(ObjectRepository.value_301);
		basic.validateContains(ObjectRepository.value_301, netProduct);
		if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
		{
			basic.validateContains(ObjectRepository.value_303, netTss);
		}
		basic.validateContains(ObjectRepository.value_304, netTotal);
		basic.validateContains(ObjectRepository.value_305, discountProduct);
		if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
		{
			basic.validateContains(ObjectRepository.value_306, discountTss);
		}
		basic.validateContains(ObjectRepository.value_307, discountTotal);
		basic.validateContains(ObjectRepository.value_308, marginProduct);
		if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
		{
			basic.validateContains(ObjectRepository.value_309, marginTss);
		}
		basic.validateContains(ObjectRepository.value_310, marginTotal);
		basic.scrollIntoView(ObjectRepository.value_311);
		basic.validate(ObjectRepository.value_311, "61001372");
	}

	
	@Test
	public static void _01MyDHPge_TC06_Verify_Executive_summary_for_deals_displayed_for_reopened_deal() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	m.advanceSearchDealID("61001566");
	
	basic.pause(8000);
	String productDD = basic.getText(ObjectRepository.value_273);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.scrollIntoView(ObjectRepository.value_275);
	String country = basic.getText(ObjectRepository.value_275);
	basic.scrollIntoView(ObjectRepository.value_276);
	String optyName = basic.getText(ObjectRepository.value_276);
	String optyOwner = basic.getText(ObjectRepository.value_277);
	String accName = basic.getText(ObjectRepository.value_278);
	String recentSubmission = basic.getText(ObjectRepository.value_279);
	basic.scrollIntoView(ObjectRepository.value_280);
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.scrollIntoView(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_281);
	basic.click(ObjectRepository.value_12);
	String netProduct = basic.getText(ObjectRepository.value_282);
	String netTss = basic.getText(ObjectRepository.value_283);
	String netTotal = basic.getText(ObjectRepository.value_284);
	String discountProduct = basic.getText(ObjectRepository.value_285);
	String discountTss = basic.getText(ObjectRepository.value_286);
	String discountTotal = basic.getText(ObjectRepository.value_287);
	String marginProduct = basic.getText(ObjectRepository.value_288);
	String marginTss = basic.getText(ObjectRepository.value_289);
	String marginTotal = basic.getText(ObjectRepository.value_290);
	basic.click(ObjectRepository.value_291);
	basic.click(ObjectRepository.value_292);
	basic.validate(ObjectRepository.value_293, "Executive Summary");
	basic.validateContains(ObjectRepository.value_294, productDD);
	basic.validateContains(ObjectRepository.value_295, serviceDD);
	basic.validateContains(ObjectRepository.value_296, country);
	basic.validate(ObjectRepository.value_297, optyName);
	basic.validate(ObjectRepository.value_298, optyOwner);
	basic.validateIfPresent(ObjectRepository.value_299);
	basic.validate(ObjectRepository.value_300, accName);
	basic.scrollIntoView(ObjectRepository.value_301);
	basic.validateContains(ObjectRepository.value_301, netProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_303, netTss);
	}
	basic.validateContains(ObjectRepository.value_304, netTotal);
	basic.validateContains(ObjectRepository.value_305, discountProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_306, discountTss);
	}
	basic.validateContains(ObjectRepository.value_307, discountTotal);
	basic.validateContains(ObjectRepository.value_308, marginProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_309, marginTss);
	}
	basic.validateContains(ObjectRepository.value_310, marginTotal);
	basic.scrollIntoView(ObjectRepository.value_311);
	basic.validateIfPresent(ObjectRepository.value_313);
	}

	
	@Test
	public static void _01MyDHPge_TC07_Verify_Executive_summary_for_global_deal() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	m.advanceSearchDealID("25617167", null, "GPN");
	basic.pause(8000);
	String productDD = basic.getText(ObjectRepository.value_273);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.scrollIntoView(ObjectRepository.value_275);
	String country = basic.getText(ObjectRepository.value_275);
	basic.scrollIntoView(ObjectRepository.value_276);
	String optyName = basic.getText(ObjectRepository.value_276);
	String optyOwner = basic.getText(ObjectRepository.value_277);
	String accName = basic.getText(ObjectRepository.value_278);
	String recentSubmission = basic.getText(ObjectRepository.value_279);
	basic.scrollIntoView(ObjectRepository.value_280);
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.scrollIntoView(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_281);
	basic.click(ObjectRepository.value_12);
	String netProduct = basic.getText(ObjectRepository.value_282);
	String netTss = basic.getText(ObjectRepository.value_283);
	String netTotal = basic.getText(ObjectRepository.value_284);
	String discountProduct = basic.getText(ObjectRepository.value_285);
	String discountTss = basic.getText(ObjectRepository.value_286);
	String discountTotal = basic.getText(ObjectRepository.value_287);
	String marginProduct = basic.getText(ObjectRepository.value_288);
	String marginTss = basic.getText(ObjectRepository.value_289);
	String marginTotal = basic.getText(ObjectRepository.value_290);
	basic.click(ObjectRepository.value_291);
	basic.click(ObjectRepository.value_292);
	basic.validate(ObjectRepository.value_293, "Executive Summary");
	basic.validateContains(ObjectRepository.value_294, productDD);
	basic.validateContains(ObjectRepository.value_295, serviceDD);
	basic.validateContains(ObjectRepository.value_296, country);
	basic.validate(ObjectRepository.value_297, optyName);
	basic.validate(ObjectRepository.value_298, optyOwner);
	basic.validateIfPresent(ObjectRepository.value_299);
	basic.validate(ObjectRepository.value_300, accName);
	basic.scrollIntoView(ObjectRepository.value_301);
	basic.validateContains(ObjectRepository.value_301, netProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_303, netTss);
	}
	basic.validateContains(ObjectRepository.value_304, netTotal);
	basic.validateContains(ObjectRepository.value_305, discountProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_306, discountTss);
	}
	basic.validateContains(ObjectRepository.value_307, discountTotal);
	basic.validateContains(ObjectRepository.value_308, marginProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_309, marginTss);
	}
	basic.validateContains(ObjectRepository.value_310, marginTotal);
	}

	
	@Test
	public static void _01MyDHPge_TC08_Verify_Executive_summary_for_RNSD_deal() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	m.advanceSearchDealID("61001579", null, "RNSD");
	
	basic.pause(8000);
	String productDD = basic.getText(ObjectRepository.value_273);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.scrollIntoView(ObjectRepository.value_275);
	String country = basic.getText(ObjectRepository.value_275);
	basic.scrollIntoView(ObjectRepository.value_276);
	String optyName = basic.getText(ObjectRepository.value_276);
	String optyOwner = basic.getText(ObjectRepository.value_277);
	String accName = basic.getText(ObjectRepository.value_278);
	String recentSubmission = basic.getText(ObjectRepository.value_279);
	basic.scrollIntoView(ObjectRepository.value_280);
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.scrollIntoView(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_281);
	basic.click(ObjectRepository.value_12);
	String netProduct = basic.getText(ObjectRepository.value_282);
	String netTss = basic.getText(ObjectRepository.value_283);
	String netTotal = basic.getText(ObjectRepository.value_284);
	String discountProduct = basic.getText(ObjectRepository.value_285);
	String discountTss = basic.getText(ObjectRepository.value_286);
	String discountTotal = basic.getText(ObjectRepository.value_287);
	String marginProduct = basic.getText(ObjectRepository.value_288);
	String marginTss = basic.getText(ObjectRepository.value_289);
	String marginTotal = basic.getText(ObjectRepository.value_290);
	basic.click(ObjectRepository.value_291);
	basic.click(ObjectRepository.value_292);
	basic.validate(ObjectRepository.value_293, "Executive Summary");
	basic.validateContains(ObjectRepository.value_294, productDD);
	basic.validateContains(ObjectRepository.value_295, serviceDD);
	basic.validateContains(ObjectRepository.value_296, country);
	basic.validate(ObjectRepository.value_297, optyName);
	basic.validate(ObjectRepository.value_298, optyOwner);
	basic.validateIfPresent(ObjectRepository.value_299);
	basic.validate(ObjectRepository.value_300, accName);
	basic.scrollIntoView(ObjectRepository.value_301);
	basic.validateContains(ObjectRepository.value_301, netProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_303, netTss);
	}
	basic.validateContains(ObjectRepository.value_304, netTotal);
	basic.validateContains(ObjectRepository.value_305, discountProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_306, discountTss);
	}
	basic.validateContains(ObjectRepository.value_307, discountTotal);
	basic.validateContains(ObjectRepository.value_308, marginProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_309, marginTss);
	}
	basic.validateContains(ObjectRepository.value_310, marginTotal);
	basic.scrollIntoView(ObjectRepository.value_311);
	basic.validate(ObjectRepository.value_311, "61001579");
	}

	
	@Test
	public static void _01MyDHPge_TC09_Verify_Export_functionality_on_executive_summary() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	m.advanceSearchDealID("61001374");
	
	basic.pause(8000);
	String productDD = basic.getText(ObjectRepository.value_273);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.scrollIntoView(ObjectRepository.value_275);
	String country = basic.getText(ObjectRepository.value_275);
	basic.scrollIntoView(ObjectRepository.value_276);
	String optyName = basic.getText(ObjectRepository.value_276);
	String optyOwner = basic.getText(ObjectRepository.value_277);
	String accName = basic.getText(ObjectRepository.value_278);
	String recentSubmission = basic.getText(ObjectRepository.value_279);
	basic.scrollIntoView(ObjectRepository.value_280);
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.scrollIntoView(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_281);
	basic.click(ObjectRepository.value_12);
	String netProduct = basic.getText(ObjectRepository.value_282);
	String netTss = basic.getText(ObjectRepository.value_283);
	String netTotal = basic.getText(ObjectRepository.value_284);
	String discountProduct = basic.getText(ObjectRepository.value_285);
	String discountTss = basic.getText(ObjectRepository.value_286);
	String discountTotal = basic.getText(ObjectRepository.value_287);
	String marginProduct = basic.getText(ObjectRepository.value_288);
	String marginTss = basic.getText(ObjectRepository.value_289);
	String marginTotal = basic.getText(ObjectRepository.value_290);
	basic.click(ObjectRepository.value_291);
	basic.click(ObjectRepository.value_292);
	basic.validate(ObjectRepository.value_293, "Executive Summary");
	basic.validateContains(ObjectRepository.value_294, productDD);
	basic.validateContains(ObjectRepository.value_295, serviceDD);
	basic.validateContains(ObjectRepository.value_296, country);
	basic.validate(ObjectRepository.value_297, optyName);
	basic.validate(ObjectRepository.value_298, optyOwner);
	basic.validateIfPresent(ObjectRepository.value_299);
	basic.validate(ObjectRepository.value_300, accName);
	basic.scrollIntoView(ObjectRepository.value_301);
	basic.validateContains(ObjectRepository.value_301, netProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_303, netTss);
	}
	basic.validateContains(ObjectRepository.value_304, netTotal);
	basic.validateContains(ObjectRepository.value_305, discountProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_306, discountTss);
	}
	basic.validateContains(ObjectRepository.value_307, discountTotal);
	basic.validateContains(ObjectRepository.value_308, marginProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_309, marginTss);
	}
	basic.validateContains(ObjectRepository.value_310, marginTotal);
	basic.scrollIntoView(ObjectRepository.value_311);
	basic.validate(ObjectRepository.value_311, "61001374");
	basic.click(ObjectRepository.value_315);
	}

	
	@Test
	public static void _01MyDHPge_TC10_Verify_export_functionality_for_advanced_search() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("ngazaleh");
	m.advanceSearchDealID("61000223");

	String productDD = basic.getText(ObjectRepository.value_273);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.scrollIntoView(ObjectRepository.value_275);
	String country = basic.getText(ObjectRepository.value_275);
	basic.scrollIntoView(ObjectRepository.value_276);
	String optyName = basic.getText(ObjectRepository.value_276);
	String optyOwner = basic.getText(ObjectRepository.value_277);
	String accName = basic.getText(ObjectRepository.value_278);
	String recentSubmission = basic.getText(ObjectRepository.value_279);
	basic.scrollIntoView(ObjectRepository.value_280);
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.scrollIntoView(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.dealID_link);
	basic.click(ObjectRepository.value_281);
	basic.click(ObjectRepository.value_12);
	String netProduct = basic.getText(ObjectRepository.value_282);
	String netTss = basic.getText(ObjectRepository.value_283);
	String netTotal = basic.getText(ObjectRepository.value_284);
	String discountProduct = basic.getText(ObjectRepository.value_285);
	String discountTss = basic.getText(ObjectRepository.value_286);
	String discountTotal = basic.getText(ObjectRepository.value_287);
	String marginProduct = basic.getText(ObjectRepository.value_288);
	String marginTss = basic.getText(ObjectRepository.value_289);
	String marginTotal = basic.getText(ObjectRepository.value_290);
	basic.click(ObjectRepository.value_291);
	basic.click(ObjectRepository.value_292);
	basic.validate(ObjectRepository.value_293, "Executive Summary");
	basic.validateContains(ObjectRepository.value_294, productDD);
	basic.validateContains(ObjectRepository.value_295, serviceDD);
	basic.validateContains(ObjectRepository.value_296, country);
	basic.validate(ObjectRepository.value_297, optyName);
	basic.validate(ObjectRepository.value_298, optyOwner);
	basic.validateIfPresent(ObjectRepository.value_299);
	basic.validate(ObjectRepository.value_300, accName);
	basic.scrollIntoView(ObjectRepository.value_301);
	basic.validateContains(ObjectRepository.value_301, netProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_303, netTss);
	}
	basic.validateContains(ObjectRepository.value_304, netTotal);
	basic.validateContains(ObjectRepository.value_305, discountProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_306, discountTss);
	}
	basic.validateContains(ObjectRepository.value_307, discountTotal);
	basic.validateContains(ObjectRepository.value_308, marginProduct);
	if(basic.ifLogic(ObjectRepository.value_302, "TSS-Core"))
	{
	basic.validateContains(ObjectRepository.value_309, marginTss);
	}
	basic.validateContains(ObjectRepository.value_310, marginTotal);
	basic.scrollIntoView(ObjectRepository.value_311);
	basic.validate(ObjectRepository.value_311, "61000223");
	}

	
	@Test
	public static void _01MyDHPge_TC11_Verify_Deal_search_using_change_in_PDQ() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	basic.selectOption(ObjectRepository.value_2, "Approved");
	basic.click(ObjectRepository.value_292);
	basic.click(ObjectRepository.value_316);
	basic.validateContains(ObjectRepository.value_317, "Approved");
	basic.selectOption(ObjectRepository.value_318, "Deals Desk Engaged");
	basic.click(ObjectRepository.value_292);
	basic.click(ObjectRepository.value_316);
	basic.validateContains(ObjectRepository.value_317, "Deals Desk Engaged");
	}

	
	@Test
	public static void _01MyDHPge_TC12_Verify_Deal_search_using_advanced_search_by_giving_one_option() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	m.advanceSearchDealID(null, "Transactional", null);
	basic.validateContains(ObjectRepository.value_319, "Transactional");
	basic.validateContains(ObjectRepository.value_320, "Transactional");
	basic.click(ObjectRepository.advancedSearch_link);
	basic.selectOption(ObjectRepository.value_314, "RNSD");
	basic.click(ObjectRepository.advancedSearch_button);
	basic.validateContains(ObjectRepository.value_319, "RNSD");
	basic.validateContains(ObjectRepository.value_320, "RNSD");
	basic.click(ObjectRepository.advancedSearch_link);
	basic.selectOption(ObjectRepository.value_314, "GPN");
	basic.click(ObjectRepository.advancedSearch_button);
	basic.validateContains(ObjectRepository.value_319, "GPN");
	basic.validateContains(ObjectRepository.value_320, "GPN");
	}

	
	@Test
	public static void _01MyDHPge_TC14_Verify_Pagination_on_My_deals_home_page() throws Exception
	{
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("duabhish");
		basic.validateIfPresent(ObjectRepository.value_2);
		if(basic.ifLogic(ObjectRepository.value_321, "of"))
		{
			String DealID = basic.getText(ObjectRepository.dealID_link);
			basic.click(ObjectRepository.value_322);
			basic.pause(2000);
			basic.validateDoesNotContain(ObjectRepository.dealID_link, DealID);
			basic.click(ObjectRepository.value_323);
			basic.pause(2000);
			basic.validateContains(ObjectRepository.dealID_link, DealID);
			basic.click(ObjectRepository.value_322);
			basic.pause(2000);
			basic.validateDoesNotContain(ObjectRepository.dealID_link, DealID);
			basic.click(ObjectRepository.value_324);
			basic.pause(2000);
			basic.validateContains(ObjectRepository.dealID_link, DealID);
			basic.click(ObjectRepository.value_325);
			basic.pause(2000);
			basic.validateDoesNotContain(ObjectRepository.dealID_link, DealID);
			String DealID1 = basic.getText(ObjectRepository.dealID_link);
			basic.click(ObjectRepository.value_324);
			basic.pause(2000);
			basic.validateDoesNotContain(ObjectRepository.dealID_link, DealID1);
			basic.click(ObjectRepository.value_322);
			basic.pause(2000);
			basic.validateContains(ObjectRepository.dealID_link, DealID1);
		}
	}

	@Test
	public static void _01MyDHPge_TC15_Verify_change_in_number_of_records_on_my_deals_home_page() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	basic.validateIfPresent(ObjectRepository.value_2);
	basic.selectOption(ObjectRepository.value_326, "15");
	basic.pause(2000);
	basic.validateIfPresent(ObjectRepository.value_327);
	basic.click(ObjectRepository.value_322);
	basic.pause(2000);
	basic.validateIfPresent(ObjectRepository.value_327);
	basic.click(ObjectRepository.value_322);
	basic.pause(2000);
	basic.validateIfPresent(ObjectRepository.value_327);
	basic.click(ObjectRepository.value_322);
	basic.pause(2000);
	basic.validateIfPresent(ObjectRepository.value_327);
	basic.click(ObjectRepository.value_325);
	basic.pause(2000);
	basic.click(ObjectRepository.value_324);
	basic.pause(2000);
	basic.validateIfPresent(ObjectRepository.value_327);
	}

	
	@Test
	public static void _01MyDHPge_TC16_Verify_Sorting_on_My_deals_home_page() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("duabhish");
	basic.validateIfPresent(ObjectRepository.value_2);
	basic.scrollIntoView(ObjectRepository.value_328);
	basic.click(ObjectRepository.value_328);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_317);
	String DealStatus = basic.getText(ObjectRepository.value_317);
	basic.click(ObjectRepository.value_328);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_317);
	basic.validateDoesNotContain(ObjectRepository.value_317, DealStatus);
	basic.scrollIntoView(ObjectRepository.value_329);
	basic.click(ObjectRepository.value_329);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_276);
	String OptyName = basic.getText(ObjectRepository.value_276);
	basic.click(ObjectRepository.value_329);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_276);
	basic.validateDoesNotContain(ObjectRepository.value_276, OptyName);
	basic.scrollIntoView(ObjectRepository.value_330);
	basic.click(ObjectRepository.value_330);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_319);
	String dealType = basic.getText(ObjectRepository.value_319);
	basic.click(ObjectRepository.value_330);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_319);
	basic.validateDoesNotContain(ObjectRepository.value_319, dealType);
	basic.scrollIntoView(ObjectRepository.value_331);
	basic.click(ObjectRepository.value_331);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_332);
	String dealListPrice = basic.getText(ObjectRepository.value_332);
	basic.click(ObjectRepository.value_331);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_332);
	basic.validateDoesNotContain(ObjectRepository.value_332, dealListPrice);
	basic.scrollIntoView(ObjectRepository.value_331);
	basic.click(ObjectRepository.value_331);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_332);
	
	basic.scrollIntoView(ObjectRepository.value_280);
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.click(ObjectRepository.value_333);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_280);
	basic.validateDoesNotContain(ObjectRepository.value_280, dealNetPrice);
	basic.scrollIntoView(ObjectRepository.value_334);
	basic.click(ObjectRepository.value_334);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_274);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.click(ObjectRepository.value_334);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_274);
	basic.validateDoesNotContain(ObjectRepository.value_274, serviceDD);
	basic.scrollIntoView(ObjectRepository.value_335);
	basic.click(ObjectRepository.value_335);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_273);
	String productDD = basic.getText(ObjectRepository.value_273);
	basic.click(ObjectRepository.value_335);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_273);
	basic.validateDoesNotContain(ObjectRepository.value_273, productDD);
	basic.scrollIntoView(ObjectRepository.value_336);
	basic.click(ObjectRepository.value_336);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_337);
	String optyOwner = basic.getText(ObjectRepository.value_337);
	basic.click(ObjectRepository.value_336);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_337);
	basic.validateDoesNotContain(ObjectRepository.value_337, optyOwner);
	basic.scrollIntoView(ObjectRepository.value_338);
	basic.click(ObjectRepository.value_338);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_339);
	String expireDate = basic.getText(ObjectRepository.value_339);
	basic.click(ObjectRepository.value_338);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_339);
	basic.validateDoesNotContain(ObjectRepository.value_339, expireDate);
	basic.scrollIntoView(ObjectRepository.value_340);
	basic.click(ObjectRepository.value_340);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_341);
	String accName = basic.getText(ObjectRepository.value_341);
	basic.click(ObjectRepository.value_340);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_341);
	basic.validateDoesNotContain(ObjectRepository.value_341, accName);
	basic.scrollIntoView(ObjectRepository.value_342);
	basic.click(ObjectRepository.value_342);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_343);
	String recentSubmission = basic.getText(ObjectRepository.value_343);
	basic.click(ObjectRepository.value_342);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_343);
	basic.validateDoesNotContain(ObjectRepository.value_343, recentSubmission);
	basic.scrollIntoView(ObjectRepository.value_344);
	basic.click(ObjectRepository.value_344);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_345);
	String multiQuote = basic.getText(ObjectRepository.value_345);
	basic.click(ObjectRepository.value_344);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_345);
	basic.validateDoesNotContain(ObjectRepository.value_345, multiQuote);
	basic.scrollIntoView(ObjectRepository.value_346);
	basic.click(ObjectRepository.value_346);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_347);
	String area = basic.getText(ObjectRepository.value_347);
	basic.click(ObjectRepository.value_346);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_347);
	basic.validateDoesNotContain(ObjectRepository.value_347, area);
	basic.scrollIntoView(ObjectRepository.value_348);
	basic.click(ObjectRepository.value_348);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_349);
	String country = basic.getText(ObjectRepository.value_349);
	basic.click(ObjectRepository.value_348);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_349);
	basic.validateDoesNotContain(ObjectRepository.value_349, country);
	}

	
	@Test
	public static void _01MyDHPge_TC17_Verify_sorting_when_logged_in_as_proxy_user() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("mbanchi");
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_351);
	basic.scrollIntoView(ObjectRepository.value_352);
	basic.ngclick(ObjectRepository.value_352);
	basic.click(ObjectRepository.value_353);
	basic.pause(8000);
	basic.scrollIntoView(ObjectRepository.value_328);
	basic.click(ObjectRepository.value_328);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String DealStatus = basic.getText(ObjectRepository.value_317);
	basic.click(ObjectRepository.value_328);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_329);
	basic.click(ObjectRepository.value_329);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String OptyName = basic.getText(ObjectRepository.value_276);
	basic.click(ObjectRepository.value_329);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_317, OptyName);
	basic.scrollIntoView(ObjectRepository.value_330);
	basic.click(ObjectRepository.value_330);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String dealType = basic.getText(ObjectRepository.value_319);
	basic.click(ObjectRepository.value_330);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_331);
	basic.click(ObjectRepository.value_331);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String dealListPrice = basic.getText(ObjectRepository.value_332);
	basic.click(ObjectRepository.value_331);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_332, dealListPrice);
	basic.scrollIntoView(ObjectRepository.value_331);
	basic.click(ObjectRepository.value_331);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	
	String dealNetPrice = basic.getText(ObjectRepository.value_280);
	basic.click(ObjectRepository.value_333);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_280, dealNetPrice);
	basic.scrollIntoView(ObjectRepository.value_334);
	basic.click(ObjectRepository.value_334);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String serviceDD = basic.getText(ObjectRepository.value_274);
	basic.click(ObjectRepository.value_334);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.scrollIntoView(ObjectRepository.value_335);
	basic.click(ObjectRepository.value_335);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String productDD = basic.getText(ObjectRepository.value_273);
	basic.click(ObjectRepository.value_335);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_273, productDD);
	basic.scrollIntoView(ObjectRepository.value_336);
	basic.click(ObjectRepository.value_336);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String optyOwner = basic.getText(ObjectRepository.value_337);
	basic.click(ObjectRepository.value_336);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_337, optyOwner);
	basic.scrollIntoView(ObjectRepository.value_338);
	basic.click(ObjectRepository.value_338);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String expireDate = basic.getText(ObjectRepository.value_339);
	basic.click(ObjectRepository.value_338);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_339, expireDate);
	basic.scrollIntoView(ObjectRepository.value_340);
	basic.click(ObjectRepository.value_340);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String accName = basic.getText(ObjectRepository.value_341);
	basic.click(ObjectRepository.value_340);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_341, accName);
	basic.scrollIntoView(ObjectRepository.value_342);
	basic.click(ObjectRepository.value_342);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String recentSubmission = basic.getText(ObjectRepository.value_343);
	basic.click(ObjectRepository.value_342);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_343, recentSubmission);
	basic.scrollIntoView(ObjectRepository.value_344);
	basic.click(ObjectRepository.value_344);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String multiQuote = basic.getText(ObjectRepository.value_345);
	basic.click(ObjectRepository.value_344);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_345, multiQuote);
	basic.scrollIntoView(ObjectRepository.value_346);
	basic.click(ObjectRepository.value_346);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String area = basic.getText(ObjectRepository.value_347);
	basic.click(ObjectRepository.value_346);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_347, area);
	basic.scrollIntoView(ObjectRepository.value_348);
	basic.click(ObjectRepository.value_348);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	String country = basic.getText(ObjectRepository.value_349);
	basic.click(ObjectRepository.value_348);
	basic.pause(1000);
	basic.waitForElementClickable(ObjectRepository.advancedSearch_link);
	basic.validateDoesNotContain(ObjectRepository.value_349, country);
	}

	
	@Test
	public static void _01MyDHPge_TC18_Edit_deal_from_MyDealsHomepage() throws Exception
	{
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		m.ngmdmLogin("duabhish");
		m.advanceSearchDealID("61001375");
		basic.click(ObjectRepository.value_354);
		basic.typeTextAutopopulate(ObjectRepository.value_355, "PJOHNSO3");
		basic.typeTextAutopopulate(ObjectRepository.value_356, "PJOHNSO3");
		basic.click(ObjectRepository.value_357);
		basic.pause(5000);
		basic.waitForElementDisappear(ObjectRepository.value_358);
		basic.waitForElementClickable(ObjectRepository.value_354);
		basic.scrollIntoView(ObjectRepository.value_274);
		basic.pause(60000);
		basic.click(ObjectRepository.advancedSearch_link);
		basic.typeText(ObjectRepository.dealID_textbox, "61001375");
		basic.click(ObjectRepository.advancedSearch_button);
		basic.validateContains(ObjectRepository.value_274, "PJOHNSO3");
		basic.scrollIntoView(ObjectRepository.value_273);
		basic.validateContains(ObjectRepository.value_273, "PJOHNSO3");
		basic.click(ObjectRepository.advancedSearch_link);
		basic.typeText(ObjectRepository.dealID_textbox, "61001375");
		basic.click(ObjectRepository.advancedSearch_button);
		basic.click(ObjectRepository.value_354);
		basic.typeTextAutopopulate(ObjectRepository.value_355, "MAMANIK");
		basic.typeTextAutopopulate(ObjectRepository.value_356, "MAMANIK");
		basic.click(ObjectRepository.value_357);
		basic.pause(10000);
		basic.waitForElementDisappear(ObjectRepository.value_358);
		basic.waitForElementClickable(ObjectRepository.value_354);
		basic.scrollIntoView(ObjectRepository.value_274);
		basic.pause(60000);
		basic.click(ObjectRepository.advancedSearch_link);
		basic.typeText(ObjectRepository.dealID_textbox, "61001375");
		basic.click(ObjectRepository.advancedSearch_button);
		basic.validateContains(ObjectRepository.value_274, "MAMANIK");
		basic.scrollIntoView(ObjectRepository.value_273);
		basic.validateContains(ObjectRepository.value_273, "MAMANIK");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	LaunchBrowsers launchBrowsers; 
	Modules commonFunctions;
	BasicCommands basic;
	Connection con;
	Statement stmt;
	ResultSet rset;
		
	@BeforeTest
	public void beforeTest() throws Exception
	{
		System.out.println("Before Test");
		launchBrowsers = new LaunchBrowsers();
		basic = new BasicCommands(); 
		commonFunctions = new Modules();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb", "sys as sysdba", "amiitonoma07");
		stmt = con.createStatement();
	}
	
	public ResultSet getResultSet(String tabno, String testcaseno) throws Exception
	{
		return stmt.executeQuery("select * from ngmdm_data where tabno='"+tabno+"' and testcaseno='"+testcaseno+"'");
	}
	
	
	@Test
	public void test1() throws Exception
	{
		System.out.println("Test1");
		ResultSet rset = getResultSet("03","16");
		System.out.println(rset.getString("testcasename"));
		System.exit(0);
		
		WebDriver driver = launchBrowsers.launchBrowser("chrome");
		commonFunctions.mdmLogin(driver, ObjectRepository.duabhish);
		commonFunctions.openDealID(driver, "61000156");
		
	}
	
	@AfterTest
	public void afterTest() throws Exception
	{
		System.out.println("After Test");
	}*/
}
