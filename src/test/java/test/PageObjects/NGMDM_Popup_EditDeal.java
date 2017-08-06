package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class NGMDM_Popup_EditDeal 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public NGMDM_Popup_EditDeal(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public NGMDM_Popup_EditDeal _01_changeDealStatus(String selectDealStatus) throws Exception
	{
		basic.selectOption(ObjectRepository.dealStatusSelectbox, selectDealStatus);
		return this;
	}
	
	public NGMDM_Popup_EditDeal _02_enterNewPrimaryProductDd(String primaryProductDd) throws Exception
	{
		basic.clearText(ObjectRepository.value_356);
		basic.typeTextAutopopulate(ObjectRepository.value_356, primaryProductDd);
		return this;
	}
	
	public NGMDM_Popup_EditDeal _03_enterNewSecondaryProductDd(String secondaryProductDd) throws Exception
	{
		basic.clearText(ObjectRepository.editDealSecondaryDD);
		basic.typeTextAutopopulate(ObjectRepository.editDealSecondaryDD, secondaryProductDd);
		return this;
	}
	
	public NGMDM_Popup_EditDeal _04_enterNewServiceDd(String serviceDd) throws Exception
	{
		basic.clearText(ObjectRepository.value_355);
		basic.typeTextAutopopulate(ObjectRepository.value_355, serviceDd);
		return this;
	}
	
	public NGMDM_Page_MyDealsHomepage _05_clickOnSaveButton() throws Exception
	{
		basic.click(ObjectRepository.value_357);
		return new NGMDM_Page_MyDealsHomepage(basic);
	}
	
	
	
	
}
