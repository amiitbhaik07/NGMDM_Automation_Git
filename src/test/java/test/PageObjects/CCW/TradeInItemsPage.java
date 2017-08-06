package test.PageObjects.CCW;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class TradeInItemsPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public TradeInItemsPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public TradeInItemsPage _01_addDefaultTradeInItems() throws Exception
	{
		_02_addSpecificTradeInItems("Cisco");
		return this;
	}	
	
	public TradeInItemsPage _02_addSpecificTradeInItems(String tradeInItem) throws Exception
	{
		basic.click(ObjectRepository.value_74);
		basic.click(ObjectRepository.value_75);
		basic.clearUpdateText(ObjectRepository.value_75, tradeInItem);
		basic.click(ObjectRepository.value_76);
		basic.doubleClick(ObjectRepository.value_75);
		basic.click(ObjectRepository.value_75);
		basic.click(ObjectRepository.value_77);
		basic.click(ObjectRepository.value_78);
		basic.typeText(ObjectRepository.value_78, "10");
		basic.click(ObjectRepository.value_79);
		logger.info("Added Tradein Item : " + tradeInItem);
		return this;
	}
	
	public DiscountsAndCreditsPage _03_saveAndContinueFromTradeInItemsPage() throws Exception
	{
		basic.click(ObjectRepository.value_80);
		return new DiscountsAndCreditsPage(basic);
	}

}
