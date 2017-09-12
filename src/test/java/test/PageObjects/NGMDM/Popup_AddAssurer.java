package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_AddAssurer 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_AddAssurer(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public Page_DealSummary _00_addAssurerAndContinueDefault(String assurerName) throws Exception
	{
		_01_enterAndSelectAssurer(assurerName);
		_03_enterInstructions("test");
		return _03_clickAddButton();
	}
	
	public Popup_AddAssurer _01_enterAndSelectAssurer(String assurer) throws Exception
	{
		basic.typeTextAutopopulate(ObjectRepository.assurerNameTextbox,assurer);
		return this;
	}
	
	public Popup_AddAssurer _02_selectNonStandardType(String type) throws Exception
	{
		basic.selectOption(ObjectRepository.assurerNSSelectbox, type);
		return this;
	}
	
	public Popup_AddAssurer _03_enterInstructions(String instructions) throws Exception
	{
		basic.typeText(ObjectRepository.value_260, instructions);
		return this;
	}
	
	public Page_DealSummary _03_clickAddButton() throws Exception
	{
		basic.click(ObjectRepository.value_261);
		return new Page_DealSummary(basic);
	}
	
	public Page_DealSummary _04_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.addAssurCancelBtn);
		return new Page_DealSummary(basic);
	}

}
