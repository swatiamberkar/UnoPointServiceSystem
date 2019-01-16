package com.uno.test.sd;

import io.qameta.allure.Description;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_DailyActivityPage;
import com.uno.pages.sd.SD_EmployeeDetailsPage;
import com.uno.pages.sd.SD_EmployeePage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;

public class SD_EmployeeDetailsTest extends BaseCode {
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_EmployeePage sd_EmployeePage;
	SD_EmployeeDetailsPage sd_EmployeeDetailsPage;

	public SD_EmployeeDetailsTest() {

		super();

	}

	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

		initialization();

		sd_LoginPage = new SD_LoginPage();
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));
		Thread.sleep(1000);

	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket() throws Exception {

		sd_HomePage = new SD_HomePage();
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
		sd_EmployeePage = sd_HomePage.EmployeeTab();
		Thread.sleep(1000);
		sd_EmployeeDetailsPage = sd_EmployeePage.EmployeeDetailsTab();
		Thread.sleep(1000);

	}

	@Test(priority = 1, groups = { "Employee Details Page" }, description = "In Filter tab if User apply Region filter then in table, entries should display where same region is showing as per applied Region filter")
	@Description("In Filter tab if User apply Region filter then in table, entries should display where same region is showing as per applied Region filter")
	public void CheckDataFilterByRegion() throws Exception {

		sd_EmployeeDetailsPage.checkDataFilterByRegion();

	}

	@Test(priority = 2, groups = { "Employee Details Page" }, description = "In Filter tab if User apply State filter and Region filter then in table, entries should display where same State is showing as per applied State filter")
	@Description("In Filter tab if User apply State filter and Region filter then in table, entries should display where same State is showing as per applied State filter")
	public void CheckDataFilterByState() throws Exception {

		sd_EmployeeDetailsPage.checkDataFilterByState();

	}

	@Test(priority = 3, groups = { "Employee Details Page" }, description = "If User apply Poplocation filter then in table, entries should display where same Poplocation is showing as per applied Poplocation filter")
	@Description("If User apply Poplocation filter then in table, entries should display where same Poplocation is showing as per applied Poplocation filter")
	public void heckDataFilterByPopLocation() throws Exception {

		sd_EmployeeDetailsPage.checkDataFilterByPopLocation();

	}

	@Test(priority = 4, groups = { "Employee Details Page" }, description = "If User apply City filter then in table, entries should display where same City is showing as per applied city filter")
	@Description("If User apply City filter then in table, entries should display where same City is showing as per applied city filter")
	public void CheckDataFilterByCity() throws Exception {

		sd_EmployeeDetailsPage.checkDataFilterByCity();

	}
	
	@Test(priority = 5, groups = { "Employee Details Page" }, description = "If User apply Search By Role filter, then in table entries should display for same UPSD Role as per applied filter")
	@Description("If User apply Search By Role filter, then in table entries should display for same UPSD Role as per applied filter")
	public void CheckDataSearchByRole() throws Exception {

		sd_EmployeeDetailsPage.checkDataSearchByRole();

	}
	
	@Test(priority = 6, groups = { "Employee Details Page" }, description = "If User apply Search By Status filter then in as 'Resigned Employee' then entries should display where (Resignation Date/Last Working Date/Tools Delivered/  Resignation Commen) column are present")
	@Description("If User apply Search By Status filter then in as 'Resigned Employee' then entries should display where (Resignation Date/Last Working Date/Tools Delivered/  Resignation Commen) column are present")
	public void CheckDataSearchByStatus() throws Exception {

		sd_EmployeeDetailsPage.checkDataSearchByStatus();

	}
	
	@Test(priority = 7, groups = { "Employee Details Page" }, description = "If User apply Filter By Customer filter then, employee entries having same customer assigned should display in list")
	@Description("If User apply Filter By Customer filter then, employee entries having same customer assigned should display in list")
	public void checkDataFilterByCustomer() throws Exception {

		sd_EmployeeDetailsPage.checkDataFilterByCustomer();

	}
	
	@Test(priority = 8, groups = { "Employee Details Page" }, description = "In Search tab-> Search by name if user enter name in field and click on search link then employee having same name (First name/last name) should display in table")
	@Description("In Search tab-> Search by name if user enter name in field and click on search link then employee having same name (First name/last name) should display in table")
	public void checkDataSearchByName() throws Exception {

		sd_EmployeeDetailsPage.checkDataSearchByName();

	}
	
	@Test(priority = 9, groups = { "Employee Details Page" }, description = "In Search tab-> Search by ECode if user enter ecode in field and click on search link then employee having same ecode should display in table")
	@Description("In Search tab-> Search by ECode if user enter ecode in field and click on search link then employee having same ecode should display in table")
	public void checkDataSearchByEcode() throws Exception {

		sd_EmployeeDetailsPage.checkDataSearchByEcode();

	}

	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======PASS======");
			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======FAIL======");

				// TestUtil.takeScreenshotAtEndOfTest();
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);

				String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir
						+ "/Screenshots/" + result.getMethod().getMethodName()
						+ ".jpg"));

				driver.quit();
				initialization();

				sd_LoginPage = new SD_LoginPage();
				sd_HomePage = sd_LoginPage.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);

				// takeScreenshot(dateTimeStamp,driver,methodName);
				// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
				// Do your excel writing stuff here

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				driver.quit();
				initialization();

				sd_LoginPage = new SD_LoginPage();
				sd_HomePage = sd_LoginPage.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);
				// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

			}
		} catch (Exception e) {
			driver.close();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);

		}

	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
