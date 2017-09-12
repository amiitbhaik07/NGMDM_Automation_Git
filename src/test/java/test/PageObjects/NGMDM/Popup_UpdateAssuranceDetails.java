package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_UpdateAssuranceDetails 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_UpdateAssuranceDetails(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Popup_UpdateAssuranceDetails _01_updateAssurerRole(String assurerRole) throws Exception
	{
		basic.selectOption(ObjectRepository.updateAssuranceDetails_assurerRole,assurerRole);
		return this;
	}
	
	public Popup_UpdateAssuranceDetails _02_updateAssurerName(String assurerName) throws Exception
	{
		basic.clearText(ObjectRepository.updateAssuranceDetails_assurerName);
		basic.typeTextAutopopulate(ObjectRepository.updateAssuranceDetails_assurerName,assurerName);
		return this;
	}
	
	public Popup_UpdateAssuranceDetails _03_updateInstructions(String instructions) throws Exception
	{
		basic.clearText(ObjectRepository.value_268);
		basic.typeText(ObjectRepository.value_268,instructions);
		return this;
	}	
		
	public Page_DealSummary _04_clickSaveButton() throws Exception
	{
		basic.click(ObjectRepository.value_269);
		return new Page_DealSummary(basic);
	}
	
	public Page_DealSummary _05_clickCancelButton() throws Exception
	{
		basic.click(ObjectRepository.updateAssuranceDetails_cancel);
		return new Page_DealSummary(basic);
	}

}
