package com.uno.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.logistics.Logistic_HomePage;
import com.uno.pages.logistics.Logistic_InventoryRequiredPage;
import com.uno.pages.logistics.Logistic_LoginPage;
import com.uno.pages.logistics.Logistic_SpareDetailsReportPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_InventoryPage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_SpareApprovalPage;
import com.uno.pages.scm.SCM_HomePage;
import com.uno.pages.scm.SCM_InventoryPage;
import com.uno.pages.scm.SCM_LoginPage;
import com.uno.pages.scm.SCM_ValidationSpareRequestPage;
import com.uno.pages.sd.SD_AssetDetailsPage;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;

public class BasicFlowPage extends BaseCode

{
	// Declare variables
	public static String incidentID = null;
	public static String lastSpareRequestIDInSD = null;
	public static String secondLastSpareRequestIDInSD = null;
	public static String thirdLastSpareRequestIDInSD = null;

	public static String lastSpareRemarkInSD = null;

	// call the method from SD role
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_CreateNewPage createNewPageOfSdRole;
	SD_ViewTicketPage viewTicketPageOfSdRole;
	SD_AssetDetailsPage sd_AssetDetailsPage;

	RM_LoginPage loginPageOfReportingManagerRole;
	RM_HomePage homePageOfReportingManagerRole;
	RM_InventoryPage inventoryPageOfReportingManagerRole;
	RM_SpareApprovalPage spareApprovalPageInReportingManagerRole;

	SCM_LoginPage loginPageOfSCMRole;
	SCM_HomePage homePageOfSCMRole;
	SCM_InventoryPage inventoryPageOfSCMRole;
	SCM_ValidationSpareRequestPage validationSpareRequestOfSCMRole;

	Logistic_LoginPage loginPageOfLogisticRole;
	Logistic_HomePage homePageOfLogisticRole;
	Logistic_SpareDetailsReportPage spareDetailsReportPageOfLogisticRole;
	Logistic_InventoryRequiredPage inventoryRequiredPageOfLogisticRole;

	// Select SD tab for logout tab
	@FindBy(linkText = "Sd")
	WebElement link_sd;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement link_Test;

	// Select tab for logout tab
	@FindBy(linkText = "Bhagyashree")
	WebElement link_RM;

	// Select tab for logout tab
	@FindBy(linkText = "scm")
	WebElement link_scm;

	// Select tab for logout tab
	@FindBy(linkText = "Logistic")
	WebElement link_Logistic;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;

	// select Search Ticket
	@FindBy(css = "#open")
	WebElement tab_SearchTicketOpen;

	// select Search Ticket
	@FindBy(css = "#close")
	WebElement tab_SearchTicketClose;

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

	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)")
	List<WebElement> lstStatusInTable;

	// list of ETA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)")
	List<WebElement> lstETADateInTable;

	// list of ATA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)")
	List<WebElement> lstATADateInTable;

	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
	List<WebElement> lstIDInTable;

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
	@FindBy(css = ".rectagleBox.marBot10>div[class='toggle1']>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(7)>td")
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

	// select ETA Date Time
	@FindBy(css = "div[id='time_spent']>div:nth-of-type(4)>span:nth-of-type(1)")
	WebElement label_ATA;

	// ATA Tab //

	// ATA Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(4)>a")
	WebElement tab_ATA;

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
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(9)>a")
	public WebElement tab_SpareInTicketForm;

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
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[11]/a")
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

	// Spare Status in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[7]")
	List<WebElement> label_StatusInSpareTab;

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

	// spare request ID in spare detail pop up
	@FindBy(xpath = ".//*[@id='sparesLabel']/table[2]/tbody/tr/td[1]")
	List<WebElement> label_SpareRequestIdInSpareDetail;

	// spare request ID in spare detail pop up
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[1]")
	List<WebElement> label_SpareRequestIdInSpareTab;

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
	// select list of serial number in Add Spare tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(2)")
	List<WebElement> list_PartNameInSpareTab;

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
	@FindBy(css = "select[name='m_strReplacePartCode1']")
	WebElement dropdown_ListOfAnotherPartCodeInReplaceSpare;

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
	@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr/td[4]")
	List<WebElement> label_RemarkByInRemarkTab;

	// select the heading of add remark window
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
	WebElement label_AddRemark;

	// select remark text box
	@FindBy(name = "m_strRemarkValue")
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
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr[3]/td[5]")
	WebElement lable_DateOfActivities;

	// select date from activities Tab
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr[3]/td[6]")
	WebElement lable_TimeOfActivities;

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

	// select test tab for logout super Role
	@FindBy(xpath = ".//*[@id='main']/div[2]/div[2]/div/ul/li[13]/a")
	WebElement link_TestTabSuperRole;

	// Select Incident ID Text Box
	@FindBy(xpath = ".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]")
	WebElement textbox_IncidenID;

	// Select Search ID Text Box
	@FindBy(name = "m_strSearchIncId")
	WebElement textbox_SearchID;

	// Get Text From View Ticket Page Id
	@FindBy(css = "div[class='fht-tbody']>table>tbody>tr>td:nth-of-type(2)")
	WebElement ticketId_ViewTicketPage;

	// Click On Asset ID GO button
	@FindBy(xpath = ".//*[@id='Search_Incident']/tbody/tr[4]/td[2]/img")
	WebElement button_AssetIDGO;

	// Click On AssertID GO Button
	@FindBy(xpath = ".//*[@id='Search_Incident']/tbody/tr[6]/td[2]/img")
	WebElement button_TicketIDGO;

	// Select Log By Local Contact Number
	@FindBy(xpath = ".//*[@id='requestorDetails']/div[1]/table/tbody/tr/td[1]/input")
	WebElement textbox_LogByContactNumber;

	// Select Log By Serial Number TextBox
	@FindBy(xpath = ".//*[@id='requestorDetails']/div[1]/table/tbody/tr/td[3]/input")
	WebElement textbox_SerialNumber;

	// Select Log By Serial Number TextBox
	@FindBy(css = "input[name='m_strReplaceSerialNo']")
	WebElement txtSerialNumberInSpare;

	// Click on GO Button
	@FindBy(xpath = ".//*[@id='requestorDetails']/table/tbody/tr[2]/td[6]/a/span")
	WebElement button_SerialNoGO;

	// Select Request Title list button
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table[2]/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a")
	WebElement button_RequestTitle;

	// Select Request description TextBox
	@FindBy(className = "textarea")
	WebElement textbox_RequestDiscription;

	// Select Local contact Name TextBox
	@FindBy(name = "m_strValue1")
	WebElement textbox_LocalName;

	// Select Local Contact Number TextBox
	@FindBy(name = "m_strValue2")
	WebElement textbox_LocalContactNumber;

	// Select Customer Email ID TextBox
	@FindBy(name = "m_strValue3")
	WebElement textbox_CustomerEmailId;

	// Click On Technician List Button
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table[2]/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/img")
	WebElement button_Technician;

	// select technician from technician window
	@FindBy(css = "div[class='rectagleBox']>table>tbody>tr>td:nth-of-type(3)")
	List<WebElement> listOfRow_TechnicianName;

	// Select Ticket Type TextBox
	@FindBy(name = "m_strIncidentType")
	WebElement textbox_TicketType;

	// Select Record Ticket Button
	@FindBy(linkText = "Record Ticket")
	WebElement button_RecordTicket;

	// select ETA date text box
	@FindBy(name = "m_strEtaDate")
	WebElement textbox_ETADates;

	// Drop down Site Code
	@FindBy(css = "select[name='m_strSiteCode']")
	WebElement ddlSiteCode;
	
	// Drop down Site Code
	@FindBy(css = "select[name='m_strAssetID']")
	WebElement ddlAssetID;

	@FindBy(linkText = "Search Asset")
	WebElement btnSearchAssert;

	@FindBy(xpath = ".//*[@id='form']/div[2]/table/tbody/tr/td[2]/a")
	List<WebElement> lstAssetId;

	// Select Log By Local Contact Number
	@FindBy(name = "m_strSearchByMobileNo")
	WebElement txtLogByContactNumber;

	// Select Log By Serial Number TextBox
	@FindBy(name = "m_strSearchBySerialNo")
	WebElement txtSerialNumber;

	// Click on GO Button
	@FindBy(xpath = ".//*[@id='requestorDetails']/table/tbody/tr[2]/td[6]/a/span")
	WebElement btnSerialNoGO;

	// Select Request Title list button
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table[2]/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a")
	WebElement btnRequestTitle;

	// Select Request description TextBox
	@FindBy(className = "textarea")
	WebElement txtRequestDiscription;

	// Select Local contact Name TextBox
	@FindBy(name = "m_strValue1")
	WebElement txtLocalName;

	// Select Local Contact Number TextBox
	@FindBy(name = "m_strValue2")
	WebElement txtLocalContactNumber;

	// Select Customer Email ID TextBox
	@FindBy(name = "m_strValue3")
	WebElement txtCustomerEmailId;

	// Click On Technician List Button
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table[2]/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/img")
	WebElement btnTechnician;

	// select technician from technician window
	@FindBy(css = "div[class='rectagleBox']>table>tbody>tr>td:nth-of-type(3)")
	List<WebElement> lblTechnicianName;

	// Select Ticket Type TextBox
	@FindBy(name = "m_strIncidentType")
	WebElement txtTicketType;

	// Select Record Ticket Button
	@FindBy(linkText = "Record Ticket")
	WebElement btnRecordTicket;

	// Text box Customer
	@FindBy(css = "#m_strCustomerName")
	WebElement txtCustomer;

	// Drop down Business Unit
	@FindBy(css = "select[name='m_strBusinessUnit']")
	WebElement ddlBusinessUnit;

	// Drop down Principle Customer
	@FindBy(css = "#m_strPrincipalCust")
	WebElement ddlPrincipleCustomer;

	public BasicFlowPage() {
		PageFactory.initElements(driver, this);

	}

	// 9.

	/*
	 * (String siteCodetxt, String customerContactNametxt, String
	 * customerContactNotxt, String customerContactEmailIDtxt, String
	 * customerAddressTxt, String regionTxt, String stateTxt, String
	 * popLocationTxt, String cityTxt, String distancetxt, String
	 * averageTravelTimeTxt, String customerSLATxt, String ourSLATxt, String
	 * responseTimeTxt, String productCategoryInProductTxt, String
	 * productSubCategoryInProductTxt, String SerialNoTxt, String assetIdTxt,
	 * String makeInProductTxt, String productModelNoTxt, String
	 * engineerGradeTxt, String engineerTxt, String pmFrequencyTxt, String
	 * contractReferenceAvailableTxt, String contractRefNoTxt, String
	 * ipAddressTxt, String addressCodeTxt, String address1Txt)
	 */
	public void createNewTicketWithAsset(String siteCodetxt,String customerContactNametxt,
			String customerContactNotxt, String customerContactEmailIDtxt,
			String customerAddressTxt, String regionTxt, String stateTxt,
			String popLocationTxt, String cityTxt, String distancetxt,
			String averageTravelTimeTxt, String customerSLATxt,
			String ourSLATxt, String responseTimeTxt,
			String productCategoryInProductTxt,
			String productSubCategoryInProductTxt, 
			String assetIdTxt, String makeInProductTxt,
			String productModelNoTxt, String engineerGradeTxt,
			String engineerTxt, String pmFrequencyTxt,
			String contractReferenceAvailableTxt, String contractRefNoTxt)
			throws Exception {

		String firstWindow1 = driver.getWindowHandle();
		// ddlBusinessUnit.click();
		Select businessUnit = new Select(ddlBusinessUnit);
		businessUnit.selectByValue("Diebold");

		// ddlPrincipleCustomer.click();
		Select principleCustomer = new Select(ddlPrincipleCustomer);
		principleCustomer.selectByValue("Demo_Principle");
		Thread.sleep(1000);

		/*
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.linkText("PrincipleCust1")));
		 * driver.findElement(By.linkText("PrincipleCust1")).click();
		 */

		driver.findElement(By.id("m_strCustomerName")).sendKeys("de");
		Thread.sleep(1000);
		List<WebElement> customerNameList = driver.findElements(By
				.xpath(".//*[@id='as_ul']/li/a/span[3]"));
		System.out.println("custermer list" + customerNameList.size());

		for (int i = 0; i < customerNameList.size(); i++) {

			System.out.println(customerNameList.get(i).getText());

			if (customerNameList.get(i).getText().contains("demo_Customer")) {

				Thread.sleep(1000);
				customerNameList.get(i).click();
				break;
			}

		}

		Thread.sleep(2000);

		btnSearchAssert.click();

		for (String requestTitleWindow : driver.getWindowHandles()) {
			driver.switchTo().window(requestTitleWindow);

		}

		driver.manage().window().maximize();
		Thread.sleep(1000);
		sd_AssetDetailsPage = new SD_AssetDetailsPage();
		sd_AssetDetailsPage.createAssetByExcel(siteCodetxt,customerContactNametxt,
				customerContactNotxt, customerContactEmailIDtxt,
				customerAddressTxt, regionTxt, stateTxt, popLocationTxt,
				cityTxt, distancetxt, averageTravelTimeTxt, customerSLATxt,
				ourSLATxt, responseTimeTxt, productCategoryInProductTxt,
				productSubCategoryInProductTxt, assetIdTxt,
				makeInProductTxt, productModelNoTxt, engineerGradeTxt,
				engineerTxt, pmFrequencyTxt, contractReferenceAvailableTxt,
				contractRefNoTxt);
		/*
		 * sd_AssetDetailsPage.createAssetByExcel(siteCodetxt,
		 * customerContactNametxt, customerContactNotxt,
		 * customerContactEmailIDtxt, customerAddressTxt, regionTxt, stateTxt,
		 * popLocationTxt, cityTxt, distancetxt, averageTravelTimeTxt,
		 * customerSLATxt, ourSLATxt, responseTimeTxt,
		 * productCategoryInProductTxt, productSubCategoryInProductTxt,
		 * SerialNoTxt, assetIdTxt, makeInProductTxt, productModelNoTxt,
		 * engineerGradeTxt, engineerTxt, pmFrequencyTxt,
		 * contractReferenceAvailableTxt, contractRefNoTxt, ipAddressTxt,
		 * addressCodeTxt, address1Txt);
		 */

		
		int size = lstAssetId.size();
		// for (int i = 0; i < size; i++) {
		String assetId = lstAssetId.get(size - 1).getText();
		System.out.println("assetId: " + assetId);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", lstAssetId.get(size - 1));

		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						lstAssetId.get(size - 1));
		Thread.sleep(2000);
		lstAssetId.get(size - 1).click();
		/*
		 * break;
		 * 
		 * }
		 */
		Thread.sleep(1000);
		// Closing Pop Up window
		driver.switchTo().window(firstWindow1);
		// select Trouble category
		Select troubleCategory;

		troubleCategory = new Select(driver.findElement(By
				.name("m_strCategory")));

		troubleCategory.selectByIndex(3);
		Thread.sleep(1000);
		// select Trouble category
		Select troubleSubCategory;
		troubleSubCategory = new Select(driver.findElement(By
				.name("m_strSubCategory")));
		troubleSubCategory.selectByIndex(1);

		Thread.sleep(3000);
		// click on request title
		btnRequestTitle.click();

		String firstWindow = driver.getWindowHandle();
		// for window handler

		for (String requestTitleWindow : driver.getWindowHandles()) {
			driver.switchTo().window(requestTitleWindow);

		}

		// get text from request title
		String requestTitle = driver.findElement(
				By.cssSelector(".rectagleBox>table>tbody>tr:nth-of-type(8)"))
				.getText();
		System.out.println("1st request title: " + requestTitle);

		Thread.sleep(100);
		driver.findElement(By.linkText("ATM - Not coming in service")).click();

		// Closing Pop Up window
		driver.switchTo().window(firstWindow);

		// enter the Request description and check page should be writable
		txtRequestDiscription.sendKeys("ATM - Not coming in service");

		/*
		 * // enter the local contact name txtLocalName.sendKeys("bhagyashree");
		 * 
		 * // enter the local contact number
		 * txtLocalContactNumber.sendKeys("7400438090");
		 * 
		 * // enter the customer emailID
		 * txtCustomerEmailId.sendKeys("bhagyashree@gmail.com");
		 */

		// get the all value from ticket type
		txtTicketType.getText();

		// select ticket type
		Select ticketType;
		ticketType = new Select(
				driver.findElement(By.name("m_strIncidentType")));
		ticketType.selectByIndex(2);
		Thread.sleep(100);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// click on record ticket button
		btnRecordTicket.click();
		Thread.sleep(2000);

		/*
		 * Alert alert = driver.switchTo().alert(); String alertMessage =
		 * alert.getText(); System.out.println(alertMessage); alert.accept();
		 */

		String notification = driver.findElement(By.id("dialogBoxSuccess"))
				.getText();
		System.out.println(notification);

		Assert.assertEquals(notification, "Incident added successfully",
				"Ticket Is Not Created");
		Thread.sleep(1000);
	//	driver.findElement(By.linkText("Edit Incident")).click();

	}

	
	public void createNewTicket( )
			throws Exception {

		// ddlBusinessUnit.click();
		Select businessUnit = new Select(ddlBusinessUnit);
		businessUnit.selectByValue("Diebold");

		// ddlPrincipleCustomer.click();
		Select principleCustomer = new Select(ddlPrincipleCustomer);
		principleCustomer.selectByValue("Demo_Principle");
		Thread.sleep(1000);

		/*
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.linkText("PrincipleCust1")));
		 * driver.findElement(By.linkText("PrincipleCust1")).click();
		 */

		driver.findElement(By.id("m_strCustomerName")).sendKeys("de");
		Thread.sleep(1000);
		List<WebElement> customerNameList = driver.findElements(By
				.xpath(".//*[@id='as_ul']/li/a/span[3]"));
		System.out.println("custermer list" + customerNameList.size());

		for (int i = 0; i < customerNameList.size(); i++) {

			System.out.println(customerNameList.get(i).getText());

			if (customerNameList.get(i).getText().contains("demo_Customer")) {

				Thread.sleep(1000);
				customerNameList.get(i).click();
				break;
			}

		}

		Thread.sleep(2000);

		Select siteCode = new Select(ddlSiteCode);
		siteCode.selectByIndex(1);
		Thread.sleep(1000);
		// ddlPrincipleCustomer.click();
		Select assetID = new Select(ddlAssetID);
		assetID.selectByIndex(1);
		Thread.sleep(2000);

		
		// select Trouble category
		Select troubleCategory;

		troubleCategory = new Select(driver.findElement(By
				.name("m_strCategory")));

		troubleCategory.selectByIndex(3);
		Thread.sleep(1000);
		// select Trouble category
		Select troubleSubCategory;
		troubleSubCategory = new Select(driver.findElement(By
				.name("m_strSubCategory")));
		troubleSubCategory.selectByIndex(1);

		Thread.sleep(3000);
		// click on request title
		btnRequestTitle.click();

		String firstWindow = driver.getWindowHandle();
		// for window handler

		for (String requestTitleWindow : driver.getWindowHandles()) {
			driver.switchTo().window(requestTitleWindow);

		}

		// get text from request title
		String requestTitle = driver.findElement(
				By.cssSelector(".rectagleBox>table>tbody>tr:nth-of-type(8)"))
				.getText();
		System.out.println("1st request title: " + requestTitle);

		Thread.sleep(100);
		driver.findElement(By.linkText("ATM - Not coming in service")).click();

		// Closing Pop Up window
		driver.switchTo().window(firstWindow);

		// enter the Request description and check page should be writable
		txtRequestDiscription.sendKeys("ATM - Not coming in service");


		  // enter the local contact name 
		txtLocalName.sendKeys("bhagyashree");
		  
		  // enter the local contact number
		  txtLocalContactNumber.sendKeys("7400438090");
		  
		  // enter the customer emailID
		  txtCustomerEmailId.sendKeys("bhagyashree@gmail.com");
		 

		// get the all value from ticket type
		txtTicketType.getText();

		// select ticket type
		Select ticketType;
		ticketType = new Select(
				driver.findElement(By.name("m_strIncidentType")));
		ticketType.selectByIndex(2);
		Thread.sleep(100);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// click on record ticket button
		btnRecordTicket.click();
		Thread.sleep(2000);

		/*
		 * Alert alert = driver.switchTo().alert(); String alertMessage =
		 * alert.getText(); System.out.println(alertMessage); alert.accept();
		 */

		String notification = driver.findElement(By.id("dialogBoxSuccess"))
				.getText();
		System.out.println(notification);

		Assert.assertEquals(notification, "Incident added successfully",
				"Ticket Is Not Created");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Edit Incident")).click();

	}
	public void assignTSD() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		/*
		 * createNewPageOfSdRole = new SD_CreateNewPage(); WebElement
		 * fromCreateTicketPage = createNewPageOfSdRole.textbox_IncidenID;
		 * String getIncidentIdValue = fromCreateTicketPage.getText();
		 * System.out.println(getIncidentIdValue); String split =
		 * getIncidentIdValue.split(" ")[2]; System.out.println(split);
		 * incidentID = split.split("Status")[0];
		 * System.out.println("=====================");
		 * System.out.println(incidentID);
		 */

		Thread.sleep(2000); // click on Preliminary Analysis Tab
		tab_PreliminaryAnalysis.click();

		// click on Edit button
		button_EditOfPreliminaryAnalysis.click();

		for (String tsdAssignDetailsWindow : driver.getWindowHandles()) {

			System.out.println(tsdAssignDetailsWindow);
			driver.switchTo().window(tsdAssignDetailsWindow);

		}

		// click on TSD button
		driver.findElement(
				By.cssSelector("div[id='incidentTypeDetails']>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td>img"))
				.click();

		for (String technicianWindow : driver.getWindowHandles()) {
			driver.switchTo().window(technicianWindow);

		}

		System.out.println(driver.getTitle());
		Thread.sleep(1000);

		// select the particular technician, here used the first name.
		WebElement technicalName = driver.findElement(By
				.cssSelector("td[class='pad5']>a"));
		String technicalNameValue = technicalName.getText();
		String technicalNameNewValue = technicalNameValue.split(" ")[0];
		System.out.println("Technician Name:-" + technicalNameNewValue);

		// click on the first name
		driver.findElement(By.cssSelector("td[class='pad5']>a")).click();
		Thread.sleep(1000);

		for (String basicWindow : driver.getWindowHandles()) {
			driver.switchTo().window(basicWindow);

		}

		// Select Technical Status as Unresolved
		Select selectTechnicalStatus;
		selectTechnicalStatus = new Select(textbox_TechnicalStatus);
		selectTechnicalStatus.selectByVisibleText("Unresolved");

		// click on Observations Text Box With any characters
		textbox_Observation.clear();
		textbox_Observation.sendKeys("abc");

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

		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Incident Updated SuccessFully", "Notification is not Match");

		Thread.sleep(5000);
		String etaDateBeforeDataEnter = label_ETADate.getText();
		System.out.println("ETA date:-" + etaDateBeforeDataEnter);

		softAssert.assertNotNull(etaDateBeforeDataEnter);

		softAssert.assertAll();

	}

	public void assignTechnicianAndPunchETA() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on ETA and Technician tab
		tab_ETATechnician.click();

		// click on Call Assign To Technician Button.
		button_CallAssignToTechnician.click();

		// get the message from Technician Assign And ETA Details window handler

		for (String TechnicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(TechnicianAssignAndETADetailsWindow);
			driver.switchTo().window(TechnicianAssignAndETADetailsWindow);

		}

		if (textbox_Technician.getText().contains("")) {

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
			technicianBusinessUnit.selectByVisibleText("test");

			Select city;
			city = new Select(driver.findElement(By.name("m_strCity")));
			city.selectByVisibleText("Mumbai");

			driver.findElement(
					By.xpath(".//*[@id='right']/table/tbody/tr[3]/td[3]/input"))
					.click();

			// Thread.sleep(3000);

			int size = list_TechnicianName.size();

			for (int j = 0; j < size; j++) {

				// Thread.sleep(2000);
				scrollDown(list_TechnicianName.get(j));
				String technicianVlaue = list_TechnicianName.get(j).getText();
				System.out.println(technicianVlaue);

				if (technicianVlaue.contains("pranjali12 deshpande"))

				{
					// Thread.sleep(2000);
					scrollDown(list_TechnicianName.get(j));
					highLight(list_TechnicianName.get(j));
					list_TechnicianName.get(j).click();
					break;

				}

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
		 * int nextDay = Integer.parseInt(currentDay); String nxtDay =
		 * Integer.toString(nextDay);
		 */

		symbol_ETACalender.click();

		// select Date in Calendar

		for (WebElement day : dates_InETACalender) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {

				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE) + 1;
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		if (min3.length() == 1) {
			min3 = "0" + min3;
			System.out.println("min3: " + min3);
		}

		// String min4 = String.format("%02d", min3);

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String currentHrs = new SimpleDateFormat("HH").format(calendar
				.getTime());
		System.out.println(currentHrs);

		String currentMin = new SimpleDateFormat("mm").format(calendar
				.getTime());
		System.out.println(currentMin);

		int nextMin = Integer.parseInt(currentMin) + 2;
		String min = Integer.toString(nextMin);
		System.out.println(min);
		// select Hrs in Drop down

		for (WebElement hrsofSystem : dropdown_ETATimeHour) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(currentHrs)) {

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

			if (minInDropdown.equalsIgnoreCase(min3)) {

				Thread.sleep(1000);
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);
				break;
			}

		}

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		button_UpdateDetail.click();
		// Thread.sleep(3000);

		try {
			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			Thread.sleep(2000);
			technicianAlert.dismiss();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}

		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Incident Updated SuccessFully", "Notification is not Match");

		softAssert.assertAll();
	}

	public void punchATA() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Click on ATA Tab
		tab_ATA.click();

		// Click on Edit Button In ATA Tab
		button_EditInATATab.click();

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		String currentDay = Integer.toString(dayOfMonth);
		System.out.println(currentDay);

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
		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
		System.out.println(hrs);
		String min = new SimpleDateFormat("mm").format(calendar.getTime());
		System.out.println(min);

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE);
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		if (min3.length() == 1) {
			min3 = "0" + min3;
			System.out.println("min3: " + min3);
		}

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

			if (minInDropdown.equalsIgnoreCase(min3)) {
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

		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Incident Updated Successfully", "Notification is not Match");

		softAssert.assertAll();

	}

	public void addSpare() throws Exception {

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

			for (String listOfAvailableSparesWindow : driver.getWindowHandles()) {

				System.out.println(listOfAvailableSparesWindow);
				driver.switchTo().window(listOfAvailableSparesWindow);

			}
			List<WebElement> productClassification = list_ProductClassificationInSpareDetail;
			int size1 = productClassification.size();
			System.out.println(size1);

			for (int j = 0; j < size1; j++) {
				String productClassificationValue = productClassification
						.get(j).getText();
				System.out.println(productClassificationValue);

				String transactionTypeValue = list_TransactionTypeInSpareDetail
						.get(j).getText();
				System.out.println(transactionTypeValue);

				String partTypeValue = list_PartTypeInSpareDetail.get(j)
						.getText();
				System.out.println(partTypeValue);
				// Component
				if (productClassificationValue.equalsIgnoreCase("Device")
						&& transactionTypeValue.equalsIgnoreCase("Stock")
						&& partTypeValue.equalsIgnoreCase("Non-Consumable"))

				{

					String partName = list_PartNameInSpareDetail.get(j)
							.getText();
					System.out.println(partName);

					// select part name from list of Available
					// Spares Window
					driver.findElement(By.linkText(partName)).click();

					for (String spareDetailsWindow1 : driver.getWindowHandles()) {

						System.out.println(spareDetailsWindow1);
						driver.switchTo().window(spareDetailsWindow1);
					}

					Select anotherPartCodeInRepaceTab;
					anotherPartCodeInRepaceTab = new Select(
							dropdown_PartCodeInReplaceSpare);
					anotherPartCodeInRepaceTab
							.selectByVisibleText("Replace With Another PartCode");
					Thread.sleep(500);

					Select anotherPartCode;
					anotherPartCode = new Select(
							dropdown_ListOfAnotherPartCodeInReplaceSpare);
					anotherPartCode.selectByIndex(1);
					Thread.sleep(500);

					txtSerialNumberInSpare
							.sendKeys(SD_AssetDetailsPage.serialNumber);
					// select the status
					Select statusDropdown;
					statusDropdown = new Select(dropdown_Status);
					statusDropdown.selectByVisibleText("Faulty");

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							button_UpdateDetail);
					driver.manage().timeouts()
							.pageLoadTimeout(100, TimeUnit.SECONDS);
					// Click on update button
					button_UpdateDetail.click();

					Thread.sleep(3000);

					break;
				}

				if (size1 - 1 == j) {
					System.out
							.println("Spare is not Available in Pranjali's Technician Stock");
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "w");
					Thread.sleep(1000);
					driver.switchTo().window(spareDetailsWindow);
					Select sparesConsumed1;
					sparesConsumed1 = new Select(dropdown_SparesConsumed);
					sparesConsumed1.selectByVisibleText("No");
					driver.manage().timeouts()
							.pageLoadTimeout(10, TimeUnit.SECONDS);
					// Click on update button
					button_UpdateDetail.click();

					// Thread.sleep(3000);

					// click on spare tab
					tab_Spare.click();

				}
			}
		}

	}
	
	public void addSpareTab() throws Exception {

		tab_SpareInTicketForm.click();

		// click on Edit button
		button_EditInSpareTab.click();

		for (String spareDetailsWindow : driver.getWindowHandles()) {

			System.out.println(spareDetailsWindow);
			driver.switchTo().window(spareDetailsWindow);

			// select the Spares Consumed By Inventory logistic
			Select sparesConsumed;
			sparesConsumed = new Select(dropdown_SparesConsumed);
			sparesConsumed.selectByVisibleText("No");

			
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							button_UpdateDetail);
					driver.manage().timeouts()
							.pageLoadTimeout(100, TimeUnit.SECONDS);
					// Click on update button
					button_UpdateDetail.click();

					Thread.sleep(3000);

				}

				
		}

	

	public void technicianClose() throws Exception {

		tab_TechnicianClose.click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		button_EditOfTechncianClose.click();

		// To Handle window based pop-up
		/*
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
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
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
		System.out.println(hrs);

		String min = new SimpleDateFormat("mm").format(calendar.getTime());
		System.out.println(min);
		
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE) - 1;
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		if (min3.length() == 1) {
			min3 = "0" + min3;
			System.out.println("min3: " + min3);
		}

		// String min4 = String.format("%02d", min3);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : dropdown_HrsOfTechnicianCloseTime) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				Thread.sleep(2000);
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		Thread.sleep(1000);
		// select Min in Drop down

		for (WebElement minOfSystem : dropdown_MinOfTechnicianCloseTime) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min3)) {
				Thread.sleep(2000);
				minOfSystem.click();
				Thread.sleep(2000);
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		Thread.sleep(2000);
		String resolution = "abc";
		textbox_ResolutionInTechnicianClose.sendKeys(resolution);

		String resolutionDescription = "xyz";
		textbox_ResolutionDescriptionInTechnicianClose
				.sendKeys(resolutionDescription);

		String FSRNo = "123";
		textbox_FSRNoInTechnicianClose.sendKeys(FSRNo);
		// Thread.sleep(500);

		textbox_SerialNumberInTechClose
				.sendKeys(SD_AssetDetailsPage.serialNumber);

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		button_submitTechCloseDetails.click();

		// Get Notification
		// Thread.sleep(1000);
		String notificationText1 = notification.getText();
		System.out.println(notificationText1);

		Assert.assertEquals(notificationText1, "Incident Updated SuccessFully",
				"Notification is not Match");

	}

	// close any ticket
	public void closeTicket() throws InterruptedException {

		// click on Technician close tab
		tab_TechnicianClose.click();

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

		List<WebElement> allDates = driver.findElements(By
				.xpath(".//*[@id='fd-dp-4']/table/tbody/tr/td"));

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				ele.click();
				getDateValue = ele.getText();
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
		// int preHour = Integer.parseInt(hrs);
		// String previousHour = Integer.toString(preHour);

		System.out.println(hrs);
		String min = new SimpleDateFormat("mm").format(calendar.getTime());
		int preMinute = Integer.parseInt(min);
		String previousMinute = Integer.toString(preMinute);

		System.out.println(previousMinute);

		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE) - 1;
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		if (min3.length() == 1) {
			min3 = "0" + min3;
			System.out.println("min3: " + min3);
		}

		// select Hrs in Drop down

		for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				Thread.sleep(2000);
				hrsofSystem.click();
				String getTimeHour = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getTimeHour);

				break;
			}

		}

		// select Minute in Drop down

		/*
		 * for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {
		 * 
		 * String minInDropdown = minOfSystem.getText();
		 * 
		 * if (minInDropdown.equalsIgnoreCase(previousMinute)) {
		 * 
		 * Thread.sleep(1000); minOfSystem.click(); String getTimeMinute =
		 * minOfSystem.getText(); System.out.println("Select the min:-" +
		 * getTimeMinute);
		 * 
		 * break; }
		 * 
		 * }
		 */

		// select Min in Drop down

		for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min3)) {
				Thread.sleep(1000);
				minOfSystem.click();
				String getDateValue1 = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue1);

				break;
			}

		}
		String getCloseTimeHourValue = dropdown_CloseTimeHour
				.getAttribute("value");
		System.out.println(getCloseTimeHourValue);

		String getCloseTimeMinuteValue = dropdown_CloseTimeMinute
				.getAttribute("value");
		System.out.println(getCloseTimeMinuteValue);
		textbox_UpdateSerialNo.sendKeys(SD_AssetDetailsPage.serialNumber);

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);

		button_UpdateDetail.click();
		String notificationText = notification.getText();
		System.out.println(notificationText);

		/*
		 * Assert.assertEquals(notificationText,
		 * "Incident updated successfully.", "Notification is not Match");
		 */
		Thread.sleep(5000);

	}

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

			int size = lstStatusInTable.size();
			System.out.println(size);

			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (status.equalsIgnoreCase("Open") && !ETA.equals("")
						&& !ATA.equals(""))

				{
					// get ID from list of Available Spares Window
					String idValue = lstIDInTable.get(i).getText();
					System.out.println(idValue);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					// Thread.sleep(2000);

					break loop;

				}
			}

			if (sizePagination - 1 == p)
				softAssert.assertTrue(false,
						" Ticket is not Available for Punching ATA");
		}
		softAssert.assertAll();
	}

	public void CheckStatusAfterFinalClose() {

		String getStatusValue = textbox_IncidenID.getText();
		System.out.println(getStatusValue);
		String splitStatus = getStatusValue.split("\n")[1];
		System.out.println(splitStatus);

		Assert.assertEquals(splitStatus, "Status : Closed",
				"Status is not Same");
		System.out.println("Status is Same");
	}

	public void selectIncidentIDInSD() throws Exception {

		Thread.sleep(1000);
		// Click on search ticket tab
		tab_SearchTicketOpen.click();

		// Enter Id in Search Id Tab
		tab_SearchId.sendKeys(incidentID);

		// Click on Go button
		button_GoOfId.click();

		Thread.sleep(1000);
		// Click on Id in Table
		driver.findElement(
				By.cssSelector("div[class='fht-tbody']>table[class='fht-table']>tbody>tr>td:nth-of-type(1)>span>a"))
				.click();

		Thread.sleep(1000);
	}

	public void checkCustomerAddress() throws Exception {

		
		// ddlBusinessUnit.click();
		Select businessUnit = new Select(ddlBusinessUnit);
		businessUnit.selectByValue("Diebold");

		// ddlPrincipleCustomer.click();
		Select principleCustomer = new Select(ddlPrincipleCustomer);
		principleCustomer.selectByValue("Demo_Principle");
		Thread.sleep(1000);

		/*
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.linkText("PrincipleCust1")));
		 * driver.findElement(By.linkText("PrincipleCust1")).click();
		 */

		driver.findElement(By.id("m_strCustomerName")).sendKeys("de");
		Thread.sleep(1000);
		List<WebElement> customerNameList = driver.findElements(By
				.xpath(".//*[@id='as_ul']/li/a/span[3]"));
		System.out.println("custermer list" + customerNameList.size());

		for (int i = 0; i < customerNameList.size(); i++) {

			System.out.println(customerNameList.get(i).getText());

			if (customerNameList.get(i).getText().contains("demo_Customer")) {

				Thread.sleep(1000);
				customerNameList.get(i).click();
				break;
			}

		}

		Thread.sleep(1000);
		Select sitecode;
		sitecode = new Select(driver.findElement(By.name("m_strSiteCode")));

		sitecode.selectByValue("dem-Mum-0023");

		Thread.sleep(1000);

		btnSearchAssert.click();

		for (String requestTitleWindow : driver.getWindowHandles()) {
			driver.switchTo().window(requestTitleWindow);

		}

		driver.manage().window().maximize();
		Thread.sleep(1000);
		sd_AssetDetailsPage = new SD_AssetDetailsPage();
		sd_AssetDetailsPage.checkCustomerAddress();

	}

	public void loginIntoSD() throws Exception {

		Thread.sleep(1000);
		// maximize the window to 100%
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		loginPageOfSdRole = new SD_LoginPage();
		homePageOfSdRole = loginPageOfSdRole.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		homePageOfSdRole = new SD_HomePage();
		Thread.sleep(1000);
		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000);
		viewTicketPageOfSdRole = ticketPageOfSdRole.viewTicketTab();
		Thread.sleep(1000);
	}

	public void logoutFromSD() throws Exception {

		Thread.sleep(1000);
		link_sd.click();
		Thread.sleep(1000);
		link_LogOut.click();
		Thread.sleep(1000);

	}

	public void loginIntoRM() throws Exception {

		// maximize the window to 100%
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		loginPageOfReportingManagerRole = new RM_LoginPage();
		homePageOfReportingManagerRole = loginPageOfReportingManagerRole.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));

		inventoryPageOfReportingManagerRole = homePageOfReportingManagerRole
				.InventoryTab();
		Thread.sleep(1000);
		spareApprovalPageInReportingManagerRole = inventoryPageOfReportingManagerRole
				.SpareApprovalTab();
		Thread.sleep(1000);
	}

	public void logoutFromRM() throws Exception {
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
		Thread.sleep(1000);

		link_RM.click();
		Thread.sleep(1000);
		link_LogOut.click();
		Thread.sleep(1000);
	}

	public void loginIntoSCM() throws Exception {

		Thread.sleep(1000);
		// maximize the window to 100%
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		loginPageOfSCMRole = new SCM_LoginPage();
		homePageOfSCMRole = loginPageOfSCMRole.Login(
				properties.getProperty("loginIdForSCM"),
				properties.getProperty("password"));

		inventoryPageOfSCMRole = homePageOfSCMRole.InventoryTab();
		Thread.sleep(1000);
		validationSpareRequestOfSCMRole = inventoryPageOfSCMRole
				.ValidationSpareRequestTab();
		Thread.sleep(1000);

	}

	public void logoutFromSCM() throws Exception {

		Thread.sleep(1000);
		link_scm.click();
		Thread.sleep(1000);
		link_LogOut.click();
		Thread.sleep(1000);
	}

	public void loginIntoLogistic() throws Exception {

		Thread.sleep(1000);
		// maximize the window to 100%
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		loginPageOfLogisticRole = new Logistic_LoginPage();
		homePageOfLogisticRole = loginPageOfLogisticRole.Login(
				properties.getProperty("loginIdForLogistic"),
				properties.getProperty("password"));

		spareDetailsReportPageOfLogisticRole = homePageOfLogisticRole
				.SpareDetailsReportTab();

		Thread.sleep(1000);
		inventoryRequiredPageOfLogisticRole = spareDetailsReportPageOfLogisticRole
				.InventoryRequiredTab();
		Thread.sleep(1000);

	}

	public void logoutFromLogistic() throws Exception {

		Thread.sleep(1000);
		link_Logistic.click();
		Thread.sleep(1000);
		link_LogOut.click();
		Thread.sleep(1000);
	}
}
