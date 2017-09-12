package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_DealSummary extends Pane_LeftBarAndOrderHeader
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_DealSummary(BasicUtils basic) throws Exception
	{
		super(basic);
		this.basic = basic;
		_01_expandAll();
	}
	
	public Page_DealSummary _01_expandAll() throws Exception
	{
		basic.click(ObjectRepository.value_256);
		return this;
	}
	
	public Page_DealSummary _02_collapseAll() throws Exception
	{
		basic.click(ObjectRepository.collapseAllDealSummary);
		return this;
	}
	
	public Popup_AddApprover _03_addApprover() throws Exception
	{
		int queueNo=10;
		if(basic.knowIfAppears(ObjectRepository.approverLastQueueNo))
		{
			queueNo = Integer.parseInt(basic.getText(ObjectRepository.approverLastQueueNo));
		}
		basic.click(ObjectRepository.addAproverButton);		
		return new Popup_AddApprover(basic, queueNo+1);
	}
	
	public Page_DealSummary _04_startApproverQueue() throws Exception
	{
		basic.click(ObjectRepository.value_895);
		return this;
	}
	
	public Page_DealSummary _05_cancelApproverQueue() throws Exception
	{
		basic.click(ObjectRepository.value_886);
		return this;
	}
	
	public Page_DealSummary _06_validateApproverPresent(String approverName) throws Exception
	{
		basic.validateIfPresent("//*[starts-with(@kdfid,'approver-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+approverName+"')]");
		return this;
	}
	
	public Popup_ApprovalDecision _07_editLineForApprover(String approverName) throws Exception
	{
		_06_validateApproverPresent(approverName);
		basic.click("//*[starts-with(@kdfid,'approver-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+approverName+"')]/parent::tr/descendant::a[starts-with(@kdfid,'editApprover')]");
		return new Popup_ApprovalDecision(basic);
	}
	
	public Page_DealSummary _08_deleteLineForApprover(String approverName) throws Exception
	{
		_06_validateApproverPresent(approverName);
		basic.click("//*[starts-with(@kdfid,'approver-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+approverName+"')]/parent::tr/descendant::a[starts-with(@kdfid,'deleteApprover')]");
		basic.click(ObjectRepository.value_15);
		return this;
	}
	
	public Popup_AddAssurer _09_addAssurer() throws Exception
	{
		basic.click(ObjectRepository.value_257);		
		return new Popup_AddAssurer(basic);
	}
	
	public Page_DealSummary _10_validateAssurerPresent(String assurerName) throws Exception
	{
		basic.validateIfPresent("//*[starts-with(@kdfid,'assurerName-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+assurerName+"')]");		
		return this;
	}
	
	public Page_DealSummary _11_sendRequestForAssurer(String assurerName) throws Exception
	{
		_10_validateAssurerPresent(assurerName);
		basic.click("//*[starts-with(@kdfid,'assurerName-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+assurerName+"')]/parent::tr/descendant::input[starts-with(@kdfid,'assurerCheckbox-')]");
		basic.click(ObjectRepository.value_264);
		return this;
	}
	
	public Popup_UpdateAssuranceDetails _12_editLineForAssurer(String assurerName) throws Exception
	{
		_10_validateAssurerPresent(assurerName);
		basic.click("//*[starts-with(@kdfid,'assurerName-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+assurerName+"')]/parent::tr/descendant::a[starts-with(@kdfid,'assurerEdit-')]");
		return new Popup_UpdateAssuranceDetails(basic);
	}
	
	public Page_DealSummary _13_deleteLineForAssurer(String assurerName) throws Exception
	{
		_10_validateAssurerPresent(assurerName);
		basic.click("//*[starts-with(@kdfid,'assurerName-') and @kdfapp='mdmUI' and @kdfpage='ngDealSummary' and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+assurerName+"')]/parent::tr/descendant::a[starts-with(@kdfid,'deleteRule-')]");
		basic.click(ObjectRepository.value_15);
		return this;
	}
	
	

}
