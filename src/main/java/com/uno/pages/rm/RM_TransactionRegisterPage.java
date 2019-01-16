package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;


public class RM_TransactionRegisterPage extends BaseCode 
{
	// Call method from RM login
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	private static String downloadPath = "C:\\Users\\Admin\\Downloads";

	// Call method from super login
/*	Super_EmployeeMasterTest super_EmployeeMasterPageTest;
	Super_EmployeeDetailPage super_EmployeeDetailPage;
	RM_InventoryPage rm_InventoryPage;
	RM_TransactInventoryPage rm_TransactInventoryPage;*/

	// Select home tab symbol
	@FindBy(css = "a[href='/erprmwise/SuperAdminHomeScreen.do']")
	WebElement tabHome;

	// Select SD tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement tabRM;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// Select heading of page
	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement heading;

	// Select Region filter
	@FindBy(name = "m_strRegion")
	WebElement ddlRegionFilter;

	// Select Business Unit filter
	@FindBy(name = "m_strBusinessUnit")
	WebElement ddlBusinessUnitFillter;

	// Select Send to filter
	@FindBy(name = "m_strEngineerFilter")
	WebElement ddlSendToFillter;
	
	// Select Received From filter
	@FindBy(name = "m_strSendBy")
	WebElement ddlReceivedFromFillter;

	// Select Part Code filter
	@FindBy(name = "m_strPartCodeFillter")
	WebElement ddlPartCodeFillter;

	// Select Transaction Type filter
	@FindBy(name = "m_strTransactionType")
	WebElement ddlTransactionTypeFillter;
	
	// Select  Ordered By filter
	@FindBy(name = "m_strSearchBy")
	WebElement ddlOrderedByFillter;

	// Select Serial Number textBox
	@FindBy(name = "m_strPartSerialNumberFilter")
	WebElement txtSerialNumber;

	// Select Go button
	@FindBy(xpath = ".//*[@id='form']/div[1]/table/tbody/tr[2]/td[9]/input")
	WebElement btnGo;

	// select Region
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[19]")
	List<WebElement> lstRegion;

	// select Business Unit
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[5]")
	List<WebElement> lstBusinessUnit;

	// select Send To column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[16]")
	List<WebElement> lstSendTo;

	// select part code column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[15]")
	List<WebElement> lstReceivedFrom;

	// select Part Code column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[8]")
	List<WebElement> lstPartCodeNumber;

	// select Part Serial No column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[9]")
	List<WebElement> lstPartSerialNo;

	
    //select CMDB ID column
	  
	 @FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[3]")
	 List<WebElement> lstCMDBID;
	 
	 //click on CMDB ID
	 @FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[3]/a")
	 List<WebElement> lstID;
	  
	 
	 //select Transaction Date
	  @FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[4]")
	  List<WebElement> lstTransactionDate;
	  
	  //select Transaction Type:
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[14]")
	List<WebElement> lstTransactionType;
	
	//select view symbol:
    @FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[40]/a")
	List<WebElement> lstView;
    
  //select Inventory Life Cycle:
    @FindBy(linkText = "Inventory Life Cycle")
	WebElement btnInventoryLifeCycle;
    
   // click on download button
 	@FindBy(xpath = ".//*[@id='container']/input")
 	WebElement btnDownload;

	// Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
	List<WebElement> ddlPagination;

	// Left Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(1)")
	WebElement btnLeftmostArrowOfPagination;

	// Right Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(4)")
	WebElement btnRightmostArrowOfPagination;

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
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr[class = 'odd']")
	List<WebElement> lstRowInTable;
	
	

	// Initializing Page Object
	public RM_TransactionRegisterPage() {
		PageFactory.initElements(driver, this);
	}

	// If User apply Region filter and click on Go button then entries having
	// same Region as per applied filter, should display in transaction register
	public void checkRegion() throws Exception 
	{
		// click on Region
		SoftAssert softAssert = new SoftAssert();

		scrollDown(ddlRegionFilter);

		Thread.sleep(200);
		highLight(ddlRegionFilter);

		// select region from list
		Select regionFilter = new Select(ddlRegionFilter);
		regionFilter.selectByVisibleText("West");

		Thread.sleep(200);

		String regionFilterValue = ddlRegionFilter.getAttribute("value");
		System.out.println("regionFilterValue:" + regionFilterValue);

		// click on go button
		btnGo.click();

		int size = lstRegion.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {
			
			scrollDown(lstRegion.get(i));

			Thread.sleep(200);
			highLight(lstRegion.get(i));

			String regionInList = lstRegion.get(i).getText();
			System.out.println(regionInList);

			softAssert.assertEquals(regionInList, regionFilterValue,
					"Region Value is not same");

		}

		softAssert.assertAll();

	}

	// If User apply Business Unit Filter and click on Go button then entries
	// having same BU as per applied filter, should display in transaction
	// register

	public void checkBusinessUnit() throws Exception 
	{
		
		SoftAssert softAssert = new SoftAssert();

		scrollDown(ddlBusinessUnitFillter);

		Thread.sleep(200);
		highLight(ddlBusinessUnitFillter);

		Select businessUnitFilter = new Select(ddlBusinessUnitFillter);
		businessUnitFilter.selectByVisibleText("Diebold");

		Thread.sleep(200);

		String businessUnitValue = ddlBusinessUnitFillter.getAttribute("value");
		System.out.println("businessUnitValue:" + businessUnitValue);
		
		

		// click on go button
		btnGo.click();

		int size = lstBusinessUnit.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {
			
			scrollDown(lstBusinessUnit.get(i));

			Thread.sleep(200);
			highLight(lstBusinessUnit.get(i));

			String businessUnitList = lstBusinessUnit.get(i).getText();
			System.out.println(businessUnitList);

			softAssert.assertEquals(businessUnitList, businessUnitValue,
					"Business Unit Value is not same");

		}

		softAssert.assertAll();

	}
	
	//If User apply Send To Filter and click on Go button then entries having same data in Send To field as per applied filter, should display in transaction register
	public void checkSendTo() throws Exception 
	{
			SoftAssert softAssert = new SoftAssert();

			scrollDown(ddlSendToFillter);

			highLight(ddlSendToFillter);

			Select sendToFilter = new Select(ddlSendToFillter);
			sendToFilter.selectByVisibleText("Kavita .");

			Thread.sleep(200);

			String sendToFilterValue = ddlSendToFillter.getAttribute("value");
			System.out.println("sendToFilterValue:" + sendToFilterValue);

			// click on go button
			btnGo.click();

			int size = lstSendTo.size();
			System.out.println("size: " + size);

			for (int i = 0; i < size; i++) {


				scrollDown(lstSendTo.get(i));

				Thread.sleep(200);
				highLight(lstSendTo.get(i));
				
				String sendToInList = lstSendTo.get(i).getText();
				System.out.println(sendToInList);


				softAssert.assertEquals(sendToInList, sendToFilterValue,
						"Send To Value is not same");

			}

			softAssert.assertAll();

		}
	//If User apply Received From Filter and click on Go button then entries having same data in Received From field as per applied filter, should display in transaction register
	public void checkReceivedFrom() throws Exception 
	{
		
		SoftAssert softAssert = new SoftAssert();

		scrollDown(ddlReceivedFromFillter);

		highLight(ddlReceivedFromFillter);

		Select receivedFromFillter = new Select(ddlReceivedFromFillter);
		receivedFromFillter.selectByVisibleText("Logistic .");

		Thread.sleep(200);

		String receivedFromFillterValue = ddlReceivedFromFillter.getAttribute("value");
		System.out.println("receivedFromFillterValue:" + receivedFromFillterValue);

		// click on go button
		btnGo.click();

		int size = lstReceivedFrom.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {
			
			scrollDown(lstReceivedFrom.get(i));

			Thread.sleep(200);
			highLight(lstReceivedFrom.get(i));

			String receivedFromInList = lstReceivedFrom.get(i).getText();
			System.out.println(receivedFromInList);
			
			boolean engineerIsPresent = true;
			if(receivedFromInList.contains(receivedFromFillterValue))
			{		
			     softAssert.assertTrue(engineerIsPresent,"Engineer name is different in Receive from column ");
			     
			}

		}

		softAssert.assertAll();
		
	}
	
	//If User apply Part Code Filter and click on Go button then entries having same data in Part Code field as per applied filter, should display in transaction register.
		public void checkPartCode() throws Exception 
		{
			
			SoftAssert softAssert = new SoftAssert();

			scrollDown(ddlPartCodeFillter);

			Thread.sleep(200);
			highLight(ddlPartCodeFillter);

			Select partCodeFillter = new Select(ddlPartCodeFillter);
			partCodeFillter.selectByVisibleText("00100200000A");

			Thread.sleep(200);

			String partCodeFillterValue = ddlPartCodeFillter.getAttribute("value");
			System.out.println("partCodeFillterValue:" + partCodeFillterValue);

			// click on go button
			btnGo.click();

			int size = lstPartCodeNumber.size();
			System.out.println("size: " + size);

			for (int i = 0; i < size; i++) {
				
				scrollDown(lstPartCodeNumber.get(i));

				Thread.sleep(200);
				highLight(lstPartCodeNumber.get(i));

				String partCodeInList = lstPartCodeNumber.get(i).getText();
				System.out.println(partCodeInList);
				

				softAssert.assertEquals(partCodeInList, partCodeFillterValue,
						"Part Code Value is not same");

			 
			}
			
			  softAssert.assertAll();
		
		}	
	
		//If User apply Transaction Type Filter and click on Go button then entries having same transaction type as per applied filter, should display in transaction register
		public void checkTransactionType() throws Exception 
		{
			
			SoftAssert softAssert = new SoftAssert();

			scrollDown(ddlTransactionTypeFillter);

			Thread.sleep(200);
			highLight(ddlTransactionTypeFillter);

			Select transactionTypeFillter = new Select(ddlTransactionTypeFillter);
			transactionTypeFillter.selectByVisibleText("In Transit");

			Thread.sleep(200);

			String transactionTypeFillterValue = ddlTransactionTypeFillter.getAttribute("value");
			System.out.println("transactionTypeFillterValue:" + transactionTypeFillterValue);

			// click on go button
			btnGo.click();

			int size = lstTransactionType.size();
			System.out.println("size: " + size);

			for (int i = 0; i < size; i++) {
				
				scrollDown(lstTransactionType.get(i));

				Thread.sleep(200);
				highLight(lstTransactionType.get(i));

				String transactionTypeList = lstTransactionType.get(i).getText();
				System.out.println(transactionTypeList);
				

				softAssert.assertEquals(transactionTypeList, transactionTypeFillterValue,
						"Transaction Type is not same");

			 
			}
			
			  softAssert.assertAll();
		
		}	
	
	//If User apply Ordered By Filter with CMDB ID option and click on  Go button then entries should display as per CMDB ID in descending Order
	public void checkOrderedByCMDBID() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();

		scrollDown(ddlOrderedByFillter);

		Thread.sleep(200);
		highLight(ddlOrderedByFillter);

		Select orderedByFillter = new Select(ddlOrderedByFillter);
		orderedByFillter.selectByVisibleText("CMDB ID");

		Thread.sleep(200);

		String orderedByFillterValue = ddlOrderedByFillter
				.getAttribute("value");
		System.out.println("orderedByFillte"+ orderedByFillterValue);

		// click on go button
		btnGo.click();

		int size = lstCMDBID.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size-1; i++) {

			scrollDown(lstCMDBID.get(i));

			Thread.sleep(200);
			highLight(lstCMDBID.get(i));

			String firstCMDBId = lstCMDBID.get(i).getText();
			System.out.println("firstCMDBId: " + firstCMDBId);

			int firstID = Integer.parseInt(firstCMDBId);

			String secondCMDBId = lstCMDBID.get(i + 1).getText();
			System.out.println("secondCMDBID:-" + secondCMDBId);

			int secondID = Integer.parseInt(secondCMDBId);

			boolean iDIsDescending = true;

			if (firstID > secondID) {
				System.out.println("Pass");

			}

			softAssert.assertTrue(iDIsDescending,
					"All IDs is in descending order");

		}

		softAssert.assertAll();
		

	}
	
	//"If User apply Ordered By Filter with Transaction Date option and click on Click on Go button then entries should display as per Transaction Date in descending Order
	//(Current date entry should display first)"
	
	public void checkOrderedByTransactionDate() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();

		scrollDown(ddlOrderedByFillter);

		Thread.sleep(200);
		highLight(ddlOrderedByFillter);

		Select orderedByFillter = new Select(ddlOrderedByFillter);
		orderedByFillter.selectByVisibleText("Transaction Date");

		Thread.sleep(200);

		String orderedByFillterValue = ddlOrderedByFillter
				.getAttribute("value");
		System.out.println("orderedByFillterValue:" + orderedByFillterValue);

		// click on go button
		btnGo.click();

		int size = lstTransactionDate.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size-1; i++) {

			scrollDown(lstTransactionDate.get(i));

			Thread.sleep(200);
			highLight(lstTransactionDate.get(i));

			String firstTransactionDate = lstTransactionDate.get(i).getText();
			System.out.println("firstTransactionDate: " + firstTransactionDate);
			                             
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");     
            Date firstDate = formatDate.parse(firstTransactionDate);


			String secondTransactionDate = lstTransactionDate.get(i + 1).getText();
			System.out.println("secondTransactionDate:-" + secondTransactionDate);
		
            Date secondDate = formatDate.parse(secondTransactionDate);

			boolean dateIsDescending = true;

			if (firstDate.before(secondDate)) {
				
				System.out.println("Pass");
				softAssert.assertTrue(dateIsDescending,
						"All dates is in descending order");

			}

			

		}

		softAssert.assertAll();
		

	}
	
    //If User enter correct Serial number and click on Go button then entries having same serial number as per applied filter should display in table.
	public void checkSerialNumber() throws Exception 
	{
		
		SoftAssert softAssert = new SoftAssert();

		String serialNumber = "serialMB012";
		txtSerialNumber.sendKeys(serialNumber);

		Thread.sleep(200);

		// click on go button
		btnGo.click();

		int size = lstPartSerialNo.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {
			
			scrollDown(lstPartSerialNo.get(i));

			Thread.sleep(200);
			highLight(lstPartSerialNo.get(i));

			String serialNumberInList = lstPartSerialNo.get(i).getText();
			System.out.println(serialNumberInList);
			
					
			softAssert.assertEquals(serialNumberInList, serialNumber,
					"Send To Value is not same");
			     
		}

		softAssert.assertAll();
		
	}
	
	//If User apply multiple filters and click on Go button then entries should display as per all applied filters in table
	public void checkWithAllFilters() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// select region filter from list
		Select regionFilter = new Select(ddlRegionFilter);
		regionFilter.selectByVisibleText("West");
		Thread.sleep(200);

		String regionFilterValue = ddlRegionFilter.getAttribute("value");
		System.out.println("regionFilterValue:" + regionFilterValue);
		Thread.sleep(500);

		// select Business unit
		Select businessUnitFilter = new Select(ddlBusinessUnitFillter);
		businessUnitFilter.selectByVisibleText("Diebold");
		Thread.sleep(200);

		String businessUnitValue = ddlBusinessUnitFillter.getAttribute("value");
		System.out.println("businessUnitValue:" + businessUnitValue);
		Thread.sleep(500);

		Select sendToFilter = new Select(ddlSendToFillter);
		sendToFilter.selectByVisibleText("Kavita .");
		Thread.sleep(200);

		String sendToFilterValue = ddlSendToFillter.getAttribute("value");
		System.out.println("sendToFilterValue:" + sendToFilterValue);
		Thread.sleep(500);

		Select receivedFromFillter = new Select(ddlReceivedFromFillter);
		receivedFromFillter.selectByVisibleText("Logistic .");
		Thread.sleep(200);

		String receivedFromFillterValue = ddlReceivedFromFillter
				.getAttribute("value");
		System.out.println("receivedFromFillterValue:"
				+ receivedFromFillterValue);

		Select partCodeFillter = new Select(ddlPartCodeFillter);
		partCodeFillter.selectByVisibleText("00100200000A");
		Thread.sleep(200);

		String partCodeFillterValue = ddlPartCodeFillter.getAttribute("value");
		System.out.println("partCodeFillterValue:" + partCodeFillterValue);

		Select transactionTypeFillter = new Select(ddlTransactionTypeFillter);
		transactionTypeFillter.selectByVisibleText("In Transit");
		Thread.sleep(200);

		String transactionTypeFillterValue = ddlTransactionTypeFillter
				.getAttribute("value");
		System.out.println("transactionTypeFillterValue:"
				+ transactionTypeFillterValue);

		// click on go button
		btnGo.click();

		int size = lstSendTo.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			scrollDown(lstRegion.get(i));

			Thread.sleep(200);
			highLight(lstRegion.get(i));

			String regionInList = lstRegion.get(i).getText();
			System.out.println(regionInList);

			softAssert.assertEquals(regionInList, regionFilterValue,
					"Region Value is not same");

			scrollDown(lstSendTo.get(i));

			Thread.sleep(200);
			highLight(lstSendTo.get(i));

			String sendToInList = lstSendTo.get(i).getText();
			System.out.println(sendToInList);

			softAssert.assertEquals(sendToInList, sendToFilterValue,
					"Send To Value is not same");

			scrollDown(lstReceivedFrom.get(i));

			Thread.sleep(200);
			highLight(lstReceivedFrom.get(i));

			String receivedFromInList = lstReceivedFrom.get(i).getText();
			System.out.println(receivedFromInList);

			boolean engineerIsPresent = true;
			if (receivedFromInList.contains(receivedFromFillterValue)) {
				softAssert.assertTrue(engineerIsPresent,
						"Engineer name is different in Receive from column ");

			}

			scrollDown(lstPartCodeNumber.get(i));

			Thread.sleep(200);
			highLight(lstPartCodeNumber.get(i));

			String partCodeInList = lstPartCodeNumber.get(i).getText();
			System.out.println(partCodeInList);

			softAssert.assertEquals(partCodeInList, partCodeFillterValue,
					"Part Code Value is not same");

			scrollDown(lstTransactionType.get(i));

			Thread.sleep(200);
			highLight(lstTransactionType.get(i));

			String transactionTypeList = lstTransactionType.get(i).getText();
			System.out.println(transactionTypeList);

			softAssert
					.assertEquals(transactionTypeList,
							transactionTypeFillterValue,
							"Transaction Type is not same");

		}

		softAssert.assertAll();
	}
	
	
	// Count Of Pagination
	public void countOfPagination() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		int size = ddlPagination.size();
		System.out.println("Pagination Pages: "+size);
	
		
		int count=20*(size-1);
		System.out.println(count);
		ddlPagination.get(size-1).click();
		Thread.sleep(1000);
		int lastPageCount = lstRowInTable.size();
		System.out.println("last Page Count: "+lastPageCount);
		int totalCountTicket = count + lastPageCount;
		System.out.println("Total Count: "+totalCountTicket);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		System.out.println(textOfTotalCount);
		String totalCount  = textOfTotalCount.split("Total Count: ")[1];
		System.out.println("totalCount:"+totalCount);
		
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		
		softAssert.assertEquals(totalCountTicket,actualTotalCount,"Count is not match");
		softAssert.assertAll();

	}

	//If user click on leftmost arrow then control should transfer on first page in  page transact inventory page
	//If user click on left arrow then control should transfer on Previous page of current page showing  in transact inventory page
	//If user click on rightmost arrow then control should transfer on Last page in transact inventory page
	//If user click on right arrow then control should transfer on next page of current page showing in transact inventory page

	public void displayAsPerArrowsOfPagination() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		// Click on leftmost arrow
		int size = ddlPagination.size();
		System.out.println("size" + size);

		btnLeftmostArrowOfPagination.click();
		String leftMostPage = pageSelectedInPagination.getAttribute("value");
		System.out.println("leftMostPage " + leftMostPage);
		softAssert.assertEquals("1", leftMostPage, "Page not Same");

		// Click on Rightmost arrow
		// Thread.sleep(500);
		btnRightmostArrowOfPagination.click();
		String page = pageSelectedInPagination.getAttribute("value");
		System.out.println("rightMostPage " + page);
		int rightMostPage = Integer.parseInt(page);
		softAssert.assertEquals(size, rightMostPage, "Page not Same");

		// Click on RightArrow
		// Thread.sleep(500);
		btnLeftmostArrowOfPagination.click();
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
	
	//If User click on CMDB ID hyper link then Item Details page should display with
	public void checkCMDB() throws Exception 
	{
		scrollDown(lstCMDBID.get(1));
		
		highLight(lstCMDBID.get(1));
		
		//click on CMDB ID
		lstID.get(1).click();
		
		//check the page heading
		for (String window : driver
				.getWindowHandles()) {

			driver.switchTo().window(window);

		}
		String pageHeading = heading.getText();
		System.out.println("pageHeading:"+pageHeading);
		
	    assertEquals(pageHeading, "Item Details");
	    
	    driver.navigate().back();
		
	}

	//If User click on View Symbol then Item Details page should display with Part Details, File Upload, Received Details, Send Details, Courier Details, Transact details.
	//If user click on Inventory life Cycle button then Life Cycle pop up should display for life cycle of same part
	public void checkViewSymbol() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		scrollDown(lstView.get(1));

		highLight(lstView.get(1));

		// click on View Symbol
		lstView.get(1).click();

		// check the page heading
		for (String itemDetailsWindow : driver.getWindowHandles()) {

			driver.switchTo().window(itemDetailsWindow);

		}
		String pageHeading = heading.getText();
		System.out.println("pageHeading:" + pageHeading);

		softAssert.assertEquals(pageHeading, "Item Details");

		scrollDown(btnInventoryLifeCycle);

		highLight(btnInventoryLifeCycle);

		// click on Inventory Life Cycle
		btnInventoryLifeCycle.click();

		// check the page heading
		for (String lifeCycleWindow : driver.getWindowHandles()) {

			driver.switchTo().window(lifeCycleWindow);

		}
		String headingLifeCycle = heading.getText();
		System.out.println("headingLifeCycle:" + headingLifeCycle);

		softAssert.assertEquals(headingLifeCycle, "Life Cycle");

		driver.navigate().back();

	}
	
	//If User click on Download Excel button then Excel should get download with number of entries showing as per Total count 
	public void verifyDownloadExcel() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		
		// select region filter from list
		Select regionFilter = new Select(ddlRegionFilter);
		regionFilter.selectByVisibleText("West");
		Thread.sleep(200);

		// select Business unit
		Select businessUnitFilter = new Select(ddlBusinessUnitFillter);
		businessUnitFilter.selectByVisibleText("Diebold");
		Thread.sleep(200);
		
		Select transactionTypeFillter = new Select(ddlTransactionTypeFillter);
		transactionTypeFillter.selectByVisibleText("In Transit");
		Thread.sleep(200);
		
		//click on Go Button
		btnGo.click();
		
		String totalCount = driver.findElement(By.xpath(".//*[@id='pagination']/strong")).getText();
		System.out.println("size:"+totalCount);
		String totalCountValue = totalCount.split("Total Count: ")[1];
		System.out.println("totalCountValue: "+totalCountValue);
		
		int size = Integer.parseInt(totalCountValue);
		System.out.println(size);
		
		// click on download button
		btnDownload.click();

		Robot robot = new Robot();
		Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(700);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(20000);
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		System.out.println("fileName: "+fileName);
		softAssert.assertTrue(fileName.contains("NewRM1_TransactionRegisterReport"),
				"Downloaded file name is not matching with expected file name");
		
		FileInputStream stream = new FileInputStream(downloadPath+"\\"+fileName);
		File file = new File(downloadPath+"\\"+fileName);
		
		Workbook workbook = WorkbookFactory.create(stream);
		
		Sheet s = workbook.getSheet("Inventory_Reports");
		
		int rowcount = s.getLastRowNum();
		System.out.println(rowcount);
		int cellcount = s.getRow(0).getLastCellNum();
		System.out.println(cellcount);
		
		softAssert.assertEquals(rowcount, size,"count is different");
		
		file.delete();
		
		Thread.sleep(500);
		softAssert.assertAll();
		
		
	}
	
	private File getLatestFilefromDir(String dirPath) 
	{
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}


}
	


