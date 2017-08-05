package test.PageObjects;

import org.apache.log4j.Logger;
import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_MyDealsHomepage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_MyDealsHomepage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	
	public NGMDM_ScenarioBrowserPage _01_openFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.dealID_link);
		logger.info("Successfully clicked on First Deal ID Link on My Deals Homepage");
		return new NGMDM_ScenarioBrowserPage(basic);
	}
	
	public NGMDM_AdvancedSearchPage _02_clickAdvancedSearchLink() throws Exception
	{
		basic.click(ObjectRepository.dealID_link);
		logger.info("Successfully clicked on Advanced Search Link on My Deals Homepage");
		return new NGMDM_AdvancedSearchPage(basic);
	}
	
	public NGMDM_MyDealsHomepage _03_regularSearchDealID(String dealId) throws Exception
	{
		basic.waitForElementVisible(ObjectRepository.regularSearchDealID_textbox);
		basic.typeText(ObjectRepository.regularSearchDealID_textbox, dealId);
		basic.pressEnterUsingActions();
		return this;
	}
	
	public NGMDM_EditDealPage _04_editFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.value_354);
		return new NGMDM_EditDealPage(basic);
	}
	
	public NGMDM_ExecutiveSummary _05_executiveSummaryForFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.value_292);
		return new NGMDM_ExecutiveSummary(basic);
	}
	
	public NGMDM_ChangeAccessPage _08_openChangeAccess() throws Exception
	{
		basic.mouseOver(ObjectRepository.subMenuArrow);
		basic.click(ObjectRepository.value_351);
		return new NGMDM_ChangeAccessPage(basic);
	}
	
	public NGMDM_ExistingProxyPage _08_openAddNewProxy() throws Exception
	{
		basic.mouseOver(ObjectRepository.subMenuArrow);
		basic.click(ObjectRepository.value_381);
		return new NGMDM_ExistingProxyPage(basic);
	}
	
	
	
	

}
