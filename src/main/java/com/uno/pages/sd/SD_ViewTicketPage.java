package com.uno.pages.sd;

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
import com.uno.excelUtility.WebEventListener;
import com.uno.pages.rm.RM_SpareApprovalPage;
import com.uno.pages.superrole.Super_AdminPage;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_FileCategoryPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_ItemMasterPage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ManageStaffPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;
import com.uno.pages.superrole.Super_SpareInventoryLocationPage;
import com.uno.pages.superrole.Super_TeamMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketTypePage;
import com.uno.test.sd.SD_ViewTicketTest;
import com.uno.test.superrole.Super_AdminTest;
import com.uno.test.superrole.Super_InventoryMastersTest;
import com.uno.test.superrole.Super_ServiceDeskSettingsTest;


public class SD_ViewTicketPage extends BaseCode {

	// call the method from SD role
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_ViewTicketPage viewTicketPageOfSdRole;
	WebEventListener webEventListener;

	// call the method from super role
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDmasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_TicketTypePage ticketTypePageOfSuperRole;
	Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
	Super_EmployeeDetailPage employeeDetailPageOfSuperRole;
	Super_ManageStaffPage manageStaffPageOfSuperRole;
	Super_TeamMasterPage teamMasterPageOfSuperRole;
	Super_FileCategoryPage fileCategoryPageOfSuperRole;
	Super_AdminPage adminPageOfSuperRole;
	Super_AdminTest adminPageTestCaseOfSuperRole;
	Super_ServiceDeskSettingsPage serviceDeskSettingsPageOfSuperRole;
	Super_ServiceDeskSettingsTest serviceDeskSettingsPageTestCaseOfSuperRole;
	Super_InventoryMastersTest inventoryMastersPageTestCaseOfSuperRole;
	Super_ItemMasterPage itemMasterPageOfSuperRole;
	Super_SpareInventoryLocationPage spareInventoryLocationPageOfSuperRole;
	SD_ViewTicketTest viewTicketPageTestCaseOfSdRole;
	SD_CreateNewPage createNewPageOfSdRole;
	RM_SpareApprovalPage rm_SpareApprovalPage;

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
	@FindBy(linkText = "Search Ticket")
	WebElement tab_SearchTicketOpen;

	// select Search Ticket
	@FindBy(css = "#close")
	WebElement tab_SearchTicketClose;

	// Select Account link
	@FindBy(linkText = "Account")
	WebElement link_Account;

	// Select SD tab for logout tab
	@FindBy(linkText = "SD")
	WebElement link_sd;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement link_Test;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
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

	// get the serial number from final close detail
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[6]/td")
	WebElement textbox_SerialNumber;

	// select Update Serial No For this Asset: field
	@FindBy(name = "m_strCloseSerialNo")
	WebElement textbox_UpdateSerialNo;

	// KEDB Tab
	// Select KEDB Tabion
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

	 // select Search Ticket
	@FindBy(css = "#open")
	WebElement tabSearchTicketOpen;

	// select Search Ticket
	@FindBy(css = "#close")
	WebElement tabSearchTicketClose;  
	
	// select Search Ticket ID
	@FindBy(name = "m_strSearchTicketId")
	WebElement txtTicketId;

	// select GO button of ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
	WebElement btnGoOfTicketId;

	// Label in Incident Number
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/span/a")
	WebElement lnkFirstId;
	
	// select spare tab
	@FindBy(css = "li[class='tab9']>a>span")
	WebElement tabSpare;

	// spare Request ID
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[1]")
	List<WebElement> lstSpareRequestID;
	
	// status
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[9]")
	List<WebElement> lstStatus;
 
	
	// status
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[12]")
	List<WebElement> lstRemark;
	// Initializing Page Object
	public SD_ViewTicketPage() {
		PageFactory.initElements(driver, this);
	}

	// Display Title Of View Ticket Page
	public void displayTitleOfViewTicketPage() {
		SoftAssert softAssert = new SoftAssert();
		
		String viewTicketPageTitle = driver.getTitle();
		System.out.println(viewTicketPageTitle);
		softAssert.assertEquals(viewTicketPageTitle, "Welcome To Uno Point");

	}

	// Descending order of Incident ID's
	public void displayDescendingOrderOfIncidentID() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Get the list Of Row
		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		// Get the size of Row
		Integer countOfRow = listOfRow.size();

		for (int i = 0; i < countOfRow - 1; i++) {
			// Get the list Of ID
			List<WebElement> listOfID = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>a"));
			/*
			 * // Get the Id String id = listOfID.get(i).getText(); // Print the
			 * ID System.out.println("Incident ID: " + id);
			 */
			scrollDown(list_IDInTable.get(i));
			highLight(list_IDInTable.get(i));
			
			
			/*((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_IDInTable.get(i));*/
			// Get the First ID
			String textOfFirstID = listOfID.get(i).getText();
			// Convert into integer
			int firstID = Integer.parseInt(textOfFirstID);
			// Get the Second ID
			String textOfSecondID = listOfID.get(i + 1).getText();
			// Convert into integer
			int secondID = Integer.parseInt(textOfSecondID);

			boolean idIsPresent = true;
			try {
				// Compare firstID and secondID
				if (firstID > secondID) {
					// Print the Result
					System.out.println("Pass");
					idIsPresent = true;
				}

			}

			catch (Exception e) {
				// Print the Result
				System.out.println("Fail");
				idIsPresent = false;
			}
			softAssert.assertTrue(idIsPresent, "ID is not Descending Order");
		}
		softAssert.assertAll();

	}

	// column headers should display as per selected in My View pop-up of View
	// ticket
	public void displayColumnHeader() throws Exception 
	{
		tab_Ticket.click();
		Thread.sleep(1000);
		tab_ViewTicket.click();
		Thread.sleep(1000);
		
		SoftAssert softAssert = new SoftAssert();
		// Click on My View Tab
		driver.findElement(
				By.cssSelector("a[class='topLnk'][onclick='fireMyPopup()']"))
				.click();
		// Get list Of Pop up Column
		List<WebElement> listOfPopupColumn = driver.findElements(By
				.cssSelector("#view_property>ul>li"));
		// Get size of Pop up Column
		int sizeOfPopupColumn = listOfPopupColumn.size();
		// Print size of Pop up Column
		System.out.println("Size Of Popup Column: " + sizeOfPopupColumn);
		// Click on Save Button
		driver.findElement(By.cssSelector("input[onclick='Save()']")).click();
		
		// Get list Of Table Column
		List<WebElement> listOfTableColumn = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>thead>tr>th"));
		// Get size Of Table Column
		int sizeOfTableColumn = listOfTableColumn.size();
		// Print size Of Table Column
		System.out.println("Total Table Column: " + sizeOfTableColumn);

		for (int i = 1; i < sizeOfPopupColumn; i++) {
			// Click on My View Tab
			driver.findElement(
					By.cssSelector("a[class='topLnk'][onclick='fireMyPopup()']"))
					.click();
			// Get list Of Pop up Column Check box
			List<WebElement> listOfPopupColumnCheckbox = driver.findElements(By
					.cssSelector("#view_property>ul>li>input"));
			// Check Pop up Column Check box is selected or not
			if (!listOfPopupColumnCheckbox.get(0).isSelected()) {
				// Click Pop up Column Check box
				listOfPopupColumnCheckbox.get(0).click();
				Thread.sleep(500);
				// Click Pop up Column Check box
				listOfPopupColumnCheckbox.get(0).click();
			} else {
				// Click Pop up Column Check box
				listOfPopupColumnCheckbox.get(0).click();
			}
			
			
			// Get list Of Pop up Column Check box Name
			List<WebElement> listOfPopupColumnCheckboxName = driver
					.findElements(By.cssSelector("#view_property>ul>li"));
			// Get check box Name
			String checkboxName = listOfPopupColumnCheckboxName.get(i)
					.getText();
			// Print check box Name
			System.out.println("Selected Checkbox:" + checkboxName);

			// Cursor transfer to Check box
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					listOfPopupColumnCheckbox.get(i));
			// Click on Check box
			listOfPopupColumnCheckbox.get(i).click();
			// Clickc on Save Button
			driver.findElement(By.cssSelector("input[onclick='Save()']"))
					.click();
			Thread.sleep(2000);
			// Get list Of Table Column Name
			List<WebElement> listOfTableColumnName = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>thead>tr>th"));
			// Get Table Column Name
			String tableColumnName = listOfTableColumnName.get(1).getText();
			// Print Table Column Name
			System.out.println("Display Table Column Name: " + tableColumnName);
			// Check check box Name
			if (checkboxName.equalsIgnoreCase(tableColumnName)) {
				// Print Message
				System.out.println("Column is Match\n");
				// Verify check box Name
				softAssert.assertTrue(
						checkboxName.equalsIgnoreCase(tableColumnName),
						"Column is not Match");
			} else {
				// Print Message
				System.out.println("Column is not Match\n");
				// Verify check box Name
				softAssert.assertEquals(checkboxName, tableColumnName,
						"Column is not Match");

			}

			Thread.sleep(2000);
		}
		
		softAssert.assertAll();

	}
	
	
	// Hyper link of ID should have present
	public void checkHyperlinkOfID() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		
		// Get list Of Row
		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		// Get the size of Row
		Integer countOfRow = listOfRow.size();
		for (int i = 0; i < countOfRow; i++) {
			// Get list Of ID
			List<WebElement> listOfID = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>a"));
			/*((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_IDInTable.get(i));*/
			scrollDown(list_IDInTable.get(i));
			highLight(list_IDInTable.get(i));
			// Get ID
			String ID = listOfID.get(i).getText();
			// print ID
			System.out.println("ID: " + ID);
			// Check id is Present or not
			boolean idIsPresent = driver.findElement(By.linkText(ID))
					.isDisplayed();
			// Print Result
			System.out.println("Hyperlink of ID	present: " + idIsPresent);
			// Verify ID is Present or not
			softAssert.assertTrue(idIsPresent, "Hyperlink of ID is not present");

		}
		softAssert.assertAll();
	}

	// Hyper link of Customer should have present
	public void checkHyperlinkOfCustomer() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Get list Of Row
		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		// Get Size of Row
		Integer countOfRow = listOfRow.size();
		for (int i = 0; i < countOfRow; i++) {
			// Get list Of Customer
			List<WebElement> listOfCustomer = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)>a"));
		/*	((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					listOfCustomer.get(i));*/
			scrollDown(listOfCustomer.get(i));
			highLight(listOfCustomer.get(i));
			// Get Customer
			String customer = listOfCustomer.get(i).getText();
			// Print Customer
			System.out.println("Customer: " + customer);
			// Check customer is Present or not
			boolean customerIsPresent = driver.findElement(
					By.linkText(customer)).isDisplayed();
			// Print result
			System.out.println("Hyperlink of Customer present: "
					+ customerIsPresent);
			// Verify customer is Present or not
			softAssert.assertTrue(customerIsPresent,
					"Hyperlink of Customer is not present");

		}
		softAssert.assertAll();
	}

	// Hyper link of Asset Id should have present
	public void checkHyperlinkOfAssetId() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Get list Of Row
		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		// Get list of
		Integer countOfRow = listOfRow.size();
		for (int i = 0; i < countOfRow; i++) {
			// Get list Of Asset Id
			List<WebElement> listOfAssetId = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(7)>a"));
			
		/*	((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					listOfAssetId.get(i));*/
			
			scrollDown(listOfAssetId.get(i));
			highLight(listOfAssetId.get(i));
			
			// Get Assert Id
			String assertId = listOfAssetId.get(i).getText();
			// Print Assert Id
			System.out.println("Assert Id: " + assertId);
			// Check Assert Id is Present or not
			boolean assetIdIsPresent = driver
					.findElement(By.linkText(assertId)).isDisplayed();
			// Print result
			System.out.println("Hyperlink of Asset Id present: "
					+ assetIdIsPresent);
			// Verify Assert Id is Present or not
			softAssert.assertTrue(assetIdIsPresent,
					"Hyperlink of Asset Id is not present");

		}
		softAssert.assertAll();
	}

	// Blinking Notification
	public void checkBlinkingNotification() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRow = listOfRow.size();

		int j = 0;
		for (int i = 0; i < countOfRow; i++) {
			List<WebElement> listOfID = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span"));
			String id = listOfID.get(i).getText();
			System.out.println(id);
			Integer count = id.length();
			if (count != 5) {
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
					scrollDown(listOfEngineer.get(i));
					highLight(listOfEngineer.get(i));
					softAssert.assertNotNull(engineer, "Technicion not Assign");
					System.out.println("Engineer Assign\n");

					break;

				case "ATA":
					List<WebElement> listOfETA = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
					String eta = listOfETA.get(i).getText();
					System.out.println("ETA: " + eta);
					scrollDown(listOfETA.get(i));
					highLight(listOfETA.get(i));
					softAssert.assertNotNull(eta, "ETA is not Present");
					System.out.println("Punch the ETA\n");

					break;

				case "Feedback":
					List<WebElement> listOfATA = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
					String ata = listOfATA.get(i).getText();
					scrollDown(listOfATA.get(i));
					highLight(listOfATA.get(i));
					System.out.println("ATA: " + ata);
					softAssert.assertNotNull(ata, "ATA is not Present");
					System.out.println("Punch the ATA\n");

					break;

				case "Spare Requested":

					System.out.println("Spare Requested\n");

					break;

				default:
					System.out.println("wrong");
					break;
				}
				break;
			}

			else {
				System.out.println("There is not Blinking Notification\n");
			}
		}
	}

	// Match Customer in Incident History Page
	public void checkCustomer() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		boolean customerIsMatch = true;
		List<WebElement> listOfRowInParentWindow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRowInParentWindow = listOfRowInParentWindow.size();

		for (int i = 0; i < countOfRowInParentWindow; i++) {
			List<WebElement> listOfCustomerInParentWindow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)>a"));
			String customerInParentWindow = listOfCustomerInParentWindow.get(i)
					.getText();
			System.out.println("customerInParentWindow: "
					+ customerInParentWindow);
			WebElement element = driver.findElement(By
					.linkText(customerInParentWindow));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", element);
			// Thread.sleep(1000);
			driver.findElement(By.linkText(customerInParentWindow)).click();
			String parentWindow = driver.getWindowHandle();

			for (String childWindow : driver.getWindowHandles()) {
				driver.switchTo().window(childWindow);
			}

			String customer = driver
					.findElement(
							By.cssSelector("div[id='headingText']>table>tbody>tr>td>span>b"))
					.getText();
			String customerInChildWindow = customer.split(":-  ")[1];
			System.out.println("customerInChildWindow: "
					+ customerInChildWindow);

			if (customerInParentWindow.equalsIgnoreCase(customerInChildWindow)) {
				System.out.println("Customer name are same.\n");
				customerIsMatch = true;

			} else {
				System.out.println("Customer name are not same.\n");
				customerIsMatch = false;
			}

			softAssert.assertTrue(customerIsMatch, "Customer name are not same.");

			List<WebElement> listOfRowInChildWindow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRowInChildWindow = listOfRowInChildWindow.size();

			for (int j = 0; j < countOfRowInChildWindow; j++) {
				List<WebElement> listOfCustomerInChildWindowTable = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>a"));
				String customerInChildWindowTable = listOfCustomerInChildWindowTable
						.get(j).getText();
				System.out.println("Customer: " + customerInChildWindowTable);

				if (customerInParentWindow
						.equalsIgnoreCase(customerInChildWindowTable)) {
					System.out.println("Customer name are same.\n");
					customerIsMatch = true;
					break;

				} else {
					System.out.println("Customer name are not same.\n");
					customerIsMatch = false;

				}

				softAssert.assertTrue(customerIsMatch,
						"Customer name are not same.");

			}

			// Closing Pop Up window
			driver.close();
			driver.switchTo().window(parentWindow);
			break;
		}
		softAssert.assertAll();
	}

	// Match Asset ID in Incident History
	public void checkAssetID() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		boolean assetIdIsMatch = true;
		List<WebElement> listOfRowInParentWindow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRowInParentWindow = listOfRowInParentWindow.size();

		for (int i = 0; i < countOfRowInParentWindow; i++) {
			List<WebElement> listOfAssetIdInParentWindow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(7)>a"));
			String assetIdInParentWindow = listOfAssetIdInParentWindow.get(i)
					.getText();
			System.out.println("Asset ID: " + assetIdInParentWindow);

			WebElement element = driver.findElement(By
					.linkText(assetIdInParentWindow));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", element);
			// Thread.sleep(1000);
			driver.findElement(By.linkText(assetIdInParentWindow)).click();

			String parentWindow = driver.getWindowHandle();

			for (String childWindow : driver.getWindowHandles()) {
				driver.switchTo().window(childWindow);
			}

			String assetId = driver
					.findElement(
							By.cssSelector("div[id='headingText']>table>tbody>tr>td>span>b"))
					.getText();
			String assetIDInChildWindow = assetId.split(":-  ")[1];
			System.out.println("Asset ID In Child Window: "
					+ assetIDInChildWindow);

			if (assetIdInParentWindow.equalsIgnoreCase(assetIDInChildWindow)) {
				System.out.println("Asset ID are same.\n");
				assetIdIsMatch = true;
			} else {
				System.out.println("Asset ID are not same.\n");
				assetIdIsMatch = false;
			}

			softAssert.assertTrue(assetIdIsMatch, "Asset ID  are not same.");

			List<WebElement> listOfRowInChildWindow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRowInChildWindow = listOfRowInChildWindow.size();

			for (int j = 0; j < countOfRowInChildWindow; j++) {
				List<WebElement> listOfAssetIdInChildWindowTable = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(4)>a"));
				String assetIdInChildWindowTable = listOfAssetIdInChildWindowTable
						.get(j).getText();
				System.out.println("AssetID In Child Window Table: "
						+ assetIdInChildWindowTable);

				if (assetIdInParentWindow
						.equalsIgnoreCase(assetIdInChildWindowTable)) {
					System.out.println("Asset ID are same.\n");
					assetIdIsMatch = true;
					break;

				} else {
					System.out.println("Asset ID are not same.\n");
					assetIdIsMatch = false;
				}

				softAssert.assertTrue(assetIdIsMatch, "Asset ID  are not same.");

			}

			// Closing Pop Up window
			driver.close();
			driver.switchTo().window(parentWindow);
			break;
		}
		softAssert.assertAll();

	}

	// Incident Id-SLA Flag
	public void IncidentId_SLAFlagMethod() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfID = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>a"));
			String ID = listOfID.get(i).getText();
			System.out.println("\nID:" + ID);

			/*
			 * List<WebElement> listOfID1 =driver.findElements(By.cssSelector(
			 * "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)"
			 * )); WebElement ID1=listOfID1.get(i).i if(ID1.equals("")) {
			 * System.out.println("pass"); } Assert.assertNotNull(ID1);
			 * System.out.println("\nID:"+ID1); Assert.assert
			 */
			/*
			 * Boolean qq=listOfID1.get(i).findElement(By.cssSelector(
			 * "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"
			 * )).isDisplayed(); System.out.println(qq);
			 */
			// if(listOfID1.get(i).
			// System.out.println(qq);

			/*
			 * WebElement element = driver.findElement(By.linkText(ID));
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);",
			 * element); driver.findElement(By.linkText(ID)).click();
			 * 
			 * String ID1=driver.findElement(By.cssSelector(
			 * "div[class='roundBoxMdlBg roundBoxMdlBg1']>ul>li:nth-of-type(1)>span:nth-of-type(2)"
			 * )).getText(); //System.out.println(ID1);
			 * 
			 * String ID22 = ID1.split("\n")[3]; System.out.println("k:"+ID22);
			 * 
			 * int ourhrs1 = ID22.length(); System.out.println(ourhrs1);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * driver.findElement(By.cssSelector(
			 * "span[class='rectagleBoxHeading aa']")).click();
			 * Thread.sleep(1000); String
			 * ourhrs=driver.findElement(By.cssSelector(
			 * "div[class='marTp10']>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(2)"
			 * )).getText(); System.out.println(ourhrs);
			 * 
			 * 
			 * int ourhrs11 = ourhrs.length(); System.out.println(ourhrs11);
			 * 
			 * 
			 * driver.navigate().back();
			 */
		}

	}

	// Display Hidden Message of Flag For Address
	public void checkHiddenMessageOfAddress() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRow = listOfRow.size();

		for (int i = 0; i < countOfRow; i++) {
			List<WebElement> listOfFlag = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(12)>img"));
			String flag = listOfFlag.get(i).getAttribute("alt");
			System.out.println("Flag:" + flag);
			scrollDown(listOfFlag.get(i));
			highLight(listOfFlag.get(i));

			if (flag.equalsIgnoreCase("green")) {
				String flagMassage = listOfFlag.get(i).getAttribute("title");
				System.out.println("Flag Massage:" + flagMassage);

				softAssert.assertEquals(flagMassage, "Correct Address",
						"Hidden massage is not Correct");

				System.out.println("Correct Address");
			} else if (flag.equalsIgnoreCase("Violated")) {
				String flagMassage = listOfFlag.get(i).getAttribute("title");
				System.out.println("Flag Massage:" + flagMassage);

				softAssert.assertEquals(flagMassage, "Incorrect Address",
						"Hidden massage is not Correct");

				System.out.println("Incorrect Address");
			}

		}
		softAssert.assertAll();
	}

	// Display Hidden Message Of SLA Flag
	public void checkHiddenMessageOfSLAFlag() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"));
		int countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			String slaFlag = driver
					.findElements(
							By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
					.get(i).getAttribute("src");
			System.out.println("\nslaFlag: " + slaFlag);

			switch (slaFlag) {
			case "http://demo.intelli.uno/erprmwise/images/violated.gif":
				String messageOfViolatedSLAFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: "
						+ messageOfViolatedSLAFlag);

				softAssert.assertEquals(messageOfViolatedSLAFlag,
						"Resolution(Violate)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/cold.gif":
				String messageOfColdSLAFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: " + messageOfColdSLAFlag);

				softAssert.assertEquals(messageOfColdSLAFlag, "Resolution(Cold)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/warm.gif":
				String messageOfWarmSLAFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: " + messageOfWarmSLAFlag);

				softAssert.assertEquals(messageOfWarmSLAFlag, "Resolution(Warm)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/hot.gif":
				String messageOfHotSLAFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: " + messageOfHotSLAFlag);

				softAssert.assertEquals(messageOfHotSLAFlag, "Resolution(Hot)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/nv.gif":
				String messageOfNearToViolateSLAFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: "
						+ messageOfNearToViolateSLAFlag);

				softAssert.assertEquals(messageOfNearToViolateSLAFlag,
						"Resolution(Near To Violate)");

				break;

			default:
				System.out.println("wrong");
				break;
			}

		}
		softAssert.assertAll();
	}

	// Display Hidden Message Of Response Flag
	public void checkHiddenMessageOfResponseFlag() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> listOfRow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"));
		int countOfRows = listOfRow.size();

		for (int i = 0; i < countOfRows; i++) {
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

				softAssert.assertEquals(messageOfColdResponseFlag, "Response(Cold)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/warm.gif":
				String messageOfWarmResponseFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: "
						+ messageOfWarmResponseFlag);

				softAssert.assertEquals(messageOfWarmResponseFlag, "Response(Warm)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/hot.gif":
				String messageOfHotResponseFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(1)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: "
						+ messageOfHotResponseFlag);

				softAssert.assertEquals(messageOfHotResponseFlag, "Response(Hot)");

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
				break;
			}

		}
		softAssert.assertAll();
	}

	// Pagination //
	// Count Of Pagination
	public void countOfPagination() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		int size = dropdown_Pagination.size();
		System.out.println("Pagination Pages: "+size);
		/*int count = 0;
		for (int i = 0; i < size; i++) {
			System.out.println("Page No.: "+ i);
			dropdown_Pagination.get(i).click();
			Thread.sleep(1000);
			int rowSize = list_RowInTable.size();
			System.out.println("Row Count: "+rowSize);
			count = count + rowSize;
			System.out.println("Total Count: "+count);
			
		}*/
		
		int count=20*(size-1);
		dropdown_Pagination.get(size-1).click();
		Thread.sleep(1000);
		int lastPageCount = list_RowInTable.size();
		System.out.println("last Page Count: "+lastPageCount);
		int totalCountTicket = count + lastPageCount;
		System.out.println("Total Count: "+totalCountTicket);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		softAssert.assertEquals(totalCountTicket,actualTotalCount,"Count is not match");
		softAssert.assertAll();
	}

	// Display As Per Arrows Of Pagination
	public void displayAsPerArrowsOfPagination() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Click on leftmost arrow
		int size = dropdown_Pagination.size();
		System.out.println("size" + size);

		arrow_LeftmostArrowOfPagination.click();
		String leftMostPage = page_SelectedInPagination.getAttribute("value");
		System.out.println("leftMostPage " + leftMostPage);
		softAssert.assertEquals("1", leftMostPage, "Page not Same");

		// Click on Rightmost arrow
		// Thread.sleep(500);
		arrow_RightmostArrowOfPagination.click();
		String page = page_SelectedInPagination.getAttribute("value");
		System.out.println("rightMostPage " + page);
		int rightMostPage = Integer.parseInt(page);
		softAssert.assertEquals(size, rightMostPage, "Page not Same");

		// Click on RightArrow
		// Thread.sleep(500);
		arrow_LeftmostArrowOfPagination.click();
		String firstPageValue = page_SelectedInPagination.getAttribute("value");
		int firstPage = Integer.parseInt(firstPageValue);
		System.out.println("firstPage" + firstPage);

		arrow_RightArrowOfPagination.click();
		String nextPageValue = page_SelectedInPagination.getAttribute("value");
		int nextPage = Integer.parseInt(nextPageValue);
		System.out.println("nextPage" + nextPage);

		int rightArrowPage = firstPage + 1;
		softAssert.assertEquals(nextPage, rightArrowPage);

		// Click on LeftArrow
		// Thread.sleep(500);
		String lastPageValue = page_SelectedInPagination.getAttribute("value");
		int lastPage = Integer.parseInt(lastPageValue);
		System.out.println("lastPage" + lastPage);

		arrow_LeftArrowOfPagination.click();
		String previousPageValue = page_SelectedInPagination
				.getAttribute("value");
		int previousPage = Integer.parseInt(previousPageValue);
		System.out.println("previousPage" + previousPage);

		int leftArrowPage = lastPage - 1;
		softAssert.assertEquals(previousPage, leftArrowPage);
		softAssert.assertAll();

	}

	// If user click on Search Ticket tab then Search ticket tab
	// should get open with ID, Asset ID, and Ticket ID search fields
	public void checkSearchTicketTab() {
		SoftAssert softAssert = new SoftAssert();

		// Click on search ticket tab
		tab_SearchTicketOpen.click();

		// Get value of Search Id
		String searchId = textbox_SearchId.getText();
		// Print value of Search Id
		System.out.println("search ID :" + searchId);

		// Verify the value of search ID is null
		softAssert.assertEquals(searchId, "");

		// Get value of Search Asset ID
		String searchassetId = textbox_SearchAssetID.getText();
		// Print value of Search Asset ID
		System.out.println("search asset ID :" + searchassetId);

		// verify the value of search asset ID is null
		softAssert.assertEquals(searchassetId, "");

		// Get value of Search Ticket ID
		String searchTicketId = textbox_SearchTicketID.getText();
		// Print value of Search Ticket ID
		System.out.println("search ticket ID :" + searchTicketId);
		// verify the value of search ticket ID is null
		softAssert.assertEquals(searchTicketId, "");
		softAssert.assertAll();

	}

	// In ID field if user enter alphabets then alert box should display as
	// 'Please Enter The Numeric Value for Incident ID'
	public void checkSearchIdTextBox() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		 tab_SearchTicketClose.click();

		// click on search ticket tab
		tab_SearchTicketOpen.click();
		Thread.sleep(500);
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// enter the alphabetical value in ID field, after that it display the
		// alert box
		textbox_SearchId.sendKeys("ABC");

		// click on Go button
		button_IDGo.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message is Please Enter The Numeric Value for
		// Incident ID or not
		softAssert.assertEquals(alertMessage,
				"Please Enter The Numeric Value for Incident ID");
		System.out.println("Both the message is equal");
		softAssert.assertAll();

	}

	// If user enter incident number which is not present
	// in view ticket dash board then after click on Go button, 0 count is
	// showing
	public void checkInvalidIdTextBox() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		tab_SearchTicketClose.click();

		// click on search ticket tab
		tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// enter the incident ID which is not present in view ticket dashboard
		textbox_SearchId.sendKeys("1000000");

		// click on Go button
		button_IDGo.click();

		// Thread.sleep(3000);

		// address of total ticket count
		WebElement totalTicketCount = driver
				.findElement(By
						.xpath(".//*[@id='pagination']/strong[contains(text(),'Total Ticket Count:')]"));
		String valueOfTicketCount = totalTicketCount.getText();
		System.out.println(valueOfTicketCount);

		// enter incident ID number which is not present in view ticket
		// dash board then the count must be 0 ,if it is equal to zero then test
		// case pass
		softAssert.assertEquals(valueOfTicketCount, "  Total Ticket Count: 0",
				" Wrong");
		softAssert.assertAll();

	}

	// If User enter Asset ID which is not present in system then
	// after click on Go button, It should display 0 count in Incident dash
	// board
	public void checkInvalidAssetId() {
		SoftAssert softAssert = new SoftAssert();
		// tab_SearchTicketClose.click();

		// click on search ticket tab
		tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// enter the incident number in asset id tab which is not present in
		// view ticket dash board
		textbox_SearchAssetID.sendKeys("TestAp");

		// click on GO button
		button_AssetIDGo.click();

		// Address of total ticket count
		WebElement totalTicketCount = driver
				.findElement(By
						.xpath(".//*[@id='pagination']/strong[contains(text(),'Total Ticket Count:')]"));

		String valueOfTicketCount = totalTicketCount.getText();
		System.out.println(valueOfTicketCount);

		// enter incident asset ID number which is not present in view ticket
		// dash board then the count must be 0 ,if it is equal to zero then test
		// case pass
		softAssert.assertEquals(valueOfTicketCount, "  Total Ticket Count: 0",
				" Wrong");
		softAssert.assertAll();

	}

	// enter incident ticket ID number which is not present in view ticket
	// dash board then the count must be 0 ,if it is equal to zero then test
	// case pass
	public void checkInvalidTicketId() {
		SoftAssert softAssert = new SoftAssert();
		// tab_SearchTicketClose.click();

		// click on search ticket tab
		tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// enter the incident number in ticket id tab which is not present in
		// view ticket dash board
		textbox_SearchTicketID.sendKeys("123a");

		// click on GO button
		button_TicketIDGo.click();

		// Address of total ticket count
		WebElement totalTicketCount = driver
				.findElement(By
						.xpath(".//*[@id='pagination']/strong[contains(text(),'Total Ticket Count:')]"));

		String valueOfTicketCount = totalTicketCount.getText();
		System.out.println(valueOfTicketCount);

		// enter incident ticket ID number which is not present in view ticket
		// dash board then the count must be 0 ,if it is equal to zero then test
		// case pass
		softAssert.assertEquals(valueOfTicketCount, "  Total Ticket Count: 0");
		softAssert.assertAll();

	}

	// If User enter correct Ticket ID and click on Go button,
	// then system should display Incident of same ticket ID
	public void checkValidTicketId() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		 tab_SearchTicketClose.click();

		// click on search ticket tab
		tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// enter the incident number in ticket id tab which is not present in
		// view ticket dash board
		textbox_SearchTicketID.sendKeys("540");

		// click on GO button
		button_TicketIDGo.click();

		// Thread.sleep(3000);

		// for table
		List<WebElement> rowElement = driver
				.findElements(By
						.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ rowElement.size());

		for (int i = 0; i < rowElement.size(); i++) {

			List<WebElement> columnElement = driver
					.findElements(By
							.cssSelector("div[class='fht-fixed-column']>div[class='fht-tbody']>table>tbody>tr>td:nth-of-type(2)"));
			WebElement element = columnElement.get(i);
			System.out.println(element.getText());

			if (element.getText().contains("540")) {

				System.out.println("Both the ticket Id is equal");

			}

		}

	}

	// If User Click on Go button of ID search field with blank details,
	// then alert box should display as 'Please Enter Incident ID'
	public void checkSearchIdTextBoxBlankData() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// tab_SearchTicketClose.click();

		// click on search ticket tab
		tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// click on Go button of the ID text box
		button_IDGo.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message is Please Enter Incident ID or not
		softAssert.assertEquals(alertMessage, "Please Enter Incident ID");
		System.out.println("Both the message is equal");
		softAssert.assertAll();

	}

	// If User Click on Go button of Asset ID search field with blank details,
	// then alert box should display as 'Please Enter Asset ID'
	public void checkSearchAssertIdTextBoxBlankData() throws Exception {
		SoftAssert softAssert = new SoftAssert();// Thread.sleep(1000);
	//	tab_SearchTicketClose.click();

		// click on search ticket tab
	//	tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// click on GO button of asset ID text box
		button_AssetIDGo.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message is Please Enter Incident ID or not
		softAssert.assertEquals(alertMessage, "Please Enter Asset Id");
		System.out.println("Both the message is equal");
		softAssert.assertAll();

	}

	// If User Click on Go button of Ticket ID search field with blank details,
	// then alert box should display as 'Please Enter Customer Ticket ID'
	public void checkSearchTicketIdTextBoxBlankData() throws Exception 
	{
		 SoftAssert softAssert = new SoftAssert();
	//	 tab_SearchTicketClose.click();

		// click on search ticket tab
	//	tab_SearchTicketOpen.click();
		textbox_SearchId.clear();
		textbox_SearchAssetID.clear();
		textbox_SearchTicketID.clear();

		// click on GO button of ticket ID text box
		button_TicketIDGo.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message is Please Enter Customer Ticket ID or not
		softAssert.assertEquals(alertMessage, "Please Enter Customer Ticket ID");
		System.out.println("Both the message is equal");
		softAssert.assertAll();

	}

	// In view ticket page, if user click on Filter button then pop up
	// should display to filter view incident page. By default All option should
	// display in all filters
	public void checkFilterTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(500);
		// click on filter tab
		tab_Filter.click();

		// get the text from state filter which is already selected
		String stateFilter = dropdown_StateFilter.getText();
		System.out.println("selected state:-" + stateFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(stateFilter, "All");

		// Thread.sleep(1000);
		// get the text from status filter which is already selected
		String statusFilter = dropdown_StatusFilter.getText();
		System.out.println("selected Status:-" + statusFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(statusFilter, "All");

		// Thread.sleep(1000);
		// get the text from Ticket Type filter which is already selected
		String ticketTypeFilter = dropdown_TicketTypeFilter.getText();
		System.out.println("selected Ticket Type:-" + ticketTypeFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(ticketTypeFilter, "All");

		// Thread.sleep(1000);
		String ctsFilter = dropdown_CTS.getText();
		System.out.println("selected CTS:-" + ctsFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(ctsFilter, "All");

		// Thread.sleep(1000);
		String customerNameFilter = dropdown_CustomerNameFilter.getText();
		System.out.println("selected customer:-" + customerNameFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(customerNameFilter, "All");

		// Thread.sleep(1000);
		String enginnerFilter = dropdown_EnginnerFilter.getText();
		System.out.println("selected Engineer:-" + enginnerFilter);

		// Thread.sleep(1000);
		String createByRoleFilter = dropdown_CreateByRoleFilter.getText();
		System.out.println("selected Create By Role:-" + createByRoleFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(createByRoleFilter, "All");

		// Thread.sleep(1000);
		String createByFilter = dropdown_CreateByFilter.getText();
		System.out.println("selected Create By:-" + createByFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(createByFilter, "All");

		// Thread.sleep(1000);
		String categoryFilter = dropdown_CategoryFilter.getText();
		System.out.println("selected Category:-" + categoryFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(categoryFilter, "All");

		// Thread.sleep(1000);
		String subCategoryFilter = dropdown_SubCategoryFilter.getText();
		System.out.println("selected Sub Category:-" + subCategoryFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(subCategoryFilter, "All");
		// tab_Filter.click();
		softAssert.assertAll();

	}

	// In state filter, All states which are assign to SD login should display
	// in list
	public void selectStateFilter() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on filter tab
		tab_Filter.click();

		// select the particular state
		Select state;
		state = new Select(driver.findElement(By.name("m_strStateFilter")));
		state.selectByVisibleText("Maharashtra");
		// Thread.sleep(3000);

		// for table
		List<WebElement> rowElement = driver
				.findElements(By
						.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ rowElement.size());

		for (int i = 0; i < rowElement.size(); i++) {

			List<WebElement> columnElement = driver
					.findElements(By
							.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[23]"));
			WebElement element = columnElement.get(i);
			System.out.println(element.getText());

			if (element.getText().contains("Maharashtra")) {

				System.out.println("Both the ticket Id is equal");

			}

		}

	}

	
	// If User select particular state option then in view ticket page,
	// all tickets should display where customer address is belongs to selected
	// state
	public void selectStatusFilter() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(2000);
		// click on filter tab
		tab_Filter.click();

		// select the particular status
		Select status;
		status = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status.selectByValue("Open");
		// Thread.sleep(3000);

		/*
		 * // for table List<WebElement> rowElement = driver .findElements(By
		 * .xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
		 * System.out.println("NUMBER OF ROWS IN THIS TABLE = " +
		 * rowElement.size());
		 * 
		 * for (int i = 0; i < rowElement.size(); i++) {
		 * 
		 * 
		 * List<WebElement> columnElement = driver .findElements(By
		 * .xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[8]"
		 * ));
		 * 
		 * String element = columnElement.get(i).getText();
		 * System.out.println(element);
		 */
		// List<WebElement> element = list_StatusInTable;
		// System.out.println(element.size());
		int size = list_StatusInTable.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) 
		{

			String statusValue = list_StatusInTable.get(i).getText();
			System.out.println(statusValue);
			
			scrollDown(list_StatusInTable.get(i));
			highLight(list_StatusInTable.get(i));
			softAssert.assertEquals(statusValue, "Open",
					"ticket status is not equal");
			System.out.println("ticket status is equal");
			/*
			 * WebElement element = columnElement.get(i);
			 * System.out.println(element.getText());
			 * 
			 * if (element.getText().contains("Open")) {
			 * 
			 * System.out.println("ticket status is equal");
			 * 
			 * }
			 */
		}
		softAssert.assertAll();

	}
	
	// In Ticket Type filter-> all ticket type filter
		// should display as per super login-> ticket type master
		public void compareStateFilter() throws Exception 
		{
			
			SoftAssert softAssert = new SoftAssert();
			// Thread.sleep(2000);
			// click on filter tab
			tab_Filter.click();

			// get all values of state filter
			String stateFilterValue = dropdown_State.getText();
			String splitAll = stateFilterValue.split("All")[1];
			// String splitSpace= splitAll.split("-")[0];
			System.out.println("all values of state filter:-" + splitAll);

			// Thread.sleep(1000);
			// click on filter tab
			// tab_Filter.click();

			// Change the Tab
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
			// Enter url
			driver.get(properties.getProperty("url"));

			driver.findElement(By.cssSelector("body"))
					.sendKeys(Keys.CONTROL + "\t");
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");

			// click on account
			link_sd.click();
			Thread.sleep(1000);

			// click on logout
			link_LogOut.click();
			// Thread.sleep(1000);

			// login as super ,call it from super Role customer detail page
			loginPageOfSuperRole = new Super_LoginPage();
			homePageOfSuperRole = loginPageOfSuperRole.Login(
					properties.getProperty("loginIdForSuper"),
					properties.getProperty("password"));

			// Thread.sleep(1000);
			empolyeeMasterPageOfSuperRole = homePageOfSuperRole
					.clickEmpolyeeMasterlink();

			// Thread.sleep(1000);
			employeeDetailPageOfSuperRole = empolyeeMasterPageOfSuperRole
					.clickOnEmpolyeeDetailLink();

			// Thread.sleep(2000);
			driver.findElement(By.id("open")).click();
			
			Select select = new Select(driver.findElement(By.name("m_strRole")));
			select.selectByVisibleText("SD");
			Thread.sleep(500);
			// for table
			List<WebElement> rowElement = driver.findElements(By
					.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr"));
			System.out.println("NUMBER OF ROWS IN THIS TABLE = "
					+ rowElement.size());

			for (int i = 0; i < rowElement.size(); i++) {

				List<WebElement> listOfLoginIdcolumn = driver
						.findElements(By
								.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[33]"));
				String loginIdcolumn = listOfLoginIdcolumn.get(i).getText();
				System.out.println(loginIdcolumn);

				if (loginIdcolumn.contains("sd")) {
					System.out.println("Both the ticket Id is equal ");

					List<WebElement> listOfUpdateColumn = driver
							.findElements(By
									.cssSelector(".fht-table.fht-table-init>tbody>tr>td:nth-of-type(34)>a"));
					WebElement updateColumn = listOfUpdateColumn.get(i);
					System.out.println(updateColumn.getText());

					updateColumn.click();
					
					String bydefaultStateValue = driver.findElement(By.xpath(".//*[@id='right']/div[1]/table/tbody/tr[1]/td[1]/table/tbody/tr[15]/td/select/option[@selected = 'selected']")).getText();
					System.out.println("bydefaultStateValue: "+ bydefaultStateValue);

					String superStateValue = driver
							.findElement(
									By.xpath(".//*[@id='right']/div[1]/table/tbody/tr[7]/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[5]/select"))
							.getText();
					System.out.println("State Values:-" + superStateValue);

					softAssert.assertEquals(splitAll, "\n" + superStateValue +"\n"+bydefaultStateValue);

					/*// Change the Tab
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "t");
					// Enter url
					driver.get(properties.getProperty("url"));

					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "\t");
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "w");

					// click on account
					link_Test.click();
					Thread.sleep(500);

					// click on logout
					link_LogOut.click();
					// Thread.sleep(1000);

					loginPageOfSdRole = new SD_LoginPage();
					homePageOfSdRole = loginPageOfSdRole.login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);
					ticketPageOfSdRole = homePageOfSdRole.ticketTab();
					Thread.sleep(1000);
					viewTicketPageOfSdRole = ticketPageOfSdRole.viewTicketTab();

					break;*/
					
					break;

				}

				else {
					System.out.println("Both the ticket Id is Not equal");

				}

			}
			softAssert.assertAll();

		}


	// If user select particular ticket type then in dash board,
	// all tickets should display as per selected ticket type filter
	public void compareTicketTypeFilter() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(1000);
		// click on filter tab
		tab_Filter.click();

		// get the value of ticket type filter
		String ticketTypeValue = dropdown_TicketType.getText();
		String splitAll = ticketTypeValue.split("All")[1];
		System.out.println("All Value Ticket Type In SD Role:-" + splitAll);

		// Change the Tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		// Enter url
		driver.get(properties.getProperty("url"));

		driver.findElement(By.cssSelector("body"))
				.sendKeys(Keys.CONTROL + "\t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");

		/*
		 * // Switching between tabs using CTRL + tab keys.
		 * driver.findElement(By.cssSelector("body")) .sendKeys(Keys.CONTROL +
		 * "\t"); driver.switchTo().defaultContent();
		 */
		// Thread.sleep(3000);
		// click on filter tab
		// tab_Filter.click();

		// click on account
		link_sd.click();
		Thread.sleep(2000);

		// click on logout
		link_LogOut.click();
		Thread.sleep(1000);

		// login as super ,call it from super Role customer detail page
		loginPageOfSuperRole = new Super_LoginPage();
		homePageOfSuperRole = loginPageOfSuperRole.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		// homePageOfSuperRole = new HomePageOfSuperRole();

		// Thread.sleep(3000);
		sDmasterPageOfSuperRole = homePageOfSuperRole.clickSdMasterlink();

		Thread.sleep(1000);
		ticketMasterPageOfSuperRole = sDmasterPageOfSuperRole
				.clickOnTicketMasterLink();

		Thread.sleep(1000);
		ticketTypePageOfSuperRole = ticketMasterPageOfSuperRole
				.ticketTypeTab();

		// Thread.sleep(3000);

		// for table
		List<WebElement> rowElement = driver.findElements(By
				.xpath(".//*[@id='right']/div/div/div[2]/table/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ rowElement.size());

		for (int i = 0; i < rowElement.size();) {

			List<WebElement> columnElement = driver
					.findElements(By
							.xpath(".//*[@id='right']/div/div/div[2]/table/tbody/tr/td[2]"));
			String element = columnElement.get(i).getText();
			System.out.println("All Value Ticket Type In super Role:-"
					+ element);

			if (ticketTypeValue.contains(element))

			{

				System.out.println("Pass");

			}

			else 
			{
				System.out.println("fails");
			}

			softAssert.assertTrue(true, "not");

			// Change the Tab
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "t");
			// Enter url
			driver.get(properties.getProperty("url"));

			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "\t");
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "w");

			// click on account
			link_Test.click();
			Thread.sleep(2000);

			// click on logout
			link_LogOut.click();
			// Thread.sleep(1000);

			loginPageOfSdRole = new SD_LoginPage();
			homePageOfSdRole = loginPageOfSdRole.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			ticketPageOfSdRole = homePageOfSdRole.ticketTab();
			// Thread.sleep(2000);
			Thread.sleep(1000);
			viewTicketPageOfSdRole = ticketPageOfSdRole.viewTicketTab();
			break;

		}
		softAssert.assertAll();

	}

	// If user select Open status in CTS filter, then in View incident ticket
	// should display
	// with status 'Open', 'Paused', 'Reopened', 'technician closed',
	// 'Cancelled'
	public void selectOpenCTSFilterTextBox() throws Exception { 
		SoftAssert softAssert = new SoftAssert();// Thread.sleep(2000);
																// click on
																// filter tab
		tab_Filter.click();

		// select the CTS filter
		Select ctsFilter;
		ctsFilter = new Select(driver.findElement(By.name("m_strMTS")));
		ctsFilter.selectByVisibleText("Open");
		 Thread.sleep(3000);

		// for table
		List<WebElement> rowElement = driver
				.findElements(By
						.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ rowElement.size());

		boolean statusIsPresent;

		for (int i = 0; i < rowElement.size(); i++) {

			List<WebElement> columnElement = driver
					.findElements(By
							.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[8]"));
			String element = columnElement.get(i).getText();
			System.out.println(element);
			scrollDown(columnElement.get(i));
			highLight(columnElement.get(i));

			if (element.contains("Open")) {
				System.out.println("ticket status is open");
				statusIsPresent = true;

			}

			else if (element.contains("Paused")) {
				System.out.println("ticket status is Paused");
				statusIsPresent = true;

			}

			else if (element.contains("Reopened")) {
				System.out.println("ticket status is Reopened");
				statusIsPresent = true;

			}

			else if (element.contains("TechnicianClosed")) {
				System.out.println("ticket status is TechnicianClosed");
				statusIsPresent = true;

			}

			else if (element.contains("Cancelled")) {
				System.out.println("ticket status is Cancelled");
				statusIsPresent = true;

			}

			else {
				System.out.println("ticket status is wrong");
				statusIsPresent = false;

			}

			softAssert.assertTrue(statusIsPresent);

		}
		softAssert.assertAll();

	}

	// If user select Close status in CTS filter,
	// then in View incident ticket should display with status 'closed'
	public void selectCloseCTSFilterTextBox() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(2000);
		// click on filter tab
		//tab_Filter.click();

		 Thread.sleep(1000);
		// select the CTS filter
		Select ctsFilter;
		ctsFilter = new Select(driver.findElement(By.name("m_strMTS")));
		ctsFilter.selectByValue("Closed");
		 Thread.sleep(4000);

		List<WebElement> columnElement = driver
				.findElements(By
						.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[8]"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ columnElement.size());

		boolean statusIsClose;

		for (int i = 0; i < columnElement.size(); i++) {

			String element = columnElement.get(i).getText();
			System.out.println(element);
			scrollDown(columnElement.get(i));
			highLight(columnElement.get(i));
			if (element.contains("Closed")) {
				System.out.println("ticket status is close");
				statusIsClose = true;

			} else {
				System.out.println("ticket status is wrong");
				statusIsClose = false;

			}

			softAssert.assertTrue(statusIsClose);

		}
		softAssert.assertAll();
	}
	
	//used in RM -> Inventory -> Spare Approve 
	public void checkStatusInSD() throws Exception
	{
	
		SoftAssert softAssert = new SoftAssert();
		
		Thread.sleep(200);
		//click on search ticket
		tabSearchTicketOpen.click();
		
		//click on Ticket ID
		txtTicketId.sendKeys(rm_SpareApprovalPage.ticketId);
		
		//click on GO button
		btnGoOfTicketId.click();
		
		//click on ID
		lnkFirstId.click();
		
		//click on spare tab
		tabSpare.click();
				
		//get value of Spare Request ID
		int size = lstSpareRequestID.size();
		
		for(int i = 0 ; i < size; i++)
		{
			scrollDown(lstSpareRequestID.get(i));
			Thread.sleep(200);
			highLight(lstSpareRequestID.get(i));

			
			String spareId = lstSpareRequestID.get(i).getText();
			System.out.println("spareId: "+ spareId);
			
			if(spareId.contains(rm_SpareApprovalPage.spareRequestId))
			{
				
				scrollDown(lstStatus.get(i));
				Thread.sleep(200);
				highLight(lstStatus.get(i));
				
				String status = lstStatus.get(i).getText();
				System.out.println("spareId: "+ status);
				
				softAssert.assertEquals(status, "Approved");
				
			}
			
			
			
		}
		softAssert.assertAll();
		
		
	}
	
	//used in RM -> Inventory -> Spare Approve check remark
			public void checkRemarkInSD() throws Exception
			{
			
				SoftAssert softAssert = new SoftAssert();
				
				Thread.sleep(200);
				//click on search ticket
				tabSearchTicketOpen.click();
				
				//click on Ticket ID
				txtTicketId.sendKeys(rm_SpareApprovalPage.ticketId);
				
				//click on GO button
				btnGoOfTicketId.click();
				
				//click on ID
				lnkFirstId.click();
				
				//click on spare tab
				tabSpare.click();
						
				//get value of Spare Request ID
				int size = lstSpareRequestID.size();
				
				for(int i = 0 ; i < size; i++)
				{
					scrollDown(lstSpareRequestID.get(i));
					Thread.sleep(200);
					highLight(lstSpareRequestID.get(i));

					
					String spareId = lstSpareRequestID.get(i).getText();
					System.out.println("spareId: "+ spareId);
					
					if(spareId.contains(rm_SpareApprovalPage.spareRequestId))
					{
						
						scrollDown(lstRemark.get(i));
						Thread.sleep(200);
						highLight(lstRemark.get(i));
						
						String remark = lstRemark.get(i).getText();
						System.out.println("spareId: "+ remark);
						
						softAssert.assertEquals(remark, rm_SpareApprovalPage.spareRemark, "SD Remark is different");
						
					}
					
					
					
				}
				softAssert.assertAll();
				
				
			}

}