package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_AuditHistory extends Pane_LeftBarAndOrderHeader
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_AuditHistory(BasicUtils basic) throws Exception
	{
		super(basic);
		this.basic = basic;
	}
	
	public Page_AuditHistory _01_selectQuoteOnAuditHistory(String quoteName) throws Exception
	{
		basic.selectOption(ObjectRepository.value_422, quoteName);
		return this;
	}
}
