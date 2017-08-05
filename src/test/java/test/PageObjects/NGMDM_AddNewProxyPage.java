package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_AddNewProxyPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_AddNewProxyPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public NGMDM_AddNewProxyPage _01_selectTheater(String theater) throws Exception
	{
		basic.selectOption(ObjectRepository.value_383, theater);
		return this;
	}
	
	public NGMDM_AddNewProxyPage _02_selectRole(String role) throws Exception
	{
		basic.selectOption(ObjectRepository.value_384, role);
		return this;
	}
	
	public NGMDM_AddNewProxyPage _03_enterProxyName(String proxyName) throws Exception
	{
		basic.typeTextAutopopulate(ObjectRepository.value_385, proxyName);
		return this;
	}
	
	public NGMDM_AddNewProxyPage _04_makeEndDateAsTodaysDate() throws Exception
	{
		basic.click(ObjectRepository.value_392);
		basic.pause(1000);
		basic.click(ObjectRepository.value_393);
		basic.pause(1000);
		basic.click(ObjectRepository.value_393);
		basic.pause(1000);
		basic.click(ObjectRepository.value_394);
		basic.pause(1000);
		basic.click(ObjectRepository.value_394);
		basic.pause(1000);
		basic.click(ObjectRepository.value_394);
		return this;
	}
	
	public NGMDM_ExistingProxyPage _05_clickAddNewProxy() throws Exception
	{
		basic.click(ObjectRepository.value_387);
		return new NGMDM_ExistingProxyPage(basic);
	}
	
	public NGMDM_MyDealsHomepage _06_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.value_389);
		return new NGMDM_MyDealsHomepage(basic);
	}
	
	
	
	

}
