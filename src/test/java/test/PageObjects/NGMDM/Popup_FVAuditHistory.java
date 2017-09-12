package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_FVAuditHistory 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_FVAuditHistory(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Page_DealPricing _01_closeAuditHistory() throws Exception
	{
		basic.click(ObjectRepository.closeBtnAuditHistory);
		return new Page_DealPricing(basic);
	}
}
