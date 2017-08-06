package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;
import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_MyDealsHomepage extends Pane_MyDealsTop
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_MyDealsHomepage(BasicUtils basic)
	{
		super(basic);
		this.basic = basic;
	}	
	
	public Page_ScenarioBrowser _01_openFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.dealID_link);
		logger.info("Successfully clicked on First Deal ID Link on My Deals Homepage");
		return new Page_ScenarioBrowser(basic);
	}	
	
	public Popup_EditDeal _04_editFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.value_354);
		return new Popup_EditDeal(basic);
	}
	
	public Popup_ExecutiveSummary _05_executiveSummaryForFirstDealDisplayed() throws Exception
	{
		basic.click(ObjectRepository.value_292);
		return new Popup_ExecutiveSummary(basic);
	}
	
	
	
	
	
	

}
