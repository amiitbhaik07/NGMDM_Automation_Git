package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_AddProductLine 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_AddProductLine(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_AddProductLine _01_selectLineType(String lineType) throws Exception
	{
		basic.selectOption(ObjectRepository.selectLineTypeDropdownProduct,lineType);
		return this;
	}
	
	public Popup_AddProductLine _02_enterProductFamily(String productFamily) throws Exception
	{
		basic.typeTextAutopopulate(ObjectRepository.productFamilyTextbox,productFamily);
		return this;
	}
	
	public Popup_AddProductLine _03_enterPartNumber(String partNumber) throws Exception
	{
		basic.typeText(ObjectRepository.value_515,partNumber);
		return this;
	}
	
	public Popup_AddProductLine _04_enterDescription(String description) throws Exception
	{
		basic.typeText(ObjectRepository.value_526,description);
		return this;
	}
	
	public Popup_AddProductLine _05_enterListPrice(String listPrice) throws Exception
	{
		basic.typeText(ObjectRepository.value_511,listPrice);
		return this;
	}
	
	public Popup_AddProductLine _06_enterQuantity(String quantity) throws Exception
	{
		basic.typeText(ObjectRepository.value_510,quantity);
		return this;
	}
	
	public Popup_AddProductLine _07_enterDiscount(String discount) throws Exception
	{
		basic.typeText(ObjectRepository.value_538,discount);
		return this;
	}
	
	public Popup_AddProductLine _08_enterExtendedNetPrice(String extNetPrice) throws Exception
	{
		basic.typeText(ObjectRepository.extendedNetPricefut,extNetPrice);
		return this;
	}
	
	public Popup_AddProductLine _09_enterStandardCost(String standardCost) throws Exception
	{
		basic.typeText(ObjectRepository.value_539,standardCost);
		return this;
	}
	
	public Popup_AddProductLine _10_enterRoyaltyCost(String royaltyCost) throws Exception
	{
		basic.typeText(ObjectRepository.royaltyCostfut,royaltyCost);
		return this;
	}
	
	public Popup_AddProductLine _11_enterOverheadCost(String overheadCost) throws Exception
	{
		basic.typeText(ObjectRepository.overheadCostfut,overheadCost);
		return this;
	}
	
	public Page_DealPricing _12_clickAddButton() throws Exception
	{
		basic.click(ObjectRepository.value_516);
		return new Page_DealPricing(basic);
	}
	
	public Page_DealPricing _13_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.addproductcancelBtn);
		return new Page_DealPricing(basic);
	}
	
	

}
