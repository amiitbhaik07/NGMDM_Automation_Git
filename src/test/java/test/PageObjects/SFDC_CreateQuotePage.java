package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class SFDC_CreateQuotePage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public SFDC_CreateQuotePage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public CCW_ItemsPage _00_proceedWithDefaultValues(boolean isRnsd) throws Exception
	{
		_01_clickRadioButton(isRnsd);
		_02_selectDefaultPriceList();
		_03_selectDefaultBuyMethod();
		_04_selectDefaultDealCategory();
		return _08_clickCreateQuoteButton();
	}
	
	public SFDC_CreateQuotePage _01_clickRadioButton(boolean isRnsd) throws Exception
	{
		basic.click(ObjectRepository.sfdc_createQuote_label);
		basic.pause(5000);
		if(basic.isRewrite())
		{
			if(isRnsd)
			{
				basic.click(ObjectRepository.value_189);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.value_115);
				logger.info("Clicked on Transactional Radio button");
			}
		}
		else
		{
			if(isRnsd)
			{				
				basic.click(ObjectRepository.rnsd_radio);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.transactional_radio);
				logger.info("Clicked on Transactional Radio button");
			}
		}
		return this;
	}
	
	public SFDC_CreateQuotePage _02_selectDefaultPriceList() throws Exception
	{
		return _05_selectSpecificPriceList("Global Price List in US Dollars");
	}
	
	public SFDC_CreateQuotePage _03_selectDefaultBuyMethod() throws Exception
	{
		return _06_selectSpecificBuyMethod("Cisco");
	}
	
	public SFDC_CreateQuotePage _04_selectDefaultDealCategory() throws Exception
	{
		return _07_selectSpecificDealCategory("Outsource");
	}
	
	public SFDC_CreateQuotePage _05_selectSpecificPriceList(String priceList) throws Exception
	{
		if(basic.isRewrite())
		{
			basic.selectOption(ObjectRepository.value_116, priceList);
		}
		else
		{
			basic.click(ObjectRepository.proceList_dropdown);
			basic.click(ObjectRepository.priceList_USD_value);
		}
		return this;
	}
	
	public SFDC_CreateQuotePage _06_selectSpecificBuyMethod(String buyMethod) throws Exception
	{
		if(basic.isRewrite())
		{
			basic.selectOption(ObjectRepository.value_117, buyMethod);
		}
		else
		{
			basic.click(ObjectRepository.buyMethod_dropdown);
			basic.click(ObjectRepository.buyMethod_Cisco_value);
		}
		return this;
	}
	
	public SFDC_CreateQuotePage _07_selectSpecificDealCategory(String dealCategory) throws Exception
	{
		if(basic.isRewrite())
		{
			basic.selectOption(ObjectRepository.value_118, dealCategory);
		}
		else
		{
			basic.click(ObjectRepository.dealCategory_dropdown);
			basic.click(ObjectRepository.dealCategory_Outsource_value);
		}
		return this;
	}
	
	public CCW_ItemsPage _08_clickCreateQuoteButton() throws Exception
	{
		if(basic.isRewrite())
		{
			basic.click(ObjectRepository.value_119);
		}
		else
		{
			basic.click(ObjectRepository.createDeal_button);
		}
		logger.info("Clicked on Create Quote on Quote Initiation Page");
		return new CCW_ItemsPage(basic);
	}
	
	
	
	/*public ItemsPage _09_sfdcFillCreateQuotePageAndContinueDefault(boolean isRnsd) throws Exception
	{
		basic.click(ObjectRepository.sfdc_createQuote_label);
		basic.pause(5000);
		if(basic.isRewrite())
		{
			if(isRnsd)
			{
				basic.click(ObjectRepository.value_189);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.value_115);
				logger.info("Clicked on Transactional Radio button");
			}
			basic.selectOption(ObjectRepository.value_116, "Global Price List in US Dollars");
			basic.selectOption(ObjectRepository.value_117, "Cisco");
			basic.selectOption(ObjectRepository.value_118, "Outsource");
			basic.click(ObjectRepository.value_119);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
		else
		{
			if(isRnsd)
			{				
				basic.click(ObjectRepository.rnsd_radio);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.transactional_radio);
				logger.info("Clicked on Transactional Radio button");
			}			
			basic.click(ObjectRepository.proceList_dropdown);
			basic.click(ObjectRepository.priceList_USD_value);
			basic.click(ObjectRepository.buyMethod_dropdown);
			basic.click(ObjectRepository.buyMethod_Cisco_value);
			basic.click(ObjectRepository.dealCategory_dropdown);
			basic.click(ObjectRepository.dealCategory_Outsource_value);
			basic.click(ObjectRepository.createDeal_button);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
		
		return new ItemsPage(basic);		
	}	
	
	public ItemsPage _10_sfdcFillCreateQuotePageAndContinue_EMEAR(boolean isRnsd) throws Exception
	{
		basic.click(ObjectRepository.sfdc_createQuote_label);
		basic.pause(5000);
		if(basic.isRewrite())
		{
			if(isRnsd)
			{
				basic.click(ObjectRepository.value_189);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.value_115);
				logger.info("Clicked on Transactional Radio button");
			}
			basic.selectOption(ObjectRepository.value_116, "Global Price List EMEA Availability");
			basic.selectOption(ObjectRepository.value_117, "Cisco");
			basic.selectOption(ObjectRepository.value_118, "Outsource");
			basic.click(ObjectRepository.value_119);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
		else
		{
			if(isRnsd)
			{				
				basic.click(ObjectRepository.rnsd_radio);
				logger.info("Clicked on RNSD Radio button");
			}
			else
			{
				basic.click(ObjectRepository.transactional_radio);
				logger.info("Clicked on Transactional Radio button");
			}			
			basic.click(ObjectRepository.proceList_dropdown);
			basic.click(ObjectRepository.priceList_USD_value);
			basic.click(ObjectRepository.buyMethod_dropdown);
			basic.click(ObjectRepository.buyMethod_Cisco_value);
			basic.click(ObjectRepository.dealCategory_dropdown);
			basic.click(ObjectRepository.dealCategory_Outsource_value);
			basic.click(ObjectRepository.createDeal_button);
			logger.info("Clicked on Create Quote on Quote Initiation Page");
		}
		return new ItemsPage(basic);
	}*/
	

}
