package com.uno.pages.rm;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;



public class RM_DailyActivityPage extends BaseCode{


		public static int incidentID = 1;
		public static int customerName = 1;
		public static int activityHeader = 1;

		RM_DailyActivityPage rm_DailyActivityPage;

		// Select Filter Tab
		@FindBy(css = "#open")
		WebElement tab_Filter;

		// Filter By Incident ID Drop down
		@FindBy(css = "select[name='m_strOpportunityIDFilter']")
		WebElement dropdown_FilterByIncidentID;

		// Filter By Customer Name Drop down
		@FindBy(css = "select[name='m_strCustomerNameFilter']")
		WebElement dropdown_FilterByCustomerName;

		// Filter By Activity Header Drop down
		@FindBy(css = "select[name='m_strActivityHeaderFilter']")
		WebElement dropdown_FilterByActivityHeader;

		// From Date Text box
		@FindBy(css = "input[name='m_strFromDate']")
		WebElement textbox_FromDate;

		// To Date Text box
		@FindBy(css = "input[name='m_strToDate']")
		WebElement textbox_ToDate;

		// From Date Calendar
		@FindBy(css = "a[id='fd-but-dp-12']")
		WebElement calendar_FromDate;

		// From Date day of Calendar
		@FindBy(css = "div[id='fd-dp-12']>.datePickerTable>tbody>tr>td")
		List<WebElement> dayOfCalendar_FromDate;

		// From Date month of Calendar
		@FindBy(css = "#dp-12-prev-month-but")
		WebElement previousMonthOfCalendar_FromDate;

		// From Date -Selected month of Calendar
		@FindBy(css = "div[id='fd-dp-12']>table>thead>tr:nth-of-type(1)>th>span[class='month-display drag-enabled']")
		WebElement displayMonthOfCalendar_FromDate;

		// To Date Calendar
		@FindBy(css = "a[id='fd-but-dp-11']")
		WebElement calendar_ToDate;

		// To Date day of Calendar
		@FindBy(css = "div[id='fd-dp-11']>.datePickerTable>tbody>tr>td")
		List<WebElement> dayOfCalendar_ToDate;

		// From Date month of Calendar
		@FindBy(css = "#dp-11-prev-month-but")
		WebElement previousMonthOfCalendar_ToDate;

		// From Date -Selected month of Calendar
		@FindBy(css = "div[id='fd-dp-11']>table>thead>tr:nth-of-type(1)>th>span[class='month-display drag-enabled']")
		WebElement displayMonthOfCalendar_ToDate;

		// Go Button
		@FindBy(css = "a[onclick='callFilterByDateRange();']")
		WebElement button_Go;

		// Download Excel Button
		@FindBy(css = "a[onclick='callDownloadExcel()']")
		WebElement button_DownloadExcel;

		// Add Activity Button
		@FindBy(xpath = ".//*[@id='headingText']/ul/li[1]/a")
		WebElement button_AddActivity;

		// Days Label
		@FindBy(xpath = ".//*[@id='headingText']/ul/li[3]/a")
		WebElement label_Days;

		// Hours Label
		@FindBy(xpath = ".//*[@id='headingText']/ul/li[2]/a")
		WebElement label_Hours;

		// list of Date
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(1)")
		List<WebElement> list_Date;

		// list of From Time
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
		List<WebElement> list_FromTime;

		// list of To Time
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(3)")
		List<WebElement> list_ToTime;

		// list of TAT
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(4)")
		List<WebElement> list_TAT;

		// list of Location
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(5)")
		List<WebElement> list_Location;

		// list of Incident ID
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(6)")
		List<WebElement> list_IncidentID;

		// list of Customer Name
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(7)")
		List<WebElement> list_CustomerName;

		// list of Activity Header
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(8)")
		List<WebElement> list_ActivityHeader;

		// list of Activity
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(9)")
		List<WebElement> list_Activity;

		// list of Activity Remark
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(10)")
		List<WebElement> list_ActivityRemark;

		// list of Created_BY
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(11)")
		List<WebElement> list_Created_BY;

		// list of Created By_Role
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
		List<WebElement> list_CreatedBy_Role;

		// list of Update
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(13)>a")
		List<WebElement> list_Update;

		// list of Delete
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(14)>a")
		List<WebElement> list_Delete;

		// Heading of Add Daily Activity Pop up
		@FindBy(css = "form[name='DailyActivityForm']>div[id='box']>.box>table>tbody>tr>th:nth-of-type(2)")
		WebElement heading_AddDailyActivityPopup;

		// Heading of Update Daily Activity Pop up
		@FindBy(css = "form[name='DailyActivityForm']>div[id='boxa']>.box>table>tbody>tr>th:nth-of-type(2)")
		WebElement heading_UpdateDailyActivityPopup;

		// Text box - date of Add Daily Activity Pop-up
		@FindBy(css = "#dp-1")
		WebElement textbox_date;

		// Button - Add of Add Daily Activity Pop-up
		@FindBy(css = "a[onclick='add();']")
		WebElement button_Add;

		// Button - Update of Update Daily Activity Pop-up
		@FindBy(css = "a[onclick='UpdateDailyActivity();']")
		WebElement button_Update;

		// Calendar - Date
		@FindBy(css = "a[id='fd-but-dp-1']")
		WebElement calendar_Date;

		// Day of Calendar- Date
		@FindBy(css = ".datePickerTable>tbody>tr>td")
		List<WebElement> dayOfCalendar_Date;

		// Drop down - From date
		@FindBy(css = "select[name='m_strFromTimeHour']>option ")
		List<WebElement> dropdown_FromDate;

		// Drop down - To date
		@FindBy(css = "select[name='m_strToTimeHour']>option ")
		List<WebElement> dropdown_ToDate;

		// Drop down - Location
		@FindBy(css = "select[name='m_strLocation']")
		WebElement dropdown_Location;

		// Drop down - Incident ID
		@FindBy(css = "select[name='m_strOppId']")
		WebElement dropdown_IncidentID;

		// Hidden Element - Customer Name
		@FindBy(css = ".as_highlight>a>span>em")
		WebElement hiddenElement_CustomerName;

		// Text box - Customer Name
		@FindBy(css = "#m_strCustName")
		WebElement textbox_CustomerName;

		// Drop down - Activity Header
		@FindBy(css = "select[name='m_strActivityHeader']")
		WebElement dropdown_ActivityHeader;

		// Text box - Activity
		@FindBy(css = "textarea[name='m_strActivity1']")
		WebElement textbox_Activity;

		// Text box - Remark
		@FindBy(css = "textarea[name='m_strActivityRemark']")
		WebElement textbox_Remark;

		// Text box - Update Remark
		@FindBy(css = "textarea[name='m_strUpdateActivityRemark']")
		WebElement textbox_UpdateRemark;

		// Notification of View Ticket Page
		@FindBy(css = "#dialogBoxSuccess")
		WebElement notification;

		// Initializing Page Object
		public RM_DailyActivityPage() {
			PageFactory.initElements(driver, this);
		}

		// 1. If User click on Add activity button in Daily Activity form, then Add
		// Daily Activity pop up should display
		public void varifyHeadingOfAddDailyActivityPopup() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Add Activity Button
			button_AddActivity.click();

			// Get Heading of Add Daily Activity Pop up
			String heading = heading_AddDailyActivityPopup.getText();

			// Display Heading of Add Daily Activity Pop up
			System.out.println("heading: " + heading);

			// Verify Heading of Add Daily Activity Pop up
			softAssert.assertEquals(heading, "Add Daily Activity",
					"Add Daily Activity popup is not Same");

			driver.findElement(By.linkText("Cancel")).click();
			softAssert.assertAll();

		}

		public void checkNotificationWithSelectionAndVarifyDataInAddDailyActivityFrom()
				throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Add Activity button
			button_AddActivity.click();

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			// Get DAY OF MONTH
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			// Print day of Month
			System.out.println("dayOfMonth: " + dayOfMonth);
			// Convert into String
			String currentDay = Integer.toString(dayOfMonth);

			// Click on Calendar
			calendar_Date.click();

			// Get all Dates in Calendar
			for (WebElement day : dayOfCalendar_Date) {

				// Get day in Calendar
				String dayInCalendar = day.getText();
				// Compare day In Calendar And current Day
				if (dayInCalendar.equalsIgnoreCase(currentDay)) {
					Thread.sleep(1000);
					// Select day
					day.click();
					// Get day
					String getDateValue = day.getText();
					// Print Selected day
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}
			Thread.sleep(1000);
			// Get System Time
			Calendar calendar = Calendar.getInstance();
			// Get Time in Hrs format
			String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
			// Print Time in Hrs format
			System.out.println("hrs:" + hrs);
			// Add hrs
			int fromHrs = Integer.parseInt(hrs) + 1;
			// Convert into String
			String fromHours = Integer.toString(fromHrs);

			// Get Time in min format
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			// Print Time in Min format
			System.out.println("min: " + min);
			// Add mins
			int fromMin = Integer.parseInt(hrs) + 2;
			// Convert into String
			String fromMinute = Integer.toString(fromMin);

			// select Hrs in Drop down
			for (WebElement hrsofSystem : dropdown_FromDate) {
				// Get hrs
				String hrsInDropdown = hrsofSystem.getText();
				// Compare hrs
				if (hrsInDropdown.equalsIgnoreCase(fromHours)) {
					Thread.sleep(1000);
					// Select hrs
					hrsofSystem.click();
					// Get hrs
					String getDateValue = hrsofSystem.getText();
					// Print hrs
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			Thread.sleep(1000);
			// select min in Drop down
			for (WebElement hrsofSystem : dropdown_ToDate) {
				// Get min
				String hrsInDropdown = hrsofSystem.getText();
				// Compare min
				if (hrsInDropdown.equalsIgnoreCase(fromMinute)) {
					Thread.sleep(1000);
					// Select min
					hrsofSystem.click();
					// Get min
					String getDateValue = hrsofSystem.getText();
					// Print min
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}
			try {
				// Select Location
				Select location1 = new Select(dropdown_Location);
				location1.selectByIndex(1);

				// Get list of Location
				List<WebElement> listOfLocation = location1.getOptions();
				// Get location
				String selectedLocation = listOfLocation.get(1).getText();
				// Print Location
				System.out.println("SelectedLocation: " + selectedLocation);

				/*// Select Incident ID
				Select incidentID1 = new Select(dropdown_IncidentID);
				incidentID1.selectByIndex(5);

				// Get list of Incident ID
				List<WebElement> listOfIncidentID = incidentID1.getOptions();
				// Get Incident ID
				String selectedIncidentID = listOfIncidentID.get(5).getText();
				// Print Incident ID
				System.out.println("SelectedLocation: " + selectedIncidentID);*/

				/*
				 * String customerName= textbox_CustomerName.get
				 * System.out.println("CustomerName: "+customerName);
				 * Thread.sleep(200); // hiddenElement_CustomerName.click();
				 */
				
				textbox_CustomerName.sendKeys("demo_Customer");
				// Select activity
				Select activity1 = new Select(dropdown_ActivityHeader);
				activity1.selectByIndex(1);

				// Get list of Activity Header
				List<WebElement> listOfActivityHeader = activity1.getOptions();
				// Get Activity Header
				String selectedActivityHeader = listOfActivityHeader.get(1)
						.getText();
				// Print Activity Header
				System.out.println("selectedActivityHeader: "
						+ selectedActivityHeader);

				// Enter Activity
				String activityText = "Send Report";
				textbox_Activity.sendKeys(activityText);

				// Enter Remark
				String remarkText = "Tested";
				textbox_Remark.sendKeys(remarkText);

				// Click on Add Button
				button_Add.click();
				Thread.sleep(2000);

				// Get Notification
				String notificationText = notification.getText();
				// Print Notification
				System.out.println(notificationText);

				// Verify Notification
				softAssert.assertEquals(notificationText,
						"Activity Added Successfully.", "Notification is not Match");

				// Initialize index
				int i = 0;
				// Get Location in Table
				String locationInTable = list_Location.get(i).getText();
				// Print Location in Table
				System.out.println("locationInTable: " + locationInTable);

				// Get Incident ID in Table
				String incidentIDInTable = list_IncidentID.get(i).getText();
				// Print Incident ID in Table
				System.out.println("incidentIDInTable: " + incidentIDInTable);

				// Get Customer Name in Table
				String customerNameInTable = list_CustomerName.get(i).getText();
				// Print Customer Name in Table
				System.out.println("customerNameInTable: " + customerNameInTable);

				// Get Activity Header in Table
				String activityHeaderInTable = list_ActivityHeader.get(i).getText();
				// Print Activity Header in Table
				System.out.println("activityHeaderInTable: "
						+ activityHeaderInTable);

				// Get Activity in Table
				String activityInTable = list_Activity.get(i).getText();
				// Print Activity in Table
				System.out.println("ActivityInTable: " + activityInTable);

				// Get Activity Remark in Table
				String remarkInTable = list_ActivityRemark.get(i).getText();
				// Print Activity Remark in Table
				System.out.println("RemarkInTable: " + remarkInTable);

				// Verify Location
				softAssert.assertEquals(selectedLocation, locationInTable,
						"Location is not Same.");

				/*// Verify Incident ID
				softAssert.assertEquals(selectedIncidentID, incidentIDInTable,
						"Incident ID is not Same.");*/

				// Verify Customer Name
				// Assert.assertEquals(customerName,
				// customerNameInTable,"Customer Name is not Same.");

				// Verify Activity Header
				softAssert.assertEquals(selectedActivityHeader, activityHeaderInTable,
						"Activity Header is not Same.");

				// Verify Activity
				softAssert.assertEquals(activityText, activityInTable,
						"Activity is not Same.");

				// Verify Remark
				softAssert.assertEquals(remarkText, remarkInTable,
						"Remark is not Same.");

			} catch (Exception e) {

				// Click on Add Activity Button
				button_AddActivity.click();

				// Get System Date
				Calendar mydate1 = new GregorianCalendar();
				// Get DAY OF MONTH
				int dayOfMonth1 = mydate1.get(Calendar.DAY_OF_MONTH);
				// Print day of Month
				System.out.println(dayOfMonth1);
				// Convert into String
				String currentDay1 = Integer.toString(dayOfMonth1);
				// Click on Calendar
				calendar_Date.click();

				// select Date in Calendar
				for (WebElement day : dayOfCalendar_Date) {
					// Get day in Calendar
					String dayInCalender = day.getText();
					// Compare day In Calendar And current Day
					if (dayInCalender.equalsIgnoreCase(currentDay1)) {
						Thread.sleep(1000);
						// Select day
						day.click();
						// Get day
						String getDateValue = day.getText();
						// Print Selected day
						System.out.println("Select the date:-" + getDateValue);

						break;
					}

				}

				Thread.sleep(1000);
				// Get System Time
				Calendar calendar1 = Calendar.getInstance();
				// Get Time in Hrs format
				String hrs1 = new SimpleDateFormat("HH")
						.format(calendar1.getTime());
				// Print Time in Hrs format
				System.out.println("hrs1: " + hrs1);
				// Add hrs
				int fromHrs1 = Integer.parseInt(hrs1) + 1;
				// Convert into String
				String fromHours1 = Integer.toString(fromHrs1);

				// Get Time in min format
				String min1 = new SimpleDateFormat("mm")
						.format(calendar1.getTime());
				// Print Time in Min format
				System.out.println("min1: " + min1);
				// Add mins
				int fromMin1 = Integer.parseInt(hrs1) + 2;
				// Convert into String
				String fromMinute1 = Integer.toString(fromMin1);

				// select Hrs in Drop down
				for (WebElement hrsofSystem : dropdown_FromDate) {
					// Get hrs
					String hrsInDropdown = hrsofSystem.getText();
					// Compare hrs
					if (hrsInDropdown.equalsIgnoreCase(fromHours1)) {
						Thread.sleep(1000);
						// Select hrs
						hrsofSystem.click();
						// Get hrs
						String getDateValue = hrsofSystem.getText();
						// Print hrs
						System.out.println("Select the hrs:-" + getDateValue);

						break;
					}

				}
				Thread.sleep(1000);
				// select min in Drop down
				for (WebElement hrsofSystem : dropdown_ToDate) {
					// Get min
					String hrsInDropdown = hrsofSystem.getText();
					// Compare min
					if (hrsInDropdown.equalsIgnoreCase(fromMinute1)) {
						Thread.sleep(1000);
						// Select min
						hrsofSystem.click();
						// Get min
						String getDateValue = hrsofSystem.getText();
						// Print min
						System.out.println("Select the hrs:-" + getDateValue);

						break;
					}

				}

				// Select Location
				Select location1 = new Select(dropdown_Location);
				location1.selectByIndex(1);

				// Get list of Location
				List<WebElement> listOfLocation = location1.getOptions();
				// Get location
				String selectedLocation = listOfLocation.get(1).getText();
				// Print Location
				System.out.println("SelectedLocation: " + selectedLocation);

				/*// Select Incident ID
				Select incidentID1 = new Select(dropdown_IncidentID);
				incidentID1.selectByIndex(5);

				// Get list of Incident ID
				List<WebElement> listOfIncidentID = incidentID1.getOptions();
				// Get Incident ID
				String selectedIncidentID = listOfIncidentID.get(5).getText();
				// Print Incident ID
				System.out.println("SelectedLocation: " + selectedIncidentID);*/

				/*
				 * String customerName= textbox_CustomerName.get
				 * System.out.println("CustomerName: "+customerName);
				 * Thread.sleep(200); // hiddenElement_CustomerName.click();
				 */
				textbox_CustomerName.sendKeys("demo_Customer");
				// Select activity
				Select activity1 = new Select(dropdown_ActivityHeader);
				activity1.selectByIndex(1);

				// Get list of Activity Header
				List<WebElement> listOfActivityHeader = activity1.getOptions();
				// Get Activity Header
				String selectedActivityHeader = listOfActivityHeader.get(1)
						.getText();
				// Print Activity Header
				System.out.println("selectedActivityHeader: "
						+ selectedActivityHeader);

				// Enter Activity
				String activityText = "Send Report";
				textbox_Activity.sendKeys(activityText);

				// Enter Remark
				String remarkText = "Tested";
				textbox_Remark.sendKeys(remarkText);

				// Click on Add Button
				button_Add.click();
				Thread.sleep(2000);

				// Get Notification
				String notificationText = notification.getText();
				// Print Notification
				System.out.println(notificationText);

				// Verify Notification
				softAssert.assertEquals(notificationText,
						"Activity Added Successfully.", "Notification is not Match");

				// Initialize index
				int i = 0;
				// Get Location in Table
				String locationInTable = list_Location.get(i).getText();
				// Print Location in Table
				System.out.println("locationInTable: " + locationInTable);

				// Get Incident ID in Table
				String incidentIDInTable = list_IncidentID.get(i).getText();
				// Print Incident ID in Table
				System.out.println("incidentIDInTable: " + incidentIDInTable);

				// Get Customer Name in Table
				String customerNameInTable = list_CustomerName.get(i).getText();
				// Print Customer Name in Table
				System.out.println("customerNameInTable: " + customerNameInTable);

				// Get Activity Header in Table
				String activityHeaderInTable = list_ActivityHeader.get(i).getText();
				// Print Activity Header in Table
				System.out.println("activityHeaderInTable: "
						+ activityHeaderInTable);

				// Get Activity in Table
				String activityInTable = list_Activity.get(i).getText();
				// Print Activity in Table
				System.out.println("ActivityInTable: " + activityInTable);

				// Get Activity Remark in Table
				String remarkInTable = list_ActivityRemark.get(i).getText();
				// Print Activity Remark in Table
				System.out.println("RemarkInTable: " + remarkInTable);

				// Verify Location
				softAssert.assertEquals(selectedLocation, locationInTable,
						"Location is not Same.");

				/*// Verify Incident ID
				softAssert.assertEquals(selectedIncidentID, incidentIDInTable,
						"Incident ID is not Same.");
*/
				// Verify Customer Name
				// Assert.assertEquals(customerName,
				// customerNameInTable,"Customer Name is not Same.");

				// Verify Activity Header
				softAssert.assertEquals(selectedActivityHeader, activityHeaderInTable,
						"Activity Header is not Same.");

				// Verify Activity
				softAssert.assertEquals(activityText, activityInTable,
						"Activity is not Same.");

				// Verify Remark
				softAssert.assertEquals(remarkText, remarkInTable,
						"Remark is not Same.");

			}
			softAssert.assertAll();

		}

		// 1. If User click on Add button in Add Daily Activity pop up with blank
		// date then notification should display as 'Please Select Date.'"
		// 2. If User not select time then notification should display as 'Please
		// Select Time.'"
		// 3. If User click on Add button in Add Daily Activity pop up with blank
		// location field then notification should display as 'Please Select
		// Location.'"
		// 4. If User keep 'All' option in Incident ID and click on Add button then
		// notification should display as 'Please Select Incident ID.'"
		// 5. If User select Incident ID from list then as per selected ID, customer
		// name should get auto fill"
		// 6. If User click on Add button in Add Daily Activity pop up without
		// select Activity Header field then notification should display as 'Please
		// Select Activity Header.'"
		// 7. If User click on Add button in Add Daily Activity pop up with blank
		// activity field then notification should display as 'Please Select
		// Activity.'"
		// 8. If User click on Add button in Add Daily Activity pop up with blank
		// activity remark field then notification should display as 'Please Select
		// Activity Remark.'

		public void checkNotificationWithoutSelectionInAddDailyActivityPopup()
				throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Click on Add Activity button
			button_AddActivity.click();

			// Click on Add Button
			button_Add.click();

			// Switch to the Alert
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Date
			String alertWithoutDate = alert.getText();

			// Display Message of alert Without Date
			System.out.println("AlertWithoutDate:" + alertWithoutDate);

			// Verify Alert message
			softAssert.assertEquals(alertWithoutDate, "Please Select Date.",
					"Alert in Add Daily Activity popup is not Same");

			// Click on OK button of Alert
			alert.accept();

			Thread.sleep(1000);

			// Get System Calendar
			Calendar mydate = new GregorianCalendar();
			// Get Day of Month From System Calendar
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			// Print Day Of Month
			System.out.println("Day Of Month: " + dayOfMonth);
			// Convert Day Of Month into String
			String currentDay = Integer.toString(dayOfMonth);
			// Click on Calendar
			calendar_Date.click();

			// Get all Date in Calendar
			for (WebElement day : dayOfCalendar_Date) {
				// Get Day in Calendar
				String dayInCalendar = day.getText();

				// Compare Day In Calendar And Current Day
				if (dayInCalendar.equalsIgnoreCase(currentDay)) {
					Thread.sleep(1000);
					// Click on Day
					day.click();
					// Get Day in Calendar
					String getDateValue = day.getText();
					// Print Day in Calendar
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// Click on Add Button
			button_Add.click();

			// Switch to the Alert
			Alert alertTime = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Time
			String alertWithoutTime = alertTime.getText();
			// Display Message of alert Without Time
			System.out.println("alertWithoutTime:" + alertWithoutTime);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutTime, "Please Select Time.",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertTime.accept();

			Thread.sleep(1000);

			// Get System Calendar
			Calendar calendar = Calendar.getInstance();
			// Get Hours from System Calendar
			String hrs = new SimpleDateFormat("HH").format(calendar.getTime());
			// Display Hours from System Calendar
			System.out.println(hrs);
			String min = new SimpleDateFormat("mm").format(calendar.getTime());
			System.out.println(min);

			// Get all Date in Calendar
			for (WebElement hrsofSystem : dropdown_FromDate) {
				// Get Day in Calendar
				String hrsInDropdown = hrsofSystem.getText();
				// Compare hrs In Drop down And Current hrs
				if (hrsInDropdown.equalsIgnoreCase(hrs)) {
					Thread.sleep(1000);
					// Click on hrs
					hrsofSystem.click();
					// Get hrs In Drop down
					String getDateValue = hrsofSystem.getText();
					// Print hrs In Drop down
					System.out.println("Select the hrs:-" + getDateValue);

					break;
				}

			}

			// Click on Add Button
			button_Add.click();

			// Switch to the Alert
			Alert alertLocation = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Location
			String alertWithoutlocation = alertLocation.getText();
			// Display Message of alert Without Location
			System.out.println("AlertWithoutlocation:" + alertWithoutlocation);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutlocation, "Please Select Location.",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertLocation.accept();

			Thread.sleep(1000);

			// Select Location in Drop down
			Select location = new Select(dropdown_Location);
			location.selectByIndex(1);

			// Click on Add Button
			button_Add.click();

		/*	// Switch to the Alert
			Alert alertIncidentID = driver.switchTo().alert();
			// Get Message from alert Without Incident ID
			String alertWithoutIncidentID = alertIncidentID.getText();
			// Display Message of alert Without Incident ID
			System.out.println("AlertWithoutIncidentID:" + alertWithoutIncidentID);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutIncidentID,
					"Please Select Incident ID.",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertIncidentID.accept();

			Thread.sleep(1000);
			// Select Incident Id in Drop down
			Select incidentID = new Select(dropdown_IncidentID);
			incidentID.selectByIndex(1);

			// Click on Add Button
			button_Add.click();*/

			// Switch to the Alert
			Alert alertCustomerName = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Date
			String alertWithoutCustomerName = alertCustomerName.getText();
			// Display Message of alert Without Date
			System.out.println("AlertWithoutCustomerName:"
					+ alertWithoutCustomerName);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutCustomerName,
					"Please Enter Customer Name.",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertCustomerName.accept();

			Thread.sleep(1000);
			// Click on customer name
			textbox_CustomerName.sendKeys("demo_Customer");
			Thread.sleep(200);
			// hiddenElement_CustomerName.click();

			// Click on Add Button
			button_Add.click();

			// Switch to the Alert
			Alert alertHeader = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Header
			String alertWithoutHeader = alertHeader.getText();
			// Display Message of alert Without Header
			System.out.println("AlertWithoutHeader:" + alertWithoutHeader);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutHeader,
					"Please Select Activity Header.",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertHeader.accept();
			Thread.sleep(1000);

			// Select Activity Header
			Select activity = new Select(dropdown_ActivityHeader);
			activity.selectByIndex(1);

			// Click on Add Button
			button_Add.click();

			// Switch to the Alert
			Alert alertActivity = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Activity
			String alertWithoutActivity = alertActivity.getText();
			// Display Message of alert Without Activity
			System.out.println("AlertWithoutActivity:" + alertWithoutActivity);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutActivity, "Please Enter Activity.",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertActivity.accept();

			Thread.sleep(1000);
			// Enter Activity
			textbox_Activity.sendKeys("Send Report");

			// Click on Add Button
			button_Add.click();

			// Switch to the Alert
			Alert alertRemark = driver.switchTo().alert();
			Thread.sleep(1000);
			// Get Message from alert Without Remark
			String alertWithoutRemark = alertRemark.getText();
			// Display Message of alert Without Remark
			System.out.println("AlertWithoutRemark:" + alertWithoutRemark);
			// Verify Alert message
			softAssert.assertEquals(alertWithoutRemark,
					"Please Enter Activity Remark .",
					"Alert in Add Daily Activity popup is not Same");
			// Click on OK button of Alert
			alertRemark.accept();

			driver.findElement(By.linkText("Cancel")).click();
			softAssert.assertAll();

		}

		public void checkDataFilterByIncidentID() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Click on Filter tab
			tab_Filter.click();
			// Get drop down of Filter By Incident ID
			Select filterByIncidentID = new Select(dropdown_FilterByIncidentID);

			// Get list of Filter By Incident ID
			List<WebElement> listOfFilterByIncidentID = filterByIncidentID
					.getOptions();
			// Get size of Filter By Incident ID
			int sizeOfFilterByIncidentID = listOfFilterByIncidentID.size();
			// Print size of Filter By Incident ID
			System.out.println("\nsizeOfIncidentID: " + sizeOfFilterByIncidentID);

			// Apply For Loop for Incident ID
			for (; incidentID < sizeOfFilterByIncidentID; incidentID++) {

				// Get Incident ID
				String incidentIDOptions = listOfFilterByIncidentID.get(incidentID)
						.getAttribute("value");
				// Print Incident ID
				System.out.println("\nIncidentIDOptions: " + incidentIDOptions);
				Thread.sleep(2000);
				// Select Incident ID
				filterByIncidentID.selectByIndex(incidentID);
				Thread.sleep(1000);

				// Get size of Incident ID
				int sizeOfIncidentID = list_IncidentID.size();
				// Print size of Incident ID
				System.out.println("sizeOfIncidentID: " + sizeOfIncidentID);

				// Check condition
				if (sizeOfIncidentID > 0) {
					// Apply For Loop for Incident ID
					for (int j = 0; j < sizeOfIncidentID; j++) {
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_IncidentID.get(j));
						// Get Incident ID
						String incidentID = list_IncidentID.get(j).getText();
						// Print Incident ID
						System.out.println("incidentID: " + incidentID);
						// Verify Incident ID
						softAssert.assertEquals(incidentID, incidentIDOptions,
								"Incident ID is not Same");

					}
					// Update Incident ID
					incidentID = incidentID + 1;
					// Call Daily Activity Page Of Sd Role
					rm_DailyActivityPage = new RM_DailyActivityPage();
					// call check Data Filter By Incident ID Method
					rm_DailyActivityPage.checkDataFilterByIncidentID();
					Thread.sleep(2000);

				} else if (sizeOfIncidentID == 0) {
					// Update Incident ID
					incidentID = incidentID + 1;
					// Call Daily Activity Page Of Sd Role
					rm_DailyActivityPage = new RM_DailyActivityPage();
					// call check Data Filter By Incident ID Method
					rm_DailyActivityPage.checkDataFilterByIncidentID();
					Thread.sleep(2000);
				}
			}
			softAssert.assertAll();
		}

		public void checkDataFilterByCustomerName() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Filter tab
			tab_Filter.click();
			// Get drop down of Filter By Customer Name
			Select filterByCustomerName = new Select(dropdown_FilterByCustomerName);
			// Get list of Filter By Customer Name
			List<WebElement> listOfFilterByCustomerName = filterByCustomerName
					.getOptions();
			// Get size of Filter By Customer Name
			int sizeOfFilterByCustomerName = listOfFilterByCustomerName.size();
			// Print size of Filter By Customer Name
			System.out.println("\nsizeOfFilterByCustomerName: "
					+ sizeOfFilterByCustomerName);
			// Apply For Loop for Customer Name
			for (; customerName < sizeOfFilterByCustomerName;) {
				// Get Customer Name
				String customerNameOptions = listOfFilterByCustomerName.get(
						customerName).getAttribute("value");
				// Print Customer Name
				System.out.println("\ncustomerNameOptions: " + customerNameOptions);
				Thread.sleep(2000);
				// Select Customer Name
				filterByCustomerName.selectByIndex(customerName);
				Thread.sleep(1000);
				// Get size of Customer Name
				int sizeOfCustomerName = list_CustomerName.size();
				// Print size of Customer Name
				System.out.println("sizeOfCustomerName: " + sizeOfCustomerName);

				// Check condition
				if (sizeOfCustomerName > 0) {
					// Apply For Loop for Customer Name
					for (int j = 0; j < sizeOfCustomerName; j++) {
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_CustomerName.get(j));
						// Get Customer Name
						//j
						String customerName = list_CustomerName.get(j).getText();
						// Print Customer Name
						System.out.println("Customer Name: " + customerName);
						// Verify Customer Name
						softAssert.assertEquals(customerName, customerNameOptions,
								"Customer Name is not Same");

					}
					// Update Customer Name
					customerName = customerName + 1;
					// Call Daily Activity Page Of Sd Role
					rm_DailyActivityPage = new RM_DailyActivityPage();
					// call check Data Filter By Customer Name Method
					rm_DailyActivityPage.checkDataFilterByCustomerName();
					
					Thread.sleep(2000);
					/////////////////////////////////////////////
					// Optional //
					break;
				
					//Thread.sleep(2000);
				} else if (sizeOfCustomerName == 0) {
					// Update Incident ID
					customerName = customerName + 1;
					// Call Daily Activity Page Of Sd Role
					rm_DailyActivityPage = new RM_DailyActivityPage();
					// call check Data Filter By Customer Name Method
					rm_DailyActivityPage.checkDataFilterByCustomerName();
					Thread.sleep(2000);
					/////////////////////////////////////////////
					// Optional //
					break;
				}
				Thread.sleep(2000);
				/////////////////////////////////////////////
				// Optional //
				break;

			}
			softAssert.assertAll();

		}

		public void checkDataFilterByActivityHeader() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Filter tab
			tab_Filter.click();

			// Get drop down of Filter By Activity Header
			Select filterByActivityHeader = new Select(
					dropdown_FilterByActivityHeader);
			// Get list of Filter By Activity Header
			List<WebElement> listOfFilterByActivityHeader = filterByActivityHeader
					.getOptions();
			// Get size of Filter By Activity Header
			int sizeOfFilterByActivityHeader = listOfFilterByActivityHeader.size();
			// Print size of Filter By Activity Header
			System.out.println("\nsizeOfFilterByActivityHeader: "
					+ sizeOfFilterByActivityHeader);
			// Apply For Loop for Activity Header
			for (; activityHeader < sizeOfFilterByActivityHeader; activityHeader++) {
				// Get Activity Header
				String activityHeaderOptions = listOfFilterByActivityHeader.get(
						activityHeader).getAttribute("value");
				// Print Activity Header
				System.out.println("\nactivityHeaderOptions: "
						+ activityHeaderOptions);
				Thread.sleep(2000);
				// Select Activity Header
				filterByActivityHeader.selectByIndex(activityHeader);
				Thread.sleep(1000);
				// Get size of Activity Header
				int sizeOfActivityHeader = list_ActivityHeader.size();
				// Print size of Activity Header
				System.out.println("sizeOfActivityHeader: " + sizeOfActivityHeader);

				// Check condition
				if (sizeOfActivityHeader > 0) {
					// Apply For Loop for Activity Header
					for (int j = 0; j < sizeOfActivityHeader; j++) {
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_ActivityHeader.get(j));
						// Get Activity Header
						String activityHeader = list_ActivityHeader.get(j)
								.getText();
						// Print Activity Header
						System.out.println("ActivityHeader: " + activityHeader);
						// Verify Activity Header
						softAssert.assertEquals(activityHeader, activityHeaderOptions,
								"Activity Header is not Same");

					}
					// Update Activity Header
					activityHeader = activityHeader + 1;
					// Call Daily Activity Page Of Sd Role
					rm_DailyActivityPage = new RM_DailyActivityPage();
					// call check Data Filter By Activity Header Method
					rm_DailyActivityPage.checkDataFilterByActivityHeader();
					Thread.sleep(2000);
				} else if (sizeOfActivityHeader == 0) {
					// Update Activity Header
					activityHeader = activityHeader + 1;
					// Call Daily Activity Page Of Sd Role
					rm_DailyActivityPage = new RM_DailyActivityPage();
					// call check Data Filter By Activity Header Method
					rm_DailyActivityPage.checkDataFilterByActivityHeader();
					Thread.sleep(2000);
				}

			}
			softAssert.assertAll();
		}

		public void checkDateAccordingFromAndToDate() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Filter tab
			tab_Filter.click();

			// Click on From Date Calendar
			calendar_FromDate.click();

			// Apply For Loop
			for (int i = 0; i < 12; i++) {
				// Click Previous Month Of Calendar
				previousMonthOfCalendar_FromDate.click();
				// Get Month
				String displayMonth = displayMonthOfCalendar_FromDate.getText();
				// Print Month
				System.out.println("Display Month: " + displayMonth);
				Thread.sleep(1000);
				// Compare Month
				if (displayMonth.equalsIgnoreCase("APRIL ")) {

					// Get all Dates in Calendar
					for (WebElement day : dayOfCalendar_FromDate) {
						// Get day
						String dayInCalender = day.getText();
						// Compare day
						if (dayInCalender.equals("4")) {
							// Select day
							day.click();
							// Get day
							String getDateValue = day.getText();
							// Print day
							System.out.println("Select the date:-" + getDateValue);

							break;
						}
					}
					break;
				}

			}
			
			Thread.sleep(1000);
			
			// Click on To Date Calendar
			calendar_ToDate.click();
			
			// Apply For Loop
			for (int i = 0; i < 12; i++) {
				// Click Previous Month Of Calendar
				previousMonthOfCalendar_ToDate.click();
				// Get Month
				String displayMonth = displayMonthOfCalendar_ToDate.getText();
				// Print Month
				System.out.println("Display Month: " + displayMonth);
				Thread.sleep(1000);
				// Compare Month
				if (displayMonth.equalsIgnoreCase("APRIL ")) {
					// Get all Dates in Calendar
					for (WebElement day : dayOfCalendar_ToDate) {
						// Get day
						String dayInCalender = day.getText();
						// Compare day
						if (dayInCalender.equals("5")) {
							// Select day
							day.click();
							// Get day
							String getDateValue = day.getText();
							// Print day
							System.out.println("Select the date:-" + getDateValue);

							break;
						}
					}
					break;
				}

			}
			// Click on Go Button
			button_Go.click();
			Thread.sleep(1000);
			// Get DAte Format
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// Get From Date
			String getFromDate = textbox_FromDate.getAttribute("value");
			// Print From Date
			System.out.println("fromDate: " + getFromDate);

			// Get To Date
			String getToDate = textbox_ToDate.getAttribute("value");
			// Print To Date
			System.out.println("toDate: " + getToDate);

			// Convert into Date Format
			Date fromDate = sdf.parse(getFromDate);
			// Print Date
			System.out.println(fromDate);

			// Convert into Date Format
			Date toDate = sdf.parse(getToDate);
			// Print Date
			System.out.println(toDate);

			// Get size of Date in Table
			int sizeOfDate = list_Date.size();
			// Print size of Date in Table
			System.out.println("sizeOfDate: " + sizeOfDate);

			// Check Condition
			if (sizeOfDate > 0) {
				// Apply For Loop
				for (int j = 0; j < sizeOfDate; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);", list_Date.get(j));
					// Get Date
					String date = list_Date.get(j).getText();
					// Print Date
					System.out.println("Date: " + date);

					// Convert into Date Format
					Date dateInTable = sdf.parse(date);

					boolean dateIspresent = true;

					// Compare Date
					if ((dateInTable.compareTo(fromDate) >= 0)
							&& (dateInTable.compareTo(toDate) <= 0)) {
						// Print message
						System.out.println("Date is between From Date to To date.");
						dateIspresent = true;
					} else {
						// Print message
						System.out
								.println("Date is not between From Date to To date.");
						dateIspresent = false;
					}
					// Verify date
					softAssert.assertTrue(dateIspresent,
							"Date is not between From Date to To date.");

				}

			}
			softAssert.assertAll();

		}

		public void checkDaysAccordingDates() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get Days
			String days = label_Days.getText();
			// Split day
			String dayInString = days.split(" ")[0];
			// Convert into Integer
			int day = Integer.parseInt(dayInString);
			// Print Day
			System.out.println("Days: " + day);

			// Convert List of WebElement to List Of String
			List<String> strings = new ArrayList<String>();
			for (WebElement e : list_Date) {
				strings.add(e.getText());
			}

			// Count unique data
			Set<String> uniqueDates = new HashSet<String>(strings);
			// Get Size
			int uniqueDate = uniqueDates.size();
			// Print Size
			System.out.println("Unique Date count: " + uniqueDate);
			// Verify Days Count
			softAssert.assertEquals(day, uniqueDate, "Days Count is not Same.");
			softAssert.assertAll();

		}

		public void checkTimeAccordingTAT() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get Time
			String time = label_Hours.getText();
			// Print Time
			System.out.println("time: " + time);

			// Split Time
			String hrsTime = time.split(" ")[0];
			// Convert into Integer
			int hours = Integer.parseInt(hrsTime);
			// Print Hours
			System.out.println("hours:" + hours);

			// Split Time
			String minTime = time.split(" ")[2];
			// Convert into Integer
			int minute = Integer.parseInt(minTime);
			// Print Minute
			System.out.println("minute: " + minute);

			// Get Size of TAT
			int sizeOfTAT = list_TAT.size();
			// Print Size of TAT
			System.out.println("sizeOfTAT: " + sizeOfTAT);

			// Initialize total Hrs
			int totalHrs = 0;
			// Initialize total MIn
			int totalMin = 0;

			// Apply For Loop
			for (int i = 0; i < sizeOfTAT; i++) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);", list_TAT.get(i));
				// Get TAT
				String tat = list_TAT.get(i).getText();
				// Print TAT
				System.out.println("\nTAT: " + tat);

				// Split hrs
				String hrsValue = tat.split(" ")[0];
				// Convert into Integer
				int hrs = Integer.parseInt(hrsValue);
				// Print hrs
				System.out.println("hrs: " + hrs);

				// Split min
				String minValue = tat.split(" ")[2];
				// Convert into Integer
				int min = Integer.parseInt(minValue);
				// Print min
				System.out.println("min: " + min);

				// Count Total Hrs
				totalHrs = totalHrs + hrs;
				// Print Total Hrs
				System.out.println("TotalHrs: " + totalHrs);
				// Count Total Min
				totalMin = totalMin + min;
				// Print Total min
				System.out.println("TotalMin: " + totalMin);
			}
			// Verify Hours
			softAssert.assertEquals(totalHrs, hours, "Hours are not Same.");
			// Verify Minutes
			softAssert.assertEquals(totalMin, minute, "Minutes are not Same.");
			softAssert.assertAll();

		}

		public void updateDailyActivity() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get first Remark within list
			String remarkBeforeUpdate = list_ActivityRemark.get(0).getText();
			// Print Remark
			System.out.println("Remark Before Update: " + remarkBeforeUpdate);

			// Click on first Update symbol
			list_Update.get(0).click();

			// Get Heading of Update Daily Activity Pop up
			String heading = heading_UpdateDailyActivityPopup.getText();

			// Display Heading of Update Daily Activity Pop up
			System.out.println("heading: " + heading);

			// Verify Heading of Update Daily Activity Pop up
			softAssert.assertEquals(heading, "Update Daily Activity",
					"Update Daily Activity popup is not Same");

			// Give the Remark
			String remark = "Tested After Updation";
			// Clear Remark Text box
			textbox_UpdateRemark.clear();
			// Enter Remark in Text box
			textbox_UpdateRemark.sendKeys(remark);
			// Click on Update Button
			button_Update.click();

			Thread.sleep(1000);
			// Get first Remark within list
			String remarkAfterUpdate = list_ActivityRemark.get(0).getText();
			// Print Remark
			System.out.println("Remark After Update: " + remarkAfterUpdate);

			// Verify Remark
			softAssert.assertEquals(remarkAfterUpdate, remark, "Remark is not Same.");

			Thread.sleep(1000);
			// Get Notification
			String notificationText = notification.getText();
			// Print Notification
			System.out.println(notificationText);

			// Verify Notification
			softAssert.assertEquals(notificationText, "Activity Updated Successfully.",
					"Notification is not Match");
			softAssert.assertAll();

		}

		public void deleteDailyActivity() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			int sizeBeforeDelete = list_Delete.size();
			System.out.println("Size Before Delete: " + sizeBeforeDelete);

			list_Delete.get(0).click();

			// Switch to the Alert
			Alert alert = driver.switchTo().alert();

			// Get Message from alert
			String alertOfConfirmation = alert.getText();

			// Display Message of alert
			System.out.println("Alert Of Confirmation: " + alertOfConfirmation);

			// Verify Alert message
			softAssert.assertEquals(alertOfConfirmation,
					"Do you want to delete this Daily Activity? ",
					"Alert is not Same");

			// Click on OK button of Alert
			alert.accept();

			Thread.sleep(1000);

			int sizeAfterDelete = list_Delete.size();
			System.out.println("Size After Delete: " + sizeAfterDelete);

			softAssert.assertNotEquals(sizeBeforeDelete, sizeAfterDelete,
					"Entry not get deleted.");

			Thread.sleep(1000);
			// Get Notification
			String notificationText = notification.getText();
			// Print Notification
			System.out.println(notificationText);

			// Verify Notification
			softAssert.assertEquals(notificationText, "Activity Deleted Successfully.",
					"Notification is not Match");
			softAssert.assertAll();

		}

		public void clickOnDeleteSymbolInDailyActivity() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get size
			int sizeBeforeDelete = list_Delete.size();
			// print Size
			System.out.println("Size Before Delete: " + sizeBeforeDelete);
			
			// Click on first Entry
			list_Delete.get(0).click();

			// Switch to the Alert
			Alert alert = driver.switchTo().alert();

			Thread.sleep(1000);
			// Click on Cancel button of Alert
			alert.dismiss();

			Thread.sleep(1000);

			// Get size
			int sizeAfterDelete = list_Delete.size();
			// print Size
			System.out.println("Size After Delete: " + sizeAfterDelete);
			// Verify Size
			softAssert.assertEquals(sizeBeforeDelete, sizeAfterDelete,
					"Entry get deleted.");
			softAssert.assertAll();
		}
	
		

	}

