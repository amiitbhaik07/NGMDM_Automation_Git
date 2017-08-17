package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Pane_LeftBarAndOrderHeader extends Pane_MyDealsTop
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Pane_LeftBarAndOrderHeader(BasicUtils basic)
	{
		super(basic);
		this.basic = basic;
	}	
	
	public Page_DealPricing _00_1_01_openDealPricing() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_26))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_26);
		return new Page_DealPricing(basic);
	}
	
	public Page_ScenarioBrowser _00_1_02_openScenarioBrowser() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_281))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_281);
		return new Page_ScenarioBrowser(basic);
	}
	
	public Page_CreateNewScenario _00_1_03_createNewScenario() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.createNewScenario))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.createNewScenario);
		return new Page_CreateNewScenario(basic);
	}
	
	public Page_Qualification _00_1_04_openQualification() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_140))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_140);
		return new Page_Qualification(basic);
	}
	
	public Page_DealSummary _00_1_05_openDealSummary() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_255))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_255);
		return new Page_DealSummary(basic);
	}
	
	public Page_AuditHistory _00_1_06_openAuditHistory() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.auditHistoryTab))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.auditHistoryTab);
		return new Page_AuditHistory(basic);
	}
	
	public Pane_LeftBarAndOrderHeader _00_1_07_showDetailsHeader() throws Exception
	{
		basic.click(ObjectRepository.dealHeadershowdetails);
		return this;
	}
	
	

}
