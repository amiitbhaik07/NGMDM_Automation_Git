package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_UpdateOverhead 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_UpdateOverhead(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_UpdateOverhead _01_updateProductOverhead(String productOverhead) throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_491,productOverhead);
		return this;
	}
	
	public Popup_UpdateOverhead _02_updateSubscriptionOverhead(String subscriptionOverhead) throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_841,subscriptionOverhead);
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
