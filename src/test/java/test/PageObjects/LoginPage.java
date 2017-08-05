package test.PageObjects;

import org.apache.log4j.Logger;
import test.BasicUtils.BasicUtils;
import test.BasicUtils.Constants;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class LoginPage 
{
	BasicUtils basic;
	private static Logger logger = Logger.getLogger(Modules.class);
	
	public LoginPage(BasicUtils basic)
	{
		this.basic = basic;
	}
	
	public SFDC_HomePage _01_sfdcLogin(String username, String password) throws Exception
	{
		basic.clearBrowserCache();
		basic.justNavigate(ObjectRepository.salesforce_url);
		String uname = username+"@cisco.com."+Constants.sfdc_sandbox;
		basic.typeText(ObjectRepository.sfdc_username_tb, uname);
		basic.typeText(ObjectRepository.sfdc_password_tb, password);
		basic.click(ObjectRepository.sfdc_login_button);
		if(basic.knowIfAppears(ObjectRepository.sfdc_changePasswordCancel_button))
		{
			basic.click(ObjectRepository.sfdc_changePasswordCancel_button);
		}
		logger.info("SFDC Login Successful for '"+uname+"' / '"+password+"' for URL : " + ObjectRepository.salesforce_url);
		return new SFDC_HomePage(basic);
	}
	
	public SFDC_HomePage _02_1_sfdcLoginDefaultAM_US() throws Exception
	{
		return _01_sfdcLogin(Constants.defaultSfdcAm_US, "cisco123");
	}
	
	public SFDC_HomePage _02_2_sfdcLoginDefaultAM_EMEAR() throws Exception
	{
		return _01_sfdcLogin(Constants.defaultSfdcAm_EMEAR, "cisco123");
	}
	
	public NGMDM_MyDealsHomepage _03_ngmdmLogin(String userName) throws Exception
	{
		basic.clearBrowserCache();
		basic.justNavigate(ObjectRepository.mdmProxy_Url);
		basic.typeText(ObjectRepository.username_tb, ObjectRepository.mdmProxyUsername);
		basic.typeText(ObjectRepository.password_tb, ObjectRepository.mdmProxyPassword);
		basic.click(ObjectRepository.login_button);
		basic.typeText(ObjectRepository.proxyId_tb, userName);
		basic.click(ObjectRepository.proxyIdSubmit_button);
		return new NGMDM_MyDealsHomepage(basic);
	}
	
	
	
	
	

}
