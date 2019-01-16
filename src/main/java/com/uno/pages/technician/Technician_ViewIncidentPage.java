package com.uno.pages.technician;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.test.sd.SD_ViewTicket2Test;

public class Technician_ViewIncidentPage extends BaseCode{
	
	
	// Select Technician tab for logout tab
	@FindBy(xpath = ".//*[@id='main']/div[3]/div[2]/div/ul/li[7]/a")
	WebElement tabTechnician;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement lnkLogOut;

	// Select Incident ID Text Box
	@FindBy(xpath = ".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]")
	WebElement txtIncidenID;

	// select Search Ticket
	@FindBy(css = "#open")
	WebElement tabSearchTicketOpen;

	// text box of id
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[2]/td[2]")
	WebElement textBoxId;
	
	// text box of Asset Id
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[2]/td[5]")
	WebElement textBoxAssetId;
	
	// text box of Ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[2]/td[8]")
	WebElement textBoxTicketID;
	
  
	// select Search Ticket
	@FindBy(css = "#close")
	WebElement tabSearchTicketClose;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;

	// select Search Ticket
	@FindBy(linkText = "Search Ticket")
	WebElement tabSearchTicket;

	// Select Id in Table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
	WebElement lblIdInTable;

	// list of Flag of Incorrect Customer Address
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(12)>img")
	List<WebElement> lstFlagOfIncorrectCustomerAddressInTable;

	// list of Blinking Notification in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>i")
	List<WebElement> lstBlinkingNotificationInTable;

	// list of ETA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)")
	List<WebElement> lstETADateInTable;

	// list of ATA Date in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)")
	List<WebElement> lstATADateInTable;

	// list of Paused Time in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(39)")
	List<WebElement> lstPausedTimeInTable;

	// list of Remark in View Ticket Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(53)")
	List<WebElement> lstRemarkInTable;

	// Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
	List<WebElement> ddlPagination;

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
	List<WebElement> lstRowInTable;
	
	// Pagination
		@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
		List<WebElement> dropdown_Pagination;



		// List of Row in Table
		@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
		List<WebElement> list_RowInTable;

	// Search Ticket Tab //

	// select Search ID
	@FindBy(name = "m_strSearchIncId")
	WebElement tabSearchId;

	// select GO button of ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
	WebElement btnGoOfId;

	// select Search asset ID
	@FindBy(name = "m_strSearchAssetId")
	WebElement tabAssetId;

	// select GO button of asset ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
	WebElement btnGoOfAssetId;

	// select Search Ticket ID
	@FindBy(name = "m_strSearchTicketId")
	WebElement tabTicketId;

	// select GO button of ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
	WebElement btnGoOfTicketId;
	
	// List Of Id in Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
	List<WebElement> lstRow;
	
	@FindBy(css = "#pagination>strong")
	WebElement lblcount;

	// Label in Incident Number
	@FindBy(css = ".roundBoxMdlBg.roundBoxMdlBg1>ul>li:nth-of-type(1)>span:nth-of-type(2)")
	WebElement lblIncidentNumber;

	// Label Date in Incident Date Time
	@FindBy(css = ".roundBoxMdlBg.roundBoxMdlBg1>ul>li:nth-of-type(2)>span")
	WebElement lblDateInIncidentDateTime;

	// select filter
	@FindBy(linkText = "Filter")
	WebElement tabFilter;

	// select state filter text box ,with default selected value
	@FindBy(css = "select[name='m_strStatusFilter']>option:nth-of-type(1)")
	WebElement ddlStateFilter;

	// select status filter text box ,with default selected value
	@FindBy(css = "select[name='m_strStatusFilter']>option:nth-of-type(1)")
	WebElement ddlStatusFilter;

	// select ticket type filter text box ,with default selected value
	@FindBy(css = "select[name='m_strIncidentType']>option:nth-of-type(1)")
	WebElement ddlTicketTypeFilter;

	// select CTS filter text box ,with default selected value
	@FindBy(css = "select[name='m_strMTS']>option:nth-of-type(1)")
	WebElement ddlCTSFilter;
	
	// select customer filter text box ,with default selected value
	@FindBy(css = "select[name='m_strCustomerName']>option:nth-of-type(1)")
	WebElement ddlCustomerNameFilter;
	
	// select engineer filter text box ,with default selected value
	@FindBy(css = "select[name='m_strEngineer']>option:nth-of-type(1)")
	WebElement ddlEnginnerFilter;
	
	// select create by role filter text box ,with default selected value
	@FindBy(css = "select[name='m_strFilterCreatedByRole']>option:nth-of-type(1)")
	WebElement ddlCreateByRoleFilter;
	
	// select create by filter text box ,with default selected value
	@FindBy(css = "select[name='m_strFilterCreatedBy']>option:nth-of-type(1)")
	WebElement ddlCreateByFilter;
	
	// select category filter text box ,with default selected value
	@FindBy(css = "select[name='m_strProductCategory']>option:nth-of-type(1)")
	WebElement ddlCategoryFilter;

	// select sub category filter text box ,with default selected value
	@FindBy(css = "select[name='m_strProductSubCategory']>option:nth-of-type(1)")
	WebElement ddlSubCategoryFilter;
	
	// select CTS filter text box ,with default selected value
	@FindBy(css = "select[name='m_strMTS']")
	WebElement ddlCTS;

	// select engineer filter text box
	@FindBy(name = "m_strEngineer")
	WebElement ddlEngineer;

	// select create by role filter text box ,with default selected value
	@FindBy(css = "select[name='m_strFilterCreatedByRole']")
	WebElement ddlCreateByRole;

	// select create by filter text box ,with default selected value
	@FindBy(css = "select[name='m_strFilterCreatedBy']")
	WebElement ddlCreateBy;

	// select category filter text box ,with default selected value
	@FindBy(css = "select[name='m_strProductCategory']")
	WebElement ddlCategory;

	// select sub category filter text box ,with default selected value
	@FindBy(css = "select[name='m_strProductSubCategory']")
	WebElement ddlSubCategory;

	// select ticket type filter
	@FindBy(name = "m_strIncidentType")
	WebElement ddlTicketType;

	// select state filter
	@FindBy(name = "m_strStateFilter")
	WebElement ddlState;

	// select state filter
	@FindBy(name = "m_strStatusFilter")
	WebElement ddlStatusFilterName;

	// select state filter
	@FindBy(name = "m_strCustomerName")
	WebElement ddlCustomer;

	// select Assign filter text box
	@FindBy(css = "select[name='m_strAssignFilter']")
	WebElement ddlAssign;

	// VIEW TICKET PAGE //

	// select Search ID
	@FindBy(name = "m_strSearchIncId")
	WebElement txtSearchId;

	// select GO button of ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[2]/img")
	WebElement btnIDGo;

	// select Search asset ID
	@FindBy(name = "m_strSearchAssetId")
	WebElement txtSearchAssetID;

	// select GO button of asset ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[4]/img")
	WebElement btnAssetIDGo;

	// select Search Ticket ID
	@FindBy(name = "m_strSearchTicketId")
	WebElement txtSearchTicketID;

	// select GO button of ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[3]/td[6]/img")
	WebElement btnTicketIDGo;

	// Select list of Id in Table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/span/a")
	List<WebElement> lstIDInTable;

	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)")
	List<WebElement> lstStatusInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(11)")
	List<WebElement> lstTicketTypeInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(22)")
	List<WebElement> lstCTSInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)>a")
	List<WebElement> lstCustomerInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(26)>span")
	List<WebElement> lstEngineerInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(52)")
	List<WebElement> lstCreatedByRoleInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(51)")
	List<WebElement> lstCreatedByInTable;
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(62)")
	List<WebElement> lstCategoryInTable;	
	
	// select list of status in table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(63)")
	List<WebElement> lstSubCategoryInTable;

	// select list of Serial Number from table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[10]")
	List<WebElement> lstSerialNumberInTable;
	
	@FindBy(linkText = "Ticket")
	WebElement tab_Ticket;

	@FindBy(css = "a[href='/erprmwise/IncidentAction.do']")
	WebElement tab_CreateNew;

	@FindBy(xpath = "//a[@href='/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")
	WebElement tab_ViewTicket;

	

	// Initializing Page Object
	public Technician_ViewIncidentPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void varifySearchFieldsInSearchTicketTab() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(500);
		tabSearchTicketOpen.click();
		String id = textBoxId.getText();
		System.out.println("id: "+id);
		softAssert.assertEquals(id, "ID :","Text box label is not Same.");
		
		String assetId = textBoxAssetId.getText();
		System.out.println("assetId: "+assetId);
		softAssert.assertEquals(assetId, "Asset Id :","Text box label is not Same.");
		
		String ticketID = textBoxTicketID.getText();
		System.out.println("ticketID: "+ticketID);
		softAssert.assertEquals(ticketID, "Ticket ID :","Text box label is not Same.");
		
		softAssert.assertAll();
		
		
		
	}
	
	
	public void verifyIdTextBox(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabSearchTicketOpen.click();
		System.out.println("Input : "+data);
		txtSearchId.sendKeys(data);
		btnGoOfId.click();
		
		
			try {
				if(data.isEmpty())
				{
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					Thread.sleep(500);
					System.out.println("Alert Text:" + alertMessage);
					alert.accept();
					driver.switchTo().defaultContent();


					softAssert.assertEquals(alertMessage,
							"Please Enter Incident ID");
					System.out.println("Both the message is equal");
				}
				else
				{
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				Thread.sleep(500);
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
				}
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize==1)
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: 1","Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
			softAssert.assertAll();
	}
	
	public void verifyAssetIdTextBox(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabSearchTicketOpen.click();
		System.out.println("Input : "+data);
		txtSearchAssetID.sendKeys(data);
		btnGoOfAssetId.click();
		
		
			try {
				if(data.isEmpty())
				{
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					Thread.sleep(500);
					System.out.println("Alert Text:" + alertMessage);
					alert.accept();
					driver.switchTo().defaultContent();


					softAssert.assertEquals(alertMessage,
							"Please Enter Asset Id");
					System.out.println("Both the message is equal");
				}
				else
				{
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				Thread.sleep(500);
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
				}
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize>=1)
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: "+rowSize,"Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
			softAssert.assertAll();
	}
	
	public void verifyTicketIdTextBox(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabSearchTicketOpen.click();
		System.out.println("Input : "+data);
		txtSearchTicketID.sendKeys(data);
		btnGoOfTicketId.click();
		
		
			try {
				if(data.isEmpty())
				{
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					Thread.sleep(500);
					System.out.println("Alert Text:" + alertMessage);
					alert.accept();
					driver.switchTo().defaultContent();


					softAssert.assertEquals(alertMessage,
							"Please Enter Customer Ticket ID");
					System.out.println("Both the message is equal");
				}
				else
				{
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				Thread.sleep(500);
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
				}
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize>=1)
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: "+rowSize,"Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"  Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
			softAssert.assertAll();
	}
	
	
	
	

	
	public void verifyStatusDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select status= new Select(ddlStatusFilterName);
		Thread.sleep(1000);
		String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(dataWithoutSpaces);
		System.out.println("Input : "+dataWithoutSpaces);
		
		int size =lstStatusInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstStatusInTable.get(i));
			highLight(lstStatusInTable.get(i));
			String statusValue=lstStatusInTable.get(i).getText();
			System.out.println("StatusValue: "+statusValue);
			softAssert.assertEquals(statusValue, dataWithoutSpaces,"Status value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyTicketTypeDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select status= new Select(ddlTicketType);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstTicketTypeInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstTicketTypeInTable.get(i));
			highLight(lstTicketTypeInTable.get(i));
			String ticketType=lstTicketTypeInTable.get(i).getText();
			System.out.println("ticketType: "+ticketType);
			softAssert.assertEquals(ticketType, data,"Ticket Type value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyCTSDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select status= new Select(ddlCTS);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstCTSInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCTSInTable.get(i));
			highLight(lstCTSInTable.get(i));
			String cts=lstCTSInTable.get(i).getText();
			System.out.println("cts: "+cts);
			softAssert.assertEquals(cts, data,"CTS value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyCustomerDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select status= new Select(ddlCustomer);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstCustomerInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCustomerInTable.get(i));
			highLight(lstCustomerInTable.get(i));
			String customer=lstCustomerInTable.get(i).getText();
			System.out.println("customer: "+customer);
			softAssert.assertEquals(customer, data,"Customer value is not Same.");
		}
			softAssert.assertAll();
	}

	public void verifyEngineerDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select status= new Select(ddlEngineer);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstEngineerInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstEngineerInTable.get(i));
			highLight(lstEngineerInTable.get(i));
			String engineer=lstEngineerInTable.get(i).getText();
			String engineerSplit =engineer.split(" ")[0];
			System.out.println("engineer: "+engineerSplit);
			String dot=".";
			softAssert.assertEquals(engineerSplit+" "+dot, data,"Engineer value is not Same.");
		}
			softAssert.assertAll();
	}

	public void verifyCreatedByRoleDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select status= new Select(ddlCreateByRole);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstCreatedByRoleInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCreatedByRoleInTable.get(i));
			highLight(lstCreatedByRoleInTable.get(i));
			String createdByRole=lstCreatedByRoleInTable.get(i).getText();
			
			System.out.println("createdByRole: "+createdByRole);
			softAssert.assertEquals(createdByRole, data,"Created By Role value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyCreatedByDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select createBy= new Select(ddlCreateBy);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		createBy.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstCreatedByInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCreatedByInTable.get(i));
			highLight(lstCreatedByInTable.get(i));
			String createdBy=lstCreatedByInTable.get(i).getText();
			System.out.println("createdBy: "+createdBy);
			
			String dataSplit =data.split(" ")[0];
			System.out.println("createdBy: "+dataSplit);
			softAssert.assertEquals(createdBy, dataSplit,"Created By value is not Same.");
			
		}
			softAssert.assertAll();
	}
	
	public void verifyCategoryDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select category= new Select(ddlCategory);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		category.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstCategoryInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCategoryInTable.get(i));
			highLight(lstCategoryInTable.get(i));
			String categoryValue=lstCategoryInTable.get(i).getText();
			System.out.println("categoryValue: "+categoryValue);
			
			softAssert.assertEquals(categoryValue, data,"Category value is not Same.");
			
		}
			softAssert.assertAll();
	}


	public void verifySubCategoryDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabFilter.click();
		Select subCategory= new Select(ddlSubCategory);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		subCategory.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		int size =lstSubCategoryInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstSubCategoryInTable.get(i));
			highLight(lstSubCategoryInTable.get(i));
			String subCategoryValue=lstSubCategoryInTable.get(i).getText();
			System.out.println("subCategoryValue: "+subCategoryValue);
			
			softAssert.assertEquals(subCategoryValue, data,"Sub Category value is not Same.");
			
		}
			softAssert.assertAll();
	}


	// In view ticket page, if user click on Filter button then pop up
	// should display to filter view incident page. By default All option should
	// display in all filters
	public void checkDefaultOptionOfFilterTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(500);
		// click on filter tab
		tabFilter.click();

		// get the text from state filter which is already selected
		String stateFilter = ddlStateFilter.getText();
		System.out.println("selected state:-" + stateFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(stateFilter, "All");

		// Thread.sleep(1000);
		// get the text from status filter which is already selected
		String statusFilter = ddlStatusFilter.getText();
		System.out.println("selected Status:-" + statusFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(statusFilter, "All");

		// Thread.sleep(1000);
		// get the text from Ticket Type filter which is already selected
		String ticketTypeFilter = ddlTicketTypeFilter.getText();
		System.out.println("selected Ticket Type:-" + ticketTypeFilter);

		
		// if value is equal All the test case is pass
		softAssert.assertEquals(ticketTypeFilter, "All");

		// Thread.sleep(1000);
		String ctsFilter = ddlCTSFilter.getText();
		System.out.println("selected CTS:-" + ctsFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(ctsFilter, "All");

		// Thread.sleep(1000);
		String customerNameFilter = ddlCustomerNameFilter.getText();
		System.out.println("selected customer:-" + customerNameFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(customerNameFilter, "All");

		// Thread.sleep(1000);
		String enginnerFilter = ddlEnginnerFilter.getText();
		System.out.println("selected Engineer:-" + enginnerFilter);

		// Thread.sleep(1000);
		String createByRoleFilter = ddlCreateByRoleFilter.getText();
		System.out.println("selected Create By Role:-" + createByRoleFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(createByRoleFilter, "All");

		// Thread.sleep(1000);
		String createByFilter = ddlCreateByFilter.getText();
		System.out.println("selected Create By:-" + createByFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(createByFilter, "All");

		// Thread.sleep(1000);
		String categoryFilter = ddlCategoryFilter.getText();
		System.out.println("selected Category:-" + categoryFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(categoryFilter, "All");

		// Thread.sleep(1000);
		String subCategoryFilter = ddlSubCategoryFilter.getText();
		System.out.println("selected Sub Category:-" + subCategoryFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(subCategoryFilter, "All");
		// tab_Filter.click();
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
	
	// column headers should display as per selected in My View pop-up of View
		// ticket
		public void displayColumnHeader() throws Exception 
		{
			/*tab_Ticket.click();
			Thread.sleep(1000);
			tab_ViewTicket.click();
			Thread.sleep(1000);
			*/
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


}
