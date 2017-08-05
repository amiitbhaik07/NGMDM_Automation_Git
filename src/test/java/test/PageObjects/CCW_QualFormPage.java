package test.PageObjects;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class CCW_QualFormPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public CCW_QualFormPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public CCW_QualFormPage _01_sfdcFillQualForm(int qualFormId) throws Exception
	{
		logger.info("Filling Qual Form ID = " + qualFormId);
		switch(qualFormId)
		{
		case 1: _02_fillQualForm_ID_1();break;
		case 3: _03_fillQualForm_ID_3();break;
		case 5: _04_fillQualForm_ID_5();break;
		case 7: _05_fillQualForm_ID_7();break;
		case 9: _06_fillQualForm_ID_9();break;
		case 11: _07_fillQualForm_ID_11();break;
		case 12: _08_fillQualForm_ID_12();break;
		}
		return this;
	}
	
	public CCW_QualFormPage _02_fillQualForm_ID_1() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_128);
		basic.click(ObjectRepository.value_129);
		logger.info("Successfully filled Qual Form ID = 1");
		return this;
	}
	
	public CCW_QualFormPage _03_fillQualForm_ID_3() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		logger.info("Successfully filled Qual Form ID = 3");
		return this;
	}
	
	public CCW_QualFormPage _04_fillQualForm_ID_5() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		logger.info("Successfully filled Qual Form ID = 5");
		return this;
	}
	
	public CCW_QualFormPage _05_fillQualForm_ID_7() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		logger.info("Successfully filled Qual Form ID = 7");
		return this;
	} 
	
	public CCW_QualFormPage _06_fillQualForm_ID_9() throws Exception
	{
		basic.typeText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_127, "test");
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		logger.info("Successfully filled Qual Form ID = 9");
		return this;
	} 
	
	public CCW_QualFormPage _07_fillQualForm_ID_11() throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_96, "test");
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_99, "test");
		basic.typeText(ObjectRepository.value_100, "test");
		basic.click(ObjectRepository.value_101);
		basic.click(ObjectRepository.value_102);
		basic.click(ObjectRepository.value_105);
		basic.click(ObjectRepository.value_106);
		logger.info("Successfully filled Qual Form ID = 11");
		return this;
	}
	
	public CCW_QualFormPage _08_fillQualForm_ID_12() throws Exception
	{
		basic.clearUpdateText(ObjectRepository.value_93, "6");
		basic.click(ObjectRepository.value_94);
		basic.click(ObjectRepository.value_95);
		basic.typeText(ObjectRepository.value_96, "test");
		basic.click(ObjectRepository.value_97);
		basic.click(ObjectRepository.value_98);
		basic.click(ObjectRepository.value_103);
		basic.click(ObjectRepository.value_104);
		basic.typeText(ObjectRepository.value_99, "test");
		basic.typeText(ObjectRepository.value_100, "test");
		basic.click(ObjectRepository.value_101);
		basic.click(ObjectRepository.value_102);
		basic.click(ObjectRepository.value_128);
		basic.click(ObjectRepository.value_128);
		basic.click(ObjectRepository.value_129);
		logger.info("Successfully filled Qual Form ID = 12");
		return this;
	}
	
	public SFDC_NSReviewAndSubmitPage _09_saveAndContinueFromQualForm() throws Exception
	{
		basic.click(ObjectRepository.value_107);
		logger.info("Clicked on Save and Continue on Qual Form after filling all fields");
		return new SFDC_NSReviewAndSubmitPage(basic);
	}

}
