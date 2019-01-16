package com.uno.pages.logistics;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.BasicFlowPage;
import com.uno.pages.superrole.Super_CourierMediumPage;
import com.uno.pages.superrole.Super_CourierNamePage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_InventoryMastersPage;
import com.uno.pages.superrole.Super_LoginPage;

public class Logistic_InventoryRequiredPage extends BaseCode {
	
	//this spare should be approve at SCM
	 public static String spareRequestIdInSD ="Worldline395";
	 public static String quantityInSD = "5";
	 public static String customerNameInSD = "Worldline India Pvt. Ltd";
	 public static String ReceiverAddressInSD = "abc";
	 
	 Super_LoginPage loginPageOfSuperRole;
	 Super_HomePage homePageOfSuperRole;
	 Super_InventoryMastersPage inventoryMastersPageOfSuperRole;
	 Super_CourierNamePage courierNamePageOfSuperRole;
	 Super_CourierMediumPage courierMediumPageOfSuperRole;
	 Logistic_InventoryRequiredPage inventoryRequiredPageOfLogisticRole;
	 Logistic_LoginPage	loginPageOfLogisticRole;
	 Logistic_HomePage	homePageOfLogisticRole;
	 Logistic_SpareDetailsReportPage	spareDetailsReportPageOfLogisticRole;
	 
	  
	
	// Select tab for logout tab		
	 @FindBy(linkText = "Logistic")
	WebElement link_Logistic; 
	 
	 @FindBy(linkText = "Test")
	WebElement link_Super;
	 
	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;
		
	// select the list of Spare Request ID
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]")
	List<WebElement> list_SpareRequestID;

	// select the list of Ticket ID
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[3]")
	List<WebElement> list_TicketID;

	// select the list of Asset ID
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]")
	List<WebElement> list_AssetID;

	// select the list of Date Of Request
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[5]")
	List<WebElement> list_DateOfRequest;

	// select the list of Engineer Name
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[6]")
	List<WebElement> list_EngineerName;

	// select the list of Part Code
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[7]")
	List<WebElement> list_PartCode;

	// select the list of Part Name
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[8]")
	List<WebElement> list_PartName;

	// select the list of Requested Quantity
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[9]")
	List<WebElement> list_RequestedQuantity;

	// select the list of Pending Quantity
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[10]")
	List<WebElement> list_PendingQuantity;

	// select the list of Region
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[11]")
	List<WebElement> list_Region;

	// select the list of State
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[12]")
	List<WebElement> list_State;

	// select the list of Spare Delivery Location
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[13]")
	List<WebElement> list_SpareDeliveryLocation;

	// select the list of Spare Request ID
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[14]")
	List<WebElement> list_SpareRemark;

	// select the list of Pending Remark
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[15]")
	List<WebElement> list_PendingRemark;

	// select the list of Pending Remark Status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[16]")
	List<WebElement> list_PendingRemarkStatus;

	// select the list of spare request status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[17]")
	List<WebElement> list_SpareRequestStatus;

	// select the list of SCM Test Status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[18]")
	List<WebElement> list_SCMTestStatus;

	// select the list of TRC Testing Status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[19]")
	List<WebElement> list_TRCTestingStatus;

	// select the list of View PO Generated
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[20]")
	List<WebElement> list_ViewPOGenerated;

	// select TM status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[21]")
	List<WebElement> list_TMStatus;
	
	// select view button ,it is display after selecting the ApproveAtSCM Status.
	 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[22]")
	 List<WebElement> list_ViewButton;

	// select Update Pending Remark
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[22]/a")
	List<WebElement> list_UpdatePendingRemark;

	// select Date Range drop down
	@FindBy(css = "select[name='m_strDaterange']>option")
	List<WebElement> dropdown_DateRange;

	// select Date Range drop down
	@FindBy(name = "m_strDaterange")
	WebElement dropdown_DateRange1;

	// select From date text box
	@FindBy(name = "m_strFromDate")
	WebElement textbox_FromDate;

	// select button of calendar of From date
	@FindBy(xpath = ".//*[@id='fd-but-dp-1']/span[1]")
	WebElement button_CalendarOfFromDate;

	// select button of calendar of To date
	@FindBy(name = "m_strToDate")
	WebElement textbox_ToDate;

	// select Region Filter drop down
	@FindBy(css = "select[name='m_strRegion']>option")
	List<WebElement> dropdown_RegionFilter;

	// select Region Filter drop down
	@FindBy(name = "m_strRegion")
	WebElement dropdown_Region;

	// select state filter drop down
	@FindBy(css = "select[name='m_strState']>option")
	List<WebElement> dropdown_StateFilter;
	
	// select Region Filter drop down
	@FindBy(name = "m_strState")
	WebElement dropdown_State;

	// select pending Remark filter drop down
	@FindBy(css = "select[name='m_strPendingRemarkFilter']>option")
	List<WebElement> dropdown_PendingRemarkFilter;
	
	// select Region Filter drop down
	@FindBy(name = "m_strPendingRemarkFilter")
	WebElement dropdown_PendingRemark;
	
	// select Region Filter drop down
	@FindBy(name = "m_strStatus")
	WebElement dropdown_Status;

	// select Status filter drop down
	@FindBy(css = "select[name='m_strStatus']>option")
	List<WebElement> dropdown_StatusFilter;

	// select GO button
	@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr/td[31]/a/span")
	WebElement button_GO;

	// select Reset Filter button
	@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr/td[32]/a/span")
	WebElement button_ResetFilter;
	
	 //select Pending Remark In Update Remark PopUp
	 @FindBy(name = "m_strPendingRemark")
	 WebElement dropdown_PendingRemarkInUpdateRemarkPopUp;
	 
	 //send Comment In Update Remark PopUp
	 @FindBy(name = "m_strPendingRemarkComment")
	 WebElement textbox_CommentInUpdateRemarkPopUp;
	 
	 //select update button In Update Remark PopUp
	 @FindBy(xpath = ".//*[@id='boxb']/div/div/center/input")
	 WebElement button_updateInUpdateRemarkPopUp;
	 
	 //select create and send
	 @FindBy(xpath = ".//*[@id='container']/div[3]/table/tbody/tr/td/input")
	 WebElement button_CreateAndSend;
	 
	 //select All drop down in part status
	 @FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr/td/table/tbody/tr/td/select[@class='listmenu']")
	 WebElement dropdowns_PartStatus;
	 
	 //select All drop down in Assign Criteria
	 @FindBy(xpath = ".//*[@id='right']/div[5]/table/tbody/tr/td/table/tbody/tr/td/select[@class='listmenu']")
	 WebElement dropdowns_AssignCriteria;
	 
	 //select All small Text Area Box in Courier Details
	 @FindBy(xpath = ".//*[@id='right']/div[8]/table/tbody/tr/td/table/tbody/tr/td/textarea[@class='textareasmall']")
	 WebElement textAreaBoxs_CourierDetails;
	 
	 //select All drop down in  Courier Details
	 @FindBy(xpath = ".//*[@id='right']/div[8]/table/tbody/tr/td/table/tbody/tr/td/select[@class='listmenu']")
	 WebElement dropdowns_CourierDetails;
	 
	 //select All text box in Courier Details
	 @FindBy(xpath = ".//*[@id='right']/div[8]/table/tbody/tr/td/table/tbody/tr/td/input[@type='text']")
	 WebElement textboxs_CourierDetails;
	 
	 //select All text box in Transact Detail
	 @FindBy(xpath = ".//*[@id='form']/table/tbody/tr/td/div[3]/table/tbody/tr/td/table/tbody/tr/td/input[@type='text']")
	 WebElement textboxs_TransactDetail;

	 //select All small Text Area Box in Transact Details
	 @FindBy(xpath = ".//*[@id='form']/table/tbody/tr/td/div[3]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/textarea")
	 WebElement textAreaBoxs_TransactDetail;
	 
	// select Courier Name drop down
	@FindBy(css = "select[name = 'm_strCourierName']")
	WebElement dropdown_CourierName;
	
	// select list of Courier Name drop down
	@FindBy(css = "select[name = 'm_strCourierName']>option")
	List<WebElement> dropdown_ListOfCourierName;
	
	// select Courier Medium drop down
	@FindBy(css = "select[name = 'm_strCourierMedium']")
	WebElement dropdown_CourierMedium;
	
	// select List of Courier Medium drop down
	@FindBy(css = "select[name = 'm_strCourierMedium']>option")
	List<WebElement> dropdown_ListOfCourierMedium;
	
	

	public Logistic_InventoryRequiredPage() {
		PageFactory.initElements(driver, this);

	}

	// After approve spare request from SCM login, same entry should display in
	// Logistic login-> Spare Details Report->
	// Inventory Required tab with Spare request status as 'Open' , SCM Test
	// Status as 'Valid' and TM Status as 'ApprovedAtSCM'
	public void checkStatusAfterApproveBySCMInLogistic() throws Exception {
		 SoftAssert softAssert = new SoftAssert();

		// Call Robot class for Handle System Window.
		Robot robot = new Robot();
		// Press Control Button Of keyboard using Robot Class.
		robot.keyPress(KeyEvent.VK_CONTROL);
		// Press Minus Button Of keyboard using Robot Class to Minimize the
		// window.
		robot.keyPress(KeyEvent.VK_MINUS);

		// Get last Spare Request ID In SD.
		String lastSpareRequestIDInSD = BasicFlowPage.lastSpareRequestIDInSD;
		// Print last Spare Request ID In SD.
		System.out.println("lastSpareRequestIDInSD: " + lastSpareRequestIDInSD);

		// Get Size of Spare Request ID.
		int sizeSpareRequestID = list_SpareRequestID.size();
		// Print Size of Spare Request ID.
		System.out.println(sizeSpareRequestID);

		// Apply For loop for get the all Spare Request ID.
		for (int i = 0; i < sizeSpareRequestID; i++) {

			// Get Spare Request Id In Logistic According For loop.
			String spareRequestIdInLogistic = list_SpareRequestID.get(i)
					.getText();
			// Print Spare Request Id In Logistic According For loop.
			System.out.println("spareRequestIdInLogistic: "
					+ spareRequestIdInLogistic);

			// Check both Spare Request ID between SD & Logistic Role is Match
			// or not.
			if (lastSpareRequestIDInSD
					.equalsIgnoreCase(spareRequestIdInLogistic)) {

				// Get TM Status Value
				String tmStatusValue = list_TMStatus.get(i).getText();
				// Print TM Status Value
				System.out.println("TM Status value: " + tmStatusValue);

				// Verify the TM Status Value. It should have "ApprovedAtSCM".
				softAssert.assertEquals(tmStatusValue, "ApprovedAtSCM");

				// Get Status Value
				String statusValue = list_SpareRequestStatus.get(i).getText();
				// Print Status Value
				System.out
						.println("status after Spare request is approve by SCM"
								+ statusValue);

				// Verify the Status Value. It should have "Open".
				softAssert.assertEquals(statusValue, "Open");
				softAssert.assertAll();

			}

		}

	}

	// In logistic login-> Spare Details Report-> Inventory Required tab, as per
	// applied
	// date range entries should display whose request date as per selected date
	// Range
	public void checkFromAndToDateAccordingSelectedDateRange() throws Exception {

		 SoftAssert softAssert = new SoftAssert();
		// Get the Today system date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		System.out.println("Today Date: " + todayDate);

		Calendar calendar = Calendar.getInstance();
		// Move calendar to yesterday
		calendar.add(Calendar.DATE, -1);
		// Get current date of calendar which point to the yesterday now
		Date yesterday = calendar.getTime();
		String yesterdayDate = dateFormat.format(yesterday).toString();
		System.out.println("Yesterday Date: " + yesterdayDate);

		Calendar calendar1 = Calendar.getInstance();
		// Move calendar to 7 days before
		calendar1.add(Calendar.DATE, -7);
		// Get current date of calendar which point to the yesterday now
		Date lastSevenDays = calendar1.getTime();
		String lastSevenDaysDate = dateFormat.format(lastSevenDays).toString();
		System.out.println("Last Seven Days Date: " + lastSevenDaysDate);

		Calendar calendar2 = Calendar.getInstance();
		// Move calendar to 30 days before
		calendar2.add(Calendar.DATE, -30);
		// Get current date of calendar which point to the yesterday now
		Date lastThirtyDays = calendar2.getTime();
		String lastThirtyDaysDate = dateFormat.format(lastThirtyDays)
				.toString();
		System.out.println("Last Thirty Days Date: " + lastThirtyDaysDate);

		Select selectDateRange = new Select(dropdown_DateRange1);

		List<WebElement> listOfDateRange = selectDateRange.getOptions();

		int sizeOfDateRangeOptions = listOfDateRange.size();
		System.out.println(sizeOfDateRangeOptions);
		int i = 0;
		for (i = 1; i < sizeOfDateRangeOptions; i++) {

			Cookie cobj = new Cookie("MyCookies", "12345");
			driver.manage().addCookie(cobj);

			String dateRangeOptions = listOfDateRange.get(i).getAttribute(
					"value");
			System.out.println("\ndateRangeOptions: " + dateRangeOptions);

			if (dateRangeOptions.equalsIgnoreCase("Today")) {
				selectDateRange.selectByIndex(i);

				Thread.sleep(2000);

				String fromDate = textbox_FromDate.getAttribute("value");
				System.out.println("fromDate: " + fromDate);

				String toDate = textbox_ToDate.getAttribute("value");
				System.out.println("toDate: " + toDate);

				softAssert.assertEquals(fromDate, todayDate, "Date is not Same");
				softAssert.assertEquals(toDate, todayDate, "Date is not Same");

			} else if (dateRangeOptions.equalsIgnoreCase("Yesterday")) {

				selectDateRange.selectByIndex(i);

				Thread.sleep(2000);

				String fromDate = textbox_FromDate.getAttribute("value");
				System.out.println("fromDate: " + fromDate);

				String toDate = textbox_ToDate.getAttribute("value");
				System.out.println("toDate: " + toDate);

				softAssert.assertEquals(fromDate, yesterdayDate, "Date is not Same");
				softAssert.assertEquals(toDate, yesterdayDate, "Date is not Same");
				// driver.navigate().back();
				driver.manage().getCookieNamed("cobj");
				break;

			}

			/*
			 * else if (dateRangeOptions.equalsIgnoreCase("Yesterday")) {
			 * 
			 * selectDateRange.selectByIndex(i);
			 * 
			 * Thread.sleep(2000);
			 * 
			 * String fromDate = textbox_FromDate.getAttribute("value");
			 * System.out.println("fromDate: " + fromDate);
			 * 
			 * String toDate = textbox_ToDate.getAttribute("value");
			 * System.out.println("toDate: " + toDate);
			 * 
			 * Assert.assertEquals(fromDate, yesterdayDate, "Date is not Same");
			 * Assert.assertEquals(toDate, yesterdayDate, "Date is not Same");
			 * continue loop; }
			 */
			softAssert.assertAll();
		}

	}

	public void checkRegionAccordingSelectedRegionFilter() throws Exception {
		 

		Select selectRegion = new Select(dropdown_Region);

		List<WebElement> listOfRegion = selectRegion.getOptions();
		int sizeOfRegionOptions = listOfRegion.size();
		System.out.println("\nsizeOfRegionOptions: " + sizeOfRegionOptions);

		String listOfRegions = dropdown_Region.getText();
		System.out.println("listOfRegions:" + listOfRegions);

		int i = 0;
		for (i = 1; i < sizeOfRegionOptions; i++) {

			Cookie cobj = new Cookie("MyCookies", "12345");
			driver.manage().addCookie(cobj);

			String regionOptions = listOfRegion.get(i).getAttribute("value");
			System.out.println("\nregionOptions: " + regionOptions);

			/* if (regionOptions.equalsIgnoreCase("West")) { */

			selectRegion.selectByIndex(i);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_GO);
			Thread.sleep(1000);
			button_GO.click();

			int sizeOfRegion = list_Region.size();
			System.out.println("sizeOfRegion: " + sizeOfRegion);

			for (int j = 0; j < sizeOfRegion; j++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						list_Region.get(j));
				String region = list_Region.get(j).getText();
				System.out.println("region: " + region);
				Assert.assertEquals(region, regionOptions, "Region is not Same");
			}

		}

	}

	public void checkDateOfRequestAccordingSelectedDateRange() throws Exception {
		
		// Get the Today system date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		System.out.println("Today Date: " + todayDate);

		Calendar calendar = Calendar.getInstance();
		// Move calendar to yesterday
		calendar.add(Calendar.DATE, -1);
		// Get current date of calendar which point to the yesterday now
		Date yesterday = calendar.getTime();
		String yesterdayDate = dateFormat.format(yesterday).toString();
		System.out.println("Yesterday Date: " + yesterdayDate);

		Calendar calendar1 = Calendar.getInstance();
		// Move calendar to 7 days before
		calendar1.add(Calendar.DATE, -7);
		// Get current date of calendar which point to the yesterday now
		Date lastSevenDays = calendar1.getTime();
		String lastSevenDaysDate = dateFormat.format(lastSevenDays).toString();
		System.out.println("Last Seven Days Date: " + lastSevenDaysDate);

		Calendar calendar2 = Calendar.getInstance();
		// Move calendar to 30 days before
		calendar2.add(Calendar.DATE, -30);
		// Get current date of calendar which point to the yesterday now
		Date lastThirtyDays = calendar2.getTime();
		String lastThirtyDaysDate = dateFormat.format(lastThirtyDays)
				.toString();
		System.out.println("Last Thirty Days Date: " + lastThirtyDaysDate);

		Select selectDateRange = new Select(dropdown_DateRange1);

		List<WebElement> listOfDateRange = selectDateRange.getOptions();

		int sizeOfDateRangeOptions = listOfDateRange.size();
		System.out.println(sizeOfDateRangeOptions);
		int i = 0;
		for (i = 1; i < sizeOfDateRangeOptions; i++) {

			Cookie cobj = new Cookie("MyCookies", "12345");
			driver.manage().addCookie(cobj);

			String dateRangeOptions = listOfDateRange.get(i).getAttribute(
					"value");
			System.out.println("\ndateRangeOptions: " + dateRangeOptions);

			if (dateRangeOptions.equalsIgnoreCase("Today")) {
				selectDateRange.selectByIndex(i);

				int sizeOfDateOfRequest = list_DateOfRequest.size();
				System.out.println("sizeOfDateOfRequest: "
						+ sizeOfDateOfRequest);

				for (int j = 0; j < sizeOfDateOfRequest; j++) {
					String dateOfRequest = list_DateOfRequest.get(i).getText();
					System.out.println("dateOfRequest: " + dateOfRequest);
					Assert.assertEquals(dateOfRequest, todayDate,
							"Date is not Same");
				}

			}

		}
	}
	
	public void checkStateAccordingSelectedStateFilter() throws Exception {
		 

		Select selectState = new Select(dropdown_State);

		List<WebElement> listOfState = selectState.getOptions();
		int sizeOfStateOptions = listOfState.size();
		System.out.println("\nsizeOfStateOptions: " + sizeOfStateOptions);

		String listOfStates = dropdown_State.getText();
		System.out.println("listOfStates:" + listOfStates);

		int i = 0;
		for (i = 1; i < sizeOfStateOptions; i++) {

			Cookie cobj = new Cookie("MyCookies", "12345");
			driver.manage().addCookie(cobj);

			String StateOptions = listOfState.get(i).getAttribute("value");
			System.out.println("\nStateOptions: " + StateOptions);

			/* if (regionOptions.equalsIgnoreCase("West")) { */

			selectState.selectByIndex(i);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_GO);
			Thread.sleep(1000);
			button_GO.click();

			int sizeOfState = list_State.size();
			System.out.println("sizeOfState: " + sizeOfState);

			for (int j = 0; j < sizeOfState; j++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						list_State.get(j));
				String state = list_State.get(j).getText();
				System.out.println("state: " + state);
				Assert.assertEquals(state, StateOptions, "State is not Same");
			}

		}

	}
	
	public void checkPendingRemarkAccordingSelectedPendingRemarkFilter() throws Exception {
	

		Select selectPendingRemark = new Select(dropdown_PendingRemark);

		List<WebElement> listOfPendingRemark = selectPendingRemark.getOptions();
		int sizeOfPendingRemarkOptions = listOfPendingRemark.size();
		System.out.println("\nsizeOfPendingRemarkOptions: " + sizeOfPendingRemarkOptions);

		String listOfPendingRemarks = dropdown_State.getText();
		System.out.println("listOfPendingRemarks:" + listOfPendingRemarks);

		int i = 0;
		for (i = 1; i < sizeOfPendingRemarkOptions; i++) {

			Cookie cobj = new Cookie("MyCookies", "12345");
			driver.manage().addCookie(cobj);

			String pendingRemarkOptions = listOfPendingRemark.get(i).getAttribute("value");
			System.out.println("\npendingRemarkOptions: " + pendingRemarkOptions);

			/* if (regionOptions.equalsIgnoreCase("West")) { */

			selectPendingRemark.selectByIndex(i);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_GO);
			Thread.sleep(1000);
			button_GO.click();

			int sizeOfPendingRemark = list_PendingRemark.size();
			System.out.println("sizeOfPendingRemark: " + sizeOfPendingRemark);

			for (int j = 0; j < sizeOfPendingRemark; j++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						list_PendingRemark.get(j));
				String pendingRemark = list_PendingRemark.get(j).getText();
				System.out.println("Pending Remark: " + pendingRemark);
				Assert.assertEquals(pendingRemark, pendingRemarkOptions, "Pending Remark is not Same");
			}

		}

	}
	
	public void checkStatusAccordingSelectedStatusFilter() throws Exception {
		 SoftAssert softAssert = new SoftAssert();

		Select selectStatus = new Select(dropdown_Status);

		List<WebElement> listOStatus = selectStatus.getOptions();
		int sizeOfStatusOptions = listOStatus.size();
		System.out.println("\nsizeOfStatusOptions: " + sizeOfStatusOptions);

		String listOfStatus = dropdown_Status.getText();
		System.out.println("listOfStatus:" + listOfStatus);

		int i = 0;
		for (i = 1; i < sizeOfStatusOptions; i++) {

			Cookie cobj = new Cookie("MyCookies", "12345");
			driver.manage().addCookie(cobj);

			String statusOptions = listOStatus.get(i).getAttribute("value");
			System.out.println("\nstatusOptions: " + statusOptions);

			/* if (regionOptions.equalsIgnoreCase("West")) { */

			selectStatus.selectByIndex(i);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					button_GO);
			Thread.sleep(1000);
			button_GO.click();

			int sizeOfStatus = list_TMStatus.size();
			System.out.println("sizeOfStatus: " + sizeOfStatus);

			for (int j = 0; j < sizeOfStatus; j++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						list_TMStatus.get(j));
				String status = list_TMStatus.get(j).getText();
				System.out.println("Status: " + status);
				softAssert.assertEquals(status, statusOptions, "Status is not Same");
				if(status.equalsIgnoreCase("RejectedAtSCM"))
				{
					boolean viewButtonIsPresent=list_ViewButton.get(j).isDisplayed();
					System.out.println("viewButtonIsPresent: "+viewButtonIsPresent);
					softAssert.assertTrue(false, "view button is Display After Rejected by SCM ");
				}
			}
			softAssert.assertAll();

		}

	}
	public void checkCourierNameWithMasterInSuperRole() throws Exception {
		 
		
		  // select the Status as ApproveAtSCM
		   Select Status = new Select(dropdown_Status);
		  Status.selectByVisibleText("ApprovedAtSCM");

		  // click on GO button
		  button_GO.click();

		    ((JavascriptExecutor) driver).executeScript(
		      "arguments[0].scrollIntoView(true);",
		      list_ViewButton.get(1));

		    Thread.sleep(3000);
		    list_ViewButton.get(1).click();
		    
		    button_CreateAndSend.click();
		    
		    
		    
		    
		    int sizeOfCourierNameInLogisticRole = dropdown_ListOfCourierName
					.size()-1;
			System.out.println("\nsizeOfCourierNameInLogisticRole:"
					+ sizeOfCourierNameInLogisticRole);

			dropdown_CourierName.click();
			Thread.sleep(1000);
			
			String courierNameInLogisticRole = dropdown_CourierName
					.getText();
			System.out
					.println("\nCourierNameInLogisticRole:" + courierNameInLogisticRole);

			/*// Change the Tab
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "t");
			// Enter url
			driver.get(properties.getProperty("url"));

			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "\t");
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "w");
			// Thread.sleep(1000);
*/			// click on account
			link_Logistic.click();
			Thread.sleep(1000);

			// click on logout
			link_LogOut.click();
			 Thread.sleep(1000);
			
			 inventoryRequiredPageOfLogisticRole = new Logistic_InventoryRequiredPage();
			 
			 inventoryRequiredPageOfLogisticRole.loginIntoSuper();
			 
			homePageOfSuperRole = new Super_HomePage();
			Thread.sleep(1000);
			inventoryMastersPageOfSuperRole = homePageOfSuperRole.clickInventoryMastersLink();
			Thread.sleep(1000);
			courierNamePageOfSuperRole = inventoryMastersPageOfSuperRole.clickCourierNameLink();
			Thread.sleep(1000);
			
		


			// Get Size Of Courier Name In Super Role
			int sizeOfCourierNameInSuperRole = courierNamePageOfSuperRole.list_CourierName
					.size();
			System.out.println("\nsizeOfCourierNameInSuperRole:"
					+ sizeOfCourierNameInSuperRole);


			// Check Size Of Part Name in both Role

			if ((sizeOfCourierNameInLogisticRole == sizeOfCourierNameInSuperRole)) {
				
				for (int j = 0; j < sizeOfCourierNameInSuperRole; j++) {

					String CourierNameInSuperRole = courierNamePageOfSuperRole.list_CourierName
							.get(j).getText();
					System.out.println("\nCourierNameInSuperRole:"
							+ CourierNameInSuperRole);
					// Check Part name in Both Role
					Assert.assertTrue(courierNameInLogisticRole
							.contains(CourierNameInSuperRole),
							"Courier Name is Not same");
				}
			}
			inventoryRequiredPageOfLogisticRole = new Logistic_InventoryRequiredPage();
			
			inventoryRequiredPageOfLogisticRole.logoutFromSuper();
			
			inventoryRequiredPageOfLogisticRole.loginIntoLogistic();
			
		

		}
	
	public void checkCourierMediumWithMasterInSuperRole() throws Exception {
		
		
		  // select the Status as ApproveAtSCM
		   Select Status = new Select(dropdown_Status);
		  Status.selectByVisibleText("ApprovedAtSCM");

		  // click on GO button
		  button_GO.click();

		    ((JavascriptExecutor) driver).executeScript(
		      "arguments[0].scrollIntoView(true);",
		      list_ViewButton.get(1));

		    Thread.sleep(3000);
		    list_ViewButton.get(1).click();
		    
		    button_CreateAndSend.click();
		    
		    
		    
		    
		    int sizeOfCourierMediumInLogisticRole = dropdown_ListOfCourierMedium
					.size()-1;
			System.out.println("\nsizeOfCourierMediumInLogisticRole:"
					+ sizeOfCourierMediumInLogisticRole);

			dropdown_CourierMedium.click();
			Thread.sleep(1000);
			
			String courierMediumInLogisticRole = dropdown_CourierMedium
					.getText();
			System.out
					.println("\ncourierMediumInLogisticRole:" + courierMediumInLogisticRole);

			/*// Change the Tab
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "t");
			// Enter url
			driver.get(properties.getProperty("url"));

			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "\t");
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "w");
			// Thread.sleep(1000);
*/			// click on account
			link_Logistic.click();
			Thread.sleep(1000);

			// click on logout
			link_LogOut.click();
			 Thread.sleep(1000);
			
			 inventoryRequiredPageOfLogisticRole = new Logistic_InventoryRequiredPage();
			 
			 inventoryRequiredPageOfLogisticRole.loginIntoSuper();
			 
			homePageOfSuperRole = new Super_HomePage();
			Thread.sleep(1000);
			inventoryMastersPageOfSuperRole = homePageOfSuperRole.clickInventoryMastersLink();
			Thread.sleep(1000);
			courierMediumPageOfSuperRole = inventoryMastersPageOfSuperRole.clickCourierMediumLink();
			Thread.sleep(1000);
			
		


			// Get Size Of Courier Name In Super Role
			int sizeOfCourierMediumInSuperRole = courierMediumPageOfSuperRole.list_CourierMedium
					.size();
			System.out.println("\nsizeOfCourierMediumInSuperRole:"
					+ sizeOfCourierMediumInSuperRole);


			// Check Size Of Part Name in both Role

			if ((sizeOfCourierMediumInLogisticRole== sizeOfCourierMediumInSuperRole)) {
				
				for (int j = 0; j < sizeOfCourierMediumInSuperRole; j++) {

					String courierMediumInSuperRole = courierMediumPageOfSuperRole.list_CourierMedium
							.get(j).getText();
					System.out.println("\ncourierMediumInSuperRole:"
							+ courierMediumInSuperRole);
					// Check Part name in Both Role
					Assert.assertTrue(courierMediumInLogisticRole
							.contains(courierMediumInSuperRole),
							"Courier Medium is Not same");
				}
			}
			inventoryRequiredPageOfLogisticRole = new Logistic_InventoryRequiredPage();
			
			inventoryRequiredPageOfLogisticRole.logoutFromSuper();
			
			inventoryRequiredPageOfLogisticRole.loginIntoLogistic();
			
		

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
	
	public void loginIntoSuper() throws Exception {

		Thread.sleep(1000);
		// maximize the window to 100%
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		loginPageOfSuperRole = new Super_LoginPage();
		homePageOfSuperRole = loginPageOfSuperRole.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));

	}

	public void logoutFromSuper() throws Exception {

		Thread.sleep(1000);
		link_Super.click();
		Thread.sleep(1000);
		link_LogOut.click();
		Thread.sleep(1000);

	}
	
}