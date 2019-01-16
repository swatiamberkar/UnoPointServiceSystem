package com.uno.pages.sd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_BusinessUnitMasterPage;
import com.uno.pages.superrole.Super_CustomerDetailsPage;
import com.uno.pages.superrole.Super_CustomerMasterPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketTypePage;

public class SD_SDActivityPage extends BaseCode{
	
	SD_EngineerActivityPage engineerActivityPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_LoginPage loginPageOfSdRole;
	
	// call the method from super role
		Super_LoginPage loginPageOfSuperRole;
		Super_HomePage homePageOfSuperRole;
		Super_SDMasterPage sDmasterPageOfSuperRole;
		Super_TicketMasterPage ticketMasterPageOfSuperRole;
		Super_TicketTypePage ticketTypePageOfSuperRole;
		Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
		Super_CustomerDetailsPage customerDetailsPageOfSuperRole;
		Super_CustomerMasterPage  customerMasterPageOfSuperRole;
		Super_BusinessUnitMasterPage businessUnitMasterPageOfSuperRole;
		
		

	public static int dateRange ;
	public static String incTypeInEngineerActivity = null;
	public static String customerInEngineerActivity = null;
	public static String businessUnitInEngineerActivity = null;
	
	// Date Range Drop down
	@FindBy(css = "select[name='m_strDateRange']")
	WebElement dropdown_DateRange;
	
	// From Text box
	@FindBy(css = "input[name='m_strFromDate']")
	WebElement textbox_From;

	// To Text box
	@FindBy(css = "input[name='m_strToDate']")
	WebElement textbox_To;

	// From Calendar
	@FindBy(css = "a[id='fd-but-dp-1']")
	WebElement calendar_From;

	// To Calendar
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calendar_To;

	// From - Day of Calendar
	@FindBy(css = "div[id='fd-dp-1']>table>tbody>tr>td")
	List<WebElement> dayOfCalendar_From;

	// To - Day of Calendar
	@FindBy(css = "div[id='fd-dp-2']>table>tbody>tr>td")
	List<WebElement> dayOfCalendar_To;
	
	// Region Drop down
	@FindBy(css = "select[name='m_strRegion']")
	WebElement dropdown_Region;

	// State Drop down
	@FindBy(css = "select[name='m_strState']")
	WebElement dropdown_State;
	
	// Business Unit Drop down
	@FindBy(css = "select[name='m_strBusinessUnit']")
	WebElement dropdown_BusinessUnit;
	
	// Pop Location Drop down
	@FindBy(css = "select[name='m_strPopLocation']")
	WebElement dropdown_PopLocation;
	

	// Go Button
	@FindBy(css = "a[onclick= 'GoForSearch()']")
	WebElement button_Go;

	// list of Row
	@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr")
	List<WebElement> list_Row;

	// list of Engineer
	@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(3)")
	List<WebElement> list_Engineer;

	// list of Pop Location
	@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(2)")
	List<WebElement> list_PopLocation;
	
	
	// Home Button
	@FindBy(css = "a[href='/erprmwise/SDHomeScreen.do']")
	WebElement button_Home;
	
	// list of Log Date
	@FindBy(xpath = ".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[7]")
	List<WebElement> list_LogDate;
	
	// Select SD tab for logout tab
	@FindBy(linkText = "Sd")
	WebElement link_sd;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement link_Test;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	// Initializing Page Object
	public SD_SDActivityPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkFromAndToDateAccordingSelectedDateRange() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		// Get Format
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Get system date
		Date date = new Date();
		// Convert into Date Format
		String todayDate = dateFormat.format(date);
		// Print Date
		System.out.println("Today Date: " + todayDate);
		Date todaysDate = (Date) dateFormat.parse(todayDate);

		// Get System Calendar
		Calendar calendar = Calendar.getInstance();
		// Move calendar to yesterday
		calendar.add(Calendar.DATE, -1);
		// Get current date of calendar which point to the yesterday now
		Date yesterday = calendar.getTime();
		// Convert into Date Format
		String yesterdayDate = dateFormat.format(yesterday).toString();
		// print Date
		System.out.println("Yesterday Date: " + yesterdayDate);

		// Get System Calendar
		Calendar calendar1 = Calendar.getInstance();
		// Move calendar to 7 days before
		calendar1.add(Calendar.DATE, -7);
		// Get current date of calendar which point to the yesterday now
		Date lastSevenDays = calendar1.getTime();
		// Convert into Date Format
		String lastSevenDaysDate = dateFormat.format(lastSevenDays).toString();
		// print Date
		System.out.println("Last Seven Days Date: " + lastSevenDaysDate);
		Date lastSevenDayDate = (Date) dateFormat.parse(lastSevenDaysDate);

		// Get System Calendar
		Calendar calendar2 = Calendar.getInstance();
		// Move calendar to 30 days before
		calendar2.add(Calendar.DATE, -30);
		// Get current date of calendar which point to the yesterday now
		Date lastThirtyDays = calendar2.getTime();
		// Convert into Date Format
		String lastThirtyDaysDate = dateFormat.format(lastThirtyDays)
				.toString();
		// print Date
		System.out.println("Last Thirty Days Date: " + lastThirtyDaysDate);
		Date lastThirtyDayDate = (Date) dateFormat.parse(lastThirtyDaysDate);

		// Get Date Range Drop down
		Select selectDateRange = new Select(dropdown_DateRange);
		// Get list of Options in Drop down
		List<WebElement> listOfDateRange = selectDateRange.getOptions();

		// Get size of Options in Drop down
		int sizeOfDateRangeOptions = listOfDateRange.size();
		// Print size of Options in Drop down
		System.out.println("sizeOfDateRangeOptions: " + sizeOfDateRangeOptions);

		// Apply For Loop
		for (; dateRange < sizeOfDateRangeOptions; dateRange++) {

			// Get Option in Drop down
			String dateRangeOptions = listOfDateRange.get(dateRange)
					.getAttribute("value");
			// Print Option in Drop down
			System.out.println("\ndateRangeOptions: " + dateRangeOptions);

			// Compare Option in Drop down
			if (dateRangeOptions.equalsIgnoreCase("Today")) {
				// Select Option
				selectDateRange.selectByIndex(dateRange);
				Thread.sleep(1000);
				// Get From Date
				String fromDate = textbox_From.getAttribute("value");
				// print From Date
				System.out.println("fromDate: " + fromDate);

				// Get To Date
				String toDate = textbox_To.getAttribute("value");
				// print To Date
				System.out.println("toDate: " + toDate);

				// Verify From Date
				softAssert.assertEquals(fromDate, todayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Verify To Date
				softAssert.assertEquals(toDate, todayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Click on Go button
				button_Go.click();
				Thread.sleep(1000);
				// Get size of Log Date Time
				int sizeOfLogDateTime = list_LogDate.size();
				// Print size of Log Date Time
				System.out.println("size: " + sizeOfLogDateTime);
				// Compare size
				if (sizeOfLogDateTime == 0) {
					// Update Date Range
					dateRange = dateRange + 1;
					// Call Engineer Activity Page Of Sd Role
					engineerActivityPageOfSdRole = new SD_EngineerActivityPage();
					// call checkFromAndToDateAccordingSelectedDateRange Method
					engineerActivityPageOfSdRole
							.checkFromAndToDateAccordingSelectedDateRange();
					Thread.sleep(500);
				}
				for (int i = 1; i < sizeOfLogDateTime; i++) {
					Thread.sleep(2000);

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_LogDate.get(i));
					Thread.sleep(200);
					highLight(list_LogDate.get(i));
					Thread.sleep(5000);
					// Get Log Date Time
					String LogDateTime = list_LogDate.get(i).getText();
					// Print Log Date Time
					System.out.println("LogDateTime: " + LogDateTime);
					// Get only Log Date
					String LogDateAndTime = LogDateTime.split(" ")[0];
					// Print Log Date
					System.out.println("LogDateAndTime: " + LogDateAndTime);
					// Verify Date
					softAssert.assertEquals(LogDateAndTime, todayDate,
							"Log Date And Time is not same");
				}

			}
			// Compare Option in Drop down
			else if (dateRangeOptions.equalsIgnoreCase("Yesterday")) {

				// Select Option
				selectDateRange.selectByIndex(dateRange);
				Thread.sleep(1000);
				// Get From Date
				String fromDate = textbox_From.getAttribute("value");
				// print From Date
				System.out.println("fromDate: " + fromDate);

				// Get To Date
				String toDate = textbox_To.getAttribute("value");
				// print To Date
				System.out.println("toDate: " + toDate);

				// Verify From Date
				softAssert.assertEquals(fromDate, yesterdayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Verify To Date
				softAssert.assertEquals(toDate, yesterdayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Click on Go button
				button_Go.click();
				Thread.sleep(1000);
				// Get size of Log Date Time
				int sizeOfLogDateTime = list_LogDate.size();
				// Print size of Log Date Time
				System.out.println("size: " + sizeOfLogDateTime);
				// Compare size
				if (sizeOfLogDateTime == 0) {
					// Update Date Range
					dateRange = dateRange + 1;
					// Call Engineer Activity Page Of Sd Role
					engineerActivityPageOfSdRole = new SD_EngineerActivityPage();
					// call checkFromAndToDateAccordingSelectedDateRange Method
					engineerActivityPageOfSdRole
							.checkFromAndToDateAccordingSelectedDateRange();
					Thread.sleep(500);
				}
				for (int i = 0; i < sizeOfLogDateTime; i++) {

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_LogDate.get(i));
					highLight(list_LogDate.get(i));
					Thread.sleep(5000);
					// Get Log Date Time
					String LogDateTime = list_LogDate.get(i).getText();
					// Print Log Date Time
					System.out.println("LogDateTime: " + LogDateTime);
					// Get only Log Date
					String LogDateAndTime = LogDateTime.split(" ")[0];
					// Print Log Date
					System.out.println("LogDateAndTime: " + LogDateAndTime);
					// Verify Date
					softAssert.assertEquals(LogDateAndTime, yesterdayDate,
							"Log Date And Time is not same");
					Thread.sleep(5000);
				}

			}
			// Compare Option in Drop down
			else if (dateRangeOptions.equalsIgnoreCase("Last 7 days")) {
				// Select Option
				selectDateRange.selectByIndex(dateRange);
				Thread.sleep(1000);
				// Get From Date
				String fromDate = textbox_From.getAttribute("value");
				// print From Date
				System.out.println("fromDate: " + fromDate);

				// Get To Date
				String toDate = textbox_To.getAttribute("value");
				// print To Date
				System.out.println("toDate: " + toDate);

				// Verify From Date
				softAssert.assertEquals(fromDate, lastSevenDaysDate,
						"Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Verify To Date
				softAssert.assertEquals(toDate, todayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Click on Go button
				button_Go.click();
				Thread.sleep(1000);
				// Get size of Log Date Time
				int sizeOfLogDateTime = list_LogDate.size();
				// Print size of Log Date Time
				System.out.println("size: " + sizeOfLogDateTime);
				// Compare size
				if (sizeOfLogDateTime == 0) {
					// Update Date Range
					dateRange = dateRange + 1;
					// Call Engineer Activity Page Of Sd Role
					engineerActivityPageOfSdRole = new SD_EngineerActivityPage();
					// call checkFromAndToDateAccordingSelectedDateRange Method
					engineerActivityPageOfSdRole
							.checkFromAndToDateAccordingSelectedDateRange();
					Thread.sleep(500);
				}
				for (int i = 0; i < sizeOfLogDateTime; i++) {

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_LogDate.get(i));
					// Get Log Date Time
					String LogDateTime = list_LogDate.get(i).getText();
					// Print Log Date Time
					System.out.println("LogDateTime: " + LogDateTime);
					// Get only Log Date
					String LogDateAndTime = LogDateTime.split(" ")[0];
					// Print Log Date
					System.out.println("LogDateAndTime: " + LogDateAndTime);
					Date logDate = (Date) dateFormat.parse(LogDateAndTime);
					Boolean dateIsPresent = true;
					if (logDate.compareTo(lastSevenDayDate) >= 0
							&& logDate.compareTo(todaysDate) <= 0) {
						dateIsPresent = true;

					} else {
						dateIsPresent = false;
					}
					// Verify Date
					softAssert.assertTrue(dateIsPresent,
							"Log Date And Time is not between Seven Days.");
					System.out
							.println("Log Date And Time is between Seven Days.");
				}

			}
			// Compare Option in Drop down
			else if (dateRangeOptions.equalsIgnoreCase("Last 30 days")) {
				// Select Option
				selectDateRange.selectByIndex(dateRange);
				Thread.sleep(1000);
				// Get From Date
				String fromDate = textbox_From.getAttribute("value");
				// print From Date
				System.out.println("fromDate: " + fromDate);

				// Get To Date
				String toDate = textbox_To.getAttribute("value");
				// print To Date
				System.out.println("toDate: " + toDate);

				// Verify From Date
				softAssert.assertEquals(fromDate, lastThirtyDaysDate,
						"Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Verify To Date
				softAssert.assertEquals(toDate, todayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Click on Go button
				button_Go.click();
				Thread.sleep(1000);
				// Get size of Log Date Time
				int sizeOfLogDateTime = list_LogDate.size();
				// Print size of Log Date Time
				System.out.println("size: " + sizeOfLogDateTime);
				// Compare size
				if (sizeOfLogDateTime == 0) {
					// Update Date Range
					dateRange = dateRange + 1;
					// Call Engineer Activity Page Of Sd Role
					engineerActivityPageOfSdRole = new SD_EngineerActivityPage();
					// call checkFromAndToDateAccordingSelectedDateRange Method
					engineerActivityPageOfSdRole
							.checkFromAndToDateAccordingSelectedDateRange();
					Thread.sleep(500);
				}
				for (int i = 0; i < sizeOfLogDateTime; i++) {

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_LogDate.get(i));
					// Get Log Date Time
					String LogDateTime = list_LogDate.get(i).getText();
					// Print Log Date Time
					System.out.println("LogDateTime: " + LogDateTime);
					// Get only Log Date
					String LogDateAndTime = LogDateTime.split(" ")[0];
					// Print Log Date
					System.out.println("LogDateAndTime: " + LogDateAndTime);
					Date logDate = (Date) dateFormat.parse(LogDateAndTime);
					Boolean dateIsPresent = true;
					if (logDate.compareTo(lastThirtyDayDate) >= 0
							&& logDate.compareTo(todaysDate) <= 0) {
						dateIsPresent = true;

					} else {
						dateIsPresent = false;
					}
					// Verify Date
					softAssert.assertTrue(dateIsPresent,
							"Log Date And Time is not between Seven Days.");
					System.out
							.println("Log Date And Time is between Seven Days.");
				}

			}
			// Compare Option in Drop down
			else if (dateRangeOptions.equalsIgnoreCase("Custom")) {

				// Select Option
				selectDateRange.selectByIndex(dateRange);
				Thread.sleep(1000);
				// Get From Date
				String fromDate = textbox_From.getAttribute("value");
				// print From Date
				System.out.println("fromDate: " + fromDate);

				// Get To Date
				String toDate = textbox_To.getAttribute("value");
				// print To Date
				System.out.println("toDate: " + toDate);

				// Verify From Date
				softAssert.assertEquals(fromDate, todayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Verify To Date
				softAssert.assertEquals(toDate, todayDate, "Date is not Same");
				// display Message
				System.out.println("Display same Date.");

				// Click on Go button
				button_Go.click();
				Thread.sleep(1000);
				// Get size of Log Date Time
				int sizeOfLogDateTime = list_LogDate.size();
				// Print size of Log Date Time
				System.out.println("size: " + sizeOfLogDateTime);
				// Compare size
				if (sizeOfLogDateTime == 0) {
					// Update Date Range
					dateRange = dateRange + 1;
					// Call Engineer Activity Page Of Sd Role
					engineerActivityPageOfSdRole = new SD_EngineerActivityPage();
					// call checkFromAndToDateAccordingSelectedDateRange Method
					engineerActivityPageOfSdRole
							.checkFromAndToDateAccordingSelectedDateRange();
					Thread.sleep(500);
				}
				for (int i = 0; i < sizeOfLogDateTime; i++) {

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							list_LogDate.get(i));
					// Get Log Date Time
					String LogDateTime = list_LogDate.get(i).getText();
					// Print Log Date Time
					System.out.println("LogDateTime: " + LogDateTime);
					// Get only Log Date
					String LogDateAndTime = LogDateTime.split(" ")[0];
					// Print Log Date
					System.out.println("LogDateAndTime: " + LogDateAndTime);
					// Verify Date
					softAssert.assertEquals(LogDateAndTime, todayDate,
							"Log Date And Time is not same");
				}

			}
			
			// Update Date Range
			dateRange = dateRange + 1;
			// Call Engineer Activity Page Of Sd Role
			engineerActivityPageOfSdRole = new SD_EngineerActivityPage();
			// call checkFromAndToDateAccordingSelectedDateRange Method
			engineerActivityPageOfSdRole
					.checkFromAndToDateAccordingSelectedDateRange();
			Thread.sleep(500);

		}
		softAssert.assertAll();
	}
	
	public void verifyPopLocationAccordingSelectedPopLocation() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Get Region Drop down
		Select selectRegion = new Select(dropdown_Region);
		// Select Region
		selectRegion.selectByVisibleText("West");

		Thread.sleep(1000);
		// Get State Drop down
		Select selectState = new Select(dropdown_State);
		// Select State
		selectState.selectByVisibleText("Maharashtra");
		Thread.sleep(1000);
		// Get Pop Location Drop down
		Select select = new Select(dropdown_PopLocation);
		// Select Pop Location
		select.selectByVisibleText("Mumbai");

		// Click on Go button
		button_Go.click();

		// Get Size of Pop Location in table
		int size = list_PopLocation.size();
		// Print Size of Pop Location in table
		System.out.println("size: " + size);
		// Apply For loop
		for (int i = 0; i < size; i++) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", list_PopLocation.get(i));
			// Get name of Pop Location
			String popLocation = list_PopLocation.get(i).getText();
			// Print name of Pop Location
			System.out.println("PopLocation: " + popLocation);
			// Verify Pop Location
			softAssert.assertEquals(popLocation, "Mumbai");
		}
		softAssert.assertAll();
	}


}
