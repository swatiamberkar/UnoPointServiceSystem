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
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_ManagerActivityPage;


public class RM_ManagerActivityTest extends BaseCode{


	/*RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;*/
	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;
	//	SD_EngineerActivityPage engineerActivityPageOfSdRole;
		RM_ManagerActivityPage rm_ManagerActivityPage;
		
		public RM_ManagerActivityTest() {

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
			rm_IncidentPage = rm_HomePage.IncidentTab();
			Thread.sleep(1000);
			rm_ManagerActivityPage =rm_IncidentPage.ManagerActivityTab();
			Thread.sleep(2000);

		}


		
		@Test(priority = 2, groups = { "Engineer Activity" }, 
		description = "1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill ")
		@Description ("1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill")			
		public void checkFromAndToDateAccordingSelectedDateRange() throws Exception  {

			rm_ManagerActivityPage.checkFromAndToDateAccordingSelectedDateRange();

		}
		
		@Test(priority = 2, groups = { "Engineer Activity" }, 
		description = "1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill ")
		@Description ("1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill")			
		public void verifyPopLocationAccordingSelectedPopLocation() throws Exception  {

			rm_ManagerActivityPage.verifyPopLocationAccordingSelectedPopLocation();

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
					/*driver.quit();
					initialization();

					rm_LoginPage = new SD_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);*/

				}
			

		}

		@AfterClass
		public void TearDown() {
			driver.quit();
		}


	}

