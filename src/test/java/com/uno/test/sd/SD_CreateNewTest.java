package com.uno.test.sd;



import io.qameta.allure.Description;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;

import bsh.ParseException;


public class SD_CreateNewTest extends BaseCode 
{
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_TicketPage sd_TicketPage;
	SD_CreateNewPage sd_createNewPage;
	SD_ViewTicketPage sd_ViewTicketPage;

	public SD_CreateNewTest() 
	{

		super();

	}

	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception 
	{
		initialization();

		sd_LoginPage = new SD_LoginPage();
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));
		
		Thread.sleep(2000);
		sd_HomePage = new SD_HomePage();
		sd_TicketPage = sd_HomePage.ticketTab();
		Thread.sleep(1000);
		sd_createNewPage = sd_TicketPage.createNewTab();
		Thread.sleep(1000);
		

	}
	@Test(priority = 1, groups = { "Smoke Testing" }, description = "Check  title of page")
	@Description("Check  title of page")
	public void VerifyTitleOfCreateNewPage() throws Exception 
	{
		sd_createNewPage.verifyTitleOfCreateNewPage();
		Thread.sleep(2000);

	}

	@Test(priority = 2, groups = { "Smoke Testing"  }, description = "Display Default Incident No")
	@Description("Display Default Incident No")
	public void CheckDefaultIncidentNo()
	{
		sd_createNewPage.checkDefaultIncidentNo();
		
	}

	@Test(priority = 3,  groups = { "Smoke Testing"  }, description = "verify incident date and time is equal to system date and time or not")
	@Description("verify incident date and time is equal to system date and time or not")
	public void CheckDefaultIncidentDateTime() throws Exception 
	{
		sd_createNewPage.checkDefaultIncidentDateTime();
	}

	@Test(priority = 4,  groups = { "Smoke Testing"  }, description = "Check the default value of create By ,is should be sd")
	@Description("Check the default value of create By ,is should be sd")
	public void CheckDefaultCreateByRoleElement() throws ParseException 
	{
		sd_createNewPage.checkDefaultCreateByRoleElement();
	}

	@Test(priority = 5,  groups = { "Smoke Testing"  }, description = "Check the default value of close Date Time ,is should be blank")
	@Description("Check the default value of close Date Time ,is should be blank")
	public void CheckDefaultcloseDateTime() throws ParseException
	{
		sd_createNewPage.checkDefaultcloseDateTime();
		
	}

	@Test(priority = 6,  groups = { "Smoke Testing"  }, description = "Check that the Ticket date time is equal to the system date and time")
	@Description("Check that the Ticket date time is equal to the system date and time")
	public void VerifyTicketDateTime() throws Exception
	{
		sd_createNewPage.verifyTicketDateTime();
	}

	@Test(priority = 7,  groups = { "Smoke Testing"  }, description = "If user select the My default business unit then, the same business unit is "
			+ "appere in Requestor Details")
	@Description("If user select the My default business unit then, the same business unit is "
			+ "appere in Requestor Details")
	public void CheckDefaultBusinessUnit() throws InterruptedException 
	{

		sd_createNewPage.checkDefaultBusinessUnit();

	}
	
	@Test(priority = 8, groups = {"Smoke Testing"}, invocationCount = 1 , description = "check that ticket is log or not") 
	@Description("check that ticket is log or not")
	public void CreateTicket() throws Exception
	{
		
		Thread.sleep(1000);
		sd_createNewPage.createNewTicket();

	}
	

	@Test(priority = 9 , groups = {"Regression Testing"}, description = "1.If User enter the ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular id then in view page it display only selected ID ")
	@Description("1.If User enter the ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular id then in view page it display only selected ID ")
	public void CheckSearchIdTextBox() throws InterruptedException 
	{
		sd_createNewPage.verifyIdTextBox();
		
	}

	@Test(priority = 10, groups = {"Regression Testing"}, description = "1.If User enter the Assert ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular Assert Id then in view page it display only selected ID")
	@Description("1.If User enter the Assert ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular Assert Id then in view page it display only selected ID")
	public void VerifyAssetIDTextBox() throws Exception
	{
		sd_createNewPage.verifyAssetIDTextBox();
		
	}

	@Test(priority = 11, groups = {"Regression Testing"}, description = "1.If User enter the Ticket ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the particular Ticket Id then in view page it display only selected ID")
	@Description("1.If User enter the Ticket ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the particular Ticket Id then in view page it display only selected ID")
	public void VerifyTicketIdTextBox() throws Exception 
	{
		sd_createNewPage.verifyTicketIdTextBox();
		
	}
	
	@Test(priority = 12, groups = {"Regression Testing"}, description = "If user select the serial number then asset id value should be matched with requestor detail asset id")
	@Description("If user select the serial number then asset id value should be matched with requestor detail asset id")
	public void CheckAssetIdRelatedToSiteCode() throws InterruptedException
	{
		sd_createNewPage.checkAssetIdRelatedToSiteCode();

	}

   @Test(priority = 13, groups = {"Regression Testing"}, description = "If user enter the serial number in log by serial number then the detail is dispaly in requestor tab")
	@Description("If user enter the serial number in log by serial number then the detail is dispaly in requestor tab")
	public void LogBySerialNumber() throws InterruptedException 
	{
		sd_createNewPage.logBySerialNumber();
		Thread.sleep(2000);

	}

	/*@Test(priority = 12, groups = {"Regression Testing"}, description = "If user enter the contact number in log by serial number then the detail is dispaly in requestor tab")
	@Description("If user enter the contact number in log by serial number then the detail is dispaly in requestor tab")
	public void LogByLocalContactNumber() throws InterruptedException 
	{
		sd_createNewPage.logByLocalContactNumber();

	}
*/
	@Test(priority = 14, groups = {"Testing With Super"}, description = "If user select the perticular business unit then that related principal customer should display "
			+ "compare with the super login")
	@Description("If user select the perticular business unit then that related principal customer should display "
			+ "compare with the super login ")
	public void CheckPrincipalCustomerInSuperLogin() throws Exception 
	{
		//driver.close();
		initialization();

		sd_LoginPage = new SD_LoginPage();
		Thread.sleep(1000);
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		sd_HomePage = new SD_HomePage();
		sd_TicketPage = sd_HomePage.ticketTab();
		Thread.sleep(1000);
		sd_createNewPage = sd_TicketPage.createNewTab();
		sd_createNewPage.checkPrincipalCustomerInSuperLogin();

	}

	@Test(priority = 15, groups = {"Testing With Super"}, description = "If user select the perticular principal customer then that related customer should display "
			+ "compare with the super login")
	@Description("If user select the perticular principal customer then that related customer should display "
			+ "compare with the super login")
	public void CheckCustomerInSuperLogin() throws Exception 
	{
		Thread.sleep(1000);
		sd_createNewPage.checkCustomerInSuperLogin();

	}

	

	
	/*@DataProvider
	public String[][] getSheetdata() throws InvalidFormatException, IOException{
		TestUtility data= new TestUtility();
		//Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetName);
		
		
	 }
	

	@Test(priority = 4, dataProvider= "getLoginUnoSheetdata")
	@Description()
	public void checkWithWrongLoginCredentials(String username , String password ) throws Exception
	{
		//sd_LoginPage.checkWithWrongLoginCredentials();
		sd_LoginPage.checkWithWrongLoginCredentials(username, password);
		
	
	}
	
*/
	@AfterMethod
	  public void writeResult(ITestResult result) throws Exception
	  {
	      
	       
	          if(result.getStatus() == ITestResult.SUCCESS)
	          {
	           System.out.println("================");
	           System.out.println(result.getMethod().getMethodName());
	              System.out.println("======PASS======");
	          }
	          else if(result.getStatus() == ITestResult.FAILURE)
	          {
	           System.out.println("================");
	           System.out.println(result.getMethod().getMethodName());
	           System.out.println("======FAIL======");
	           
	          

	           
	           try {
	        	   
	        	   // driver.quit();
		          //  initialization();
					sd_HomePage = new SD_HomePage();
					sd_TicketPage = sd_HomePage.ticketTab();
					Thread.sleep(1000);
					sd_createNewPage = sd_TicketPage.createNewTab();
					Thread.sleep(1000);
					
				} catch (Exception e) {
					
					//driver.close();
					initialization();

					sd_LoginPage = new SD_LoginPage();
					Thread.sleep(1000);
					sd_HomePage = sd_LoginPage.login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);
					sd_HomePage = new SD_HomePage();
					sd_TicketPage = sd_HomePage.ticketTab();
					Thread.sleep(1000);
					sd_createNewPage = sd_TicketPage.createNewTab();
					Thread.sleep(1000);
				}
	           

	          }
	          else if(result.getStatus() == ITestResult.SKIP)
	          {
	           System.out.println("================");
	           System.out.println(result.getMethod().getMethodName());
	           System.out.println("======Skip======");
	             // driver.quit();
	         
	           driver.close();
				initialization();

	   		    sd_LoginPage = new SD_LoginPage();
	   		     sd_HomePage = sd_LoginPage.login(
	   				properties.getProperty("username"),
	   				properties.getProperty("password"));
	       

	          }
	    
	  }
	

	@AfterClass
	public void tearDown() 
	{
		try {
			
			driver.quit();
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}


}
