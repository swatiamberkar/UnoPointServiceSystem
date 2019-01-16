package com.uno.test.rm;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import com.relevantcodes.extentreports.ExtentTest;
import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.excelUtility.WebEventListener;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_ViewIncidentPage;



public class RM_ViewIncidentTest extends BaseCode {

	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;
	RM_ViewIncidentPage rm_ViewIncidentPage;
	RM_ViewIncidentTest rm_ViewIncidentTest;
	WebEventListener webEventListener;
	ITestResult result;
	ExtentTest extentTest;
	
	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\ViewTicket.xlsx";
	String sheet = "Sheet";

	public RM_ViewIncidentTest() {
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
			initialization();

			rm_LoginPage = new RM_LoginPage();
			Thread.sleep(1000);
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_HomePage = new RM_HomePage();
			rm_IncidentPage = rm_HomePage.IncidentTab();
			Thread.sleep(1000);
			rm_ViewIncidentPage = rm_IncidentPage.ViewIncidentTab();
			Thread.sleep(1000);
			
		

	}

	

	// Table in View Ticket //

	@Feature("View Ticket")
	@Test(priority = 1, groups = { "View Ticket" }, description = "Check Title of View Ticket Page.")
	@Description("Check Title of View Ticket Page.")
	public void TitleOfViewTicketPage() {
		rm_ViewIncidentPage.displayTitleOfViewTicketPage();
	
	}

	@Feature("View Ticket")
	@Test(priority = 2, groups = { "View Ticket" }, description = "Display all Incident Id in descending Order.")
	@Description("Display all Incident Id in descending Order.")
	public void DisplayDescendingOrderOfIncidentID() {
		rm_ViewIncidentPage.displayDescendingOrderOfIncidentID();
	}

	

	@Feature("View Ticket")
	@Test(priority = 3, groups = { "View Ticket" }, description = "Check Hyper link is present for all ID's")
	@Description("Check Hyper link is present for all ID's")
	public void CheckHyperlinkOfID() throws Exception {
		rm_ViewIncidentPage.checkHyperlinkOfID();
	}

	@Feature("View Ticket")
	@Test(priority = 4, groups = { "View Ticket" }, description = "Check Hyper link is present for all Customer's")
	@Description("Check Hyper link is present for all Customer's")
	public void CheckHyperlinkOfCustomer() throws Exception {
		rm_ViewIncidentPage.checkHyperlinkOfCustomer();
	}

	@Feature("View Ticket")
	@Test(priority = 5, groups = { "View Ticket" }, description = "Check Hyper link is present for all Asset Id's")
	@Description("Check Hyper link is present for all Asset Id's")
	public void CheckHyperlinkOfAssetId() throws Exception {
		rm_ViewIncidentPage.checkHyperlinkOfAssetId();
	}

	@Feature("View Ticket")
	@Test(priority = 6, groups = { "View Ticket" }, description = "Check Blinking Notification is Correct or not.")
	@Description("Check Blinking Notification is Correct or not.")
	public void CheckBlinkingNotification() throws Exception {
		rm_ViewIncidentPage.checkBlinkingNotification();

	}

	@Feature("View Ticket")
	@Test(priority = 7, groups = { "View Ticket" }, description = "Check Customer in Incident History Of Customer Page is Same or not.")
	@Description("Check Customer in Incident History Of Customer Page is Same or not.")
	public void checkCustomer() throws Exception {
		rm_ViewIncidentPage.checkCustomer();
	}

	@Feature("View Ticket")
	@Test(priority = 8, groups = { "View Ticket" }, description = "Check Asset ID in Incident History Of Asset ID Page is Same or not.")
	@Description("Check Asset ID in Incident History Of Asset ID Page is Same or not.")
	public void checkAssetID() throws Exception {
		rm_ViewIncidentPage.checkAssetID();
	}

	@Feature("View Ticket")
	@Test(priority = 9, groups = { "View Ticket" }, description = "Check Hidden Message Of Flag For Address is Correct or not.")
	@Description("Check Hidden Message Of Flag For Address is Correct or not.")
	public void CheckHiddenMessageOfAddress() throws Exception {
		rm_ViewIncidentPage.checkHiddenMessageOfAddress();
	}

	/*@Feature("View Ticket")
	@Test(priority = 10, groups = { "View Ticket" }, description = "Check Hidden Message Of SLA Flag is Correct or not.")
	@Description("Check Hidden Message Of SLA Flag is Correct or not.")
	public void CheckHiddenMessageOfSLAFlag() throws Exception {
		viewTicketPageOfSdRole.checkHiddenMessageOfSLAFlag();
	}

	@Feature("View Ticket")
	@Test(priority = 11, groups = { "View Ticket" }, description = "Check Hidden Message Of Response Flag is Correct or not.")
	@Description("Check Hidden Message Of Response Flag is Correct or not.")
	public void CheckHiddenMessageOfResponseFlag() throws Exception {
		viewTicketPageOfSdRole.checkHiddenMessageOfResponseFlag();
	}*/

	@Feature("View Ticket")
	@Test(priority = 10, groups = { "View Ticket" }, description = "Count the Ticket in all pages.")
	@Description("Count the Ticket in all pages.")
	public void CountOfPagination() throws Exception {
		rm_ViewIncidentPage.countOfPagination();
	}

	@Feature("View Ticket")
	@Test(priority = 11, groups = { "View Ticket" }, description = "Display Pages As Per Arrows Of Pagination")
	@Description("Display Pages As Per Arrows Of Pagination")
	public void DisplayAsPerArrowsOfPagination() throws Exception {
		rm_ViewIncidentPage.displayAsPerArrowsOfPagination();
	}

	// Search Ticket Tab //

	@Feature("View Ticket")
	@Test(priority = 12, groups = { "View Ticket" }, description = " If user click on Search Ticket tab then Search ticket tab should get open with ID, Asset ID, and Ticket ID search fields")
	@Description(" If user click on Search Ticket tab then Search ticket tab should get open with ID, Asset ID, and Ticket ID search fields")
	public void CheckSearchTicketTab() {
		rm_ViewIncidentPage.checkSearchTicketTab();
	}

	@Feature("View Ticket")
	@Test(priority = 13, groups = { "View Ticket" }, description = " In ID field if user enter alphabets then alert box should"
			+ " display as 'Please Enter The Numeric Value for Incident ID'")
	@Description(" In ID field if user enter alphabets then alert box should"
			+ " display as 'Please Enter The Numeric Value for Incident ID'")
	public void CheckSearchIdTextBox() throws Exception {
		rm_ViewIncidentPage.checkSearchIdTextBox();

	}

	@Feature("View Ticket")
	@Test(priority = 14, groups = { "View Ticket" }, description = "If user enter incident number which is not present in view "
			+ "ticket dash board then after click on Go button, 0 count is showing")
	@Description("If user enter incident number which is not present in view "
			+ "ticket dash board then after click on Go button, 0 count is showing")
	public void CheckInvalidIdTextBox() throws InterruptedException {
		rm_ViewIncidentPage.checkInvalidIdTextBox();

	}

	@Feature("View Ticket")
	@Test(priority = 15, groups = { "View Ticket" }, description = "If User enter Asset ID which is not present in system then"
			+ " after click on Go button, It should display 0 count in Incident dash board")
	@Description("If User enter Asset ID which is not present in system then"
			+ " after click on Go button, It should display 0 count in Incident dash board")
	public void CheckInvalidAssetId() throws InterruptedException {
		rm_ViewIncidentPage.checkInvalidAssetId();
	}

	@Feature("View Ticket")
	@Test(priority = 16, groups = { "View Ticket" }, description = "enter incident ticket ID number which is not present "
			+ "in view ticket dash board then the count must be 0")
	@Description("enter incident ticket ID number which is not present "
			+ "in view ticket dash board then the count must be 0")
	public void CheckInvalidTicketId() throws InterruptedException {
		rm_ViewIncidentPage.checkInvalidTicketId();

	}

	@Feature("View Ticket")
	@Test(priority = 17, groups = { "View Ticket" }, description = "If User enter correct Ticket ID and click on Go button, "
			+ "then system should display Incident of same ticket ID ")
	@Description("If User enter correct Ticket ID and click on Go button, "
			+ "then system should display Incident of same ticket ID ")
	public void CheckValidTicketId() throws InterruptedException {
		rm_ViewIncidentPage.checkValidTicketId();

	}

	@Feature("View Ticket")
	@Test(priority = 18, groups = { "View Ticket" }, description = "If User Click on Go button of ID search field with blank details,"
			+ "then alert box should display as 'Please Enter Incident ID'")
	@Description("If User Click on Go button of ID search field with blank details,"
			+ "then alert box should display as 'Please Enter Incident ID'")
	public void SearchIdTextBoxBlankData() throws Exception {
		rm_ViewIncidentPage.checkSearchIdTextBoxBlankData();

	}

	@Feature("View Ticket")
	@Test(priority = 19, groups = { "View Ticket" }, description = "If User Click on Go button of Asset ID search field with blank details,"
			+ " then alert box should display as 'Please Enter Asset ID'")
	@Description("If User Click on Go button of Asset ID search field with blank details,"
			+ " then alert box should display as 'Please Enter Asset ID'")
	public void SearchAssertIdTextBoxBlankData() throws Exception {
		rm_ViewIncidentPage.checkSearchAssertIdTextBoxBlankData();

	}

	@Feature("View Ticket")
	@Test(priority = 20, groups = { "View Ticket" }, description = " If User Click on Go button of Ticket ID search field with blank details,"
			+ "then alert box should display as 'Please Enter Customer Ticket ID'")
	@Description(" If User Click on Go button of Ticket ID search field with blank details,"
			+ "then alert box should display as 'Please Enter Customer Ticket ID'")
	public void SearchTicketIdTextBoxBlankData() throws Exception {
		rm_ViewIncidentPage.checkSearchTicketIdTextBoxBlankData();

	}
	
	@Feature("View Ticket")
	@Test(priority = 21, groups = { "View Ticket" }, description = "Column Header Display As Per My View Popup.")
	@Description("Column Header Display As Per My View Popup.")
	public void DisplayColumnHeader() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_ViewIncidentPage = rm_IncidentPage.ViewIncidentTab();
		Thread.sleep(1000);	
		rm_ViewIncidentPage.displayColumnHeader();
	}

	// Filter Tab //

	@Feature("View Ticket")
	@Test(priority = 22, groups = { "View Ticket" }, description = "In view ticket page, if user click on Filter button then"
			+ " pop up should display to filter view incident page. By default All option"
			+ " should display in all filters")
	@Description("In view ticket page, if user click on Filter button then"
			+ " pop up should display to filter view incident page. By default All option"
			+ " should display in all filters")
	public void FilterTab() throws Exception {
		rm_ViewIncidentPage.setMyView();
		rm_ViewIncidentPage.checkFilterTab();

	}

	@Feature("View Ticket")
	@Test(priority = 23, groups = { "View Ticket" }, description = "In state filter, All states which are assign to SD login should display in list ")
	@Description("In state filter, All states which are assign to SD login should display in list ")
	public void SelectStateFilter() throws Exception {
		rm_ViewIncidentPage.selectStateFilter();

	}

	

	@Feature("View Ticket")
	@Test(priority = 24, groups = { "View Ticket" }, description = "If User select particular state option then in view ticket page, "
			+ "all tickets should display where customer address is belongs to selected state")
	@Description("If User select particular state option then in view ticket page, "
			+ "all tickets should display where customer address is belongs to selected state")
	public void SelectStatusFilter() throws Exception {
		rm_ViewIncidentPage.selectStatusFilter();

	}

	

	@Feature("View Ticket")
	@Test(priority = 25, groups = { "View Ticket" }, description = "If user select Open status in CTS filter, then in View incident "
			+ "ticket should display with status 'Open', 'Paused', 'Reopened', 'technician closed', 'Cancelled' ")
	@Description("If user select Open status in CTS filter, then in View incident "
			+ "ticket should display with status 'Open', 'Paused', 'Reopened', 'technician closed', 'Cancelled' ")
	public void SelectOpenCTSFilterTextBox() throws Exception {
		rm_ViewIncidentPage.selectOpenCTSFilterTextBox();

	}

	@Feature("View Ticket")
	@Test(priority = 26, groups = { "View Ticket " }, description = "If user select Close status in CTS filter, "
			+ "then in View incident ticket should display with status 'closed' ")
	@Description("If user select Close status in CTS filter, "
			+ "then in View incident ticket should display with status 'closed' ")
	public void selectCloseCTSFilterTextBox() throws Exception {
		rm_ViewIncidentPage.selectCloseCTSFilterTextBox();

	}
	
	

	@Feature("View Ticket")
	@Test(priority = 26,groups = { "View Ticket " }, description = "")
	@Description("")
	public void CheckFilterOfAssign() throws Exception {
		rm_ViewIncidentPage.checkFilterOfAssign();

	}
	
	

	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======PASS======");
			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======FAIL======");

				// TestUtil.takeScreenshotAtEndOfTest();
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);

				String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
						+ result.getMethod().getMethodName() + ".jpg"));

				/*try {
					rm_HomePage = new SD_HomePage();
					rm_IncidentPage = rm_HomePage.ticketTab();
					Thread.sleep(1000);
					rm_ViewIncidentPage = rm_IncidentPage.viewTicketTab();
					Thread.sleep(1000);
					
				} catch (Exception e) {
					
					driver.close();
					initialization();

					rm_LoginPage = new SD_LoginPage();
					Thread.sleep(1000);
					rm_HomePage = rm_LoginPage.login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);
					rm_HomePage = new SD_HomePage();
					rm_IncidentPage = rm_HomePage.ticketTab();
					Thread.sleep(1000);
					rm_ViewIncidentPage = rm_IncidentPage.viewTicketTab();
					Thread.sleep(1000);
				}		*/

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
			}
		
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}