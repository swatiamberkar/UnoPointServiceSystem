package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.pages.technician.Technician_IncidentPage;
import com.uno.pages.technician.Technician_MyAvailabilityPage;
import com.uno.test.rm.RM_MyAvailabilityTest;
import com.uno.test.superrole.Super_EmployeeMasterTest;
import com.uno.test.superrole.Super_ServiceDeskSettingsTest;
import com.uno.test.technician.Technician_MyAvilabilityTest;




public class RM_EngineerAttendancePage extends BaseCode
{

	private static String totalOpeningBalanceValue = null;
	private static String totalClosingBalanceValue = null;
	private static String totalLeave = null;
	public static  int row ;
	public static String fileName = "EngineerAttendanceExcelReport";
    private static String downloadPath = "C:\\Users\\Admin\\Downloads";
    
    public static String dateAttendance = null;

	// Call method from RM login
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_MyAvailabilityTest rm_MyAvailabilityTest;
	RM_AttendancePage rm_AttendancePage;
	RM_MyAvailabilityPage rm_MyAvailabilityPage;
	RM_EngineerAttendancePage rm_EngineerAttendancePage;
	RM_AttendanceApprovalPage rm_AttendanceApprovalPage;

	// Call method from super login
	Super_EmployeeMasterTest super_EmployeeMasterPageTest;
	Super_EmployeeDetailPage super_EmployeeDetailPage;
	Super_ServiceDeskSettingsPage super_ServiceDeskSettingsPage;
	Super_ServiceDeskSettingsTest super_ServiceDeskSettingsTest;

	
	// call method from technician login
	Technician_MyAvilabilityTest technician_MyAvilabilityTest;
	Technician_HomePage technician_HomePage;
	Technician_IncidentPage technician_IncidentPage;
	Technician_MyAvailabilityPage technician_MyAvailabilityPage;

	// Select RM tab for logout tab
	@FindBy(xpath = ".//*[@id='main']/div[2]/div[2]/div/ul/li[10]/a")
	WebElement tabRM;

	// Select RM tab for logout tab
	@FindBy(linkText = "Test")
	WebElement tabTest;

	// Select technician name tab for logout tab
	@FindBy(xpath = ".//*[@id='main']/div[2]/div[2]/div/ul/li[7]/a[@href = '#']")
	WebElement tabTechnicianLogout;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// Heading 
	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement lblHeading;

	// Select Year Filter
	@FindBy(name = "l_strYear")
	WebElement ddlYear;

	// Select Month Filter
	@FindBy(name = "l_strMonth")
	WebElement ddlMonth;

	// Select Employee Role
	@FindBy(name = "m_strFilter")
	WebElement ddlEmpolyeeRole;

	// Select Customer Name
	@FindBy(name = "m_strCustomerName")
	WebElement ddlCustomerName;

	// Select State
	@FindBy(name = "m_strState")
	WebElement ddlState;

	// Select Pop Location
	@FindBy(name = "m_strPopLocation")
	WebElement ddlPopLocation;

	// Select BusinessUnit
	@FindBy(name = "m_strBusinessUnit")
	WebElement ddlBusinessUnit;

	// Select Go Button
	@FindBy(xpath = ".//*[@id='form']/div/table/tbody/tr[2]/td[5]/a/span")
	WebElement btnGo;

	// Select Engineer Name
	@FindBy(xpath = ".//*[@id='container']/div[3]/div/div[1]/div[2]/table/tbody/tr/td[2]")
	List<WebElement> lstEngineerName;

	// Select State
	@FindBy(xpath = ".//*[@id='container']/div[3]/div/div[2]/div[2]/table/tbody/tr/td[4]")
	List<WebElement> lstState;

	// Select Table Header
	@FindBy(css = "div[id='container']>div:nth-of-type(3)>div>div:nth-of-type(2)>div:nth-of-type(1)>table>thead>tr:nth-of-type(1)>th")
	List<WebElement> lstTableHeader;

	// Select Table Row
	@FindBy(xpath = ".//*[@id='container']/div[3]/div/div[2]/div[2]/table/tbody/tr")
	List<WebElement> lstRows;

	// Select Table column
	@FindBy(xpath = ".//*[@id='container']/div[3]/div/div[2]/div[2]/table/tbody/tr/td")
	List<WebElement> lstColumn;
	
	
	// Select Table Header Column
	@FindBy(xpath = ".//*[@id='container']/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td")
	List<WebElement> lstHeaderCol;

	// click on download button
	@FindBy(xpath = ".//*[@id='form']/div/table/tbody/tr[2]/td[7]/a")
	WebElement btnDownload;

	// Initializing Page Object
	public RM_EngineerAttendancePage() 
	{
		PageFactory.initElements(driver, this);
	}

	// If User click on My Availability tab, then View My Availability page
	// should get open with last login details .
	public void checkHeadingOfPage() 
	{
		// check the heading of View My Availability
		String viewMyAvailability = lblHeading.getText();
		System.out.println("HeadingName: " + viewMyAvailability);

		assertEquals(viewMyAvailability, "View Engineer Attendance",
				"page heading is not match");

	}

	// 1.If user click on Go button without select any filter then notification
	// should display as 'Please select Year And Month First' (Year and month
	// filters are mandatory)
	// 2.In Engineer attendance tab if user apply Employee role filter and click
	// on Go button then entries should display which having selected employee
	// roles
	public void checkBeforeSelectingFilter() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		
		// Click on Go button before selecting any filter
		btnGo.click();

		// check alert
		Alert alert = driver.switchTo().alert();
		String alterMessage = alert.getText();
		System.out.println("alterMessage: " + alterMessage);
		alert.accept();

		softAssert.assertEquals(alterMessage,
				"Please select Year And Month First",
				"The alert message is different");
		
		softAssert.assertAll();

		// select year and month filter
		/*Select year = new Select(ddlYear);
		year.selectByIndex(3);

		Select month = new Select(ddlMonth);
		month.selectByIndex(5);

		// select Employee role
		Select employeeRole = new Select(ddlEmpolyeeRole);
		employeeRole.selectByVisibleText("RM");

		// Click on Go button
		btnGo.click();

		// Change the Tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		// Enter url
		driver.get(properties.getProperty("url"));

		// Thread.sleep(1000);
		// click on account
		tabRM.click();

		Thread.sleep(1000);
		// click on logout
		tabLogOut.click();

		// get value from super login -> Employee Master -> Employee Details
		super_EmployeeMasterPageTest = new Super_EmployeeMasterTest();
		super_EmployeeMasterPageTest.Setup();
		super_EmployeeMasterPageTest.ClickOnEmpolyeeDetailLink();
		super_EmployeeDetailPage = new Super_EmployeeDetailPage();
		super_EmployeeDetailPage.selectRMInFilter();

		// Switching between tabs using CTRL + tab keys.
		driver.findElement(By.cssSelector("body"))
				.sendKeys(Keys.CONTROL + "\t");
		driver.switchTo().defaultContent();

		int sizeOfEngineerNameInRM = lstEngineerName.size();
		System.out.println("sizeOfEngineerNameInRM: " + sizeOfEngineerNameInRM);

		loop: for (int i = 0; i < sizeOfEngineerNameInRM; i++) {

			String engineerNameInRM = lstEngineerName.get(i).getText();
			System.out.println("engineerNameInRM:" + engineerNameInRM);

			// Switching between tabs using CTRL + tab keys.
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "\t");
			driver.switchTo().defaultContent();

			Thread.sleep(500);
			int sizeOfEngineerNameInSuperRole = super_EmployeeDetailPage.lstFirstName
					.size();
			System.out.println("sizeOfEngineerNameInSuperRole: "
					+ sizeOfEngineerNameInSuperRole);

			if (sizeOfEngineerNameInRM == sizeOfEngineerNameInSuperRole) {
				loopSecond: for (; k < sizeOfEngineerNameInSuperRole;) {
					System.out.println("\nEngineer Name Size is same.");

					String engineerNameInSuperRole = super_EmployeeDetailPage.lstFirstName
							.get(k).getText();
					System.out.println("EngineerNameInSuperRole: "
							+ engineerNameInSuperRole);

					softAssert.assertTrue(engineerNameInRM.contains(engineerNameInSuperRole),
							"engineer name is not same");

					// Switching between tabs using CTRL + tab keys.
					driver.findElement(By.cssSelector("body")).sendKeys(
							Keys.CONTROL + "\t");
					driver.switchTo().defaultContent();

					softAssert.assertAll();
					k++;
					continue loop;

				}
			}

			else {
				
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "\t");
				driver.findElement(By.cssSelector("body")).sendKeys(
						Keys.CONTROL + "w");
				tabTest.click();
				Thread.sleep(1000);

				// click on logout
				tabLogOut.click();
				// Thread.sleep(1000);

				rm_LoginPage = new RM_LoginPage();
				rm_HomePage = rm_LoginPage.Login(
						properties.getProperty("loginIdForRM"),
						properties.getProperty("password"));
				Thread.sleep(1000);
				rm_AttendancePage = rm_HomePage.AttendanceTab();
				Thread.sleep(1000);
				rm_EngineerAttendancePage = rm_AttendancePage
						.engineerAttendanceTab();

				Assert.assertEquals(sizeOfEngineerNameInRM,
						sizeOfEngineerNameInRM,
						"engineer name size is different");
				System.out.println("engineer name size is different");
				k++;
				continue loop;

			}

		}

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");

		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();
		// Thread.sleep(1000);
		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_EngineerAttendancePage = rm_AttendancePage
				.engineerAttendanceTab();

		driver.switchTo().window(window);*/

	}

	
	// If in Super login-> Attendance approval by Reporting Manager is 'Yes'
	// then without Approving By RM, it should not Reflect on Engineer
	// Attendance Dashboard.It should display as Not Available
	public void checkAttendanceWithYesSelectInRMSetting() throws Exception 
	{
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
		Thread.sleep(1000);
		// click on account
		tabRM.click();

		Thread.sleep(1000);
		// click on logout
		tabLogOut.click();

		// select Attendance Approve By RM, Call the method from service desk
		// setting page in super login
		super_ServiceDeskSettingsTest = new Super_ServiceDeskSettingsTest();
		super_ServiceDeskSettingsTest.Setup();
		super_ServiceDeskSettingsTest
				.SelectYesOfAttendanceApproveByRm();

		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();

		Thread.sleep(2000);
		// go to technician My Availability page and do login
		technician_MyAvilabilityTest = new Technician_MyAvilabilityTest();
		technician_MyAvilabilityTest.Login();
		technician_MyAvilabilityTest.doTechnicianLogin();

		tabTechnicianLogout.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();

		Thread.sleep(2000);
		// back to the RM login
		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_EngineerAttendancePage = rm_AttendancePage
				.engineerAttendanceTab();

		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		SoftAssert softAssert = new SoftAssert();
		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);

		// Click on Go button
		btnGo.click();

		// If first row is header row

		int size = lstTableHeader.size();
		System.out.println("size of header: " + size);

		for (int i = 0; i < size; i++) 
		{

			/*((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstTableHeader.get(i));
			*/
			Thread.sleep(500);
			String getList = lstTableHeader.get(i).getText();
			System.out.println("getList: " + getList);

			if (getList.contains(currentDate)) 
			{

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);",
						lstRows.get(i));

				int sizeOfRows = lstRows.size();
				System.out.println("sizeOfRows: " + sizeOfRows);

				loop: for (int j = 1; j < sizeOfRows; j++) 
				{

					List<WebElement> columnElement = lstRows.get(j)
							.findElements(By.tagName("td"));

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							columnElement.get(i));
					
					String firstColumn = columnElement.get(1).getText();
					System.out.println("firstColumn: " + firstColumn);

					if (firstColumn.contains("Pranjali")) 
					{

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								columnElement.get(i));
						
						for (int k = 0; k < columnElement.size(); k++) {

							if (k == i) 
							{

								((JavascriptExecutor) driver).executeScript(
										"arguments[0].scrollIntoView(true);",
										columnElement.get(k));
								
								((JavascriptExecutor) driver).executeScript(
										"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
										columnElement.get(k));
								
								System.out.println("K: " + k);
								String dateAttendance = columnElement.get(k)
										.getText();
								System.out.println("dateAttendance: "
										+ dateAttendance);
								softAssert.assertEquals(dateAttendance,
										"Not Available");
								break loop;

							}

						}
					}

				}
				break;
			}

		}
		softAssert.assertAll();
	}

	// If in Super login-> Attendance approval by Reporting Manager is 'No' then
	// without Approving By RM, it should reflect on Engineer Attendance Dash
	// board as Login, Leave(Sick,Casual.Privilage,Paid)
	public void checkAttendanceWithNoSelectInRMSetting() throws Exception 
	{
		String window = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

		// click on account
		tabRM.click();

		Thread.sleep(1000);
		// click on logout
		tabLogOut.click();

		// select Attendance Approve By RM, Call the method from service desk
		// setting page in super login
		super_ServiceDeskSettingsTest = new Super_ServiceDeskSettingsTest();
		super_ServiceDeskSettingsTest.Setup();
		super_ServiceDeskSettingsTest.SelectNoOfAttendanceApproveByRm();

		tabTest.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();

		Thread.sleep(2000);
		// go to technician My Availability page and do login
		rm_LoginPage = new RM_LoginPage();
		technician_HomePage = rm_LoginPage.technicianLogin(
				properties.getProperty("loginIdForSecondTechnician"),
				properties.getProperty("password"));
		technician_IncidentPage = technician_HomePage.incidentTab();
		Thread.sleep(1000);
		technician_MyAvailabilityPage = technician_IncidentPage
				.MyAvailabilityTab();
		Thread.sleep(1000);

		// apply leave
		technician_MyAvailabilityPage.applyLeave();

		// for take update value click on incident tab and My Availability tab
		technician_IncidentPage = technician_HomePage.incidentTab();
		Thread.sleep(1000);
		technician_MyAvailabilityPage = technician_IncidentPage
				.MyAvailabilityTab();
		Thread.sleep(1000);

		WebElement totalOpeningBalance = technician_MyAvailabilityPage.totalOpeningBalanceValue;
		totalOpeningBalanceValue = totalOpeningBalance.getText();
		System.out.println("totalOpeningBalanceValue: "
				+ totalOpeningBalanceValue);

		WebElement totalClosingBalance = technician_MyAvailabilityPage.totalClosingBalanceValue;
		totalClosingBalanceValue = totalClosingBalance.getText();
		System.out.println("lblTotalClosingBalance: "
				+ totalClosingBalanceValue);

		// Get value of privilege leave
		WebElement privilageLeave = technician_MyAvailabilityPage.previlageLeaveTakenValue;
		String previlageLeaveValue = privilageLeave.getText();
		System.out.println("previlageLeaveValue: " + previlageLeaveValue);

		int intValueOfPrevilageLeave = Integer.parseInt(previlageLeaveValue);
		System.out.println("intValueOfPrevilageLeave: "
				+ intValueOfPrevilageLeave);

		// Get value of sick leave
		WebElement sickLeave = technician_MyAvailabilityPage.sickLeaveTakenValue;
		String sickLeaveValue = sickLeave.getText();
		System.out.println("sickLeaveValue: " + sickLeaveValue);

		int intValueOfSickLeave = Integer.parseInt(sickLeaveValue);
		System.out.println("intValueOfsickLeave: " + intValueOfSickLeave);

		// add the value of privilege leave and sick leave
		int leave = intValueOfPrevilageLeave + intValueOfSickLeave;
		System.out.println("leave: " + leave);

		totalLeave = Integer.toString(leave);
		System.out.println("totalLeave: " + totalLeave);

		Thread.sleep(1000);
		tabTechnicianLogout.click();
		Thread.sleep(1000);

		// click on logout
		tabLogOut.click();

		Thread.sleep(2000);
		// back to the RM login
		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_EngineerAttendancePage = rm_AttendancePage.engineerAttendanceTab();
		
		driver.switchTo().window(window);

		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);

		// Click on Go button
		btnGo.click();

		// If first row is header row

		int size = lstTableHeader.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView(true);",
							lstTableHeader.get(i));

			String getList = lstTableHeader.get(i).getText();
			System.out.println("getList: " + getList);

			if (getList.contains(currentDate)) {
/*
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView(true);", lstRows.get(i));*/

				int sizeOfRows = lstRows.size();
				System.out.println("sizeOfRows: " + sizeOfRows);

				loop: for (int j = 1; j < sizeOfRows; j++) {

					List<WebElement> columnElement = lstRows.get(j)
							.findElements(By.tagName("td"));

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							columnElement.get(i));

					String firstColumn = columnElement.get(1).getText();
					System.out.println("firstColumn: " + firstColumn);

					if (firstColumn.contains("pranjali12")) {

						for (int k = 0; k < columnElement.size(); k++) {

							if (k == i) {

								((JavascriptExecutor) driver).executeScript(
										"arguments[0].scrollIntoView(true);",
										columnElement.get(k));

								((JavascriptExecutor) driver)
										.executeScript(
												"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
												columnElement.get(k));

								System.out.println("K: " + k);
								String dateAttendance = columnElement.get(k)
										.getText();
								System.out.println("dateAttendance: "
										+ dateAttendance);
								softAssert.assertEquals(dateAttendance,
										"Previlage Leave");
								break loop;

							}

						}
					}

				}
				break;
			}

		}
		softAssert.assertAll();
	}

	// In Engineer Attendance-Total Opening Balance count should display as per
	// update in employee master that should Reflect in RM Login,Technician
	// Login, Mobile Application
	public void checkTotalOpeningBalanceCount() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();

		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);


		// Click on Go button
		btnGo.click();

		// If first row is header row
		int size = lstTableHeader.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) 
		{

			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstTableHeader.get(i));

			Thread.sleep(1000);
			String getList = lstTableHeader.get(i).getText();
			System.out.println("getList: " + getList);

			if (getList.equalsIgnoreCase("Total Opening Balance")) {

				Thread.sleep(1000);
				System.out.println("=========");
				int sizeOfRows = lstRows.size();
				System.out.println("sizeOfRows: " + sizeOfRows);

				loop: for (int j = 1; j < sizeOfRows; j++) 
				{	
					
					List<WebElement> columnElement = lstRows.get(j)
							.findElements(By.tagName("td"));
					

					Thread.sleep(1000);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							columnElement.get(i));
				
					Thread.sleep(1000);
					String firstColumn = columnElement.get(1).getText();
					System.out.println("firstColumn: " + firstColumn);
					
					if (firstColumn.contains("pranjali12"))
					{

						for (int k = 0; k < columnElement.size(); k++) {

							Thread.sleep(1000);
							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									columnElement.get(i));

							if (k == i + 4) {
								
								((JavascriptExecutor) driver).executeScript(
										"arguments[0].scrollIntoView(true);",
										columnElement.get(k));
								
								((JavascriptExecutor) driver)
								.executeScript(
										"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
										columnElement.get(k));
								

								System.out.println("K: " + k);
								String totalOpeningBalanceInRM = columnElement
										.get(k).getText();
								System.out.println("totalOpeningBalance: "
										+ totalOpeningBalanceInRM);

								softAssert.assertEquals(totalOpeningBalanceInRM
												+ ".0",
												totalOpeningBalanceValue,
												"Total opening balance count is different");

								String leave = columnElement.get(k + 1)
										.getText();
								System.out.println("leave: " + leave);

								softAssert.assertEquals(leave, totalLeave,
										"leave count is different");

								String totalClosingBalanceValueInRM = columnElement
										.get(k + 2).getText();
								System.out.println("totalClosingBalance: "
										+ totalClosingBalanceValueInRM);

								softAssert.assertEquals(
												totalClosingBalanceValueInRM
														+ ".0",
												totalClosingBalanceValue,
												"Total closing balance count is different");

								break loop;

							}

						}
					}

				}
				break;
			}

		}
		softAssert.assertAll();

	}

	// If User click on Download button then excel should get download with same
	// entries which are present in Engineer attendance sheet
	public void checkFileIsDowloadedOrNot() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);

		Select businessUnit = new Select(ddlBusinessUnit);
		businessUnit.selectByVisibleText("test");

		// Click on Go button
		btnGo.click();

		Thread.sleep(1000);

		// click on download button
		btnDownload.click();
		
		Robot robot = new Robot();
		Thread.sleep(1000);
		//robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(700);
		robot.keyPress(KeyEvent.VK_ENTER);
		

		Thread.sleep(20000);
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		softAssert.assertTrue(
				fileName.contains("EngineerAttendanceExcelReport"),
				"Downloaded file name is not matching with expected file name");
		getLatestFile.delete();

		softAssert.assertAll();
	}

	public static FirefoxProfile firefoxProfile() throws Exception 
	{

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference(
				"browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", downloadPath);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/zip");

		return firefoxProfile;

	}

	public boolean isFileDownloaded(String downloadPath, String fileName)
	{
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

	
	public void matchExcelSheetWithTableData() throws Exception 
	{
		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);

		// select Employee role
		Select employeeRole = new Select(ddlEmpolyeeRole);
		employeeRole.selectByVisibleText("Technician");

		// select state filter
		Select state = new Select(ddlState);
		state.selectByVisibleText("Maharashtra");

		Select popLocation = new Select(ddlPopLocation);
		popLocation.selectByVisibleText("Mumbai");

		// Click on Go button
		btnGo.click();
		// get the table
		WebElement tableElement = driver.findElement(By
				.xpath(".//*[@id='container']/div[3]/div"));

		// Get all the rows in the table
		List<WebElement> allRows = tableElement.findElements(By.tagName("tr"));

		// Get the size(row no) of allRows
		int rowSize = allRows.size();
		System.out.println("rowSize:-" + rowSize);

		// locate the test excel file
		FileInputStream  file = new FileInputStream(new File("C:\\Users\\Admin\\Downloads\\uno.xls"));
		System.out.println("Read file");
	    DataInputStream dis = new DataInputStream(file);

		
		try {
			Robot robot = new Robot();
			Thread.sleep(1000);
			//robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(700);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println("Wrong");
			//e.printStackTrace();
		}
		 
	
		try {
			
		 @SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(dis);
		 HSSFSheet sheet = workbook.getSheetAt(0);
		                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		 row = sheet.getLastRowNum();
		 System.out.println("row no: "+ row);
		}
		 
		// Cell cell = row.getCell(0);}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		/*
		for (int i = 0; i < rowSize; i++) 
		{
		*/	WebElement webRow = allRows.get(0);
			System.out.println("webRow: " +webRow);
			/*// Get all cell values in each row
			List<WebElement> allCells = tableElement.findElements(By.tagName("td"));
			System.out.println(allCells.size());
			
			int size = allCells.size();
			System.out.println("size:"+size);*/

			

		

	}
	
	//If User apply Leave for Compensatory/ Holiday/Week Off then in leave taken column count should not get added
	public void checkTotalLeaveCountAfterCompensatoryLeave() throws Exception 
	{
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

		// click on account
		tabRM.click();

		Thread.sleep(1000);
		// click on logout
		tabLogOut.click();

		Thread.sleep(2000);
		// go to technician My Availability page and do login
		rm_LoginPage = new RM_LoginPage();
		technician_HomePage = rm_LoginPage.technicianLogin(
				properties.getProperty("loginIdForThirdTechnician"),
				properties.getProperty("password"));
		technician_IncidentPage = technician_HomePage.incidentTab();
		Thread.sleep(1000);
		technician_MyAvailabilityPage = technician_IncidentPage
				.MyAvailabilityTab();
		Thread.sleep(1000);

		// apply leave
		technician_MyAvailabilityPage.applyCompensatoryLeave();

		// click on account
		tabTechnicianLogout.click();

		Thread.sleep(1000);
		// click on logout
		tabLogOut.click();

		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);
		rm_AttendancePage = rm_HomePage.AttendanceTab();
		Thread.sleep(1000);
		rm_EngineerAttendancePage = rm_AttendancePage
				.engineerAttendanceTab();
		
		SoftAssert softAssert = new SoftAssert();

		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		Thread.sleep(1000);
		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);

		// Click on Go button
		btnGo.click();

		
		// If first row is header row
		int size = lstTableHeader.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) 
		{

			List<WebElement> headerValue = driver.findElements(By.xpath(".//*[@id='container']/div[3]/div/div[2]/div[1]/table/thead/tr[2]/th"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					headerValue.get(i));

			String getList = headerValue.get(i).getText();
			System.out.println("getList: " + getList);

			if (getList.equalsIgnoreCase("Compensatory Leave")) 
			{

				Thread.sleep(1000);
				System.out.println("=========");
				int sizeOfRows = lstRows.size();
				System.out.println("sizeOfRows: " + sizeOfRows);

				loop: for (int j = 1; j < sizeOfRows; j++) 
				{

					List<WebElement> columnElement = lstRows.get(j)
							.findElements(By.tagName("td"));

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstRows.get(i));

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							columnElement.get(j));

					Thread.sleep(1000);
					String firstColumn = columnElement.get(1).getText();
					System.out.println("firstColumn: " + firstColumn);

					if (firstColumn.contains("Pranjali")) {

						for (int k = 0; k < columnElement.size(); k++) {

							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									columnElement.get(k));

							if (k == i) {

								System.out.println("K: " + k);
								String compensatoryLeave = columnElement
										.get(k).getText();
								System.out.println("compensatory Leave: "
										+ compensatoryLeave);

								String Totalleave = columnElement.get(k++)
										.getText();
								System.out.println("Totalleave: " + Totalleave);

								softAssert.assertEquals(Totalleave, totalLeave,
										"leave count is different");

							

								break loop;

							}

						}
					}

				}
				break;
			}

		}
		softAssert.assertAll();

		
	}
	
	
	//used in Attendance Approval page
	public void checkAvailability() throws Exception
	{		
		Calendar calendar = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(calendar
				.getTime());
		System.out.println("currentYear: " + currentYear);

		String currentMonth = new SimpleDateFormat("M").format(calendar
				.getTime());
		System.out.println("currentMonth: " + currentMonth);
		int intValueOfCurrentMonth = Integer.parseInt(currentMonth);
		System.out.println("intValueOfCurrentMonth: " + intValueOfCurrentMonth);

		String currentDate = new SimpleDateFormat("d").format(calendar
				.getTime());
		System.out.println("currentDate: " + currentDate);
		int intValueOfCurrentDate = Integer.parseInt(currentDate);
		System.out.println("intValueOfCurrentDate: " + intValueOfCurrentDate);

		// select year and month filter
		Select year = new Select(ddlYear);
		year.selectByVisibleText(currentYear);

		Select month = new Select(ddlMonth);
		month.selectByIndex(intValueOfCurrentMonth);
		
		// Click on Go button
		btnGo.click();
		
		// If first row is header row
		int size = lstTableHeader.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) 
		{

			Thread.sleep(200);
			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView(true);",
							lstTableHeader.get(i));

			String getList = lstTableHeader.get(i).getText();
			System.out.println("getList: " + getList);

			if (getList.contains(currentDate)) 
			{
		
				int sizeOfRows = lstRows.size();
				System.out.println("sizeOfRows: " + sizeOfRows);

				loop: for (int j = 0; j < sizeOfRows; j++) {

					List<WebElement> columnElement = lstRows.get(j)
							.findElements(By.tagName("td"));

					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							columnElement.get(i));

					String firstColumn = columnElement.get(1).getText();
					System.out.println("firstColumn: " + firstColumn);

					if (firstColumn.contains(RM_AttendanceApprovalPage.engineerName))
				     {

						for (int k = 0; k < columnElement.size(); k++) {
							

							if (k == i) {

								((JavascriptExecutor) driver).executeScript(
										"arguments[0].scrollIntoView(true);",
										columnElement.get(k));

								((JavascriptExecutor) driver)
										.executeScript(
												"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
												columnElement.get(k));

								System.out.println("K: " + k);
								dateAttendance = columnElement.get(k)
										.getText();
								System.out.println("dateAttendance: "
										+ dateAttendance);
								break loop;

							}

						}
					}

				}
			
			}

		}
		
	}

	
}

