package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_FVCancel 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_FVCancel(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Page_DealPricing _00_cancelFvWithDefaultValues() throws Exception
	{
		_01_selectBusinessJustification("CentralPrograms");
		_02_enterComments("test");
		return _03_clickCancelFVButton();
	}
	
	public Popup_FVCancel _01_selectBusinessJustification(String justification) throws Exception
	{
		basic.selectOption(ObjectRepository.businessJustificationFvCancel, justification);
		return this;
	}
	
	public Popup_FVCancel _02_enterComments(String comments) throws Exception
	{
		basic.typeText(ObjectRepository.commentsFvCancel, comments);
		return this;
	}
	
	public Page_DealPricing _03_clickCancelFVButton() throws Exception
	{
		basic.click(ObjectRepository.value_862);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _04_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.commentsFvCancel);
		return new Page_DealPricing(basic);
	}
}
