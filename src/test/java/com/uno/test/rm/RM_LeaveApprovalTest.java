package com.uno.test.rm;

import java.io.File;
import java.lang.reflect.Method;

import io.qameta.allure.Description;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_AttendanceApprovalPage;
import com.uno.pages.rm.RM_AttendancePage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LeaveApprovalPage;
import com.uno.pages.rm.RM_LoginPage;

public class RM_LeaveApprovalTest extends BaseCode {

	String currentDir = System.getProperty("user.dir");
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_AttendancePage rm_AttendancePage;
	RM_AttendanceApprovalPage rm_AttendanceApprovalPage;
	RM_LeaveApprovalPage rm_LeaveApprovalPage;

	@BeforeSuite(alwaysRun = true)
	public void login(Method method) throws Exception {

		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());
		try {
			initialization();
			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_AttendancePage = rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
			rm_AttendanceApprovalPage = rm_AttendancePage
					.attendanceApprovalTab();
			Thread.sleep(1000);
			rm_LeaveApprovalPage = rm_AttendanceApprovalPage.leaveApproval();

		} catch (Exception e) {
			driver.close();
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_AttendancePage = rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
			rm_AttendanceApprovalPage = rm_AttendancePage
					.attendanceApprovalTab();
			Thread.sleep(1000);
			rm_LeaveApprovalPage = rm_AttendanceApprovalPage.leaveApproval();
			// e.printStackTrace();
		}

	}

	@Test(priority = 1, groups = { "Leave Approval, Smoke Testing" }, description = " If User click on Attendance Approval page then leave Approvals Screen should display.")
	@Description(" If User click on Attendance Approval page then leave Approvals Screen should display.")
	public void CheckHeadingOfPage() throws Exception {
		rm_LeaveApprovalPage.checkHeadingOfPage();

	}

	@Test(priority = 2, groups = { "Leave Approval" }, description = "In Filter-> Select Date, if user select date and click on Go button then in  Leave Date, Leave Start Date and Leave End Date field of all entries, selected date should display ")
	@Description("In Filter-> Select Date, if user select date and click on Go button then in  Leave Date, Leave Start Date and Leave End Date field of all entries, selected date should display ")
	public void checkLeaveDate() throws Exception {
		rm_LeaveApprovalPage.checkLeaveDate();

	}

	@Test(priority = 3, groups = { "Leave Approval" }, description = "If User click on Leave Type and click on option"
			+ " should display same as per Leave master in Super login")
	@Description("If User click on Leave Type and click on option should display same as per Leave master in Super login ")
	public void MatchLeaveType() throws Exception {
		rm_LeaveApprovalPage.matchLeaveType();

	}

	@Test(priority = 4, groups = { "Leave Approval" }, description = "If User click on Pending button without select Availability then notification should display as 'Please Select Leave for (Emp_Name)'"
			+ "If User click on Pending button without select Leave Type then notification should display as 'Please Select Leave Type for (Emp_Name)'")
	@Description("If User click on Pending button without select Availability then notification should display as 'Please Select Leave for (Emp_Name)'"
			+ "If User click on Pending button without select Leave Type then notification should display as 'Please Select Leave Type for (Emp_Name)' ")
	public void CheckPendingFunctionality() throws Exception {
		rm_LeaveApprovalPage.checkPendingFunctionality();

	}

	@Test(priority = 5, groups = { "Leave Approval" }, description = "1.If User click on Reject button without select Availability then notification should display as 'You Can't Reject Without Leave for (Emp_Name)'"
			+ "2.If User click on Reject button without select Leave Type then notification should display as ' If you select Availability as Leave then select Leave Type..")
	@Description("1.If User click on Reject button without select Availability then notification should display as 'You Can't Reject Without Leave for (Emp_Name)'"
			+ "2.If User click on Reject button without select Leave Type then notification should display as ' If you select Availability as Leave then select Leave Type.. ")
	public void checkRejectFunctionality() throws Exception {
		rm_LeaveApprovalPage.checkRejectFunctionality();

	}

	@Test(priority = 6, groups = { "Leave Approval" }, description = "If User check check box and click on Submit approval button without select Availability then notification "
			+ "should display as 'Please Select Availability Leave for (Emp_name)'"
			+ "If User check check box and click on Submit approval button without select Leave type then notification "
			+ "should display as 'Please Select Leave Type for (Emp_name)'"
			+ "After update leave if user click on Pending button then notification should display as "
			+ "'Record Approved Successfully.!' and status should display as 'Approved'")
	@Description("If User check check box and click on Submit approval button without select Availability then notification "
			+ "should display as 'Please Select Availability Leave for (Emp_name)'"
			+ "If User check check box and click on Submit approval button without select Leave type then notification "
			+ "should display as 'Please Select Leave Type for (Emp_name)'"
			+ "After update leave if user click on Pending button then notification should display as "
			+ "'Record Approved Successfully.!' and status should display as 'Approved'")
	public void checkWithMultipleApproval() throws Exception {
		rm_LeaveApprovalPage.checkWithMultipleApproval();

	}

	@Test(priority = 6, groups = { "Leave Approval" }, description = "I//If User click on multiple Approval check box then all check box in table should get checked")
	@Description("If User click on multiple Approval check box then all check box in table should get checked'")
	public void checkAfterSelectingMultipleApproval() throws Exception {
		rm_LeaveApprovalPage.checkAfterSelectingMultipleApproval();

	}

	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {

		stopRecording();
		String path = currentDir + "/Recording/" + method.getName();
		changeFileName(path, method.getName());

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

			scrollDown(driver.findElement(By
					.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
			driver.findElement(
					By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']"))
					.click();

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

	@AfterClass
	public void tearDown() {

		driver.quit();

	}
}
