package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_AddAdjustmentLine 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_AddAdjustmentLine(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_AddAdjustmentLine _01_selectComponent(String component) throws Exception
	{
		basic.selectOption(ObjectRepository.selectComponentAdjLine,component);
		return this;
	}
	
	public Popup_AddAdjustmentLine _02_selectLineType(String lineType) throws Exception
	{
		basic.selectOption(ObjectRepository.selectLineTypeAdjLine,lineType);
		return this;
	}
	
	public Popup_AddAdjustmentLine _03_enterAdjustmentValue(String adjustmentValue) throws Exception
	{
		basic.typeText(ObjectRepository.value_22,adjustmentValue);
		return this;
	}
	
	public Popup_AddAdjustmentLine _04_enterDescription(String description) throws Exception
	{
		basic.typeText(ObjectRepository.value_21,description);
		return this;
	}
		
	public Page_DealPricing _05_clickAddButton() throws Exception
	{
		basic.click(ObjectRepository.value_23);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _06_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.value_840);
		return new Page_DealPricing(basic);
	}

}
