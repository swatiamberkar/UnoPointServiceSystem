package com.uno.test.rm;



import io.qameta.allure.Description;

import java.io.File;

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
import com.uno.pages.rm.RM_AttendancePage;
import com.uno.pages.rm.RM_EngineerAvailabilityPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.sd.SD_AttendancePage;
import com.uno.pages.sd.SD_EngineerActivityPage;
import com.uno.pages.sd.SD_EngineerAvailabilityPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_SDActivityPage;
import com.uno.pages.sd.SD_TicketPage;
public class RM_EngineerAvailabilityTest extends BaseCode {

		RM_LoginPage rm_LoginPage;
		RM_HomePage rm_HomePage;
		//SD_TicketPage ticketPageOfSdRole;
		//SD_EngineerActivityPage engineerActivityPageOfSdRole;
		//SD_SDActivityPage sdActivityPageOfSdRole;
		RM_AttendancePage rm_AttendancePage;
		RM_EngineerAvailabilityPage rm_EngineerAvailabilityPage;
		
		public RM_EngineerAvailabilityTest() {

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
		public void EngineerActivityTab() throws Exception  {

			rm_HomePage = new RM_HomePage();
			driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
			rm_AttendancePage = rm_HomePage.AttendanceTab();
			Thread.sleep(1000);
			rm_EngineerAvailabilityPage =rm_AttendancePage.engineerAvailabilityTab();
			Thread.sleep(2000);

		}


		
		@Test(priority = 1, groups = { "Engineer availability " }, 
		description = " In Engineer availability table, bydefault updated attendance entries should display in table for employee (For present day)."
				+ "2. If User select option from Role filter and click on Go button then attendance entries should display for selected role, where attendance is updated")
		@Description (" In Engineer availability table, bydefault updated attendance entries should display in table for employee (For present day)."
				+ "2. If User select option from Role filter and click on Go button then attendance entries should display for selected role, where attendance is updated")			
		public void checkFromAndToDateAccordingSelectedDateRange() throws Exception  {

			rm_EngineerAvailabilityPage.checkByDefaultUpdatedDate();
			//rm_EngineerAvailabilityPage.varifyEngineerAccordingSelectedRole();

		}
		
		@Test(priority = 2, groups = { " Engineer availability " }, 
				description = "1. If User select To date and click on Go button then alert message should display as 'Please insert from date'"
						+ "2. If User select From date and click on Go button then alert message should display as 'Please insert to date'"
						+ "3. If User select from and To date  and click on Go button then entries should display within selected date range."
						+ "4. If User apply engineer filter and click on Go button then entries should display for selected engineer only"
						+ "5. If User select Business unit filter and click on Go button then employee attendance entries should display whose BU is as per applied filter")
				@Description (" 1. If User select To date and click on Go button then alert message should display as 'Please insert from date'"
						+ "2. If User select From date and click on Go button then alert message should display as 'Please insert to date'"
						+ "3. If User select from and To date  and click on Go button then entries should display within selected date range."
						+ "4. If User apply engineer filter and click on Go button then entries should display for selected engineer only."
						+ "5. If User select Business unit filter and click on Go button then employee attendance entries should display whose BU is as per applied filter")			
				public void checkSearchFilter() throws Exception  {

					rm_EngineerAvailabilityPage.checkSearchFilter();

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

					// TestUtil.takeScreenshotAtEndOfTest();
					File scrFile = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);

					String currentDir = System.getProperty("user.dir");

					FileUtils.copyFile(scrFile, new File(currentDir
							+ "/Screenshots/" + result.getMethod().getMethodName()
							+ ".jpg"));

					/*driver.quit();
					initialization();

					rm_LoginPage = new SD_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);*/

					// takeScreenshot(dateTimeStamp,driver,methodName);
					// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
					// Do your excel writing stuff here

				} else if (result.getStatus() == ITestResult.SKIP) {
					System.out.println("================");
					System.out.println(result.getMethod().getMethodName());
					System.out.println("======Skip======");
					driver.quit();
					initialization();
				}
/*
					rm_LoginPage = new SD_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);

				}*/
			/*} catch (Exception e) {
				driver.close();
				initialization();

				rm_LoginPage = new SD_LoginPage();
				rm_HomePage = rm_LoginPage.Login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);

			}
*/
		}

		@AfterClass
		public void TearDown() {
			driver.quit();
		}

	}

