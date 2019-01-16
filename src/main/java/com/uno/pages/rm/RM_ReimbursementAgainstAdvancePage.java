package com.uno.pages.rm;

import java.util.Calendar;
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
import com.uno.pages.superrole.Super_ClaimPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketTypePage;

public class RM_ReimbursementAgainstAdvancePage extends BaseCode {

	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDmasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_TicketTypePage ticketTypePageOfSuperRole;
	Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
	Super_ClaimPage super_ClaimPage;
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_ClaimPage rm_ClaimPage;
	RM_CreateNewClaimPage rm_CreateNewClaimPage;
	RM_ReimbursementAgainstAdvancePage rm_ReimbursementAgainstAdvancePage;
	RM_ClaimApprovalPage rm_ClaimApprovalPage;

	// Drop down Advanced Claim ID
	@FindBy(css = "select[name='m_strAdvancedClaimID']")
	WebElement ddlAdvancedClaimID;

	// Drop down Expense Type
	@FindBy(css = "#m_strExpenseType1")
	WebElement ddlExpenseType;

	// Drop Down Expense Type
	@FindBy(css = "select[name='m_strExpenseType1']>option")
	List<WebElement> ddlListExpenseType;

	// Select SD tab for logout tab
	@FindBy(linkText = "Niraj1")
	WebElement link_RM;

	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement link_Test;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	@FindBy(xpath = ".//*[@id='item-details']/tbody/tr[1]/th")
	List<WebElement> lstColumnName;

	@FindBy(css = "input[name='m_strBillDateFrom1']")
	List<WebElement> txtFrom_ToBillDate;

	@FindBy(css = "input[name='m_strTicketId1']")
	List<WebElement> txtTicketID;

	// Text box Bill No.
	@FindBy(css = "input[name='m_strBillNo1']")
	WebElement txtBillNo;

	// Text box Bill Date
	@FindBy(css = "input[name='m_strBillDate1']")
	WebElement txtBillDate;

	// Text box Claim Amount
	@FindBy(css = "input[name='m_strBillAmount1']")
	WebElement txtClaimAmount;

	// Text box Description
	@FindBy(css = "input[name='m_strDescription1']")
	WebElement txtDescription;

	// Calendar Bill Date
	@FindBy(css = "#fd-but-fdDatePickerInput-0")
	WebElement calBillDate;

	// Date Picker Bill Date
	@FindBy(css = ".datePickerTable>tbody>tr>td")
	List<WebElement> dtpBillDate;

	// Calendar Bill Period From
	@FindBy(css = "#fd-but-fdDatePickerInput-1")
	WebElement calBillPeriodFrom;

	// Date Picker Bill Period From
	@FindBy(css = "#fd-fdDatePickerInput-1>table>tbody>tr>td")
	List<WebElement> dtpBillPeriodFrom;

	// Calendar Bill Period To
	@FindBy(css = "#fd-but-fdDatePickerInput-2")
	WebElement calBillPeriodTo;

	// Date Picker Bill Period To
	@FindBy(css = "#fd-fdDatePickerInput-2>table>tbody>tr>td")
	List<WebElement> dtpBillPeriodTo;

	// Button Browse
	@FindBy(css = ".file_browse")
	WebElement btnBrowse;

	// Button Submit
	@FindBy(css = "#add")
	WebElement btnSubmit;

	// List of File
	@FindBy(css = ".rectagleBox>table:nth-of-type(2)>tbody>tr[class='trHover']>td:nth-of-type(2)>a")
	WebElement lstFile;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;

	// List of Id
	@FindBy(css = ".rectagleBox>table>tbody>tr[class='trHover']>td:nth-of-type(1)>a")
	List<WebElement> lstId;

	// Heading
	@FindBy(css = ".heading")
	WebElement heading;

	@FindBy(linkText = "Attachment View")
	WebElement tabAttachmentView;

	// take list of "List Of Attachment " window
	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr[2]/td[2]")
	List<WebElement> list_ListOfAttachment;

	// List of Row
	@FindBy(css = "#item-details>tbody>tr")
	List<WebElement> lstRow;

	// Heading
	@FindBy(css = "#append1")
	WebElement btnPlus;

	// Heading
	@FindBy(css = "#remove1")
	WebElement btnMinus;

	public RM_ReimbursementAgainstAdvancePage() {
		PageFactory.initElements(driver, this);
	}

	public void varifyExpenseTypeWithSuperRole() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		ddlExpenseType.click();
		int expenseTypeSize = ddlListExpenseType.size() - 2;
		System.out.println("ExpenseTypeSize: " + expenseTypeSize);

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
		super_ClaimPage = empolyeeMasterPageOfSuperRole.clickOnClaimLink();
		Thread.sleep(1000);
		super_ClaimPage.linkExpenseTypeMaster.click();

		int sizeOfExpenseType = super_ClaimPage.lstExpenseType.size();
		highLight(super_ClaimPage.lstExpenseType.get(0));
		System.out.println("sizeOfExpenseType: " + sizeOfExpenseType);

		Thread.sleep(1000);
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
		rm_HomePage = new RM_HomePage();
		softAssert.assertEquals(expenseTypeSize, sizeOfExpenseType,
				"Expense Type Size is not Same.");

	}

	public void varifyColumnBySelectingPeriodicWiseClaim() throws Exception {
		SoftAssert softAssert = new SoftAssert();
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
		super_ClaimPage = empolyeeMasterPageOfSuperRole.clickOnClaimLink();
		Thread.sleep(1000);
		super_ClaimPage.linkExpenseTypeMaster.click();
		int sizeOfExpenseType = super_ClaimPage.lstPeriodicFlag.size();
		System.out.println("sizeOfExpenseType: " + sizeOfExpenseType);

		int sizeOfNoPeriodicFlag = 0;
		int sizeOfYesPeriodicFlag = 0;

		for (int j = 0; j < sizeOfExpenseType; j++) {
			String periodicFlag = super_ClaimPage.lstPeriodicFlag.get(j)
					.getText();
			System.out.println("periodicFlag: " + periodicFlag);
			highLight(super_ClaimPage.lstPeriodicFlag.get(j));

			if (periodicFlag.equalsIgnoreCase("No")) {
				sizeOfNoPeriodicFlag = sizeOfNoPeriodicFlag + 1;
				System.out.println("sizeOfNoPeriodicFlag: "
						+ sizeOfNoPeriodicFlag);
			}

			if (periodicFlag.equalsIgnoreCase("Yes")) {
				sizeOfYesPeriodicFlag = sizeOfYesPeriodicFlag + 1;
				System.out.println("sizeOfYesPeriodicFlag: "
						+ sizeOfYesPeriodicFlag);

			}

		}

		System.out.println("sizeOfNoPeriodicFlag: " + sizeOfNoPeriodicFlag);
		System.out.println("sizeOfYesPeriodicFlag: " + sizeOfYesPeriodicFlag);

		String arrayOfNoPeriodicFlag[] = new String[sizeOfNoPeriodicFlag];
		String arrayOfYesPeriodicFlag[] = new String[sizeOfYesPeriodicFlag];

		int sizeOfNoPeriodicFlag1 = 0;
		int sizeOfYesPeriodicFlag1 = 0;
		for (int i = 0; i < sizeOfExpenseType; i++) {
			String periodicFlag = super_ClaimPage.lstPeriodicFlag.get(i)
					.getText();
			System.out.println("periodicFlag: " + periodicFlag);
			highLight(super_ClaimPage.lstPeriodicFlag.get(i));

			if (periodicFlag.equalsIgnoreCase("No")) {

				System.out.println("sizeOfNoPeriodicFlag: "
						+ sizeOfNoPeriodicFlag1);
				highLight(super_ClaimPage.lstExpenseType.get(i));

				arrayOfNoPeriodicFlag[sizeOfNoPeriodicFlag1] = super_ClaimPage.lstExpenseType
						.get(i).getText();
				System.out.println("arrayOfNames[" + sizeOfNoPeriodicFlag1
						+ "]: " + arrayOfNoPeriodicFlag[sizeOfNoPeriodicFlag1]);
				System.out.println("\n");
				sizeOfNoPeriodicFlag1 = sizeOfNoPeriodicFlag1 + 1;

			}

			if (periodicFlag.equalsIgnoreCase("Yes")) {

				System.out.println("sizeOfYesPeriodicFlag: "
						+ sizeOfYesPeriodicFlag1);
				highLight(super_ClaimPage.lstExpenseType.get(i));

				arrayOfYesPeriodicFlag[sizeOfYesPeriodicFlag1] = super_ClaimPage.lstExpenseType
						.get(i).getText();
				System.out.println("arrayOfNames[" + sizeOfYesPeriodicFlag1
						+ "]: "
						+ arrayOfYesPeriodicFlag[sizeOfYesPeriodicFlag1]);
				System.out.println("\n");
				sizeOfYesPeriodicFlag1 = sizeOfYesPeriodicFlag1 + 1;

			}

		}
		System.out.println(arrayOfNoPeriodicFlag[0]);
		System.out.println(arrayOfNoPeriodicFlag[1]);
		// System.out.println(arrayOfNoPeriodicFlag[2]);
		System.out.println(arrayOfYesPeriodicFlag[0]);
		System.out.println(arrayOfYesPeriodicFlag[1]);
		System.out.println(arrayOfYesPeriodicFlag[2]);

		Thread.sleep(1000);
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
		rm_HomePage = new RM_HomePage();
		rm_ClaimPage = rm_HomePage.ClaimTab();
		Thread.sleep(1000);
		rm_ReimbursementAgainstAdvancePage = rm_ClaimPage
				.ReimbursementAgainstAdvanceTab();
		Thread.sleep(1000);
		System.out.println("sizeOfNoPeriodicFlag: " + sizeOfNoPeriodicFlag);

		// ddlExpenseType.click();
		
		Select select = new Select(ddlExpenseType);
		for (int i = 0; i < sizeOfNoPeriodicFlag; i++) {
			String expense = arrayOfNoPeriodicFlag[i].toString();
			System.out.println("expense: " + expense);
			select.selectByVisibleText(expense);
			Thread.sleep(2000);
			int From_ToBillDateSize = txtFrom_ToBillDate.size();
			for (int j = 0; j < From_ToBillDateSize; j++) {
				boolean From_ToBillDateIsPresent = txtFrom_ToBillDate.get(j)
						.isDisplayed();
				System.out.println("From_ToBillDateIsPresent: "
						+ From_ToBillDateIsPresent);
				softAssert.assertEquals(From_ToBillDateIsPresent, false,
						"From_To Bill Date Column is not Disable");

			}

		}
		System.out.println("sizeOfYesPeriodicFlag: " + sizeOfYesPeriodicFlag);
		for (int i = 0; i < sizeOfYesPeriodicFlag; i++) {
			String expense = arrayOfYesPeriodicFlag[i].toString();
			System.out.println("expense: " + expense);
			select.selectByVisibleText(expense);
			Thread.sleep(2000);
			int From_ToBillDateSize = txtFrom_ToBillDate.size();
			for (int j = 0; j < From_ToBillDateSize; j++) {
				boolean ticketIDIsPresent = txtTicketID.get(j).isDisplayed();
				System.out.println("ticketIDIsPresent: " + ticketIDIsPresent);
				softAssert.assertEquals(ticketIDIsPresent, false,
						"Ticket ID Column is not Disable");

			}
		}

	}

	public void checkSubmitButtonWithoutSelection() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Select select = new Select(ddlAdvancedClaimID);
		select.selectByIndex(1);

		btnSubmit.click();
		Alert expenseTypeAlert = driver.switchTo().alert();
		String expenseType = expenseTypeAlert.getText();
		System.out.println("Alert Text:" + expenseType);
		Thread.sleep(2000);
		expenseTypeAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(expenseType,
				"Please Select Expense Type for SR.NO. 1",
				"Alert massage is not Same.");

		Select expenseTypeSelect = new Select(ddlExpenseType);
		expenseTypeSelect.selectByVisibleText("monthly travel");
		btnSubmit.click();
		Alert billNoAlert = driver.switchTo().alert();
		String billNo = billNoAlert.getText();
		System.out.println("Alert Text:" + billNo);
		Thread.sleep(2000);
		billNoAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(billNo,
				"Please Enter From Bill Date for SR.NO.1",
				"Alert massage is not Same.");

		txtBillNo.sendKeys("101");
		btnSubmit.click();
		Alert billDateAlert = driver.switchTo().alert();
		String billDateText = billDateAlert.getText();
		System.out.println("Alert Text:" + billDateText);
		Thread.sleep(2000);
		billDateAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(billDateText,
				"Please Enter From Bill Date for SR.NO.1",
				"Alert massage is not Same.");

		calBillDate.click();
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		for (WebElement ele : dtpBillDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
				ele.click();
				String getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		btnSubmit.click();
		Alert billPeriodFromAlert = driver.switchTo().alert();
		String billPeriodFromText = billPeriodFromAlert.getText();
		System.out.println("Alert Text:" + billPeriodFromText);
		Thread.sleep(2000);
		billPeriodFromAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(billPeriodFromText,
				"Please Enter From Bill Date for SR.NO.1",
				"Alert massage is not Same.");

		Thread.sleep(2000);
		calBillPeriodFrom.click();
		Thread.sleep(1000);
		for (WebElement ele : dtpBillPeriodFrom) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(currentDay)) {
				Thread.sleep(2000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
				ele.click();
				String getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		Thread.sleep(2000);
		btnSubmit.click();
		Alert billPeriodToAlert = driver.switchTo().alert();
		String billPeriodToText = billPeriodToAlert.getText();
		System.out.println("Alert Text:" + billPeriodToText);
		Thread.sleep(2000);
		billPeriodToAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(billPeriodToText,
				"Please Enter To Bill Date for SR.NO. 1",
				"Alert massage is not Same.");

		calBillPeriodTo.click();
		driver.findElement(
				By.cssSelector("#fdDatePickerInput-2-next-month-but")).click();
		Thread.sleep(1000);
		for (WebElement ele : dtpBillPeriodTo) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(currentDay)) {
				Thread.sleep(1000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
				ele.click();
				String getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		btnSubmit.click();
		Alert claimAmountAlert = driver.switchTo().alert();
		String claimAmountText = claimAmountAlert.getText();
		System.out.println("Alert Text:" + claimAmountText);
		Thread.sleep(2000);
		claimAmountAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(claimAmountText,
				"Please Enter Bill Amount for SR.NO. 1",
				"Alert massage is not Same.");

		txtClaimAmount.sendKeys("Five");

		btnSubmit.click();

		Alert claimAmountAlert1 = driver.switchTo().alert();
		String claimAmountText1 = claimAmountAlert1.getText();
		System.out.println("Alert Text:" + claimAmountText1);
		Thread.sleep(2000);
		claimAmountAlert1.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(claimAmountText1,
				"Please Enter the Bill Amount in Numeric for SR.NO. 1",
				"Alert massage is not Same.");

		txtClaimAmount.clear();
		txtClaimAmount.sendKeys("@");
		btnSubmit.click();

		Alert claimAmountAlert2 = driver.switchTo().alert();
		String claimAmountText2 = claimAmountAlert2.getText();
		System.out.println("Alert Text:" + claimAmountText2);
		Thread.sleep(2000);
		claimAmountAlert2.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(claimAmountText2,
				"Please Enter the Bill Amount in Numeric for SR.NO. 1",
				"Alert massage is not Same.");

		txtClaimAmount.clear();
		txtClaimAmount.sendKeys("1500");
		btnSubmit.click();

		Alert descriptionAlert = driver.switchTo().alert();
		String descriptionText = descriptionAlert.getText();
		System.out.println("Alert Text:" + descriptionText);
		Thread.sleep(2000);
		descriptionAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals(descriptionText,
				"Please Enter Description for SR.NO. 1",
				"Alert massage is not Same.");

		txtDescription.sendKeys("Test");
		btnSubmit.click();
		// Get Notification
		Thread.sleep(5000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert
				.assertEquals(
						notificationText,
						"Your Total Bill Amount Is Greater Than Advance Claim Amount. Please Adjust Total Bill Amount Against Advance Amount. Then Create Payable Claim.",
						"Notification is not Match");
		Thread.sleep(1000);

		txtClaimAmount.clear();
		txtClaimAmount.sendKeys("10");
		btnSubmit.click();

		Alert fileAlert = driver.switchTo().alert();
		String fileText = fileAlert.getText();
		System.out.println("Alert Text:" + fileText);
		Thread.sleep(2000);
		fileAlert.accept();
		driver.switchTo().defaultContent();
		softAssert
				.assertEquals(
						"Your Total Bill Amount Is Less Than Advance Claim Amount. Do You Want To Submit?",
						fileText, "Alert massage is not Same.");

		// Get Notification
		Thread.sleep(5000);
		String notificationText1 = notification.getText();
		System.out.println(notificationText1);

		softAssert.assertEquals(notificationText1,
				"Claim Submitted Successfully", "Notification is not Match");
		Thread.sleep(1000);

		softAssert.assertAll();
	}

	public void checkRowSizeByApplyingPlusMinusSymbol() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		int size = lstRow.size();
		System.out.println("size: " + size);

		btnPlus.click();
		Thread.sleep(2000);
		int afterPlus = lstRow.size();
		System.out.println("afterPlus: " + afterPlus);
		softAssert.assertEquals(afterPlus, size + 1, "Row Size is not Same.");

		btnMinus.click();
		Thread.sleep(2000);
		int afterMinus = lstRow.size();
		System.out.println("afterMinus: " + afterMinus);
		softAssert.assertEquals(afterMinus, size, "Row Size is not Same.");
		softAssert.assertAll();

	}

	public void approveClaim() throws Exception {
		link_RM.click();
		Thread.sleep(1000);

		// click on logout
		link_LogOut.click();

		rm_LoginPage = new RM_LoginPage();
		Thread.sleep(1000);
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		rm_HomePage = new RM_HomePage();
		rm_ClaimPage = rm_HomePage.ClaimTab();
		Thread.sleep(1000);
		rm_ClaimApprovalPage = rm_ClaimPage.ClaimApprovalTab();
		Thread.sleep(1000);

	}

}
