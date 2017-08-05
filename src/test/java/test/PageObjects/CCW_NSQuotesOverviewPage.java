package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class CCW_NSQuotesOverviewPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public CCW_NSQuotesOverviewPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public CCW_QualFormPage _01_continueToQualForm() throws Exception
	{
		basic.click(ObjectRepository.value_90);
		basic.click(ObjectRepository.value_91);
		logger.info("Continued to Qual Form");
		return new CCW_QualFormPage(basic);
	}
	

}
