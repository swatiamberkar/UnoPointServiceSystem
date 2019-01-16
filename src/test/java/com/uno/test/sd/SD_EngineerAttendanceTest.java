package com.uno.test.sd;

import java.io.File;

import io.qameta.allure.Description;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.sd.SD_AttendancePage;
import com.uno.pages.sd.SD_EngineerAttendancePage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;


public class SD_EngineerAttendanceTest extends BaseCode  
{
	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\file\\EngineerAttendance.xlsx";
    String sheetName = "Sheet1";
    String sheetNameForState = "state";
    
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_AttendancePage sd_AttendancePage;
	SD_EngineerAttendancePage sd_EngineerAttendancePage;
	
	public SD_EngineerAttendanceTest()
	{
		super();
	}
	@BeforeSuite(alwaysRun = true)
	public void Login() throws Exception {
		try {
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			sd_AttendancePage=sd_HomePage.attendanceTab();
			Thread.sleep(1000);
			sd_EngineerAttendancePage = sd_AttendancePage.engineerAttendanceTab();
			
		} catch (Exception e) {
			

			
			driver.close();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			sd_AttendancePage=sd_HomePage.attendanceTab();
			Thread.sleep(1000);
			sd_EngineerAttendancePage = sd_AttendancePage.engineerAttendanceTab();
			
			
		}

	}

	@Test(priority= 1, groups = { "Engineer Attendance"} ,description = "If User click on Engineer Attendance tab, then View Engineer Attendance page should get open with last login details" )
	@Description("If User click on Engineer Attendance tab, then View Engineer Attendance page should get open with last login details")
	public void CheckHeadingOfPage() throws Exception
	{
		sd_EngineerAttendancePage.checkHeadingOfPage();
		
	}
	
	@Test(priority= 2, groups = { "Engineer Attendance"} ,description = "1.If user click on Go button without select any filter then notification"
			+ " should display as 'Please select Year And Month First' (Year and month filters are mandatory)"
			+ "2.In Engineer attendance tab if user apply Employee role filter and click"
			+ "on Go button then entries should display which having selected employee roles" )
	@Description("1.If user click on Go button without select any filter then notification"
			+ " should display as 'Please select Year And Month First' (Year and month filters are mandatory)"
			+ "2.In Engineer attendance tab if user apply Employee role filter and click"
			+ " on Go button then entries should display which having selected employee roles")
	public void MatchEmployeeRoleAfterSelectingFilter() throws Exception
	{
		sd_EngineerAttendancePage.matchEmployeeRoleAfterSelectingFilter();
		
	}
	@Test(priority= 3, groups = { "Engineer Attendance"} ,description = "In Engineer attendance tab if user apply Customer Name filter and click on Go button then entries should display as per selected customer name " )
	@Description("In Engineer attendance tab if user apply Customer Name filter and click on Go button then entries should display as per selected customer name  ")
	public void MatchCustomerAfterSelectingFilter() throws Exception
	{
		sd_EngineerAttendancePage.matchCustomerAfterSelectingFilter();
		
	}

	@Test(priority= 4, groups = { "Engineer Attendance"} ,description = "In Engineer attendance tab if user apply state filter and click on Go button then employee entries should whose assigned state is as per selected state filter " )
	@Description("In Engineer attendance tab if user apply state filter and click on Go button then employee entries should whose assigned state is as per selected state filter ")
	public void MatchStateAfterSelectingStateFilter() throws Exception
	{
		sd_EngineerAttendancePage.matchStateAfterSelectingStateFilter();
		
	}
		
	@Test(priority= 5, groups = { "Engineer Attendance"} ,description = "If in Super login-> Attendance approval by Reporting Manager is 'Yes' then without Approving By RM, it shoud not Reflect on Enginner Attaendace Dashboard.It should display as Not Available" )
	@Description("If in Super login-> Attendance approval by Reporting Manager is 'Yes' then without Approving By RM, it shoud not Reflect on Enginner Attaendace Dashboard.It should display as Not Available")
	public void CheckAttendanceWithYesSelectInRMSetting() throws Exception
	{
		sd_EngineerAttendancePage.checkAttendanceWithYesSelectInRMSetting();
		
    }
	@Test(priority= 6, groups = { "Engineer Attendance"} ,description = "If in Super login-> Attendance approval by Reporting Manager is 'No' then without Approving By RM, it should reflect on Engineer Attendance Dash board as Login, Leave(Sick,Casual.Privilage,Paid)" )
	@Description("If in Super login-> Attendance approval by Reporting Manager is 'No' then without Approving By RM, it should reflect on Engineer Attendance Dash board as Login, Leave(Sick,Casual.Privilage,Paid)")
	public void CheckAttendanceWithNoSelectInRMSetting() throws Exception
	{
		sd_EngineerAttendancePage.checkAttendanceWithNoSelectInRMSetting();
		
	}
	@Test(priority= 7, groups = { "Engineer Attendance"} ,description = "In Engineer Attendance-Total Opening Balance count should display as per update in employee master that should Reflect in sd Login,Technician Login, Mobile Application" )
	@Description("In Engineer Attendance-Total Opening Balance count should display as per update in employee master that should Reflect in sd Login,Technician Login, Mobile Application")
	public void CheckTotalOpeningBalanceCount() throws Exception
	{
		sd_EngineerAttendancePage.checkTotalOpeningBalanceCount();
		
	}
	

	@Test(priority= 8, groups = { "Engineer Attendance"} ,description = "If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet" )
	@Description("//If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet")
	public void CheckFileIsDowloadedOrNot() throws Exception
	{
		sd_EngineerAttendancePage.checkFileIsDowloadedOrNot();
		
	}
	
	   
	@Test(priority= 9, groups = { "Engineer Attendance"} ,description = "If User apply Leave for Compensatory/ Holiday/Week Off then in leave taken column count should not get added" )
	@Description("If User apply Leave for Compensatory/ Holiday/Week Off then in leave taken column count should not get added")
	public void CheckTotalLeaveCountAfterCompensatoryLeave() throws Exception
	{
		sd_EngineerAttendancePage.checkTotalLeaveCountAfterCompensatoryLeave();
		
	}
	
	/*@Test(priority= 10, groups = { "Engineer Attendance"} ,description = "If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet" )
	@Description("//If User click on Download button then excel should get download with same entries which are present in Engineer attendance sheet")
	public void MatchExcelSheetWithTableData() throws Exception
	{
        //sd_EngineerAttendancePage.checkFileIsDowloadedOrNot();
		sd_EngineerAttendancePage.matchExcelSheetWithTableData();
		
	} */
	
	@DataProvider
	public String[][] getEmployeeRoleSheetdata() throws Exception{
		TestUtil data= new TestUtil();
		//Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetName);
		
		
	 }
	
	@Test(priority = 13, dataProvider= "getEmployeeRoleSheetdata")
	@Description("In Engineer attendance tab if user apply Customer Name filter and click"
			+ " on Go button then entries should display as per selected customer name.")
	public void MatchEmployeeRoleUsingDataDriven(String yearddl, String monthddl, String empolyeeRoleddl, String searchByRoleddl) throws Exception
	{
		//sd_LoginPage.checkWithWrongLoginCredentials();
		sd_EngineerAttendancePage.matchEmployeeRoleUsingDataDriven(yearddl, monthddl, empolyeeRoleddl, searchByRoleddl );
	
	}
	
	@DataProvider
	public String[][] getStatesValueFromSheet() throws Exception{
		TestUtil data= new TestUtil();
		//Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetNameForState);
		
		
	 }

	@Test(priority = 14, dataProvider= "getStatesValueFromSheet")
	@Description("In Engineer attendance tab if user apply Customer Name filter and click"
			+ " on Go button then entries should display as per selected customer name.")
	public void MatchStateFilterUsingDataDriven(String yearddl, String monthddl, String stateddl, String popLocationddl) throws Exception
	{
		//sd_LoginPage.checkWithWrongLoginCredentials();
		sd_EngineerAttendancePage.matchStateFilterUsingDataDriven(yearddl, monthddl, stateddl, popLocationddl );
	
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

	
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			/*driver.quit();
			initialization();

			sd_LoginPage = new LoginPageOfReportingManageRole();
			sd_HomePage = sd_LoginPage.login(
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
