package com.uno.test.rm;

import io.qameta.allure.Description;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_AttendancePage;
import com.uno.pages.rm.RM_EngineerAttendancePage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;

public class RM_EngineerAttendanceTest extends BaseCode 
{
	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_AttendancePage rm_AttendancePage;
	RM_EngineerAttendancePage rm_EngineerAttendancePage;
	
	public RM_EngineerAttendanceTest()
	{
		super();
	}
	@BeforeSuite(alwaysRun = true)
	public void Login() throws Exception {
		try {
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_AttendancePage=rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
			rm_EngineerAttendancePage = rm_AttendancePage.engineerAttendanceTab();
			
		} catch (Exception e) 
		{
			

			
			driver.close();
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_AttendancePage=rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
			rm_EngineerAttendancePage = rm_AttendancePage.engineerAttendanceTab();
			
			
		}

	}
		
	@Test(priority= 1, groups = { "Engineer Attendance"} ,description = "If User click on Engineer Attendance tab, then View Engineer Attendance page should get open with last login details" )
	@Description("If User click on Engineer Attendance tab, then View Engineer Attendance page should get open with last login details")
	public void CheckHeadingOfPage() throws Exception
	{
		rm_EngineerAttendancePage.checkHeadingOfPage();
		
	}
	
	@Test(priority= 2, groups = { "Engineer Attendance"} ,description = "1.If user click on Go button without select any filter then notification"
			+ " should display as 'Please select Year And Month First' (Year and month filters are mandatory")
			
	@Description("1.If user click on Go button without select any filter then notification"
			+ " should display as 'Please select Year And Month First' (Year and month filters are mandatory")
	public void checkBeforeSelectingFilter() throws Exception
	{
		rm_EngineerAttendancePage.checkBeforeSelectingFilter();
		
	}
		
	@Test(priority= 3, groups = { "Engineer Attendance"} ,description = "If in Super login-> Attendance approval by Reporting Manager is 'Yes' then without Approving By RM, it shoud not Reflect on Enginner Attaendace Dashboard.It should display as Not Available" )
	@Description("If in Super login-> Attendance approval by Reporting Manager is 'Yes' then without Approving By RM, it shoud not Reflect on Enginner Attaendace Dashboard.It should display as Not Available")
	public void CheckAttendanceWithYesSelectInRMSetting() throws Exception
	{
		rm_EngineerAttendancePage.checkAttendanceWithYesSelectInRMSetting();
		
    }
	@Test(priority= 4, groups = { "Engineer Attendance"} ,description = "If in Super login-> Attendance approval by Reporting Manager is 'No' then without Approving By RM, it should reflect on Engineer Attendance Dash board as Login, Leave(Sick,Casual.Privilage,Paid)" )
	@Description("If in Super login-> Attendance approval by Reporting Manager is 'No' then without Approving By RM, it should reflect on Engineer Attendance Dash board as Login, Leave(Sick,Casual.Privilage,Paid)")
	public void CheckAttendanceWithNoSelectInRMSetting() throws Exception
	{
		rm_EngineerAttendancePage.checkAttendanceWithNoSelectInRMSetting();
		
	}
	@Test(priority= 5, groups = { "Engineer Attendance"} ,description = "In Engineer Attendance-Total Opening Balance count should display as per update in employee master that should Reflect in sd Login,Technician Login, Mobile Application" )
	@Description("In Engineer Attendance-Total Opening Balance count should display as per update in employee master that should Reflect in sd Login,Technician Login, Mobile Application")
	public void CheckTotalOpeningBalanceCount() throws Exception
	{
		rm_EngineerAttendancePage.checkTotalOpeningBalanceCount();
		
	}
	

	@Test(priority= 6, groups = { "Engineer Attendance"} ,description = "If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet" )
	@Description("//If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet")
	public void CheckFileIsDowloadedOrNot() throws Exception
	{
		rm_EngineerAttendancePage.checkFileIsDowloadedOrNot();
		
	}

	   
	@Test(priority= 7, groups = { "Engineer Attendance"} ,description = "If User apply Leave for Compensatory/ Holiday/Week Off then in leave taken column count should not get added" )
	@Description("If User apply Leave for Compensatory/ Holiday/Week Off then in leave taken column count should not get added")
	public void CheckTotalLeaveCountAfterCompensatoryLeave() throws Exception
	{
		rm_EngineerAttendancePage.checkTotalLeaveCountAfterCompensatoryLeave();
		
	}
	
	/*@Test(priority= 8, groups = { "Engineer Attendance"} ,description = "If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet" )
	@Description("//If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet")
	public void MatchExcelSheetWithTableData() throws Exception
	{
        //rm_EngineerAttendancePage.checkFileIsDowloadedOrNot();
		rm_EngineerAttendancePage.matchExcelSheetWithTableData();
		
	} */
	
	
	
	
	
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

	
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			/*driver.quit();
			initialization();

			rm_LoginPage = new LoginPageOfReportingManageRole();
			rm_HomePage = rm_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);*/
			// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

		}

	}


	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	
}
