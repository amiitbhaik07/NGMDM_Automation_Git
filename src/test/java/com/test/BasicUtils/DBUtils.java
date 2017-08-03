package com.test.BasicUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBUtils 
{
	public Connection getConnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=64.100.226.68)(PORT=1541))(ADDRESS=(PROTOCOL=TCP)(HOST=64.100.226.69)(PORT=1541)))(CONNECT_DATA=(SERVICE_NAME=TS1PDB.cisco.com)(SERVER=DEDICATED)))", "WIPSADM", "W1#abc_06");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@"+Constants.dbUrl, Constants.dbUsername, Constants.dbPassword);
		System.out.println("Got connection");
		return con;
	}
	
	public String fetchAM(Connection con, String dealId) throws Exception
	{
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String query = "select AM_EMAIL from cq_ccw_all_deal  where OPTY_NUMBER = '"+dealId+"'";
		ResultSet rset = stmt.executeQuery(query);
		String am = "";
				
		long startTime = System.currentTimeMillis();
		while((System.currentTimeMillis()-startTime)/1000 < Constants.waitForAmAppearanceSeconds)
		{
			try
			{
				rset.next();
			}
			catch(Exception e)
			{
				throw new Exception("Unable to retrieve any rows for Deal ID : " + dealId);
			}
			am = rset.getString("AM_EMAIL");
			
			if(am!=null)
			{				
				System.out.println("Got AM : " + am);
				rset.close();
				stmt.close();
				return am.trim();
			}
			else
			{
				System.out.println("AM is still NULL : " + am);
				Thread.sleep(5000);
				rset = stmt.executeQuery(query);
			}
		}		
		return null;
	}
	
	/*public static void main(String args[]) throws Exception
	{
		DBUtils d = new DBUtils();
		Connection con = d.getConnection();
		d.fetchAM(con, "25763367");
		con.close();
	}*/

}
