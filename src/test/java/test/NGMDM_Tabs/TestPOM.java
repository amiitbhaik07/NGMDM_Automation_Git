package test.NGMDM_Tabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.BasicUtils.BasicUtils;
import test.BasicUtils.LaunchBrowsers;
import test.PageObjects.Login.LoginPage;

public class TestPOM 
{	
	static Connection con = null;
	static Statement stmt = null;
	
	@BeforeTest
	public void dbConnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb","sys as sysdba","amiitonoma07");
		stmt = con.createStatement();
	}
	
	public void createDealType2() throws Exception
	{
		System.out.println("Deal type 2");		
		WebDriver driver = LaunchBrowsers.launchBrowser();
		BasicUtils basic = new BasicUtils(driver);	
		
		throw new Exception();
		
		/*String optyName = "NGMDM_Automation_DNT_DealType2_RNSD_ImportedEstimate_" + new SimpleDateFormat("dd_MMM_hh_mm_ss").format(new Date());
		String dealId = 
		new LoginPage(basic)
						._01_sfdcLogin("thaymore", "cisco123")
						._01_createNewParentOpportunity()
						._02_1_fillAndSaveNewOpportunitySFDCPageDefault(optyName)
						._01_proceedWithDefaultValuesAndContinue()
						._01_createQuoteFromOpty()
						._00_proceedWithDefaultValues(true)
						._12_ImportDefaultEstimate()
						._12_saveAndContinueFromItemsTab()
						._01_addDefaultNSDiscount()
						._03_saveAndContinueFromDiscountsTab()
						._03_finishAndSaveFromRnSTab()
						._01_continueToQualForm()
						._07_fillQualForm_ID_11()
						._09_saveAndContinueFromQualForm()
						._01_submitDealForQualification(true)
						._01_AssertDealSuccessPage()
						._02_getDealID();
		
		try
		{
			basic.takeScreenshot();
		}
		catch(Exception e){}
		
		try
		{
			basic.quitDriver();
		}
		catch(Exception e){}
		
		try
		{
			String query = "insert into ngmdm_deals_q2_fy18 values ('"+dealId+"','"+optyName+"',sysdate,'N')";			
			stmt.executeQuery(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	@Test
	public void testDeal00() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal01() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal02() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal03() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal04() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal05() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal06() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal07() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal08() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal09() throws Exception
	{
		createDealType2();
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testDeal10() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal11() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal12() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal13() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal14() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal15() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal16() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal17() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal18() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal19() throws Exception
	{
		createDealType2();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testDeal20() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal21() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal22() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal23() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal24() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal25() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal26() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal27() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal28() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal29() throws Exception
	{
		createDealType2();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testDeal30() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal31() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal32() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal33() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal34() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal35() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal36() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal37() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal38() throws Exception
	{
		createDealType2();
	}
	
	@Test
	public void testDeal39() throws Exception
	{
		createDealType2();
	}
	
	
	
}
