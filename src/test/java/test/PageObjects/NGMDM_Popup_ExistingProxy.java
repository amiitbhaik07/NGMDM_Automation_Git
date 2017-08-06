package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_Popup_ExistingProxy 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_Popup_ExistingProxy(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public NGMDM_Popup_AddNewProxy _01_addNewProxy() throws Exception
	{
		basic.click(ObjectRepository.value_382);
		return new NGMDM_Popup_AddNewProxy(basic);
	}
	
	public NGMDM_Page_MyDealsHomepage _02_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.value_382);
		return new NGMDM_Page_MyDealsHomepage(basic);
	}
	

}
