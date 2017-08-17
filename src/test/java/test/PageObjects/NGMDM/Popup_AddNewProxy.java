package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_AddNewProxy 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	
	public Popup_AddNewProxy(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public Popup_AddNewProxy _01_selectTheater(String theater) throws Exception
	{
		basic.selectOption(ObjectRepository.value_383, theater);
		return this;
	}
	
	public Popup_AddNewProxy _02_selectRole(String role) throws Exception
	{
		basic.selectOption(ObjectRepository.value_384, role);
		return this;
	}
	
	public Popup_AddNewProxy _03_enterProxyName(String proxyName) throws Exception
	{
		basic.typeTextAutopopulate(ObjectRepository.value_385, proxyName);
		return this;
	}
	
	public Popup_AddNewProxy _04_makeEndDateAsTodaysDate() throws Exception
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
	
	public Popup_ExistingProxy _05_clickAddNewProxy() throws Exception
	{
		basic.click(ObjectRepository.value_387);
		return new Popup_ExistingProxy(basic);
	}
	
	public Page_MyDealsHomepage _06_clickCancel() throws Exception
	{
		basic.click(ObjectRepository.value_389);
		return new Page_MyDealsHomepage(basic);
	}
	
	
	
	

}
