package com.uno.test.technician;





import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_TicketSummaryPage;
import com.uno.pages.sd.SD_ViewTicketPage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.pages.technician.Technician_IncidentPage;
import com.uno.pages.technician.Technician_TicketSummaryPage;
import com.uno.pages.technician.Technician_ViewIncidentPage;




public class Technician_TicketSummaryTest extends BaseCode{

	
	SD_LoginPage sd_LoginPage;
	Technician_HomePage technician_HomePage;
	Technician_IncidentPage technician_IncidentPage;
	Technician_ViewIncidentPage technician_ViewIncidentPage;

	Technician_TicketSummaryPage technician_TicketSummaryPage;
	Integer count;
	Integer totalcount;
	
	public Technician_TicketSummaryTest ()
	{
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		initialization();

		sd_LoginPage = new SD_LoginPage();
		technician_HomePage = sd_LoginPage.technicianLogin(
				properties.getProperty("loginIdForTechnician"),
				properties.getProperty("password"));
		
		
	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		technician_TicketSummaryPage = new Technician_TicketSummaryPage();
		tabHome.click();
			
			
		

	}


	
	
	@Test(priority=1, description = "Check Title of View Ticket Page.")
			public void TicketSummaryTab() throws Exception
			{
			technician_TicketSummaryPage.ticketSummaryTab();
			
			}
	
	
	
	@Test(priority=2, groups = { "Open Tab", "Smoke Testing" })
			public void VerifyTotalCountAndStatusOfRequestsOpenTab() throws Exception
			{
			
			technician_TicketSummaryPage.verifyTotalCountAndStatusOfRequestsOpenTab();
			}

	
	@Test(priority=3, groups = { "Open Tab", "Smoke Testing" })
			public void TotalCountofAssignedButNoETATab() throws Exception
			{
			technician_TicketSummaryPage.totalCountofAssignedButNoETATab();
			}

	
	@Test(priority=11, groups = { "Open Tab", "Smoke Testing" })
			public void TotalCountOfETAExpiredAndNoATATab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfETAExpiredAndNoATATab();
			}
		
	@Test(priority=12, groups = { "Open Tab", "Smoke Testing" })
			public void StatusOfETAExpiredAndNoATATab() throws Exception
			{
				technician_TicketSummaryPage.statusOfETAExpiredAndNoATATab();
			
			}

	@Test(priority=13, groups = { "Open Tab" , "Smoke Testing"})
			public void CompareTimeOfETAInETAExpiredAndNoATATab() throws Exception
			{
				technician_TicketSummaryPage.compareTimeOfETAInETAExpiredAndNoATATab();
				
			}
	
	@Test(priority=14, groups = { "Open Tab", "Smoke Testing" })
			public void ATAOfETAExpiredAndNoATATab() throws Exception
			{
				technician_TicketSummaryPage.aTAOfETAExpiredAndNoATATab();
				
			}
	
	@Test(priority=15,groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountOfWorkInProgressTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfWorkInProgressTab();
			}
	
	@Test(priority=16,groups = { "Work In Progress Tab", "Smoke Testing" })
			public void StatusOfWorkInProgressTab() throws Exception
			{
				technician_TicketSummaryPage.statusOfWorkInProgressTab();
			}

	@Test(priority=17, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void ATAOfWorkInProgressTab() throws Exception
			{
				technician_TicketSummaryPage.aTAOfWorkInProgressTab();
			}
	

	
		
	@Test(priority=18, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountOfRequestsPausedTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestsPausedTab();
			}

	@Test(priority=19, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void StatusOfRequestsPausedTab() throws Exception
			{
				technician_TicketSummaryPage.statusOfRequestsPausedTab();
			}	

	
		
	@Test(priority=20, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountOfPendingForSparesTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfPendingForSparesTab();
			}

	
				
	@Test(priority=21, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAColdTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestSLAColdTab();
		
			}
				
	
	@Test(priority=22, groups = { "SLA Tab", "Smoke Testing" })
			public void CompareColdSLAImageOfRequestSLAColdTab() throws Exception
			{
				technician_TicketSummaryPage.compareColdSLAImageOfRequestSLAColdTab();
			}


	@Test(priority=23, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAHotTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestSLAHotTab();
			}
		
	@Test(priority=24, groups = { "SLA Tab" , "Smoke Testing"})
			public void CompareHotSLAImageOfRequestSLAHotTab() throws Exception
			{
				technician_TicketSummaryPage.compareHotSLAImageOfRequestSLAHotTab();
			}
	
	@Test(priority=25, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAWarmTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestSLAWarmTab();
			}		
	@Test(priority=26, groups = { "SLA Tab", "Smoke Testing" })
			public void CompareWarmSLAImageOfRequestSLAWarmTab() throws Exception
			{
				technician_TicketSummaryPage.compareWarmSLAImageOfRequestSLAWarmTab();
			}

				
	@Test(priority=27, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLANearToViolationTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestSLANearToViolationTab();
			}
	
	@Test(priority=28, groups = { "SLA Tab" , "Smoke Testing"})
			public void CompareNearToViolationImageOfRequestSLANearToViolationTab() throws Exception
			{
				technician_TicketSummaryPage.compareWarmNearToViolationImageOfRequestSLANearToViolationTab();
			}
	
				
	@Test(priority=29,groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAViolatedTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestSLAViolatedTab();
			}
		
	@Test(priority=30, groups = { "SLA Tab", "Smoke Testing" })
			public void CompareViolatedSLAImageOfRequestSLAViolatedTab() throws Exception
			{
				technician_TicketSummaryPage.compareViolatedSLAImageOfRequestSLAViolatedTab();
			}


	
	@Test(priority=31, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfConsumedWithSparesTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfConsumedWithSparesTab();
			}


	@Test(priority=32, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfRequestsClosedByTechnicianTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfRequestsClosedByTechnicianTab();	
			}
	

	@Test(priority=33, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfRequestsFinalClosedTab() throws Exception
			{
			technician_TicketSummaryPage.totalCountOfRequestsFinalClosedTab();
			}
	

	@Test(priority=34, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfAllRequestsTab() throws Exception
			{
				technician_TicketSummaryPage.totalCountOfAllRequestsTab();
			}
	
	
	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());
		
		try{
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

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
	

		}
}catch(Exception e)
{
	driver.quit();
	initialization();

	

	sd_LoginPage = new SD_LoginPage();
	technician_HomePage = sd_LoginPage.technicianLogin(
			properties.getProperty("loginIdForTechnician"),
			properties.getProperty("password"));
	Thread.sleep(1000);
/*	technician_HomePage = new SD_HomePage();
	driver.findElement(By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
	 sd_TicketSummaryPage=technician_HomePage.ticketSummaryTab();*/
	}

	}

	@AfterClass

	public void TearDown() {
		driver.quit();
	}

	


}
