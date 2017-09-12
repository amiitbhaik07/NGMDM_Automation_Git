package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_CreateNewScenario extends Pane_LeftBarAndOrderHeader
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_CreateNewScenario(BasicUtils basic)
	{
		super(basic);
		this.basic = basic;
	}
	
	public Page_ScenarioBrowser _01_createNewScenario(String scenarioName) throws Exception
	{
		basic.typeText(ObjectRepository.createNewScenarioTextbox, scenarioName);
		basic.click(ObjectRepository.createNewScenarioButton);
		basic.waitForElementPresent(ObjectRepository.value_786);
		basic.validateIfPresent("//*[starts-with(@kdfid,'scenarioName-') and @kdfapp='mdmUI' and @kdfpage='ngScenarioBrowser' and text()='"+scenarioName+"']");
		return new Page_ScenarioBrowser(basic);
	}
	
	
	
	

}
