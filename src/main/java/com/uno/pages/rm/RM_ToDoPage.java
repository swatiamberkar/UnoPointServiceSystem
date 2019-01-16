package com.uno.pages.rm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;



public class RM_ToDoPage  extends BaseCode{
	

	

	

		// Add Button
		@FindBy(linkText = "Add+")
		WebElement button_AddPlus;

		// Assign To Drop down
		@FindBy(name = "m_strToDoChoice+")
		WebElement dropdown_AssignTo;

		// Target Date Text box
		@FindBy(css = "input[name='m_strTargetDate']")
		WebElement textbox_TargetDate;

		// Target Date calendar
		@FindBy(css = "a[id='fd-but-dp-2']")
		WebElement calendar_TargetDate;

		// Target Date hrs Drop down
		@FindBy(name = "m_strTargetTimeHour")
		WebElement dropdown_HrsOfTargetDate;

		// Target Date min Drop down
		@FindBy(name = "m_strTargetTimeMinute")
		WebElement dropdown_MinOfTargetDate;

		// Description Text box
		@FindBy(css = "textarea[name='m_strToDoDescription']")
		WebElement textbox_Description;

		// Add Button
		@FindBy(css = "a[onclick='AddToDo();']")
		WebElement button_Add;

		// List of Sr no
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(1)")
		List<WebElement> list_SrNo;

		// List of Assign By
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
		List<WebElement> list_AssignBy;

		// List of Assign To
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(3)")
		List<WebElement> list_AssignTo;

		// List of To Do
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(4)")
		List<WebElement> list_ToDo;

		// List of Assign Date
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(5)")
		List<WebElement> list_AssignDate;

		// List of Target Date
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(6)")
		List<WebElement> list_TargetDate;

		// List of SLA
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(7)>img")
		List<WebElement> list_SLA;

		// List of Status
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(8)")
		List<WebElement> list_Status;

		// List of Remark
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(9)")
		List<WebElement> list_Remark;
		
		// List of Target Date
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr")
		List<WebElement> list_Row;

		// To Do Pop up heading
		@FindBy(css = "div[id='box']>.box>table>tbody>tr>th:nth-of-type(2)")
		WebElement heading_ToDoPopup;
		
		// Close To Do Pop up heading
		
		@FindBy(css = "div[id='boxa']>.box>table>tbody>tr>th:nth-of-type(2)")
		WebElement heading_ClosedToDoPopup;

		// Target Date calendar
		@FindBy(css = ".datePickerTable>tbody>tr>td")
		List<WebElement> dayOfCalendar_TargetDate;

		// Notification of To Do Page
		@FindBy(css = "#dialogBoxSuccess")
		WebElement notification;
		
		// Open Button
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(8)>a")
		List<WebElement> list_OpenButton;
		
		// Remark Text box
		@FindBy(css = "textarea[name='m_strRemark']")
		WebElement textbox_Remark;
		
		// Submit Button
		@FindBy(css = "a[onclick='callCloseToDO();']")
		WebElement button_Submit;
		
		

		public RM_ToDoPage() {
			PageFactory.initElements(driver, this);

		}

		// 1. If User click on Add button then To Do pop up should display to create
		// new To Do task
		// 2. If User keep target date as blank and click on Add button then
		// notification should display as 'Please Enter Target Date'
		// 3. If User keep Description field as blank then notification should
		// display as 'Please Enter Description'
		// 4. After enter/select all mandatory details if user click on save button
		// then entry should get create in To do table and notification should
		// display as 'To Do Added Successfully...!'
		public void checkToDoPopup() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Click on Add+ button
			button_AddPlus.click();
			// Get the Heading of To Do Pop up
			String heading = heading_ToDoPopup.getText();
			// Print the Heading of To Do Pop up
			System.out.println("Heading of To Do Popup: " + heading);
			// Verify the Heading
			softAssert.assertEquals(heading, "To Do",
					"Heading of To Do Popup is not match");

			// Click on Add button
			button_Add.click();
			Thread.sleep(2000);
			// Handle alert
			Alert alert = driver.switchTo().alert();
			// Get text of Alert
			String alertOfTargetDate = alert.getText();
			// Print text of Alert
			System.out.println("Alert Of Target Date: " + alertOfTargetDate);
			// Verify the Alert message
			softAssert.assertEquals(alertOfTargetDate, "Please Enter Target Date",
					"Alert message is not match");
			// Click on OK button of Alert
			alert.accept();

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			// Get Day Of Month
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			// Print Day Of Month
			System.out.println("Day Of Month: " + dayOfMonth);
			// Convert into String
			String currentDay = Integer.toString(dayOfMonth);

			// Click on calendar of Target Date
			calendar_TargetDate.click();

			// Get all Dates in Calendar
			for (WebElement day : dayOfCalendar_TargetDate) {
				// Get day in Calendar
				String dayInCalendar = day.getText();
				// Compare Day In Calendar and Current Day
				if (dayInCalendar.equalsIgnoreCase(currentDay)) {
					Thread.sleep(500);
					// Select day
					day.click();
					// Get day in Calendar
					String getDateValue = day.getText();
					// Print day in Calendar
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// Click on Add button
			button_Add.click();
			Thread.sleep(2000);
			// Handle alert
			driver.switchTo().alert();
			// Get text of Alert
			String alertOfDescription = alert.getText();
			// Print text of Alert
			System.out.println("Alert Of Description: " + alertOfDescription);
			// Verify the Alert message
			softAssert.assertEquals(alertOfDescription, "Please Enter Description",
					"Alert message is not match");
			// Click on OK button of Alert
			alert.accept();

			// Enter Description
			String description = "Test";
			textbox_Description.sendKeys(description);

			// Click on Add button
			button_Add.click();

			// Get Notification
			String notificationText = notification.getText();
			// Print Notification
			System.out.println(notificationText);

			// Verify Notification
			softAssert.assertEquals(notificationText, "To Do Addeed Successfully...!",
					"Notification is not Match");
			
			softAssert.assertAll();
			
			

		}
		
		public void checkAssignByAndTo() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get size
			int size = list_TargetDate.size();
			// Print size
			System.out.println("Size: " + size);
			
			// Get last Assign By
			String assignBy = list_AssignBy.get(size - 1).getText();
			// Print last Assign By
			System.out.println("Assign By: " + assignBy);
			
			// Get last Assign By
			String assignTo = list_AssignTo.get(size - 1).getText();
			// Print last Assign By
			System.out.println("Assign To: " + assignTo);
			
			// Verify Assign By
			softAssert.assertEquals(assignBy, "NewRM1 .",
					"Assign By is not Match");
			// Verify Assign To
			softAssert.assertEquals(assignTo, "NewRM1 .",
							"Assign To is not Match");
			softAssert.assertAll();
			
		}
		
		public void checkStatusWhenAssignToSelf() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get size
			int size = list_OpenButton.size();
			// Print size
			System.out.println("Size: " + size);
			
			// Get size
			int sizeOfRemark = list_Remark.size();
			// Print size
			System.out.println("sizeOfRemark: " + sizeOfRemark);
			
			
			boolean status =list_OpenButton.get(size-1).isDisplayed();
			System.out.println(status);
			softAssert.assertTrue(status, "Open Button  is not Present.");
			list_OpenButton.get(size-1).click();
			
					// Get the Heading of To Do Pop up
					String heading = heading_ClosedToDoPopup.getText();
					// Print the Heading of To Do Pop up
					System.out.println("Heading of To Do Popup: " + heading);
					// Verify the Heading
					Assert.assertEquals(heading, "Close To Do",
							"Heading of To Do Popup is not match");
					
					// Enter Remark
					String remark = "Tested";
					textbox_Remark.sendKeys(remark);
					
					button_Submit.click();
					
					String  remarkInTable =list_Remark.get(sizeOfRemark-1).getText();
					System.out.println(remarkInTable);
					softAssert.assertEquals(remarkInTable,remark, "Open Button  is not Present.");
					
					String  statusInTable =list_Status.get(sizeOfRemark-1).getText();
					System.out.println(statusInTable);
					softAssert.assertEquals(statusInTable,"Closed", "Closed Status not get update.");
					softAssert.assertAll();
					
		
		}

		public void checkSLAFlagWithLessTime() throws Exception {

			SoftAssert softAssert = new SoftAssert();
			// Get size
			int size = list_TargetDate.size();
			// Print size
			System.out.println("Size: " + size);
			// Get Date in ATA Date Text box
			String datePattern = "yyyy-MM-dd HH:mm:ss";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);
			// Get last Target Date
			String targetDate = list_TargetDate.get(size - 1).getText();
			// Print last Target Date
			System.out.println("Target Date: " + targetDate);

			// Convert into Date format
			Date applicationTime = (Date) dateFormat.parse(targetDate);
			System.out.println(applicationTime);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String systemDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(calendar.getTime());
			System.out.println("System Date:" + systemDate);

			// Convert into Date format
			Date systemTime = (Date) dateFormat.parse(systemDate);
			System.out.println(systemTime);

			// Compare Application Time And System Time
			if (applicationTime.compareTo(systemTime) > 0) {
				// Display Message
				System.out.println("Application Time is Greter than System Time\n");
				// Get SLA Color
				String flag = list_SLA.get(size - 1).getAttribute("alt");
				// Print SLA Color
				System.out.println("Flag: " + flag);
				// Verify Flag
				softAssert.assertEquals(flag, "Cold", "Flag is not Match");

			}
				// Compare Application Time And System Time
			else if (applicationTime.compareTo(systemTime) <= 0) {
				// Display Message
				System.out.println("Application Time is Less than System Time\n");
				// Get SLA Color
				String flag = list_SLA.get(size - 1).getAttribute("alt");
				// Print SLA Color
				System.out.println("Flag: " + flag);
				// Verify Flag
				softAssert.assertEquals(flag, "Violated", "Flag is not Match");

			}
			softAssert.assertAll();
		}


		public void checkSLAFlagWithGreaterTime() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			// Click on Add+ button
			button_AddPlus.click();

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			// Get Day Of Month
			int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
			// Print Day Of Month
			System.out.println("Day Of Month: " + dayOfMonth);
			// Convert into String
			String currentDay = Integer.toString(dayOfMonth);
			
			int nxtDay = Integer.parseInt(currentDay) + 1;
			String nextDay = Integer.toString(nxtDay);

			// Click on calendar of Target Date
			calendar_TargetDate.click();

			// Get all Dates in Calendar
			for (WebElement day : dayOfCalendar_TargetDate) {
				// Get day in Calendar
				String dayInCalendar = day.getText();
				// Compare Day In Calendar and Current Day
				if (dayInCalendar.equalsIgnoreCase(nextDay)) {
					Thread.sleep(500);
					// Select day
					day.click();
					// Get day in Calendar
					String getDateValue = day.getText();
					// Print day in Calendar
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			// Enter Description
			String description = "Test";
			textbox_Description.sendKeys(description);

			// Click on Add button
			button_Add.click();

			// Get size
			int size = list_TargetDate.size();
			// Print size
			System.out.println("Size: " + size);
			// Get Date in ATA Date Text box
			String datePattern = "yyyy-MM-dd HH:mm:ss";
			DateFormat dateFormat = new SimpleDateFormat(datePattern);
			// Get last Target Date
			String targetDate = list_TargetDate.get(size - 1).getText();
			// Print last Target Date
			System.out.println("Target Date: " + targetDate);

			// Convert into Date format
			Date applicationTime = (Date) dateFormat.parse(targetDate);
			System.out.println(applicationTime);

			// Get System Time
			Calendar calendar = Calendar.getInstance();
			String systemDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(calendar.getTime());
			System.out.println("System Date:" + systemDate);

			// Convert into Date format
			Date systemTime = (Date) dateFormat.parse(systemDate);
			System.out.println(systemTime);

			// Compare Application Time And System Time
			if (applicationTime.compareTo(systemTime) > 0) {
				// Display Message
				System.out.println("Application Time is Greter than System Time\n");
				// Get SLA Color
				String flag = list_SLA.get(size - 1).getAttribute("alt");
				// Print SLA Color
				System.out.println("Flag: " + flag);
				// Verify Flag
				softAssert.assertEquals(flag, "Cold", "Flag is not Match");

			}
				// Compare Application Time And System Time
			else if (applicationTime.compareTo(systemTime) <= 0) {
				// Display Message
				System.out.println("Application Time is Less than System Time\n");
				// Get SLA Color
				String flag = list_SLA.get(size - 1).getAttribute("alt");
				// Print SLA Color
				System.out.println("Flag: " + flag);
				// Verify Flag
				softAssert.assertEquals(flag, "Violated", "Flag is not Match");

			}
			softAssert.assertAll();
		}
	
	}




