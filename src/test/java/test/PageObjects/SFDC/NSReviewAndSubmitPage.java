package test.PageObjects.SFDC;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NSReviewAndSubmitPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NSReviewAndSubmitPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public NSDealSubmissionSuccessPage _01_submitDealForQualification(boolean isRnsd) throws Exception
	{
		if(isRnsd)
		{
			basic.click(ObjectRepository.yesRadioButton_submitPage);
		}
		basic.click(ObjectRepository.value_108);
		basic.click(ObjectRepository.value_109);
		basic.click(ObjectRepository.value_110);
		logger.info("Successfully submitted the deal");
		return new NSDealSubmissionSuccessPage(basic);
	}
	
	

}
