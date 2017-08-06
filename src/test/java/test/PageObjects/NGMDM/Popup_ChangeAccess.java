package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_ChangeAccess 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_ChangeAccess(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_ChangeAccess _01_changeAccessTo(String changeAccessTo) throws Exception
	{
		basic.pressSpaceUsingActions("//*[@kdfid='"+changeAccessTo+"' and @kdfapp='mdmUI' and @kdfpage='changeAccess']");
		return this;
	}
	
	public Page_MyDealsHomepage _02_clickSave() throws Exception
	{
		basic.click(ObjectRepository.value_353);
		return new Page_MyDealsHomepage(basic);
	}
	
	public Popup_ChangeAccess _02_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.cancelButtonChangeAccess);
		return this;
	}

}
