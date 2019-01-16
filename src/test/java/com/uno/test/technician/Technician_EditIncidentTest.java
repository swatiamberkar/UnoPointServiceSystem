package com.uno.test.technician;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import com.relevantcodes.extentreports.ExtentTest;
import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.excelUtility.WebEventListener;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_EditTicketPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.technician.Technician_EditIncidentPage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.pages.technician.Technician_IncidentPage;
import com.uno.pages.technician.Technician_ViewIncidentPage;

public class Technician_EditIncidentTest extends BaseCode {

	SD_LoginPage sd_LoginPage;
	SD_HomePage homePageOfSdRole;
	SD_CreateNewPage createNewPageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	Technician_HomePage technician_HomePage;
	Technician_IncidentPage technician_IncidentPage;
	Technician_ViewIncidentTest technician_ViewIncidentTest;
	Technician_ViewIncidentPage technician_ViewIncidentPage;
	Technician_EditIncidentPage technician_EditIncidentPage;

	WebEventListener webEventListener;
	ITestResult result;
	ExtentTest extentTest;

	String filePath_RequestorTab = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\Technician_RequestorTab.xlsx";
	String sheet_File = "UploadFile";
	String sheet_TicketDetails = "TicketDetails";
	String sheet_CustomerAddress = "CustomerAddress";
	String filePath_PreliminaryAnalysis = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\Technician_PreliminaryAnalysisTab.xlsx";
	String sheet_TSDAssignDetails = "TSDAssignDetails";
	String filePath_ETAAndTechnician = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\Technician_ETAAndTechnicianTab.xlsx";

	String sheet_Technician = "Technician";

	public Technician_EditIncidentTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

		initialization();

		sd_LoginPage = new SD_LoginPage();
		technician_HomePage = sd_LoginPage.technicianLogin(
				properties.getProperty("loginIdForTechnician"),
				properties.getProperty("password"));
		Thread.sleep(1000);

	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {

		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());

		technician_HomePage = new Technician_HomePage();
		//tabHome.click();
		technician_IncidentPage = technician_HomePage.incidentTab();
		Thread.sleep(500);
		technician_EditIncidentPage = technician_IncidentPage.EditIncidentTab();
		Thread.sleep(500);

	}

	@DataProvider
	public String[][] idData() throws Exception {
		TestUtil data = new TestUtil();
		// Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(filePath_RequestorTab, sheet_File);

	}

	// Requestor / Incident Tab //

	@Feature("Requestor / Incident Tab")
	@Test(priority = 1, dataProvider = "idData", groups = {
			"Requestor / Incident Tab", "Smoke Testing" }, description = "If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!'")
	@Description("If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!' ")
	public void CheckNotificationAfterUploadFile(String ddl_FileType,
			String txt_FilePath) throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkNotificationAfterUploadFile(
				ddl_FileType, txt_FilePath);

	}

	@DataProvider
	public String[][] TicketDetails() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(filePath_RequestorTab, sheet_TicketDetails);

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 2, dataProvider = "TicketDetails", groups = {
			"Requestor / Incident Tab", "Smoke Testing" }, description = "If user update any details and click on update details after click on Update details button then updated details should get override on old incident details")
	@Description("If user update any details and click on update details after click on Update details button then updated details should get override on old incident details")
	public void CheckUpdatedTicketDetails(String ddl_TicketType,
			String ddl_Mode, String ddl_Level, String ddl_CTS,
			String txt_Amount, String ddl_Impact, String ddl_Urgency,
			String ddl_TroubleCategory, String ddl_TroubleSubCategory,
			String txt_LocalContact, String txt_LocalContactNo,
			String txt_CustomerEmailID, String btn_today, String dtp_Date,
			String btn_PreviousYear, String btn_PreviousMonth,
			String btn_nextYear, String btn_nextMonth, String ddl_Hrs,
			String ddl_Mins) throws Exception {
		// viewTicketPageOfSdRole.SelectEngineerInFilterTab();
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkUpdatedTicketDetails(ddl_TicketType,
				ddl_Mode, ddl_Level, ddl_CTS, txt_Amount, ddl_Impact,
				ddl_Urgency, ddl_TroubleCategory, ddl_TroubleSubCategory,
				txt_LocalContact, txt_LocalContactNo, txt_CustomerEmailID,
				btn_today, dtp_Date, btn_PreviousYear, btn_PreviousMonth,
				btn_nextYear, btn_nextMonth, ddl_Hrs, ddl_Mins);

	}

	@DataProvider
	public String[][] CustomerAddress() throws Exception {
		TestUtil data = new TestUtil();
		// Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(filePath_RequestorTab, sheet_CustomerAddress);

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 3, dataProvider = "CustomerAddress", groups = {
			"Requestor / Incident Tab", "Smoke Testing" }, description = "If customer address is incorrect then in requester tab, Incorrect address with hyperlink should display &  then message popup should display to enter Customer address & If user enter customer address and click on OK button then new address should get override on Customer address.")
	@Description("If customer address is incorrect then in requester tab, Incorrect address with hyperlink should display &  then message popup should display to enter Customer address & If user enter customer address and click on OK button then new address should get override on Customer address.")
	public void overrideCustomerAddress(String lst_Customer,
			String txt_CustomerAddress) throws Exception {
		technician_EditIncidentPage
				.selectTicketOfIncorrectAddress(lst_Customer);
		technician_EditIncidentPage
				.overrideCustomerAddress(txt_CustomerAddress);

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 4, groups = { "Requestor / Incident Tab",
			"Regression Testing", "Regression Testing" }, description = "")
	@Description("")
	public void VerifyIncidentDetailsAsPerSuper() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.verifyIncidentDetailsAsPerSuper();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 5, groups = { "Requestor / Incident Tab", "Sanity Testing" }, description = "1.If user click on Incident ID hyperlink in View ticket dashboard then ticket form should display with Requester / Incident Tab."
			+ "2.  Check Id in Requester / Incident Tab is same or not. "
			+ "3. If User click on edit button of Incident details then ticket detail popup should display to update all ticket details.")
	@Description("1.If user click on Incident ID hyperlink in View ticket dashboard then ticket form should display with Requester / Incident Tab."
			+ "2.  Check Id in Requester / Incident Tab is same or not. "
			+ "3. If User click on edit button of Incident details then ticket detail popup should display to update all ticket details.")
	public void VerifyRequestorOrIncidentTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.verifyRequestorOrIncidentTab();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 6, groups = { "Requestor / Incident Tab", "Sanity Testing" }, description = "1. If user click on Customer name hyperlink in Requester tab,then 'Incident History of Customer  :-  (Customer Name)' page should display."
			+ "2. If user click on Asset ID hyperlink in Requester tab, then 'Incident History of Asset ID  :-  (Asset ID)' page should display")
	@Description("1. If user click on Customer name hyperlink in Requester tab,then 'Incident History of Customer  :-  (Customer Name)' page should display."
			+ "2. If user click on Asset ID hyperlink in Requester tab, then 'Incident History of Asset ID  :-  (Asset ID)' page should display")
	public void CheckIncidentHistoryOfCustomerPage() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkIncidentHistoryOfCustomerPage();
		technician_EditIncidentPage.checkIncidentHistoryOfAssetIdPage();
		technician_EditIncidentPage.checkSerialNoHyperlinkInRequesterTab();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 7, groups = { "Requestor / Incident Tab", "Sanity Testing" }, description = "1.If user click on Upload file button without Select any File Type then notification should display as 'Please Select File Type First.'"
			+ "2. If user click on Upload file button without attach any attachment then notification should display as 'Please Select File First.'"
			+ "3. If user click on View Attachments button then list of files popup should display with all attachment file entries ")
	@Description("1.If user click on Upload file button without Select any File Type then notification should display as 'Please Select File Type First.'"
			+ "2. If user click on Upload file button without attach any attachment then notification should display as 'Please Select File First.'"
			+ "3. If user click on View Attachments button then list of files popup should display with all attachment file entries ")
	public void CheckNotificationWithoutFileType() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkNotificationWithoutFileType();
		technician_EditIncidentPage.checkNotificationWithoutFile();
		technician_EditIncidentPage.verifyListOfFilePage();

	}

	// Preliminary Analysis Tab //

	@DataProvider
	public String[][] DetailsInPreliminaryAnalysis() throws Exception {
		TestUtil data = new TestUtil();
		// Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(filePath_PreliminaryAnalysis,
				sheet_TSDAssignDetails);

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 8, dataProvider = "DetailsInPreliminaryAnalysis", groups = {
			"Preliminary Analysis Tab", "Smoke Testing" }, description = "In User click on Update details button then all entered value should display on Preliminary analysis page as respective label and notifiation should display.")
	@Description("In User click on Update details button then all entered value should display on Preliminary analysis page as respective label and notifiation should display.")
	public void CheckUpdateDetailsButtonOfPreliminaryAnalysis(
			String lnk_Technicians, String ddl_TechnicalStatus,
			String txt_Observations, String txt_CustomerNameAndContactNo)
			throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage
				.checkUpdateDetailsButtonOfPreliminaryAnalysis(lnk_Technicians,
						ddl_TechnicalStatus, txt_Observations,
						txt_CustomerNameAndContactNo);

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 9, groups = { "Requestor / Incident Tab",
			"Regression Testing", "Regression Testing" }, description = "Verify Technicians in TSD tab as per Super login")
	@Description("Verify Technicians in TSD tab as per Super login")
	public void verifyTechniciansInTSDAsPerSuper() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.verifyTechniciansInTSDAsPerSuper();

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 10, groups = { "Preliminary Analysis Tab",
			"Sanity Testing" }, description = "1. If user click on Edit button in Preliminary Analysis tab, then TSD Assign Details popup should display."
			+ "2. In User click on Cancel button then input data should not get save against respective labels on preliminary analysis page"
			+ "3. In TSD Assign Details popup-> In TSD field user should not enter manual entry."
			+ "4. If user click on Hyperlink of TSD name then same name should get fill in TSD field"
			+ "5. In Technical Status field should display two options as 'Resolved' and 'Unresolved'")
	@Description("1. If user click on Edit button in Preliminary Analysis tab, then TSD Assign Details popup should display."
			+ "2. In User click on Cancel button then input data should not get save against respective labels on preliminary analysis page"
			+ "3. In TSD Assign Details popup-> In TSD field user should not enter manual entry."
			+ "4. If user click on Hyperlink of TSD name then same name should get fill in TSD field"
			+ "5. In Technical Status field should display two options as 'Resolved' and 'Unresolved'")
	public void checkPreliminaryAnalysisTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkCancelButton();
		technician_EditIncidentPage.verifyTSDAssignDetailsPopup();
		technician_EditIncidentPage.VerifyTSDTextBox();
		technician_EditIncidentPage.matchTechnician();
		technician_EditIncidentPage.checkStatusField();

	}

	// ETA and Technician Tab //

	@Feature("ETA and Technician Tab")
	@Test(priority = 11, groups = { "ETA and Technician Tab", "Smoke Testing",
			"Regression Testing" }, description = "In User click on Update details button then all entered value should display on ETA and Technician Tab as respective label and notifiation should display.")
	public void CheckUpdateDetailsButtonOfETAAndTechnician() throws Exception {

		technician_EditIncidentPage.selectTicketForPunchETA();
		technician_EditIncidentPage
				.checkUpdateDetailsButtonOfETAAndTechnician();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 12, groups = { "ETA and Technician Tab", "Sanity Testing" }, description = "1. If user click on Call Assign To Technician button then, 'Technician Assign And ETA Details' pop up should display"
			+ "2. In ETA Date field, user should not enter manual data"
			+ "3. If user keep 00hr and 00min and click on Update details button then, notification should display as 'Please enter ETA Time'."
			+ "4. After click on Cancel button then data should not get fill into respective fields"
			+ "5. If User click on Resend SMS button then 'Do You Want To Resend SMS To Technician' aert message should display ")
	@Description("1. If user click on Call Assign To Technician button then, 'Technician Assign And ETA Details' pop up should display"
			+ "2. In ETA Date field, user should not enter manual data"
			+ "3. If user keep 00hr and 00min and click on Update details button then, notification should display as 'Please enter ETA Time'."
			+ "4. After click on Cancel button then data should not get fill into respective fields"
			+ "5. If User click on Resend SMS button then 'Do You Want To Resend SMS To Technician' aert message should display ")
	public void checkETAAndTechnicianTab() throws Exception {
		technician_EditIncidentPage.selectTicketForPunchETA();
		technician_EditIncidentPage.checkCancelButtonFunctionality();
		technician_EditIncidentPage.checkResendSMSButton();

	}

	// ATA Tab //

	@Feature("ATA Tab")
	@Test(priority = 13, groups = { "ATA Tab", "Smoke Testing" }, description = "After select only  technician and appointment date/time in ETA tab and if user click on Edit button in ATA tab then notification should display as 'Please Select ETA And Technician First.'")
	@Description("After select only  technician and appointment date/time in ETA tab and if user click on Edit button in ATA tab then notification should display as 'Please Select ETA And Technician First.'")
	public void DisplayNotificationWithoutETAinATATab() throws Exception {

		technician_EditIncidentPage.selectTicketForPunchETA();
		technician_EditIncidentPage.displayNotificationWithoutETAInATATab();
	}

	@Feature("ATA Tab")
	@Test(priority = 14, groups = { "ATA Tab", "Smoke Testing" }, description = "If user select ATA date and Time less than ETA Date and Time then notification should display as ' Incident Updated Successfully  ' and data/time should get update on ATA tab"
			+ "2. If User select 'Yes' in Machine Available option and select ATA date/time then same should get reflect in ATA tab")
	@Description("If user select ATA date and Time less than ETA Date and Time then notification should display as ' Incident Updated Successfully  ' and data/time should get update on ATA tab")
	public void CheckUpdateDetailsButtonOfATATab() throws Exception {
		technician_EditIncidentPage.selectTicketForPunchATA();
		technician_EditIncidentPage.checkUpdateDetailsButtonOfATATab();
	}

	@Feature("ATA Tab")
	@Test(priority = 15, groups = { "ATA Tab", "Sanity Testing",
			"Regression Testing" }, description = "1. If user select ATA date and Time less than Incident Date and Time then notification should display as ' ATA should be either less or equal to current Date and time.'"
			+ "2. In ATA tab if user doesnot select Machine Available option then notification should display as 'Please Select Machine Availability.'")
	@Description("If user select ATA date and Time less than Incident Date and Time then notification should display as ' ATA should be either less or equal to current Date and time.'"
			+ "2. In ATA tab if user doesnot select Machine Available option then notification should display as 'Please Select Machine Availability.'")
	public void CheckATATab() throws Exception {

		technician_EditIncidentPage.selectTicketForPunchATA();
		technician_EditIncidentPage.checkATATab();

	}

	// Pause Tab //

	@Feature("Pause Tab")
	@Test(priority = 16, groups = { "Pause Tab", "Smoke Testing" }, description = "If user click on edit button of Pause tab without punching  ETA/ATA then notification should display as 'Please Update ETA First.'")
	@Description("If user click on edit button of Pause tab without punching  ETA/ATA then notification should display as 'Please Update ETA First.'")
	public void DisplayNotificationWhenTicketPause() throws Exception {
		technician_EditIncidentPage.selectPauseTicket();
		technician_EditIncidentPage.displayNotificationWhenTicketPause();

	}

	@Feature("Pause Tab")
	@Test(priority = 17, groups = { "Pause Tab", "Smoke Testing" }, description = "Count Total Pause Time In Pause Tab")
	@Description("Count Total Pause Time In Pause Tab")
	public void CountTotalPauseTimeInPauseTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicketForCountPauseTime();
		technician_EditIncidentPage.countTotalPauseTimeInPauseTab();

	}

	@Feature("Pause Tab")
	@Test(priority = 18, groups = { "Pause Tab", "Smoke Testing" }, description = "1. If user click on hyperlink any pause reason then same should get filled into Reason To Pause field"
			+ "2. If user click on calender symbol of Auto resume date field then same date should get filled ")
	@Description("1.If user click on hyperlink any pause reason then same should get filled into Reason To Pause field"
			+ "2. If user click on calender symbol of Auto resume date field then same date should get filled ")
	public void CheckUpdateDetailsButtonOfPauseTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.matchResumeDateAndTimeAndPauseReason();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 19, groups = { "Requestor / Incident Tab",
			"Regression Testing", "Regression Testing" }, description = "Verify Pause Reason as per Super login")
	@Description("Verify Pause Reason as per Super login")
	public void verifyPauseReasonAsPerSuper() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.verifyPauseReasonAsPerSuper();

	}

	@Feature("Pause Tab")
	@Test(priority = 20, groups = { "Pause Tab", "Sanity Testing" }, description = "If Pause end date Time and Total Pause Time(minutes) are filled in pause tab then ticket should display as 'Open' status")
	@Description("If Pause end date Time and Total Pause Time(minutes) are filled in pause tab then ticket should display as 'Open' status")
	public void DisplayTotalPauseTimeWhenTicketOpen() throws Exception {

		technician_EditIncidentPage.displayTotalPauseTimeWhenTicketOpen();

	}

	@Feature("Pause Tab")
	@Test(priority = 21, groups = { "Pause Tab", "Sanity Testing" }, description = "1. To check the functionality of Edit ticket-Pause tab-after click on Edit button, Pause details popup should get open"
			+ "2. User should not enter manual entry in Auto Resume Date field"
			+ "3. If user click on list symbol of 'Reason To Pause' field,  List of Pause Reasons popup should display with pause reasons"
			+ "4. If user click on hyper link any pause reason then same should get filled into Reason To Pause field")
	@Description("1. To check the functionality of Edit ticket-Pause tab-after click on Edit button, Pause details popup should get open"
			+ "2. User should not enter manual entry in Auto Resume Date field"
			+ "3. If user click on list symbol of 'Reason To Pause' field,  List of Pause Reasons popup should display with pause reasons"
			+ "4. If user click on hyper link any pause reason then same should get filled into Reason To Pause field")
	public void OpenPauseDetailsPage() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.openPauseDetailsPage();
		technician_EditIncidentPage.checkAutoResumeDateField();
		technician_EditIncidentPage.displayListOfPauseReasonsPopup();
		technician_EditIncidentPage.displaySamePauseReason();

	}

	// Spare Tab //


	@Feature("Spare Tab - Spare Details")
	@Test(priority = 48, groups = { "Spare Tab - Spare Details" },
	description = "If user click on 'Update Details' button in spare details [with inventorymodule] then notification should display a'Please Consumed or Replaced Spare, if you select spare consumed yes.")
	@Description("If user click on 'Update Details' button in spare details[with inventorymodule] then notification should display a'Please Consumed or Replaced Spare, if you select spare consumed yes.")
	public void CheckUpdateButtonWithEnteringData() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkUpdateButtonWithoutEnteringData();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 49, groups = { "Spare Tab - Spare Details" }, description = "1. If user select 'Yes' in 'Spares Consumed By Inventory logistic(Y/N)'option then Add spare tab should display"
			+ "2. If User click on list symbol of 'Spares Consumed By Inventory logistic(Y/N)' title, then 'List of Available Spares' pop up should display."
			+ "3. If user click on hyper link of part name in 'List of Available Spares'pop up, after select 'Yes' in list then same part name should display in Add Spare tab"
			+ "4. If User select Non consumable part from list then in Replace spare with details Product Classification and Product Description should display with same value present in Add Spare tab."
			+ "5. If user select component part and click on update details button then spare entry should display in spare tab as 'consumed' transaction type.")
	@Description("1. If user select 'Yes' in 'Spares Consumed By Inventory logistic(Y/N)'option then Add spare tab should display"
			+ "2. If User click on list symbol of 'Spares Consumed By Inventory logistic(Y/N)' title, then 'List of Available Spares' pop up should display. "
			+ "3. If user click on hyper link of part name in 'List of Available Spares'pop up, after select 'Yes' in list then same part name should display in Add Spare tab. "
			+ "4. If User select Non consumable part from list then in Replace spare with details Product Classification and Product Description should display with same value present in Add Spare tab."
			+ "5. If user select component part and click on update details button then spare entry should display in spare tab as 'consumed' transaction type ")
	public void CheckSpareTabWithYesSelect() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkSpareTabWithYesSelect();
		technician_EditIncidentPage.checkListOfAvailableSparesWindow();
		technician_EditIncidentPage.matchPartname();
	//	technician_EditIncidentPage.selectNonConsumableProduct();
	//	technician_EditIncidentPage.checkTransactionType();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 54, groups = { "Spare Tab - Spare Details" }, description = " If user select part with 'product classification' as 'Device' then 'Replace spare with' tab should display to enter faulty details."
			+ "If user not selecting part code option in Part code field and click on Update details button then notification should display as 'Please select Part Code..!"
			+ "3. In Replace spare with tab-> Part code field if user select 'Replace with Another Part Code' option then part code list should display related to selected part code."
			+ "4. If user not selecting status in Replace spare with tab then notification should display as 'Please select Part Status..!'"
			+ "5. If user doesn't enter serial number while Replacement then auto generated serial number should get generated and should display in technician's stock."
			+ "6. If User Replace spare with faulty spare and click on Update details button then on spare tab, replaced entry should display with part detailsand new serial number and replacement entry transaction type should be 'Replaced'"
			+ "6. If user replace Device in spare tab then while technician close with serial number field notification should display as 'This serial no will get updated the new serial no for TID/Asset ID. Next time the call is logged for this TID the updated serial no will be shown.")
	@Description(" If user select part with 'product classification' as 'Device' then 'Replace spare with' tab should display to enter faulty details."
			+ "If user not selecting part code option in Part code field and click on Update details button then notification should display as 'Please select Part Code..!"
			+ "3. In Replace spare with tab-> Part code field if user select 'Replace with Another Part Code' option then part code list should display related to selected part code."
			+ "4. If user not selecting status in Replace spare with tab then notification should display as 'Please select Part Status..!'"
			+ "5. If user doesn't enter serial number while Replacement then auto generated serial number should get generated and should display in technician's stock."
			+ "6. If User Replace spare with faulty spare and click on Update details button then on spare tab, replaced entry should display with part detailsand new serial number and replacement entry transaction type should be 'Replaced'"
			+ "6. If user replace Device in spare tab then while technician close with serial number field notification should display as 'This serial no will get updated the new serial no for TID/Asset ID. Next time the call is logged for this TID the updated serial no will be shown.")
	public void checkReplaceSpareWithTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkReplaceSpareWithTab();
		technician_EditIncidentPage.matchNotificationOfWithoutPartCode();
		technician_EditIncidentPage.checkPartCodeField();
		technician_EditIncidentPage.matchNotificationOfWithoutStatus();
		technician_EditIncidentPage.CheckWithoutEnteringSerialNumber();
		technician_EditIncidentPage.checkWithFaultySpare();
		technician_EditIncidentPage.matchTechnicianCloseMessageWithDevice();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 62, groups = { "Spare Tab - Required Spare" }, description = " 1. In Spare tab after click on edit button pop up should get open "
			+ "2. If User click on Add button without select any details in Required Spare[With Inventory module] tab, then alert box should display as 'Please Select part name'")
	@Description("1. In Spare tab after click on edit button pop up should get open "
			+ "2.  If User click on Add button without select any details in Required Spare[With Inventory module] tab, then alert box should display as 'Please Select part name'")
	public void CheckNotificationWithoutSelectionInSpareDetailsPage()
			throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.openSpareDetailsPage();
		technician_EditIncidentPage
				.checkNotificationWithoutSelectionInSpareDetailsPage();

	}

		@Feature("Spare Tab - Required Spare")
	@Test(priority = 63, groups = { "Spare Tab - Required Spare" }, description = " After enter all mandatory details if user click on Add button then entry should made in Required Spare[With Inventory module] tab and same entry should display in edit ticket->Spare tab and notification should display as 'Spare Added Successfully'")
	@Description(" After enter all mandatory details if user click on Add button then entry should made in Required Spare[With Inventory module] tab and same entry should display in edit ticket->Spare tab and notification should display as 'Spare Added Successfully'")
	public void CheckNotificationWithSelectionInSpareTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();	
		technician_EditIncidentPage.checkNotificationWithSelectionInSpareTab();

	}
		
	@Feature("Spare Tab - Required Spare")
	@Test(priority = 65, groups = { "Spare Tab - Required Spare" }, description = "1.  In Spare tab-> Required Spare [With Inventory Module], if user click on update symbol of spare request then 'Update Spare Remark' pop up should get open"
			+ "2.  If in 'Update Spare Remark' pop up user enter remark and click on update button then same should display in spare Remark column in spare tab")
	@Description("1. In Spare tab-> Required Spare [With Inventory Module], if user click on update symbol of spare request then 'Update Spare Remark' pop up should get open"
			+ "2. If in 'Update Spare Remark' pop up user enter remark and click on update button then same should display in spare Remark column in spare tab")
	public void CheckUpdatedSpareRemarkInSpareTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkPopupOfUpdateSymbolInSpareTab();
		technician_EditIncidentPage.checkUpdatedSpareRemarkInSpareTab();

	}
	
	@Feature("Spare Tab - Required Spare")
	@Test(priority = 66, groups = { "Spare Tab - Required Spare" }, description = " If User click on Remove button in Required Spare[With Inventory module] tab entry, then entry should get remove from Required Spare[With Inventory module] tab")
	@Description(" If User click on Remove button in Required Spare[With Inventory module] tab entry,"
			+ " then entry should get remove from Required Spare[With Inventory module] tab")
	public void CheckRemoveDetailsInRequiredSpareTab() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkRemoveDetailsInRequiredSpareTab();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 67, groups = { "Spare Tab - Spare Details" }, description = "If user select In-transit spare from 'List of Available Spares' pop up and click on update details button then notification should display as 'Please Check This Spare is In Transit.. '")
	@Description("If user select In-transit spare from 'List of Available Spares' pop up and click on update details button then notification should display as 'Please Check This Spare is In Transit.. '")
	public void MatchNotificationAfterSelectInTransitSpare() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage
				.matchNotificationAfterSelectInTransitSpare();

	}

	// Remarks Tab //

	

	@Feature("Remarks Tab")
	@Test(priority = 69, groups = { "Remarks Tab" }, description = "1. If User click on Add Remark button then alert box should display with textbox to enter remark "
			+ "2. If User click on OK button without enter data in textbox then notification should display as 'Please Enter Remark..!'")
	@Description("1.If User click on Add Remark button then alert box should display with textbox to enter remark  "
			+ "2.If User click on OK button without enter data in textbox then notification should display as 'Please Enter Remark..!'")
	public void CheckAlertPopupWithoutData() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkAlertPopup();
		technician_EditIncidentPage.checkAlertPopupWithoutData();

	}

		@Feature("Remarks Tab")
	@Test(priority = 70, groups = { "Remarks Tab" }, enabled = true, description = "If User click on OK button after enter data in text box then entry should not get generate same remark value, Remark date/time and login role 'remark by' column")
	@Description("If User click on OK button after enter data in text box then entry should not get generate same remark value, Remark date/time and login role 'remark by' column")
	public void CheckRemarkInRemarkTab() throws Exception {
		
			technician_EditIncidentPage.selectOpenTicket();
			technician_EditIncidentPage.checkRemarkInRemarkTab();

	}

			@Feature("Remarks Tab")
	@Test(priority = 71, groups = { "Remarks Tab" }, description = " If User click on Cancel button without enter data in textbox then alert box should get close")
	@Description(" If User click on Cancel button without enter data in textbox then alert box should get close")
	public void CheckAlertPopupAfterCancel() throws Exception {
				technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkAlertPopupAfterCancel();

	}

	// Activity tab
	/*
	@Feature("Activity tab")
	@Test(priority = 73, groups = { "Activity tab" }, description = "1. If user click on Add activity button then Add Activity Pop Up should get open"
			+ "2.If user click on submit button with blank details then notification should display as 'Please select Activity.'"
			+ "3. If user click on submit button without select Activity status from list then notification should display as'Please select Activity Status.'"
			+ "4.  If user click on submit button without enter Activity details in details field then notification should display as 'Please enter Activity Details.")
	@Description("1. If user click on Add activity button then Add Activity Pop Up should get open"
			+ "2.If user click on submit button with blank details then notification should display as 'Please select Activity.'"
			+ "3. If user click on submit button without select Activity status from list then notification should display as'Please select Activity Status.'"
			+ "4.  If user click on submit button without enter Activity details in details field then notification should display as 'Please enter Activity Details.")
	public void CheckAlertWithoutSelection() throws Exception {
		technician_EditIncidentPage.matchAddActivityPopUp();
		technician_EditIncidentPage.checkAlertWithoutSelection();

	}

	@Feature("Activity tab")
	@Test(priority = 76, groups = { "Activity tab" }, description = " If User enter all details in Add Activity Pop up then entry should made in Activity tab details with current date/time login role in Updated by column")
	@Description(" If User enter all details in Add Activity Pop up then entry should made in Activity tab details with current date/time login role in Updated by column")
	public void verifyActivityDetailsAndDateAndTime() throws Exception {
		technician_EditIncidentPage.matchActivityDetailsAndDateAndTime();
		Thread.sleep(1000);

	}

	// VCT Tab //

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 79, groups = { "VCT Tab - Purchase Order" }, description = "1. After click on VCT tab then Purchase order title should display with Create PO button"
			+ "2.If User click on Create PO button then 'Vendor Commercial PO Details' popup should display"
			+ "3.If user click on Submit button without select vendor in 'Vendor Commercial PO Details' popup then notification should display as 'Please Select Vendor'")
	@Description("1. After click on VCT tab then Purchase order title should display with Create PO button"
			+ "2. If User click on Create PO button then 'Vendor Commercial PO Details' popup should display"
			+ "3. If user click on Submit button without select vendor in 'Vendor Commercial PO Details' popup then notification should display as 'Please Select Vendor'")
	public void CheckNotificationWithoutVendor() throws Exception {
		technician_EditIncidentPage.checkHeadingOfVCTTab();
		technician_EditIncidentPage
				.checkHeadingOfVendorCommercialPODetailsPopup();
		technician_EditIncidentPage.checkNotificationWithoutVendor();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 80, groups = { "VCT Tab - Purchase Order" }, description = "Vendor dropdown not able to selection")
	@Description("Vendor dropdown not able to selection")
	public void CheckVendorDropdown() throws Exception {
		technician_EditIncidentPage.checkVendorDropdown();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 80, groups = { "VCT Tab - Purchase Order" }, description = "In 'Vendor Commercial PO Details' popup if user enter value then same should get autofill in Amount field")
	@Description("In 'Vendor Commercial PO Details' popup if user enter value then same should get autofill in Amount field")
	public void CheckAmountInVendorCommercialPODetailsPopup() throws Exception {
		technician_EditIncidentPage
				.checkAmountInVendorCommercialPODetailsPopup();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 81, groups = { "VCT Tab- Purchase Order" }, description = "If User enter details in 'Vendor Commercial PO Details' popup and click on Submit button then PO entry should get create in Purchase order dashboard with Edit,Send PO, And Send Mail link")
	@Description("If User enter details in 'Vendor Commercial PO Details' popup and click on Submit button then PO entry should get create in Purchase order dashboard with Edit,Send PO, And Send Mail link")
	public void CreatePOInVCTTab() throws Exception {
		technician_EditIncidentPage.createPOInVCTTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 82, groups = { "VCT Tab- Purchase Order" }, description = "As per enter rate in Rate field same should display with Total Amount title with Purchase order title in VCT tab")
	@Description("As per enter rate in Rate field same should display with Total Amount title with Purchase order title in VCT tab")
	public void checkTotalAmountInPOTab() throws Exception {
		technician_EditIncidentPage.checkTotalAmountInPOTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 83, groups = { "VCT Tab- Purchase Order" }, description = "If User click on Edit link then Vendor Commercial PO Details popup should get open to update already present values with 'Update Details' button")
	@Description("If User click on Edit link then Vendor Commercial PO Details popup should get open to update already present values with 'Update Details' button")
	public void checkEditlinkInPOTab() throws Exception {

		technician_EditIncidentPage.checkEditlinkInPOTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 84, groups = { "VCT Tab - Purchase Order" }, description = "After update some field if user click on Update details button then same values should get override on already present values")
	@Description("After update some field if user click on Update details button then same values should get override on already present values")
	public void CheckUpdatedDetailsInVCTTab() throws Exception {

		technician_EditIncidentPage.checkUpdatedDetailsInVCTTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 85, groups = { "VCT Tab- Purchase Order" }, description = "If User click on Print PO link of PO entry, then popup should display to show PDF format of Purchase Order")
	@Description("If User click on Print PO link of PO entry, then popup should display to show PDF format of Purchase Order")
	public void checkPrintPOlinkInPOTab() throws Exception {

		technician_EditIncidentPage.checkPrintPOlinkInPOTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 86, groups = { "VCT Tab - Purchase Order" }, description = "If User click on Send mail then PO should get mailed to entered email Id")
	@Description("If User click on Send mail then PO should get mailed to entered email Id")
	public void CheckSendMailLinkInPOTab() throws Exception {

		technician_EditIncidentPage.checkSendMailLinkInPOTab();
	}

	// VCT Tab

	@Feature("VCT Tab - Payments")
	@Test(priority = 87, groups = { "VCT Tab - Payments" }, description = " If User click on Update Payment button then'Vendor Commercial Payment Details' pop up should display to generate Invoice")
	@Description(" If User click on Update Payment button then'Vendor Commercial Payment Details' pop up should display to generate Invoice")
	public void checkVendorCommercialPaymentDetailsPopUp() throws Exception {
		technician_EditIncidentPage.selectOpenTicket();
		technician_EditIncidentPage.checkVendorCommercialPaymentDetailsPopUp();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 88, groups = { "VCT Tab- Payments" }, description = "If user click on Submit button without select details in 'Vendor Commercial Payment Details' pop up then notification should display as 'Please Select Mode'")
	@Description("If user click on Submit button without select details in 'Vendor Commercial Payment Details' pop up then notification should display as 'Please Select Mode'")
	public void checkSubmitButtonWithBlankDate() throws Exception {
		technician_EditIncidentPage.checkSubmitButtonWithBlankDate();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 89, groups = { "VCT Tab- Payments" }, description = "If user click on Submit button without status option in 'Vendor Commercial Payment Details'pop up then notification should display as 'Please Select Status'")
	@Description("If user click on Submit button without status option in 'Vendor Commercial Payment Details'pop up then notification should display as 'Please Select Status'")
	public void CheckSubmitButtonWithoutSelectingStatus() throws Exception {
		technician_EditIncidentPage.checkSubmitButtonWithoutSelectingStatus();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 90, groups = { "VCT Tab- Payments" }, description = "If user click on Submit button with all details in 'Vendor Commercial Payment Details' pop up then same should display in Payment entry with Edit and View Attachment links")
	@Description("If user click on Submit button with all details in 'Vendor Commercial Payment Details' pop up then same should display in Payment entry with Edit and View Attachment links")
	public void CheckSubmitButtonWithAllFieldFill() throws Exception {
		technician_EditIncidentPage.checkSubmitButtonWithAllFieldFill();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 91, groups = { "VCT Tab- Payments" }, description = "If User update details and click on Update details button then same values should get override on already present values")
	@Description("If User update details and click on Update details button then same values should get override on already present values")
	public void CheckUpdateDetailFunctionality() throws Exception { //
		technician_EditIncidentPage.selectOpenTicket(); //
		technician_EditIncidentPage.selectOpenTicketAndPunchETAATA();
		technician_EditIncidentPage.checkUpdateDetailFunctionality();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 92, groups = { "VCT Tab- Payments" }, description = "If any attachment is provide while generate invoice then same should display in List of Attachments pop up after click Attachment link")
	@Description("If any attachment is provide while generate invoice then same should display in List of Attachments pop up after click Attachment link")
	public void CheckFileAttachmentFunctionality() throws Exception {
		technician_EditIncidentPage.checkFileAttachmentFunctionality();

	}

	@Test(priority = 94, groups = { "CCT" }, description = "Check all Alerts without entering the data")
	@Description("Check all Alerts without entering the data")
	public void CheckCCTtab() throws Exception {
		technician_EditIncidentPage.checkCCTtab();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 95, groups = { "Cancel Ticket Tab" }, description = "If User click on Cancel ticket button in Cancel ticket tab then 'Cancel Ticket Details' pop up should get open .")
	@Description("If User click on Cancel ticket button in Cancel ticket tab then 'Cancel Ticket Details' pop up should get open .")
	public void CheckCancelTicketDetailPOpUp() throws Exception {
		technician_EditIncidentPage.checkCancelTicketDetailPOpUp();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 96, groups = { "Cancel Ticket Tab" }, description = "If User try to edit Resolution value then system should not allow to edit this field and also check that the resolution field contain default value is 'cancel'")
	@Description("If User try to edit Resolution value then system should not allow to edit this field and also check that the resolution field contain default value is 'cancel'")
	public void CheckResolutionFieldIsNotEditable() throws Exception {
		technician_EditIncidentPage.checkResolutionFieldIsNotEditable();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 97, groups = { "Cancel Ticket Tab" }, description = "If User click on Cancel ticket button in 'Cancel Ticket Details' popup then notification should display as 'Please Enter Ticket Cancel Reason'")
	@Description("If User click on Cancel ticket button in 'Cancel Ticket Details' popup then notification should display as 'Please Enter Ticket Cancel Reason'")
	public void CheckWithBlankCancelReasonField() throws Exception {
		technician_EditIncidentPage.checkWithBlankCancelReasonField();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 98, groups = { "Cancel Ticket Tab" }, description = "If user enter data in Cancel reason text box and click on cancel ticket button then entry should get created in ticket cancel tab and notification should display as 'Ticket Cancelled Successfully.'Also Status of ticket should display as 'Cancelled'")
	@Description("If user enter data in Cancel reason text box and click on cancel ticket button then entry should get created in ticket cancel tab and notification should display as 'Ticket Cancelled Successfully.' Also Status of ticket should display as 'Cancelled'")
	public void CheckCancelButtonWithAllFieldFill() throws Exception {
		technician_EditIncidentPage.checkCancelButtonWithAllFieldFill();

	}

	// Technician Close //

	@Feature("Technician Close Tab")
	@Test(priority = 99, groups = { "Technician Close Tab" }, description = "select replace spare and do the technician close")
	@Description("select replace spare and do the technician close")
	public void SelectSpareWithDeviceAndTechClose() throws Exception {
		homePageOfSdRole = new SD_HomePage();
		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000); //
		// technician_EditIncidentPage = ticketPageOfSdRole.TicketFrom();
		Thread.sleep(1000); //
		technician_EditIncidentPage.SelectEngineerInFilterTab();
		technician_EditIncidentPage.selectSpareWithDeviceAndTechClose();

	}

	@Feature("Technician Close Tab")
	@Test(priority = 100, groups = { "Technician Close Tab" }, description = " If User click on Update Details in Techclose tab without enter any details then notification should display as 'Please enter Technician Close Date.'")
	@Description(" If User click on Update Details in Techclose tab without enter any details then notification should display as 'Please enter Technician Close Date.'")
	public void CheckNotificationWithoutSelectionInTechnicianCloseTab()
			throws Exception {

		technician_EditIncidentPage
				.checkNotificationWithoutSelectionInTechnicianCloseTab();
	}

	@Feature("Technician Close Tab")
	@Test(priority = 101, groups = { "Technician Close Tab" }, description = "If User enter and select all mandatory details in technician close Details popup then all details should display in technician close tab and notification should display as ' Incident Updated SuccessFully'")
	@Description("  If User enter and select all mandatory details in technician close Details popup then all details should display in technician close tab and notification should display as ' Incident Updated SuccessFully'")
	public void CheckNotificationWithSelectionInTechnicianCloseTab()
			throws Exception { // viewTicketPageOfSdRole.SelectEngineerInFilterTab();
		technician_EditIncidentPage
				.checkNotificationWithSelectionInTechnicianCloseTab();
	}

	// Technician close

	@Feature("Technician Close Tab")
	@Test(priority = 102, groups = { "Technician Close Tab" }, description = "If User click on Generate PDF button after technician close then in 'End Of Service' techclose date and time should display")
	@Description("If User click on Generate PDF button after technician close then in 'End Of Service' techclose date and time should display")
	public void CheckGeneratePDFLink() throws Exception {
		technician_EditIncidentPage.checkGeneratePDFLink();

	}

	@Feature("Technician Close Tab")
	@Test(priority = 103, groups = { "Technician Close Tab" }, description = "If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details pop up should not display and notification should display as 'Please Update ETA And ATA First.'")
	@Description("If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details pop up should not display and notification should display as 'Please Update ETA And ATA First.'")
	public void checkEditButtonAfterTechnicianClose() throws Exception {

		technician_EditIncidentPage.checkEditButtonAfterTechnicianClose();

	}

	@Feature("Technician Close Tab")
	@Test(priority = 104, groups = { "Technician Close Tab" }, description = "when the spare is replaced the the serial number field in tech close is match with the serial number in Final Close")
	@Description("when the spare is replaced the the serial number field in tech close is match with the serial number in Final Close")
	public void SelectTechnicianCloseWithSerialNo() throws Exception {
		technician_EditIncidentPage.selectTechnicianCloseWithSerialNo();

	}

	// Final close tab

	@Feature("Final Close Tab")
	@Test(priority = 105, groups = { "Final Close Tab" }, description = "If user click on the close button then Final close Detail pop up should get open ")
	@Description("If user click on the close button then Final close Detail pop up should get open ")
	public void checkFinalCloseDetailpopup() throws Exception {
		technician_EditIncidentPage.checkFinalCloseDetailpopup();

	}

	@Feature("Final Close Tab")
	@Test(priority = 106, groups = { "Final Close Tab" }, description = "without entering any data if user click on update detail button then 'Please enter Final close date.' pop up message should display.")
	@Description("without entering any data if user click on update detail button then 'Please enter Final close date.' pop up message should display.")
	public void CheckUpdateDetailsWithBlankData() throws Exception {
		technician_EditIncidentPage.checkUpdateDetailsWithBlankData();

	}

	@Feature("Final Close Tab")
	@Test(priority = 107, groups = { "Final Close Tab" }, description = "If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	@Description("If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	public void CompareCloseDateWithTechnicianDateTime() throws Exception {
		technician_EditIncidentPage.compareCloseDateWithTechnicianDateTime();

	}

	@Feature("Final Close Tab")
	@Test(priority = 108, groups = { "Final Close Tab" }, description = " If User enter final close date/time more than current date and time then notification should display as 'Final close Date/Time should be less than or Equal to Current Date/Time.'")
	@Description(" If User enter final close date/time more than current date and time then notification should display as 'Final close Date/Time should be less than or Equal to Current Date/Time.'")
	public void CompareCloseDateTimeWithCurrentDateTime() throws Exception {
		technician_EditIncidentPage.compareCloseDateTimeWithCurrentDateTime();

	}

	@Feature("Final Close Tab")
	@Test(priority = 109, groups = { "Final Close Tab" }, description = "If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	@Description("If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	public void CompareCloseDateTimeWithTechnicianDateTime() throws Exception {
		technician_EditIncidentPage
				.compareCloseDateTimeWithTechnicianDateTime();

	}

	@Feature("Final Close Tab")
	@Test(priority = 110, groups = { "Final Close Tab" }, description = "In user enter replaced  serial  number while techclose then in Final Close Details popup in same  number should display in serial number field")
	@Description("In user enter replaced  serial  number while techclose then in Final Close Details popup in same  number should display in serial number field")
	public void MatchReplacedSerialWithFinalCloseSerialNumber()
			throws Exception {
		technician_EditIncidentPage
				.matchReplacedSerialWithFinalCloseSerialNumber();

	}

	@Feature("Final Close Tab")
	@Test(priority = 111, groups = { "Final Close Tab" }, description = "In user enter replaced  serial  number while tech close and in Final Close Details pop up-> Update Serial No For this Asset field if user not enter any value then notification should display as 'Serial No. does not match.'")
	@Description("In user enter replaced  serial  number while tech close and in Final Close Details pop up-> Update Serial No For this Asset field if user not enter any value then notification should display as 'Serial No. does not match.'")
	public void MatchPopUpWithBlankUpdateSerialNoField() throws Exception {
		technician_EditIncidentPage.matchPopUpWithBlankUpdateSerialNoField();

	}

	@Feature("Final Close Tab")
	@Test(priority = 112, groups = { "Final Close Tab" }, description = "In user enter replaced  serial  number while tech close and in Final Close Details pop up->Update Serial No For this Asset field if user enter the different serial number then notification should display as 'Serial No. does not match.'")
	@Description("In user enter replaced  serial  number while tech close and in Final Close Details pop up-> Update Serial No For this Asset field if user enter the different serial number then notification should display as 'Serial No. does not match.'")
	public void MatchPopUpWithUpdateSerialNoFieldFill() throws Exception {
		technician_EditIncidentPage.matchPopUpWithUpdateSerialNoFieldFill();

	}

	@Feature("Final Close Tab")
	@Test(priority = 113, groups = { "Final Close Tab" }, description = "If User enter correct serial number while technician close then user need to enter same serial number in 'Update Serial No For this Asset' field in final close pop up to override on existing serial number")
	@Description("If User enter correct serial number while technician close then user need to enter same serial number in 'Update Serial No For this Asset' field in final close pop up to override on existing serial number")
	public void ClosePinkTicket() throws Exception {
		technician_EditIncidentPage.closePinkTicket();

	}

	// Create Sub Ticket

	@Test(priority = 114, groups = { "Create Sub Ticket" }, description = "If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ETA Date First' .")
	@Description("If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ETA Date First' .")
	public void CheckAlertMessageWithoutETA() throws Exception {

		// technician_EditIncidentPage.SelectEngineerInFilterTab();
		technician_EditIncidentPage.checkAlertMessageWithoutETA();

	}

	@Test(priority = 115, groups = { "Create Sub Ticket" }, description = "If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ATA Date First' .")
	@Description("If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ATA Date First' .")
	public void CheckAlertMessageWithoutATA() throws Exception {
		technician_EditIncidentPage.checkAlertMessageWithoutATA();

	}

	@Test(priority = 116, groups = { "Create Sub Ticket" }, description = " If User click on create sub ticket button for pause ticket then ticket form should get open to record sub ticket And If User click on View Sub ticket button then 'List of your Requests' page should get open with Pause ticket window of selected parent ticket ")
	@Description(" If User click on create sub ticket button for pause ticket then ticket form should get open to record sub ticket And If User click on View Sub ticket button then 'List of your Requests' page should get open with Pause ticket window of selected parent ticket ")
	public void checkCreateSubTicketAndViewSubTicketForPause() throws Exception {
		technician_EditIncidentPage
				.checkCreateSubTicketAndViewSubTicketForPause();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 7, groups = { "Requestor / Incident Tab" }, description = "In requester details if user click on Serial No Hyperlink then Life Cycle popup window should display.")
	@Description("In requester details if user click on Serial No Hyperlink then Life Cycle popup window should display.")
	public void CheckSerialNoHyperlinkInRequesterTab() throws Exception {
		technician_EditIncidentPage.checkSerialNoHyperlinkInRequesterTab();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 32, groups = { "ETA and Technician Tab" }, enabled = false, description = "While update ETA details if SLA getting applied then after click on Update details button alert box should display as 'DO You Want To Punch ETA Beyond SLA.'")
	@Description("While update ETA details if SLA getting applied then after click on Update details button alert box should display as 'DO You Want To Punch ETA Beyond SLA.'")
	public void CheckETAAndSLA() throws Exception {
		technician_EditIncidentPage.checkETAAndSLA();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 33, groups = { "ETA and Technician Tab" }, enabled = false, description = "If calls regarding same Asset are assign to another technician then in ETA tab while update ETA details alertbox should display as 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'")
	@Description("If calls regarding same Asset are assign to another technician then in ETA tab while update ETA details alertbox should display as 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'")
	public void CheckOkButtonOfPopUp() throws Exception {
		technician_EditIncidentPage.checkOkButtonOfPopUp();

	}

	/*
	 * 
	 * @Test(priority = 01, invocationCount=5) public void Ticket() throws
	 * Exception { // createNewPageTestCaseOfSdRole.createNewTicket();
	 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 * homePageOfSdRole = new SD_HomePage(); ticketPageOfSdRole =
	 * homePageOfSdRole.ticketTab(); Thread.sleep(1000); createNewPageOfSdRole =
	 * ticketPageOfSdRole.createNewTab(); Thread.sleep(1000);
	 * 
	 * createNewPageOfSdRole.createNewTicket(); //
	 * viewTicketPageOfSdRole.punchETAAndATAAfterCreatingTicket();
	 * 
	 * 
	 * @Feature("ATA Tab")
	 * 
	 * @Test(priority = 45, groups = { "ATA Tab", "Regression Testing" },
	 * enabled = true, description =
	 * "If User select 'No' in Machine Available option and select ATA date/time then control should get transfer on Pause tab"
	 * )
	 * 
	 * @Description(
	 * "If User select 'No' in Machine Available option and select ATA date/time then control should get transfer on Pause tab"
	 * ) public void PauseTheTicketAutomatically() throws Exception {
	 * technician_EditIncidentPage.pauseTheTicketAutomatically();
	 * 
	 * }
	 */

	// viewTicketPageOfSdRole.pauseTheTicket(); }

	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

		try {
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

				FileUtils.copyFile(scrFile, new File(currentDir
						+ "/Screenshots/" + result.getMethod().getMethodName()
						+ ".jpg"));

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");

			}
		} catch (Exception e) {

			driver.quit();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			Thread.sleep(1000);
			homePageOfSdRole = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);

		}

	}

	@AfterClass
	public void TearDown() {
		driver.close();

	}
}
