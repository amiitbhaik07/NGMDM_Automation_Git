package kdfMigration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class TestClass 
{
	
	@Test
	public static void _256_SetPreferencesForThisQuote_Partner_QQ() throws Exception
	{
	WebDriver driver = LaunchBrowsers.launchBrowser();
	BasicUtils basic = new BasicUtils(driver);
	Modules m = new Modules(driver);
	basic.justNavigate(ObjectRepository.value_1128);
	basic.typeText(ObjectRepository.username_tb, "sunchand");
	basic.typeText(ObjectRepository.password_tb, "cisco123");
	basic.click(ObjectRepository.login_button);
	basic.typeText(ObjectRepository.value_209, "kazembemalvin");
	basic.click(ObjectRepository.value_210);
	basic.click(ObjectRepository.value_211);
	basic.click(ObjectRepository.value_212);
	basic.typeText(ObjectRepository.value_212, "testQuickQuote");
	basic.click(ObjectRepository.value_213);
	basic.selectOption(ObjectRepository.value_213, "Other (Other)");
	basic.click(ObjectRepository.value_897);
	basic.click(ObjectRepository.value_214);
	basic.typeText(ObjectRepository.value_214, "glwalker");
	basic.click(ObjectRepository.value_215);
	basic.click(ObjectRepository.value_216);
	basic.typeText(ObjectRepository.value_216, "Verizon");
	basic.click(ObjectRepository.value_217);
	basic.click(ObjectRepository.value_898);
	basic.click(ObjectRepository.value_219);
	basic.click(ObjectRepository.value_220);
	basic.click(ObjectRepository.value_221);
	basic.click(ObjectRepository.value_222);
	basic.click(ObjectRepository.value_223);
	basic.typeText(ObjectRepository.value_223, "testDescription");
	basic.click(ObjectRepository.intendedUseDropdown);
	basic.selectOption(ObjectRepository.intendedUseDropdown, "Internal Business Use");
	basic.click(ObjectRepository.dealCategoryDropdown);
	basic.selectOption(ObjectRepository.dealCategoryDropdown, "Outsource");
	basic.click(ObjectRepository.priceListDropdown);
	basic.selectOption(ObjectRepository.priceListDropdown, "Global Price List EMEA Availability");
	basic.click(ObjectRepository.value_899);
	basic.click(ObjectRepository.buyMethod_CCW_dropdown);
	basic.click(ObjectRepository.buyMethod_cisco_CCW_dropdownvalue);
	basic.click(ObjectRepository.saveAndContinueFromQIP);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.click(ObjectRepository.value_1111);
	basic.validateIfPresent(ObjectRepository.value_1112);
	basic.validateIfPresent(ObjectRepository.value_1113);
	basic.validateIfPresent(ObjectRepository.value_1114);
	basic.validateIfPresent(ObjectRepository.value_1115);
	basic.validateIfPresent(ObjectRepository.value_1116);
	basic.validateIfPresent(ObjectRepository.value_1117);
	basic.click(ObjectRepository.value_1112);
	basic.click(ObjectRepository.value_1118);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.click(ObjectRepository.value_1111);
	basic.validateIfPresent(ObjectRepository.value_1119);
	basic.validateIfPresent(ObjectRepository.value_1120);
	basic.click(ObjectRepository.value_1120);
	basic.click(ObjectRepository.value_1118);
	basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
	basic.click(ObjectRepository.value_1111);
	basic.validateIfPresent(ObjectRepository.value_1121);
	basic.validateIfPresent(ObjectRepository.value_1122);
	}









}
