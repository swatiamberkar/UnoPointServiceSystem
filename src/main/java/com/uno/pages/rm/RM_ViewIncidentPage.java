package com.uno.pages.rm;

import java.util.ArrayList;
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
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ManageStaffPage;

public class RM_ViewIncidentPage extends BaseCode {

	Super_LoginPage super_LoginPage;
	Super_HomePage super_HomePage;
	Super_EmployeeMasterPage super_EmpolyeeMasterPage;
	Super_EmployeeDetailPage super_EmployeeDetailPage;
	Super_ManageStaffPage super_ManageStaffPage;
	RM_ViewIncidentPage rm_ViewIncidentPage;

	
	public String nameOfRM= null;
	
	
	// Select SD tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement link_NewRM1;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	// Select Incident ID Text Box
	@FindBy(xpath = ".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]")
	WebElement txtIncidenID;

	// select Search Ticket
	@FindBy(css = "#open")
	WebElement tabSearchTicketOpen;

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
	@FindBy(css = "div[class='filter-container']>div>table>tbody>tr:nth-of-type(2)>td>select>option:nth-of-type(1)")
	WebElement ddlStateFilter;

	// select status filter text box ,with default selected value
	@FindBy(css = "select[name='m_strStatusFilter']>option:nth-of-type(1)")
	WebElement ddlStatusFilter;

	// select ticket type filter text box ,with default selected value
	@FindBy(css = "select[name='m_strIncidentType']>option:nth-of-type(1)")
	WebElement ddlTicketTypeFilter;

	// select CTS filter text box ,with default selected value
	@FindBy(css = "select[name='m_strMTS']>option:nth-of-type(1)")
	WebElement ddlCTS;

	// select customer filter text box ,with default selected value
	@FindBy(css = "select[name='m_strCustomerName']>option:nth-of-type(1)")
	WebElement ddlCustomerNameFilter;

	// select engineer filter text box ,with default selected value
	@FindBy(css = "select[name='m_strEngineer']>option:nth-of-type(1)")
	WebElement ddlEnginnerFilter;

	// select engineer filter text box
	@FindBy(name = "m_strEngineer")
	WebElement ddlEngineer;

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

	// select list of Serial Number from table
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[10]")
	List<WebElement> lstSerialNumberInTable;

	// Requester Tab

	// Select Requester Tab for Open
	@FindBy(css = "div[id='Requestor']>div>div[style='border: 1px solid #b7b7b7']>div[class='rectagleBox marBot10']>span>a[id='open']")
	WebElement tabRequestorForOpenInRequesterTab;

	// label business unit
	@FindBy(xpath = ".//*[@id='Requestor']/div/div[1]/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr[21]/td")
	WebElement lblBusinessUnit;

	// label Product Category
	@FindBy(xpath = ".//*[@id='Requestor']/div/div[1]/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr[5]/td")
	WebElement lblProductCategory;

	// ETA and Technician Tab //

	// ETA and Technician Tab
	@FindBy(css = "div[class='tab_widget']>ul>li:nth-of-type(3)>a")
	WebElement tabETAAndTechnician;

	// Technician in ETA and Technician Tab
	@FindBy(css = "div[id='ETA-technician']>div:nth-of-type(1)>table>tbody>tr>td:nth-of-type(5)")
	WebElement lblTechnicianInETAAndTechnicianTab;

	// Initializing Page Object
	public RM_ViewIncidentPage() {
		PageFactory.initElements(driver, this);
	}

	// Display Title Of View Ticket Page
	public void displayTitleOfViewTicketPage() {
		SoftAssert softAssert = new SoftAssert();
		String viewTicketPageTitle = driver.getTitle();
		System.out.println(viewTicketPageTitle);
		softAssert.assertEquals(viewTicketPageTitle, "Welcome To Uno Point");
		softAssert.assertAll();

	}

	// Descending order of Incident ID's
	public void displayDescendingOrderOfIncidentID() {
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

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", lstIDInTable.get(i));
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
	public void displayColumnHeader() throws Exception {
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
			Thread.sleep(500);
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
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", lstIDInTable.get(i));
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
			softAssert
					.assertTrue(idIsPresent, "Hyperlink of ID is not present");

		}
		softAssert.assertAll();
	}

	// Hyper link of Customer should have present
	public void checkHyperlinkOfCustomer() {
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
			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView(true);",
							listOfCustomer.get(i));
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
	public void checkHyperlinkOfAssetId() {
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

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", listOfAssetId.get(i));
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
					softAssert.assertNotNull(engineer, "Technicion not Assign");
					System.out.println("Engineer Assign\n");

					break;

				case "ATA":
					List<WebElement> listOfETA = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
					String eta = listOfETA.get(i).getText();
					System.out.println("ETA: " + eta);
					softAssert.assertNotNull(eta, "ETA is not Present");
					System.out.println("Punch the ETA\n");

					break;

				case "Feedback":
					List<WebElement> listOfATA = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
					String ata = listOfATA.get(i).getText();
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

			}

			else {
				System.out.println("There is not Blinking Notification\n");
			}
		}
		softAssert.assertAll();
	}

	// Match Customer in Incident History Page
	public void checkCustomer() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		boolean customerIsMatch = true;
		List<WebElement> listOfRowInParentWindow = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRowInParentWindow = listOfRowInParentWindow.size();

		for (int i = 0; i < countOfRowInParentWindow; ) {
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

			softAssert.assertTrue(customerIsMatch,
					"Customer name are not same.");

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

		for (int i = 0; i < countOfRowInParentWindow; ) {
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

				softAssert
						.assertTrue(assetIdIsMatch, "Asset ID  are not same.");

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

				softAssert.assertEquals(messageOfColdSLAFlag,
						"Resolution(Cold)");

				break;

			case "http://demo.intelli.uno/erprmwise/images/warm.gif":
				String messageOfWarmSLAFlag = driver
						.findElements(
								By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>span:nth-of-type(2)>img"))
						.get(i).getAttribute("title");
				System.out.println("Hidden message: " + messageOfWarmSLAFlag);

				softAssert.assertEquals(messageOfWarmSLAFlag,
						"Resolution(Warm)");

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
				break;
			}

		}
		softAssert.assertAll();
	}

	// Pagination //
	// Count Of Pagination
	public void countOfPagination() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		int size = ddlPagination.size();
		System.out.println("Pagination Pages: " + size);
		/*
		 * int count = 0; for (int i = 0; i < size; i++) {
		 * System.out.println("Page No.: "+ i);
		 * dropdown_Pagination.get(i).click(); Thread.sleep(1000); int rowSize =
		 * list_RowInTable.size(); System.out.println("Row Count: "+rowSize);
		 * count = count + rowSize; System.out.println("Total Count: "+count);
		 * 
		 * }
		 */

		int count = 20 * (size - 1);
		ddlPagination.get(size - 1).click();
		Thread.sleep(1000);
		int lastPageCount = lstRowInTable.size();
		System.out.println("last Page Count: " + lastPageCount);
		int totalCountTicket = count + lastPageCount;
		System.out.println("Total Count: " + totalCountTicket);

		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		softAssert.assertEquals(totalCountTicket, actualTotalCount,
				"Count is not match");
		softAssert.assertAll();
	}

	// Display As Per Arrows Of Pagination
	public void displayAsPerArrowsOfPagination() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Click on leftmost arrow
		int size = ddlPagination.size();
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
		tabSearchTicketOpen.click();

		// Get value of Search Id
		String searchId = txtSearchId.getText();
		// Print value of Search Id
		System.out.println("search ID :" + searchId);

		// Verify the value of search ID is null
		softAssert.assertEquals(searchId, "");

		// Get value of Search Asset ID
		String searchassetId = txtSearchAssetID.getText();
		// Print value of Search Asset ID
		System.out.println("search asset ID :" + searchassetId);

		// verify the value of search asset ID is null
		softAssert.assertEquals(searchassetId, "");

		// Get value of Search Ticket ID
		String searchTicketId = txtSearchTicketID.getText();
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
		tabSearchTicketClose.click();

		// click on search ticket tab
		tabSearchTicketOpen.click();
		Thread.sleep(500);
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// enter the alphabetical value in ID field, after that it display the
		// alert box
		txtSearchId.sendKeys("ABC");

		// click on Go button
		btnIDGo.click();

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

		tabSearchTicketClose.click();

		// click on search ticket tab
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// enter the incident ID which is not present in view ticket dashboard
		txtSearchId.sendKeys("1000000");

		// click on Go button
		btnIDGo.click();

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
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// enter the incident number in asset id tab which is not present in
		// view ticket dash board
		txtSearchAssetID.sendKeys("TestAp");

		// click on GO button
		btnAssetIDGo.click();

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
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// enter the incident number in ticket id tab which is not present in
		// view ticket dash board
		txtSearchTicketID.sendKeys("123a");

		// click on GO button
		btnTicketIDGo.click();

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
	
		// tab_SearchTicketClose.click();

		// click on search ticket tab
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// enter the incident number in ticket id tab which is not present in
		// view ticket dash board
		txtSearchTicketID.sendKeys("540");

		// click on GO button
		btnTicketIDGo.click();

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
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// click on Go button of the ID text box
		btnIDGo.click();

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
		tabSearchTicketClose.click();

		// click on search ticket tab
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// click on GO button of asset ID text box
		btnAssetIDGo.click();

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
	public void checkSearchTicketIdTextBoxBlankData() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		tabSearchTicketClose.click();

		// click on search ticket tab
		tabSearchTicketOpen.click();
		txtSearchId.clear();
		txtSearchAssetID.clear();
		txtSearchTicketID.clear();

		// click on GO button of ticket ID text box
		btnTicketIDGo.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String alertMessage = alert.getText();
		System.out.println("Alert Text:" + alertMessage);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message is Please Enter Customer Ticket ID or not
		softAssert
				.assertEquals(alertMessage, "Please Enter Customer Ticket ID");
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
		String ctsFilter = ddlCTS.getText();
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

	// In state filter, All states which are assign to SD login should display
	// in list
	public void selectStateFilter() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on filter tab
		// tab_Filter.click();

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
		softAssert.assertAll();

	}

	// If User select particular state option then in view ticket page,
	// all tickets should display where customer address is belongs to selected
	// state
	public void selectStatusFilter() throws Exception {
		
		// Thread.sleep(2000);
		// click on filter tab
		tabFilter.click();

		// select the particular status
		Select status;
		status = new Select(driver.findElement(By.name("m_strStatusFilter")));
		status.selectByVisibleText("Open");
		
		int size = lstStatusInTable.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {

			List<WebElement> columnElement = driver
					.findElements(By
							.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[5]"));

			String statusValue = columnElement.get(i).getText();
			System.out.println(statusValue);

			Assert.assertEquals(statusValue, "Open",
					"ticket status is not equal");
			System.out.println("ticket status is equal");
			
		}

	}

	// If user select Open status in CTS filter, then in View incident ticket
	// should display
	// with status 'Open', 'Paused', 'Reopened', 'technician closed',
	// 'Cancelled'
	public void selectOpenCTSFilterTextBox() throws Exception {
		SoftAssert softAssert = new SoftAssert();// Thread.sleep(2000);
													// click on
													// filter tab
		tabFilter.click();

		// select the CTS filter
		Select ctsFilter;
		ctsFilter = new Select(driver.findElement(By.name("m_strMTS")));
		ctsFilter.selectByVisibleText("Open");
		// Thread.sleep(3000);

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
							.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[5]"));
			String element = columnElement.get(i).getText();
			System.out.println(element);

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

			softAssert.assertTrue(statusIsPresent, "ticket status is wrong");

		}
		softAssert.assertAll();

	}

	// If user select Close status in CTS filter,
	// then in View incident ticket should display with status 'closed'
	public void selectCloseCTSFilterTextBox() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(2000);
		// click on filter tab
		tabFilter.click();

		// select the CTS filter
		Select ctsFilter;
		ctsFilter = new Select(driver.findElement(By.name("m_strMTS")));
		ctsFilter.selectByVisibleText("Closed");
		// Thread.sleep(3000);

		// for table
		List<WebElement> rowElement = driver
				.findElements(By
						.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ rowElement.size());

		boolean statusIsClose;

		for (int i = 0; i < rowElement.size(); i++) {

			List<WebElement> columnElement = driver
					.findElements(By
							.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[4]"));
			String element = columnElement.get(i).getText();
			System.out.println(element);

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

	public void checkFilterOfAssign() throws Exception {

		link_NewRM1.click();
		Thread.sleep(1000);
		link_LogOut.click();

		// login as super ,call it from super Role customer detail page
		super_LoginPage = new Super_LoginPage();
		super_HomePage = super_LoginPage.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));

		// Thread.sleep(3000);
		super_EmpolyeeMasterPage = super_HomePage.clickEmpolyeeMasterlink();

		super_EmployeeDetailPage = super_EmpolyeeMasterPage
				.clickOnEmpolyeeDetailLink();

		super_EmployeeDetailPage.tabFilter.click();

		Select role = new Select(super_EmployeeDetailPage.ddlSearchByRole);
		role.selectByVisibleText("ReportingManager");

		int sizeofName = super_EmployeeDetailPage.lstNameInTable.size();
		System.out.println("Row in Table: " + sizeofName);
		for (int j = 0; j < sizeofName; ) {
			String rm0 = super_EmployeeDetailPage.lstNameInTable.get(j)
					.getText();
			System.out.println("Name: " + rm0);

			if (rm0.equalsIgnoreCase("newrm1")) {

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								super_EmployeeDetailPage.lstNameInTable.get(j));

				// Cursor transfer to Check box
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						super_EmployeeDetailPage.lstNameInTable.get(j));
				Thread.sleep(1000);
				driver.findElement(By.linkText(rm0)).click();
				// super_EmployeeDetailPage.lstNameInTable.get(j).click();

				super_ManageStaffPage = new Super_ManageStaffPage();
				// Get drop down of Filter By Incident ID
				Select businessUnit = new Select(
						super_ManageStaffPage.ddlBusinessUnit);

				// Get list of Business Unit
				List<WebElement> listOfBusinessUnit = businessUnit.getOptions();
				// Get size of Business Unit
				int sizeOfBusinessUnit = listOfBusinessUnit.size();
				// Print size of Business Unit
				System.out.println("\nsizeOfBusinessUnit: "
						+ sizeOfBusinessUnit);

				// myList contains all the web elements
				// if you want to get all elements text into array list
				List<String> businessUnit0 = new ArrayList<>();

				for (int i = 0; i < sizeOfBusinessUnit; i++) {

					// loading text of each element in to array
					// all_elements_text
					businessUnit0.add(listOfBusinessUnit.get(i).getText());
					// Cursor transfer to Check box
		
					// to print directly
					//System.out.println(listOfBusinessUnit.get(i).getText());

				}

				// to print directly
				System.out.println("all_elements_text: " + businessUnit0);

				// Get drop down of Filter By Incident ID
				Select productCategory = new Select(
						super_ManageStaffPage.ddlProductCategory);

				// Get list of ProductCategory
				List<WebElement> listOfProductCategory = productCategory
						.getOptions();
				// Get size of ProductCategory
				int sizeOfProductCategory = listOfProductCategory.size();
				// Print size ofProductCategory
				System.out.println("\nsizeOfProductCategory: "
						+ sizeOfProductCategory);

				// myList contains all the web elements
				// if you want to get all elements text into array list
				List<String> productCategory0 = new ArrayList<>();

				for (int i = 0; i < sizeOfProductCategory; i++) {

					// loading text of each element in to array
					// all_elements_text
					

					productCategory0
							.add(listOfProductCategory.get(i).getText());

					// to print directly
					System.out.println(listOfProductCategory.get(i).getText());

				}

				// to print directly
				System.out.println("arrayOfProductCategory: "
						+ productCategory0);

			
			}
			driver.navigate().back();
			break;
		}
		Thread.sleep(2000);
		int sizeofRM = super_EmployeeDetailPage.lstReportingManager.size();
		System.out.println("Row in Table: " + sizeofRM);
		for (int j = 0; j < sizeofRM; j++) {
			String rm = super_EmployeeDetailPage.lstReportingManager.get(j)
					.getText();
			System.out.println("rm: " + rm);

			 int rmNumber=0;
			if (rm.equalsIgnoreCase("NewRM1 .")) {
				rmNumber = rmNumber + 1;

				// Cursor transfer to Check box
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						super_EmployeeDetailPage.lstReportingManager.get(j));

				// Cursor transfer to Check box
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						super_EmployeeDetailPage.lstNameInTable.get(j));
				Thread.sleep(2000);
				String nameOfRm =super_EmployeeDetailPage.lstNameInTable.get(j)
						.getText();
				nameOfRM = super_EmployeeDetailPage.lstNameInTable.get(j)
						.getText();
				System.out.println("nameOfRM"+rmNumber+": "+nameOfRM);
				
			
			
				
				Thread.sleep(2000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								super_EmployeeDetailPage.lstNameInTable.get(j));

				Thread.sleep(1000);
				driver.findElement(By.linkText(nameOfRm)).click();
				// super_EmployeeDetailPage.lstNameInTable.get(j).click();

				super_ManageStaffPage = new Super_ManageStaffPage();
				// Get drop down of Filter By Incident ID
				Select businessUnit = new Select(
						super_ManageStaffPage.ddlBusinessUnit);

				// Get list of Business Unit
				List<WebElement> listOfBusinessUnit = businessUnit.getOptions();
				// Get size of Business Unit
				int sizeOfBusinessUnit = listOfBusinessUnit.size();
				// Print size of Business Unit
				System.out.println("\nsizeOfBusinessUnit: "
						+ sizeOfBusinessUnit);

				// myList contains all the web elements
				// if you want to get all elements text into array list
				List<String> arrayOfBusinessUnit = new ArrayList<>();

				for (int i = 0; i < sizeOfBusinessUnit; i++) {

					// loading text of each element in to array
					// all_elements_text
					arrayOfBusinessUnit
							.add(listOfBusinessUnit.get(i).getText());

					// to print directly
					System.out.println(listOfBusinessUnit.get(i).getText());

				}

				// to print directly
				System.out.println("all_elements_text: " + arrayOfBusinessUnit);

				// Get drop down of Filter By Incident ID
				Select productCategory = new Select(
						super_ManageStaffPage.ddlProductCategory);

				// Get list of ProductCategory
				List<WebElement> listOfProductCategory = productCategory
						.getOptions();
				// Get size of ProductCategory
				int sizeOfProductCategory = listOfProductCategory.size();
				// Print size ofProductCategory
				System.out.println("\nsizeOfProductCategory: "
						+ sizeOfProductCategory);

				// myList contains all the web elements
				// if you want to get all elements text into array list
				List<String> arrayOfProductCategory = new ArrayList<>();

				for (int i = 0; i < sizeOfProductCategory; i++) {

					// loading text of each element in to array
					// all_elements_text
					arrayOfProductCategory.add(listOfProductCategory.get(i)
							.getText());

					// to print directly
					//System.out.println(listOfProductCategory.get(i).getText());

				}

				// to print directly
				System.out.println("arrayOfProductCategory: "
						+ arrayOfProductCategory);

				driver.navigate().back();
				//break;
			}
			if( j==sizeofRM-1)
			{
			System.out.println("nameOfRM[rmNumber]: "+nameOfRM);
			}
			
		}
		

		/*
		 * Select assign = new Select(ddlAssign);
		 * assign.selectByVisibleText("Assigned");
		 * 
		 * int size = lstIDInTable.size(); System.out.println("Row in Table: " +
		 * size); for (int i = 0; i < size; i++) { String ticketId =
		 * lstIDInTable.get(i).getText(); System.out.println("TicketId: " +
		 * ticketId); // Cursor transfer to Check box ((JavascriptExecutor)
		 * driver).executeScript( "arguments[0].scrollIntoView(true);",
		 * lstIDInTable.get(i));
		 * 
		 * ((JavascriptExecutor) driver) .executeScript(
		 * "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');"
		 * , lstIDInTable.get(i));
		 * 
		 * lstIDInTable.get(i).click();
		 * tabRequestorForOpenInRequesterTab.click(); Thread.sleep(1000); String
		 * businessUnit = lblBusinessUnit.getText();
		 * System.out.println("Business Unit: " + businessUnit); String
		 * businessUnitValue = businessUnit.split("Business Unit : ")[1];
		 * System.out.println("businessUnitValue: " + businessUnitValue);
		 * 
		 * String productCategory = lblProductCategory.getText();
		 * System.out.println("ProductCategory: " + productCategory); String
		 * productCategoryValue = productCategory
		 * .split("Product Category : ")[1];
		 * System.out.println("productCategoryValue: " + productCategoryValue);
		 * 
		 * tabETAAndTechnician.click();
		 * 
		 * String technician = lblTechnicianInETAAndTechnicianTab.getText();
		 * System.out.println("Technician: " + technician); String
		 * technicianValue = technician.split("Technician : ")[1];
		 * System.out.println("TechnicianValue: " + technicianValue);
		 * 
		 * }
		 */
		return;
	}

}
