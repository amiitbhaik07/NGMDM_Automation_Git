package test.PageObjects;

import org.apache.log4j.Logger;
import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_Page_MyDealsHomepage extends NGMDM_Pane_MyDealsTop
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_Page_MyDealsHomepage(BasicUtils basic)
	{
		super(basic);
		this.basic = basic;
	}	
	
	public NGMDM_Page_ScenarioBrowser _01_openFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.dealID_link);
		logger.info("Successfully clicked on First Deal ID Link on My Deals Homepage");
		return new NGMDM_Page_ScenarioBrowser(basic);
	}	
	
	public NGMDM_Popup_EditDeal _04_editFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.value_354);
		return new NGMDM_Popup_EditDeal(basic);
	}
	
	public NGMDM_Popup_ExecutiveSummary _05_executiveSummaryForFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.value_292);
		return new NGMDM_Popup_ExecutiveSummary(basic);
	}
	
	
	
	
	
	

}
