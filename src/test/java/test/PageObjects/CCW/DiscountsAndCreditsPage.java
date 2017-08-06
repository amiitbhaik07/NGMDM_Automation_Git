package test.PageObjects.CCW;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Constants;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class DiscountsAndCreditsPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public DiscountsAndCreditsPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public DiscountsAndCreditsPage _01_addDefaultNSDiscount() throws Exception
	{
		_02_addSpecificNSDiscount(Constants.defaultProductDiscount, Constants.defaultServiceDiscount, Constants.defaultSubscriptionDiscount);
		return this;
	}
	
	public DiscountsAndCreditsPage _02_addSpecificNSDiscount(int productDiscount, int serviceDiscount, int subscriptionDiscount) throws Exception
	{
		basic.click(ObjectRepository.value_81);
		if(productDiscount!=0)
		{
			basic.clearUpdateText(ObjectRepository.productDiscount_tb, ""+productDiscount);
		}
		if(serviceDiscount!=0)
		{
			basic.clearUpdateText(ObjectRepository.serviceDiscount_tb, ""+serviceDiscount);
		}
		if(subscriptionDiscount!=0)
		{
			basic.clearUpdateText(ObjectRepository.subscriptionDiscount_tb, ""+subscriptionDiscount);
		}
		basic.click(ObjectRepository.value_84);
		basic.pause(6000);
		basic.click(ObjectRepository.value_85);
		basic.pause(6000);
		logger.info("Added NS Discount : Product = '"+productDiscount+"', Service = '"+serviceDiscount+"', Subscription = '"+subscriptionDiscount+"'");
		return this;
	}
	
	public ReviewAndSubmitPage _03_saveAndContinueFromDiscountsTab() throws Exception
	{
		basic.click(ObjectRepository.saveAndCont_dnc_button);
		logger.info("Clicked on Save and Continue on Discounts and Credits tab");
		return new ReviewAndSubmitPage(basic);
	}
	
	
	
}
