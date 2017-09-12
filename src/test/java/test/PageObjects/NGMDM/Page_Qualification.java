package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_Qualification extends Pane_LeftBarAndOrderHeader
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_Qualification(BasicUtils basic) throws Exception
	{
		super(basic);
		this.basic = basic;
		_01_expandAll();
	}
	
	public Page_Qualification _01_expandAll() throws Exception
	{
		basic.click(ObjectRepository.value_141);
		return this;
	}
	
	public Page_Qualification _02_collapseAll() throws Exception
	{
		basic.click(ObjectRepository.collapseAllQual);
		return this;
	}
	
	public Page_Qualification _03_save() throws Exception
	{
		basic.click(ObjectRepository.saveButtonDealQual);
		return this;
	}
	
	public Page_Qualification _03_saveAndContinue() throws Exception
	{
		basic.click(ObjectRepository.value_154);
		return this;
	}
	
	
	
	

}
