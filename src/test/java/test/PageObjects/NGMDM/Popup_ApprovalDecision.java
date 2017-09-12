package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_ApprovalDecision 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_ApprovalDecision(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public Page_DealSummary _00_1_approveThisStraightaway() throws Exception
	{
		_01_selectDecision("Approved");
		_02_enterComments("test");
		return _03_clickSaveButton();
	}
	
	public Page_DealSummary _00_2_rejectThisStraightaway() throws Exception
	{
		_01_selectDecision("Reject");
		_02_enterComments("test");
		return _03_clickSaveButton();
	}
	
	public Popup_ApprovalDecision _01_selectDecision(String decision) throws Exception
	{
		basic.selectOption(ObjectRepository.value_361,decision);
		return this;
	}
	
	public Popup_ApprovalDecision _02_enterComments(String comments) throws Exception
	{
		basic.typeText(ObjectRepository.value_360, comments);
		return this;
	}
	
	public Page_DealSummary _03_clickSaveButton() throws Exception
	{
		basic.click(ObjectRepository.value_896);
		return new Page_DealSummary(basic);
	}
	
	public Page_DealSummary _04_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.value_362);
		return new Page_DealSummary(basic);
	}

}
