package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.test.rm.RM_AttendanceApprovalTest;



public class RM_AttendanceApprovalPage extends BaseCode 
{
	Calendar systemDate = new GregorianCalendar();
	public static String engineerName = null;

	// call the page from RM
	RM_HomePage rm_HomePage;
	RM_AttendancePage rm_AttendancePage;
	RM_EngineerAttendancePage rm_EngineerAttendancePage;
	RM_AttendanceApprovalTest rm_AttendanceApprovalTest;
	RM_AttendanceApprovalPage rm_AttendanceApprovalPage;

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
	@FindBy(xpath = ".//*[@id='container']/div[1]/div[1]")
	WebElement lblHeading;

	// Select filter tab
	@FindBy(linkText = "Filter")
	WebElement tabFilter;

	// select Select Date text box
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calSelectDate;

	// click on select date calendar button
	@FindBy(name = "m_strDate")
	WebElement txtSelectDate;

	// select date from date picker
	@FindBy(xpath = ".//*[@id='fd-dp-2']/table/tbody/tr/td")
	List<WebElement> dtpSelectDate;

	// Select Go button
	@FindBy(xpath = ".//*[@id='form']/div[1]/div/table/tbody/tr[3]/td[3]/img")
	WebElement btnGO;

	// Select Avail Date
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]/input")
	List<WebElement> lstAvailDate;

	// Select Engineer Name
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[3]")
	List<WebElement> lstEngineerName;

	// Select Availability
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]/select/option")
	List<WebElement> lstAvailabilityValue;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]/select")
	List<WebElement> ddlAvailability;

	// Select Availability
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]")
	List<WebElement> lstAvailability;

	// Select Login Time
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[5]")
	List<WebElement> lstLoginTime;

	// Select hour
	@FindBy(name = "m_strLoginTimeHour")
	WebElement ddlTimeHour;

	// Select minute
	@FindBy(name = "m_strLoginTimeMin")
	WebElement ddlTimeMin;

	// Select minute
	@FindBy(className = "update1Btn")
	WebElement btnUpdate;

	// Select Logout Time
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[6]")
	List<WebElement> lstLogoutTime;

	// Select Status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[14]")
	List<WebElement> lstStatus;

	// Select Reject
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[15]")
	List<WebElement> lstReject;

	// Select Multiple Approval
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[10]")
	List<WebElement> lstMultipleApproval;

	// Select Multiple Approval
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[10]/input")
	List<WebElement> rdoMultipleApproval;

	// Heading
	@FindBy(xpath = ".//*[@id='dialogBoxSuccess']")
	WebElement lblDialogBox;

	// Select Reason for Reject
	@FindBy(name = "m_strReason")
	WebElement txaReasonforReject;

	// Select Reject Button
	@FindBy(linkText = "Reject")
	WebElement btnReject;

	// Select Reject Button
	@FindBy(linkText = "Cancel")
	WebElement btnCancel;

	// Select Submit Approval
	@FindBy(linkText = "Submit Approval")
	WebElement btnSubmitApproval;

	// click on Leave Approval page
	@FindBy(linkText = "Leave Approval")
	WebElement tabLeaveApproval;

	// Initializing Page Object
	public RM_AttendanceApprovalPage() {
		PageFactory.initElements(driver, this);
	}

	// If User click on Attendance Approval page then Engineer Attendance
	// Approval Screen should display.
	public void checkHeadingOfPage() {
		// Check the heading of View My Availability
		String viewMyAvailability = lblHeading.getText();
		System.out.println("HeadingName: " + viewMyAvailability);

		assertEquals(viewMyAvailability, "Engineer Attendance Approval Screen",
				"page heading is not match");

	}

	// Click on leave Approval page
	public RM_LeaveApprovalPage leaveApproval() {
		tabLeaveApproval.click();
		return new RM_LeaveApprovalPage();
	}

	// In Filter-> Select Date, if user select date and click on Go button then
	// in Avail Date field of all entries selected date should display
	public void checkAvailDate() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();

		// Click on filter
		tabFilter.click();

		// Select date from Select Date field

		int dateInMonth = systemDate.get(Calendar.DAY_OF_MONTH) - 5;
		System.out.println("dateInMonth: " + dateInMonth);
		String priviousDate = Integer.toString(dateInMonth);
		System.out.println("priviousDate: " + priviousDate);
		calSelectDate.click();

		// select Date in Calendar
		for (WebElement date : dtpSelectDate) {

			String dayInCalender = date.getText();

			if (dayInCalender.equalsIgnoreCase(priviousDate)) {

				Thread.sleep(1000);
				date.click();
				String getDateValue = date.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;

			}

		}

		// get selected date
		String selectDate = txtSelectDate.getAttribute("value");
		System.out.println("selectDate: " + selectDate);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", txtSelectDate);

		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						txtSelectDate);

		// click on GO button
		btnGO.click();

		Thread.sleep(500);
		// check that same date is present on Avail Date column or not
		int size = lstAvailDate.size();
		System.out.println("size: " + size);
		for (int i = 0; i < lstAvailDate.size(); i++) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", lstAvailDate.get(i));

			((JavascriptExecutor) driver)
					.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							lstAvailDate.get(i));

			String availDate = lstAvailDate.get(i).getAttribute("value");

			softAssert.assertEquals(availDate, selectDate,
					"The selected date and Avail Date is diffrent");

		}

		softAssert.assertAll();
	}

	// In Availability filter list, Login and Logout option should display
	public void checkAvailabilityFilterList() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();

		String value = "Select" + "Login" + "Logout";
		System.out.println(value);

		int size = lstAvailabilityValue.size();
		System.out.println("size: " + size);
		for (int i = 0; i < lstAvailabilityValue.size(); i++) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstAvailabilityValue.get(i));

			String availability = lstAvailabilityValue.get(i).getAttribute(
					"value");
			System.out.println("availability: " + availability);

			softAssert.assertTrue(value.contains(availability));
			/* "The selected date and Avail Date is diffrent") */

		}

		softAssert.assertAll();

	}

	// If User click on Login Time link then 'Update Login Time' popup should
	// display then user able to select time to update login time.
	// If User click on Update button after select time then same should get
	// update in Login Time and notification should display as 'Time Updated
	// Successfully.!'
	public void checkWithLoginSelect() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		// String basicWindow = driver.getWindowHandle();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			if (engineerName.contains("pranjali12 deshpande")) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// if login is done previously then select "Select"
				Select availablityBeforeLogin = new Select(
						ddlAvailability.get(i));
				availablityBeforeLogin.selectByVisibleText("Select");

				// click on login link , without apply the login
				Thread.sleep(500);
				lstLoginTime.get(i).click();

				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("alertMessage: " + alertMessage);
				alert.accept();

				softAssert.assertEquals(alertMessage,
						"Please Select Availability for pranjali12 deshpande",
						"alert message is different");

				String availablityList = ddlAvailability.get(i).getText();
				System.out.println("availablityList: " + availablityList);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						ddlAvailability.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ddlAvailability.get(i));

				Select availablity = new Select(ddlAvailability.get(i));
				availablity.selectByVisibleText("Login");

				Thread.sleep(500);
				lstLoginTime.get(i).click();

				String windowName = driver
						.findElement(
								By.xpath(".//*[@id='boxsr']/div/table/tbody/tr[1]/th[2]"))
						.getText();
				System.out.println("windowName: " + windowName);

				softAssert.assertEquals(windowName, "Update Login Time",
						"The Login Window is different");

				Calendar calendar = Calendar.getInstance();
				String currentHrs = new SimpleDateFormat("HH").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentHrs);

				String currentMin = new SimpleDateFormat("mm").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentMin);

				Select hours = new Select(ddlTimeHour);
				hours.selectByVisibleText(currentHrs);

				Select minute = new Select(ddlTimeMin);
				minute.selectByVisibleText(currentMin);

				String totalTime = currentHrs + ":" + currentMin + ":" + "00";
				System.out.println("totalTime: " + totalTime);

				btnUpdate.click();

				String loginTime = lstLoginTime.get(i).getText();
				System.out.println("loginTime: " + loginTime);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstLoginTime.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstLoginTime.get(i));

				softAssert.assertEquals(loginTime, totalTime,
						"The Login Time Is Different");
				break;

			}

		}

		softAssert.assertAll();

	}

	// If User click on Pending button without update login details then
	// notification should display as 'Please Select Login for (Emp_Name)'
	// If User check check box of entry without update Availability option and
	// click on Submit Approval button then notification should display as
	// 'Please Select Availability Login for (Emp_Name).'

	public void checkPendingFunctionality() throws Exception 
	{
		Thread.sleep(1000);
		SoftAssert softAssert = new SoftAssert();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			if (engineerName.contains("Pranjali Deshpande")) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// if login is done previously then select "Select"
				Select availablityBeforeLogin = new Select(
						ddlAvailability.get(i));
				availablityBeforeLogin.selectByVisibleText("Select");

				Thread.sleep(500);
				// click on status without selecting
				lstStatus.get(i).click();

				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("alertMessage: " + alertMessage);
				alert.accept();

				softAssert.assertEquals(alertMessage,
						"Please Select Login for Pranjali Deshpande",
						"alert message is different");

				Thread.sleep(1000);
				Select availablity = new Select(ddlAvailability.get(i));
				availablity.selectByVisibleText("Login");

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						ddlAvailability.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ddlAvailability.get(i));

				Thread.sleep(500);
				lstLoginTime.get(i).click();

				Calendar calendar = Calendar.getInstance();
				String currentHrs = new SimpleDateFormat("HH").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentHrs);

				String currentMin = new SimpleDateFormat("mm").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentMin);

				Select hours = new Select(ddlTimeHour);
				hours.selectByValue(currentHrs);

				Select minute = new Select(ddlTimeMin);
				minute.selectByValue(currentMin);

				String totalTime = currentHrs + ":" + currentMin + ":" + "00";
				System.out.println("totalTime: " + totalTime);

				btnUpdate.click();

				lstStatus.get(i).click();

				Thread.sleep(500);
				// Check the heading message
				String heading = lblDialogBox.getText();
				System.out.println("heading: " + heading);

				softAssert.assertEquals(heading,
						"Record Approved Successfully.!",
						"Record is not Approve");

				break;

			}

		}

		softAssert.assertAll();

	}

	// If User click on Reject button without update any details then after
	// click on Reject button in pop up then notification should display as 'You
	// Can't Reject Without Login Or Leave for (Emp_Name)'
	// If User update availability and click on Reject button then after update
	// click on Reject button in Pop up, notification should display as 'Record
	// Rejected Successfully.!' and Availability details also get refreshed.

	public void checkRejectFunctionality() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			if (engineerName.contains("KavitaM .")) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// if login is done previously then select "Select"
				Select availablityBeforeLogin = new Select(
						ddlAvailability.get(i));
				availablityBeforeLogin.selectByVisibleText("Select");

				Thread.sleep(500);
				// click on status without selecting
				lstReject.get(i).click();

				// Send reason in Reject Reject text box
				txaReasonforReject.sendKeys("Select Availability");

				// Click on Reject Button
				btnReject.click();

				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("alertMessage: " + alertMessage);
				alert.accept();

				softAssert
						.assertEquals(
								alertMessage,
								"You Can't Reject Without Login Or Leave for KavitaM .",
								"alert message is different");

				btnCancel.click();

				// Select login
				Select availablity = new Select(ddlAvailability.get(i));
				availablity.selectByVisibleText("Login");

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						ddlAvailability.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ddlAvailability.get(i));

				Thread.sleep(500);
				lstLoginTime.get(i).click();

				Calendar calendar = Calendar.getInstance();
				String currentHrs = new SimpleDateFormat("HH").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentHrs);

				String currentMin = new SimpleDateFormat("mm").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentMin);

				Select hours = new Select(ddlTimeHour);
				hours.selectByValue(currentHrs);

				Select minute = new Select(ddlTimeMin);
				minute.selectByValue(currentMin);

				String totalTime = currentHrs + ":" + currentMin + ":" + "00";
				System.out.println("totalTime: " + totalTime);

				btnUpdate.click();

				// click on reject
				lstReject.get(i).click();

				btnReject.click();

				Thread.sleep(500);
				// Check the heading message
				String heading = lblDialogBox.getText();
				System.out.println("heading: " + heading);

				softAssert.assertEquals(heading,
						"Record Rejected Successfully.!",
						"Record is not reject");

				break;

			}
		}

		softAssert.assertAll();
	}

	// If User click on Approve button without update login time after select
	// Availability as 'Login', then alert box should display as 'If your
	// Availability is Login then select Login Time..'
	// After update login and/Or logout if user click on Pending button then
	// notification should display as 'Record Approved Successfully.!' and
	// status should display as 'Approved'
	/*
	 * public void checkWithMultipleApproval() {
	 * 
	 * 
	 * }
	 */
	// If User select availability and check checkbox then after click on Submit
	// Approval button then in login time, current time should display same
	// current date and time display in Updated Date Time column. Updated By
	// column should display login name and status should become 'Approved'.
	// also notification should display as 'Record Approved Successfully.!'
	public void checkWithMultipleApproval() throws Exception {

		SoftAssert softAssert = new SoftAssert();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			if (engineerName.contains("Swati .")) {

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// Select login
				Select availablity = new Select(ddlAvailability.get(i));
				availablity.selectByVisibleText("Login");

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						ddlAvailability.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ddlAvailability.get(i));

				// get Multiple Approval list
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstMultipleApproval.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstMultipleApproval.get(i));

				// select check box
				lstMultipleApproval.get(i).click();

				//
				btnSubmitApproval.click();

				// check the heading message
				String heading = lblDialogBox.getText();
				System.out.println("heading: " + heading);

				softAssert.assertEquals(heading,
						"Record Approved Successfully.!'",
						"Record is not get approve");

				// get current date and time
				Calendar calendar = Calendar.getInstance();
				String currentHrs = new SimpleDateFormat("HH").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentHrs);

				String currentMin = new SimpleDateFormat("mm").format(calendar
						.getTime());
				System.out.println("currentHrs: " + currentMin);

				String totalSystemTime = currentHrs + ":" + currentMin;
				System.out.println("totalSystemTime: " + totalSystemTime);

				// get value from login time
				String loginTimeValue = lstLoginTime.get(i).getText();
				System.out.println("loginTimeValue: " + loginTimeValue);

				/*
				 * String splitSecond = loginTimeValue.split(": ")[1];
				 * System.out.println("splitSecond: "+splitSecond);
				 */

				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
				Date dateStr = formatter.parse(loginTimeValue);
				String formattedDate = formatter.format(dateStr);
				System.out.println("formattedDate: " + formattedDate);

				softAssert.assertEquals(formattedDate, totalSystemTime,
						"Login Time Is not match ");

				break;

			}

		}
		softAssert.assertAll();

	}

	// If Attendance status is 'Approved' then in Engineer Attendance tab value
	// should display as 'Login' (If Attendance Approve By Reporting Manager
	// setting is 'Yes')
	public void verifyAfterApprove() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		int size = lstStatus.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String statusValue = lstStatus.get(i).getText();
			System.out.println("statusValue: " + statusValue);

			if (statusValue.contains("Approved")) {

				engineerName = lstEngineerName.get(i).getText();
				System.out.println("engineerName: " + engineerName);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// Match the availability of engineer in engineer Attendance Tab
				for (String mainWindow : driver.getWindowHandles()) {
					driver.switchTo().window(mainWindow);

				}

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].scrollIntoView(true);",
								driver.findElement(By
										.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
				driver.findElement(
						By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']"))
						.click();

				rm_HomePage = new RM_HomePage();
				rm_AttendancePage = rm_HomePage.AttendanceTab();
				Thread.sleep(1000);
				rm_EngineerAttendancePage = rm_AttendancePage
						.engineerAttendanceTab();
				rm_EngineerAttendancePage.checkAvailability();
				Thread.sleep(1000);

				softAssert.assertEquals(
						RM_EngineerAttendancePage.dateAttendance, "Login");

				break;

			}

		}
		softAssert.assertAll();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);

		}

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

		rm_HomePage = new RM_HomePage();
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_AttendanceApprovalPage = rm_AttendancePage.attendanceApprovalTab();

	}

	// If Attendance status is 'Rejected' then in Engineer Attendance tab value
	// should display as 'Not available'
	// (If Attendance Approve By Reporting Manager setting is 'Yes')
	public void verifyAfterReject() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		int size = lstStatus.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String rejectValue = lstReject.get(i).getText();
			System.out.println("statusValue: " + rejectValue);

			if (rejectValue.contains("Rejected")) {

				engineerName = lstEngineerName.get(i).getText();
				System.out.println("engineerName: " + engineerName);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// Match the availability of engineer in engineer Attendance Tab
				for (String mainWindow : driver.getWindowHandles()) {
					driver.switchTo().window(mainWindow);

				}

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].scrollIntoView(true);",
								driver.findElement(By
										.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
				driver.findElement(
						By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']"))
						.click();

				Thread.sleep(1000);
				rm_HomePage = new RM_HomePage();
				rm_AttendancePage = rm_HomePage.AttendanceTab();
				Thread.sleep(1000);
				rm_EngineerAttendancePage = rm_AttendancePage
						.engineerAttendanceTab();
				rm_EngineerAttendancePage.checkAvailability();
				Thread.sleep(1000);

				softAssert.assertEquals(
						RM_EngineerAttendancePage.dateAttendance,
						"Not Available");

				break;

			}

		}
		softAssert.assertAll();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);

		}

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

		rm_HomePage = new RM_HomePage();
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_AttendanceApprovalPage = rm_AttendancePage.attendanceApprovalTab();

	}

	// If entry is pending from RM then in Engineer Attendance tab value should
	// display as
	// 'Not Available' (If Attendance Approve By Reporting Manager setting is
	// 'Yes')
	public void verifyWithPendingStatus() throws Exception {
		Thread.sleep(1000);
		SoftAssert softAssert = new SoftAssert();
		int size = lstStatus.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String statusValue = lstStatus.get(i).getText();
			System.out.println("statusValue: " + statusValue);

			if (statusValue.contains("Pending")) {

				engineerName = lstEngineerName.get(i).getText();
				System.out.println("engineerName: " + engineerName);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstEngineerName.get(i));

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								lstEngineerName.get(i));

				// Match the availability of engineer in engineer Attendance Tab
				for (String mainWindow : driver.getWindowHandles()) {
					driver.switchTo().window(mainWindow);

				}

				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].scrollIntoView(true);",
								driver.findElement(By
										.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
				driver.findElement(
						By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']"))
						.click();

				Thread.sleep(1000);
				rm_HomePage = new RM_HomePage();
				rm_AttendancePage = rm_HomePage.AttendanceTab();
				Thread.sleep(1000);
				rm_EngineerAttendancePage = rm_AttendancePage
						.engineerAttendanceTab();
				rm_EngineerAttendancePage.checkAvailability();
				Thread.sleep(1000);

				softAssert.assertEquals(
						RM_EngineerAttendancePage.dateAttendance,
						"Not Available");

				break;

			}

		}

		softAssert.assertAll();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);

		}

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

		rm_HomePage = new RM_HomePage();
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_AttendanceApprovalPage = rm_AttendancePage.attendanceApprovalTab();

	}

}
