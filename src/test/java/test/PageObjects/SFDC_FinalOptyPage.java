package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class SFDC_FinalOptyPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public SFDC_FinalOptyPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public SFDC_CreateQuotePage _01_createQuoteFromOpty() throws Exception
	{
		logger.info("Waiting few seconds to click on Create Quote button");
		basic.pause(35000);
		basic.click(ObjectRepository.sfdc_createQuote_button);
		logger.info("Successfully clicked on Create Quote button");
		return new SFDC_CreateQuotePage(basic);
	}
	
}
