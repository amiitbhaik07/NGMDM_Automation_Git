package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Pane_MyDealsTop 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Pane_MyDealsTop(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public Page_AdvancedSearch _00_0_01_clickAdvancedSearchLink() throws Exception
	{
		basic.click(ObjectRepository.dealID_link);
		logger.info("Successfully clicked on Advanced Search Link on My Deals Homepage");
		return new Page_AdvancedSearch(basic);
	}
	
	public Page_MyDealsHomepage _00_0_02_regularSearchDealID(String dealId) throws Exception
	{
		basic.waitForElementVisible(ObjectRepository.regularSearchDealID_textbox);
		basic.typeText(ObjectRepository.regularSearchDealID_textbox, dealId);
		basic.pressEnterUsingActions();
		return new Page_MyDealsHomepage(basic);
	}
	
	public Popup_ChangeAccess _00_0_03_openChangeAccess() throws Exception
	{
		basic.mouseOver(ObjectRepository.subMenuArrow);
		basic.click(ObjectRepository.value_351);
		return new Popup_ChangeAccess(basic);
	}
	
	public Popup_ExistingProxy _00_0_04_openAddNewProxy() throws Exception
	{
		basic.mouseOver(ObjectRepository.subMenuArrow);
		basic.click(ObjectRepository.value_381);
		return new Popup_ExistingProxy(basic);
	}
	
	

}
