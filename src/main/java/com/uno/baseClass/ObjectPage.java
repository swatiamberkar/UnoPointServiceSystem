package com.uno.baseClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.excelUtility.WebEventListener;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.superrole.Super_AdminPage;
import com.uno.pages.superrole.Super_CTSStatusPage;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_FileCategoryPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_ItemMasterPage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ManageStaffPage;
import com.uno.pages.superrole.Super_PauseReasonPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;
import com.uno.pages.superrole.Super_SpareInventoryLocationPage;
import com.uno.pages.superrole.Super_TeamMasterPage;
import com.uno.pages.superrole.Super_TicketCategoryMasterPage;
import com.uno.pages.superrole.Super_TicketLevelPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketModePage;
import com.uno.pages.superrole.Super_TicketTypePage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.pages.technician.Technician_IncidentPage;
import com.uno.pages.technician.Technician_TicketSummaryPage;
import com.uno.pages.technician.Technician_ViewIncidentPage;
import com.uno.test.sd.SD_ViewTicketTest;
import com.uno.test.superrole.Super_AdminTest;
import com.uno.test.superrole.Super_InventoryMastersTest;
import com.uno.test.superrole.Super_ServiceDeskSettingsTest;

public class ObjectPage {

	public static WebDriver driver;
	public WebEventListener webEventListener;
	// call the method from SD role
	public SD_LoginPage sd_LoginPage;
	public SD_ViewTicketTest sd_ViewTicketTest;
	public SD_CreateNewPage sd_CreateNewPage;

	public Technician_HomePage technician_HomePage;
	public Technician_IncidentPage technician_IncidentPage;
	public Technician_ViewIncidentPage technician_ViewIncidentPage;
	public Technician_TicketSummaryPage technician_TicketSummaryPage;
	

	// call the method from super role
	public Super_LoginPage super_LoginPage;
	public Super_HomePage super_HomePage;
	public Super_SDMasterPage super_SDMasterPage;
	public Super_TicketMasterPage super_TicketMasterPage;
	public Super_PauseReasonPage super_PauseReasonPage;
	public Super_TicketTypePage super_TicketTypePage;
	public Super_TicketModePage super_TicketModePage;
	public Super_TicketLevelPage super_TicketLevelPage;
	public Super_CTSStatusPage super_CTSStatusPage;
	public Super_TicketCategoryMasterPage super_TicketCategoryMasterPage;
	public Super_EmployeeMasterPage super_EmployeeMasterPage;
	public Super_EmployeeDetailPage super_EmployeeDetailPage;
	public Super_ManageStaffPage super_ManageStaffPage;
	public Super_TeamMasterPage super_TeamMasterPage;
	public Super_FileCategoryPage super_FileCategoryPage;
	public Super_AdminPage super_AdminPage;
	public Super_AdminTest super_AdminTest;
	public Super_ServiceDeskSettingsPage super_ServiceDeskSettingsPage;
	public Super_ServiceDeskSettingsTest super_ServiceDeskSettingsTest;
	public Super_InventoryMastersTest super_InventoryMastersTest;
	public Super_ItemMasterPage super_ItemMasterPage;
	public Super_SpareInventoryLocationPage super_SpareInventoryLocationPage;

	
	// SD Master Link
	@FindBy(linkText = "SD Master")
	public static WebElement tabSDMaster;

	// Employee Master Link
	@FindBy(linkText = "Employee Master")
	public static WebElement tabEmployeeMaster;

	// Admin link
	@FindBy(xpath = ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[9]")
	public static WebElement tabAdmin;

	// Inventory Masters Link
	@FindBy(linkText = "Inventory Masters")
	public static WebElement tabInventoryMasters;
	
	@FindBy(css = "select[name='m_strRole']")
	public static WebElement ddlSearchByRole;

	
	// Button Save
	@FindBy(css = "input[onclick='Save()']")
	public static WebElement btnSave;

	// Label Ticket Count in Ticket Table
	@FindBy(css = "div[id='pagination']>strong")
	public static WebElement lblTicketCountInTicketTable;

	// Label Ticket Count in Ticket Table
	@FindBy(css = "a[onclick='submitOpen();']>span[class='badge']")
	public static WebElement lblCountOfRequestOpenTab;

	// Label Ticket Count in Ticket Table
	@FindBy(css = "a[onclick='submitETAassing();']>span[class='badge']")
	public static WebElement lblCountOfAssignedButNoETA;
	
	@FindBy(css = "a[onclick='submitopenetaviolated();']>span[class='badge']")
	public static WebElement lblCountOfETAExpiredAndNoATAETA;

	@FindBy(css = "#view_property>ul>li>input")
	public static List<WebElement> lstChkMyView;

	// Row in Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
	public static List<WebElement> lstRowInTicketTable;

	// Status in Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)")
	public static List<WebElement> lstStatusInTicketTable;

	// Engineer in Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(26)")
	public static List<WebElement> lstEngineerInTicketTable;

	// Engineer in Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)")
	public static List<WebElement> lstETADateInTicketTable;

	@FindBy(css = "a[class='topLnk'][onclick='fireMyPopup()']")
	public static WebElement tabMyView;

	// Ticket Summary Page

	// Select Open Tab
	@FindBy(linkText = "Open")
	public static WebElement tabOpenInTicketSummary;

	// Select Work In Progress Tab
	@FindBy(linkText = "Work In Progress")
	public static WebElement tabWorkInProgressInTicketSummary;

	// Select SLA Tab
	@FindBy(linkText = "SLA")
	public static WebElement tabSLAInTicketSummary;

	// Select Resolved Tab
	@FindBy(linkText = "Resolved")
	public static WebElement tabResolvedInTicketSummary;

	// Select Requests Open Tab
	@FindBy(css = "a[onclick='submitOpen();']")
	public static WebElement tabRequestsOpenInTicketSummary;

	@FindBy(css = "a[onclick='submitETAassing();']")
	public static WebElement tabAssignedButNoETA;
	
	@FindBy(css = "a[onclick='submitopenetaviolated();']")
	public static WebElement tabETAExpiredAndNoATA;
	
	@FindBy(css = "div[id='pagination']>strong")
	public static WebElement lblTotalTicketCount;

	// Technician Module //

	// Home Tab of Technician
	@FindBy(css = ".home>a")
	public static WebElement tabHome;
	
	@FindBy(css = "a[title='showtabledata']")
	public static WebElement tabTicketSummary;

	@FindBy(linkText = "Ticket")
	public static WebElement tabTicket;

	@FindBy(css = "a[href='/erprmwise/IncidentAction.do']")
	public static WebElement tabCreateNew;

	@FindBy(xpath = "//a[@href='/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")
	public static WebElement tabViewTicket;

	@FindBy(linkText = "Edit Incident")
	public static WebElement tabEditIncident;

	// Select Incident ID Text Box
	@FindBy(xpath = ".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]")
	public static WebElement txtIncidenID;

	// select Search Ticket
	@FindBy(css = "#open")
	public static WebElement tabSearchTicketOpen;

	// select Search Ticket
	@FindBy(css = "#close")
	public static WebElement tabSearchTicketClose;

	// Select Account link
	@FindBy(linkText = "Account")
	public static WebElement tabAccount;

	// Select SD tab for logout tab
	@FindBy(linkText = "SD")
	public static WebElement tabSd;
	
	// Select SD tab for logout tab
	@FindBy(css = "div.header-wrapper:nth-child(22) div.nav-wrapper div.nav ul.nav-ul li:nth-child(7) > a:nth-child(1)")
	public static WebElement tabTechnician;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	public static WebElement tabTest;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	public static WebElement tabLogOut;

	// Notification of View Ticket Page
	@FindBy(css = "div[id='form']>div[id='dialogBoxSuccess']")
	public static WebElement msgNotification;

	// select Search Ticket
	@FindBy(linkText = "Search Ticket")
	public static WebElement tabSearchTicket;

	// Select Id in Table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
	public static WebElement lnkFirstIdInTable;

	// list of Flag of Incorrect Customer Address
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(12)>img")
	public static List<WebElement> lstFlagOfIncorrectCustomerAddressInTable;

	// list of Blinking Notification in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>i")
	public static List<WebElement> listBlinkingNotificationInTable;

	// list of ETA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)")
	public static List<WebElement> lstETADateInTable;
	
	// list of ETA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(26)")
	public static List<WebElement> lstTechnicianInTable;

	// list of ATA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)")
	public static List<WebElement> lstATADateInTable;
	
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(11)")
	public static List<WebElement> lstCallTypeInTable;

	// list of Paused Time in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(39)")
	public static List<WebElement> lstPausedTimeInTable;

	// list of Remark in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(53)")
	public static List<WebElement> lstRemarkInTable;

	// Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
	public static List<WebElement> ddlPagination;

	// Left Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(1)")
	public static WebElement btnLeftmostArrowOfPagination;

	// Right Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(4)")
	public static WebElement btnRightmostArrowOfPagination;

	// Right Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(3)")
	public static WebElement btnRightArrowOfPagination;

	// Left Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(2)")
	public static WebElement btnLeftArrowOfPagination;

	// Selected Page in Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option[selected='selected']")
	public static WebElement pageSelectedInPagination;

	// List of Row in Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
	public static List<WebElement> lstRowInTable;

	// Search Ticket Tab //

	// select Search ID
	@FindBy(name = "m_strSearchIncId")
	public static WebElement tabSearchId;

	// select GO button of ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
	public static WebElement btnGoOfId;

	// select Search asset ID
	@FindBy(name = "m_strSearchAssetId")
	public static WebElement tabAssetId;

	// select GO button of asset ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
	public static WebElement btnGoOfAssetId;

	// select Search Ticket ID
	@FindBy(name = "m_strSearchTicketId")
	public static WebElement tabTicketId;

	// select GO button of ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
	public static WebElement btnGoOfTicketId;

	// Label in Incident Number
	@FindBy(css = ".roundBoxMdlBg.roundBoxMdlBg1>ul>li:nth-of-type(1)>span:nth-of-type(2)")
	public static WebElement lblIncidentNumber;

	// Label Date in Incident Date Time
	@FindBy(xpath = ".//*[@id='Requestor']/div/div[3]/table/tbody/tr/td[3]/table/tbody/tr[5]/td")
	public static WebElement lblDateInIncidentDateTime;

	// select filter
	@FindBy(linkText = "Filter")
	public static WebElement tabFilter;

	// select state filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(2)>td>select>option:nth-of-type(1)")
	public static WebElement ddlStateFilter;

	// select status filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(5)>td>select>option:nth-of-type(1)")
	public static WebElement ddlStatusFilter;

	// select ticket type filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(7)>td>select>option:nth-of-type(1)")
	public static WebElement ddlTicketTypeFilter;

	// select CTS filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(9)>td>select>option:nth-of-type(1)")
	public static WebElement ddlCTS;

	// select customer filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(11)>td>select>option:nth-of-type(1)")
	public static WebElement ddlCustomerNameFilter;

	// select engineer filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(13)>td>select>option:nth-of-type(1)")
	public static WebElement ddlEnginnerFilter;

	// select engineer filter text box
	@FindBy(name = "m_strEngineer")
	public static WebElement ddlEngineer;

	// select create by role filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(15)>td>select>option:nth-of-type(1)")
	public static WebElement ddlCreateByRoleFilter;

	// select create by filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(17)>td>select>option:nth-of-type(1)")
	public static WebElement ddlCreateByFilter;

	// select category filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(19)>td>select>option:nth-of-type(1)")
	public static WebElement ddlCategoryFilter;

	// select sub category filter text box ,with default selected value
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(21)>td>select>option:nth-of-type(1)")
	public static WebElement ddlSubCategoryFilter;

	// select ticket type filter
	@FindBy(name = "m_strIncidentType")
	public static WebElement ddlTicketType;

	// select state filter
	@FindBy(name = "m_strStateFilter")
	public static WebElement ddlState;

	// select state filter
	@FindBy(name = "m_strStatusFilter")
	public static WebElement ddlStatusFilterName;

	// select state filter
	@FindBy(name = "m_strCustomerName")
	public static WebElement ddlCustomer;

	// VIEW TICKET PAGE //

	// select Search ID
	@FindBy(name = "m_strSearchIncId")
	public static WebElement txtSearchId;

	// select GO button of ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
	public static WebElement btnIDGo;

	// select Search asset ID
	@FindBy(name = "m_strSearchAssetId")
	public static WebElement txtSearchAssetID;

	// select GO button of asset ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
	public static WebElement btnAssetIDGo;

	// select Search Ticket ID
	@FindBy(name = "m_strSearchTicketId")
	public static WebElement txtSearchTicketID;

	// select GO button of ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
	public static WebElement btnTicketIDGo;

	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
	public static List<WebElement> lstIDInTable;

	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)")
	public static List<WebElement> lstStatusInTable;

	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)>a")
	public static List<WebElement> lstCustomerInTable;

	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(12)>img")
	public static List<WebElement> lstIncorrectAddressInTable;

	// select list of Serial Number from table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[10]")
	public static List<WebElement> lstSerialNumberInTable;

	// Selected tab
	@FindBy(xpath = ".//*[@id='form']/div[2]/ul/li[contains(@class,'active')]")
	public static WebElement tabSelected;

	// Title of All Tab Details Page
	@FindBy(css = ".modal-content>div>span")
	public static WebElement lblTitleAllTabDetailsPage;

	// Requester / Incident Tab //

	// Requester Tab //

	// Click on Incorrect Address Link
	@FindBy(css = ".incorrect-address")
	public static WebElement lnkIncorrectAddress;

	// Select Requester Tab for Open
	@FindBy(css = "div[id='Requestor']>div>div[style='border: 1px solid #b7b7b7']>div[class='rectagleBox marBot10']>span>a[id='open']")
	public static WebElement tabRequestorForOpenInRequesterTab;

	// Select Requester Tab for Close
	@FindBy(css = "div[id='Requestor']>div>div[style='border: 1px solid #b7b7b7']>div[class='rectagleBox marBot10']>span>a[id='close']")
	public static WebElement tabRequestorForCloseInRequesterTab;

	// Get Customer Address in Requester Table After Entering address
	@FindBy(css = ".rectagleBox.marBot10>div[class='toggle1']>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(9)>td")
	public static WebElement lblCustomerAddressInRequesterTab;

	// Get Serial No in Requester Table
	@FindBy(css = ".rectagleBox.marBot10>div[class='toggle1']>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(3)>td>strong>span>a")
	public static WebElement lblSerialNoInRequesterTab;

	// Get Customer Name in Requester Tab
	@FindBy(css = ".rectagleBoxHeading.aa>a[id='open']>table>tbody>tr>td:nth-of-type(2)>span")
	public static WebElement lblCustomerNameInRequesterTab;

	// Heading in Incident History Page
	@FindBy(css = "div[id='headingText']>table>tbody>tr>td>span")
	public static WebElement lblHeadingIncidentHistoryPage;

	// Asset Id in Requester Tab
	@FindBy(css = ".rectagleBoxHeading.aa>a[id='open']>table>tbody>tr>td:nth-of-type(3)>span")
	public static WebElement lblAssetIdInRequesterTab;

	// Incident details Tab //

	// Edit Button in Incident details Tab
	@FindBy(css = "div[id='Requestor']>div>div:nth-of-type(3)>div[class='pad10']>a")
	public static WebElement btnEditInIncidentDetailsTab;

	// Ticket Details Pop up //

	// Title of Ticket Details Pop up
	@FindBy(css = ".modal-content>div>span")
	public static WebElement lblTitleTicketDetailsPopup;

	// Drop Down Ticket Type in Ticket Details Pop up
	@FindBy(css = "select[name='m_strIncidentType']")
	public static WebElement ddlTicketTypeInTicketDetailsPopup;

	// Drop Down Mode in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td>select")
	public static WebElement ddlModeInTicketDetailsPopup;

	// Drop Down Level in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td>select")
	public static WebElement ddlLevelInTicketDetailsPopup;

	// Drop Down CTS in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(8)>td>select")
	public static WebElement ddlCTSInTicketDetailsPopup;

	// Drop Down Impact in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td>select")
	public static WebElement ddlImpactInTicketDetailsPopup;

	// Drop Down Urgency in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(4)>td>select")
	public static WebElement ddlUrgencyInTicketDetailsPopup;

	// Drop Down Trouble Category in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(6)>td>select")
	public static WebElement ddlTroubleCategoryInTicketDetailsPopup;

	// Drop Down Trouble Sub-Category in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(8)>td>select")
	public static WebElement ddlTroubleSubCategoryInTicketDetailsPopup;

	// Text box Amount in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(10)>td>input")
	public static WebElement txtAmountInTicketDetailsPopup;

	// Text box Local Contact in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>td>input")
	public static WebElement txtLocalContactInTicketDetailsPopup;

	// Text box Local Contact No in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(4)>td>input")
	public static WebElement txtLocalContactNoInTicketDetailsPopup;

	// Text box Customer Email ID in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(6)>td>input")
	public static WebElement txtCustomerEmailIDInTicketDetailsPopup;

	// Text box Date in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)>div>input")
	public static WebElement txtDateInTicketDetailsPopup;

	// T Button of Date in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)>a")
	public static WebElement btnTodayDateInTicketDetailsPopup;

	// Calendar in Ticket Details Pop up
	@FindBy(xpath = ".//*[@id='fd-but-dp-10']/span[1]")
	public static WebElement calDateInTicketDetailsPopup;

	@FindBy(css = ".datePickerTable>tbody>tr>td")
	public static List<WebElement> dtpDateInTicketDetailsPopup;

	@FindBy(css = "#dp-10-prev-year-but")
	public static WebElement btnPrevoiusYearDateInTicketDetailsPopup;

	@FindBy(css = "#dp-10-prev-month-but")
	public static WebElement btnPrevoiusMonthDateInTicketDetailsPopup;

	@FindBy(css = "#dp-10-next-year-but")
	public static WebElement btnNextYearDateInTicketDetailsPopup;

	@FindBy(css = "#dp-10-next-month-but")
	public static WebElement btnNextMonthDateInTicketDetailsPopup;

	// Drop Down Hrs of Time in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(1)")
	public static WebElement ddlHrsOfTimeInTicketDetailsPopup;

	@FindBy(css = "select[name='m_strHugesIncidentTimeHour']>option[selected='selected']")
	public static WebElement selectedHrsOfTimeInTicketDetailsPopup;

	// Drop Down Min of Time in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)")
	public static WebElement ddlMinOfTimeInTicketDetailsPopup;

	@FindBy(css = "select[name='m_strHugesIncidentTimeMin']>option[selected='selected']")
	public static WebElement selectedMinOfTimeInTicketDetailsPopup;

	// Update Details button in Ticket Details Pop up
	@FindBy(css = ".modal-content>div>div>a:nth-of-type(1)")
	public static WebElement btnUpdateDetailsInTicketDetailsPopup;

	// Incident details Tab //

	// Label Incident type in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(6)>td")
	public static WebElement lblIncidentTypeInIncidentDetailsTab;

	// Label Mode in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(3)>td")
	public static WebElement lblModeInIncidentDetailsTab;

	// Label Level in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(4)>td")
	public static WebElement lblLevelInIncidentDetailsTab;

	// Label CTS in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(8)>td")
	public static WebElement lblCTSInIncidentDetailsTab;

	// Label Impact in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(5)>td")
	public static WebElement lblImpactInIncidentDetailsTab;

	// Label Urgency in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(7)>td")
	public static WebElement lblUrgencyInIncidentDetailsTab;

	// Label Trouble Category in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(1)>td")
	public static WebElement lblTroubleCategoryInIncidentDetailsTab;

	// Label Trouble Sub-Category in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>td")
	public static WebElement lblTroubleSubCategoryInIncidentDetailsTab;

	// Label Amount in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(3)>td")
	public static WebElement lblAmountInIncidentDetailsTab;

	// Label Local Contact in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public static WebElement lblLocalContactInIncidentDetailsTab;

	// Label Local Contact No in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public static WebElement lblLocalContactNoInIncidentDetailsTab;

	// Label Customer Email ID in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(3)")
	public static WebElement lblCustomerEmailIDInIncidentDetailsTab;

	// Label Date in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(5)>td")
	public static WebElement lblDateInIncidentDetailsTab;

	// Label Time in Incident details Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(3)>table>tbody>tr>td:nth-of-type(3)>table>tbody>tr:nth-of-type(6)>td")
	public static WebElement lblTimeInIncidentDetailsTab;

	// File Attachments Tab //

	// Drop Down File Type in File Attachments Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>table>tbody>tr>td:nth-of-type(3)>select")
	public static WebElement ddlFileTypeInFileAttachmentsTab;

	// Button Browse in File attachments Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>table>tbody>tr>td:nth-of-type(5)>input")
	public static WebElement btnBrowseInFileAttachmentsTab;

	// Button Upload File in File attachments Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>div:nth-of-type(2)>a:nth-of-type(1)")
	public static WebElement btnUploadFileInFileAttachmentsTab;

	// Button View Attachments in File attachments Tab
	@FindBy(css = ".rectagleBoxContent>div:nth-of-type(4)>div:nth-of-type(2)>a:nth-of-type(2)")
	public static WebElement btnViewAttachmentsInFileAttachmentsTab;

	// List Of Files Page //

	// Heading of List Of Files Page
	@FindBy(css = "div[id='headingText']>span")
	public static WebElement lblHeadingListOfFilesPage;

	// File Column in List Of Files Page
	@FindBy(css = ".rectagleBox>table>tbody>tr>td:nth-of-type(2)>a")
	public static List<WebElement> lstFileInListOfFilesPage;

	// Preliminary Analysis //

	// select Preliminary Analysis Tab
	@FindBy(css = "li[class='tab14']>a>span")
	public static WebElement tabPreliminaryAnalysis;

	// select Edit Button On Preliminary Analysis Tab
	@FindBy(css = "div[id='Preliminary-analysis']>div>div:nth-of-type(2)>a>span")
	public static WebElement btnEditOfPreliminaryAnalysis;

	// select the pop location in Technician window in preliminary analysis
	@FindBy(name = "m_strPoplocation")
	public static WebElement txtPoplocation;

	// select Technical Status
	@FindBy(name = "m_strPreliminaryStatus")
	public static WebElement ddlTechnicalStatus;
	
	// select Technical Status
	@FindBy(css = "div[id='incidentTypeDetails']>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td>img")
	public static WebElement btnTSD;
	
	@FindBy(css = "td[class='pad5']>a")
	public static List<WebElement> lstTechnician;
	
	@FindBy(name = "m_strTSDName")
	public static WebElement txtTSD;

	// select Technical Status
	@FindBy(name = "m_strPreliminaryObservations")
	public static WebElement txtObservation;

	// select Customer Name And Contact No Text Box
	@FindBy(name = "m_strCustNamePhone")
	public static WebElement txtCustomerName;
	
	@FindBy(css = "div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(1)")
	public static WebElement lblTSD;
	
	@FindBy(css = "div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(3)")
	public static WebElement lblTechnicalStatus;
	
	@FindBy(css = "div[id='Preliminary-analysis']>div>table>tbody>tr>td:nth-of-type(5)")
	public static WebElement lblObservation;

	// select Update Detail Button in TSD Assign Detail Window
	@FindBy(linkText = "Update Details")
	public static WebElement btnUpdateDetail;

	// select cancel Detail Button in TSD Assign Detail Window
	@FindBy(linkText = "Cancel")
	public static WebElement btnCancel;

	// ETA and Technician Tab //

	// ETA and Technician Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(3)>a")
	public static WebElement tabETAAndTechnician;

	// Technician in ETA and Technician Tab
	@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
	public static WebElement lblTechnicianInETAAndTechnicianTab;

	// ETA Date in ETA and Technician Tab
	@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(7)")
	public static WebElement lblETADateInETAAndTechnicianTab;

	// select ETA Time from ETA and Technician Tab before data enter
	@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(9)")
	public static WebElement lblETATimeInETAAndTechnicianTab;

	// Calendar in ETA Details Page
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
	public static WebElement calETADetailsPage;

	// Day in Calendar in ETA Details Page
	@FindBy(css = "div[id='fd-dp-8']>table>tbody>tr>td")
	public static List<WebElement> dtpCalendarInETADetailsPage;

	// ETA Date in ETA Details Page
	@FindBy(css = "input[name='m_strEtaDate']")
	public static WebElement txtETADateInETADetailsPage;

	// Hrs of ETA Time in ETA Details Page
	@FindBy(css = "[name='m_strETATimeHour']>option")
	public static List<WebElement> ddlHrsOfETATimeInETADetailsPage;

	// Min of ETA Time in ETA Details Page
	@FindBy(css = "[name='m_strETATimeMin']>option")
	public static List<WebElement> ddlMinOfETATimeInETADetailsPage;

	// ETA Technician tab

	// select ETA and Technician tab
	@FindBy(css = "li[class='tab4']>a>span")
	public static WebElement tabETATechnician;

	// select call Assign To Technician button
	@FindBy(linkText = "Call Assign To Technician")
	public static WebElement btnCallAssignToTechnician;

	// select call Assign To Technician button
	@FindBy(linkText = "Resend SMS")
	public static WebElement btnResendSMS;

	// select Technician Text Box of call assign to technician button
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)>input")
	public static WebElement txtTechnician;

	// select the first list of click on first list symbol of Technician Field
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[1]/table/tbody/tr[2]/td[2]/img")
	public static WebElement btnTechnicianList;

	// select technician from technician window
	@FindBy(css = "div[class='rectagleBox']>table>tbody>tr>td:nth-of-type(3)")
	public static List<WebElement> lstTechnicianName;

	// select ETA Date in Technician Assign And ETA Details Detail Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>input")
	public static WebElement txtETADate;

	// select ETA Date Calendar Button in Technician Assign And ETA Details
	// Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
	public static WebElement calETACalender;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)")
	public static WebElement txtETATimeMinute;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)>option")
	public static List<WebElement> ddlETATimeMinute;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)")
	public static WebElement txtETATimeSecond;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(2)>option")
	public static List<WebElement> ddlETATimeSecond;

	// select Appointment Date in Technician Assign And ETA Details Detail
	// Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(8)>td>div>input")
	public static WebElement txtAppointmentDate;

	// select Appointment Date calendar in Technician Assign And ETA Details
	// Detail Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(8)>td>div>a")
	public static WebElement btnAppointmentDate;

	// select Appointment Date in Technician Assign And ETA Details Detail
	// Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(10)>td>select")
	public static WebElement txtAppointmentTime;

	// select Appointment Date from ETA and Technician Tab before data enter
	@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
	public static WebElement lblAppointmentDate;

	// select Appointment time from ETA and Technician Tab before data enter
	@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
	public static WebElement lblAppointmentTime;

	// select Technician from ETA and Technician Tab before data enter
	@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
	public static WebElement lblTechnician;

	// select ETA Date from ETA and Technician Tab before data enter
	@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(7)")
	public static WebElement lblETADate;

	// select ETA Time from ETA and Technician Tab before data enter
	@FindBy(css = "div[class='tab_widget_content']>div:nth-of-type(1)>div:nth-of-type(3)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(9)")
	public static WebElement lblETATime;

	// select requester tab
	@FindBy(css = ".rectagleBoxHeading.aa>a[id='open']>table>tbody>tr")
	public static WebElement tabRequestor;

	// select Customer SLA
	@FindBy(css = "div[class='rectagleBoxContent']>div:nth-of-type(1)>div:nth-of-type(2)>div>div>table>tbody>tr>td:nth-of-type(4)>table>tbody>tr:nth-of-type(1)>td")
	public static WebElement tabCustomerSLA;

	@FindBy(css = "table[class='datePickerTable']>tbody>tr>td")
	public static List<WebElement> dtpInETACalender;

	// select ETA time in Technician Assign And ETA Details Window
	@FindBy(css = "div[id='incidentTypeDetails']>div:nth-of-type(1)>table>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>select:nth-of-type(1)>option")
	public static List<WebElement> ddlETATimeHour;

	// Select line element

	// select Ticket Log Time
	@FindBy(css = "div[id='time_spent']>div:nth-of-type(2)>span:nth-of-type(1)")
	public static WebElement lblTicketLogTime;

	// select ETA Date Time
	@FindBy(css = "div[id='time_spent']>div:nth-of-type(3)>span:nth-of-type(1)")
	public static WebElement lblETA;

	// ATA Tab //

	// ATA Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(4)>a")
	public static WebElement tabATA;

	// Edit Button in ATA Tab
	@FindBy(css = "img[src='images/close_success.gif']")
	public static WebElement btnCloseNotification;

	// Edit Button in ATA Tab
	@FindBy(css = "div[id='ATA']>div>div:nth-of-type(2)>a")
	public static WebElement btnEditInATATab;

	// ATA Date in ATA Tab
	@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
	public static WebElement lblATADateInATATab;

	// ATA Time in ATA Tab
	@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
	public static WebElement lblATATimeInATATab;

	// Machine Available in ATA Tab
	@FindBy(css = "div[id='ATA']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
	public static WebElement lblMachineAvailableInATATab;

	// ATA Details Page //

	// Calendar in ATA Details Page
	@FindBy(css = "div[id='incidentTypeDetails']>div>table>tbody>tr:nth-of-type(2)>td>a")
	public static WebElement calATADetailsPage;

	// Day in Calendar in ATA Details Page
	@FindBy(css = "div[id='fd-dp-8']>table>tbody>tr>td")
	public static List<WebElement> dtpCalendarInATADetailsPage;

	// ATA Date in ATA Details Page
	@FindBy(css = "input[id='dp-8']")
	public static WebElement txtATADateInATADetailsPage;

	// Hrs of ATA Time in ATA Details Page
	@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(1)>option")
	public static List<WebElement> ddlHrsOfATATimeInATADetailsPage;

	// Min of ATA Time in ATA Details Page
	@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)>option")
	public static List<WebElement> ddlMinOfATATimeInATADetailsPage;

	// Machine Available in ATA Details Page
	@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select")
	public static WebElement ddlMachineAvailableInATADetailsPage;

	// Pause Reason Button in ATA Details Page
	@FindBy(css = "a[onclick='selectPauseReason()']")
	public static WebElement btnPauseReasonInATADetailsPage;

	// Calendar for Auto Resume Date in ATA Details Page
	@FindBy(css = "a[id='fd-but-dp-4']")
	public static WebElement calAutoResumeDateInATADetailsPage;

	// Day in Calendar for Auto Resume Date in ATA Details Page
	@FindBy(css = "div[id='fd-dp-4']>table>tbody>tr>td")
	public static List<WebElement> dtpAutoResumeDateInATADetailsPage;

	// ATA Date for Auto Resume Date in ATA Details Page
	@FindBy(css = "input[id='dp-4']")
	public static WebElement txtATADateOfAutoResumeDateInATADetailsPage;

	// Hrs of ATA Time for Auto Resume Date in ATA Details Page
	@FindBy(css = "select[name='m_strResumeTimeHour']>option ")
	public static List<WebElement> ddlHrsOfATATimeOfAutoResumeDateInATADetailsPage;

	// Min of ATA Time for Auto Resume Date in ATA Details Page
	@FindBy(css = "select[name='m_strResumeTimeMinute']>option ")
	public static List<WebElement> ddlMinOfATATimeOfAutoResumeDateInATADetailsPage;

	// Update Details Button in ATA Details Page
	@FindBy(linkText = "Update Details")
	public static WebElement btnUpdateDetailsInATADetailsPage;

	// List of Pause Reasons Page //

	// List of Name in List of Pause Reasons Page
	@FindBy(css = "div[id='right']>div>table>tbody>tr>td:nth-of-type(2)>a")
	public static List<WebElement> lstListOfPauseReasonsPage;

	// Pause Tab //

	// Pause Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(6)>a")
	public static WebElement tabPauseInTicketForm;

	// Edit Button in Pause Tab
	@FindBy(css = "div[id='Pause']>div:nth-of-type(2)>a")
	public static WebElement btnEditInPauseTab;

	// Pause Start Date Time in Pause Tab
	@FindBy(css = "div[id='Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(1)")
	public static WebElement lblPauseStartDateTimeInPauseTab;

	// Pause end Date Time in Pause Tab
	@FindBy(css = "div[id='Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(2)")
	public static WebElement lblPauseEndDateTimeInPauseTab;

	// Total Pause Time(minutes) in Pause Tab
	@FindBy(css = "div[id='Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
	public static WebElement lblTotalPauseMinutesInPauseTab;

	// Pause details Page //

	// Calendar in Pause Details Page
	@FindBy(css = "#incidentTypeDetails>div[class='pad10']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
	public static WebElement calPauseDetailsPage;

	// Day in Calendar in Pause Details Page
	@FindBy(css = ".datePickerTable>tbody>tr>td")
	public static List<WebElement> dtpCalendarInPauseDetailsPage;

	// Auto Resume Date in Pause Details Page
	@FindBy(css = "#incidentTypeDetails>div[class='pad10']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>input")
	public static WebElement txtAutoResumeDateInPauseDetailsPage;

	// Hrs of Auto Resume Time in Pause Details Page
	@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select:nth-of-type(1)>option")
	public static List<WebElement> ddlHrsOfAutoResumeTimeInPauseDetailsPage;

	// Min of Auto Resume Time in Pause Details Page
	@FindBy(css = ".modal-content>div>div>table>tbody>tr:nth-of-type(6)>td>select:nth-of-type(2)>option")
	public static List<WebElement> ddlMinOfAutoResumeTimeInPauseDetailsPage;

	// Update Details Button in Pause Details Page
	@FindBy(linkText = "Update Details")
	public static WebElement btnUpdateDetailsInPauseDetailsPage;

	// List of Pause Reasons Page //

	// List of Pause Reasons Button in Pause Page
	@FindBy(css = ".clickOn")
	public static WebElement btnListOfPauseReasonsInPausepage;

	// Heading of List of Pause Reasons Page
	@FindBy(css = "div[id='headingText']>span")
	public static WebElement lblHeadingListOfPauseReasonsPage;

	// Pause Reasons Column in List of Pause Reasons Page
	@FindBy(css = ".rectagleBox>table>tbody>tr>td:nth-of-type(2)>a")
	public static List<WebElement> lstPauseReasonsInListOfPauseReasonsPage;

	// Latest Pause Tab //

	// Latest Pause Tab
	@FindBy(linkText = "Latest Pause")
	public static WebElement tabLatestPauseInTicketForm;

	// Pause Reason Label
	@FindBy(css = "div[id='Latest-Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)")
	public static WebElement lblPauseReasonInLatestPauseTab;

	// Resume Date And Time in Latest Pause Tab
	@FindBy(css = "div[id='Latest-Pause']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(2)")
	public static WebElement lblResumeDateAndTimeInLatestPauseTab;

	// Spare Tab //

	// Spare Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(9)>a")
	public static WebElement tabSpareInTicketForm;

	// Edit Button in Spare Tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(2)>a")
	public static WebElement btnEditInSpareTab;

	// Part Name in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[4]")
	public static List<WebElement> lblPartNameInSpareTab;

	// Part code in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[5]")
	public static List<WebElement> lblPartCodeInSpareTab;

	// Quantity in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[7]")
	public static List<WebElement> lblQuantityInSpareTab;

	// Location in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[8]")
	public static List<WebElement> lblLocationInSpareTab;

	// Update symbol in Spare Tab
	@FindBy(css = "a[class='updateBtn']")
	public static List<WebElement> lstSymbolUpdateInSpareTab;

	// heading of Update Spare Remark Pop up
	@FindBy(xpath = ".//*[@id='boxsr']/div/table/tbody/tr[1]/th[2]")
	public static WebElement lblHeadingUpdateSpareRemarkPopup;

	// Text box of Spare Remark in Update Spare Remark Page
	@FindBy(css = "input[name='m_strRemark']")
	public static WebElement txtSpareRemarkInUpdateSpareRemarkPopup;

	// Update Button in Update Spare Remark Page
	@FindBy(css = "a[onclick='UpdateSpareRemark()']")
	public static WebElement btnUpdateInUpdateSpareRemarkPopup;

	// Spare Remark in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr/td[12]")
	public static List<WebElement> lblSpareRemarkInSpareTab;

	// Row of Table in Spare Tab
	@FindBy(xpath = ".//*[@id='sapredetailsdiv']/table/tbody/tr")
	public static List<WebElement> lstRowTableInSpareTab;

	// [With Inventory Module] //

	// Required Spare Tab in Spare Tab
	@FindBy(css = ".modal-content>div>div:nth-of-type(3)>span>a[id='open']")
	public static WebElement tabRequiredSpareInSpareTab;

	// Part Name DropDown in Required Spare Tab
	@FindBy(css = "Select[name='m_strReqPartName']")
	public static WebElement ddlPartNameInRequiredSpareTab;

	// Part Category DropDown in Required Spare Tab
	@FindBy(css = "Select[name='m_strReqPartCategory']")
	public static WebElement ddlPartCategoryInRequiredSpareTab;
	
	@FindBy(css = "Select[name='m_strAssetMake']")
	public static WebElement ddlAssetMakeInRequiredSpareTab;

	// List of Part Name DropDown in Required Spare Tab
	@FindBy(css = "Select[name='m_strReqPartName']>option")
	public static List<WebElement> lstddlPartNameInRequiredSpareTab;

	// Part Code DropDown in Required Spare Tab
	@FindBy(css = "select[name='m_strReqPartCode']")
	public static WebElement ddlPartCodeInRequiredSpareTab;

	// Quantity in Required Spare Tab
	@FindBy(css = "input[name='m_strReqPartQty']")
	public static WebElement txtQuantityInRequiredSpareTab;

	// List of Location DropDown in Required Spare Tab
	@FindBy(css = "select[name='m_strSpareDeliverylocation']")
	public static WebElement ddlLocationInRequiredSpareTab;

	// Add button in Required Spare Tab
	@FindBy(css = "a[id='AddRequired']")
	public static WebElement btnAddInRequiredSpareTab;

	// Remove button in Required Spare Tab
	@FindBy(css = "a[class='removeBtn']")
	public static List<WebElement> btnRemoveInRequiredSpareTab;

	// [Without Inventory Module] //

	// Title of Spare Details [Without Inventory Module] Page
	@FindBy(css = ".modal-content>div>div>span>a[id='open2']")
	public static WebElement lblTitleWithoutInventoryModule;

	// Required Spare Tab in Without Inventory Module
	@FindBy(css = ".modal-content>div>div>div:nth-of-type(2)>div:nth-of-type(1)>div>span>a[id='open1']")
	public static WebElement tabRequiredSpareInWithoutInventoryModule;

	// Part Name DropDown in Required Spare Tab in Without Inventory Module
	@FindBy(css = "select[name='m_strPartNameNew1']")
	public static WebElement ddlPartNameInRequiredSpareTabInWithoutInventoryModule;

	// List of Part Name DropDown in Required Spare Tab
	@FindBy(css = "select[name='m_strPartNameNew1']>option")
	public static List<WebElement> lstddlPartNameInRequiredSpareTabInWithoutInventoryModule;

	// Part Code DropDown in Required Spare Tab
	@FindBy(css = "select[name='m_strPartCodeNew1']")
	public static WebElement ddlPartCodeInRequiredSpareTabInWithoutInventoryModule;

	// Quantity in Required Spare Tab
	@FindBy(css = "input[name='m_strQuantity1']")
	public static WebElement txtQuantityInRequiredSpareTabInWithoutInventoryModule;

	// Part Description DropDown in Required Spare Tab
	@FindBy(css = "select[name='m_strPartDescription1']")
	public static WebElement ddlLocationInRequiredSpareTabInWithoutInventoryModule;

	// Add button in Required Spare Tab
	@FindBy(css = "a[id='AddRequired']")
	public static WebElement btnAddInRequiredSpareTabInWithoutInventoryModule;

	// Remove button in Required Spare Tab
	@FindBy(css = "a[class='removeBtn']")
	public static List<WebElement> lstbtnRemoveInRequiredSpareTabInWithoutInventoryModule;

	// Spare tab

	// select spare tab
	@FindBy(css = "li[class='tab9']>a>span")
	public static WebElement tabSpare;

	// select Spares Consumed By Inventory logistic
	@FindBy(name = "m_strSparesConsumed")
	public static WebElement ddlSparesConsumedInSpareTab;

	// margin tab for Add Spare in Spare detail window
	@FindBy(css = "div[id='Spares']>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>div[id='sparesLabel']>div")
	public static WebElement lblAddSpare;

	// margin tab for Add Spare in Spare detail window
	@FindBy(css = "div[id='Spares']>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>div[id='inventoryreplacedetails']>div")
	public static WebElement lblReplaceSpareWith;

	// select list symbol in spare detail window
	@FindBy(css = "div[id='Spares']>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(3)>img")
	public static WebElement btnSymbolOfSpareDetail;

	// select part name from list of available spare window
	@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(1)>a")
	public static List<WebElement> lstPartNameInSpareDetail;

	// select Product Classification from list of available spare window
	@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(3)")
	public static List<WebElement> lstProductClassificationInSpareDetail;

	// select Part Type from list of available spare window
	@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(8)")
	public static List<WebElement> lstPartTypeInSpareDetail;

	// select Transaction Type from list of available spare window
	@FindBy(css = "div[id='form']>div>table>tbody>tr>td:nth-of-type(9)")
	public static List<WebElement> lstTransactionTypeInSpareDetail;

	// select part name in Add Spare tab
	@FindBy(name = "m_strPartName")
	public static WebElement txtPartName;

	// select Product Classification in Add Spare tab
	@FindBy(name = "m_strProductClassification1")
	public static WebElement txtProductClassificationInAddSpare;

	// select part Description in Add Spare tab
	@FindBy(name = "m_strPartDescription")
	public static WebElement txtPartDescriptionInAddSpare;

	// select Product Classification in Replace Spare with tab
	@FindBy(name = "m_strReplaceProductClassification")
	public static WebElement txtProductClassificationInReplaceSpare;

	// select part Description in Replace Spare with tab
	@FindBy(name = "m_strReplacePartDescription")
	public static WebElement txtPartDescriptionInReplaceSpare;

	// select part code in Replace Spare with tab
	@FindBy(name = "m_strReplaceWith1")
	public static WebElement ddlPartCodeInReplaceSpare;

	// select another part code text tab
	@FindBy(css = "select[name='m_strReplacePartCode1']>option")
	public static List<WebElement> lstddlAnotherPartCodeInReplaceSpare;

	// select Replace with another part code
	@FindBy(name = "m_strReplacePartCode1")
	public static WebElement ddlAnotherPartCodeInReplaceSpare;

	// select part name in Add Spare tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(10)")
	public static WebElement lblTransactionTypeOfSapre;

	// select serial number in Add Spare tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(5)")
	public static WebElement lblSerialNumberOfSapre;

	// select list of serial number in Add Spare tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
	public static List<WebElement> lstSerialNumberOfSapre;

	// select list of serial number in Add Spare tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(10)")
	public static List<WebElement> lstTransactionTypeOfSapre;

	// select list of serial number in Add Spare tab
	@FindBy(css = "div[id='Spares']>div>div:nth-of-type(1)>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(11)")
	public static List<WebElement> lstStatusOfSapre;

	// select Replace with another part code
	@FindBy(name = "m_strReplaceStatus")
	public static WebElement ddlStatus;

	// Remark Tab //

	@FindBy(linkText = "Remarks")
	public static WebElement tabRemarkInTicketForm;

	@FindBy(linkText = "Add Remark")
	public static WebElement btnAddRemarkInRemarkTab;

	// Row in Remark Tab
	@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr")
	public static List<WebElement> lstRowTableInRemarkTab;

	// Remark in Remark Tab
	@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr/td[1]")
	public static List<WebElement> lstlblRemarkInRemarkTab;

	// Remark By in Remark Tab
	@FindBy(xpath = ".//*[@id='Remarks']/div[1]/table/tbody/tr/td[5]")
	public static List<WebElement> lstlblRemarkByInRemarkTab;

	// select the heading of add remark window
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
	public static WebElement lblAddRemark;

	// select remark text box
	@FindBy(css = "textarea[name='m_strRemarkValue']")
	public static WebElement txtRemark;

	@FindBy(name = "m_strVisibilty")
	public static WebElement ddlVisibility;

	// Activities tab

	// select Activities tab
	@FindBy(css = "li[class='tab11']>a>span")
	public static WebElement tabActivities;

	// select Add Remark button of activities Tab
	@FindBy(css = "div[id='Activities']>div:nth-of-type(2)>a>span")
	public static WebElement btnAddActivityOfActivities;

	// select Add Remark button of activities Tab
	@FindBy(xpath = ".//*[@id='boxActivity']/div/table/tbody/tr[1]/th[2]")
	public static WebElement lblAddActivityWindow;

	// select submit button
	@FindBy(linkText = "Submit")
	public static WebElement btnSubmit;

	// select Activity
	@FindBy(name = "m_strActivity")
	public static WebElement ddlActivity;

	// select Activity Status
	@FindBy(name = "m_strActivityStatus")
	public static WebElement ddlActivityStatus;

	// Select Details
	@FindBy(name = "m_strActivityDetail")
	public static WebElement txtActivityDetail;

	// select date from activities Tab
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[5]")
	public static List<WebElement> lstDateOfActivities;

	// select date from activities Tab
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[2]")
	public static List<WebElement> lstActivity;

	// select date from activities Tab
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[3]")
	public static List<WebElement> lstActivityStatus;

	// select date from activities Tab
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[4]")
	public static List<WebElement> lstActivityDetails;

	// select date from activities Tab
	@FindBy(xpath = ".//*[@id='Activities']/div[1]/table/tbody/tr/td[6]")
	public static List<WebElement> lstTimeOfActivities;

	// VCT Tab //

	// VCT Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(13)>a")
	public static WebElement tabVCTInTicketForm;

	// Heading of VCT Tab
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[1]")
	public static WebElement lblHeadingVCTTab;

	// Row in VCT Tab
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr")
	public static List<WebElement> lstRowTableInVCTTab;

	// button Create PO in VCT Tab
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/table/tbody/tr/td[1]/a/span")
	public static WebElement btnCreatePOInVCTTab;

	// button Show Email Log in VCT Tab
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/table/tbody/tr/td[2]/a/span")
	public static WebElement btnShowEmailLogInVCTTab;

	// PO No Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[1]")
	public static List<WebElement> lstlblPONOInPOTab;

	// PO Date Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[2]")
	public static List<WebElement> lstlblPODateInPOTab;

	// Service Charges Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[3]")
	public static List<WebElement> lblServiceChargesInPOTab;

	// Product Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[4]")
	public static List<WebElement> lstlblProductInPOTab;

	// Title Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[5]")
	public static List<WebElement> lstlblTitleInPOTab;

	// Category Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[6]")
	public static List<WebElement> lstlblCategoryInPOTab;

	// Description Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[7]")
	public static List<WebElement> lstlblDescriptionInPOTab;

	// Km Travelled Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[8]")
	public static List<WebElement> lstlblKmTravelledInPOTab;

	// Amount Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[9]")
	public static List<WebElement> lstlblAmountInVCTTab;

	// Vendor Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[10]")
	public static List<WebElement> lstlblVendorInPOTab;

	// Status Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[11]")
	public static List<WebElement> lstlblStatusInPOTab;

	// To Email Id Label
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[12]")
	public static List<WebElement> lstlblToEmailIdInPOTab;

	// Edit Link
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[13]")
	public static List<WebElement> lstlnkEditInPOTab;

	// Print Link
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[14]")
	public static List<WebElement> lstlnkPrintInPOTab;

	// Send Mail Link
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[1]/div[2]/div/table/tbody/tr/td[15]")
	public static List<WebElement> lstlnkSendMailInPOTab;

	// Vendor Commercial PO Details Pop up //

	// Heading of Vendor Commercial PO Details Pop up
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
	public static WebElement lblHeadingVendorCommercialPODetailsPopup;

	// PO No Text box
	@FindBy(css = "input[name='m_strCommercialPONO']")
	public static WebElement txtPONOInVCTTab;

	// PO Date Text box
	@FindBy(css = "input[id='dp-10']")
	public static WebElement txtPODateInVCTTab;

	// Service Charges Text box
	@FindBy(css = "input[name='m_strPoServiceCharges']")
	public static WebElement txtServiceChargesInVCTTab;

	// Product Text box
	@FindBy(css = "input[name='m_strPoProduct']")
	public static WebElement txtProductInVCTTab;

	// Title Text box
	@FindBy(css = "input[name='m_strPoTitle']")
	public static WebElement txtTitleInVCTTab;

	// Category Text box
	@FindBy(css = "input[name='m_strPoCategory']")
	public static WebElement txtCategoryInVCTTab;

	// Quantity Text box
	@FindBy(css = "input[name='m_strPOQuantity']")
	public static WebElement txtQuantityInVCTTab;

	// Description Text box
	@FindBy(css = "textarea[name='m_strPoDescription']")
	public static WebElement txtDescriptionInVCTTab;

	// Km Travelled Text box
	@FindBy(css = "input[name='m_strPoKmTravelled']")
	public static WebElement txtKmTravelledInVCTTab;

	// Vendor Drop down
	@FindBy(css = "select[name='m_strVendor']")
	public static WebElement ddlVendorInVCTTab;

	// Status Drop down
	@FindBy(css = "select[name='m_strPaymentStatus']")
	public static WebElement ddlStatusInVCTTab;

	// Rate Text box
	@FindBy(css = "input[name='m_strPORate']")
	public static WebElement txtRateInVCTTab;

	// Amount Text box
	@FindBy(css = "input[name='m_strCommercialAmount']")
	public static WebElement txtAmountInVCTTab;

	// To Email Id Text box
	@FindBy(css = "textarea[name='m_strPOToMailId']")
	public static WebElement txtToEmailIdInVCTTab;

	// button Submit in Vendor Commercial PO Details Pop up
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[2]/a[1]/span")
	public static WebElement btnSubmitInCommercialPODetailsPopup;

	// List of Sent Mails Page //

	// Row in List of Sent Mails Page
	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr")
	public static List<WebElement> lstRowTableInListOfSentMailsPage;

	// Send To Label
	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr/td[4]")
	public static List<WebElement> lstlblSendToListOfSentMailsPage;

	// VCT Tab

	// select VCT tab
	@FindBy(css = "li[class='tab12']>a>span")
	public static WebElement tabVCT;

	// select update payment button in VCT TAB
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[2]/table/tbody/tr/td/a/span")
	public static WebElement btnUpdatePayment;

	// select Invoice Number text box
	@FindBy(name = "m_strVendorCommercialInvNO")
	public static WebElement txtInvoiceNumber;

	// select amount text box
	@FindBy(name = "m_strVendorCommercialInvAmount")
	public static WebElement txtAmount;

	// select TSD Amount text box
	@FindBy(name = "m_strVendorCommercialTDSAmount")
	public static WebElement txtTSDAmount;

	// select Total Amount text box
	@FindBy(name = "m_strVendorCommercialTotalAmount")
	public static WebElement txtTotalAmount;

	// select Total Amount text box
	@FindBy(name = "m_strVendorCommercialInvReferenceCode")
	public static WebElement txtReferenceCode;

	// select Mode in update payment-> Vendor Commercial Payment Details window
	@FindBy(name = "m_strPaymentMode")
	public static WebElement ddlMode;

	// select Mode in update payment-> Vendor Commercial Payment Details window
	@FindBy(name = "m_strPaymentStatus")
	public static WebElement ddlStatusOfUpdatePayment;

	// Browse file button
	@FindBy(name = "m_strVendorCommercialPaymentFile")
	public static WebElement btnBrowseUpdatePayment;

	// select list of Edit in update payment
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr/td[8]/a/span")
	public static List<WebElement> lstEditInUpdatePayment;

	// select list Attachment In Update Payment
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr/td[9]/a/span")
	public static List<WebElement> lstAttachmentInUpdatePayment;

	// select list Attachment In Update Payment
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr/td[10]")
	public static List<WebElement> lstStatusInUpdatePayment;

	// take list of update payment detail whole row data
	@FindBy(xpath = ".//*[@id='Commercial-closed']/div[3]/table/tbody/tr")
	public static List<WebElement> lstCompleteDataInUpdatePayment;

	// take list of "List Of Attachment " window
	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr[2]/td[2]")
	public static List<WebElement> lstListOfAttachment;

	// select the submit button
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[2]/div/a[1]/span")
	public static WebElement btnSubmitAndUpdateDetailOfVendorCommercialPaymentDetails;

	// Technician Close Tab //

	// Technician Tab
	@FindBy(css = "a[title='Technician-close']")
	public static WebElement tabTechnicianClose;

	// select Spares Consumed By Inventory logistic
	@FindBy(name = "m_strSparesConsumed")
	public static WebElement ddlSparesConsumed;

	// select Edit Button On TechncianClose Tab
	@FindBy(css = "div[id='Technician-close']>div>div>a>span")
	public static WebElement btnEditOfTechncianClose;

	// submitTechCloseDetails button
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div/a[1]/span")
	public static WebElement btnSubmitTechCloseDetails;

	// Calendar in Technician Close Page
	@FindBy(css = "div[id='incidentTypeDetails']>table>tbody>tr>td:nth-of-type(1)>table>tbody>tr:nth-of-type(2)>td>a")
	public static WebElement calTechnicianClosePage;

	// Day in Calendar in Technician Close Page
	@FindBy(css = ".datePickerTable>tbody>tr>td")
	public static List<WebElement> dtpCalendarInTechnicianClosePage;

	// Hrs of Auto Resume Time in Technician Close Page
	@FindBy(css = "select[name='m_strTechcloseTimemHour']>option")
	public static List<WebElement> ddlHrsOfTechnicianCloseTime;

	// Min of Auto Resume Time in Technician Close Page
	@FindBy(css = "select[name='m_strTechcloseTimemMinute']>option")
	public static List<WebElement> ddlMinOfTechnicianCloseTime;

	// Enter Resolution
	@FindBy(name = "m_strResolution")
	public static WebElement txtResolutionInTechnicianClose;

	// Enter Resolution Description
	@FindBy(name = "m_strResolutionDescription")
	public static WebElement txtResolutionDescriptionInTechnicianClose;

	// Enter FSR No
	@FindBy(name = "m_strResolutionParameter7")
	public static WebElement txtFSRNoInTechnicianClose;

	// Technician close tab

	// serial number Message
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr/td[1]/table/tbody/tr[21]/td/strong")
	public static WebElement msgSerialNumber;

	// select serial number
	@FindBy(xpath = ".//*[@id='Technician-close']/div/div[2]/table/tbody/tr/td[1]/table/tbody/tr[9]/td")
	public static WebElement lblSerialNumber;

	// select generate PDF button
	@FindBy(xpath = ".//*[@id='headingText']/ul/li[3]/ul/a")
	public static WebElement btnGeneratePDF;

	// select serial number field
	@FindBy(name = "m_strResolutionParameter6")
	public static WebElement txtSerialNumberInTechClose;

	// select technician close time
	@FindBy(css = "div[id='final_close']>span:nth-of-type(1)")
	public static WebElement lblTechnicianCloseTime;

	// Cancel Ticket Tab

	// select cancel ticket tab
	@FindBy(css = "li[class='tab16']>a>span")
	public static WebElement tabCancelTicket;

	// select Cancel Ticket Tab
	@FindBy(css = "div[id='TicketCancel']>div:nth-of-type(2)>a>span")
	public static WebElement btnCancelTicket;

	// select Resolution text box
	@FindBy(name = "m_strCancelTicketResolution")
	public static WebElement txtResolution;

	// select Cancel Reason text box
	@FindBy(name = "m_strCancelTicketResolutionDescription")
	public static WebElement txtCancelReason;

	// select Cancel Ticket button of Cancel Ticket Details Window
	@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/div[2]/div/a[1]/span")
	public static WebElement btnCancelTicketInCancelTicketDetails;

	// select Cancel Ticket button of Cancel Ticket Details Window
	@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/div[2]/div/a[2]/span")
	public static WebElement btnCancelInCancelTicketDetails;

	// close button of the pop up window
	@FindBy(xpath = ".//*[@id='boxActivity']/div/table/tbody/tr[1]/th[3]/img")
	public static WebElement btnClosePopUp;

	// final close
	// select close button
	@FindBy(linkText = "Close")
	public static WebElement btnClose;

	// select Final Close Details window name
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
	public static WebElement lblFinalCloseDetailsWindow;

	// select close date text box
	@FindBy(name = "m_strCloseDate")
	public static WebElement txtCloseDate;

	// select close time hour
	@FindBy(name = "m_strCloseTimeHour")
	public static WebElement ddlCloseTimeHour;

	// select close time hour
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[4]/td/select[1]/option")
	public static List<WebElement> lstddlCloseTimeHourValue;

	// select close time hour
	@FindBy(name = "m_strCloseTimeMinute")
	public static WebElement ddlCloseTimeMinute;

	// select close time hour
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[4]/td/select[2]/option")
	public static List<WebElement> lstddlCloseTimeMinuteValue;

	// select close date calendar button
	@FindBy(css = "div[id='incidentTypeDetails']>table>tbody>tr:nth-of-type(2)>td>a")
	public static WebElement btnSymbolCloseDateCalender;

	// get the serial number from final close detail
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/table/tbody/tr[6]/td")
	public static WebElement txtSerialNumber;

	// select Update Serial No For this Asset: field
	@FindBy(name = "m_strCloseSerialNo")
	public static WebElement txtUpdateSerialNo;

	// KEDB Tab
	// Select KEDB Tab
	@FindBy(css = "li[class='tab15']>a>span")
	public static WebElement tabKEDB;

	// Select Add KEDB Tab
	@FindBy(css = "div[id='KEDB']>a>span")
	public static WebElement btnAddKEDB;

	// select KEDB Details window name
	@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/span")
	public static WebElement lblKEDBDetailsWindow;

	// select Known Error
	@FindBy(name = "m_strKnownError")
	public static WebElement txtKnownError;

	// select Work around details
	@FindBy(name = "m_strWorkAroundDetails")
	public static WebElement txtWorkArroundDetail;

	// select solution text box
	@FindBy(name = "m_strSolution")
	public static WebElement txtSolution;

	// select Add KEDB
	@FindBy(xpath = ".//*[@id='main']/div[10]/div[2]/div/div[2]/div/a[1]/span")
	public static WebElement btnAddKEDBInKEDBDetails;

	// CCT TAB

	// select CCT Tab
	@FindBy(css = "li[class='tab13']>a>span")
	public static WebElement tabCCT;

	// select create PI button
	@FindBy(xpath = ".//*[@id='Payment-closed']/div[1]/table/tbody/tr/td[1]/a/span")
	public static WebElement btnCreatePI;

	// select Customer Commercial Proforma Details window
	@FindBy(xpath = ".//*[@id='incidentTypeDetails']/span")
	public static WebElement lblCustomerCommercialProformaDetailsPopUp;

	// Create Sub Ticket
	// select CCT Tab
	@FindBy(linkText = "Create Sub Ticket")
	public static WebElement tabCreateSubTicket;

	@FindBy(linkText = "View Sub-Ticket")
	public static WebElement tabViewSubTicket;

	// heading of ticket form
	@FindBy(xpath = ".//*[@id='headingText']/span")
	public static WebElement lblHeading;

	// Select Record Ticket Button
	@FindBy(linkText = "Record Sub Ticket")
	public static WebElement btnRecordSubTicket;

	// select list of state in view sub ticket table
	@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(3)")
	public static List<WebElement> lstStateInViewSubTicketTable;

	// select list of status in view sub ticket table
	@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(6)")
	public static List<WebElement> lstStatusInViewSubTicketTable;

	// select list of status in view sub ticket table
	@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(26)")
	public static List<WebElement> lstTicketTypeInViewSubTicketTable;

	// select list of status in view sub ticket table
	@FindBy(css = "div[id='table_div']>table>tbody>tr>td:nth-of-type(1)")
	public static List<WebElement> lstCustomerInViewSubTicketTable;

	// select ETA in sub ticket
	@FindBy(css = "li[class='tab6']>a>span")
	public static WebElement tabETAInSubTicket;

	// select ATA in sub ticket
	@FindBy(css = "li[class='tab7']>a>span")
	public static WebElement tabATAInSubTicket;

	// select ATA in sub ticket
	@FindBy(css = "li[class='tab10']>a>span")
	public static WebElement tabTechnitianCloseInSubTicket;

	// select id in sub ticket
	@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr[2]/td[1]/div/table/tbody/tr")
	public static List<WebElement> lstIDInViewSubTicketTable;

	// select ParentTicketID in sub ticket
	@FindBy(css = ".borLftNone.padLftNone>span:nth-of-type(2)")
	public static WebElement lblParentTicketIDInSubTicket;

	@FindBy(css = "div.header-wrapper:nth-child(22) div.nav-wrapper div.nav ul.nav-ul li:nth-child(7) > a:nth-child(1)")
	public static WebElement tabTechnicianForLogout;

	@FindBy(css = "div[class='nav']>ul>li:nth-of-type(13)>a")
	public static WebElement tabSuperForLogout;

	@FindBy(css = "a[href='/erprmwise/Logout.do']")
	public static WebElement tabLogout;

	// select id in sub ticket
	@FindBy(xpath = ".//*[@id='right']/div/div/div[2]/table/tbody/tr/td[2]")
	public static List<WebElement> lstTicketTypeInSuper;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]")
	public static List<WebElement> lstTicketModeInSuper;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]")
	public static List<WebElement> lstTicketLevelInSuper;

	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr/td[2]")
	public static List<WebElement> lstCTSStatusInSuper;
	
	@FindBy(css = "select[name='m_strCategory']")
	public static WebElement ddlTicketCategoryInSuper;

	// select Ticket Type link
	@FindBy(xpath = ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[3]/div/div/ul/li[2]/div/div[1]/a[contains(text(),'Ticket Type')]")
	public static WebElement tabTicketType;

	@FindBy(css = "a[href='/erprmwise/IncidentModeAction.do']")
	public static WebElement tabTicketMode;

	// select Ticket Level Link
	@FindBy(css = "a[href='/erprmwise/IncidentLevelAction.do']")
	public static WebElement tabTicketLevel;

	@FindBy(css = "a[href='/erprmwise/CTSMaster.do']")
	public static WebElement tabCTSStatus;
	
	@FindBy(css = "a[href='/erprmwise/PauseReasonAction.do']")
	public static WebElement tabPauseReason;

	// select Business Unit master link
	@FindBy(xpath = ".//*[@id='main']/div[2]/div[2]/div/ul/li[3]/div/div/ul/li[8]/a")
	public static WebElement tabBusinessUnitMasterLink;

	// select Ticket Master link
	@FindBy(css = "li[class='subnav-children-wrapper mediumwidth']:nth-of-type(2)>a")
	public static WebElement tabTicketMasterLink;

	// select File Category link
	@FindBy(css = "div[class='nav']>ul>li:nth-of-type(3)>div>div>ul>li:nth-of-type(7)>a")
	public static WebElement tabFileCategoryLink;
	
	@FindBy(css = "a[href='/erprmwise/IncidentCategoryAction.do']")
	public static WebElement tabTicketCategoryMaster;
	
	

	// Initializing Page Object
	public ObjectPage() {
		PageFactory.initElements(driver, this);
	}

}
