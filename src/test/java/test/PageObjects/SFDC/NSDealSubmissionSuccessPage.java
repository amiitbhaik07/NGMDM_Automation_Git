package test.PageObjects.SFDC;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NSDealSubmissionSuccessPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NSDealSubmissionSuccessPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public NSDealSubmissionSuccessPage _01_AssertDealSuccessPage() throws Exception
	{
		basic.validateIfPresent(ObjectRepository.value_131);
		basic.validateIfPresent(ObjectRepository.value_132);
		basic.validateIfPresent(ObjectRepository.value_133);
		basic.validateIfPresent(ObjectRepository.value_134);
		basic.validateIfPresent(ObjectRepository.value_135);
		basic.validateIfPresent(ObjectRepository.value_136);
		basic.validateIfPresent(ObjectRepository.value_137);
		basic.validateIfPresent(ObjectRepository.value_138);
		logger.info("Deal Type 2 validation successful");
		return this;
	}

}
