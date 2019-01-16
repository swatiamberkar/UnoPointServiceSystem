package com.uno.test.sd;

import io.qameta.allure.Description;





import io.qameta.allure.Feature;

import java.io.File;

import org.apache.commons.io.FileUtils;
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
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewSubTicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;


public class SD_ViewSubTicketTest extends BaseCode 
{
	
	SD_ViewSubTicketPage sd_ViewSubTicketPage;
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_CreateNewPage sd_CreateNewPage;
	SD_CreateNewTest sd_CreateNewTest;
	SD_TicketPage sd_TicketPage;
	SD_ViewTicketPage sd_ViewTicketPage;
	SD_ViewTicketTest sd_ViewTicketTest;

	ITestResult result;
	ExtentTest extentTest;
	
	
	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\file\\View Sub Ticket.xlsx";
    String sheetName = "Ticket ID";

	public SD_ViewSubTicketTest() 
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
		Thread.sleep(1000);


	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket() throws Exception 
	{  
		 try {
			Thread.sleep(1000);
				sd_HomePage = new SD_HomePage();
				sd_TicketPage = sd_HomePage.ticketTab();
				Thread.sleep(1000);
				sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
				Thread.sleep(1000);
		} catch (Exception e) {
			
			driver.close();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			
			sd_HomePage = new SD_HomePage();
			sd_TicketPage = sd_HomePage.ticketTab();
			Thread.sleep(1000);
			sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
		
		}
		
		

	}

	// Table in View Sub Ticket //

	@Test(priority = 1, groups = { "Table in View Sub Ticket", "Regression Testing"}, description = "If User click on View Sub ticket tab then 'list of your requests' page should display")
	@Description("If User click on View Sub ticket tab then 'list of your requests' page should display")
	public void CheckPageNameOfViewSubTickets() throws Exception {
		sd_ViewSubTicketPage.checkPageNameOfViewSubTickets();
	}

	@Test(priority = 2, groups = { "pagination","Smoke Testing" }, description = "Count the Ticket in view sub ticket")
	@Description("Count the Ticket in view sub ticket")
	public void CountOfPagination() throws Exception {
		sd_ViewSubTicketPage.countOfPagination();
	}

	@Test(priority = 3, groups = { "pagination", "Smoke Testing" }, description = "Display Pages As Per Arrows Of Pagination")
	@Description("Display Pages As Per Arrows Of Pagination")
	public void DisplayAsPerArrowsOfPagination() throws Exception {
		sd_ViewSubTicketPage.displayAsPerArrowsOfPagination();
	}

	@Test(priority = 4, groups = { "Table in View Sub Ticket","Smoke Testing" }, description = "Incident Id should in descending Order.")
	@Description("Incident Id should in descending Order.")
	public void DisplayDescendingOrderOfIncidentID() throws Exception 
	{
		sd_ViewSubTicketPage.displayDescendingOrderOfIncidentID();
	}

	@Test(priority = 5, groups = { "Table in View Sub Ticket","Regression Testing"}, description = "Column Header should display As Per My View Popup.")
	@Description("Column Header should display As Per My View Popup.")
	public void DisplayColumnHeaderInSubTicket() throws Exception
	{
		sd_ViewSubTicketPage.displayColumnHeaderInSubTicket();
	}
   
	@Test(priority = 6, groups = { "Table in View Sub Ticket","Smoke Testing" }, description = "Check Hyper link is present for all ID's")
	@Description("Check Hyper link is present for all ID's")
	public void CheckHyperlinkOfID() throws Exception 
	{
		sd_ViewSubTicketPage.checkHyperlinkOfID();
	}
	
	@Test(priority = 7, groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "Check Hyper link is present for all Customer's")
	@Description("Check Hyper link is present for all Customer's")
	public void CheckHyperlinkOfCustomer() throws Exception {
		sd_ViewSubTicketPage.checkHyperlinkOfCustomer();
	}

	@Test(priority = 8, groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "Check Hyper link is present for all Asset Id's")
	@Description("Check Hyper link is present for all Asset Id's")
	public void CheckHyperlinkOfAssetId() throws Exception {
		sd_ViewSubTicketPage.checkHyperlinkOfAssetId();
	}

	@Test(priority = 9, groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "Check Blinking Notification is Correct or not.")
	@Description("Check Blinking Notification is Correct or not.")
	public void CheckBlinkingNotification() throws Exception 
	{
		sd_ViewSubTicketPage.checkBlinkingNotification();

	}
	
	@Test(priority = 10, groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "Check Hidden Message Of Flag For Address is Correct or not.")
	@Description("Check Hidden Message Of Flag For Address is Correct or not.")
	public void CheckHiddenMessageOfAddress() throws Exception {
		sd_ViewSubTicketPage.checkHiddenMessageOfAddress();
	}


	@Test(priority = 11, groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "Check Hidden Message Of SLA Flag is Correct or not.")
	@Description("Check Hidden Message Of SLA Flag is Correct or not.")
	public void CheckHiddenMessageOfSLAFlag() throws Exception {
		sd_ViewSubTicketPage.checkHiddenMessageOfSLAFlag();
	}

	@Test(priority = 12, groups = { "Table in View Sub Ticket" , "Smoke Testing"}, description = "Check Hidden Message Of Response Flag is Correct or not.")
	@Description("Check Hidden Message Of Response Flag is Correct or not.")
	public void CheckHiddenMessageOfResponseFlag() throws Exception {
		sd_ViewSubTicketPage.checkHiddenMessageOfResponseFlag();
	}

	@DataProvider
	public String[][] getTicketIDSheetdata() throws Exception{
		TestUtil data= new TestUtil();
		//Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetName);
		
		
	 }
	
	@Test(priority = 13, dataProvider= "getTicketIDSheetdata")
	@Description("If User  team check box and click on Login button with wrong details, then notification"
			+ " should display as 'Wrong User name and Password'")
	public void VerifyTicketIdTextBox(String ticketID) throws Exception
	{
		//sd_LoginPage.checkWithWrongLoginCredentials();
		sd_ViewSubTicketPage.verifyTicketIdTextBox(ticketID);
	
	}	


	@Test(priority = 14,  groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "If User click on View Sub ticket tab then list of your requests page"
			+ " should display with all Parent tickets in Pause status" )
	@Description("If User click on View Sub ticket tab then list of your requests page"
			+ " should display with all Parent tickets in Pause status")
	public void matchStatusOfParentTicket() throws Exception
	{
		sd_ViewSubTicketPage.matchStatusOfParentTicket();
		
	}
		
	@Test(priority = 15,  groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "After click hyper link of ID then 'List of your requests' page should "
			+ "display with all sub ticket entries of same parent ticket" )
	@Description("After click hyper link of ID then 'List of your requests' page should"
			+ " display with all sub ticket entries of same parent ticket")
	public void matchSubTicketIdWithParentTicketId() throws Exception
	{
		sd_ViewSubTicketPage.matchSubTicketIdWithParentTicketId();
		
	}

	@Test(priority = 16, groups = { "Table in View Sub Ticket", "Smoke Testing" }, description = "If User click on Subticket ID hyperlink then 'Sub Ticket Form' should display to edit sub ticket" )
	@Description("If User click on Subticket ID hyperlink then 'Sub Ticket Form' should display to edit sub ticket")
	public void checkTheSubTicketFormWindow() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		sd_ViewSubTicketPage.checkTheSubTicketFormWindow();
	}
	
//Nature of call	
	@Test(priority = 17, groups = "Nature Of Call ", description = "1.If User click on Edit button then 'Nature of Call' pop up should display."
			+ "2. If User update details in Nature of Call pop up and click on Cancel button then updated details should not save in Nature of Call tab." )
	@Description("1.If User click on Edit button then 'Nature of Call' pop up should display."
			+ "2.If User update details in Nature of Call pop up and click on Cancel button then updated details should not save in Nature of Call tab.")
	public void checkNatureOfCallPopUpAndCancelButtonFunctinality() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		sd_ViewSubTicketPage.checkNatureOfCallPopUpAndCancelButtonFunctinality();
	}
	@Test(priority = 18, groups = "Nature Of Call ", description = "Match type of call list with super login-> SD master-> Ticket Master-> Ticket Type")
	@Description("Match type of call list with super login-> SD master-> Ticket Master-> Ticket Type")
	public void MatchTheTypeOfCallWithSuperLogin() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		sd_ViewSubTicketPage.matchTheTypeOfCallWithSuperLogin();
	}
	
	@Test(priority = 19, groups = "Nature Of Call ", description = "Match type of call list with super login-> SD master-> Ticket Master-> Ticket Mode")
	@Description("Match type of call list with super login-> SD master-> Ticket Master-> Ticket Mode")
	public void MatchTheModeWithSuperLoginInSubTicket() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.matchTheModeWithSuperLogin();
	}
	@Test(priority = 20, groups = "Nature Of Call ", description = "Match type of call list with super login-> SD master-> Ticket Master-> Ticket Level")
	@Description("Match type of call list with super login-> SD master-> Ticket Master-> Ticket Level")
	public void MatchTheLevelWithSuperLogin() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.matchTheLevelWithSuperLogin();
	}
	@Test(priority = 20, groups = "Nature Of Call ", description = "If User update details in Nature of Call pop up and click on Update Details button then updated details "
			+ "should save in Nature of Call tab")
	@Description("If User update details in Nature of Call pop up and click on Update Details button then updated details "
			+ "should save in Nature of Call tab")
	public void UpdateTheDetailInNatureOfCall() throws Exception
	{

		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.updateTheDetailInNatureOfCall();
	}

//File Attachments
	
	@Test(priority = 21, groups = "File Attachments", description = "In File attachments-> file type lists should display"
			+ " all options as mention in  file category master in Super login")
	@Description("In File attachments-> file type lists should display all options as mention in  file category master "
			+ "in Super login")
	public void MatchFileCategory() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.matchFileCategory();
	}
	
	
	@Test(priority = 22, groups = "File Attachments", description = "1. If user click on choose file button then 'please select file type' pop up should get open."
			+ "2. After selecting file type and click on upload file then 'please select file' pop up should get open")
	@Description("1. If user click on choose file button then 'please select file type' pop up should get open."
			+ "2. After selecting file type and click on upload file then 'please select file' pop up should get open")
	public void matchpopUpOfFileTypeAndFile() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.matchpopUpOfFileTypeAndFile();
	}
	@Test(priority = 23, groups = "File Attachments", description = "1. If  user choose file from system then name of same file should display in front of choose file button"
			+ "2. If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!'"
			+ "3. If User click on Hyper link of attachment file then file should get download")
	@Description("1. If  user choose file from system then name of same file should display in front of choose file button "
			+ "2. If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!'"
			+ "3. If User click on Hyper link of attachment file then file should get download")
	public void matchUploadedFile() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.matchUploadedFile();
	
	}

//ETA And Technician
	
	@Test(priority = 24, groups = "ETA And Technician", 
			description = "1.If user click on Edit button in ETA and technician tab, then 'Technician Assign And ETA Details' pop up should display"
			+ "2.If user keep Technician field  as blank and click on Update Details page then notification should display 'Please select engineer.'"
			+ "3.In 'Technicians Assign And ETA Details'  pop up If User click on list symbol of Technician Field then 'List of your Technicians' pop up should display"
			+ "4.In ETA Date field, user should not enter manual data "
					+ "5.In ETA Date field, if user select date from calendar then same should get fill into ETA date field"
					+ "6.In ETA time field, if user keep 00 hr and 00min and click on Update details button then notification should display as 'Please enter ETA Time.'")
	@Description("1.If user click on Edit button in ETA and technician tab, then 'Technician Assign And ETA Details' pop up should display"
			+ "2.If user keep Technician field  as blank and click on Update Details page then notification should display 'Please select engineer.'"
			+ "3.In 'Technicians Assign And ETA Details'  pop up If User click on list symbol of Technician Field then 'List of your Technicians' pop up should display")
	
	public void PunchETAandTchnician() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.punchETAandTchnician();
	
	}

	//ATA Technician
	@Test(priority = 25, groups = "ATA", description = "1. If User click on Edit button of ATA tab without update ETA tab then notification should display as 'Please Select ETA And Technician First.")
	@Description("1.If User click on Edit button of ATA tab without update ETA tab then notification should display as 'Please Select ETA And Technician First.")
	public void DisplayNotificationWithoutETAInATATab() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithoutETA();
		sd_ViewSubTicketPage.displayNotificationWithoutETAInATATab();
	}
	
	@Test(priority = 26, groups = "ATA", description = "If user select ATA date and Time less than Incident Date and"
			+ " Time then notification should display as ' ATA Date Time should be greater than Incident Date Time '")
	@Description("If user select ATA date and Time less than Incident Date and Time then notification should display as "
			+ "' ATA Date Time should be greater than Incident Date Time '")
	public void checkATADateAndTimeWithIncidentDateAndTime() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.checkATADateAndTimeWithIncidentDateAndTime();
	}
	@Test(priority = 27, groups = "ATA", description = "If user select ATA date and Time less than ETA Date and Time then"
			+ " notification should display as ' Incident Updated Successfully  ' "
			+ "and data/time should get update on ATA tab")
	@Description("If user select ATA date and Time less than ETA Date and Time then"
			+ " notification should display as ' Incident Updated Successfully  ' "
			+ "and data/time should get update on ATA tab")
	public void PunchATA() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicket();
		Thread.sleep(2000);
		sd_ViewSubTicketPage.punchATA();
		
	}

	// Pause Tab //

	@Feature("Pause Tab")
	@Test(priority = 28, groups = { "Pause Tab" }, description = "If user click on edit button of Pause tab without punching  ETA/ATA then"
			+ " notification should display as 'Please Update ETA First.'")
	@Description("If user click on edit button of Pause tab without punching  ETA/ATA then"
			+ " notification should display as 'Please Update ETA First.'")
	public void DisplayNotificationWithoutETAAndATAinPauseTab()
			throws Exception 
	{
		sd_ViewSubTicketPage.displayNotificationWithoutETAAndATAInPauseTab();
    }
     
	
	@Feature("Pause Tab")
	@Test(priority = 29, groups = { "Pause Tab" }, description = "1.If User click on Edit button of Pause tab then Pause details  popup should get open"
			+ "2.If User click on Update Details button in Pause details popup then notification should display as 'Please Enter All Mandetory Fields'"
			+ "3.If user click on list symbol of 'Reason To Pause' field, List of Pause Reasons popup should display with pause reasons"
			+ "4.If user click on hyperlink any pause reason then same should get filled into Reason To Pause field"
			+ "5.User should not enter manual entry in Auto Resume Date field"
			+ "6.If user click on calender symbol of Auto resume date field then same date should get filled"
			+ "7.In Total pause time(minutes) column, number of minutes should display between start date/time and end date/time"
			+ "8.If Pause end date Time and Total Pause Time(minutes) are filled in pause tab then ticket should display as 'Open' status")
	@Description("To check the functionality of Edit ticket-Pause tab-after click on Edit button, "
			+ "Pause details popup should get open")
	public void CheckPauseTabInSubTicket() throws Exception 
	{
		
		sd_ViewSubTicketPage.clickOnSubTicketWithETA();
		sd_ViewSubTicketPage.pauseTheTicket();
		sd_ViewSubTicketPage.checkPauseDetails();
		sd_ViewSubTicketPage.checkLatestPauseDetails();
		sd_ViewSubTicketPage.countTotalPauseTimeInPauseTab();
    
	}

//Technician close	
	@Test(priority = 30, groups = "Technician close", description = "1. If User click on Edit button of Technician close tab without update ETA tab then notification should display as 'Please Select ETA And Technician First.")
	@Description("1.If User click on Edit button of Technician close tab without update ETA tab then notification should display as 'Please Select ETA And Technician First.")
	public void CheckTechnicianCloseWithoutETA() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithoutETA();
		sd_ViewSubTicketPage.clickOnEditButtonAndCheckNotification();
	}
	
	@Test(priority = 31, groups = "Technician close", description = "1. If User click on Update Details in Techclose tab without enter any details then notification should display as 'Please Select Tech Close Date And Time'"
			+ "2.If User click on Update Details in Techclose tab without enter Resolution then notification should display as 'Please Enter Resolution'"
			+ "3.If User click on Update Details in Techclose tab without enter Resolution description then notification should display as 'Please Enter Resolutin Description'")
	@Description("1. If User click on Update Details in Techclose tab without enter any details then notification should display as 'Please Select Tech Close Date And Time'"
			+ "2.If User click on Update Details in Techclose tab without enter Resolution then notification should display as 'Please Enter Resolution'"
			+ "3.If User click on Update Details in Techclose tab without enter Resolution description then notification should display as 'Please Enter Resolutin Description'")
	public void CheckUpdateDetailInTechnicianClose() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithETA();
		sd_ViewSubTicketPage.checkUpdateDetailInTechnicianClose();
		
	}
	
	@Test(priority = 32, groups = "Technician close", description = "1.If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details popup should not display and notification should display as 'Please Update ETA And ATA First.' ")
	@Description("1.If user click on Edit button of technician close tab  for already updated technician close tab then Technician close Details popup should not display and notification should display as 'Please Update ETA And ATA First.' ")
	public void CheckTechnicianCloseWithAleradyTechClose() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		sd_ViewSubTicketPage.clickOnEditButtonAndCheckNotification();
	}
	
//Final Close Tab
	@Test(priority = 33, groups = "Technician close", description = "1.If user click on Update details button in Final close details popup without enter any details  then notification should display as 'Please enter Final close date.'")
	@Description("1.If user click on Update details button in Final close details popup without enter any details  then notification should display as 'Please enter Final close date.'")
	public void CheckUpdateDetailsWithBlankData() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		sd_ViewSubTicketPage.checkUpdateDetailsWithBlankData();
	}
	
	
	
	@Feature("Final Close Tab")
	@Test(priority = 34, groups = { "Final Close Tab" }, description="1.if user select the close date less than technician close date then "
			+ "'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly."
			+ "2.if user select the close date greater than current date and time then "
			+ "'Final Close date time should be less than or Equal to Current date time'.pop up should be dispaly.'"
			+ "3. If user click on Update details button in Final close details popup without enter Final close time  then notification should display as 'Final close date/time should be greater than Tech close date/time.'"
			+ "4.If user click on Update details button in Final close details popup without enter Final close time  then notification should display as 'Final close date/time should be greater than Tech close date/time.'")
	@Description("1.if user select the close date less than technician close date then "
			+ "'Final close date/time should be greater than Tech close date/time.' pop up should be dispaly."
			+ "2.if user select the close date greater than current date and time then "
			+ "'Final Close date time should be less than or Equal to Current date time'.pop up should be dispaly.'"
			+ "3.If user click on Update details button in Final close details popup without enter Final close time  then notification should display as 'Final close date/time should be greater than Tech close date/time.'"
			+ "4.If user click on Update details button in Final close details popup without enter Final close time  then notification should display as 'Final close date/time should be greater than Tech close date/time.'")
	public void verifyCloseDate() throws Exception 
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		sd_ViewSubTicketPage.compareCloseDateWithTechnicianDateTime();
		sd_ViewSubTicketPage.checkNotificationWithoutSelectingTime();
    	sd_ViewSubTicketPage.compareCloseDateWithCurrentDateTime();
     }

	@Test(priority = 35, groups = "Technician close", description = "1.Enter  all the details and close the sub ticket'")
	@Description("1.If user click on Update details button in Final close details popup without enter any details  then notification should display as 'Please enter Final close date.'")
	public void CloseTicket() throws Exception
	{
		sd_ViewSubTicketPage.clickOnSubTicketWithTechclose();
		sd_ViewSubTicketPage.closeSubTicket();
	}

	/*@Test(priority = 36, groups = "Technician close", description = "1.Enter  all the details and close the sub ticket'")
	@Description("1.If user click on Update details button in Final close details popup without enter any details  then notification should display as 'Please enter Final close date.'")
	public void CheckAfterTechCloseTheParentTicketGetOpen() throws Exception
	{
		sd_ViewSubTicketPage.checkParentTicketStatusAfterCloseAllSubTicket();
		
	}
*/
	

	@AfterMethod
	public void writeResult(ITestResult result) throws Exception 
	{

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

				sd_LoginPage = new SD_LoginPage();
				sd_HomePage = sd_LoginPage.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				
				sd_HomePage = new SD_HomePage();
				sd_TicketPage = sd_HomePage.ticketTab();
				Thread.sleep(1000);
				sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
				Thread.sleep(1000);*/

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				
				
				driver.quit();
				initialization();

				sd_LoginPage = new SD_LoginPage();
				sd_HomePage = sd_LoginPage.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);
					
				sd_HomePage = new SD_HomePage();
				sd_TicketPage = sd_HomePage.ticketTab();
				Thread.sleep(1000);
				sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
				// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

			}
		} catch (Exception e) 
		{
			
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			
			sd_HomePage = new SD_HomePage();
			sd_TicketPage = sd_HomePage.ticketTab();
			Thread.sleep(1000);
			sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
		
		}

	}

	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}

}
