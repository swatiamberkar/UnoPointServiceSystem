package com.uno.pages.sd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;

public class SD_EngineerAvailabilityPage extends BaseCode {

	// Drop down of Role
	@FindBy(css = "select[name='m_strFilterAvail']")
	WebElement dropdown_Role;

	// Drop down of List of Role
	@FindBy(css = "select[name='m_strFilterAvail']>option ")
	List<WebElement> dropdown_ListOfRole;

	// Drop down of Engineer
	@FindBy(css = "select[name='m_strEngineerList']")
	WebElement dropdown_Engineer;

	// Drop down of Business Unit
	@FindBy(css = "select[name='m_strBusinessUnit']")
	WebElement dropdown_BusinessUnit;
	
	// Drop down of Business Unit
	@FindBy(css = "select[name='m_strBusinessUnit']>option ")
	List<WebElement> dropdown_ListOfBusinessUnit;

	// Drop down of State
	@FindBy(css = "select[name='m_strStateFilter']")
	WebElement dropdown_State;

	// Drop down of Location
	@FindBy(css = "select[name='m_strPopLocation']")
	WebElement dropdown_Location;

	// Text box of From Date
	@FindBy(css = "input[name='m_strStartDate']")
	WebElement textbox_FromDate;

	// Text box of To Date
	@FindBy(css = "input[name='m_strToDate']")
	WebElement textbox_ToDate;

	// Calendar of From Date
	@FindBy(css = "a[id='fd-but-dp-1']")
	WebElement calendar_FromDate;

	// Calendar of To Date
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calendar_ToDate;

	// Day of Calendar in From Date
	@FindBy(css = "div[id='fd-dp-1']>table>tbody>tr>td")
	List<WebElement> dayOfCalendar_FromDate;

	// Day of Calendar in To Date
	@FindBy(css = "div[id='fd-dp-2']>table>tbody>tr>td")
	List<WebElement> dayOfCalendar_ToDate;

	// Button Go
	@FindBy(css = "img[onclick='FilterAs();']")
	WebElement button_Go;

	// Button Go of Search
	@FindBy(css = "img[onclick='search();']")
	WebElement button_GoOfSearch;

	// List of ID
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(1)")
	List<WebElement> list_ID;

	// List of Engineer Name
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(2)")
	List<WebElement> list_EngineerName;

	// List of Available Time
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(3)")
	List<WebElement> list_AvailableTime;

	// List of Updated Date
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(4)")
	List<WebElement> list_UpdatedDate;

	// List of Updated Time
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(5)")
	List<WebElement> list_UpdatedTime;

	// List of Leave Type
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(6)")
	List<WebElement> list_LeaveType;

	// List of Lat
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(7)")
	List<WebElement> list_Lat;

	// List of Lon
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(8)")
	List<WebElement> list_Lon;

	// List of Address
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(9)")
	List<WebElement> list_Address;

	// Initializing Page Object
	public SD_EngineerAvailabilityPage() {
		PageFactory.initElements(driver, this);
	}

	// In Engineer availability table, by default updated attendance entries
	// should display in table for employee (For present day)
	public void checkByDefaultUpdatedDate() throws Exception {

		// get current date
		Date systemDate = new Date();
		// Get Format
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Convert into String
		String formatSystemDate = dateFormat.format(systemDate);
		// Convert into Date Format
		Date actualSystemDate = dateFormat.parse(formatSystemDate);
		// Convert into Date Format to String Format
		String SystemDateValue = dateFormat.format(actualSystemDate);
		// print Date
		System.out.println("System Date:-" + SystemDateValue);

		// Get size of Updated Date
		int size = list_UpdatedDate.size();
		// Get size of Updated Date
		System.out.println("size: " + size);
		// Check Condition
		if (size >= 1) {
			// Apply For Loop
			for (int i = 0; i < size; i++) {
				// Get date from list of Updated Date
				String updatedDate = list_UpdatedDate.get(i).getText();
				// Print date from list of Updated Date
				System.out.println("Updated Date: " + updatedDate);
				// Verify Date
				Assert.assertEquals(updatedDate, SystemDateValue,
						"Updated Date is not Same.");
			}
		}

	}

	public void varifyEngineerAccordingSelectedRole() throws Exception {
		// Handle drop down of Role
		Select select = new Select(dropdown_Role);
		// Get size of List Of Role
		int sizeOfRole = dropdown_ListOfRole.size();
		// Print size of List Of Role
		System.out.println("sizeOfRole: " + sizeOfRole);
		// Apply For Loop
		for (int i = 2; i < sizeOfRole; i++) {
			// Get Role from List Of Role
			String role = dropdown_ListOfRole.get(i).getText();
			// Print Role from List Of Role
			System.out.println("role: " + role);
			// Select Role
			select.selectByIndex(i);
			// Click on Go button
			button_Go.click();
			// Get Size of list of Engineer Name
			int sizeOfEngineerName = list_EngineerName.size();
			// Apply condition
			if (sizeOfEngineerName >= 1) {
				// Apply For Loop
				for (int j = 0; j < sizeOfEngineerName; j++) {
					// Get Name of list of Engineer Name
					String engineerName = list_EngineerName.get(j).getText();
					// Print Name of list of Engineer Name
					System.out.println("Engineer Name: " + engineerName);

					String engineer = engineerName.split(" ")[0];
					boolean engineerIsPresent = true;

					if (role.equalsIgnoreCase(engineer)
							|| engineer.contains(role)) {
						engineerIsPresent = true;
					} else {
						engineerIsPresent = false;
					}

					// Verify Engineer Name
					Assert.assertTrue(engineerIsPresent,
							"Engineer is not Same.");
				}
			}
		}
	}

	public void checkSearchFilter() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// Click on Go button
		button_GoOfSearch.click();

		// Handle Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		// Get Text From Alert
		String alertOfFromDate = alert.getText();
		// Print Text From Alert
		System.out.println("alertOfFromDate: " + alertOfFromDate);
		// Click on OK button of Alert
		alert.accept();
		// Verify Alert Message
		softAssert.assertEquals(alertOfFromDate, "Please insert from date",
				"Alert Message is not Same.");

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		// Get Current Day
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		// Print Current Day
		System.out.println("dayOfMonth: " + dayOfMonth);
		// Convert into String
		String currentDay = Integer.toString(dayOfMonth);
		// Get Previous Day
		int preDay = Integer.parseInt(currentDay) - 2;
		// Convert into String
		String previousDay = Integer.toString(preDay);
		// Click on Calendar
		calendar_FromDate.click();

		// Get all days in Calendar
		for (WebElement day : dayOfCalendar_FromDate) {

			String dayInCalender = day.getText();
			// Compare day
			if (dayInCalender.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				// select Day
				day.click();
				// Get Day
				String getDateValue = day.getText();
				// Print Day
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		// Click on Go button
		button_GoOfSearch.click();

		// Handle Alert
		Alert alertForToDate= driver.switchTo().alert();
		Thread.sleep(2000);
		// Get Text From Alert
		String alertOfToDate = alertForToDate.getText();
		// Print Text From Alert
		System.out.println("alertOfToDate: " + alertOfToDate);
		// Click on OK button of Alert
		alertForToDate.accept();
		// Verify Alert Message
		softAssert.assertEquals(alertOfToDate, "Please insert to date",
				"Alert Message is not Same.");

		Thread.sleep(1000);
		// Click on Calendar
		calendar_ToDate.click();

		// Get all days in Calendar
		for (WebElement day : dayOfCalendar_ToDate) {

			String dayInCalender = day.getText();
			// Compare day
			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				// select Day
				day.click();
				// Get Day
				String getDateValue = day.getText();
				// Print Day
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		// Click on Go button
		button_GoOfSearch.click();
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

		// Get size of Updated Date
		int size = list_UpdatedDate.size();
		// Get size of Updated Date
		System.out.println("size: " + size);
		// Check Condition
		if (size >= 1) {
			// Apply For Loop
			for (int i = 0; i < size; i++) {
				// Get date from list of Updated Date
				String updatedDate = list_UpdatedDate.get(i).getText();
				// Print date from list of Updated Date
				System.out.println("Updated Date: " + updatedDate);

				// Convert into Date Format
				Date dateInTable = sdf.parse(updatedDate);

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
		// Handle drop down of Engineer
				Select select = new Select(dropdown_Engineer);
				select.selectByVisibleText("Kavita1 .");
				// Click on Go button
				button_GoOfSearch.click();
				
				// Get Size of list of Engineer Name
				int sizeOfEngineerName = list_EngineerName.size();
				// Apply condition
				if (sizeOfEngineerName >= 1) {
					// Apply For Loop
					for (int j = 0; j < sizeOfEngineerName; j++) {
						// Get Name of list of Engineer Name
						String engineerName = list_EngineerName.get(j).getText();
						// Print Name of list of Engineer Name
						System.out.println("Engineer Name: " + engineerName);

						
						boolean engineerIsPresent = true;

						if ( engineerName.contains("Kavita1 .")) {
							engineerIsPresent = true;
						} else {
							engineerIsPresent = false;
						}

						// Verify Engineer Name
						softAssert.assertTrue(engineerIsPresent,
								"Engineer is not Same.");
					}
				}
				select.selectByVisibleText("All");
				Thread.sleep(1000);
				
				// Handle drop down of Business Unit
				Select businessUnit = new Select(dropdown_BusinessUnit);
				// Get size of List Of Business Unit
				int sizeOfBusinessUnit = dropdown_ListOfBusinessUnit.size();
				// Print size of List Of Business Unit
				System.out.println("sizeOfBusinessUnit: " + sizeOfBusinessUnit);
				// Apply For Loop
				for (int i = 1; i < sizeOfBusinessUnit; i++) {
					// Get Business Unit from List Of Business Unit
					String businessUnitText = dropdown_ListOfBusinessUnit.get(i).getText();
					// Print Business Unit from List Of Business Unit
					System.out.println("businessUnit: " + businessUnitText);
					// Select Business Unit
					businessUnit.selectByIndex(i);
					// Click on Go button
					button_GoOfSearch.click();
					// Get Size of list of Business Unit
					int sizeOfEngineerNameColumn = list_EngineerName.size();
					// Apply condition
					if (sizeOfEngineerNameColumn >= 1) {
						// Apply For Loop
						for (int j = 0; j < sizeOfEngineerNameColumn; j++) {
							// Get Name of list of Business Unit
							String businessUnitName = list_EngineerName.get(j).getText();
							// Print Name of list of Business Unit
							System.out.println("businessUnitName: " + businessUnitName);

							
							boolean businessUnitIsPresent = true;

							if ( businessUnitName.contains(businessUnitText)) {
								
								businessUnitIsPresent = true ;
							} else {
								businessUnitIsPresent = false;
							}

							// Verify Business Unit
							softAssert.assertTrue(businessUnitIsPresent,
									"Business Unit is not Same.");
						}
					}
				}
				
				softAssert.assertAll();
	}

}
