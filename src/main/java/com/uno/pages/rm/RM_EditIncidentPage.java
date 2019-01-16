package com.uno.pages.rm;



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

	import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;





	public class RM_EditIncidentPage extends BaseCode {
		

		public static String serialNumber = null;
		public static String getTechnicianDateTime = null;
		

		// call the method from SD role




		@FindBy(linkText = "Ticket")
		WebElement tab_Ticket;

		@FindBy(css = "a[href='/erprmwise/IncidentAction.do']")
		WebElement tab_CreateNew;

		@FindBy(xpath = "//a[@href='/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")
		WebElement tab_ViewTicket;

		@FindBy(linkText = "Edit Incident")
		WebElement tab_EditIncident;

		// Select Incident ID Text Box
		@FindBy(xpath = ".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]")
		WebElement textbox_IncidenID;

		// select Search Ticket
		@FindBy(css = "#open")
		WebElement tab_SearchTicketOpen;

		// select Search Ticket
		@FindBy(css = "#close")
		WebElement tab_SearchTicketClose;

		// Select Account link
		@FindBy(linkText = "Account")
		WebElement link_Account;

		// Select SD tab for logout tab
		@FindBy(linkText = "Bhagyashree")
		WebElement link_Bhagyashree;

		// Select SD tab for logout tab
		@FindBy(linkText = "Test")
		WebElement link_Test;

		// Click on logout
		@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
		WebElement link_LogOut;

		// Notification of View Ticket Page
		@FindBy(css = "div[id='form']>div[id='dialogBoxSuccess']")
		WebElement notification;

		// select Search Ticket
		@FindBy(linkText = "Search Ticket")
		WebElement tab_SearchTicket;

		// Select Id in Table
		@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
		WebElement id_InTable;

		// list of Flag of Incorrect Customer Address
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(12)>img")
		List<WebElement> list_FlagOfIncorrectCustomerAddressInTable;

		// list of Blinking Notification in View Ticket Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>i")
		List<WebElement> list_BlinkingNotificationInTable;

		// list of ETA Date in View Ticket Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)")
		List<WebElement> list_ETADateInTable;

		// list of ATA Date in View Ticket Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)")
		List<WebElement> list_ATADateInTable;

		// list of Paused Time in View Ticket Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(39)")
		List<WebElement> list_PausedTimeInTable;

		// list of Remark in View Ticket Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(53)")
		List<WebElement> list_RemarkInTable;

		// Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
		List<WebElement> dropdown_Pagination;

		// Left Most Arrow Of Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(1)")
		WebElement arrow_LeftmostArrowOfPagination;

		// Right Most Arrow Of Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(4)")
		WebElement arrow_RightmostArrowOfPagination;

		// Right Arrow Of Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(3)")
		WebElement arrow_RightArrowOfPagination;

		// Left Arrow Of Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(2)")
		WebElement arrow_LeftArrowOfPagination;

		// Selected Page in Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option[selected='selected']")
		WebElement page_SelectedInPagination;

		// List of Row in Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
		List<WebElement> list_RowInTable;

		// Search Ticket Tab //

		// select Search ID
		@FindBy(name = "m_strSearchIncId")
		WebElement tab_SearchId;

		// select GO button of ID
		@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
		WebElement button_GoOfId;

		// select Search asset ID
		@FindBy(name = "m_strSearchAssetId")
		WebElement tab_AssetId;

		// select GO button of asset ID
		@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
		WebElement button_GoOfAssetId;

		// select Search Ticket ID
		@FindBy(name = "m_strSearchTicketId")
		WebElement tab_TicketId;

		// select GO button of ticket ID
		@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
		WebElement button_GoOfTicketId;

		// Label in Incident Number
		@FindBy(css = ".roundBoxMdlBg.roundBoxMdlBg1>ul>li:nth-of-type(1)>span:nth-of-type(2)")
		WebElement label_IncidentNumber;

		// Label Date in Incident Date Time
		@FindBy(css = ".roundBoxMdlBg.roundBoxMdlBg1>ul>li:nth-of-type(2)>span")
		WebElement label_DateInIncidentDateTime;

		// select filter
		@FindBy(linkText = "Filter")
		WebElement tab_Filter;

		// select state filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(2)>td>select>option:nth-of-type(1)")
		WebElement dropdown_StateFilter;

		// select status filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(5)>td>select>option:nth-of-type(1)")
		WebElement dropdown_StatusFilter;

		// select ticket type filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(7)>td>select>option:nth-of-type(1)")
		WebElement dropdown_TicketTypeFilter;

		// select CTS filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(9)>td>select>option:nth-of-type(1)")
		WebElement dropdown_CTS;

		// select customer filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(11)>td>select>option:nth-of-type(1)")
		WebElement dropdown_CustomerNameFilter;

		// select engineer filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(13)>td>select>option:nth-of-type(1)")
		WebElement dropdown_EnginnerFilter;

		// select engineer filter text box
		@FindBy(name = "m_strEngineer")
		WebElement dropdown_Engineer;

		// select create by role filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(15)>td>select>option:nth-of-type(1)")
		WebElement dropdown_CreateByRoleFilter;

		// select create by filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(17)>td>select>option:nth-of-type(1)")
		WebElement dropdown_CreateByFilter;

		// select category filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(19)>td>select>option:nth-of-type(1)")
		WebElement dropdown_CategoryFilter;

		// select sub category filter text box ,with default selected value
		@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(21)>td>select>option:nth-of-type(1)")
		WebElement dropdown_SubCategoryFilter;

		// select ticket type filter
		@FindBy(name = "m_strIncidentType")
		WebElement dropdown_TicketType;

		// select state filter
		@FindBy(name = "m_strStateFilter")
		WebElement dropdown_State;

		// select state filter
		@FindBy(name = "m_strStatusFilter")
		WebElement dropdown_StatusFilterName;

		// select state filter
		@FindBy(name = "m_strCustomerName")
		WebElement dropdown_Customer;

		// VIEW TICKET PAGE //

		// select Search ID
		@FindBy(name = "m_strSearchIncId")
		WebElement textbox_SearchId;

		// select GO button of ID
		@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
		WebElement button_IDGo;

		// select Search asset ID
		@FindBy(name = "m_strSearchAssetId")
		WebElement textbox_SearchAssetID;

		// select GO button of asset ID
		@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
		WebElement button_AssetIDGo;

		// select Search Ticket ID
		@FindBy(name = "m_strSearchTicketId")
		WebElement textbox_SearchTicketID;

		// select GO button of ticket ID
		@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
		WebElement button_TicketIDGo;

		// Select list of Id in Table
		@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
		List<WebElement> list_IDInTable;

		// select list of status in table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)")
		List<WebElement> list_StatusInTable;

		// select list of Serial Number from table
		@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[10]")
		List<WebElement> list_SerialNumberInTable;

		// Selected tab
		@FindBy(xpath = ".//*[@id='form']/div[2]/ul/li[contains(@class,'active')]")
		WebElement tab_Selected;

		// Title of All Tab Details Page
		@FindBy(css = ".modal-content>div>span")
		WebElement title_AllTabDetailsPage;

		// Requester / Incident Tab //

		// Requester Tab //

		// Click on Incorrect Address Link
		@FindBy(css = ".incorrect-address")
		WebElement link_IncorrectAddress;

		// Select Requester Tab for Open
		@FindBy(css = "div[id='Requestor']>div>div[style='border: 1px solid #b7b7b7']>div[class='rectagleBox marBot10']>span>a[id='open']")
		WebElement tab_RequestorForOpenInRequesterTab;

		// Select Requester Tab for Close
		@FindBy(css = "div[id='Requestor']>div>div[style='border: 1px solid #b7b7b7']>div[class='rectagleBox marBot10']>span>a[id='close']")
		WebElement tab_RequestorForCloseInRequesterTab;

		// Get Customer Address in Requester Table After Entering address
		@FindBy(css = ".rectagleBox.marBot10>div[class='toggle1']>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(9)>td")
		WebElement label_CustomerAddressInRequesterTab;

		// Get Serial No in Requester Table
		@FindBy(css = ".rectagleBox.marBot10>div[class='toggle1']>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(3)>td>strong>span>a")
		WebElement label_SerialNoInRequesterTab;

		// Get Customer Name in Requester Tab
		@FindBy(css = ".rectagleBoxHeading.aa>a[id='open']>table>tbody>tr>td:nth-of-type(2)>span")
		WebElement label_CustomerNameInRequesterTab;

		// Heading in Incident History Page
		@FindBy(css = "div[id='headingText']>table>tbody>tr>td>span")
		WebElement heading_IncidentHistoryPage;

		// Asset Id in Requester Tab
		@FindBy(css = ".rectagleBoxHeading.aa>a[id='open']>table>tbody>tr>td:nth-of-type(3)>span")
		WebElement label_AssetIdInRequesterTab;

		// Incident details Tab //

		// Edit Button in Incident details Tab
		@FindBy(css = "div[id='Requestor']>div>div:nth-of-type(3)>div[class='pad10']>a")
		WebElement button_EditInIncidentDetailsTab;

		// Ticket Details Pop up //

		// Title of Ticket Details Pop up
		@FindBy(css = ".modal-content>div>span")
		WebElement title_TicketDetailsPopup;

		// Drop Down Ticket Type in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td>select")
		WebElement dropdown_TicketTypeInTicketDetailsPopup;

		// Drop Down Mode in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td>select")
		WebElement dropdown_ModeInTicketDetailsPopup;

		// Drop Down Level in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td>select")
		WebElement dropdown_LevelInTicketDetailsPopup;

		// Drop Down CTS in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(8)>td>select")
		WebElement dropdown_CTSInTicketDetailsPopup;

		// Drop Down Impact in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td>select")
		WebElement dropdown_ImpactInTicketDetailsPopup;

		// Drop Down Urgency in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(4)>td>select")
		WebElement dropdown_UrgencyInTicketDetailsPopup;

		// Drop Down Trouble Category in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(6)>td>select")
		WebElement dropdown_TroubleCategoryInTicketDetailsPopup;

		// Drop Down Trouble Sub-Category in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(8)>td>select")
		WebElement dropdown_TroubleSubCategoryInTicketDetailsPopup;

		// Text box Amount in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(10)>td>input")
		WebElement textbox_AmountInTicketDetailsPopup;

		// Text box Local Contact in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>td>input")
		WebElement textbox_LocalContactInTicketDetailsPopup;

		// Text box Local Contact No in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(4)>td>input")
		WebElement textbox_LocalContactNoInTicketDetailsPopup;

		// Text box Customer Email ID in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(6)>td>input")
		WebElement textbox_CustomerEmailIDInTicketDetailsPopup;

		// Text box Date in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)>div>input")
		WebElement textbox_DateInTicketDetailsPopup;

		// T Button of Date in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)>a")
		WebElement button_TofDateInTicketDetailsPopup;

		// Drop Down Hrs of Time in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(1)")
		WebElement dropdown_HrsOfTimeInTicketDetailsPopup;

		// Drop Down Min of Time in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)")
		WebElement dropdown_MinOfTimeInTicketDetailsPopup;

		// Update Details button in Ticket Details Pop up
		@FindBy(css = ".modal-content>div>div>a:nth-of-type(1)")
		WebElement button_UpdateDetailsInTicketDetailsPopup;

		// Incident details Tab //

		// Label Incident type in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(6)>td")
		WebElement label_IncidentTypeInIncidentDetailsTab;

		// Label Mode in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(3)>td")
		WebElement label_ModeInIncidentDetailsTab;

		// Label Level in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(4)>td")
		WebElement label_LevelInIncidentDetailsTab;

		// Label CTS in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(8)>td")
		WebElement label_CTSInIncidentDetailsTab;

		// Label Impact in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(5)>td")
		WebElement label_ImpactInIncidentDetailsTab;

		// Label Urgency in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(7)>td")
		WebElement label_UrgencyInIncidentDetailsTab;

		// Label Trouble Category in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(1)>td")
		WebElement label_TroubleCategoryInIncidentDetailsTab;

		// Label Trouble Sub-Category in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>td")
		WebElement label_TroubleSubCategoryInIncidentDetailsTab;

		// Label Amount in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(3)>td")
		WebElement label_AmountInIncidentDetailsTab;

		// Label Local Contact in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
		WebElement label_LocalContactInIncidentDetailsTab;

		// Label Local Contact No in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
		WebElement label_LocalContactNoInIncidentDetailsTab;

		// Label Customer Email ID in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(3)")
		WebElement label_CustomerEmailIDInIncidentDetailsTab;

		// Label Date in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(5)>td")
		WebElement label_DateInIncidentDetailsTab;

		// Label Time in Incident details Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(6)>td")
		WebElement label_TimeInIncidentDetailsTab;

		// File Attachments Tab //

		// Drop Down File Type in File Attachments Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>table>tbody>tr>td:nth-of-type(3)>select")
		WebElement dropdown_FileTypeInFileAttachmentsTab;

		// Button Browse in File attachments Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>table>tbody>tr>td:nth-of-type(5)>input")
		WebElement button_BrowseInFileAttachmentsTab;

		// Button Upload File in File attachments Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>div:nth-of-type(2)>a:nth-of-type(1)")
		WebElement button_UploadFileInFileAttachmentsTab;

		// Button View Attachments in File attachments Tab
		@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>div:nth-of-type(2)>a:nth-of-type(2)")
		WebElement button_ViewAttachmentsInFileAttachmentsTab;

		// List Of Files Page //

		// Heading of List Of Files Page
		@FindBy(css = "div[id='headingText']>span")
		WebElement heading_ListOfFilesPage;

		// File Column in List Of Files Page
		@FindBy(css = ".rectagleBox>table>tbody>tr>td:nth-of-type(2)>a")
		List<WebElement> column_FileInListOfFilesPage;

		// Preliminary Analysis //

		// select Preliminary Analysis Tab
		@FindBy(css = "li[class='tab14']>a>span")
		WebElement tab_PreliminaryAnalysis;

		// select Edit Button On Preliminary Analysis Tab
		@FindBy(css = "div[id='Preliminary-analysis']>div>div:nth-of-type(2)>a>span")
		WebElement button_EditOfPreliminaryAnalysis;

		// select the pop location in Technician window in preliminary analysis
		@FindBy(name = "m_strPoplocation")
		WebElement textbox_Poplocation;

		// select Technical Status
		@FindBy(name = "m_strPreliminaryStatus")
		WebElement textbox_TechnicalStatus;

		// select Technical Status
		@FindBy(name = "m_strPreliminaryObservations")
		WebElement textbox_Observation;

		// select Customer Name And Contact No Text Box
		@FindBy(name = "m_strCustNamePhone")
		WebElement textbox_CustomerName;

		// select Update Detail Button in TSD Assign Detail Window
		@FindBy(linkText = "Update Details")
		WebElement button_UpdateDetail;

		// select cancel Detail Button in TSD Assign Detail Window
		@FindBy(linkText = "Cancel")
		WebElement button_Cancel;

		// ETA and Technician Tab //

		// ETA and Technician Tab
		@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(3)>a")
		WebElement tab_ETAAndTechnician;

		// Technician in ETA and Technician Tab
		@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
		WebElement label_TechnicianInETAAndTechnicianTab;

		// ETA Date in ETA and Technician Tab
		@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(7)")
		WebElement label_ETADateInETAAndTechnicianTab;

		// select ETA Time from ETA and Technician Tab before data enter
		@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(9)")
		WebElement label_ETATimeInETAAndTechnicianTab;

		// Calendar in ETA Details Page
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
		WebElement calendar_ETADetailsPage;

		// Day in Calendar in ETA Details Page
		@FindBy(css = "div[id='fd-dp-8']>table>tbody>tr>td")
		List<WebElement> day_CalendarInETADetailsPage;

		// ETA Date in ETA Details Page
		@FindBy(css = "input[id='dp-8']")
		WebElement textbox_ETADateInETADetailsPage;

		// Hrs of ETA Time in ETA Details Page
		@FindBy(css = "[name='m_strETATimeHour']>option")
		List<WebElement> dropdown_HrsOfETATimeInETADetailsPage;

		// Min of ETA Time in ETA Details Page
		@FindBy(css = "[name='m_strETATimeMin']>option")
		List<WebElement> dropdown_MinOfETATimeInETADetailsPage;

		// ETA Technician tab

		// select ETA and Technician tab
		@FindBy(css = "li[class='tab4']>a>span")
		WebElement tab_ETATechnician;

		// select call Assign To Technician button
		@FindBy(linkText = "Call Assign To Technician")
		WebElement button_CallAssignToTechnician;

		// select call Assign To Technician button
		@FindBy(linkText = "Resend SMS")
		WebElement button_ResendSMS;

		// select Technician Text Box of call assign to technician button
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)>input")
		WebElement textbox_Technician;

		// select the first list of click on first list symbol of Technician Field
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[1]/table/tbody/tr[2]/td[2]/img")
		WebElement symbol_TechnicianList;

		// select technician from technician window
		@FindBy(css = "div[class='rectagleBox']>table>tbody>tr>td:nth-of-type(3)")
		List<WebElement> list_TechnicianName;

		// select ETA Date in Technician Assign And ETA Details Detail Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>input")
		WebElement textbox_ETADate;

		// select ETA Date Calendar Button in Technician Assign And ETA Details
		// Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
		WebElement symbol_ETACalender;

		// select ETA time in Technician Assign And ETA Details Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)")
		WebElement textbox_ETATimeMinute;

		// select ETA time in Technician Assign And ETA Details Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)>option")
		List<WebElement> dropdown_ETATimeMinute;

		// select ETA time in Technician Assign And ETA Details Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)")
		WebElement textbox_ETATimeSecond;

		// select ETA time in Technician Assign And ETA Details Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)>option")
		List<WebElement> dropdown_ETATimeSecond;

		// select Appointment Date in Technician Assign And ETA Details Detail
		// Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(8)>td>div>input")
		WebElement textBox_AppointmentDate;

		// select Appointment Date calendar in Technician Assign And ETA Details
		// Detail Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(8)>td>div>a")
		WebElement button_AppointmentDate;

		// select Appointment Date in Technician Assign And ETA Details Detail
		// Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(10)>td>select")
		WebElement textBox_AppointmentTime;

		// select Appointment Date from ETA and Technician Tab before data enter
		@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
		WebElement label_AppointmentDate;

		// select Appointment time from ETA and Technician Tab before data enter
		@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
		WebElement label_AppointmentTime;

		// select Technician from ETA and Technician Tab before data enter
		@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
		WebElement label_Technician;

		// select ETA Date from ETA and Technician Tab before data enter
		@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(7)")
		WebElement label_ETADate;

		// select ETA Time from ETA and Technician Tab before data enter
		@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(9)")
		WebElement label_ETATime;

		// select requester tab
		@FindBy(css = ".rectagleBoxHeading.aa>a[id='open']>table>tbody>tr")
		WebElement tab_Requestor;

		// select Customer SLA
		@FindBy(css = "div[class='rectagleBoxContent']>div:nth-of-type(1)>div:nth-of-type(2)>div>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(1)>td")
		WebElement tab_CustomerSLA;

		@FindBy(css = "table[class='datePickerTable']>tbody>tr>td")
		List<WebElement> dates_InETACalender;

		// select ETA time in Technician Assign And ETA Details Window
		@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)>option")
		List<WebElement> dropdown_ETATimeHour;

		// Select line element

		// select Ticket Log Time
		@FindBy(css = "div[id='time_spent']>div:nth-of-type(2)>span:nth-of-type(1)")
		WebElement label_TicketLogTime;

		// select ETA Date Time
		@FindBy(css = "div[id='time_spent']>div:nth-of-type(3)>span:nth-of-type(1)")
		WebElement label_ETA;

		// ATA Tab //

		// ATA Tab
		@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(4)>a")
		WebElement tab_ATA;

		// Edit Button in ATA Tab
		@FindBy(css = "img[src='images/close_success.gif']")
		WebElement btnCloseNotification;
		
		// Edit Button in ATA Tab
		@FindBy(css = "div[id='ATA']>div>div:nth-of-type(2)>a")
		WebElement button_EditInATATab;

		// ATA Date in ATA Tab
		@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
		WebElement label_ATADateInATATab;

		// ATA Time in ATA Tab
		@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
		WebElement label_ATATimeInATATab;

		// Machine Available in ATA Tab
		@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
		WebElement label_MachineAvailableInATATab;

		// ATA Details Page //

		// Calendar in ATA Details Page
		@FindBy(css = "div[id='incidentTypeDetails']>div>table>tbody>tr:nth-of-type(2)>td>a")
		WebElement calendar_ATADetailsPage;

		// Day in Calendar in ATA Details Page
		@FindBy(css = "div[id='fd-dp-8']>table>tbody>tr>td")
		List<WebElement> day_CalendarInATADetailsPage;

		// ATA Date in ATA Details Page
		@FindBy(css = "input[id='dp-8']")
		WebElement textbox_ATADateInATADetailsPage;

		// Hrs of ATA Time in ATA Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(1)>option")
		List<WebElement> dropdown_HrsOfATATimeInATADetailsPage;

		// Min of ATA Time in ATA Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)>option")
		List<WebElement> dropdown_MinOfATATimeInATADetailsPage;

		// Machine Available in ATA Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select")
		WebElement dropdown_MachineAvailableInATADetailsPage;

		// Pause Reason Button in ATA Details Page
		@FindBy(css = "a[onclick='selectPauseReason()']")
		WebElement button_PauseReasonInATADetailsPage;

		// Calendar for Auto Resume Date in ATA Details Page
		@FindBy(css = "a[id='fd-but-dp-4']")
		WebElement calendar_AutoResumeDateInATADetailsPage;

		// Day in Calendar for Auto Resume Date in ATA Details Page
		@FindBy(css = "div[id='fd-dp-4']>table>tbody>tr>td")
		List<WebElement> dayInCalendar_AutoResumeDateInATADetailsPage;

		// ATA Date for Auto Resume Date in ATA Details Page
		@FindBy(css = "input[id='dp-4']")
		WebElement textbox_ATADateOfAutoResumeDateInATADetailsPage;

		// Hrs of ATA Time for Auto Resume Date in ATA Details Page
		@FindBy(css = "select[name='m_strResumeTimeHour']>option ")
		List<WebElement> dropdown_HrsOfATATimeOfAutoResumeDateInATADetailsPage;

		// Min of ATA Time for Auto Resume Date in ATA Details Page
		@FindBy(css = "select[name='m_strResumeTimeMinute']>option ")
		List<WebElement> dropdown_MinOfATATimeOfAutoResumeDateInATADetailsPage;

		// Update Details Button in ATA Details Page
		@FindBy(linkText = "Update Details")
		WebElement button_UpdateDetailsInATADetailsPage;

		// List of Pause Reasons Page //

		// List of Name in List of Pause Reasons Page
		@FindBy(css = "div[id='right']>div>table>tbody>tr>td:nth-of-type(2)>a")
		List<WebElement> ListOfName_ListOfPauseReasonsPage;

		// Pause Tab //

		// Pause Tab
		@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(6)>a")
		WebElement tab_PauseInTicketForm;

		// Edit Button in Pause Tab
		@FindBy(css = "div[id='Pause']>div:nth-of-type(2)>a")
		WebElement button_EditInPauseTab;

		// Pause Start Date Time in Pause Tab
		@FindBy(css = "div[id='Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
		WebElement label_PauseStartDateTimeInPauseTab;

		// Pause end Date Time in Pause Tab
		@FindBy(css = "div[id='Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(2)")
		WebElement label_PauseEndDateTimeInPauseTab;

		// Total Pause Time(minutes) in Pause Tab
		@FindBy(css = "div[id='Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
		WebElement label_TotalPauseMinutesInPauseTab;

		// Pause details Page //

		// Calendar in Pause Details Page
		@FindBy(css = "#incidentTypeDetails>div[class='pad10']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
		WebElement calendar_PauseDetailsPage;

		// Day in Calendar in Pause Details Page
		@FindBy(css = ".datePickerTable>tbody>tr>td")
		List<WebElement> day_CalendarInPauseDetailsPage;

		// Auto Resume Date in Pause Details Page
		@FindBy(css = "#incidentTypeDetails>div[class='pad10']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>input")
		WebElement textbox_AutoResumeDateInPauseDetailsPage;

		// Hrs of Auto Resume Time in Pause Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select:nth-of-type(1)>option")
		List<WebElement> dropdown_HrsOfAutoResumeTimeInPauseDetailsPage;

		// Min of Auto Resume Time in Pause Details Page
		@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select:nth-of-type(2)>option")
		List<WebElement> dropdown_MinOfAutoResumeTimeInPauseDetailsPage;

		// Update Details Button in Pause Details Page
		@FindBy(linkText = "Update Details")
		WebElement button_UpdateDetailsInPauseDetailsPage;

		// List of Pause Reasons Page //

		// List of Pause Reasons Button in Pause Page
		@FindBy(css = ".clickOn")
		WebElement button_ListOfPauseReasonsInPausepage;

		// Heading of List of Pause Reasons Page
		@FindBy(css = "div[id='headingText']>span")
		WebElement heading_ListOfPauseReasonsPage;

		// Pause Reasons Column in List of Pause Reasons Page
		@FindBy(css = ".rectagleBox>table>tbody>tr>td:nth-of-type(2)>a")
		List<WebElement> column_PauseReasonsInListOfPauseReasonsPage;

		// Latest Pause Tab //

		// Latest Pause Tab
		@FindBy(linkText = "Latest Pause")
		WebElement tab_LatestPauseInTicketForm;

		// Pause Reason Label
		@FindBy(css = "div[id='Latest-Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
		WebElement label_PauseReasonInLatestPauseTab;

		// Resume Date And Time in Latest Pause Tab
		@FindBy(css = "div[id='Latest-Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(2)")
		WebElement label_ResumeDateAndTimeInLatestPauseTab;

		// Spare Tab //

		// Spare Tab
		@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(8)>a")
		WebElement tab_SpareInTicketForm;

		// Edit Button in Spare Tab
		@FindBy(css = "div[id='Spares']>div>div:nth-of-type(2)>a")
		WebElement button_EditInSpareTab;

		// Part Name in Spare Tab
		@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[2]")
		List<WebElement> label_PartNameInSpareTab;

		// Part code in Spare Tab
		@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[3]")
		List<WebElement> label_PartCodeInSpareTab;

		// Quantity in Spare Tab
		@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[5]")
		List<WebElement> label_QuantityInSpareTab;

		// Location in Spare Tab
		@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[6]")
		List<WebElement> label_LocationInSpareTab;

		// Update symbol in Spare Tab
		@FindBy(css = "a[class='updateBtn']")
		List<WebElement> symbol_UpdateInSpareTab;

		// heading of Update Spare Remark Pop up
		@FindBy(xpath = ".//*[@id='boxsr']/div/table/tbody/tr[1]/th[2]")
		WebElement heading_UpdateSpareRemarkPopup;

		// Text box of Spare Remark in Update Spare Remark Page
		@FindBy(css = "input[name='m_strRemark']")
		WebElement textbox_SpareRemarkInUpdateSpareRemarkPopup;

		// Update Button in Update Spare Remark Page
		@FindBy(css = "a[onclick='UpdateSpareRemark()']")
		WebElement button_UpdateInUpdateSpareRemarkPopup;

		// Spare Remark in Spare Tab
		@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[10]")
		List<WebElement> label_SpareRemarkInSpareTab;

		// Row of Table in Spare Tab
		@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr")
		List<WebElement> row_TableInSpareTab;

		// [With Inventory Module] //

		// Required Spare Tab in Spare Tab
		@FindBy(css = ".modal-content>div>div:nth-of-type(3)>span>a[id='open']")
		WebElement tab_RequiredSpareInSpareTab;

		// Part Name DropDown in Required Spare Tab
		@FindBy(css = "Select[name='m_strReqPartName']")
		WebElement dropdown_PartNameInRequiredSpareTab;

		// List of Part Name DropDown in Required Spare Tab
		@FindBy(css = "Select[name='m_strReqPartName']>option")
		List<WebElement> dropdown__ListOfPartNameInRequiredSpareTab;

		// Part Code DropDown in Required Spare Tab
		@FindBy(css = "select[name='m_strReqPartCode']")
		WebElement dropdown__PartCodeInRequiredSpareTab;

		// Quantity in Required Spare Tab
		@FindBy(css = "input[name='m_strReqPartQty']")
		WebElement textbox__QuantityInRequiredSpareTab;

		// List of Location DropDown in Required Spare Tab
		@FindBy(css = "select[name='m_strSpareDeliverylocation']")
		WebElement dropdown_LocationInRequiredSpareTab;

		// Add button in Required Spare Tab
		@FindBy(css = "a[id='AddRequired']")
		WebElement button_AddInRequiredSpareTab;

		// Remove button in Required Spare Tab
		@FindBy(css = "a[class='removeBtn']")
		List<WebElement> button_RemoveInRequiredSpareTab;

		// [Without Inventory Module] //

		// Title of Spare Details [Without Inventory Module] Page
		@FindBy(css = ".modal-content>div>div>span>a[id='open2']")
		WebElement title_WithoutInventoryModule;

		// Required Spare Tab in Without Inventory Module
		@FindBy(css = ".modal-content>div>div>div:nth-of-type(2)>div:nth-of-type(1)>div>span>a[id='open1']")
		WebElement tab_RequiredSpareInWithoutInventoryModule;

		// Part Name DropDown in Required Spare Tab in Without Inventory Module
		@FindBy(css = "select[name='m_strPartNameNew1']")
		WebElement dropdown_PartNameInRequiredSpareTabInWithoutInventoryModule;

		// List of Part Name DropDown in Required Spare Tab
		@FindBy(css = "select[name='m_strPartNameNew1']>option")
		List<WebElement> dropdown__ListOfPartNameInRequiredSpareTabInWithoutInventoryModule;

		// Part Code DropDown in Required Spare Tab
		@FindBy(css = "select[name='m_strPartCodeNew1']")
		WebElement dropdown__PartCodeInRequiredSpareTabInWithoutInventoryModule;

		// Quantity in Required Spare Tab
		@FindBy(css = "input[name='m_strQuantity1']")
		WebElement textbox__QuantityInRequiredSpareTabInWithoutInventoryModule;

		// Part Description DropDown in Required Spare Tab
		@FindBy(css = "select[name='m_strPartDescription1']")
		WebElement dropdown_LocationInRequiredSpareTabInWithoutInventoryModule;

		// Add button in Required Spare Tab
		@FindBy(css = "a[id='AddRequired']")
		WebElement button_AddInRequiredSpareTabInWithoutInventoryModule;

		// Remove button in Required Spare Tab
		@FindBy(css = "a[class='removeBtn']")
		List<WebElement> button_RemoveInRequiredSpareTabInWithoutInventoryModule;

		// Spare tab

		// select spare tab
		@FindBy(css = "li[class='tab9']>a>span")
		WebElement tab_Spare;

		// select Spares Consumed By Inventory logistic
		@FindBy(name = "m_strSparesConsumed")
		WebElement dropdown_SparesConsumedInSpareTab;

		// margin tab for Add Spare in Spare detail window
		@FindBy(css = "div[id='Spares']>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>div[id='sparesLabel']>div")
		WebElement label_AddSpare;

		// margin tab for Add Spare in Spare detail window
		@FindBy(css = "div[id='Spares']>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>div[id='inventoryreplacedetails']>div")
		WebElement label_ReplaceSpareWith;

		// select list symbol in spare detail window
		@FindBy(css = "div[id='Spares']>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)>img")
		WebElement button_ListSymbolOfSpareDetail;

		// select part name from list of available spare window
		@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(1)")
		List<WebElement> list_PartNameInSpareDetail;

		// select Product Classification from list of available spare window
		@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(3)")
		List<WebElement> list_ProductClassificationInSpareDetail;

		// select Part Type from list of available spare window
		@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(8)")
		List<WebElement> list_PartTypeInSpareDetail;

		// select Transaction Type from list of available spare window
		@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(9)")
		List<WebElement> list_TransactionTypeInSpareDetail;

		// select part name in Add Spare tab
		@FindBy(name = "m_strPartName")
		WebElement textBox_PartName;

		// select Product Classification in Add Spare tab
		@FindBy(name = "m_strProductClassification1")
		WebElement textBox_ProductClassificationInAddSpare;

		// select part Description in Add Spare tab
		@FindBy(name = "m_strPartDescription")
		WebElement textBox_PartDescriptionInAddSpare;

		// select Product Classification in Replace Spare with tab
		@FindBy(name = "m_strReplaceProductClassification")
		WebElement textBox_ProductClassificationInReplaceSpare;

		// select part Description in Replace Spare with tab
		@FindBy(name = "m_strReplacePartDescription")
		WebElement textBox_PartDescriptionInReplaceSpare;

		// select part code in Replace Spare with tab
		@FindBy(name = "m_strReplaceWith1")
		WebElement dropdown_PartCodeInReplaceSpare;

		// select another part code text tab
		@FindBy(css = "select[name='m_strReplacePartCode1']>option")
		List<WebElement> dropdown_ListOfAnotherPartCodeInReplaceSpare;

		// select Replace with another part code
		@FindBy(name = "m_strReplacePartCode1")
		WebElement dropdown_AnotherPartCodeInReplaceSpare;

		// select part name in Add Spare tab
		@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(10)")
		WebElement lable_TransactionTypeOfSapre;

		// select serial number in Add Spare tab
		@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(5)")
		WebElement lable_SerialNumberOfSapre;

		// select list of serial number in Add Spare tab
		@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
		List<WebElement> list_SerialNumberOfSapre;

		// select list of serial number in Add Spare tab
		@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(10)")
		List<WebElement> list_TransactionTypeOfSapre;

		// select list of serial number in Add Spare tab
		@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(11)")
		List<WebElement> list_StatusOfSapre;

		// select Replace with another part code
		@FindBy(name = "m_strReplaceStatus")
		WebElement dropdown_Status;

		// Remark Tab //

		// Remark Tab
		/*
		 * @FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(10)>a")
		 * 
		 * WebElement tab_RemarkInTicketForm;
		 */

		@FindBy(linkText = "Remarks")
		WebElement tab_RemarkInTicketForm;

		// Add Remark Button in Remark Tab
		/*
		 * @FindBy(css = "a[onclick='addRemarks()']")
		 * 
		 * WebElement button_AddRemarkInRemarkTab;
		 */

		@FindBy(linkText = "Add Remark")
		WebElement button_AddRemarkInRemarkTab;

		// Row in Remark Tab
		@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr")
		List<WebElement> row_TableInRemarkTab;

		// Remark in Remark Tab
		@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr/td[1]")
		List<WebElement> label_RemarkInRemarkTab;

		// Remark By in Remark Tab
		@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr/td[5]")
		List<WebElement> label_RemarkByInRemarkTab;

		// select the heading of add remark window
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
		WebElement label_AddRemark;

		// select remark text box
		@FindBy(css = "textarea[name='m_strRemarkValue']")
		WebElement textbox_Remark;

		@FindBy(name = "m_strVisibilty")
		WebElement dropdown_Visibility;

		// Activities tab

		// select Activities tab
		@FindBy(css = "li[class='tab11']>a>span")
		WebElement tab_Activities;

		// select Add Remark button of activities Tab
		@FindBy(css = "div[id='Activities']>div:nth-of-type(2)>a>span")
		WebElement button_AddActivityOfActivities;

		// select Add Remark button of activities Tab
		@FindBy(xpath = ".//*[@id='boxActivity']/div/table/tbody/tr[1]/th[2]")
		WebElement lable_AddActivityWindow;

		// select submit button
		@FindBy(linkText = "Submit")
		WebElement button_Submit;

		// select Activity
		@FindBy(name = "m_strActivity")
		WebElement dropdown_Activity;

		// select Activity Status
		@FindBy(name = "m_strActivityStatus")
		WebElement dropdown_ActivityStatus;

		// Select Details
		@FindBy(name = "m_strActivityDetail")
		WebElement textbox_ActivityDetail;

		// select date from activities Tab
		@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[5]")
		List<WebElement> list_DateOfActivities;

		// select date from activities Tab
		@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[6]")
		List<WebElement> list_TimeOfActivities;

		// VCT Tab //

		// VCT Tab
		@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(12)>a")
		WebElement tab_VCTInTicketForm;

		// Heading of VCT Tab
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[1]")
		WebElement heading_VCTTab;

		// Row in VCT Tab
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr")
		List<WebElement> row_TableInVCTTab;

		// button Create PO in VCT Tab
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/table/tbody/tr/td[1]/a/span")
		WebElement button_CreatePOInVCTTab;

		// button Show Email Log in VCT Tab
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/table/tbody/tr/td[2]/a/span")
		WebElement button_ShowEmailLogInVCTTab;

		// PO No Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[1]")
		List<WebElement> label_PONOInPOTab;

		// PO Date Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[2]")
		List<WebElement> label_PODateInPOTab;

		// Service Charges Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[3]")
		List<WebElement> label_ServiceChargesInPOTab;

		// Product Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[4]")
		List<WebElement> label_ProductInPOTab;

		// Title Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[5]")
		List<WebElement> label_TitleInPOTab;

		// Category Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[6]")
		List<WebElement> label_CategoryInPOTab;

		// Description Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[7]")
		List<WebElement> label_DescriptionInPOTab;

		// Km Travelled Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[8]")
		List<WebElement> label_KmTravelledInPOTab;

		// Amount Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[9]")
		List<WebElement> label_AmountInVCTTab;

		// Vendor Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[10]")
		List<WebElement> label_VendorInPOTab;

		// Status Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[11]")
		List<WebElement> label_StatusInPOTab;

		// To Email Id Label
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[12]")
		List<WebElement> label_ToEmailIdInPOTab;

		// Edit Link
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[13]")
		List<WebElement> link_EditInPOTab;

		// Print Link
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[14]")
		List<WebElement> link_PrintInPOTab;

		// Send Mail Link
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[15]")
		List<WebElement> link_SendMailInPOTab;

		// Vendor Commercial PO Details Pop up //

		// Heading of Vendor Commercial PO Details Pop up
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
		WebElement heading_VendorCommercialPODetailsPopup;

		// PO No Text box
		@FindBy(css = "input[name='m_strCommercialPONO']")
		WebElement textbox_PONOInVCTTab;

		// PO Date Text box
		@FindBy(css = "input[id='dp-10']")
		WebElement textbox_PODateInVCTTab;

		// Service Charges Text box
		@FindBy(css = "input[name='m_strPoServiceCharges']")
		WebElement textbox_ServiceChargesInVCTTab;

		// Product Text box
		@FindBy(css = "input[name='m_strPoProduct']")
		WebElement textbox_ProductInVCTTab;

		// Title Text box
		@FindBy(css = "input[name='m_strPoTitle']")
		WebElement textbox_TitleInVCTTab;

		// Category Text box
		@FindBy(css = "input[name='m_strPoCategory']")
		WebElement textbox_CategoryInVCTTab;

		// Quantity Text box
		@FindBy(css = "input[name='m_strPOQuantity']")
		WebElement textbox_QuantityInVCTTab;

		// Description Text box
		@FindBy(css = "textarea[name='m_strPoDescription']")
		WebElement textbox_DescriptionInVCTTab;

		// Km Travelled Text box
		@FindBy(css = "input[name='m_strPoKmTravelled']")
		WebElement textbox_KmTravelledInVCTTab;

		// Vendor Drop down
		@FindBy(css = "select[name='m_strVendor']")
		WebElement dropdown_VendorInVCTTab;

		// Status Drop down
		@FindBy(css = "select[name='m_strPaymentStatus']")
		WebElement dropdown_StatusInVCTTab;

		// Rate Text box
		@FindBy(css = "input[name='m_strPORate']")
		WebElement textbox_RateInVCTTab;

		// Amount Text box
		@FindBy(css = "input[name='m_strCommercialAmount']")
		WebElement textbox_AmountInVCTTab;

		// To Email Id Text box
		@FindBy(css = "textarea[name='m_strPOToMailId']")
		WebElement textbox_ToEmailIdInVCTTab;

		// button Submit in Vendor Commercial PO Details Pop up
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[2]/a[1]/span")
		WebElement button_SubmitInCommercialPODetailsPopup;

		// List of Sent Mails Page //

		// Row in List of Sent Mails Page
		@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr")
		List<WebElement> row_TableInListOfSentMailsPage;

		// Send To Label
		@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr/td[4]")
		List<WebElement> label_SendToListOfSentMailsPage;

		// VCT Tab

		// select VCT tab
		@FindBy(css = "li[class='tab12']>a>span")
		WebElement tab_VCT;

		// select update payment button in VCT TAB
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[2]/table/tbody/tr/td/a/span")
		WebElement button_UpdatePayment;

		// select Invoice Number text box
		@FindBy(name = "m_strVendorCommercialInvNO")
		WebElement textbox_InvoiceNumber;

		// select amount text box
		@FindBy(name = "m_strVendorCommercialInvAmount")
		WebElement textbox_Amount;

		// select TSD Amount text box
		@FindBy(name = "m_strVendorCommercialTDSAmount")
		WebElement textbox_TSDAmount;

		// select Total Amount text box
		@FindBy(name = "m_strVendorCommercialTotalAmount")
		WebElement textbox_TotalAmount;

		// select Total Amount text box
		@FindBy(name = "m_strVendorCommercialInvReferenceCode")
		WebElement textbox_ReferenceCode;

		// select Mode in update payment-> Vendor Commercial Payment Details window
		@FindBy(name = "m_strPaymentMode")
		WebElement dropdown_Mode;

		// select Mode in update payment-> Vendor Commercial Payment Details window
		@FindBy(name = "m_strPaymentStatus")
		WebElement dropdown_StatusOfUpdatePayment;

		// Browse file button
		@FindBy(name = "m_strVendorCommercialPaymentFile")
		WebElement button_BrowseUpdatePayment;

		// select list of Edit in update payment
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr/td[8]/a/span")
		List<WebElement> list_EditInUpdatePayment;

		// select list Attachment In Update Payment
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr/td[9]/a/span")
		List<WebElement> list_AttachmentInUpdatePayment;

		// select list Attachment In Update Payment
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr/td[10]")
		List<WebElement> list_StatusInUpdatePayment;

		// take list of update payment detail whole row data
		@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr")
		List<WebElement> list_CompleteDataInUpdatePayment;

		// take list of "List Of Attachment " window
		@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr[2]/td[2]")
		List<WebElement> list_ListOfAttachment;

		// select the submit button
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[2]/div/a[1]/span")
		WebElement button_SubmitAndUpdateDetailOfVendorCommercialPaymentDetails;

		// Technician Close Tab //

		// Technician Tab
		@FindBy(css = "a[title='Technician-close']")
		WebElement tab_TechnicianClose;

		// select Spares Consumed By Inventory logistic
		@FindBy(name = "m_strSparesConsumed")
		WebElement dropdown_SparesConsumed;

		// select Edit Button On TechncianClose Tab
		@FindBy(css = "div[id='Technician-close']>div>div>a>span")
		WebElement button_EditOfTechncianClose;

		// submitTechCloseDetails button
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div/a[1]/span")
		WebElement button_submitTechCloseDetails;

		// Calendar in Technician Close Page
		@FindBy(css = "div[id='incidentTypeDetails']>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td>a")
		WebElement calendar_TechnicianClosePage;

		// Day in Calendar in Technician Close Page
		@FindBy(css = ".datePickerTable>tbody>tr>td")
		List<WebElement> day_CalendarInTechnicianClosePage;

		// Hrs of Auto Resume Time in Technician Close Page
		@FindBy(css = "select[name='m_strTechcloseTimemHour']>option")
		List<WebElement> dropdown_HrsOfTechnicianCloseTime;

		// Min of Auto Resume Time in Technician Close Page
		@FindBy(css = "select[name='m_strTechcloseTimemMinute']>option")
		List<WebElement> dropdown_MinOfTechnicianCloseTime;

		// Enter Resolution
		@FindBy(name = "m_strResolution")
		WebElement textbox_ResolutionInTechnicianClose;

		// Enter Resolution Description
		@FindBy(name = "m_strResolutionDescription")
		WebElement textbox_ResolutionDescriptionInTechnicianClose;

		// Enter FSR No
		@FindBy(name = "m_strResolutionParameter7")
		WebElement textbox_FSRNoInTechnicianClose;

		// Technician close tab

		// serial number Message
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr/td[1]/table/tbody/tr[21]/td/strong")
		WebElement message_SerialNumber;

		// select serial number
		@FindBy(xpath = ".//*[@id='Technician-close']/div/div[2]/table/tbody/tr/td[1]/table/tbody/tr[9]/td")
		WebElement label_SerialNumber;

		// select generate PDF button
		@FindBy(xpath = ".//*[@id='headingText']/ul/li[3]/ul/a")
		WebElement button_GeneratePDF;

		// select serial number field
		@FindBy(name = "m_strResolutionParameter6")
		WebElement textbox_SerialNumberInTechClose;

		// select technician close time
		@FindBy(css = "div[id='final_close']>span:nth-of-type(1)")
		WebElement label_TechnicianCloseTime;

		// Cancel Ticket Tab

		// select cancel ticket tab
		@FindBy(css = "li[class='tab16']>a>span")
		WebElement tab_CancelTicket;

		// select Cancel Ticket Tab
		@FindBy(css = "div[id='TicketCancel']>div:nth-of-type(2)>a>span")
		WebElement button_CancelTicket;

		// select Resolution text box
		@FindBy(name = "m_strCancelTicketResolution")
		WebElement textbox_Resolution;

		// select Cancel Reason text box
		@FindBy(name = "m_strCancelTicketResolutionDescription")
		WebElement textbox_CancelReason;

		// select Cancel Ticket button of Cancel Ticket Details Window
		@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/div[2]/div/a[1]/span")
		WebElement button_CancelTicketInCancelTicketDetails;

		// select Cancel Ticket button of Cancel Ticket Details Window
		@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/div[2]/div/a[2]/span")
		WebElement button_CancelInCancelTicketDetails;

		// close button of the pop up window
		@FindBy(xpath = ".//*[@id='boxActivity']/div/table/tbody/tr[1]/th[3]/img")
		WebElement button_ClosePopUp;

		// final close
		// select close button
		@FindBy(linkText = "Close")
		WebElement button_Close;

		// select Final Close Details window name
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
		WebElement lable_FinalCloseDetailsWindow;

		// select close date text box
		@FindBy(name = "m_strCloseDate")
		WebElement textbox_CloseDate;

		// select close time hour
		@FindBy(name = "m_strCloseTimeHour")
		WebElement dropdown_CloseTimeHour;

		// select close time hour
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[4]/td/select[1]/option")
		List<WebElement> dropdown_CloseTimeHourValue;

		// select close time hour
		@FindBy(name = "m_strCloseTimeMinute")
		WebElement dropdown_CloseTimeMinute;

		// select close time hour
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[4]/td/select[2]/option")
		List<WebElement> dropdown_CloseTimeMinuteValue;

		// select close date calendar button
		@FindBy(css = "div[id='incidentTypeDetails']>table>tbody>tr:nth-of-type(2)>td>a")
		WebElement symbol_CloseDateCalender;

		// get the serial number from final close detail
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[6]/td")
		WebElement textbox_SerialNumber;

		// select Update Serial No For this Asset: field
		@FindBy(name = "m_strCloseSerialNo")
		WebElement textbox_UpdateSerialNo;

		// KEDB Tab
		// Select KEDB Tab
		@FindBy(css = "li[class='tab15']>a>span")
		WebElement tab_KEDB;

		// Select Add KEDB Tab
		@FindBy(css = "div[id='KEDB']>a>span")
		WebElement button_AddKEDB;

		// select KEDB Details window name
		@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/span")
		WebElement label_KEDBDetailsWindow;

		// select Known Error
		@FindBy(name = "m_strKnownError")
		WebElement textbox_KnownError;

		// select Work around details
		@FindBy(name = "m_strWorkAroundDetails")
		WebElement textbox_WorkArroundDetail;

		// select solution text box
		@FindBy(name = "m_strSolution")
		WebElement textbox_Solution;

		// select Add KEDB
		@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/div[2]/div/a[1]/span")
		WebElement button_AddKEDBInKEDBDetails;

		// CCT TAB

		// select CCT Tab
		@FindBy(css = "li[class='tab13']>a>span")
		WebElement tab_CCT;

		// select create PI button
		@FindBy(xpath = ".//*[@id='Payment-closed']/div[1]/table/tbody/tr/td[1]/a/span")
		WebElement button_CreatePI;

		// select Customer Commercial Proforma Details window
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
		WebElement labal_CustomerCommercialProformaDetailsPopUp;

		// Create Sub Ticket
		// select CCT Tab
		@FindBy(linkText = "Create Sub Ticket")
		WebElement tab_CreateSubTicket;

		@FindBy(linkText = "View Sub-Ticket")
		WebElement tab_ViewSubTicket;

		// heading of ticket form
		@FindBy(xpath = ".//*[@id='headingText']/span")
		WebElement label_OfHeading;

		// Select Record Ticket Button
		@FindBy(linkText = "Record Sub Ticket")
		WebElement button_RecordSubTicket;

		// select list of state in view sub ticket table
		@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(3)")
		List<WebElement> list_StateInViewSubTicketTable;

		// select list of status in view sub ticket table
		@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(6)")
		List<WebElement> list_StatusInViewSubTicketTable;

		// select list of status in view sub ticket table
		@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(26)")
		List<WebElement> list_TicketTypeInViewSubTicketTable;

		// select list of status in view sub ticket table
		@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(1)")
		List<WebElement> list_CustomerInViewSubTicketTable;

		// select ETA in sub ticket
		@FindBy(css = "li[class='tab6']>a>span")
		WebElement tab_ETAInSubTicket;

		// select ATA in sub ticket
		@FindBy(css = "li[class='tab7']>a>span")
		WebElement tab_ATAInSubTicket;

		// select ATA in sub ticket
		@FindBy(css = "li[class='tab10']>a>span")
		WebElement tab_TechnitianCloseInSubTicket;

		// select id in sub ticket
		@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr[2]/td[1]/div/table/tbody/tr")
		List<WebElement> list_IDInViewSubTicketTable;

		// select ParentTicketID in sub ticket
		@FindBy(css = ".borLftNone.padLftNone>span:nth-of-type(2)")
		WebElement label_ParentTicketIDInSubTicket;

		// Initializing Page Object
		public RM_EditIncidentPage() {
			PageFactory.initElements(driver, this);
		}

		// Display Request/ Incident Tab
		public void verifyRequestorOrIncidentTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				List<WebElement> status = list_StatusInTable;
				int size = status.size();
				System.out.println(size);

				for (int i = 0; i < status.size(); i++) {
					String statusValue = status.get(i).getText();
					System.out.println(statusValue);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					String flag = list_FlagOfIncorrectCustomerAddressInTable.get(i)
							.getAttribute("alt");
					System.out.println("Flag:" + flag);

					if (statusValue.equalsIgnoreCase("Open")
							&& flag.equalsIgnoreCase("Violated") && ETA.equals("")
							&& ATA.equals(""))

					{

						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();

						// Get text of Request/ Incident Tab
						String requestOrIncidentTab = driver.findElement(
								By.cssSelector(" .tab1.active>a>span")).getText();

						// Print text of Request/ Incident Tab
						System.out.println("Tab Name: " + requestOrIncidentTab);

						// Check text of Request/ Incident Tab is match or not
						softAssert.assertEquals(requestOrIncidentTab,
								"Requestor / Incident", "Tab is not correct");

						break loop;

					}
				}
				if (sizePagination - 1 == p) {
					Assert.assertTrue(false, " Ticket is not Available");
				}
			}
			softAssert.assertAll();
		}

		// Compare Id Of Requester/ Incident Tab
		public void compareIdOfRequesterOrIncidentTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			Thread.sleep(1000);
			// Get Incident ID
			String getIncidentIdValue = textbox_IncidenID.getText();
			// System.out.println(getIncidentIdValue);
			String split = getIncidentIdValue.split(" ")[2];
			// System.out.println(split);
			String incidentID1 = split.split("Status")[0];
			// Remove beginning & Ending Space
			String incidentID = incidentID1.trim();
			// Print Incident Id
			System.out.println("incidentID: " + incidentID);

			// Click on Request/ Incident Tab
			driver.findElement(By.cssSelector(" .tab1.active>a>span")).click();

			// Get Ticket Id in Request/ Incident Tab
			String ticketId = driver.findElement(
					By.cssSelector("#open>table>tbody>tr>td:nth-of-type(1)"))
					.getText();
			String splitTicketId = ticketId.split(" ")[2];
			System.out.println("splitTicketId: " + splitTicketId);

			// Verify Incident ID
			softAssert.assertEquals(splitTicketId, incidentID, "Id are not same");

			softAssert.assertAll();

		}

		// If user click on Customer name hyper link in Requester tab, then
		// 'Incident History of Customer :- (Customer Name)' page should display
		public void checkIncidentHistoryOfCustomerPage() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			for (String Window : driver.getWindowHandles()) {

				driver.switchTo().window(Window);

				// Get Customer Name in Requester Table
				String customerName = label_CustomerNameInRequesterTab.getText();
				System.out.println("Customer Name: " + customerName);

				Thread.sleep(1000);
				// driver.findElement(By.linkText(customerName)).click();
				label_CustomerNameInRequesterTab.click();

				for (String technicianWindow1 : driver.getWindowHandles()) {

					driver.switchTo().window(technicianWindow1);

				}
				boolean headingIsPresent;
				String headingInIncidentHistoryOfCustomerPage = heading_IncidentHistoryPage
						.getText();
				System.out.println(headingInIncidentHistoryOfCustomerPage);
				if (headingInIncidentHistoryOfCustomerPage
						.contains("Incident History of Customer")) {
					System.out.println("Pass");
					headingIsPresent = true;

				} else {
					System.out.println("Fail");
					headingIsPresent = false;
				}

				softAssert.assertTrue(headingIsPresent, "'Heading is not Same.'");
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");

				driver.switchTo().window(Window);
			}
			softAssert.assertAll();
		}

		// If user click on Asset ID hyper link in Requester tab, then 'Incident
		// History of Asset ID :- (Asset ID)' page should display
		public void checkIncidentHistoryOfAssetIdPage() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			for (String Window : driver.getWindowHandles()) {

				driver.switchTo().window(Window);

				// Click on Requester Tab For Open
				tab_RequestorForCloseInRequesterTab.click();
				Thread.sleep(1000);
				// Get Asset Id in Requester Table
				String assetId = label_AssetIdInRequesterTab.getText();
				System.out.println("Asset Id: " + assetId);

				Thread.sleep(1000);
				label_AssetIdInRequesterTab.click();

				for (String technicianWindow1 : driver.getWindowHandles()) {

					driver.switchTo().window(technicianWindow1);

				}
				boolean headingIsPresent;
				String headingInIncidentHistoryOfAssetIdPage = heading_IncidentHistoryPage
						.getText();
				System.out.println(headingInIncidentHistoryOfAssetIdPage);
				if (headingInIncidentHistoryOfAssetIdPage
						.contains("Incident History of Asset ID")) {
					System.out.println("Pass");
					headingIsPresent = true;

				} else {
					System.out.println("Fail");
					headingIsPresent = false;
				}

				softAssert.assertTrue(headingIsPresent, "'Heading is not Same.'");
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");

				driver.switchTo().window(Window);
			}
			softAssert.assertAll();
		}

		// Check Serial No Hyper link in Requester tab & Serial No. Life Cycle Page
		// open or not
		public void checkSerialNoHyperlinkInRequesterTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			for (String Window : driver.getWindowHandles()) {

				driver.switchTo().window(Window);

				// Click on Requester Tab For Open
				// tab_RequestorForOpenInRequesterTab.click();

				// Get Serial No in Requester Table
				Thread.sleep(500);
				String serialNo = label_SerialNoInRequesterTab.getText();
				System.out.println("ID: " + serialNo);
				boolean hyperlinkIsPresent = driver.findElement(
						By.linkText(serialNo)).isDisplayed();
				System.out
						.println("Hyperlink of ID	present: " + hyperlinkIsPresent);

				softAssert.assertTrue(hyperlinkIsPresent,
						"'Hyperlink is not Present.'");

				driver.findElement(By.linkText(serialNo)).click();

				for (String technicianWindow1 : driver.getWindowHandles()) {

					driver.switchTo().window(technicianWindow1);

				}
				Thread.sleep(2000);
				String serialNoTitle = driver.getTitle();
				System.out.println(serialNoTitle);

				softAssert.assertEquals("Serial No. Life Cycle", serialNoTitle,
						"Title is not Same.");
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");

				driver.switchTo().window(Window);

			}
			softAssert.assertAll();
		}

		// If User click on edit button of Incident details then ticket detail pop
		// up should display to update all ticket details
		// This Test Case required Edit button is enable. Not Technician close.
		public void displayTicketDetailsPopup() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// tab_Requestor.click();
			// Click on Requester Tab For Open
			// tab_RequestorForCloseInRequesterTab.click();
			// driver.navigate().back();

			// Thread.sleep(1000);
			// driver.navigate().forward();

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_EditInIncidentDetailsTab);
			Thread.sleep(1000);
			// Click on Edit button
			button_EditInIncidentDetailsTab.click();

			// Get the Title of Ticket Details Window
			String TitleOfTicketDetailsPopup = title_TicketDetailsPopup.getText();
			System.out.println(TitleOfTicketDetailsPopup);

			softAssert.assertEquals("Ticket Details", TitleOfTicketDetailsPopup,
					"Pop-up is not same");
			softAssert.assertAll();

		}

		// Check Updated Ticket details
		// This Test Case required Edit button is enable. Not Technician close.
		public void checkUpdatedTicketDetails() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Select Ticket Type
			Select ticketTypeDropDown = new Select(
					dropdown_TicketTypeInTicketDetailsPopup);
			// Value of Ticket Type
			String ticketTypeValue = "Soft Call";
			// Select Value of Ticket Type
			ticketTypeDropDown.selectByVisibleText(ticketTypeValue);

			// Select Mode
			Select modeDropDown = new Select(dropdown_ModeInTicketDetailsPopup);
			// Value of Mode
			String modeValue = "M1";
			// Select Value of Mode
			modeDropDown.selectByVisibleText(modeValue);

			// Select Level
			Select levelDropDown = new Select(dropdown_LevelInTicketDetailsPopup);
			// Value of Level
			String levelValue = "Level1";
			// Select Value of Level
			levelDropDown.selectByVisibleText(levelValue);

			// Select CTS
			Select CTSDropDown = new Select(dropdown_CTSInTicketDetailsPopup);
			// Value of CTS
			String CTSValue = "Open";
			// Select Value of CTS
			CTSDropDown.selectByVisibleText(CTSValue);

			// Value of Amount
			String amountValue = "1000";
			textbox_AmountInTicketDetailsPopup.clear();
			// Enter Value of Amount
			textbox_AmountInTicketDetailsPopup.sendKeys(amountValue);

			// Select Urgency
			Select urgencyDropDown = new Select(
					dropdown_UrgencyInTicketDetailsPopup);
			// Value of Urgency
			String UrgencyValue = "U1";
			// Select Value of Urgency
			urgencyDropDown.selectByVisibleText(UrgencyValue);

			// Select Trouble Category
			Select troubleCategoryDropDown = new Select(
					dropdown_TroubleCategoryInTicketDetailsPopup);
			// Value of Trouble Category
			String troubleCategoryValue = "MC";
			// Select Value of Trouble Category
			troubleCategoryDropDown.selectByVisibleText(troubleCategoryValue);

			// Value of Local Contact
			String localContactValue = "Swati";
			textbox_LocalContactInTicketDetailsPopup.clear();
			// Enter Value of Local Contact
			textbox_LocalContactInTicketDetailsPopup.sendKeys(localContactValue);

			// Value of Local Contact No
			String localContactNoValue = "8975537588";
			textbox_LocalContactNoInTicketDetailsPopup.clear();
			// Enter Value of Local Contact No
			textbox_LocalContactNoInTicketDetailsPopup
					.sendKeys(localContactNoValue);

			// Value of Customer Email ID
			String customerEmailIDValue = "Swa@gmail.com";
			textbox_CustomerEmailIDInTicketDetailsPopup.clear();
			// Enter Value of Customer Email ID
			textbox_CustomerEmailIDInTicketDetailsPopup
					.sendKeys(customerEmailIDValue);

			// Value of Date
			button_TofDateInTicketDetailsPopup.click();
			String dateValue = textbox_DateInTicketDetailsPopup
					.getAttribute("value");
			System.out.println(dateValue);

			// Select Time
			Select HrsOfTimeDropDown = new Select(
					dropdown_HrsOfTimeInTicketDetailsPopup);
			Select MinOfTimeDropDown = new Select(
					dropdown_MinOfTimeInTicketDetailsPopup);
			// Value of Time
			String HrsOfTimeValue = "11";
			String MinOfTimeValue = "11";

			// Select Value of Time
			HrsOfTimeDropDown.selectByVisibleText(HrsOfTimeValue);
			MinOfTimeDropDown.selectByVisibleText(MinOfTimeValue);

			String timeValue = HrsOfTimeValue.concat(" : " + MinOfTimeValue);
			System.out.println(timeValue);

			// Click on Update Details Button
			button_UpdateDetailsInTicketDetailsPopup.click();
			Thread.sleep(5000);

			// Get Value of Ticket Type
			String textOfIncidentType = label_IncidentTypeInIncidentDetailsTab
					.getText();
			String incidentType = textOfIncidentType.split("Incident type ")[1];
			System.out.println(incidentType);

			// Get Value of Mode
			String textOfMode = label_ModeInIncidentDetailsTab.getText();
			String mode = textOfMode.split("Mode ")[1];
			System.out.println(mode);

			// Get Value of Level
			String textOfLevel = label_LevelInIncidentDetailsTab.getText();
			String level = textOfLevel.split("Level ")[1];
			System.out.println(level);

			// Get Value of CTS
			String textOfCTS = label_CTSInIncidentDetailsTab.getText();
			String CTS = textOfCTS.split("CTS ")[1];
			System.out.println(CTS);

			// Get Value of Amount
			String textOfAmount = label_AmountInIncidentDetailsTab.getText();
			String amount = textOfAmount.split("Amount : ")[1];
			System.out.println(amount);

			// Get Value of Urgency
			String textOfUrgency = label_UrgencyInIncidentDetailsTab.getText();
			String urgency = textOfUrgency.split("Urgency ")[1];
			System.out.println(urgency);

			// Get Value of Trouble Category
			String textOfTroubleCategory = label_TroubleCategoryInIncidentDetailsTab
					.getText();
			String troubleCategory = textOfTroubleCategory
					.split("Trouble Category :")[1];
			System.out.println(troubleCategory);

			// Get Value of Local Contact
			String textOfLocalContact = label_LocalContactInIncidentDetailsTab
					.getText();
			String localContact = textOfLocalContact.split("Local Contact ")[0];
			System.out.println(localContact);

			// Get Value of Local Contact No
			String textOfLocalContactNo = label_LocalContactNoInIncidentDetailsTab
					.getText();
			String localContactNo = textOfLocalContactNo.split("Local Contact No ")[0];
			System.out.println(localContactNo);

			// Get Value of Customer Email ID
			String textOfCustomerEmailID = label_CustomerEmailIDInIncidentDetailsTab
					.getText();
			String customerEmailID = textOfCustomerEmailID
					.split("Customer Email ID ")[0];
			System.out.println(customerEmailID);

			// Get Value of Date
			String textOfDate = label_DateInIncidentDetailsTab.getText();
			String date = textOfDate.split("Date:")[1];
			System.out.println(date);

			// Get Value of Time
			String textOfTime = label_TimeInIncidentDetailsTab.getText();
			String time = textOfTime.split("Time ")[1];
			System.out.println(time);

			softAssert.assertEquals(ticketTypeValue, incidentType,
					"Ticket Type is not same");
			softAssert.assertEquals(modeValue, mode, "Mode is not same");
			softAssert.assertEquals(levelValue, level, "Level is not same");
			softAssert.assertEquals(CTSValue, CTS, "CTS is not same");
			softAssert.assertEquals(amountValue, amount, "Amount is not same");
			softAssert.assertEquals(UrgencyValue, urgency, "Urgency is not same");
			softAssert.assertEquals(troubleCategoryValue, troubleCategory,
					"Trouble Category is not same");
			softAssert.assertEquals(localContactValue, localContact,
					"Local Contact is not same");
			softAssert.assertEquals(customerEmailIDValue, customerEmailID,
					"Customer Email ID is not same");
			softAssert.assertEquals(dateValue, date, "Date is not same");
			softAssert.assertEquals(timeValue, time, "Time is not same");

			softAssert.assertAll();

		}

		public void displayPopupForEnterAddress() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// tab_RequestorForOpenInRequesterTab.click();

			try {
				// Click on incorrect Address
				driver.findElement(By.cssSelector(".incorrect-address")).click();

				Thread.sleep(1000);

				Alert alert = driver.switchTo().alert();

				// Get Alert message
				String alertMsg = alert.getText();
				System.out.println(alertMsg);

				softAssert.assertEquals(alertMsg, "Enter the Customer Address ",
						"Alert Message is not Match");

			} catch (Exception e) {

				softAssert.assertTrue(false,
						" Incorrect Address link is not Present.");

			}
			softAssert.assertAll();
		}

		// Override Customer Address
		// For this Test Case required "Incorrect Address" Link
		public void overrideCustomerAddress() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			String addressValue = "abc";
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(addressValue);
			System.out.println("Alert Text:" + addressValue);
			alert.accept();
			driver.switchTo().defaultContent();

			Thread.sleep(1000);
			// Click on Requester Tab For Open
			tab_RequestorForOpenInRequesterTab.click();

			Thread.sleep(1000);
			String CustomerAddress = label_CustomerAddressInRequesterTab.getText();
			System.out.println(CustomerAddress);
		//	String address = CustomerAddress.split("Customer Address :")[1];
		//	System.out.println(address);

			softAssert.assertEquals(addressValue, CustomerAddress,
					"Override Address is not same");
			softAssert.assertAll();

		}

		// Check Upload File button without File in File attachments Tab
		public void checkNotificationWithoutFileType() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// click on that ID
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_UploadFileInFileAttachmentsTab);

			// Click Upload File Button
			button_UploadFileInFileAttachmentsTab.click();
			Alert alert = driver.switchTo().alert();

			// Get Alert message
			String alertMsg = alert.getText();
			Thread.sleep(1000);
			System.out.println(alertMsg);
			alert.accept();

			softAssert.assertEquals(alertMsg, "Please Select File Type First.",
					"Alert Message is not Match");

			Thread.sleep(1000);
			/*
			 * driver.findElement(
			 * By.cssSelector(".home>a[href='/erprmwise/SDHomeScreen.do']"))
			 * .click();
			 */
			softAssert.assertAll();

		}

		// Check Upload File button without File in File attachments Tab
		public void checkNotificationWithoutFile() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			Thread.sleep(2000);
			// click on that ID
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_UploadFileInFileAttachmentsTab);

			// Select File Type
			Select fileTypeDropDown = new Select(
					dropdown_FileTypeInFileAttachmentsTab);
			// Value of File Type
			String fileTypeValue = "Customer Approval";
			// Select Value of File Type
			fileTypeDropDown.selectByVisibleText(fileTypeValue);

			// Click Upload File Button
			button_UploadFileInFileAttachmentsTab.click();
			Alert alert = driver.switchTo().alert();

			// Get Alert message
			String alertMsg = alert.getText();
			Thread.sleep(1000);
			System.out.println(alertMsg);
			alert.accept();

			softAssert.assertEquals(alertMsg, "Please Select File First.",
					"Alert Message is not Match");

			/*
			 * Thread.sleep(1000); driver.findElement(
			 * By.cssSelector(".home>a[href='/erprmwise/SDHomeScreen.do']"))
			 * .click();
			 */
			softAssert.assertAll();

		}

		// Check Upload File button with File in File attachments Tab
		public void checkNotificationAfterUploadFile() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Select File Type
			Select fileTypeDropDown = new Select(
					dropdown_FileTypeInFileAttachmentsTab);
			// Value of File Type
			String fileTypeValue = "Customer Approval";
			// Select Value of File Type
			fileTypeDropDown.selectByVisibleText(fileTypeValue);

			// Enter File Path
			button_BrowseInFileAttachmentsTab
					.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");

			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// Click Upload File Button
			button_UploadFileInFileAttachmentsTab.click();

			// Get Notification
			Thread.sleep(5000);
			String notificationText = notification.getText();
			System.out.println(notificationText);

			softAssert.assertEquals(notificationText,
					"File Uploaded Successfully...!", "Notification is not Match");
			Thread.sleep(1000);

			softAssert.assertAll();

		}

		// Display list of file Page when we click on View Attachment button
		public void verifyListOfFilePage() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			for (String listOfFileWindow : driver.getWindowHandles()) {
				driver.switchTo().window(listOfFileWindow);

				button_ViewAttachmentsInFileAttachmentsTab.click();

				for (String listOfFileWindow1 : driver.getWindowHandles()) {
					driver.switchTo().window(listOfFileWindow1);
				}

				String HeadingOfListOfFilesPage = heading_ListOfFilesPage.getText();
				System.out.println(HeadingOfListOfFilesPage);

				softAssert.assertEquals(HeadingOfListOfFilesPage, "List of Files",
						"Page is not same");

				softAssert.assertAll();
				// driver.manage().window().maximize();
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");

				driver.switchTo().window(listOfFileWindow);

			}

		}

		// Preliminary Analysis//

		// preliminary Analysis tab

		// After click on Edit option In preliminary Analysis Tab TSD Assign Details
		// should display

		public void verifyTSDAssignDetailsPopup() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on Preliminary Analysis Tab
			tab_PreliminaryAnalysis.click();

			// click on Edit button
			button_EditOfPreliminaryAnalysis.click();

			// get the message from TSD Assign Details window
			// window handler

			for (String tsdAssignDetailsWindow : driver.getWindowHandles()) {

				System.out.println(tsdAssignDetailsWindow);
				driver.switchTo().window(tsdAssignDetailsWindow);

			}

			String textOftsdAssignDetails = driver.findElement(
					By.cssSelector("span[class='rectagleBoxHeading']")).getText();
			System.out.println(textOftsdAssignDetails);

			// verify that the window is TSD Assign Details window or
			// not
			softAssert.assertEquals(textOftsdAssignDetails, "TSD Assign Details");

			System.out.println("Both the message is equal");

		}

		// verify TSD TextBox should not editable
		public void VerifyTSDTextBox() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// send the value to check TSD is editable or not on TSD
			// Text
			// Box
			WebElement objectOfTsdTextBox = driver.findElement(By
					.name("m_strTSDName"));
			objectOfTsdTextBox.sendKeys("abc");
			String tsdFieldValue = objectOfTsdTextBox.getAttribute("value");

			boolean isTsdFieldEditable;

			if (tsdFieldValue.contentEquals("abc")) {

				System.out.println("Field is editable");
				isTsdFieldEditable = true;
				softAssert.assertFalse(isTsdFieldEditable);
				// driver.findElement(By.linkText("Cancel")).click();

			}

			else

			{

				System.out.println("Field is non editable" + tsdFieldValue);
				isTsdFieldEditable = false;
				softAssert.assertFalse(isTsdFieldEditable);
				// driver.findElement(By.linkText("Cancel")).click();

			}

			softAssert.assertAll();

		}

		// If you select the technician name from list of your Technicians window ,
		// then selected technician should display in TSD text box

		public void matchTechnician() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on TSD button
			driver.findElement(
					By.cssSelector("div[id='incidentTypeDetails']>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td>img"))
					.click();

			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}
			System.out.println(driver.getTitle());
			// Thread.sleep(3000);

			// select the particular technician, here used the first name.
			WebElement technicalName = driver.findElement(By
					.cssSelector("td[class='pad5']>a"));
			String technicalNameValue = technicalName.getText();
			String technicalNameNewValue = technicalNameValue.split(" ")[0];
			System.out.println("Technician Name:-" + technicalNameNewValue);

			// click on the first name
			driver.findElement(By.cssSelector("td[class='pad5']>a")).click();
			// Thread.sleep(1000);

			for (String basicWindow : driver.getWindowHandles()) {
				driver.switchTo().window(basicWindow);

			}
			Thread.sleep(3000);
			// get value from TSD text box
			String tsdTextBoxValue = driver.findElement(By.name("m_strTSDName"))
					.getAttribute("value");
			System.out.println("TSD Text Box Value:-" + tsdTextBoxValue);

			// Match both the Technician Name

			softAssert.assertEquals(tsdTextBoxValue, technicalNameNewValue);

		}

		public void checkStatusField() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			String technicalStatus = textbox_TechnicalStatus.getText();
			System.out.println("Technical Status:-" + technicalStatus);

			boolean technicalStatusIsPresent = true;
			if (technicalStatus.contains("Resolved")) {
				System.out.println("pass");
				technicalStatusIsPresent = true;

			} else if (technicalStatus.contains("Unresolved")) {
				System.out.println("pass");
				technicalStatusIsPresent = true;

			} else {
				System.out.println("fail");
				technicalStatusIsPresent = false;

			}

			// Match technical status,Resolved and Unresolved is present
			// or
			// not
			softAssert.assertTrue(technicalStatusIsPresent);

			// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +
			// "w");
			// driver.findElement(By.linkText("Cancel")).click();
			softAssert.assertAll();

		}

		// Check Update Detail Field
		public void checkUpdateDetailButton() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();

			// click on TSD
			driver.findElement(
					By.cssSelector("div[id='incidentTypeDetails']>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td>img"))
					.click();

			// Window handler
			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}

			System.out.println(driver.getTitle());
			// Thread.sleep(3000);

			// select the particular technician, here used the first
			// name.
			WebElement technicalName = driver.findElement(By
					.cssSelector("td[class='pad5']>a"));
			String technicalNameValue = technicalName.getText();
			System.out.println("Technician Name:-" + technicalNameValue);

			// click on the first name
			driver.findElement(By.cssSelector("td[class='pad5']>a")).click();
			// Thread.sleep(3000);

			// go to first window
			for (String basicWindow : driver.getWindowHandles()) {
				driver.switchTo().window(basicWindow);

			}

			// get value from TSD text box
			String tsdTextBoxValue = driver.findElement(By.name("m_strTSDName"))
					.getAttribute("value");
			System.out.println("TSD Text Box Value:-" + tsdTextBoxValue);

			// Select Technical Status as Resolved
			Select selectTechnicalStatus;
			selectTechnicalStatus = new Select(textbox_TechnicalStatus);
			selectTechnicalStatus.selectByVisibleText("Resolved");

			// get the Selected Technician Status Value
			String technicalStatusValue = textbox_TechnicalStatus
					.getAttribute("value");
			System.out.println("Selected Technician Status:-"
					+ technicalStatusValue);

			// clear the text bo
			textbox_Observation.clear();

			// click on Observations Text Box With any characters
			textbox_Observation.sendKeys("The Defect is resolved");

			// get the observation
			String observationValue = textbox_Observation.getAttribute("value");
			System.out.println("Selected observation value:-" + observationValue);

			if (textbox_CustomerName.getAttribute("value").isEmpty()) {
				// if field is empty send contact name or number
				textbox_CustomerName.sendKeys("Bhagyashree");

			} else {

				String storeValue = textbox_CustomerName.getAttribute("value");
				System.out.println(" Customer Name And Contact No:-" + storeValue);

			}
			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// click on Update Detail Button
			button_UpdateDetail.click();

			// select the TSD value from Preliminary Analysis window
			String tsdPreliminaryTab = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(1)"))
					.getText();
			String splitTsdWord = tsdPreliminaryTab.split("TSD :")[1];

			String splitSword = splitTsdWord.split(" ")[0];
			System.out.println(splitSword);

			boolean tsdIsSame = true;
			if (tsdPreliminaryTab.contains(splitSword)) {
				System.out.println("pass");
				tsdIsSame = true;

			} else {
				System.out.println("fail");
				tsdIsSame = false;
			}

			// Match both TSD, is the TSD name is display is as selected
			// TSD
			// or not
			softAssert.assertTrue(tsdIsSame);

			// select theTechnical Status value from Preliminary
			// Analysis
			// window
			String technicalStatusPreliminaryTab = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(3)"))
					.getText();
			String splitTechnicalStatusWord = technicalStatusPreliminaryTab
					.split("Technical Status :")[1];
			System.out.println(splitTechnicalStatusWord);

			// Match both Technical status value from TSD Assign Details
			// page and
			// Preliminary Analysis tab
			softAssert.assertEquals(splitTechnicalStatusWord, technicalStatusValue);

			// select theTechnical Status value from Preliminary
			// Analysis
			// window
			String observationPreliminaryTab = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(5)"))
					.getText();
			String splitObservationWord = observationPreliminaryTab
					.split("Observations :")[1];
			System.out.println(splitObservationWord);

			// Match both Technical status value from TSD Assign Details
			// page and
			// Preliminary Analysis tab
			softAssert.assertEquals(splitObservationWord, observationValue);

			softAssert.assertAll();

		}

		// After click on the data cancel button the data should not updated
		public void checkCancelButton() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			String tsdBeforeDataEnter = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(1)"))
					.getText();
			System.out.println("TSD Before data enter:-" + tsdBeforeDataEnter);

			String technicalStatusBeforeDataEnter = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(3)"))
					.getText();
			System.out.println("Technical Status Before data enter:-"
					+ technicalStatusBeforeDataEnter);

			String observationBeforeDataEnter = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(5)"))
					.getText();
			System.out.println("Technical Status Before data enter:-"
					+ observationBeforeDataEnter);

			// click on Edit button
			button_EditOfPreliminaryAnalysis.click();

			// click on TSD
			driver.findElement(
					By.cssSelector("div[id='incidentTypeDetails']>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td>img"))
					.click();

			// Window handler
			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}

			System.out.println(driver.getTitle());
			// Thread.sleep(3000);

			// select the particular technician, here used the first
			// name.
			WebElement technicalName = driver.findElement(By
					.cssSelector("td[class='pad5']>a"));
			String technicalNameValue = technicalName.getText();
			System.out.println("Technician Name:-" + technicalNameValue);

			// click on the first name
			driver.findElement(By.cssSelector("td[class='pad5']>a")).click();
			// Thread.sleep(3000);

			// go to first window
			for (String basicWindow : driver.getWindowHandles()) {
				driver.switchTo().window(basicWindow);

			}

			// Select Technical Status as Resolved
			Select selectTechnicalStatus;
			selectTechnicalStatus = new Select(textbox_TechnicalStatus);
			selectTechnicalStatus.selectByVisibleText("Resolved");

			// clear the text box
			textbox_Observation.clear();

			// click on Observations Text Box With any characters
			textbox_Observation.sendKeys("The Defect is resolved");

			if (textbox_CustomerName.getAttribute("value").isEmpty()) {
				// if field is empty send contact name or number
				textbox_CustomerName.sendKeys("Bhagyashree");

			} else {

				String storeValue = textbox_CustomerName.getAttribute("value");
				System.out.println(" Customer Name And Contact No:-" + storeValue);

			}

			// click on cancel button
			button_Cancel.click();

			// select the TSD value from Preliminary Analysis window
			String tsdPreliminaryTab = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(1)"))
					.getText();
			System.out.println(tsdPreliminaryTab);

			// Match After click on cancel the value should not change
			softAssert.assertEquals(tsdPreliminaryTab, tsdBeforeDataEnter);

			// select theTechnical Status value from Preliminary
			// Analysis
			// window
			String technicalStatusPreliminaryTab = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(3)"))
					.getText();
			System.out.println(technicalStatusPreliminaryTab);

			// Match After click on cancel the value should not change
			softAssert.assertEquals(technicalStatusPreliminaryTab,
					technicalStatusBeforeDataEnter);

			// select theTechnical Status value from Preliminary
			// Analysis
			// window
			String observationPreliminaryTab = driver
					.findElement(
							By.cssSelector("div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(5)"))
					.getText();
			System.out.println(observationPreliminaryTab);

			// Match After click on cancel the value should not change
			softAssert.assertEquals(observationPreliminaryTab,
					observationBeforeDataEnter);

			softAssert.assertAll();

		}

		// If user click on Call Assign To Technician button then,
		// 'Technician Assign And ETA Details' pop up should display
		public void displayTechnicianAssignAndETADetailsPopup() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				List<WebElement> status = list_StatusInTable;
				int size = status.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {

					String statusValue = status.get(i).getText();
					System.out.println(statusValue);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					if (statusValue.equalsIgnoreCase("Open") && ETA.equals(""))

					{

						// get ID from list of Available Spares Window
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);

						// click on that ID
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();
						// Thread.sleep(2000);
						// click on ETA and Technician tab
						tab_ETATechnician.click();

						// click on Call Assign To Technician Button.
						button_CallAssignToTechnician.click();

						// get the message from Technician Assign And ETA Details
						// window
						// window handler

						for (String TechnicianAssignAndETADetailsWindow : driver
								.getWindowHandles()) {

							System.out.println(TechnicianAssignAndETADetailsWindow);
							driver.switchTo().window(
									TechnicianAssignAndETADetailsWindow);

						}
						Thread.sleep(1000);

						String textOfTechnicianAssignAndETADetails = driver
								.findElement(
										By.cssSelector("span[class='rectagleBoxHeading']"))
								.getText();
						System.out.println(textOfTechnicianAssignAndETADetails);

						// verify that the window is TSD Assign Details window or
						// not
						softAssert.assertEquals(
								textOfTechnicianAssignAndETADetails,
								"Technician Assign And ETA Details");
						System.out.println("Both the message is equal");

						Thread.sleep(1000);
						// driver.findElement(By.linkText("Cancel")).click();
						break loop;
					}
				}

				if (sizePagination - 1 == p) {
					System.out.println("Ticket is not Available for Punching ETA");
					softAssert.assertTrue(false, " Ticket is not Available");

					/*tab_Ticket.click();
					Thread.sleep(1000);
					tab_CreateNew.click();

					createNewPageOfSdRole = new SD_CreateNewPage();
					createNewPageOfSdRole.createNewTicket();

					ticketFromOfViewTicketPage = new SD_TicketFromOfViewTicketPage();
					// viewTicketPageOfSdRole.punchETAAfterCreatingTicket();

					tab_Ticket.click();
					Thread.sleep(1000);
					tab_ViewTicket.click();

					ticketFromOfViewTicketPage
							.displayTechnicianAssignAndETADetailsPopup();*/
				}

			}
			softAssert.assertAll();
		}

		// If user keep Technician field as blank and
		// click on Update Details page then notification should display 'Please
		// select engineer.'

		public void checkWithBlankTechnician() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// clear the technician name
			textbox_Technician.clear();

			// Thread.sleep(1000);

			// click on Update Detail Button
			button_UpdateDetail.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();

			// verify that alert message is Please Enter The Numeric
			// Value
			// for
			// Incident ID or not
			softAssert.assertEquals(alertMessage, "Please select engineer.");
			System.out.println("Both the message is equal");

			softAssert.assertAll();

		}

		// In Technician field if user enter name then auto suggest list should
		// display as per entered characters
		public void checkTechnicianAutoSuggest() throws Exception {
			

			// clear the technician name
			textbox_Technician.clear();

			// send the technician name
			textbox_Technician.sendKeys("Tech");

			List<WebElement> technicianNameList = driver.findElements(By
					.xpath(".//*[@id='as_ul']/li[6]/a/span[3]"));
			System.out.println("custermer list" + technicianNameList.size());

			for (int j = 0; j < technicianNameList.size(); j++) {
				System.out.println(technicianNameList.get(j).getText());

				if (technicianNameList.get(j).getText().contains("Tech12")) {
					technicianNameList.get(j).click();

				}

			}

		}

		// After click on first list symbol of Technician Field then
		// 'List of your Technicians' pop up should display
		public void displayListOfYourTechniciansWindow() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click the first list of click on first list symbol of
			// Technician Field
			symbol_TechnicianList.click();

			Thread.sleep(1000);
			for (String listOfYourTechniciansWindow : driver.getWindowHandles()) {

				System.out.println(listOfYourTechniciansWindow);
				driver.switchTo().window(listOfYourTechniciansWindow);

			}

			String textSelectTechnician = driver.getTitle();

			// verify that ,pop up window is Select Technicians
			// window or not
			softAssert.assertEquals(textSelectTechnician, "Select Technicians");
			System.out.println("Both the message is equal");

			softAssert.assertAll();

		}

		// If User click on hyper link of particular employee name in list then,
		// same name should get fill into Technician field in 'Technician Assign And
		// ETA Details'pop up

		public void matchTechnicianName() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*
			 * symbol_TechnicianList.click();
			 * 
			 * // Window handler for (String technicianWindow :
			 * driver.getWindowHandles()) {
			 * driver.switchTo().window(technicianWindow);
			 * 
			 * }
			 */
			// Thread.sleep(1000);
		/*	// select Business Unit of that window
			Select technicianBusinessUnit;
			technicianBusinessUnit = new Select(driver.findElement(By
					.name("m_strBusinessUnit")));
			technicianBusinessUnit.selectByIndex(8);
			System.out.println("woldline");

			// Thread.sleep(1000);
			Select state;
			state = new Select(driver.findElement(By.name("m_strState")));
			state.selectByValue("Maharashtra");
			System.out.println("Maharashtra");

			// click on go button of state
			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[2]/td[3]/input"))
					.click();
			// Thread.sleep(3000);

			Select city;
			city = new Select(driver.findElement(By.name("m_strCity")));
			city.selectByValue("Kalyan");
			System.out.println("Kalyan");
			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[3]/td[3]/input"))
					.click();*/

			// Thread.sleep(3000)

			int size = list_TechnicianName.size();

			for (int j = 0; j < size; j++) {

				// Thread.sleep(2000);
				String technicianVlaue = list_TechnicianName.get(j).getText();
				System.out.println(technicianVlaue);

				if (technicianVlaue.contains("Pranjali Deshpande"))

				{
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_TechnicianName.get(j));
					 Thread.sleep(1000);
					list_TechnicianName.get(j).click();

					String split = technicianVlaue.split(" ")[0];
					System.out.println(split);

					// go to first window
					for (String basicWindow : driver.getWindowHandles()) {
						driver.switchTo().window(basicWindow);

					}

					driver.manage().timeouts()
							.pageLoadTimeout(50, TimeUnit.SECONDS);
					// Click on update button
					button_UpdateDetail.click();

					try {
						Alert alert = driver.switchTo().alert();
						System.out.println("Alert Text:" + alert.getText());
						alert.dismiss();
						// Thread.sleep(3000);

						// select the assert if already ETA date time is
						// present
						// then used alert

						/*
						 * // get the message from that alert box Alert alert =
						 * driver.switchTo().alert(); //Thread.sleep(3000);
						 * 
						 * String alertMessage = alert.getText();
						 * System.out.println("Alert Text:" + alertMessage);
						 * alert.dismiss();
						 */

						// go to first window
						for (String basicWindow : driver.getWindowHandles()) {
							driver.switchTo().window(basicWindow);

						}
						break;
					} catch (Exception e) {

						for (String basicWindow : driver.getWindowHandles()) {
							driver.switchTo().window(basicWindow);

						}
						
					}
					// click on Call Assign To Technician Button.
					button_CallAssignToTechnician.click();

					// go to technician window
					for (String technicianAssignAndETADetailsWindow : driver
							.getWindowHandles()) {

						System.out.println(technicianAssignAndETADetailsWindow);
						driver.switchTo().window(
								technicianAssignAndETADetailsWindow);

					}

					// after selecting the technician name ,that name is
					// appear
					// in
					// technician text box
					String selectedName = textbox_Technician.getAttribute("value");
					System.out.println("selected technician name is:-"
							+ selectedName);

					// Match that both value is same or not
					softAssert.assertEquals(split, selectedName);
					System.out.println("The name is same");

				}
			}
			softAssert.assertAll();
		}

		// If calls regarding same Asset are assign to another technician then
		// in ETA tab while update ETA details alert box should display as
		// 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'
		public void CheckAlertMessage() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*// clear all the field
			textbox_Technician.clear();

			// click the first list of click on first list symbol of
			// Technician
			// Field
			symbol_TechnicianList.click();

			// Window handler
			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}

			// Thread.sleep(1000);
			// select Business Unit of that window
			Select technicianBusinessUnit;
			technicianBusinessUnit = new Select(driver.findElement(By
					.name("m_strBusinessUnit")));
			technicianBusinessUnit.selectByIndex(8);
			System.out.println("woldline");

			// Thread.sleep(1000);
			Select state;
			state = new Select(driver.findElement(By.name("m_strState")));
			state.selectByValue("Maharashtra");
			System.out.println("Maharashtra");

			// click on go button of state
			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[2]/td[3]/input"))
					.click();
			// Thread.sleep(3000);

			int size = list_TechnicianName.size();

			for (int j = 0; j < size; j++) {

				// Thread.sleep(2000);
				String technicianVlaue = list_TechnicianName.get(j).getText();
				System.out.println(technicianVlaue);

				if (technicianVlaue.contains("Pranjali Deshpande"))

				{

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_TechnicianName.get(j));
					
					// Thread.sleep(2000);
					String technicianValue = list_TechnicianName.get(j).getText();
					System.out.println(technicianVlaue);
					
					// Thread.sleep(2000);
					list_TechnicianName.get(j).click();

					String split = technicianValue.split(" ")[0];
					System.out.println(split);
*/
					// go to first window
					for (String basicWindow : driver.getWindowHandles()) {
						driver.switchTo().window(basicWindow);

					}
					// Click on update button
					button_UpdateDetail.click();
					// Thread.sleep(3000);

					try {
						// get the message from that alert box
						Alert technicianAlert = driver.switchTo().alert();
						// Thread.sleep(3000);

						String technicianAlertMessage = technicianAlert.getText();
						System.out.println("Alert Text:" + technicianAlertMessage);
						technicianAlert.dismiss();

						softAssert
								.assertEquals(technicianAlertMessage,
										"DO You Want To Assign Other Calls To The Same Engineer For This Asset.");
						
						
					} catch (Exception e) {
					
						
						//softAssert.assertAll();
					}
			
			
			softAssert.assertAll();
		}

		// In ETA Date field, user should not enter manual data
		public void checkETADateField() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			// send the value to check ETA Date is editable or not
			// on TSD Text Box
			textbox_ETADate.sendKeys("2018-05-25");
			String tsdFieldValue = textbox_ETADate.getAttribute("value");

			boolean isETADateFieldEditable;

			if (tsdFieldValue.contentEquals("2018-05-25")) {

				System.out.println("Field is editable");
				isETADateFieldEditable = true;

			}

			else

			{

				System.out.println("Field is non editable" + tsdFieldValue);
				isETADateFieldEditable = false;

			}

			// check field should not editable

			softAssert.assertFalse(isETADateFieldEditable);
			softAssert.assertAll();

		}

		// if user keep 00hr and 00min and click on Update details button then
		// notification should display as 'Please enter ETA Time'.
		public void checkETATime() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// select ETA date
			Actions action = new Actions(driver);
			action.moveToElement(symbol_ETACalender).doubleClick().build()
					.perform();
			// Thread.sleep(3000);

			// select Date
			List<WebElement> allDates = driver.findElements(By
					.cssSelector("div[id='fd-dp-8']>table>tbody>tr>td"));

			for (WebElement ele : allDates) {

				String date = ele.getText();

				if (date.equalsIgnoreCase("30")) {
					ele.click();
					String getDateValue = ele.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			Select etaTimeMinute;
			etaTimeMinute = new Select(textbox_ETATimeMinute);
			etaTimeMinute.selectByVisibleText("00");
			// Thread.sleep(3000);

			Select etaTimeSecond;
			etaTimeSecond = new Select(textbox_ETATimeSecond);
			etaTimeSecond.selectByVisibleText("00");
			Thread.sleep(3000);

			button_UpdateDetail.click();
			// Thread.sleep(3000);

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();

			// go to first window
			softAssert.assertEquals(alertMessage, "Please enter ETA Time.");
			softAssert.assertAll();

		}

		// In ETA Date time field, if user select date from calendar and time then,
		// same should get fill into ETA Date and ETA time field
		public void matchETADateTime() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Previous date
			int nextDay = Integer.parseInt(currentDay);
			String nxtDay = Integer.toString(nextDay);

			symbol_ETACalender.click();

			// select Date in Calendar

			for (WebElement day : dates_InETACalender) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(nxtDay)) {
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}
			/*
			 * // Get Date in ATA Date Text box String datePattern = "yyyy-MM-dd";
			 * DateFormat dateFormat = new SimpleDateFormat(datePattern); String
			 * currentDate = textbox_ETADate .getAttribute("value");
			 * 
			 * System.out.println(currentDate); Date ATADate = (Date)
			 * dateFormat.parse(currentDate); System.out.println(ATADate);
			 */

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String currentHrs = new SimpleDateFormat("HH").format(calendar
					.getTime());
			System.out.println(currentHrs);
			int nextHrs = Integer.parseInt(currentHrs) + 1;
			String hrs = Integer.toString(nextHrs);

			String currentMin = new SimpleDateFormat("mm").format(calendar
					.getTime());
			System.out.println(currentMin);
			int nextMin = Integer.parseInt(currentMin);
			String min = Integer.toString(nextMin);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_ETATimeHour) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {

					Thread.sleep(1000);
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_ETATimeMinute) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min)) {

					Thread.sleep(1000);
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);
					break;
				}

			}

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			button_UpdateDetail.click();
			/*
			 * Thread.sleep(1000); button_UpdateDetail.click();
			 */
			// Thread.sleep(3000);

			try {
				// get the message from that alert box
				Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);

				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.dismiss();
				driver.switchTo().defaultContent();

				/*
				 * driver.manage().timeouts() .pageLoadTimeout(30,
				 * TimeUnit.SECONDS);
				 */
				// button_UpdateDetail.click()

			} catch (Exception e) {
				// button_UpdateDetail.click();
				Alert technicianAlert = driver.switchTo().alert();
				Thread.sleep(1000);

				String technicianAlertMessage = technicianAlert.getText();
				System.out.println("Alert Text:" + technicianAlertMessage);
				technicianAlert.dismiss();
				driver.switchTo().defaultContent();

			}

			// go to first window
			for (String basicWindow : driver.getWindowHandles()) {
				driver.switchTo().window(basicWindow);

			}
			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			// go to technician window
			for (String technicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(technicianAssignAndETADetailsWindow);
				driver.switchTo().window(technicianAssignAndETADetailsWindow);

			}

			// after selecting the ETA Date ,that Date is appear in
			// ETA text box
			String selectedDate = textbox_ETADate.getAttribute("value");
			System.out.println("selected Date is:-" + selectedDate);

			Boolean DateIsPresent;
			if (selectedDate.contains("")) {
				System.out.println("pass");
				DateIsPresent = true;
			} else {
				System.out.println("fail");
				DateIsPresent = false;
			}

			// Match the text box contain selected value or not
			Boolean selectedTimeIsPresent = driver
					.findElement(
							By.cssSelector("div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)>option[selected]"))
					.getText().contains(hrs);

			// Match the text box contain selected value or not
			boolean SelectedTimeSecondPresent = driver
					.findElement(
							By.cssSelector("div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)>option[selected]"))
					.getText().contains(min);

			// Match that both ETA Date value is same or not
			softAssert.assertTrue(DateIsPresent);
			System.out.println("The Date is same");

			// Match that both ETA Time Minute value is same or not
			softAssert.assertTrue(selectedTimeIsPresent);
			System.out.println("The Time is same");

			// Match that both ETA Time Second value is same or not
			softAssert.assertTrue(SelectedTimeSecondPresent);
			System.out.println("The Time is same");

			softAssert.assertAll();

		}

		// Check Appointment Date and Time
		public void checkAppointmentDateAndTime() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*
			 * // click on Call Assign To Technician Button.
			 * button_CallAssignToTechnician.click();
			 * 
			 * for (String technicianAssignAndETADetailsWindow : driver
			 * .getWindowHandles()) {
			 * 
			 * System.out.println(technicianAssignAndETADetailsWindow);
			 * driver.switchTo().window( technicianAssignAndETADetailsWindow);
			 * 
			 * }
			 */

			Actions action = new Actions(driver);
			action.moveToElement(button_AppointmentDate).doubleClick().build()
					.perform();
			// Thread.sleep(3000);

			// select Date
			String getDateValue = null;

			List<WebElement> allDates = driver.findElements(By
					.cssSelector("div[id='fd-dp-7']>table>tbody>tr>td"));

			for (WebElement ele : allDates) {

				String date = ele.getText();

				if (date.equalsIgnoreCase("30")) {
					Thread.sleep(1000);
					ele.click();
					getDateValue = ele.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// list of Appointment List
			textBox_AppointmentTime.getText();

			// select Appointment Time
			Select AppointmentTime;
			AppointmentTime = new Select(textBox_AppointmentTime);
			AppointmentTime.selectByVisibleText("7pm - 9pm");
			// Thread.sleep(3000);

			// Match the text box contain selected value or not
			boolean selectedTimeIsPresent = textBox_AppointmentTime.getText()
					.contains("7pm - 9pm");

			button_UpdateDetail.click();
			// Thread.sleep(3000);

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.dismiss();
			driver.switchTo().defaultContent();

			// go to first window
			for (String basicWindow : driver.getWindowHandles()) {
				driver.switchTo().window(basicWindow);

			}
			// get the dialogue Box notification
			String dialogueBox = notification.getText();
			System.out.println("dialogue Box Notification:-" + dialogueBox);

			// after fill all the field ,Incident Updated SuccessFully
			// notification
			// should display
			softAssert.assertEquals(dialogueBox, "Incident Updated SuccessFully");

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			// go to technician window
			for (String technicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(technicianAssignAndETADetailsWindow);
				driver.switchTo().window(technicianAssignAndETADetailsWindow);

			}

			// after selecting the technician name ,that name is appear
			// in
			// technician text box
			String selectedDate = textBox_AppointmentDate.getAttribute("value");
			System.out.println("selected Date is:-" + selectedDate);

			Boolean appointmentDateIsPresent;
			if (selectedDate.contains(getDateValue)) {
				System.out.println("pass");
				appointmentDateIsPresent = true;
			} else {
				System.out.println("fail");
				appointmentDateIsPresent = false;
			}

			// Match that both ETA Date value is same or not
			softAssert.assertTrue(appointmentDateIsPresent);
			System.out.println("The Date is same");

			// Match that both ETA Time Minute value is same or not
			softAssert.assertTrue(selectedTimeIsPresent);
			System.out.println("The Time is same");

			softAssert.assertAll();

			button_Cancel.click();

		}

		// After click on Cancel button then data should not get fill into
		// respective fields

		public void checkCancelButtonFunctionality() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// get the value from ETA and Technician window
			String appointmentDateBeforeDataEnter = label_AppointmentDate.getText();
			System.out.println("Appointment Date:-"
					+ appointmentDateBeforeDataEnter);

			String appointmentTimeBeforeDataEnter = label_AppointmentTime.getText();
			System.out.println("Appointment time:-"
					+ appointmentTimeBeforeDataEnter);

			String etaDateBeforeDataEnter = label_ETADate.getText();
			System.out.println("ETA date:-" + etaDateBeforeDataEnter);

			String etaTimeBeforeDataEnter = label_ETATime.getText();
			System.out.println("ETA Time:-" + etaTimeBeforeDataEnter);

			String Technician = label_Technician.getText();
			System.out.println("Technician:-" + Technician);

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			for (String technicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(technicianAssignAndETADetailsWindow);
				driver.switchTo().window(technicianAssignAndETADetailsWindow);

			}
			// clear all the field
			textbox_Technician.clear();

			// click the first list of click on first list symbol of
			// Technician
			// Field
			symbol_TechnicianList.click();

			// Window handler
			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}

			System.out.println(driver.getTitle());
			// Thread.sleep(3000);

			// click on the first name
			driver.findElement(
					By.xpath(".//*[@id='right']/div/table/tbody/tr[3]/td[3]/a"))
					.click();

			for (String technicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(technicianAssignAndETADetailsWindow);
				driver.switchTo().window(technicianAssignAndETADetailsWindow);

			}
			// select appointment date
			Actions action = new Actions(driver);
			action.moveToElement(button_AppointmentDate).doubleClick().build()
					.perform();
			// Thread.sleep(3000);

			// select Date
			List<WebElement> allDates = driver.findElements(By
					.cssSelector("div[id='fd-dp-7']>table>tbody>tr>td"));

			for (WebElement ele : allDates) {

				String date = ele.getText();

				if (date.equalsIgnoreCase("30")) {

					Thread.sleep(1000);
					ele.click();
					String getDateValue = ele.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}
			// select Appointment Time
			Select AppointmentTime;
			AppointmentTime = new Select(textBox_AppointmentTime);
			AppointmentTime.selectByVisibleText("7pm - 9pm");
			// Thread.sleep(3000);

			// select ETA date
			action.moveToElement(symbol_ETACalender).doubleClick().build()
					.perform();
			// Thread.sleep(3000);

			// select Date
			List<WebElement> allETADate = driver.findElements(By
					.cssSelector("div[id='fd-dp-8']>table>tbody>tr>td"));

			for (WebElement ele : allETADate) {

				String date = ele.getText();

				if (date.equalsIgnoreCase("30")) {

					Thread.sleep(500);
					ele.click();
					String getETADateValue = ele.getText();
					System.out.println("Select the date:-" + getETADateValue);

					break;
				}

			}

			Select etaTimeMinute;
			etaTimeMinute = new Select(textbox_ETATimeMinute);
			etaTimeMinute.selectByVisibleText("15");
			// Thread.sleep(3000);

			Select etaTimeSecond;
			etaTimeSecond = new Select(textbox_ETATimeSecond);
			etaTimeSecond.selectByVisibleText("30");
			// Thread.sleep(3000);

			// click on cancel button
			button_Cancel.click();

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			for (String technicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(technicianAssignAndETADetailsWindow);
				driver.switchTo().window(technicianAssignAndETADetailsWindow);

			}

			// after enter all the value and press cancel button,
			// get value from ETA Technician tab
			String appointmentDateAfterDataEnter = label_AppointmentDate.getText();
			System.out.println("Technician value after click on cancel:-"
					+ appointmentDateAfterDataEnter);

			String appointmentTimeAfterDataEnter = label_AppointmentTime.getText();
			System.out.println("Technician value after click on cancel:-"
					+ appointmentTimeAfterDataEnter);

			String etaDateAfterDataEnter = label_ETADate.getText();
			System.out.println("Technician value after click on cancel:-"
					+ etaDateAfterDataEnter);

			String etaTimeAfterDataEnter = label_ETATime.getText();
			System.out.println("Technician value after click on cancel:-"
					+ etaTimeAfterDataEnter);

			String TechnicianValueAfterDataEnter = label_Technician.getText();
			System.out.println("Technician value after click on cancel:-"
					+ TechnicianValueAfterDataEnter);

			// Match both the value it should same
			softAssert.assertEquals(appointmentDateBeforeDataEnter,
					appointmentDateAfterDataEnter);
			softAssert.assertEquals(appointmentTimeBeforeDataEnter,
					appointmentTimeAfterDataEnter);
			softAssert.assertEquals(etaDateBeforeDataEnter, etaDateAfterDataEnter);
			softAssert.assertEquals(Technician, TechnicianValueAfterDataEnter);
			// click on cancel button
			button_Cancel.click();
			softAssert.assertAll();
		}

		// check on Resends SMS button
		public void checkResendSMSButton() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click on resend SMS button
			button_ResendSMS.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String resendAlertMessage = alert.getText();
			System.out.println("Alert Text:" + resendAlertMessage);
			alert.accept();
			driver.switchTo().defaultContent();

			softAssert.assertEquals(resendAlertMessage,
					"Do You Want To Resend SMS To Technician");

			String dialogueBoxMessage = driver.findElement(By.cssSelector("#dialogBoxSuccess")).getText();
			System.out.println(dialogueBoxMessage);

			softAssert.assertEquals(dialogueBoxMessage, "SMS Sent Successfully");

			// Thread.sleep(2000);
			driver.findElement(By.cssSelector("#dialogBoxSuccess>img")).click();
			softAssert.assertAll();
		}

		public void checkETAAndSLA() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// click on filter

			tab_Requestor.click();

			// Thread.sleep(3000);
			// click on customer SLA in requester tab
			String customerSLA = tab_CustomerSLA.getText();
			System.out.println(customerSLA);
			String splitCustomerSLAWord = customerSLA.split("Customer SLA:")[1];
			System.out.println(splitCustomerSLAWord);
			String splitHRs = splitCustomerSLAWord.split("hrs")[0];
			System.out.println("splitHRs:-" + splitHRs);
			String splitSpace = splitHRs.split(" ")[1];
			int result = Integer.parseInt(splitSpace);
			System.out.println("integer result:-" + result);

			// Thread.sleep(3000);
			String ticketLogTime = label_TicketLogTime.getText();
			String splitDate = ticketLogTime.split(" ")[1];
			String splitTime = ticketLogTime.split(" ")[0];
			System.out.println(splitTime);
			System.out.println(splitDate);

			// Add customer SLA with ticket Log Time
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			Date date = formatter.parse(splitDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR_OF_DAY, result);
			Date addedTime = cal.getTime();
			String timeInString = formatter.format(addedTime);
			System.out.println(timeInString);

			String totalDateTime = splitTime.concat(" " + timeInString);
			System.out.println(totalDateTime);

			String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
			DateFormat dateTimeFormat = new SimpleDateFormat(dateTimePattern);
			Date totalSLATime = (Date) dateTimeFormat.parse(totalDateTime);
			String totalSLADateTime = dateTimeFormat.format(totalSLATime);

			System.out.println(totalSLATime);

			// click on ETA and Technician tab
			tab_ETATechnician.click();

			// get the value from ETA and Technician window
			String appointmentDateBeforeDataEnter = label_AppointmentDate.getText();
			System.out.println("Appointment Date:-"
					+ appointmentDateBeforeDataEnter);

			String appointmentTimeBeforeDataEnter = label_AppointmentTime.getText();
			System.out.println("Appointment time:-"
					+ appointmentTimeBeforeDataEnter);

			String etaDateBeforeDataEnter = label_ETADate.getText();
			System.out.println("ETA date:-" + etaDateBeforeDataEnter);

			String etaTimeBeforeDataEnter = label_ETATime.getText();
			System.out.println("ETA Time:-" + etaTimeBeforeDataEnter);

			String Technician = label_Technician.getText();
			System.out.println("Technician:-" + Technician);

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			for (String technicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(technicianAssignAndETADetailsWindow);
				driver.switchTo().window(technicianAssignAndETADetailsWindow);

			}

			Actions action = new Actions(driver);
			action.moveToElement(symbol_ETACalender).doubleClick().build()
					.perform();
			// Thread.sleep(3000);

			// Select ETA
			// to click on calendar tab
			WebElement etadate = driver.findElement(By
					.xpath(".//*[@id='fd-dp-8']/table/tbody"));
			Actions mouseaction = new Actions(driver);
			mouseaction.moveToElement(etadate).doubleClick().build().perform();
			// Thread.sleep(3000);

			// click on ...row 4th....column 4th
			WebElement selectDate = driver.findElement(By
					.xpath(".//*[@id='fd-dp-8']/table/tbody/tr[5]/td[4]"));
			action.moveToElement(selectDate).click().build().perform();

			String getDateValue = textbox_ETADate.getAttribute("value");
			System.out.println(getDateValue);

			// Format of Date Time
			SimpleDateFormat timeFormatter = new SimpleDateFormat("HH");
			// DateFormat hourTimeFormatETA = new
			// SimpleDateFormat(hourTimeForETA);
			Date hourTimeOfETA = timeFormatter.parse(splitDate);
			String timeHourvalue = timeFormatter.format(hourTimeOfETA);
			int selectValue = Integer.parseInt(timeHourvalue) + 1;
			String timeHour = Integer.toString(selectValue);
			System.out.println(timeHour);

			// Format of Date Time
			SimpleDateFormat timeMinuteFormatter = new SimpleDateFormat("mm");
			// DateFormat minuteTimeFormatETA = new
			// SimpleDateFormat(minuteTimeForETA);
			Date minuteTimeOfETA = timeMinuteFormatter.parse(splitDate);
			String timeMinute = timeMinuteFormatter.format(minuteTimeOfETA);
			System.out.println(timeMinute);

			String getTimeHoureValue1 = null;
			for (WebElement hrsofSystem : dropdown_ETATimeMinute) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(timeHour)) {

					Thread.sleep(1000);
					hrsofSystem.click();
					getTimeHoureValue1 = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getTimeHoureValue1);

					break;
				}

			}

			String getTimeMinuteValue1 = null;
			for (WebElement minOfSystem : dropdown_ETATimeSecond) {

				String minuteInDropdown = minOfSystem.getText();

				if (minuteInDropdown.equalsIgnoreCase(timeMinute)) {

					Thread.sleep(1000);
					minOfSystem.click();
					getTimeMinuteValue1 = minOfSystem.getText();
					System.out.println("Select the hrs:-" + getTimeMinuteValue1);

					break;
				}

			}

			String addTime = getTimeHoureValue1.concat(":" + getTimeMinuteValue1);
			System.out.println(addTime);

			String addTotalDateTime = getDateValue.concat(" " + addTime);
			System.out.println(addTotalDateTime);

			if (addTotalDateTime.compareTo(totalSLADateTime) > 0) {

				String getAppointmentDate = textBox_AppointmentDate
						.getAttribute("value");
				System.out.println(getAppointmentDate);

				String getAppointmentTime = textBox_AppointmentTime
						.getAttribute("value");
				System.out.println(getAppointmentTime);

				button_UpdateDetail.click();
				// Thread.sleep(3000);

				// get the message from that alert box
				Alert alert = driver.switchTo().alert();
				// Thread.sleep(3000);

				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();

				// Thread.sleep(4000);

				Alert technicianAlert = driver.switchTo().alert();
				// Thread.sleep(3000);

				String technicianAlertMessage = technicianAlert.getText();
				System.out.println("Alert Text:" + technicianAlertMessage);
				technicianAlert.dismiss();

				softAssert.assertEquals(alertMessage,
						"DO You Want To Punch ETA Beyond SLA.");

				softAssert.assertEquals(getAppointmentDate,
						appointmentDateBeforeDataEnter);
				softAssert.assertEquals(getAppointmentTime,
						appointmentTimeBeforeDataEnter);
				softAssert.assertEquals(getDateValue, etaDateBeforeDataEnter);
				softAssert.assertEquals(addTime, etaTimeBeforeDataEnter);

			} else if (addTotalDateTime.compareTo(totalSLADateTime) <= 0)

			{
				button_UpdateDetail.click();
				// Thread.sleep(3000);

				Alert technicianAlert = driver.switchTo().alert();
				// Thread.sleep(3000);

				String technicianAlertMessage = technicianAlert.getText();
				System.out.println("Alert Text:" + technicianAlertMessage);
				technicianAlert.dismiss();

				for (String basicWindow : driver.getWindowHandles()) {

					System.out.println(basicWindow);
					driver.switchTo().window(basicWindow);

				}

				String message = notification.getText();

				softAssert.assertEquals(message, "Incident Updated SuccessFully");

			} else

			{
				System.out.println("Something is Wrong");

			}
			softAssert.assertAll();

		}

		// If user click on OK button of 'DO You Want To Assign Other Calls To The
		// Same Engineer For This Asset.
		// pop up window then All calls regarding same AssetID should get assign to
		// same technician

		public void checkOkButtonOfPopUp() throws Exception {
	

			// click on search ticket tab
			tab_SearchTicketOpen.click();

			// enter the valid id in field
			textbox_SearchAssetID.sendKeys("Wor-Mum-0001");

			// click on Go button
			button_AssetIDGo.click();

			// click on first id in Id column
			id_InTable.click();

			// click on ETA and Technician tab
			tab_ETATechnician.click();

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			for (String TechnicianAssignAndETADetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(TechnicianAssignAndETADetailsWindow);
				driver.switchTo().window(TechnicianAssignAndETADetailsWindow);

			}

			textbox_Technician.clear();
			// click the first list of click on first list symbol of Technician
			// Field
			symbol_TechnicianList.click();

			for (String listOfYourTechniciansWindow : driver.getWindowHandles()) {

				System.out.println(listOfYourTechniciansWindow);
				driver.switchTo().window(listOfYourTechniciansWindow);

			}
			// Thread.sleep(3000);
			// select Business Unit of that window
			Select technicianBusinessUnit;
			technicianBusinessUnit = new Select(driver.findElement(By
					.name("m_strBusinessUnit")));
			technicianBusinessUnit.selectByIndex(8);
			System.out.println("woldline");

			// Thread.sleep(1000);
			Select state;
			state = new Select(driver.findElement(By.name("m_strState")));
			state.selectByValue("Maharashtra");
			System.out.println("Maharashtra");

			// click on go button of state
			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[2]/td[3]/input"))
					.click();
			// Thread.sleep(3000);
			int size = list_TechnicianName.size();

			for (int i = 0; i < size; i++) {

				// Thread.sleep(2000);
				String technicianValue = list_TechnicianName.get(i).getText();
				System.out.println(technicianValue);

				if (technicianValue.contains("Pranjali Deshpande"))

				{
					// Thread.sleep(2000);
					list_TechnicianName.get(i).click();

					for (String TechnicianAssignAndETADetailsWindow : driver
							.getWindowHandles()) {

						System.out.println(TechnicianAssignAndETADetailsWindow);
						driver.switchTo().window(
								TechnicianAssignAndETADetailsWindow);

					}

					// Click on update button
					button_UpdateDetail.click();
					// Thread.sleep(3000);

					/*
					 * Alert alert = driver.switchTo().alert(); Thread.sleep(3000);
					 * 
					 * String alertMessage = alert.getText();
					 * System.out.println("Alert Text:" + alertMessage);
					 * alert.accept();
					 */
					// get the message from that alert box
					Alert technicianAlert = driver.switchTo().alert();
					// Thread.sleep(3000);

					String technitianalertMessage = technicianAlert.getText();
					System.out.println("Alert Text:" + technitianalertMessage);
					technicianAlert.accept();
					// driver.switchTo().defaultContent();

					driver.manage().timeouts()
							.pageLoadTimeout(120, TimeUnit.SECONDS);

					// Thread.sleep(2000);
					String window = driver.getWindowHandle();
					System.out.println(window);

					// Thread.sleep(2000);
					// click on ticket tab
					driver.findElement(
							By.xpath(".//*[@id='main']/div[2]/div[2]/div/ul/li[2]/a"))
							.click();

					// Thread.sleep(2000);
					// click on view ticket tab
					driver.findElement(
							By.xpath(".//*[@id='main']/div[2]/div[2]/div/ul/li[2]/div/div/div/ul/li[2]/a"))
							.click();

					// Thread.sleep(3000);

					// click on filter tab
					tab_Filter.click();

					// select the particular status
					Select status;
					status = new Select(driver.findElement(By
							.name("m_strStatusFilter")));
					status.selectByVisibleText("Open");
					// Thread.sleep(3000);

					// click on search ticket tab
					tab_SearchTicketOpen.click();

					// enter the valid id in field
					textbox_SearchAssetID.sendKeys("Wor-Mum-0001");

					// click on Go button
					button_AssetIDGo.click();
					// Thread.sleep(2000);

					// Thread.sleep(1000);
					// for table
					List<WebElement> rowElement = driver
							.findElements(By
									.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
					System.out.println("NUMBER OF ROWS IN THIS TABLE = "
							+ rowElement.size());

					for (int j = 0; j < rowElement.size(); j++) {

						// Thread.sleep(3000);
						List<WebElement> columnElement = driver
								.findElements(By
										.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[21]"));
						String technicianName = columnElement.get(j).getText();
						System.out.println(technicianName);

						boolean technicianNameIsSame;
						if (technicianValue.contains(technicianName)) {

							System.out.println("Technician name is same");
							technicianNameIsSame = true;

						} else {

							System.out.println("Technician name is different");
							technicianNameIsSame = false;

						}

						Assert.assertTrue(technicianNameIsSame);

					}

				}

			}

		}

		// ATA //
		// After select only technician and appointment date/time in ETA tab and if
		// user click on Edit button in ATA tab then notification should display as
		// 'Please Select ETA And Technician First.'
		public void displayNotificationWithoutETAInATATab() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_ETADateInTable.size();
				System.out.println(size);
				for (int i = 0; i < size; i++) {

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					if (status.equals("Open") && ETA.equals("")) {
						String id = list_IDInTable.get(i).getText();
						System.out.println(id);

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();

						// Click on ETA And Technician Tab
						tab_ETAAndTechnician.click();

						// Get Technician Value
						String technician = label_TechnicianInETAAndTechnicianTab
								.getText();
						System.out.println(technician);

						// Get ETA Date Value
						String ETADate = label_ETADateInETAAndTechnicianTab
								.getText();
						System.out.println(ETADate);

						if (ETADate.equalsIgnoreCase("ETA Date :")) {
							// Click on ATA Tab
							tab_ATA.click();
							// Click on Edit Button In ATA Tab
							button_EditInATATab.click();
							// Get Notification
							// Thread.sleep(5000);
							String notificationText = notification.getText();
							System.out.println(notificationText);

						/*	if(notificationText.contains("SMS Sent Successfully"))
							{
								btnCloseNotification.click();
							}
							
							String notificationValue = notification.getText();
							System.out.println(notificationValue);*/
							Thread.sleep(1000);
							softAssert.assertEquals(notificationText,
									"Please Select ETA And Technician First.",
									"Notification is not Match");

						}
						break loop;

					}
				}
				if (sizePagination - 1 == p) {

					System.out.println("Ticket is not Available for Punching ETA");
					/*tab_Ticket.click();
					Thread.sleep(1000);
					tab_CreateNew.click();

					createNewPageOfSdRole = new SD_CreateNewPage();
					createNewPageOfSdRole.createNewTicket();

					ticketFromOfViewTicketPage = new SD_TicketFromOfViewTicketPage();
					tab_Ticket.click();
					Thread.sleep(1000);
					tab_ViewTicket.click();

					ticketFromOfViewTicketPage
							.displayNotificationWithoutETAInATATab();*/

				}
			}
			softAssert.assertAll();
		}

		// If user select ATA date and Time less than Incident Date and Time then
		// notification should display as ' ATA Date Time should be greater than
		// Incident Date Time '
		public void checkATADateAndTimeWithIncidentDateAndTime() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_ATADateInTable.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {
					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					if (status.equals("Open") && !ETA.equals("") && ATA.equals("")) {
						String id = list_IDInTable.get(i).getText();
						System.out.println(id);

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();

						// Get Date & Time
						// Thread.sleep(3000);
						String dateTimeText = label_DateInIncidentDateTime
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
						tab_ATA.click();
						// Click on Edit Button In ATA Tab
						button_EditInATATab.click();

						// Get System Date
						Calendar mydate = new GregorianCalendar();
						int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
						System.out.println(dayOfMonth);
						String currentDay = Integer.toString(dayOfMonth);

						// This is Optional
						// Used If you want select Previous date
						int preDay = Integer.parseInt(currentDay) - 1;
						String previousDay = Integer.toString(preDay);
						calendar_ATADetailsPage.click();

						// select Date in Calendar

						for (WebElement day : day_CalendarInATADetailsPage) {

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
						String currentDate = textbox_ATADateInATADetailsPage
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

						for (WebElement hrsofSystem : dropdown_HrsOfATATimeInATADetailsPage) {

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

						for (WebElement minOfSystem : dropdown_MinOfATATimeInATADetailsPage) {

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

						Select machineAvailable = new Select(
								dropdown_MachineAvailableInATADetailsPage);
						machineAvailable.selectByVisibleText("Yes");
						button_UpdateDetailsInATADetailsPage.click();

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

							softAssert
									.assertEquals(
											notificationText,
											"ATA Date Time should be greater than Incident Date Time",
											"Notification is not Match");
						}

						break loop;
					}
				}
				if (sizePagination - 1 == p) {
					System.out.println("Ticket is not Available for Punching ETA");

					/*tab_Ticket.click();
					Thread.sleep(1000);
					tab_CreateNew.click();

					createNewPageOfSdRole = new SD_CreateNewPage();
					createNewPageOfSdRole.createNewTicket();

					ticketFromOfViewTicketPage = new SD_TicketFromOfViewTicketPage();
					ticketFromOfViewTicketPage.punchETAAfterCreatingTicket();

					tab_Ticket.click();
					Thread.sleep(1000);
					tab_ViewTicket.click();

					ticketFromOfViewTicketPage
							.checkATADateAndTimeWithIncidentDateAndTime();*/
				}

			}
			softAssert.assertAll();
		}

		// If user select ATA date and Time less than ETA Date and Time then
		// notification should display as ' Incident Updated Successfully ' and
		// data/time should get update on ATA tab
		public void checkATADateAndTimeWithETADateAndTime() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Format Date
			String datePattern = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);

			// Format Time
			String timePattern = "HH:mm";
			DateFormat timeFormat = new SimpleDateFormat(timePattern);

			// Click on ETA and Technician Tab
			tab_ETAAndTechnician.click();
			String ETADateText = label_ETADateInETAAndTechnicianTab.getText();
			System.out.println(ETADateText);
			String ETADate = ETADateText.split("ETA Date : ")[1];
			System.out.println("ETADate" + ETADate);

			String ETATimeText = label_ETATimeInETAAndTechnicianTab.getText();
			System.out.println(ETATimeText);
			String ETATime = ETATimeText.split("ETA Time : ")[1];
			System.out.println("ETATime" + ETATime);

			// Click on ATA Tab
			tab_ATA.click();

			// Click on Edit Button In ATA Tab
			button_EditInATATab.click();

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);
			// Click on Calendar
			calendar_ATADetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInATADetailsPage) {

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
			String currentDate = textbox_ATADateInATADetailsPage
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

			for (WebElement hrsofSystem : dropdown_HrsOfATATimeInATADetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			/*
			 * // select Min in Drop down List<WebElement> allMin = driver
			 * .findElements(By .cssSelector(
			 * ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)>option"
			 * ));
			 */
			for (WebElement minOfSystem : dropdown_MinOfATATimeInATADetailsPage) {

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

			Select machineAvailable = new Select(
					dropdown_MachineAvailableInATADetailsPage);
			machineAvailable.selectByVisibleText("Yes");

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			button_UpdateDetailsInATADetailsPage.click();

			if (dateTimeOfATA.compareTo(dateTimeOfETA) <= 0
					&& dateTimeOfATA.compareTo(dateTimeOfETA) <= 0) {
				System.out
						.println("ATA Date & Time is Less than ETA Date & Time\n");

				// Get Notification
				// Thread.sleep(5000);
				String notificationText = notification.getText();
				System.out.println(notificationText);

				softAssert.assertEquals(notificationText,
						"Incident Updated Successfully",
						"Notification is not Match");
			}

		}

		// In ATA tab if user does not select Machine Available option then
		// notification should display as 'Please Select Machine Availability.'
		public void displayAlertWithoutSelectMachineAvailable() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Click on ATA Tab
			tab_ATA.click();

			// Click on Edit Button In ATA Tab
			button_EditInATATab.click();

			// Click on Update Details button in ATA Details Page
			button_UpdateDetailsInATADetailsPage.click();

			// Get the message from Alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();

			// driver.findElement(By.linkText("Cancel")).click();

			// verify alert message is Please Select Machine
			// Availability.
			softAssert.assertEquals(alertMessage,
					"Please Select Machine Availability.",
					"Alert message is not same");
			softAssert.assertAll();

		}

		// If User select 'Yes' in Machine Available option and select ATA date/time
		// then same should get reflect in ATA tab
		public void matchUpdatedDetailesOfATA() throws Exception {

			SoftAssert softAssert = new SoftAssert();
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
			String currentDay = Integer.toString(dayOfMonth);

			// Click on Calendar
			calendar_ATADetailsPage.click();

			// select Date in Calendar
			for (WebElement day : day_CalendarInATADetailsPage) {

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
			String currentDate = textbox_ATADateInATADetailsPage
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
			for (WebElement hrsofSystem : dropdown_HrsOfATATimeInATADetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down
			for (WebElement minOfSystem : dropdown_MinOfATATimeInATADetailsPage) {

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

			// Select Machine Available
			Select machineAvailable = new Select(
					dropdown_MachineAvailableInATADetailsPage);
			machineAvailable.selectByVisibleText("Yes");

			// Click on Update Details
			button_UpdateDetailsInATADetailsPage.click();

			// Click on ATA Tab
			tab_ATA.click();

			// Get ATA Date
			String ATADateText = label_ATADateInATATab.getText();
			System.out.println(ATADateText);
			String dateOfATADate = ATADateText.split("ATA Date : ")[1];
			System.out.println(dateOfATADate);

			// Get ATA Time
			String ATATimeText = label_ATATimeInATATab.getText();
			System.out.println(ATATimeText);
			String timeOfATATime = ATATimeText.split("ATA Time : ")[1];
			System.out.println(timeOfATATime);

			// Get Machine Available
			String MachineAvailableText = label_MachineAvailableInATATab.getText();
			System.out.println(MachineAvailableText);
			String MachineAvailableOfATA = MachineAvailableText
					.split("Machine Available : ")[1];
			System.out.println(MachineAvailableOfATA);

			softAssert.assertEquals(currentDate, dateOfATADate,
					"ATA Date is not same");
			softAssert.assertEquals(hrsMin, timeOfATATime, "ATA Time is not same");
			softAssert.assertEquals("Yes", MachineAvailableOfATA,
					"Machine Available is not same");
			softAssert.assertAll();

		}

		// If User select 'No' in Machine Available option and select ATA date/time
		// then control should get transfer on Pause tab
		public void pauseTheTicketAutomatically() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Format Date
			String datePattern = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);

			/*
			 * // Format Time String timePattern = "HH:mm"; DateFormat timeFormat =
			 * new SimpleDateFormat(timePattern);
			 */

			// Click on ATA Tab
			tab_ATA.click();

			// Click on Edit Button In ATA Tab
			button_EditInATATab.click();

			// Select Machine Available
			Select machineAvailable = new Select(
					dropdown_MachineAvailableInATADetailsPage);
			machineAvailable.selectByVisibleText("No");

			button_PauseReasonInATADetailsPage.click();
			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}
			// Thread.sleep(1000);
			ListOfName_ListOfPauseReasonsPage.get(0).click();
			// Thread.sleep(1000);
			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			// Click on Calendar
			calendar_AutoResumeDateInATADetailsPage.click();

			// select Date in Calendar
			for (WebElement day : dayInCalendar_AutoResumeDateInATADetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(currentDay)) {
					Thread.sleep(2000);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// Get Date in ATA Date Text box
			String currentDate = textbox_ATADateOfAutoResumeDateInATADetailsPage
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
			for (WebElement hrsofSystem : dropdown_HrsOfATATimeOfAutoResumeDateInATADetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down
			for (WebElement minOfSystem : dropdown_MinOfATATimeOfAutoResumeDateInATADetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			// Click on Update Details
			button_UpdateDetailsInATADetailsPage.click();
			// Thread.sleep(1000);
			String headingOfTab = tab_Selected.getText();
			System.out.println(headingOfTab);

			softAssert.assertEquals(headingOfTab, "Pause",
					"Selected Tab is not Same");

			softAssert.assertAll();

		}

		// Pause //

		// To check the functionality of Edit ticket-Pause tab-after click on Edit
		// button, Pause details pop-up should get open
		public void openPauseDetailsPage() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Click on Pause Tab
			tab_PauseInTicketForm.click();

			// Click on Edit Button In Pause Tab
			button_EditInPauseTab.click();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

			// Get Heading
			// Thread.sleep(5000);
			String headingOfPauseDetailsPage = title_AllTabDetailsPage.getText();
			System.out.println(headingOfPauseDetailsPage);

			softAssert.assertEquals(headingOfPauseDetailsPage, "Pause details",
					"Page is not Match");
			softAssert.assertAll();

		}

		// User should not enter manual entry in Auto Resume Date field
		public void checkAutoResumeDateField() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			/*
			 * // Click on Pause Tab tab_PauseInTicketForm.click();
			 * 
			 * // Click on Edit Button In Pause Tab button_EditInPauseTab.click();
			 */

			// send the value to check ETA Date is editable or not on
			// Auto
			// Resume
			// Date Text Box
			textbox_AutoResumeDateInPauseDetailsPage.sendKeys("2018-05-25");
			String autoResumeDate = textbox_AutoResumeDateInPauseDetailsPage
					.getAttribute("value");

			boolean isAutoResumeDateEditable;

			if (autoResumeDate.contentEquals("2018-05-25")) {

				System.out.println("Field is editable");
				isAutoResumeDateEditable = true;

			}

			else

			{

				System.out.println("Field is non editable" + autoResumeDate);
				isAutoResumeDateEditable = false;

			}

			// check field should not editable
			softAssert.assertFalse(isAutoResumeDateEditable);
			softAssert.assertAll();
			// tab_ViewTicket.click();

		}

		// If user click on list symbol of 'Reason To Pause' field, List of Pause
		// Reasons pop up should display with pause reasons
		public void displayListOfPauseReasonsPopup() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*
			 * for (String Window : driver.getWindowHandles()) {
			 * driver.switchTo().window(Window);
			 */
			// Click on List Of Pause Reasons Button
			button_ListOfPauseReasonsInPausepage.click();
			for (String listOfPauseReasons : driver.getWindowHandles()) {
				driver.switchTo().window(listOfPauseReasons);
			}

			// Get Heading
			String HeadingOflistOfPauseReasonsPage = heading_ListOfPauseReasonsPage
					.getText();
			System.out.println(HeadingOflistOfPauseReasonsPage);

			softAssert.assertEquals(HeadingOflistOfPauseReasonsPage,
					"List of Pause Reasons", "Page is not same");
			softAssert.assertAll();
			/*
			 * driver.findElement(By.cssSelector("body")).sendKeys( Keys.CONTROL +
			 * "w"); driver.switchTo().window(Window);
			 * driver.findElement(By.linkText("Cancel")).click();
			 */

		}

		// If user click on hyper link any pause reason then same should get filled
		// into Reason To Pause field
		public void displaySamePauseReason() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			for (String listOfPauseReasons : driver.getWindowHandles()) {
				driver.switchTo().window(listOfPauseReasons);
			}

			// Get Pause Reason
			String pauseReason = column_PauseReasonsInListOfPauseReasonsPage.get(1)
					.getText();
			System.out.println(pauseReason);
			driver.findElement(By.linkText(pauseReason)).click();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

			// Format Date
			String datePattern = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);

			/*
			 * // Format Time String timePattern = "HH:mm"; DateFormat timeFormat =
			 * new SimpleDateFormat(timePattern);
			 */

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Next date
			int afterDay = Integer.parseInt(currentDay) + 1;
			String nextDay = Integer.toString(afterDay);
			calendar_PauseDetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInPauseDetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(nextDay)) {
					Thread.sleep(500);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// Get Date in Resume Date Text box
			String currentDate = textbox_AutoResumeDateInPauseDetailsPage
					.getAttribute("value");
			System.out.println(currentDate);
			Date resumeDate = (Date) dateFormat.parse(currentDate);
			System.out.println(resumeDate);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hrs);
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_HrsOfAutoResumeTimeInPauseDetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_MinOfAutoResumeTimeInPauseDetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}
			button_UpdateDetailsInPauseDetailsPage.click();
			// Thread.sleep(3000);

			tab_LatestPauseInTicketForm.click();

			String pauseReasonText = label_PauseReasonInLatestPauseTab.getText();
			System.out.println(pauseReasonText);

			softAssert.assertEquals(pauseReason, pauseReasonText,
					"Pause Reason is not same");
			softAssert.assertAll();

		}

		// after completion resume date and time, In pause tab end date/time should
		// display as resume date/time
		public void matchResumeDateAndTimeAndPauseReason() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Get Pause Reason
			String pauseReason = column_PauseReasonsInListOfPauseReasonsPage.get(1)
					.getText();
			System.out.println(pauseReason);
			driver.findElement(By.linkText(pauseReason)).click();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

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
			String currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Next date
			int afterDay = Integer.parseInt(currentDay) + 1;
			String nextDay = Integer.toString(afterDay);
			calendar_PauseDetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInPauseDetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(nextDay)) {
					Thread.sleep(500);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			Thread.sleep(1000);
			// Get Date in Resume Date Text box
			String resumeDateText = textbox_AutoResumeDateInPauseDetailsPage
					.getAttribute("value");
			System.out.println(resumeDateText);
			Date resumeDate = (Date) dateFormat.parse(resumeDateText);
			System.out.println(resumeDate);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hour = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hour);
			int hours = Integer.parseInt(hour) + 2;
			String hrs = Integer.toString(hours);
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_HrsOfAutoResumeTimeInPauseDetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_MinOfAutoResumeTimeInPauseDetailsPage) {

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
			Date pauseTime = (Date) timeFormat.parse(hrsMin);
			System.out.println(pauseTime);

			/*
			 * // Format of Date Time String dateTimePattern = "yyyy-MM-dd HH:mm";
			 * DateFormat dateTimeFormat = new SimpleDateFormat(dateTimePattern);
			 */
			// concatenation of date & Time in ATA Date Time
			String pauseEndDateAndTime = resumeDateText.concat("  " + hrsMin);
			System.out.println("pauseEndDateAndTime " + pauseEndDateAndTime);
			// Date dateTimeOfATA = (Date)
			// dateTimeFormat.parse(dateTimeOfATAText);
			// System.out.println(dateTimeOfATA);

			// Click on Update Details
			button_UpdateDetailsInPauseDetailsPage.click();

			// Click on Pause Tab
			Thread.sleep(2000);

			tab_LatestPauseInTicketForm.click();
			String pauseReasonText = label_PauseReasonInLatestPauseTab.getText();
			System.out.println(pauseReasonText);

			softAssert.assertEquals(pauseReason, pauseReasonText,
					"Pause Reason is not same");

			// Get Pause End Date And Time
			String pauseEndDateAndTimeText = label_ResumeDateAndTimeInLatestPauseTab
					.getText();
			System.out.println(pauseEndDateAndTimeText);
			String pauseEndDateAndTimeInPauseTab = pauseEndDateAndTimeText
					.split(":00")[0];
			System.out.println(pauseEndDateAndTimeInPauseTab);

			softAssert.assertEquals(pauseEndDateAndTimeInPauseTab,
					pauseEndDateAndTime, "Pause End Date And Time is not same");
			softAssert.assertAll();

		}

		// If ticket is in pause state still user click on edit button of pause tab
		// then notification should display as 'Please Update ETA First.'
		public void displayNotificationWhenTicketPause() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			/*
			 * int sizePagination = dropdown_Pagination.size();
			 * System.out.println(sizePagination); loop: for (int p = 0; p <
			 * sizePagination; p++) {
			 * 
			 * dropdown_Pagination.get(p).click();
			 * 
			 * int size = list_StatusInTable.size();
			 * 
			 * System.out.println(size);
			 * 
			 * for (int i = 0; i < size; i++) {
			 * 
			 * String status = list_StatusInTable.get(i).getText();
			 * System.out.println(status);
			 * 
			 * String ETA = list_ETADateInTable.get(i).getText();
			 * System.out.println(ETA);
			 * 
			 * if (status.equalsIgnoreCase("Paused") && !ETA.equals(""))
			 * 
			 * { // get ID from list of Available Spares Window String idValue =
			 * list_IDInTable.get(i).getText(); System.out.println(idValue);
			 * ((JavascriptExecutor) driver).executeScript(
			 * "arguments[0].scrollIntoView(true);", list_IDInTable.get(i));
			 * 
			 * list_IDInTable.get(i).click();
			 * 
			 * String statusText = label_IncidentNumber.getText();
			 * System.out.println(statusText); String status1 =
			 * statusText.split("\n")[1]; System.out.println(status1); String
			 * statusPause = status1.split(" ")[2]; System.out.println("\n" +
			 * statusPause); if (statusPause.equalsIgnoreCase("Paused")) {
			 */
			// Click on Pause Tab
			tab_PauseInTicketForm.click();

			// Click on Edit button
			button_EditInPauseTab.click();

			// Get Notification
			// Thread.sleep(5000);
			String notificationText = notification.getText();
			System.out.println(notificationText);
			
		/*	if(notificationText.contains("SMS Sent Successfully"))
			{
				btnCloseNotification.click();
			}
			
			Thread.sleep(5000);
			String notificationValue = notification.getText();
			System.out.println(notificationValue);
			Thread.sleep(1000);
	*/
			softAssert.assertEquals(notificationText, "Please Update ETA First.",
					"Notification is not Match");
			softAssert.assertAll();
			/*
			 * break loop; } }
			 * 
			 * if (sizePagination - 1 == p) { System.out
			 * .println("Ticket is not Available for Punching ATA");
			 * 
			 * tab_Ticket.click(); Thread.sleep(1000); tab_CreateNew.click();
			 * 
			 * createNewPageOfSdRole = new CreateNewPageOfSdRole();
			 * createNewPageOfSdRole.createNewTicket();
			 * 
			 * ticketFromOfViewTicketPage = new TicketFromOfViewTicketPage();
			 * ticketFromOfViewTicketPage .punchETAAndATAAfterCreatingTicket();
			 * ticketFromOfViewTicketPage.pauseTheTicket();
			 * 
			 * tab_Ticket.click(); Thread.sleep(1000); tab_ViewTicket.click();
			 * 
			 * ticketFromOfViewTicketPage .displayNotificationWhenTicketPause(); } }
			 * 
			 * }
			 */
		}

		// If Pause end date Time and Total Pause Time(minutes) are filled in pause
		// tab then ticket should display as 'Open' status
		public void displayTotalPauseTimeWhenTicketOpen() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_ATADateInTable.size();
				System.out.println(size);
				for (int i = 0; i < size; i++) {

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					String Pause = list_PausedTimeInTable.get(i).getText();
					System.out.println(Pause);

					if (status.equalsIgnoreCase("Open") && !ETA.equals("")
							&& !ATA.equals("") && !Pause.equals("")) {
						// get ID from list of Available Spares Window
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();
						String statusText = label_IncidentNumber.getText();
						System.out.println(statusText);
						String status1 = statusText.split("\n")[1];
						System.out.println(status1);
						String statusPause = status1.split(" ")[2];
						System.out.println("\n" + statusPause);
						if (statusPause.equalsIgnoreCase("Open")
								|| statusPause.equalsIgnoreCase("Closed")) {
							// Click on Pause Tab
							tab_PauseInTicketForm.click();

							// Click on Edit button
							// button_EditInPauseTab.click();

							softAssert
									.assertNotNull(label_PauseEndDateTimeInPauseTab);
							softAssert
									.assertNotNull(label_TotalPauseMinutesInPauseTab);
							break loop;
						}

					}

					if (sizePagination - 1 == p) {
						System.out
								.println("Ticket is not Available for Punching ATA");

						/*tab_Ticket.click();
						Thread.sleep(1000);
						tab_CreateNew.click();

						createNewPageOfSdRole = new SD_CreateNewPage();
						createNewPageOfSdRole.createNewTicket();

						ticketFromOfViewTicketPage = new SD_TicketFromOfViewTicketPage();
						ticketFromOfViewTicketPage
								.punchETAAndATAAfterCreatingTicket();
						ticketFromOfViewTicketPage.pauseTheTicket();

						tab_Ticket.click();
						Thread.sleep(1000);
						tab_ViewTicket.click();

						ticketFromOfViewTicketPage
								.displayTotalPauseTimeWhenTicketOpen();*/
					}
				}

			}
			softAssert.assertAll();
		}

		// In Total pause time(minutes) column, number of minutes should display
		// between start date/time and end date/time
		public void countTotalPauseTimeInPauseTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Click on Pause Tab
			// tab_PauseInTicketForm.click();

			// Format of Date Time
			String dateTimePattern = "yyyy-MM-dd HH:mm";
			DateFormat dateTimeFormat = new SimpleDateFormat(dateTimePattern);

			// Get Pause Start Date And Time Text
			String pauseStartDateAndTimeText = label_PauseStartDateTimeInPauseTab
					.getText();
			System.out.println(pauseStartDateAndTimeText);
			Date pauseStartDateAndTime = (Date) dateTimeFormat
					.parse(pauseStartDateAndTimeText);
			System.out.println(pauseStartDateAndTime);

			// Get Pause End Date And Time Text
			String pauseEndDateAndTimeText = label_PauseEndDateTimeInPauseTab
					.getText();
			System.out.println(pauseEndDateAndTimeText);
			Date pauseEndDateAndTime = (Date) dateTimeFormat
					.parse(pauseEndDateAndTimeText);
			System.out.println(pauseEndDateAndTime);

			Instant startDateTime = pauseStartDateAndTime.toInstant();
			Instant endDateTime = pauseEndDateAndTime.toInstant();

			// Difference between Two Dates
			Duration duration = Duration.between(startDateTime, endDateTime);
			long dateAndTime = duration.toMinutes();
			System.out.println("Days: " + dateAndTime);
			int dateTime = (int) dateAndTime - 2;

			String min = Integer.toString(dateTime);
			System.out.println(min);

			String totalPauseMinutes = label_TotalPauseMinutesInPauseTab.getText();
			System.out.println(totalPauseMinutes);
			softAssert.assertEquals(totalPauseMinutes, min,
					"'Total Pause Minutes is not Same.'");
			softAssert.assertAll();

		}

		// If user click on edit button of Pause tab without punching ETA/ATA then
		// notification should display as 'Please Update ETA First.'
		public void displayNotificationWithoutPunchingETAAndATAInPauseTab()
				throws Exception {
			SoftAssert softAssert = new SoftAssert();

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);

			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();
				int size = list_ATADateInTable.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					if (ETA.equals("") && ATA.equals("")) {
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();

						// Click on ETA And Technician Tab
						tab_ETAAndTechnician.click();

						// Get ETA Date Value
						String ETADate = label_ETADateInETAAndTechnicianTab
								.getText();
						System.out.println(ETADate);

						// Click on ATA Tab
						tab_ATA.click();

						// Get ATA Date Value
						String ATADate = label_ATADateInATATab.getText();
						System.out.println(ATADate);

						if (ATADate.equalsIgnoreCase("ATA Date :")
								|| ETADate.equalsIgnoreCase("ETA Date :")) {
							// Click on Pause Tab
							tab_PauseInTicketForm.click();
							// Click on Edit Button In Pause Tab
							button_EditInPauseTab.click();
							// Get Notification
							// Thread.sleep(5000);
							String notificationText = notification.getText();
							System.out.println(notificationText);
							
							/*if(notificationText.contains("SMS Sent Successfully"))
							{
								btnCloseNotification.click();
							}
							Thread.sleep(5000);
							String notificationValue = notification.getText();
							System.out.println(notificationValue);*/
							Thread.sleep(1000);
							softAssert.assertEquals(notificationText,
									"Please Update ETA First.",
									"Notification is not Match");
							break loop;
						}
					}

				}

				if (sizePagination - 1 == p) {
					System.out.println("Ticket is not Available for Punching ATA");

					/*tab_Ticket.click();
					Thread.sleep(1000);
					tab_CreateNew.click();

					createNewPageOfSdRole = new SD_CreateNewPage();
					createNewPageOfSdRole.createNewTicket();

					ticketFromOfViewTicketPage = new SD_TicketFromOfViewTicketPage();

					tab_Ticket.click();
					Thread.sleep(1000);
					tab_ViewTicket.click();

					ticketFromOfViewTicketPage
							.displayNotificationWithoutPunchingETAAndATAInPauseTab();*/
				}

			}
			softAssert.assertAll();
		}

		// Spare Tab //

		// If user click on 'Update Details' button in spare details[with inventory
		// module] then notification should display as
		// 'Please Consumed or Replaced Spare, if you select spare consumed yes.'
		public void checkUpdateButtonWithoutEnteringData() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Thread.sleep(3000);
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_StatusInTable.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					if (status.equalsIgnoreCase("Open") && !ETA.equals("")
							&& !ATA.equals(""))

					{
						// get ID from list of Available Spares Window
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();
						// Thread.sleep(2000);

						// click on spare tab
						tab_SpareInTicketForm.click();

						// click on Edit button
						button_EditInSpareTab.click();

						for (String spareDetailsWindow : driver.getWindowHandles()) {

							System.out.println(spareDetailsWindow);
							driver.switchTo().window(spareDetailsWindow);

						}
						// Thread.sleep(2000);
						// Click on update button
						button_UpdateDetail.click();
						// Thread.sleep(3000);

						for (String basicWindow : driver.getWindowHandles()) {

							System.out.println(basicWindow);
							driver.switchTo().window(basicWindow);

						}

						String notificationText = notification.getText();
						System.out.println(notificationText);
						
						/*if(notificationText.contains("SMS Sent Successfully"))
						{
							btnCloseNotification.click();
						}
						Thread.sleep(5000);
						String notificationValue = notification.getText();
						System.out.println(notificationValue);
						Thread.sleep(1000);*/

						softAssert
								.assertEquals(notificationText,
										"Please Consumed or Replaced Spare, if you select spare consumed yes.");
						break loop;

					}
				}

				if (sizePagination - 1 == p)
					softAssert.assertTrue(false,
							" Ticket is not Available for Punching ATA");
			}
			softAssert.assertAll();
		}

		// If user select 'Yes' in 'Spares Consumed By Inventory
		// logistic(Y/N)'option then
		// Add spare tab should display
		public void checkSpareTabWithYesSelect() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click on spare tab
			tab_Spare.click();

			// click on Edit button
			button_EditInSpareTab.click();

			for (String spareDetailsWindow : driver.getWindowHandles()) {

				System.out.println(spareDetailsWindow);
				driver.switchTo().window(spareDetailsWindow);

			}

			// select the Spares Consumed By Inventory logistic
			Select sparesConsumed;
			sparesConsumed = new Select(dropdown_SparesConsumed);
			sparesConsumed.selectByVisibleText("Yes");

			// verify after click on "Yes" the add spare is get open or
			// not
			String textOfAddSpare = label_AddSpare.getText();
			System.out.println(textOfAddSpare);

			softAssert.assertEquals(textOfAddSpare, "Add Spare");
			// driver.findElement(By.linkText("Cancel")).click();
			softAssert.assertAll();

		}

		// If User click on list symbol of 'Spares Consumed By Inventory
		// logistic(Y/N)' title, then
		// 'List of Available Spares' pop up should display
		public void checkListOfAvailableSparesWindow() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// list symbol button in spare detail window
			button_ListSymbolOfSpareDetail.click();

			for (String listOfAvailableSparesWindow : driver.getWindowHandles()) {

				System.out.println(listOfAvailableSparesWindow);
				driver.switchTo().window(listOfAvailableSparesWindow);

			}

			String getTitleOfWindow = driver.getTitle();
			System.out.println(getTitleOfWindow);

			softAssert.assertEquals(getTitleOfWindow, "Select Inventory");
			softAssert.assertAll();

		}

		// If user click on hyper link of part name in 'List of Available Spares'
		// pop up, after select 'Yes' in list then
		// same part name should display in Add Spare tab

		public void matchPartname() throws Exception {
			SoftAssert softAssert = new SoftAssert();


			
			List<WebElement> productClassification = list_ProductClassificationInSpareDetail;
			int size1 = productClassification.size();
			System.out.println(size1);

			for (int j = 0; j < size1; j++) {
				String productClassificationValue = productClassification.get(j)
						.getText();
				System.out.println(productClassificationValue);

				String transactionTypeValue = list_TransactionTypeInSpareDetail
						.get(j).getText();
				System.out.println(transactionTypeValue);

				String partTypeValue = list_PartTypeInSpareDetail.get(j).getText();
				System.out.println(partTypeValue);

				if (productClassificationValue.equalsIgnoreCase("Component")
						&& transactionTypeValue.equalsIgnoreCase("Stock")
						&& partTypeValue.equalsIgnoreCase("Non-Consumable"))

				{

					String partName = list_PartNameInSpareDetail.get(j).getText();
					System.out.println(partName);

					// select part name from list of Available
					// Spares Window
					// driver.findElement(By.linkText(partName)).click();

					list_PartNameInSpareDetail.get(j).click();

					for (String spareDetailsWindow : driver.getWindowHandles()) {

						System.out.println(spareDetailsWindow);
						driver.switchTo().window(spareDetailsWindow);

					}
					// Thread.sleep(2000);

					// get the part name from part name text box in add spare
					String getPartName = textBox_PartName.getAttribute("value");
					System.out.println(getPartName);

					boolean partnameIsSame = true;
					if (partName.contains(getPartName)) {

						System.out.println("the partname is same");
						partnameIsSame = true;
						break;

					} else {
						System.out.println("the partname is different");
						partnameIsSame = false;

					}

					// Match both the part name
					softAssert.assertTrue(partnameIsSame);
					/*
					 * WebElement cancelButton = driver.findElement(By
					 * .linkText("Cancel")); ((JavascriptExecutor)
					 * driver).executeScript( "arguments[0].scrollIntoView(true);",
					 * cancelButton); cancelButton.click();
					 */

				} else if (j == size1 - 1) {
					// Match both the part name
					softAssert.assertTrue(false, "Spare is not Available");
					driver.findElement(By.cssSelector("body")).sendKeys(	Keys.CONTROL + "w");

					
			
			}
			}
			softAssert.assertAll();

		}

		// If User select Non consumable part from list then in Replace spare with
		// details Product Classification and Product Description should
		// display with same value present in Add Spare tab .
		public void selectNonConsumableProduct() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Thread.sleep(2000);

			// get value from Product Classification in Add
			// Spare tab
			String productClassificationValue = textBox_ProductClassificationInAddSpare
					.getAttribute("value");
			System.out.println("product Classification in add spare:-"
					+ productClassificationValue);

			// get value from Part Description in Add Spare
			// tab
			String partDescriptionValue = textBox_PartDescriptionInAddSpare
					.getAttribute("value");
			System.out.println("product Classification in add spare:-"
					+ partDescriptionValue);

			// get value from Product Classification in
			// Replace Spare tab
			String productClassificationValueInReplaceSapre = textBox_ProductClassificationInReplaceSpare
					.getAttribute("value");
			System.out.println("product Classification in add spare:-"
					+ productClassificationValueInReplaceSapre);

			// get value from Part Description in Replace Spare
			// tab
			String partDescriptionValueInReplaceSapre = textBox_PartDescriptionInReplaceSpare
					.getAttribute("value");
			System.out.println("product Classification in add spare:-"
					+ partDescriptionValueInReplaceSapre);

			// Match both the Product classification value same
			// or
			// not
			softAssert.assertEquals(productClassificationValue,
					productClassificationValueInReplaceSapre);

			// Match both the Part Description value same or not
			softAssert.assertEquals(partDescriptionValue,
					partDescriptionValueInReplaceSapre);

			softAssert.assertAll();

		}

		// If user select component part and click on update details button then
		// spare entry should display in spare tab as 'consumed' transaction type
		public void checkTransactionType() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", button_UpdateDetail);

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			// Click on update button
			button_UpdateDetail.click();

			Thread.sleep(5000);

			// click on spare tab
			tab_Spare.click();

			// Thread.sleep(1000);
			// List<WebElement> transactionTypeValueAfterUpdate
			// = list_TransactionTypeOfSapre;
			int getTotalSize = list_TransactionTypeOfSapre.size();
			System.out.println(getTotalSize);

			String getTransactionType = list_TransactionTypeOfSapre.get(
					getTotalSize - 1).getText();
			System.out.println(getTransactionType);

			// match that after click on update button
			// the Transaction type change to consumed
			softAssert.assertEquals(getTransactionType, "Consumed");

			softAssert.assertAll();
		}

		// If user select part with 'product classification' as 'Device' then
		// 'Replace spare with' tab should display to enter faulty details
		public void checkReplaceSpareWithTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on spare tab
			// tab_Spare.click();

			// click on Edit button
			button_EditInSpareTab.click();

			for (String spareDetailsWindow : driver.getWindowHandles()) {

				System.out.println(spareDetailsWindow);
				driver.switchTo().window(spareDetailsWindow);

			}

			// select the Spares Consumed By Inventory logistic
			Select sparesConsumed;
			sparesConsumed = new Select(dropdown_SparesConsumed);
			sparesConsumed.selectByVisibleText("Yes");

			// list symbol button in spare detail window
			button_ListSymbolOfSpareDetail.click();

			for (String listOfAvailableSparesWindow : driver.getWindowHandles()) {

				System.out.println(listOfAvailableSparesWindow);
				driver.switchTo().window(listOfAvailableSparesWindow);

			}

			List<WebElement> productClassificationName = list_ProductClassificationInSpareDetail;
			System.out.println("product Classification Name:-"
					+ productClassificationName.size());

			for (int j = 0; j < productClassificationName.size(); j++) {

				String productClassificationValue = productClassificationName
						.get(j).getText();

				String partTypeValue = list_PartTypeInSpareDetail.get(j).getText();
				System.out.println(partTypeValue);

				String transactionType = list_TransactionTypeInSpareDetail.get(j)
						.getText();
				System.out.println(transactionType);

				if (productClassificationValue.equalsIgnoreCase("Device")
						&& partTypeValue.equalsIgnoreCase("Non-Consumable")
						&& transactionType.equalsIgnoreCase("Stock"))

				{
					String partName = list_PartNameInSpareDetail.get(j).getText();
					System.out.println(partName);

					// select part name from list of Available
					// Spares Window
					// driver.findElement(By.linkText(partName)).click();
					list_PartNameInSpareDetail.get(j).click();
					for (String spareDetailsWindow : driver.getWindowHandles()) {

						System.out.println(spareDetailsWindow);
						driver.switchTo().window(spareDetailsWindow);

					}
					// Thread.sleep(2000);

					String textOfReplaceSpareWithTab = label_ReplaceSpareWith
							.getText();
					System.out.println(textOfReplaceSpareWithTab);

					// match that replace spare tab is open or not
					softAssert.assertEquals(textOfReplaceSpareWithTab,
							"Replace spare with");
					break;
				} else if (j == productClassificationName.size() - 1) {
					// Match both the part name
					softAssert.assertTrue(false, "Spare is not Available");
				}
			}
			softAssert.assertAll();
		}

		// If user not selecting part code option in Part code field and click on
		// Update details button
		// then notification should display as 'Please select Part Code..!
		public void matchNotificationOfWithoutPartCode() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			button_UpdateDetail.click();
			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();

			// Match the alert is Please select Part Code..!
			// or not
			softAssert.assertEquals(alertMessage, "Please select Part Code..!");
			softAssert.assertAll();

		}

		// In Replace spare with tab-> Part code field if user select 'Replace with
		// Another Part Code' option then
		// part code list should display related to selected part code.
		public void checkPartCodeField() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			String partNameValue = textBox_PartName.getAttribute("value");
			System.out.println("part name in Add Spare tab:-" + partNameValue);

			// Thread.sleep(1000);
			String partCodeValueInReplaceWithTab = dropdown_PartCodeInReplaceSpare
					.getText();
			System.out.println(partCodeValueInReplaceWithTab);

			Select samePartCodeInRepaceTab;
			samePartCodeInRepaceTab = new Select(dropdown_PartCodeInReplaceSpare);
			samePartCodeInRepaceTab
					.selectByVisibleText("Replace With Same PartCode");

			Select anotherPartCodeInRepaceTab;
			anotherPartCodeInRepaceTab = new Select(dropdown_PartCodeInReplaceSpare);
			anotherPartCodeInRepaceTab
					.selectByVisibleText("Replace With Another PartCode");
			Thread.sleep(500);

			List<WebElement> anotherPartCodeList = dropdown_ListOfAnotherPartCodeInReplaceSpare;
			System.out.println("NUMBER OF ROWS IN THIS TABLE = "
					+ anotherPartCodeList.size());

			for (int k = 0; k < anotherPartCodeList.size() - 1; k++) {

				String afterSelect = anotherPartCodeList.get(k + 1).getText();
				System.out.println(afterSelect);
				softAssert.assertTrue(afterSelect.contains(partNameValue));
				System.out
						.println("The option is related to same part name in Add Spare");
				anotherPartCodeList.get(k + 1).click();

			}

			softAssert.assertAll();
		}

		// If user not selecting status in Replace spare with tab then notification
		// should display as 'Please select Part Status..!'
		public void matchNotificationOfWithoutStatus() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			button_UpdateDetail.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// Match the alert is Please select Part Code..! or
			// not
			softAssert.assertEquals(alertMessage, "Please select Part Status..!");
			softAssert.assertAll();

		}

		// If user doesn't enter serial number while Replacement then auto generated
		// serial number should get generated and
		// should display in technician's stock
		public void CheckWithoutEnteringSerialNumber() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			
			// select the status
			Select statusDropdown;
			statusDropdown = new Select(dropdown_Status);
			statusDropdown.selectByVisibleText("Faulty");
			// Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			// click on update button
			button_UpdateDetail.click();
			// WebDriverWait wait = new WebDriverWait(driver,
			// 100);
			// //you can play with the time integer to wait for
			// longer than 15 seconds.`
			// wait.until(ExpectedConditions.titleContains("title"));
			// driver.manage().timeouts().pageLoadTimeout(300,
			// TimeUnit.SECONDS);
			// Thread.sleep(1000);
			/*
			 * // click on spare tab tab_Spare.click(); Thread.sleep(1000);
			 */

			List<WebElement> serialNumberValueAfterUpdate = list_SerialNumberOfSapre;
			int getSize = serialNumberValueAfterUpdate.size();
			System.out.println(getSize);

			String getSerialNumber = list_SerialNumberOfSapre.get(getSize - 1)
					.getText();
			System.out.println(getSerialNumber);

			// Match that without selecting serial number
			// the serial number is generate or not
			softAssert.assertNotNull(getSerialNumber);

			// Match the notification
			String notificationValue = notification.getText();
			System.out.println(notificationValue);

			// match the spare get update or not
			softAssert
					.assertEquals(notificationValue, "Spare Updated Successfully");
			softAssert.assertAll();

		}

		// If User Replace spare with faulty spare and click on Update details
		// button then on spare tab, replaced entry should display with part details
		// and new serial number and replacement entry transaction type should be
		// 'Replaced'

		public void checkWithFaultySpare() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			tab_Spare.click();

			Thread.sleep(1000);
			List<WebElement> transactionTypeValueAfterUpdate = list_TransactionTypeOfSapre;
			int getTotalSize = transactionTypeValueAfterUpdate.size();
			System.out.println(getTotalSize);

			String getTransactionType = list_TransactionTypeOfSapre.get(
					getTotalSize - 1).getText();
			System.out.println(getTransactionType);

			String getStatus = list_StatusOfSapre.get(getTotalSize - 1).getText();
			System.out.println(getStatus);

			// match that after click on update button the
			// Transaction type change
			// to Replaced
			softAssert.assertEquals(getTransactionType, "Replaced");

			// match the serial number is change or nor
			softAssert.assertEquals(getStatus, "Faulty");
			softAssert.assertAll();

		}

		// If user replace Device in spare tab then while technician close with
		// serial number field notification should display as
		// 'This serial no will get updated the new serial no for TID/Asset ID. Next
		// time the call is logged for this TID the updated serial no will be shown.
		public void matchTechnicianCloseMessageWithDevice() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click on Technician close tab
			tab_TechnicianClose.click();

			// click on edit button
			button_EditOfTechncianClose.click();

			// get the message from technician close
			// tab->edit->serial No.
			String message = message_SerialNumber.getText();
			System.out.println(message);

			softAssert
					.assertEquals(
							message,
							"*This serial no will get updated the new serial no for TID/Asset ID. Next time the call is logged for this TID the updated serial no will be shown.");

			Thread.sleep(500);
			WebElement cancelButton = driver.findElement(By.linkText("Cancel"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", cancelButton);
			cancelButton.click();

			softAssert.assertAll();

		}


		// In Spare tab after click on edit button pop up should get open
		public void openSpareDetailsPage() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on search ticket tab

			// Click on Spare Tab
			tab_SpareInTicketForm.click();

			// Click on Edit Button In Pause Tab
			button_EditInSpareTab.click();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

			// Get Heading
			// Thread.sleep(5000);
			String headingOfSpareDetailsPage = title_AllTabDetailsPage.getText();
			// log("Heading of Spare Details Page: " +
			// headingOfSpareDetailsPage);
			System.out.println("Heading of Spare Details Page: "
					+ headingOfSpareDetailsPage);

			softAssert.assertTrue(
					(headingOfSpareDetailsPage.contains("Spare Details")),
					"Page is not Match");
			Reporter.log("Page is Match");
			System.out.println("Page is Match");
			softAssert.assertAll();

		}

		// If User click on Add button without select any details in Required
		// Spare[With Inventory module] tab, then alert box should display as
		// 'Please Select part name'
		public void checkNotificationWithoutSelectionInSpareDetailsPage()
				throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Required Spare In Spare Tab
			tab_RequiredSpareInSpareTab.click();
			// Thread.sleep(2000);

			// Click on Add Button
			button_AddInRequiredSpareTab.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			// Thread.sleep(1000);
			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();
			// Thread.sleep(1000);

			// verify that alert message
			softAssert.assertEquals(alertMessage, "Please Select partname");
			System.out.println("\nAlert Message is Correct");

			// alert box should display as 'Please Select the Quantity'
			Select selectPartName = new Select(dropdown_PartNameInRequiredSpareTab);
			selectPartName.selectByIndex(1);

			// Click on Add button
			button_AddInRequiredSpareTab.click();

			// get the message from that alert box
			Alert alertForPartCode = driver.switchTo().alert();
			// Thread.sleep(1000);

			String alertMessageForPartCode = alertForPartCode.getText();
			System.out.println("\nAlert Text:" + alertMessageForPartCode);
			alert.accept();
			driver.switchTo().defaultContent();
			Thread.sleep(500);

			// verify that alert message
			softAssert.assertEquals(alertMessageForPartCode,
					"Please Enter The Quantity");
			System.out.println("Alert Message is Correct");

			// alert box should display as 'Please Select Spare Delivery
			// Location'
			Select selectPartCode = new Select(dropdown__PartCodeInRequiredSpareTab);
			selectPartCode.selectByIndex(1);

			/*
			 * Alert alert2 = driver.switchTo().alert();
			 * 
			 * alert2.accept();
			 */
			// Enter Quantity
			textbox__QuantityInRequiredSpareTab.sendKeys("5");

			// Click on Add Button
			button_AddInRequiredSpareTab.click();

			// Get the message from Alert box
			Alert alertForLocation = driver.switchTo().alert();
			String alertMessageForLocation = alertForLocation.getText();
			System.out.println("\nAlert Text:" + alertMessageForLocation);
			alert.accept();
			driver.switchTo().defaultContent();
			// Thread.sleep(1000);

			// verify that alert message
			softAssert.assertEquals(alertMessageForLocation,
					"Please Select Spare Delivry Location");
			System.out.println("Alert Message is Correct");
			// driver.findElement(By.linkText("Cancel")).click();
			softAssert.assertAll();

		}

		// After enter all mandatory details if user click on Add button then entry
		// should made in Required Spare[With Inventory module] tab and same entry
		// should display in edit ticket->Spare tab and notification should display
		// as 'Spare Added Successfully'

		public void checkNotificationWithSelectionInSpareTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// alert box should display as 'Please Select the Quantity'
			Select selectPartName = new Select(dropdown_PartNameInRequiredSpareTab);
			List<WebElement> listOfPartName = selectPartName.getOptions();

			String partName = listOfPartName.get(2).getAttribute("value");
			System.out.println("\npartName: " + partName);

			selectPartName.selectByIndex(2);
			Thread.sleep(500);

			Select selectPartCode = new Select(dropdown__PartCodeInRequiredSpareTab);
			List<WebElement> listOFPartCode = selectPartCode.getOptions();
			Thread.sleep(500);
			String partCode = listOFPartCode.get(1).getAttribute("value");
			System.out.println("\npartCode: " + partCode);

			selectPartCode.selectByIndex(1);
			Thread.sleep(1000);

			/*
			 * Alert alert = driver.switchTo().alert();
			 * 
			 * alert.accept(); // driver.switchTo().defaultContent();
			 * Thread.sleep(500);
			 */

			textbox__QuantityInRequiredSpareTab.clear();
			// Enter Quantity
			String quantity = "5";
			textbox__QuantityInRequiredSpareTab.sendKeys(quantity);

			Select selectLocation = new Select(dropdown_LocationInRequiredSpareTab);
			List<WebElement> listOFLocation = selectLocation.getOptions();

			String location = listOFLocation.get(1).getAttribute("value");
			System.out.println("\nLocation: " + location);

			selectLocation.selectByIndex(1);

			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// Click on Add Button
			button_AddInRequiredSpareTab.click();

			// Get Notification
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			String notificationText = notification.getText();
			System.out.println(notificationText);

			softAssert.assertEquals(notificationText, "Spare Added Successfully",
					"Notification is not Match");
			Thread.sleep(500);
			int size1 = label_PartNameInSpareTab.size() - 1;
			String partNameInSpareTab = label_PartNameInSpareTab.get(size1)
					.getText();
			System.out.println(partNameInSpareTab);

			String partCodeInSpareTab = label_PartCodeInSpareTab.get(size1)
					.getText();
			System.out.println(partCodeInSpareTab);

			String quantityInSpareTab = label_QuantityInSpareTab.get(size1)
					.getText();
			System.out.println(quantityInSpareTab);

			String locationInSpareTab = label_LocationInSpareTab.get(size1)
					.getText();
			System.out.println(locationInSpareTab);

			softAssert.assertEquals(partName, partNameInSpareTab,
					"Part Name is not Match");
			softAssert.assertEquals(partCode, partCodeInSpareTab,
					"Part Code is not Match");
			softAssert.assertEquals(quantity, quantityInSpareTab,
					"quantity is not Match");
			softAssert.assertEquals(location, locationInSpareTab,
					"location is not Match");

			softAssert.assertAll();

		}

		// In Spare tab-> Required Spare[With Inventory Module], if user click on
		// update symbol of spare request then 'Update Spare Remark' pop up should
		// get open
		public void checkPopupOfUpdateSymbolInSpareTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Spare Tab
			tab_SpareInTicketForm.click();

			// Click on Update Button In Pause Tab
			try {
				symbol_UpdateInSpareTab.get(0).click();

				for (String sdWindow : driver.getWindowHandles()) {
					driver.switchTo().window(sdWindow);
				}
				Thread.sleep(500);

				String heading = heading_UpdateSpareRemarkPopup.getText();
				System.out.println(heading);
				driver.findElement(
						By.xpath(".//*[@id='boxsr']/div/table/tbody/tr[1]/th[3]/img"))
						.click();
				softAssert.assertEquals("Update Spare Remark", heading,
						"Pop up is not Same");

			} catch (Exception e) {

				softAssert.assertTrue(false, " Spare is not Available");
			}

			softAssert.assertAll();
		}

		// If in 'Update Spare Remark' pop up user enter remark and click on update
		// button then same should display in spare Remark column in spare tab
		public void checkUpdatedSpareRemarkInSpareTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Thread.sleep(1000);

			String remark = "Ok";
			textbox_SpareRemarkInUpdateSpareRemarkPopup.clear();
			textbox_SpareRemarkInUpdateSpareRemarkPopup.sendKeys(remark);
			button_UpdateInUpdateSpareRemarkPopup.click();
			// Thread.sleep(1000);
			String SpareRemark = label_SpareRemarkInSpareTab.get(0).getText();
			System.out.println(SpareRemark);
			softAssert
					.assertEquals(SpareRemark, remark, "Spare Remark is not Same");
			softAssert.assertAll();

		}

		// If User click on Remove button in Required Spare[With Inventory module]
		// tab entry, then entry should get remove from Required Spare[With
		// Inventory module] tab
		public void checkRemoveDetailsInRequiredSpareTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Spare Tab
			tab_SpareInTicketForm.click();

			int sizeBeforeRemove = row_TableInSpareTab.size();
			System.out.println(sizeBeforeRemove);

			// Click on Edit Button In Pause Tab
			button_EditInSpareTab.click();

			for (String sdWindow : driver.getWindowHandles()) {
				driver.switchTo().window(sdWindow);
			}
			// Thread.sleep(1000);

			// Click on Required Spare In Spare Tab
			tab_RequiredSpareInSpareTab.click();
			// Thread.sleep(1000);

			try {
				button_RemoveInRequiredSpareTab.get(0).click();

				int sizeAfterRemove = row_TableInSpareTab.size();
				System.out.println(sizeAfterRemove);
				softAssert.assertEquals(sizeAfterRemove, sizeBeforeRemove - 1,
						"Row Size is not Same");

			} catch (Exception e) {
				softAssert.assertTrue(false, "Spare is not Available");
				button_Cancel.click();

			}
			softAssert.assertAll();

		}
		
		// If user select Intransit spare from 'List of Available Spares' pop up and
		// click on update details button then notification should display
		// as 'Please Check This Spare is In Transit.. '

		public void matchNotificationAfterSelectInTransitSpare() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			for (String Window : driver.getWindowHandles()) {

				System.out.println(Window);
				driver.switchTo().window(Window);

				// click on spare tab
				tab_SpareInTicketForm.click();

				// click on Edit button
				button_EditInSpareTab.click();

				for (String spareDetailsWindow : driver.getWindowHandles()) {

					System.out.println(spareDetailsWindow);
					driver.switchTo().window(spareDetailsWindow);

					// select the Spares Consumed By Inventory logistic
					Select sparesConsumed;
					sparesConsumed = new Select(dropdown_SparesConsumed);
					sparesConsumed.selectByVisibleText("Yes");

					// list symbol button in spare detail window
					button_ListSymbolOfSpareDetail.click();

					for (String listOfAvailableSparesWindow : driver
							.getWindowHandles()) {

						System.out.println(listOfAvailableSparesWindow);
						driver.switchTo().window(listOfAvailableSparesWindow);

					}

					List<WebElement> transactionType = list_TransactionTypeInSpareDetail;
					int sizeOfSpare = transactionType.size();
					System.out.println(sizeOfSpare);

					for (int j = 0; j < transactionType.size(); j++) {

						String transactionTypeValue = transactionType.get(j)
								.getText();
						System.out.println(transactionTypeValue);

						if (transactionTypeValue.equalsIgnoreCase("In Transit"))

						{
							// get part name from list of Available Spares
							// Window
							String partName = list_PartNameInSpareDetail.get(j)
									.getText();
							System.out.println(partName);

							// select part name from list of Available Spares
							// Window
							//driver.findElement(By.linkText(partName)).click();
							list_PartNameInSpareDetail.get(j).click();
							
							driver.switchTo().window(spareDetailsWindow);
							Select samePartCodeInRepaceTab;
							samePartCodeInRepaceTab = new Select(dropdown_PartCodeInReplaceSpare);
							samePartCodeInRepaceTab
									.selectByVisibleText("Replace With Same PartCode");
							
							// select the status
							Select statusDropdown;
							statusDropdown = new Select(dropdown_Status);
							statusDropdown.selectByVisibleText("Faulty");

							// Thread.sleep(2000);
							// Click on update button
							button_UpdateDetail.click();
							driver.manage().timeouts()
									.pageLoadTimeout(10, TimeUnit.SECONDS);
							// Thread.sleep(3000);

							for (String basicWindow : driver.getWindowHandles()) {

								System.out.println(basicWindow);
								driver.switchTo().window(basicWindow);

							}

							Thread.sleep(1000);

							String textOfNotification = notification.getText();
							System.out.println(textOfNotification);

							softAssert.assertEquals(textOfNotification,
									"Please Check This Spare is In Transit..");

						}

						if (sizeOfSpare - 1 == j) {
							System.out.println("Fail........");

							softAssert.assertTrue(false, "Spare is not Available.");

							driver.findElement(By.cssSelector("body")).sendKeys(
									Keys.CONTROL + "w");

							driver.switchTo().window(Window);
							// button_Cancel.click();
						}
					}

				}
			}

			softAssert.assertAll();
		}


		public void addRequiredSpare() throws Exception {

			// Click on Edit Button In Pause Tab
			button_EditInSpareTab.click();

			for (String sdWindow : driver.getWindowHandles()) {
				driver.switchTo().window(sdWindow);
			}

			// Click on Required Spare In Spare Tab
			tab_RequiredSpareInSpareTab.click();
			// Thread.sleep(2000);

			// select part name
			Select selectPartName = new Select(dropdown_PartNameInRequiredSpareTab);
			List<WebElement> listOfPartName = selectPartName.getOptions();

			String partName = listOfPartName.get(2).getAttribute("value");
			System.out.println("\npartName: " + partName);

			selectPartName.selectByIndex(2);
			Thread.sleep(500);

			// select part code
			Select selectPartCode = new Select(dropdown__PartCodeInRequiredSpareTab);
			List<WebElement> listOFPartCode = selectPartCode.getOptions();
			Thread.sleep(500);
			String partCode = listOFPartCode.get(1).getAttribute("value");
			System.out.println("\npartCode: " + partCode);

			selectPartCode.selectByIndex(1);
			/*
			 * Thread.sleep(1000); Alert alert = driver.switchTo().alert();
			 * alert.accept();
			 */
			// driver.switchTo().defaultContent();
			Thread.sleep(500);

			// Enter Quantity
			String quantity = "5";
			textbox__QuantityInRequiredSpareTab.sendKeys(quantity);

			Select selectLocation = new Select(dropdown_LocationInRequiredSpareTab);
			List<WebElement> listOFLocation = selectLocation.getOptions();

			String location = listOFLocation.get(1).getAttribute("value");
			System.out.println("\nLocation: " + location);

			selectLocation.selectByIndex(1);

			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// Click on Add Button
			button_AddInRequiredSpareTab.click();

			Thread.sleep(500);

		}

		// If User click on Add Remark button then alert box should display with
		// text box to enter remark
		public void checkAlertPopup() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				// Click on search ticket tab
				int size = list_StatusInTable.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					if (status.equalsIgnoreCase("Open") && !ETA.equals("")
							&& !ATA.equals(""))

					{
						// get ID from list of Available Spares Window
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();

						// Click on Spare Tab
						tab_RemarkInTicketForm.click();

						// Click on Add Remark Button In Remark Tab
						button_AddRemarkInRemarkTab.click();

						for (String Window : driver.getWindowHandles()) {

							System.out.println(Window);
							driver.switchTo().window(Window);

						}

						String windowValue = label_AddRemark.getText();
						System.out.println(windowValue);

						// verify that alert message is Please Enter The Numeric
						// Value for Incident ID or not
						softAssert.assertEquals("Add Remark", windowValue);

						System.out.println("Both the message is equal");

						// button_Cancel.click();

						break loop;

					}
				}
				if (sizePagination - 1 == p) {
					Assert.assertTrue(false, " Ticket is not Available");
				}
			}
			softAssert.assertAll();
		}

		// If User click on OK button without enter data in text box then
		// notification should display as 'Please Enter Remark..!'
		public void checkAlertPopupWithoutData() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Add Remark")).click();

			Thread.sleep(1000);
			// get the message from that alert box
			/*
			 * Alert alert = driver.switchTo().alert(); // Thread.sleep(3000);
			 * 
			 * String alertMessage = alert.getText();
			 * System.out.println("Alert Text:" + alertMessage); alert.accept();
			 */

			Alert alertWithoutData = driver.switchTo().alert();
			Thread.sleep(1000);

			String alertMessageWithoutData = alertWithoutData.getText();
			System.out.println("Alert Text:" + alertMessageWithoutData);
			alertWithoutData.accept();

			// driver.switchTo().defaultContent();

			// verify that alert message is Please Enter The Numeric
			// Value
			// for
			// Incident ID or not
			softAssert.assertEquals("Please Enter Remark", alertMessageWithoutData);

			System.out.println("Both the message is equal");
			softAssert.assertAll();

		}

		// If User click on OK button after enter data in text box then entry should
		// not get generate same remark value, Remark date/time and login role
		// 'remark by' column
		public void checkRemarkInRemarkTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			Thread.sleep(1000);

			String remark = "Ok";
			textbox_Remark.sendKeys(remark);

			driver.findElement(By.linkText("Add Remark")).click();

			Thread.sleep(200);
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);

			String alertMessageWithoutVisibility = alert.getText();
			System.out.println("Alert Text:" + alertMessageWithoutVisibility);
			alert.accept();

			softAssert.assertEquals(alertMessageWithoutVisibility,
					"Please Select Visibility");

			Select visibitity;
			visibitity = new Select(dropdown_Visibility);
			visibitity.selectByIndex(1);

			driver.findElement(By.linkText("Add Remark")).click();

			int size1 = row_TableInRemarkTab.size() - 3;
			String remarkInRemarkTab = label_RemarkInRemarkTab.get(size1).getText();
			System.out.println(remarkInRemarkTab);

			String user = link_Bhagyashree.getText();
			System.out.println(user);

			String remarkByInRemarkTab = label_RemarkByInRemarkTab.get(size1)
					.getText();
			System.out.println(remarkByInRemarkTab);

			softAssert
					.assertEquals(remark, remarkInRemarkTab, "Remark is not same");
			System.out.println("Both the Remark is equal");

			softAssert.assertEquals(remarkByInRemarkTab, user, "User is not same");
			System.out.println("Both the message is equal");
			softAssert.assertAll();

		}

		// If User click on Cancel button without enter data in text box then alert
		// box should get close
		public void checkAlertPopupAfterCancel() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Get Title of Page
			String title = driver.getTitle();
			System.out.println("Title: " + title);

			// Count the row in Remark Tab
			int size1 = row_TableInRemarkTab.size();
			System.out.println(size1);

			// Click on Add Remark Button In Remark Tab
			button_AddRemarkInRemarkTab.click();

			driver.findElement(By.linkText("Cancel")).click();
			Thread.sleep(1000);

			driver.switchTo().defaultContent();

			String titleAfterClosePopup = driver.getTitle();
			System.out.println("Title: " + titleAfterClosePopup);

			// Count the row in Remark Tab
			int sizeAfterClosePopup = row_TableInRemarkTab.size();
			System.out.println(sizeAfterClosePopup);

			softAssert.assertEquals(title, titleAfterClosePopup);
			softAssert.assertEquals(size1, sizeAfterClosePopup);

			System.out.println("Both Title is equal");
			System.out.println("Both Size is equal");
			softAssert.assertAll();

		}

		// Activity tab

		// If user click on Add activity button then Add Activity Pop Up should get
		// open
		public void matchAddActivityPopUp() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click on activities tab
			tab_Activities.click();

			// click on add remark
			button_AddActivityOfActivities.click();

			// get the message from Technician Assign And ETA Details
			// window
			// window handler

			for (String addActivityWindow : driver.getWindowHandles()) {

				System.out.println(addActivityWindow);
				driver.switchTo().window(addActivityWindow);

			}

			String textOfAddActivityWindow = lable_AddActivityWindow.getText();
			System.out.println(textOfAddActivityWindow);

			// verify that the window is TSD Assign Details window or
			// not
			softAssert.assertEquals(textOfAddActivityWindow, "Add Activity");
			System.out.println("Both the message is equal");
			softAssert.assertAll();

		}

		// If user click on submit button with blank details then notification
		// should display as
		// 'Please select Activity.'
		public void checkWithBlankDate() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on submit button
			button_Submit.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// verify that alert message isPlease select Activity.or not
			softAssert.assertEquals(alertMessage, "Please select Activity.");
			System.out.println("Both the message is equal");

			softAssert.assertAll();

		}

		// If user click on submit button without select Activity status from list
		// then notification should display as
		// 'Please select Activity Status.'
		public void checkWithoutSelectingActivityStatus() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// select the Activity
			Select activityStatus;
			activityStatus = new Select(dropdown_Activity);
			activityStatus.selectByVisibleText("Additional Activity");
			Thread.sleep(3000);

			// click on submit button
			button_Submit.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// verify that alert message is Please select Activity.or
			// not
			softAssert.assertEquals(alertMessage, "Please select Activity Status.");
			System.out.println("Both the message is equal");
			softAssert.assertAll();

		}

		// If user click on submit button without enter Activity details in details
		// field then notification should display as 'Please enter Activity Details.
		public void checkWithoutSelectingActivityDetails() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// select the Activity status
			Select activityStatus;
			activityStatus = new Select(dropdown_ActivityStatus);
			activityStatus.selectByVisibleText("Complete");
			Thread.sleep(3000);

			// click on submit button
			button_Submit.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// verify that alert message is Please select Activity.or
			// not
			softAssert.assertEquals(alertMessage, "Please enter Activity Details.");
			System.out.println("Both the message is equal");

			// write in detail in detail text box
			textbox_ActivityDetail.sendKeys("abc");

			// click on submit button
			button_Submit.click();
			softAssert.assertAll();

		}

		// If User enter all details in Add Activity Pop up then entry should made
		// in Activity tab details with current date/time
		// login role in Updated by column
		public void matchDateAndTime() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on activities tab
			// tab_Activities.click();

			// Get Activity date and time
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			int dateSize = list_DateOfActivities.size();
			String activityDate = list_DateOfActivities.get(dateSize - 1).getText();
			System.out.println(activityDate);
			Date formateDate = dateFormat.parse(activityDate);
			String dateformat = dateFormat.format(formateDate);
			Date date = dateFormat.parse(dateformat);
			String dateValue = dateFormat.format(date);
			System.out.println("Activity Date :-" + dateValue);

			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			int timeSize = list_TimeOfActivities.size();
			String activityTime = list_TimeOfActivities.get(timeSize - 1).getText();
			System.out.println(activityTime);
			Date formateTime = timeFormat.parse(activityTime);
			String timeformat = timeFormat.format(formateTime);
			Date time = timeFormat.parse(timeformat);
			String timeValue = timeFormat.format(time);
			System.out.println("Activity Time:-" + timeValue);

			// get current date and time
			Date systemDate = new Date();

			String formatSystemDate = dateFormat.format(systemDate);
			Date actualSystemDate = dateFormat.parse(formatSystemDate);
			String SystemDateValue = dateFormat.format(actualSystemDate);
			System.out.println("System Date:-" + SystemDateValue);

			String formatSystemTime = timeFormat.format(systemDate);
			Date actualSystemTime = timeFormat.parse(formatSystemTime);
			String SystemTimeValue = timeFormat.format(actualSystemTime);
			System.out.println("System Time:-" + SystemTimeValue);

			softAssert.assertEquals(dateValue, SystemDateValue, "Date is not Same");
			softAssert.assertEquals(timeValue, SystemTimeValue, "Time is not Same");
			softAssert.assertAll();
		}

		// Required Spare [Without Inventory Module]
		// If user click on Required Spare [Without Inventory Module] title then tab
		// should display with fields to enter part details
		public void checkNotificationWithoutSelectionInWithoutInventoryModule()
				throws Exception {
			// Click on search ticket tab
			tab_SearchTicketOpen.click();

			// Enter Id in Search Id Tab
			tab_SearchId.sendKeys("739");

			// Click on Go button
			button_GoOfId.click();

			// Click on Id in Table
			Thread.sleep(1000);
			id_InTable.click();

			// Click on Spare Tab
			tab_SpareInTicketForm.click();

			// Click on Edit Button In Pause Tab
			button_EditInSpareTab.click();

			for (String sdWindow : driver.getWindowHandles()) {
				driver.switchTo().window(sdWindow);
			}
			Thread.sleep(1000);

			// Click on Required Spare In Spare Tab
			tab_RequiredSpareInSpareTab.click();
			Thread.sleep(2000);

			// Click on Add Button
			button_AddInRequiredSpareTab.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			// verify that alert message
			Assert.assertEquals(alertMessage, "Please Select partname");
			System.out.println("\nAlert Message is Correct");

			// alert box should display as 'Please Select the Quantity'
			Select selectPartName = new Select(dropdown_PartNameInRequiredSpareTab);
			selectPartName.selectByIndex(1);

			// Click on Add button
			button_AddInRequiredSpareTab.click();

			// get the message from that alert box
			Alert alertForCartCode = driver.switchTo().alert();
			Thread.sleep(1000);

			String alertMessageForPartCode = alertForCartCode.getText();
			System.out.println("\nAlert Text:" + alertMessageForPartCode);
			alert.accept();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			// verify that alert message
			Assert.assertEquals(alertMessageForPartCode,
					"Please Enter The Quantity");
			System.out.println("Alert Message is Correct");

			// alert box should display as 'Please Select Spare Delivery Location'
			Select selectPartCode = new Select(dropdown__PartCodeInRequiredSpareTab);
			selectPartCode.selectByIndex(1);

			// Enter Quantity
			textbox__QuantityInRequiredSpareTab.sendKeys("5");

			// Click on Add Button
			button_AddInRequiredSpareTab.click();

			// Get the message from Alert box
			Alert alertForLocation = driver.switchTo().alert();
			String alertMessageForLocation = alertForLocation.getText();
			System.out.println("\nAlert Text:" + alertMessageForLocation);
			alert.accept();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			// verify that alert message
			Assert.assertEquals(alertMessageForLocation,
					"Please Select Spare Delivry Location");
			System.out.println("Alert Message is Correct");

		}

		// After click on VCT tab then Purchase order title should display with
		// Create PO button
		public void checkHeadingOfVCTTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Click on Spare Tab
			tab_VCTInTicketForm.click();

			// Get Heading of VCT Tab
			String heading = heading_VCTTab.getText();
			System.out.println("Heading: " + heading);

			softAssert.assertTrue(heading.contains("Purchase Order"),
					"Heading is not same");
			System.out.println("Heading is same");
			softAssert.assertAll();

		}

		// If User click on Create PO button then 'Vendor Commercial PO Details' pop
		// up should display
		public void checkHeadingOfVendorCommercialPODetailsPopup() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Click on Create Tab
			button_CreatePOInVCTTab.click();

			// Get Heading of Vendor Commercial PO Details Pop up
			String heading = heading_VendorCommercialPODetailsPopup.getText();
			System.out.println("Heading: " + heading);

			softAssert.assertTrue(heading.contains("Vendor Commercial PO Details"),
					"Heading is not same");
			System.out.println("Heading is same");
			softAssert.assertAll();

		}

		// If user click on Submit button without select vendor in 'Vendor
		// Commercial PO Details' pop up then notification should display as 'Please
		// Select Vendor'
		public void checkNotificationWithoutVendor() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Click on Submit Button
			button_SubmitInCommercialPODetailsPopup.click();

			// get the message from alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			driver.switchTo().defaultContent();

			softAssert.assertEquals(alertMessage, "Please Select Vendor",
					"Alert message is Incorrect");

			System.out.println("Alert message is Correct");
			softAssert.assertAll();

		}

		// In 'Vendor Commercial PO Details' pop up if user enter value then same
		// should get auto fill in Amount field
		public void checkAmountInVendorCommercialPODetailsPopup() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			String quantity = textbox_QuantityInVCTTab.getAttribute("value");
			int quantityInt = Integer.parseInt(quantity);
			System.out.println(quantityInt);

			String rate = "2";
			int rateInt = Integer.parseInt(rate);
			textbox_RateInVCTTab.sendKeys(rate);

			int amountInt = quantityInt * rateInt;
			System.out.println(amountInt);

			String amount = textbox_AmountInVCTTab.getAttribute("value");
			int amountValue = Integer.parseInt(amount);
			System.out.println(amountValue);

			softAssert.assertEquals(amountInt, amountValue);
			softAssert.assertAll();

		}

		// If User enter details in 'Vendor Commercial PO Details' pop up and click
		// on Submit button then PO entry should get create in Purchase order
		// dash board with Edit,Print PO, And Send Mail link
		public void createPOInVCTTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			String textPONO = textbox_PONOInVCTTab.getAttribute("value");
			System.out.println(textPONO);

			String textPODate = textbox_PODateInVCTTab.getAttribute("value");
			System.out.println(textPODate);

			String textServiceCharges = textbox_ServiceChargesInVCTTab
					.getAttribute("value");
			System.out.println(textServiceCharges);

			String textProduct = "AC";
			textbox_ProductInVCTTab.clear();
			textbox_ProductInVCTTab.sendKeys(textProduct);
			System.out.println(textProduct);

			Select selectStatus = new Select(dropdown_StatusInVCTTab);
			List<WebElement> listOfStatus = selectStatus.getOptions();
			Thread.sleep(500);
			String dropdownStatus = listOfStatus.get(1).getAttribute("value");
			System.out.println(dropdownStatus);
			selectStatus.selectByIndex(1);

			String textTitle = textbox_TitleInVCTTab.getAttribute("value");
			System.out.println(textTitle);

			Select selectVendor = new Select(dropdown_VendorInVCTTab);
			List<WebElement> listOfVendor = selectVendor.getOptions();
			Thread.sleep(500);
			String dropdownVendor = listOfVendor.get(1).getAttribute("value");
			System.out.println(dropdownVendor);
			selectVendor.selectByIndex(1);

			String textCategory = "abc";
			textbox_CategoryInVCTTab.clear();
			textbox_CategoryInVCTTab.sendKeys(textCategory);
			System.out.println(textCategory);

			String textKmTravelled = "1";
			textbox_KmTravelledInVCTTab.sendKeys(textKmTravelled);
			System.out.println(textKmTravelled);

			String textquantity = textbox_QuantityInVCTTab.getAttribute("value");
			System.out.println(textquantity);

			String rate = "2";
			textbox_RateInVCTTab.clear();
			textbox_RateInVCTTab.sendKeys(rate);
			System.out.println(rate);

			String textAmount = textbox_AmountInVCTTab.getAttribute("value");
			System.out.println(textAmount);

			textbox_ToEmailIdInVCTTab.clear();

			String textToEmailId = "swa@ksys.in";
			textbox_ToEmailIdInVCTTab.clear();
			textbox_ToEmailIdInVCTTab.sendKeys(textToEmailId);
			System.out.println(textToEmailId);

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			button_SubmitInCommercialPODetailsPopup.click();

			int size1 = row_TableInVCTTab.size() - 2;
			System.out.println(size1);

			String labelPONO = label_PONOInPOTab.get(size1).getText();
			System.out.println(labelPONO);

			String labelPODate = label_PODateInPOTab.get(size1).getText();
			System.out.println(labelPODate);

			String labelServiceCharges = label_ServiceChargesInPOTab.get(size1)
					.getText();
			System.out.println(labelServiceCharges);

			String labelProduct = label_ProductInPOTab.get(size1).getText();
			System.out.println(labelProduct);

			String labelTitle = label_TitleInPOTab.get(size1).getText();
			System.out.println(labelTitle);

			String labelCategory = label_CategoryInPOTab.get(size1).getText();
			System.out.println(labelCategory);

			String labelKmTravelled = label_KmTravelledInPOTab.get(size1).getText();
			System.out.println(labelKmTravelled);

			String labelAmount = label_AmountInVCTTab.get(size1).getText();
			System.out.println(labelAmount);

			String labelVendor = label_VendorInPOTab.get(size1).getText();
			System.out.println(labelVendor);

			String labelStatus = label_StatusInPOTab.get(size1).getText();
			System.out.println(labelStatus);

			String labelToEmailId = label_ToEmailIdInPOTab.get(size1).getText();
			System.out.println(labelToEmailId);

			boolean linkEdit = link_EditInPOTab.get(size1).isEnabled();
			System.out.println(linkEdit);

			boolean linkPrint = link_PrintInPOTab.get(size1).isEnabled();
			System.out.println(linkPrint);

			boolean linkSendMail = link_SendMailInPOTab.get(size1).isEnabled();
			System.out.println(linkSendMail);

			softAssert.assertEquals(textPONO, labelPONO, "PO No is not Same.");
			softAssert
					.assertEquals(textPODate, labelPODate, "PO Date is not Same.");
			softAssert.assertEquals(textServiceCharges, labelServiceCharges,
					"Service Charges is not Same.");
			softAssert.assertEquals(textProduct, labelProduct,
					"Product is not Same.");
			softAssert.assertEquals(textTitle, labelTitle, "Title is not Same.");
			softAssert.assertEquals(textCategory, labelCategory,
					"Category is not Same.");
			softAssert.assertEquals(textKmTravelled, labelKmTravelled,
					"Km Travelled is not Same.");
			softAssert.assertEquals(textAmount, labelAmount, "Amount is not Same.");
			softAssert.assertEquals(dropdownVendor, labelVendor,
					"Vendor is not Same.");
			softAssert.assertEquals(dropdownStatus, labelStatus,
					"Status is not Same.");
			softAssert.assertEquals(textToEmailId, labelToEmailId,
					"To Email Id is not Same.");
			softAssert.assertTrue(linkEdit);
			softAssert.assertTrue(linkPrint);
			softAssert.assertTrue(linkSendMail);
			softAssert.assertAll();

		}

		// As per enter rate in Rate field same should display with Total Amount
		// title with Purchase order title in VCT tab
		public void checkTotalAmountInPOTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			int totalAmount = 0;
			int size1 = label_AmountInVCTTab.size();
			for (int j = 0; j <= size1 - 1; j++) {
				String textAmount = label_AmountInVCTTab.get(j).getText();
				int amount = Integer.parseInt(textAmount);
				System.out.println(amount);
				totalAmount = totalAmount + amount;
			}
			System.out.println(totalAmount);

			String labelAmount = heading_VCTTab.getText();
			String amount = labelAmount.split("Purchase Order    Total Amount:")[1];
			int labelTotalAmount = Integer.parseInt(amount);
			System.out.println(labelTotalAmount);
			softAssert.assertEquals(totalAmount, labelTotalAmount,
					"Total Amount is not Same.");
			softAssert.assertAll();

		}

		// If User click on Edit link then Vendor Commercial PO Details pop up
		// should
		// get open to update already present values with 'Update Details' button
		public void checkEditlinkInPOTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			link_EditInPOTab.get(0).click();

			// Get Heading of Vendor Commercial PO Details Pop up
			String heading = heading_VendorCommercialPODetailsPopup.getText();
			System.out.println("Heading: " + heading);

			softAssert.assertTrue(heading.contains("Vendor Commercial PO Details"),
					"Heading is not same");
			System.out.println("Heading is same");
			softAssert.assertAll();

		}

		// After update some field if user click on Update details button then same
		// values should get override on already present values
		public void checkUpdatedDetailsInVCTTab() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			textbox_CategoryInVCTTab.clear();
			String textCategory = "abc";
			textbox_CategoryInVCTTab.sendKeys(textCategory);
			System.out.println(textCategory);

			textbox_KmTravelledInVCTTab.clear();
			String textKmTravelled = "1";
			textbox_KmTravelledInVCTTab.sendKeys(textKmTravelled);
			System.out.println(textKmTravelled);

			String textquantity = textbox_QuantityInVCTTab.getAttribute("value");
			System.out.println(textquantity);

			textbox_RateInVCTTab.clear();
			String rate = "2";
			textbox_RateInVCTTab.sendKeys(rate);
			System.out.println(rate);

			String textAmount = textbox_AmountInVCTTab.getAttribute("value");
			System.out.println(textAmount);

			textbox_ToEmailIdInVCTTab.clear();
			String textToEmailId = "swa@ksys.in";
			textbox_ToEmailIdInVCTTab.sendKeys(textToEmailId);
			System.out.println(textToEmailId);

			button_SubmitInCommercialPODetailsPopup.click();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			// Click on VCT Tab
			tab_VCTInTicketForm.click();

			String labelCategory = label_CategoryInPOTab.get(0).getText();
			System.out.println(labelCategory);

			String labelKmTravelled = label_KmTravelledInPOTab.get(0).getText();
			System.out.println(labelKmTravelled);

			String labelAmount = label_AmountInVCTTab.get(0).getText();
			System.out.println(labelAmount);

			String labelToEmailId = label_ToEmailIdInPOTab.get(0).getText();
			System.out.println(labelToEmailId);

			softAssert.assertEquals(textCategory, labelCategory,
					"Category is not Same.");
			softAssert.assertEquals(textKmTravelled, labelKmTravelled,
					"Km Travelled is not Same.");
			softAssert.assertEquals(textAmount, labelAmount, "Amount is not Same.");

			softAssert.assertEquals(textToEmailId, labelToEmailId,
					"To Email Id is not Same.");
			softAssert.assertAll();

		}

		// If User click on Print PO link of PO entry, then pop up should display to
		// show PDF format of Purchase Order
		public void checkPrintPOlinkInPOTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);

				link_PrintInPOTab.get(0).click();

				for (String Window1 : driver.getWindowHandles()) {
					driver.switchTo().window(Window1);
				}

				// Get Heading of Vendor Commercial PO Details Pop
				// up
				String url = driver.getCurrentUrl();
				System.out.println(url);

				softAssert.assertTrue(url.contains(".pdf"), "Heading is not same");
				System.out.println("Page is same");
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");
				driver.switchTo().window(Window);

			}
			softAssert.assertAll();
		}

		// If User click on Send mail then PO should get mailed to entered email Id
		public void checkSendMailLinkInPOTab() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);

				String labelToEmailId = label_ToEmailIdInPOTab.get(0).getText();
				System.out.println(labelToEmailId);

				link_SendMailInPOTab.get(0).click();
				// Click on VCT Tab
				tab_VCTInTicketForm.click();

				button_ShowEmailLogInVCTTab.click();

				for (String Window1 : driver.getWindowHandles()) {
					driver.switchTo().window(Window1);
				}
				try {
					int size1 = row_TableInListOfSentMailsPage.size() - 2;
					System.out.println(size1);

					String labelSendTo = label_SendToListOfSentMailsPage.get(size1)
							.getText();
					System.out.println(labelSendTo);

					softAssert.assertEquals(labelToEmailId, labelSendTo,
							"To Email Id is not Same.");
					System.out.println("To Email Id is Same.");
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "w");
					driver.switchTo().window(Window);
					break;
				} catch (Exception e) {

					softAssert.assertTrue(false,
							"Table of Sent Mails is not present");
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "w");
					driver.switchTo().window(Window);

				}

			}
			softAssert.assertAll();
		}

		// VCT TAB
		// If User click on Update Payment button then
		// 'Vendor Commercial Payment Details' pop up should display to generate
		// Invoice
		public void checkVendorCommercialPaymentDetailsPopUp() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on cancel ticket button
			button_UpdatePayment.click();

			for (String vendorCommercialPaymentDetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(vendorCommercialPaymentDetailsWindow);
				driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

			}

			String textOfVendorCommercialPaymentDetailsWindow = title_AllTabDetailsPage
					.getText();
			System.out.println(textOfVendorCommercialPaymentDetailsWindow);

			// verify that the window is TSD Assign Details window or
			// not
			softAssert.assertEquals(textOfVendorCommercialPaymentDetailsWindow,
					"Vendor Commercial Payment Details");
			System.out.println("Both the message is equal");

			softAssert.assertAll();
		}

		// If user click on Submit button without select details in 'Vendor
		// Commercial Payment Details' pop up then
		// notification should display as 'Please Select Mode'
		public void checkSubmitButtonWithBlankDate() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// click on submit button
			button_Submit.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// verify that alert message isPlease select Activity.or not
			softAssert.assertEquals(alertMessage, "Please Select Mode");
			System.out.println("Both the message is equal");
			softAssert.assertAll();

		}

		// If user click on Submit button without status option in 'Vendor
		// Commercial Payment Details'
		// pop up then notification should display as 'Please Select Status'
		public void checkSubmitButtonWithoutSelectingStatus() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// select the mode of payment
			Select mode;
			mode = new Select(dropdown_Mode);
			mode.selectByVisibleText("Cash");

			// click on submit button
			button_Submit.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// verify that alert message isPlease select Activity.or not
			softAssert.assertEquals(alertMessage, "Please Select Status");
			System.out.println("Both the message is equal");
			softAssert.assertAll();

		}

		// If user click on Submit button with all details in 'Vendor Commercial
		// Payment Details'
		// pop up then same should display in Payment entry with Edit and View
		// Attachment links

		public void checkSubmitButtonWithAllFieldFill() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// select the mode of payment
			Select statusInUpdatePayment;

			statusInUpdatePayment = new Select(dropdown_StatusOfUpdatePayment);
			statusInUpdatePayment.selectByVisibleText("Approved");

			// click on submit button
			button_Submit.click();

			List<WebElement> editValueAfterUpdate = list_EditInUpdatePayment;
			int getSize = editValueAfterUpdate.size();
			System.out.println(getSize);

			String getEditValue = list_EditInUpdatePayment.get(getSize - 1)
					.getText();
			System.out.println(getEditValue);

			List<WebElement> attachmentValueAfterUpdate = list_AttachmentInUpdatePayment;
			int getTotalSize = attachmentValueAfterUpdate.size();
			System.out.println(getTotalSize);

			String getAttachmentValue = list_AttachmentInUpdatePayment.get(
					getTotalSize - 1).getText();
			System.out.println(getAttachmentValue);

			// match that after click submit button then the edit link
			// should display in edit
			softAssert.assertEquals(getEditValue, "Edit");

			// match that after click submit button then the edit link
			// should display in edit
			softAssert.assertEquals(getAttachmentValue, "View Attachment");
			softAssert.assertAll();

		}

		// If User update details and click o Update details button then same values
		// should get override on already present values
		public void checkUpdateDetailFunctionality() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// click on cancel ticket button
			button_UpdatePayment.click();

			for (String vendorCommercialPaymentDetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(vendorCommercialPaymentDetailsWindow);
				driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

			}

			// write Invoice No
			textbox_InvoiceNumber.sendKeys("123");
			String getInvoiceNumberValue = textbox_InvoiceNumber
					.getAttribute("value");
			System.out.println(getInvoiceNumberValue);

			// Write Amount value
			textbox_Amount.sendKeys("10000");
			String getAmountValue = textbox_Amount.getAttribute("value");
			System.out.println(getAmountValue);

			// Write TDS Amount value
			textbox_TSDAmount.sendKeys("500");
			String getTDSAmountValue = textbox_InvoiceNumber.getAttribute("value");
			System.out.println(getTDSAmountValue);

			// get total amount
			String getTotalAmountValue = textbox_TotalAmount.getAttribute("value");
			System.out.println(getTotalAmountValue);

			// select the mode of payment
			Select mode;
			mode = new Select(dropdown_Mode);
			mode.selectByVisibleText("Cash");

			// write the reference code
			textbox_ReferenceCode.sendKeys("W099");

			// select the mode of payment
			Select statusTextBox;
			statusTextBox = new Select(dropdown_StatusOfUpdatePayment);
			statusTextBox.selectByVisibleText("Approved");

			// click on submit button
			button_Submit.click();

			List<WebElement> completeDataValueAfterUpdate = list_CompleteDataInUpdatePayment;
			int getRowSize = completeDataValueAfterUpdate.size();
			System.out.println(getRowSize);

			String getAllDetailValue = list_CompleteDataInUpdatePayment.get(
					getRowSize - 1).getText();
			System.out.println(getAllDetailValue);

			List<WebElement> statusValueAfterUpdate = list_StatusInUpdatePayment;
			int getTotalSize = statusValueAfterUpdate.size();
			System.out.println(getTotalSize);

			String getSatusValue = list_StatusInUpdatePayment.get(getTotalSize - 1)
					.getText();
			System.out.println(getSatusValue);

			List<WebElement> editValueAfterUpdate = list_EditInUpdatePayment;
			int getSize = editValueAfterUpdate.size();
			System.out.println(getSize);

			String getEditValue = list_EditInUpdatePayment.get(getSize - 1)
					.getText();
			System.out.println(getEditValue);

			list_EditInUpdatePayment.get(getSize - 1).click();

			// driver.findElement(By.linkText(getEditValue)).click();

			for (String vendorCommercialPaymentDetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(vendorCommercialPaymentDetailsWindow);
				driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

			}

			// change the Attachment of payment
			Select modeAfterClickOnEditLink;
			modeAfterClickOnEditLink = new Select(dropdown_StatusOfUpdatePayment);
			modeAfterClickOnEditLink.selectByIndex(2);

			String statusValueInDatails = dropdown_StatusOfUpdatePayment
					.getAttribute("value");
			System.out.println(statusValueInDatails);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			// click on update detail button
			button_SubmitAndUpdateDetailOfVendorCommercialPaymentDetails.click();

			List<WebElement> statusValueAfterEdit = list_StatusInUpdatePayment;
			int getStatusColumnSize = statusValueAfterEdit.size();
			System.out.println(getStatusColumnSize);

			String getStatusValueAfterEdit = list_StatusInUpdatePayment.get(
					getTotalSize - 1).getText();
			System.out.println(getStatusValueAfterEdit);

			softAssert.assertEquals(getStatusValueAfterEdit, statusValueInDatails,
					" Status of Payment is not same in VCT Tab.");
			softAssert.assertAll();

		}

		// If any attachment is provide while generate invoice then same
		// should display in List of Attachments pop up after click Attachment link
		public void checkFileAttachmentFunctionality() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			for (String Window : driver.getWindowHandles()) {

				driver.switchTo().window(Window);

				// click on cancel ticket button
				button_UpdatePayment.click();

				for (String vendorCommercialPaymentDetailsWindow : driver
						.getWindowHandles()) {

					System.out.println(vendorCommercialPaymentDetailsWindow);
					driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

				}

				// select the mode of payment
				Select mode;
				mode = new Select(dropdown_Mode);
				mode.selectByVisibleText("Cash");

				// select the mode of payment
				Select statusTextBox;
				statusTextBox = new Select(dropdown_StatusOfUpdatePayment);
				statusTextBox.selectByVisibleText("Quote");

				// Browse the file
				// Enter File Name
				String fileName = "Desert.jpg";
				System.out.println(fileName);
				// Enter File Path
				button_BrowseUpdatePayment
						.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
				// Get uploaded file name
				String browseFileName = button_BrowseUpdatePayment
						.getAttribute("value");
				System.out.println(browseFileName);

				// click on submit button
				button_Submit.click();

				List<WebElement> attachmentValue = list_AttachmentInUpdatePayment;
				int getSize = attachmentValue.size();
				System.out.println(getSize);

				String getAttachmentValue = list_AttachmentInUpdatePayment.get(
						getSize - 1).getText();
				System.out.println(getAttachmentValue);

				driver.findElement(By.linkText(getAttachmentValue)).click();

				for (String listOfAttachmentsWindow : driver.getWindowHandles()) {

					System.out.println(listOfAttachmentsWindow);
					driver.switchTo().window(listOfAttachmentsWindow);

				}
				try {
					List<WebElement> attachmentListValue = list_ListOfAttachment;
					int getSizeOfAllFile = attachmentListValue.size();
					System.out.println(getSizeOfAllFile);

					String getAttachmentFileName = list_ListOfAttachment.get(
							getSizeOfAllFile - 1).getText();
					System.out.println(getAttachmentFileName);

					softAssert.assertEquals(getAttachmentFileName, browseFileName);
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "w");
					driver.switchTo().window(Window);
					break;

				} catch (Exception e) {

					softAssert.assertTrue(false,
							"Table of File Attachement is not present");
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "w");
					driver.switchTo().window(Window);

				}
			}

			softAssert.assertAll();
		}

		// KEDB TAB
		public void checkKEDBDetailsPopUp() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on KEDB tab
			tab_KEDB.click();

			// click on final close button
			button_AddKEDB.click();

			Thread.sleep(1000);
			// get the Final Close Details window name
			String windowValue = label_KEDBDetailsWindow.getText();
			System.out.println(windowValue);

			// match the window
			softAssert.assertEquals(windowValue, "KEDB Details");

			// click on Add KEDB button, without entering data
			button_AddKEDBInKEDBDetails.click();

			// get the alert message
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			String alertMessage = alert.getText();
			System.out.println(alertMessage);
			alert.accept();
			Thread.sleep(500);

			softAssert.assertEquals(alertMessage, "Please Enter Known Error");

			// enter the Known error
			textbox_KnownError.sendKeys("asdddd");

			// click on Add KEDB button,after Known error field is fill
			button_AddKEDBInKEDBDetails.click();

			// get the alert message
			Alert alertOfWorkAround = driver.switchTo().alert();

			String alertOfWorkAroundMessage = alertOfWorkAround.getText();
			System.out.println(alertOfWorkAroundMessage);
			alertOfWorkAround.accept();
			Thread.sleep(500);

			softAssert.assertEquals(alertOfWorkAroundMessage,
					"Please Enter Work Around Details");

			// enter the work around detail
			textbox_WorkArroundDetail.sendKeys("ghjjj");

			// click on Add KEDB button,after Known error field is fill
			button_AddKEDBInKEDBDetails.click();

			// get the alert message
			Alert alertOfSolution = driver.switchTo().alert();

			String alertOfSolutionMessage = alertOfSolution.getText();
			System.out.println(alertOfSolutionMessage);
			alertOfSolution.accept();
			Thread.sleep(500);

			softAssert
					.assertEquals(alertOfSolutionMessage, "Please Enter Solution");

			// enter the solution
			textbox_Solution.sendKeys("abcbcbcb");

			// click on Add KEDB button,after entering all the detail
			button_AddKEDBInKEDBDetails.click();

			String textOfNotification = notification.getText();
			System.out.println(textOfNotification);

			softAssert.assertEquals(textOfNotification, "KEDB added successfully.");
			softAssert.assertAll();

		}

		// CCT tab
		public void checkCCTtab() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// click on CCT Tab
			tab_CCT.click();

			// click on create PI tab
			button_CreatePI.click();

			// get the Customer Commercial Proforma Details window name
			String windowValue = labal_CustomerCommercialProformaDetailsPopUp
					.getText();
			System.out.println(windowValue);

			// match the window
			softAssert.assertEquals(windowValue,
					"Customer Commercial Proforma Details");

			// click on submit button without entering any data
			button_Submit.click();

			// get the alert message
			Alert alertOfSolution = driver.switchTo().alert();

			String alertOfSolutionMessage = alertOfSolution.getText();
			System.out.println(alertOfSolutionMessage);
			alertOfSolution.accept();
			Thread.sleep(500);

			softAssert.assertEquals(alertOfSolutionMessage, "Please Select Status");

			// click on cancel button
			button_Cancel.click();
			softAssert.assertAll();

		}

		// Cancel Ticket

		// If User click on Cancel ticket button in Cancel ticket tab then 'Cancel
		// Ticket Details' pop up should get open .

		public void checkCancelTicketDetailPOpUp() throws Exception {

			tab_CancelTicket.click();

			// click on cancel ticket button
			button_CancelTicket.click();

			for (String cancelTicketDetailsWindow : driver.getWindowHandles()) {

				System.out.println(cancelTicketDetailsWindow);
				driver.switchTo().window(cancelTicketDetailsWindow);

			}

			String textOfCancelTicketDetailsWindow = title_AllTabDetailsPage
					.getText();
			System.out.println(textOfCancelTicketDetailsWindow);

			// verify that the window is TSD Assign Details window or
			// not
			Assert.assertEquals(textOfCancelTicketDetailsWindow,
					"Cancel Ticket Details");
			System.out.println("Both the message is equal");

		}

		// If User try to edit Resolution value then system should not allow to edit
		// this field and also check that
		// the resolution field contain default value is "cancel"
		public void checkResolutionFieldIsNotEditable() throws Exception {

			// Check that the resolution field is not editable
			textbox_Resolution.sendKeys("abc");
			String tsdFieldValue = textbox_Resolution.getAttribute("value");

			boolean resolutionFieldIsEditable;

			if (!tsdFieldValue.contentEquals("abc")
					&& tsdFieldValue.contentEquals("Cancel")) {

				System.out.println("Field is Not editable");
				resolutionFieldIsEditable = true;

			}

			else

			{

				System.out.println("Field is editable" + tsdFieldValue);
				resolutionFieldIsEditable = false;

			}

			// check field should not editable

			Assert.assertTrue(resolutionFieldIsEditable);

		}

		// If User click on Cancel ticket button in 'Cancel Ticket Details' popup
		// then notification should display as
		// 'Please Enter Ticket Cancel Reason'
		public void checkWithBlankCancelReasonField() throws Exception {

			button_CancelTicketInCancelTicketDetails.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// verify that alert message is Please Enter The Numeric
			// Value
			// for Incident ID or not
			Assert.assertEquals(alertMessage, "Please Enter Ticket Cancel Reason");
			System.out.println("Both the message is equal");

		}

		// If user enter data in Cancel reason text box and click on cancel ticket
		// button then entry should get created in ticket cancel tab and
		// notification should
		// display as 'Ticket Cancelled Successfully.'
		// Also Status of ticket should display as 'Cancelled'
		public void checkCancelButtonWithAllFieldFill() throws Exception {

			textbox_CancelReason.sendKeys("Spare is not available");

			// click on cancel button
			button_CancelTicketInCancelTicketDetails.click();

			String getNotification = notification.getText();
			System.out.println(getNotification);

			// match the pop up window get close after click on cancel
			// button
			Assert.assertEquals(getNotification, "Ticket Cancelled Successfully.");

			// get the status from incident number
			String getStatus = driver.findElement(
					By.xpath(".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]"))
					.getText();
			String splitStatus = getStatus.split("\n")[1];
			System.out.println(splitStatus);

			// check the status is change to cancelled or not
			Assert.assertEquals(splitStatus, "Status : Cancelled");

		}

		
		public void createPurchaseOrder() throws Exception {
			// Click on Create PO Button
			button_CreatePOInVCTTab.click();

			Select selectVendor = new Select(dropdown_VendorInVCTTab);
			List<WebElement> listOfVendor = selectVendor.getOptions();
			Thread.sleep(500);
			String dropdownVendor = listOfVendor.get(1).getAttribute("value");
			System.out.println(dropdownVendor);
			selectVendor.selectByIndex(1);

			String rate = "2";
			textbox_RateInVCTTab.sendKeys(rate);
			System.out.println(rate);

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			button_SubmitInCommercialPODetailsPopup.click();

		}

		public void SelectEngineerInFilterTab() throws Exception {
			// click on filter
			tab_Filter.click();

			// select engineer filter
			Select engineer;
			engineer = new Select(dropdown_Engineer);
			// engineer.selectByVisibleText("Swati .");
			engineer.selectByVisibleText("Pranjali Deshpande");

		}

		// select spare with device,Non consumable,stock and then technician close ,
			// to replace serial number is

			public void selectSpareWithDeviceAndTechClose() throws Exception {

				SoftAssert softAssert = new SoftAssert();
				
				Thread.sleep(500);
				int sizePagination = dropdown_Pagination.size();
				System.out.println(sizePagination);
				loop: for (int p = 0; p < sizePagination; p++) {

					dropdown_Pagination.get(p).click();

					List<WebElement> status = list_StatusInTable;
					int size = status.size();
					System.out.println(size);

					for (int i = 0; i < size; i++) {

						String statusValue = status.get(i).getText();
						System.out.println(statusValue);

						String ETA = list_ETADateInTable.get(i).getText();
						System.out.println(ETA);

						String ATA = list_ATADateInTable.get(i).getText();
						System.out.println(ATA);

						if (statusValue.equalsIgnoreCase("Open") && !ETA.equals("")
								&& !ATA.equals(""))

						{

							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									list_IDInTable.get(i));
							list_IDInTable.get(i).click();

							// click on spare tab
							tab_Spare.click();

							// click on Edit button
							button_EditInSpareTab.click();

							for (String spareDetailsWindow : driver.getWindowHandles()) {

								System.out.println(spareDetailsWindow);
								driver.switchTo().window(spareDetailsWindow);

							}

							// select the Spares Consumed By Inventory logistic
							Select sparesConsumed;
							sparesConsumed = new Select(dropdown_SparesConsumed);
							sparesConsumed.selectByVisibleText("Yes");

							// list symbol button in spare detail window
							button_ListSymbolOfSpareDetail.click();

							for (String listOfAvailableSparesWindow : driver
									.getWindowHandles()) {

								System.out.println(listOfAvailableSparesWindow);
								driver.switchTo().window(listOfAvailableSparesWindow);

							}
							// get part name from list of Available Spares Window
							// select the part name if transaction type is stock
							List<WebElement> transactionType = list_TransactionTypeInSpareDetail;
							int sizeOfSapre = transactionType.size();
							System.out.println(sizeOfSapre);

							for (int j = 0; j < transactionType.size(); j++) {

								String transactionTypeValue = list_TransactionTypeInSpareDetail
										.get(j).getText();
								System.out.println(transactionTypeValue);

								String productClassificationValue = list_ProductClassificationInSpareDetail
										.get(j).getText();
								System.out.println(productClassificationValue);

								String partTypeValue = list_PartTypeInSpareDetail
										.get(j).getText();
								System.out.println(partTypeValue);

								if (productClassificationValue
										.equalsIgnoreCase("Device")
										&& partTypeValue
												.equalsIgnoreCase("Non-Consumable")
										&& transactionTypeValue
												.equalsIgnoreCase("Stock"))

								{

									String partName = list_PartNameInSpareDetail.get(j)
											.getText();
									System.out.println(partName);

									// select part name from list of Available
									// Spares Window
									((JavascriptExecutor) driver).executeScript(
											"arguments[0].scrollIntoView(true);",
											list_PartNameInSpareDetail.get(j));
									list_PartNameInSpareDetail.get(j).click();

									for (String spareDetailsWindow : driver
											.getWindowHandles()) {

										System.out.println(spareDetailsWindow);
										driver.switchTo().window(spareDetailsWindow);

									}
									// select the part code as replace with another part
									// code
									Select partCodeInRepaceTab;
									partCodeInRepaceTab = new Select(
											dropdown_PartCodeInReplaceSpare);
									partCodeInRepaceTab
											.selectByVisibleText("Replace With Another PartCode");

									// select the part code for replace
									String anotherPartCodeInReplaceTabValue = dropdown_ListOfAnotherPartCodeInReplaceSpare
											.get(1).getText();
									System.out
											.println(anotherPartCodeInReplaceTabValue);

									Select anotherPartCodeInReplaceTab;
									anotherPartCodeInReplaceTab = new Select(
											dropdown_AnotherPartCodeInReplaceSpare);
									anotherPartCodeInReplaceTab
											.selectByVisibleText(anotherPartCodeInReplaceTabValue);

									// select the status
									Select statusDoprdown;
									statusDoprdown = new Select(dropdown_Status);
									statusDoprdown.selectByVisibleText("Good");

									driver.manage().timeouts()
											.pageLoadTimeout(60, TimeUnit.SECONDS);
									// click on update button
									button_UpdateDetail.click();

									

								}
								if (sizeOfSapre - 1 == j) {
									softAssert.assertTrue(false,
											" spare is not Available for Closing Ticket");

								}

							}
							break loop;

						}
					}
					if (sizePagination - 1 == p)
						softAssert.assertTrue(false,
								" Ticket is not Available for Closing Ticket");

				}
			}

		// Technician Close //

		// If User click on Update Details in Tech close tab without enter any
		// details then
		// notification should display as 'Please enter Technician Close Date.'
		public void checkNotificationWithoutSelectionInTechnicianCloseTab()
				throws Exception {
			SoftAssert softAssert = new SoftAssert();
			
						
						tab_TechnicianClose.click();
						
						button_EditOfTechncianClose.click();
						Thread.sleep(500);
						// To Handle window based pop-up
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_MINUS);
						Thread.sleep(1000);
						// robot.keyPress(KeyEvent.VK_CONTROL);
						// robot.keyPress(KeyEvent.VK_MINUS);

						driver.manage().timeouts()
								.pageLoadTimeout(10, TimeUnit.SECONDS);
						// Thread.sleep(2000);
						button_submitTechCloseDetails.click();
						Thread.sleep(1000);

						// get the message from that alert box

						Alert alert = driver.switchTo().alert();
						Thread.sleep(500);
						String alertMessage = alert.getText();
						System.out.println("Alert Text:" + alertMessage);
						alert.accept();
						driver.switchTo().defaultContent();

						softAssert.assertEquals(alertMessage,
								"Please enter Technician Close Date.");
						System.out.println("Both the message is equal");

						// Format Date
						/*
						 * String datePattern = "yyyy-MM-dd"; DateFormat dateFormat
						 * = new SimpleDateFormat(datePattern);
						 * 
						 * // Format Time String timePattern = "HH:mm"; DateFormat
						 * timeFormat = new SimpleDateFormat(timePattern);
						 */

						// Get System Date
						Calendar mydate = new GregorianCalendar();
						int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
						System.out.println(dayOfMonth);
						String currentDay = Integer.toString(dayOfMonth);

						// This is Optional
						// Used If you want select Previous date
						int preDay = Integer.parseInt(currentDay);
						String previousDay = Integer.toString(preDay);
						calendar_TechnicianClosePage.click();

						// select Date in Calendar

						for (WebElement day : day_CalendarInTechnicianClosePage) {

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
						// Thread.sleep(1000);
						driver.manage().timeouts()
								.pageLoadTimeout(10, TimeUnit.SECONDS);
						button_submitTechCloseDetails.click();
						Thread.sleep(1000);

						String alertTime = alert.getText();
						System.out.println("Alert Text:" + alertTime);
						alert.accept();
						driver.switchTo().defaultContent();

						softAssert.assertEquals(alertTime,
								"Please enter Tech Close Time.");
						System.out.println("Both the message is equal");

						// Get System Time
						Calendar calendar = Calendar.getInstance();
						String hrs = new SimpleDateFormat("HH").format(calendar
								.getTime());
						System.out.println(hrs);
						String min = new SimpleDateFormat("mm").format(calendar
								.getTime());
						System.out.println(min);

						// select Hrs in Drop down

						for (WebElement hrsofSystem : dropdown_HrsOfTechnicianCloseTime) {

							String hrsInDropdown = hrsofSystem.getText();

							if (hrsInDropdown.equalsIgnoreCase(hrs)) {

								Thread.sleep(1000);
								hrsofSystem.click();
								String getDateValue = hrsofSystem.getText();
								System.out.println("Select the hrs:-"
										+ getDateValue);

								break;
							}

						}

						// select Min in Drop down

						for (WebElement minOfSystem : dropdown_MinOfTechnicianCloseTime) {

							String minInDropdown = minOfSystem.getText();

							if (minInDropdown.equalsIgnoreCase(min)) {

								Thread.sleep(1000);
								minOfSystem.click();
								String getDateValue = minOfSystem.getText();
								System.out.println("Select the min:-"
										+ getDateValue);

								break;
							}

						}

						// Thread.sleep(1000);
						driver.manage().timeouts()
								.pageLoadTimeout(10, TimeUnit.SECONDS);
						button_submitTechCloseDetails.click();

						// get the message from that alert box

						String alertResolution = alert.getText();
						System.out.println("Alert Text:" + alertResolution);
						alert.accept();
						driver.switchTo().defaultContent();

						softAssert.assertEquals(alertResolution,
								"Please Enter Resolution");
						System.out.println("Both the message is equal");

						String resolution = "abc";
						textbox_ResolutionInTechnicianClose.sendKeys(resolution);
						Thread.sleep(500);
						button_submitTechCloseDetails.click();
						Thread.sleep(500);
						// get the message from that alert box

						String alertResolutionDescription = alert.getText();
						System.out.println("Alert Text:"
								+ alertResolutionDescription);
						alert.accept();
						driver.switchTo().defaultContent();

						softAssert.assertEquals(alertResolutionDescription,
								"Please Enter Resolution Description");
						System.out.println("Both the message is equal");

						String resolutionDescription = "xyz";
						textbox_ResolutionDescriptionInTechnicianClose
								.sendKeys(resolutionDescription);
						// Thread.sleep(00);
						
						//Robot robot = new Robot();
					//	robot.keyPress(KeyEvent.VK_CONTROL);
						/*driver.manage().timeouts()
								.pageLoadTimeout(40, TimeUnit.SECONDS);
						button_submitTechCloseDetails.click();

						// Get Notification
						// Thread.sleep(1000);
						String notificationText = notification.getText();
						System.out.println(notificationText);

						softAssert.assertEquals(notificationText,
								"Please enter FSR No", "Notification is not Match");
	*/
						// driver.findElement(By.linkText("Cancel")).click();

						
			
			softAssert.assertAll();
		}

		// If User enter and select all mandatory details in technician close
		// Details popup then all details should display in technician close tab and
		// notification should display as ' Incident Updated SuccessFully'
		public void checkNotificationWithSelectionInTechnicianCloseTab()
				throws Exception {

			SoftAssert softAssert = new SoftAssert();

			String FSRNo = "123";
			textbox_FSRNoInTechnicianClose.sendKeys(FSRNo);
			textbox_SerialNumberInTechClose.sendKeys("567");
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_submitTechCloseDetails);
			 Thread.sleep(500);

			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			button_submitTechCloseDetails.click();

			// Get Notification
			// Thread.sleep(1000);
			String notificationText1 = notification.getText();
			System.out.println(notificationText1);

			softAssert.assertEquals(notificationText1,
					"Incident Updated SuccessFully", "Notification is not Match");
			softAssert.assertAll();

		}

		// If User click on Generate PDF button after technician close then in 'End
		// Of Service' technician close date and time should display
		public void checkGeneratePDFLink() throws Exception {
	
			String parentWindow = driver.getWindowHandle();

			// click on generate PDF button
			button_GeneratePDF.click();

			// use for system window handle
			Robot robot = new Robot();
			// robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);

			for (String childWindow : driver.getWindowHandles()) {

				System.out.println(childWindow);
				String windowName = driver.getTitle();
				System.out.println(windowName);
				driver.switchTo().window(childWindow);

			}

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
			driver.switchTo().window(parentWindow);

		}

		// If user click on Edit button of technician close tab for already updated
		// technician close tab then Technician close Details
		// pop up should not display and notification should display as 'Please
		// Update ETA And ATA First.'
		public void checkEditButtonAfterTechnicianClose() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// click on Technician close tab
			tab_TechnicianClose.click();

			// click on edit button
			button_EditOfTechncianClose.click();

			String notificationText = notification.getText();
			System.out.println(notificationText);

			// Match notification
			softAssert.assertEquals(notificationText,
					"Please Update ETA And ATA First.");
			softAssert.assertAll();

		}

		

		// Technician close
		// select the technician close with replace spare serial no.
		public void selectTechnicianCloseWithSerialNo() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			
			// click on Technician close tab
			tab_TechnicianClose.click();
			Thread.sleep(5000);
			
			 getTechnicianDateTime = label_TechnicianCloseTime.getText();
			System.out.println("getTechnicianDateTime" + getTechnicianDateTime);
			// get the serial number from technician close tab
			String serialNumberValue = label_SerialNumber.getText();
			String splitNumberValue = serialNumberValue.split("Serial No. :")[1];
			 serialNumber = splitNumberValue.split(" ")[1];
			System.out.println(serialNumber);

			boolean serialNoIsPresent;
			if (!serialNumber.contains(" ")) {
				System.out.println("serial number is present");
				serialNoIsPresent = true;
				softAssert.assertTrue(serialNoIsPresent);

			} else {
				System.out.println("serial number is not present");
				softAssert.assertEquals(serialNumber, "");

			}
			softAssert.assertAll();

		}

		// final close
		// Check Final Close Detail pop up
		public void checkFinalCloseDetailpopup() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// click on Technician close tab
			tab_TechnicianClose.click();

			// click on final close button
			button_Close.click();

			// get the Final Close Details window
			String windowValue = lable_FinalCloseDetailsWindow.getText();
			System.out.println(windowValue);

			// match the window
			softAssert.assertEquals(windowValue, "Final Close Details");

			softAssert.assertAll();

		}

		// without entering any data if user click on update detail button then
		// 'Please enter Final close date.' pop up message should display.
		public void checkUpdateDetailsWithBlankData() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			button_UpdateDetail.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();

			// match the window
			softAssert.assertEquals(alertMessage, "Please enter Final close date.");
			//button_Cancel.click();
			softAssert.assertAll();

		}

		// if user select the close date less than technician close date then 'Final
		// close date/time should be greater than Tech close date/time.' pop up
		// should be display
		public void compareCloseDateWithTechnicianDateTime() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			//String getTechnicianDateTime = label_TechnicianCloseTime.getText();
			System.out.println("getTechnicianDateTime" + getTechnicianDateTime);

			String splitTime = getTechnicianDateTime.split(" ")[0];
			String splitYearAndMonth = splitTime.split("-")[2];
			System.out.println("date" + splitYearAndMonth);
			// select Date in Calendar

	/*		// click on Technician close tab
			tab_TechnicianClose.click();

			// click on final close button
			button_Close.click();*/

			Actions action = new Actions(driver);
			action.moveToElement(symbol_CloseDateCalender).doubleClick().build()
					.perform();
			Thread.sleep(3000);

			for (WebElement day : day_CalendarInTechnicianClosePage) {

				String dayInCalender = day.getText();

				if (splitYearAndMonth.contains(dayInCalender)) {
					Thread.sleep(1000);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			String getCloseDateValue = textbox_CloseDate.getAttribute("value");
			System.out.println(getCloseDateValue);

			if (splitYearAndMonth.compareTo(getCloseDateValue) >= 0) {

				button_UpdateDetail.click();
				Thread.sleep(3000);

				// get the message from that alert box
				Alert alert = driver.switchTo().alert();
				Thread.sleep(500);

				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				//driver.switchTo().defaultContent();

				softAssert
						.assertEquals(alertMessage,
								"Final close date/time should be greater than Tech close date/time.");
				//button_Cancel.click();
			}
			softAssert.assertAll();

		}

		// If User enter final close date/time more than current date and time then
		// notification should "
		// display as 'Final close Date/Time should be less than or Equal to Current
		// Date/Time.
		public void compareCloseDateTimeWithCurrentDateTime() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			// get current date
			Date systemDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formatSystemDate = dateFormat.format(systemDate);
			Date actualSystemDate = dateFormat.parse(formatSystemDate);
			String SystemDateValue = dateFormat.format(actualSystemDate);
			System.out.println("System Date:-" + SystemDateValue);

			Thread.sleep(1000);
			/*// click on Technician close tab
			tab_TechnicianClose.click();

			// click on final close button
			button_Close.click();
	*/
			// select close date and time

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			int preDay = Integer.parseInt(currentDay);
			String previousDay = Integer.toString(preDay);
			symbol_CloseDateCalender.click();

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

			String getCloseDateValue = textbox_CloseDate.getAttribute("value");
			System.out.println(getCloseDateValue);

			if (getCloseDateValue.compareTo(SystemDateValue) >= 0) {

				button_UpdateDetail.click();
				Thread.sleep(3000);

				// get the message from that alert box
				Alert alert = driver.switchTo().alert();
				Thread.sleep(3000);

				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				//driver.switchTo().defaultContent();

				softAssert
						.assertEquals(alertMessage,
								"Final close date/time should be greater than Tech close date/time.");

			//	button_Cancel.click();

			}
			softAssert.assertAll();

		}

		// If User enter final close date/time less than technician close date and
		// time
		// then notification should display as 'Final close date/time should be
		// greater than Tech close date/time.'
		public void compareCloseDateTimeWithTechnicianDateTime() throws Exception {

			SoftAssert softAssert = new SoftAssert();

			//String getTechnicianDateTime = label_TechnicianCloseTime.getText();
			System.out.println(getTechnicianDateTime);

			Thread.sleep(1000);
			/*// click on Technician close tab
			tab_TechnicianClose.click();

			// click on final close button
			button_Close.click();
	*/
			// select close date and time

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			int preDay = Integer.parseInt(currentDay);
			String previousDay = Integer.toString(preDay);
			symbol_CloseDateCalender.click();

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
			String getCloseDateValue = textbox_CloseDate.getAttribute("value");
			System.out.println(getCloseDateValue);

			// select ETA Time Minute
			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hrs);
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			int nextMinut = Integer.parseInt(min) + 2;
			String nextMinutValue = Integer.toString(nextMinut);

			System.out.println(nextMinutValue);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {

					Thread.sleep(1000);
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(nextMinutValue)) {

					Thread.sleep(1000);
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			String getCloseTimeHourValue = dropdown_CloseTimeHour
					.getAttribute("value");
			System.out.println(getCloseTimeHourValue);

			String getCloseTimeMinuteValue = dropdown_CloseTimeMinute
					.getAttribute("value");
			System.out.println(getCloseTimeMinuteValue);

			String addTime = getCloseTimeHourValue.concat(":"
					+ getCloseTimeMinuteValue);

			System.out.println(addTime);

			String addDateTime = getCloseDateValue.concat(" " + addTime);
			System.out.println(addDateTime);

			if (getTechnicianDateTime.compareTo(addDateTime) <= 0) {

				button_UpdateDetail.click();
				Thread.sleep(3000);

				// get the message from that alert box
				Alert alert = driver.switchTo().alert();
				Thread.sleep(3000);

				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				//driver.switchTo().defaultContent();

				softAssert
						.assertEquals(alertMessage,
								"Final close Date/Time should be less than or Equal to Current Date/Time.");

			}
			softAssert.assertAll();
		}

		// In user enter replaced serial number while tech close then in Final Close
		// Details pop up in same number should display in serial number field
		public void matchReplacedSerialWithFinalCloseSerialNumber()
				throws Exception {

			SoftAssert softAssert = new SoftAssert();
			/*// click on Technician close tab
			tab_TechnicianClose.click();

			// get the serial number from technician close tab
			String serialNumberValue = label_SerialNumber.getText();
			String splitNumberValue = serialNumberValue.split("Serial No. :")[1];
		 serialNumber = splitNumberValue.split(" ")[1];*/
			System.out.println(serialNumber);

			/*// click on final close button
			button_Close.click();
	*/
			// get the value of serial number
			String serialNo = textbox_SerialNumber.getText();
			System.out.println(serialNo);

			// Match both the serial number is same
			softAssert.assertEquals(serialNumber, serialNo);
			softAssert.assertAll();

		}

		// In user enter replaced serial number while tech close and in Final Close
		// Details pop up->Update Serial No For
		// this Asset field if user not enter any value then notification should
		// display as 'Serial No. does not match.'
		public void matchPopUpWithBlankUpdateSerialNoField() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*// click on Technician close tab
			tab_TechnicianClose.click();

			// click on final close button
			button_Close.click();
	*/
			// select close date and time

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			int preDay = Integer.parseInt(currentDay);
			String previousDay = Integer.toString(preDay);
			symbol_CloseDateCalender.click();

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
			String getCloseDateValue = textbox_CloseDate.getAttribute("value");
			System.out.println(getCloseDateValue);

			// select ETA Time Minute
			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hrs);

			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			int previousMinut = Integer.parseInt(min) - 10;
			String previousMinutValue = Integer.toString(previousMinut);

			System.out.println(previousMinutValue);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {

					Thread.sleep(1000);
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(previousMinutValue)) {

					Thread.sleep(1000);
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			String getCloseTimeHourValue = dropdown_CloseTimeHour
					.getAttribute("value");
			System.out.println(getCloseTimeHourValue);

			String getCloseTimeMinuteValue = dropdown_CloseTimeMinute
					.getAttribute("value");
			System.out.println(getCloseTimeMinuteValue);

			button_UpdateDetail.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			//driver.switchTo().defaultContent();

			softAssert.assertEquals(alertMessage, "Serial No. does not match.");
			softAssert.assertAll();

		}

		// In user enter replaced serial number while tech close and in Final Close
		// Details pop up->Update Serial No For this
		// Asset field if user enter different value then notification should
		// display as 'Serial No. does not match.'
		public void matchPopUpWithUpdateSerialNoFieldFill() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*// click on Technician close tab
			tab_TechnicianClose.click();

			// click on final close button
			button_Close.click();

			// select close date and time
			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			int preDay = Integer.parseInt(currentDay);
			String previousDay = Integer.toString(preDay);
			symbol_CloseDateCalender.click();

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
			String getCloseDateValue = textbox_CloseDate.getAttribute("value");
			System.out.println(getCloseDateValue);

			// select ETA Time Minute
			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hrs);
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			int previousMinut = Integer.parseInt(min) - 1;
			String previousMinutValue = Integer.toString(previousMinut);

			System.out.println(previousMinutValue);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {

					Thread.sleep(1000);
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(previousMinutValue)) {

					Thread.sleep(1000);
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}
	*/
			// enter the update serial number in Update Serial No
			// For
			// this Asset field
			textbox_UpdateSerialNo.sendKeys("123");

			button_UpdateDetail.click();

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			//driver.switchTo().defaultContent();

			// Match both the serial number is same
			softAssert.assertEquals(alertMessage, "Serial No. does not match.");
			softAssert.assertAll();

		}

		// If User enter correct serial number while technician close then user need
		// to enter same serial number in
		// 'Update Serial No For this Asset' field in final close pop up to override
		// on existing serial number
		public void closePinkTicket() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			/*// click on filter
			tab_Filter.click();

			// select engineer filter
			Select engineer;
			engineer = new Select(dropdown_Engineer);
			engineer.selectByVisibleText("Pranjali Deshpande");

			Thread.sleep(500);

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				List<WebElement> status = list_StatusInTable;
				int size = status.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {

					String statusValue = status.get(i).getText();
					System.out.println(statusValue);

					if (statusValue.equalsIgnoreCase("TechnicianClosed"))

					{

						List<WebElement> SelectID = driver
								.findElements(By
										.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
						String SelectIDWithPink = SelectID.get(i).getAttribute(
								"class");
						System.out.println(SelectIDWithPink);

						if (SelectIDWithPink.contains("techclosed")) {

							String serialNumberValue = list_SerialNumberInTable
									.get(i).getText();
							System.out.println(serialNumberValue);

							// get ID from list of Available Spares Window
							String idValue = list_IDInTable.get(i).getText();
							System.out.println(idValue);

							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									list_IDInTable.get(i));
							list_IDInTable.get(i).click();

							// click on Technician close tab
							tab_TechnicianClose.click();

							// get the serial number from technician close tab
							String serialNumberValueInTechClose = label_SerialNumber
									.getText();
							String splitNumberValue = serialNumberValueInTechClose
									.split("Serial No. :")[1];
							String splitSpace = splitNumberValue.split(" ")[1];
							System.out.println(splitSpace);

							// click on final close
							button_Close.click();

							// Get System Date
							Calendar mydate = new GregorianCalendar();
							int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
							System.out.println(dayOfMonth);
							String currentDay = Integer.toString(dayOfMonth);

							int preDay = Integer.parseInt(currentDay);
							String previousDay = Integer.toString(preDay);
							symbol_CloseDateCalender.click();

							// select close date and time

							// select Date
							String getDateValue = null;

							List<WebElement> allDates = driver
									.findElements(By
											.xpath(".//*[@id='fd-dp-4']/table/tbody/tr/td"));

							for (WebElement ele : allDates) {

								String date = ele.getText();

								if (date.equalsIgnoreCase(previousDay)) {
									Thread.sleep(1000);
									ele.click();
									getDateValue = ele.getText();
									System.out.println("Select the date:-"
											+ getDateValue);

									break;
								}

							}

							String getCloseDateValue = textbox_CloseDate
									.getAttribute("value");

							System.out.println(getCloseDateValue);

							// select ETA Time Minute

							// Get System Time
							Calendar calendar = Calendar.getInstance();
							String hrs = new SimpleDateFormat("HH").format(calendar
									.getTime());
							int preHour = Integer.parseInt(hrs);
							String previousHour = Integer.toString(preHour);

							System.out.println(hrs);
							String min = new SimpleDateFormat("mm").format(calendar
									.getTime());
							int preMinute = Integer.parseInt(min) - 1;
							String previousMinute = Integer.toString(preMinute);

							System.out.println(previousMinute);

							// select Hrs in Drop down

							for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {

								String hrsInDropdown = hrsofSystem.getText();

								if (hrsInDropdown.equalsIgnoreCase(previousHour)) {

									Thread.sleep(1000);
									hrsofSystem.click();
									String getTimeHour = hrsofSystem.getText();
									System.out.println("Select the hrs:-"
											+ getTimeHour);

									break;
								}

							}

							// select Minute in Drop down

							for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {

								String minInDropdown = minOfSystem.getText();

								if (minInDropdown.equalsIgnoreCase(previousMinute)) {

									Thread.sleep(1000);
									minOfSystem.click();
									String getTimeMinute = minOfSystem.getText();
									System.out.println("Select the min:-"
											+ getTimeMinute);

									break;
								}

							}

							
							 * Select closeTimeMinute; closeTimeMinute = new
							 * Select(dropdown_CloseTimeMinute);
							 * closeTimeMinute.selectByVisibleText("00");
							 * Thread.sleep(3000);
							 

							String getCloseTimeHourValue = dropdown_CloseTimeHour
									.getAttribute("value");
							System.out.println(getCloseTimeHourValue);

							String getCloseTimeMinuteValue = dropdown_CloseTimeMinute
									.getAttribute("value");
							System.out.println(getCloseTimeMinuteValue);*/

							try {
								// update the serial number
								textbox_UpdateSerialNo.sendKeys(serialNumber);

								driver.manage().timeouts()
										.pageLoadTimeout(60, TimeUnit.SECONDS);

								button_UpdateDetail.click();

								Thread.sleep(1000);

								/*// click on search ticket tab
								tab_SearchTicket.click();

								// enter the alphabetical value in ID field, after that
								// it
								// display the alert box
								textbox_SearchId.sendKeys(idValue);

								// click on Go button
								button_IDGo.click();
	*/
								Thread.sleep(1000);

								String serialNumberValueAfterUpdateSerialNumber = driver
										.findElement(
												By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[10]"))
										.getText();
								System.out
										.println(serialNumberValueAfterUpdateSerialNumber);
								String serialNumberValueAfterUpdateSerialNo = serialNumberValueAfterUpdateSerialNumber
										.split("Serial No. :")[1];

								softAssert.assertEquals(serialNumberValueAfterUpdateSerialNo,
										serialNumber);
							} catch (Exception e) {
								button_Cancel.click();
							}

		
		
			softAssert.assertAll();
		}

		public void selectTicketForTechnicianClose() throws Exception {

			tab_Filter.click();

			// select engineer filter
			Select engineer;
			engineer = new Select(dropdown_Engineer);
			engineer.selectByVisibleText("Pranjali Deshpande");

			Thread.sleep(500);
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_ATADateInTable.size();
				System.out.println(size);
				for (int i = 0; i < size; i++) {

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					if (status.equalsIgnoreCase("open") && !ETA.equals("")
							&& !ATA.equals("")) {
						String id = list_IDInTable.get(i).getText();
						System.out.println(id);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));
						list_IDInTable.get(i).click();
						break loop;
					}
				}
				if (sizePagination - 1 == p) {
					Assert.assertTrue(false, " Ticket is not Available");
				}

			}

		}

		// If User enter correct serial number while technician close then user need
		// to enter same serial number
		// in 'Update Serial No For this Asset' field in final close pop up to
		// override on existing serial number
		public void selectTechnicianCloseWithSerial() throws Exception {
			// click on filter
			tab_Filter.click();

			// select engineer filter
			Select engineer;
			engineer = new Select(dropdown_Engineer);
			engineer.selectByVisibleText("Pranjali Deshpande");

			Thread.sleep(500);

			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				List<WebElement> status = list_StatusInTable;
				int size = status.size();
				System.out.println(size);

				for (int i = 0; i < size; i++) {

					String statusValue = status.get(i).getText();
					System.out.println(statusValue);

					if (statusValue.equalsIgnoreCase("TechnicianClosed"))

					{

						List<WebElement> SelectID = driver
								.findElements(By
										.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
						String SelectIDWithPink = SelectID.get(i).getAttribute(
								"class");
						System.out.println(SelectIDWithPink);

						if (SelectIDWithPink.contains("techclosed odd")) {

							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									list_IDInTable.get(i));
							list_IDInTable.get(i).click();

							// click on Technician close tab
							tab_TechnicianClose.click();

							break loop;

						}
					}
				}
				if (sizePagination - 1 == p) {
					Assert.assertTrue(false, " Ticket is not Available");
				}
			}
		}

		
		// Create Sub Ticket

			// If User click on Create Sub Ticket button without punch ETA then
			// notification should display as 'Please Update ETA Date First' .

			public void checkAlertMessageWithoutETA() throws Exception {
		
				SoftAssert softAssert = new SoftAssert();

				int sizePagination = dropdown_Pagination.size();
				System.out.println(sizePagination);
				loop: for (int p = 0; p < sizePagination; p++) {

					dropdown_Pagination.get(p).click();

					Thread.sleep(3000);

					List<WebElement> status = list_StatusInTable;
					int size = status.size();
					System.out.println(size);

					for (int i = 0; i < size; i++) {

						String statusValue = status.get(i).getText();
						System.out.println(statusValue);

						String ETA = list_ETADateInTable.get(i).getText();
						System.out.println(ETA);

						if (statusValue.equalsIgnoreCase("Open") && ETA.equals("")) {

							// click on ID
							String idValue = list_IDInTable.get(i).getText();
							System.out.println(idValue);
							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									list_IDInTable.get(i));

							list_IDInTable.get(i).click();

							Thread.sleep(1000);

							// click on create sub ticket tab

							tab_CreateSubTicket.click();

							// get alert
							Alert alert = driver.switchTo().alert();
							String alertMessage = alert.getText();
							System.out.println(alertMessage);
							alert.accept();

							softAssert.assertEquals(alertMessage,
									"Please Update ETA Date First");

							break loop;

						}

					}
					if (size - 1 == p) {
						softAssert.assertTrue(false, " Ticket is not Available");
					}
				}
				softAssert.assertAll();
			}

			
			// If User click on Create Sub Ticket button without punch ATA then
				// notification should display as 'Please Update ATA Date First' .

				public void checkAlertMessageWithoutATA() throws Exception {
					SoftAssert softAssert = new SoftAssert();
					// click on ETA and Technician tab
					tab_ETATechnician.click();

					// click on Call Assign To Technician Button.
					button_CallAssignToTechnician.click();

					for (String Window : driver.getWindowHandles()) {

						System.out.println(Window);

					}

					// Get System Date
					Calendar mydate = new GregorianCalendar();
					int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
					System.out.println(dayOfMonth);
					String currentDay = Integer.toString(dayOfMonth);

					// This is Optional
					/*
					 * // Used If you want select Previous date int nextDay =
					 * Integer.parseInt(currentDay) ; String nxtDay =
					 * Integer.toString(nextDay);
					 */
					calendar_ETADetailsPage.click();

					// select Date in Calendar

					for (WebElement day : day_CalendarInETADetailsPage) {

						String dayInCalender = day.getText();

						if (dayInCalender.equalsIgnoreCase(currentDay)) {
							Thread.sleep(500);
							day.click();
							String getDateValue = day.getText();
							System.out.println("Select the date:-"
									+ getDateValue);

							break;
						}

					}

					// Get Date in ATA Date Text box
					String datePattern = "yyyy-MM-dd";
					DateFormat dateFormat = new SimpleDateFormat(datePattern);
					String currentDate = textbox_ETADateInETADetailsPage
							.getAttribute("value");
					System.out.println(currentDate);
					Date ATADate = (Date) dateFormat.parse(currentDate);
					System.out.println(ATADate);

					// Get System Time
					Calendar calendar = Calendar.getInstance();
					String currentHrs = new SimpleDateFormat("HH")
							.format(calendar.getTime());
					System.out.println(currentHrs);
					int nextHrs = Integer.parseInt(currentHrs) + 1;
					String hrs = Integer.toString(nextHrs);

					String currentMin = new SimpleDateFormat("mm")
							.format(calendar.getTime());
					System.out.println(currentMin);
					int nextMin = Integer.parseInt(currentMin);
					String min = Integer.toString(nextMin);

					// select Hrs in Drop down

					for (WebElement hrsofSystem : dropdown_HrsOfETATimeInETADetailsPage) {

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

					for (WebElement minOfSystem : dropdown_MinOfETATimeInETADetailsPage) {

						String minInDropdown = minOfSystem.getText();

						if (minInDropdown.equalsIgnoreCase(min)) {
							minOfSystem.click();
							String getDateValue = minOfSystem.getText();
							System.out.println("Select the min:-"
									+ getDateValue);

							break;
						}

					}

					// Click on update button
					button_UpdateDetail.click();
					// Thread.sleep(3000);

					// get the message from that alert box
					
					// Thread.sleep(3000);

					

					try {
						Alert technicianAlert1 = driver.switchTo().alert();
						// Thread.sleep(3000);
						String technicianAlertMessage = technicianAlert1.getText();
						System.out.println("Alert Text:" + technicianAlertMessage);
						Thread.sleep(1000);
						technicianAlert1.accept();
						
					
						// click on create sub ticket tab

						tab_CreateSubTicket.click();
						
						Alert technicianAlert2 = driver.switchTo().alert();
						// Thread.sleep(3000);
						Thread.sleep(1000); 
						String technicianAlertMessages = technicianAlert2.getText();
						System.out.println("Alert Text:" + technicianAlertMessages);
						Thread.sleep(1000);
						technicianAlert2.dismiss();
						
						Thread.sleep(1000);
						// click on create sub ticket tab

						tab_CreateSubTicket.click();
					} catch (Exception e) {
						Alert technicianAlert4 = driver.switchTo().alert();
						String technicianAlertMessage = technicianAlert4.getText();
						System.out.println("Alert Text:" + technicianAlertMessage);
						Thread.sleep(1000);
						technicianAlert4.dismiss();
						
						// click on create sub ticket tab

						tab_CreateSubTicket.click();
					}
				
					
					
					
						
						
					
				


/*
							Thread.sleep(1000);
							// click on create sub ticket tab

							tab_CreateSubTicket.click();
*/
							// get alert
							Alert alert = driver.switchTo().alert();
							String alertMessage = alert.getText();
							System.out.println(alertMessage);
							alert.accept();

							softAssert.assertEquals(alertMessage,
									"Please Update ATA Date First");
							softAssert.assertAll();

							
				}
		// If User click on create sub ticket button for pause ticket then ticket
		// form should get open to record sub ticket
		public void checkCreateSubTicketAndViewSubTicketForPause() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			
			// Click on ATA Tab
			tab_ATA.click();

			// Click on Edit Button In ATA Tab
			button_EditInATATab.click();

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			// Click on Calendar
			calendar_ATADetailsPage.click();

			// select Date in Calendar
			for (WebElement day : day_CalendarInATADetailsPage) {

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

			/*// Get Date in ATA Date Text box
			String currentDate = textbox_ATADateInATADetailsPage
					.getAttribute("value");
			System.out.println(currentDate);
			Date ATADate = (Date) dateFormat.parse(currentDate);
			System.out.println(ATADate);*/

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hrs = new SimpleDateFormat("HH").format(calendar
					.getTime());
			System.out.println(hrs);
			String min = new SimpleDateFormat("mm").format(calendar
					.getTime());
			System.out.println(min);

			// select Hrs in Drop down
			for (WebElement hrsofSystem : dropdown_HrsOfATATimeInATADetailsPage) {

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
			for (WebElement minOfSystem : dropdown_MinOfATATimeInATADetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-"
							+ getDateValue);

					break;
				}

			}

		/*	// concatenation of Hrs & min
			String hrsMin = hrs.concat(":" + min);
			System.out.println(hrsMin);
			Date ATATime = (Date) timeFormat.parse(hrsMin);
			System.out.println(ATATime);*/

			// Select Machine Available
			Select machineAvailable = new Select(
					dropdown_MachineAvailableInATADetailsPage);
			machineAvailable.selectByVisibleText("Yes");

			// Click on Update Details
			button_UpdateDetailsInATADetailsPage.click();

					// click on create sub ticket tab

					tab_CreateSubTicket.click();

					// get alert
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					System.out.println(alertMessage);
					alert.accept();

					softAssert.assertEquals(alertMessage,
							"Are You Sure Want To Create Sub Ticket?");

					String headingValueOfTicketForm = label_OfHeading.getText();
					System.out.println(headingValueOfTicketForm);

					softAssert.assertEquals(headingValueOfTicketForm, "Ticket Form");

					driver.manage().timeouts()
							.pageLoadTimeout(60, TimeUnit.SECONDS);

					button_RecordSubTicket.click();
					Thread.sleep(1000);

					String headingValueOfSubTicketForm = label_OfHeading.getText();
					System.out.println(headingValueOfSubTicketForm);

					softAssert.assertEquals(headingValueOfSubTicketForm,
							"Sub Ticket Form");

					/*createNewPageOfSdRole = new SD_CreateNewPage();
					WebElement fromCreateTicketPage = createNewPageOfSdRole.textbox_IncidenID;
					String getSatusValue = fromCreateTicketPage.getText();
					System.out.println(getSatusValue);
					String splitStatus = getSatusValue.split("\n")[2];
					System.out.println(splitStatus);

					// check the status of sub ticket is change to open
					softAssert.assertEquals(splitStatus, "Status : Open");*/
					softAssert.assertAll();

					
		}

		

		
		

		public void punchTheETA() throws InterruptedException, Exception {
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				List<WebElement> status = list_StatusInTable;
				System.out.println(status.size());

				for (int i = 0; i < status.size(); i++) {

					String statusValue = status.get(i).getText();
					System.out.println(statusValue);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					if (statusValue.equalsIgnoreCase("Open") && ETA.equals(""))

					{

						// get ID from list of Available Spares Window
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();
						// click on that ID
						// driver.findElement(By.linkText(idValue)).click();
						// Thread.sleep(2000);

						// click on ETA and Technician tab
						tab_ETATechnician.click();

						// click on Call Assign To Technician Button.
						button_CallAssignToTechnician.click();

						for (String Window : driver.getWindowHandles()) {

							System.out.println(Window);

						}

						// Get System Date
						Calendar mydate = new GregorianCalendar();
						int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
						System.out.println(dayOfMonth);
						String currentDay = Integer.toString(dayOfMonth);

						// This is Optional
						/*
						 * // Used If you want select Previous date int nextDay =
						 * Integer.parseInt(currentDay) ; String nxtDay =
						 * Integer.toString(nextDay);
						 */
						calendar_ETADetailsPage.click();

						// select Date in Calendar

						for (WebElement day : day_CalendarInETADetailsPage) {

							String dayInCalender = day.getText();

							if (dayInCalender.equalsIgnoreCase(currentDay)) {
								Thread.sleep(500);
								day.click();
								String getDateValue = day.getText();
								System.out.println("Select the date:-"
										+ getDateValue);

								break;
							}

						}

						// Get Date in ATA Date Text box
						String datePattern = "yyyy-MM-dd";
						DateFormat dateFormat = new SimpleDateFormat(datePattern);
						String currentDate = textbox_ETADateInETADetailsPage
								.getAttribute("value");
						System.out.println(currentDate);
						Date ATADate = (Date) dateFormat.parse(currentDate);
						System.out.println(ATADate);

						// Get System Time
						Calendar calendar = Calendar.getInstance();
						String currentHrs = new SimpleDateFormat("HH")
								.format(calendar.getTime());
						System.out.println(currentHrs);
						int nextHrs = Integer.parseInt(currentHrs) + 1;
						String hrs = Integer.toString(nextHrs);

						String currentMin = new SimpleDateFormat("mm")
								.format(calendar.getTime());
						System.out.println(currentMin);
						int nextMin = Integer.parseInt(currentMin);
						String min = Integer.toString(nextMin);

						// select Hrs in Drop down

						for (WebElement hrsofSystem : dropdown_HrsOfETATimeInETADetailsPage) {

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

						for (WebElement minOfSystem : dropdown_MinOfETATimeInETADetailsPage) {

							String minInDropdown = minOfSystem.getText();

							if (minInDropdown.equalsIgnoreCase(min)) {
								minOfSystem.click();
								String getDateValue = minOfSystem.getText();
								System.out.println("Select the min:-"
										+ getDateValue);

								break;
							}

						}

						// Click on update button
						button_UpdateDetail.click();
						// Thread.sleep(3000);

						// get the message from that alert box
						Alert technicianAlert = driver.switchTo().alert();
						// Thread.sleep(3000);

						String technicianAlertMessage = technicianAlert.getText();
						System.out.println("Alert Text:" + technicianAlertMessage);
						technicianAlert.dismiss();

						String notificationText = notification.getText();
						System.out.println(notificationText);

						Assert.assertEquals(notificationText,
								"Incident Updated SuccessFully",
								"Notification is not Match");
						break loop;

					}
				}
				if (sizePagination - 1 == p)
					Assert.assertTrue(false,
							" Ticket is not Available for Punching ETA");

			}
		}

		public void punchTheATA() throws Exception {
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_IDInTable.size();
				System.out.println(size);
				for (int i = 0; i < size; i++) {

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					if (status.equals("Open") && !ETA.equals("") && ATA.equals("")) {
						String idValue = list_IDInTable.get(i).getText();
						System.out.println(idValue);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));

						list_IDInTable.get(i).click();

						// Format Date
						String datePattern = "yyyy-MM-dd";
						DateFormat dateFormat = new SimpleDateFormat(datePattern);

						// Format Time
						String timePattern = "HH:mm";
						DateFormat timeFormat = new SimpleDateFormat(timePattern);

						// Click on ATA Tab
						tab_ATA.click();

						// Click on Edit Button In ATA Tab
						button_EditInATATab.click();

						// Get System Date
						Calendar mydate = new GregorianCalendar();
						int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
						System.out.println(dayOfMonth);
						String currentDay = Integer.toString(dayOfMonth);

						// Click on Calendar
						calendar_ATADetailsPage.click();

						// select Date in Calendar
						for (WebElement day : day_CalendarInATADetailsPage) {

							String dayInCalender = day.getText();

							if (dayInCalender.equalsIgnoreCase(currentDay)) {
								day.click();
								String getDateValue = day.getText();
								System.out.println("Select the date:-"
										+ getDateValue);

								break;
							}

						}

						// Get Date in ATA Date Text box
						String currentDate = textbox_ATADateInATADetailsPage
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
						for (WebElement hrsofSystem : dropdown_HrsOfATATimeInATADetailsPage) {

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
						for (WebElement minOfSystem : dropdown_MinOfATATimeInATADetailsPage) {

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

						// Select Machine Available
						Select machineAvailable = new Select(
								dropdown_MachineAvailableInATADetailsPage);
						machineAvailable.selectByVisibleText("Yes");

						// Click on Update Details
						button_UpdateDetailsInATADetailsPage.click();

						String notificationText = notification.getText();
						System.out.println(notificationText);

						Assert.assertEquals(notificationText,
								"Incident Updated Successfully",
								"Notification is not Match");

						break loop;
					}
				}

				if (sizePagination - 1 == p)
					Assert.assertTrue(false,
							" Ticket is not Available for Punching ATA");
			}

		}

		public void punchETAAndATAAfterCreatingTicket()
				throws InterruptedException, Exception {
			driver.findElement(By.linkText("Edit Incident")).click();
			// Thread.sleep(2000);

			// click on ETA and Technician tab
			tab_ETATechnician.click();

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			for (String Window : driver.getWindowHandles()) {

				System.out.println(Window);

			}

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Previous date
			/*
			 * int nextDay = Integer.parseInt(currentDay) ; String nxtDay =
			 * Integer.toString(nextDay);
			 */
			calendar_ETADetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInETADetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(currentDay)) {
					Thread.sleep(1000);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:" + getDateValue);

					break;
				}

			}

			// Get Date in ATA Date Text box
			String datePattern = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);
			String currentDate = textbox_ETADateInETADetailsPage
					.getAttribute("value");
			System.out.println(currentDate);
			Date ATADate = (Date) dateFormat.parse(currentDate);
			System.out.println(ATADate);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String currentHrs = new SimpleDateFormat("HH").format(calendar
					.getTime());
			System.out.println(currentHrs);
			int nextHrs = Integer.parseInt(currentHrs) + 1;
			String hrs = Integer.toString(nextHrs);

			String currentMin = new SimpleDateFormat("mm").format(calendar
					.getTime());
			System.out.println(currentMin);
			int nextMin = Integer.parseInt(currentMin);
			String min = Integer.toString(nextMin);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_HrsOfETATimeInETADetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_MinOfETATimeInETADetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			// Click on update button
			button_UpdateDetail.click();
			// Thread.sleep(3000);

			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			technicianAlert.dismiss();

			// String notificationText = notification.getText();
			// System.out.println(notificationText);

			// Assert.assertEquals(notificationText,
			// "Incident Updated SuccessFully",
			// "Notification is not Match");
			// Click on ATA Tab
			tab_ATA.click();

			// Click on Edit Button In ATA Tab
			button_EditInATATab.click();

			// Get System Date
			Calendar mydate1 = new GregorianCalendar();
			int dayOfMonth1 = mydate1.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth1);
			String currentDay1 = Integer.toString(dayOfMonth1);

			// Click on Calendar
			calendar_ATADetailsPage.click();

			// select Date in Calendar
			for (WebElement day : day_CalendarInATADetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(currentDay1)) {
					Thread.sleep(1000);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// Get Date in ATA Date Text box
			String currentDate1 = textbox_ATADateInATADetailsPage
					.getAttribute("value");
			System.out.println(currentDate1);
			Date ATADate1 = (Date) dateFormat.parse(currentDate1);
			System.out.println(ATADate1);

			// Get System Time
			Calendar calendar1 = Calendar.getInstance();
			String hrs1 = new SimpleDateFormat("HH").format(calendar1.getTime());
			System.out.println(hrs1);
			String min1 = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min1);

			// select Hrs in Drop down
			for (WebElement hrsofSystem : dropdown_HrsOfATATimeInATADetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs1)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down
			for (WebElement minOfSystem : dropdown_MinOfATATimeInATADetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min1)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			// Select Machine Available
			Select machineAvailable = new Select(
					dropdown_MachineAvailableInATADetailsPage);
			machineAvailable.selectByVisibleText("Yes");

			// Click on Update Details
			button_UpdateDetailsInATADetailsPage.click();

			String notificationText1 = notification.getText();
			System.out.println(notificationText1);

			Assert.assertEquals(notificationText1, "Incident Updated Successfully",
					"Notification is not Match");

		}

		public void punchETAAfterCreatingTicket() throws InterruptedException,
				Exception {

			driver.findElement(By.linkText("Edit Incident")).click();
			// Thread.sleep(2000);

			// click on ETA and Technician tab
			tab_ETATechnician.click();

			// click on Call Assign To Technician Button.
			button_CallAssignToTechnician.click();

			for (String Window : driver.getWindowHandles()) {

				System.out.println(Window);

			}

			String selectedName = textbox_Technician.getAttribute("value");
			System.out.println("selected technician name is:-" + selectedName);

			// clear all the field
			textbox_Technician.clear();

			// click the first list of click on first list symbol of
			// Technician Field
			symbol_TechnicianList.click();

			// Window handler
			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}

			// select Business Unit of that window
			Select technicianBusinessUnit;
			technicianBusinessUnit = new Select(driver.findElement(By
					.name("m_strBusinessUnit")));
			technicianBusinessUnit.selectByIndex(8);
			System.out.println("woldline");

			// Thread.sleep(1000)
			Select state;
			state = new Select(driver.findElement(By.name("m_strState")));
			state.selectByValue("Maharashtra");
			System.out.println("Maharashtra");

			// click on go button of state
			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[2]/td[3]/input"))
					.click();

			Select city;
			city = new Select(driver.findElement(By.name("m_strCity")));
			city.selectByValue("Kalyan");
			System.out.println("Kalyan");
			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[3]/td[3]/input"))
					.click();

			// Thread.sleep(3000);

			int size = list_TechnicianName.size();

			for (int j = 0; j < size; j++) {

				// Thread.sleep(2000);
				String technicianVlaue = list_TechnicianName.get(j).getText();
				System.out.println(technicianVlaue);

				if (technicianVlaue.contains("Pranjali Deshpande"))

				{
					// Thread.sleep(2000);
					list_TechnicianName.get(j).click();
					break;

				}

			}

			// go to first window
			for (String basicWindow : driver.getWindowHandles()) {
				driver.switchTo().window(basicWindow);

			}
			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(dayOfMonth);
			String currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Previous date
			/*
			 * int nextDay = Integer.parseInt(currentDay) ; String nxtDay =
			 * Integer.toString(nextDay);
			 */
			calendar_ETADetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInETADetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(currentDay)) {
					Thread.sleep(1000);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:" + getDateValue);

					break;
				}

			}

			// Get Date in ATA Date Text box
			String datePattern = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);
			String currentDate = textbox_ETADateInETADetailsPage
					.getAttribute("value");
			System.out.println(currentDate);
			Date ATADate = (Date) dateFormat.parse(currentDate);
			System.out.println(ATADate);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String currentHrs = new SimpleDateFormat("HH").format(calendar
					.getTime());
			System.out.println(currentHrs);
			int nextHrs = Integer.parseInt(currentHrs) + 1;
			String hrs = Integer.toString(nextHrs);

			String currentMin = new SimpleDateFormat("mm").format(calendar
					.getTime());
			System.out.println(currentMin);
			int nextMin = Integer.parseInt(currentMin);
			String min = Integer.toString(nextMin);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_HrsOfETATimeInETADetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_MinOfETATimeInETADetailsPage) {

				String minInDropdown = minOfSystem.getText();

				if (minInDropdown.equalsIgnoreCase(min)) {
					minOfSystem.click();
					String getDateValue = minOfSystem.getText();
					System.out.println("Select the min:-" + getDateValue);

					break;
				}

			}

			// Click on update button
			button_UpdateDetail.click();
			// Thread.sleep(3000);

			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			technicianAlert.dismiss();

			// String notificationText = notification.getText();
			// System.out.println(notificationText);

			// Assert.assertEquals(notificationText,
			// "Incident Updated SuccessFully",
			// "Notification is not Match");
			// Click on ATA Tab
			/*
			 * tab_ATA.click();
			 * 
			 * // Click on Edit Button In ATA Tab button_EditInATATab.click();
			 * 
			 * // Get System Date Calendar mydate1 = new GregorianCalendar(); int
			 * dayOfMonth1 = mydate1.get(Calendar.DAY_OF_MONTH);
			 * System.out.println(dayOfMonth1); String currentDay1 =
			 * Integer.toString(dayOfMonth1);
			 * 
			 * // Click on Calendar calendar_ATADetailsPage.click();
			 * 
			 * // select Date in Calendar for (WebElement day :
			 * day_CalendarInATADetailsPage) {
			 * 
			 * String dayInCalender = day.getText();
			 * 
			 * if (dayInCalender.equalsIgnoreCase(currentDay1)) {
			 * Thread.sleep(1000); day.click(); String getDateValue = day.getText();
			 * System.out.println("Select the date:-" + getDateValue);
			 * 
			 * break; }
			 * 
			 * }
			 * 
			 * // Get Date in ATA Date Text box String currentDate1 =
			 * textbox_ATADateInATADetailsPage .getAttribute("value");
			 * System.out.println(currentDate1); Date ATADate1 = (Date)
			 * dateFormat.parse(currentDate1); System.out.println(ATADate1);
			 * 
			 * // Get System Time Calendar calendar1 = Calendar.getInstance();
			 * String hrs1 = new SimpleDateFormat("HH").format(calendar1.getTime());
			 * System.out.println(hrs1); String min1 = new
			 * SimpleDateFormat("mm").format(calendar.getTime());
			 * System.out.println(min1);
			 * 
			 * // select Hrs in Drop down for (WebElement hrsofSystem :
			 * dropdown_HrsOfATATimeInATADetailsPage) {
			 * 
			 * String hrsInDropdown = hrsofSystem.getText();
			 * 
			 * if (hrsInDropdown.equalsIgnoreCase(hrs1)) { hrsofSystem.click();
			 * String getDateValue = hrsofSystem.getText();
			 * System.out.println("Select the hrs:-" + getDateValue);
			 * 
			 * break; }
			 * 
			 * }
			 * 
			 * // select Min in Drop down for (WebElement minOfSystem :
			 * dropdown_MinOfATATimeInATADetailsPage) {
			 * 
			 * String minInDropdown = minOfSystem.getText();
			 * 
			 * if (minInDropdown.equalsIgnoreCase(min1)) { minOfSystem.click();
			 * String getDateValue = minOfSystem.getText();
			 * System.out.println("Select the min:-" + getDateValue);
			 * 
			 * break; }
			 * 
			 * }
			 * 
			 * // Select Machine Available Select machineAvailable = new Select(
			 * dropdown_MachineAvailableInATADetailsPage);
			 * machineAvailable.selectByVisibleText("Yes");
			 * 
			 * // Click on Update Details
			 * button_UpdateDetailsInATADetailsPage.click();
			 * 
			 * String notificationText1 = notification.getText();
			 * System.out.println(notificationText1);
			 * 
			 * Assert.assertEquals(notificationText1,
			 * "Incident Updated Successfully", "Notification is not Match");
			 */
		}

		public void technicianClose() throws Exception {
			int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);
			loop: for (int p = 0; p < sizePagination; p++) {

				dropdown_Pagination.get(p).click();

				int size = list_ATADateInTable.size();
				System.out.println(size);
				for (int i = 0; i < size; i++) {

					String status = list_StatusInTable.get(i).getText();
					System.out.println(status);

					String ETA = list_ETADateInTable.get(i).getText();
					System.out.println(ETA);

					String ATA = list_ATADateInTable.get(i).getText();
					System.out.println(ATA);

					if (status.equalsIgnoreCase("open") && !ETA.equals("")
							&& !ATA.equals("")) {
						String id = list_IDInTable.get(i).getText();
						System.out.println(id);
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IDInTable.get(i));
						list_IDInTable.get(i).click();

						// Click on Spare Tab
						tab_SpareInTicketForm.click();

						// Click on Edit Button In Pause Tab
						button_EditInSpareTab.click();

						for (String Window : driver.getWindowHandles()) {
							driver.switchTo().window(Window);
						}

						// Get Heading
						// Thread.sleep(1000);
						// select the Spares Consumed By Inventory logistic
						Select sparesConsumed;
						sparesConsumed = new Select(
								dropdown_SparesConsumedInSpareTab);
						sparesConsumed.selectByVisibleText("No");
						button_UpdateDetail.click();

						for (String Window : driver.getWindowHandles()) {
							driver.switchTo().window(Window);
						}
						tab_TechnicianClose.click();
						driver.manage().timeouts()
								.pageLoadTimeout(10, TimeUnit.SECONDS);
						button_EditOfTechncianClose.click();

						// To Handle window based pop-up
						/*
						 * Robot robot = new Robot();
						 * robot.keyPress(KeyEvent.VK_CONTROL);
						 * robot.keyPress(KeyEvent.VK_MINUS); Thread.sleep(1000);
						 * robot.keyPress(KeyEvent.VK_CONTROL);
						 * robot.keyPress(KeyEvent.VK_MINUS);
						 */

						// Get System Date
						Calendar mydate = new GregorianCalendar();
						int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
						System.out.println(dayOfMonth);
						String currentDay = Integer.toString(dayOfMonth);

						int preDay = Integer.parseInt(currentDay);
						String previousDay = Integer.toString(preDay);
						calendar_TechnicianClosePage.click();

						// select Date in Calendar

						for (WebElement day : day_CalendarInTechnicianClosePage) {

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

						// Get System Time
						Calendar calendar = Calendar.getInstance();
						String hrs = new SimpleDateFormat("HH").format(calendar
								.getTime());
						System.out.println(hrs);
						String min = new SimpleDateFormat("mm").format(calendar
								.getTime());
						System.out.println(min);

						// select Hrs in Drop down

						for (WebElement hrsofSystem : dropdown_HrsOfTechnicianCloseTime) {

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

						for (WebElement minOfSystem : dropdown_MinOfTechnicianCloseTime) {

							String minInDropdown = minOfSystem.getText();

							if (minInDropdown.equalsIgnoreCase(min)) {
								minOfSystem.click();
								String getDateValue = minOfSystem.getText();
								System.out.println("Select the min:-"
										+ getDateValue);

								break;
							}

						}

						String resolution = "abc";
						textbox_ResolutionInTechnicianClose.sendKeys(resolution);

						String resolutionDescription = "xyz";
						textbox_ResolutionDescriptionInTechnicianClose
								.sendKeys(resolutionDescription);

						String FSRNo = "123";
						textbox_FSRNoInTechnicianClose.sendKeys(FSRNo);
						// Thread.sleep(500);

						driver.manage().timeouts()
								.pageLoadTimeout(30, TimeUnit.SECONDS);
						button_submitTechCloseDetails.click();

						// Get Notification
						// Thread.sleep(1000);
						String notificationText1 = notification.getText();
						System.out.println(notificationText1);

						Assert.assertEquals(notificationText1,
								"Incident Updated SuccessFully",
								"Notification is not Match");
						break loop;
					}
				}
				if (sizePagination - 1 == p)
					Assert.assertTrue(false,
							" Ticket is not Available for Closing Ticket");

			}
		}

		public void pauseTheTicket() throws Exception {

			// Click on Pause Tab
			tab_PauseInTicketForm.click();

			// Click on Edit Button In Pause Tab
			button_EditInPauseTab.click();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

			// Click on List Of Pause Reasons Button
			button_ListOfPauseReasonsInPausepage.click();
			for (String listOfPauseReasons : driver.getWindowHandles()) {
				driver.switchTo().window(listOfPauseReasons);
			}

			// Get Pause Reason
			String pauseReason = column_PauseReasonsInListOfPauseReasonsPage.get(1)
					.getText();
			System.out.println(pauseReason);
			driver.findElement(By.linkText(pauseReason)).click();

			for (String Window : driver.getWindowHandles()) {
				driver.switchTo().window(Window);
			}

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
			String currentDay = Integer.toString(dayOfMonth);

			// This is Optional
			// Used If you want select Next date
			int afterDay = Integer.parseInt(currentDay) + 1;
			String nextDay = Integer.toString(afterDay);
			calendar_PauseDetailsPage.click();

			// select Date in Calendar

			for (WebElement day : day_CalendarInPauseDetailsPage) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(nextDay)) {
					Thread.sleep(500);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			Thread.sleep(1000);
			// Get Date in Resume Date Text box
			String resumeDateText = textbox_AutoResumeDateInPauseDetailsPage
					.getAttribute("value");
			System.out.println(resumeDateText);
			Date resumeDate = (Date) dateFormat.parse(resumeDateText);
			System.out.println(resumeDate);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String hour = new SimpleDateFormat("HH").format(calendar.getTime());
			System.out.println(hour);
			int hours = Integer.parseInt(hour) + 2;
			String hrs = Integer.toString(hours);
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			// select Hrs in Drop down

			for (WebElement hrsofSystem : dropdown_HrsOfAutoResumeTimeInPauseDetailsPage) {

				String hrsInDropdown = hrsofSystem.getText();

				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					hrsofSystem.click();
					String getDateValue = hrsofSystem.getText();
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// select Min in Drop down

			for (WebElement minOfSystem : dropdown_MinOfAutoResumeTimeInPauseDetailsPage) {

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
			Date pauseTime = (Date) timeFormat.parse(hrsMin);
			System.out.println(pauseTime);

			/*
			 * // Format of Date Time String dateTimePattern = "yyyy-MM-dd HH:mm";
			 * DateFormat dateTimeFormat = new SimpleDateFormat(dateTimePattern);
			 */
			// concatenation of date & Time in ATA Date Time
			String pauseEndDateAndTime = resumeDateText.concat("  " + hrsMin);
			System.out.println("pauseEndDateAndTime " + pauseEndDateAndTime);
			// Date dateTimeOfATA = (Date)
			// dateTimeFormat.parse(dateTimeOfATAText);
			// System.out.println(dateTimeOfATA);

			// Click on Update Details
			button_UpdateDetailsInPauseDetailsPage.click();

			// Click on Pause Tab
			Thread.sleep(2000);

		}
	}



