package test.PageObjects.CCW;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class ReviewAndSubmitPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public ReviewAndSubmitPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	private ReviewAndSubmitPage selectReasonDropdownIfAppears() throws Exception
	{
		if(basic.knowIfAppears(ObjectRepository.value_124))
		{
			if(basic.isRewrite())
			{
				basic.click(ObjectRepository.value_125);
				basic.click(ObjectRepository.value_126);
			}
			else
			{
				basic.click(ObjectRepository.value_125);
				basic.click(ObjectRepository.value_126);
			}
			logger.info("Successfully selected Reason Dropdown on Review and Submit Page");
		}
		else
		{
			logger.info("Reason dropdown not present on Review and Submit Page, continuing script execution");
		}
		return this;
	}
	
	
	private ReviewAndSubmitPage verifyAmAndForecastingPositionPresent() throws Exception
	{
		if(! basic.knowIfAppears(ObjectRepository.notNullAmValue_rnsPage))
		{
			//AM is NOT stamped
			_01_selectDefaultAMCCW();
		}
		
		if(! basic.knowIfAppears(ObjectRepository.salesHierarchy_rns))
		{
			//Forecasting Position is not present
			changeForecastingPosition();
		}
		return this;
	}
	
	private ReviewAndSubmitPage changeForecastingPosition() throws Exception
	{
		basic.click(ObjectRepository.value_241);
		basic.waitForElementPresent(ObjectRepository.value_242);
		basic.selectOptionWhereValueLike(ObjectRepository.value_242, "CORP_IT US");
		basic.click(ObjectRepository.value_243);
		basic.waitForPreloaderAppear();
		basic.waitForPreloaderDisappear();
		basic.refreshPage();
		basic.waitForElementPresent(ObjectRepository.salesHierarchy_rns);
		return this;
	}
	
	public ReviewAndSubmitPage _01_selectDefaultAMCCW() throws Exception
	{
		_02_selectDifferentAMCCW("thaymore");
		return this;
	}
	
	public ReviewAndSubmitPage _02_selectDifferentAMCCW(String amCecId) throws Exception
	{
		basic.click(ObjectRepository.value_248);
		basic.click(ObjectRepository.value_249);
		basic.click("//*[@kdfid='amEmailId' and @kdfapp='Quoting' and @kdfpage='reviewAndSubmit']/following::a[@kdfid='amEmailId_' and contains(text(),'"+amCecId+"')]");
		basic.click(ObjectRepository.value_251);
		basic.click(ObjectRepository.value_252);
		basic.click(ObjectRepository.value_253);
		return this;
	}	
	
	public NSQuotesOverviewPage _03_finishAndSaveFromRnSTab() throws Exception
	{
		selectReasonDropdownIfAppears();
		verifyAmAndForecastingPositionPresent();
		basic.click(ObjectRepository.finishAndSave_rns_page);
		logger.info("Clicked on Finish and Save on Review and Submit tab");
		return new NSQuotesOverviewPage(basic);
	}
	
	public ReviewAndSubmitPage _04_submitQuoteForApprovalFromRnSTab() throws Exception
	{
		selectReasonDropdownIfAppears();	
		verifyAmAndForecastingPositionPresent();
		basic.click(ObjectRepository.submitQuoteForApproval_rns_page);
		logger.info("Clicked on Submit Quote for Approval on Review and Submit tab");
		return null;
	}
	

}
