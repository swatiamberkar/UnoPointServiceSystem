package com.uno.test.sd;

import java.io.File;
import java.lang.reflect.Method;

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

import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ToDoPage;



public class SD_ToDoTest extends SD_ToDoPage{
	
	SD_ToDoPage toDoPageOfSdRole;
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	String currentDir = System.getProperty("user.dir");



	
	
	public SD_ToDoTest() {
		super();
	}
	
	
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		try {
			initialization();

			loginPageOfSdRole = new SD_LoginPage();
			homePageOfSdRole = loginPageOfSdRole.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			
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

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		
		try {
			homePageOfSdRole = new SD_HomePage();
			ticketPageOfSdRole = homePageOfSdRole.ticketTab();
			Thread.sleep(1000);
			toDoPageOfSdRole = ticketPageOfSdRole.toDo();
			Thread.sleep(1000);
		} catch (Exception e) {
			
			initialization();

			loginPageOfSdRole = new SD_LoginPage();
			homePageOfSdRole = loginPageOfSdRole.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			homePageOfSdRole = new SD_HomePage();
			ticketPageOfSdRole = homePageOfSdRole.ticketTab();
			Thread.sleep(1000);
			toDoPageOfSdRole = ticketPageOfSdRole.toDo();
			Thread.sleep(1000);

			// e.printStackTrace();
		}

	}


	@Feature("To Do Popup")
	@Test(priority = 1, groups = { "To Do Popup" }, 
						description = "1. If User click on Add button then To Do popup should display to create new To Do task"
									+ "2. If User keep target date as blank and click on Add button then notification should display as 'Please Enter Target Date'"
									+ "3. If User keep Description field as blank then notification should display as 'Please Enter Description'"
									+ "4. After enter/select all mandatory details if user click on save button then entry should get create in To do table and notification should display as 'To Do Addeed Successfully...!'")
	@Description("Check Title of View Ticket Page.")
	public void checkToDoPopup() throws Exception {
		toDoPageOfSdRole.checkToDoPopup();

	}
	
	@Feature("To Do Popup")
	@Test(priority = 2, groups = { "To Do Popup" }, 
						description = "")
	@Description("Check Title of View Ticket Page.")
	public void checkSLAFlagWithLessTime() throws Exception {
		toDoPageOfSdRole.checkSLAFlagWithLessTime();

	}
	
	
	@Feature("To Do Popup")
	@Test(priority = 3, groups = { "To Do Popup" }, 
						description = "")
	@Description("Check Title of View Ticket Page.")
	public void checkAssignByAndTo() throws Exception {
		toDoPageOfSdRole.checkAssignByAndTo();

	}
	
	@Feature("To Do Popup")
	@Test(priority = 4, groups = { "To Do Popup" }, 
						description = "")
	@Description("Check Title of View Ticket Page.")
	public void checkStatusWhenAssignToSelf() throws Exception {
		toDoPageOfSdRole.checkStatusWhenAssignToSelf();

	}
	
	
	@Feature("To Do Popup")
	@Test(priority = 5, groups = { "To Do Popup" }, 
						description = "")
	@Description("Check Title of View Ticket Page.")
	public void checkSLAFlagWithGreaterTime() throws Exception {
		toDoPageOfSdRole.checkSLAFlagWithGreaterTime();

	}
	
	
	

	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {

		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());
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

				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
						+ result.getMethod().getMethodName() + ".jpg"));

				try {
					homePageOfSdRole = new SD_HomePage();
					ticketPageOfSdRole = homePageOfSdRole.ticketTab();
					Thread.sleep(1000);
					toDoPageOfSdRole = ticketPageOfSdRole.toDo();
					Thread.sleep(1000);
				} catch (Exception e) {
					driver.quit();
					initialization();

					loginPageOfSdRole = new SD_LoginPage();
					homePageOfSdRole = loginPageOfSdRole.login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);
				}

				// takeScreenshot(dateTimeStamp,driver,methodName);
				// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
				// Do your excel writing stuff here

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				try {
					homePageOfSdRole = new SD_HomePage();
					ticketPageOfSdRole = homePageOfSdRole.ticketTab();
					Thread.sleep(1000);
					toDoPageOfSdRole = ticketPageOfSdRole.toDo();
					Thread.sleep(1000);
				} catch (Exception e) {
					driver.quit();
					initialization();

					loginPageOfSdRole = new SD_LoginPage();
					homePageOfSdRole = loginPageOfSdRole.login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);
				}

				// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

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
