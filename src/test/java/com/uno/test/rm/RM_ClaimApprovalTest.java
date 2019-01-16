
package com.uno.test.rm;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_ClaimApprovalPage;
import com.uno.pages.rm.RM_ClaimPage;
import com.uno.pages.rm.RM_CreateNewClaimPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_ReimbursementAgainstAdvancePage;
import com.uno.pages.rm.RM_ViewMyClaimPage;

public class RM_ClaimApprovalTest extends BaseCode {

	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_ClaimPage rm_ClaimPage;
	RM_CreateNewClaimPage rm_CreateNewClaimPage;
	RM_ReimbursementAgainstAdvancePage rm_ReimbursementAgainstAdvancePage;
	RM_ViewMyClaimPage rm_ViewMyClaimPage;
	RM_ClaimApprovalPage rm_ClaimApprovalPage;
	ATUTestRecorder recorder;
	public static String methodName = null;
	String currentDir = System.getProperty("user.dir");

	public RM_ClaimApprovalTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

		initialization();

		rm_LoginPage = new RM_LoginPage();
		Thread.sleep(1000);
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM2"),
				properties.getProperty("password"));
		Thread.sleep(1000);
	

	}

	@BeforeMethod(alwaysRun = true)
	public void Claim(Method method) throws Exception {
		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());
		rm_HomePage = new RM_HomePage();
		rm_ClaimPage = rm_HomePage.ClaimTab();
		Thread.sleep(1000);
		rm_ClaimApprovalPage = rm_ClaimPage
				.ClaimApprovalTab();
		Thread.sleep(1000);

	}

	// Table in View Ticket //

	@Feature("")
	@Test(priority = 1, groups = { "Smoke Testing" }, 
	description = "In Claim approval tab, login RM tab should display ")
	@Description("In Claim approval tab, login RM tab should display ")
	public void VerifyRMAndLoginUser() throws Exception {
		rm_ClaimApprovalPage.verifyRMAndLoginUser();
	}
	
	@Feature("")
	@Test(priority = 2, groups = { "Smoke Testing" }, 
	description = "If user click on RM name tab then all reportees name should display with total claim amount")
	@Description("If user click on RM name tab then all reportees name should display with total claim amount")
	public void VerifyReporteesCount() throws Exception {
		rm_ClaimApprovalPage.verifyReporteesCount();
	}

	@Feature("")
	@Test(priority = 3, groups = { "Smoke Testing" }, 
	description = "If user click on view button against RM name tab then all claims should display of its reportees and login RM also")
	@Description("If user click on view button against RM name tab then all claims should display of its reportees and login RM also")
	public void verifyReporteesOfAllClaim() throws Exception {
		rm_ClaimApprovalPage.verifyReporteesOfAllClaim();
	}
	
	@Feature("")
	@Test(priority = 4, groups = { "Smoke Testing" }, 
	description = "If user click on view button against reportees name in hierarchy then all claims should display of respective reportee claim should display in Claim for Approval page")
	@Description("If user click on view button against reportees name in hierarchy then all claims should display of respective reportee claim should display in Claim for Approval page")
	public void verifyPerticularReporteesOfClaim() throws Exception {
		rm_ClaimApprovalPage.verifyPerticularReporteesOfClaim();
	}
	
	@Feature("")
	@Test(priority = 5, groups = { "Smoke Testing" }, 
	description = "In Claim for approval page, if user select from date and To date and click on Go button then claims should display where claim date is between applied daterenage filter")
	@Description("In Claim for approval page, if user select from date and To date and click on Go button then claims should display where claim date is between applied daterenage filter")
	public void VerifyFromToDate() throws Exception {
		rm_ClaimApprovalPage.verifyFromToDate();
	}
	
	@Feature("")
	@Test(priority = 6, groups = { "Smoke Testing" }, 
	description = "If User apply Expense Type filter and click on Go button, then claim entries should display where same claim type is present")
	@Description("If User apply Expense Type filter and click on Go button, then claim entries should display where same claim type is present")
	public void VerifyExpenseType() throws Exception {
		rm_ClaimApprovalPage.verifyExpenseType();
	}
	
	@Feature("")
	@Test(priority = 7, groups = { "Smoke Testing" }, 
	description = "For approval pending claim, if user click on View attachment hyperlink then list of files popup should get open with attachment files")
	@Description("For approval pending claim, if user click on View attachment hyperlink then list of files popup should get open with attachment files")
	public void VerifyPageByViewAttachmentHyperlink() throws Exception {
		rm_ClaimApprovalPage.verifyPageByViewAttachmentHyperlink();
	}
	
	@Feature("")
	@Test(priority = 8, groups = { "Smoke Testing" }, 
	description = "1. In Claim for approval page, if user click on Reject hyperlink then popup with Reject button should display"
			+ "2. If User enter comment and click on Reject button then alert bix should display as 'Are You Sure Want To Reject?'"
			+ "3. After click on OK button in Alert box then notification should display as 'Claim ID : '(ClaimID)' Rejected.' and comment should reflect in comment column")
	@Description("1. In Claim for approval page, if user click on Reject hyperlink then popup with Reject button should display"
			+ "2. If User enter comment and click on Reject button then alert bix should display as 'Are You Sure Want To Reject?'"
			+ "3. After click on OK button in Alert box then notification should display as 'Claim ID : '(ClaimID)' Rejected.' and comment should reflect in comment column")
	public void VerifyNotificationByReject() throws Exception {
		rm_ClaimApprovalPage.verifyNotificationByReject();
	}
	
	@Feature("")
	@Test(priority = 9, groups = { "Smoke Testing" }, 
	description = "1. If user click on checkox and click on Approve button then alert box should display as 'Are You Sure Want To Approve?'"
			+ "2.After click on OK button in Alert box while approve then notification should display as 'Claim Approved Successfully.'' ")
	@Description("1. If user click on checkox and click on Approve button then alert box should display as 'Are You Sure Want To Approve?'"
			+ "2. After click on OK button in Alert box while approve then notification should display as 'Claim Approved Successfully.'' ")
	public void checkNotificationByApproveClaim() throws Exception {
		rm_ClaimApprovalPage.checkNotificationByApproveClaim();
	}
	
	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {
		stopRecording();
		String path = currentDir + "/Recording/" + method.getName();
		changeFileName(path, method.getName());

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

				// String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir
						+ "/Screenshots/" + result.getMethod().getMethodName()
						+ ".jpg"));

				try {

					rm_HomePage = new RM_HomePage();
					rm_ClaimPage = rm_HomePage.ClaimTab();
					Thread.sleep(1000);
					rm_ClaimApprovalPage = rm_ClaimPage
							.ClaimApprovalTab();
					Thread.sleep(1000);
				} catch (Exception e) {
					driver.close();
					initialization();

					rm_LoginPage = new RM_LoginPage();
					Thread.sleep(1000);
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForRM2"),
							properties.getProperty("password"));
					Thread.sleep(1000);
					rm_HomePage = new RM_HomePage();
					rm_ClaimPage = rm_HomePage.ClaimTab();
					Thread.sleep(1000);
					rm_ClaimApprovalPage = rm_ClaimPage
							.ClaimApprovalTab();
					Thread.sleep(1000);
					
				}
				
				
				
			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				
				try {

					rm_HomePage = new RM_HomePage();
					rm_ClaimPage = rm_HomePage.ClaimTab();
					Thread.sleep(1000);
					rm_ClaimApprovalPage = rm_ClaimPage
							.ClaimApprovalTab();
					Thread.sleep(1000);
				} catch (Exception e) {
					driver.close();
					initialization();

					rm_LoginPage = new RM_LoginPage();
					Thread.sleep(1000);
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForRM2"),
							properties.getProperty("password"));
					Thread.sleep(1000);
					rm_HomePage = new RM_HomePage();
					rm_ClaimPage = rm_HomePage.ClaimTab();
					Thread.sleep(1000);
					rm_ClaimApprovalPage = rm_ClaimPage
							.ClaimApprovalTab();
					Thread.sleep(1000);
					
				}

			}
		} catch (Exception e) {
			driver.close();
			initialization();

			rm_LoginPage = new RM_LoginPage();
			Thread.sleep(1000);
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM2"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_HomePage = new RM_HomePage();
			rm_ClaimPage = rm_HomePage.ClaimTab();
			Thread.sleep(1000);
			rm_ClaimApprovalPage = rm_ClaimPage
					.ClaimApprovalTab();
			Thread.sleep(1000);

		}

	}

	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
