package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_ExistingProxy 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_ExistingProxy(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_AddNewProxy _01_addNewProxy() throws Exception
	{
		basic.click(ObjectRepository.value_382);
		return new Popup_AddNewProxy(basic);
	}
	
	public Page_MyDealsHomepage _02_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.value_382);
		return new Page_MyDealsHomepage(basic);
	}
	

}
