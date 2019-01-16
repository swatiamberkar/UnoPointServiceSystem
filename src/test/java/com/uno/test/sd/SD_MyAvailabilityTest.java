package com.uno.test.sd;

import io.qameta.allure.Description;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_AttendancePage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_MyAvailabilityPage;

public class SD_MyAvailabilityTest extends BaseCode 
{

	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_AttendancePage sd_AttendancePage;
	SD_MyAvailabilityPage sd_MyAvailabilityPage;
	
	public SD_MyAvailabilityTest()
	{
		super();
	}
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		try {
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			/*sd_AttendancePage=sd_HomePage.attendanceTab();
			Thread.sleep(1000);
		    sd_MyAvailabilityPage =  sd_AttendancePage.myAvailabilityTab();
			Thread.sleep(1000);*/
			
		} catch (Exception e) {
		

			
			driver.close();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			/*sd_AttendancePage=sd_HomePage.attendanceTab();
			Thread.sleep(1000);
		    sd_MyAvailabilityPage =  sd_AttendancePage.myAvailabilityTab();
			Thread.sleep(1000);*/
			
			
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket() throws Exception {
		try {
			sd_HomePage = new SD_HomePage();
			sd_AttendancePage=sd_HomePage.attendanceTab();
			Thread.sleep(1000);
			 sd_MyAvailabilityPage =  sd_AttendancePage.myAvailabilityTab();
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			sd_HomePage = new SD_HomePage();
			sd_AttendancePage=sd_HomePage.attendanceTab();
			Thread.sleep(1000);
		     sd_MyAvailabilityPage =  sd_AttendancePage.myAvailabilityTab();

			// e.printStackTrace();
		}

	}
	
	@Test(priority=1, groups = { "My Availability"} ,description = "If User click on My Availability tab, then View My Availability page should get open with last login details" )
	@Description("If User click on My Availability tab, then View My Availability page should get open with last login details")
	public void CheckHeadingOfPage() throws Exception
	{
		sd_MyAvailabilityPage.checkHeadingOfPage();
		
	}
	
	@Test(priority=2, groups = { "My Availability"} , description =  "In Total Opening Balance Of This Month column value should display as per"
			+ " Total leaves assign in employee master -> employee Details for employee login." )
	@Description("In Total Opening Balance Of This Month column value should display as per"
			+ " Total leaves assign in employee master -> employee Details for employee login.")
	public void MatchTotalOpeningBalanceWithSuperRole() throws Exception
	{
		sd_MyAvailabilityPage.matchTotalOpeningBalanceWithSuperRole();
		
	}
	
	@Test(priority=3, groups = { "My Availability"} , description =  "1.If User click on Update availability button then My Availability pop up should display with availability list"
			+ "2.If User select login and click on Save button then pop up should display was 'Do you want to save changes?' and after click on ok button, latest login entry should display in Availability table login date and time and notification should display as 'Availability updated successfully.'" )
	@Description("1.If User click on Update availability button then My Availability pop up should display with availability list"
			+ "2.If User select login and click on Save button then pop up should display was 'Do you want to save changes?' and after click on ok button, latest login entry should display in Availability table login date and time and notification should display as 'Availability updated successfully.'")
	public void CheckWithLoginSelect() throws Exception
	{
		sd_MyAvailabilityPage.checkWithLoginSelect();
		
	}
	@Test(priority=4, groups = { "My Availability"} , description =  "1.If User select logout option then in My Availability pop up 'Early out Reason' field  should display with list"
			+ "2.If User select Early out Reason and click on save button for logout availability then same should display in availability column with logout date/time and selected early out reason and notification should display as 'Out Time updated successfully.'")
	@Description("1.If User select logout option then in My Availability pop up 'Early out Reason' field  should display with list"
			+ "2.If User select Early out Reason and click on save button for logout availability then same should display in availability column with logout date/time and selected early out reason and notification should display as 'Out Time updated successfully.'")
	public void CheckWithLogoutSelect() throws Exception
	{
		
		sd_MyAvailabilityPage.checkWithLogoutSelect();
	}

	@Test(priority=5, groups = { "My Availability"} ,description = "1.If user select leave in availability list then Leave type field should display with from date and To date also"
			+ "2.If User select availability as 'Leave' and select all details then after save changes, notification should display as 'Availability updated successfully.' and availability  should display as 'Leave'."
			+ "3.If User apply leave for Present day then as per applied leave, count should display for same month and same leave type and in table, availability should display as Leave with login date and time " )
	@Description("1.If user select leave in availability list then Leave type field should display with from date and To date also"
			+ "2.If User select availability as 'Leave' and select all details then after save changes, notification should display as 'Availability updated successfully.' and availability  should display as 'Leave'."
			+ "3.If User apply leave for Present day then as per applied leave, count should display for same month and same leave type and in table, availability should display as Leave with login date and time ")
	public void CheckWithLeaveForPresentDaySelect() throws Exception
	{
		sd_MyAvailabilityPage.checkWithLeaveForPresentDaySelect();
		
	}

	@Test(priority=6, groups = { "My Availability"} , description = "If User apply leave for day (Except Present day) then as per applied leave, count should display for same month and same leave type and In table, applied Leave type should display in table" )
	@Description("If User apply leave for day (Except Present day) then as per applied leave, count should display for same month and same leave type and In table, applied Leave type should display in table")
	public void CheckWithLeaveForNextDaySelect() throws Exception
	{
		sd_MyAvailabilityPage.checkWithLeaveForNextDaySelect();
		
	}
	@Test(priority=7, groups = { "My Availability"} , description = "check Total Closing Balance After applying  Leave")
	@Description("check Total Closing Balance After applying  Leave")
	public void CheckTotalClosingBalance() throws Exception
	{
		sd_MyAvailabilityPage.checkTotalClosingBalance();
		
	}
	
	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======PASS======");
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======FAIL======");

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			String currentDir = System.getProperty("user.dir");

			FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
					+ result.getMethod().getMethodName() + ".jpg"));

			driver.quit();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);

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

	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	

	

}
