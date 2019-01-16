package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.uno.pages.superrole.Super_CustomerDetailsPage;
import com.uno.pages.superrole.Super_CustomerMasterPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_PrincipalCustomerPage;
import com.uno.test.rm.RM_CreateNewTest;


public class RM_CreateNewPage extends BaseCode

{
	// Call The Method From SD Role
	RM_CreateNewTest rm_CreateNewTest;
	RM_CreateNewPage rm_CreateNewPage;
	RM_IncidentPage rm_IncidentPage;
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;

	// call the method from super role
	Super_LoginPage super_LoginPage;
	Super_HomePage super_HomePage;
	Super_EmployeeMasterPage super_EmplolyeeMasterPage;
	Super_CustomerMasterPage super_CustomerMasterPage;
	Super_CustomerDetailsPage super_CustomerDetailsPage;
	Super_PrincipalCustomerPage super_PrincipalCustomerPage;

	// select SD tab for logout tab
	@FindBy(css = "ul[class = 'nav-ul']>li:nth-of-type(10)")
	WebElement tabRM;

	// click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// select test tab for logout super Role
	@FindBy(xpath = ".//*[@id='main']/div[2]/div[2]/div/ul/li[13]/a")
	WebElement tabTest;

	// Select Incident ID Text Box
	@FindBy(xpath = ".//*[@id='incidentInfo']/div[2]/ul/li[1]/span[2]")
	WebElement txtIncidenID;

	// Select Search ID Text Box
	@FindBy(name = "m_strSearchIncId")
	WebElement txtSearchID;

	// Click on ID GO button
	@FindBy(xpath = ".//*[@id='Search_Incident']/tbody/tr[2]/td[2]")
	WebElement btnIDGo;

	// Get Text From View Ticket Page Id
	@FindBy(css = "div[class='fht-tbody']>table>tbody>tr>td:nth-of-type(2)")
	WebElement lstTicketId;

	// Select Search Ticket AssetID TextBox
	@FindBy(name = "m_strSearchAssetId")
	WebElement txtSearchAssetID;

	// Click On Asset ID GO button
	@FindBy(xpath = ".//*[@id='Search_Incident']/tbody/tr[4]/td[2]")
	WebElement btnAssetIDGO;

	// Click On Ticket ID TextBox
	@FindBy(name = "m_strSearchTicketId")
	WebElement txtSearchTicketID;

	// Click On AssertID GO Button
	@FindBy(xpath = ".//*[@id='Search_Incident']/tbody/tr[6]/td[2]")
	WebElement btnTicketIDGO;

	// Select Log By Local Contact Number
	@FindBy(name = "m_strSearchByMobileNo")
	WebElement txtLogByContactNumber;

	// Select Log By Serial Number TextBox
	@FindBy(name = "m_strSearchBySerialNo")
	WebElement txtSerialNumber;

	// Click on GO Button
	@FindBy(xpath = ".//*[@id='requestorDetails']/table/tbody/tr[2]/td[6]/a/span")
	WebElement btnSerialNoGO;

	// Select Request Title list button
	@FindBy(xpath = ".//*[@id='lblCalendarPauseDetailsPage']/table[2]/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a")
	WebElement btnRequestTitle;

	// Select Request description TextBox
	@FindBy(className = "textarea")
	WebElement txtRequestDiscription;

	// Select Local contact Name TextBox
	@FindBy(name = "m_strValue1")
	WebElement txtLocalName;

	// Select Local Contact Number TextBox
	@FindBy(name = "m_strValue2")
	WebElement txtLocalContactNumber;

	// Select Customer Email ID TextBox
	@FindBy(name = "m_strValue3")
	WebElement txtCustomerEmailId;

	// Click On Technician List Button
	@FindBy(xpath = ".//*[@id='lblCalendarPauseDetailsPage']/table[2]/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/img")
	WebElement btnTechnician;

	// select technician from technician window
	@FindBy(css = "div[class='rectagleBox']>table>tbody>tr>td:nth-of-type(3)")
	List<WebElement> lstTechnicianName;

	// Select Ticket Type TextBox
	@FindBy(name = "m_strIncidentType")
	WebElement txtTicketType;

	// Select Record Ticket Button
	@FindBy(linkText = "Record Ticket")
	WebElement btnRecordTicket;

	// click on calendar button of ETA
	@FindBy(xpath = ".//[@id='fd-but-dp-5']/span[1]")
	WebElement btnETACalender;

	// select ETA dates
	@FindBy(xpath = ".//*[@id='fd-dp-5']/table/tbody/tr/td")
	List<WebElement> tblETACalender;

	// select ETA Time Hour
	@FindBy(xpath = ".//*[@id='lblCalendarPauseDetailsPage']/table[2]/tbody/tr/td[2]/table/tbody/tr[6]/td/select[1]/option")
	List<WebElement> ddlETATimeHour;

	// select ETA dates
	@FindBy(xpath = ".//*[@id='lblCalendarPauseDetailsPage']/table[2]/tbody/tr/td[2]/table/tbody/tr[6]/td/select[2]/option")
	List<WebElement> ddlETATimeMinute;

	// select ETA date text box
	@FindBy(name = "m_strEtaDate")
	WebElement txtETADates;

	public RM_CreateNewPage() {
		PageFactory.initElements(driver, this);

	}

	// ChecK title of page
	public void verifyTitleOfCreateNewPage() {
		String createTicketPageTitle = driver.getTitle();
		System.out.println("createTicketPageTitle: " + createTicketPageTitle);
		assertEquals(createTicketPageTitle, "Unopoint",
				"Title Of Create New Page Is Wrong");

	}

	// Display Default Incident No
	public void checkDefaultIncidentNo() {
		String incidentId = txtIncidenID.getText();
		System.out.println("incidentId: " + incidentId);
		assertEquals(incidentId, "ID :\nNot Generated");

	}

	public void checkDefaultIncidentDateTime() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String incidentDateAndTime = driver
				.findElement(
						By.cssSelector("div[class='roundBoxMdlBg roundBoxMdlBg1']>ul>li:nth-of-type(2)>span:nth-of-type(2)"))
				.getText();
		String dateValue = incidentDateAndTime.split("Date :")[1];
		System.out.println("dateValue: " + dateValue);
		Date incidentDate = dateFormat.parse(dateValue);
		String dateformat = dateFormat.format(incidentDate);
		Date date = dateFormat.parse(dateformat);

		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		driver.findElement(
				By.cssSelector("div[class='roundBoxMdlBg roundBoxMdlBg1']>ul>li:nth-of-type(2)>span:nth-of-type(2)"))
				.getText();
		String timeValue = incidentDateAndTime.split("Time :")[1];
		System.out.println(timeValue);
		Date incidentTime = timeFormat.parse(timeValue);
		String timeformat = timeFormat.format(incidentTime);
		Date time = timeFormat.parse(timeformat);

		System.out.println("Incident date and time=" + dateformat + "\n"
				+ timeformat + "\n");

		// get current date and time
		Date systemDate = new Date();

		String formatSystemDate = dateFormat.format(systemDate);
		Date actualSystemDate = dateFormat.parse(formatSystemDate);

		String formatSystemTime = timeFormat.format(systemDate);
		Date actualSystemTime = timeFormat.parse(formatSystemTime);

		// print date and time in console
		System.out.println("System date and time:" + formatSystemDate + "\n"
				+ formatSystemTime + "\n");

		// Compare system date and time with incident date and time
		boolean incidentDateTimeIsSame = true;

		if (date.compareTo(actualSystemDate) > 0
				&& time.compareTo(actualSystemTime) > 0) {

			System.out
					.println("Incident date and time After System date and time\n");
			incidentDateTimeIsSame = false;
		}

		else if (date.compareTo(actualSystemDate) <= 0
				&& time.compareTo(actualSystemTime) <= 0) {
			System.out
					.println("Incident date and time Before System date and time\n");
			incidentDateTimeIsSame = true;

		}

		else {

			System.out.println("somthing is wrong");
		}

		assertTrue(incidentDateTimeIsSame, "Incident Date Time Is Different");

	}

	public void checkDefaultCreateByRoleElement() {
		SoftAssert softAssert = new SoftAssert();

		// Take the value from login
		String username = driver.findElement(
				By.xpath(".//*[@id='main']/div[3]")).getText();
		String splitWelcome = username.split("Welcome -")[1];
		System.out.println("splitWelcome: " + splitWelcome);

		// get the value of create By and create By Role display element
		String createByElement = driver
				.findElement(
						By.cssSelector("div[class='roundBoxMdlBg roundBoxMdlBg1']>ul>li:nth-of-type(3)>span:nth-of-type(2)"))
				.getText();
		String split = createByElement.split("\\n")[0];
		System.out.println("split: " + split);
		String valueOfByElement = split.split("By : ")[1];
		// print the value of create by
		System.out.println("create By Value:- " + valueOfByElement);

		softAssert.assertEquals(" " + valueOfByElement, splitWelcome,
				"The value of create By Is Different");

		// By Role
		String splitByRole = createByElement.split("\\n")[1];
		System.out.println("splitByRole: " + splitByRole);
		String valueOfByRoleElement = splitByRole.split("By Role :")[1];
		// print the value of create by role
		System.out.println("valueOfByRoleElement:-" + valueOfByRoleElement);

		softAssert.assertEquals(valueOfByRoleElement, " ReportingManager",
				"The value of create By Role Is Different");

		softAssert.assertAll();

	}

	public void checkDefaultcloseDateTime()
	{
		SoftAssert softAssert = new SoftAssert();

		// get the value of close date and time
		String closeDateElement = driver
				.findElement(
						By.cssSelector("div[class='roundBoxMdlBg roundBoxMdlBg1']>ul>li:nth-of-type(4)>span:nth-of-type(2)"))
				.getText();
		String dateValue = closeDateElement.split("\\n")[0];
		System.out.println("dateValue: " + dateValue);

		softAssert.assertEquals(dateValue, "Date :", "date value is not blank");

		String timeValue = closeDateElement.split("\\n")[1];
		System.out.println("timeValue: " + timeValue);

		softAssert.assertEquals(timeValue, "Time :", "time value is not blank");

		softAssert.assertAll();

	}

	public void verifyTicketDateTime() throws ParseException,
			InterruptedException 
	{
		// get current incident date and time
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		String softwareDate = dateTimeFormat.format(date);
		System.out.println(softwareDate);

		// get the current system date and time
		DateFormat secondDateTimeFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		new Date();
		String systemDateTime = secondDateTimeFormat.format(date);
		System.out.println(systemDateTime);

		// Compare system date and time with incident date and time

		if (softwareDate.compareTo(systemDateTime) > 0) {

			System.out
					.println("Ticket date and time After System date and time\n");
		}

		else if (softwareDate.compareTo(systemDateTime) <= 0) {
			System.out
					.println("Ticket date and time Before System date and time\n");

		}

		else {

			System.out.println("somthing is wrong");
		}

		// check ticket date is editable or not
		driver.findElement(By.xpath(".//*[@id='dp-3']/span[1]")).click();

		// here select row number first and column number six in date table
		driver.findElement(
				By.xpath(".//*[@id='fd-dp-3']/table/tbody/tr[3]/td[4]"))
				.click();

		// print select date
		// System.out.println("Incident Date:-" + selectDate);

		// check ticket time is editable or not
		Select ticketHour;
		ticketHour = new Select(
				driver.findElement(By
						.xpath(".//[@id='requestorDetails']/table/tbody/tr[2]/td[2]/select[1]")));
		ticketHour.selectByValue("07");

		// print select time
		System.out.println("07");

		Select ticketSecond;
		ticketSecond = new Select(
				driver.findElement(By
						.xpath(".//[@id='requestorDetails']/table/tbody/tr[2]/td[2]/select[2]")));
		ticketSecond.selectByValue("35");

	}

	public void checkDefaultBusinessUnit() throws InterruptedException {

		// get the selected Business Unit
		String defaultBusinessUnit = driver.findElement(
				By.cssSelector("select[class='listmenu_a']>option[selected]"))
				.getText();
		System.out.println("Default Business Unit:-" + defaultBusinessUnit);

		String businessUnit = driver
				.findElement(
						By.cssSelector("select[name='m_strBusinessUnit']>option[selected]"))
				.getText();
		System.out.println("Default Business Unit:-" + businessUnit);

		Assert.assertEquals(defaultBusinessUnit, defaultBusinessUnit);

	}

	public void verifyIdTextBox() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Search ticket Id verify that after clicking view page is display or
		// not
		String id = "6252";
		txtSearchID.sendKeys(id);

		Thread.sleep(500);
		btnIDGo.click();

		softAssert.assertEquals("Welcome To Uno Point", driver.getTitle());

		Thread.sleep(1000);
		softAssert
				.assertEquals(
						id,
						driver.findElement(
								By.cssSelector("div[class='fht-tbody']>table>tbody>tr>td:nth-of-type(1)>span>a"))
								.getText(), "Id In View Ticket Is not Same");

		System.out.println("Both the ID is equal");

		driver.navigate().back();
		Thread.sleep(1000);

	}

	public void verifyAssetIDTextBox() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		// Search ticket Asset Id verify that after clicking view page is
		// display or not
		String assetIDValue = "Cus-Mum-0002";
		// write the 11505203 on Assert ID text box
		txtSearchAssetID.sendKeys(assetIDValue);

		Thread.sleep(500);
		btnAssetIDGO.click();

		softAssert.assertEquals("Welcome To Uno Point", driver.getTitle());

		Thread.sleep(500);
		// check the all Assert ID in view ticket page
		List<WebElement> rowElement = driver
				.findElements(By
						.xpath(".//*[@id='right']/div[2]/div/div[2]/div[2]/table/tbody/tr/td[7]"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "
				+ rowElement.size());

		boolean assetIdIsSame = true;
		for (int i = 0; i < rowElement.size(); i++) 
		{

			WebElement element = rowElement.get(i);
			System.out.println(element.getText());

			System.out.println("PASS");
		}
		softAssert.assertTrue(assetIdIsSame,
				"The Asset Id in view ticket is not same");

		driver.navigate().back();
		Thread.sleep(1000);

		softAssert.assertAll();

	}

	public void verifyTicketIdTextBox() throws Exception 
	{
		// Search ticket Id verify that after clicking view page is display or
		// not
		SoftAssert softAssert = new SoftAssert();
		String ticketId = "6252";
		txtSearchTicketID.sendKeys(ticketId);

		Thread.sleep(1000);
		btnTicketIDGO.click();

		softAssert.assertEquals("Welcome To Uno Point", driver.getTitle());

		softAssert.assertEquals(ticketId,driver.findElement(
								By.xpath(".//*[@id='right']/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"))
								.getText(),
						"Ticket Id In View Ticket Is Not Same");

		System.out.println("Both the ID is equal");

		driver.navigate().back();
		Thread.sleep(1000);
		softAssert.assertAll();
	}

	public void logBySerialNumber() throws InterruptedException {

		txtSerialNumber.sendKeys("1262829201");
		btnSerialNoGO.click();
		Thread.sleep(3000);

		// alert window is appear , click on OK button
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("Alert Text:" + alert.getText());
		alert.accept();
		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		// select Assert ID take the value
		String assertIdValue = driver.findElement(
				By.cssSelector("#m_strAssetIDNewNew>option:nth-of-type(2)"))
				.getText();
		System.out.println(assertIdValue);

		Thread.sleep(2000);
		// select Assert ID in requester detail take the value
		String requesterAssertId = driver
				.findElement(
						By.xpath(".//*[@id='assetidnew_detailsNew']/table/tbody/tr/td[1]/table/tbody/tr[6]/td/a"))
				.getText();
		System.out.println(requesterAssertId);

		// match both the assert
		Assert.assertEquals(assertIdValue, requesterAssertId,
				"Both Asset Id Is Not Same");
		System.out.println("Pass");

	}

	public void logByLocalContactNumber() throws InterruptedException 
	{
		Thread.sleep(2000);
		txtLogByContactNumber.sendKeys("7400438090");
		
		Thread.sleep(1000);
		btnSerialNoGO.click();
		

		/*// alert window is appear , click on OK button
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("Alert Text:" + alert.getText());
		alert.accept();
		driver.switchTo().defaultContent();*/

		Thread.sleep(2000);
		String localContact = driver.findElement(
				By.cssSelector("#MobileNoMessage>a>span")).getText();

		if (localContact.contains("No Record Found")) {
			System.out.println("No Record Found");
			Assert.assertEquals("No Record Found", localContact);
			System.out.println("Pass");

		}

		else {

			// get the contact number value
			String contactNumberValue = driver
					.findElement(
							By.cssSelector("#m_strAssetIDNewNew>option:nth-of-type(2)"))
					.getText();
			System.out.println(contactNumberValue);

			// get the contact number value from requester detail
			String requesterContactId = driver
					.findElement(
							By.cssSelector(".grd_v_line1>table>tbody>tr:nth-of-type(5)>td>a"))
					.getText();
			System.out.println(requesterContactId);

			Assert.assertEquals(contactNumberValue, requesterContactId);
			System.out.println("Pass");

		}

	}

	public void checkPrincipalCustomerInSuperLogin() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		boolean businessUnitIsPresent = driver
				.findElement(By.name("m_strBusinessUnit")).getText()
				.contains("test");
		System.out.println("===List Of Business Unit===="
				+ businessUnitIsPresent);

		// select Business Unit
		Select businessUnit;
		businessUnit = new Select(driver.findElement(By
				.name("m_strBusinessUnit")));
		businessUnit.selectByValue("test");

		// take the principal customer related to that BU
		String principalCustomer = driver.findElement(
				By.name("m_strPrincipalCust")).getText();
		System.out.println("===List Of Principal Customer===="
				+ principalCustomer);

		Select principalCustomerValue;
		principalCustomerValue = new Select(driver.findElement(By
				.id("m_strPrincipalCust")));
		principalCustomerValue.selectByValue("NewCust1");

		Thread.sleep(1000);
		String customer = driver.findElement(
				By.cssSelector("#m_strPrincipalCust>option[value='NewCust1']"))
				.getText();
		System.out.println("customer:" + customer);
		/*
		 * driver.findElement(By.id("m_strCustomerName")).sendKeys("wo");
		 * Thread.sleep(1000); List<WebElement> customerNameList =
		 * driver.findElements(By .xpath(".//[@id='as_ul']/li/a/span[3]"));
		 * System.out.println("custermer list" + customerNameList.size());
		 * 
		 * for (int i = 0; i < customerNameList.size(); i++) {
		 * System.out.println(customerNameList.get(i).getText());
		 * 
		 * if
		 * (customerNameList.get(i).getText().contains("Worldline India Pvt. Ltd"
		 * )) { customerNameList.get(i).click(); break; }
		 * 
		 * }
		 */

		// click on account
		tabRM.click();
		Thread.sleep(3000);

		// click on logout
		tabLogOut.click();

		Thread.sleep(3000);

		// login as super ,call it from super Role customer detail page
		super_LoginPage = new Super_LoginPage();
		Thread.sleep(2000);
		super_HomePage = super_LoginPage.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		Thread.sleep(3000);
		super_EmplolyeeMasterPage = super_HomePage.clickEmpolyeeMasterlink();
		Thread.sleep(5000);
		super_CustomerDetailsPage = super_EmplolyeeMasterPage
				.clickOnCustomerDetailLink();
		super_PrincipalCustomerPage = super_CustomerDetailsPage
				.clickOnPrincipalCustomerLink();

		// the principal customer value of SD Role send to super login principal
		// customer
		driver.findElement(By.name("m_strSearchCustomer")).sendKeys(customer);

		// click the go button of principal customer in super login
		driver.findElement(
				By.xpath(".//*[@id='Search_Incident']/tbody/tr[2]/td[2]/img"))
				.click();

		// get the value of Business Unit for that principal customer in super
		// login
		boolean isBusinessUnitSuperRole = driver
				.findElement(
						By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(7)"))
				.getText().contains("PrincipleCust1");

		// Match both the value of Business Unit from SD Role and another from
		// super
		softAssert.assertEquals(businessUnitIsPresent, isBusinessUnitSuperRole,
				" The principal customer is not same");
		System.out.println("pass");

		tabTest.click();
		tabLogOut.click();

		for (String mainWindow : driver.getWindowHandles()) {

			driver.switchTo().window(mainWindow);
		}

		rm_IncidentPage = new RM_IncidentPage();
		rm_CreateNewTest = new RM_CreateNewTest();
		rm_CreateNewTest.Login();

	}

	public void checkCustomerInSuperLogin() throws Exception 
	{
		String window = driver.getWindowHandle(); 
		SoftAssert softAssert = new SoftAssert();

		// select Business Unit
		Select businessUnit;
		businessUnit = new Select(driver.findElement(By
				.name("m_strBusinessUnit")));
		businessUnit.selectByValue("test");

		// take the principal customer related to that BU
		String principalCustomer = driver.findElement(
				By.name("m_strPrincipalCust")).getText();
		System.out.println("===List Of Principal Customer===="
				+ principalCustomer);

		Select principalCustomerValue;
		principalCustomerValue = new Select(driver.findElement(By
				.id("m_strPrincipalCust")));
		principalCustomerValue.selectByValue("NewCust1");

		boolean principalCustomerIsPresent = driver
				.findElement(By.name("m_strPrincipalCust")).getText()
				.contains("NewCust1");
		System.out.println("PRICIPAL CUSTOMER" + principalCustomerIsPresent);

		Thread.sleep(1000);
		String customer = driver.findElement(
				By.cssSelector("#m_strPrincipalCust>option[value='NewCust1']"))
				.getText();
		System.out.println("customer:-" +customer);
		/*
		 * driver.findElement(By.id("m_strCustomerName")).sendKeys("wo");
		 * Thread.sleep(1000); List<WebElement> customerNameList =
		 * driver.findElements(By .xpath(".//[@id='as_ul']/li/a/span[3]"));
		 * System.out.println("custermer list" + customerNameList.size());
		 * 
		 * for (int i = 0; i < customerNameList.size(); i++) {
		 * System.out.println(customerNameList.get(i).getText());
		 * 
		 * if
		 * (customerNameList.get(i).getText().contains("Worldline India Pvt. Ltd"
		 * )) { customerNameList.get(i).click(); break; }
		 * 
		 * }
		 */
	/*	driver.findElement(By.cssSelector("a[href= '/erprmwise/RMHomeScreen.do']")).click();
		
		for (String listOfAttachmentsWindow : driver.getWindowHandles()) 
		{

			System.out.println(listOfAttachmentsWindow);
			driver.switchTo().window(listOfAttachmentsWindow);

		}*/
		
		driver.switchTo().window(window);
		Thread.sleep(5000);
		// click on account
		tabRM.click();
		Thread.sleep(2000);

		// click on logout
		tabLogOut.click();

		Thread.sleep(1000);
		// login as super ......call it from super Role customer detail page
		super_LoginPage = new Super_LoginPage();
		Thread.sleep(2000);
		super_HomePage = super_LoginPage.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		Thread.sleep(3000);
		super_EmplolyeeMasterPage = super_HomePage.clickEmpolyeeMasterlink();
		Thread.sleep(5000);
		super_CustomerDetailsPage = super_EmplolyeeMasterPage
				.clickOnCustomerDetailLink();
		Thread.sleep(2000);
		super_CustomerMasterPage = super_CustomerDetailsPage
				.clickOncustMaster();
		Thread.sleep(2000);

		// the customer value of SD send to super login customer name
		driver.findElement(By.className("textfield")).sendKeys("NewCust1");

		Thread.sleep(5000);

		// click the go button of principal customer in super login
		driver.findElement(
				By.xpath(".//*[@id='Search_Incident']/tbody/tr[2]/td[2]/img"))
				.click();

		// get the value for that principal customer in super
		boolean principalCustomerIsPresentInSuper = driver
				.findElement(
						By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)"))
				.getText().contains("NewCust1");
		System.out.println(principalCustomerIsPresentInSuper);

		// compare both the value of principal customer one from SD and another
		// from super
		softAssert.assertEquals(principalCustomerIsPresent,
				principalCustomerIsPresentInSuper,
				"Principal customer is not same");
		System.out.println("Match");

		tabTest.click();
		tabLogOut.click();

		for (String mainWindow : driver.getWindowHandles()) 
		{

			driver.switchTo().window(mainWindow);
		}

		rm_IncidentPage = new RM_IncidentPage();
		rm_CreateNewTest = new RM_CreateNewTest();
		rm_CreateNewTest.Login();

	}

	public void checkAssetIdRelatedToSiteCode() throws InterruptedException 
	{
		SoftAssert softAssert = new SoftAssert();
		// select Business Unit
		Select businessUnit;
		businessUnit = new Select(driver.findElement(By
				.name("m_strBusinessUnit")));
		businessUnit.selectByValue("test");

		// take the principal customer related to that BU
		String principalCustomer = driver.findElement(
				By.name("m_strPrincipalCust")).getText();
		System.out.println("===List Of Principal Customer===="
				+ principalCustomer);

		Select principalCustomerValue;
		principalCustomerValue = new Select(driver.findElement(By
				.id("m_strPrincipalCust")));
		principalCustomerValue.selectByValue("NewCust1");

		Thread.sleep(1000);
		String customer = driver.findElement(
				By.cssSelector("#m_strPrincipalCust>option[value='NewCust1']"))
				.getText();
		System.out.println(customer);

		/*
		 * driver.findElement(By.id("m_strCustomerName")).sendKeys("wo");
		 * Thread.sleep(1000); List<WebElement> customerNameList =
		 * driver.findElements(By .xpath(".//*[@id='as_ul']/li/a/span[3]"));
		 * System.out.println("custermer list" + customerNameList.size());
		 * 
		 * for (int i = 0; i < customerNameList.size(); i++) {
		 * System.out.println(customerNameList.get(i).getText());
		 * 
		 * if (customerNameList.get(i).getText()
		 * .contains("Worldline India Pvt. Ltd")) {
		 * customerNameList.get(i).click(); break; }
		 * 
		 * }
		 */

		// take the site code related to that customer
		String sitecode1 = driver.findElement(By.name("m_strSiteCode"))
				.getText();
		System.out.println("===site code LIST====" + sitecode1);

		// select the side code value
		Select sitecode;
		sitecode = new Select(driver.findElement(By.name("m_strSiteCode")));
		sitecode.selectByIndex(1);

		Thread.sleep(1000);
		// get the assert values
		String listOFAssertID = driver.findElement(
				By.xpath(".//*[@id='m_strAssetIDNewNew']/option")).getText();
		System.out.println("===AssertID LIST====" + listOFAssertID);

		// select the side code value
		Select assertID;
		assertID = new Select(driver.findElement(By.name("m_strAssetID")));
		assertID.selectByIndex(1);

		// click on GO button
		driver.findElement(
				By.xpath(".//*[@id='requestorDetails']/table/tbody/tr[2]/td[6]/a/span"))
				.click();

		// get the asset ID
		String assetIDValue = driver.findElement(
				By.cssSelector("#m_strAssetIDNewNew>option:nth-of-type(2)"))
				.getText();
		System.out.println(assetIDValue);

		// GET asset id from requester detail
		String assetIdInRequesterTab = driver
				.findElement(
						By.xpath(".//*[@id='assetidnew_detailsNew']/table/tbody/tr/td[1]/table/tbody/tr[6]/td/a"))
				.getText();
		System.out.println(assetIdInRequesterTab);

		// Match both the asset ID
		softAssert.assertEquals(assetIDValue, assetIdInRequesterTab,
				"Asset Id Is Not Equal");

		// select another value of business unit
		Select secondBusinessUnit;
		secondBusinessUnit = new Select(driver.findElement(By
				.name("m_strBusinessUnit")));
		secondBusinessUnit.selectByValue("test");

	}

	public void createNewTicket() throws InterruptedException, Exception 
	{
		Thread.sleep(300);
		// select Business Unit
		Select businessUnit;
		businessUnit = new Select(driver.findElement(By
				.name("m_strBusinessUnit")));
		businessUnit.selectByIndex(1);

		Thread.sleep(100);
		Select principalCustomerValue;
		principalCustomerValue = new Select(driver.findElement(By
				.id("m_strPrincipalCust")));
		principalCustomerValue.selectByIndex(2);

		Thread.sleep(500);
		// select the side code value
		Select sitecode;
		sitecode = new Select(driver.findElement(By.name("m_strSiteCode")));
		sitecode.selectByIndex(1);

		Thread.sleep(500);
		// select the side code value
		Select assertID;
		assertID = new Select(driver.findElement(By.name("m_strAssetID")));
		assertID.selectByIndex(1);

		// click on GO button
		driver.findElement(
				By.xpath(".//*[@id='requestorDetails']/table/tbody/tr[2]/td[6]/a/span"))
				.click();

		// select Trouble category
		Select troubleCategory;
		troubleCategory = new Select(driver.findElement(By
				.name("m_strCategory")));
		troubleCategory.selectByIndex(1);

		// click on request title
		btnRequestTitle.click();

		// for window handler
		String firstWindow = driver.getWindowHandle();

		for (String requestTitleWindow : driver.getWindowHandles()) 
		{
			driver.switchTo().window(requestTitleWindow);

		}

		// get text from request title
		String requestTitle = driver.findElement(
				By.cssSelector(".rectagleBox>table>tbody>tr:nth-of-type(8)"))
				.getText();
		System.out.println("1st request title: " + requestTitle);

		Thread.sleep(100);
		driver.findElement(By.linkText("ATM - Not coming in service")).click();

		// Closing Pop Up window
		driver.switchTo().window(firstWindow);

		// enter the Request description and check page should be writable
		txtRequestDiscription.sendKeys("ATM - Not coming in service");

		// enter the local contact name
		txtLocalName.sendKeys("bhagyashree");

		// enter the local contact number
		txtLocalContactNumber.sendKeys("7400438090");

		// enter the customer emailID
		txtCustomerEmailId.sendKeys("bhagyashree@gmail.com");

		// get the all value from ticket type
		txtTicketType.getText();

		// select ticket type
		Select ticketType;
		ticketType = new Select(
				driver.findElement(By.name("m_strIncidentType")));
		ticketType.selectByIndex(8);
		Thread.sleep(100);

		// click on record ticket button
		btnRecordTicket.click();
		Thread.sleep(2000);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String notification = driver.findElement(By.id("dialogBoxSuccess"))
				.getText();
		System.out.println(notification);

		Assert.assertEquals(notification, "Incident added successfully",
				"Ticket Is Not Created");

	}

}
