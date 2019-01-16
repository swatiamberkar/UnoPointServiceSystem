package com.uno.pages.technician;

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

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
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
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;
import com.uno.pages.superrole.Super_SpareInventoryLocationPage;
import com.uno.pages.superrole.Super_TeamMasterPage;
import com.uno.pages.superrole.Super_TicketCategoryMasterPage;
import com.uno.pages.superrole.Super_TicketLevelPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketModePage;
import com.uno.pages.superrole.Super_TicketTypePage;
import com.uno.test.sd.SD_ViewTicketTest;
import com.uno.test.superrole.Super_AdminTest;
import com.uno.test.superrole.Super_InventoryMastersTest;
import com.uno.test.superrole.Super_ServiceDeskSettingsTest;

public class Technician_EditIncidentPage extends BaseCode {

	public static String serialNumber = null;
	public static String getTechnicianDateTime = null;

	/*
	 * // call the method from SD role SD_LoginPage loginPageOfSdRole;
	 * Technician_HomePage technician_HomePage; Technician_IncidentPage
	 * technician_IncidentPage; Technician_ViewIncidentPage
	 * technician_ViewIncidentPage; WebEventListener webEventListener;
	 * 
	 * // call the method from super role Super_LoginPage loginPageOfSuperRole;
	 * Super_HomePage homePageOfSuperRole; Super_SDMasterPage
	 * sDmasterPageOfSuperRole; Super_TicketMasterPage
	 * ticketMasterPageOfSuperRole; Super_TicketTypePage
	 * ticketTypePageOfSuperRole; Super_EmployeeMasterPage
	 * empolyeeMasterPageOfSuperRole; Super_EmployeeDetailPage
	 * employeeDetailPageOfSuperRole; Super_ManageStaffPage
	 * manageStaffPageOfSuperRole; Super_TeamMasterPage
	 * teamMasterPageOfSuperRole; Super_FileCategoryPage
	 * fileCategoryPageOfSuperRole; Super_AdminPage adminPageOfSuperRole;
	 * Super_AdminTest adminPageTestCaseOfSuperRole;
	 * Super_ServiceDeskSettingsPage serviceDeskSettingsPageOfSuperRole;
	 * Super_ServiceDeskSettingsTest serviceDeskSettingsPageTestCaseOfSuperRole;
	 * Super_InventoryMastersTest inventoryMastersPageTestCaseOfSuperRole;
	 * Super_ItemMasterPage itemMasterPageOfSuperRole;
	 * Super_SpareInventoryLocationPage spareInventoryLocationPageOfSuperRole;
	 * SD_ViewTicketTest viewTicketPageTestCaseOfSdRole; SD_CreateNewPage
	 * createNewPageOfSdRole;
	 */

	// Initializing Page Object
	public Technician_EditIncidentPage() {
		PageFactory.initElements(driver, this);
	}

	// Check Upload File button with File in File attachments Tab
	public void checkNotificationAfterUploadFile(String ddl_FileType,
			String txt_FilePath) throws Exception {
		SoftAssert softAssert = new SoftAssert();

		scrollDown(ddlFileTypeInFileAttachmentsTab);
		// Select File Type
		Select fileTypeDropDown = new Select(ddlFileTypeInFileAttachmentsTab);
		// Value of File Type
		String fileTypeValue = "Customer Approval";
		// Select Value of File Type
		fileTypeDropDown.selectByVisibleText(ddl_FileType);

		// Enter File Path
		/*
		 * btnBrowseInFileAttachmentsTab
		 * .sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"
		 * );
		 */
		btnBrowseInFileAttachmentsTab.sendKeys(txt_FilePath);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		// Click Upload File Button
		btnUploadFileInFileAttachmentsTab.click();

		// Get Notification
		Thread.sleep(2000);
		String notificationText = msgNotification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"File Uploaded Successfully...!", "Notification is not Match");
		Thread.sleep(1000);

		softAssert.assertAll();

	}

	// If user update any details and click on update details after click on
	// Update details button then updated details should get override on old
	// incident details

	public void checkUpdatedTicketDetails(String ddl_TicketType,
			String ddl_Mode, String ddl_Level, String ddl_CTS,
			String txt_Amount, String ddl_Impact, String ddl_Urgency,
			String ddl_TroubleCategory, String ddl_TroubleSubCategory,
			String txt_LocalContact, String txt_LocalContactNo,
			String txt_CustomerEmailID, String btn_today, String dtp_Date,
			String btn_PreviousYear, String btn_PreviousMonth,
			String btn_nextYear, String btn_nextMonth, String ddl_Hrs,
			String ddl_Mins) throws Exception {

		SoftAssert softAssert = new SoftAssert();
		btnEditInIncidentDetailsTab.click();
		// Select Ticket Type
		Select ticketTypeDropDown = new Select(
				ddlTicketTypeInTicketDetailsPopup);
		// Select Value of Ticket Type
		ticketTypeDropDown.selectByVisibleText(ddl_TicketType);

		// Select Mode
		Select modeDropDown = new Select(ddlModeInTicketDetailsPopup);
		// Select Value of Mode
		modeDropDown.selectByVisibleText(ddl_Mode);

		if (ddl_Level.equalsIgnoreCase(" ")) {
			// Select Level
			Select levelDropDown = new Select(ddlLevelInTicketDetailsPopup);
			levelDropDown.selectByVisibleText(ddl_Level);
		}
		// Select CTS
		Select CTSDropDown = new Select(ddlCTSInTicketDetailsPopup);
		// Select Value of CTS
		CTSDropDown.selectByVisibleText(ddl_CTS);

		// Value of Amount
		txtAmountInTicketDetailsPopup.clear();
		// Enter Value of Amount
		txtAmountInTicketDetailsPopup.sendKeys(txt_Amount);

		if (ddl_Impact.equalsIgnoreCase(" ")) {
			Select impactDropdown = new Select(ddlImpactInTicketDetailsPopup);
			impactDropdown.selectByVisibleText(ddl_Impact);
		}
		// Select Urgency
		Select urgencyDropDown = new Select(ddlUrgencyInTicketDetailsPopup);
		// Select Value of Urgency
		urgencyDropDown.selectByVisibleText(ddl_Urgency);

		// Select Trouble Category
		Select troubleCategoryDropDown = new Select(
				ddlTroubleCategoryInTicketDetailsPopup);
		// Select Value of Trouble Category
		troubleCategoryDropDown.selectByVisibleText(ddl_TroubleCategory);
		Thread.sleep(1000);
		// Select Trouble Category
		Select troubleSubCategoryDropDown = new Select(
				ddlTroubleSubCategoryInTicketDetailsPopup);
		// Select Value of Trouble Category
		troubleSubCategoryDropDown.selectByVisibleText(ddl_TroubleSubCategory);

		txtLocalContactInTicketDetailsPopup.clear();
		// Enter Value of Local Contact
		txtLocalContactInTicketDetailsPopup.sendKeys(txt_LocalContact);

		txtLocalContactNoInTicketDetailsPopup.clear();
		// Enter Value of Local Contact No
		txtLocalContactNoInTicketDetailsPopup.sendKeys(txt_LocalContactNo);

		txtCustomerEmailIDInTicketDetailsPopup.clear();
		// Enter Value of Customer Email ID
		txtCustomerEmailIDInTicketDetailsPopup.sendKeys(txt_CustomerEmailID);
		String dateValue = null;
		String timeValue = null;

		if (btn_today.equalsIgnoreCase("Y")) {
			// Value of Date
			btnTodayDateInTicketDetailsPopup.click();
			/*
			 * dateValue = txtDateInTicketDetailsPopup.getAttribute("value");
			 * System.out.println(dateValue);
			 * 
			 * // Value of Time String HrsOfTimeValue =
			 * selectedHrsOfTimeInTicketDetailsPopup .getAttribute("value");
			 * System.out.println("HrsOfTimeValue: " + HrsOfTimeValue); String
			 * MinOfTimeValue = selectedMinOfTimeInTicketDetailsPopup
			 * .getAttribute("value"); System.out.println("MinOfTimeValue: " +
			 * MinOfTimeValue);
			 * 
			 * timeValue = HrsOfTimeValue.concat(" : " + MinOfTimeValue);
			 * System.out.println(timeValue);
			 */

		} else if (btn_today.equalsIgnoreCase("N")) {
			calDateInTicketDetailsPopup.click();

			if (btn_PreviousYear.equalsIgnoreCase("Y")) {
				btnPrevoiusYearDateInTicketDetailsPopup.click();
			}
			if (btn_PreviousMonth.equalsIgnoreCase("Y")) {
				btnPrevoiusMonthDateInTicketDetailsPopup.click();
			}
			if (btn_nextMonth.equalsIgnoreCase("Y")) {
				btnNextMonthDateInTicketDetailsPopup.click();
			}
			if (btn_nextYear.equalsIgnoreCase("Y")) {
				btnNextYearDateInTicketDetailsPopup.click();
			}
			if (!dtp_Date.equalsIgnoreCase("N")) {

				// select Date in Calendar

				for (WebElement day : dtpDateInTicketDetailsPopup) {

					String dayInCalender = day.getText();

					if (dayInCalender.equalsIgnoreCase(dtp_Date)) {
						Thread.sleep(1000);
						highLight(day);
						day.click();
						String getDateValue = day.getText();
						System.out.println("Select the date:-" + getDateValue);

						break;
					}

				}
			}

			else if (!ddl_Hrs.equalsIgnoreCase("N")) {
				Select HrsOfTimeDropDown = new Select(
						ddlHrsOfTimeInTicketDetailsPopup);
				// Select Value of Time
				HrsOfTimeDropDown.selectByVisibleText(ddl_Hrs);

			} else if (!ddl_Mins.equalsIgnoreCase("N")) {
				// Select Time
				Select MinOfTimeDropDown = new Select(
						ddlMinOfTimeInTicketDetailsPopup);
				MinOfTimeDropDown.selectByVisibleText(ddl_Mins);

			}

		}
		// Value of Date
		dateValue = txtDateInTicketDetailsPopup.getAttribute("value");
		System.out.println(dateValue);

		// Value of Time
		String HrsOfTimeValue = selectedHrsOfTimeInTicketDetailsPopup
				.getAttribute("value");
		System.out.println("HrsOfTimeValue: " + HrsOfTimeValue);
		String MinOfTimeValue = selectedMinOfTimeInTicketDetailsPopup
				.getAttribute("value");
		System.out.println("MinOfTimeValue: " + MinOfTimeValue);

		timeValue = HrsOfTimeValue.concat(" : " + MinOfTimeValue);
		System.out.println(timeValue);

		// Click on Update Details Button
		btnUpdateDetailsInTicketDetailsPopup.click();
		Thread.sleep(5000);

		// Get Value of Ticket Type
		String textOfIncidentType = lblIncidentTypeInIncidentDetailsTab
				.getText();
		String incidentType = textOfIncidentType.split("Incident type ")[1];
		System.out.println(incidentType);

		// Get Value of Mode
		String textOfMode = lblModeInIncidentDetailsTab.getText();
		String mode = textOfMode.split("Mode ")[1];
		System.out.println(mode);

		/*
		 * // Get Value of Level String textOfLevel
		 * =lblLevelInIncidentDetailsTab.getText(); String level =
		 * textOfLevel.split("Level ")[1]; System.out.println(level);
		 */

		// Get Value of CTS
		String textOfCTS = lblCTSInIncidentDetailsTab.getText();
		String CTS = textOfCTS.split("CTS ")[1];
		System.out.println(CTS);
		// Get Value of Amount
		String textOfAmount = lblAmountInIncidentDetailsTab.getText();
		String amount = textOfAmount.split("Amount : ")[1];
		System.out.println(amount);

		/*
		 * String textOfImpact =lblImpactInIncidentDetailsTab.getText(); String
		 * impact = textOfImpact.split("Impact ")[1];
		 * System.out.println(impact);
		 */
		// Get Value of Urgency
		String textOfUrgency = lblUrgencyInIncidentDetailsTab.getText();
		String urgency = textOfUrgency.split("Urgency ")[1];
		System.out.println(urgency);

		// Get Value of Trouble Category
		String textOfTroubleCategory = lblTroubleCategoryInIncidentDetailsTab
				.getText();
		String troubleCategory = textOfTroubleCategory
				.split("Trouble Category :")[1];
		System.out.println(troubleCategory);

		// Get Value of Local Contact
		String textOfLocalContact = lblLocalContactInIncidentDetailsTab
				.getText();
		String localContact = textOfLocalContact.split("Local Contact ")[0];
		System.out.println(localContact);

		// Get Value of Local Contact No
		String textOfLocalContactNo = lblLocalContactNoInIncidentDetailsTab
				.getText();
		String localContactNo = textOfLocalContactNo.split("Local Contact No ")[0];
		System.out.println(localContactNo);

		// Get Value of Customer Email ID
		String textOfCustomerEmailID = lblCustomerEmailIDInIncidentDetailsTab
				.getText();
		String customerEmailID = textOfCustomerEmailID
				.split("Customer Email ID ")[0];
		System.out.println(customerEmailID);

		// Get Value of Date
		String textOfDate = lblDateInIncidentDetailsTab.getText();
		String date = textOfDate.split("Date:")[1];
		System.out.println(date);

		// Get Value of Time
		String textOfTime = lblTimeInIncidentDetailsTab.getText();
		String time = textOfTime.split("Time ")[1];
		System.out.println(time);

		highLight(lblIncidentTypeInIncidentDetailsTab);
		softAssert.assertEquals(ddl_TicketType, incidentType,
				"Ticket Type is not same");
		highLight(lblModeInIncidentDetailsTab);
		softAssert.assertEquals(ddl_Mode, mode, "Mode is not same");
		highLight(lblLevelInIncidentDetailsTab);
		// softAssert.assertEquals(ddl_Level, level, "Level is not same");
		highLight(lblCTSInIncidentDetailsTab);
		softAssert.assertEquals(ddl_CTS, CTS, "CTS is not same");
		highLight(lblImpactInIncidentDetailsTab);
		// softAssert.assertEquals(ddl_Impact, impact, "Impact is not same");
		highLight(lblAmountInIncidentDetailsTab);
		softAssert.assertEquals(txt_Amount, amount, "Amount is not same");
		highLight(lblUrgencyInIncidentDetailsTab);
		softAssert.assertEquals(ddl_Urgency, urgency, "Urgency is not same");
		highLight(lblTroubleCategoryInIncidentDetailsTab);
		softAssert.assertEquals(ddl_TroubleCategory, troubleCategory,
				"Trouble Category is not same");
		highLight(lblLocalContactInIncidentDetailsTab);
		softAssert.assertEquals(txt_LocalContact, localContact,
				"Local Contact is not same");
		highLight(lblLocalContactNoInIncidentDetailsTab);
		softAssert.assertEquals(txt_LocalContactNo, localContactNo,
				"Local Contact No is not same");
		highLight(lblCustomerEmailIDInIncidentDetailsTab);
		softAssert.assertEquals(txt_CustomerEmailID, customerEmailID,
				"Customer Email ID is not same");
		highLight(lblDateInIncidentDateTime);
		softAssert.assertEquals(dateValue, date, "Date is not same");
		highLight(lblTimeInIncidentDetailsTab);
		softAssert.assertEquals(timeValue, time, "Time is not same");

		softAssert.assertAll();

	}

	public void selectTicketOfIncorrectAddress(String lst_Customer)
			throws Exception {
		/*
		 * // click on filter tab tabFilter.click();
		 * 
		 * // select the particular status Select status11; status11 = new
		 * Select(driver.findElement(By.name("m_strStatusFilter")));
		 * status11.selectByValue("Open");
		 */
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstIncorrectAddressInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				scrollDown(lstIncorrectAddressInTable.get(i));
				String flag = lstIncorrectAddressInTable.get(i).getAttribute(
						"alt");
				System.out.println(flag);

				String customer = lstCustomerInTable.get(i).getText();
				System.out.println("customer: " + customer);

				if (flag.equalsIgnoreCase("Violated")
						&& customer.equalsIgnoreCase(lst_Customer)) {
					scrollDown(lstIncorrectAddressInTable.get(i));
					highLight(lstIncorrectAddressInTable.get(i));
					scrollDown(lstCustomerInTable.get(i));
					highLight(lstCustomerInTable.get(i));
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					scrollDown(lstIDInTable.get(i));
					highLight(lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					break loop;
				}
			}

			if (sizePagination - 1 == p) {
				Assert.assertTrue(false,
						" Ticket is not Available for Closing Ticket");
			}
		}

	}

	public void overrideCustomerAddress(String txt_CustomerAddress) {
		SoftAssert softAssert = new SoftAssert();
		for (String Window : driver.getWindowHandles()) {

			driver.switchTo().window(Window);
		}
		tabRequestorForOpenInRequesterTab.click();
		try {
			highLight(driver.findElement(By.cssSelector(".incorrect-address")));
			// Click on incorrect Address
			driver.findElement(By.cssSelector(".incorrect-address")).click();

			Thread.sleep(1000);

			Alert alert = driver.switchTo().alert();

			// Get Alert message
			String alertMsg = alert.getText();
			System.out.println(alertMsg);

			softAssert.assertEquals(alertMsg, "Enter the Customer Address ",
					"Alert Message is not Match");

			Alert alert1 = driver.switchTo().alert();
			Thread.sleep(500);
			alert1.sendKeys(txt_CustomerAddress);
			Thread.sleep(1000);
			// System.out.println("Alert Text:" + addressValue);
			alert1.accept();
			driver.switchTo().defaultContent();

			Thread.sleep(3000);
			// Click on Requester Tab For Open
			tabRequestorForOpenInRequesterTab.click();

			Thread.sleep(1000);
			highLight(lblCustomerAddressInRequesterTab);
			String CustomerAddress = lblCustomerAddressInRequesterTab.getText();
			System.out.println(CustomerAddress);
			// String address = CustomerAddress.split("Customer Address :")[1];
			// System.out.println(address);

			softAssert.assertEquals(CustomerAddress, txt_CustomerAddress,
					"Override Address is not same");

		} catch (Exception e) {

			softAssert.assertTrue(false,
					" Incorrect Address link is not Present.");

		}
		softAssert.assertAll();

	}

	public void verifyIncidentDetailsAsPerSuper() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		btnEditInIncidentDetailsTab.click();

		Select ticketType = new Select(ddlTicketTypeInTicketDetailsPopup);
		int sizeTicketType = ticketType.getOptions().size() - 1;
		System.out.println("sizeTicketType: " + sizeTicketType);
		highLight(ddlTicketTypeInTicketDetailsPopup);

		Select mode = new Select(ddlModeInTicketDetailsPopup);
		int sizeMode = mode.getOptions().size() - 1;
		System.out.println("sizeMode: " + sizeMode);
		highLight(ddlModeInTicketDetailsPopup);

		Select level = new Select(ddlLevelInTicketDetailsPopup);
		int sizeLevel = level.getOptions().size() - 1;
		System.out.println("sizeLevel: " + sizeLevel);
		highLight(ddlLevelInTicketDetailsPopup);

		Select cts = new Select(ddlCTSInTicketDetailsPopup);
		int sizeCTS = cts.getOptions().size() - 1;
		System.out.println("sizeCTS: " + sizeCTS);
		highLight(ddlCTSInTicketDetailsPopup);

		Select troubleCategory = new Select(
				ddlTroubleCategoryInTicketDetailsPopup);
		int sizeTroubleCategory = troubleCategory.getOptions().size() - 1;
		System.out.println("sizeTroubleCategory: " + sizeTroubleCategory);
		highLight(ddlTroubleCategoryInTicketDetailsPopup);

		btnCancel.click();
		Thread.sleep(2000);
		logoutFromTechnician();
		loginIntoSuper();

		super_HomePage = new Super_HomePage();
		super_SDMasterPage = super_HomePage.clickSdMasterlink();
		Thread.sleep(500);
		super_TicketMasterPage = super_SDMasterPage.clickOnTicketMasterLink();
		Thread.sleep(500);
		super_TicketTypePage = super_TicketMasterPage.clickOnTicketTypeLink();
		Thread.sleep(500);
		int sizeTickeTypeInSuper = lstTicketTypeInSuper.size();
		System.out.println("sizeTickeTypeInSuper: " + sizeTickeTypeInSuper);
		softAssert.assertEquals(sizeTicketType, sizeTickeTypeInSuper,
				"Ticket Type size is not Same.");

		super_HomePage = new Super_HomePage();
		super_SDMasterPage = super_HomePage.clickSdMasterlink();
		Thread.sleep(1000);
		super_TicketMasterPage = super_SDMasterPage.clickOnTicketMasterLink();
		Thread.sleep(500);
		super_TicketModePage = super_TicketMasterPage.clickOnTicketModeLink();
		Thread.sleep(500);
		int sizeTickeModeInSuper = lstTicketModeInSuper.size();
		System.out.println("sizeTickeModeInSuper: " + sizeTickeModeInSuper);
		softAssert.assertEquals(sizeMode, sizeTickeModeInSuper,
				"Ticket Mode size is not Same.");

		super_HomePage = new Super_HomePage();
		super_SDMasterPage = super_HomePage.clickSdMasterlink();
		Thread.sleep(500);
		super_TicketMasterPage = super_SDMasterPage.clickOnTicketMasterLink();
		Thread.sleep(500);
		super_TicketLevelPage = super_TicketMasterPage.clickOnTicketLevelLink();
		Thread.sleep(500);
		int sizeTickeLevelInSuper = lstTicketLevelInSuper.size();
		System.out.println("sizeTickeLevelInSuper: " + sizeTickeLevelInSuper);
		softAssert.assertEquals(sizeLevel, sizeTickeLevelInSuper,
				"Ticket Level size is not Same.");

		super_HomePage = new Super_HomePage();
		super_SDMasterPage = super_HomePage.clickSdMasterlink();
		Thread.sleep(500);
		super_TicketMasterPage = super_SDMasterPage.clickOnTicketMasterLink();
		Thread.sleep(500);
		super_CTSStatusPage = super_TicketMasterPage.clickOnCTSStatusLink();
		Thread.sleep(500);
		int sizeCTSStatusInSuper = lstCTSStatusInSuper.size();
		System.out.println("sizeCTSStatusInSuper: " + sizeCTSStatusInSuper);
		softAssert.assertEquals(sizeCTS, sizeCTSStatusInSuper,
				"CTS Status size is not Same.");

		super_HomePage = new Super_HomePage();
		super_SDMasterPage = super_HomePage.clickSdMasterlink();
		Thread.sleep(500);
		super_TicketCategoryMasterPage = super_SDMasterPage
				.clickOnTicketCategoryMaster();
		Thread.sleep(500);
		Select ticketCategory = new Select(ddlTicketCategoryInSuper);
		int sizeTicketCategoryInSuper = ticketCategory.getOptions().size() - 1;
		System.out.println("sizeTicketCategoryInSuper: "
				+ sizeTicketCategoryInSuper);
		highLight(ddlTicketCategoryInSuper);

		softAssert.assertEquals(sizeTroubleCategory, sizeTicketCategoryInSuper,
				"Ticket Category size is not Same.");

		logoutFromSuper();
		loginIntoTechnician();

		softAssert.assertAll();

	}

	// Display Request/ Incident Tab
	public void verifyRequestorOrIncidentTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// Get text of Request/ Incident Tab
		String requestOrIncidentTab = driver.findElement(
				By.cssSelector(" .tab1.active>a>span")).getText();

		// Print text of Request/ Incident Tab
		System.out.println("Tab Name: " + requestOrIncidentTab);

		// Check text of Request/ Incident Tab is match or not
		softAssert.assertEquals(requestOrIncidentTab, "Requestor / Incident",
				"Tab is not correct");

		// Get Incident ID
		String getIncidentIdValue = txtIncidenID.getText();
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

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				btnEditInIncidentDetailsTab);
		Thread.sleep(1000);
		// Click on Edit button
		btnEditInIncidentDetailsTab.click();

		// Get the Title of Ticket Details Window
		String TitleOfTicketDetailsPopup = lblTitleTicketDetailsPopup.getText();
		System.out.println(TitleOfTicketDetailsPopup);

		softAssert.assertEquals("Ticket Details", TitleOfTicketDetailsPopup,
				"Pop-up is not same");
	btnCancel.click();

		softAssert.assertAll();
	}

	// Compare Id Of Requester/ Incident Tab
	public void compareIdOfRequesterOrIncidentTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// Get Incident ID
		String getIncidentIdValue = txtIncidenID.getText();
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
			String customerName = lblCustomerNameInRequesterTab.getText();
			System.out.println("Customer Name: " + customerName);

			Thread.sleep(1000);
			// driver.findElement(By.linkText(customerName)).click();
			lblCustomerNameInRequesterTab.click();

			for (String technicianWindow1 : driver.getWindowHandles()) {

				driver.switchTo().window(technicianWindow1);

			}
			boolean headingIsPresent;
			String headingInIncidentHistoryOfCustomerPage = lblHeadingIncidentHistoryPage
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
			tabRequestorForCloseInRequesterTab.click();
			Thread.sleep(1000);
			// Get Asset Id in Requester Table
			String assetId = lblAssetIdInRequesterTab.getText();
			System.out.println("Asset Id: " + assetId);

			Thread.sleep(1000);
			lblAssetIdInRequesterTab.click();

			for (String technicianWindow1 : driver.getWindowHandles()) {

				driver.switchTo().window(technicianWindow1);

			}
			boolean headingIsPresent;
			String headingInIncidentHistoryOfAssetIdPage = lblHeadingIncidentHistoryPage
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
			String serialNo = lblSerialNoInRequesterTab.getText();
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
				btnEditInIncidentDetailsTab);
		Thread.sleep(1000);
		// Click on Edit button
		btnEditInIncidentDetailsTab.click();

		// Get the Title of Ticket Details Window
		String TitleOfTicketDetailsPopup = lblTitleTicketDetailsPopup.getText();
		System.out.println(TitleOfTicketDetailsPopup);

		softAssert.assertEquals("Ticket Details", TitleOfTicketDetailsPopup,
				"Pop-up is not same");
		softAssert.assertAll();

	}

	// Check Upload File button without File in File attachments Tab
	public void checkNotificationWithoutFileType() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// click on that ID
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				btnUploadFileInFileAttachmentsTab);

		// Select File Type
		Select fileTypeDropDown = new Select(ddlFileTypeInFileAttachmentsTab);

		// Select Value of File Type
		fileTypeDropDown.selectByValue("Select");

		// Click Upload File Button
		btnUploadFileInFileAttachmentsTab.click();
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
				btnUploadFileInFileAttachmentsTab);

		// Select File Type
		Select fileTypeDropDown = new Select(ddlFileTypeInFileAttachmentsTab);
		// Value of File Type
		String fileTypeValue = "Customer Approval";
		// Select Value of File Type
		fileTypeDropDown.selectByValue(fileTypeValue);

		// Click Upload File Button
		btnUploadFileInFileAttachmentsTab.click();
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

	// Display list of file Page when we click on View Attachment button
	public void verifyListOfFilePage() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		for (String listOfFileWindow : driver.getWindowHandles()) {
			driver.switchTo().window(listOfFileWindow);

			btnViewAttachmentsInFileAttachmentsTab.click();

			for (String listOfFileWindow1 : driver.getWindowHandles()) {
				driver.switchTo().window(listOfFileWindow1);
			}

			String HeadingOfListOfFilesPage = lblHeadingListOfFilesPage
					.getText();
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
		// tab_PreliminaryAnalysis.click();

		// click on Edit button
		btnEditOfPreliminaryAnalysis.click();

		// get the message from TSD Assign Details window
		// window handler

		for (String tsdAssignDetailsWindow : driver.getWindowHandles()) {

			System.out.println(tsdAssignDetailsWindow);
			driver.switchTo().window(tsdAssignDetailsWindow);

		}
		highLight(lblTitleAllTabDetailsPage);
		String textOftsdAssignDetails = lblTitleAllTabDetailsPage.getText();
		System.out.println(textOftsdAssignDetails);

		// verify that the window is TSD Assign Details window or
		// not
		softAssert.assertEquals(textOftsdAssignDetails, "TSD Assign Details");

		System.out.println("Both the message is equal");
		softAssert.assertAll();

	}

	// verify TSD TextBox should not editable
	public void VerifyTSDTextBox() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// send the value to check TSD is editable or not on TSD
		// Text
		// Box

		txtTSD.sendKeys("abc");
		highLight(txtTSD);
		String tsdFieldValue = txtTSD.getAttribute("value");

		boolean isTsdFieldEditable;

		if (tsdFieldValue.contentEquals("abc")) {

			System.out.println("Field is editable");
			isTsdFieldEditable = true;

			// driver.findElement(By.linkText("Cancel")).click();

		}

		else

		{

			System.out.println("Field is non editable" + tsdFieldValue);
			isTsdFieldEditable = false;

			// driver.findElement(By.linkText("Cancel")).click();

		}
		softAssert.assertFalse(isTsdFieldEditable);
		softAssert.assertAll();

	}

	// If you select the technician name from list of your Technicians window ,
	// then selected technician should display in TSD text box

	public void matchTechnician() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// click on TSD button
		btnTSD.click();

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
		highLight(txtTSD);
		// get value from TSD text box
		String tsdTextBoxValue = txtTSD
				.getAttribute("value");
		System.out.println("TSD Text Box Value:-" + tsdTextBoxValue);

		// Match both the Technician Name

		softAssert.assertEquals(tsdTextBoxValue, technicalNameNewValue);
		softAssert.assertAll();

	}

	public void checkStatusField() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		String technicalStatus = ddlTechnicalStatus.getText();
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

		ddlTechnicalStatus.click();
		// click on cancel button
		btnCancel.click();
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
	public void checkUpdateDetailsButtonOfPreliminaryAnalysis(
			String lnk_Technicians, String ddl_TechnicalStatus,
			String txt_Observations, String txt_CustomerNameAndContactNo)
			throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// click on Preliminary Analysis Tab
		tabPreliminaryAnalysis.click();

		// click on Edit button
		btnEditOfPreliminaryAnalysis.click();

		// get the message from TSD Assign Details window
		// window handler

		for (String tsdAssignDetailsWindow : driver.getWindowHandles()) {

			System.out.println(tsdAssignDetailsWindow);
			driver.switchTo().window(tsdAssignDetailsWindow);

		}
		// click on TSD
		btnTSD.click();

		// Window handler
		for (String technicianWindow : driver.getWindowHandles()) {
			driver.switchTo().window(technicianWindow);

		}

		System.out.println(driver.getTitle());
		// Thread.sleep(3000);

		// select the particular technician, here used the first
		// name.
		int size = lstTechnician.size();
		for (int j = 0; j < size; j++) {

			String technicalNameValue = lstTechnician.get(j).getText();
			System.out.println("Technician Name:-" + technicalNameValue);

			if (technicalNameValue.contains(lnk_Technicians)) {
				lstTechnician.get(j).click();
				break;
			}
		}

		// go to first window
		for (String basicWindow : driver.getWindowHandles()) {
			driver.switchTo().window(basicWindow);

		}
		// get value from TSD text box
		String tsdTextBoxValue = driver.findElement(By.name("m_strTSDName"))
				.getAttribute("value");
		System.out.println("TSD Text Box Value:-" + tsdTextBoxValue);

		// Select Technical Status as Resolved
		Select selectTechnicalStatus= new Select(ddlTechnicalStatus);
		selectTechnicalStatus.selectByVisibleText(ddl_TechnicalStatus);

		// get the Selected Technician Status Value
		String technicalStatusValue = ddlTechnicalStatus.getAttribute("value");
		System.out.println("Selected Technician Status:-"
				+ technicalStatusValue);

		// clear the text bo
		txtObservation.clear();

		// click on Observations Text Box With any characters
		txtObservation.sendKeys(txt_Observations);

		// get the observation
		String observationValue = txtObservation.getAttribute("value");
		System.out.println("Selected observation value:-" + observationValue);

		if (txtCustomerName.getAttribute("value").isEmpty()) {
			// if field is empty send contact name or number
			txtCustomerName.sendKeys(txt_CustomerNameAndContactNo);

		} else {

			String storeValue = txtCustomerName.getAttribute("value");
			System.out.println(" Customer Name And Contact No:-" + storeValue);

		}
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		// click on Update Detail Button
		btnUpdateDetail.click();

		highLight(lblTSD);
		// select the TSD value from Preliminary Analysis window
		String tsdPreliminaryTab = lblTSD.getText();
		System.out.println("tsdPreliminaryTab: " + tsdPreliminaryTab);

		String splitTsdWord = tsdPreliminaryTab.split("TSD :")[1];
		System.out.println("splitTsdWord: " + splitTsdWord);

		String splitSword = splitTsdWord.split(" ")[0];
		System.out.println(splitSword);

		boolean tsdIsSame = true;
		if (lnk_Technicians.contains(splitSword)) {
			System.out.println("pass");
			tsdIsSame = true;

		} else {
			System.out.println("fail");
			tsdIsSame = false;
		}

		// Match both TSD, is the TSD name is display is as selected
		// TSD
		// or not
		softAssert.assertTrue(tsdIsSame, "TSD is not Same.");
		/*
		 * String tech = lnk_Technicians.split(" ")[0];
		 * System.out.println("tech: "+tech);
		 * softAssert.assertEquals(splitSword, tech,"TSD is not Same.");
		 */

		// select theTechnical Status value from Preliminary
		// Analysis
		// window
		highLight(lblTechnicalStatus);
		String technicalStatusPreliminaryTab = lblTechnicalStatus.getText();
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
		highLight(lblObservation);
		String observationPreliminaryTab = lblObservation.getText();
		String splitObservationWord = observationPreliminaryTab
				.split("Observations :")[1];
		System.out.println(splitObservationWord);

		// Match both Technical status value from TSD Assign Details
		// page and
		// Preliminary Analysis tab
		softAssert.assertEquals(splitObservationWord, observationValue);

		softAssert.assertAll();

	}

	public void verifyTechniciansInTSDAsPerSuper() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on Preliminary Analysis Tab
				tabPreliminaryAnalysis.click();

				// click on Edit button
				btnEditOfPreliminaryAnalysis.click();

				// get the message from TSD Assign Details window
				// window handler

				for (String tsdAssignDetailsWindow : driver.getWindowHandles()) {

					System.out.println(tsdAssignDetailsWindow);
					driver.switchTo().window(tsdAssignDetailsWindow);

				}
				// click on TSD
				btnTSD.click();

				// Window handler
				for (String technicianWindow : driver.getWindowHandles()) {
					driver.switchTo().window(technicianWindow);

				}

				// select the particular technician, here used the first
				// name.
				int sizeTechnician = lstTechnician.size();
				System.out.println("SizeOfTechnician: "+sizeTechnician);
				
				lstTechnician.get(0).click();
					

				// go to first window
				for (String basicWindow : driver.getWindowHandles()) {
					driver.switchTo().window(basicWindow);

				}

				btnCancel.click();
				
		

		logoutFromTechnician();
		loginIntoSuper();

		super_HomePage = new Super_HomePage();
		super_EmployeeMasterPage = super_HomePage.clickEmpolyeeMasterlink();
		Thread.sleep(500);
		super_EmployeeDetailPage = super_EmployeeMasterPage.clickOnEmployeeDetailLink();
		Thread.sleep(500);
		tabFilter.click();
		
		Select selectTechnicalStatus= new Select(ddlSearchByRole);
		selectTechnicalStatus.selectByVisibleText("TSD");
		
		int sizeRow =lstRowInTable.size();
		System.out.println("sizeRow: "+sizeRow);
		softAssert.assertEquals(sizeRow, sizeTechnician,
				"Technician size is not Same.");

		logoutFromSuper();
		loginIntoTechnician();

		softAssert.assertAll();

	}

	// After click on the data cancel button the data should not updated
	public void checkCancelButton() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		

		// click on ETA and Technician tab
		tabPreliminaryAnalysis.click();
		String tsdBeforeDataEnter = lblTSD.getText();
		System.out.println("TSD Before data enter:-" + tsdBeforeDataEnter);

		String technicalStatusBeforeDataEnter = lblTechnicalStatus.getText();
		System.out.println("Technical Status Before data enter:-"
				+ technicalStatusBeforeDataEnter);

		String observationBeforeDataEnter = lblObservation.getText();
		System.out.println("Technical Status Before data enter:-"
				+ observationBeforeDataEnter);

		// click on Edit button
		btnEditOfPreliminaryAnalysis.click();

		// click on TSD
		btnTSD.click();

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
		selectTechnicalStatus = new Select(ddlTechnicalStatus);
		selectTechnicalStatus.selectByVisibleText("Resolved");

		// clear the text box
		txtObservation.clear();

		// click on Observations Text Box With any characters
		txtObservation.sendKeys("The Defect is resolved");

		if (txtCustomerName.getAttribute("value").isEmpty()) {
			// if field is empty send contact name or number
			txtCustomerName.sendKeys("Bhagyashree");

		} else {

			String storeValue = txtCustomerName.getAttribute("value");
			System.out.println(" Customer Name And Contact No:-" + storeValue);

		}

		// click on cancel button
		btnCancel.click();

		highLight(lblTSD);
		// select the TSD value from Preliminary Analysis window
		String tsdPreliminaryTab = lblTSD.getText();
		System.out.println(tsdPreliminaryTab);

		// Match After click on cancel the value should not change
		softAssert.assertEquals(tsdPreliminaryTab, tsdBeforeDataEnter);

		// select theTechnical Status value from Preliminary
		// Analysis
		// window
		highLight(lblTechnicalStatus);
		String technicalStatusPreliminaryTab = lblTechnicalStatus.getText();
		System.out.println(technicalStatusPreliminaryTab);

		// Match After click on cancel the value should not change
		softAssert.assertEquals(technicalStatusPreliminaryTab,
				technicalStatusBeforeDataEnter);

		// select theTechnical Status value from Preliminary
		// Analysis
		// window
		highLight(lblObservation);
		String observationPreliminaryTab = lblObservation.getText();
		System.out.println(observationPreliminaryTab);

		// Match After click on cancel the value should not change
		softAssert.assertEquals(observationPreliminaryTab,
				observationBeforeDataEnter);

		softAssert.assertAll();

	}

	public void checkUpdateDetailsButtonOfETAAndTechnician() throws Exception {
		SoftAssert softAssert = new SoftAssert();


		
		  // click on ETA and Technician tab 
		tabETATechnician.click();
		  
		  // click on Call Assign To Technician Button.
		  btnCallAssignToTechnician.click();
		  
		  // get the message from Technician Assign And ETA Details window  handler
		  
		  for (String TechnicianAssignAndETADetailsWindow : driver
		  .getWindowHandles()) {
		  driver.switchTo().window(TechnicianAssignAndETADetailsWindow);
		  
		  }
		 
		
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		// This is Optional
		// Used If you want select Previous date
		int nextDay = Integer.parseInt(currentDay);
		String nxtDay = Integer.toString(nextDay);

		calETACalender.click();

		// select Date in Calendar

		for (WebElement day : dtpInETACalender) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(nxtDay)) {
				Thread.sleep(1000);
				highLight(day);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		

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

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE) + 1;
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		if (min3.length() == 1) {
			min3 = "0" + min3;
			System.out.println("min3: " + min3);
		}

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlETATimeHour) {

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

		for (WebElement minOfSystem : ddlETATimeMinute) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min3)) {

				Thread.sleep(1000);
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);
				break;
			}

		}

		String etadate = txtETADateInETADetailsPage.getAttribute("value");
		System.out.println("date: " + etadate);
		// concatenation of Hrs & min
		// Format of Date Time
		// Format Time
		String timePattern = "HH:mm";
		DateFormat timeFormat = new SimpleDateFormat(timePattern);

		String hrsMin = hrs.concat(":" + min3);
		System.out.println(hrsMin);
		Date ETATime = (Date) timeFormat.parse(hrsMin);
		System.out.println("ETATime: " + ETATime);

		Actions action = new Actions(driver);
		action.moveToElement(btnAppointmentDate).doubleClick().build()
				.perform();
		// Thread.sleep(3000);

		// select Date
		String getDateValue = null;

		List<WebElement> allDates = driver.findElements(By
				.cssSelector("div[id='fd-dp-7']>table>tbody>tr>td"));

		for (WebElement ele : allDates) {

			String date2 = ele.getText();

			if (date2.equalsIgnoreCase("30")) {
				Thread.sleep(1000);
				highLight(ele);
				ele.click();
				getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		String appointmentDate = txtAppointmentDate.getAttribute("value");
		System.out.println("date: " + appointmentDate);

		// list of Appointment List
		// textBox_AppointmentTime.click();

		String apppointmentTimetext = "7pm - 9pm";
		// select Appointment Time
		scrollDown(txtAppointmentTime);
		Select AppointmentTime;
		AppointmentTime = new Select(txtAppointmentTime);
		AppointmentTime.selectByValue("7pm - 9pm");
		// Thread.sleep(3000);

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		btnUpdateDetail.click();
		// Thread.sleep(3000);
		String notificationText = null;
		try {
			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			Thread.sleep(1000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			Thread.sleep(1000);
			technicianAlert.accept();
			driver.switchTo().defaultContent();

			notificationText = msgNotification.getText();
			System.out.println(notificationText);

		} catch (Exception e) {

			
			driver.switchTo().defaultContent();

			notificationText = msgNotification.getText();
			System.out.println(notificationText);

		}

		// go to first window
		for (String basicWindow : driver.getWindowHandles()) {
			driver.switchTo().window(basicWindow);

		}
		
		highLight(msgNotification);
		softAssert.assertEquals(notificationText,
				"Incident Updated SuccessFully", "Notification is not Match");


		// after selecting the ETA Date ,that Date is appear in
		// ETA text box
		String selectedDate = lblETADateInETAAndTechnicianTab.getText();
		System.out.println("selected Date is:-" + selectedDate);
		String splitDate = selectedDate.split(" ")[3];
		System.out.println("splitName: " + splitDate);

		String selectedTime = lblETATimeInETAAndTechnicianTab.getText();
		System.out.println("selected Date is:-" + selectedTime);
		String splitTime = selectedTime.split(" ")[3];
		System.out.println("splitName: " + splitTime);

		// get the value from ETA and Technician window
		String appointmentDateBeforeDataEnter = lblAppointmentDate.getText();
		System.out.println("Appointment Date:-"
				+ appointmentDateBeforeDataEnter);
		String appointDate = appointmentDateBeforeDataEnter.split(" ")[2];
		System.out.println("splitName: " + appointDate);

		String appointmentTimeBeforeDataEnter = lblAppointmentTime.getText();
		System.out.println("Appointment time:-"
				+ appointmentTimeBeforeDataEnter);
		String appointTime = appointmentTimeBeforeDataEnter.split("Appointment Time: ")[1];
		System.out.println("splitName: " + appointTime);

		highLight(lblAppointmentDate);
		// Match that both ETA Date value is same or not
		softAssert.assertEquals(appointDate, appointmentDate,
				"Appointment Date is not same");
		System.out.println("The Date is same");
		Thread.sleep(1000);

		highLight(lblAppointmentTime);
		// Match that both ETA Time Minute value is same or not
		softAssert.assertEquals(appointTime, apppointmentTimetext,
				"Appointment Time is not same");
		System.out.println("The Time is same");
		Thread.sleep(1000);

		highLight(lblETADateInETAAndTechnicianTab);
		// Match that both ETA Date value is same or not
		softAssert.assertEquals(etadate, splitDate, "ETA Date is not same");
		System.out.println("The Date is same");
		Thread.sleep(1000);

		highLight(lblETATimeInETAAndTechnicianTab);
		// Match that both ETA Time Minute value is same or not
		softAssert.assertEquals(hrsMin, splitTime, "ETA Time is not same");
		System.out.println("The Time is same");
		Thread.sleep(1000);


		softAssert.assertAll();
	}
	
	// If user click on Call Assign To Technician button then,
	// 'Technician Assign And ETA Details' pop up should display
	public void displayTechnicianAssignAndETADetailsPopup() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// click on ETA and Technician tab
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		// get the message from Technician Assign And ETA Details
		// window
		// window handler

		for (String TechnicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(TechnicianAssignAndETADetailsWindow);
			driver.switchTo().window(TechnicianAssignAndETADetailsWindow);

		}
		Thread.sleep(1000);

		String textOfTechnicianAssignAndETADetails = driver.findElement(
				By.cssSelector("span[class='rectagleBoxHeading']")).getText();
		System.out.println(textOfTechnicianAssignAndETADetails);

		// verify that the window is TSD Assign Details window or
		// not
		softAssert.assertEquals(textOfTechnicianAssignAndETADetails,
				"Technician Assign And ETA Details");
		System.out.println("Both the message is equal");

		softAssert.assertAll();
	}

	public void applyOpenFilter() throws Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Open");

	}

	// If user click on Call Assign To Technician button then,
	// 'Technician Assign And ETA Details' pop up should display
	public void selectTicketForPunchETA() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		applyOpenFilter();

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			List<WebElement> status = lstStatusInTable;
			int size = status.size();
			System.out.println(size);

			for (int i = 0; i < size; i++) {

				String statusValue = status.get(i).getText();
				System.out.println(statusValue);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				if (statusValue.equalsIgnoreCase("Open") && ETA.equals(""))

				{

					// get ID from list of Available Spares Window
					String idValue = lstIDInTable.get(i).getText();
					System.out.println(idValue);

					// click on that ID
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));

					highLight(lstIDInTable.get(i));
					lstIDInTable.get(i).click();
					// Thread.sleep(2000);
					break loop;

				}

			}
			if (sizePagination - 1 == p) {
				System.out.println("Ticket is not Available for Punching ETA");
				softAssert.assertTrue(false, " Ticket is not Available");

			}

		}
		softAssert.assertAll();
	}

	public void assignTechnicianAndPunchETA() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		/*
		 * // click on ETA and Technician tab tab_ETATechnician.click();
		 * 
		 * // click on Call Assign To Technician Button.
		 * button_CallAssignToTechnician.click();
		 * 
		 * // get the message from Technician Assign And ETA Details window
		 * handler
		 * 
		 * for (String TechnicianAssignAndETADetailsWindow : driver
		 * .getWindowHandles()) {
		 * 
		 * System.out.println(TechnicianAssignAndETADetailsWindow);
		 * driver.switchTo().window(TechnicianAssignAndETADetailsWindow);
		 * 
		 * }
		 */

		if (txtTechnician.getText().contains("")) {

			// click the first list of click on first list symbol of
			// Technician Field
			btnTechnicianList.click();

			// Window handler
			for (String technicianWindow : driver.getWindowHandles()) {
				driver.switchTo().window(technicianWindow);

			}

			/*
			 * // select Business Unit of that window Select
			 * technicianBusinessUnit; technicianBusinessUnit = new
			 * Select(driver.findElement(By .name("m_strBusinessUnit")));
			 * technicianBusinessUnit.selectByVisibleText("test");
			 * 
			 * Select city; city = new
			 * Select(driver.findElement(By.name("m_strCity")));
			 * city.selectByVisibleText("Mumbai");
			 * 
			 * driver.findElement(
			 * By.xpath(".//*[@id='right']/table/tbody/tr[3]/td[3]/input"))
			 * .click();
			 * 
			 * // Thread.sleep(3000);
			 */
			int size = lstTechnicianName.size();

			for (int j = 0; j < size; j++) {

				// Thread.sleep(2000);
				String technicianVlaue = lstTechnicianName.get(j).getText();
				System.out.println(technicianVlaue);

				if (technicianVlaue.contains("Pranjali Deshpande"))

				{
					// Thread.sleep(2000);
					lstTechnicianName.get(j).click();
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

		calETACalender.click();

		// select Date in Calendar

		for (WebElement day : dtpInETACalender) {

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

		for (WebElement hrsofSystem : ddlETATimeHour) {

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

		for (WebElement minOfSystem : ddlETATimeMinute) {

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
		btnUpdateDetail.click();
		// Thread.sleep(3000);
		String notificationText = null;
		try {
			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			Thread.sleep(1000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			Thread.sleep(1000);
			technicianAlert.dismiss();
			driver.switchTo().defaultContent();

			notificationText = msgNotification.getText();
			System.out.println(notificationText);
			softAssert
					.assertEquals(
							technicianAlertMessage,
							"DO You Want To Assign Other Calls To The Same Engineer For This Asset.",
							"Alert Message is not Same.");
		} catch (Exception e) {

			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			btnUpdateDetail.click();
			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			Thread.sleep(1000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			Thread.sleep(1000);
			technicianAlert.accept();
			// driver.switchTo().defaultContent();

			// get the message from that alert box
			Alert technicianAlert1 = driver.switchTo().alert();
			Thread.sleep(1000);

			String technicianAlertMessage1 = technicianAlert1.getText();
			System.out.println("Alert Text:" + technicianAlertMessage1);
			Thread.sleep(1000);
			technicianAlert1.dismiss();
			softAssert
					.assertEquals(
							technicianAlertMessage1,
							"DO You Want To Assign Other Calls To The Same Engineer For This Asset.",
							"Alert Message is not Same.");

			driver.switchTo().defaultContent();

			notificationText = msgNotification.getText();
			System.out.println(notificationText);

		}

		softAssert.assertEquals(notificationText,
				"Incident Updated SuccessFully", "Notification is not Match");

		softAssert.assertAll();
	}



	// If calls regarding same Asset are assign to another technician then
	// in ETA tab while update ETA details alert box should display as
	// 'DO You Want To Assign Other Calls To The Same Engineer For This Asset.'
	public void CheckAlertMessage() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		// go to technician window
		for (String technicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(technicianAssignAndETADetailsWindow);
			driver.switchTo().window(technicianAssignAndETADetailsWindow);

		}

		// clear all the field
		txtTechnician.clear();

		// click the first list of click on first list symbol of
		// Technician
		// Field
		btnTechnicianList.click();

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
		int size = lstTechnicianName.size();

		for (int j = 0; j < size; j++) {

			// Thread.sleep(2000);
			String technicianVlaue = lstTechnicianName.get(j).getText();
			System.out.println(technicianVlaue);

			if (technicianVlaue.contains("Pranjali Deshpande"))

			{
				// Thread.sleep(2000);
				lstTechnicianName.get(j).click();
				break;

			}

		}

		// go to first window
		for (String basicWindow : driver.getWindowHandles()) {
			driver.switchTo().window(basicWindow);

		}
		// Click on update button
		btnUpdateDetail.click();
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

			// softAssert.assertAll();
		}

		softAssert.assertAll();
	}

	

	
	// After click on Cancel button then data should not get fill into
	// respective fields

	public void checkCancelButtonFunctionality() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		tabETAAndTechnician.click();
		// get the value from ETA and Technician window
		String appointmentDateBeforeDataEnter = lblAppointmentDate.getText();
		System.out.println("Appointment Date:-"
				+ appointmentDateBeforeDataEnter);

		String appointmentTimeBeforeDataEnter = lblAppointmentTime.getText();
		System.out.println("Appointment time:-"
				+ appointmentTimeBeforeDataEnter);

		String etaDateBeforeDataEnter = lblETADate.getText();
		System.out.println("ETA date:-" + etaDateBeforeDataEnter);

		String etaTimeBeforeDataEnter = lblETATime.getText();
		System.out.println("ETA Time:-" + etaTimeBeforeDataEnter);

		String Technician = lblTechnician.getText();
		System.out.println("Technician:-" + Technician);

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		for (String technicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(technicianAssignAndETADetailsWindow);
			driver.switchTo().window(technicianAssignAndETADetailsWindow);

		}
		
		String textOfTechnicianAssignAndETADetails = driver.findElement(
				By.cssSelector("span[class='rectagleBoxHeading']")).getText();
		System.out.println(textOfTechnicianAssignAndETADetails);

		// verify that the window is TSD Assign Details window or
		// not
		softAssert.assertEquals(textOfTechnicianAssignAndETADetails,
				"Technician Assign And ETA Details");
		System.out.println("Both the message is equal");

		txtETADate.sendKeys("2019-05-25");
		String tsdFieldValue = txtETADate.getAttribute("value");

		boolean isETADateFieldEditable;

		if (tsdFieldValue.contentEquals("2019-05-25")) {

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
		// select appointment date
		Actions action = new Actions(driver);
		action.moveToElement(btnAppointmentDate).doubleClick().build()
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
		AppointmentTime = new Select(txtAppointmentTime);
		AppointmentTime.selectByVisibleText("7pm - 9pm");
		// Thread.sleep(3000);

		// select ETA date
		action.moveToElement(calETACalender).doubleClick().build().perform();
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

		btnUpdateDetail.click();
		// Thread.sleep(3000);

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		// go to first window
		softAssert.assertEquals(alertMessage, "Please enter ETA Time.");

		Select etaTimeMinute;
		etaTimeMinute = new Select(txtETATimeMinute);
		etaTimeMinute.selectByVisibleText("15");
		// Thread.sleep(3000);

		Select etaTimeSecond;
		etaTimeSecond = new Select(txtETATimeSecond);
		etaTimeSecond.selectByVisibleText("30");
		// Thread.sleep(3000);

		// click on cancel button
		btnCancel.click();

		// click on Call Assign To Technician Button.
		// button_CallAssignToTechnician.click();

		for (String technicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(technicianAssignAndETADetailsWindow);
			driver.switchTo().window(technicianAssignAndETADetailsWindow);

		}

		// after enter all the value and press cancel button,
		// get value from ETA Technician tab
		String appointmentDateAfterDataEnter = lblAppointmentDate.getText();
		System.out.println("Technician value after click on cancel:-"
				+ appointmentDateAfterDataEnter);

		String appointmentTimeAfterDataEnter = lblAppointmentTime.getText();
		System.out.println("Technician value after click on cancel:-"
				+ appointmentTimeAfterDataEnter);

		String etaDateAfterDataEnter = lblETADate.getText();
		System.out.println("Technician value after click on cancel:-"
				+ etaDateAfterDataEnter);

		String etaTimeAfterDataEnter = lblETATime.getText();
		System.out.println("Technician value after click on cancel:-"
				+ etaTimeAfterDataEnter);

		String TechnicianValueAfterDataEnter = lblTechnician.getText();
		System.out.println("Technician value after click on cancel:-"
				+ TechnicianValueAfterDataEnter);

		// Match both the value it should same
		highLight(lblAppointmentDate);
		Thread.sleep(1000);
		softAssert.assertEquals(appointmentDateBeforeDataEnter,
				appointmentDateAfterDataEnter);
		highLight(lblAppointmentTime);
		Thread.sleep(1000);
		softAssert.assertEquals(appointmentTimeBeforeDataEnter,
				appointmentTimeAfterDataEnter);

		highLight(lblTechnician);
		Thread.sleep(1000);
		softAssert.assertEquals(Technician, TechnicianValueAfterDataEnter);
		highLight(lblETADate);
		Thread.sleep(1000);
		softAssert.assertEquals(etaDateBeforeDataEnter, etaDateAfterDataEnter);

		
		softAssert.assertAll();
	}

	// check on Resends SMS button
	public void checkResendSMSButton() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on resend SMS button
		btnResendSMS.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);

		String resendAlertMessage = alert.getText();
		System.out.println("Alert Text:" + resendAlertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(resendAlertMessage,
				"Do You Want To Resend SMS To Technician");

		String dialogueBoxMessage = driver.findElement(
				By.cssSelector("#dialogBoxSuccess")).getText();
		System.out.println(dialogueBoxMessage);

		softAssert.assertEquals(dialogueBoxMessage, "SMS Sent Successfully");

		// Thread.sleep(2000);
		driver.findElement(By.cssSelector("#dialogBoxSuccess>img")).click();
		softAssert.assertAll();
	}

	public void checkETAAndSLA() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// click on filter

		tabRequestor.click();

		// Thread.sleep(3000);
		// click on customer SLA in requester tab
		String customerSLA = tabCustomerSLA.getText();
		System.out.println(customerSLA);
		String splitCustomerSLAWord = customerSLA.split("Customer SLA:")[1];
		System.out.println(splitCustomerSLAWord);
		String splitHRs = splitCustomerSLAWord.split("hrs")[0];
		System.out.println("splitHRs:-" + splitHRs);
		String splitSpace = splitHRs.split(" ")[1];
		int result = Integer.parseInt(splitSpace);
		System.out.println("integer result:-" + result);

		// Thread.sleep(3000);
		String ticketLogTime = lblTicketLogTime.getText();
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
		tabETATechnician.click();

		// get the value from ETA and Technician window
		String appointmentDateBeforeDataEnter = lblAppointmentDate.getText();
		System.out.println("Appointment Date:-"
				+ appointmentDateBeforeDataEnter);

		String appointmentTimeBeforeDataEnter = lblAppointmentTime.getText();
		System.out.println("Appointment time:-"
				+ appointmentTimeBeforeDataEnter);

		String etaDateBeforeDataEnter = lblETADate.getText();
		System.out.println("ETA date:-" + etaDateBeforeDataEnter);

		String etaTimeBeforeDataEnter = lblETATime.getText();
		System.out.println("ETA Time:-" + etaTimeBeforeDataEnter);

		String Technician = lblTechnician.getText();
		System.out.println("Technician:-" + Technician);

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		for (String technicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(technicianAssignAndETADetailsWindow);
			driver.switchTo().window(technicianAssignAndETADetailsWindow);

		}

		Actions action = new Actions(driver);
		action.moveToElement(calETACalender).doubleClick().build().perform();
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

		String getDateValue = txtETADate.getAttribute("value");
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
		for (WebElement hrsofSystem : ddlETATimeMinute) {

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
		for (WebElement minOfSystem : ddlETATimeSecond) {

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

			String getAppointmentDate = txtAppointmentDate
					.getAttribute("value");
			System.out.println(getAppointmentDate);

			String getAppointmentTime = txtAppointmentTime
					.getAttribute("value");
			System.out.println(getAppointmentTime);

			btnUpdateDetail.click();
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
			btnUpdateDetail.click();
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

			String message = msgNotification.getText();

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
		SoftAssert softAssert = new SoftAssert();

		// click on search ticket tab
		tabSearchTicketOpen.click();

		// enter the valid id in field
		txtSearchAssetID.sendKeys("Wor-Mum-0001");

		// click on Go button
		btnAssetIDGo.click();

		// click on first id in Id column
		lnkFirstIdInTable.click();

		// click on ETA and Technician tab
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		for (String TechnicianAssignAndETADetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(TechnicianAssignAndETADetailsWindow);
			driver.switchTo().window(TechnicianAssignAndETADetailsWindow);

		}

		txtTechnician.clear();
		// click the first list of click on first list symbol of Technician
		// Field
		btnTechnicianList.click();

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
		int size = lstTechnicianName.size();

		for (int i = 0; i < size; i++) {

			// Thread.sleep(2000);
			String technicianValue = lstTechnicianName.get(i).getText();
			System.out.println(technicianValue);

			if (technicianValue.contains("Pranjali Deshpande"))

			{
				// Thread.sleep(2000);
				lstTechnicianName.get(i).click();

				for (String TechnicianAssignAndETADetailsWindow : driver
						.getWindowHandles()) {

					System.out.println(TechnicianAssignAndETADetailsWindow);
					driver.switchTo().window(
							TechnicianAssignAndETADetailsWindow);

				}

				// Click on update button
				btnUpdateDetail.click();
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
				tabFilter.click();

				// select the particular status
				Select status;
				status = new Select(driver.findElement(By
						.name("m_strStatusFilter")));
				status.selectByVisibleText("Open");
				// Thread.sleep(3000);

				// click on search ticket tab
				tabSearchTicketOpen.click();

				// enter the valid id in field
				txtSearchAssetID.sendKeys("Wor-Mum-0001");

				// click on Go button
				btnAssetIDGo.click();
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

	public void punchATA() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Click on ATA Tab
		tabATA.click();

		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		String currentDay = Integer.toString(dayOfMonth);
		System.out.println(currentDay);

		// Click on Calendar
		calATADetailsPage.click();

		// select Date in Calendar
		for (WebElement day : dtpCalendarInATADetailsPage) {

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
		String currentDate = txtATADateInATADetailsPage.getAttribute("value");
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
		for (WebElement hrsofSystem : ddlHrsOfATATimeInATADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down
		for (WebElement minOfSystem : ddlMinOfATATimeInATADetailsPage) {

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
				ddlMachineAvailableInATADetailsPage);
		machineAvailable.selectByVisibleText("Yes");

		// Click on Update Details
		btnUpdateDetailsInATADetailsPage.click();

		String notificationText = msgNotification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Incident Updated Successfully", "Notification is not Match");

		softAssert.assertAll();

	}

	// After select only technician and appointment date/time in ETA tab and if
	// user click on Edit button in ATA tab then notification should display as
	// 'Please Select ETA And Technician First.'
	public void displayNotificationWithoutETAInATATab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

						// Click on ATA Tab
						tabATA.click();
						// Click on Edit Button In ATA Tab
						btnEditInATATab.click();
						// Get Notification
						// Thread.sleep(5000);
						String notificationText = msgNotification.getText();
						System.out.println(notificationText);

						/*
						 * if(notificationText.contains("SMS Sent Successfully"))
						 * { btnCloseNotification.click(); }
						 * 
						 * String notificationValue = notification.getText();
						 * System.out.println(notificationValue);
						 */
						Thread.sleep(1000);
						softAssert.assertEquals(notificationText,
								"Please Select ETA And Technician First.",
								"Notification is not Match");

					
		
		softAssert.assertAll();
	}

	// If user select ATA date and Time less than Incident Date and Time then
	// notification should display as ' ATA Date Time should be greater than
	// Incident Date Time '
	public void checkATATab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		

					// Get Date & Time
					 Thread.sleep(1000);
					String dateTimeText = lblDateInIncidentDateTime.getText();
					System.out.println("dateTimeText: "+dateTimeText);
					String date = dateTimeText.split(":")[1];
					System.out.println("dateValue: "+date);
					
					// Get Time	
					String timeText = lblTimeInIncidentDetailsTab.getText();
					System.out.println("timeText: "+timeText);
					String timeValue = timeText.split("Time ")[1];	
					System.out.println("\timeValue " + timeValue);

					String dateValue = timeText.split(" ")[1];
					System.out.println("dateValue: "+dateValue);
					
					String dateValue1 = timeText.split(" ")[3];
					System.out.println("dateValue: "+dateValue1);
					
					String time = dateValue.concat(":").concat(dateValue1);
					System.out.println("time: "+time);
					
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
					int preDay = Integer.parseInt(currentDay) + 1;
					String previousDay = Integer.toString(preDay);
					calATADetailsPage.click();

					// select Date in Calendar

					for (WebElement day : dtpCalendarInATADetailsPage) {

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

					// Click on Update Details button in ATA Details Page
					btnUpdateDetailsInATADetailsPage.click();

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
					
					Select machineAvailable = new Select(
							ddlMachineAvailableInATADetailsPage);
					machineAvailable.selectByVisibleText("Yes");
					btnUpdateDetailsInATADetailsPage.click();

					if (dateTimeOfATA.compareTo(dateTimeOfIncident) > 0
							&& dateTimeOfATA.compareTo(dateTimeOfIncident) > 0) {
						System.out
								.println("ATA Date & Time is Greter than Incident Date & Time\n");

					} else if (dateTimeOfATA.compareTo(dateTimeOfIncident) <= 0
							&& dateTimeOfATA.compareTo(dateTimeOfIncident) <= 0) {
						System.out
								.println("ATA Date & Time is Less than Incident Date & Time\n");
					}

						// Get Notification
						// Thread.sleep(5000);
						String notificationText = msgNotification.getText();
						System.out.println(notificationText);

						softAssert
								.assertEquals(
										notificationText,
										"ATA should be either less or equal to current Date and time.",
										"Notification is not Match");
					
		softAssert.assertAll();
	}

	// If user select ATA date and Time less than ETA Date and Time then
	// notification should display as ' Incident Updated Successfully ' and
	// data/time should get update on ATA tab
	public void checkUpdateDetailsButtonOfATATab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// Format Date
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);

		// Format Time
		String timePattern = "HH:mm";
		DateFormat timeFormat = new SimpleDateFormat(timePattern);

		// Click on ETA and Technician Tab
		tabETAAndTechnician.click();
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
		calATADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInATADetailsPage) {

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
		String currentDate = txtATADateInATADetailsPage.getAttribute("value");
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

		/*
		 * // select Min in Drop down List<WebElement> allMin = driver
		 * .findElements(By .cssSelector(
		 * ".modal-content>div>div>table>tbody>tr:nth-of-type(4)>td>select:nth-of-type(2)>option"
		 * ));
		 */
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

		Select machineAvailable = new Select(
				ddlMachineAvailableInATADetailsPage);
		machineAvailable.selectByVisibleText("Yes");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		btnUpdateDetailsInATADetailsPage.click();

		if (dateTimeOfATA.compareTo(dateTimeOfETA) <= 0
				&& dateTimeOfATA.compareTo(dateTimeOfETA) <= 0) {
			System.out
					.println("ATA Date & Time is Less than ETA Date & Time\n");

			// Get Notification
			// Thread.sleep(5000);
			String notificationText = msgNotification.getText();
			System.out.println(notificationText);

			softAssert.assertEquals(notificationText,
					"Incident Updated Successfully",
					"Notification is not Match");
		}
		// Click on ATA Tab
				tabATA.click();

				highLight(lblATADateInATATab);
				// Get ATA Date
				String ATADateText = lblATADateInATATab.getText();
				System.out.println(ATADateText);
				String dateOfATADate = ATADateText.split("ATA Date : ")[1];
				System.out.println(dateOfATADate);

				highLight(lblATATimeInATATab);
				// Get ATA Time
				String ATATimeText = lblATATimeInATATab.getText();
				System.out.println(ATATimeText);
				String timeOfATATime = ATATimeText.split("ATA Time : ")[1];
				System.out.println(timeOfATATime);

				highLight(lblMachineAvailableInATATab);
				// Get Machine Available
				String MachineAvailableText = lblMachineAvailableInATATab.getText();
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

	// In ATA tab if user does not select Machine Available option then
	// notification should display as 'Please Select Machine Availability.'
	public void displayAlertWithoutSelectMachineAvailable() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// Click on ATA Tab
		tabATA.click();

		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();

		// Click on Update Details button in ATA Details Page
		btnUpdateDetailsInATADetailsPage.click();

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
		tabATA.click();

		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();

		// Select Machine Available
		Select machineAvailable = new Select(
				ddlMachineAvailableInATADetailsPage);
		machineAvailable.selectByVisibleText("No");

		btnPauseReasonInATADetailsPage.click();
		for (String Window : driver.getWindowHandles()) {
			driver.switchTo().window(Window);
		}
		// Thread.sleep(1000);
		lstListOfPauseReasonsPage.get(0).click();
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
		calAutoResumeDateInATADetailsPage.click();

		// select Date in Calendar
		for (WebElement day : dtpAutoResumeDateInATADetailsPage) {

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
		String currentDate = txtATADateOfAutoResumeDateInATADetailsPage
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

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE) + 1;
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		if (min3.length() == 1) {
			min3 = "0" + min3;
			System.out.println("min3: " + min3);
		}
		// select Hrs in Drop down
		for (WebElement hrsofSystem : ddlHrsOfATATimeOfAutoResumeDateInATADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down
		for (WebElement minOfSystem : ddlMinOfATATimeOfAutoResumeDateInATADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min3)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		// Click on Update Details
		btnUpdateDetailsInATADetailsPage.click();
		// Thread.sleep(1000);
		String headingOfTab = tabSelected.getText();
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
		tabPauseInTicketForm.click();

		// Click on Edit Button In Pause Tab
		btnEditInPauseTab.click();

		for (String Window : driver.getWindowHandles()) {
			driver.switchTo().window(Window);
		}

		// Get Heading
		// Thread.sleep(5000);
		String headingOfPauseDetailsPage = lblTitleAllTabDetailsPage.getText();
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
		txtAutoResumeDateInPauseDetailsPage.sendKeys("2018-05-25");
		String autoResumeDate = txtAutoResumeDateInPauseDetailsPage
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
		btnListOfPauseReasonsInPausepage.click();
		for (String listOfPauseReasons : driver.getWindowHandles()) {
			driver.switchTo().window(listOfPauseReasons);
		}

		// Get Heading
		String HeadingOflistOfPauseReasonsPage = lblHeadingListOfPauseReasonsPage
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
		String pauseReason = lstPauseReasonsInListOfPauseReasonsPage.get(1)
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
		calPauseDetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInPauseDetailsPage) {

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
		String currentDate = txtAutoResumeDateInPauseDetailsPage
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

		for (WebElement hrsofSystem : ddlHrsOfAutoResumeTimeInPauseDetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfAutoResumeTimeInPauseDetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}
		btnUpdateDetailsInPauseDetailsPage.click();
		// Thread.sleep(3000);

		tabLatestPauseInTicketForm.click();

		String pauseReasonText = lblPauseReasonInLatestPauseTab.getText();
		System.out.println(pauseReasonText);

		softAssert.assertEquals(pauseReason, pauseReasonText,
				"Pause Reason is not same");
		softAssert.assertAll();

	}

	// after completion resume date and time, In pause tab end date/time should
	// display as resume date/time
	public void matchResumeDateAndTimeAndPauseReason() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		tabPauseInTicketForm.click();
		
		// Click on Edit Button In Pause Tab
				btnEditInPauseTab.click();
				
				// Click on List Of Pause Reasons Button
				btnListOfPauseReasonsInPausepage.click();
				for (String listOfPauseReasons : driver.getWindowHandles()) {
					driver.switchTo().window(listOfPauseReasons);
				}
		// Get Pause Reason
		String pauseReason = lstPauseReasonsInListOfPauseReasonsPage.get(1)
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
		calPauseDetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInPauseDetailsPage) {

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
		String resumeDateText = txtAutoResumeDateInPauseDetailsPage
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

		for (WebElement hrsofSystem : ddlHrsOfAutoResumeTimeInPauseDetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfAutoResumeTimeInPauseDetailsPage) {

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
		btnUpdateDetailsInPauseDetailsPage.click();

		// Click on Pause Tab
		Thread.sleep(2000);

		tabLatestPauseInTicketForm.click();
		String pauseReasonText = lblPauseReasonInLatestPauseTab.getText();
		System.out.println(pauseReasonText);

		softAssert.assertEquals(pauseReason, pauseReasonText,
				"Pause Reason is not same");

		// Get Pause End Date And Time
		String pauseEndDateAndTimeText = lblResumeDateAndTimeInLatestPauseTab
				.getText();
		System.out.println(pauseEndDateAndTimeText);
		String pauseEndDateAndTimeInPauseTab = pauseEndDateAndTimeText
				.split(":00")[0];
		System.out.println(pauseEndDateAndTimeInPauseTab);

		softAssert.assertEquals(pauseEndDateAndTimeInPauseTab,
				pauseEndDateAndTime, "Pause End Date And Time is not same");
		softAssert.assertAll();

	}

	public void verifyPauseReasonAsPerSuper() throws Exception {
		SoftAssert softAssert = new SoftAssert();

tabPauseInTicketForm.click();
		
		// Click on Edit Button In Pause Tab
				btnEditInPauseTab.click();
				
				// Click on List Of Pause Reasons Button
				btnListOfPauseReasonsInPausepage.click();
				for (String listOfPauseReasons : driver.getWindowHandles()) {
					driver.switchTo().window(listOfPauseReasons);
				}

				// select the particular technician, here used the first
				// name.
				int sizePauseReason = lstPauseReasonsInListOfPauseReasonsPage.size();
				System.out.println("sizePauseReason: "+sizePauseReason);
				
				lstPauseReasonsInListOfPauseReasonsPage.get(0).click();
					

				// go to first window
				for (String basicWindow : driver.getWindowHandles()) {
					driver.switchTo().window(basicWindow);

				}

				btnCancel.click();
				
		

		logoutFromTechnician();
		loginIntoSuper();

		super_HomePage = new Super_HomePage();
		super_SDMasterPage = super_HomePage.clickSdMasterlink();
		Thread.sleep(500);
		super_TicketMasterPage = super_SDMasterPage.clickOnTicketMasterLink();
		Thread.sleep(500);
		super_PauseReasonPage = super_TicketMasterPage.clickOnPauseReasonLink();

		
		int sizeRow =lstRowInTable.size();
		System.out.println("sizeRow: "+sizeRow);
		softAssert.assertEquals(sizeRow, sizePauseReason,
				"Pause Reason size is not Same.");

		logoutFromSuper();
		loginIntoTechnician();

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
		tabPauseInTicketForm.click();

		// Click on Edit button
		btnEditInPauseTab.click();

		// Get Notification
		// Thread.sleep(5000);
		String notificationText = msgNotification.getText();
		System.out.println(notificationText);

		/*
		 * if(notificationText.contains("SMS Sent Successfully")) {
		 * btnCloseNotification.click(); }
		 * 
		 * Thread.sleep(5000); String notificationValue =
		 * notification.getText(); System.out.println(notificationValue);
		 * Thread.sleep(1000);
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

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				String Pause = lstPausedTimeInTable.get(i).getText();
				System.out.println(Pause);

				if (status.equalsIgnoreCase("Open") && !ETA.equals("")
						&& !ATA.equals("") && !Pause.equals("")) {
					// get ID from list of Available Spares Window
					String idValue = lstIDInTable.get(i).getText();
					System.out.println(idValue);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					String statusText = lblIncidentNumber.getText();
					System.out.println(statusText);
					String status1 = statusText.split("\n")[1];
					System.out.println(status1);
					String statusPause = status1.split(" ")[2];
					System.out.println("\n" + statusPause);
					if (statusPause.equalsIgnoreCase("Open")
							|| statusPause.equalsIgnoreCase("Closed")) {
						// Click on Pause Tab
						tabPauseInTicketForm.click();

						// Click on Edit button
						// button_EditInPauseTab.click();

						softAssert.assertNotNull(lblPauseEndDateTimeInPauseTab);
						softAssert
								.assertNotNull(lblTotalPauseMinutesInPauseTab);
						break loop;
					}

				}

				if (sizePagination - 1 == p) {
					System.out
							.println("Ticket is not Available for Punching ATA");

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
		tabPauseInTicketForm.click();

		// Format of Date Time
		String dateTimePattern = "yyyy-MM-dd HH:mm";
		DateFormat dateTimeFormat = new SimpleDateFormat(dateTimePattern);

		// Get Pause Start Date And Time Text
		String pauseStartDateAndTimeText = lblPauseStartDateTimeInPauseTab
				.getText();
		System.out.println(pauseStartDateAndTimeText);
		Date pauseStartDateAndTime = (Date) dateTimeFormat
				.parse(pauseStartDateAndTimeText);
		System.out.println(pauseStartDateAndTime);

		// Get Pause End Date And Time Text
		String pauseEndDateAndTimeText = lblPauseEndDateTimeInPauseTab
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
		int dateTime = (int) dateAndTime;

		String min = Integer.toString(dateTime);
		System.out.println(min);

		String totalPauseMinutes = lblTotalPauseMinutesInPauseTab.getText();
		System.out.println(totalPauseMinutes);
		softAssert.assertEquals(totalPauseMinutes, min,
				"'Total Pause Minutes is not Same.'");
		softAssert.assertAll();

	}

	

	// Spare Tab //

	// If user click on 'Update Details' button in spare details[with inventory
	// module] then notification should display as
	// 'Please Consumed or Replaced Spare, if you select spare consumed yes.'
	public void checkUpdateButtonWithoutEnteringData() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on spare tab
		tabSpareInTicketForm.click();

		// click on Edit button
		btnEditInSpareTab.click();

		for (String spareDetailsWindow : driver.getWindowHandles()) {

			System.out.println(spareDetailsWindow);
			driver.switchTo().window(spareDetailsWindow);

		}
		// Thread.sleep(2000);
		// Click on update button
		btnUpdateDetail.click();
		// Thread.sleep(3000);

		for (String basicWindow : driver.getWindowHandles()) {

			System.out.println(basicWindow);
			driver.switchTo().window(basicWindow);

		}

		String notificationText = msgNotification.getText();
		System.out.println(notificationText);

		/*
		 * if(notificationText.contains("SMS Sent Successfully")) {
		 * btnCloseNotification.click(); } Thread.sleep(5000); String
		 * notificationValue = notification.getText();
		 * System.out.println(notificationValue); Thread.sleep(1000);
		 */

		softAssert
				.assertEquals(notificationText,
						"Please Consumed or Replaced Spare, if you select spare consumed yes.");

		softAssert.assertAll();
	}

	// If user select 'Yes' in 'Spares Consumed By Inventory
	// logistic(Y/N)'option then
	// Add spare tab should display
	public void checkSpareTabWithYesSelect() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on spare tab
		tabSpareInTicketForm.click();

		// click on Edit button
		btnEditInSpareTab.click();

		for (String spareDetailsWindow : driver.getWindowHandles()) {

			System.out.println(spareDetailsWindow);
			driver.switchTo().window(spareDetailsWindow);

		}

		// select the Spares Consumed By Inventory logistic
		Select sparesConsumed;
		sparesConsumed = new Select(ddlSparesConsumed);
		sparesConsumed.selectByVisibleText("Yes");

		// verify after click on "Yes" the add spare is get open or
		// not
		String textOfAddSpare = lblAddSpare.getText();
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
		btnSymbolOfSpareDetail.click();

		for (String listOfAvailableSparesWindow : driver.getWindowHandles()) {

			System.out.println(listOfAvailableSparesWindow);
			driver.switchTo().window(listOfAvailableSparesWindow);

		}

		String getTitleOfWindow = driver.getTitle();
		System.out.println(getTitleOfWindow);
		Thread.sleep(2000);
		softAssert.assertEquals(getTitleOfWindow, "Select Inventory");
		softAssert.assertAll();

	}

	// If user click on hyper link of part name in 'List of Available Spares'
	// pop up, after select 'Yes' in list then
	// same part name should display in Add Spare tab

	public void matchPartname() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		try {
			List<WebElement> productClassification = lstProductClassificationInSpareDetail;
			int size1 = productClassification.size();
			System.out.println(size1);

			for (int j = 0; j < size1; j++) {
				scrollDown(productClassification.get(j));
				String productClassificationValue = productClassification.get(j)
						.getText();
				System.out.println(productClassificationValue);

				String transactionTypeValue = lstTransactionTypeInSpareDetail
						.get(j).getText();
				System.out.println(transactionTypeValue);

				String partTypeValue = lstPartTypeInSpareDetail.get(j).getText();
				System.out.println(partTypeValue);

				//
				//
				if (productClassificationValue.equalsIgnoreCase("Component")
						&& partTypeValue.equalsIgnoreCase("Non-Consumable")
						&& transactionTypeValue.equalsIgnoreCase("Stock"))

				{

					scrollDown(lstPartNameInSpareDetail.get(j));
					String partName = lstPartNameInSpareDetail.get(j).getText();
					System.out.println(partName);

					// select part name from list of Available
					// Spares Window
					scrollDown(lstPartNameInSpareDetail.get(j));
					highLight(lstPartNameInSpareDetail.get(j));
					// driver.findElement(By.linkText(partName)).click();

					lstPartNameInSpareDetail.get(j).click();

					for (String spareDetailsWindow : driver.getWindowHandles()) {

						System.out.println(spareDetailsWindow);
						driver.switchTo().window(spareDetailsWindow);

					}
					// Thread.sleep(2000);

					// get the part name from part name text box in add spare
					String getPartName = txtPartName.getAttribute("value");
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
					// driver.findElement(By.cssSelector("body")).sendKeys(
					// Keys.CONTROL + "w");

				}
			}
			
		
		selectNonConsumableProduct();
		checkTransactionType();
		} catch (Exception e) {
			softAssert.assertTrue(false, "Spare is not Available");
			driver.findElement(By.cssSelector("body")).sendKeys( Keys.CONTROL + "w");
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
		String productClassificationValue = txtProductClassificationInAddSpare
				.getAttribute("value");
		System.out.println("product Classification in add spare:-"
				+ productClassificationValue);

		// get value from Part Description in Add Spare
		// tab
		String partDescriptionValue = txtPartDescriptionInAddSpare
				.getAttribute("value");
		System.out.println("product Classification in add spare:-"
				+ partDescriptionValue);

		// get value from Product Classification in
		// Replace Spare tab
		String productClassificationValueInReplaceSapre = txtProductClassificationInReplaceSpare
				.getAttribute("value");
		System.out.println("product Classification in add spare:-"
				+ productClassificationValueInReplaceSapre);

		// get value from Part Description in Replace Spare
		// tab
		String partDescriptionValueInReplaceSapre = txtPartDescriptionInReplaceSpare
				.getAttribute("value");
		System.out.println("product Classification in add spare:-"
				+ partDescriptionValueInReplaceSapre);

		// Match both the Product classification value same
		// or
		// not
		highLight(txtProductClassificationInAddSpare);
		scrollDown(txtProductClassificationInReplaceSpare);
		highLight(txtProductClassificationInReplaceSpare);
		softAssert.assertEquals(productClassificationValue,
				productClassificationValueInReplaceSapre);

		// Match both the Part Description value same or not
		highLight(txtPartDescriptionInAddSpare);
		highLight(txtPartDescriptionInReplaceSpare);
		highLight(txtPartDescriptionInReplaceSpare);
		softAssert.assertEquals(partDescriptionValue,
				partDescriptionValueInReplaceSapre);

		softAssert.assertAll();

	}

	// If user select component part and click on update details button then
	// spare entry should display in spare tab as 'consumed' transaction type
	public void checkTransactionType() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", btnUpdateDetail);

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		// Click on update button
		btnUpdateDetail.click();

		Thread.sleep(3000);

		// click on spare tab
		tabSpareInTicketForm.click();

		// Thread.sleep(1000);
		// List<WebElement> transactionTypeValueAfterUpdate
		// = list_TransactionTypeOfSapre;
		int getTotalSize = lstTransactionTypeOfSapre.size();
		System.out.println(getTotalSize);

		String getTransactionType = lstTransactionTypeOfSapre.get(
				getTotalSize - 1).getText();
		System.out.println(getTransactionType);

		scrollDown(lstTransactionTypeOfSapre.get(getTotalSize - 1));
		highLight(lstTransactionTypeOfSapre.get(getTotalSize - 1));
		Thread.sleep(2000);
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
		tabSpareInTicketForm.click();

		// click on Edit button
		btnEditInSpareTab.click();

		for (String spareDetailsWindow : driver.getWindowHandles()) {

			System.out.println(spareDetailsWindow);
			driver.switchTo().window(spareDetailsWindow);

		}

		// select the Spares Consumed By Inventory logistic
		Select sparesConsumed;
		sparesConsumed = new Select(ddlSparesConsumed);
		sparesConsumed.selectByVisibleText("Yes");

		// list symbol button in spare detail window
		btnSymbolOfSpareDetail.click();

		for (String listOfAvailableSparesWindow : driver.getWindowHandles()) {

			System.out.println(listOfAvailableSparesWindow);
			driver.switchTo().window(listOfAvailableSparesWindow);

		}

		List<WebElement> productClassificationName = lstProductClassificationInSpareDetail;
		System.out.println("product Classification Name:-"
				+ productClassificationName.size());

		for (int j = 0; j < productClassificationName.size(); j++) {
			scrollDown(productClassificationName.get(j));
			String productClassificationValue = productClassificationName
					.get(j).getText();

			String partTypeValue = lstPartTypeInSpareDetail.get(j).getText();
			System.out.println(partTypeValue);

			String transactionType = lstTransactionTypeInSpareDetail.get(j)
					.getText();
			System.out.println(transactionType);

			if (productClassificationValue.equalsIgnoreCase("Device")
					&& partTypeValue.equalsIgnoreCase("Non-Consumable")
					&& transactionType.equalsIgnoreCase("Stock"))

			{
				String partName = lstPartNameInSpareDetail.get(j).getText();
				System.out.println(partName);

				// select part name from list of Available
				// Spares Window
				highLight(lstPartNameInSpareDetail.get(j));
				// driver.findElement(By.linkText(partName)).click();
				lstPartNameInSpareDetail.get(j).click();
				for (String spareDetailsWindow : driver.getWindowHandles()) {

					System.out.println(spareDetailsWindow);
					driver.switchTo().window(spareDetailsWindow);

				}
				// Thread.sleep(2000);

				String textOfReplaceSpareWithTab = lblReplaceSpareWith
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

		btnUpdateDetail.click();
		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);

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

		String partNameValue = txtPartName.getAttribute("value");
		System.out.println("part name in Add Spare tab:-" + partNameValue);

		// Thread.sleep(1000);
		String partCodeValueInReplaceWithTab = ddlPartCodeInReplaceSpare
				.getText();
		System.out.println(partCodeValueInReplaceWithTab);

		Select samePartCodeInRepaceTab;
		samePartCodeInRepaceTab = new Select(ddlPartCodeInReplaceSpare);
		samePartCodeInRepaceTab
				.selectByVisibleText("Replace With Same PartCode");

		Select anotherPartCodeInRepaceTab;
		anotherPartCodeInRepaceTab = new Select(ddlPartCodeInReplaceSpare);
		anotherPartCodeInRepaceTab
				.selectByVisibleText("Replace With Another PartCode");
		Thread.sleep(500);

		List<WebElement> anotherPartCodeList = lstddlAnotherPartCodeInReplaceSpare;
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
		btnUpdateDetail.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
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
		statusDropdown = new Select(ddlStatus);
		statusDropdown.selectByVisibleText("Faulty");
		// Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// click on update button
		btnUpdateDetail.click();
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

		List<WebElement> serialNumberValueAfterUpdate = lstSerialNumberOfSapre;
		int getSize = serialNumberValueAfterUpdate.size();
		System.out.println(getSize);

		String getSerialNumber = lstSerialNumberOfSapre.get(getSize - 1)
				.getText();
		System.out.println(getSerialNumber);

		// Match that without selecting serial number
		// the serial number is generate or not
		softAssert.assertNotNull(getSerialNumber);

		// Match the notification
		String notificationValue = msgNotification.getText();
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

		tabSpare.click();

		Thread.sleep(1000);
		List<WebElement> transactionTypeValueAfterUpdate = lstTransactionTypeOfSapre;
		int getTotalSize = transactionTypeValueAfterUpdate.size();
		System.out.println(getTotalSize);

		String getTransactionType = lstTransactionTypeOfSapre.get(
				getTotalSize - 1).getText();
		System.out.println(getTransactionType);

		String getStatus = lstStatusOfSapre.get(getTotalSize - 1).getText();
		System.out.println(getStatus);

		// match that after click on update button the
		// Transaction type change
		// to Replaced
		highLight(lstTransactionTypeOfSapre.get(getTotalSize - 1));
		highLight(lstStatusOfSapre.get(getTotalSize - 1));
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
		tabTechnicianClose.click();

		// click on edit button
		btnEditOfTechncianClose.click();

		// get the message from technician close
		// tab->edit->serial No.
		String message = msgSerialNumber.getText();
		System.out.println(message);
		highLight(msgSerialNumber);

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
		tabSpareInTicketForm.click();

		// Click on Edit Button In Pause Tab
		btnEditInSpareTab.click();

		for (String Window : driver.getWindowHandles()) {
			driver.switchTo().window(Window);
		}

		// Get Heading
		// Thread.sleep(5000);
		String headingOfSpareDetailsPage = lblTitleAllTabDetailsPage.getText();
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
		tabRequiredSpareInSpareTab.click();
		// Thread.sleep(2000);

		// Click on Add Button
		btnAddInRequiredSpareTab.click();

		// get the message from that alert box
				Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);
				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();
				// Thread.sleep(1000);

				// verify that alert message
				softAssert.assertEquals(alertMessage, "Please Select Asset Make");
				//System.out.println("\nAlert Message is Correct");
				
				scrollDown(ddlAssetMakeInRequiredSpareTab);
				Thread.sleep(2000);
				Select selectAssetMake = new Select(
						ddlAssetMakeInRequiredSpareTab);
				selectAssetMake.selectByIndex(1);

				scrollDown(btnAddInRequiredSpareTab);
				// Click on Add Buttons
				btnAddInRequiredSpareTab.click();
				
				
		// get the message from that alert box
		Alert alert5 = driver.switchTo().alert();
		Thread.sleep(3000);
		String alertMessage5 = alert5.getText();
		System.out.println("Alert Text:" + alertMessage5);
		alert5.accept();
		driver.switchTo().defaultContent();
		// Thread.sleep(1000);

		// verify that alert message
		softAssert.assertEquals(alertMessage5, "Please Select Part Category");
		//System.out.println("\nAlert Message is Correct");

		// alert box should display as 'Please Select the Quantity'

		scrollDown(ddlPartCategoryInRequiredSpareTab);
		Select selectPartCategory = new Select(
				ddlPartCategoryInRequiredSpareTab);
		selectPartCategory.selectByIndex(1);

		scrollDown(btnAddInRequiredSpareTab);
		// Click on Add Button
				btnAddInRequiredSpareTab.click();
				

		// get the message from that alert box
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		String alertMessage1 = alert1.getText();
		System.out.println("Alert Text:" + alertMessage1);
		alert1.accept();
		driver.switchTo().defaultContent();
		// Thread.sleep(1000);

		// verify that alert message
		softAssert.assertEquals(alertMessage1, "Please Select Part Name");
		//System.out.println("\nAlert Message is Correct");

		scrollDown(ddlPartNameInRequiredSpareTab);
		// alert box should display as 'Please Select the Quantity'
		Select selectPartName = new Select(ddlPartNameInRequiredSpareTab);
		selectPartName.selectByIndex(1);

		// Click on Add button
		btnAddInRequiredSpareTab.click();

		// get the message from that alert box
		Alert alertForPartCode = driver.switchTo().alert();
		Thread.sleep(1000);

		String alertMessageForPartCode = alertForPartCode.getText();
		System.out.println("\nAlert Text:" + alertMessageForPartCode);
		alertForPartCode.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(500);

		// verify that alert message
		softAssert.assertEquals(alertMessageForPartCode,
				"Please Enter The Quantity");
		//System.out.println("Alert Message is Correct");

		// alert box should display as 'Please Select Spare Delivery
		// Location'
		/*Select selectPartCode = new Select(ddlPartCodeInRequiredSpareTab);
		selectPartCode.selectByIndex(1);
*/
		/*
		 * Alert alert2 = driver.switchTo().alert();
		 * 
		 * alert2.accept();
		 */
		// Enter Quantity
		txtQuantityInRequiredSpareTab.sendKeys("5");

		// Click on Add Button
		btnAddInRequiredSpareTab.click();

		// Get the message from Alert box
		Alert alertForLocation = driver.switchTo().alert();
		Thread.sleep(1000);
		String alertMessageForLocation = alertForLocation.getText();
		System.out.println("\nAlert Text:" + alertMessageForLocation);
		alertForLocation.accept();
		driver.switchTo().defaultContent();
		// Thread.sleep(1000);

		// verify that alert message
		softAssert.assertEquals(alertMessageForLocation,
				"Please Select Spare Delivry Location");
		//System.out.println("Alert Message is Correct");
		driver.findElement(By.linkText("Cancel")).click();
		softAssert.assertAll();

	}

	// After enter all mandatory details if user click on Add button then entry
	// should made in Required Spare[With Inventory module] tab and same entry
	// should display in edit ticket->Spare tab and notification should display
	// as 'Spare Added Successfully'

	public void checkNotificationWithSelectionInSpareTab() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// Click on Spare Tab
		tabSpareInTicketForm.click();

		// Click on Edit Button In Pause Tab
		btnEditInSpareTab.click();

		for (String Window : driver.getWindowHandles()) {
			driver.switchTo().window(Window);
		}

		// Click on Required Spare In Spare Tab
		tabRequiredSpareInSpareTab.click();

		scrollDown(ddlAssetMakeInRequiredSpareTab);
		Thread.sleep(2000);
		Select selectAssetMake = new Select(
				ddlAssetMakeInRequiredSpareTab);
		selectAssetMake.selectByIndex(2);
		
		// alert box should display as 'Please Select the Quantity'
		Select selectPartCategory = new Select(
				ddlPartCategoryInRequiredSpareTab);
		selectPartCategory.selectByIndex(1);

		// alert box should display as 'Please Select the Quantity'
		Select selectPartName = new Select(ddlPartNameInRequiredSpareTab);
		List<WebElement> listOfPartName = selectPartName.getOptions();

		String partName = listOfPartName.get(1).getAttribute("value");
		System.out.println("\npartName: " + partName);

		selectPartName.selectByIndex(1);
		Thread.sleep(500);

		Select selectPartCode = new Select(ddlPartCodeInRequiredSpareTab);
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

		txtQuantityInRequiredSpareTab.clear();
		// Enter Quantity
		String quantity = "5";
		txtQuantityInRequiredSpareTab.sendKeys(quantity);

		Select selectLocation = new Select(ddlLocationInRequiredSpareTab);
		List<WebElement> listOFLocation = selectLocation.getOptions();

		String location = listOFLocation.get(1).getAttribute("value");
		System.out.println("\nLocation: " + location);

		selectLocation.selectByIndex(1);

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		// Click on Add Button
		btnAddInRequiredSpareTab.click();

		// Get Notification
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String notificationText = msgNotification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText, "Spare Added Successfully",
				"Notification is not Match");
		Thread.sleep(500);

		int size1 = lblPartNameInSpareTab.size() - 1;
		scrollDown(lblPartNameInSpareTab.get(size1));
		String partNameInSpareTab = lblPartNameInSpareTab.get(size1).getText();
		System.out.println(partNameInSpareTab);

		String partCodeInSpareTab = lblPartCodeInSpareTab.get(size1).getText();
		System.out.println(partCodeInSpareTab);

		String quantityInSpareTab = lblQuantityInSpareTab.get(size1).getText();
		System.out.println(quantityInSpareTab);

		String locationInSpareTab = lblLocationInSpareTab.get(size1).getText();
		System.out.println(locationInSpareTab);

		highLight(lblPartNameInSpareTab.get(size1));
		softAssert.assertEquals(partName, partNameInSpareTab,
				"Part Name is not Match");
		highLight(lblPartCodeInSpareTab.get(size1));
		softAssert.assertEquals(partCode, partCodeInSpareTab,
				"Part Code is not Match");
		highLight(lblQuantityInSpareTab.get(size1));
		softAssert.assertEquals(quantity, quantityInSpareTab,
				"quantity is not Match");
		highLight(lblLocationInSpareTab.get(size1));
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
		tabSpareInTicketForm.click();

		// Click on Update Button In Pause Tab
		try {
			int size = lblSpareRemarkInSpareTab.size();
			System.out.println(size);
			//scrollDown(lblSpareRemarkInSpareTab.get(size - 1));
			highLight(lstSymbolUpdateInSpareTab.get(size - 1));
			Thread.sleep(500);
			lstSymbolUpdateInSpareTab.get(size - 1).click();

			for (String sdWindow : driver.getWindowHandles()) {
				driver.switchTo().window(sdWindow);
			}
			Thread.sleep(500);

			String heading = lblHeadingUpdateSpareRemarkPopup.getText();
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
		txtSpareRemarkInUpdateSpareRemarkPopup.clear();
		txtSpareRemarkInUpdateSpareRemarkPopup.sendKeys(remark);
		btnUpdateInUpdateSpareRemarkPopup.click();
		// Thread.sleep(1000);
		int size = lblSpareRemarkInSpareTab.size();
		System.out.println(size);
		scrollDown(lblSpareRemarkInSpareTab.get(size - 1));
		highLight(lblSpareRemarkInSpareTab.get(size - 1));
		String SpareRemark = lblSpareRemarkInSpareTab.get(size - 1).getText();
		System.out.println(SpareRemark);
		highLight(lblSpareRemarkInSpareTab.get(size - 1));
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
		tabSpareInTicketForm.click();

		int sizeBeforeRemove = lstRowTableInSpareTab.size();
		System.out.println(sizeBeforeRemove);

		// Click on Edit Button In Pause Tab
		btnEditInSpareTab.click();

		for (String sdWindow : driver.getWindowHandles()) {
			driver.switchTo().window(sdWindow);
		}
		// Thread.sleep(1000);

		// Click on Required Spare In Spare Tab
		tabRequiredSpareInSpareTab.click();
		// Thread.sleep(1000);

		try {
			Thread.sleep(2000);
			btnRemoveInRequiredSpareTab.get(0).click();
			Thread.sleep(2000);

			int sizeAfterRemove = lstRowTableInSpareTab.size();
			System.out.println(sizeAfterRemove);
			softAssert.assertEquals(sizeAfterRemove, sizeBeforeRemove - 1,
					"Row Size is not Same");

		} catch (Exception e) {
			softAssert.assertTrue(false, "Spare is not Available");
			btnCancel.click();

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
			tabSpareInTicketForm.click();

			// click on Edit button
			btnEditInSpareTab.click();

			for (String spareDetailsWindow : driver.getWindowHandles()) {

				System.out.println(spareDetailsWindow);
				driver.switchTo().window(spareDetailsWindow);

				// select the Spares Consumed By Inventory logistic
				Select sparesConsumed;
				sparesConsumed = new Select(ddlSparesConsumed);
				sparesConsumed.selectByVisibleText("Yes");

				// list symbol button in spare detail window
				btnSymbolOfSpareDetail.click();

				for (String listOfAvailableSparesWindow : driver
						.getWindowHandles()) {

					System.out.println(listOfAvailableSparesWindow);
					driver.switchTo().window(listOfAvailableSparesWindow);

				}

				List<WebElement> transactionType = lstTransactionTypeInSpareDetail;
				int sizeOfSpare = transactionType.size();
				System.out.println(sizeOfSpare);

				for (int j = 0; j < transactionType.size(); j++) {

					String transactionTypeValue = transactionType.get(j)
							.getText();
					System.out.println(transactionTypeValue);
					scrollDown(transactionType.get(j));
					highLight(transactionType.get(j));
					if (transactionTypeValue.equalsIgnoreCase("In Transit"))

					{
						// get part name from list of Available Spares
						// Window
						scrollDown(lstPartNameInSpareDetail.get(j));
						highLight(lstPartNameInSpareDetail.get(j));
						String partName = lstPartNameInSpareDetail.get(j)
								.getText();
						System.out.println(partName);

						// select part name from list of Available Spares
						// Window
						// driver.findElement(By.linkText(partName)).click();
						scrollDown(lstPartNameInSpareDetail.get(j));
						lstPartNameInSpareDetail.get(j).click();

						driver.switchTo().window(spareDetailsWindow);
						Select samePartCodeInRepaceTab;
						samePartCodeInRepaceTab = new Select(
								ddlPartCodeInReplaceSpare);
						samePartCodeInRepaceTab
								.selectByVisibleText("Replace With Same PartCode");

						// select the status
						Select statusDropdown;
						statusDropdown = new Select(ddlStatus);
						statusDropdown.selectByVisibleText("Faulty");

						// Thread.sleep(2000);
						// Click on update button
						btnUpdateDetail.click();
						driver.manage().timeouts()
								.pageLoadTimeout(10, TimeUnit.SECONDS);
						// Thread.sleep(3000);

						for (String basicWindow : driver.getWindowHandles()) {

							System.out.println(basicWindow);
							driver.switchTo().window(basicWindow);

						}

						Thread.sleep(1000);

						String textOfNotification = msgNotification.getText();
						System.out.println(textOfNotification);

						softAssert.assertEquals(textOfNotification,
								"Please Check This Spare is In Transit..");

					}

					else if (sizeOfSpare - 1 == j) {
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
		btnEditInSpareTab.click();

		for (String sdWindow : driver.getWindowHandles()) {
			driver.switchTo().window(sdWindow);
		}

		// Click on Required Spare In Spare Tab
		tabRequiredSpareInSpareTab.click();
		// Thread.sleep(2000);

		// select part name
		Select selectPartName = new Select(ddlPartNameInRequiredSpareTab);
		List<WebElement> listOfPartName = selectPartName.getOptions();

		String partName = listOfPartName.get(2).getAttribute("value");
		System.out.println("\npartName: " + partName);

		selectPartName.selectByIndex(2);
		Thread.sleep(500);

		// select part code
		Select selectPartCode = new Select(ddlPartCodeInRequiredSpareTab);
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
		txtQuantityInRequiredSpareTab.sendKeys(quantity);

		Select selectLocation = new Select(ddlLocationInRequiredSpareTab);
		List<WebElement> listOFLocation = selectLocation.getOptions();

		String location = listOFLocation.get(1).getAttribute("value");
		System.out.println("\nLocation: " + location);

		selectLocation.selectByIndex(1);

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		// Click on Add Button
		btnAddInRequiredSpareTab.click();

		Thread.sleep(500);

	}

	// If User click on Add Remark button then alert box should display with
	// text box to enter remark
	public void checkAlertPopup() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// Click on Spare Tab
		tabRemarkInTicketForm.click();

		// Click on Add Remark Button In Remark Tab
		btnAddRemarkInRemarkTab.click();

		for (String Window : driver.getWindowHandles()) {

			System.out.println(Window);
			driver.switchTo().window(Window);

		}

		String windowValue = lblAddRemark.getText();
		System.out.println(windowValue);

		// verify that alert message is Please Enter The Numeric
		// Value for Incident ID or not
		softAssert.assertEquals("Add Remark", windowValue);

		System.out.println("Both the message is equal");

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

		String remark = "Ok";
		txtRemark.sendKeys(remark);

		driver.findElement(By.linkText("Add Remark")).click();

		Thread.sleep(200);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);

		String alertMessageWithoutVisibility = alert.getText();
		System.out.println("Alert Text:" + alertMessageWithoutVisibility);
		alert.accept();

		softAssert.assertEquals(alertMessageWithoutVisibility,
				"Please Select Visibility");

		driver.findElement(By.linkText("Cancel")).click();
		softAssert.assertAll();

	}

	// If User click on OK button after enter data in text box then entry should
	// not get generate same remark value, Remark date/time and login role
	// 'remark by' column
	public void checkRemarkInRemarkTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// Click on Spare Tab
		tabRemarkInTicketForm.click();

		// Click on Add Remark Button In Remark Tab
		btnAddRemarkInRemarkTab.click();

		for (String Window : driver.getWindowHandles()) {

			System.out.println(Window);
			driver.switchTo().window(Window);

		}

		String remark = "Ok";
		txtRemark.sendKeys(remark);

		Select visibitity;
		visibitity = new Select(ddlVisibility);
		visibitity.selectByIndex(1);

		
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Add Remark")).click();

		Thread.sleep(3000);
		int size1 = lstRowTableInRemarkTab.size()-3;
		System.out.println(size1);
		String remarkInRemarkTab = lstlblRemarkInRemarkTab.get(size1).getText();
		System.out.println(remarkInRemarkTab);


		
		/*highLight(tabTechnicianForLogout);
		//tabTechnicianForLogout.click();
		Actions builder = new Actions(driver);
		String seriesOfActions = builder
			.moveToElement(tabTechnicianForLogout).toString();*/
		String user = tabTechnician.getText();
		System.out.println(user);
		

		String remarkByInRemarkTab = lstlblRemarkByInRemarkTab.get(size1)
				.getText();
		System.out.println(remarkByInRemarkTab);
		highLight(lstlblRemarkInRemarkTab.get(size1));
		softAssert
				.assertEquals(remark, remarkInRemarkTab, "Remark is not same");
		System.out.println("Both the Remark is equal");
		highLight(lstlblRemarkByInRemarkTab.get(size1));
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

		tabRemarkInTicketForm.click();
		// Count the row in Remark Tab
		int size1 = lstRowTableInRemarkTab.size();
		System.out.println(size1);

		// Click on Add Remark Button In Remark Tab
		btnAddRemarkInRemarkTab.click();

		String remark = "Ok";
		txtRemark.sendKeys(remark);

		driver.findElement(By.linkText("Cancel")).click();
		Thread.sleep(1000);

		driver.switchTo().defaultContent();

		String titleAfterClosePopup = driver.getTitle();
		System.out.println("Title: " + titleAfterClosePopup);

		// Count the row in Remark Tab
		int sizeAfterClosePopup = lstRowTableInRemarkTab.size();
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
		tabActivities.click();

		// click on add remark
		btnAddActivityOfActivities.click();

		// get the message from Technician Assign And ETA Details
		// window
		// window handler

		for (String addActivityWindow : driver.getWindowHandles()) {

			System.out.println(addActivityWindow);
			driver.switchTo().window(addActivityWindow);

		}

		String textOfAddActivityWindow = lblAddActivityWindow.getText();
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
	public void checkAlertWithoutSelection() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// click on submit button
		btnSubmit.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();

		// verify that alert message isPlease select Activity.or not
		softAssert.assertEquals(alertMessage, "Please select Activity.");
		System.out.println("Both the message is equal");

		// select the Activity
		Select activity;
		activity = new Select(ddlActivity);
		activity.selectByVisibleText("Additional Activity");
		Thread.sleep(3000);

		// click on submit button
		btnSubmit.click();

		// get the message from that alert box
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage1 = alert1.getText();
		System.out.println("Alert Text:" + alertMessage1);
		alert1.accept();

		// verify that alert message is Please select Activity.or
		// not
		softAssert
				.assertEquals(alertMessage1, "Please select Activity Status.");
		System.out.println("Both the message is equal");

		// select the Activity status
		Select activityStatus;
		activityStatus = new Select(ddlActivityStatus);
		activityStatus.selectByVisibleText("Complete");
		Thread.sleep(3000);

		// click on submit button
		btnSubmit.click();

		// get the message from that alert box
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage2 = alert2.getText();
		System.out.println("Alert Text:" + alertMessage2);
		alert2.accept();

		// verify that alert message is Please select Activity.or
		// not
		softAssert
				.assertEquals(alertMessage2, "Please enter Activity Details.");
		System.out.println("Both the message is equal");

		driver.findElement(
				By.xpath(".//*[@id='boxActivity']/div/table/tbody/tr[1]/th[3]/img"))
				.click();

		softAssert.assertAll();

	}

	// If User enter all details in Add Activity Pop up then entry should made
	// in Activity tab details with current date/time
	// login role in Updated by column
	public void matchActivityDetailsAndDateAndTime() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// click on activities tab
		Thread.sleep(1000);
		tabRemarkInTicketForm.click();
		Thread.sleep(1000);
		tabActivities.click();

		// click on add remark
		btnAddActivityOfActivities.click();

		// select the Activity
		Select activity;
		activity = new Select(ddlActivity);
		activity.selectByVisibleText("Additional Activity");
		Thread.sleep(1000);

		// select the Activity status
		Select activityStatus;
		activityStatus = new Select(ddlActivityStatus);
		activityStatus.selectByVisibleText("Complete");
		Thread.sleep(1000);

		txtActivityDetail.sendKeys("Testing");

		// click on submit button
		btnSubmit.click();

		// Get Activity date and time
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int dateSize = lstDateOfActivities.size();
		String activityDate = lstDateOfActivities.get(dateSize - 1).getText();
		System.out.println(activityDate);
		Date formateDate = dateFormat.parse(activityDate);
		String dateformat = dateFormat.format(formateDate);
		Date date = dateFormat.parse(dateformat);
		String dateValue = dateFormat.format(date);
		System.out.println("Activity Date :-" + dateValue);

		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		int timeSize = lstTimeOfActivities.size();
		String activityTime = lstTimeOfActivities.get(timeSize - 1).getText();
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

		String activityName = lstActivity.get(timeSize - 1).getText();
		System.out.println(activityName);

		String activityStatusTxt = lstActivityStatus.get(timeSize - 1)
				.getText();
		System.out.println(activityStatusTxt);

		String activityDetailsTxt = lstActivityDetails.get(timeSize - 1)
				.getText();
		System.out.println(activityDetailsTxt);

		highLight(lstActivity.get(timeSize - 1));
		softAssert.assertEquals(activityName, "Additional Activity",
				"Activity is not Same");
		highLight(lstActivityStatus.get(timeSize - 1));
		softAssert.assertEquals(activityStatusTxt, "Complete",
				"Activity Status is not Same");
		highLight(lstActivityDetails.get(timeSize - 1));
		softAssert.assertEquals(activityDetailsTxt, "Testing",
				"Activity Details is not Same");
		highLight(lstDateOfActivities.get(dateSize - 1));
		softAssert.assertEquals(dateValue, SystemDateValue, "Date is not Same");
		highLight(lstTimeOfActivities.get(timeSize - 1));
		softAssert.assertEquals(timeValue, SystemTimeValue, "Time is not Same");
		softAssert.assertAll();
	}

	// Required Spare [Without Inventory Module]
	// If user click on Required Spare [Without Inventory Module] title then tab
	// should display with fields to enter part details
	public void checkNotificationWithoutSelectionInWithoutInventoryModule()
			throws Exception {
		// Click on search ticket tab
		tabSearchTicketOpen.click();

		// Enter Id in Search Id Tab
		tabSearchId.sendKeys("739");

		// Click on Go button
		btnGoOfId.click();

		// Click on Id in Table
		Thread.sleep(1000);
		lnkFirstIdInTable.click();

		// Click on Spare Tab
		tabSpareInTicketForm.click();

		// Click on Edit Button In Pause Tab
		btnEditInSpareTab.click();

		for (String sdWindow : driver.getWindowHandles()) {
			driver.switchTo().window(sdWindow);
		}
		Thread.sleep(1000);

		// Click on Required Spare In Spare Tab
		tabRequiredSpareInSpareTab.click();
		Thread.sleep(2000);

		// Click on Add Button
		btnAddInRequiredSpareTab.click();

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
		Select selectPartName = new Select(ddlPartNameInRequiredSpareTab);
		selectPartName.selectByIndex(1);

		// Click on Add button
		btnAddInRequiredSpareTab.click();

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
		Select selectPartCode = new Select(ddlPartCodeInRequiredSpareTab);
		selectPartCode.selectByIndex(1);

		// Enter Quantity
		txtQuantityInRequiredSpareTab.sendKeys("5");

		// Click on Add Button
		btnAddInRequiredSpareTab.click();

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
		tabVCTInTicketForm.click();

		// Get Heading of VCT Tab
		String heading = lblHeadingVCTTab.getText();
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
		btnCreatePOInVCTTab.click();

		// Get Heading of Vendor Commercial PO Details Pop up
		String heading = lblHeadingVendorCommercialPODetailsPopup.getText();
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
		btnSubmitInCommercialPODetailsPopup.click();

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
		btnCancel.click();
		softAssert.assertAll();

	}

	public void checkVendorDropdown() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		// Click on Spare Tab
		tabVCTInTicketForm.click();

		// Click on Create Tab
		btnCreatePOInVCTTab.click();

		ddlVendorInVCTTab.click();
		Thread.sleep(1000);

		// Click on Submit Button
		btnSubmitInCommercialPODetailsPopup.click();

		// get the message from alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(alertMessage, "",
				"Submit button is not working");
		btnCancel.click();
		softAssert.assertAll();

	}

	// In 'Vendor Commercial PO Details' pop up if user enter value then same
	// should get auto fill in Amount field
	public void checkAmountInVendorCommercialPODetailsPopup() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		String quantity = txtQuantityInVCTTab.getAttribute("value");
		int quantityInt = Integer.parseInt(quantity);
		System.out.println(quantityInt);

		String rate = "2";
		int rateInt = Integer.parseInt(rate);
		txtRateInVCTTab.sendKeys(rate);

		int amountInt = quantityInt * rateInt;
		System.out.println(amountInt);

		String amount = txtAmountInVCTTab.getAttribute("value");
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
		String textPONO = txtPONOInVCTTab.getAttribute("value");
		System.out.println(textPONO);

		String textPODate = txtPODateInVCTTab.getAttribute("value");
		System.out.println(textPODate);

		String textServiceCharges = txtServiceChargesInVCTTab
				.getAttribute("value");
		System.out.println(textServiceCharges);

		String textProduct = "AC";
		txtProductInVCTTab.clear();
		txtProductInVCTTab.sendKeys(textProduct);
		System.out.println(textProduct);

		Select selectStatus = new Select(ddlStatusInVCTTab);
		List<WebElement> listOfStatus = selectStatus.getOptions();
		Thread.sleep(500);
		String dropdownStatus = listOfStatus.get(1).getAttribute("value");
		System.out.println(dropdownStatus);
		selectStatus.selectByIndex(1);

		String textTitle = txtTitleInVCTTab.getAttribute("value");
		System.out.println(textTitle);

		Select selectVendor = new Select(ddlVendorInVCTTab);
		List<WebElement> listOfVendor = selectVendor.getOptions();
		Thread.sleep(500);
		String dropdownVendor = listOfVendor.get(1).getAttribute("value");
		System.out.println(dropdownVendor);
		selectVendor.selectByIndex(1);

		String textCategory = "abc";
		txtCategoryInVCTTab.clear();
		txtCategoryInVCTTab.sendKeys(textCategory);
		System.out.println(textCategory);

		String textKmTravelled = "1";
		txtKmTravelledInVCTTab.sendKeys(textKmTravelled);
		System.out.println(textKmTravelled);

		String textquantity = txtQuantityInVCTTab.getAttribute("value");
		System.out.println(textquantity);

		String rate = "2";
		txtRateInVCTTab.clear();
		txtRateInVCTTab.sendKeys(rate);
		System.out.println(rate);

		String textAmount = txtAmountInVCTTab.getAttribute("value");
		System.out.println(textAmount);

		txtToEmailIdInVCTTab.clear();

		String textToEmailId = "swa@ksys.in";
		txtToEmailIdInVCTTab.clear();
		txtToEmailIdInVCTTab.sendKeys(textToEmailId);
		System.out.println(textToEmailId);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		btnSubmitInCommercialPODetailsPopup.click();

		int size1 = lstRowTableInVCTTab.size() - 2;
		System.out.println(size1);

		String labelPONO = lstlblPONOInPOTab.get(size1).getText();
		System.out.println(labelPONO);

		String labelPODate = lstlblPODateInPOTab.get(size1).getText();
		System.out.println(labelPODate);

		String labelServiceCharges = lblServiceChargesInPOTab.get(size1)
				.getText();
		System.out.println(labelServiceCharges);

		String labelProduct = lstlblProductInPOTab.get(size1).getText();
		System.out.println(labelProduct);

		String labelTitle = lstlblTitleInPOTab.get(size1).getText();
		System.out.println(labelTitle);

		String labelCategory = lstlblCategoryInPOTab.get(size1).getText();
		System.out.println(labelCategory);

		String labelKmTravelled = lstlblKmTravelledInPOTab.get(size1).getText();
		System.out.println(labelKmTravelled);

		String labelAmount = lstlblAmountInVCTTab.get(size1).getText();
		System.out.println(labelAmount);

		String labelVendor = lstlblVendorInPOTab.get(size1).getText();
		System.out.println(labelVendor);

		String labelStatus = lstlblStatusInPOTab.get(size1).getText();
		System.out.println(labelStatus);

		String labelToEmailId = lstlblToEmailIdInPOTab.get(size1).getText();
		System.out.println(labelToEmailId);

		boolean linkEdit = lstlnkEditInPOTab.get(size1).isEnabled();
		System.out.println(linkEdit);

		boolean linkPrint = lstlnkPrintInPOTab.get(size1).isEnabled();
		System.out.println(linkPrint);

		boolean linkSendMail = lstlnkSendMailInPOTab.get(size1).isEnabled();
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
		int size1 = lstlblAmountInVCTTab.size();
		for (int j = 0; j <= size1 - 1; j++) {
			String textAmount = lstlblAmountInVCTTab.get(j).getText();
			int amount = Integer.parseInt(textAmount);
			System.out.println(amount);
			totalAmount = totalAmount + amount;
		}
		System.out.println(totalAmount);

		String labelAmount = lblHeadingVCTTab.getText();
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
		lstlnkEditInPOTab.get(0).click();

		// Get Heading of Vendor Commercial PO Details Pop up
		String heading = lblHeadingVendorCommercialPODetailsPopup.getText();
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
		txtCategoryInVCTTab.clear();
		String textCategory = "abc";
		txtCategoryInVCTTab.sendKeys(textCategory);
		System.out.println(textCategory);

		txtKmTravelledInVCTTab.clear();
		String textKmTravelled = "1";
		txtKmTravelledInVCTTab.sendKeys(textKmTravelled);
		System.out.println(textKmTravelled);

		String textquantity = txtQuantityInVCTTab.getAttribute("value");
		System.out.println(textquantity);

		txtRateInVCTTab.clear();
		String rate = "2";
		txtRateInVCTTab.sendKeys(rate);
		System.out.println(rate);

		String textAmount = txtAmountInVCTTab.getAttribute("value");
		System.out.println(textAmount);

		txtToEmailIdInVCTTab.clear();
		String textToEmailId = "swa@ksys.in";
		txtToEmailIdInVCTTab.sendKeys(textToEmailId);
		System.out.println(textToEmailId);

		btnSubmitInCommercialPODetailsPopup.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// Click on VCT Tab
		tabVCTInTicketForm.click();

		String labelCategory = lstlblCategoryInPOTab.get(0).getText();
		System.out.println(labelCategory);

		String labelKmTravelled = lstlblKmTravelledInPOTab.get(0).getText();
		System.out.println(labelKmTravelled);

		String labelAmount = lstlblAmountInVCTTab.get(0).getText();
		System.out.println(labelAmount);

		String labelToEmailId = lstlblToEmailIdInPOTab.get(0).getText();
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

			lstlnkPrintInPOTab.get(0).click();

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

			String labelToEmailId = lstlblToEmailIdInPOTab.get(0).getText();
			System.out.println(labelToEmailId);

			lstlnkSendMailInPOTab.get(0).click();
			// Click on VCT Tab
			tabVCTInTicketForm.click();

			btnShowEmailLogInVCTTab.click();

			for (String Window1 : driver.getWindowHandles()) {
				driver.switchTo().window(Window1);
			}
			try {
				int size1 = lstRowTableInListOfSentMailsPage.size() - 2;
				System.out.println(size1);

				String labelSendTo = lstlblSendToListOfSentMailsPage.get(size1)
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

		// Click on Spare Tab
		tabVCTInTicketForm.click();

		// click on cancel ticket button
		btnUpdatePayment.click();

		for (String vendorCommercialPaymentDetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(vendorCommercialPaymentDetailsWindow);
			driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

		}

		String textOfVendorCommercialPaymentDetailsWindow = lblTitleAllTabDetailsPage
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
		btnSubmit.click();

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
		mode = new Select(ddlMode);
		mode.selectByVisibleText("Cash");

		// click on submit button
		btnSubmit.click();

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

		statusInUpdatePayment = new Select(ddlStatusOfUpdatePayment);
		statusInUpdatePayment.selectByVisibleText("Approved");

		// click on submit button
		btnSubmit.click();

		List<WebElement> editValueAfterUpdate = lstEditInUpdatePayment;
		int getSize = editValueAfterUpdate.size();
		System.out.println(getSize);

		String getEditValue = lstEditInUpdatePayment.get(getSize - 1).getText();
		System.out.println(getEditValue);

		List<WebElement> attachmentValueAfterUpdate = lstAttachmentInUpdatePayment;
		int getTotalSize = attachmentValueAfterUpdate.size();
		System.out.println(getTotalSize);

		String getAttachmentValue = lstAttachmentInUpdatePayment.get(
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
		// Click on Spare Tab
		tabVCTInTicketForm.click();

		// click on cancel ticket button
		btnUpdatePayment.click();

		for (String vendorCommercialPaymentDetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(vendorCommercialPaymentDetailsWindow);
			driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

		}

		// write Invoice No
		txtInvoiceNumber.sendKeys("123");
		String getInvoiceNumberValue = txtInvoiceNumber.getAttribute("value");
		System.out.println(getInvoiceNumberValue);

		// Write Amount value
		txtAmount.sendKeys("10000");
		String getAmountValue = txtAmount.getAttribute("value");
		System.out.println(getAmountValue);

		// Write TDS Amount value
		txtTSDAmount.sendKeys("500");
		String getTDSAmountValue = txtInvoiceNumber.getAttribute("value");
		System.out.println(getTDSAmountValue);

		// get total amount
		String getTotalAmountValue = txtTotalAmount.getAttribute("value");
		System.out.println(getTotalAmountValue);

		// select the mode of payment
		Select mode;
		mode = new Select(ddlMode);
		mode.selectByVisibleText("Cash");

		// write the reference code
		txtReferenceCode.sendKeys("W099");

		// select the mode of payment
		Select statusTextBox;
		statusTextBox = new Select(ddlStatusOfUpdatePayment);
		statusTextBox.selectByVisibleText("Approved");

		// click on submit button
		btnSubmit.click();

		List<WebElement> completeDataValueAfterUpdate = lstCompleteDataInUpdatePayment;
		int getRowSize = completeDataValueAfterUpdate.size();
		System.out.println(getRowSize);

		String getAllDetailValue = lstCompleteDataInUpdatePayment.get(
				getRowSize - 1).getText();
		System.out.println(getAllDetailValue);

		List<WebElement> statusValueAfterUpdate = lstStatusInUpdatePayment;
		int getTotalSize = statusValueAfterUpdate.size();
		System.out.println(getTotalSize);

		String getSatusValue = lstStatusInUpdatePayment.get(getTotalSize - 1)
				.getText();
		System.out.println(getSatusValue);

		List<WebElement> editValueAfterUpdate = lstEditInUpdatePayment;
		int getSize = editValueAfterUpdate.size();
		System.out.println(getSize);

		String getEditValue = lstEditInUpdatePayment.get(getSize - 1).getText();
		System.out.println(getEditValue);

		lstEditInUpdatePayment.get(getSize - 1).click();

		// driver.findElement(By.linkText(getEditValue)).click();

		for (String vendorCommercialPaymentDetailsWindow : driver
				.getWindowHandles()) {

			System.out.println(vendorCommercialPaymentDetailsWindow);
			driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

		}

		// change the Attachment of payment
		Select modeAfterClickOnEditLink;
		modeAfterClickOnEditLink = new Select(ddlStatusOfUpdatePayment);
		modeAfterClickOnEditLink.selectByIndex(2);

		String statusValueInDatails = ddlStatusOfUpdatePayment
				.getAttribute("value");
		System.out.println(statusValueInDatails);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// click on update detail button
		btnSubmitAndUpdateDetailOfVendorCommercialPaymentDetails.click();

		List<WebElement> statusValueAfterEdit = lstStatusInUpdatePayment;
		int getStatusColumnSize = statusValueAfterEdit.size();
		System.out.println(getStatusColumnSize);

		String getStatusValueAfterEdit = lstStatusInUpdatePayment.get(
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
			btnUpdatePayment.click();

			for (String vendorCommercialPaymentDetailsWindow : driver
					.getWindowHandles()) {

				System.out.println(vendorCommercialPaymentDetailsWindow);
				driver.switchTo().window(vendorCommercialPaymentDetailsWindow);

			}

			// select the mode of payment
			Select mode;
			mode = new Select(ddlMode);
			mode.selectByVisibleText("Cash");

			// select the mode of payment
			Select statusTextBox;
			statusTextBox = new Select(ddlStatusOfUpdatePayment);
			statusTextBox.selectByVisibleText("Quote");

			// Browse the file
			// Enter File Name
			String fileName = "Desert.jpg";
			System.out.println(fileName);
			// Enter File Path
			btnBrowseUpdatePayment
					.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
			// Get uploaded file name
			String browseFileName = btnBrowseUpdatePayment
					.getAttribute("value");
			System.out.println(browseFileName);

			// click on submit button
			btnSubmit.click();

			List<WebElement> attachmentValue = lstAttachmentInUpdatePayment;
			int getSize = attachmentValue.size();
			System.out.println(getSize);

			String getAttachmentValue = lstAttachmentInUpdatePayment.get(
					getSize - 1).getText();
			System.out.println(getAttachmentValue);

			driver.findElement(By.linkText(getAttachmentValue)).click();

			for (String listOfAttachmentsWindow : driver.getWindowHandles()) {

				System.out.println(listOfAttachmentsWindow);
				driver.switchTo().window(listOfAttachmentsWindow);

			}
			try {
				List<WebElement> attachmentListValue = lstListOfAttachment;
				int getSizeOfAllFile = attachmentListValue.size();
				System.out.println(getSizeOfAllFile);

				String getAttachmentFileName = lstListOfAttachment.get(
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
		tabKEDB.click();

		// click on final close button
		btnAddKEDB.click();

		Thread.sleep(1000);
		// get the Final Close Details window name
		String windowValue = lblKEDBDetailsWindow.getText();
		System.out.println(windowValue);

		// match the window
		softAssert.assertEquals(windowValue, "KEDB Details");

		// click on Add KEDB button, without entering data
		btnAddKEDBInKEDBDetails.click();

		// get the alert message
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();
		Thread.sleep(500);

		softAssert.assertEquals(alertMessage, "Please Enter Known Error");

		// enter the Known error
		txtKnownError.sendKeys("asdddd");

		// click on Add KEDB button,after Known error field is fill
		btnAddKEDBInKEDBDetails.click();

		// get the alert message
		Alert alertOfWorkAround = driver.switchTo().alert();

		String alertOfWorkAroundMessage = alertOfWorkAround.getText();
		System.out.println(alertOfWorkAroundMessage);
		alertOfWorkAround.accept();
		Thread.sleep(500);

		softAssert.assertEquals(alertOfWorkAroundMessage,
				"Please Enter Work Around Details");

		// enter the work around detail
		txtWorkArroundDetail.sendKeys("ghjjj");

		// click on Add KEDB button,after Known error field is fill
		btnAddKEDBInKEDBDetails.click();

		// get the alert message
		Alert alertOfSolution = driver.switchTo().alert();

		String alertOfSolutionMessage = alertOfSolution.getText();
		System.out.println(alertOfSolutionMessage);
		alertOfSolution.accept();
		Thread.sleep(500);

		softAssert
				.assertEquals(alertOfSolutionMessage, "Please Enter Solution");

		// enter the solution
		txtSolution.sendKeys("abcbcbcb");

		// click on Add KEDB button,after entering all the detail
		btnAddKEDBInKEDBDetails.click();

		String textOfNotification = msgNotification.getText();
		System.out.println(textOfNotification);

		softAssert.assertEquals(textOfNotification, "KEDB added successfully.");
		softAssert.assertAll();

	}

	// CCT tab
	public void checkCCTtab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on CCT Tab
		tabCCT.click();

		// click on create PI tab
		btnCreatePI.click();

		// get the Customer Commercial Proforma Details window name
		String windowValue = lblCustomerCommercialProformaDetailsPopUp
				.getText();
		System.out.println(windowValue);

		// match the window
		softAssert.assertEquals(windowValue,
				"Customer Commercial Proforma Details");

		// click on submit button without entering any data
		btnSubmit.click();

		// get the alert message
		Alert alertOfSolution = driver.switchTo().alert();

		String alertOfSolutionMessage = alertOfSolution.getText();
		System.out.println(alertOfSolutionMessage);
		alertOfSolution.accept();
		Thread.sleep(500);

		softAssert.assertEquals(alertOfSolutionMessage, "Please Select Status");

		// click on cancel button
		btnCancel.click();
		softAssert.assertAll();

	}

	// Cancel Ticket

	// If User click on Cancel ticket button in Cancel ticket tab then 'Cancel
	// Ticket Details' pop up should get open .

	public void checkCancelTicketDetailPOpUp() throws Exception {

		tabCancelTicket.click();

		// click on cancel ticket button
		btnCancelTicket.click();

		for (String cancelTicketDetailsWindow : driver.getWindowHandles()) {

			System.out.println(cancelTicketDetailsWindow);
			driver.switchTo().window(cancelTicketDetailsWindow);

		}

		String textOfCancelTicketDetailsWindow = lblTitleAllTabDetailsPage
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
		txtResolution.sendKeys("abc");
		String tsdFieldValue = txtResolution.getAttribute("value");

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

		btnCancelTicketInCancelTicketDetails.click();

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

		txtCancelReason.sendKeys("Spare is not available");

		// click on cancel button
		btnCancelTicketInCancelTicketDetails.click();

		String getNotification = msgNotification.getText();
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
		btnCreatePOInVCTTab.click();

		Select selectVendor = new Select(ddlVendorInVCTTab);
		List<WebElement> listOfVendor = selectVendor.getOptions();
		Thread.sleep(500);
		String dropdownVendor = listOfVendor.get(1).getAttribute("value");
		System.out.println(dropdownVendor);
		selectVendor.selectByIndex(1);

		String rate = "2";
		txtRateInVCTTab.sendKeys(rate);
		System.out.println(rate);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		btnSubmitInCommercialPODetailsPopup.click();

	}

	public void SelectEngineerInFilterTab() throws Exception {
		// click on filter
		tabFilter.click();

		// select engineer filter
		Select engineer;
		engineer = new Select(ddlEngineer);
		// engineer.selectByVisibleText("Swati .");
		engineer.selectByVisibleText("Pranjali Deshpande");

	}

	// select spare with device,Non consumable,stock and then technician close ,
	// to replace serial number is

	public void selectSpareWithDeviceAndTechClose() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		Thread.sleep(500);
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			List<WebElement> status = lstStatusInTable;
			int size = status.size();
			System.out.println(size);

			for (int i = 0; i < size; i++) {

				String statusValue = status.get(i).getText();
				System.out.println(statusValue);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (statusValue.equalsIgnoreCase("Open") && !ETA.equals("")
						&& !ATA.equals(""))

				{

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));
					lstIDInTable.get(i).click();

					// click on spare tab
					tabSpare.click();

					// click on Edit button
					btnEditInSpareTab.click();

					for (String spareDetailsWindow : driver.getWindowHandles()) {

						System.out.println(spareDetailsWindow);
						driver.switchTo().window(spareDetailsWindow);

					}

					// select the Spares Consumed By Inventory logistic
					Select sparesConsumed;
					sparesConsumed = new Select(ddlSparesConsumed);
					sparesConsumed.selectByVisibleText("Yes");

					// list symbol button in spare detail window
					btnSymbolOfSpareDetail.click();

					for (String listOfAvailableSparesWindow : driver
							.getWindowHandles()) {

						System.out.println(listOfAvailableSparesWindow);
						driver.switchTo().window(listOfAvailableSparesWindow);

					}
					// get part name from list of Available Spares Window
					// select the part name if transaction type is stock
					List<WebElement> transactionType = lstTransactionTypeInSpareDetail;
					int sizeOfSapre = transactionType.size();
					System.out.println(sizeOfSapre);

					for (int j = 0; j < transactionType.size(); j++) {

						String transactionTypeValue = lstTransactionTypeInSpareDetail
								.get(j).getText();
						System.out.println(transactionTypeValue);

						String productClassificationValue = lstProductClassificationInSpareDetail
								.get(j).getText();
						System.out.println(productClassificationValue);

						String partTypeValue = lstPartTypeInSpareDetail.get(j)
								.getText();
						System.out.println(partTypeValue);

						if (productClassificationValue
								.equalsIgnoreCase("Device")
								&& partTypeValue
										.equalsIgnoreCase("Non-Consumable")
								&& transactionTypeValue
										.equalsIgnoreCase("Stock"))

						{

							String partName = lstPartNameInSpareDetail.get(j)
									.getText();
							System.out.println(partName);

							// select part name from list of Available
							// Spares Window
							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									lstPartNameInSpareDetail.get(j));
							lstPartNameInSpareDetail.get(j).click();

							for (String spareDetailsWindow : driver
									.getWindowHandles()) {

								System.out.println(spareDetailsWindow);
								driver.switchTo().window(spareDetailsWindow);

							}
							// select the part code as replace with another part
							// code
							Select partCodeInRepaceTab;
							partCodeInRepaceTab = new Select(
									ddlPartCodeInReplaceSpare);
							partCodeInRepaceTab
									.selectByVisibleText("Replace With Another PartCode");

							// select the part code for replace
							String anotherPartCodeInReplaceTabValue = lstddlAnotherPartCodeInReplaceSpare
									.get(1).getText();
							System.out
									.println(anotherPartCodeInReplaceTabValue);

							Select anotherPartCodeInReplaceTab;
							anotherPartCodeInReplaceTab = new Select(
									ddlAnotherPartCodeInReplaceSpare);
							anotherPartCodeInReplaceTab
									.selectByVisibleText(anotherPartCodeInReplaceTabValue);

							// select the status
							Select statusDoprdown;
							statusDoprdown = new Select(ddlStatus);
							statusDoprdown.selectByVisibleText("Good");

							driver.manage().timeouts()
									.pageLoadTimeout(60, TimeUnit.SECONDS);
							// click on update button
							btnUpdateDetail.click();

						}
						if (sizeOfSapre - 1 == j) {
							softAssert
									.assertTrue(false,
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

		tabTechnicianClose.click();

		btnEditOfTechncianClose.click();
		Thread.sleep(500);
		// To Handle window based pop-up
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_CONTROL);
		// robot.keyPress(KeyEvent.VK_MINUS);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// Thread.sleep(2000);
		btnSubmitTechCloseDetails.click();
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
		 * String datePattern = "yyyy-MM-dd"; DateFormat dateFormat = new
		 * SimpleDateFormat(datePattern);
		 * 
		 * // Format Time String timePattern = "HH:mm"; DateFormat timeFormat =
		 * new SimpleDateFormat(timePattern);
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
		calTechnicianClosePage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInTechnicianClosePage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		// Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		btnSubmitTechCloseDetails.click();
		Thread.sleep(1000);

		String alertTime = alert.getText();
		System.out.println("Alert Text:" + alertTime);
		alert.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(alertTime, "Please enter Tech Close Time.");
		System.out.println("Both the message is equal");

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
		System.out.println(hrs);
		String min = new SimpleDateFormat("mm").format(calendar.getTime());
		System.out.println(min);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlHrsOfTechnicianCloseTime) {

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

		for (WebElement minOfSystem : ddlMinOfTechnicianCloseTime) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {

				Thread.sleep(1000);
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		// Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		btnSubmitTechCloseDetails.click();

		// get the message from that alert box

		String alertResolution = alert.getText();
		System.out.println("Alert Text:" + alertResolution);
		alert.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(alertResolution, "Please Enter Resolution");
		System.out.println("Both the message is equal");

		String resolution = "abc";
		txtResolutionInTechnicianClose.sendKeys(resolution);
		Thread.sleep(500);
		btnSubmitTechCloseDetails.click();
		Thread.sleep(500);
		// get the message from that alert box

		String alertResolutionDescription = alert.getText();
		System.out.println("Alert Text:" + alertResolutionDescription);
		alert.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(alertResolutionDescription,
				"Please Enter Resolution Description");
		System.out.println("Both the message is equal");

		String resolutionDescription = "xyz";
		txtResolutionDescriptionInTechnicianClose
				.sendKeys(resolutionDescription);
		// Thread.sleep(00);

		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_CONTROL);
		/*
		 * driver.manage().timeouts() .pageLoadTimeout(40, TimeUnit.SECONDS);
		 * button_submitTechCloseDetails.click();
		 * 
		 * // Get Notification // Thread.sleep(1000); String notificationText =
		 * notification.getText(); System.out.println(notificationText);
		 * 
		 * softAssert.assertEquals(notificationText, "Please enter FSR No",
		 * "Notification is not Match");
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
		txtFSRNoInTechnicianClose.sendKeys(FSRNo);
		txtSerialNumberInTechClose.sendKeys("567");
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);",
						btnSubmitTechCloseDetails);
		Thread.sleep(500);

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		btnSubmitTechCloseDetails.click();

		// Get Notification
		// Thread.sleep(1000);
		String notificationText1 = msgNotification.getText();
		System.out.println(notificationText1);

		softAssert.assertEquals(notificationText1,
				"Incident Updated SuccessFully", "Notification is not Match");
		softAssert.assertAll();

	}

	// If User click on Generate PDF button after technician close then in 'End
	// Of Service' technician close date and time should display
	public void checkGeneratePDFLink() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		String parentWindow = driver.getWindowHandle();

		// click on generate PDF button
		btnGeneratePDF.click();

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
		tabTechnicianClose.click();

		// click on edit button
		btnEditOfTechncianClose.click();

		String notificationText = msgNotification.getText();
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
		tabTechnicianClose.click();
		Thread.sleep(5000);

		getTechnicianDateTime = lblTechnicianCloseTime.getText();
		System.out.println("getTechnicianDateTime" + getTechnicianDateTime);
		// get the serial number from technician close tab
		String serialNumberValue = lblSerialNumber.getText();
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
		tabTechnicianClose.click();

		// click on final close button
		btnClose.click();

		// get the Final Close Details window
		String windowValue = lblFinalCloseDetailsWindow.getText();
		System.out.println(windowValue);

		// match the window
		softAssert.assertEquals(windowValue, "Final Close Details");

		softAssert.assertAll();

	}

	// without entering any data if user click on update detail button then
	// 'Please enter Final close date.' pop up message should display.
	public void checkUpdateDetailsWithBlankData() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		btnUpdateDetail.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();

		// match the window
		softAssert.assertEquals(alertMessage, "Please enter Final close date.");
		// button_Cancel.click();
		softAssert.assertAll();

	}

	// if user select the close date less than technician close date then 'Final
	// close date/time should be greater than Tech close date/time.' pop up
	// should be display
	public void compareCloseDateWithTechnicianDateTime() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// String getTechnicianDateTime = label_TechnicianCloseTime.getText();
		System.out.println("getTechnicianDateTime" + getTechnicianDateTime);

		String splitTime = getTechnicianDateTime.split(" ")[0];
		String splitYearAndMonth = splitTime.split("-")[2];
		System.out.println("date" + splitYearAndMonth);
		// select Date in Calendar

		/*
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // click on final close button button_Close.click();
		 */

		Actions action = new Actions(driver);
		action.moveToElement(btnSymbolCloseDateCalender).doubleClick().build()
				.perform();
		Thread.sleep(3000);

		for (WebElement day : dtpCalendarInTechnicianClosePage) {

			String dayInCalender = day.getText();

			if (splitYearAndMonth.contains(dayInCalender)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		String getCloseDateValue = txtCloseDate.getAttribute("value");
		System.out.println(getCloseDateValue);

		if (splitYearAndMonth.compareTo(getCloseDateValue) >= 0) {

			btnUpdateDetail.click();
			Thread.sleep(3000);

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(500);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			// driver.switchTo().defaultContent();

			softAssert
					.assertEquals(alertMessage,
							"Final close date/time should be greater than Tech close date/time.");
			// button_Cancel.click();
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
		/*
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // click on final close button button_Close.click();
		 */
		// select close date and time

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay);
		String previousDay = Integer.toString(preDay);
		btnSymbolCloseDateCalender.click();

		for (WebElement day : dtpCalendarInTechnicianClosePage) {

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

		if (getCloseDateValue.compareTo(SystemDateValue) >= 0) {

			btnUpdateDetail.click();
			Thread.sleep(3000);

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			// driver.switchTo().defaultContent();

			softAssert
					.assertEquals(alertMessage,
							"Final close date/time should be greater than Tech close date/time.");

			// button_Cancel.click();

		}
		softAssert.assertAll();

	}

	// If User enter final close date/time less than technician close date and
	// time
	// then notification should display as 'Final close date/time should be
	// greater than Tech close date/time.'
	public void compareCloseDateTimeWithTechnicianDateTime() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// String getTechnicianDateTime = label_TechnicianCloseTime.getText();
		System.out.println(getTechnicianDateTime);

		Thread.sleep(1000);
		/*
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // click on final close button button_Close.click();
		 */
		// select close date and time

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay);
		String previousDay = Integer.toString(preDay);
		btnSymbolCloseDateCalender.click();

		for (WebElement day : dtpCalendarInTechnicianClosePage) {

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

		for (WebElement hrsofSystem : lstddlCloseTimeHourValue) {

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

		for (WebElement minOfSystem : lstddlCloseTimeMinuteValue) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(nextMinutValue)) {

				Thread.sleep(1000);
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		String getCloseTimeHourValue = ddlCloseTimeHour.getAttribute("value");
		System.out.println(getCloseTimeHourValue);

		String getCloseTimeMinuteValue = ddlCloseTimeMinute
				.getAttribute("value");
		System.out.println(getCloseTimeMinuteValue);

		String addTime = getCloseTimeHourValue.concat(":"
				+ getCloseTimeMinuteValue);

		System.out.println(addTime);

		String addDateTime = getCloseDateValue.concat(" " + addTime);
		System.out.println(addDateTime);

		if (getTechnicianDateTime.compareTo(addDateTime) <= 0) {

			btnUpdateDetail.click();
			Thread.sleep(3000);

			// get the message from that alert box
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);

			String alertMessage = alert.getText();
			System.out.println("Alert Text:" + alertMessage);
			alert.accept();
			// driver.switchTo().defaultContent();

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
		/*
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // get the serial number from technician close tab String
		 * serialNumberValue = label_SerialNumber.getText(); String
		 * splitNumberValue = serialNumberValue.split("Serial No. :")[1];
		 * serialNumber = splitNumberValue.split(" ")[1];
		 */
		System.out.println(serialNumber);

		/*
		 * // click on final close button button_Close.click();
		 */
		// get the value of serial number
		String serialNo = txtSerialNumber.getText();
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

		/*
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // click on final close button button_Close.click();
		 */
		// select close date and time

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay);
		String previousDay = Integer.toString(preDay);
		btnSymbolCloseDateCalender.click();

		for (WebElement day : dtpCalendarInTechnicianClosePage) {

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

		for (WebElement hrsofSystem : lstddlCloseTimeHourValue) {

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

		for (WebElement minOfSystem : lstddlCloseTimeMinuteValue) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(previousMinutValue)) {

				Thread.sleep(1000);
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		String getCloseTimeHourValue = ddlCloseTimeHour.getAttribute("value");
		System.out.println(getCloseTimeHourValue);

		String getCloseTimeMinuteValue = ddlCloseTimeMinute
				.getAttribute("value");
		System.out.println(getCloseTimeMinuteValue);

		btnUpdateDetail.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		// driver.switchTo().defaultContent();

		softAssert.assertEquals(alertMessage, "Serial No. does not match.");
		softAssert.assertAll();

	}

	// In user enter replaced serial number while tech close and in Final Close
	// Details pop up->Update Serial No For this
	// Asset field if user enter different value then notification should
	// display as 'Serial No. does not match.'
	public void matchPopUpWithUpdateSerialNoFieldFill() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		/*
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // click on final close button button_Close.click();
		 * 
		 * // select close date and time // Get System Date Calendar mydate =
		 * new GregorianCalendar(); int dayOfMonth =
		 * mydate.get(Calendar.DAY_OF_MONTH); System.out.println(dayOfMonth);
		 * String currentDay = Integer.toString(dayOfMonth);
		 * 
		 * int preDay = Integer.parseInt(currentDay); String previousDay =
		 * Integer.toString(preDay); symbol_CloseDateCalender.click();
		 * 
		 * for (WebElement day : day_CalendarInTechnicianClosePage) {
		 * 
		 * String dayInCalender = day.getText();
		 * 
		 * if (dayInCalender.equalsIgnoreCase(previousDay)) {
		 * Thread.sleep(1000); day.click(); String getDateValue = day.getText();
		 * System.out.println("Select the date:-" + getDateValue);
		 * 
		 * break; }
		 * 
		 * } String getCloseDateValue = textbox_CloseDate.getAttribute("value");
		 * System.out.println(getCloseDateValue);
		 * 
		 * // select ETA Time Minute // Get System Time Calendar calendar =
		 * Calendar.getInstance(); String hrs = new
		 * SimpleDateFormat("HH").format(calendar.getTime());
		 * System.out.println(hrs); String min = new
		 * SimpleDateFormat("mm").format(calendar.getTime());
		 * System.out.println(min);
		 * 
		 * int previousMinut = Integer.parseInt(min) - 1; String
		 * previousMinutValue = Integer.toString(previousMinut);
		 * 
		 * System.out.println(previousMinutValue);
		 * 
		 * // select Hrs in Drop down
		 * 
		 * for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {
		 * 
		 * String hrsInDropdown = hrsofSystem.getText();
		 * 
		 * if (hrsInDropdown.equalsIgnoreCase(hrs)) {
		 * 
		 * Thread.sleep(1000); hrsofSystem.click(); String getDateValue =
		 * hrsofSystem.getText(); System.out.println("Select the hrs:-" +
		 * getDateValue);
		 * 
		 * break; }
		 * 
		 * }
		 * 
		 * // select Min in Drop down
		 * 
		 * for (WebElement minOfSystem : dropdown_CloseTimeMinuteValue) {
		 * 
		 * String minInDropdown = minOfSystem.getText();
		 * 
		 * if (minInDropdown.equalsIgnoreCase(previousMinutValue)) {
		 * 
		 * Thread.sleep(1000); minOfSystem.click(); String getDateValue =
		 * minOfSystem.getText(); System.out.println("Select the min:-" +
		 * getDateValue);
		 * 
		 * break; }
		 * 
		 * }
		 */
		// enter the update serial number in Update Serial No
		// For
		// this Asset field
		txtUpdateSerialNo.sendKeys("123");

		btnUpdateDetail.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		Thread.sleep(500);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		// driver.switchTo().defaultContent();

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

		/*
		 * // click on filter tab_Filter.click();
		 * 
		 * // select engineer filter Select engineer; engineer = new
		 * Select(dropdown_Engineer);
		 * engineer.selectByVisibleText("Pranjali Deshpande");
		 * 
		 * Thread.sleep(500);
		 * 
		 * int sizePagination = dropdown_Pagination.size();
		 * System.out.println(sizePagination); loop: for (int p = 0; p <
		 * sizePagination; p++) {
		 * 
		 * dropdown_Pagination.get(p).click();
		 * 
		 * List<WebElement> status = list_StatusInTable; int size =
		 * status.size(); System.out.println(size);
		 * 
		 * for (int i = 0; i < size; i++) {
		 * 
		 * String statusValue = status.get(i).getText();
		 * System.out.println(statusValue);
		 * 
		 * if (statusValue.equalsIgnoreCase("TechnicianClosed"))
		 * 
		 * {
		 * 
		 * List<WebElement> SelectID = driver .findElements(By
		 * .xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
		 * String SelectIDWithPink = SelectID.get(i).getAttribute( "class");
		 * System.out.println(SelectIDWithPink);
		 * 
		 * if (SelectIDWithPink.contains("techclosed")) {
		 * 
		 * String serialNumberValue = list_SerialNumberInTable
		 * .get(i).getText(); System.out.println(serialNumberValue);
		 * 
		 * // get ID from list of Available Spares Window String idValue =
		 * list_IDInTable.get(i).getText(); System.out.println(idValue);
		 * 
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].scrollIntoView(true);", list_IDInTable.get(i));
		 * list_IDInTable.get(i).click();
		 * 
		 * // click on Technician close tab tab_TechnicianClose.click();
		 * 
		 * // get the serial number from technician close tab String
		 * serialNumberValueInTechClose = label_SerialNumber .getText(); String
		 * splitNumberValue = serialNumberValueInTechClose
		 * .split("Serial No. :")[1]; String splitSpace =
		 * splitNumberValue.split(" ")[1]; System.out.println(splitSpace);
		 * 
		 * // click on final close button_Close.click();
		 * 
		 * // Get System Date Calendar mydate = new GregorianCalendar(); int
		 * dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		 * System.out.println(dayOfMonth); String currentDay =
		 * Integer.toString(dayOfMonth);
		 * 
		 * int preDay = Integer.parseInt(currentDay); String previousDay =
		 * Integer.toString(preDay); symbol_CloseDateCalender.click();
		 * 
		 * // select close date and time
		 * 
		 * // select Date String getDateValue = null;
		 * 
		 * List<WebElement> allDates = driver .findElements(By
		 * .xpath(".//*[@id='fd-dp-4']/table/tbody/tr/td"));
		 * 
		 * for (WebElement ele : allDates) {
		 * 
		 * String date = ele.getText();
		 * 
		 * if (date.equalsIgnoreCase(previousDay)) { Thread.sleep(1000);
		 * ele.click(); getDateValue = ele.getText();
		 * System.out.println("Select the date:-" + getDateValue);
		 * 
		 * break; }
		 * 
		 * }
		 * 
		 * String getCloseDateValue = textbox_CloseDate .getAttribute("value");
		 * 
		 * System.out.println(getCloseDateValue);
		 * 
		 * // select ETA Time Minute
		 * 
		 * // Get System Time Calendar calendar = Calendar.getInstance(); String
		 * hrs = new SimpleDateFormat("HH").format(calendar .getTime()); int
		 * preHour = Integer.parseInt(hrs); String previousHour =
		 * Integer.toString(preHour);
		 * 
		 * System.out.println(hrs); String min = new
		 * SimpleDateFormat("mm").format(calendar .getTime()); int preMinute =
		 * Integer.parseInt(min) - 1; String previousMinute =
		 * Integer.toString(preMinute);
		 * 
		 * System.out.println(previousMinute);
		 * 
		 * // select Hrs in Drop down
		 * 
		 * for (WebElement hrsofSystem : dropdown_CloseTimeHourValue) {
		 * 
		 * String hrsInDropdown = hrsofSystem.getText();
		 * 
		 * if (hrsInDropdown.equalsIgnoreCase(previousHour)) {
		 * 
		 * Thread.sleep(1000); hrsofSystem.click(); String getTimeHour =
		 * hrsofSystem.getText(); System.out.println("Select the hrs:-" +
		 * getTimeHour);
		 * 
		 * break; }
		 * 
		 * }
		 * 
		 * // select Minute in Drop down
		 * 
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
		 * 
		 * 
		 * Select closeTimeMinute; closeTimeMinute = new
		 * Select(dropdown_CloseTimeMinute);
		 * closeTimeMinute.selectByVisibleText("00"); Thread.sleep(3000);
		 * 
		 * 
		 * String getCloseTimeHourValue = dropdown_CloseTimeHour
		 * .getAttribute("value"); System.out.println(getCloseTimeHourValue);
		 * 
		 * String getCloseTimeMinuteValue = dropdown_CloseTimeMinute
		 * .getAttribute("value"); System.out.println(getCloseTimeMinuteValue);
		 */

		try {
			// update the serial number
			txtUpdateSerialNo.sendKeys(serialNumber);

			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			btnUpdateDetail.click();

			Thread.sleep(1000);

			/*
			 * // click on search ticket tab tab_SearchTicket.click();
			 * 
			 * // enter the alphabetical value in ID field, after that // it //
			 * display the alert box textbox_SearchId.sendKeys(idValue);
			 * 
			 * // click on Go button button_IDGo.click();
			 */
			Thread.sleep(1000);

			String serialNumberValueAfterUpdateSerialNumber = driver
					.findElement(
							By.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[10]"))
					.getText();
			System.out.println(serialNumberValueAfterUpdateSerialNumber);
			String serialNumberValueAfterUpdateSerialNo = serialNumberValueAfterUpdateSerialNumber
					.split("Serial No. :")[1];

			softAssert.assertEquals(serialNumberValueAfterUpdateSerialNo,
					serialNumber);
		} catch (Exception e) {
			btnCancel.click();
		}

		softAssert.assertAll();
	}

	public void selectTicketForTechnicianClose() throws Exception {

		tabFilter.click();

		// select engineer filter
		Select engineer;
		engineer = new Select(ddlEngineer);
		engineer.selectByVisibleText("Pranjali Deshpande");

		Thread.sleep(500);
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (status.equalsIgnoreCase("open") && !ETA.equals("")
						&& !ATA.equals("")) {
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));
					lstIDInTable.get(i).click();
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
		tabFilter.click();

		// select engineer filter
		Select engineer;
		engineer = new Select(ddlEngineer);
		engineer.selectByVisibleText("Pranjali Deshpande");

		Thread.sleep(500);

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			List<WebElement> status = lstStatusInTable;
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
								lstIDInTable.get(i));
						lstIDInTable.get(i).click();

						// click on Technician close tab
						tabTechnicianClose.click();

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

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			Thread.sleep(3000);

			List<WebElement> status = lstStatusInTable;
			int size = status.size();
			System.out.println(size);

			for (int i = 0; i < size; i++) {

				String statusValue = status.get(i).getText();
				System.out.println(statusValue);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String tech = lstTechnicianInTable.get(i).getText();
				System.out.println(tech);

				if (statusValue.equalsIgnoreCase("Open") && ETA.equals("")
						&& !tech.equals("")) {

					// click on ID
					String idValue = lstIDInTable.get(i).getText();
					System.out.println(idValue);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));

					lstIDInTable.get(i).click();

					Thread.sleep(1000);

					// click on create sub ticket tab

					tabCreateSubTicket.click();

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
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

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
		calETADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInETADetailsPage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(500);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		// Get Date in ATA Date Text box
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		String currentDate = txtETADateInETADetailsPage.getAttribute("value");
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

		for (WebElement hrsofSystem : ddlHrsOfETATimeInETADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfETATimeInETADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		// Click on update button
		btnUpdateDetail.click();
		// Thread.sleep(3000);

		// get the message from that alert box
		Alert technicianAlert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String technicianAlertMessage = technicianAlert.getText();
		System.out.println("Alert Text:" + technicianAlertMessage);
		technicianAlert.dismiss();

		Thread.sleep(1000);
		// click on create sub ticket tab

		tabCreateSubTicket.click();

		// get alert
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();

		softAssert.assertEquals(alertMessage, "Please Update ATA Date First");
		softAssert.assertAll();

	}

	// If User click on create sub ticket button for pause ticket then ticket
	// form should get open to record sub ticket
	public void checkCreateSubTicketAndViewSubTicketForPause() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// Format Date
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);

		// Format Time
		String timePattern = "HH:mm";
		DateFormat timeFormat = new SimpleDateFormat(timePattern);

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
		calATADetailsPage.click();

		// select Date in Calendar
		for (WebElement day : dtpCalendarInATADetailsPage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		/*
		 * // Get Date in ATA Date Text box String currentDate =
		 * textbox_ATADateInATADetailsPage .getAttribute("value");
		 * System.out.println(currentDate); Date ATADate = (Date)
		 * dateFormat.parse(currentDate); System.out.println(ATADate);
		 */

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

		// select Min in Drop down
		for (WebElement minOfSystem : ddlMinOfATATimeInATADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		/*
		 * // concatenation of Hrs & min String hrsMin = hrs.concat(":" + min);
		 * System.out.println(hrsMin); Date ATATime = (Date)
		 * timeFormat.parse(hrsMin); System.out.println(ATATime);
		 */

		// Select Machine Available
		Select machineAvailable = new Select(
				ddlMachineAvailableInATADetailsPage);
		machineAvailable.selectByVisibleText("Yes");

		// Click on Update Details
		btnUpdateDetailsInATADetailsPage.click();

		// click on create sub ticket tab

		tabCreateSubTicket.click();

		// get alert
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();

		softAssert.assertEquals(alertMessage,
				"Are You Sure Want To Create Sub Ticket?");

		String headingValueOfTicketForm = lblHeading.getText();
		System.out.println(headingValueOfTicketForm);

		softAssert.assertEquals(headingValueOfTicketForm, "Ticket Form");

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		btnRecordSubTicket.click();
		Thread.sleep(1000);

		String headingValueOfSubTicketForm = lblHeading.getText();
		System.out.println(headingValueOfSubTicketForm);

		softAssert.assertEquals(headingValueOfSubTicketForm, "Sub Ticket Form");

		sd_CreateNewPage = new SD_CreateNewPage();
		WebElement fromCreateTicketPage = SD_CreateNewPage.textbox_IncidenID;
		String getSatusValue = fromCreateTicketPage.getText();
		System.out.println(getSatusValue);
		String splitStatus = getSatusValue.split("\n")[2];
		System.out.println(splitStatus);

		// check the status of sub ticket is change to open
		softAssert.assertEquals(splitStatus, "Status : Open");
		softAssert.assertAll();

	}

	public void punchTheETABySelectingTicket() throws Exception {
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			List<WebElement> status = lstStatusInTable;
			System.out.println(status.size());

			for (int i = 0; i < status.size(); i++) {

				String statusValue = status.get(i).getText();
				System.out.println(statusValue);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				if (statusValue.equalsIgnoreCase("Open") && ETA.equals(""))

				{

					// get ID from list of Available Spares Window
					String idValue = lstIDInTable.get(i).getText();
					System.out.println(idValue);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					// click on that ID
					// driver.findElement(By.linkText(idValue)).click();
					// Thread.sleep(2000);

					// click on ETA and Technician tab
					tabETATechnician.click();

					// click on Call Assign To Technician Button.
					btnCallAssignToTechnician.click();

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
					calETADetailsPage.click();

					// select Date in Calendar

					for (WebElement day : dtpCalendarInETADetailsPage) {

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
					String currentDate = txtETADateInETADetailsPage
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

					for (WebElement hrsofSystem : ddlHrsOfETATimeInETADetailsPage) {

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

					for (WebElement minOfSystem : ddlMinOfETATimeInETADetailsPage) {

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
					btnUpdateDetail.click();
					// Thread.sleep(3000);

					// get the message from that alert box
					Alert technicianAlert = driver.switchTo().alert();
					// Thread.sleep(3000);

					String technicianAlertMessage = technicianAlert.getText();
					System.out.println("Alert Text:" + technicianAlertMessage);
					technicianAlert.dismiss();

					String notificationText = msgNotification.getText();
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

	public void punchTheATABySelectingTicket() throws Exception {
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstIDInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				if (status.equals("Open") && !ETA.equals("") && ATA.equals("")) {
					String idValue = lstIDInTable.get(i).getText();
					System.out.println(idValue);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));

					lstIDInTable.get(i).click();

					// Format Date
					String datePattern = "yyyy-MM-dd";
					DateFormat dateFormat = new SimpleDateFormat(datePattern);

					// Format Time
					String timePattern = "HH:mm";
					DateFormat timeFormat = new SimpleDateFormat(timePattern);

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
					calATADetailsPage.click();

					// select Date in Calendar
					for (WebElement day : dtpCalendarInATADetailsPage) {

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

					// Select Machine Available
					Select machineAvailable = new Select(
							ddlMachineAvailableInATADetailsPage);
					machineAvailable.selectByVisibleText("Yes");

					// Click on Update Details
					btnUpdateDetailsInATADetailsPage.click();

					String notificationText = msgNotification.getText();
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

	public void punchTheETA() throws Exception {

		// click on ETA and Technician tab
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		for (String Window : driver.getWindowHandles()) {

			System.out.println(Window);

			btnTechnicianList.click();

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

			int size = lstTechnicianName.size();

			for (int j = 0; j < size; j++) {

				// Thread.sleep(2000);
				String technicianVlaue = lstTechnicianName.get(j).getText();
				System.out.println(technicianVlaue);

				if (technicianVlaue.contains("Pranjali Deshpande"))

				{
					// Thread.sleep(2000);
					lstTechnicianName.get(j).click();
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
		/*
		 * // Used If you want select Previous date int nextDay =
		 * Integer.parseInt(currentDay) ; String nxtDay =
		 * Integer.toString(nextDay);
		 */
		calETADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInETADetailsPage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(500);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		// Get Date in ATA Date Text box
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		String currentDate = txtETADateInETADetailsPage.getAttribute("value");
		System.out.println(currentDate);
		Date ATADate = (Date) dateFormat.parse(currentDate);
		System.out.println(ATADate);

		// Get System Time
		Calendar calendar = Calendar.getInstance();
		String currentHrs = new SimpleDateFormat("HH").format(calendar
				.getTime());
		System.out.println(currentHrs);
		int nextHrs = Integer.parseInt(currentHrs);
		String hrs = Integer.toString(nextHrs);

		String currentMin = new SimpleDateFormat("mm").format(calendar
				.getTime());
		System.out.println(currentMin);
		int nextMin = Integer.parseInt(currentMin) + 1;
		String min = Integer.toString(nextMin);

		// select Hrs in Drop down

		for (WebElement hrsofSystem : ddlHrsOfETATimeInETADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfETATimeInETADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		btnUpdateDetail.click();
		// Thread.sleep(3000);
		String notificationText = null;
		try {
			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			// Thread.sleep(3000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			Thread.sleep(1000);
			technicianAlert.dismiss();
			// driver.switchTo().defaultContent();
			notificationText = msgNotification.getText();
			System.out.println(notificationText);

		} catch (Exception e) {
			// driver.manage().timeouts().pageLoadTimeout(300,
			// TimeUnit.SECONDS);
			btnUpdateDetail.click();
			// get the message from that alert box
			Alert technicianAlert = driver.switchTo().alert();
			Thread.sleep(2000);

			String technicianAlertMessage = technicianAlert.getText();
			System.out.println("Alert Text:" + technicianAlertMessage);
			Thread.sleep(2000);
			technicianAlert.accept();
			// driver.switchTo().defaultContent();
			// driver.manage().timeouts().pageLoadTimeout(300,
			// TimeUnit.SECONDS);
			// button_UpdateDetail.click();
			// get the message from that alert box
			Alert technicianAlert1 = driver.switchTo().alert();
			Thread.sleep(2000);

			String technicianAlertMessage1 = technicianAlert1.getText();
			System.out.println("Alert Text:" + technicianAlertMessage1);
			Thread.sleep(2000);
			technicianAlert1.dismiss();
			// driver.switchTo().defaultContent();
			driver.switchTo().defaultContent();
			notificationText = msgNotification.getText();
			System.out.println(notificationText);

		}

		Assert.assertEquals(notificationText, "Incident Updated SuccessFully",
				"Notification is not Match");

	}

	public void punchTheATA() throws Exception {

		// Format Date
		String datePattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);

		// Format Time
		String timePattern = "HH:mm";
		DateFormat timeFormat = new SimpleDateFormat(timePattern);

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
		calATADetailsPage.click();

		// select Date in Calendar
		for (WebElement day : dtpCalendarInATADetailsPage) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		// Get Date in ATA Date Text box
		String currentDate = txtATADateInATADetailsPage.getAttribute("value");
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

		// select Min in Drop down
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

		// Select Machine Available
		Select machineAvailable = new Select(
				ddlMachineAvailableInATADetailsPage);
		machineAvailable.selectByVisibleText("Yes");

		// Click on Update Details
		btnUpdateDetailsInATADetailsPage.click();

		String notificationText = msgNotification.getText();
		System.out.println(notificationText);

		Assert.assertEquals(notificationText, "Incident Updated Successfully",
				"Notification is not Match");

	}

	public void punchETAAndATAAfterCreatingTicket()
			throws InterruptedException, Exception {
		driver.findElement(By.linkText("Edit Incident")).click();
		// Thread.sleep(2000);

		// click on ETA and Technician tab
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

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
		calETADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInETADetailsPage) {

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
		String currentDate = txtETADateInETADetailsPage.getAttribute("value");
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

		for (WebElement hrsofSystem : ddlHrsOfETATimeInETADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfETATimeInETADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		// Click on update button
		btnUpdateDetail.click();
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
		tabATA.click();

		// Click on Edit Button In ATA Tab
		btnEditInATATab.click();

		// Get System Date
		Calendar mydate1 = new GregorianCalendar();
		int dayOfMonth1 = mydate1.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth1);
		String currentDay1 = Integer.toString(dayOfMonth1);

		// Click on Calendar
		calATADetailsPage.click();

		// select Date in Calendar
		for (WebElement day : dtpCalendarInATADetailsPage) {

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
		String currentDate1 = txtATADateInATADetailsPage.getAttribute("value");
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
		for (WebElement hrsofSystem : ddlHrsOfATATimeInATADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs1)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down
		for (WebElement minOfSystem : ddlMinOfATATimeInATADetailsPage) {

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
				ddlMachineAvailableInATADetailsPage);
		machineAvailable.selectByVisibleText("Yes");

		// Click on Update Details
		btnUpdateDetailsInATADetailsPage.click();

		String notificationText1 = msgNotification.getText();
		System.out.println(notificationText1);

		Assert.assertEquals(notificationText1, "Incident Updated Successfully",
				"Notification is not Match");

	}

	public void punchETAAfterCreatingTicket() throws InterruptedException,
			Exception {

		driver.findElement(By.linkText("Edit Incident")).click();
		// Thread.sleep(2000);

		// click on ETA and Technician tab
		tabETATechnician.click();

		// click on Call Assign To Technician Button.
		btnCallAssignToTechnician.click();

		for (String Window : driver.getWindowHandles()) {

			System.out.println(Window);

		}

		String selectedName = txtTechnician.getAttribute("value");
		System.out.println("selected technician name is:-" + selectedName);

		// clear all the field
		txtTechnician.clear();

		// click the first list of click on first list symbol of
		// Technician Field
		btnTechnicianList.click();

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

		int size = lstTechnicianName.size();

		for (int j = 0; j < size; j++) {

			// Thread.sleep(2000);
			String technicianVlaue = lstTechnicianName.get(j).getText();
			System.out.println(technicianVlaue);

			if (technicianVlaue.contains("Pranjali Deshpande"))

			{
				// Thread.sleep(2000);
				lstTechnicianName.get(j).click();
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
		calETADetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInETADetailsPage) {

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
		String currentDate = txtETADateInETADetailsPage.getAttribute("value");
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

		for (WebElement hrsofSystem : ddlHrsOfETATimeInETADetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfETATimeInETADetailsPage) {

			String minInDropdown = minOfSystem.getText();

			if (minInDropdown.equalsIgnoreCase(min)) {
				minOfSystem.click();
				String getDateValue = minOfSystem.getText();
				System.out.println("Select the min:-" + getDateValue);

				break;
			}

		}

		// Click on update button
		btnUpdateDetail.click();
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
		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (status.equalsIgnoreCase("open") && !ETA.equals("")
						&& !ATA.equals("")) {
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstIDInTable.get(i));
					lstIDInTable.get(i).click();

					// Click on Spare Tab
					tabSpareInTicketForm.click();

					// Click on Edit Button In Pause Tab
					btnEditInSpareTab.click();

					for (String Window : driver.getWindowHandles()) {
						driver.switchTo().window(Window);
					}

					// Get Heading
					// Thread.sleep(1000);
					// select the Spares Consumed By Inventory logistic
					Select sparesConsumed;
					sparesConsumed = new Select(ddlSparesConsumedInSpareTab);
					sparesConsumed.selectByVisibleText("No");
					btnUpdateDetail.click();

					for (String Window : driver.getWindowHandles()) {
						driver.switchTo().window(Window);
					}
					tabTechnicianClose.click();
					driver.manage().timeouts()
							.pageLoadTimeout(10, TimeUnit.SECONDS);
					btnEditOfTechncianClose.click();

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
					calTechnicianClosePage.click();

					// select Date in Calendar

					for (WebElement day : dtpCalendarInTechnicianClosePage) {

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

					for (WebElement hrsofSystem : ddlHrsOfTechnicianCloseTime) {

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

					String resolution = "abc";
					txtResolutionInTechnicianClose.sendKeys(resolution);

					String resolutionDescription = "xyz";
					txtResolutionDescriptionInTechnicianClose
							.sendKeys(resolutionDescription);

					String FSRNo = "123";
					txtFSRNoInTechnicianClose.sendKeys(FSRNo);
					// Thread.sleep(500);

					driver.manage().timeouts()
							.pageLoadTimeout(30, TimeUnit.SECONDS);
					btnSubmitTechCloseDetails.click();

					// Get Notification
					// Thread.sleep(1000);
					String notificationText1 = msgNotification.getText();
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
		tabPauseInTicketForm.click();

		// Click on Edit Button In Pause Tab
		btnEditInPauseTab.click();

		for (String Window : driver.getWindowHandles()) {
			driver.switchTo().window(Window);
		}

		// Click on List Of Pause Reasons Button
		btnListOfPauseReasonsInPausepage.click();
		for (String listOfPauseReasons : driver.getWindowHandles()) {
			driver.switchTo().window(listOfPauseReasons);
		}

		// Get Pause Reason
		String pauseReason = lstPauseReasonsInListOfPauseReasonsPage.get(1)
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
		calPauseDetailsPage.click();

		// select Date in Calendar

		for (WebElement day : dtpCalendarInPauseDetailsPage) {

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
		String resumeDateText = txtAutoResumeDateInPauseDetailsPage
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

		for (WebElement hrsofSystem : ddlHrsOfAutoResumeTimeInPauseDetailsPage) {

			String hrsInDropdown = hrsofSystem.getText();

			if (hrsInDropdown.equalsIgnoreCase(hrs)) {
				hrsofSystem.click();
				String getDateValue = hrsofSystem.getText();
				System.out.println("Select the hrs:-" + getDateValue);

				break;
			}

		}

		// select Min in Drop down

		for (WebElement minOfSystem : ddlMinOfAutoResumeTimeInPauseDetailsPage) {

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
		btnUpdateDetailsInPauseDetailsPage.click();

		// Click on Pause Tab
		Thread.sleep(2000);

	}

	public void selectOpenTicket() throws Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Open");

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				scrollDown(lstETADateInTable.get(i));
				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				scrollDown(lstATADateInTable.get(i));
				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (status.equalsIgnoreCase("open") && !ETA.equals("")
						&& !ATA.equals("")) {
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					scrollDown(lstIDInTable.get(i));
					highLight(lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					Thread.sleep(1000);
					break loop;
				}
			}
			if (sizePagination - 1 == p)
				Assert.assertTrue(false,
						" Open Ticket is not Available.");

		}
	}

	public void selectOpenTicketForSpare() throws Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Open");

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);

			int j = 0;
			for (int i = 0; i < size; i++) {
				
				String id = lstIDInTable.get(i).getText();
				System.out.println(id);
				Integer count = id.length();
				if (count != 5) {
					j = j + 1;
					
					String notification = driver
							.findElements(
									By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>i"))
							.get(j - 1).getText();
					
					System.out.println("Blinking Notification: " + notification);
					
				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				scrollDown(lstETADateInTable.get(i));
				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				scrollDown(lstATADateInTable.get(i));
				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (status.equalsIgnoreCase("open") && !ETA.equals("")
						&& !ATA.equals("") && notification.equalsIgnoreCase("Spare Requested")) {
					String id1 = lstIDInTable.get(i).getText();
					System.out.println(id1);
					scrollDown(lstIDInTable.get(i));
					highLight(lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					break loop;
				}
			}
			}
			if (sizePagination - 1 == p)
				Assert.assertTrue(false,
						" Open Ticket is not Available.");

		}
	}
	public void selectOpenTicketForCountPauseTime() throws Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Open");

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				scrollDown(lstPausedTimeInTable.get(i));
				String pausedTime = lstPausedTimeInTable.get(i).getText();
				System.out.println(pausedTime);

				

				if (status.equalsIgnoreCase("open") && !pausedTime.equals("")
						) {
					highLight(lstPausedTimeInTable.get(i));
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					scrollDown(lstIDInTable.get(i));
					highLight(lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					break loop;
				}
			}
			if (sizePagination - 1 == p)
				Assert.assertTrue(false,
						" Open Ticket is not Available.");

		}
	}
	public void selectPauseTicket() throws Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Paused");


			String id = lstIDInTable.get(0).getText();
			System.out.println(id);
			scrollDown(lstIDInTable.get(0));
			highLight(lstIDInTable.get(0));

			lstIDInTable.get(0).click();
			
	}

	public void selectTicketForPunchATA() throws Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Open");

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				scrollDown(lstETADateInTable.get(i));
				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				scrollDown(lstATADateInTable.get(i));
				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);
				
				String callType = lstCallTypeInTable.get(i).getText();
				System.out.println(callType);

				if (status.equalsIgnoreCase("open") && !ETA.equals("")
						&& ATA.equals("") && !callType.equals("PM")) {
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					scrollDown(lstIDInTable.get(i));
					highLight(lstIDInTable.get(i));

					lstIDInTable.get(i).click();
					break loop;
				}
			}
			if (sizePagination - 1 == p)
				Assert.assertTrue(false,
						" Ticket is not Available for Closing Ticket");

		}
	}
	
	public void selectOpenTicketAndPunchETAATA() throws Exception, Exception {

		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status11;
		status11 = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status11.selectByValue("Open");

		int sizePagination = ddlPagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			ddlPagination.get(p).click();

			int size = lstATADateInTable.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				String status = lstStatusInTable.get(i).getText();
				System.out.println(status);

				scrollDown(lstETADateInTable.get(i));
				String ETA = lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				scrollDown(lstATADateInTable.get(i));
				String ATA = lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				if (status.equalsIgnoreCase("open") && ETA.equals("")
						&& ATA.equals("")) {
					String id = lstIDInTable.get(i).getText();
					System.out.println(id);
					scrollDown(lstIDInTable.get(i));
					highLight(lstIDInTable.get(i));
					lstIDInTable.get(i).click();
					punchTheETA();
					punchATA();
					break loop;
				}
			}
			if (sizePagination - 1 == p)
				Assert.assertTrue(false,
						" Ticket is not Available for Closing Ticket");

		}
	}

	public void logoutFromTechnician() throws Exception {

		Thread.sleep(1000);
		highLight(tabTechnicianForLogout);
		tabTechnicianForLogout.click();
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(tabTechnicianForLogout).build();
		seriesOfActions.perform();
		//tabTechnicianForLogout.click();
		Thread.sleep(1000);
		tabLogOut.click();
		Thread.sleep(1000);

	}

	public void logoutFromSuper() throws Exception {

		Thread.sleep(1000);
		tabSuperForLogout.click();
		Thread.sleep(1000);
		tabLogOut.click();
		Thread.sleep(1000);

	}

	public void loginIntoSuper() throws Exception {
		// login as super ,call it from super Role customer detail page
		super_LoginPage = new Super_LoginPage();
		super_HomePage = super_LoginPage.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));

	}

	public void loginIntoTechnician() throws Exception {
		// login as super ,call it from super Role customer detail page
		sd_LoginPage = new SD_LoginPage();
		technician_HomePage = sd_LoginPage.technicianLogin(
				properties.getProperty("loginIdForTechnician"),
				properties.getProperty("password"));

	}

}
