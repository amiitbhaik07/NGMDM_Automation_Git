package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_ChangeAccessPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_ChangeAccessPage(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public NGMDM_ChangeAccessPage _01_changeAccessTo(String changeAccessTo) throws Exception
	{
		basic.pressSpaceUsingActions("//*[@kdfid='"+changeAccessTo+"' and @kdfapp='mdmUI' and @kdfpage='changeAccess']");
		return this;
	}
	
	public NGMDM_MyDealsHomepage _02_clickSave() throws Exception
	{
		basic.click(ObjectRepository.value_353);
		return new NGMDM_MyDealsHomepage(basic);
	}
	
	public NGMDM_ChangeAccessPage _02_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.cancelButtonChangeAccess);
		return this;
	}

}
