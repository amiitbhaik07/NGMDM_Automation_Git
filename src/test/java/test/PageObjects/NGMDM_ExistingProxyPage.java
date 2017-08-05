package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_ExistingProxyPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_ExistingProxyPage(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public NGMDM_AddNewProxyPage _01_addNewProxy() throws Exception
	{
		basic.click(ObjectRepository.value_382);
		return new NGMDM_AddNewProxyPage(basic);
	}
	
	public NGMDM_MyDealsHomepage _02_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.value_382);
		return new NGMDM_MyDealsHomepage(basic);
	}
	

}
