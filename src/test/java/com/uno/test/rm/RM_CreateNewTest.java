package com.uno.test.rm;

import io.qameta.allure.Description;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;


import com.uno.pages.rm.RM_CreateNewPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;

import bsh.ParseException;

public class RM_CreateNewTest extends BaseCode 
{
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;

	RM_CreateNewTest rm_CreateNewTest;
	RM_CreateNewPage rm_CreateNewPage;
	RM_IncidentPage rm_IncidentPage;

	public RM_CreateNewTest() {

		super();

	}

	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		initialization();

		Thread.sleep(1000);
		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));

		Thread.sleep(2000);
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_CreateNewPage = rm_IncidentPage.createNewTab();
		Thread.sleep(2000);

	}

	@Test(priority = 1, groups = { "Display Unit In Create New" }, description = "Check  title of page")
	@Description("Check  title of page")
	public void VerifyTitleOfCreateNewPage() throws Exception {
		rm_CreateNewPage.verifyTitleOfCreateNewPage();
		Thread.sleep(1000);

	}

	@Test(priority = 2, groups = { "Display Unit In Create New" }, description = "Display Default Incident No")
	@Description("Display Default Incident No")
	public void CheckDefaultIncidentNo() {
		rm_CreateNewPage.checkDefaultIncidentNo();

	}

	@Test(priority = 3, groups = { "Display Unit In Create New" }, description = "verify incident date and time is equal to system date and time or not")
	@Description("verify incident date and time is equal to system date and time or not")
	public void CheckDefaultIncidentDateTime() throws Exception {
		rm_CreateNewPage.checkDefaultIncidentDateTime();
	}

	@Test(priority = 4, groups = { "Display Unit In Create New" }, description = "Check the default value of create By ,is should be sd")
	@Description("Check the default value of create By ,is should be sd")
	public void CheckDefaultCreateByRoleElement() throws ParseException {
		rm_CreateNewPage.checkDefaultCreateByRoleElement();
	}

	@Test(priority = 5, groups = { "Display Unit In Create New" }, description = "Check the default value of close Date Time ,is should be blank")
	@Description("Check the default value of close Date Time ,is should be blank")
	public void CheckDefaultcloseDateTime() throws ParseException {
		rm_CreateNewPage.checkDefaultcloseDateTime();

	}

	@Test(priority = 6, groups = { "Display Unit In Create New" }, description = "Check that the Ticket date time is equal to the system date and time")
	@Description("Check that the Ticket date time is equal to the system date and time")
	public void VerifyTicketDateTime() throws Exception {
		rm_CreateNewPage.verifyTicketDateTime();
	}

	@Test(priority = 7, groups = { "Requestor Details" }, description = "If user select the My default business unit then, the same business unit is "
			+ "appere in Requestor Details")
	@Description("If user select the My default business unit then, the same business unit is "
			+ "appere in Requestor Details")
	public void CheckDefaultBusinessUnit() throws InterruptedException {

		rm_CreateNewPage.checkDefaultBusinessUnit();

	}

	@Test(priority = 8, groups = { "Search Ticket" }, description = "1.If User enter the ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular id then in view page it display only selected ID ")
	@Description("1.If User enter the ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular id then in view page it display only selected ID ")
	public void CheckSearchIdTextBox() throws InterruptedException {
		rm_CreateNewPage.verifyIdTextBox();

	}

	@Test(priority = 9, groups = { "Search Ticket" }, description = "1.If User enter the Assert ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular Assert Id then in view page it display only selected ID")
	@Description("1.If User enter the Assert ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the perticular Assert Id then in view page it display only selected ID")
	public void VerifyAssetIDTextBox() throws Exception {
		rm_CreateNewPage.verifyAssetIDTextBox();

	}

	@Test(priority = 10, groups = { "Search Ticket" }, description = "1.If User enter the Ticket ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the particular Ticket Id then in view page it display only selected ID")
	@Description("1.If User enter the Ticket ID in Serch Ticket and click on go button then it will reflect the View Ticket page"
			+ "2.if you enter the particular Ticket Id then in view page it display only selected ID")
	public void VerifyTicketIdTextBox() throws Exception {
		rm_CreateNewPage.verifyTicketIdTextBox();

	}

	@Test(priority = 11, groups = { "Requestor" }, description = "If user enter the serial number in log by serial number then the detail is dispaly in requestor tab")
	@Description("If user enter the serial number in log by serial number then the detail is dispaly in requestor tab")
	public void LogBySerialNumber() throws InterruptedException {
		rm_CreateNewPage.logBySerialNumber();

	}

	/*@Test(priority = 12, groups = { "Requestor" }, description = "If user enter the contact number in log by serial number then the detail is dispaly in requestor tab")
	@Description("If user enter the contact number in log by serial number then the detail is dispaly in requestor tab")
	public void LogByLocalContactNumber() throws InterruptedException {
		rm_CreateNewPage.logByLocalContactNumber();

	}*/

	@Test(priority = 13, groups = { "Requestor" }, description = "If user select the perticular business unit then that related principal customer should display "
			+ "compare with the super login")
	@Description("If user select the perticular business unit then that related principal customer should display "
			+ "compare with the super login ")
	public void CheckPrincipalCustomerInSuperLogin() throws Exception
	{
		rm_CreateNewPage.checkPrincipalCustomerInSuperLogin();

	}

	@Test(priority = 14, groups = { "Requestor" }, description = "If user select the perticular principal customer then that related customer should display "
			+ "compare with the super login")
	@Description("If user select the perticular principal customer then that related customer should display "
			+ "compare with the super login")
	public void CheckCustomerInSuperLogin() throws Exception 
	{
		rm_CreateNewPage.checkCustomerInSuperLogin();

	}
	@Test(priority = 15, groups = { "Requestor" }, description = "If user select the serial number then asset id value should be matched with requestor detail asset id")
	@Description("If user select the serial number then asset id value should be matched with requestor detail asset id")
	public void CheckAssetIdRelatedToSiteCode() throws InterruptedException 
	{
		rm_CreateNewPage.checkAssetIdRelatedToSiteCode();

	}

	@Test(priority = 16, groups = { "Ticket Details" }, description = "check that ticket is log or not")
	@Description("check that ticket is log or not")
	public void CreateTicket() throws Exception 
	{
		rm_CreateNewPage.createNewTicket();

	}

	/*
	 * @DataProvider public String[][] getSheetdata() throws
	 * InvalidFormatException, IOException{ TestUtility data= new TestUtility();
	 * //Object data[][] = TestUtility.getSheetdata(sheetName); return
	 * data.getCellData(xlFilePath, sheetName);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 4, dataProvider= "getLoginUnoSheetdata")
	 * 
	 * @Description() public void checkWithWrongLoginCredentials(String username
	 * , String password ) throws Exception {
	 * //loginPageOfSdRole.checkWithWrongLoginCredentials();
	 * loginPageOfSdRole.checkWithWrongLoginCredentials(username, password);
	 * 
	 * 
	 * }
	 */
	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======PASS======");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======FAIL======");

			driver.quit();
			initialization();

			try {
				
				rm_LoginPage = new RM_LoginPage();
				rm_HomePage = rm_LoginPage.Login(
						properties.getProperty("loginIdForRM"),
						properties.getProperty("password"));

				Thread.sleep(2000);
				rm_HomePage = new RM_HomePage();
				rm_IncidentPage = rm_HomePage.IncidentTab();
				Thread.sleep(1000);
				rm_CreateNewPage = rm_IncidentPage.createNewTab();
				Thread.sleep(2000);

			} catch (Exception e) {

				driver.close();
				initialization();

				rm_LoginPage = new RM_LoginPage();
				rm_HomePage = rm_LoginPage.Login(
						properties.getProperty("loginIdForRM"),
						properties.getProperty("password"));

				Thread.sleep(2000);
				rm_HomePage = new RM_HomePage();
				rm_IncidentPage = rm_HomePage.IncidentTab();
				Thread.sleep(1000);
				rm_CreateNewPage = rm_IncidentPage.createNewTab();
				Thread.sleep(2000);


			}

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			driver.quit();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));

		}

	}

	@AfterClass
	public void tearDown() {
		try {

			driver.quit();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
