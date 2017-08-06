package test.PageObjects.SFDC;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class AddTechnologyPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public AddTechnologyPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public FinalOptyPage _01_proceedWithDefaultValuesAndContinue() throws Exception
	{
		_02_selectForecastingPositionLike("US thaymore");
		_03_addTechnology();
		return _04_saveTechnology();
	}
		
	public AddTechnologyPage _02_selectForecastingPositionLike(String forecastingPositionLike) throws Exception
	{
		basic.pause(15000);
		basic.waitForElementVisible(ObjectRepository.value_112);
		//basic.selectOption(ObjectRepository.value_112, "GOOGLE ACCESS US thaymore");
		basic.selectOptionWhereValueLike(ObjectRepository.value_112, "thaymore");
		return this;
	}
	
	public AddTechnologyPage _03_addTechnology() throws Exception
	{
		basic.click(ObjectRepository.value_113);
		basic.click(ObjectRepository.value_50);
		basic.click(ObjectRepository.value_114);
		basic.click_id(ObjectRepository.value_52);
		basic.updateText_id(ObjectRepository.value_52, "100");
		return this;
	}
	
	public FinalOptyPage _04_saveTechnology() throws Exception
	{
		basic.click(ObjectRepository.value_53);
		return new FinalOptyPage(basic);
	}
}
