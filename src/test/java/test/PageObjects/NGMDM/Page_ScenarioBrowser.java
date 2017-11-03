package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_ScenarioBrowser extends Pane_LeftBarAndOrderHeader
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_ScenarioBrowser(BasicUtils basic)
	{
		super(basic);
		this.basic = basic;
	}
	
	public Page_DealPricing _01_openFirstPublishedScenario() throws Exception
	{
		basic.waitForElementClickable(ObjectRepository.firstPublishedScenario);
		basic.click(ObjectRepository.firstPublishedScenario);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _02_compareSqf() throws Exception
	{
		basic.click(ObjectRepository.value_12);
		return new Page_DealPricing(basic);
	}
	
	public Page_ScenarioBrowser _03_deleteScenario(String scenarioName) throws Exception
	{
		basic.click("//*[starts-with(@kdfid,'scenarioName-') and @kdfapp='mdmUI' and @kdfpage='ngScenarioBrowser' and text()='"+scenarioName+"']/ancestor::tr/descendant::a[starts-with(@kdfid,'delete-')]");
		basic.click(ObjectRepository.value_15);
		basic.waitForElementDisappear("//*[starts-with(@kdfid,'scenarioName-') and @kdfapp='mdmUI' and @kdfpage='ngScenarioBrowser' and text()='"+scenarioName+"']/ancestor::tr/descendant::a[starts-with(@kdfid,'delete-')]");
		return this;
	}
	
	public Page_DealPricing _04_openFirstScenario() throws Exception
	{
		basic.waitForElementClickable(ObjectRepository.firstScenario);
		basic.click(ObjectRepository.firstScenario);
		return new Page_DealPricing(basic);
	}
	
	

}
