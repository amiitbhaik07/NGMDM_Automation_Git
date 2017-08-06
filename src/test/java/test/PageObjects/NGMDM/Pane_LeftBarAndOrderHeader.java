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
	
	public Pane_LeftBarAndOrderHeader _01_openDealPricing() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_26))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_26);
		return this;
	}
	
	public Pane_LeftBarAndOrderHeader _02_openScenarioBrowser() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_281))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_281);
		return this;
	}
	
	public Pane_LeftBarAndOrderHeader _03_createNewScenario() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.createNewScenario))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.createNewScenario);
		return this;
	}
	
	public Pane_LeftBarAndOrderHeader _04_openQualification() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_140))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_140);
		return this;
	}
	
	public Pane_LeftBarAndOrderHeader _05_openDealSummary() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.value_255))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.value_255);
		return this;
	}
	
	public Pane_LeftBarAndOrderHeader _06_openAuditHistory() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.auditHistoryTab))
		{
			basic.click(ObjectRepository.slideMenu);
		}
		basic.click(ObjectRepository.auditHistoryTab);
		return this;
	}
	
	public Pane_LeftBarAndOrderHeader _07_showDetailsHeader() throws Exception
	{
		basic.click(ObjectRepository.dealHeadershowdetails);
		return this;
	}
	
	

}
