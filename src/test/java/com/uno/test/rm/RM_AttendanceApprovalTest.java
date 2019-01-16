package com.uno.test.rm;

import java.io.File;

import io.qameta.allure.Description;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_AttendanceApprovalPage;
import com.uno.pages.rm.RM_AttendancePage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_MyAvailabilityPage;

public class RM_AttendanceApprovalTest extends BaseCode
{

	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_AttendancePage rm_AttendancePage;
	RM_AttendanceApprovalPage rm_AttendanceApprovalPage;
	
	public RM_AttendanceApprovalTest() 
	{
		super();
	}
	

	@BeforeSuite(alwaysRun = true)
	public void login() throws Exception 
	{
		try {
			initialization();
			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_AttendancePage=rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
		     rm_AttendanceApprovalPage =  rm_AttendancePage.attendanceApprovalTab();
			 
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
		     rm_AttendanceApprovalPage =  rm_AttendancePage.attendanceApprovalTab();

			// e.printStackTrace();
		}

	}
	
	@Test(priority=1, groups = { "My Availability"} ,description = "If User click on My Availability tab, then View My Availability page should get open with last login details" )
	@Description("If User click on My Availability tab, then View My Availability page should get open with last login details")
	public void CheckHeadingOfPage() throws Exception
	{
		rm_AttendanceApprovalPage.checkHeadingOfPage();
		
	}

	@Test(priority=2, groups = { "My Availability"} ,description = "In Filter-> Select Date, if user select date and click on Go button then in Avail Date field of all entries selected date should display" )
	@Description("In Filter-> Select Date, if user select date and click on Go button then in Avail Date field of all entries selected date should display")
	public void CheckAvailDate() throws Exception
	{
		rm_AttendanceApprovalPage.checkAvailDate();
		
	}
	
	@Test(priority=3, groups = { "My Availability"} ,description = "In Availability filter list, Login and Logout option should display" )
	@Description("In Availability filter list, Login and Logout option should display")
	public void checkAvailabilityFilterList() throws Exception
	{
		rm_AttendanceApprovalPage.checkAvailabilityFilterList();
		
	}
	
	@Test(priority=4, groups = { "My Availability"} ,description = "If User click on Login Time link then "
			+ "'Update Login Time' popup should display then user able to select time to update login time."
			+ "If User click on Update button after select time then same should get update in Login Time  and  "
			+ "notification should display as 'Time Updated Successfully.!'" )
	@Description("If User click on Login Time link then 'Update Login Time' popup should display then user able "
			+ "to select time to update login time."
			+ "If User click on Update button after select time then same should get update in Login Time  and "
			+ " notification should display as 'Time Updated Successfully.!'")
	public void CheckWithLoginSelect() throws Exception
	{
		rm_AttendanceApprovalPage.checkWithLoginSelect();
		
	}
	
	@Test(priority=5, groups = { "My Availability"} ,description = "1.If User click on Pending button without update "
			+ "login details then notification should display as 'Please Select Login for (Emp_Name)'"
			+ "If User check check box of entry without update Availability option and click on Submit Approval button "
			+ "then notification should display as 'Please Select Availability Login for (Emp_Name).'" )
	@Description("1.If User click on Pending button without update "
			+ "login details then notification should display as 'Please Select Login for (Emp_Name)'"
			+ "If User check check box of entry without update Availability option and click on Submit Approval button "
			+ "then notification should display as 'Please Select Availability Login for (Emp_Name).'")
	public void CheckPendingFunctionality() throws Exception
	{
		rm_AttendanceApprovalPage.checkPendingFunctionality();
		
	}
	

	@Test(priority=6, groups = { "My Availability"} ,description = "1.If User click on Reject button without update any "
			+ "details then after click on Reject button in pop up then notification should display as 'You Can't Reject Without Login Or Leave for (Emp_Name)'"
			+ "2.If User update availability and click on Reject button then after update click on Reject button "
			+ "in Pop up, notification should display as 'Record Rejected Successfully.!' and Availability details also get refreshed." )
	@Description("1.If User click on Reject button without update any details then after click on Reject button in "
			+ "pop up then notification should display as 'You Can't Reject Without Login Or Leave for (Emp_Name)'"
			+ "2.If User update availability and click on Reject button then after update click on Reject button "
			+ "in Pop up, notification should display as 'Record Rejected Successfully.!' and Availability details also get refreshed.")
	public void CheckRejectFunctionality() throws Exception
	{
		rm_AttendanceApprovalPage.checkRejectFunctionality();
		
	}
	
	@Test(priority=7, groups = { "My Availability"} ,description = "If User select availability and check checkbox then "
			+ "after click on Submit Approval button then in login time, current time should display same "
			+ "current date and time  display in Updated Date Time column. Updated By column should display login name "
			+ " and status should become 'Approved'.also notification should display as 'Record Approved Successfully.!'" )
	@Description("If User select availability and check checkbox then "
			+ "after click on Submit Approval button then in login time, current time should display same "
			+ "current date and time  display in Updated Date Time column. Updated By column should display login name "
			+ " and status should become 'Approved'.also notification should display as 'Record Approved Successfully.!'")
	public void CheckWithMultipleApproval() throws Exception
	{
		rm_AttendanceApprovalPage.checkWithMultipleApproval();
		
	}
	
	@Test(priority=7, groups = { "My Availability"} ,description ="If Attendance status is 'Approved' then in Engineer Attendance "
			+ "tab value should display as 'Login' (If Attendance Approve By Reporting Manager setting is 'Yes'")
			@Description("If Attendance status is 'Approved' then in Engineer Attendance "
					+ "tab value should display as 'Login' (If Attendance Approve By Reporting Manager setting is 'Yes')")
	public void VerifyAfterApprove() throws Exception
	{
		rm_AttendanceApprovalPage.verifyAfterApprove();
		
	}
	
	@Test(priority=8, groups = { "My Availability"} ,description ="If Attendance status is 'Rejected' then in Engineer "
			+ "Attendance tab value should display as 'Not available' (If Attendance Approve By Reporting Manager "
			+ "setting is 'Yes')")
			@Description("If Attendance status is 'Rejected' then in Engineer Attendance tab value should display as "
					+ "'Not available' (If Attendance Approve By Reporting Manager setting is 'Yes')")
	public void VerifyAfterReject() throws Exception
	{
		rm_AttendanceApprovalPage.verifyAfterReject();
		
	}
	@Test(priority=9, groups = { "My Availability"} ,description ="If entry is pending from RM then in Engineer "
			+ "Attendance tab value should display as 'Not Available' (If Attendance Approve By Reporting Manager setting is 'Yes')")
			@Description("If entry is pending from RM then in Engineer Attendance tab value should display as"
					+ " 'Not Available' (If Attendance Approve By Reporting Manager setting is 'Yes')")
	public void VerifyWithPendingStatus() throws Exception
	{
		rm_AttendanceApprovalPage.verifyWithPendingStatus();
		
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

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", driver.findElement(By
							.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
			driver.findElement(
					By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

			rm_HomePage = new RM_HomePage();
			rm_AttendancePage = rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
			rm_AttendanceApprovalPage = rm_AttendancePage.attendanceApprovalTab();
		

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			driver.quit();
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

		}

	}

	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	
}

	
	
