package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_EditDeal 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_EditDeal(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_EditDeal _01_changeDealStatus(String selectDealStatus) throws Exception
	{
		basic.selectOption(ObjectRepository.dealStatusSelectbox, selectDealStatus);
		return this;
	}
	
	public Popup_EditDeal _02_enterNewPrimaryProductDd(String primaryProductDd) throws Exception
	{
		basic.clearText(ObjectRepository.value_356);
		basic.typeTextAutopopulate(ObjectRepository.value_356, primaryProductDd);
		return this;
	}
	
	public Popup_EditDeal _03_enterNewSecondaryProductDd(String secondaryProductDd) throws Exception
	{
		basic.clearText(ObjectRepository.editDealSecondaryDD);
		basic.typeTextAutopopulate(ObjectRepository.editDealSecondaryDD, secondaryProductDd);
		return this;
	}
	
	public Popup_EditDeal _04_enterNewServiceDd(String serviceDd) throws Exception
	{
		basic.clearText(ObjectRepository.value_355);
		basic.typeTextAutopopulate(ObjectRepository.value_355, serviceDd);
		return this;
	}
	
	public Page_MyDealsHomepage _05_clickOnSaveButton() throws Exception
	{
		basic.click(ObjectRepository.value_357);
		return new Page_MyDealsHomepage(basic);
	}
	
	
	
	
}
