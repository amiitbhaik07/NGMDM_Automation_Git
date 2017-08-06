package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_Page_AdvancedSearch 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_Page_AdvancedSearch(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public NGMDM_Page_AdvancedSearch _01_enterDealId(String dealId) throws Exception
	{
		if(dealId!=null)
		{
			if(! dealId.trim().equals(""))
			{
				basic.typeText(ObjectRepository.dealID_textbox, dealId);
			}
		}
		logger.info("Successfully entered Deal ID '"+dealId+"' on Advanced Search Page");
		return new NGMDM_Page_AdvancedSearch(basic);
	}	
	
	public NGMDM_Page_AdvancedSearch _02_selectDealStatus(String dealStatus) throws Exception
	{
		if(dealStatus!=null)
		{
			if(! dealStatus.trim().equals(""))
			{
				basic.selectOption(ObjectRepository.value_312, dealStatus);
			}
		}
		logger.info("Successfully selected Deal Status '"+dealStatus+"' on Advanced Search Page");
		return new NGMDM_Page_AdvancedSearch(basic);
	}
	
	public NGMDM_Page_AdvancedSearch _03_selectDealType(String dealType) throws Exception
	{
		if(dealType!=null)
		{
			if(! dealType.trim().equals(""))
			{
				basic.selectOption(ObjectRepository.value_314, dealType);
			}
		}
		logger.info("Successfully selected Deal Type '"+dealType+"' on Advanced Search Page");
		return new NGMDM_Page_AdvancedSearch(basic);
	}
	
	public NGMDM_Page_MyDealsHomepage _04_clickSearchButton() throws Exception
	{
		basic.click(ObjectRepository.advancedSearch_button);
		return new NGMDM_Page_MyDealsHomepage(basic);
	}
	
	public NGMDM_Popup_EditDeal _04_clickEditDealLink() throws Exception
	{
		basic.click(ObjectRepository.advancedSearch_button);
		return new NGMDM_Popup_EditDeal(basic);
	}
	

}
