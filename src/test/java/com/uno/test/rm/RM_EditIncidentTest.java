package com.uno.test.rm;

import java.io.File;
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
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import com.relevantcodes.extentreports.ExtentTest;
import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.WebEventListener;
import com.uno.pages.rm.RM_EditIncidentPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;


public class RM_EditIncidentTest extends BaseCode {

	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;
	RM_EditIncidentPage rm_EditIncidentPage;
	// SD_ViewTicketTest viewTicketPageTestCaseOfSdRole;

	WebEventListener webEventListener;
	ITestResult result;
	ExtentTest extentTest;

	public RM_EditIncidentTest() {
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
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);

	}

	// Requestor / Incident Tab //

	@Feature("Requestor / Incident Tab")
	@Test(priority = 1, groups = { "Requestor / Incident Tab" }, description = "If user click on Incident ID hyperlink in View ticket dashboard then ticket form should display with Requester / Incident Tab.")
	@Description("If user click on Incident ID hyperlink in View ticket dashboard then ticket form should display with Requester / Incident Tab")
	public void VerifyRequestorOrIncidentTab() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
		//rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.verifyRequestorOrIncidentTab();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 2, groups = { "Requestor / Incident Tab" }, description = " Check Id in Requester / Incident Tab is same or not. ")
	@Description(" Check Id in Requester / Incident Tab is same or not. ")
	public void CompareIdOfRequesterOrIncidentTab() throws Exception {

		rm_EditIncidentPage.compareIdOfRequesterOrIncidentTab();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 3, groups = { "Requestor / Incident Tab" }, description = "If User click on edit button of Incident details then ticket detail popup should display to update all ticket details.")
	@Description("If User click on edit button of Incident details then ticket detail popup should display to update all ticket details.")
	public void DisplayTicketDetailsPopup() throws Exception {

		rm_EditIncidentPage.displayTicketDetailsPopup();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 4, groups = { "Requestor / Incident Tab" }, description = "If user update any details and click on update details after click on Update details button then updated details should get override on old incident details")
	@Description("If user update any details and click on update details after click on Update details button then updated details should get override on old incident details")
	public void CheckUpdatedTicketDetails() throws Exception {
		// viewTicketPageOfSdRole.SelectEngineerInFilterTab();
		rm_EditIncidentPage.checkUpdatedTicketDetails();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 5, groups = { "Requestor / Incident Tab" }, description = "If user click on Customer name hyperlink in Requester tab,then 'Incident History of Customer  :-  (Customer Name)' page should display.")
	@Description("If user click on Customer name hyperlink in Requester tab, then 'Incident History of Customer  :-  (Customer Name)' page should display")
	public void CheckIncidentHistoryOfCustomerPage() throws Exception {
		rm_EditIncidentPage.checkIncidentHistoryOfCustomerPage();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 6, groups = { "Requestor / Incident Tab" }, description = "If user click on Asset ID hyperlink in Requester tab, then 'Incident History of Asset ID  :-  (Asset ID)' page should display")
	@Description("If user click on Asset ID hyperlink in Requester tab, then 'Incident History of Asset ID  :-  (Asset ID)' page should display")
	public void checkIncidentHistoryOfAssetIdPage() throws Exception {
		rm_EditIncidentPage.checkIncidentHistoryOfAssetIdPage();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 7, groups = { "Requestor / Incident Tab" }, description = "In requester details if user click on Serial No Hyperlink then Life Cycle popup window should display.")
	@Description("In requester details if user click on Serial No Hyperlink then Life Cycle popup window should display.")
	public void CheckSerialNoHyperlinkInRequesterTab() throws Exception {
		rm_EditIncidentPage.checkSerialNoHyperlinkInRequesterTab();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 8, groups = { "Requestor / Incident Tab" }, description = "If customer address is incorrect then in requester tab, Incorrect address with hyperlink should display &  then message popup should display to enter Customer address")
	@Description("If customer address is incorrect then in requester tab, Incorrect address with hyperlink should display &  then message popup should display to enter Customer address")
	public void DisplayPopupForEnterAddress() throws Exception {
		rm_EditIncidentPage.displayPopupForEnterAddress();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 9, groups = { "Requestor / Incident Tab" }, dependsOnMethods = "DisplayPopupForEnterAddress", description = "If user enter customer address and click on OK button then new address should get override on Customer address.")
	@Description("If user enter customer address and click on OK button then new address should get override on Customer address.")
	public void OverrideCustomerAddress() throws Exception {
		rm_EditIncidentPage.overrideCustomerAddress();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 10, groups = { "Requestor / Incident Tab" }, description = "If user click on Upload file button without Select any File Type then notification should display as 'Please Select File Type First.'")
	@Description("If user click on Upload file button without Select any File Type then notification should display as 'Please Select File Type First.'")
	public void CheckNotificationWithoutFileType() throws Exception {
		rm_EditIncidentPage.checkNotificationWithoutFileType();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 11, groups = { "Requestor / Incident Tab" }, description = "If user click on Upload file button without attach any attachment then notification should display as 'Please Select File First.'")
	@Description("If user click on Upload file button without attach any attachment then notification should display as 'Please Select File First.'")
	public void CheckNotificationWithoutFile() throws Exception {
		rm_EditIncidentPage.checkNotificationWithoutFile();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 12, groups = { "Requestor / Incident Tab" }, description = "If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!'")
	@Description("If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!' ")
	public void CheckNotificationAfterUploadFile() throws Exception {
		rm_EditIncidentPage.checkNotificationAfterUploadFile();

	}

	@Feature("Requestor / Incident Tab")
	@Test(priority = 13, groups = { "Requestor / Incident Tab" }, description = "If user click on View Attachments button then list of files popup should display with all attachment file entries")
	@Description("If user click on View Attachments button then list of files popup should display with all attachment file entries")
	public void VerifyListOfFilePage() throws Exception {
		rm_EditIncidentPage.verifyListOfFilePage();

	}

	// Preliminary Analysis Tab //

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 14, groups = { "Preliminary Analysis Tab" }, description = "If user click on Edit button in Preliminary Analysis tab, then TSD Assign Details popup should display.")
	@Description("If user click on Edit button in Preliminary Analysis tab, then TSD Assign Details popup should display.")
	public void VerifyTSDAssignDetailsPopup() throws Exception {
		rm_EditIncidentPage.verifyTSDAssignDetailsPopup();

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 15, groups = { "Preliminary Analysis Tab" }, description = "In TSD Assign Details popup-> In TSD field user should not enter manual entry.")
	@Description("In TSD Assign Details popup-> In TSD field user should not enter manual entry.")
	public void VerifyTSDTextBox() throws Exception {
		rm_EditIncidentPage.VerifyTSDTextBox();

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 16, groups = { "Preliminary Analysis Tab" }, description = "If user click on Hyperlink of TSD name then same name should get fill in TSD field")
	@Description("If user click on Hyperlink of TSD name then same name should get fill in TSD field")
	public void MatchTechnician() throws Exception {
		rm_EditIncidentPage.matchTechnician();

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 17, groups = { "Preliminary Analysis Tab" }, description = "In Technical Status field should display two options as 'Resolved' and 'Unresolved'")
	@Description("In Technical Status field should display two options as 'Resolved' and 'Unresolved'")
	public void CheckStatusField() throws Exception {
		rm_EditIncidentPage.checkStatusField();

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 18, groups = { "Preliminary Analysis Tab" }, description = "In User click on Update details button then all entered value should display on Preliminary analysis page as respective label and notifiation should display.")
	@Description("In User click on Update details button then all entered value should display on Preliminary analysis page as respective label and notifiation should display.")
	public void CheckUpdateDetailButton() throws Exception {
		rm_EditIncidentPage.checkUpdateDetailButton();

	}

	@Feature("Preliminary Analysis Tab")
	@Test(priority = 19, groups = { "Preliminary Analysis Tab" }, description = "In User click on Cancel button then input data should not get save against respective labels on preliminary analysis page")
	@Description("In User click on Cancel button then input data should not get save against respective labels on preliminary analysis page")
	public void CheckCancelButton() throws Exception {
		rm_EditIncidentPage.checkCancelButton();

	}

	
	// ETA and Technician Tab //

	@Feature("ETA and Technician Tab")
	@Test(priority = 20, groups = { "ETA and Technician Tab" }, description = "If user click on Call Assign To Technician button then, 'Technician Assign And ETA Details' pop up should display")
	@Description("If user click on Call Assign To Technician button then, 'Technician Assign And ETA Details' pop up should display")
	public void displayTechnicianAssignAndETADetailsPopup() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
		//rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.displayTechnicianAssignAndETADetailsPopup();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 21, groups = { "ETA and Technician Tab" }, description = "If user keep Technician field as blank and click on Update Details page then notification should display 'Please select engineer.'")
	@Description("If user keep Technician field as blank and click on Update Details page then notification should display 'Please select engineer.'")
	public void CheckWithBlankTechnician() throws Exception {
		rm_EditIncidentPage.checkWithBlankTechnician();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 22, groups = { "ETA and Technician Tab" }, description = "In Technician field if user enter name then auto suggest list should display as per entered characters")
	@Description("In Technician field if user enter name then auto suggest list should display as per entered characters")
	public void CheckTechnicianAutoSuggest() throws Exception {
		rm_EditIncidentPage.checkTechnicianAutoSuggest();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 23, groups = { "ETA and Technician Tab" }, description = " After click on first list symbol of Technician Field then 'List of your Technicians' pop up should display")
	@Description(" After click on first list symbol of Technician Field then 'List of your Technicians' pop up should display")
	public void DisplayListOfYourTechniciansWindow() throws Exception {
		rm_EditIncidentPage.displayListOfYourTechniciansWindow();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 24, groups = { "ETA and Technician Tab" }, description = "If User click on hyper link of particular employee name in list then, same name should get fill into Technician field in 'Technician Assign AndETA Details' pop up")
	@Description("If User click on hyper link of particular employee name in list then, same name should get fill into Technician field in 'Technician Assign AndETA Details' pop up")
	public void MatchTechnicianName() throws Exception {
		rm_EditIncidentPage.matchTechnicianName();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 25, groups = { "ETA and Technician Tab" }, description = "If calls regarding same Asset are assign to another technician then in ETA tab while update ETA details alert box should display as 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'")
	@Description("If calls regarding same Asset are assign to another technician then in ETA tab while update ETA details alert box should display as 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'")
	public void CheckAlertMessage() throws Exception {
		rm_EditIncidentPage.CheckAlertMessage();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 26, groups = { "ETA and Technician Tab" }, description = " In ETA Date field, user should not enter manual data")
	@Description(" In ETA Date field, user should not enter manual data")
	public void CheckETADateField() throws Exception {
		rm_EditIncidentPage.checkETADateField();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 27, groups = { "ETA and Technician Tab" }, description = "If user keep 00hr and 00min and click on Update details button then, notification should display as 'Please enter ETA Time'.")
	@Description("If user keep 00hr and 00min and click on Update details button then, notification should display as 'Please enter ETA Time'.")
	public void CheckETATime() throws Exception {
		rm_EditIncidentPage.checkETATime();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 28, groups = { "ETA and Technician Tab" }, enabled = true, description = "In ETA Date time field, if user select date from calendar and time then, same should get fill into ETA Date and ETA time field")
	@Description("In ETA Date time field, if user select date from calendar and time then, same should get fill into ETA Date and ETA time field")
	public void MatchETADateTime() throws Exception {
		rm_EditIncidentPage.matchETADateTime();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 29, groups = { "ETA and Technician Tab" }, description = "In Appointment Date field, if user select date from calender then same should get fill into Appointment date field")
	@Description("In Appointment Date field, if user select date from calender then same should get fill into Appointment date field")
	public void checkAppointmentDateAndTime() throws Exception {
		rm_EditIncidentPage.checkAppointmentDateAndTime();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 30, groups = { "ETA and Technician Tab" }, description = "After click on Cancel button then data should not get fill into respective fields")
	@Description("After click on Cancel button then data should not get fill into respective fields")
	public void CheckCancelButtonFunctionality() throws Exception {
		rm_EditIncidentPage.checkCancelButtonFunctionality();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 31, groups = { "ETA and Technician Tab" }, enabled = true, description = "If User click on Resend SMS button then 'Do You Want To Resend SMS To Technician' aert message should display ")
	@Description("If User click on Resend SMS button then 'Do You Want To Resend SMS To Technician' aert message should display ")
	public void CheckResendSMSButton() throws Exception {
		rm_EditIncidentPage.checkResendSMSButton();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 32, groups = { "ETA and Technician Tab" }, enabled = false, description = "While update ETA details if SLA getting applied then after click on Update details button alert box should display as 'DO You Want To Punch ETA Beyond SLA.'")
	@Description("While update ETA details if SLA getting applied then after click on Update details button alert box should display as 'DO You Want To Punch ETA Beyond SLA.'")
	public void CheckETAAndSLA() throws Exception {
		rm_EditIncidentPage.checkETAAndSLA();

	}

	@Feature("ETA and Technician Tab")
	@Test(priority = 33, groups = { "ETA and Technician Tab" }, enabled = false, description = "If calls regarding same Asset are assign to another technician then in ETA tab while update ETA details alertbox should display as 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'")
	@Description("If calls regarding same Asset are assign to another technician then in ETA tab while update ETA details alertbox should display as 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'")
	public void CheckOkButtonOfPopUp() throws InterruptedException, Exception {
		rm_EditIncidentPage.checkOkButtonOfPopUp();

	}

	// ATA Tab //

	@Feature("ATA Tab")
	@Test(priority = 34, groups = { "ATA Tab" }, description = "After select only  technician and appointment date/time in ETA tab and if user click on Edit button in ATA tab then notification should display as 'Please Select ETA And Technician First.'")
	@Description("After select only  technician and appointment date/time in ETA tab and if user click on Edit button in ATA tab then notification should display as 'Please Select ETA And Technician First.'")
	public void DisplayNotificationWithoutETAinATATab() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);

		//rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.displayNotificationWithoutETAInATATab();

	}

	@Feature("ATA Tab")
	@Test(priority = 35, groups = { "ATA Tab" }, description = "If user select ATA date and Time less than Incident Date and Time then notification should display as ' ATA Date Time should be greater than Incident Date Time '")
	@Description("If user select ATA date and Time less than Incident Date and Time then notification should display as ' ATA Date Time should be greater than Incident Date Time '")
	public void CheckATADateAndTimeWithIncidentDateAndTime() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
		rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.checkATADateAndTimeWithIncidentDateAndTime();

	}

	@Feature("ATA Tab")
	@Test(priority = 36, groups = { "ATA Tab" }, description = "If user select ATA date and Time less than ETA Date and Time then notification should display as ' Incident Updated Successfully  ' and data/time should get update on ATA tab")
	@Description("If user select ATA date and Time less than ETA Date and Time then notification should display as ' Incident Updated Successfully  ' and data/time should get update on ATA tab")
	public void CheckATADateAndTimeWithETADateAndTime() throws Exception {
		rm_EditIncidentPage.checkATADateAndTimeWithETADateAndTime();

	}

	@Feature("ATA Tab")
	@Test(priority = 37, groups = { "ATA Tab" }, description = "In ATA tab if user doesnot select Machine Available option then notification should display as 'Please Select Machine Availability.'")
	@Description("In ATA tab if user doesnot select Machine Available option then notification should display as 'Please Select Machine Availability.'")
	public void DisplayAlertWithoutSelectMachineAvailable() throws Exception {
		rm_EditIncidentPage.displayAlertWithoutSelectMachineAvailable();

	}

	@Feature("ATA Tab")
	@Test(priority = 38, groups = { "ATA Tab" }, description = "If User select 'Yes' in Machine Available option and select ATA date/time then same should get reflect in ATA tab")
	@Description("If User select 'Yes' in Machine Available option and select ATA date/time then same should get reflect in ATA tab")
	public void MatchUpdatedDetailesOfATA() throws Exception {
		rm_EditIncidentPage.matchUpdatedDetailesOfATA();

	}

	@Feature("ATA Tab")
	@Test(priority = 39, groups = { "ATA Tab" }, description = "If User select 'No' in Machine Available option and select ATA date/time then control should get transfer on Pause tab")
	@Description("If User select 'No' in Machine Available option and select ATA date/time then control should get transfer on Pause tab")
	public void PauseTheTicketAutomatically() throws Exception {
		rm_EditIncidentPage.pauseTheTicketAutomatically();

	}

	// Pause Tab //

	@Feature("Pause Tab")
	@Test(priority = 40, groups = { "Pause Tab" }, description = "To check the functionality of Edit ticket-Pause tab-after click on Edit button, Pause details popup should get open")
	@Description("To check the functionality of Edit ticket-Pause tab-after click on Edit button,  Pause details popup should get open")
	public void OpenPauseDetailsPage() throws Exception {
		rm_EditIncidentPage.openPauseDetailsPage();

	}

	@Feature("Pause Tab")
	@Test(priority = 41, groups = { "Pause Tab" }, description = "User should not enter manual entry in Auto Resume Date field")
	@Description("User should not enter manual entry in Auto Resume Date field")
	public void CheckAutoResumeDateField() throws Exception {
		rm_EditIncidentPage.checkAutoResumeDateField();

	}

	@Feature("Pause Tab")
	@Test(priority = 42, groups = { "Pause Tab" }, description = "If user click on list symbol of 'Reason To Pause' field,  List of Pause Reasons popup should display with pause reasons")
	@Description("If user click on list symbol of 'Reason To Pause' field, List of Pause Reasons popup should display with pause reasons")
	public void DisplayListOfPauseReasonsPopup() throws Exception {
		rm_EditIncidentPage.displayListOfPauseReasonsPopup();

	}

	@Feature("Pause Tab")
	@Test(priority = 43, groups = { "Pause Tab" }, description = "1. If user click on hyperlink any pause reason then same should get filled into Reason To Pause field"
			+ "2. If user click on calender symbol of Auto resume date field then same date should get filled ")
	@Description("1.If user click on hyperlink any pause reason then same should get filled into Reason To Pause field"
			+ "2. If user click on calender symbol of Auto resume date field then same date should get filled ")
	public void MatchResumeDateAndTimeAndPauseReason() throws Exception {
		rm_EditIncidentPage.matchResumeDateAndTimeAndPauseReason();

	}

	@Feature("Pause Tab")
	@Test(priority = 44, groups = { "Pause Tab" }, description = "Display Notification When Ticket Pause")
	@Description("Display Notification When Ticket Pause")
	public void DisplayNotificationWhenTicketPause() throws Exception {
		rm_EditIncidentPage.displayNotificationWhenTicketPause();

	}

	@Feature("Pause Tab")
	@Test(priority = 45, groups = { "Pause Tab" }, description = "If Pause end date Time and Total Pause Time(minutes) are filled in pause tab then ticket should display as 'Open' status")
	@Description("If Pause end date Time and Total Pause Time(minutes) are filled in pause tab then ticket should display as 'Open' status")
	public void DisplayTotalPauseTimeWhenTicketOpen() throws Exception {
		Thread.sleep(1000);
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
	//	rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.displayTotalPauseTimeWhenTicketOpen();

	}

	@Feature("Pause Tab")
	@Test(priority = 46, groups = { "Pause Tab" }, description = "Count Total Pause Time In Pause Tab")
	@Description("Count Total Pause Time In Pause Tab")
	public void CountTotalPauseTimeInPauseTab() throws Exception {
		rm_EditIncidentPage.countTotalPauseTimeInPauseTab();

	}

	@Feature("Pause Tab")
	@Test(priority = 47, groups = { "Pause Tab" }, description = "If user click on edit button of Pause tab without punching  ETA/ATA then notification should display as 'Please Update ETA First.'")
	@Description("If user click on edit button of Pause tab without punching  ETA/ATA then notification should display as 'Please Update ETA First.'")
	public void displayNotificationWithoutPunchingETAAndATAInPauseTab()
			throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
		//rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage
				.displayNotificationWithoutPunchingETAAndATAInPauseTab();

	}

	// Spare Tab /

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 48, groups = { "Spare Tab - Spare Details" }, description = "If user click on 'Update Details' button in spare details [with inventorymodule] then notification should display a'Please Consumed or Replaced Spare, if you select spare consumed yes.")
	@Description("If user click on 'Update Details' button in spare details[with inventorymodule] then notification should display a'Please Consumed or Replaced Spare, if you select spare consumed yes.")
	public void CheckUpdateButtonWithEnteringData() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
	//	rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.checkUpdateButtonWithoutEnteringData();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 49, groups = { "Spare Tab - Spare Details" }, description = "If user select 'Yes' in 'Spares Consumed By Inventory logistic(Y/N)'option then Add spare tab should display")
	@Description("If user select 'Yes' in 'Spares Consumed By Inventory logistic(Y/N)'option then Add spare tab should display")
	public void CheckSpareTabWithYesSelect() throws Exception {
		rm_EditIncidentPage.checkSpareTabWithYesSelect();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 50, groups = { "Spare Tab - Spare Details" }, description = "If User click on list symbol of 'Spares Consumed By Inventory logistic(Y/N)' title, then 'List of Available Spares' pop up should display")
	@Description("If User click on list symbol of 'Spares Consumed By Inventory logistic(Y/N)' title, then 'List of Available Spares' pop up should display")
	public void checkListOfAvailableSparesWindow() throws Exception {
		rm_EditIncidentPage.checkListOfAvailableSparesWindow();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 51, groups = { "Spare Tab - Spare Details" }, description = " If user click on hyper link of part name in 'List of Available Spares'pop up, after select 'Yes' in list then same part name should display in Add Spare tab")
	@Description(" If user click on hyper link of part name in 'List of Available Spares'pop up, after select 'Yes' in list then same part name should display in Add Spare tab")
	public void MatchPartname() throws Exception {
		rm_EditIncidentPage.matchPartname();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 52, groups = { "Spare Tab - Spare Details" }, description = "If User select Non consumable part from list then in Replace spare with details Product Classification and Product Description should display with same value present in Add Spare tab ")
	@Description("If User select Non consumable part from list then in Replace spare with details Product Classification and Product Description should display with same value present in Add Spare tab ")
	public void SelectNonConsumableProduct() throws Exception {
		rm_EditIncidentPage.selectNonConsumableProduct();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 53, groups = { "Spare Tab - Spare Details" }, description = "If user select component part and click on update details button then spare entry should display in spare tab as 'consumed' transaction type")
	@Description("If user select component part and click on update details button then spare entry should display in spare tab as 'consumed' transaction type")
	public void CheckTransactionType() throws Exception {
		rm_EditIncidentPage.checkTransactionType();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 54, groups = { "Spare Tab - Spare Details" }, description = " If user select part with 'product classification' as 'Device' then 'Replace spare with' tab should display to enter faulty details")
	@Description(" If user select part with 'product classification' as 'Device' then 'Replace spare with' tab should display to enter faulty details")
	public void checkReplaceSpareWithTab() throws Exception {
		rm_EditIncidentPage.checkReplaceSpareWithTab();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 55, groups = { "Spare Tab - Spare Details" }, description = "If user not selecting part code option in Part code field and click on Update details button then notification should display as 'Please select Part Code..!")
	@Description("If user not selecting part code option in Part code field and click on Update details button then notification should display as 'Please select Part Code..!")
	public void MatchNotificationOfWithoutPartCode() throws Exception {
		rm_EditIncidentPage.matchNotificationOfWithoutPartCode();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 56, groups = { "Spare Tab - Spare Details" }, description = "In Replace spare with tab-> Part code field if user select 'Replace with Another Part Code' option then part code list should display related to selected part code.")
	@Description("In Replace spare with tab-> Part code field if user select 'Replace with Another Part Code' option then part code list should display related to selected part code.")
	public void CheckPartCodeField() throws Exception {
		rm_EditIncidentPage.checkPartCodeField();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 57, groups = { "Spare Tab - Spare Details" }, description = " If user not selecting status in Replace spare with tab then notification should display as 'Please select Part Status..!'")
	@Description(" If user not selecting status in Replace spare with tab then notification should display as 'Please select Part Status..!'")
	public void MatchNotificationOfWithoutStatus() throws Exception {
		rm_EditIncidentPage.matchNotificationOfWithoutStatus();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 58, groups = { "Spare Tab - Spare Details" }, description = "If user doesn't enter serial number while Replacement then auto generated serial number should get generated and should display in technician's stock")
	@Description("If user doesn't enter serial number while Replacement then auto generated serial number should get generated and should display in technician's stock")
	public void CheckWithoutEnteringSerialNumber() throws Exception {
		rm_EditIncidentPage.CheckWithoutEnteringSerialNumber();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 59, groups = { "Spare Tab - Spare Details" }, description = "If User Replace spare with faulty spare and click on Update details button then on spare tab, replaced entry should display with part detailsand new serial number and replacement entry transaction type should be 'Replaced'")
	@Description("If User Replace spare with faulty spare and click on Update details button then on spare tab, replaced entry should display with part detailsand new serial number and replacement entry transaction type should be 'Replaced'")
	public void CheckWithFaultySpare() throws Exception {
		rm_EditIncidentPage.checkWithFaultySpare();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 60, groups = { "Spare Tab - Spare Details" }, description = "If user replace Device in spare tab then while technician close with serial number field notification should display as 'This serial no will get updated the new serial no for TID/Asset ID. Next time the call is logged for this TID the updated serial no will be shown.")
	@Description("If user replace Device in spare tab then while technician close with serial number field notification should display as 'This serial no will get updated the new serial no for TID/Asset ID. Next time the call is logged for this TID the updated serial no will be shown.")
	public void MatchTechnicianCloseMessageDevice() throws Exception {
		rm_EditIncidentPage.matchTechnicianCloseMessageWithDevice();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 61, groups = { "Spare Tab - Required Spare" }, description = "In Spare tab after click on edit button pop up should get open ")
	@Description("In Spare tab after click on edit button pop up should get open ")
	public void OpenSpareDetailsPage() throws Exception {

		rm_EditIncidentPage.openSpareDetailsPage();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 62, groups = { "Spare Tab - Required Spare" }, description = " If User click on Add button without select any details in Required Spare[With Inventory module] tab, then alert box should display as 'Please Select part name'")
	@Description(" If User click on Add button without select any details in Required Spare[With Inventory module] tab, then alert box should display as 'Please Select part name'")
	public void CheckNotificationWithoutSelectionInSpareDetailsPage()
			throws Exception {
		rm_EditIncidentPage
				.checkNotificationWithoutSelectionInSpareDetailsPage();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 63, groups = { "Spare Tab - Required Spare" }, description = " After enter all mandatory details if user click on Add button then entry should made in Required Spare[With Inventory module] tab and same entry should display in edit ticket->Spare tab and notification should display as 'Spare Added Successfully'")
	@Description(" After enter all mandatory details if user click on Add button then entry should made in Required Spare[With Inventory module] tab and same entry should display in edit ticket->Spare tab and notification should display as 'Spare Added Successfully'")
	public void CheckNotificationWithSelectionInSpareTab() throws Exception {
		rm_EditIncidentPage.checkNotificationWithSelectionInSpareTab();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 64, groups = { "Spare Tab - Required Spare" }, description = " In Spare tab-> Required Spare [With Inventory Module], if user click on update symbol of spare request then 'Update Spare Remark' pop up should get open")
	@Description(" In Spare tab-> Required Spare[With Inventory Module], if user click on update symbol of spare request then 'Update Spare Remark' pop up should get open")
	public void CheckPopupOfUpdateSymbolInSpareTab() throws Exception {
		rm_EditIncidentPage.checkPopupOfUpdateSymbolInSpareTab();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 65, groups = { "Spare Tab - Required Spare" }, description = " If in 'Update Spare Remark' pop up user enter remark and click on update button then same should display in spare Remark column in spare tab")
	@Description(" If in 'Update Spare Remark' pop up user enter remark and click on update button then same should display in spare Remark column in spare tab")
	public void CheckUpdatedSpareRemarkInSpareTab() throws Exception {
		rm_EditIncidentPage.checkUpdatedSpareRemarkInSpareTab();

	}

	@Feature("Spare Tab - Required Spare")
	@Test(priority = 66, groups = { "Spare Tab - Required Spare" }, description = " If User click on Remove button in Required Spare[With Inventory module] tab entry, then entry should get remove from Required Spare[With Inventory module] tab")
	@Description(" If User click on Remove button in Required Spare[With Inventory module] tab entry,"
			+ " then entry should get remove from Required Spare[With Inventory module] tab")
	public void CheckRemoveDetailsInRequiredSpareTab() throws Exception {
		rm_EditIncidentPage.checkRemoveDetailsInRequiredSpareTab();

	}

	@Feature("Spare Tab - Spare Details")
	@Test(priority = 67, groups = { "Spare Tab - Spare Details" }, description = "If user select In-transit spare from 'List of Available Spares' pop up and click on update details button then notification should display as 'Please Check This Spare is In Transit.. '")
	@Description("If user select In-transit spare from 'List of Available Spares' pop up and click on update details button then notification should display as 'Please Check This Spare is In Transit.. '")
	public void MatchNotificationAfterSelectInTransitSpare() throws Exception {
		rm_EditIncidentPage.matchNotificationAfterSelectInTransitSpare();

	}

	// Remarks Tab //

	@Feature("Remarks Tab")
	@Test(priority = 68, groups = { "Remarks Tab" }, description = "If User click on Add Remark button then alert box should display with textbox to enter remark ")
	@Description("If User click on Add Remark button then alert box should display with textbox to enter remark ")
	public void CheckAlertPopup() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
	//	rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.checkAlertPopup();

	}

	@Feature("Remarks Tab")
	@Test(priority = 69, groups = { "Remarks Tab" }, description = "If User click on OK button without enter data in textbox then notification should display as 'Please Enter Remark..!'")
	@Description("If User click on OK button without enter data in textbox then notification should display as 'Please Enter Remark..!'")
	public void CheckAlertPopupWithoutData() throws Exception {
		rm_EditIncidentPage.checkAlertPopupWithoutData();

	}

	@Feature("Remarks Tab")
	@Test(priority = 70, groups = { "Remarks Tab" }, enabled = true, description = "If User click on OK button after enter data in text box then entry should not get generate same remark value, Remark date/time and login role 'remark by' column")
	@Description("If User click on OK button after enter data in text box then entry should not get generate same remark value, Remark date/time and login role 'remark by' column")
	public void CheckRemarkInRemarkTab() throws Exception {
		rm_EditIncidentPage.checkRemarkInRemarkTab();

	}

	@Feature("Remarks Tab")
	@Test(priority = 71, groups = { "Remarks Tab" }, description = " If User click on Cancel button without enter data in textbox then alert box should get close")
	@Description(" If User click on Cancel button without enter data in textbox then alert box should get close")
	public void CheckAlertPopupAfterCancel() throws Exception {
		rm_EditIncidentPage.checkAlertPopupAfterCancel();

	}

	// Activity tab

	@Feature("Activity tab")
	@Test(priority = 72, groups = { "Activity tab" }, description = "If user click on Add activity button then Add Activity Pop Up should get open")
	@Description("If user click on Add activity button then Add Activity Pop Up should get open")
	public void MatchAddActivityPopUp() throws Exception {
		rm_EditIncidentPage.matchAddActivityPopUp();

	}

	@Feature("Activity tab")
	@Test(priority = 73, groups = { "Activity tab" }, description = "If user click on submit button with blank details then notification should display as 'Please select Activity.'")
	@Description("If user click on submit button with blank details then notification should display as 'Please select Activity.'")
	public void CheckWithBlankDate() throws Exception {
		rm_EditIncidentPage.checkWithBlankDate();

	}

	@Feature("Activity tab")
	@Test(priority = 74, groups = { "Activity tab" }, description = "If user click on submit button without select Activity status from list then notification should display as'Please select Activity Status.'")
	@Description("If user click on submit button without select Activity status from list then notification should display as'Please select Activity Status.'")
	public void CheckWithoutSelectingActivityStatus() throws Exception {
		rm_EditIncidentPage.checkWithoutSelectingActivityStatus();
	}

	@Feature("Activity tab")
	@Test(priority = 75, groups = { "Activity tab" }, description = " If user click on submit button without enter Activity details in details field then notification should display as 'Please enter Activity Details.")
	@Description(" If user click on submit button without enter Activity details in details field then notification should display as 'Please enter Activity Details.")
	public void CheckWithoutSelectingActivityDetails() throws Exception {
		rm_EditIncidentPage.checkWithoutSelectingActivityDetails();

	}

	@Feature("Activity tab")
	@Test(priority = 76, groups = { "Activity tab" }, description = " If User enter all details in Add Activity Pop up then entry should made in Activity tab details with current date/time login role in Updated by column")
	@Description(" If User enter all details in Add Activity Pop up then entry should made in Activity tab details with current date/time login role in Updated by column")
	public void MatchDateAndTime() throws Exception {
		rm_EditIncidentPage.matchDateAndTime();
		Thread.sleep(1000);

	}

	// VCT Tab //

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 77, groups = { "VCT Tab - Purchase Order" }, description = "After click on VCT tab then Purchase order title should display with Create PO button")
	@Description("After click on VCT tab then Purchase order title should display with Create PO button")
	public void CheckHeadingOfVCTTab() throws Exception {
		rm_EditIncidentPage.checkHeadingOfVCTTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 78, groups = { "VCT Tab - Purchase Order" }, description = "If User click on Create PO button then 'Vendor Commercial PO Details' popup should display")
	@Description("If User click on Create PO button then 'Vendor Commercial PO Details' popup should display")
	public void checkHeadingOfVendorCommercialPODetailsPopup() throws Exception {

		rm_EditIncidentPage.checkHeadingOfVendorCommercialPODetailsPopup();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 79, groups = { "VCT Tab - Purchase Order" }, description = "If user click on Submit button without select vendor in 'Vendor Commercial PO Details' popup then notification should display as 'Please Select Vendor'")
	@Description("If user click on Submit button without select vendor in 'Vendor Commercial PO Details' popup then notification should display as 'Please Select Vendor'")
	public void CheckNotificationWithoutVendor() throws Exception {

		rm_EditIncidentPage.checkNotificationWithoutVendor();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 80, groups = { "VCT Tab - Purchase Order" }, description = "In 'Vendor Commercial PO Details' popup if user enter value then same should get autofill in Amount field")
	@Description("In 'Vendor Commercial PO Details' popup if user enter value then same should get autofill in Amount field")
	public void CheckAmountInVendorCommercialPODetailsPopup() throws Exception {
		rm_EditIncidentPage.checkAmountInVendorCommercialPODetailsPopup();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 81, groups = { "VCT Tab- Purchase Order" }, description = "If User enter details in 'Vendor Commercial PO Details' popup and click on Submit button then PO entry should get create in Purchase order dashboard with Edit,Send PO, And Send Mail link")
	@Description("If User enter details in 'Vendor Commercial PO Details' popup and click on Submit button then PO entry should get create in Purchase order dashboard with Edit,Send PO, And Send Mail link")
	public void CreatePOInVCTTab() throws Exception {
		rm_EditIncidentPage.createPOInVCTTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 82, groups = { "VCT Tab- Purchase Order" }, description = "As per enter rate in Rate field same should display with Total Amount title with Purchase order title in VCT tab")
	@Description("As per enter rate in Rate field same should display with Total Amount title with Purchase order title in VCT tab")
	public void checkTotalAmountInPOTab() throws Exception {
		rm_EditIncidentPage.checkTotalAmountInPOTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 83, groups = { "VCT Tab- Purchase Order" }, description = "If User click on Edit link then Vendor Commercial PO Details popup should get open to update already present values with 'Update Details' button")
	@Description("If User click on Edit link then Vendor Commercial PO Details popup should get open to update already present values with 'Update Details' button")
	public void checkEditlinkInPOTab() throws Exception {

		rm_EditIncidentPage.checkEditlinkInPOTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 84, groups = { "VCT Tab - Purchase Order" }, description = "After update some field if user click on Update details button then same values should get override on already present values")
	@Description("After update some field if user click on Update details button then same values should get override on already present values")
	public void CheckUpdatedDetailsInVCTTab() throws Exception {

		rm_EditIncidentPage.checkUpdatedDetailsInVCTTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 85, groups = { "VCT Tab- Purchase Order" }, description = "If User click on Print PO link of PO entry, then popup should display to show PDF format of Purchase Order")
	@Description("If User click on Print PO link of PO entry, then popup should display to show PDF format of Purchase Order")
	public void checkPrintPOlinkInPOTab() throws Exception {

		rm_EditIncidentPage.checkPrintPOlinkInPOTab();
	}

	@Feature("VCT Tab - Purchase Order")
	@Test(priority = 86, groups = { "VCT Tab - Purchase Order" }, description = "If User click on Send mail then PO should get mailed to entered email Id")
	@Description("If User click on Send mail then PO should get mailed to entered email Id")
	public void CheckSendMailLinkInPOTab() throws Exception {

		rm_EditIncidentPage.checkSendMailLinkInPOTab();
	}

	// VCT Tab

	@Feature("VCT Tab - Payments")
	@Test(priority = 87, groups = { "VCT Tab - Payments" }, description = " If User click on Update Payment button then'Vendor Commercial Payment Details' pop up should display to generate Invoice")
	@Description(" If User click on Update Payment button then'Vendor Commercial Payment Details' pop up should display to generate Invoice")
	public void checkVendorCommercialPaymentDetailsPopUp() throws Exception {
		rm_EditIncidentPage.checkVendorCommercialPaymentDetailsPopUp();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 88, groups = { "VCT Tab- Payments" }, description = "If user click on Submit button without select details in 'Vendor Commercial Payment Details' pop up then notification should display as 'Please Select Mode'")
	@Description("If user click on Submit button without select details in 'Vendor Commercial Payment Details' pop up then notification should display as 'Please Select Mode'")
	public void checkSubmitButtonWithBlankDate() throws Exception {
		rm_EditIncidentPage.checkSubmitButtonWithBlankDate();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 89, groups = { "VCT Tab- Payments" }, description = "If user click on Submit button without status option in 'Vendor Commercial Payment Details'pop up then notification should display as 'Please Select Status'")
	@Description("If user click on Submit button without status option in 'Vendor Commercial Payment Details'pop up then notification should display as 'Please Select Status'")
	public void CheckSubmitButtonWithoutSelectingStatus() throws Exception {
		rm_EditIncidentPage.checkSubmitButtonWithoutSelectingStatus();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 90, groups = { "VCT Tab- Payments" }, description = "If user click on Submit button with all details in 'Vendor Commercial Payment Details' pop up then same should display in Payment entry with Edit and View Attachment links")
	@Description("If user click on Submit button with all details in 'Vendor Commercial Payment Details' pop up then same should display in Payment entry with Edit and View Attachment links")
	public void CheckSubmitButtonWithAllFieldFill() throws Exception {
		rm_EditIncidentPage.checkSubmitButtonWithAllFieldFill();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 91, groups = { "VCT Tab- Payments" }, description = "If User update details and click on Update details button then same values should get override on already present values")
	@Description("If User update details and click on Update details button then same values should get override on already present values")
	public void CheckUpdateDetailFunctionality() throws Exception {
		rm_EditIncidentPage.checkUpdateDetailFunctionality();

	}

	@Feature("VCT Tab - Payments")
	@Test(priority = 92, groups = { "VCT Tab- Payments" }, description = "If any attachment is provide while generate invoice then same should display in List of Attachments pop up after click Attachment link")
	@Description("If any attachment is provide while generate invoice then same should display in List of Attachments pop up after click Attachment link")
	public void CheckFileAttachmentFunctionality() throws Exception {
		rm_EditIncidentPage.checkFileAttachmentFunctionality();

	}



	@Test(priority = 94, groups = { "CCT" }, description = "Check all Alerts without entering the data")
	@Description("Check all Alerts without entering the data")
	public void CheckCCTtab() throws Exception {
		rm_EditIncidentPage.checkCCTtab();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 95, groups = { "Cancel Ticket Tab" }, description = "If User click on Cancel ticket button in Cancel ticket tab then 'Cancel Ticket Details' pop up should get open .")
	@Description("If User click on Cancel ticket button in Cancel ticket tab then 'Cancel Ticket Details' pop up should get open .")
	public void CheckCancelTicketDetailPOpUp() throws Exception {
		rm_EditIncidentPage.checkCancelTicketDetailPOpUp();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 96, groups = { "Cancel Ticket Tab" }, description = "If User try to edit Resolution value then system should not allow to edit this field and also check that the resolution field contain default value is 'cancel'")
	@Description("If User try to edit Resolution value then system should not allow to edit this field and also check that the resolution field contain default value is 'cancel'")
	public void CheckResolutionFieldIsNotEditable() throws Exception {
		rm_EditIncidentPage.checkResolutionFieldIsNotEditable();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 97, groups = { "Cancel Ticket Tab" }, description = "If User click on Cancel ticket button in 'Cancel Ticket Details' popup then notification should display as 'Please Enter Ticket Cancel Reason'")
	@Description("If User click on Cancel ticket button in 'Cancel Ticket Details' popup then notification should display as 'Please Enter Ticket Cancel Reason'")
	public void CheckWithBlankCancelReasonField() throws Exception {
		rm_EditIncidentPage.checkWithBlankCancelReasonField();

	}

	@Feature("Cancel Ticket Tab")
	@Test(priority = 98, groups = { "Cancel Ticket Tab" }, description = "If user enter data in Cancel reason text box and click on cancel ticket button then entry should get created in ticket cancel tab and notification should display as 'Ticket Cancelled Successfully.'Also Status of ticket should display as 'Cancelled'")
	@Description("If user enter data in Cancel reason text box and click on cancel ticket button then entry should get created in ticket cancel tab and notification should display as 'Ticket Cancelled Successfully.' Also Status of ticket should display as 'Cancelled'")
	public void CheckCancelButtonWithAllFieldFill() throws Exception {
		rm_EditIncidentPage.checkCancelButtonWithAllFieldFill();

	}

	// Technician Close //

	@Feature("Technician Close Tab")
	@Test(priority = 99, groups = { "Technician Close Tab" }, description = "select replace spare and do the technician close")
	@Description("select replace spare and do the technician close")
	public void SelectSpareWithDeviceAndTechClose() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();

		Thread.sleep(1000);
	//	rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.selectSpareWithDeviceAndTechClose();

	}

	@Feature("Technician Close Tab")
	@Test(priority = 100, groups = { "Technician Close Tab" }, description = " If User click on Update Details in Techclose tab without enter any details then notification should display as 'Please enter Technician Close Date.'")
	@Description(" If User click on Update Details in Techclose tab without enter any details then notification should display as 'Please enter Technician Close Date.'")
	public void CheckNotificationWithoutSelectionInTechnicianCloseTab()
			throws Exception {

		rm_EditIncidentPage
				.checkNotificationWithoutSelectionInTechnicianCloseTab();
	}

	@Feature("Technician Close Tab")
	@Test(priority = 101, groups = { "Technician Close Tab" }, description = "If User enter and select all mandatory details in technician close Details popup then all details should display in technician close tab and notification should display as ' Incident Updated SuccessFully'")
	@Description("  If User enter and select all mandatory details in technician close Details popup then all details should display in technician close tab and notification should display as ' Incident Updated SuccessFully'")
	public void CheckNotificationWithSelectionInTechnicianCloseTab()
			throws Exception {
		// viewTicketPageOfSdRole.SelectEngineerInFilterTab();
		rm_EditIncidentPage
				.checkNotificationWithSelectionInTechnicianCloseTab();
	}

	// Technician close
	@Feature("Technician Close Tab")
	@Test(priority = 102, groups = { "Technician Close Tab" }, description = "If User click on Generate PDF button after technician close then in 'End Of Service' techclose date and time should display")
	@Description("If User click on Generate PDF button after technician close then in 'End Of Service' techclose date and time should display")
	public void CheckGeneratePDFLink() throws Exception {
		rm_EditIncidentPage.checkGeneratePDFLink();

	}

	@Feature("Technician Close Tab")
	@Test(priority = 103, groups = { "Technician Close Tab" }, description = "If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details pop up should not display and notification should display as 'Please Update ETA And ATA First.'")
	@Description("If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details pop up should not display and notification should display as 'Please Update ETA And ATA First.'")
	public void checkEditButtonAfterTechnicianClose() throws Exception {

		rm_EditIncidentPage.checkEditButtonAfterTechnicianClose();

	}

	@Feature("Technician Close Tab")
	@Test(priority = 104, groups = { "Technician Close Tab" }, description = "when the spare is replaced the the serial number field in tech close is match with the serial number in Final Close")
	@Description("when the spare is replaced the the serial number field in tech close is match with the serial number in Final Close")
	public void SelectTechnicianCloseWithSerialNo() throws Exception {
		rm_EditIncidentPage.selectTechnicianCloseWithSerialNo();

	}

	// Final close tab

	@Feature("Final Close Tab")
	@Test(priority = 105, groups = { "Final Close Tab" }, description = "If user click on the close button then Final close Detail pop up should get open ")
	@Description("If user click on the close button then Final close Detail pop up should get open ")
	public void checkFinalCloseDetailpopup() throws Exception {
		rm_EditIncidentPage.checkFinalCloseDetailpopup();

	}

	@Feature("Final Close Tab")
	@Test(priority = 106, groups = { "Final Close Tab" }, description = "without entering any data if user click on update detail button then 'Please enter Final close date.' pop up message should display.")
	@Description("without entering any data if user click on update detail button then 'Please enter Final close date.' pop up message should display.")
	public void CheckUpdateDetailsWithBlankData() throws Exception {
		rm_EditIncidentPage.checkUpdateDetailsWithBlankData();

	}

	@Feature("Final Close Tab")
	@Test(priority = 107, groups = { "Final Close Tab" }, description = "If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	@Description("If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	public void CompareCloseDateWithTechnicianDateTime() throws Exception {
		rm_EditIncidentPage.compareCloseDateWithTechnicianDateTime();

	}

	@Feature("Final Close Tab")
	@Test(priority = 108, groups = { "Final Close Tab" }, description = " If User enter final close date/time more than current date and time then notification should display as 'Final close Date/Time should be less than or Equal to Current Date/Time.'")
	@Description(" If User enter final close date/time more than current date and time then notification should display as 'Final close Date/Time should be less than or Equal to Current Date/Time.'")
	public void CompareCloseDateTimeWithCurrentDateTime() throws Exception {
		rm_EditIncidentPage.compareCloseDateTimeWithCurrentDateTime();

	}

	@Feature("Final Close Tab")
	@Test(priority = 109, groups = { "Final Close Tab" }, description = "If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	@Description("If user select the close date less than technician close date then 'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly.")
	public void CompareCloseDateTimeWithTechnicianDateTime() throws Exception {
		rm_EditIncidentPage.compareCloseDateTimeWithTechnicianDateTime();

	}

	@Feature("Final Close Tab")
	@Test(priority = 110, groups = { "Final Close Tab" }, description = "In user enter replaced  serial  number while techclose then in Final Close Details popup in same  number should display in serial number field")
	@Description("In user enter replaced  serial  number while techclose then in Final Close Details popup in same  number should display in serial number field")
	public void MatchReplacedSerialWithFinalCloseSerialNumber()
			throws Exception {
		rm_EditIncidentPage.matchReplacedSerialWithFinalCloseSerialNumber();

	}

	@Feature("Final Close Tab")
	@Test(priority = 111, groups = { "Final Close Tab" }, description = "In user enter replaced  serial  number while tech close and in Final Close Details pop up-> Update Serial No For this Asset field if user not enter any value then notification should display as 'Serial No. does not match.'")
	@Description("In user enter replaced  serial  number while tech close and in Final Close Details pop up-> Update Serial No For this Asset field if user not enter any value then notification should display as 'Serial No. does not match.'")
	public void MatchPopUpWithBlankUpdateSerialNoField() throws Exception {
		rm_EditIncidentPage.matchPopUpWithBlankUpdateSerialNoField();

	}

	@Feature("Final Close Tab")
	@Test(priority = 112, groups = { "Final Close Tab" }, description = "In user enter replaced  serial  number while tech close and in Final Close Details pop up->Update Serial No For this Asset field if user enter the different serial number then notification should display as 'Serial No. does not match.'")
	@Description("In user enter replaced  serial  number while tech close and in Final Close Details pop up-> Update Serial No For this Asset field if user enter the different serial number then notification should display as 'Serial No. does not match.'")
	public void MatchPopUpWithUpdateSerialNoFieldFill() throws Exception {
		rm_EditIncidentPage.matchPopUpWithUpdateSerialNoFieldFill();

	}

	@Feature("Final Close Tab")
	@Test(priority = 113, groups = { "Final Close Tab" }, description = "If User enter correct serial number while technician close then user need to enter same serial number in 'Update Serial No For this Asset' field in final close pop up to override on existing serial number")
	@Description("If User enter correct serial number while technician close then user need to enter same serial number in 'Update Serial No For this Asset' field in final close pop up to override on existing serial number")
	public void ClosePinkTicket() throws Exception {
		rm_EditIncidentPage.closePinkTicket();

	}

	// Create Sub Ticket

	@Test(priority = 114, groups = { "Create Sub Ticket" }, description = "If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ETA Date First' .")
	@Description("If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ETA Date First' .")
	public void CheckAlertMessageWithoutETA() throws Exception {
		rm_HomePage = new RM_HomePage();
		rm_IncidentPage = rm_HomePage.IncidentTab();
		Thread.sleep(1000);
		rm_EditIncidentPage = rm_IncidentPage.EditIncident();
		Thread.sleep(1000);
	//	rm_EditIncidentPage.SelectEngineerInFilterTab();
		rm_EditIncidentPage.checkAlertMessageWithoutETA();

	}

	@Test(priority = 115, groups = { "Create Sub Ticket" }, description = "If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ATA Date First' .")
	@Description("If User click on Create Sub Ticket button without punch ETA then notification should display as 'Please Update ATA Date First' .")
	public void CheckAlertMessageWithoutATA() throws Exception {
		rm_EditIncidentPage.checkAlertMessageWithoutATA();

	}

	@Test(priority = 116, groups = { "Create Sub Ticket" }, description = " If User click on create sub ticket button for pause ticket then ticket form should get open to record sub ticket And If User click on View Sub ticket button then 'List of your Requests' page should get open with Pause ticket window of selected parent ticket ")
	@Description(" If User click on create sub ticket button for pause ticket then ticket form should get open to record sub ticket And If User click on View Sub ticket button then 'List of your Requests' page should get open with Pause ticket window of selected parent ticket ")
	public void checkCreateSubTicketAndViewSubTicketForPause() throws Exception {
		rm_EditIncidentPage.checkCreateSubTicketAndViewSubTicketForPause();

	}

/*	@Test(priority = 01, invocationCount = 1)
	public void Ticket() throws Exception { // createNewPageTestCaseOfSdRole.createNewTicket();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		rm_HomePage = new SD_HomePage();
		rm_IncidentPage = rm_HomePage.ticketTab();
		Thread.sleep(1000);
		createNewPageOfSdRole = rm_IncidentPage.createNewTab();
		Thread.sleep(1000);

		createNewPageOfSdRole.createNewTicket();
		// viewTicketPageOfSdRole.punchETAAndATAAfterCreatingTicket();

		// viewTicketPageOfSdRole.pauseTheTicket();

	}*/

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

				FileUtils.copyFile(scrFile, new File(currentDir
						+ "/Screenshots/" + result.getMethod().getMethodName()
						+ ".jpg"));

				/*
				 * driver.quit(); initialization();
				 * 
				 * loginPageOfSdRole = new LoginPageOfSdRole();
				 * Thread.sleep(1000); homePageOfSdRole =
				 * loginPageOfSdRole.login(
				 * properties.getProperty("loginIdForSd"),
				 * properties.getProperty("password")); Thread.sleep(1000);
				 */
				// takeScreenshot(dateTimeStamp,driver,methodName);
				// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
				// Do your excel writing stuff here

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

			}
	

	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
