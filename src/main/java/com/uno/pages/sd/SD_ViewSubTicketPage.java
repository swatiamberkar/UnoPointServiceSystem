package com.uno.pages.sd;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_FileCategoryPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketLevelPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketModePage;
import com.uno.pages.superrole.Super_TicketTypePage;
import com.uno.test.sd.SD_ViewSubTicketTest;
import com.uno.test.superrole.Super_SDMasterTest;
import com.uno.test.superrole.Super_TicketMasterTest;


public class SD_ViewSubTicketPage extends BaseCode 
{

	String idValue = null;
	public static String currentDay = null;
	public static String min = null;
	public static String hour = null;
	public static String sec = null;
	public static String pauseEndDateAndTime = null;
	public static String currentDateAndTime = null;
	public static String resumeDateAndTime = null;
	public static String pauseReasonValue = null;
	public static  Date startTime = null;
	public static  Date resumeTime = null;
	SimpleDateFormat dateHrsMin = new SimpleDateFormat("yyyy-MM-dd   HH:mm");
	 
	
	// call the method from SD role
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_TicketPage sd_TicketPage;
	SD_ViewTicketPage sd_ViewTicketPage;
	SD_ViewSubTicketPage sd_ViewSubTicketPage ;
	Reporter reporter;
	
	//call method from super
	Super_LoginPage super_LoginPage;
	Super_HomePage super_HomePage;
	Super_SDMasterPage super_SDMasterPage;
	Super_TicketMasterPage super_TicketMasterPage;
	Super_TicketTypePage super_TicketTypePage;
	Super_TicketModePage super_TicketModePage;
	Super_TicketLevelPage super_TicketLevelPage;
	Super_TicketMasterTest super_TicketMasterTest;
	Super_SDMasterTest super_SDMasterTest;
	Super_FileCategoryPage  super_FileCategoryPage; 
	
	// Select SD tab for logout tab
	@FindBy(linkText = "SD")
	WebElement tabSD;
	
	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement tabTest;
	
	// select cancel Detail Button in TSD Assign Detail Window
	@FindBy(linkText = "Cancel")
	WebElement btnCancel;

	// select Update Detail Button 
	@FindBy(linkText = "Update Details")
	WebElement btnUpdateDetail;
	
	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;
	
	// Notification of View Ticket Page
	@FindBy(xpath = ".//*[@id='dialogBoxSuccess']/img")
	WebElement btnCloseNotificationBox;

	// Label Date in Incident Date Time
	@FindBy(css = ".roundBoxMdlBg.roundBoxMdlBg1>ul>li:nth-of-type(2)>span")
	WebElement lblDateInIncidentDateTime;
	

//View Sub Ticket Table (Parent Table)
	//heading of ticket form 
	 @FindBy(xpath = ".//*[@id='headingText']/span")
	 WebElement lblHeading;
		
	 @FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/span/a")
	WebElement lblIdTable; 
	 
	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
	List<WebElement> lblIDInParentTable;

	// select list of status in table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[8]")
	List<WebElement> lblStatusInParentTable;
	
	// select list of customer in table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[5]")
	List<WebElement> lblCustomerInParentTable;
	
	// select list of customer in table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[7]")
	List<WebElement> lblAssetIdInParentTable;
	
	// select list of customer in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(11)>img")
	List<WebElement> lblIncorrectAddressInParentTable;
	
	//select My View button
	@FindBy(xpath = ".//*[@id='headingText']/ul/li[2]/a")
	WebElement btnMyView;
	
	// select list of status in table
	@FindBy(css = "#view_property>ul>li")
	List<WebElement> lstMyViewProperty;
		
	//select My View button
	@FindBy(xpath = ".//*[@id='view_property']/input")
	WebElement btnSaveInMyView;
		
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>thead>tr>th")
	List<WebElement> lblNameOfColumnInTable;
	
// Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
	List<WebElement> ddlPagination;

	// Left Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(1)")
	WebElement btnLeftMostArrowOfPagination;

	// Right Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(4)")
	WebElement btnRightMostArrowOfPagination;

	// Right Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(3)")
	WebElement btnRightArrowOfPagination;

	// Left Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(2)")
	WebElement btnLeftArrowOfPagination;

	// Selected Page in Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option[selected='selected']")
	WebElement pageSelectedInPagination;

	// List of Row in Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
	List<WebElement> lstRowInTable;

// Search Ticket Tab //

	@FindBy(xpath = ".//*[@id='open']")
	WebElement tabSearchId;

	// select Search asset ID
	@FindBy(name = "m_strSearchAssetId")
	WebElement txtAssetId;

	// select GO button of asset ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
	WebElement btnGoOfAssetId;

	// select Search Ticket ID
	@FindBy(name = "m_strSearchIncId")
	WebElement txtTicketId;

	// select GO button of ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
	WebElement btnGoOfTicketId;
	
	//select Total Ticket count
	@FindBy(xpath = ".//*[@id='pagination']/strong")
	WebElement lblcount;

// Child Table
	
	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='firstcol']/table/tbody/tr/td/span")
	List<WebElement> lstIDInChildTable;

	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='table_div']/table/tbody/tr/td[4]")
	List<WebElement> lstStatusInChildTable;
	
	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='table_div']/table/tbody/tr/td[9]")
	List<WebElement> lstETADateInChildTable;
	
	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='table_div']/table/tbody/tr/td[19]")
	List<WebElement> lstATADateInChildTable;

//Nature Of Call
	
	//select nature of call tab
	@FindBy(xpath = ".//*[@id='form']/div/ul/li[2]/a/span")
	WebElement tabNatureOfCall;
	
	//select Edit button
	@FindBy(xpath = ".//*[@id='Nature-Of-Call']/div[2]/a/span")
	WebElement btnEditOfNatureOfCall;
	
	//get pop up window name
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
	WebElement lblHeadingPopUpWindow;
	
	//select list of Type Of Call
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select/option")
	List<WebElement> lstTypeOfCall;
	
	//select Type Of Call drop down
	@FindBy(name = "m_strIncidentType")
	WebElement ddlTypeOfCall;	
	
	//select list of Mode
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr/td[1]/table/tbody/tr[4]/td/select/option")
	List<WebElement> lstMode;
	
	//select Mode drop down
	@FindBy(name = "m_strIncidentMode")
	WebElement ddlMode;
	
	//select level list
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr/td[1]/table/tbody/tr[6]/td/select/option")
	List<WebElement> lstLevel;
		
	//select level drop down 
	@FindBy(name = "m_strLevel")
	WebElement ddlLevel;
	
	//select CTS drop down 
	@FindBy(name = "m_strMTS")
	WebElement ddlCTS;
	
	//select level drop down 
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div/a[1]/span")
	WebElement btnUpdateDetails;
	
//File Attachment
	
	//select File Attachment tab
	@FindBy(xpath = ".//*[@id='form']/div/ul/li[3]/a/span")
	WebElement tabFileAttachments;
	
	//select File Type list
	@FindBy(xpath = ".//*[@id='File-Attachments']/table/tbody/tr/td[3]/select/option")
	List<WebElement> lstFileType;
	
	//select File Type drop down 
	@FindBy(name = "m_strFileType")
	WebElement ddlFileType; 
	
	//browse file
	@FindBy(xpath = ".//*[@id='File-Attachments']/table/tbody/tr/td[5]/input")
	WebElement btnBrowseFile; 
	
	//Upload File Button
	@FindBy(xpath = ".//*[@id='File-Attachments']/div/a[1]/span")
	WebElement btnUploadFile;
	
	//View Attachment
	@FindBy(xpath = ".//*[@id='File-Attachments']/div/a[2]/span")
	WebElement btnViewAttachment;
	
	//list of files
	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr/td[2]")
	List<WebElement> lstAttachFiles;
	
//ETA And Technician

	// select ETA and Technician tab
	@FindBy(xpath = ".//*[@id='form']/div/ul/li[4]/a/span")
	WebElement tabETATechnician;

	// select call Assign To Technician button
	@FindBy(xpath = ".//*[@id='ETA-technician']/div[2]/a/span")
	WebElement btnEditInETATechnician;

	// select call Assign To Technician button
	@FindBy(linkText = "Resend SMS")
	WebElement btnResendSMS;

	// select Technician Text Box of call assign to technician button
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)>input")
	WebElement txtTechnician;

	// select the first list of click on first list symbol of Technician Field
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[1]/table/tbody/tr[2]/td[2]/img")
	WebElement lblTechnicianList;

	// select technician from technician window
	@FindBy(css = "div[class='rectagleBox']>table>tbody>tr>td:nth-of-type(3)>a")
	List<WebElement> lstTechnicianName;

	// select ETA Date in Technician Assign And ETA Details Detail Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>input")
	WebElement txtETADate;

	// select ETA Date Calendar Button in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
	WebElement lblETACalender;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)")
	WebElement txtETATimeHour;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)")
	WebElement txtETATimeMinute;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)>option")
	List<WebElement> ddlETATimeMinute;
	
	@FindBy(css = "table[class='datePickerTable']>tbody>tr>td")
	List<WebElement> lblDatesInETACalender;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)>option")
	List<WebElement> ddlETATimeHour;
	
	// ETA Date from ETA And Technician
	@FindBy(xpath = ".//*[@id='ETA-technician']/div[1]/table/tbody/tr/td[1]")
	WebElement lblTechnicianNameInETAAndTechnicianTab;
	
	// ETA Date from ETA And Technician
	@FindBy(xpath = ".//*[@id='ETA-technician']/div[1]/table/tbody/tr/td[3]")
	WebElement lblETADateInETAAndTechnicianTab;

	// select ETA Time from ETA and Technician Tab before data enter
	@FindBy(xpath = ".//*[@id='ETA-technician']/div[1]/table/tbody/tr/td[5]")
	WebElement lblETATimeInETAAndTechnicianTab;

// ATA Tab //

		// ATA Tab
		@FindBy(xpath = ".//*[@id='form']/div/ul/li[5]/a/span")
		WebElement tabATA;

		// Edit Button in ATA Tab
		@FindBy(xpath = ".//*[@id='ATA']/div[2]/a/span")
		WebElement btnEditInATATab;

		// ATA Date in ATA Tab
		@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
		WebElement lblATADateInATATab;

		// ATA Time in ATA Tab
		@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
		WebElement lblATATimeInATATab;

		// ATA Details Page //

		// Calendar in ATA Details Page
		@FindBy(css = "div[id='incidentTypeDetails']>div>table>tbody>tr:nth-of-type(2)>td>a")
		WebElement lblCalendarATADetailsPage;

		// Day in Calendar in ATA Details Page
		@FindBy(css = "div[id='fd-dp-8']>table>tbody>tr>td")
		List<WebElement> lblDayCalendarInATADetailsPage;

		// ATA Date in ATA Details Page
		@FindBy(css = "input[id='dp-8']")
		WebElement txtATADateInATADetailsPage;

		// Hrs of ATA Time in ATA Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(1)>option")
		List<WebElement> ddlHrsOfATATimeInATADetailsPage;

		// Min of ATA Time in ATA Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)>option")
		List<WebElement> ddlMinOfATATimeInATADetailsPage;

		// Machine Available in ATA Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select")
		WebElement ddlMachineAvailableInATADetailsPage;

		// Pause Reason Button in ATA Details Page
		@FindBy(css = "a[onclick='selectPauseReason()']")
		WebElement btnPauseReasonInATADetailsPage;

		// Calendar for Auto Resume Date in ATA Details Page
		@FindBy(css = "a[id='fd-but-dp-4']")
		WebElement lblCalendarAutoResumeDateInATADetailsPage;

		// Day in Calendar for Auto Resume Date in ATA Details Page
		@FindBy(css = "div[id='fd-dp-4']>table>tbody>tr>td")
		List<WebElement> dayInCalendar_AutoResumeDateInATADetailsPage;

		// ATA Date for Auto Resume Date in ATA Details Page
		@FindBy(css = "input[id='dp-4']")
		WebElement txtATADateOfAutoResumeDateInATADetailsPage;

		// Hrs of ATA Time for Auto Resume Date in ATA Details Page
		@FindBy(css = "select[name='m_strResumeTimeHour']>option ")
		List<WebElement> ddlHrsOfATATimeOfAutoResumeDateInATADetailsPage;

		// Min of ATA Time for Auto Resume Date in ATA Details Page
		@FindBy(css = "select[name='m_strResumeTimeMinute']>option ")
		List<WebElement> ddlMinOfATATimeOfAutoResumeDateInATADetailsPage;	
		

		// Pause Tab //

		// Pause Tab
		@FindBy(xpath = ".//*[@id='form']/div/ul/li[7]/a/span")
		WebElement tabPauseInTicketForm;

		// Edit Button in Pause Tab
		@FindBy(css = "div[id='Pause']>div:nth-of-type(2)>a")
		WebElement btnEditInPauseTab;

		// Pause Start Date Time in Pause Tab
		@FindBy(xpath = ".//*[@id='Pause']/div[1]/div/table/tbody/tr/td[1]")
		List<WebElement> lblPauseStartDateTimeInPauseTab;

		// Pause end Date Time in Pause Tab
		@FindBy(xpath = ".//*[@id='Pause']/div[1]/div/table/tbody/tr[2]/td[2]")
		WebElement lblPauseEndDateTimeInPauseTab;

		// Total Pause Time(minutes) in Pause Tab
		@FindBy(xpath = ".//*[@id='Pause']/div[1]/div/table/tbody/tr[2]/td[3]")
		WebElement lblTotalPauseMinutesInPauseTab;

		// Pause details Page //

		@FindBy(name = "m_strPausedReason")
		WebElement txtPasuedReson;
		
		// Calendar in Pause Details Page
		@FindBy(css = "#incidentTypeDetails>div[class='pad10']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
		WebElement lblCalendarPauseDetailsPage;

		// Day in Calendar in Pause Details Page
		@FindBy(css = ".datePickerTable>tbody>tr>td")
		List<WebElement> day_CalendarInPauseDetailsPage;

		
		// Auto Resume Date in Pause Details Page
		@FindBy(css = "#incidentTypeDetails>div[class='pad10']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>input")
		WebElement txtAutoResumeDateInPauseDetailsPage;

		// Hrs of Auto Resume Time in Pause Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select:nth-of-type(1)>option")
		List<WebElement> ddlHrsOfAutoResumeTimeInPauseDetailsPage;

		// Min of Auto Resume Time in Pause Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select:nth-of-type(2)>option")
		List<WebElement> ddlMinOfAutoResumeTimeInPauseDetailsPage;
		
		// List of Pause Reasons Button in Pause Page
		@FindBy(css = ".clickOn")
		WebElement btnListOfPauseReasonsInPausepage;

		// Heading of List of Pause Reasons Page
		@FindBy(css = "div[id='headingText']>span")
		WebElement headingListOfPauseReasonsPage;

		// Pause Reasons Column in List of Pause Reasons Page
		@FindBy(css = ".rectagleBox>table>tbody>tr>td:nth-of-type(2)>a")
		List<WebElement> column_PauseReasonsInListOfPauseReasonsPage;

		// Latest Pause Tab //

		// Latest Pause Tab
		@FindBy(linkText = "Latest Pause")
		WebElement tabLatestPauseInTicketForm;

		// Pause Reason Label
		@FindBy(xpath = ".//*[@id='Latest-Pause']/div/div/table/tbody/tr[2]/td[3]")
		WebElement lblPauseReasonInLatestPauseTab;

		// Resume Date And Time in Latest Pause Tab
		@FindBy(xpath = ".//*[@id='Latest-Pause']/div/div/table/tbody/tr[2]/td[2]")
		WebElement lblResumeDateAndTimeInLatestPauseTab;

     	// Pause start Date And Time in Latest Pause Tab
    	@FindBy(xpath = ".//*[@id='Latest-Pause']/div/div/table/tbody/tr[2]/td[1]")
	    WebElement lblPauseStartDateAndTimeInLatestPauseTab;
    	
    	// Technician Tab
    	@FindBy(linkText = "Technician Close")
    	WebElement tabTechnicianClose;

    	// select Spares Consumed By Inventory logistic
    	@FindBy(name = "m_strSparesConsumed")
    	WebElement ddlSparesConsumed;

    	// select Edit Button On TechncianClose Tab
    	@FindBy(xpath = ".//*[@id='Technician-close']/div[2]/a/span")
    	WebElement btnEditOfTechncianClose;

    	// submitTechCloseDetails button
    	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div/a[1]/span")
    	WebElement btnSubmitTechCloseDetails;

    	// Calendar in Technician Close Page
    	@FindBy(css = "div[id='incidentTypeDetails']>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td>a")
    	WebElement lblCalendarTechnicianClosePage;

    	// Day in Calendar in Technician Close Page
    	@FindBy(css = ".datePickerTable>tbody>tr>td")
    	List<WebElement> day_CalendarInTechnicianClosePage;

    	// Hrs of Auto Resume Time in Technician Close Page
    	@FindBy(css = "select[name='m_strTechcloseTimemHour']>option")
    	List<WebElement> ddlHrsOfTechnicianCloseTime;

    	// Min of Auto Resume Time in Technician Close Page
    	@FindBy(css = "select[name='m_strTechcloseTimemMinute']>option")
    	List<WebElement> ddlMinOfTechnicianCloseTime;

    	// Enter Resolution
    	@FindBy(name = "m_strResolution")
    	WebElement txtResolutionInTechnicianClose;

    	// Enter Resolution Description
    	@FindBy(name = "m_strResolutionDescription")
    	WebElement txtResolutionDescriptionInTechnicianClose;

    	// Enter FSR No
    	@FindBy(name = "m_strResolutionParameter7")
    	WebElement txtFSRNoInTechnicianClose;

    	// Technician close tab

    	// serial number Message
    	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr/td[1]/table/tbody/tr[21]/td/strong")
    	WebElement messageSerialNumber;

    	// select serial number
    	@FindBy(xpath = ".//*[@id='Technician-close']/div/div[2]/table/tbody/tr/td[1]/table/tbody/tr[9]/td")
    	WebElement lblSerialNumber;

    	// select serial number field
    	@FindBy(name = "m_strResolutionParameter6")
    	WebElement txtSerialNumberInTechClose;

    	// select technician close time
    	@FindBy(css = "div[id='final_close']>span:nth-of-type(1)")
    	WebElement lblTechnicianCloseTime;
    	
 // final close
    	
    	// select close button
    	@FindBy(xpath = ".//*[@id='Technician-close']/div[1]/table/tbody/tr/td[8]/a")
    	WebElement btnClose;

    	// select Final Close Details window name
    	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
    	WebElement lblFinalCloseDetailsWindow;

    	// select close date text box
    	@FindBy(name = "m_strCloseDate")
    	WebElement txtCloseDate;

    	// select close time hour
    	@FindBy(name = "m_strCloseTimeHour")
    	WebElement ddlCloseTimeHour;

    	// select close time hour
    	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[4]/td/select[1]/option")
    	List<WebElement> ddlCloseTimeHourValue;

    	// select close time hour
    	@FindBy(name = "m_strCloseTimeMinute")
    	WebElement ddlCloseTimeMinute;

    	// select close time hour
    	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[4]/td/select[2]/option")
    	List<WebElement> ddlCloseTimeMinuteValue;

    	// select close date calendar button
    	@FindBy(css = "div[id='incidentTypeDetails']>table>tbody>tr:nth-of-type(2)>td>a")
    	WebElement lblCloseDateCalender;

    	// get the serial number from final close detail
    	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[6]/td")
    	WebElement txtSerialNumber;

    	// select Update Serial No For this Asset: field
    	@FindBy(name = "m_strCloseSerialNo")
    	WebElement txtUpdateSerialNo;


	public SD_ViewSubTicketPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void checkPageNameOfViewSubTickets() throws Exception 
	{

		String titleOfSubTicketPage = lblHeading.getText();
		System.out.println("titleOfSubTicketPage:-" + titleOfSubTicketPage);

		Assert.assertEquals(titleOfSubTicketPage, "List of your Requests");

	}

// Pagination //
	// Count Of Pagination
	public void countOfPagination() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		int size = ddlPagination.size();
		System.out.println("Pagination Pages: "+size);
	
		
		int count=20*(size-1);
		ddlPagination.get(size-1).click();
		Thread.sleep(1000);
		int lastPageCount = lstRowInTable.size();
		System.out.println("last Page Count: "+lastPageCount);
		int totalCountTicket = count + lastPageCount;
		System.out.println("Total Count: "+totalCountTicket);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		System.out.println(textOfTotalCount);
		String totalCount  = textOfTotalCount.split(" ")[5];
		System.out.println("totalCount:"+totalCount);
		
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		
		softAssert.assertEquals(totalCountTicket,actualTotalCount,"Count is not match");
		softAssert.assertAll();
	}

	// Display As Per Arrows Of Pagination
	public void displayAsPerArrowsOfPagination() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		// Click on leftmost arrow
		int size = ddlPagination.size();
		System.out.println("size" + size);

		btnLeftMostArrowOfPagination.click();
		String leftMostPage = pageSelectedInPagination.getAttribute("value");
		System.out.println("leftMostPage " + leftMostPage);
		softAssert.assertEquals("1", leftMostPage, "Page not Same");

		// Click on Rightmost arrow
		// Thread.sleep(500);
		btnRightMostArrowOfPagination.click();
		String page = pageSelectedInPagination.getAttribute("value");
		System.out.println("rightMostPage " + page);
		int rightMostPage = Integer.parseInt(page);
		softAssert.assertEquals(size, rightMostPage, "Page not Same");

		// Click on RightArrow
		// Thread.sleep(500);
		btnLeftMostArrowOfPagination.click();
		String firstPageValue = pageSelectedInPagination.getAttribute("value");
		int firstPage = Integer.parseInt(firstPageValue);
		System.out.println("firstPage" + firstPage);

		btnRightArrowOfPagination.click();
		String nextPageValue = pageSelectedInPagination.getAttribute("value");
		int nextPage = Integer.parseInt(nextPageValue);
		System.out.println("nextPage" + nextPage);

		int rightArrowPage = firstPage + 1;
		softAssert.assertEquals(nextPage, rightArrowPage);

		// Click on LeftArrow
		// Thread.sleep(500);
		String lastPageValue = pageSelectedInPagination.getAttribute("value");
		int lastPage = Integer.parseInt(lastPageValue);
		System.out.println("lastPage" + lastPage);

		btnLeftArrowOfPagination.click();
		String previousPageValue = pageSelectedInPagination
				.getAttribute("value");
		int previousPage = Integer.parseInt(previousPageValue);
		System.out.println("previousPage" + previousPage);

		int leftArrowPage = lastPage - 1;
		softAssert.assertEquals(previousPage, leftArrowPage);
		softAssert.assertAll();

	}

	public void displayDescendingOrderOfIncidentID() throws Exception 
	{
	    SoftAssert softAssert = new SoftAssert();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println("sizeOfId:-" + sizeOfId);

		for (int i = 0; i < sizeOfId - 1; i++) 
		{

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			String getIDInTable = lblIDInParentTable.get(i).getText();
			System.out.println("Incident ID: " + getIDInTable);

			Matcher m = Pattern.compile("\\d+").matcher(getIDInTable);
			m.find();
			String textOfFirstID = m.group(0);
			System.out.println(textOfFirstID);
			int firstID = Integer.parseInt(textOfFirstID);
			System.out.println(firstID);

			String getSpareRequestID2 = lblIDInParentTable.get(i + 1)
					.getText();
			System.out.println(getSpareRequestID2);

			Matcher m2 = Pattern.compile("\\d+").matcher(getSpareRequestID2);
			m2.find();
			String textOfSecondID = m2.group(0);
			System.out.println(textOfSecondID);
			int secondID = Integer.parseInt(textOfSecondID);
			System.out.println(secondID);

			boolean ticketIdIsInDescending = true;
			try {
				if (firstID > secondID) {
					System.out.println("Pass");

					softAssert.assertTrue(ticketIdIsInDescending,
							"Ticket Id In Not In Descending order");
				}

			}

			catch (Exception e) {
				System.out.println("Fail");
			}
		}
		softAssert.assertAll();

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")));
		
		driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click(); 

	}

	
	// column headers should display as per selected in My View pop-up of View ticket
	public void displayColumnHeaderInSubTicket() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(500);

		scrollDown(btnMyView);
		
		highLight(btnMyView);
		
		// click on My view
		btnMyView.click();
		

		// get one by one property in My view pop up
		int sizeOfPopupColumn = lstMyViewProperty.size();
		System.out.println("Size Of Popup Column: " + sizeOfPopupColumn);

		Thread.sleep(500);

        scrollDown(btnSaveInMyView);
		
		highLight(btnSaveInMyView);
		
		// click on save button
		btnSaveInMyView.click();
		Thread.sleep(1000);

		/*if (driver.findElement(By.linkText("Back")).isEnabled()) 
		{

			driver.findElement(By.linkText("Back")).click();

		} else 
		{*/
			// get one by one name of column in table value
			int sizeOfTableColumn = lblNameOfColumnInTable.size();
			System.out.println("Total Table Column: " + sizeOfTableColumn);

			for (int i = 1; i < sizeOfPopupColumn; i++) {
				Thread.sleep(1000);

				btnMyView.click();

				if (!lstMyViewProperty.get(0).isSelected()) {
					lstMyViewProperty.get(0).click();
					Thread.sleep(500);
					lstMyViewProperty.get(0).click();
				} else {
					lstMyViewProperty.get(0).click();
				}

				String checkboxName = lstMyViewProperty.get(i).getText();
				System.out.println("Selected Checkbox:" + checkboxName);

				 scrollDown(lstMyViewProperty.get(i));
					
				 highLight(lstMyViewProperty.get(i));
				 
				lstMyViewProperty.get(i).click();

				// click on save button
				btnSaveInMyView.click();
				Thread.sleep(500);

				String tableColumnName = lblNameOfColumnInTable.get(1)
						.getText();
				System.out.println("Display Table Column Name: "
						+ tableColumnName);

				if (checkboxName.equalsIgnoreCase(tableColumnName)) {
					System.out.println("Column is Match\n");
					softAssert.assertTrue(
							checkboxName.equalsIgnoreCase(tableColumnName),
							"Column is not Match");
				} else {
					System.out.println("Column is not Match\n");
					softAssert.assertEquals(checkboxName, tableColumnName,
							"Column is not Match");

				}
				break;
			}
		
		softAssert.assertAll();
		
		/*//click on home tab symbol
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")));
		
		 driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();
*/
	}

	// Hyper link of ID should have present
	public void checkHyperlinkOfID() throws Exception 
	{

		Integer countOfRow = lblIDInParentTable.size();
		for (int i = 0; i < countOfRow; i++) 
		{

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstMyViewProperty.get(i));

			String ID = lblIDInParentTable.get(i).getText();

			System.out.println("ID: " + ID);
			boolean idIsPresent = driver.findElement(By.linkText(ID))
					.isDisplayed();
			System.out.println("Hyperlink of ID	present: " + idIsPresent);

			assertTrue(idIsPresent, "Hyperlink is not present in ID");

		}
	}

	// Hyper link of Customer should have present
	public void checkHyperlinkOfCustomer() 
	{
        SoftAssert softAsert = new SoftAssert();
		String incidentHistory = driver.getWindowHandle();
		Integer countOfRow = lblCustomerInParentTable.size();
		for (int i = 0; i < countOfRow; i++) 
		{

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstMyViewProperty.get(i));
			

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
					lstMyViewProperty.get(i));

			String customerValue = lblCustomerInParentTable.get(i).getText();

			System.out.println("Customer Name " + customerValue);
			boolean customerIsPresent = driver.findElement(
					By.linkText(customerValue)).isEnabled();

			if (customerIsPresent = true) 
			{
				lblCustomerInParentTable.get(i).click();
				for (String incidentHistoryOfCustomerWindow : driver
						.getWindowHandles()) {

					driver.switchTo().window(incidentHistoryOfCustomerWindow);

				}

				String windowName = driver
						.findElement(
								By.xpath(".//*[@id='headingText']/table/tbody/tr/td/span"))
						.getText();
				System.out
						.println("name of Incident history of customer window:-"
								+ windowName);

				String splitName = windowName.split(":-  ")[0];
				System.out.println(splitName);

				softAsert.assertEquals(splitName, "Incident History of Customer  ");

				driver.close();

				driver.switchTo().window(incidentHistory);

				break;

			} else {

				softAsert.assertTrue(customerIsPresent,
						"customer hyperlink is not enable");

			}
			
			softAsert.assertAll();
			driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();

		}
	}

	// Hyper link of Asset Id should have present
	public void checkHyperlinkOfAssetId() 
	{
		SoftAssert softAsert = new SoftAssert();
		String incidentHistory = driver.getWindowHandle();
		Integer countOfRow = lblAssetIdInParentTable.size();
		for (int i = 0; i < countOfRow; i++) 
		{

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstMyViewProperty.get(i));

			String assetIdValue = lblAssetIdInParentTable.get(i).getText();

			System.out.println("Asset Id Value" + assetIdValue);
			boolean customerIsPresent = driver.findElement(
					By.linkText(assetIdValue)).isEnabled();

			if (customerIsPresent = true) 
			{
				lblAssetIdInParentTable.get(i).click();

				for (String incidentHistoryOfAssetIdWindow : driver
						.getWindowHandles()) 
				{

					driver.switchTo().window(incidentHistoryOfAssetIdWindow);

				}

				String windowName = driver
						.findElement(
								By.xpath(".//*[@id='headingText']/table/tbody/tr/td/span"))
						.getText();
				System.out
						.println("name of Incident history of customer window:-"
								+ windowName);

				String splitName = windowName.split(":-  ")[0];
				System.out.println(splitName);

				softAsert.assertEquals(splitName, "Incident History of Customer  ");

				driver.close();

				driver.switchTo().window(incidentHistory);

				break;

			} else {

				softAsert.assertTrue(customerIsPresent,
						"customer hyperlink is not enable");

			}
			
			softAsert.assertAll();
			driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();

		}
	}

	// Blinking Notification
	public void checkBlinkingNotification() throws Exception 
	{
		SoftAssert softAsert = new SoftAssert();
     	List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRow = listOfRow.size();

		int j = 0;
		for (int i = 0; i < countOfRow; i++) {
			List<WebElement> listOfID = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span"));

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", listOfID.get(i));

			String id = listOfID.get(i).getText();
			System.out.println(id);
			Integer count = id.length();
			if (count != 4) {
				j = j + 1;
				String notification = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>i"))
						.get(j - 1).getText();
				System.out.println("Blinking Notification: " + notification);

				switch (notification) {
				case "ETA":

					List<WebElement> listOfEngineer = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(26)"));
					String engineer = listOfEngineer.get(i).getText();
					System.out.println("Engineer: " + engineer);
					softAsert.assertNotNull(engineer, "Technicion not Assign");
					System.out.println("Engineer Assign\n");

					break;

				case "ATA":
					List<WebElement> listOfETA = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
					String eta = listOfETA.get(i).getText();
					System.out.println("ETA: " + eta);
					softAsert.assertNotNull(eta, "ETA is not Present");
					System.out.println("Punch the ETA\n");

					break;

				case "Feedback":
					List<WebElement> listOfATA = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
					String ata = listOfATA.get(i).getText();
					System.out.println("ATA: " + ata);
					softAsert.assertNotNull(ata, "ATA is not Present");
					System.out.println("Punch the ATA\n");

					break;

				case "Spare Requested":

					System.out.println("Spare Requested\n");

					break;

				default:
					System.out.println("wrong");
					break;
				}

			}

			else {
				System.out.println("There is not Blinking Notification\n");
			}
		}
		
		softAsert.assertAll();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")));
		
		driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();
		
	}

	// Display Hidden Message of Flag For Address
	public void checkHiddenMessageOfAddress() throws Exception
	{

		SoftAssert softAsert = new SoftAssert();
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) 
		{

			ddlPagination.get(p).click();

			Integer countOfRow = lblIncorrectAddressInParentTable.size();
			System.out.println(countOfRow);

			for (int i = 0; i < countOfRow; i++) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lblIncorrectAddressInParentTable.get(i));

				String flag = lblIncorrectAddressInParentTable.get(i)
						.getAttribute("alt");
				System.out.println("Flag:" + flag);

				if (flag.equalsIgnoreCase("green")) {
					String flagMassage = lblIncorrectAddressInParentTable
							.get(i).getAttribute("title");
					System.out.println("Flag Massage:" + flagMassage);

					softAsert.assertEquals(flagMassage, "Correct Address",
							"Hidden massage is not Correct");

					System.out.println("Correct Address");
				} else if (flag.equalsIgnoreCase("Violated")) {

					String flagMassage = lblIncorrectAddressInParentTable
							.get(i).getAttribute("title");
					System.out.println("Flag Massage:" + flagMassage);

					softAsert.assertEquals(flagMassage, "Incorrect Address",
							"Hidden massage is not Correct");

					System.out.println("Incorrect Address");
					break loop;
				}

			}
			if (sizePagination - 1 == p) {
				softAsert.assertTrue(false, "flag is not");
				System.out.println("flag is not");
			}
		}
		
		softAsert.assertAll();
		driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();

	}

	// Display Hidden Message Of SLA Flag
	public void checkHiddenMessageOfSLAFlag() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
	    for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			List<WebElement> listOfRows = driver
					.findElements(By
							.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/span[2]/img"));
			int countOfRows = listOfRows.size();
			System.out.println(countOfRows);

			try {
				for (int i = 0; i < countOfRows; i++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							listOfRows.get(i));

					String slaFlag = listOfRows.get(i).getAttribute("src");
					System.out.println("\nslaFlag: " + slaFlag);

					switch (slaFlag) {

					case "https://demo.intelli.uno/erprmwise/images/violated.gif":
						String messageOfViolatedSLAFlag = driver
								.findElements(
										By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/span[2]/img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfViolatedSLAFlag);

						softAssert.assertEquals(messageOfViolatedSLAFlag,
								"Resolution(Violate)");

						break;

					case "https://demo.intelli.uno/erprmwise/images/cold.gif":
						String messageOfColdSLAFlag = driver
								.findElements(
										By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/span[2]/img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfColdSLAFlag);

						softAssert.assertEquals(messageOfColdSLAFlag,
								"Resolution(Cold)");

						break;

					case "https://demo.intelli.uno/erprmwise/images/warm.gif":
						String messageOfWarmSLAFlag = driver
								.findElements(
										By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/span[2]/img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfWarmSLAFlag);

						softAssert.assertEquals(messageOfWarmSLAFlag,
								"Resolution(Warm)");

						break;

					case "https://demo.intelli.uno/erprmwise/images/hot.gif":
						String messageOfHotSLAFlag = driver
								.findElements(
										By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/span[2]/img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfHotSLAFlag);

						softAssert.assertEquals(messageOfHotSLAFlag,
								"Resolution(Hot)");

						break;

					case "https://demo.intelli.uno/erprmwise/images/nv.gif":
						String messageOfNearToViolateSLAFlag = driver
								.findElements(
										By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/span[2]/img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfNearToViolateSLAFlag);

						softAssert.assertEquals(messageOfNearToViolateSLAFlag,
								"Resolution(Near To Violate)");

						break;

					default:
						System.out.println("wrong");

					}

				}

			} catch (Exception e) {

				if (sizePagination - 1 == p) {
					softAssert.assertTrue(false, "flag is not");
					System.out.println("flag is not");
				}
				e.printStackTrace();
			}
		}
	    
	    softAssert.assertAll();
	    driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();
	}

	// Display Hidden Message Of Response Flag
	public void checkHiddenMessageOfResponseFlag() throws Exception
	{
        SoftAssert softAssert = new SoftAssert();
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();
			List<WebElement> listOfRow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"));
			int countOfRows = listOfRow.size();

			try {
				for (int i = 0; i < countOfRows; i++) {

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							listOfRow.get(i));

					String responseFlag = driver
							.findElements(
									By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
							.get(i).getAttribute("src");
					System.out.println("\nslaFlag: " + responseFlag);

					switch (responseFlag) {
					case "http://demo.intelli.uno/erprmwise/images/violated.gif":
						String messageOfViolatedResponseFlag = driver
								.findElements(
										By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfViolatedResponseFlag);

						softAssert.assertEquals(messageOfViolatedResponseFlag,
								"Response(Violate)");

						break;

					case "http://demo.intelli.uno/erprmwise/images/cold.gif":
						String messageOfColdResponseFlag = driver
								.findElements(
										By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfColdResponseFlag);

						softAssert.assertEquals(messageOfColdResponseFlag,
								"Response(Cold)");

						break;

					case "http://demo.intelli.uno/erprmwise/images/warm.gif":
						String messageOfWarmResponseFlag = driver
								.findElements(
										By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfWarmResponseFlag);

						softAssert.assertEquals(messageOfWarmResponseFlag,
								"Response(Warm)");

						break;

					case "http://demo.intelli.uno/erprmwise/images/hot.gif":
						String messageOfHotResponseFlag = driver
								.findElements(
										By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfHotResponseFlag);

						softAssert.assertEquals(messageOfHotResponseFlag,
								"Response(Hot)");

						break;

					case "http://demo.intelli.uno/erprmwise/images/nv.gif":
						String messageOfNearToViolateResponseFlag = driver
								.findElements(
										By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
								.get(i).getAttribute("title");
						System.out.println("Hidden message: "
								+ messageOfNearToViolateResponseFlag);

						softAssert.assertEquals(messageOfNearToViolateResponseFlag,
								"Response(Near To Violate)");

						break;

					default:
						System.out.println("Wrong");

					}

				}

			} catch (Exception e) {
				if (sizePagination - 1 == p) {
					softAssert.assertTrue(false, " Ticket is not Available");
					System.out.println("Ticket is not Available");
				}
				e.printStackTrace();
			}
		}
		
		softAssert.assertAll();
		driver.findElement(By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a")).click();

	}
	
	//verify Ticket ID with multiple data 
	public SD_ViewSubTicketTest  verifyTicketIdTextBox(String ticketID) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		
		//click on search ticket tab
		tabSearchId.click();
		
		txtTicketId.clear();
		
		//send the alphabetical value in Ticket ID text box
		txtTicketId.sendKeys(ticketID);
		
		//click on go button
		btnGoOfTicketId.click();
		
		 try {
			    Alert alertWithAlphabeticValue = driver.switchTo().alert();
				String alertMessage = alertWithAlphabeticValue.getText();
				System.out.println("Alert Text:" + alertMessage);
				alertWithAlphabeticValue.accept();
				driver.switchTo().defaultContent();

				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Ticket ID");
				System.out.println("Both the message is equal");
			 
			 
			try {
				Alert alertWithBlank = driver.switchTo().alert();
				String alertMessageWithBlankData = alertWithBlank.getText();
				System.out.println("Alert Text:" + alertMessageWithBlankData);
				alertWithBlank.accept();
				driver.switchTo().defaultContent();

				softAssert.assertEquals(alertMessageWithBlankData,
						"Please Enter Ticket ID");
				System.out.println("Both the message is equal");
				
			} catch (Exception e) {
		
				 int rowSize=lstRowInTable.size();
			      if(rowSize==1)
			      {
			       String textOfTotalCount= lblcount.getText();
			        System.out.println("textOfTotalCount : "+textOfTotalCount);
			        softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: 1","Count is not match");
			      }
			     	      
				
			}
		} catch (Exception e) 
		 {
			
			String textOfTotalCount= lblcount.getText();
	        System.out.println("textOfTotalCount : "+textOfTotalCount);
	        softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: 0","Count is not match");
			
		}
		 softAssert.assertAll();
		return new SD_ViewSubTicketTest();
		
		
		
	}

	// If User click on View Sub ticket tab then list of your requests page
	// should display with all Parent tickets in Pause status
	public void matchStatusOfParentTicket() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		for (int i = 0; i < sizeOfId; i++) 
		{
			scrollDown(lblStatusInParentTable.get(i));
			highLight(lblStatusInParentTable.get(i));
			String statusValueOfId = lblStatusInParentTable.get(i).getText();
			System.out.println("status Value Of Id:-" + statusValueOfId);

			softAssert.assertEquals(statusValueOfId, "Paused");

		}
		softAssert.assertAll();

	}

	// After click hyper link of ID then 'List of your requests' page should
	// display with all sub ticket entries of same parent ticket
	public void matchSubTicketIdWithParentTicketId()
	{
		SoftAssert softAssert = new SoftAssert();
		String parentWindow = driver.getWindowHandle();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		for (int i = 0; i < sizeOfId; i++) {

			String statusValueOfId = lblIDInParentTable.get(i).getText();
			System.out.println("status Value Of Id:-" + statusValueOfId);

			String concadValue = statusValueOfId.concat("-");
			System.out.println("concadValue:-" + concadValue);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			lblIDInParentTable.get(i).click();

			for (String subTicketWindow : driver.getWindowHandles()) {
				driver.switchTo().window(subTicketWindow);

			}

			int sizeOfIdInSubTicket = lstIDInChildTable.size();
			System.out.println("sizeOfIdInSubTicket:-" + sizeOfIdInSubTicket);

			for (int j = 0; j < sizeOfIdInSubTicket - 1; j++) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstIDInChildTable.get(j));

				String IdInSubTicketValue = lstIDInChildTable.get(j)
						.getText();
				System.out.println("IdInSubTicketValue:-" + IdInSubTicketValue);

				// Match all sub ticket entries of same parent ticket or not
				boolean isSubTicketIdContainParentTicketId = true;
				if (IdInSubTicketValue.contains(statusValueOfId)) {

					System.out.println("SubTicket Id Contain Parent Ticket Id");
					isSubTicketIdContainParentTicketId = true;

				} else {

					System.out
							.println("SubTicket not Id Contain Parent Ticket Id");
					isSubTicketIdContainParentTicketId = false;
				}

				softAssert.assertTrue(isSubTicketIdContainParentTicketId);

				String splitID = IdInSubTicketValue.split(concadValue)[1];
				System.out.println("split ID:-" + splitID);

				int firstID = Integer.parseInt(splitID);

				String textOfSecondID = lstIDInChildTable.get(j + 1)
						.getText();
				String splitSecondID = textOfSecondID.split(concadValue)[1];
				System.out.println("splitSecondID:-" + splitSecondID);

				int secondID = Integer.parseInt(splitSecondID);

				boolean iDIsDescending = true;

				if (firstID > secondID) {
					System.out.println("Pass");

				}

				softAssert.assertTrue(iDIsDescending,
						"All IDs is in descending order");

			}
			driver.navigate().back();
			driver.switchTo().window(parentWindow);
			driver.findElement(
					By.xpath(".//*[@id='main']/div[3]/div[2]/div/ul/li[1]/a"))
					.click();
			break; // if to check for all parent id then just remove the break.

		}
		softAssert.assertAll();
	}

	// click on sub ticket
	public void clickOnSubTicket() throws Exception 
	{

		String firstParentTicketWindow = driver.getWindowHandle();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		loop: for (int i = 0; i < sizeOfId; i++) 
		{

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			String idValue = lblIDInParentTable.get(i).getText();
			System.out.println("idValue:-"+idValue);
			
			lblIDInParentTable.get(i).click();
			Thread.sleep(1000);
			
			int sizeOfIdInSubTicket = lstIDInChildTable.size();
			System.out.println(sizeOfIdInSubTicket);

			for (int k = 0; k < sizeOfIdInSubTicket; k++)
			{

				String statusInSubTicketValue = lstStatusInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-" + statusInSubTicketValue);
				
				

				if (statusInSubTicketValue.contains("Open")) 
				{

					((JavascriptExecutor) driver).executeScript(
	
							"arguments[0].scrollIntoView(true);",
							lstIDInChildTable.get(k));

					lstIDInChildTable.get(k).click();
					break ;

				}
				
				if(sizeOfIdInSubTicket-1 == k)
				{
					driver.navigate().back();
					driver.switchTo().window(firstParentTicketWindow);
					continue loop;
					
				}
				
			}
			
			break;
		}

	}
	//If User click on Sub ticket ID hyper link then 'Sub Ticket Form' should display to edit sub ticket
	public void checkTheSubTicketFormWindow() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		String nameOfSubTicketForm =  lblHeading.getText();
		System.out.println("name Of Sub Ticket Form:-"+nameOfSubTicketForm);
		
		softAssert.assertEquals(nameOfSubTicketForm, "Sub Ticket Form", "Ticket Form Name Is Different");
		
		Thread.sleep(200);
		driver.navigate().back();
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		softAssert.assertAll();
	}

//Nature of call tab
	
	//1.If User click on Edit button then 'Nature of Call' pop up should display . 
	//2. If User update details in Nature of Call pop up and click on Cancel button then updated details should not save in Nature of Call tab. 
	public void checkNatureOfCallPopUpAndCancelButtonFunctinality() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		//click on nature of call
		tabNatureOfCall.click();
		
		String typeOfCall = driver
				.findElement(
						By.xpath(".//*[@id='Nature-Of-Call']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[1]"))
				.getText();
		
		System.out.println("typeOfCall:-"+typeOfCall);
		String typeOfValueBeforeCancel = typeOfCall.split("Type Of Call :")[1];
		System.out.println("typeOfValueBeforeCancel:-"+typeOfValueBeforeCancel);
		//click on edit button
		btnEditOfNatureOfCall.click();
		
	    //get the window name 
		String WindowName = lblHeadingPopUpWindow.getText();
		System.out.println("Window Name:-"+WindowName);
		softAssert.assertEquals(WindowName, "Nature Of Call", "The name is different");
	
		//select type of call
		Select typeOfCallValue;
		typeOfCallValue = new Select (ddlTypeOfCall);
		typeOfCallValue.selectByIndex(3);
		
		//get the selected value 
		String selectTypeOfCall = ddlTypeOfCall.getAttribute("value");
		System.out.println("selectTypeOfCall:-"+selectTypeOfCall);
		
		// click on cancel button
		btnCancel.click();
       
		//get the value after cancel 
		String typeOfCallAfterSelect = driver
				.findElement(
						By.xpath(".//*[@id='Nature-Of-Call']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[1]"))
				.getText();
		
		System.out.println("typeOfCall:-"+typeOfCallAfterSelect);
		String typeOfValueAfterCancel = typeOfCallAfterSelect.split("Type Of Call :")[1];
		System.out.println("typeOfValueAfterCancel:-"+typeOfValueAfterCancel);

		// Match After click on cancel the value should not change
		softAssert.assertEquals(typeOfValueBeforeCancel, typeOfValueAfterCancel);
		softAssert.assertAll();
		
	}

	// Match type of call list with super login-> SD master-> Ticket Master->
	// Ticket Type
	public void matchTheTypeOfCallWithSuperLogin() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on nature of call
		tabNatureOfCall.click();

		// click on edit button
		btnEditOfNatureOfCall.click();

		int sizeOfTicketTypeOfCallInSdRole = lstTypeOfCall.size() - 1;
		System.out.println("size Of Type Of Call In Sd Role:-"
				+ sizeOfTicketTypeOfCallInSdRole);

		ddlTypeOfCall.click();

		String typeOfCallInSdRole = ddlTypeOfCall.getText();
		System.out.println("\nTicket Name InSdRole:" + typeOfCallInSdRole);

		btnCancel.click();

		// click on sd to logout
		tabSD.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		// Access Inventory Masters Page TestCase Of Super Role
		super_TicketMasterTest = new Super_TicketMasterTest();
		super_TicketMasterTest.Setup();
		super_TicketMasterTest.clickOnTicketTypeLink();
		super_TicketTypePage = new Super_TicketTypePage();
		// Thread.sleep(2000);

		// Get Size Of Part Name In Super Role
		int sizeOfTicketTypeInSuperRole = super_TicketTypePage.list_TicketTypeInSuper
				.size();
		System.out.println("\nsize"
				+ "OfTicketTypeInSuperRole:-"
				+ sizeOfTicketTypeInSuperRole);

		for (int i = 0; i < sizeOfTicketTypeInSuperRole; i++) {

			String ticketTypeInSuperRole = super_TicketTypePage.list_TicketTypeInSuper
					.get(i).getText();
			System.out.println("\nticketTypeInSuperRole:"
					+ ticketTypeInSuperRole);

			// Check Part name in Both Role
			softAssert.assertTrue(
					typeOfCallInSdRole.contains(ticketTypeInSuperRole),
					"Part name is Not same");

		}

		// click on account
		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		sd_LoginPage = new SD_LoginPage();
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		softAssert.assertEquals(sizeOfTicketTypeOfCallInSdRole,
				sizeOfTicketTypeInSuperRole, "Ticket Type Size Is Not Same");
		softAssert.assertAll();

	}

	// Match Mode Drop down list with super login-> SD master-> Ticket Master->
	// Ticket of mode
	public void matchTheModeWithSuperLogin() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on nature of call
		tabNatureOfCall.click();

		// click on edit button
		btnEditOfNatureOfCall.click();

		scrollDown(ddlMode);
		
		highLight(ddlMode);
		
		Thread.sleep(1000);
		ddlMode.click();

		int sizeOfModeInSdRole = lstMode.size() - 1;
		System.out.println("size Of Mode In Sd Role:-" + sizeOfModeInSdRole);

		String modeInSdRole = ddlMode.getText();
		System.out.println("\nTicket Name InSdRole:" + modeInSdRole);

		btnCancel.click();

		// click on SD to logout
		tabSD.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		// Access Inventory Masters Page TestCase Of Super Role
		super_TicketMasterTest = new Super_TicketMasterTest();
		super_TicketMasterTest.Setup();
		super_TicketMasterTest.clickOnTicketModeLink();
		super_TicketModePage = new Super_TicketModePage();

		// Get Size Of Part Name In Super Role
		int sizeOfModeInSuperRole = super_TicketModePage.list_TicketModeInSuper
				.size();
		System.out.println("\nsizeOfTicketTypeInSuperRole:-"
				+ sizeOfModeInSuperRole);

		for (int i = 0; i < sizeOfModeInSuperRole; i++) {

			scrollDown(super_TicketModePage.list_TicketModeInSuper.get(i));
			
			highLight(super_TicketModePage.list_TicketModeInSuper.get(i));
			
			String ticketModeInSuperRole = super_TicketModePage.list_TicketModeInSuper
					.get(i).getText();
			System.out.println("\nticketModeInSuperRole:"
					+ ticketModeInSuperRole);

			// Check Part name in Both Role
			softAssert.assertTrue(modeInSdRole.contains(ticketModeInSuperRole),
					"Part name is Not same");

		}

		// click on account
		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		sd_LoginPage = new SD_LoginPage();
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		softAssert.assertEquals(sizeOfModeInSdRole, sizeOfModeInSuperRole,
				"Ticket Mode Size is Not same");
		
		softAssert.assertAll();

	}
	// Match Mode Drop down list with super login-> SD master-> Ticket Master->
	// Ticket of Level
	public void matchTheLevelWithSuperLogin() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on nature of call
		tabNatureOfCall.click();

		// click on edit button
		btnEditOfNatureOfCall.click();

        scrollDown(ddlLevel);
		
		highLight(ddlLevel);
		
		Thread.sleep(1000);
		ddlLevel.click();

		int sizeOfLevelInSdRole = lstLevel.size() - 1;
		System.out.println("size Of Mode In Sd Role:-" + sizeOfLevelInSdRole);

		String sizeInSdRole = ddlLevel.getText();
		System.out.println("\npartNameInSdRole:" + sizeInSdRole);

		btnCancel.click();
		

		// click on SD to logout
		tabSD.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		// Access Inventory Masters Page TestCase Of Super Role
		super_TicketMasterTest = new Super_TicketMasterTest();
		super_TicketMasterTest.Setup();
		super_TicketMasterTest.clickOnTicketLevelLink();
		super_TicketLevelPage = new Super_TicketLevelPage();

		// Get Size Of Part Name In Super Role
		int sizeOfTicketLevelInSuperRole = super_TicketLevelPage.list_TicketLevelInSuper
				.size();
		System.out.println("\nsizeOfTicketTypeInSuperRole:-"
				+ sizeOfTicketLevelInSuperRole);

		for (int i = 0; i < sizeOfTicketLevelInSuperRole; i++) {
			
			scrollDown(super_TicketLevelPage.list_TicketLevelInSuper.get(i));
			
			highLight(super_TicketLevelPage.list_TicketLevelInSuper.get(i));

			String ticketLevelInSuperRole = super_TicketLevelPage.list_TicketLevelInSuper
					.get(i).getText();
			System.out.println("\nticketModeInSuperRole:"
					+ ticketLevelInSuperRole);

			// Check Part name in Both Role
			softAssert.assertTrue(sizeInSdRole.contains(ticketLevelInSuperRole),
					"Part name is Not same");

		}

		// click on account
		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		sd_LoginPage = new SD_LoginPage();
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		softAssert.assertEquals(sizeOfLevelInSdRole, sizeOfTicketLevelInSuperRole,
				"Ticket Mode Size is Not same");
		
		softAssert.assertAll();

	}
	//If User update details in Nature of Call pop up and click on Update Details button then updated details
	//should save in Nature of Call tab
	public void updateTheDetailInNatureOfCall() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on nature of call
		tabNatureOfCall.click();

		// click on edit button
		btnEditOfNatureOfCall.click();

		// select type of call
		Select typeOfCallValue;
		typeOfCallValue = new Select(ddlTypeOfCall);
		typeOfCallValue.selectByIndex(4);

		// get the selected value
		String selectTypeOfCall = ddlTypeOfCall.getAttribute("value");
		System.out.println("selectTypeOfCall:-" + selectTypeOfCall);

		// select Mode
		Select modeValue;
		modeValue = new Select(ddlMode);
		modeValue.selectByIndex(4);

		// get the selected value
		String selectMode = ddlMode.getAttribute("value");
		System.out.println("select Mode:-" + selectMode);
		
		// select level
		Select levelValue;
		levelValue = new Select(ddlLevel);
		levelValue.selectByIndex(4);

		// get the selected value
		String selectLevel = ddlLevel.getAttribute("value");
		System.out.println("select Level:-" + selectLevel);
		
		// select CTS
		Select ctsValue;
		ctsValue = new Select(ddlCTS);
		ctsValue.selectByIndex(1);

		// get the selected value
		String selectCTS = ddlCTS.getAttribute("value");
		System.out.println("select CTS:-" + selectCTS);
				
		//click on update detail button
		btnUpdateDetails.click();

		//click on nature of call tab
		tabNatureOfCall.click();
		
		//get the value after cancel 
		String typeOfCallAfterSelect = driver
				.findElement(
						By.xpath(".//*[@id='Nature-Of-Call']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[1]"))
				.getText();
		
		System.out.println("typeOfCall:-"+typeOfCallAfterSelect);
		String typeOfValueAfterUpdate = typeOfCallAfterSelect.split("Type Of Call :")[1];
		System.out.println("typeOfValueAfterCancel:-"+typeOfValueAfterUpdate);
		
		
		String ctsAfterSelect = driver
				.findElement(
						By.xpath(".//*[@id='Nature-Of-Call']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td"))
				.getText();
		System.out.println("ctsAfterSelect:-"+ctsAfterSelect);
		String ctsValueAfterUpdate = ctsAfterSelect.split("CTS")[1];
		System.out.println("typeOfValueAfterCancel:-"+ctsValueAfterUpdate);
		

		
		// Match After click on update details the type of call value should get change
		softAssert.assertEquals(" "+selectTypeOfCall, typeOfValueAfterUpdate);
		
		//Match the CTS , it should be same as selected CTS
		softAssert.assertEquals(" "+selectCTS, ctsValueAfterUpdate);
		
		softAssert.assertAll();
		
	}
//File Attachments
	
	//In File attachments-> file type lists should display all options as mention in  file category master in Super login
	
	public void matchFileCategory() throws Exception
	{
	
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on File Attachments
		tabFileAttachments.click();

		Thread.sleep(1000);
		ddlFileType.click();

		int sizeOfFileTypeInSdRole = lstFileType.size() - 1;
		System.out.println("size Of file type In Sd Role:-" + sizeOfFileTypeInSdRole);

		String sizeInSdRole = ddlFileType.getText();
		System.out.println("FileTypeInSdRole:" + sizeInSdRole);		

		// click on SD to logout
		tabSD.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		// Access Inventory Masters Page TestCase Of Super Role
		super_SDMasterTest = new Super_SDMasterTest();
		super_SDMasterTest.Setup();
		super_SDMasterTest.clickOnFileCategoryLink();
		super_FileCategoryPage = new Super_FileCategoryPage();

		// Get Size Of Part Name In Super Role
		int sizeOfFileTypeInSuperRole = super_FileCategoryPage.list_FileCategory
				.size();
		System.out.println("sizeOfFileTypeInSuperRole:-"
				+ sizeOfFileTypeInSuperRole);

		for (int i = 0; i < sizeOfFileTypeInSuperRole; i++) {
			
			

			String fileTypeInSuperRole = super_FileCategoryPage.list_FileCategory
					.get(i).getText();
			System.out.println("fileTypeInSuperRole:"
					+ fileTypeInSuperRole);

			// Check Part name in Both Role
			softAssert.assertTrue(sizeInSdRole.contains(fileTypeInSuperRole),
					"Part name is Not same");

		}

		// click on account
		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);

		sd_LoginPage = new SD_LoginPage();
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		softAssert.assertEquals(sizeOfFileTypeInSdRole, sizeOfFileTypeInSuperRole,
				"Ticket Mode Size is Not same");
		
		softAssert.assertAll();
	
	}
	//1. If user click on choose file button then 'please select file type' pop up should get open.
	//2. After selecting file type and click on upload file then 'please select file' pop up should get open
	public void matchpopUpOfFileTypeAndFile() throws Exception 
	{
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on File Attachments
		tabFileAttachments.click();

		// click on upload file button
		btnUploadFile.click();

		// get Alert of File type
		Alert alertOfFileType = driver.switchTo().alert();
		String alertMessage = alertOfFileType.getText();
		System.out.println("Alert Text:" + alertMessage);
		alertOfFileType.accept();

		// Match the message
		softAssert.assertEquals(alertMessage, "Please Select File Type.");

		// select File Type
		Select fileType;
		fileType = new Select(ddlFileType);
		fileType.selectByIndex(1);

		// click on upload file
		btnUploadFile.click();

		// get Alert message of File
		Alert alertOfFile = driver.switchTo().alert();
		String alertMessageValue = alertOfFile.getText();
		System.out.println("Alert Text:" + alertMessageValue);
		alertOfFile.accept();

		// Match the message
		softAssert.assertEquals(alertMessageValue, "Please Select File.");
		softAssert.assertAll();

	}
	
	
	//1. If  user choose file from system then name of same file should display in front of choose file button
	//2. If user click on Upload file button with attach any attachment then notification should display as 'File Uploaded Successfully...!'2
	//3. If User click on Hyper link of attachment file then file should get download
	public void matchUploadedFile() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on File Attachments
		tabFileAttachments.click();

		// select File Type
		Select fileType;
		fileType = new Select(ddlFileType);
		fileType.selectByIndex(1);

		Thread.sleep(1000);
		String fileName = "Use In Automation testing.xlsx";
		System.out.println(fileName);

		// Enter File Path
		btnBrowseFile.sendKeys("D:\\Use In Automation testing.xlsx");
		// Get uploaded file name
		String browseFileName = btnBrowseFile.getAttribute("value");
		System.out.println(browseFileName);

		// If user choose file from system then name of same file should display
		// in front of choose file button
		// Match that same file name is display or not
		softAssert.assertEquals(browseFileName, fileName);

		// click on submit button
		btnUploadFile.click();

		Thread.sleep(1000);
		// click on view attachment
		btnViewAttachment.click();

		for (String listOfAttachmentsWindow : driver.getWindowHandles()) {

			System.out.println(listOfAttachmentsWindow);
			driver.switchTo().window(listOfAttachmentsWindow);

		}

		// get the value from the file
		int getSize = lstAttachFiles.size();
		System.out.println("getSize:-" + getSize);

		String getAttachmentValue = lstAttachFiles.get(getSize - 1).getText();
		System.out.println(getAttachmentValue);

		driver.findElement(By.linkText(getAttachmentValue)).click();

		Thread.sleep(1000);

		Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		Thread.sleep(1000);

		for (String basicWindow : driver.getWindowHandles()) 
		{

			System.out.println(basicWindow);
			driver.switchTo().window(basicWindow);

		}

		softAssert.assertEquals(getAttachmentValue, browseFileName);
		softAssert.assertAll();
	}

//ETA And Technician
	
	//1.If user click on Edit button in ETA and technician tab, then 'Technician Assign And ETA Details' pop up should display
	//2.If user keep Technician field  as blank and click on Update Details page then notification should display 'Please select engineer.'
	//3.In 'Technicians Assign And ETA Details'  pop up If User click on list symbol of Technician Field then 'List of your Technicians' pop up should display
	public void punchETAandTchnician() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);

		// click on ETA and Technician tab
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnEditInETATechnician.click();

		String TechnicianAssignAndETADetailsWindow = driver.getWindowHandle();

		// click the first list of click on first list symbol of
		// Technician Field
		lblTechnicianList.click();

		String split = null;
		for (String listOfYourTechniciansWindow : driver.getWindowHandles()) 
		{

			System.out.println(listOfYourTechniciansWindow);
			driver.switchTo().window(listOfYourTechniciansWindow);

		}
		String textSelectTechnician = driver.getTitle();
		System.out.println("textSelectTechnician:-" + textSelectTechnician);

		// verify that ,pop up window is Select Technicians
		// window or not
		softAssert.assertEquals(textSelectTechnician, "Select Technicians");
		System.out.println("Both the message is equal");

		
		Thread.sleep(1000);
		Select state;
		state = new Select(driver.findElement(By.name("m_strPoplocation")));
		state.selectByValue("Mumbai");
		System.out.println("Mumbai");

		// click on go button of state
		driver.findElement(
				By.xpath(".//*[@id='right']/table/tbody/tr[2]/td[3]/input"))
				.click();
		Thread.sleep(500);

		int sizeOfTechnitian = lstTechnicianName.size();

		for (int j = 0; j < sizeOfTechnitian; j++) 
		{

			String technicianVlaue = lstTechnicianName.get(j).getText();
			System.out.println(technicianVlaue);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstTechnicianName.get(j));

			if (technicianVlaue.contains("Pranjali Deshpande (Mumbai)"))

			{

				Thread.sleep(3000);
				lstTechnicianName.get(j).click();

				Thread.sleep(3000);
				split = technicianVlaue.split(" ")[0];
				System.out.println(split);
				break;

			}

		}

		driver.switchTo().window(TechnicianAssignAndETADetailsWindow);

		// send the value to check ETA Date is editable or not
		// on TSD Text Box
		txtETADate.sendKeys("2018-05-25");
		String tsdFieldValue = txtETADate.getAttribute("value");

		boolean isETADateFieldEditable;

		if (tsdFieldValue.contentEquals("2018-05-25")) 
		{

			System.out.println("Field is editable");
			isETADateFieldEditable = true;

		}

		else

		{

			System.out.println("Field is non editable:-" + tsdFieldValue);
			isETADateFieldEditable = false;

		}

		// check field should not editable
		softAssert.assertFalse(isETADateFieldEditable, "ETA Field is editable");

		
		
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		lblETACalender.click();

		// select Date in Calendar

		for (WebElement day : lblDatesInETACalender) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		
		Select timeInHour;
		timeInHour = new Select(txtETATimeHour);
		timeInHour.selectByValue("00");
		
		Select timeInMinute;
		timeInMinute = new Select(txtETATimeMinute);
		timeInMinute.selectByValue("00");
		
		
		//In ETA time field, if user keep 00 hr and 00min and click on Update details button then notification should display as 'Please enter ETA Time.'"
		btnUpdateDetail.click();
		
	    Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();

		softAssert.assertEquals(alertMessage,
				"Please Enter ETA Time.");

		//Enter the Time
		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String currentHrs = new SimpleDateFormat("HH").format(calendar
				.getTime());
		System.out.println(currentHrs);

		String currentMin = new SimpleDateFormat("mm").format(calendar
				.getTime());
		System.out.println(currentMin);

		// select Hrs in Drop down

		String getTimeHourValue = null;
		for (WebElement hrsofSystem : ddlETATimeHour) 
		{

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(currentHrs)) 
			{
				
				Thread.sleep(1000);
				hrsofSystem.click();
				getTimeHourValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getTimeHourValue);

				break;
			}

		}

		// select Min in Drop down

		String getTimeMinuteValue = null;
		for (WebElement minOfSystem : ddlETATimeMinute) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(currentMin)) {

				Thread.sleep(1500);
				minOfSystem.click();
				getTimeMinuteValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getTimeMinuteValue);
				break;
			}

		}

		// after selecting the ETA Date ,that Date is appear in
		// ETA text box
		String selectedDate = txtETADate.getAttribute("value");
		System.out.println("selected Date is:-" + selectedDate);

		// get value from ETA Time
		String selectedTimeHour = txtETATimeHour.getAttribute("value");
		System.out.println("selected Time Hour is:-" + selectedTimeHour);

		String selectedTimeMinute = txtETATimeMinute.getAttribute("value");
		System.out.println("selected Time Minute is:-" + selectedTimeMinute);

		String totalTime = selectedTimeHour.concat(":" + selectedTimeMinute);
		System.out.println(totalTime);

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		btnUpdateDetail.click();
		Thread.sleep(2000);

		// click on ETA and Technician tab
		tabETATechnician.click();

		String selectedName = lblTechnicianNameInETAAndTechnicianTab.getText();
		String splitTechnicianName = selectedName.split("Technician :")[1];
		System.out.println("selected technician name is:-"
				+ splitTechnicianName);

		String dateValue = lblETADateInETAAndTechnicianTab
				.getText();
		System.out.println("dateValue:-" + dateValue);
		String splitETADatevalue = dateValue.split("ETA Date :")[1];
		System.out.println("selected ETA Date is:-" + splitETADatevalue);

		String selectedTime = lblETATimeInETAAndTechnicianTab
				.getText();
		System.out.println("selectedTime:-" + selectedTime);
		String splitETATimeValue = selectedTime.split("ETA Time :")[1];
		System.out.println("selected ETA Time is:-" + splitETATimeValue);

		// Match that both value is same or not
		softAssert.assertEquals(" " + split, splitTechnicianName,
				"The Technician name is different");
		System.out.println("The Technician name is same");

		// Match that both value is same or not
		softAssert.assertEquals(" " + selectedDate, splitETADatevalue,
				"The Date is different");
		System.out.println("The Date is same");

		// Match both date and time value value
		softAssert.assertEquals(" " + totalTime, splitETATimeValue,
				"The Time is different");
		System.out.println("The Time is same");
		
		softAssert.assertAll();

	}

	// click on sub ticket
	public void clickOnSubTicketWithoutETA() throws Exception 
	{

		String firstParentTicketWindow = driver.getWindowHandle();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		loop: for (int i = 0; i < sizeOfId; i++) {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			String idValue = lblIDInParentTable.get(i).getText();
			System.out.println("idValue:-"+idValue);
			
			lblIDInParentTable.get(i).click();
			Thread.sleep(1000);
			
			int sizeOfIdInSubTicket = lstIDInChildTable.size();
			System.out.println(sizeOfIdInSubTicket);

			for (int k = 0; k < sizeOfIdInSubTicket; k++)
			{

				String statusInSubTicketValue = lstStatusInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-" + statusInSubTicketValue);
				
				String etaDateInSubTicketValue = lstETADateInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-" + etaDateInSubTicketValue);

				if (statusInSubTicketValue.equalsIgnoreCase("open")&&etaDateInSubTicketValue.equalsIgnoreCase("")) 
				{
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInChildTable.get(k));

					lstIDInChildTable.get(k).click();
					break ;

				}
				
				if(sizeOfIdInSubTicket-1 == k)
				{
					driver.navigate().back();
					driver.switchTo().window(firstParentTicketWindow);
					continue loop;
					
				}
				
			}
			
			break;
		}

	}

	// If User click on Edit button of ATA tab without update ETA tab then
	// notification should display as 'Please Select ETA And Technician First.'
	public void displayNotificationWithoutETAInATATab() throws Exception {
		
		// Click on ATA Tab
		tabATA.click();
		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();
		// Get Notification
		// Thread.sleep(5000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		Assert.assertEquals(notificationText,
				"Please Select ETA And Technician First.");

	}

	//If user select ATA date and Time less than Incident Date and Time then notification should display as ' ATA Date Time should be greater than Incident Date Time '
	public void checkATADateAndTimeWithIncidentDateAndTime() throws Exception
	{
		// Get Date & Time
		// Thread.sleep(3000);
		String dateTimeText = lblDateInIncidentDateTime
				.getText();
		String dateValue = dateTimeText.split(" ")[2];

		// Get date
		String date = dateValue.split("Time")[0];
		System.out.println("\n" + date);
		// Get Time
		String time = dateTimeText.split(" ")[4];
		System.out.println("\n" + time);

		// Format Date
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		Date dateInIncidentDateTime = (Date) dateFormat.parse(date);
		System.out.println("\n" + dateInIncidentDateTime);
		String dateFormatOfDate = dateFormat
				.format(dateInIncidentDateTime);

		// Format Time
		String timePattern = "HH:mm";
		DateFormat timeFormat = new SimpleDateFormat(timePattern);
		Date timeInIncidentDateTime = (Date) timeFormat.parse(time);
		System.out.println(timeInIncidentDateTime);
		String timeFormatOfTime = timeFormat
				.format(timeInIncidentDateTime);

		// Click on ATA Tab
		tabATA.click();
		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		// This is Optional
		// Used If you want select Previous date
		int preDay = Integer.parseInt(currentDay) - 1;
		String previousDay = Integer.toString(preDay);
		lblCalendarATADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : lblDayCalendarInATADetailsPage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-"
						+ getDateValue);

				break;
			}

		}

		// Get Date in ATA Date Text box
		String currentDate = txtATADateInATADetailsPage
				.getAttribute("value");
		System.out.println(currentDate);
		Date ATADate = (Date) dateFormat.parse(currentDate);
		System.out.println(ATADate);

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH").format(calendar
				.getTime());
		System.out.println(hrs);
		String min = new SimpleDateFormat("mm").format(calendar
				.getTime());
		System.out.println(min);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlHrsOfATATimeInATADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-"
						+ getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfATATimeInATADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-"
						+ getDateValue);

				break;
			}

		}

		// concatenation of Hrs & min
		String hrsMin = hrs.concat(":" + min);
		System.out.println(hrsMin);
		Date ATATime = (Date) timeFormat.parse(hrsMin);
		System.out.println(ATATime);

		// Format of Date Time
		String dateTimePattern = "yyyy-MM-dd HH:mm";
		DateFormat dateTimeFormat = new SimpleDateFormat(
				dateTimePattern);

		// concatenation of date & Time in Incident Date Time
		String dateTimeOfIncidentText = dateFormatOfDate.concat(" "
				+ timeFormatOfTime);
		System.out.println(dateTimeOfIncidentText);
		Date dateTimeOfIncident = (Date) dateTimeFormat
				.parse(dateTimeOfIncidentText);
		System.out.println(dateTimeOfIncident);

		// concatenation of date & Time in ATA Date Time
		String dateTimeOfATAText = currentDate.concat(" " + hrsMin);
		System.out.println("ATA " + dateTimeOfATAText);
		Date dateTimeOfATA = (Date) dateTimeFormat
				.parse(dateTimeOfATAText);
		System.out.println(dateTimeOfATA);

		btnUpdateDetail.click();

		if (dateTimeOfATA.compareTo(dateTimeOfIncident) > 0
				&& dateTimeOfATA.compareTo(dateTimeOfIncident) > 0) {
			System.out
					.println("ATA Date & Time is Greter than Incident Date & Time\n");

		} else if (dateTimeOfATA.compareTo(dateTimeOfIncident) <= 0
				&& dateTimeOfATA.compareTo(dateTimeOfIncident) <= 0) {
			System.out
					.println("ATA Date & Time is Less than Incident Date & Time\n");

			// Get Notification
			// Thread.sleep(5000);
			String notificationText = notification.getText();
			System.out.println(notificationText);

			Assert.assertEquals(notificationText,
					"ATA Date Time should be greater than Incident Date Time",
					"Notification is not Match");
			
			btnCancel.click();
		}
	}

	// If user select ATA date and Time less than ETA Date and Time then
	// notification should display as ' Incident Updated Successfully ' and
	// data/time should get update on ATA tab
	public void punchATA() throws Exception 
	{

		// Format Date
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);

		// Format Time
		String timePattern = "HH:mm";
		DateFormat timeFormat = new SimpleDateFormat(timePattern);

		// Click on ETA and Technician Tab
		tabETATechnician.click();
		
		String ETADateText = lblETADateInETAAndTechnicianTab.getText();
		System.out.println(ETADateText);
		String ETADate = ETADateText.split("ETA Date : ")[1];
		System.out.println("ETADate" + ETADate);

		String ETATimeText = lblETATimeInETAAndTechnicianTab.getText();
		System.out.println(ETATimeText);
		String ETATime = ETATimeText.split("ETA Time : ")[1];
		System.out.println("ETATime" + ETATime);

		// Click on ATA Tab
		tabATA.click();

		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);
		// Click on Calendar
		lblCalendarATADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : lblDayCalendarInATADetailsPage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		// Get Date in ATA Date Text box
		String currentDate = txtATADateInATADetailsPage
				.getAttribute("value");
		System.out.println(currentDate);
		Date ATADate = (Date) dateFormat.parse(currentDate);
		System.out.println(ATADate);

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
		System.out.println(hrs);
		String min = new SimpleDateFormat("mm").format(calendar.getTime());
		System.out.println(min);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlHrsOfATATimeInATADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		
		for (WebElement minOfSystem : ddlMinOfATATimeInATADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		// concatenation of Hrs & min
		String hrsMin = hrs.concat(":" + min);
		System.out.println(hrsMin);
		Date ATATime = (Date) timeFormat.parse(hrsMin);
		System.out.println(ATATime);

		// Format of Date Time
		String dateTimePattern = "yyyy-MM-dd HH:mm";
		DateFormat dateTimeFormat = new SimpleDateFormat(dateTimePattern);

		// concatenation of date & Time in ATA Date Time
		String dateTimeOfATAText = currentDate.concat(" " + hrsMin);
		System.out.println("ATA " + dateTimeOfATAText);
		Date dateTimeOfATA = (Date) dateTimeFormat.parse(dateTimeOfATAText);
		System.out.println(dateTimeOfATA);

		// concatenation of date & Time in ETA Date Time
		String dateTimeOfETAText = ETADate.concat(" " + ETATime);
		System.out.println("ETA " + dateTimeOfETAText);
		Date dateTimeOfETA = (Date) dateTimeFormat.parse(dateTimeOfETAText);
		System.out.println(dateTimeOfETA);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		btnUpdateDetail.click();

		if (dateTimeOfATA.compareTo(dateTimeOfETA) <= 0
				&& dateTimeOfATA.compareTo(dateTimeOfETA) <= 0) {
			System.out
					.println("ATA Date & Time is Less than ETA Date & Time\n");

			// Get Notification
			// Thread.sleep(5000);
			String notificationText = notification.getText();
			System.out.println(notificationText);

			Assert.assertEquals(notificationText,
					"Incident Updated Successfully",
					"Notification is not Match");
		}

	}

	// If user click on edit button of Pause tab without punching ETA/ATA then
	// notification should display as 'Please Update ETA First.'
	public void displayNotificationWithoutETAAndATAInPauseTab()
			throws Exception 
	{

		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		for (int i = 0; i < sizeOfId; i++) {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			String idValue = lblIDInParentTable.get(i).getText();
			System.out.println("idValue:-" + idValue);

			lblIDInParentTable.get(i).click();
			Thread.sleep(1000);

			int sizeOfIdInSubTicket = lstIDInChildTable.size();
			System.out.println(sizeOfIdInSubTicket);

			for (int k = 0; k < sizeOfIdInSubTicket; k++) {

				String statusInSubTicketValue = lstStatusInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-"
						+ statusInSubTicketValue);

				String etaDateInSubTicketValue = lstETADateInChildTable
						.get(k).getText();
				System.out.println("etaDateInSubTicketValue:-"
						+ etaDateInSubTicketValue);

				if (statusInSubTicketValue.equalsIgnoreCase("open")
						&& etaDateInSubTicketValue.equals("")) {

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInChildTable.get(k));

					lstIDInChildTable.get(k).click();
					// Click on Pause Tab
					tabPauseInTicketForm.click();
					// Click on Edit Button In Pause Tab
					btnEditInPauseTab.click();
					// Get Notification
					// Thread.sleep(5000);
					String notificationText = notification.getText();
					System.out.println(notificationText);

					Assert.assertEquals(notificationText,
							"Please Update ETA First.",
							"Notification is not Match");
					
					btnCloseNotificationBox.click();
					break;

				}

			}
			break;

		}

	}

	// check whole test cases in pause tab
	public void pauseTheTicket() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		// Click on Pause Tab
		tabPauseInTicketForm.click();

		// Click on Edit Button In Pause Tab
		btnEditInPauseTab.click();

		for (String Window : driver.getWindowHandles()) {
			driver.switchTo().window(Window);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			scrollDown(btnListOfPauseReasonsInPausepage);
			
			highLight(btnListOfPauseReasonsInPausepage);
			
			// Click on List Of Pause Reasons Button
			btnListOfPauseReasonsInPausepage.click();

			for (String listOfPauseReasons : driver.getWindowHandles()) {
				driver.switchTo().window(listOfPauseReasons);
			}

			// Get Heading
			String HeadingOflistOfPauseReasonsPage = headingListOfPauseReasonsPage
					.getText();
			System.out.println(HeadingOflistOfPauseReasonsPage);

			softAssert.assertEquals(HeadingOflistOfPauseReasonsPage,
					"List of Pause Reasons", "Page is not same");

			// Get Pause Reason
			String pauseReason = column_PauseReasonsInListOfPauseReasonsPage
					.get(1).getText();
			System.out.println(pauseReason);

			driver.findElement(By.linkText(pauseReason)).click();

			for (String pauseDetailWindow : driver.getWindowHandles())
			{
				driver.switchTo().window(pauseDetailWindow);

			}

			pauseReasonValue = txtPasuedReson.getAttribute("value");
			System.out.println("pauseReasonValue:-" + pauseReasonValue);

			// Format Date
			String datePattern = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);

			// Format Time
			String timePattern = "HH:mm";
			DateFormat timeFormat = new SimpleDateFormat(timePattern);

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Next date
			int afterDay = Integer.parseInt(currentDay) + 1;
			String nextDay = Integer.toString(afterDay);
			lblCalendarPauseDetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInPauseDetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(currentDay)) {
					Thread.sleep(500);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			Thread.sleep(1000);
			// Get Date in Resume Date Text box
			String resumeDateText = txtAutoResumeDateInPauseDetailsPage
					.getAttribute("value");
			System.out.println(resumeDateText);
			Date resumeDate = (Date) dateFormat.parse(resumeDateText);
			System.out.println(resumeDate);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			hour = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hour);

			min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);
			int mintue = Integer.parseInt(min) + 5;
			String mints = Integer.toString(mintue);

			sec = new SimpleDateFormat("ss").format(calendar.getTime());
			System.out.println(sec);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : ddlHrsOfAutoResumeTimeInPauseDetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hour)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : ddlMinOfAutoResumeTimeInPauseDetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(mints)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			// concatenation of date & Time in current Date Time
			resumeDateAndTime = resumeDateText
					.concat("  " + hour + ":" + mints);
			System.out.println("resumeTime: " + resumeDateAndTime);
			/*
			 * Date pauseTime = (Date) dateHrsMin.parse(resumeTime);
			 * resumeDateAndTime = dateHrsMin.format(pauseTime);
			 */
			System.out.println("resumeDateAndTime: " + resumeDateAndTime);

			// concatenation of date & Time in current Date Time
			String currentTime = resumeDateText
					.concat("   " + hour + ":" + min);
			System.out.println("currentTime: " + currentTime);
			 startTime = (Date) dateHrsMin.parse(currentTime);
			currentDateAndTime = dateHrsMin.format(startTime);
			System.out.println("currentDateAndTime: " + currentDateAndTime);

			
			scrollDown(btnUpdateDetail);
			
			highLight(btnUpdateDetail);
			
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			// Click on Update Details
			btnUpdateDetail.click();
			softAssert.assertAll();

		}
	}

	public void checkPauseDetails() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("\ncheck Pause Details\n");
		// click on pause tab
		tabPauseInTicketForm.click();

		// Get pause start date and time

		int sizeOfPauseStartDateAndTime = lblPauseStartDateTimeInPauseTab
				.size();
		
		scrollDown( lblPauseStartDateTimeInPauseTab.get(sizeOfPauseStartDateAndTime - 1));
		
		highLight( lblPauseStartDateTimeInPauseTab.get(sizeOfPauseStartDateAndTime - 1));

		String pauseStartDateAndTimeTextInPause = lblPauseStartDateTimeInPauseTab
				.get(sizeOfPauseStartDateAndTime - 1).getText();
		System.out.println("PauseStartDateAndTimeText:- "
				+ pauseStartDateAndTimeTextInPause);
		Date systemTime = (Date) dateHrsMin
				.parse(pauseStartDateAndTimeTextInPause);
		String pauseStartDateAndTime = dateHrsMin.format(systemTime);
		System.out.println("pauseStartDateAndTime:- " + pauseStartDateAndTime);

		softAssert.assertEquals(pauseStartDateAndTime, currentDateAndTime,
				"Pause Start Date And Time is not same");
		
		softAssert.assertAll();	
		
	}

	public void checkLatestPauseDetails() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();

		System.out.println("\ncheck Latest Pause Details\n");
		// Click on latest Pause Tab
		tabLatestPauseInTicketForm.click();

		Thread.sleep(500);

		scrollDown(lblPauseStartDateAndTimeInLatestPauseTab);
		
		highLight(lblPauseStartDateAndTimeInLatestPauseTab);
		
		// Get pause start date and time
		String pauseStartDateAndTimeInLatestPause = lblPauseStartDateAndTimeInLatestPauseTab
				.getText();
		Date systemTime = (Date) dateHrsMin
				.parse(pauseStartDateAndTimeInLatestPause);
		String pauseStartDateAndTime = dateHrsMin.format(systemTime);
		System.out.println("pauseStartDateAndTime:-" + pauseStartDateAndTime);

		String resumeDateAndTimeInLatestPause = lblResumeDateAndTimeInLatestPauseTab
				.getText();
		System.out.println("resumeDateAndTimeInLatestPause: "
				+ resumeDateAndTimeInLatestPause);
		SimpleDateFormat dateHrsMins = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
	    resumeTime = (Date) dateHrsMins
				.parse(resumeDateAndTimeInLatestPause);

		String resumeDateAndTimeText = dateHrsMins.format(resumeTime);
		System.out.println("resumeDateAndTimeText:-" + resumeDateAndTimeText);


       scrollDown(lblPauseReasonInLatestPauseTab);
       
       highLight(lblPauseReasonInLatestPauseTab);
       
		// get Pause reason in latest pause
		String pauseReasonInLatestPause = lblPauseReasonInLatestPauseTab
				.getText();
		System.out.println("pauseReasonInLatestPause:-"
				+ pauseReasonInLatestPause);

		// Match END Date and time in latest pause
		softAssert.assertEquals(resumeDateAndTimeText, resumeDateAndTime,
				"Resume Date And Time is not same");

		// Match pause start date and time
		softAssert.assertEquals(pauseStartDateAndTime, currentDateAndTime,
				"Pause Start Date And Time is not same");

		// Match pause reason
		softAssert.assertEquals(pauseReasonInLatestPause+" ", pauseReasonValue,
				"Pause Reason In latest pause is not same");
		
		softAssert.assertAll();

	}
	
	public void countTotalPauseTimeInPauseTab() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		System.out.println("\ncountTotalPauseTimeInPauseTab\n");
		
		// click on pause tab
		tabPauseInTicketForm.click();
		
		Instant startDateTime = startTime.toInstant();
		Instant endDateTime = resumeTime.toInstant();
		
		// Difference between Two Dates
		Duration duration = Duration.between(startDateTime,
				endDateTime);
		long dateAndTime = duration.toMinutes();
		System.out.println("Days: " + dateAndTime);
		int dateTime = (int) dateAndTime;

		String min = Integer.toString(dateTime);
		System.out.println("min: "+min);

		scrollDown(lblTotalPauseMinutesInPauseTab);
		
		highLight(lblTotalPauseMinutesInPauseTab);
		
		String totalPauseMinutes = lblTotalPauseMinutesInPauseTab
				.getText();
		System.out.println(totalPauseMinutes);
		softAssert.assertEquals(totalPauseMinutes, min, "The difference Between pause start date and "
				+ "time and pause end date and time is different");
		
		softAssert.assertAll();
		
	}


//Technician close
    
	// If User not update ETA and/or ATA then and click on Edit button of
	// Technician close tab then notification should display as 'Please Update
	// ETA And ATA First.'
	public void clickOnEditButtonAndCheckNotification() throws Exception 
	{
		// Click on Technician close tab

		tabTechnicianClose.click();

		// Click on Edit Button In Technician close Tab
		btnEditOfTechncianClose.click();

		// Get Notification
		// Thread.sleep(5000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		Assert.assertEquals(notificationText,
				"Please Update ETA And ATA First.",
				"Notification is not Match");

	}
	
	//Check all pop up message
	public void checkUpdateDetailInTechnicianClose() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		//click on ETA Technician Tab
		tabTechnicianClose.click();
		
		//click on Edit Button in technician close
		btnEditOfTechncianClose.click();
		
		//click on Update details with blank data
		driver.manage().timeouts()
		.pageLoadTimeout(40, TimeUnit.SECONDS);
		
		btnUpdateDetail.click();
		
		Alert alertOfTechCloseDateAndTime = driver.switchTo().alert();
		String getAlertOfTechCloseDateAndTime = alertOfTechCloseDateAndTime.getText();
		System.out.println("getAlertOfTechCloseDateAndTime: "+getAlertOfTechCloseDateAndTime);
		alertOfTechCloseDateAndTime.accept();
	
		softAssert.assertEquals(getAlertOfTechCloseDateAndTime, "Please Select Tech Close Date And Time", "The Alert Message For Tech close date and time is not same");
		
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay);
		String previousDay = Integer.toString(preDay);
		lblCalendarTechnicianClosePage.click();
		/*
		 * Robot robot = new Robot();
		 * robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_PLUS);
		 */
		// select Date in Calendar

		for (WebElement day : day_CalendarInTechnicianClosePage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-"
						+ getDateValue);

				break;
			}

		}

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH")
				.format(calendar.getTime());
		System.out.println(hrs);
		String min = new SimpleDateFormat("mm")
				.format(calendar.getTime());
		System.out.println(min);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlHrsOfTechnicianCloseTime)
		{

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-"
						+ getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfTechnicianCloseTime) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-"
						+ getDateValue);

				break;
			}

		}
		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
        btnUpdateDetail.click();
        
        
        Alert alertOfResolutionField = driver.switchTo().alert();
		String getAlertOfResolutionField = alertOfResolutionField.getText();
		System.out.println("alertMessageValue: "+getAlertOfResolutionField);
		alertOfResolutionField.accept();
	
		assertEquals(getAlertOfResolutionField, "Please Enter Resolution And Resolutin Description", "The Alert Message For Tech close date and time is not same");
		

		String resolution = "Activity has been completed";
		txtResolutionInTechnicianClose
				.sendKeys(resolution);

		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
        btnUpdateDetail.click();
        
	    Alert alertOfResolutionDescriptionField = driver.switchTo().alert();
		String getAlertOfResolutionDescriptionField = alertOfResolutionDescriptionField.getText();
		System.out.println("alertMessageValue: "+getAlertOfResolutionDescriptionField);
		alertOfResolutionDescriptionField.accept();
	
		softAssert.assertEquals(getAlertOfResolutionDescriptionField, "Please Enter Resolution Description", "The Alert Message For Tech close date and time is not same");
		
		String resolutionDescription = "Activity has been completed";
		txtResolutionDescriptionInTechnicianClose
				.sendKeys(resolutionDescription);
		
		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
        btnUpdateDetail.click();
        
	   
        // Get Notification
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Incident Updated SuccessFully",
				"Notification is not Match");
		btnCloseNotificationBox.click();
		
		softAssert.assertAll();
	
	}
	
	//To check select TechClose
	public void clickOnSubTicketWithTechclose() throws Exception 
	{

		String firstParentTicketWindow = driver.getWindowHandle();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		loop: for (int i = 0; i < sizeOfId; i++) {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			String idValue = lblIDInParentTable.get(i).getText();
			System.out.println("idValue:-"+idValue);
			
			lblIDInParentTable.get(i).click();
			Thread.sleep(1000);
			
			int sizeOfIdInSubTicket = lstIDInChildTable.size();
			System.out.println(sizeOfIdInSubTicket);

			for (int k = 0; k < sizeOfIdInSubTicket; k++)
			{

				String statusInSubTicketValue = lstStatusInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-" + statusInSubTicketValue);
				
				
				if (statusInSubTicketValue.contains("TechnicianClosed")) 
				{

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInChildTable.get(k));

					lstIDInChildTable.get(k).click();
					break ;

				}
				
				if(sizeOfIdInSubTicket-1 == k)
				{
					driver.navigate().back();
					driver.switchTo().window(firstParentTicketWindow);
					continue loop;
					
				}
				
			}
			
			break;
			
			
		}

	}

	public void clickOnSubTicketWithETA() throws Exception 
	{

		String firstParentTicketWindow = driver.getWindowHandle();
		int sizeOfId = lblIDInParentTable.size();
		System.out.println(sizeOfId);

		loop: for (int i = 0; i < sizeOfId; i++) {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lblIDInParentTable.get(i));

			String idValue = lblIDInParentTable.get(i).getText();
			System.out.println("idValue:-"+idValue);
			
			lblIDInParentTable.get(i).click();
			Thread.sleep(1000);
			
			int sizeOfIdInSubTicket = lstIDInChildTable.size();
			System.out.println(sizeOfIdInSubTicket);

			for (int k = 0; k < sizeOfIdInSubTicket; k++)
			{

				String statusInSubTicketValue = lstStatusInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-" + statusInSubTicketValue);
				
				
				String etaDateInSubTicketValue = lstETADateInChildTable.get(k)
						.getText();
				System.out.println("statusInSubTicketValue:-" + etaDateInSubTicketValue);

				if (statusInSubTicketValue.equalsIgnoreCase("open")&&!etaDateInSubTicketValue.equalsIgnoreCase("")) 
				{
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInChildTable.get(k));

					lstIDInChildTable.get(k).click();
					break ;

				}
				
				if(sizeOfIdInSubTicket-1 == k)
				{
					driver.navigate().back();
					driver.switchTo().window(firstParentTicketWindow);
					continue loop;
					
				}
				
			}
			
			break;
		}

	}

	// without entering any data if user click on update detail button then
	// 'Please enter Final close date.' pop up message should display.
	public void checkUpdateDetailsWithBlankData() throws Exception 
	{

		// click on Technician close tab
		tabTechnicianClose.click();

		// click on final close button
		btnClose.click();

		scrollDown(btnUpdateDetail);
		
		highLight(btnUpdateDetail);
		Thread.sleep(1000);
		btnUpdateDetail.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();

		// match the window
		Assert.assertEquals(alertMessage, "Please enter Final close date.");

	}

	// if user select the close date less than technician close date then 'Final
	// close date/time should be greater than Tech close date/time.' pop up should be dispaly.
	public void compareCloseDateWithTechnicianDateTime() throws Exception 
	{
		Thread.sleep(9000);

		String getTechnicianDateTime = lblTechnicianCloseTime.getText();
		System.out.println("getTechnicianDateTime" + getTechnicianDateTime);

		String splitTime = getTechnicianDateTime.split(" ")[0];
		System.out.println("splitTime: " + splitTime);
		String splitYearAndMonth = splitTime.split("-")[2];
		System.out.println("splitYearAndMonth: " + splitYearAndMonth);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date technicianDateInFormat = (Date) dateFormat.parse(splitTime);

		String technicianDate = dateFormat.format(technicianDateInFormat);
		System.out.println("technicianDate:- " + technicianDate);

		// select Date in Calendar

		// click on Technician close tab
		tabTechnicianClose.click();

		// click on final close button
		btnClose.click();

		int preDay = Integer.parseInt(splitYearAndMonth) - 2;
		String previousDay = Integer.toString(preDay);
		System.out.println("previousDay: " + previousDay);
		lblCloseDateCalender.click();

		for (WebElement day : day_CalendarInTechnicianClosePage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		String getCloseDateValue = txtCloseDate.getAttribute("value");
		System.out.println(getCloseDateValue);

		Date closeDateInFormat = (Date) dateFormat.parse(getCloseDateValue);

		String closeDate = dateFormat.format(closeDateInFormat);
		System.out.println("closeDate:-" + closeDate);

		if (technicianDate.compareTo(closeDate) >= 0) {

			btnUpdateDetail.click();
			Thread.sleep(3000);

			// get the message from that alert box
			String notificationMessage = notification.getText();
			System.out.println("Alert Text:" + notificationMessage);

			Assert.assertEquals(notificationMessage,
					"Final Close date time should be greater than technician close date time");

		}

		else {

			System.out
					.println("The Time Is Selected is greater than Technician close time");

		}

	}

//If user click on Update details button in Final close details popup without enter Final close time  then notification should display as 'Final close date/time should be greater than Tech close date/time.'
	
	public void checkNotificationWithoutSelectingTime() throws Exception 
	{
		System.out.println("=================");
		Thread.sleep(9000);
		
		// click on Technician close tab
		tabTechnicianClose.click();

		// click on final close button
		btnClose.click();
		
		// Get System Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("currentDate:- " + currentDate);
			
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		String currentDay = Integer.toString(dayOfMonth);
        System.out.println("currentDay: "+currentDay);

		int preDay = Integer.parseInt(currentDay) +2 ;
		String nextDate = Integer.toString(preDay);
		System.out.println("previousDay: " + nextDate);
		

		lblCloseDateCalender.click();

		for (WebElement day : day_CalendarInTechnicianClosePage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(nextDate)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}
			
		}

		String getCloseDateValue = txtCloseDate
				.getAttribute("value");
		System.out.println(getCloseDateValue);
		
	    Date closeDateInFormat = (Date) dateFormat
				.parse(getCloseDateValue);

		String closeDate = dateFormat.format(closeDateInFormat);
		System.out.println("closeDate:-" + closeDate);

			if (currentDate.compareTo(closeDate) <= 0)
			{

				btnUpdateDetail.click();
				Thread.sleep(3000);

				// get the message from that alert box
				String notificationMessage = notification.getText();
				System.out.println("Alert Text:" + notificationMessage);

				Assert.assertEquals(notificationMessage,
						"Final Close date time should be greater than technician close date time");

				

			}

			else {

				System.out
						.println("there is problem in time selection");
				

			}

		}
	
	//If User enter final close date/time more than current date and time then notification should display as 'Final close Date/Time should be less than or Equal to Current Date/Time.'

	public void compareCloseDateWithCurrentDateTime() throws Exception 
	{
        System.out.println("==================");
		Thread.sleep(1000);

		// click on Technician close tab
		tabTechnicianClose.click();

		// click on final close button
		btnClose.click();

		// Get System Date
		// Get System Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("currentDate:- " + currentDate);
			
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay) + 2;
		String nextDate = Integer.toString(preDay);
		System.out.println("previousDay: " + nextDate);
		lblCloseDateCalender.click();

		for (WebElement day : day_CalendarInTechnicianClosePage) 
		{

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(nextDate)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		String getCloseDateValue = txtCloseDate
				.getAttribute("value");
		System.out.println(getCloseDateValue);
		
	    Date closeDateInFormat = (Date) dateFormat
				.parse(getCloseDateValue);

		String closeDate = dateFormat.format(closeDateInFormat);
		System.out.println("closeDate:-" + closeDate);

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH").format(calendar
				.getTime());
		System.out.println(hrs);
		String min = new SimpleDateFormat("mm").format(calendar
				.getTime());
		System.out.println(min);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlCloseTimeHourValue) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-"
						+ getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlCloseTimeMinuteValue) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-"
						+ getDateValue);

				break;
			}

		}

		if (currentDay.compareTo(getCloseDateValue) >= 0) {

			btnUpdateDetail.click();
			Thread.sleep(3000);

			// get the message 
			String notificationMessage = notification.getText();
			System.out.println("Alert Text:" + notificationMessage);

			Assert.assertEquals(notificationMessage,
					"Final Close date time should be less than or Equal to Current date time");

		}

		else {

			System.out
					.println("The Time Is Selected is less than current date and time");

		}

	
	}

	// close the ticket
	public void closeSubTicket() throws  Exception 
	{
		SoftAssert softAssert = new SoftAssert(); 
		System.out.println("=============");
		Thread.sleep(9000);
		
		String getTechnicianDateTime = lblTechnicianCloseTime.getText();
		System.out.println("getTechnicianDateTime" + getTechnicianDateTime);
		//for date
		String splitTime = getTechnicianDateTime.split(" ")[0];
		System.out.println("splitTime: " + splitTime);
		String splitYearAndMonth = splitTime.split("-")[2];
		System.out.println("splitYearAndMonth: " + splitYearAndMonth);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date technicianDateInFormat = (Date) dateFormat.parse(splitTime);
		
		String technicianDate = dateFormat.format(technicianDateInFormat);
		System.out.println("technicianDate:- " + technicianDate);
		
		//for time
		String splitDate = getTechnicianDateTime.split(" ")[1];
		System.out.println("splitDate: " + splitDate);
		String getHrsValue = splitDate.split(":")[0];
		System.out.println("getHrsValue: " + getHrsValue);
		
		
		int nextHrValue = Integer.parseInt(splitYearAndMonth)+ 1;
		String hrs = Integer.toString(nextHrValue);
		System.out.println("hrs: " + hrs);
		
		String getMinuteValue = splitDate.split(":")[1];
		System.out.println("getMinuteValue: " + getMinuteValue);

	
		// select Date in Calendar

		// click on Technician close tab
		tabTechnicianClose.click();

		// click on final close button
		btnClose.click();

		/*int preDay = Integer.parseInt(splitYearAndMonth) - 2;
		String previousDay = Integer.toString(preDay);
		System.out.println("previousDay: " + previousDay);*/
		lblCloseDateCalender.click();

		for (WebElement day : day_CalendarInTechnicianClosePage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(hrs)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		String getCloseDateValue = txtCloseDate.getAttribute("value");

		System.out.println(getCloseDateValue);

		// select ETA Time Minute

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlCloseTimeHourValue) 
		{

			String hrsInDropdown = hrsofSystem.getText();
			System.out.println(hrsInDropdown);

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				
				Thread.sleep(1000);
				hrsofSystem.click();
				String getTimeHour = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getTimeHour);

				break;
			}

		}

		// select Minute in Drop down

		for (WebElement minOfSystem : ddlCloseTimeMinuteValue) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(getMinuteValue)) {
				
				Thread.sleep(1000);
				minOfSystem.click();
				String getTimeMinute = minOfSystem.getText();
				System.out.println("Select the min:-" + getTimeMinute);

				break;
			}

		}

		String getCloseTimeHourValue = ddlCloseTimeHour
				.getAttribute("value");
		System.out.println(getCloseTimeHourValue);

		String getCloseTimeMinuteValue = ddlCloseTimeMinute
				.getAttribute("value");
		System.out.println(getCloseTimeMinuteValue);

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);

		btnUpdateDetail.click();
		
		
		// get the message from that alert box
		String notificationMessage = notification.getText();
		System.out.println("Alert Text:" + notificationMessage);

		softAssert.assertEquals(notificationMessage,
							"Ticket Final Close is Update Successfully");
		
		btnCloseNotificationBox.click();
		
		//check that the status value is get change
		String getStatusValue = driver.findElement(By.xpath(".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]/span")).getText();
		System.out.println(getStatusValue);
		String splitStatus = getStatusValue.split("\n")[1];
		System.out.println("split: "+splitStatus);
		String status = splitStatus.split(" ")[2];
		System.out.println("Status: "+status);

		softAssert.assertEquals(status, "Closed", "Ticket is not close");
		
		softAssert.assertAll();

	}

	
	
	    //To check select TechClose
		public void checkParentTicketStatusAfterCloseAllSubTicket() throws Exception 
		{

			String firstParentTicketWindow = driver.getWindowHandle();
			int sizeOfId = lblIDInParentTable.size();
			System.out.println(sizeOfId);

			loop: for (int i = 0; i < sizeOfId; i++) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lblIDInParentTable.get(i));

			    idValue = lblIDInParentTable.get(i).getText();
				System.out.println("idValue:-"+idValue);
				
				lblIDInParentTable.get(i).click();
				Thread.sleep(1000);
				
				int sizeOfIdInSubTicket = lstIDInChildTable.size();
				System.out.println(sizeOfIdInSubTicket);

				secondLoop:for (int k = 0; k < sizeOfIdInSubTicket; k++)
				{

					String statusInSubTicketValue = lstStatusInChildTable.get(k)
							.getText();
					System.out.println("statusInSubTicketValue:-" + statusInSubTicketValue);
					
					
					if (statusInSubTicketValue.equals("open")) 
					{

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								lstIDInChildTable.get(k));

						String childTicketWindow = driver.getWindowHandle();
						lstIDInChildTable.get(k).click();
						
						sd_ViewSubTicketPage = new SD_ViewSubTicketPage();
						sd_ViewSubTicketPage.punchETAandTchnician();
						Thread.sleep(2000);
						sd_ViewSubTicketPage.punchATA();
						Thread.sleep(2000);
						sd_ViewSubTicketPage.checkUpdateDetailInTechnicianClose();
						Thread.sleep(2000);
						sd_ViewSubTicketPage.closeSubTicket();
						Thread.sleep(2000);
						
						sd_HomePage = new SD_HomePage();
						sd_TicketPage = sd_HomePage.ticketTab();
						Thread.sleep(1000);
						sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
						
						tabSearchId.click();
						
						txtTicketId.sendKeys(idValue);
						
						btnGoOfTicketId.click();
						
						lblIdTable.click();
						
						driver.switchTo().window(childTicketWindow);
						continue secondLoop;
						
						

					}
					
					else	
					
					if(sizeOfIdInSubTicket-1 == k && statusInSubTicketValue.equals("Closed"))
					{
						sd_HomePage = new SD_HomePage();
						sd_TicketPage = sd_HomePage.ticketTab();
						Thread.sleep(1000);
						sd_ViewSubTicketPage = sd_TicketPage.viewSubTicketTab();
						
						tabSearchId.click();
						
						txtTicketId.sendKeys(idValue);
						
						btnGoOfTicketId.click();
						
						
						driver.switchTo().window(firstParentTicketWindow);
						
						String matchStatus = driver.findElement(By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[8]")).getText();
						System.out.println("matchStatus "+matchStatus);
						
				        assertEquals(matchStatus, "Open");
					
						break loop;
						
					}
					
					if(sizeOfIdInSubTicket-1 == k)
					{
						driver.navigate().back();
						driver.switchTo().window(firstParentTicketWindow);
						continue loop;
						
					}
					
					
					
				}
			
				break;
			}

		}
}