package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_AdvancedSearch 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_AdvancedSearch(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public Page_AdvancedSearch _01_enterDealId(String dealId) throws Exception
	{
		if(dealId!=null)
		{
			if(! dealId.trim().equals(""))
			{
				basic.typeText(ObjectRepository.dealID_textbox, dealId);
			}
		}
		logger.info("Successfully entered Deal ID '"+dealId+"' on Advanced Search Page");
		return new Page_AdvancedSearch(basic);
	}	
	
	public Page_AdvancedSearch _02_selectDealStatus(String dealStatus) throws Exception
	{
		if(dealStatus!=null)
		{
			if(! dealStatus.trim().equals(""))
			{
				basic.selectOption(ObjectRepository.value_312, dealStatus);
			}
		}
		logger.info("Successfully selected Deal Status '"+dealStatus+"' on Advanced Search Page");
		return new Page_AdvancedSearch(basic);
	}
	
	public Page_AdvancedSearch _03_selectDealType(String dealType) throws Exception
	{
		if(dealType!=null)
		{
			if(! dealType.trim().equals(""))
			{
				basic.selectOption(ObjectRepository.value_314, dealType);
			}
		}
		logger.info("Successfully selected Deal Type '"+dealType+"' on Advanced Search Page");
		return new Page_AdvancedSearch(basic);
	}
	
	public Page_MyDealsHomepage _04_clickSearchButton() throws Exception
	{
		basic.click(ObjectRepository.advancedSearch_button);
		return new Page_MyDealsHomepage(basic);
	}
	
	public Popup_EditDeal _04_clickEditDealLink() throws Exception
	{
		basic.click(ObjectRepository.advancedSearch_button);
		return new Popup_EditDeal(basic);
	}
	

}
