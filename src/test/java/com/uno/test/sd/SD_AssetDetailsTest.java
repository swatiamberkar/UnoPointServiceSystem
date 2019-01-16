package com.uno.test.sd;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.BasicFlowPage;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_EditTicketPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;

public class SD_AssetDetailsTest extends BaseCode{
	
	public static int count ;
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_CreateNewPage createNewPageOfSdRole;
	SD_ViewTicketPage viewTicketPageofSdRole;
	BasicFlowPage basicFlow;
	SD_EditTicketPage ticketFromOfViewTicketPage;


	public SD_AssetDetailsTest() {

		super();

	}

	//@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	
	public void Login() throws Exception {
		initialization();

		loginPageOfSdRole = new SD_LoginPage();
		Thread.sleep(1000);
		homePageOfSdRole = loginPageOfSdRole.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000);
		basicFlow = ticketPageOfSdRole.demoPage();
		Thread.sleep(1000);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void Claim(Method method) throws Exception {
		String currentDir = System.getProperty("user.dir");
		String path= currentDir + "/Recording/"
				+ method.getName();
		method.getName();
		startRecording(path,method.getName());
		
			
		}

	
	// invocationCount=2
	 @Test(priority = 1, groups = { "Basic Flow" }) 
	 public void createNewTicket()
	  throws Exception { 
		 
		 basicFlow.checkCustomerAddress();
		
		
	  
	  }
	
	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {
		stopRecording();

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======PASS======");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======FAIL======");
			
			// TestUtil.takeScreenshotAtEndOfTest();
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			String currentDir = System.getProperty("user.dir");

			FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
					+ result.getMethod().getMethodName() + ".jpg"));

			/*
			 * driver.quit(); initialization();
			 * 
			 * loginPageOfSdRole = new SD_LoginPage(); homePageOfSdRole =
			 * loginPageOfSdRole.login( properties.getProperty("username"),
			 * properties.getProperty("password"));
			 */
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			/*
			 * driver.quit();
			 * 
			 * loginPageOfSdRole = new SD_LoginPage(); homePageOfSdRole =
			 * loginPageOfSdRole.login( properties.getProperty("username"),
			 * properties.getProperty("password"));
			 */

		}
		/* driver.quit(); */
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
