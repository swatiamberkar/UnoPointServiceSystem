package com.uno.pages.rm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_ClaimPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketTypePage;

public class RM_CreateNewClaimPage extends BaseCode {

	private static String downloadPath = "C:\\Users\\Admin\\Downloads";
	
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDmasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_TicketTypePage ticketTypePageOfSuperRole;
	Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
	Super_ClaimPage super_ClaimPage;
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	String id=null;

	// Drop Down Expense Type
	@FindBy(css = "select[name='m_strExpenseType']")
	WebElement ddlExpenseType;

	// Drop Down Expense Type
	@FindBy(css = "select[name='m_strExpenseType']>option")
	List<WebElement> ddlListExpenseType;
	
	// Label Ticket ID
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[4]/td[1]")
	WebElement lblTicketID;
	
	// Label Claim Amount
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[6]/td[1]")
	WebElement lblClaimAmount;
	
	// Label Description
	@FindBy(xpath = ".//*[@id='right']/div[1]/div/table/tbody/tr[8]/td[1]")
	WebElement lblDescription;

	// Text box Bill No.
	@FindBy(css = "input[name='m_strBillNo']")
	WebElement txtBillNo;

	// Text box Bill Date
	@FindBy(css = "input[name='m_strBillDate']")
	WebElement txtBillDate;

	// Text box Ticket ID
	@FindBy(css = "input[name='m_strTicketId']")
	WebElement txtTicketID;

	// Text box Claim Amount
	@FindBy(css = "input[name='m_strBillAmount']")
	WebElement txtClaimAmount;

	// Text box Description
	@FindBy(css = "textarea[name='m_strDescription']")
	WebElement txtDescription;

	// Calendar Bill Date
	@FindBy(css = "a[id='fd-but-dp-1']")
	WebElement calBillDate;

	// Date Picker Bill Date
	@FindBy(css = ".datePickerTable>tbody>tr>td")
	List<WebElement> dtpBillDate;

	// Calendar Bill Period From
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calBillPeriodFrom;

	// Date Picker Bill Period From
	@FindBy(css = "div[id='fd-dp-2']>table>tbody>tr>td")
	List<WebElement> dtpBillPeriodFrom;

	// Calendar Bill Period To
	@FindBy(css = "a[id='fd-but-dp-3']")
	WebElement calBillPeriodTo;

	// Date Picker Bill Period To
	@FindBy(css = "div[id='fd-dp-3']>table>tbody>tr>td")
	List<WebElement> dtpBillPeriodTo;

	// Button Browse
	@FindBy(css = "input[name='m_theFile']")
	WebElement btnBrowse;

	// Button Add
	@FindBy(css = "a[onclick='addFiles();']")
	WebElement btnAdd;

	// Button Submit
	@FindBy(css = "a[onclick='callSubmit();']")
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
	
	// Select SD tab for logout tab
	@FindBy(linkText = "Niraj1")
	WebElement link_RM;
	
	// Select SD tab for logout tab
	@FindBy(linkText = "Test")
	WebElement link_Test;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	public RM_CreateNewClaimPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkSubmitButtonWithoutSelection() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		btnSubmit.click();
		Alert expenseTypeAlert = driver.switchTo().alert();
		String expenseType = expenseTypeAlert.getText();
		System.out.println("Alert Text:" + expenseType);
		Thread.sleep(2000);
		expenseTypeAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Select Expense Type.", expenseType,
				"Alert massage is not Same.");

		Select expenseTypeSelect = new Select(ddlExpenseType);
		expenseTypeSelect.selectByValue("Stationery");
		btnSubmit.click();
		Alert billNoAlert = driver.switchTo().alert();
		String billNo = billNoAlert.getText();
		System.out.println("Alert Text:" + billNo);
		Thread.sleep(2000);
		billNoAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Enter Bill No.", billNo,
				"Alert massage is not Same.");

		txtBillNo.sendKeys("101");
		btnSubmit.click();
		Alert billDateAlert = driver.switchTo().alert();
		String billDateText = billDateAlert.getText();
		System.out.println("Alert Text:" + billDateText);
		Thread.sleep(2000);
		billDateAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Enter Bill Date.", billDateText,
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
		softAssert.assertEquals("Please Enter Bill Period From.",
				billPeriodFromText, "Alert massage is not Same.");

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
		softAssert.assertEquals("Please Enter Bill Period To.",
				billPeriodToText, "Alert massage is not Same.");

		calBillPeriodTo.click();
		driver.findElement(By.cssSelector("#dp-3-next-month-but")).click();
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
		softAssert.assertEquals("Please Enter Claim Amount.", claimAmountText,
				"Alert massage is not Same.");

		txtClaimAmount.sendKeys("Five");

		btnSubmit.click();

		Alert claimAmountAlert1 = driver.switchTo().alert();
		String claimAmountText1 = claimAmountAlert1.getText();
		System.out.println("Alert Text:" + claimAmountText1);
		Thread.sleep(2000);
		claimAmountAlert1.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Enter Numeric Digit For Claim Amount.",
				claimAmountText1, "Alert massage is not Same.");

		txtClaimAmount.clear();
		txtClaimAmount.sendKeys("@");

		Alert claimAmountAlert2 = driver.switchTo().alert();
		String claimAmountText2 = claimAmountAlert2.getText();
		System.out.println("Alert Text:" + claimAmountText2);
		Thread.sleep(2000);
		claimAmountAlert2.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Enter Numeric Value", claimAmountText2,
				"Alert massage is not Same.");

		txtClaimAmount.sendKeys("500");
		btnSubmit.click();

		Alert descriptionAlert = driver.switchTo().alert();
		String descriptionText = descriptionAlert.getText();
		System.out.println("Alert Text:" + descriptionText);
		Thread.sleep(2000);
		descriptionAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Enter Description.", descriptionText,
				"Alert massage is not Same.");

		btnAdd.click();
		Alert fileAlert = driver.switchTo().alert();
		String fileText = fileAlert.getText();
		System.out.println("Alert Text:" + fileText);
		Thread.sleep(2000);
		fileAlert.accept();
		driver.switchTo().defaultContent();
		softAssert.assertEquals("Please Select File First.", fileText,
				"Alert massage is not Same.");

		softAssert.assertAll();
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public void downloadFileAndClickOnIcon() throws Exception {
		Robot robot = new Robot();
		Thread.sleep(2000);
		// robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);

		Screen screen = new Screen();
		Pattern downloadIcon = new Pattern("IconDownload.PNG");
		screen.wait(downloadIcon, 2000);
		screen.click();
	}

	public void checkSubmitButtonWithSelection() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Select expenseTypeSelect = new Select(ddlExpenseType);
		expenseTypeSelect.selectByValue("monthly travel");

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE);
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		// Get System Date
		Calendar sec1 = new GregorianCalendar();
		int sec2 = sec1.get(Calendar.SECOND);
		System.out.println(sec2);
		String sec3 = Integer.toString(sec2);

		String value = min3.concat(sec3);
		System.out.println("Dynamic Value: " + value);

		txtBillNo.sendKeys(value);

		calBillDate.click();
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH) + 1;
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
		calBillPeriodTo.click();
		driver.findElement(By.cssSelector("#dp-3-next-month-but")).click();
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

		txtClaimAmount.sendKeys(value);
		txtDescription.sendKeys("Stationary Expense");

		// Browse the file
		// Enter File Name
		String fileName = "Desert.jpg";
		System.out.println(fileName);
		// Enter File Path
		btnBrowse
				.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		btnAdd.click();

		String fileValue = lstFile.getText();
		System.out.println("fileValue: " + fileValue);

		Thread.sleep(2000);
		softAssert.assertEquals(fileValue, fileName, "File Name is not Match");

		driver.findElement(By.linkText(fileValue)).click();

		downloadFileAndClickOnIcon();

		Thread.sleep(2000);
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName1 = getLatestFile.getName();
		System.out.println("fileName1: " + fileName1);
		String strNew = fileName1.replace("( )", " ");
		System.out.println("strNew: " + strNew);
		// String str=fileName1.substring(1, fileName1.length());
		// System.out.println("str: "+str);

		softAssert.assertEquals(strNew, fileValue,
				"Downloaded file name is not matching with expected file name");
		Thread.sleep(2000);

		btnSubmit.click();

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert Text:" + text);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		// Get Notification
		Thread.sleep(5000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Claim Submitted Successfully", "Notification is not Match");
		Thread.sleep(1000);

		highLight(lstId.get(1));
		lstId.get(1).click();

		for (String Window : driver.getWindowHandles()) {

			System.out.println(Window);
			driver.switchTo().window(Window);

			String headingOfPage = heading.getText();
			System.out.println("headingOfPage: " + headingOfPage);
			Thread.sleep(1000);
			softAssert.assertEquals(headingOfPage, "Single Claim View",
					"Heading is not Same.");

			tabAttachmentView.click();
			for (String listOfAttachmentsWindow : driver.getWindowHandles()) {

				System.out.println(listOfAttachmentsWindow);
				driver.switchTo().window(listOfAttachmentsWindow);

			}
			try {
				List<WebElement> attachmentListValue = list_ListOfAttachment;
				int getSizeOfAllFile = attachmentListValue.size();
				System.out.println(getSizeOfAllFile);
				Thread.sleep(1000);
				String getAttachmentFileName = list_ListOfAttachment.get(
						getSizeOfAllFile - 1).getText();
				System.out.println(getAttachmentFileName);

				softAssert.assertEquals(getAttachmentFileName, fileName);
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");
				driver.switchTo().window(Window);
				break;

			} catch (Exception e) {

				softAssert.assertTrue(false,
						"Table of File Attachement is not present");
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");
				driver.switchTo().window(Window);

			}
		}
		softAssert.assertAll();
	}

	public void varifyExpenseTypeWithSuperRole() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		ddlExpenseType.click();
		 int expenseTypeSize =ddlListExpenseType.size()-1;
		 System.out.println("ExpenseTypeSize: "+expenseTypeSize);
		 
		 	link_RM.click();
			Thread.sleep(1000);

			// click on logout
			link_LogOut.click();
			
			loginPageOfSuperRole =new Super_LoginPage();
			homePageOfSuperRole = loginPageOfSuperRole.Login(
					properties.getProperty("loginIdForSuper"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			empolyeeMasterPageOfSuperRole=homePageOfSuperRole.clickEmpolyeeMasterlink();
			Thread.sleep(1000);
			super_ClaimPage=empolyeeMasterPageOfSuperRole.clickOnClaimLink();
			Thread.sleep(1000);
			super_ClaimPage.linkExpenseTypeMaster.click();
			
			int sizeOfExpenseType=super_ClaimPage.lstExpenseType.size();
			highLight(super_ClaimPage.lstExpenseType.get(0));
			System.out.println("sizeOfExpenseType: "+sizeOfExpenseType);
			
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
			softAssert.assertEquals(expenseTypeSize, sizeOfExpenseType,"Expense Type Size is not Same.");
		 
		
	}
	
	public void varifyColumnBySelectingAdvanceClaim() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Select expenseType =new Select(ddlExpenseType);
		expenseType.selectByValue("Advance Claim");
		
		String TicketID ="Ticket ID";
		String TicketIDCol=lblTicketID.getText();
		System.out.println("TicketIDCol: "+TicketIDCol);
		softAssert.assertEquals(TicketIDCol, TicketID,"Column Name is not Same.");
		
		String ClaimAmount ="Claim Amount";
		String claimAmountCol=lblClaimAmount.getText();
		System.out.println("claimAmountCol: "+claimAmountCol);
		softAssert.assertEquals(claimAmountCol, ClaimAmount,"Column Name is not Same.");
		
		String description ="Description";
		String descriptionCol=lblDescription.getText();
		System.out.println("descriptionCol: "+descriptionCol);
		softAssert.assertEquals(descriptionCol, description,"Column Name is not Same.");
		
		txtClaimAmount.sendKeys("500");
		txtDescription.sendKeys("Offical");
		btnSubmit.click();
		
		Alert alertTicketID = driver.switchTo().alert();
		String textTicketID = alertTicketID.getText();
		System.out.println("Alert Text:" + textTicketID);
		Thread.sleep(2000);
		alertTicketID.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(textTicketID,
				"Are You Sure Want To Submit?", "Notification is not Match");
		Thread.sleep(2000);
		
		// Get Notification	
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Claim Submitted Successfully", "Notification is not Match");
		Thread.sleep(1000);
		
		
		softAssert.assertAll();
	}

	public void checkNotificationWithAndWithoutTicketID() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Select expenseTypeSelect = new Select(ddlExpenseType);
		expenseTypeSelect.selectByValue("Local Travel");

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE);
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		// Get System Date
		Calendar sec1 = new GregorianCalendar();
		int sec2 = sec1.get(Calendar.SECOND);
		System.out.println(sec2);
		String sec3 = Integer.toString(sec2);

		String value = min3.concat(sec3);
		System.out.println("Dynamic Value: " + value);

		txtBillNo.sendKeys(value);

		calBillDate.click();
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH) + 1;
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
		String 	ticketID="10000";
		//txtTicketID.sendKeys(ticketID);

		txtClaimAmount.sendKeys(value);
		txtDescription.sendKeys("Travelling");
		btnSubmit.click();
		
		Alert alertTicketID = driver.switchTo().alert();
		String textTicketID = alertTicketID.getText();
		System.out.println("Alert Text:" + textTicketID);
		Thread.sleep(2000);
		alertTicketID.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(textTicketID,
				"Please Enter Ticket ID.", "Notification is not Match");
		Thread.sleep(2000);
		
		txtTicketID.sendKeys(ticketID);
		btnSubmit.click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert Text:" + text);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		softAssert.assertEquals(text,
				"Are You Sure Want To Submit?", "Notification is not Match");
		Thread.sleep(2000);
		
		// Get Notification	
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Please enter valid Ticket ID. Ticket ID : '"+ ticketID+"' is not present in system.", "Notification is not Match");
		Thread.sleep(1000);
		
		
		softAssert.assertAll();
	}
	
	public void createClaim() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Select expenseTypeSelect = new Select(ddlExpenseType);
		expenseTypeSelect.selectByValue("Advance Claim");

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE);
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		// Get System Date
		Calendar sec1 = new GregorianCalendar();
		int sec2 = sec1.get(Calendar.SECOND);
		System.out.println(sec2);
		String sec3 = Integer.toString(sec2);

		String value = min3.concat(sec3);
		System.out.println("Dynamic Value: " + value);

		txtBillNo.sendKeys(value);

		calBillDate.click();
		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH) + 1;
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
		calBillPeriodTo.click();
		driver.findElement(By.cssSelector("#dp-3-next-month-but")).click();
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

		txtClaimAmount.sendKeys(value);
		txtDescription.sendKeys("Stationary Expense");
	
		btnSubmit.click();

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert Text:" + text);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		// Get Notification
		Thread.sleep(5000);
		String notificationText = notification.getText();
		System.out.println(notificationText);

		softAssert.assertEquals(notificationText,
				"Claim Submitted Successfully", "Notification is not Match");
		Thread.sleep(1000);

		highLight(lstId.get(0));
		id=lstId.get(0).getText();
		System.out.println("id: "+id);
		
		softAssert.assertAll();
	}
}
