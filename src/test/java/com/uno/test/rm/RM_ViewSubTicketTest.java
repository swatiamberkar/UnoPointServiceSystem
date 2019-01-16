package com.uno.test.rm;


import io.qameta.allure.Description;





import io.qameta.allure.Feature;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.excelUtility.WebEventListener;
import com.uno.pages.rm.RM_CreateNewPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_ViewSubTicketPage;



public class RM_ViewSubTicketTest extends BaseCode 
{
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_ViewSubTicketPage rm_ViewSubTicketPage;
	RM_CreateNewTest rm_CreateNewTest;
	RM_CreateNewPage rm_CreateNewPage;
	RM_IncidentPage rm_IncidentPage;
	WebEventListener webEventListener;
	ITestResult result;
	ExtentTest extentTest;
	
	
	String xlFilePath = "D:\\UnoPoint\\RM_UnoPointServiceSystem\\src\\main\\java\\com\\rm\\file\\View Sub Ticket.xlsx";
    String sheetName = "Ticket ID";
    String sheetNameForAssetId = "Asset ID";

	public RM_ViewSubTicketTest() {
		super();
	}

	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception 
	{
		initialization();

		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);



	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket() throws Exception 
	{  
		 try {
			Thread.sleep(1000);
			rm_HomePage = new RM_HomePage();
			rm_IncidentPage = rm_HomePage.IncidentTab();
				Thread.sleep(1000);
				rm_ViewSubTicketPage = rm_IncidentPage.viewSubTicketTab();
				Thread.sleep(1000);
		} catch (Exception e) {
			
			driver.close();
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			
			rm_HomePage = new RM_HomePage();
			rm_IncidentPage = rm_HomePage.IncidentTab();
				Thread.sleep(1000);
				rm_ViewSubTicketPage = rm_IncidentPage.viewSubTicketTab();
				Thread.sleep(1000);
		
		}
		
		

	}
	// Table in View Sub Ticket //

	@Test(priority = 1, groups = { "Table in View Sub Ticket" }, description = "If User click on View Sub ticket tab then 'list of your requests' page should display")
	@Description("If User click on View Sub ticket tab then 'list of your requests' page should display")
	public void CheckPageNameOfViewSubTickets() throws Exception
	{
		rm_ViewSubTicketPage.checkPageNameOfViewSubTickets();
	}

	@Test(priority = 2, groups = { "pagination" }, description = "Count the Ticket in view sub ticket")
	@Description("Count the Ticket in view sub ticket")
	public void CountOfPagination() throws Exception {
		rm_ViewSubTicketPage.countOfPagination();
	}

	@Test(priority = 3, groups = { "pagination" }, description = "Display Pages As Per Arrows Of Pagination")
	@Description("Display Pages As Per Arrows Of Pagination")
	public void DisplayAsPerArrowsOfPagination() throws Exception {
		rm_ViewSubTicketPage.displayAsPerArrowsOfPagination();
	}

	@Test(priority = 4, groups = { "Table in View Sub Ticket" }, description = "Incident Id should in descending Order.")
	@Description("Incident Id should in descending Order.")
	public void DisplayDescendingOrderOfIncidentID() throws Exception {
		rm_ViewSubTicketPage.displayDescendingOrderOfIncidentID();
	}

	/*@Test(priority = 5, groups = { "Table in View Sub Ticket" }, description = "Column Header should display As Per My View Popup.")
	@Description("Column Header should display As Per My View Popup.")
	public void DisplayColumnHeader() throws Exception
	{
		rm_ViewSubTicketPage.displayColumnHeader();
	}*/
   
	@Test(priority = 6, groups = { "Table in View Sub Ticket" }, description = "Check Hyper link is present for all ID's")
	@Description("Check Hyper link is present for all ID's")
	public void CheckHyperlinkOfID() throws Exception {
		rm_ViewSubTicketPage.checkHyperlinkOfID();
	}
	
	@Test(priority = 7, groups = { "Table in View Sub Ticket" }, description = "Check Hyper link is present for all Customer's")
	@Description("Check Hyper link is present for all Customer's")
	public void CheckHyperlinkOfCustomer() throws Exception {
		rm_ViewSubTicketPage.checkHyperlinkOfCustomer();
	}

	@Test(priority = 8, groups = { "Table in View Sub Ticket" }, description = "Check Hyper link is present for all Asset Id's")
	@Description("Check Hyper link is present for all Asset Id's")
	public void CheckHyperlinkOfAssetId() throws Exception {
		rm_ViewSubTicketPage.checkHyperlinkOfAssetId();
	}

	@Test(priority = 9, groups = { "Table in View Sub Ticket" }, description = "Check Blinking Notification is Correct or not.")
	@Description("Check Blinking Notification is Correct or not.")
	public void CheckBlinkingNotification() throws Exception {
		rm_ViewSubTicketPage.checkBlinkingNotification();

	}
	
	@Test(priority = 10, groups = { "Table in View Sub Ticket" }, description = "Check Hidden Message Of Flag For Address is Correct or not.")
	@Description("Check Hidden Message Of Flag For Address is Correct or not.")
	public void CheckHiddenMessageOfAddress() throws Exception {
		rm_ViewSubTicketPage.checkHiddenMessageOfAddress();
	}


	@Test(priority = 11, groups = { "Table in View Sub Ticket" }, description = "Check Hidden Message Of SLA Flag is Correct or not.")
	@Description("Check Hidden Message Of SLA Flag is Correct or not.")
	public void CheckHiddenMessageOfSLAFlag() throws Exception {
		rm_ViewSubTicketPage.checkHiddenMessageOfSLAFlag();
	}

	@Test(priority = 12, groups = { "Table in View Sub Ticket" }, description = "Check Hidden Message Of Response Flag is Correct or not.")
	@Description("Check Hidden Message Of Response Flag is Correct or not.")
	public void CheckHiddenMessageOfResponseFlag() throws Exception {
		rm_ViewSubTicketPage.checkHiddenMessageOfResponseFlag();
	}

	@DataProvider
	public String[][] getTicketIDSheetdata() throws InvalidFormatException, IOException{
		TestUtil data= new TestUtil();
		//Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetName);
		
		
	 }
	
	@Test(priority = 13, dataProvider= "getTicketIDSheetdata")
	@Description("If User  team check box and click on Login button with wrong details, then lblNotification"
			+ " should display as 'Wrong User name and Password'")
	public void VerifyTicketIdTextBox(String ticketID) throws Exception
	{
		//loginPageOfSdRole.checkWithWrongLoginCredentials();
		rm_ViewSubTicketPage.verifyTicketIdTextBox(ticketID);
	
	}	
	@DataProvider
	public String[][] getAssetIDSheetdata() throws InvalidFormatException, IOException{
		TestUtil data= new TestUtil();
		//Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetNameForAssetId);
		
		
	 }
	
	@Test(priority = 14, dataProvider= "getAssetIDSheetdata")
	@Description("If User  team check box and click on Login button with wrong details, then lblNotification"
			+ " should display as 'Wrong User name and Password'")
	public void VerifyAssetIdTextBox(String assetID) throws Exception
	{
		//loginPageOfSdRole.checkWithWrongLoginCredentials();
		rm_ViewSubTicketPage.verifyAssetIdTextBox(assetID);
	
	}	

	@Test(priority = 15,  groups = { "Table in View Sub Ticket" }, description = "If User  team check box and click on Login button with wrong details, then lblNotification"
			+ " should display as 'Wrong User name and Password'" )
	@Description("If User  team check box and click on Login button with wrong details, then lblNotification"
			+ " should display as 'Wrong User name and Password'")
	public void matchStatusOfParentTicket() throws Exception
	{
		rm_ViewSubTicketPage.matchStatusOfParentTicket();
		
	}
		
	@Test(priority = 16,  groups = { "Table in View Sub Ticket" }, description = "After click hyper link of ID then 'List of your requests' page should "
			+ "display with all sub ticket entries of same parent ticket" )
	@Description("After click hyper link of ID then 'List of your requests' page should"
			+ " display with all sub ticket entries of same parent ticket")
	public void matchSubTicketIdWithParentTicketId() throws Exception
	{
		rm_ViewSubTicketPage.matchSubTicketIdWithParentTicketId();
		
	}

	
	@Test(priority = 17, groups = { "Table in View Sub Ticket" }, description = "If User click on Subticket ID hyperlink then 'Sub Ticket Form' should display to edit sub ticket" )
	@Description("If User click on Subticket ID hyperlink then 'Sub Ticket Form' should display to edit sub ticket")
	public void checkTheSubTicketFormWindow() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		rm_ViewSubTicketPage.checkTheSubTicketFormWindow();
	}

//Nature of call	
	@Test(priority = 18, groups = "Nature Of Call ", description = "1.If User click on Edit button then 'Nature of Call' pop up should display."
			+ "2. If User update details in Nature of Call pop up and click on Cancel button then updated details should not save in Nature of Call tab." )
	@Description("1.If User click on Edit button then 'Nature of Call' pop up should display."
			+ "2.If User update details in Nature of Call pop up and click on Cancel button then updated details should not save in Nature of Call tab.")
	public void checkNatureOfCallPopUpAndCancelButtonFunctinality() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		rm_ViewSubTicketPage.checkNatureOfCallPopUpAndCancelButtonFunctinality();
	}
	@Test(priority = 19, groups = "Nature Of Call ", description = "Match type of call list with super login-> SD master-> Ticket Master-> Ticket Type")
	@Description("Match type of call list with super login-> SD master-> Ticket Master-> Ticket Type")
	public void MatchTheTypeOfCallWithSuperLogin() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		rm_ViewSubTicketPage.matchTheTypeOfCallWithSuperLogin();
	}
	
	@Test(priority = 20, groups = "Nature Of Call ", description = "Match type of call list with super login-> SD master-> Ticket Master-> Ticket Mode")
	@Description("Match type of call list with super login-> SD master-> Ticket Master-> Ticket Mode")
	public void MatchTheModeWithSuperLogin() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.matchTheModeWithSuperLogin();
	}
	@Test(priority = 21, groups = "Nature Of Call ", description = "Match type of call list with super login-> SD master-> Ticket Master-> Ticket Level")
	@Description("Match type of call list with super login-> SD master-> Ticket Master-> Ticket Level")
	public void MatchTheLevelWithSuperLogin() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.matchTheLevelWithSuperLogin();
	}
	@Test(priority = 22, groups = "Nature Of Call ", description = "If User update details in Nature of Call pop up and click on Update Details button then updated details "
			+ "should save in Nature of Call tab")
	@Description("If User update details in Nature of Call pop up and click on Update Details button then updated details "
			+ "should save in Nature of Call tab")
	public void UpdateTheDetailInNatureOfCall() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.updateTheDetailInNatureOfCall();
	}
	
//File Attachments
	
	@Test(priority = 22, groups = "File Attachments", description = "In File attachments-> file type lists should display"
			+ " all options as mention in  file category master in Super login")
	@Description("In File attachments-> file type lists should display all options as mention in  file category master "
			+ "in Super login")
	public void MatchFileCategory() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.matchFileCategory();
	}
	
	
	@Test(priority = 23, groups = "File Attachments", description = "1. If user click on choose file button then 'please select file type' pop up should get open."
			+ "2. After selecting file type and click on upload file then 'please select file' pop up should get open")
	@Description("1. If user click on choose file button then 'please select file type' pop up should get open."
			+ "2. After selecting file type and click on upload file then 'please select file' pop up should get open")
	public void matchpopUpOfFileTypeAndFile() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.matchpopUpOfFileTypeAndFile();
	}
	@Test(priority = 24, groups = "File Attachments", description = "1. If  user choose file from system then name of same file should display in front of choose file button"
			+ "2. If user click on Upload file button with attach any attachment then lblNotification should display as 'File Uploaded Successfully...!'"
			+ "3. If User click on Hyper link of attachment file then file should get download")
	@Description("1. If  user choose file from system then name of same file should display in front of choose file button "
			+ "2. If user click on Upload file button with attach any attachment then lblNotification should display as 'File Uploaded Successfully...!'"
			+ "3. If User click on Hyper link of attachment file then file should get download")
	public void matchUploadedFile() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.matchUploadedFile();
	
	}
	
//ETA And Technician
	
	@Test(priority = 25, groups = "ETA And Technician", 
			description = "1.If user click on Edit button in ETA and technician tab, then 'Technician Assign And ETA Details' pop up should display"
			+ "2.If user keep Technician field  as blank and click on Update Details page then lblNotification should display 'Please select engineer.'"
			+ "3.In 'Technicians Assign And ETA Details'  pop up If User click on list symbol of Technician Field then 'List of your Technicians' pop up should display"
			+ "4.In ETA Date field, user should not enter manual data "
					+ "5.In ETA Date field, if user select date from calendar then same should get fill into ETA date field"
					+ "6.In ETA time field, if user keep 00 hr and 00min and click on Update details button then lblNotification should display as 'Please enter ETA Time.'")
	@Description("1.If user click on Edit button in ETA and technician tab, then 'Technician Assign And ETA Details' pop up should display"
			+ "2.If user keep Technician field  as blank and click on Update Details page then lblNotification should display 'Please select engineer.'"
			+ "3.In 'Technicians Assign And ETA Details'  pop up If User click on list symbol of Technician Field then 'List of your Technicians' pop up should display")
	
	public void PunchETAandTchnician() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.punchETAandTchnician();
	
	}

	//ATA Technician
	@Test(priority = 26, groups = "ATA", description = "1. If User click on Edit button of ATA tab without update ETA tab then lblNotification should display as 'Please Select ETA And Technician First.")
	@Description("1.If User click on Edit button of ATA tab without update ETA tab then lblNotification should display as 'Please Select ETA And Technician First.")
	public void DisplayNotificationWithoutETAInATATab() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicketWithoutETA();
		rm_ViewSubTicketPage.displayNotificationWithoutETAInATATab();
	}
	
	@Test(priority = 27, groups = "ATA", description = "If user select ATA date and Time less than Incident Date and"
			+ " Time then lblNotification should display as ' ATA Date Time should be greater than Incident Date Time '")
	@Description("If user select ATA date and Time less than Incident Date and Time then lblNotification should display as "
			+ "' ATA Date Time should be greater than Incident Date Time '")
	public void checkATADateAndTimeWithIncidentDateAndTime() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.checkATADateAndTimeWithIncidentDateAndTime();
	}
	@Test(priority = 28, groups = "ATA", description = "If user select ATA date and Time less than ETA Date and Time then"
			+ " lblNotification should display as ' Incident Updated Successfully  ' "
			+ "and data/time should get update on ATA tab")
	@Description("If user select ATA date and Time less than ETA Date and Time then"
			+ " lblNotification should display as ' Incident Updated Successfully  ' "
			+ "and data/time should get update on ATA tab")
	public void PunchATA() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		rm_ViewSubTicketPage.punchATA();
		
	}

	// Pause Tab //

	@Feature("Pause Tab")
	@Test(priority = 29, groups = { "Pause Tab" }, description = "If user click on edit button of Pause tab without punching  ETA/ATA then"
			+ " lblNotification should display as 'Please Update ETA First.'")
	@Description("If user click on edit button of Pause tab without punching  ETA/ATA then"
			+ " lblNotification should display as 'Please Update ETA First.'")
	public void DisplayNotificationWithoutETAAndATAinPauseTab()
			throws Exception {
		
		rm_ViewSubTicketPage.displayNotificationWithoutETAAndATAInPauseTab();
     }
     

	@Feature("Pause Tab")
	@Test(priority = 30, groups = { "Pause Tab" }, description = "1.If User click on Edit button of Pause tab then Pause details  popup should get open"
			+ "2.If User click on Update Details button in Pause details popup then lblNotification should display as 'Please Enter All Mandetory Fields'"
			+ "3.If user click on list symbol of 'Reason To Pause' field, List of Pause Reasons popup should display with pause reasons"
			+ "4.If user click on hyperlink any pause reason then same should get filled into Reason To Pause field"
			+ "5.User should not enter manual entry in Auto Resume Date field"
			+ "6.If user click on calender symbol of Auto resume date field then same date should get filled"
			+ "7.In Total pause time(minutes) column, number of minutes should display between start date/time and end date/time"
			+ "8.If Pause end date Time and Total Pause Time(minutes) are filled in pause tab then ticket should display as 'Open' status")
	@Description("To check the functionality of Edit ticket-Pause tab-after click on Edit button, "
			+ "Pause details popup should get open")
	public void CheckPauseTab() throws Exception 
	{
		
		rm_ViewSubTicketPage.clickOnSubTicket();
		rm_ViewSubTicketPage.pauseTheTicket();
		rm_ViewSubTicketPage.checkPauseDetails();
		rm_ViewSubTicketPage.checkLatestPauseDetails();
		rm_ViewSubTicketPage.countTotalPauseTimeInPauseTab();
    
	}

//Technician close	
	@Test(priority = 31, groups = "Technician close", description = "1. If User click on Edit button of Technician close tab without update ETA tab then lblNotification should display as 'Please Select ETA And Technician First.")
	@Description("1.If User click on Edit button of Technician close tab without update ETA tab then lblNotification should display as 'Please Select ETA And Technician First.")
	public void CheckTechnicianCloseWithoutETA() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicketWithoutETA();
		rm_ViewSubTicketPage.clickOnEditButtonAndCheckNotification();
	}
	
	@Test(priority = 32, groups = "Technician close", description = "1. If User click on Update Details in Techclose tab without enter any details then lblNotification should display as 'Please Select Tech Close Date And Time'"
			+ "2.If User click on Update Details in Techclose tab without enter Resolution then lblNotification should display as 'Please Enter Resolution'"
			+ "3.If User click on Update Details in Techclose tab without enter Resolution description then lblNotification should display as 'Please Enter Resolutin Description'")
	@Description("1. If User click on Update Details in Techclose tab without enter any details then lblNotification should display as 'Please Select Tech Close Date And Time'"
			+ "2.If User click on Update Details in Techclose tab without enter Resolution then lblNotification should display as 'Please Enter Resolution'"
			+ "3.If User click on Update Details in Techclose tab without enter Resolution description then lblNotification should display as 'Please Enter Resolutin Description'")
	public void CheckUpdateDetailInTechnicianClose() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicket();
		rm_ViewSubTicketPage.checkUpdateDetailInTechnicianClose();
	}
	
	@Test(priority = 33, groups = "Technician close", description = "1.If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details popup should not display and lblNotification should display as 'Please Update ETA And ATA First.' ")
	@Description("1.If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details popup should not display and lblNotification should display as 'Please Update ETA And ATA First.' ")
	public void CheckTechnicianCloseWithAleradyTechClose() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		rm_ViewSubTicketPage.clickOnEditButtonAndCheckNotification();
	}
	
//Final Close Tab
	@Test(priority = 34, groups = "Technician close", description = "1.If user click on Update details button in Final close details popup without enter any details  then lblNotification should display as 'Please enter Final close date.'")
	@Description("1.If user click on Update details button in Final close details popup without enter any details  then lblNotification should display as 'Please enter Final close date.'")
	public void CheckUpdateDetailsWithBlankData() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		rm_ViewSubTicketPage.checkUpdateDetailsWithBlankData();
	}
	
	
	
	@Feature("Final Close Tab")
	@Test(priority = 35, groups = { "Final Close Tab" }, description="1.if user select the close date less than technician close date then "
			+ "'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly."
			+ "2.if user select the close date greater than current date and time then "
			+ "'Final Close date time should be less than or Equal to Current date time'.pop up should be dispaly.'"
			+ "3. If user click on Update details button in Final close details popup without enter Final close time  then lblNotification should display as 'Final close date/time should be greater than Tech close date/time.'"
			+ "4.If user click on Update details button in Final close details popup without enter Final close time  then lblNotification should display as 'Final close date/time should be greater than Tech close date/time.'")
	@Description("1.if user select the close date less than technician close date then "
			+ "'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly."
			+ "2.if user select the close date greater than current date and time then "
			+ "'Final Close date time should be less than or Equal to Current date time'.pop up should be dispaly.'"
			+ "3.If user click on Update details button in Final close details popup without enter Final close time  then lblNotification should display as 'Final close date/time should be greater than Tech close date/time.'"
			+ "4.If user click on Update details button in Final close details popup without enter Final close time  then lblNotification should display as 'Final close date/time should be greater than Tech close date/time.'")
	public void verifyCloseDate() throws Exception 
	{
		rm_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		rm_ViewSubTicketPage.compareCloseDateWithTechnicianDateTime();
		rm_ViewSubTicketPage.checkNotificationWithoutSelectingTime();
    	rm_ViewSubTicketPage.compareCloseDateWithCurrentDateTime();
     }

	@Test(priority = 36, groups = "Technician close", description = "1.Enter  all the details and close the sub ticket'")
	@Description("1.If user click on Update details button in Final close details popup without enter any details  then lblNotification should display as 'Please enter Final close date.'")
	public void CloseTicket() throws Exception
	{
		rm_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		rm_ViewSubTicketPage.closeSubTicket();
	}

	@Test(priority = 37, groups = "Technician close", description = "1.Enter  all the details and close the sub ticket'")
	@Description("1.If user click on Update details button in Final close details popup without enter any details  then lblNotification should display as 'Please enter Final close date.'")
	public void CheckAfterTechCloseTheParentTicketGetOpen() throws Exception
	{
		rm_ViewSubTicketPage.checkParentTicketStatusAfterCloseAllSubTicket();
		
	}

	

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

				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);

				String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
						+ result.getMethod().getMethodName() + ".jpg"));

			/*	driver.quit();
				initialization();

				rm_LoginPage = new SD_LoginPage();
				rm_HomePage = rm_LoginPage.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				
				rm_HomePage = new Sd_HomePage();
				sd_TicketPage = rm_HomePage.ticketTab();
				Thread.sleep(1000);
				sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
				Thread.sleep(1000);*/

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				
				
				driver.quit();
				initialization();

				rm_LoginPage = new RM_LoginPage();
				rm_HomePage = rm_LoginPage.Login(
						properties.getProperty("loginIdForRM"),
						properties.getProperty("password"));
				Thread.sleep(1000);
				
				rm_HomePage = new RM_HomePage();
				rm_IncidentPage = rm_HomePage.IncidentTab();
					Thread.sleep(1000);
					rm_ViewSubTicketPage = rm_IncidentPage.viewSubTicketTab();
					Thread.sleep(1000);

			}
		} catch (Exception e) 
		{
			
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			
			rm_HomePage = new RM_HomePage();
			rm_IncidentPage = rm_HomePage.IncidentTab();
				Thread.sleep(1000);
				rm_ViewSubTicketPage = rm_IncidentPage.viewSubTicketTab();
				Thread.sleep(1000);
		
		}


	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
