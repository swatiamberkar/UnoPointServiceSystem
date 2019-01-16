package com.uno.test.sd;

import io.qameta.allure.Description;

import java.io.File;
import java.lang.reflect.Method;

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
import com.uno.pages.sd.SD_EngineerActivityPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;


public class SD_EngineerActivityTest extends BaseCode{
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_EngineerActivityPage engineerActivityPageOfSdRole;
	String currentDir = System.getProperty("user.dir");


	
	public SD_EngineerActivityTest() {

		super();

	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

		initialization();

		loginPageOfSdRole = new SD_LoginPage();
		homePageOfSdRole = loginPageOfSdRole.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));
		Thread.sleep(1000);

	}

	@BeforeMethod(alwaysRun = true)
	public void EngineerActivityTab(Method method) throws Exception  {
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		
		homePageOfSdRole = new SD_HomePage();
		driver.findElement(By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000);
		engineerActivityPageOfSdRole =ticketPageOfSdRole.EngineerActivityTab();
		Thread.sleep(2000);

	}

	@Test(priority = 1, groups = { "Engineer Activity" },
	description = "1. In Engineer activity tab, all incident entries should display for which engineer is assign as per selected filters ")
	@Description ("1. In Engineer activity tab, all incident entries should display for which engineer is assign as per selected filters")
	
	public void verifyEngineerAccordingSelectedEngineer()  {

		engineerActivityPageOfSdRole.verifyEngineerAccordingSelectedEngineer();

	}
	
	@Test(priority = 2, groups = { "Engineer Activity" }, 
	description = "1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill ")
	@Description ("1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill")			
	public void checkFromAndToDateAccordingSelectedDateRange() throws Exception  {

		engineerActivityPageOfSdRole.checkFromAndToDateAccordingSelectedDateRange();

	}
	
	@Test(priority = 3, groups = { "Engineer Activity" }, 
	description = "1. If User click on State filter then as per selected Region filter, states should display in state filter for which call is logged."
				+ "2. All records for selected filter are display in dashboard and Total Records count is change as per entries present in dashboard .")
	@Description ("1. If User click on State filter then as per selected Region filter, states should display in state filter for which call is logged."
				+ "2. All records for selected filter are display in dashboard and Total Records count is change as per entries present in dashboard.")
	public void verifyStateAccordingSelectedState() throws Exception{

		engineerActivityPageOfSdRole.verifyStateAccordingSelectedState();
		engineerActivityPageOfSdRole.verifyTotalRecordsAccordingDisplayRow();

	}
	
	@Test(priority = 4, groups = { "Engineer Activity" },
	description = "1. If user select Inc type and click on Go button then entries should display as per selected Inc Type value.")
	@Description ("1. If user select Inc type and click on Go button then entries should display as per selected Inc Type value.")
	public void verifyIncTypeAccordingSelectedSIncType() throws Exception{

		engineerActivityPageOfSdRole.verifyIncTypeAccordingSelectedSIncType();
	}
	
	@Test(priority = 5, groups = { "Engineer Activity" }, 
	description = "1. If user select Customer filter and click on Go button then entries should display as per selected Customer filter.")
	@Description ("1. If user select Customer filter and click on Go button then entries should display as per selected Customer filter.")
	public void verifyCustomerAccordingSelectedCustomer() throws Exception{

		engineerActivityPageOfSdRole.verifyCustomerAccordingSelectedCustomer();

	}
	
	@Test(priority = 6, groups = { "Engineer Activity" }, 
	description = "1. If User click on Inc Type filter then all Incident type should display  which are present in ticket type master."
			+ "2. In customer filter list all Customer should display as present in Customer master"
			+ "3. In Business Unit filter list all BU should display which are present in system")
	@Description ("1. If User click on Inc Type filter then all Incident type should display  which are present in ticket type master."
			+ "2. In customer filter list all Customer should display as present in Customer master"
			+ "3. In Business Unit filter list all BU should display which are present in system")
	public void verifyIncTypeCustomerAndBUInSuperRole() throws Exception{

		engineerActivityPageOfSdRole.verifyIncTypeCustomerAndBUInSuperRole();

	}
	
	

	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());

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

				homePageOfSdRole = new SD_HomePage();
				driver.findElement(By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
				ticketPageOfSdRole = homePageOfSdRole.ticketTab();
				Thread.sleep(1000);
				engineerActivityPageOfSdRole =ticketPageOfSdRole.EngineerActivityTab();
				Thread.sleep(2000);

				// takeScreenshot(dateTimeStamp,driver,methodName);
				// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
				// Do your excel writing stuff here

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				
				homePageOfSdRole = new SD_HomePage();
				driver.findElement(By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
				ticketPageOfSdRole = homePageOfSdRole.ticketTab();
				Thread.sleep(1000);
				engineerActivityPageOfSdRole =ticketPageOfSdRole.EngineerActivityTab();
				Thread.sleep(2000);

			}
		} catch (Exception e) {
			driver.close();
			initialization();

			loginPageOfSdRole = new SD_LoginPage();
			homePageOfSdRole = loginPageOfSdRole.login(
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
