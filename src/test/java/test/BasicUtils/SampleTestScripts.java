package test.BasicUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestScripts 
{
	static Connection con;
	static Statement stmt;
	
	@BeforeTest
	public void dbconnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb","sys as sysdba", "amiitonoma07");
		stmt = con.createStatement();
	}
	
	@AfterTest
	public void disconnect() throws Exception
	{
		stmt.close();
		con.close();
	}
	
	/*@Test
	public void test1() throws Exception
	{
		System.out.println("_______________");
		LaunchBrowsers browsers = new LaunchBrowsers();
		WebDriver driver = browsers.launchBrowser("firefox");
		BasicUtils basic = new BasicUtils(driver);
		Modules m = new Modules(driver);
		//String str = m.createDefaultDealType2_Product_Service(true);	
		String str = "64013437,NGMDM_DNT_Automation_DealType2_ProductService_RNSD_30826";		
		String[] arr = str.split(",");
		String dealID = arr[0];
		String dealName = arr[1];	
		int result = stmt.executeUpdate("insert into ngmdm_deal_creation values ( '"+dealName+"', '"+dealID+"' )");
	}*/
	
	


}
