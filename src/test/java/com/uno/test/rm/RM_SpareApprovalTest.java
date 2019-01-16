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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_InventoryPage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_SpareApprovalPage;
import com.uno.pages.rm.RM_TransactionRegisterPage;

public class RM_SpareApprovalTest extends BaseCode {

	String currentDir = System.getProperty("user.dir");
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_InventoryPage rm_InventoryPage;
	RM_SpareApprovalPage rm_SpareApprovalPage;

	public RM_SpareApprovalTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

		initialization();

		rm_LoginPage = new RM_LoginPage();
		rm_HomePage = rm_LoginPage.Login(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		Thread.sleep(1000);

	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());

		rm_HomePage = new RM_HomePage();
		scrollDown(driver.findElement(By
				.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
		rm_InventoryPage = rm_HomePage.InventoryTab();
		Thread.sleep(1000);
		rm_SpareApprovalPage = rm_InventoryPage.SpareApprovalTab();
		Thread.sleep(1000);
	}

	@Test(priority = 1, groups = { "SpareApproval: Filter", "Smoke Testing" }, description = "In Search-> Incident ID field,  user should able to search Spare request by Incident ID")
	@Description("In Search-> Incident ID field,  user should able to search Spare request by Incident ID")
	public void checkIncidentID() throws Exception {
		rm_SpareApprovalPage.checkIncidentID();

	}

	@Test(priority = 2, groups = { "SpareApproval: Filter", "Smoke Testing" }, description = " If User enter Part code in Search-> part code field and click on Go button then in outcomes, part code should be display as per searched value")
	@Description("If User enter Part code in Search-> part code field and click on Go button then in outcomes, part code should be display as per searched value")
	public void checkPartCode() throws Exception {
		rm_SpareApprovalPage.checkPartCode();

	}

	@Test(priority = 3, groups = { "SpareApproval: Filter", "Smoke Testing" }, description = "If User enter Part name in Search-> part name field and click on Go button then in outcomes, part name should be display as per searched value")
	@Description("If User enter Part name in Search-> part name field and click on Go button then in outcomes, part name should be display as per searched value")
	public void checkPartName() throws Exception {
		rm_SpareApprovalPage.checkPartName();

	}

	@Test(priority = 4, groups = { "SpareApproval: Filter", "Smoke Testing" }, description = "If User search by from and to date then, in all outcomes DateOfRequest should display same and between the from and To date values")
	@Description("If User search by from and to date then, in all outcomes DateOfRequest should display same and between the from and To date values")
	public void checkFromAndToDateAccordingSelectedDateRange() throws Exception {
		rm_SpareApprovalPage.checkFromAndToDateAccordingSelectedDateRange();

	}

	@Test(priority = 5, groups = { "SpareApproval: View/Accept/Reject/Remark",
			"Smoke Testing" }, description = "User able to update/add  Spare remark by clicking on Update symbol in Edit spare remark column")
	@Description("User able to update/add  Spare remark by clicking on Update symbol in Edit spare remark column")
	public void checkUpdateSpareRemark() throws Exception {
		rm_SpareApprovalPage.checkUpdateSpareRemark();

	}

	@Test(priority = 6, groups = { "SpareApproval: View/Accept/Reject/Remark",
			"Smoke Testing" }, description = "1.after click on view button then View Engineer Stock should display ."
			+ "2.If user click on View button of same spare request ID, then view engineer stock page should display with all spare entries present in engineer stock with same part name and part code.")
	@Description("1.after click on view button then View Engineer Stock should display ."
			+ "2.If user click on View button of same spare request ID, then view engineer stock page should display with all spare entries present in engineer stock with same part name and part code.")
	public void checkViewFunctionality() throws Exception {
		rm_SpareApprovalPage.checkViewFunctionality();

	}

	@Test(priority = 7, groups = { "SpareApproval: View/Accept/Reject/Remark",
			"Smoke Testing" }, description = "If RM Click on Approve button of spare request then, spare request entry should get remove from Dash board")
	@Description("If RM Click on Approve button of spare request then, spare request entry should get remove from Dash board")
	public void checkApproveButtonFunctionality() throws Exception {
		rm_SpareApprovalPage.checkApproveButtonFunctionality();

	}

	@Test(priority = 8, groups = { "SpareApproval: View/Accept/Reject/Remark",
			"Smoke Testing" }, description = "If RM Click on Reject button of spare request then, Reason For Reject Spare pop up should display ")
	@Description("If RM Click on Reject button of spare request then, Reason For Reject Spare pop up should display ")
	public void checkRejectButtonFunctionality() throws Exception {
		rm_SpareApprovalPage.checkRejectButtonFunctionality();

	}

	@Test(priority = 9, groups = { "SpareApproval: View/Accept/Reject/Remark",
			"Smoke Testing" }, description = "As per RM approve or Reject spare request then it should display in SD login-> ticket ID-> spare tab-> respective spare request ->status as Approve or Reject ")
	@Description("As per RM approve or Reject spare request then it should display in SD login-> ticket ID-> spare tab-> respective spare request ->status as Approve or Reject ")
	public void checkStatusInSD() throws Exception {
		rm_SpareApprovalPage.checkStatusInSD();

	}

	@Test(priority = 10, groups = { "SpareApproval: View/Accept/Reject/Remark",
			"Smoke Testing" }, description = "As per RM update remark for spare request and click on approve or Reject spare request then same remark should display in SD login-> ticket ID-> spare tab-> respective spare request entry-> Spare remark field ")
	@Description("As per RM update remark for spare request and click on approve or Reject spare request then same remark should display in SD login-> ticket ID-> spare tab-> respective spare request entry-> Spare remark field ")
	public void checkRemarkInSD() throws Exception {
		rm_SpareApprovalPage.checkRemarkInSD();

	}

	@Test(priority = 11, groups = { "SpareApproval : Pagination",
			"Smoke Testing" }, description = "count of pagination")
	@Description("count of pagination")
	public void CountOfPagination() throws Exception {
		rm_SpareApprovalPage.countOfPagination();

	}

	@Test(priority = 12, groups = { "SpareApproval :pagination",
			"Smoke Testing" }, description = "1.If user click on leftmost arrow then control should transfer on first page in  page transact inventory page"
			+ "2.If user click on left arrow then control should transfer on Previous page of current page showing  in transact inventory page"
			+ "3.If user click on rightmost arrow then control should transfer on Last page in transact inventory page"
			+ "4.If user click on right arrow then control should transfer on next page of current page showing in transact inventory page")
	@Description("1.If user click on leftmost arrow then control should transfer on first page in  page transact inventory page"
			+ "2.If user click on left arrow then control should transfer on Previous page of current page showing  in transact inventory page"
			+ "3.If user click on rightmost arrow then control should transfer on Last page in transact inventory page"
			+ "4.If user click on right arrow then control should transfer on next page of current page showing in transact inventory page")
	public void DisplayAsPerArrowsOfPagination() throws Exception {
		rm_SpareApprovalPage.displayAsPerArrowsOfPagination();

	}

	@Test(priority = 10, groups = { "SpareApproval : DownloadExcel",
			"Smoke Testing" }, description = "If User click on Download Excel button then Excel should get download with number of entries showing as per Total count")
	@Description("If User click on Download Excel button then Excel should get download with number of entries showing as per Total count.")
	public void verifyDownloadExcel() throws Exception {
		rm_SpareApprovalPage.verifyDownloadExcel();

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
