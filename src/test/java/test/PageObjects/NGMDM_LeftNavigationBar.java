package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_LeftNavigationBar 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_LeftNavigationBar(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public NGMDM_LeftNavigationBar _01_openDealPricing() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_26))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_26);
		return this;
	}
	
	public NGMDM_LeftNavigationBar _02_openScenarioBrowser() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_281))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_281);
		return this;
	}
	
	public NGMDM_LeftNavigationBar _03_createNewScenario() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.createNewScenario))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.createNewScenario);
		return this;
	}
	
	public NGMDM_LeftNavigationBar _04_openQualification() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_140))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_140);
		return this;
	}
	
	public NGMDM_LeftNavigationBar _05_openDealSummary() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_255))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_255);
		return this;
	}
	
	public NGMDM_LeftNavigationBar _06_openAuditHistory() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.auditHistoryTab))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.auditHistoryTab);
		return this;
	}
	
	public NGMDM_LeftNavigationBar _07_showDetailsHeader() throws Exception
	{
		basic.click(ObjectRepository.dealHeadershowdetails);
		return this;
	}
	
	

}
