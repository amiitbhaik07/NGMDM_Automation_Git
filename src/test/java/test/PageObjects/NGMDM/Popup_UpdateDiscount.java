package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_UpdateDiscount 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_UpdateDiscount(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_UpdateDiscount _01_updateProductDiscount(String productDiscount) throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_491,productDiscount);
		return this;
	}
	
	public Popup_UpdateDiscount _02_updateServiceDiscount(String serviceDiscount) throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_492,serviceDiscount);
		return this;
	}
	
	public Popup_UpdateDiscount _03_updateSubscriptionDiscount(String subscriptionDiscount) throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_841,subscriptionDiscount);
		return this;
	}
		
	public Page_DealPricing _05_clickUpdateButton() throws Exception
	{
		basic.click(ObjectRepository.value_493);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _06_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.value_840);
		return new Page_DealPricing(basic);
	}

}
