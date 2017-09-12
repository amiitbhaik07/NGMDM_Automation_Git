package test.PageObjects.NGMDM;

import org.apache.log4j.Logger;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class Popup_CompareSQF 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public Popup_CompareSQF(BasicUtils basic)
	{
		this.basic = basic;
	}	
	
	public Page_ScenarioBrowser _01_closeCompareSqf() throws Exception
	{
		basic.click(ObjectRepository.closeCompareSqf);
		return new Page_ScenarioBrowser(basic);
	}
}
