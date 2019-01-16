package com.uno.pages.rm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_ClaimPage;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketTypePage;

public class RM_ClaimApprovalPage extends BaseCode {

	public static int expenseType = 1;

	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDmasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_TicketTypePage ticketTypePageOfSuperRole;
	Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
	Super_EmployeeDetailPage super_EmployeeDetailPage;

	Super_ClaimPage super_ClaimPage;
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_ClaimPage rm_ClaimPage;
	RM_CreateNewClaimPage rm_CreateNewClaimPage;
	RM_ReimbursementAgainstAdvancePage rm_ReimbursementAgainstAdvancePage;
	RM_ClaimApprovalPage rm_ClaimApprovalPage;

	// Select SD tab for logout tab
	@FindBy(linkText = "Niraj1")
	WebElement link_RM;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement link_Test;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	// Claim Approval Tab
	@FindBy(css = "div[id='form']>div>ul>li>div")
	WebElement tabRM;

	@FindBy(xpath = ".//*[@id='main']/div[2]/div[2]/div/ul/li[10]/a")
	WebElement lblLogin;

	@FindBy(css = "div[id='form']>div>ul>li>ul>li>div")
	List<WebElement> lstReportees;

	@FindBy(xpath = ".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[19]")
	List<WebElement> lstReportingManager;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[3]")
	List<WebElement> lstEngineerName;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[7]")
	List<WebElement> lstFromBillDate;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[8]")
	List<WebElement> lstToBillDate;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[6]")
	List<WebElement> lstDateTime;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[4]")
	List<WebElement> lstExpenseType;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[18]")
	List<WebElement> lstAttachment;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[19]")
	List<WebElement> lstReject;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[19]/a")
	List<WebElement> lnklstReject;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[20]")
	List<WebElement> lstComment;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[2]/div[2]/table/tbody/tr/td[2]")
	List<WebElement> lstId;

	@FindBy(xpath = ".//*[@id='right']/div[1]/div/div[1]/div[2]/table/tbody/tr/td/input")
	List<WebElement> lstCheckbox;

	@FindBy(xpath = ".//*[@id='box']/div/table/tbody/tr[3]/td[3]/textarea")
	WebElement txtReject;

	@FindBy(xpath = ".//*[@id='box']/div/table/tbody/tr[5]/td/a/span")
	WebElement btnReject;

	@FindBy(xpath = ".//*[@id='form']/a")
	WebElement btnApprove;

	@FindBy(xpath = ".//*[@id='529']/div/span[3]/button")
	WebElement btnViewOfRM;

	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement headingOfPage;

	// From Date Text box
	@FindBy(xpath = ".//*[@id='dp-1']")
	WebElement textbox_FromDate;

	// To Date Text box
	@FindBy(xpath = ".//*[@id='dp-2']")
	WebElement textbox_ToDate;

	// From Date Calendar
	@FindBy(xpath = ".//*[@id='fd-but-dp-1']/span[1]")
	WebElement calendar_FromDate;

	// From Date day of Calendar
	@FindBy(xpath = ".//*[@id='fd-dp-1']/table/tbody/tr/td")
	List<WebElement> dayOfCalendar_FromDate;

	// From Date month of Calendar
	@FindBy(xpath = ".//*[@id='dp-1-prev-month-but']")
	WebElement previousMonthOfCalendar_FromDate;

	// To Date Calendar
	@FindBy(xpath = ".//*[@id='fd-but-dp-2']/span[1]")
	WebElement calendar_ToDate;

	// To Date day of Calendar
	@FindBy(xpath = ".//*[@id='fd-dp-2']/table/tbody/tr/td")
	List<WebElement> dayOfCalendar_ToDate;

	// From Date month of Calendar
	@FindBy(xpath = ".//*[@id='dp-2-prev-month-but']")
	WebElement previousMonthOfCalendar_ToDate;

	@FindBy(xpath = ".//*[@id='container']/div[2]/table/tbody/tr[2]/td[12]/select")
	WebElement ddlExpenseType;

	// Go Button
	@FindBy(xpath = ".//*[@id='container']/div[2]/table/tbody/tr[2]/td[14]/a/span")
	WebElement button_Go;

	// Download Excel Button
	@FindBy(xpath = "a[onclick='callDownloadExcel()']")
	WebElement button_DownloadExcel;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;

	public RM_ClaimApprovalPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyRMAndLoginUser() throws Exception {
		String loginUser = lblLogin.getText();
		System.out.println("loginUser: " + loginUser);

		scrollDown(tabRM);
		highLight(tabRM);
		String claimedBy = tabRM.getText();
		System.out.println("claimedBy: " + claimedBy);
		String claimedByText = claimedBy.split(" ")[0];
		System.out.println("claimedByText: " + claimedByText);
		Assert.assertEquals(claimedByText, loginUser,
				"Login User And RM is not Same.");

	}

	public void verifyReporteesCount() throws Exception {
		tabRM.click();
		int sizeOfReportees = lstReportees.size();
		System.out.println("sizeOfReportees: " + sizeOfReportees);

		link_RM.click();
		Thread.sleep(1000);

		// click on logout
		link_LogOut.click();

		loginPageOfSuperRole = new Super_LoginPage();
		homePageOfSuperRole = loginPageOfSuperRole.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		empolyeeMasterPageOfSuperRole = homePageOfSuperRole
				.clickEmpolyeeMasterlink();
		Thread.sleep(1000);
		empolyeeMasterPageOfSuperRole = empolyeeMasterPageOfSuperRole
				.clickEmpolyeeMasterlink();
		Thread.sleep(1000);
		super_EmployeeDetailPage = empolyeeMasterPageOfSuperRole
				.clickOnEmpolyeeDetailLink();
		int count = 0;
		int size = lstReportingManager.size();
		System.out.println("size: " + size);
		for (int i = 0; i < size; i++) {
			scrollDown(lstReportingManager.get(i));
			String reportingManager = lstReportingManager.get(i).getText();
			System.out.println("ReportingManager: " + reportingManager);

			if (reportingManager.equalsIgnoreCase("Niraj1 Upadhyay")) {
				highLight(lstReportingManager.get(i));
				count = count + 1;

			}
		}
		System.out.println("count: " + count);
		Assert.assertEquals(sizeOfReportees, count,
				"Reportees Size is not Same.");
		
		link_Test.click();
		Thread.sleep(1000);

		// click on logout
		link_LogOut.click();
		
		rm_LoginPage = new RM_LoginPage();
		Thread.sleep(1000);
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM2"),
				properties.getProperty("password"));
		Thread.sleep(1000);

	}

	public void verifyReporteesOfAllClaim() throws Exception {
		tabRM.click();
		Thread.sleep(1000);
		String list = "RM";
		int sizeOfReportees = lstReportees.size();
		System.out.println("size: " + sizeOfReportees);

		for (int i = 0; i < sizeOfReportees; i++) {

			String name = lstReportees.get(i).getText();

			System.out.println("name: " + name);
			list = list.concat(" " + name);

		}
		System.out.println("ListOfReportess: " + list);

		btnViewOfRM.click();
		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {
			scrollDown(lstEngineerName.get(i));
			highLight(lstEngineerName.get(i));

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);
			Assert.assertTrue(list.contains(engineerName),
					"Reportees Of Claim is not Match.");

		}

	}

	public void verifyPerticularReporteesOfClaim() throws Exception {
		tabRM.click();
		Thread.sleep(1000);
		int sizeOfReportees = lstReportees.size();
		System.out.println("size: " + sizeOfReportees);

		for (int i = 0; i < sizeOfReportees; i++) {

			String name = lstReportees.get(i).getText();
			System.out.println("name: " + name);
			if (name.contains("Kavita .")) {
				highLight(lstReportees.get(i));
				driver.findElement(By.xpath(".//*[@id='5']/div/span[3]/button"))
						.click();
				break;
			}

		}
		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {
			scrollDown(lstEngineerName.get(i));
			highLight(lstEngineerName.get(i));

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);
			Assert.assertEquals(engineerName, "Kavita .",
					"Reportees Of Claim is not Match.");

		}

	}

	public void verifyFromToDate() throws Exception {
		tabRM.click();
		Thread.sleep(500);
		btnViewOfRM.click();

		// Get the Today system date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * Date date1 = new Date(); String todayDate = dateFormat.format(date1);
		 * System.out.println("Today Date: " + todayDate);
		 * 
		 * Calendar calendar1 = Calendar.getInstance(); // Move calendar to 7
		 * days before calendar1.add(Calendar.DATE, -7); // Get current date of
		 * calendar which point to the yesterday now Date lastSevenDays =
		 * calendar1.getTime(); String lastSevenDaysDate =
		 * dateFormat.format(lastSevenDays).toString();
		 * System.out.println("Last Seven Days Date: " + lastSevenDaysDate);
		 */
		// Get System Date
		Calendar sevendate = new GregorianCalendar();
		int dayOfMonth = sevendate.get(Calendar.DAY_OF_MONTH);
		int seven = dayOfMonth - 7;
		String sevenDay = Integer.toString(seven);
		System.out.println("sevenDay: " + sevenDay);

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int today = mydate.get(Calendar.DAY_OF_MONTH);
		String currentDay = Integer.toString(today);
		System.out.println("currentDay: " + currentDay);

		calendar_FromDate.click();

		// select Date in Calendar

		for (WebElement day : dayOfCalendar_FromDate) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(sevenDay)) {

				Thread.sleep(1000);
				highLight(day);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		calendar_ToDate.click();

		// select Date in Calendar

		for (WebElement day : dayOfCalendar_ToDate) {

			String dayInCalender = day.getText();

			if (dayInCalender.equalsIgnoreCase(currentDay)) {

				Thread.sleep(1000);
				highLight(day);
				day.click();
				String getDateValue = day.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
		button_Go.click();
		Thread.sleep(1000);
		String fromDate = textbox_FromDate.getAttribute("value");
		System.out.println("fromDate: " + fromDate);
		Date fromDateInDate = (Date) dateFormat.parse(fromDate);

		String toDate = textbox_ToDate.getAttribute("value");
		System.out.println("toDate: " + toDate);
		Date toDateInDate = (Date) dateFormat.parse(toDate);

		int size = lstDateTime.size();
		System.out.println("size: " + size);
		boolean dateIsPresent = true;
		for (int i = 0; i < size; i++) {
			scrollDown(lstDateTime.get(i));
			highLight(lstDateTime.get(i));
			String date = lstDateTime.get(i).getText();
			System.out.println("date: " + date);
			Date dateTimeInDate = (Date) dateFormat.parse(date);

			if (dateTimeInDate.compareTo(fromDateInDate) >= 0
					&& dateTimeInDate.compareTo(toDateInDate) <= 0) {
				dateIsPresent = true;

			} else {
				dateIsPresent = false;
			}
			// Verify Date
			Assert.assertTrue(dateIsPresent,
					"Date And Time is not between Selected Days.");

		}
	}

	public void verifyExpenseType() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		try {
			tabRM.click();
			Thread.sleep(500);
			btnViewOfRM.click();

			// Get System Date
			Calendar sevendate = new GregorianCalendar();
			int dayOfMonth = sevendate.get(Calendar.DAY_OF_MONTH);
			int seven = dayOfMonth - 7;
			String sevenDay = Integer.toString(seven);
			System.out.println("sevenDay: " + sevenDay);

			// Get System Date
			Calendar mydate = new GregorianCalendar();
			int today = mydate.get(Calendar.DAY_OF_MONTH);
			String currentDay = Integer.toString(today);
			System.out.println("currentDay: " + currentDay);

			calendar_FromDate.click();

			// select Date in Calendar

			for (WebElement day : dayOfCalendar_FromDate) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(sevenDay)) {

					Thread.sleep(1000);
					highLight(day);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}

			calendar_ToDate.click();

			// select Date in Calendar

			for (WebElement day : dayOfCalendar_ToDate) {

				String dayInCalender = day.getText();

				if (dayInCalender.equalsIgnoreCase(currentDay)) {

					Thread.sleep(1000);
					highLight(day);
					day.click();
					String getDateValue = day.getText();
					System.out.println("Select the date:-" + getDateValue);

					break;
				}

			}
		} catch (Exception e) {

		}

		// Get drop down
		Select filterByexpenseType = new Select(ddlExpenseType);
		// Get list of Filter
		List<WebElement> listOfExpenseType = filterByexpenseType.getOptions();
		// Get size of Filter By Activity Header
		int sizeOfExpenseType = listOfExpenseType.size();
		// Print size of Filter By Activity Header
		System.out.println("\nsizeOfExpenseType: " + sizeOfExpenseType);
		// Apply For Loop for Activity Header
		for (; expenseType < sizeOfExpenseType; expenseType++) {
			// Get Activity Header
			String expenseTypeOptions = listOfExpenseType.get(expenseType)
					.getAttribute("value");
			// Print Activity Header
			System.out.println("\nexpenseTypeOptions: " + expenseTypeOptions);
			Thread.sleep(500);
			// Select Activity Header
			filterByexpenseType.selectByIndex(expenseType);
			Thread.sleep(500);
			button_Go.click();
			// Get size of Activity Header
			int sizeOfExpenseType1 = lstExpenseType.size();
			// Print size of Activity Header
			System.out.println("sizeOfExpenseType: " + sizeOfExpenseType1);

			// Check condition
			if (sizeOfExpenseType1 > 0) {
				// Apply For Loop for Activity Header
				for (int j = 0; j < sizeOfExpenseType1; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstExpenseType.get(j));
					highLight(lstExpenseType.get(j));
					// Get Activity Header
					String expenseFiler = lstExpenseType.get(j).getText();
					// Print Activity Header
					System.out.println("expenseFiler: " + expenseFiler);
					// Verify Activity Header
					softAssert.assertEquals(expenseFiler, expenseTypeOptions,
							"Activity Header is not Same");

				}
				// Update Activity Header
				expenseType = expenseType + 1;
				// Call Daily Activity Page Of Sd Role
				rm_ClaimApprovalPage = new RM_ClaimApprovalPage();
				// call check Data Filter By Activity Header Method
				rm_ClaimApprovalPage.verifyExpenseType();
				Thread.sleep(2000);
			} else if (sizeOfExpenseType1 == 0) {
				// Update Activity Header
				expenseType = expenseType + 1;
				// Call Daily Activity Page Of Sd Role
				rm_ClaimApprovalPage = new RM_ClaimApprovalPage();
				// call check Data Filter By Activity Header Method
				rm_ClaimApprovalPage.verifyExpenseType();
				Thread.sleep(2000);
			}

		}
		softAssert.assertAll();
	}

	public void verifyPageByViewAttachmentHyperlink() throws Exception {
		tabRM.click();
		Thread.sleep(500);
		btnViewOfRM.click();

		for (String listOfFileWindow1 : driver.getWindowHandles()) {
			driver.switchTo().window(listOfFileWindow1);

			int size = lstAttachment.size();
			System.out.println("size: " + size);
			for (int i = 0; i < size; i++) {
				scrollDown(lstAttachment.get(i));
				String link = lstAttachment.get(i).getText();
				System.out.println("link: " + link);
				if (link.equalsIgnoreCase("View Attachment")) {
					highLight(lstAttachment.get(i));
					lstAttachment.get(i).click();
					break;
				}

			}
			for (String listOfFileWindow2 : driver.getWindowHandles()) {
				driver.switchTo().window(listOfFileWindow2);
			}

			String heading = headingOfPage.getText();
			System.out.println("heading: " + heading);

			Assert.assertEquals(heading, "List of Files",
					"Page Heading is not Same.");
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "w");

			driver.switchTo().window(listOfFileWindow1);
		}
	}

	public void verifyNotificationByReject() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		tabRM.click();
		Thread.sleep(500);
		btnViewOfRM.click();
		String id = null;
		int idNumber = 0;
		try {
			int size = lstAttachment.size();
			System.out.println("size: " + size);
			for (int i = 0; i < size; i++) {
				scrollDown(lstReject.get(i));
				String link = lstReject.get(i).getText();
				System.out.println("link: " + link);
				if (link.equalsIgnoreCase("Reject")) {

					highLight(lstReject.get(i));
					scrollDown(lstId.get(i));
					highLight(lstId.get(i));
					id = lstId.get(i).getText();
					System.out.println("id: " + id);
					scrollDown(lstReject.get(i));
					highLight(lstReject.get(i));
					idNumber = i;
					scrollDown(lstReject.get(i));
					driver.findElement(By.linkText("Reject")).click();
					// lstReject.get(i).click();
					break;
				}

			}
		} catch (Exception e) {
			Assert.assertTrue(false, "Reject Link is not Present");
		}
		txtReject.sendKeys("Test");
		btnReject.click();

		Alert expenseTypeAlert = driver.switchTo().alert();
		String expenseType = expenseTypeAlert.getText();
		System.out.println("Alert Text:" + expenseType);
		Thread.sleep(2000);
		expenseTypeAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(expenseType, "Are You Sure Want To Reject?",
				"Alert massage is not Same.");

		// Get Notification
		Thread.sleep(1000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText, "Claim ID : '" + id
				+ "' Rejected.", "Notification is not Match");
		Thread.sleep(500);

		scrollDown(lstId.get(idNumber));
		highLight(lstId.get(idNumber));
		String idNo = lstId.get(idNumber).getText();
		System.out.println("id: " + idNo);

		scrollDown(lstComment.get(idNumber));
		highLight(lstComment.get(idNumber));
		String comment = lstComment.get(idNumber).getText();
		System.out.println("comment: " + comment);
		softAssert.assertEquals(comment, "Test", "Comment is not Same.");
		softAssert.assertAll();
	}

	public void checkNotificationByApproveClaim() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabRM.click();
		Thread.sleep(500);
		btnViewOfRM.click();

		int size = lstCheckbox.size();
		System.out.println("size: " + size);
		
		try {
			
			lstCheckbox.get(1).click();
			
			/*for (int i = 0; i < size; i++) {
				scrollDown(lstCheckbox.get(i));
				
				lstCheckbox.get(i).click();
				
					
			}*/
		} catch (Exception e) {
			Assert.assertTrue(false, "Check Box is not Present");
		}
		
		btnApprove.click();

		Alert expenseTypeAlert = driver.switchTo().alert();
		String expenseType = expenseTypeAlert.getText();
		System.out.println("Alert Text:" + expenseType);
		Thread.sleep(2000);
		expenseTypeAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(expenseType, "Are You Sure Want To Approve?",
				"Alert massage is not Same.");

		// Get Notification
		Thread.sleep(1000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText, "Claim Approved Successfully.", "Notification is not Match");
		Thread.sleep(500);
		softAssert.assertAll();
	}
}
