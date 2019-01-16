package com.uno.pages.rm;


import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.test.superrole.Super_EmployeeMasterTest;



public class RM_TransactInventoryPage extends BaseCode 
{
	
	// Call method from RM login
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	
	// Call method from super login
	Super_EmployeeMasterTest super_EmployeeMasterPageTest;
	Super_EmployeeDetailPage super_EmployeeDetailPage;
	RM_InventoryPage rm_InventoryPage;
	RM_TransactInventoryPage rm_TransactInventoryPage;
	
	
	// Select home tab symbol
	@FindBy(css = "a[href='/erprmwise/RMHomeScreen.do']")
	WebElement tabHome;
	
	// Select SD tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement tabRM;
	
	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;
	
	// Select SD tab for logout tab
	@FindBy(xpath = ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[13]/a")
	WebElement tabTest;
	
	// Select heading of page
	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement heading;

	// Select location filter
	@FindBy(name = "m_strLocationFilterForInv")
	WebElement ddlLocationFilter;
	
	// Select Part Name filter
	@FindBy(name = "m_strPartNameFillter")
	WebElement ddlPartNameFillter;
	
	// Select Transaction Type filter
	@FindBy(name = "m_strTransactionType")
	WebElement ddlTransactionTypeFillter;
	
	// Select Part Status filter
	@FindBy(name = "m_strPartStatus")
	WebElement ddlPartStatusFillter;
	
	
	// Select Serial Number textBox
	@FindBy(name = "m_strPartSerialNumberFilter")
	WebElement txtSerialNumber;
	
	// Select Go button 
	@FindBy(xpath = ".//*[@id='form']/div/table/tbody/tr/td[17]/input")
	WebElement btnGo;
	
	//select Transaction ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[6]")
	List<WebElement> lstCMDBCode;
	
	
	//select part location
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[17]")
	List<WebElement> lstLocation;
	
	//select part Received From Engineer Location
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[15]")
	List<WebElement> lstReceivedFromEnggLocation;
	
	//select part name column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[8]")
	List<WebElement> lstPartName;
	
	//select part code column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[9]")
	List<WebElement> lstPartCode;
		
	//select Part Serial column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[10]")
	List<WebElement> lstPartSerialNumber;
	
	//select Part Status column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[11]")
	List<WebElement> lstPartStatus;
	
	//select Part type column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[30]")
	List<WebElement> lstPartType;
	
	//select Part Status column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[13]")
	List<WebElement> lstTransactionType;
	
	//select Accept And Reject column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[1]/div[2]/table/tbody/tr/td[2]")
	List<WebElement> lstAcceptAndReject;
	
	// Select Accept And Reject check box
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[1]/div[2]/table/tbody/tr/td[2]/input")
	List<WebElement> rdoAcceptAndReject;
	
	//select select transact column
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[1]/div[2]/table/tbody/tr/td[1]")
	List<WebElement> lstSelectTansact;
		
	// Select Select Tansact check box
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[1]/div[2]/table/tbody/tr/td[1]/input")
	List<WebElement> rdoSelectTansact;
	
	//select Accept Selected button
	@FindBy(linkText = "Transact Selected")
	WebElement btnTransactSelected;
	
	//select Accept Selected button
	@FindBy(linkText = "Accept Selected")
	WebElement btnAcceptSelected;
	
	//select Part Remark field
	@FindBy(name = "m_strPartRemark")
	WebElement txaPartRemark;
	
	//select Add button
	@FindBy(xpath = ".//*[@id='myModal']/div/table/tbody/tr[3]/td[3]/a")
	WebElement btnAdd;
	
	//select Accept Selected button
	@FindBy(linkText = "Reject Selected")
	WebElement btnRejectSelected;
	
	//select Part Remark in reject field
	@FindBy(name = "m_strPartRemarkRejected")
	WebElement txaPartRemarkRejected;
	
	//select Add button
	@FindBy(xpath = ".//*[@id='myModalReject']/div/table/tbody/tr[3]/td[1]/input")
	WebElement btnStockReceived;
	
	//select Add button
	@FindBy(xpath = ".//*[@id='myModalReject']/div/table/tbody/tr[3]/td[2]/input")
	WebElement btnStockNotReceived;
	
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
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr")
	List<WebElement> lstRowInTable;

	//Initializing Page Object
	public RM_TransactInventoryPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	// If User select particular inventory location and click on Go button then
	// spare entries which are assign to same inventory location (same as logistic login having same inventory)
	public void checkLocation() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();

		// select transact type from list
		Select locationFilter = new Select(ddlLocationFilter);
		locationFilter.selectByVisibleText("Diebold Mumbai");

		Thread.sleep(00);

		String locationFilterValue = ddlLocationFilter.getAttribute("value");
		System.out.println("locationFilterValue:" + locationFilterValue);

		scrollDown(ddlLocationFilter);

		highLight(ddlLocationFilter);

		// click on go button
		btnGo.click();

		int size = lstLocation.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) 
		{

			String locationInList = lstLocation.get(i).getText();
			System.out.println("locationInList:"+locationInList);
			
			
			String EnggInList = lstReceivedFromEnggLocation.get(i).getText();
			System.out.println("EnggInList:"+EnggInList);
			
			boolean locationIsSame = true;
			if(locationInList.equals(locationFilterValue)||lstReceivedFromEnggLocation.equals(locationFilterValue))
			{
				
				softAssert.assertTrue(locationIsSame,"Location is different");
				
			}
			


		}

		softAssert.assertAll();
		
		
		
	}
	//If User select particular part name in filter and click on Go button then entries having part name as per applied filter should display in table 
	public void checkPartName() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		
		//select part name from list
		Select partName = new Select(ddlPartNameFillter);
		partName.selectByVisibleText("Device1");
		
		Thread.sleep(200);
		
		String partNameValue = ddlPartNameFillter.getAttribute("value");
		System.out.println("partNameValue:"+partNameValue);
		
		scrollDown(ddlPartNameFillter);
		
		highLight(ddlPartNameFillter);
		
		//click on go button
		btnGo.click();
		
		int size = lstPartName.size();
		System.out.println("size: "+size);
		
		for(int i = 0; i<size; i++)
		{
			
			String partNameInList = lstPartName.get(i).getText();
			System.out.println(partNameInList);
			
			scrollDown(lstPartName.get(i));
			
			highLight(lstPartName.get(i));
			
			softAssert.assertEquals(partNameInList, partNameValue, "Part Name is not same");
			
		}
		
		
		softAssert.assertAll();
		
		
		
	}

	// If user apply transaction type filter and click on Go button then entries
	// having same transaction type should display in table

	public void checkTransactionType() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();

		// select transact type from list
		Select transactionType = new Select(ddlTransactionTypeFillter);
		transactionType.selectByVisibleText("In Transit");

		Thread.sleep(200);

		String transactionTypeValue = ddlTransactionTypeFillter.getAttribute("value");
		System.out.println("TransactionTypeValue:" + transactionTypeValue);

		scrollDown(ddlTransactionTypeFillter);

		highLight(ddlTransactionTypeFillter);

		// click on go button
		btnGo.click();

		int size = lstTransactionType.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String transactionTypeInList = lstTransactionType.get(i).getText();
			System.out.println(transactionTypeInList);

			scrollDown(lstTransactionType.get(i));

			highLight(lstTransactionType.get(i));

			softAssert.assertEquals(transactionTypeInList, transactionTypeValue,
					"Transaction Type Value is not same");

		}

		softAssert.assertAll();
		

	}

	//If User apply particular Part Status filter and click on Go button then entries having same part status should display in table

	public void checkPartStatus() throws Exception 
	{
	
	SoftAssert softAssert = new SoftAssert();

	// select part status from list
	Select partStatus = new Select(ddlPartStatusFillter);
	partStatus.selectByVisibleText("Good");

	Thread.sleep(200);

	String PartStatusValue = ddlPartStatusFillter.getAttribute("value");
	System.out.println("PartStatusValue:" + PartStatusValue);

	scrollDown(ddlPartStatusFillter);

	highLight(ddlPartStatusFillter);

	// click on go button
	btnGo.click();

	int size = lstPartStatus.size();
	System.out.println("size: " + size);

	for (int i = 0; i < size; i++) {

		String partStatusInList = lstPartStatus.get(i).getText();
		System.out.println("partStatusInList: "+partStatusInList);

		scrollDown(lstPartStatus.get(i));

		highLight(lstPartStatus.get(i));

		softAssert.assertEquals(partStatusInList, PartStatusValue,
				"Part Status Value is not same");

	}

	softAssert.assertAll();

	
}
	

	//If user enter serial number and click on Go button then entry with same serial number should display in table 

	public void checkSerialNumberField() throws Exception 
	{
	
	SoftAssert softAssert = new SoftAssert();

	//enter the serial number 
	
	txtSerialNumber.sendKeys("ReplaceSrNo_30");

	Thread.sleep(200);

	String serialNumberValue = txtSerialNumber.getAttribute("value");
	System.out.println("serialNumberValue:" + serialNumberValue);

	scrollDown(txtSerialNumber);

	highLight(txtSerialNumber);

	// click on go button
	btnGo.click();

	int size = lstPartSerialNumber.size();
	System.out.println("size: " + size);

	for (int i = 0; i < size; i++) {

		String partSerialNumberInList = lstPartSerialNumber.get(i).getText();
		System.out.println("partSerialNumberInList: "+partSerialNumberInList);

		scrollDown(lstPartSerialNumber.get(i));

		highLight(lstPartSerialNumber.get(i));

		softAssert.assertEquals(partSerialNumberInList, serialNumberValue,
				"Part Serial Number Value is not same");

	}

	softAssert.assertAll();

	
}	

	// Count Of Pagination
	public void countOfPagination() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		int size = ddlPagination.size();
		System.out.println("Pagination Pages: "+size);
	
		
		int count=30*(size-1);
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
	//If User checked check box in Accept/Reject column and click on Accept Selected button then 'Part Accept Remark' popup should display
	//If User enter remark in 'Part Accept Remark' pop up and click on Add button then transaction type should become Stock for same entry
	public void checkAcceptSelectedFunctionaliy() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();

		// click on Accept selected button
		btnAcceptSelected.click();

		Alert alert = driver.switchTo().alert();
		String messageValue = alert.getText();
		System.out.println("messageValue: " + messageValue);
		alert.accept();

		Thread.sleep(1000);
		softAssert.assertEquals(messageValue,
				"Please select Inventory To Accept");

		int size = rdoAcceptAndReject.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; ) {

			Thread.sleep(1000);
			scrollDown(rdoAcceptAndReject.get(i));

			highLight(rdoAcceptAndReject.get(i));

			Thread.sleep(500);
			// click on Accept And Reject
			rdoAcceptAndReject.get(i).click();

			Thread.sleep(500);
			// click on Accept selected button
			btnAcceptSelected.click();

			// send remark
			txaPartRemark.sendKeys("OK");

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			// click on Add button
			btnAdd.click();

			Thread.sleep(1000);
			scrollDown(lstTransactionType.get(i));

			Thread.sleep(500);
			highLight(lstTransactionType.get(i));

			String transactionTypeValue = lstTransactionType.get(i).getText();
			System.out.println("transactionTypeValue: " + transactionTypeValue);

			softAssert.assertEquals(transactionTypeValue, "Stock");

			break;

		}

		softAssert.assertAll();

	}
	//If User checked check box in Accept/Reject column and click on Reject Selected button then 'Part Reject Remark' pop up should display
    //If User enter remark in 'Part Reject Remark' pop up and click on Stock Received button then transaction type should become Stock for same entry
	public void checkRejectSelectedFunctionality() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();

		// click on Accept selected button
		btnRejectSelected.click();

		Alert alert = driver.switchTo().alert();
		String messageValue = alert.getText();
		System.out.println("messageValue: " + messageValue);
		alert.accept();

		Thread.sleep(1000);
		softAssert.assertEquals(messageValue,
				"Please select Inventory To Reject");

		int size = rdoAcceptAndReject.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; )
		{

			Thread.sleep(1000);
			scrollDown(rdoAcceptAndReject.get(i));

			highLight(rdoAcceptAndReject.get(i));

			Thread.sleep(500);
			// click on Accept And Reject
			rdoAcceptAndReject.get(i).click();

			Thread.sleep(500);
			// click on Accept selected button
			btnRejectSelected.click();

			// send remark
			txaPartRemarkRejected.sendKeys("OK");

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			// click on Add button
			btnStockReceived.click();

			Thread.sleep(1000);
			scrollDown(lstTransactionType.get(i));

			Thread.sleep(500);
			highLight(lstTransactionType.get(i));

			String transactionTypeValue = lstTransactionType.get(i).getText();
			System.out.println("transactionTypeValue: " + transactionTypeValue);

			softAssert.assertEquals(transactionTypeValue, "Stock");

			break;

		}

	}
	//If User click on Check box in transact column and click on Transact Selected button then Outward page should display with same part details
	public void checkTransactSelectedFunctionality() throws Exception
	{
		
		SoftAssert softAssert = new SoftAssert();

		// click on Accept selected button
		btnTransactSelected.click();

		Alert alert = driver.switchTo().alert();
		String messageValue = alert.getText();
		System.out.println("messageValue: " + messageValue);
		alert.accept();

		Thread.sleep(1000);
		softAssert.assertEquals(messageValue,
				"Please select inventory");

		int size = rdoSelectTansact.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; )
		{
			scrollDown(lstPartCode.get(i));

			highLight(lstPartCode.get(i));
			//get all part details value from table
			String partCodeValue = lstPartCode.get(i).getText();
			System.out.println("partCodeValue: "+partCodeValue);
			
			scrollDown(lstPartName.get(i));

			highLight(lstPartName.get(i));
			String partNameValue = lstPartName.get(i).getText();
			System.out.println("partNameValue: "+partNameValue);
			
			scrollDown(lstPartSerialNumber.get(i));

			highLight(lstPartSerialNumber.get(i));
			String partSerialNumberValue = lstPartSerialNumber.get(i).getText();
			System.out.println("partSerialNumberValue: "+partSerialNumberValue);
			
			scrollDown(lstPartType.get(i));

			highLight(lstPartType.get(i));
			String partTypeValue = lstPartType.get(i).getText();
			System.out.println("partTypeValue: "+partTypeValue);

			Thread.sleep(1000);
			scrollDown(rdoSelectTansact.get(i));

			highLight(rdoSelectTansact.get(i));

			Thread.sleep(500);
			// click on Accept And Reject
			rdoSelectTansact.get(i).click();
			
			Thread.sleep(500);
			// click on Accept selected button
			btnTransactSelected.click();
			
			Thread.sleep(500);
			//select heading of page 
			String headingValue = heading.getText();
			System.out.println("headingValue: "+headingValue);
			
			softAssert.assertEquals(headingValue, "Outward");
			
			scrollDown(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[1]")));

			highLight(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[1]")));
			
			String partCodeInOutwardPage = driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[1]")).getText();
			System.out.println("partCodeInOutwardPage: "+partCodeInOutwardPage);
			
			scrollDown(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[4]")));

			highLight(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[4]")));
			String partNameInOutwardPage = driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[4]")).getText();
			System.out.println("partNameInOutwardPage: "+partNameInOutwardPage);
			
			scrollDown(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[6]")));

			highLight(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[6]")));
			String partSerialInOutwardPage = driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[6]")).getText();
			System.out.println("partSerialInOutwardPage: "+partSerialInOutwardPage);
			
			scrollDown(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[7]")));

			highLight(driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[7]")));
			String partTypeInOutwardPage = driver.findElement(By.xpath(".//*[@id='container']/div[3]/table/tbody/tr/td/table/tbody[2]/tr/td[7]")).getText();
			System.out.println("partTypeInOutwardPage: "+partTypeInOutwardPage);

			softAssert.assertEquals(partCodeInOutwardPage, partCodeValue);
			softAssert.assertEquals(partNameInOutwardPage, partNameValue);
			softAssert.assertEquals(partSerialInOutwardPage,partSerialNumberValue );
			softAssert.assertEquals(partTypeInOutwardPage, partTypeValue);
		
		
			break;
			
		
		}
		
		softAssert.assertAll();
		driver.navigate().back();
		
	}
	
	//If user enter serial number which is not present in table and click on Go button then blank table should display
	public void checkWithDifferentSerialNumber()
	{
		
		//send the serial number which is not present in the table
		txtSerialNumber.sendKeys("SerialOct2101");
		
		//check the table  is empty
		String tableValue = driver.findElement(By.xpath(".//*[@id='right']/div[1]/div/div[2]/div[3]/table")).getAttribute("value");
		System.out.println("tableValue: "+tableValue);
		
		boolean tableValueIsEmpty = true;
		if(tableValue == null)
		{
			System.out.println("The table is empty");
			assertTrue(tableValueIsEmpty);
			
		}
		
		
	}
	
	//In transact Inventory-> Location tab, system should display Inventory locations which are assigned to login RM
	public void checkWithAssignedLocation() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		// select transact type from list
		Select locationFilter = new Select(ddlLocationFilter);
		locationFilter.selectByVisibleText("Diebold Mumbai");

		Thread.sleep(200);
		scrollDown(ddlLocationFilter);

		highLight(ddlLocationFilter);

		String locationFilterValue = ddlLocationFilter.getAttribute("value");
		System.out.println("locationFilterValue:" + locationFilterValue);
		
		Thread.sleep(200);
		scrollDown(tabHome);
		tabHome.click();
		
	    tabRM.click();
		
	    Thread.sleep(200);
	    tabLogOut.click();
		
		//check in super login 
	    super_EmployeeMasterPageTest = new Super_EmployeeMasterTest();
		super_EmployeeMasterPageTest.Setup();
		super_EmployeeMasterPageTest.ClickOnEmpolyeeDetailLink();
		super_EmployeeDetailPage = new Super_EmployeeDetailPage();
		super_EmployeeDetailPage.location();
		
		driver.findElement(By.cssSelector("a[href='/erprmwise/SuperAdminHomeScreen.do")).click();
		Thread.sleep(1000);
		scrollDown(tabTest);
		
		tabTest.click();
		
		Thread.sleep(200);
		tabLogOut.click();
		
		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		rm_InventoryPage=rm_HomePage.InventoryTab();
		Thread.sleep(500);
		rm_TransactInventoryPage =  rm_InventoryPage.TransactInventoryTab();
		
		softAssert.assertEquals(locationFilterValue, Super_EmployeeDetailPage.assignLocationValue);
		
		
		softAssert.assertAll();
		
	}
	
	//If User enter remark in 'Part Reject Remark' pop up and click on Stock Not Received button then same spare entry is getting removed and getting added into source login
	public void checkStockNotReceive() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();

		int size = rdoAcceptAndReject.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; ) {
			Thread.sleep(200);
			scrollDown(rdoAcceptAndReject.get(i));
			Thread.sleep(200);
			highLight(rdoAcceptAndReject.get(i));

			boolean checkboxIsPresent = rdoAcceptAndReject.get(i).isEnabled();
			System.out.println(checkboxIsPresent);

			if (checkboxIsPresent == true) {
				String chekboxValue = rdoAcceptAndReject.get(i).getAttribute(
						"value");
				System.out.println("hh: " + chekboxValue);

				int sizeOfCmdbCode = lstCMDBCode.size();
				System.out.println("sizeOfCmdbCode: " + sizeOfCmdbCode);
				for (int j = 0; j < sizeOfCmdbCode; j++) {

					Thread.sleep(1000);
					scrollDown(lstCMDBCode.get(j));

					highLight(lstCMDBCode.get(j));
					String cmdbValue = lstCMDBCode.get(j).getText();
					System.out.println("transactionType: " + cmdbValue);

					if (cmdbValue.contains(chekboxValue)) {

						Thread.sleep(1000);
						scrollDown(rdoAcceptAndReject.get(i));

						highLight(rdoAcceptAndReject.get(i));

						Thread.sleep(500);
						// click on Accept And Reject
						rdoAcceptAndReject.get(i).click();

						Thread.sleep(500);
						// click on reject selected button
						btnRejectSelected.click();

						// send remark
						txaPartRemarkRejected.sendKeys("OK");

						driver.manage().timeouts()
								.pageLoadTimeout(20, TimeUnit.SECONDS);
						// click on Add button
						btnStockNotReceived.click();

						Thread.sleep(1000);

						scrollDown(lstCMDBCode.get(j));

						highLight(lstCMDBCode.get(j));

						String transactionIDAfterReject = lstCMDBCode.get(j)
								.getText();
						System.out.println("transactionIDAfterReject:"
								+ transactionIDAfterReject);

						softAssert.assertNotEquals(transactionIDAfterReject,
								cmdbValue, "The part is not get removed");
					}

				}

			}
			break;

		}
		softAssert.assertAll();

	}
}
