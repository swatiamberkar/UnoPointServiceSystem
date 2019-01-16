package com.uno.test.sd;

import io.qameta.allure.Description;

import java.io.File;
import java.lang.reflect.Method;

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
import com.uno.pages.sd.SD_EngineerActivityPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_SDActivityPage;
import com.uno.pages.sd.SD_TicketPage;


public class SD_SDActivityTest extends BaseCode {
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_EngineerActivityPage engineerActivityPageOfSdRole;
	SD_SDActivityPage sdActivityPageOfSdRole;
	String currentDir = System.getProperty("user.dir");
	
	public SD_SDActivityTest() {

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
	public void EngineerActivityTab(Method method) throws Exception  {

		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		
		homePageOfSdRole = new SD_HomePage();
		driver.findElement(By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000);
		sdActivityPageOfSdRole =ticketPageOfSdRole.SDActivityTab();
		Thread.sleep(2000);

	}


	
	@Test(priority = 2, groups = { "Engineer Activity" }, 
	description = "1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill ")
	@Description ("1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill")			
	public void checkFromAndToDateAccordingSelectedDateRange() throws Exception  {

		sdActivityPageOfSdRole.checkFromAndToDateAccordingSelectedDateRange();

	}
	
	@Test(priority = 2, groups = { "Engineer Activity" }, 
	description = "1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill ")
	@Description ("1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill")			
	public void verifyPopLocationAccordingSelectedPopLocation() throws Exception  {

		sdActivityPageOfSdRole.verifyPopLocationAccordingSelectedPopLocation();

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

				FileUtils.copyFile(scrFile, new File(currentDir
						+ "/Screenshots/" + result.getMethod().getMethodName()
						+ ".jpg"));
/*
				driver.quit();
				initialization();

				loginPageOfSdRole = new SD_LoginPage();
				homePageOfSdRole = loginPageOfSdRole.login(
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
		//driver.quit();
	}


}
