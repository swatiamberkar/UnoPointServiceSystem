package com.uno.pages.technician;

import static org.testng.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.superrole.Super_CustomerDetailsPage;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ManageStaffPage;
import com.uno.test.superrole.Super_EmployeeMasterTest;

public class Technician_MyAvailabilityPage extends BaseCode {

	String currentDir = System.getProperty("user.dir");
	// Call method from super login
	Super_EmployeeMasterTest super_EmployeeMasterPageTest;
	Super_EmployeeDetailPage super_EmployeeDetailPage;

	SD_LoginPage loginpage;
	Technician_HomePage homePageOfTechnicianRole;
	// Select RM tab for logout tab
	@FindBy(linkText = ".//*[@id='main']/div[2]/div[2]/div/ul/li[7]/a")
	WebElement tabTechnician;

	// Select RM tab for logout tab
	@FindBy(linkText = "Test")
	WebElement tabTest;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// Heading of ticket form
	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement label_OfHeading;

	// Get value of total Opening Balance
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[1]")
	public WebElement totalOpeningBalanceValue;

	// Get value of Privilege Leave Taken For This Month
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[2]")
	public WebElement previlageLeaveTakenValue;

	// Get value of Sick Leave Taken For This Month
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[3]")
	public WebElement sickLeaveTakenValue;

	// Get Total Closing Balance
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[4]")
	public WebElement totalClosingBalanceValue;

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

	// select Availability in table
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[3]")
	List<WebElement> lstAvailability;

	// select Availability in table
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[5]")
	List<WebElement> lstLoginDateTime;

	// select Availability in table
	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[6]")
	List<WebElement> lstLogoutStatus;

	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[7]")
	List<WebElement> lstLogoutDateTime;

	@FindBy(xpath = ".//*[@id='main']/div[8]/div/div/div/table/tbody/tr/td[8]")
	List<WebElement> lstEarlyOutReason;

	@FindBy(css = "div[id='main']>div:nth-of-type(8)>div>div>div>table>tbody>tr>td:nth-of-type(9)")
	List<WebElement> lstLeaveType;

	// Get value of total Opening Balance
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[1]")
	WebElement lblTotalOpeningBalance;

	// Get value of Privilege Leave Taken For This Month
	@FindBy(xpath = ".//*[@id='main']/div[7]/div/div/div/table/tbody/tr[2]/td[2]")
	WebElement lblPrevilageLeaveTaken;

	// Initializing Page Object
	public Technician_MyAvailabilityPage() {
		PageFactory.initElements(driver, this);
	}

	// If User click on My Availability tab, then View My Availability page
	// should get open with last login details .
	public void checkHeadingOfPage() {
		// check the heading of View My Availability
		String viewMyAvailability = label_OfHeading.getText();
		System.out.println("HeadingName: " + viewMyAvailability);

		assertEquals(viewMyAvailability, "View My Availability",
				"page heading is not match");

	}

	// to do login
	public void technicianLogin() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// click on update Availability
		btnUpdateAvailability.click();

		Thread.sleep(200);
		// select Login
		Select login = new Select(ddlAvailability);
		login.selectByVisibleText("Login");

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// click on save button
		btnSave.click();

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

	}

	// apply leave for current day
	public void applyLeave() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on update Availability
		btnUpdateAvailability.click();

		// select Login
		Select leave = new Select(ddlAvailability);
		leave.selectByVisibleText("Leave");

		Select leaveType = new Select(ddlLeaveType);
		leaveType.selectByVisibleText("Previlage Leave");

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
				System.out.println("Select the date:-" + getDateValue);

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
				System.out.println("Select the date:-" + getDateValue);

				break;

			}

		}
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

		/* softAssert.assertAll(); */

	}

	// apply Compensatory leave for current day
	public void applyCompensatoryLeave() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		// click on update Availability
		btnUpdateAvailability.click();

		// select Login
		Select leave = new Select(ddlAvailability);
		leave.selectByVisibleText("Leave");

		Select leaveType = new Select(ddlLeaveType);
		leaveType.selectByVisibleText("Compensatory Leave");

		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);
		int nextDay = Integer.parseInt(currentDay) + 1;
		String nxtDay = Integer.toString(nextDay);
		System.out.println(nxtDay);

		calendarFromDate.click();

		// select Date in Calendar

		for (WebElement day : dtpInFromDate) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(nxtDay)) {

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

			if (dayInCalender.equalsIgnoreCase(nxtDay)) {

				Thread.sleep(1000);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;

			}

		}

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

		/* softAssert.assertAll(); */

	}

	// In Total Opening Balance Of This Month column value should display as per
	// Total leaves assign in employee master -> employee Details for employee
	// login.
	public void matchTotalOpeningBalanceWithSuperRole() throws Exception {
		// get the value from Total Opening Balance Of This Month.
		String valueOfTotalOpeningBalance = lblTotalOpeningBalance.getText();
		System.out.println("valueOfTotalOpeningBalance: "
				+ valueOfTotalOpeningBalance);

		scrollDown(driver.findElement(By
				.cssSelector("a[href='/erprmwise/TechnicianHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/TechnicianHomeScreen.do']"))
				.click();
		Thread.sleep(400);
		scrollDown(tabTechnician);
		// logout from RM
		tabTechnician.click();

		Thread.sleep(400);
		tabLogOut.click();

		// get value from super login -> Employee Master -> Employee Details
		super_EmployeeMasterPageTest = new Super_EmployeeMasterTest();
		super_EmployeeMasterPageTest.Setup();
		super_EmployeeMasterPageTest.ClickOnEmpolyeeDetailLink();
		super_EmployeeDetailPage = new Super_EmployeeDetailPage();
		super_EmployeeDetailPage.clickOnUpdateInTechnician();
		String totalLeaveValue = Super_EmployeeDetailPage.totalLeave;
		System.out.println("totalLeaveValue: " + totalLeaveValue);

		driver.findElement(
				By.xpath(".//*[@id='boxz']/div/table/tbody/tr[1]/th[3]/img"))
				.click();

		// logout from RM
		tabTest.click();

		Thread.sleep(200);
		tabLogOut.click();

		// match both the value is same
		assertEquals(valueOfTotalOpeningBalance, totalLeaveValue + ".0",
				"The value is not same");

		loginpage = new SD_LoginPage();
		homePageOfTechnicianRole = loginpage.technicianLogin(
				properties.getProperty("loginIdForTechnician"),
				properties.getProperty("password"));

	}

	
}