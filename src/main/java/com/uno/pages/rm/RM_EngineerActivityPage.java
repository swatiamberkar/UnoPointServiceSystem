package com.uno.pages.rm;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.uno.baseClass.BaseCode;



public class RM_EngineerActivityPage extends BaseCode{

	
	RM_EngineerActivityPage rm_EngineerActivityPage;
		/*SD_HomePage homePageOfSdRole;
		SD_LoginPage loginPageOfSdRole;
		
		// call the method from super role
			Super_LoginPage loginPageOfSuperRole;
			Super_HomePage homePageOfSuperRole;
			Super_SDMasterPage sDmasterPageOfSuperRole;
			Super_TicketMasterPage ticketMasterPageOfSuperRole;
			Super_TicketTypePage ticketTypePageOfSuperRole;
			Super_EmpolyeeMasterPage empolyeeMasterPageOfSuperRole;
			Super_CustomerDetailsPage customerDetailsPageOfSuperRole;
			Super_CustomerMasterPage  customerMasterPageOfSuperRole;
			Super_BusinessUnitMasterPage businessUnitMasterPageOfSuperRole;
			*/
			

		public static int dateRange = 1;
		public static String incTypeInEngineerActivity = null;
		public static String customerInEngineerActivity = null;
		public static String businessUnitInEngineerActivity = null;

		// Date Range Drop down
		@FindBy(css = "select[name='m_strDateRange']")
		WebElement dropdown_DateRange;

		// Region Drop down
		@FindBy(css = "select[name='m_strRegion']")
		WebElement dropdown_Region;

		// State Drop down
		@FindBy(css = "select[name='m_strState']")
		WebElement dropdown_State;

		// Engineer Drop down
		@FindBy(css = "select[name='m_strEngList']")
		WebElement dropdown_Engineer;

		// Inc Type Drop down
		@FindBy(css = "select[name='m_strIncType']")
		WebElement dropdown_IncType;

		// Status Drop down
		@FindBy(css = "select[name='m_strStatus']")
		WebElement dropdown_Status;

		// Customer Drop down
		@FindBy(css = "select[name='m_strCustomerName']")
		WebElement dropdown_Customer;

		// Customer Drop down
		@FindBy(css = "select[name='m_strCustomerName']>option")
		WebElement dropdown_CustomerOptions;

		// Business Unit Drop down
		@FindBy(css = "select[name='m_strBusinessUnit']")
		WebElement dropdown_BusinessUnit;

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

		// Go Button
		@FindBy(css = "a[onclick= 'GoForSearch()']")
		WebElement button_Go;

		// list of Row
		@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr")
		List<WebElement> list_Row;

		// list of Engineer
		@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(1)")
		List<WebElement> list_Engineer;

		// list of State
		@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(8)")
		List<WebElement> list_State;

		// list of Inc Type
		@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(10)")
		List<WebElement> list_IncType;

		// list of Log Date/Time
		@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(12)")
		List<WebElement> list_LogDateTime;

		// Label of Total Record
		@FindBy(css = "div[id='right']>div>table>tbody>tr>td:nth-of-type(2)>b")
		WebElement label_TotalRecord;

		// list of Customer
		@FindBy(css = "div[class='fht-fixed-body']>div:nth-of-type(2)>table >tbody>tr>td:nth-of-type(28)")
		List<WebElement> list_Customer;

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
		public RM_EngineerActivityPage() {
			PageFactory.initElements(driver, this);
		}

		public void verifyEngineerAccordingSelectedEngineer() {
			// Get Engineer Drop down
			Select select = new Select(dropdown_Engineer);
			// Select Engineer
			select.selectByVisibleText("NewRM1 .");

			// Click on Go button
			button_Go.click();

			// Get Size of engineer in table
			int size = list_Engineer.size();
			// Print Size of engineer in table
			System.out.println("size: " + size);
			// Apply For loop
			for (int i = 0; i < size; i++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);", list_Engineer.get(i));
				// Get name of Engineer
				String engineer = list_Engineer.get(i).getText();
				// Print name of Engineer
				System.out.println("Engineer: " + engineer);
				// Verify Engineer
				Assert.assertEquals(engineer, "NewRM1 .");
			}
		}

		public void checkFromAndToDateAccordingSelectedDateRange() throws Exception {

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
					Assert.assertEquals(fromDate, todayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Verify To Date
					Assert.assertEquals(toDate, todayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Click on Go button
					button_Go.click();
					Thread.sleep(1000);
					// Get size of Log Date Time
					int sizeOfLogDateTime = list_LogDateTime.size();
					// Print size of Log Date Time
					System.out.println("size: " + sizeOfLogDateTime);
					// Compare size
					if (sizeOfLogDateTime == 0) {
						// Update Date Range
						dateRange = dateRange + 1;
						// Call Engineer Activity Page Of Sd Role
						rm_EngineerActivityPage = new RM_EngineerActivityPage();
						// call checkFromAndToDateAccordingSelectedDateRange Method
						rm_EngineerActivityPage
								.checkFromAndToDateAccordingSelectedDateRange();
						Thread.sleep(500);
					}
					for (int i = 0; i < sizeOfLogDateTime; i++) {

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_LogDateTime.get(i));
						// Get Log Date Time
						String LogDateTime = list_LogDateTime.get(i).getText();
						// Print Log Date Time
						System.out.println("LogDateTime: " + LogDateTime);
						// Get only Log Date
						String LogDateAndTime = LogDateTime.split(" ")[0];
						// Print Log Date
						System.out.println("LogDateAndTime: " + LogDateAndTime);
						// Verify Date
						Assert.assertEquals(LogDateAndTime, todayDate,
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
					Assert.assertEquals(fromDate, yesterdayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Verify To Date
					Assert.assertEquals(toDate, yesterdayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Click on Go button
					button_Go.click();
					Thread.sleep(1000);
					// Get size of Log Date Time
					int sizeOfLogDateTime = list_LogDateTime.size();
					// Print size of Log Date Time
					System.out.println("size: " + sizeOfLogDateTime);
					// Compare size
					if (sizeOfLogDateTime == 0) {
						// Update Date Range
						dateRange = dateRange + 1;
						// Call Engineer Activity Page Of Sd Role
						rm_EngineerActivityPage = new RM_EngineerActivityPage();
						// call checkFromAndToDateAccordingSelectedDateRange Method
						rm_EngineerActivityPage
								.checkFromAndToDateAccordingSelectedDateRange();
						Thread.sleep(500);
					}
					for (int i = 0; i < sizeOfLogDateTime; i++) {

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_LogDateTime.get(i));
						// Get Log Date Time
						String LogDateTime = list_LogDateTime.get(i).getText();
						// Print Log Date Time
						System.out.println("LogDateTime: " + LogDateTime);
						// Get only Log Date
						String LogDateAndTime = LogDateTime.split(" ")[0];
						// Print Log Date
						System.out.println("LogDateAndTime: " + LogDateAndTime);
						// Verify Date
						Assert.assertEquals(LogDateAndTime, yesterdayDate,
								"Log Date And Time is not same");
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
					Assert.assertEquals(fromDate, lastSevenDaysDate,
							"Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Verify To Date
					Assert.assertEquals(toDate, todayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Click on Go button
					button_Go.click();
					Thread.sleep(1000);
					// Get size of Log Date Time
					int sizeOfLogDateTime = list_LogDateTime.size();
					// Print size of Log Date Time
					System.out.println("size: " + sizeOfLogDateTime);
					// Compare size
					if (sizeOfLogDateTime == 0) {
						// Update Date Range
						dateRange = dateRange + 1;
						// Call Engineer Activity Page Of Sd Role
						rm_EngineerActivityPage = new RM_EngineerActivityPage();
						// call checkFromAndToDateAccordingSelectedDateRange Method
						rm_EngineerActivityPage
								.checkFromAndToDateAccordingSelectedDateRange();
						Thread.sleep(500);
					}
					for (int i = 0; i < sizeOfLogDateTime; i++) {

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_LogDateTime.get(i));
						// Get Log Date Time
						String LogDateTime = list_LogDateTime.get(i).getText();
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
						Assert.assertTrue(dateIsPresent,
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
					Assert.assertEquals(fromDate, lastThirtyDaysDate,
							"Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Verify To Date
					Assert.assertEquals(toDate, todayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Click on Go button
					button_Go.click();
					Thread.sleep(1000);
					// Get size of Log Date Time
					int sizeOfLogDateTime = list_LogDateTime.size();
					// Print size of Log Date Time
					System.out.println("size: " + sizeOfLogDateTime);
					// Compare size
					if (sizeOfLogDateTime == 0) {
						// Update Date Range
						dateRange = dateRange + 1;
						// Call Engineer Activity Page Of Sd Role
						rm_EngineerActivityPage = new RM_EngineerActivityPage();
						// call checkFromAndToDateAccordingSelectedDateRange Method
						rm_EngineerActivityPage
								.checkFromAndToDateAccordingSelectedDateRange();
						Thread.sleep(500);
					}
					for (int i = 0; i < sizeOfLogDateTime; i++) {

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_LogDateTime.get(i));
						// Get Log Date Time
						String LogDateTime = list_LogDateTime.get(i).getText();
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
						Assert.assertTrue(dateIsPresent,
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
					Assert.assertEquals(fromDate, todayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Verify To Date
					Assert.assertEquals(toDate, todayDate, "Date is not Same");
					// display Message
					System.out.println("Display same Date.");

					// Click on Go button
					button_Go.click();
					Thread.sleep(1000);
					// Get size of Log Date Time
					int sizeOfLogDateTime = list_LogDateTime.size();
					// Print size of Log Date Time
					System.out.println("size: " + sizeOfLogDateTime);
					// Compare size
					if (sizeOfLogDateTime == 0) {
						// Update Date Range
						dateRange = dateRange + 1;
						// Call Engineer Activity Page Of Sd Role
						rm_EngineerActivityPage = new RM_EngineerActivityPage();
						// call checkFromAndToDateAccordingSelectedDateRange Method
						rm_EngineerActivityPage
								.checkFromAndToDateAccordingSelectedDateRange();
						Thread.sleep(500);
					}
					for (int i = 0; i < sizeOfLogDateTime; i++) {

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								list_LogDateTime.get(i));
						// Get Log Date Time
						String LogDateTime = list_LogDateTime.get(i).getText();
						// Print Log Date Time
						System.out.println("LogDateTime: " + LogDateTime);
						// Get only Log Date
						String LogDateAndTime = LogDateTime.split(" ")[0];
						// Print Log Date
						System.out.println("LogDateAndTime: " + LogDateAndTime);
						// Verify Date
						Assert.assertEquals(LogDateAndTime, todayDate,
								"Log Date And Time is not same");
					}

				}
				// Update Date Range
				dateRange = dateRange + 1;
				// Call Engineer Activity Page Of Sd Role
				rm_EngineerActivityPage = new RM_EngineerActivityPage();
				// call checkFromAndToDateAccordingSelectedDateRange Method
				rm_EngineerActivityPage
						.checkFromAndToDateAccordingSelectedDateRange();
				Thread.sleep(500);

			}
		}

		public void verifyStateAccordingSelectedState() throws Exception {

			// Get Region Drop down
			Select selectRegion = new Select(dropdown_Region);
			// Select Region
			selectRegion.selectByVisibleText("West");

			// Get State Drop down
			Select selectState = new Select(dropdown_State);
			// Select State
			selectState.selectByVisibleText("Maharashtra");

			/*// Get Engineer Drop down
			Select select = new Select(dropdown_Engineer);
			// Select Engineer
			select.selectByVisibleText("NewRM1 . ");*/

			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// Click on Go button
			button_Go.click();

			Thread.sleep(1000);
			// Get Size of engineer in table
			int size = list_State.size();
			// Print Size of State in table
			System.out.println("size: " + size);
			// Apply For loop
			for (int i = 0; i < size; i++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);", list_State.get(i));
				// Get name of State
				String state = list_State.get(i).getText();
				// Print name of State
				System.out.println("State: " + state);
				boolean stateIsSame = true;
				// Verify State
				if (state.equalsIgnoreCase("Maharashtra")) {
					stateIsSame = true;
				} else {
					stateIsSame = false;
				}
				Assert.assertTrue(stateIsSame, "State is not Same.");

			}
		}

		public void verifyTotalRecordsAccordingDisplayRow() {

			// Get Size of Row in table
			int size = list_Row.size();
			// Print Size of Row in table
			System.out.println("size: " + size);
			// Convert into String
			String sizeOfRow = Integer.toString(size);
			// Get Total Record
			String record = label_TotalRecord.getText();
			// Split only Integer value from Total Record
			String totalRecord = record.split(" ")[3];
			// Print Integer value from Total Record
			System.out.println("totalRecord: " + totalRecord);
			// Verify Total Record
			Assert.assertEquals(totalRecord, sizeOfRow,
					"Total Record size is not Same.");

		}

		public void verifyIncTypeAccordingSelectedSIncType() throws Exception {

			/*// Get Region Drop down
			Select selectRegion = new Select(dropdown_Region);
			// Select Region
			selectRegion.selectByVisibleText("West");
*/
			// Get State Drop down
			Select selectState = new Select(dropdown_State);
			// Select State
			selectState.selectByVisibleText("Maharashtra");

			// Get IncType Drop down
			Select selectIncType = new Select(dropdown_IncType);
			// Select IncType
			selectIncType.selectByVisibleText("BW");

			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// Click on Go button
			button_Go.click();

			Thread.sleep(1000);
			// Get Size of engineer in table
			int size = list_IncType.size();
			// Print Size of State in table
			System.out.println("size: " + size);
			// Apply For loop
			for (int i = 0; i < size; i++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);", list_IncType.get(i));
				// Get name of State
				String incType = list_IncType.get(i).getText();
				// Print name of State
				System.out.println("incType: " + incType);

				boolean incTypeIsSame = true;
				// Compare Inc Type
				if (incType.equalsIgnoreCase("BW")) {
					incTypeIsSame = true;
				} else {
					incTypeIsSame = false;
				}

				// Verify Inc Type
				Assert.assertTrue(incTypeIsSame, "Inc Type is not Same.");

			}
		}

		public void verifyCustomerAccordingSelectedCustomer() throws Exception {

			// Get Customer Drop down
			Select selectIncType = new Select(dropdown_Customer);
			// Select Customer
			selectIncType.selectByVisibleText("NewCust1");

			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			// Click on Go button
			button_Go.click();

			Thread.sleep(1000);
			// Get Size of Customer in table
			int size = list_Customer.size();
			// Print Size of Customer in table
			System.out.println("size: " + size);
			// Apply For loop
			for (int i = 0; i < size; i++) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);", list_Customer.get(i));
				// Get name of Customer
				String customer = list_Customer.get(i).getText();
				// Print name of Customer
				System.out.println("Customer: " + customer);

				boolean customerIsSame = true;

				// Compare Customer
				if (customer.equalsIgnoreCase("NewCust1")) {
					customerIsSame = true;
				} else {
					customerIsSame = false;
				}

				// Verify Customer
				Assert.assertTrue(customerIsSame, "Customer is not Same.");

			}
		}

	/*	public void verifyIncTypeCustomerAndBUInSuperRole() throws Exception {
			dropdown_IncType.click();
			
			incTypeInEngineerActivity = dropdown_IncType.getText();
			System.out.println("IncType: " + incTypeInEngineerActivity);

			dropdown_Customer.click();
			customerInEngineerActivity = dropdown_Customer.getText();
			System.out.println("customer: " + customerInEngineerActivity);

			dropdown_BusinessUnit.click();
			businessUnitInEngineerActivity = dropdown_BusinessUnit.getText();
			System.out.println("BusinessUnit: " + businessUnitInEngineerActivity);

			link_sd.click();
			Thread.sleep(1000);

			// click on logout
			link_LogOut.click();
			
			loginPageOfSuperRole =new Super_LoginPage();
			homePageOfSuperRole = loginPageOfSuperRole.Login(
					properties.getProperty("loginIdForSuper"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			sDmasterPageOfSuperRole=homePageOfSuperRole.clickSdMasterlink();
			Thread.sleep(1000);
			ticketMasterPageOfSuperRole=sDmasterPageOfSuperRole.clickOnTicketMasterLink();
			Thread.sleep(1000);
			ticketTypePageOfSuperRole=ticketMasterPageOfSuperRole.clickOnTicketTypeLink();
			
			int sizeOfTicketType=ticketTypePageOfSuperRole.list_TicketType.size();
			for(int i=0; i<sizeOfTicketType; i++)
			{
				String ticketType= ticketTypePageOfSuperRole.list_TicketType.get(i).getText();
				System.out.println("Ticket Type: "+ticketType);	
				
				Assert.assertTrue(incTypeInEngineerActivity.contains(ticketType),"Ticket Type is not Same.");
			}
			
			homePageOfSuperRole= new Super_HomePage();
			sDmasterPageOfSuperRole=homePageOfSuperRole.clickSdMasterlink();
			Thread.sleep(1000);
			businessUnitMasterPageOfSuperRole=sDmasterPageOfSuperRole.clickOnBusinessUnitMasterLink();
			
			int sizeofBusinessUnit=businessUnitMasterPageOfSuperRole.list_BusinessUnit.size();
			for(int i=0; i<sizeofBusinessUnit; i++)
			{
				String businessUnit= businessUnitMasterPageOfSuperRole.list_BusinessUnit.get(i).getText();
				System.out.println("BusinessUnit: "+businessUnit);
				
				Assert.assertTrue(businessUnitInEngineerActivity.contains(businessUnit),"Business Unit is not Same.");
			}
			
			
			homePageOfSuperRole= new Super_HomePage();
			empolyeeMasterPageOfSuperRole=homePageOfSuperRole.clickEmpolyeeMasterlink();
			Thread.sleep(1000);
			customerDetailsPageOfSuperRole=empolyeeMasterPageOfSuperRole.clickOnCustomerDetailLink();
			Thread.sleep(1000);
			customerMasterPageOfSuperRole=customerDetailsPageOfSuperRole.clickOncustMaster();
			
			int sizeofCustomer=customerMasterPageOfSuperRole.list_Customer.size();
			for(int i=0; i<sizeofCustomer; i++)
			{
				String customer= customerMasterPageOfSuperRole.list_Customer.get(i).getText();
				System.out.println("Customer: "+customer);
				Assert.assertTrue(customerInEngineerActivity.contains(customer),"Customer is not Same.");
			}
			
			
			link_Test.click();
			Thread.sleep(1000);

			// click on logout
			link_LogOut.click();
			
			loginPageOfSdRole = new SD_LoginPage();
			homePageOfSdRole = loginPageOfSdRole.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			
			homePageOfSdRole = new SD_HomePage();

		}
		*/

	}

