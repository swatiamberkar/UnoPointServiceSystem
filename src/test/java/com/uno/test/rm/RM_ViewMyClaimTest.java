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
import com.uno.pages.rm.RM_ClaimPage;
import com.uno.pages.rm.RM_CreateNewClaimPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_ReimbursementAgainstAdvancePage;
import com.uno.pages.rm.RM_ViewMyClaimPage;

public class RM_ViewMyClaimTest extends BaseCode {

	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_ClaimPage rm_ClaimPage;
	RM_CreateNewClaimPage rm_CreateNewClaimPage;
	RM_ReimbursementAgainstAdvancePage rm_ReimbursementAgainstAdvancePage;
	RM_ViewMyClaimPage rm_ViewMyClaimPage;
	ATUTestRecorder recorder;
	public static String methodName = null;
	String currentDir = System.getProperty("user.dir");

	public RM_ViewMyClaimTest() {
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
		/*
		 * rm_HomePage = new RM_HomePage(); rm_ClaimPage =
		 * rm_HomePage.ClaimTab(); Thread.sleep(1000); rm_CreateNewClaimPage =
		 * rm_ClaimPage.CreateNewTab(); Thread.sleep(1000);
		 */

	}

	@BeforeMethod(alwaysRun = true)
	public void Claim(Method method) throws Exception {
		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());
		rm_HomePage = new RM_HomePage();
		rm_ClaimPage = rm_HomePage.ClaimTab();
		Thread.sleep(1000);
		rm_ViewMyClaimPage = rm_ClaimPage
				.ViewMyClaimTab();
		Thread.sleep(1000);

	}

	// Table in View Ticket //

	@Feature("")
	@Test(priority = 1, groups = { "Smoke Testing" }, description = "In table format if user click on Expence type field then all expence type should display as present in system")
	@Description("In table format if user click on Expence type field then all expence type should display as present in system")
	public void VerifyLoginUser() throws Exception {
		rm_ViewMyClaimPage.verifyLoginUser();
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

				/*
				 * try { rm_HomePage = new RM_HomePage(); rm_ClaimPage =
				 * rm_HomePage.ClaimTab(); Thread.sleep(1000);
				 * rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
				 * Thread.sleep(1000);
				 * 
				 * } catch (Exception e) {
				 * 
				 * driver.close(); initialization();
				 * 
				 * 
				 * rm_LoginPage = new RM_LoginPage(); Thread.sleep(1000);
				 * rm_HomePage = rm_LoginPage.Login(
				 * properties.getProperty("loginIdForRM2"),
				 * properties.getProperty("password")); Thread.sleep(1000);
				 * rm_HomePage = new RM_HomePage(); rm_ClaimPage =
				 * rm_HomePage.ClaimTab(); Thread.sleep(1000);
				 * rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
				 * Thread.sleep(1000); }
				 */
			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");

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
			rm_ViewMyClaimPage = rm_ClaimPage
					.ViewMyClaimTab();
			Thread.sleep(1000);

		}

	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
