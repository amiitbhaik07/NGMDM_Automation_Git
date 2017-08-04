package test.NGMDM_Tabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.BasicUtils.LaunchBrowsers;
import test.BasicUtils.Modules;
import test.BasicUtils.ObjectRepository;

public class _03_DealPricing 
{/*
	LaunchBrowsers launchBrowsers; 
	Modules commonFunctions;
	BasicCommands basic;
	Connection con;
	Statement stmt;
	ResultSet rset;
		
	@BeforeTest
	public void beforeTest() throws Exception
	{
		System.out.println("Before Test");
		launchBrowsers = new LaunchBrowsers();
		basic = new BasicCommands(); 
		commonFunctions = new Modules();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb", "sys as sysdba", "amiitonoma07");
		stmt = con.createStatement();
	}
	
	public ResultSet getResultSet(String tabno, String testcaseno) throws Exception
	{
		return stmt.executeQuery("select * from ngmdm_data where tabno='"+tabno+"' and testcaseno='"+testcaseno+"'");
	}
	
	
	@Test
	public void test1() throws Exception
	{
		System.out.println("Test1");
		ResultSet rset = getResultSet("03","16");
		System.out.println(rset.getString("testcasename"));
		System.exit(0);
		
		WebDriver driver = launchBrowsers.launchBrowser("chrome");
		commonFunctions.mdmLogin(driver, ObjectRepository.duabhish);
		commonFunctions.openDealID(driver, "61000156");
		
	}
	
	@AfterTest
	public void afterTest() throws Exception
	{
		System.out.println("After Test");
	}
	
*/}
