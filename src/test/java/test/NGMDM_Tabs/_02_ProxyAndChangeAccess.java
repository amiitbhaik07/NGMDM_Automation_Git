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
import test.BasicUtils.ObjectRepository;

public class _02_ProxyAndChangeAccess 
{
	@Test
	public static void _02PnChAc_TC01_Verify_by_logging_in_as_Approver() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "mbanchi");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.validateIfNotPresent(ObjectRepository.value_354);
	basic.validateIfPresent(ObjectRepository.value_292);
	basic.validateIfPresent(ObjectRepository.value_271);
	basic.validateIfPresent(ObjectRepository.value_359);
	basic.click(ObjectRepository.value_359);
	basic.validateIfPresent(ObjectRepository.value_360);
	basic.validateIfPresent(ObjectRepository.value_361);
	basic.click(ObjectRepository.value_362);
	basic.click(ObjectRepository.value_292);
	basic.validateContains(ObjectRepository.value_293, "Executive Summary");
	basic.validateIfPresent(ObjectRepository.value_294);
	basic.validateIfPresent(ObjectRepository.value_295);
	basic.validateIfPresent(ObjectRepository.value_311);
	basic.validateIfPresent(ObjectRepository.value_296);
	basic.validateIfPresent(ObjectRepository.value_297);
	basic.validateIfPresent(ObjectRepository.value_298);
	basic.validateIfPresent(ObjectRepository.value_363);
	basic.validateIfPresent(ObjectRepository.value_364);
	basic.validateIfPresent(ObjectRepository.value_300);
	basic.validateIfPresent(ObjectRepository.value_365);
	basic.validateIfPresent(ObjectRepository.value_366);
	basic.validateIfPresent(ObjectRepository.value_367);
	basic.validateIfPresent(ObjectRepository.value_304);
	basic.validateIfPresent(ObjectRepository.value_307);
	basic.validateIfPresent(ObjectRepository.value_310);
	}
	
	
	@Test
	public static void _02PnChAc_TC02_Verify_by_logging_in_as_Assuror() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
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
	basic.validateIfPresent(ObjectRepository.value_272);
	basic.click(ObjectRepository.advancedSearch_link);
	basic.typeText(ObjectRepository.dealID_textbox, "61003278");
	basic.click(ObjectRepository.advancedSearch_button);
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
	basic.click(ObjectRepository.value_315);
	}

	
	@Test
	public static void _02PnChAc_TC03_Verify_by__logging_in_as_RM() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "mbanchi");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.validateIfNotPresent(ObjectRepository.value_354);
	basic.validateIfPresent(ObjectRepository.value_292);
	basic.validateIfPresent(ObjectRepository.value_271);
	basic.validateIfPresent(ObjectRepository.value_359);
	basic.click(ObjectRepository.value_359);
	basic.validateIfPresent(ObjectRepository.value_360);
	basic.validateIfPresent(ObjectRepository.value_361);
	basic.click(ObjectRepository.value_362);
	basic.click(ObjectRepository.value_292);
	basic.validateContains(ObjectRepository.value_293, "Executive Summary");
	basic.validateIfPresent(ObjectRepository.value_294);
	basic.validateIfPresent(ObjectRepository.value_295);
	basic.validateIfPresent(ObjectRepository.value_311);
	basic.validateIfPresent(ObjectRepository.value_296);
	basic.validateIfPresent(ObjectRepository.value_297);
	basic.validateIfPresent(ObjectRepository.value_298);
	basic.validateIfPresent(ObjectRepository.value_363);
	basic.validateIfPresent(ObjectRepository.value_364);
	basic.validateIfPresent(ObjectRepository.value_300);
	basic.validateIfPresent(ObjectRepository.value_365);
	basic.validateIfPresent(ObjectRepository.value_366);
	basic.validateIfPresent(ObjectRepository.value_367);
	basic.validateIfPresent(ObjectRepository.value_304);
	basic.validateIfPresent(ObjectRepository.value_307);
	basic.validateIfPresent(ObjectRepository.value_310);
	}

	
	@Test
	public static void _02PnChAc_TC04_Verify_by__logging_in_as_Functional_group_lead() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
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
	basic.validateIfPresent(ObjectRepository.value_272);
	basic.click(ObjectRepository.advancedSearch_link);
	basic.typeText(ObjectRepository.dealID_textbox, "61003278");
	basic.click(ObjectRepository.advancedSearch_button);
	basic.click(ObjectRepository.value_292);
	basic.validateContains(ObjectRepository.value_293, "Executive Summary");
	basic.validateContains(ObjectRepository.value_294, "MUTHULAKSHMI G(MUTHGANA)");
	basic.validateContains(ObjectRepository.value_295, "MUTHULAKSHMI G(MUTHGANA)");
	basic.validate(ObjectRepository.value_311, "61003278");
	basic.validateContains(ObjectRepository.value_296, "UNITED KINGDOM");
	basic.validateContains(ObjectRepository.value_297, "NGMDM_DNT");
	basic.validateContains(ObjectRepository.value_298, "BEN HEARD");
	basic.validateContains(ObjectRepository.value_363, "Global Price List EMEA Availability");
	basic.validateContains(ObjectRepository.value_300, "ACCIDENT EXCHANGE GROUP PLC");
	basic.validateContains(ObjectRepository.value_365, "26-Jul-2017");
	basic.validateContains(ObjectRepository.value_367, "201");
	basic.click(ObjectRepository.value_304);
	basic.validateContains(ObjectRepository.value_304, ".");
	basic.validateContains(ObjectRepository.value_307, ".");
	basic.validateContains(ObjectRepository.value_310, ".");
	basic.click(ObjectRepository.value_315);
	}

	
	@Test
	public static void _02PnChAc_TC05_Verify_by__logging_in_as_DDA() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "pauclark");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.validateIfPresent(ObjectRepository.value_354);
	basic.validateIfPresent(ObjectRepository.value_2);
	basic.click(ObjectRepository.value_354);
	basic.validateIfPresent(ObjectRepository.value_368);
	basic.validateIfPresent(ObjectRepository.value_369);
	basic.validateIfPresent(ObjectRepository.value_356);
	basic.validateIfPresent(ObjectRepository.value_355);
	basic.validateIfPresent(ObjectRepository.value_370);
	basic.validateIfPresent(ObjectRepository.value_371);
	basic.validateIfPresent(ObjectRepository.value_372);
	basic.validateIfPresent(ObjectRepository.value_373);
	basic.validateIfPresent(ObjectRepository.value_374);
	basic.validateIfPresent(ObjectRepository.value_375);
	basic.validateIfPresent(ObjectRepository.value_376);
	basic.validateIfPresent(ObjectRepository.value_377);
	basic.validateIfPresent(ObjectRepository.value_378);
	basic.click(ObjectRepository.value_379);
	}

	
	@Test
	public static void _02PnChAc_TC06_Verify_by__logging_in_as_DDA_admin() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
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
	basic.validateIfPresent(ObjectRepository.value_354);
	basic.validateIfPresent(ObjectRepository.value_2);
	basic.click(ObjectRepository.value_354);
	basic.validateIfPresent(ObjectRepository.value_368);
	basic.validateIfPresent(ObjectRepository.value_369);
	basic.validateIfPresent(ObjectRepository.value_356);
	basic.validateIfPresent(ObjectRepository.value_355);
	basic.validateIfPresent(ObjectRepository.value_370);
	basic.validateIfPresent(ObjectRepository.value_371);
	basic.validateIfPresent(ObjectRepository.value_372);
	basic.validateIfPresent(ObjectRepository.value_373);
	basic.validateIfPresent(ObjectRepository.value_374);
	basic.validateIfPresent(ObjectRepository.value_375);
	basic.validateIfPresent(ObjectRepository.value_376);
	basic.validateIfPresent(ObjectRepository.value_377);
	basic.validateIfPresent(ObjectRepository.value_378);
	basic.click(ObjectRepository.value_379);
	basic.click(ObjectRepository.value_292);
	basic.validateIfPresent(ObjectRepository.value_294);
	basic.validateIfPresent(ObjectRepository.value_295);
	basic.validateIfPresent(ObjectRepository.value_311);
	basic.validateIfPresent(ObjectRepository.value_296);
	basic.validateIfPresent(ObjectRepository.value_297);
	basic.validateIfPresent(ObjectRepository.value_298);
	basic.validateIfPresent(ObjectRepository.value_363);
	basic.validateIfPresent(ObjectRepository.value_364);
	basic.validateIfPresent(ObjectRepository.value_300);
	basic.validateIfPresent(ObjectRepository.value_365);
	basic.validateIfPresent(ObjectRepository.value_366);
	basic.validateIfPresent(ObjectRepository.value_367);
	basic.validateIfPresent(ObjectRepository.value_304);
	basic.validateIfPresent(ObjectRepository.value_307);
	basic.validateIfPresent(ObjectRepository.value_310);
	}

	
	@Test
	public static void _02PnChAc_TC07_Verify_add_proxy_functionality_by_providing_all_valid_inputs() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "alicwan2");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.click(ObjectRepository.value_380);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.click(ObjectRepository.value_382);
	basic.selectOption(ObjectRepository.value_383, "GLOBAL SERVICE PROVIDER");
	basic.pause(5000);
	basic.selectOption(ObjectRepository.value_384, "Regional Manager");
	basic.typeText(ObjectRepository.value_385, "mbanchi");
	basic.click(ObjectRepository.value_386);
	basic.click(ObjectRepository.value_387);
	basic.pause(3000);
	if(basic.ifLogic(ObjectRepository.value_388, "A proxy is already assigned."))
	{
	basic.click(ObjectRepository.value_389);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.waitForElementVisible(ObjectRepository.value_382);
	}
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.validateIfPresent(ObjectRepository.value_390);
	basic.click(ObjectRepository.value_390);
	basic.click(ObjectRepository.value_391);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	String Date = basic.getText(ObjectRepository.value_395);
	basic.validateContains(ObjectRepository.value_396, Date);
	}

	
	@Test
	//public static void _02PnChAc_TC08_Verify_search_using_Proxy_user() throws Exception
	public static void main(String args[]) throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	m.ngmdmLogin("pauclark");
	basic.selectOption(ObjectRepository.value_397, "Active Deals - All");
	basic.pause(3000);
	String randomDealID = basic.getText(ObjectRepository.value_398);
	basic.click(ObjectRepository.value_380);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	if(basic.ifLogic(ObjectRepository.value_399, "GLOBAL SERVICE PROVIDER"))
	{
	basic.click(ObjectRepository.value_400);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	}
	basic.pause(3000);
	if(basic.ifLogic(ObjectRepository.value_399, "GLOBAL SERVICE PROVIDER"))
	{
	basic.click(ObjectRepository.value_402);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.calenderNextMonth);
	basic.click(ObjectRepository.value_403);
	basic.click(ObjectRepository.value_387);
	}
	else
	{
	basic.click(ObjectRepository.value_382);
	basic.selectOption(ObjectRepository.value_383, "GLOBAL SERVICE PROVIDER");
	basic.selectOption(ObjectRepository.value_384, "Regional Manager");
	basic.typeTextAutopopulate(ObjectRepository.value_385, "mbanchi");
	basic.click(ObjectRepository.value_387);
	}
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.validateIfPresent(ObjectRepository.value_400);
	basic.pause(60000);
	m.ngmdmLogin("mbanchi");
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_351);
	basic.scrollIntoView(ObjectRepository.value_352);
	basic.ngclick(ObjectRepository.value_352);
	basic.click(ObjectRepository.value_353);
	basic.pause(5000);
	basic.validateContains(ObjectRepository.value_404, "PAUL CLARK");
	basic.click(ObjectRepository.advancedSearch_link);
	basic.typeText(ObjectRepository.dealID_textbox, randomDealID);
	basic.click(ObjectRepository.advancedSearch_button);
	basic.validateIfPresent(ObjectRepository.dealID_link);
	m.ngmdmLogin("pauclark");
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.click(ObjectRepository.value_391);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	String Date = basic.getText(ObjectRepository.value_395);
	basic.validateContains(ObjectRepository.value_396, Date);
	}

	
	@Test
	public static void _02PnChAc_TC09_Edit_end_date_of_exsiting_proxy() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "ALICWAN2");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.click(ObjectRepository.value_380);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	while(basic.isElementPresent(ObjectRepository.value_405))
	{
	basic.click(ObjectRepository.value_405);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	basic.pause(15000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	}
	if(basic.ifLogic(ObjectRepository.value_406, "ALICE WANG"))
	{
	}
	else
	{
	basic.click(ObjectRepository.value_382);
	basic.selectOption(ObjectRepository.value_383, "GLOBAL SERVICE PROVIDER");
	basic.selectOption(ObjectRepository.value_384, "Regional Manager");
	basic.typeText(ObjectRepository.value_385, "ALAMER");
	basic.click(ObjectRepository.value_386);
	basic.pause(5000);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	basic.pause(5000);
	}
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.validateIfPresent(ObjectRepository.value_407);
	basic.validateIfPresent(ObjectRepository.value_408);
	basic.click(ObjectRepository.value_409);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.calenderNextMonth);
	basic.click(ObjectRepository.value_410);
	basic.click(ObjectRepository.value_387);
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.validateIfPresent(ObjectRepository.value_411);
	basic.click(ObjectRepository.value_409);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	String OldEndDate = basic.getText(ObjectRepository.value_412);
	basic.validateContains(ObjectRepository.value_413, OldEndDate);
	}

	
	@Test
	public static void _02PnChAc_TC10_Verify_if_DDA_is_able_to_give_access() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "alicwan2");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.click(ObjectRepository.value_380);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.click(ObjectRepository.value_382);
	basic.selectOption(ObjectRepository.value_383, "GLOBAL SERVICE PROVIDER");
	basic.pause(3000);
	basic.selectOption(ObjectRepository.value_384, "Area VP");
	basic.typeText(ObjectRepository.value_385, "jhurley");
	basic.click(ObjectRepository.value_386);
	basic.click(ObjectRepository.value_387);
	if(basic.ifLogic(ObjectRepository.value_388, "A proxy is already assigned."))
	{
	basic.click(ObjectRepository.value_389);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.waitForElementVisible(ObjectRepository.value_382);
	}
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.validateIfPresent(ObjectRepository.value_414);
	basic.click(ObjectRepository.value_414);
	basic.click(ObjectRepository.value_415);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	String Date = basic.getText(ObjectRepository.value_416);
	basic.validateContains(ObjectRepository.value_417, Date);
	}

	
	@Test
	public static void _02PnChAc_TC11_Verify_if_approver_is_able_to_give_access() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "alicwan2");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.click(ObjectRepository.value_380);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.click(ObjectRepository.value_382);
	basic.selectOption(ObjectRepository.value_383, "GLOBAL SERVICE PROVIDER");
	basic.pause(5000);
	basic.selectOption(ObjectRepository.value_384, "Area Service Manager");
	basic.typeText(ObjectRepository.value_385, "jascott");
	basic.click(ObjectRepository.value_386);
	basic.click(ObjectRepository.value_387);
	if(basic.ifLogic(ObjectRepository.value_388, "A proxy is already assigned."))
	{
	basic.click(ObjectRepository.value_389);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	basic.waitForElementVisible(ObjectRepository.value_382);
	}
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.validateIfPresent(ObjectRepository.value_418);
	basic.click(ObjectRepository.value_418);
	basic.click(ObjectRepository.value_419);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	String Date = basic.getText(ObjectRepository.value_420);
	basic.validateContains(ObjectRepository.value_421, Date);
	}

	
	@Test
	public static void _02PnChAc_TC12_Verify_user_is_able_to_search_proxy_users_deals() throws Exception
	{
	LaunchBrowsers browsers = new LaunchBrowsers();
	WebDriver driver = browsers.launchBrowser("firefox");
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "MBANCHI");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.selectOption(ObjectRepository.value_422, "Active Deals - DEALS DESK");
	basic.pause(5000);
	String randomDealID = basic.getText(ObjectRepository.value_398);
	basic.click(ObjectRepository.value_380);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_381);
	if(basic.ifLogic(ObjectRepository.value_423, "GLOBAL SERVICE PROVIDER"))
	{
	basic.click(ObjectRepository.value_424);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_393);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_394);
	basic.click(ObjectRepository.value_387);
	basic.pause(5000);
	}
	if(basic.ifLogic(ObjectRepository.value_423, "GLOBAL SERVICE PROVIDER"))
	{
	basic.click(ObjectRepository.value_426);
	basic.click(ObjectRepository.value_392);
	basic.click(ObjectRepository.calenderNextMonth);
	basic.click(ObjectRepository.value_403);
	basic.click(ObjectRepository.value_387);
	}
	else
	{
	basic.click(ObjectRepository.value_382);
	basic.selectOption(ObjectRepository.value_383, "GLOBAL SERVICE PROVIDER");
	basic.selectOption(ObjectRepository.value_384, "Regional Manager");
	basic.typeTextAutopopulate(ObjectRepository.value_385, "alamer");
	basic.click(ObjectRepository.value_387);
	}
	basic.pause(5000);
	basic.waitForElementVisible(ObjectRepository.value_382);
	String Date = basic.getText(ObjectRepository.value_427);
	basic.validateDoesNotContain(ObjectRepository.value_428, Date);
	basic.waitForElementVisible(ObjectRepository.value_382);
	basic.pause(800000);
	basic.clearBrowserCache();
	basic.justNavigate(ObjectRepository.ciscoLogin_Url);
	basic.pause(8000);
	basic.typeText(ObjectRepository.username_tb, "meghgupt");
	basic.typeText(ObjectRepository.password_tb, "Prisha#2017");
	basic.click(ObjectRepository.login_button);
	basic.justNavigate(ObjectRepository.value_254);
	basic.pause(5000);
	basic.typeText(ObjectRepository.proxyId_tb, "alamer");
	basic.click(ObjectRepository.proxyIdSubmit_button);
	basic.mouseOver(ObjectRepository.value_350);
	basic.click(ObjectRepository.value_351);
	basic.scrollIntoView(ObjectRepository.value_429);
	basic.ngclick(ObjectRepository.value_429);
	basic.click(ObjectRepository.value_353);
	basic.pause(5000);
	basic.validateContains(ObjectRepository.value_404, "MICHAEL BANCHI");
	basic.click(ObjectRepository.advancedSearch_link);
	basic.typeText(ObjectRepository.dealID_textbox, randomDealID);
	basic.click(ObjectRepository.advancedSearch_button);
	basic.validateIfPresent(ObjectRepository.dealID_link);
	basic.validateContains(ObjectRepository.dealID_link, randomDealID);
	}

	
	
	
	
	
	
	

}
