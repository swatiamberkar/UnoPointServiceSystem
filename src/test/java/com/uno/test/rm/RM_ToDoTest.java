package com.uno.test.rm;

import java.io.File;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
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
import com.uno.pages.rm.RM_ToDoPage;





public class RM_ToDoTest extends BaseCode{


		
		RM_ToDoPage rm_ToDoPage;
		RM_LoginPage rm_LoginPage;
		RM_HomePage rm_HomePage;
		RM_IncidentPage rm_IncidentPage;

		
		
		public RM_ToDoTest() {
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
		public void ViewTicket() throws Exception {
			
				rm_HomePage = new RM_HomePage();
				rm_IncidentPage = rm_HomePage.IncidentTab();
				Thread.sleep(1000);
				rm_ToDoPage = rm_IncidentPage.ToDoTab();
				Thread.sleep(1000);
			

		}


		@Feature("To Do Popup")
		@Test(priority = 1, groups = { "To Do Popup" }, 
							description = "1. If User click on Add button then To Do popup should display to create new To Do task"
										+ "2. If User keep target date as blank and click on Add button then notification should display as 'Please Enter Target Date'"
										+ "3. If User keep Description field as blank then notification should display as 'Please Enter Description'"
										+ "4. After enter/select all mandatory details if user click on save button then entry should get create in To do table and notification should display as 'To Do Addeed Successfully...!'")
		@Description("Check Title of View Ticket Page.")
		public void checkToDoPopup() throws Exception {
			rm_ToDoPage.checkToDoPopup();

		}
		
		@Feature("To Do Popup")
		@Test(priority = 2, groups = { "To Do Popup" }, 
							description = "")
		@Description("Check Title of View Ticket Page.")
		public void checkSLAFlagWithLessTime() throws Exception {
			rm_ToDoPage.checkSLAFlagWithLessTime();

		}
		
		
		@Feature("To Do Popup")
		@Test(priority = 3, groups = { "To Do Popup" }, 
							description = "")
		@Description("Check Title of View Ticket Page.")
		public void checkAssignByAndTo() throws Exception {
			rm_ToDoPage.checkAssignByAndTo();

		}
		
		@Feature("To Do Popup")
		@Test(priority = 4, groups = { "To Do Popup" }, 
							description = "")
		@Description("Check Title of View Ticket Page.")
		public void checkStatusWhenAssignToSelf() throws Exception {
			rm_ToDoPage.checkStatusWhenAssignToSelf();

		}
		
		
		@Feature("To Do Popup")
		@Test(priority = 5, groups = { "To Do Popup" }, 
							description = "")
		@Description("Check Title of View Ticket Page.")
		public void checkSLAFlagWithGreaterTime() throws Exception {
			rm_ToDoPage.checkSLAFlagWithGreaterTime();

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

					FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
							+ result.getMethod().getMethodName() + ".jpg"));

					/*driver.quit();
					initialization();

					rm_LoginPage = new RM_LoginPage();
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
					Thread.sleep(1000);
					// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");
*/
				}
			

		}

		@AfterClass
		public void TearDown() {
			driver.quit();
		}
		

	}

