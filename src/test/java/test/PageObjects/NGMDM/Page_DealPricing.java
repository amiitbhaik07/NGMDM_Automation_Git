package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Page_DealPricing extends Pane_LeftBarAndOrderHeader
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Page_DealPricing(BasicUtils basic) throws Exception
	{
		super(basic);
		this.basic = basic;
		//_11_expandAll();
	}	
	
	public Popup_FVAssessment _01_openFvAssessment() throws Exception
	{
		basic.click(ObjectRepository.value_30);
		basic.click(ObjectRepository.value_31);
		return new Popup_FVAssessment(basic);
	}
	
	public Popup_FVDetails _02_openFvDetails() throws Exception
	{
		basic.click(ObjectRepository.value_30);
		basic.click(ObjectRepository.value_850);
		return new Popup_FVDetails(basic);
	}
	
	public Popup_FVAuditHistory _03_openFvAuditHistory() throws Exception
	{
		basic.click(ObjectRepository.value_30);
		basic.click(ObjectRepository.value_867);
		return new Popup_FVAuditHistory(basic);
	}
	
	public Popup_FVCancel _04_cancelFv() throws Exception
	{
		basic.click(ObjectRepository.value_30);
		basic.click(ObjectRepository.value_860);
		return new Popup_FVCancel(basic);
	}
	
	public Page_DealPricing _05_viewSqf() throws Exception
	{
		basic.click(ObjectRepository.value_793);
		return this;
	}
	
	public Popup_CloneScenario _06_cloneScenario() throws Exception
	{
		basic.click(ObjectRepository.value_474);
		return new Popup_CloneScenario(basic);
	}
	
	public Page_DealPricing _07_dealConsumption() throws Exception
	{
		basic.click(ObjectRepository.utiDealConsumption);
		return this;
	}
	
	public Page_DealPricing _08_clickOnEPSLink() throws Exception
	{
		basic.click(ObjectRepository.value_535);
		basic.click(ObjectRepository.value_536);
		return this;
	}
	
	public Page_DealPricing _09_editThisQuote() throws Exception
	{
		basic.click(ObjectRepository.value_535);
		basic.click(ObjectRepository.value_769);
		basic.click(ObjectRepository.value_775);
		return this;
	}
	
	public Page_DealPricing _10_1_clickLPLPriceList() throws Exception
	{
		basic.click(ObjectRepository.value_702);
		return this;
	}
	
	public Page_DealPricing _10_2_clickGPLPriceList() throws Exception
	{
		basic.click(ObjectRepository.value_705);
		return this;
	}
	
	public Page_DealPricing _11_expandAll() throws Exception
	{
		basic.click(ObjectRepository.value_13);
		return this;
	}
	
	public Page_DealPricing _12_collapseAll() throws Exception
	{
		basic.click(ObjectRepository.collapseAll);
		return this;
	}
	
	public Page_DealPricing _13_save() throws Exception
	{
		basic.click(ObjectRepository.value_487);
		return this;
	}
	
	public Page_DealPricing _14_saveAndPublish() throws Exception
	{
		basic.click(ObjectRepository.value_16);
		return this;
	}
	
	public Popup_AddProductLine _15_editScenarioAddProductLine() throws Exception
	{
		basic.click(ObjectRepository.value_17);
		basic.click(ObjectRepository.value_509);
		return new Popup_AddProductLine(basic);
	}
	
	public Popup_AddServiceLine _16_editScenarioAddServiceLine() throws Exception
	{
		basic.click(ObjectRepository.value_17);
		basic.click(ObjectRepository.value_523);
		return new Popup_AddServiceLine(basic);
	}
	
	public Popup_AddAdjustmentLine _17_editScenarioAddAdjustmentLine() throws Exception
	{
		basic.click(ObjectRepository.value_17);
		basic.click(ObjectRepository.value_18);
		return new Popup_AddAdjustmentLine(basic);
	}
	
	public Popup_UpdateDiscount _18_editScenarioUpdateDiscount() throws Exception
	{
		basic.click(ObjectRepository.value_17);
		basic.click(ObjectRepository.value_490);
		return new Popup_UpdateDiscount(basic);
	}
	
	public Popup_UpdateOverhead _19_editScenarioUpdateOverhead() throws Exception
	{
		basic.click(ObjectRepository.value_17);
		basic.click(ObjectRepository.value_844);
		return new Popup_UpdateOverhead(basic);
	}
	
	public Page_DealPricing _20_editScenarioUpdateUpliftFactor() throws Exception
	{
		//basic.click(ObjectRepository.value_17);
		//basic.click(ObjectRepository.updateUpliftFactor);
		return this;
	}
	
	public Page_DealPricing _21_expandViewSingleSkuBundleDetailsPlusIcon() throws Exception
	{
		basic.click(ObjectRepository.expandViewSingleSkuPlusIcon);
		return this;
	}
	
	

}
