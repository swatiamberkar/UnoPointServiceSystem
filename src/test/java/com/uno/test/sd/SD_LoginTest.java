package com.uno.test.sd;

import io.qameta.allure.Description;






import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;


public class SD_LoginTest extends BaseCode {

	SD_LoginPage sd_LoginPage;
	SD_HomePage homePageOfSdRole;
	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\LoginUno.xlsx";
	String sheetName = "Sheet1";

	public SD_LoginTest() {

		super();

	}

	@BeforeClass(alwaysRun = true)
	public void Setup() throws Exception {
		
		initialization();
		sd_LoginPage = new SD_LoginPage();
		Thread.sleep(1000);
	

	}
/*
	@BeforeMethod
	public void Login() throws Exception {
		
		sd_LoginPage = new SD_LoginPage();
		Thread.sleep(1000);

		
	}*/

	@Test(priority = 1, groups = { "Regression Testing" })
	@Description("Check the login page title ")
	public void TestLoginPageTitle() {
		String titleOfLoginPage = sd_LoginPage.loginPageTitle();
		System.out.println(titleOfLoginPage);
		Assert.assertEquals(titleOfLoginPage, "UNOPOINT");

	}

	@Test(priority = 2, groups = { "Regression Testing" })
	@Description("Check team button is selected or not")
	public void CheckTeamButton() throws Exception {
		sd_LoginPage.CheckTeamButton();

	}

	@Test(priority = 3, groups = { "Regression Testing" })
	@Description("check login button with blank field")
	public void CheckLoginButtonWithBlankData() throws Exception {
		sd_LoginPage.checkLoginButtonWithBlankData();

	}

	@DataProvider
	public String[][] getLoginUnoSheetdata() throws Exception {
		TestUtil data = new TestUtil();
		// Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetName);

	}

	@Test(priority = 4, dataProvider = "getLoginUnoSheetdata", groups = { "Regression Testing" })
	@Description("If User  team check box and click on Login button with wrong details, then notification"
			+ " should display as 'Wrong User name and Password'")
	public void CheckWithWrongLoginCredentials(String username, String password)
			throws Exception {
		// sd_LoginPage.checkWithWrongLoginCredentials();
		sd_LoginPage.checkWithWrongLoginCredentials(username, password);

	}

	@Test(priority = 5, groups = {"Smoke Testing" })
	@Description("If User check Customer check box and click on trouble ticket field then trouble ticket "
			+ "form should get open to log trouble ticket")
	public void SelectCustomer() throws Exception {
		sd_LoginPage.selectCustomer();

	}

	@Test(priority = 6, groups = {"Smoke Testing" })
	@Description("If User check Customer check box and click on skip hyper link then system allow to enter customer "
			+ "login credentials in User name and password fields")
	public void CheckAfterSkip() throws Exception {
		sd_LoginPage.checkAfterSkip();

	}

	@Test(priority = 7, groups = {"Smoke Testing" })
	@Description("Enter Username in username field And click on Reset Password button then "
			+ "'Reset password link has been send on your registered email ID'  "
			+ "notification should display with Back to login link")
	public void CheckForgotPasswordLinkWithUsername() throws Exception {
		sd_LoginPage.checkForgotPasswordLink();

	}

	@Test(priority = 8, groups = {"Regression Testing" })
	@Description("If user try to enter all details in 'Enter either of the detail' popup then "
			+ "previous details get dissable and latest value should remain in page ")
	public void CheckWithAllFieldFill() throws Exception {
		sd_LoginPage.checkWithAllFieldFill();

	}

	@Test(priority = 9, groups = {"Regression Testing" })
	@Description("If user enter all wrong data in username, Ecode and Email field then "
			+ "'No record is associate with User Name.' notification should display")
	public void checkWithWrongData() throws Exception {
		sd_LoginPage.checkWithWrongData();

	}

	@Test(priority = 10, groups = { "Smoke Testing" })
	@Description("Check the login butto functinality with positive login data")
	public void TestLoginPage() throws Exception {
		Thread.sleep(500);
		homePageOfSdRole = sd_LoginPage.login(
				properties.getProperty("username"),
				properties.getProperty("password"));
	}

	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======PASS======");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======FAIL======");

			driver.quit();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			Thread.sleep(1000);

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			driver.quit();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			Thread.sleep(1000);

		}

	}

	
	
	@AfterClass
	public void tearDown() {
		driver.close();
			driver.quit();
		
	}

}
