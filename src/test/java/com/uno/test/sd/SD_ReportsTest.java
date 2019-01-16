package com.uno.test.sd;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.BasicFlowPage;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_EditTicketPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_ReportsPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;

public class SD_ReportsTest extends BaseCode {
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_TicketPage sd_TicketPage;
	SD_ReportsPage sd_ReportsPage;
	
	
	public SD_ReportsTest() {

		super();

	}

	//@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	
	public void Login() throws Exception {
		initialization();

		sd_LoginPage = new SD_LoginPage();
		Thread.sleep(1000);
		sd_HomePage = sd_LoginPage.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));

		sd_TicketPage = sd_HomePage.ticketTab();
		Thread.sleep(1000);
		sd_ReportsPage = sd_TicketPage.reportsTab();
		Thread.sleep(1000);

	}

	
	 @Test(priority = 1, groups = { "" }, description="If user click on generate report button after apply start date and end date filter then report should get download as per entered applied date range") 
	 public void createNewTicket()
	  throws Exception { 
		 sd_ReportsPage.verifyDateByDownloadDailyReports();
	  
	  }
	 
	 @Test(priority = 1, groups = { "" }, description="If user click on generate report button after apply start date and end date filter then report should get download as per entered applied date range") 
	 public void myView()
	  throws Exception { 
		 sd_ReportsPage.myView();
	  
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
			
			// TestUtil.takeScreenshotAtEndOfTest();
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			String currentDir = System.getProperty("user.dir");

			FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
					+ result.getMethod().getMethodName() + ".jpg"));

		
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			

		}
		
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
