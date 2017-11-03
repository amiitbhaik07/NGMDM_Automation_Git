package test.BasicUtils;

public class Constants {
	public static final int defaultTimeoutSeconds = 180;
	public static final long ifLogicTimeoutSeconds = 30;
	public static final int ifVisibleTimeoutSeconds = 5;
	public static final int waitForAmAppearanceSeconds = 120;	
	
	public static final long notPresenceTimeoutMillis = 30000;
	public static final int actionTryGapMillis = 5000;	
	public static final int defaultPauseMillis = 75;
	public static final int preLoaderDefaultPauseMillis = 75;
	
	public static final int actionTryCount = 7;
	
	public static final int defaultVerticalScrollPixel = 100;
	public static final int defaultHorizontalScrollPixel = 30;
	
	public static final String preLoaderXpath = "//img[contains(@src,'preloader')]";
	
	public static final String defaultSfdcAm_US = "thaymore";
	public static final String defaultSfdcAm_EMEAR = "beheard";
	public static String sfdc_sandbox = "reg";
	
	
	//Advanced Search Dropdown Values
	public static final String dealsForWhichDealIdIsKnown = "Deals for which deal id is known";
	public static final String dealsReferencingYouAs = "Deals Referencing You as CAM/ICAM/AM";
	public static final String dealsWhereIAmAnApprover = "Deals Where I am an Approver";
	public static final String dealsPendingMyApproval = "Deals Pending My Approval";	
	
	//Database Connection
	public static final String dbUrl = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=64.101.52.171)(PORT=1541))(ADDRESS=(PROTOCOL=TCP)(HOST=64.101.52.172)(PORT=1541)))(CONNECT_DATA=(SERVICE_NAME=TS1DMP.cisco.com)(SERVER=DEDICATED))) ";
	public static final String dbUsername = "XXAPPSRO";
	public static final String dbPassword = "R3ad_0nly";	
	
	//Default SKU Names
	public static final String defaultProduct = "CISCO1921DC/K9";
	public static final String defaultService = "CON-SNT3-LAP1252A";		//CON-SNT3-LAP1252A //CON-SNT-00000003
	public static final String defaultSubscription = "IVR-3.X-PORTS=";		//CIP-TRN-APESS-OL= 	//IVR-3.X-PORTS=	//A-WX-NAMED-USER 
	public static final String defaultOnPremSku = "A-HCS-UC-ERLY-TM"; //"A-HCS-UC-ERLY-TM";
	public static final String defaultUcsSku = "UCS-FAN-6248UP=";
	public static final String defaultOaSku = "CON-ECMU-C1FBC45S";
	
	public static final String defaultEstimate = "SK73171017YE";
	
	//Default SKU Quantities
	public static final int defaultProductQty = 1;
	public static final int defaultServiceQty = 50;		
	public static final int defaultSubscriptionQty = 1;
	
	//Default SKU Discounts
	public static final int defaultProductDiscount = 75;
	public static final int defaultServiceDiscount = 75;		
	public static final int defaultSubscriptionDiscount = 75;
}
