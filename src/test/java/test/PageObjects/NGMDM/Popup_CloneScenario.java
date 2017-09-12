package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_CloneScenario 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_CloneScenario(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Page_ScenarioBrowser _00_cloneAndProceedDefault(String scenarioName) throws Exception
	{
		_01_enterScenarioName(scenarioName);
		return _02_clickCloneButton();
	}
	
	public Popup_CloneScenario _01_enterScenarioName(String scenarioName) throws Exception
	{
		basic.typeText(ObjectRepository.value_475,scenarioName);
		return this;
	}
	
	public Page_ScenarioBrowser _02_clickCloneButton() throws Exception
	{
		basic.click(ObjectRepository.value_476);
		return new Page_ScenarioBrowser(basic);
	}
	
	public Page_DealPricing _03_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.cancelButtonCloneScenario);
		return new Page_DealPricing(basic);
	}
	
	

}
