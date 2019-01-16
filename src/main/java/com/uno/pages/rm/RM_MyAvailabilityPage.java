package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.uno.test.rm.RM_MyAvailabilityTest;
import com.uno.test.superrole.Super_EmployeeMasterTest;

public class RM_MyAvailabilityPage extends BaseCode 
{
	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_MyAvailabilityTest rm_MyAvailabilityTest;
	RM_AttendancePage rm_AttendancePage;
	RM_MyAvailabilityPage rm_MyAvailabilityPage;
	
	//Call method from super login
	Super_EmployeeMasterTest super_EmployeeMasterPageTest;
	Super_EmployeeDetailPage super_EmployeeDetailPage;
	

	// Select RM tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement tabRM;

	// Select RM tab for logout tab
	@FindBy(linkText = "Test")
	WebElement tabTest;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// Heading of ticket form
	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement lblHeading;
	
	//Get value of total Opening Balance
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[1]")
	WebElement lblTotalOpeningBalance;
	
	//Get value of Privilege Leave Taken For This Month
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[2]")
	WebElement lblPrevilageLeaveTaken;
	
	//Get value of Sick Leave Taken For This Month
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[3]")
	WebElement lblSickLeaveTaken;

	//Get Total Closing Balance
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[4]")
	WebElement lblTotalClosingBalance;
	
	// Click on My Availability
	@FindBy(xpath = ".//*[@id='headingText']/ul/li/a")
	WebElement btnUpdateAvailability;
	
	// select drop down of availability 
	@FindBy(name = "m_strMyAvailability")
	WebElement ddlAvailability;
	
	// select drop down of early out reason 
	@FindBy(name = "m_strEarlyOutReason")
	WebElement ddlEarlyOutReason;
	
	// select drop down of leave type 
	@FindBy(name = "m_strLeaveType")
	WebElement ddlLeaveType;
	
	// select from date 
	@FindBy(name = "m_strFromDate")
	WebElement txtFromDate;
	
	// select from date button 
	@FindBy(xpath = ".//*[@id='fd-but-dp-1']/span[1]")
	WebElement calendarFromDate;
	
	// select date from date calendar 
	@FindBy(xpath = ".//*[@id='fd-dp-1']/table/tbody/tr/td")
	List<WebElement> dtpInFromDate;
	
	// select To date 
	@FindBy(name = "m_strToDate")
	WebElement txtToDate;
	
	// select To date button 
	@FindBy(xpath = ".//*[@id='fd-but-dp-2']/span[1]")
	WebElement calendarToDate;
		
	// select date from date calendar 
	@FindBy(xpath = ".//*[@id='fd-dp-2']/table/tbody/tr/td")
	List<WebElement> dtpInToDate;
		
	// select save button
	@FindBy(className = "saveBtn")
	WebElement btnSave;
	
	// select save button
	@FindBy(xpath = ".//*[@id='dialogBoxSuccess']")
	WebElement notification;
	
	//select Availability in table
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[3]")
	List<WebElement> lstAvailability;
	
	//select Availability in table
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[5]")
	List<WebElement> lstLoginDateTime;
	
	//select Availability in table
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[6]")
	List<WebElement> lstLogoutStatus;
	
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[7]")
	List<WebElement> lstLogoutDateTime;
	
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[8]")
	List<WebElement> lstEarlyOutReason;

	
	
	// Initializing Page Object
	public RM_MyAvailabilityPage() 
	{
		PageFactory.initElements(driver, this);
	}

	// If User click on My Availability tab, then View My Availability page
	// should get open with last login details .
	public void checkHeadingOfPage()
	{
		//check the heading of View My Availability
		String viewMyAvailability = lblHeading.getText();
		System.out.println("HeadingName: "+viewMyAvailability);
		
		assertEquals(viewMyAvailability, "View My Availability", "page heading is not match");
		
		
	}
	
	// In Total Opening Balance Of This Month column value should display as per
	// Total leaves assign in employee master -> employee Details for employee login.
	public void matchTotalOpeningBalanceWithSuperRole() throws Exception 
	{
      //get the value from Total Opening Balance Of This Month.
	  String valueOfTotalOpeningBalance = lblTotalOpeningBalance.getText();
	  System.out.println("valueOfTotalOpeningBalance: "+valueOfTotalOpeningBalance);

	  //logout from RM
	  tabRM.click();
	  
	  Thread.sleep(200);
	  tabLogOut.click();
	  
	  //get value from super login -> Employee Master -> Employee Details
	  super_EmployeeMasterPageTest = new Super_EmployeeMasterTest();
	  super_EmployeeMasterPageTest.Setup();
	  super_EmployeeMasterPageTest.ClickOnEmpolyeeDetailLink();
	  super_EmployeeDetailPage = new Super_EmployeeDetailPage();
	  super_EmployeeDetailPage.clickOnUpdateInRM();
	  String totalLeaveValue = Super_EmployeeDetailPage.totalLeave;
	  System.out.println("totalLeaveValue: "+totalLeaveValue);
	  
	  driver.findElement(By.xpath(".//*[@id='boxz']/div/table/tbody/tr[1]/th[3]/img")).click();
	
	  //logout from RM
	  tabTest.click();
	  
	  Thread.sleep(200);
	  tabLogOut.click();
	  
	  //match both the value is same
	  assertEquals(valueOfTotalOpeningBalance, totalLeaveValue+".0", "The value is not same");
	  

		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));

		
	}
	//1.If User click on Update availability button then My Availability pop up should display with availability list
	//2.If User select login and click on Save button then pop up should display was 'Do you want to save changes?' and after click on ok button, latest login entry should display in Availability table login date and time and notification should display as 'Availability updated successfully.'
	public void checkWithLoginSelect() throws Exception
	{
    	SoftAssert softAssert = new SoftAssert();
    	//click on update Availability
		btnUpdateAvailability.click();
		
		//get my availability pop up
		String  getPopUpMessage = driver.findElement(By.xpath(".//*[@id='box']/div/table/tbody/tr[1]/th[1]")).getText();
		System.out.println("getPopUpMessage: "+getPopUpMessage);
		
		softAssert.assertEquals(getPopUpMessage, "My Availability", "The pop up is different");
		
		Thread.sleep(200);
		//click on save button
		btnSave.click();
		
		//without select check Alert message
		Alert availabilityAlert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String messageWithoutAvailability = availabilityAlert.getText();
		System.out.println("Alert Text:" + messageWithoutAvailability);
		availabilityAlert.accept();
		
		softAssert.assertEquals(messageWithoutAvailability, "Please select Availability");
		
		Thread.sleep(200);
		
		//select Login 
		Select login = new Select (ddlAvailability);
		login.selectByVisibleText("Login");
		
		
		//get value from Availability drop down
		String availability = ddlAvailability.getAttribute("value");
		System.out.println("availability: "+availability);
		
		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
		//click on save button
		btnSave.click();
				
		Alert message = driver.switchTo().alert();
		String saveChangePopUpMessage = message.getText();
		System.out.println("Alert Text:" + saveChangePopUpMessage);
		message.accept();
		
		//get message after select login 
		String notificationMessage = notification.getText();
		System.out.println("notificationMessage: "+notificationMessage);
		
		softAssert.assertEquals(notificationMessage, "Availability updated successfully.", "Notification Message is diffrent , Perhaps the Login is not done");
		
		//get the value from table
		int sizeOfAvailability = lstAvailability.size();
    	String availabilityValueInTable = lstAvailability.get(sizeOfAvailability-1).getText();
		System.out.println("availabilityValueInTable: "+availabilityValueInTable);
		
		softAssert.assertEquals(availabilityValueInTable, availability, "The Table Value Is Different");
		
    	//get current date time
		Date date = new Date();
		System.out.println(date);
		String datePattern = "yyyy-MM-dd HH:mm";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		String DateAndTime = dateFormat.format(date);
		System.out.println("DateAndTime:- " + DateAndTime);
		
		//get Login Date and Time
		int sizeOfLoginDateTime = lstLoginDateTime.size();
    	String loginDateTime = lstLoginDateTime.get(sizeOfLoginDateTime-1).getText();
    	System.out.println(loginDateTime);
	
    	Date formatLoginDateTime = dateFormat.parse(loginDateTime);
    	String loginDateTimeValue = dateFormat.format(formatLoginDateTime);
		System.out.println("loginDateTimeValue: "+loginDateTimeValue);
		
		softAssert.assertEquals(loginDateTimeValue, DateAndTime, "The Table Value Is Different");
						
		softAssert.assertAll();
		
	}
	
	//1.If User select logout option then in My Availability pop up 'Early out Reason' field  should display with list
    //2.If User select Early out Reason and click on save button for logout availability then same should display in availability column with logout date/time and selected early out reason and notification should display as 'Out Time updated successfully.' 
	public void checkWithLogoutSelect() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		// click on update Availability
		btnUpdateAvailability.click();

		Thread.sleep(200);
		// select Login
		Select login = new Select(ddlAvailability);
		login.selectByVisibleText("Logout");
		
		//get value from Availability drop down
		String availability = ddlAvailability.getAttribute("value");
		System.out.println("availability: "+availability);

		Thread.sleep(1000);
		boolean earlyOutReasonIsPresent = ddlEarlyOutReason.isDisplayed();
		softAssert.assertTrue(earlyOutReasonIsPresent,
				"The Early Out Reason Is Not Present");
		
		Select earlyOutReason = new Select(ddlEarlyOutReason);
		earlyOutReason.selectByVisibleText("Personal Reason");
		

		//get value from Availability drop down
		String earlyOutReasonValue = ddlEarlyOutReason.getAttribute("value");
		System.out.println("earlyOutReasonValue: "+earlyOutReasonValue);
		
		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
        // click on save button
		btnSave.click();

		Thread.sleep(1000);
		Alert message = driver.switchTo().alert();
		String saveChangePopUpMessage = message.getText();
		System.out.println("Alert Text:" + saveChangePopUpMessage);
		message.accept();
		
		//get message after select login 
		String notificationMessage = notification.getText();
		System.out.println("notificationMessage: "+notificationMessage);
		
		softAssert.assertEquals(notificationMessage, "Out Time updated successfully.", "Notification Message is diffrent , Perhaps the Logout is not done");

		//get the value from table
		int sizeOfLogoutStatusValue = lstLogoutStatus.size();
	  	String logoutStatusValueInTable = lstLogoutStatus.get(sizeOfLogoutStatusValue-1).getText();
		System.out.println("availabilityValueInTable: "+logoutStatusValueInTable);
		
	    softAssert.assertEquals(logoutStatusValueInTable, availability, "The Table Value Is Different");
	    
		// get current date time
		Date date = new Date();
		System.out.println(date);
		String datePattern = "yyyy-MM-dd HH:mm";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		String DateAndTime = dateFormat.format(date);
		System.out.println("DateAndTime:- " + DateAndTime);

		// get Login Date and Time
		int sizeOfLogoutDateTime = lstLogoutDateTime.size();
		String logoutDateTime = lstLogoutDateTime.get(sizeOfLogoutDateTime - 1)
				.getText();
		System.out.println(logoutDateTime);

		Date formatLogoutDateTime = dateFormat.parse(logoutDateTime);
		String logoutDateTimeValue = dateFormat.format(formatLogoutDateTime);
		System.out.println("loginDateTime: " + logoutDateTimeValue);

		softAssert.assertEquals(logoutDateTimeValue, DateAndTime,
				"The Table Value Is Different");
		
		int sizeOfEarlyOutReasonValue = lstEarlyOutReason.size();
	  	String earlyOutReasonValueInTable = lstEarlyOutReason.get(sizeOfEarlyOutReasonValue-1).getText();
		System.out.println("availabilityValueInTable: "+earlyOutReasonValueInTable);
		
	    softAssert.assertEquals(earlyOutReasonValueInTable, earlyOutReasonValue, "The Table Value Is Different");

		softAssert.assertAll();

	}
	//1.If user select leave in availability list then Leave type field should display with from date and To date also
	//2.If User select availability as 'Leave' and select all details then after save changes, notification should display as 'Availability updated successfully.' and availability  should display as 'Leave'.
	public void checkWithLeaveForPresentDaySelect() throws Exception 
	{

		// logout from RM
		tabRM.click();

		Thread.sleep(200);
		tabLogOut.click();


		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginidForSecondRM"),
				properties.getProperty("password"));
		
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_MyAvailabilityPage = rm_AttendancePage.myAvailabilityTab();
		
		SoftAssert softAssert = new SoftAssert();
		
    	//click on update Availability
		btnUpdateAvailability.click();

		// select Login
		Select leave = new Select(ddlAvailability);
		leave.selectByVisibleText("Leave");

		// get value from Availability drop down
		String availability = ddlAvailability.getAttribute("value");
		System.out.println("availability: " + availability);

		
		Thread.sleep(1000);
		boolean leaveTypeIsPresent = ddlLeaveType.isDisplayed();
		softAssert.assertTrue(leaveTypeIsPresent,
				"The Leave Type Is Not Present");
		
		Select leaveType = new Select(ddlLeaveType);
		leaveType.selectByVisibleText("Previlage Leave");
		

		//get value from Availability drop down
		String leaveTypeValue = ddlLeaveType.getAttribute("value");
		System.out.println("leaveTypeValue: "+leaveTypeValue);
		
		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
		//click on save button
		btnSave.click();
		
		//without select form and to dates check Alert message
		Alert dateAlert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String messageWithoutSelectingDate = dateAlert.getText();
		System.out.println("Alert Text:" + messageWithoutSelectingDate);
		dateAlert.accept();
		
		softAssert.assertEquals(messageWithoutSelectingDate, "Invalid Date");
		
		Thread.sleep(2000);
		
		//select Form and To date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);
		calendarFromDate.click();
		// select Date in Calendar

		for (WebElement day : dtpInFromDate) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-"
						+ getDateValue);

				break;
			}

		}
		
		Thread.sleep(1000);
		calendarToDate.click();

		for (WebElement day : dtpInToDate) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {
				
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-"
						+ getDateValue);

				break;
			}

		}
		
		String fromDate = txtFromDate.getAttribute("value");
		System.out.println("fromDate: "+fromDate);
		
		String toDate = txtToDate.getAttribute("value");
		System.out.println("toDate: "+toDate);
		
		driver.manage().timeouts()
		.pageLoadTimeout(60, TimeUnit.SECONDS);
		//click on save button
		btnSave.click();
		
		Alert messageOfValidDate = driver.switchTo().alert();
		String validDate = messageOfValidDate.getText();
		System.out.println("Alert Text:" + validDate);
		messageOfValidDate.accept();
		
		softAssert.assertEquals(validDate, "Valid Date", "valid date pop up massage is not same");
				
		Alert message = driver.switchTo().alert();
		String saveChangePopUpMessage = message.getText();
		System.out.println("Alert Text:" + saveChangePopUpMessage);
		message.accept();
		
		//get message after select login 
		String notificationMessage = notification.getText();
		System.out.println("notificationMessage: "+notificationMessage);
		softAssert.assertEquals(notificationMessage, "Availability updated successfully.", "Notification Message is diffrent , Perhaps the Login is not done");
		
    	softAssert.assertAll();

	}

	// If User apply leave for day (Except Present day) then as per applied
	// leave, count should display for same month
	public void checkWithLeaveForNextDaySelect() throws Exception
	{
        SoftAssert softAssert = new SoftAssert();

		// click on update Availability
		btnUpdateAvailability.click();

		// select Login
		Select leave = new Select(ddlAvailability);
		leave.selectByVisibleText("Leave");

		// get value from Availability drop down
		String availability = ddlAvailability.getAttribute("value");
		System.out.println("availability: " + availability);

		Thread.sleep(1000);
		boolean leaveTypeIsPresent = ddlLeaveType.isDisplayed();
		softAssert.assertTrue(leaveTypeIsPresent,
				"The Leave Type Is Not Present");

		Select leaveType = new Select(ddlLeaveType);
		leaveType.selectByVisibleText("Previlage Leave");

		// get value from Availability drop down
		String leaveTypeValue = ddlLeaveType.getAttribute("value");
		System.out.println("leaveTypeValue: " + leaveTypeValue);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// click on save button
		btnSave.click();

		// without select form and to dates check Alert message
		Alert dateAlert = driver.switchTo().alert();
		// Thread.sleep(3000);

		String messageWithoutSelectingDate = dateAlert.getText();
		System.out.println("Alert Text:" + messageWithoutSelectingDate);
		dateAlert.accept();

		softAssert.assertEquals(messageWithoutSelectingDate, "Invalid Date");

		Thread.sleep(2000);

		// select Form and To date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int nextDay = Integer.parseInt(currentDay) + 1;
		String nextDate = Integer.toString(nextDay);

		int secondDay = Integer.parseInt(currentDay) + 2;
		String SecondDate = Integer.toString(secondDay);

		calendarFromDate.click();

		// select Date in Calendar

		for (WebElement day : dtpInFromDate) 
		{

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(nextDate)) 
			{

				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		Thread.sleep(1000);
		calendarToDate.click();

		for (WebElement day : dtpInToDate) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(SecondDate)) {

				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			} else if (dayInCalender.equalsIgnoreCase(nextDate)) {
				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;

			}

		}

		String fromDate = txtFromDate.getAttribute("value");
		System.out.println("fromDate: " + fromDate);

		String toDate = txtToDate.getAttribute("value");
		System.out.println("toDate: " + toDate);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// click on save button
		btnSave.click();

		Alert messageOfValidDate = driver.switchTo().alert();
		String validDate = messageOfValidDate.getText();
		System.out.println("Alert Text:" + validDate);
		messageOfValidDate.accept();

		softAssert.assertEquals(validDate, "Valid Date",
				"valid date pop up massage is not same");

		Alert message = driver.switchTo().alert();
		String saveChangePopUpMessage = message.getText();
		System.out.println("Alert Text:" + saveChangePopUpMessage);
		message.accept();

		// get message after select login
		String notificationMessage = notification.getText();
		System.out.println("notificationMessage: " + notificationMessage);
		softAssert
				.assertEquals(notificationMessage,
						"Availability updated successfully.",
						"Notification Message is diffrent , Perhaps the Login is not done");

		softAssert.assertAll();

	}

	//check Total Closing Balance After applying  Leave
	public void checkTotalClosingBalance()
	{				
		//Get value of total opening balance
		String totalOpeningBalance = lblTotalOpeningBalance.getText();
		double doubleValue = Double.parseDouble(totalOpeningBalance);
		System.out.println("totalOpeningBalance: "+totalOpeningBalance);
		System.out.println("doubleValue: "+doubleValue);
		
		int intValueOfOpeningBalance = (int) Math.round(doubleValue);		
		System.out.println("intValueOfOpeningBalance: "+intValueOfOpeningBalance);
		
		//Get value of privilege leave
		String previlageLeave = lblPrevilageLeaveTaken.getText();
		System.out.println("previlageLeave: "+previlageLeave);
		
		int intValueOfPrevilageLeave = Integer.parseInt(previlageLeave);		
		System.out.println("intValueOfPrevilageLeave: "+intValueOfPrevilageLeave);
		
		//Get value of sick leave
		String sickLeave = lblSickLeaveTaken.getText();
		System.out.println("sickLeave: "+sickLeave);
		
		int intValueOfSickLeave = Integer.parseInt(sickLeave);		
		System.out.println("intValueOfsickLeave: "+intValueOfSickLeave);
		
		String totalClosingBalance = lblTotalClosingBalance.getText();
		System.out.println("totalClosingBalance: "+totalClosingBalance);
		double doubleValueOfClosingBalance = Double.parseDouble(totalClosingBalance);
		System.out.println("doubleValueOfClosingBalance: "+doubleValueOfClosingBalance);
		
		int intValueOfTotalClosingBalance = (int) Math.round(doubleValueOfClosingBalance);		
		System.out.println("intValueOfTotalClosingBalance: "+intValueOfTotalClosingBalance);
		
		//add the value of privilege leave and sick leave 
		int totalLeave = intValueOfPrevilageLeave + intValueOfSickLeave;
		System.out.println("totalLeave: "+totalLeave);
		
		//Subtract the value of total leave into total Opening Balance
		int remainingLeaves = intValueOfOpeningBalance - totalLeave;
		System.out.println("remainingLeaves: "+remainingLeaves);
		
		assertEquals(intValueOfTotalClosingBalance, remainingLeaves, "The value of closing Balance is wrong");
		
	}
	
}

