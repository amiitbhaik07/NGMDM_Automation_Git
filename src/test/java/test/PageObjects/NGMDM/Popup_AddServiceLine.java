package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_AddServiceLine 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_AddServiceLine(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_AddServiceLine _01_selectLineType(String lineType) throws Exception
	{
		basic.selectOption(ObjectRepository.selectLineTypeDropdownService,lineType);
		return this;
	}
	
	public Popup_AddServiceLine _02_selectServiceCategory(String serviceCategory) throws Exception
	{
		basic.selectOption(ObjectRepository.serviceCategoryfut,serviceCategory);
		return this;
	}
	
	public Popup_AddServiceLine _03_enterPartNumber(String partNumber) throws Exception
	{
		basic.typeText(ObjectRepository.value_527,partNumber);
		return this;
	}
	
	public Popup_AddServiceLine _04_enterDescription(String description) throws Exception
	{
		basic.typeText(ObjectRepository.value_526,description);
		return this;
	}
	
	public Popup_AddServiceLine _05_enterAnnualListPrice(String annualListPrice) throws Exception
	{
		basic.typeText(ObjectRepository.value_511,annualListPrice);
		return this;
	}
	
	public Popup_AddServiceLine _06_enterQuantity(String quantity) throws Exception
	{
		basic.typeText(ObjectRepository.value_510,quantity);
		return this;
	}
	
	public Popup_AddServiceLine _07_enterDuration(String duration) throws Exception
	{
		basic.typeText(ObjectRepository.value_528,duration);
		return this;
	}
	
	public Popup_AddServiceLine _08_enterDiscount(String discount) throws Exception
	{
		basic.typeText(ObjectRepository.value_538,discount);
		return this;
	}
	
	public Popup_AddServiceLine _09_enterPrepayDiscount(String prePayDiscount) throws Exception
	{
		basic.typeText(ObjectRepository.prePayDiscountfut,prePayDiscount);
		return this;
	}
	
	public Popup_AddServiceLine _10_enterExtendedNetPrice(String extNetPrice) throws Exception
	{
		basic.typeText(ObjectRepository.extendedNetPricefut,extNetPrice);
		return this;
	}
	
	public Popup_AddServiceLine _11_enterServiceCost(String serviceCost) throws Exception
	{
		basic.typeText(ObjectRepository.serviceCostfut,serviceCost);
		return this;
	}
	
	public Popup_AddServiceLine _12_enterGrossMargin(String grossMargin) throws Exception
	{
		basic.typeText(ObjectRepository.grossmarginfut,grossMargin);
		return this;
	}
	
	public Popup_AddServiceLine _13_enterGrossMarginPercentage(String grossMarginPercent) throws Exception
	{
		basic.typeText(ObjectRepository.grossmarginperfut,grossMarginPercent);
		return this;
	}
		
	public Page_DealPricing _14_clickAddButton() throws Exception
	{
		basic.click(ObjectRepository.value_529);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _15_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.addservicecancelBtn);
		return new Page_DealPricing(basic);
	}
	
	

}
