package test.PageObjects;

import org.apache.log4j.Logger;
import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class SFDC_HomePage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public SFDC_HomePage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public SFDC_HomePage _01_createNewParentOpportunity() throws Exception
	{
		basic.click(ObjectRepository.createNew_tabdropdown);
		basic.click(ObjectRepository.sfdc_opportunity_link);
		basic.click(ObjectRepository.sfdc_continue_button);
		return this;
	}
	
	public SFDC_AddTechnologyPage _02_1_fillAndSaveNewOpportunitySFDCPageDefault(String optyName) throws Exception
	{
		_03_enterAccountName("GOOGLE INC - Corp IT");
		_04_enterOptyName(optyName);
		_05_clickDateLink();
		_06_enterExpectedProductValue("500");
		_07_selectStageDropdown("2 - Qualification");
		_08_selectForecaseStatusDropdown("Commit");
		_10_selectSalesPathDropdown("1-Tier");
		_09_addCompetitors("8x8");
		_11_selectInstallBaseDropdown("New Installation");
		return _13_savePageAndProceed();
	}
	
	public SFDC_AddTechnologyPage _02_2_fillAndSaveNewOpportunitySFDCPage_EMEAR(String optyName) throws Exception
	{
		_03_enterAccountName("ACCIDENT EXCHANGE GROUP PLC");
		_04_enterOptyName(optyName);
		_05_clickDateLink();
		_06_enterExpectedProductValue("500");
		_07_selectStageDropdown("2 - Qualification");
		_08_selectForecaseStatusDropdown("Commit");
		_10_selectSalesPathDropdown("1-Tier");
		_09_addCompetitors("8x8");
		_12_selectIsCiscoCapitalEngagedDropdown("No-Not Required");
		_11_selectInstallBaseDropdown("New Installation");
		return _13_savePageAndProceed();
	}
	
	public SFDC_HomePage _03_enterAccountName(String accountName) throws Exception
	{
		basic.typeText(ObjectRepository.value_43, accountName);
		basic.click(ObjectRepository.accName_autoPopulated);
		return this;
	}
	
	public SFDC_HomePage _04_enterOptyName(String optyName) throws Exception
	{
		basic.typeText(ObjectRepository.value_44, optyName);
		return this;
	}
	
	public SFDC_HomePage _05_clickDateLink() throws Exception
	{
		basic.click(ObjectRepository.value_45);
		return this;
	}
	
	public SFDC_HomePage _06_enterExpectedProductValue(String expectedProductValue) throws Exception
	{
		basic.typeText(ObjectRepository.value_46, expectedProductValue);
		return this;
	}
	
	public SFDC_HomePage _07_selectStageDropdown(String stageDropdownValue) throws Exception
	{
		basic.selectOption(ObjectRepository.value_47, stageDropdownValue);
		return this;
	}
	
	public SFDC_HomePage _08_selectForecaseStatusDropdown(String forecastDropdownValue) throws Exception
	{
		basic.selectOption(ObjectRepository.value_3, forecastDropdownValue);
		return this;
	}
	
	public SFDC_HomePage _09_addCompetitors(String competitor) throws Exception
	{
		basic.selectOption(ObjectRepository.value_5, competitor);
		basic.click(ObjectRepository.value_6);
		return this;
	}
	
	public SFDC_HomePage _10_selectSalesPathDropdown(String salesPath) throws Exception
	{
		basic.selectOption(ObjectRepository.value_4, salesPath);
		return this;
	}
	
	public SFDC_HomePage _11_selectInstallBaseDropdown(String installBase) throws Exception
	{
		basic.selectOption(ObjectRepository.value_7, installBase);
		return this;
	}
	
	public SFDC_HomePage _12_selectIsCiscoCapitalEngagedDropdown(String isCiscoCapitalEngaged) throws Exception
	{
		basic.selectOption(ObjectRepository.inCiscoCapitalEngaged, isCiscoCapitalEngaged);
		return this;
	}
	
	public SFDC_AddTechnologyPage _13_savePageAndProceed() throws Exception
	{
		basic.click(ObjectRepository.value_8);
		logger.info("Saved first page in SFDC");
		return new SFDC_AddTechnologyPage(basic);
	}
	
	
}
