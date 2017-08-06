package test.PageObjects.CCW;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Constants;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class ItemsPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public ItemsPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public ItemsPage _01_quotingSetPreferences() throws Exception
	{
		logger.info("Setting Quoting Preferences");
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.waitForElementClickable(ObjectRepository.sfdc_setQuotePreferences_link);
		basic.click(ObjectRepository.sfdc_setQuotePreferences_link);
		basic.pause(5000);
		basic.waitForElementClickable(ObjectRepository.sfdc_selfService_radio);
		basic.click(ObjectRepository.sfdc_selfService_radio);
		basic.pause(5000);
		basic.waitForElementClickable(ObjectRepository.value_122);
		basic.click(ObjectRepository.value_122);
		logger.info("Successfully Set Quoting Preferences");
		return this;
	}
	
	public ItemsPage _02_addDefaultProduct() throws Exception
	{
		_05_addDefaultProduct(Constants.defaultProductQty);
		return this;
	}
	
	public ItemsPage _03_addDefaultService() throws Exception
	{
		_06_addDefaultService(Constants.defaultServiceQty);
		return this;
	}
	
	public ItemsPage _04_addDefaultSubscription() throws Exception
	{
		_09_addSpecificSubscriptionWithQty(Constants.defaultSubscription, 1);
		return this;
	}
	
	public ItemsPage _05_addDefaultProduct(int qty) throws Exception
	{
		_07_addSpecificProductWithQty(Constants.defaultProduct, qty);
		return this;
	}
	
	public ItemsPage _06_addDefaultService(int qty) throws Exception
	{
		_08_addSpecificServiceWithQty(Constants.defaultService, qty);
		if(basic.knowIfAppears(ObjectRepository.service_duration_tb))
		{
			basic.typeText(ObjectRepository.service_duration_tb, "6");
			basic.click(ObjectRepository.service_add_button);
		}
		return this;
	}
	
	public ItemsPage _07_addSpecificProductWithQty(String product, int qty) throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, product);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, ""+qty);
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added product '"+product+"' with quantity '"+qty+"'");
		return this;
	}
	
	public ItemsPage _08_addSpecificServiceWithQty(String service, int qty) throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, service);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, ""+qty);
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added service '"+service+"' with quantity '"+qty+"'");
		return this;
	}
	
	public ItemsPage _09_addSpecificSubscriptionWithQty(String subscription, int qty) throws Exception
	{
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, subscription);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, ""+qty);
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.value_64);
		if(basic.knowIfAppears(ObjectRepository.username_tb))
		{
			basic.typeText(ObjectRepository.username_tb, "sunchand");
			basic.typeText(ObjectRepository.password_tb, "cisco123");
			basic.click(ObjectRepository.login_button);
		}
		basic.click(ObjectRepository.value_65);
		if(basic.knowIfAppears(ObjectRepository.value_66))
		{
			basic.click(ObjectRepository.value_66);
		}		
		basic.click(ObjectRepository.value_67);
		basic.typeText(ObjectRepository.value_67, "100");
		basic.click(ObjectRepository.value_68);
		basic.click(ObjectRepository.value_69);
		basic.click(ObjectRepository.value_70);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added subscription '"+subscription+"' with quantity '"+qty+"'");
		return this;
	}
	
	public ItemsPage _10_addDefaultOnPremSku() throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.typeText(ObjectRepository.sfdc_descriptionProduct_tb, Constants.defaultOnPremSku);
		basic.click(ObjectRepository.sfdc_skuQty_tb);
		basic.typeText(ObjectRepository.sfdc_skuQty_tb, "1");
		basic.click(ObjectRepository.sfdc_addSku_button);
		basic.click(ObjectRepository.value_64);
		basic.typeText(ObjectRepository.username_tb, "sunchand");
		basic.typeText(ObjectRepository.password_tb, "cisco123");
		basic.click(ObjectRepository.login_button);
		basic.click(ObjectRepository.value_197);
		basic.click(ObjectRepository.value_198);
		basic.typeText(ObjectRepository.value_198, "100");
		basic.click(ObjectRepository.value_199);
		basic.click(ObjectRepository.value_69);
		basic.click(ObjectRepository.value_70);
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		logger.info("Added default OA SKU : " + Constants.defaultOnPremSku);
		return this;
	}
	
	public TradeInItemsPage _11_addTradeInItems() throws Exception
	{
		basic.click(ObjectRepository.sfdc_descriptionProduct_tb);
		basic.click(ObjectRepository.value_71);
		basic.click(ObjectRepository.value_72);
		basic.click(ObjectRepository.value_73);
		return new TradeInItemsPage(basic);		
	}
	
	public DiscountsAndCreditsPage _12_saveAndContinueFromItemsTab() throws Exception
	{
		basic.click(ObjectRepository.saveAndCont_itemsTab_button);
		basic.pause(2000);
		basic.waitForPreloaderDisappear();
		basic.waitForPageToLoad1();
		basic.pause(500);
		basic.waitForPreloaderDisappear();
		for(int i=0; i<Constants.actionTryCount; i++)
		{
			if(basic.knowIfAppears("//*[@kdfpage='discountscreditstab']"))
			{
				break;
			}
			else
			{
				basic.pause(2000);
				basic.click(ObjectRepository.saveAndCont_itemsTab_button);
				logger.info("Error in Try number '"+(i+1)+"' upon clicking Save and Continue on Items Tab");
			}
		}
		logger.info("Clicked on Save and Continue on Items tab");
		return new DiscountsAndCreditsPage(basic);
	}
	
	
}
