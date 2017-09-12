package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_FVDetails 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_FVDetails(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Page_DealPricing _02_startFvAssessment() throws Exception
	{
		basic.click(ObjectRepository.value_852);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _01_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.value_858);
		return new Page_DealPricing(basic);
	}

}
