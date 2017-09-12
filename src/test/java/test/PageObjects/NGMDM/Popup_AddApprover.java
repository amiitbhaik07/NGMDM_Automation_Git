package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_AddApprover 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	int defaultQueue=10;
	
	public Popup_AddApprover(BasicUtils basic)
	{
		this.basic = basic;
	}
	public Popup_AddApprover(BasicUtils basic, int defaultQueueNo)
	{
		this.basic = basic;
		this.defaultQueue = defaultQueueNo;
	}	
	
	public Page_DealSummary _00_addApproverAndContinueDefault(String approverName) throws Exception
	{
		_01_enterAndSelectApprover(approverName);
		_02_enterQueueNumber(""+defaultQueue);
		return _03_clickAddButton();
	}
	
	public Popup_AddApprover _01_enterAndSelectApprover(String approverName) throws Exception
	{
		basic.typeTextAutopopulate(ObjectRepository.addAproverNameTextbox,approverName);
		return this;
	}
	
	public Popup_AddApprover _02_enterQueueNumber(String queue) throws Exception
	{
		basic.typeText(ObjectRepository.value_871, queue);
		return this;
	}
	
	public Page_DealSummary _03_clickAddButton() throws Exception
	{
		basic.click(ObjectRepository.value_872);
		return new Page_DealSummary(basic);
	}
	
	public Page_DealSummary _04_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.value_840);
		return new Page_DealSummary(basic);
	}

}
