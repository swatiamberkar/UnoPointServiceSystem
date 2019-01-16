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
import com.uno.pages.sd.SD_AddKEDBPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_KEDBPage;
import com.uno.pages.sd.SD_LoginPage;


public class SD_AddKEDBTest extends BaseCode {
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_KEDBPage kedbPageOfSDRole;
	SD_AddKEDBPage addKEDBPageOfSdRole;
	
	public SD_AddKEDBTest() {

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
	public void ViewTicket() throws Exception {

		homePageOfSdRole = new SD_HomePage();
		kedbPageOfSDRole = homePageOfSdRole.KEDBab();
		Thread.sleep(1000);
		addKEDBPageOfSdRole = kedbPageOfSDRole.addKEDBTab();
		Thread.sleep(1000);

	}

	@Test(priority = 1, groups = { "Known Error Data Base" }, 
			description = "1. If User click  on add KEDB button without enter any value in 'Problem Assessment' then notification should display as 'Please Select Product Category'."
			+ "2. If User click  on add KEDB button with only  Product Category in 'Problem Assessment' then notification should display as 'Please Select Sub Product Category'."
			+ "3. If User click  on add KEDB button with  Product Category & Sub Product Category in 'Problem Assessment' then notification should display as 'Please Enter The Known Error'."
			+ "4. If User click  on add KEDB button with  Product Category , Sub Product Category  &  Known Error in 'Problem Assessment' then notification should display as 'Please Enter Work Around Details'."
			+ "5. If User click  on add KEDB button with  Product Category , Sub Product Category , Known Error & Work Around Details  in 'Problem Assessment' then notification should display as 'Please Enter The Solution'.")
	@Description("1. If User click  on add KEDB button without enter any value in 'Problem Assessment' then notification should display as 'Please Select Product Category'."
			+ "2. If User click  on add KEDB button with only  Product Category in 'Problem Assessment' then notification should display as 'Please Select Sub Product Category'."
			+ "3. If User click  on add KEDB button with  Product Category & Sub Product Category in 'Problem Assessment' then notification should display as 'Please Enter The Known Error'."
			+ "4. If User click  on add KEDB button with  Product Category , Sub Product Category  &  Known Error in 'Problem Assessment' then notification should display as 'Please Enter Work Around Details'."
			+ "5. If User click  on add KEDB button with  Product Category , Sub Product Category , Known Error & Work Around Details  in 'Problem Assessment' then notification should display as 'Please Enter The Solution'.")
	public void checkAlertWithoutEnteringDataOfKEDB() throws Exception {

		addKEDBPageOfSdRole.checkAlertWithoutEnteringDataOfKEDB();

	}

	@Test(priority = 2, groups = { "Known Error Data Base" }, 
			description ="1. If User click  on add KEDB button with all data in 'Problem Assessment' then notification should display as 'KEDB added successfully.!'."
			+ "2. After Add KEDB that entry should be get added in KEDB table.")
	@Description("1. If User click  on add KEDB button with all data in 'Problem Assessment' then notification should display as 'KEDB added successfully.!'."
			+ "2. After Add KEDB that entry should be get added in KEDB table.")
	public void checkNotificationfterAddKEDBAndVerifyDataInKEDBTable()
			throws Exception {

		addKEDBPageOfSdRole
				.checkNotificationfterAddKEDBAndVerifyDataInKEDBTable();

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

				loginPageOfSdRole = new SD_LoginPage();
				homePageOfSdRole = loginPageOfSdRole.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);



			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				driver.quit();
				initialization();

				loginPageOfSdRole = new SD_LoginPage();
				homePageOfSdRole = loginPageOfSdRole.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);

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
