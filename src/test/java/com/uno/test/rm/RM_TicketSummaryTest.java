package com.uno.test.rm;





import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
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
import com.uno.pages.rm.RM_TicketSummaryPage;
import com.uno.pages.rm.RM_ViewIncidentPage;
import com.uno.pages.sd.SD_LoginPage;




public class RM_TicketSummaryTest extends BaseCode{

	
	SD_LoginPage sd_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;
	RM_ViewIncidentPage rm_ViewIncidentPage;

	RM_TicketSummaryPage rm_TicketSummaryPage;
	Integer count;
	Integer totalcount;
	
	public RM_TicketSummaryTest ()
	{
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		initialization();

		sd_LoginPage = new SD_LoginPage();
		rm_HomePage = sd_LoginPage.rmLogin(
				properties.getProperty("loginIdForRM"),
				properties.getProperty("password"));
		
		
	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		rm_TicketSummaryPage = new RM_TicketSummaryPage();
		tabHome.click();
		tabTicketSummary.click();
			
			
		

	}


	
	
	@Test(priority=1, description = "Check Title of View Ticket Page.")
			public void TicketSummaryTab() throws Exception
			{
			rm_TicketSummaryPage.ticketSummaryTab();
			
			}
	
	
	
	@Test(priority=2, groups = { "Open Tab", "Smoke Testing" })
			public void VerifyTotalCountAndStatusOfRequestsOpenTab() throws Exception
			{
			
			rm_TicketSummaryPage.verifyTotalCountAndStatusOfRequestsOpenTab();
			}

	
	@Test(priority=3, groups = { "Open Tab", "Smoke Testing" })
			public void TotalCountofAssignedButNoETATab() throws Exception
			{
			rm_TicketSummaryPage.totalCountofAssignedButNoETATab();
			}

	
	@Test(priority=11, groups = { "Open Tab", "Smoke Testing" })
			public void TotalCountOfETAExpiredAndNoATATab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfETAExpiredAndNoATATab();
			}
		
	@Test(priority=12, groups = { "Open Tab", "Smoke Testing" })
			public void StatusOfETAExpiredAndNoATATab() throws Exception
			{
				rm_TicketSummaryPage.statusOfETAExpiredAndNoATATab();
			
			}

	@Test(priority=13, groups = { "Open Tab" , "Smoke Testing"})
			public void CompareTimeOfETAInETAExpiredAndNoATATab() throws Exception
			{
				rm_TicketSummaryPage.compareTimeOfETAInETAExpiredAndNoATATab();
				
			}
	
	@Test(priority=14, groups = { "Open Tab", "Smoke Testing" })
			public void ATAOfETAExpiredAndNoATATab() throws Exception
			{
				rm_TicketSummaryPage.aTAOfETAExpiredAndNoATATab();
				
			}
	
	@Test(priority=15,groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountOfWorkInProgressTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfWorkInProgressTab();
			}
	
	@Test(priority=16,groups = { "Work In Progress Tab", "Smoke Testing" })
			public void StatusOfWorkInProgressTab() throws Exception
			{
				rm_TicketSummaryPage.statusOfWorkInProgressTab();
			}

	@Test(priority=17, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void ATAOfWorkInProgressTab() throws Exception
			{
				rm_TicketSummaryPage.aTAOfWorkInProgressTab();
			}
	

	
		
	@Test(priority=18, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountOfRequestsPausedTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestsPausedTab();
			}

	@Test(priority=19, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void StatusOfRequestsPausedTab() throws Exception
			{
				rm_TicketSummaryPage.statusOfRequestsPausedTab();
			}	

	
		
	@Test(priority=20, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountOfPendingForSparesTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfPendingForSparesTab();
			}

	
				
	@Test(priority=21, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAColdTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestSLAColdTab();
		
			}
				
	
	@Test(priority=22, groups = { "SLA Tab", "Smoke Testing" })
			public void CompareColdSLAImageOfRequestSLAColdTab() throws Exception
			{
				rm_TicketSummaryPage.compareColdSLAImageOfRequestSLAColdTab();
			}


	@Test(priority=23, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAHotTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestSLAHotTab();
			}
		
	@Test(priority=24, groups = { "SLA Tab" , "Smoke Testing"})
			public void CompareHotSLAImageOfRequestSLAHotTab() throws Exception
			{
				rm_TicketSummaryPage.compareHotSLAImageOfRequestSLAHotTab();
			}
	
	@Test(priority=25, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAWarmTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestSLAWarmTab();
			}		
	@Test(priority=26, groups = { "SLA Tab", "Smoke Testing" })
			public void CompareWarmSLAImageOfRequestSLAWarmTab() throws Exception
			{
				rm_TicketSummaryPage.compareWarmSLAImageOfRequestSLAWarmTab();
			}

				
	@Test(priority=27, groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLANearToViolationTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestSLANearToViolationTab();
			}
	
	@Test(priority=28, groups = { "SLA Tab" , "Smoke Testing"})
			public void CompareNearToViolationImageOfRequestSLANearToViolationTab() throws Exception
			{
				rm_TicketSummaryPage.compareWarmNearToViolationImageOfRequestSLANearToViolationTab();
			}
	
				
	@Test(priority=29,groups = { "SLA Tab", "Smoke Testing" })
			public void TotalCountOfRequestSLAViolatedTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestSLAViolatedTab();
			}
		
	@Test(priority=30, groups = { "SLA Tab", "Smoke Testing" })
			public void CompareViolatedSLAImageOfRequestSLAViolatedTab() throws Exception
			{
				rm_TicketSummaryPage.compareViolatedSLAImageOfRequestSLAViolatedTab();
			}


	
	@Test(priority=31, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfConsumedWithSparesTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfConsumedWithSparesTab();
			}

	


	

	@Test(priority=32, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfRequestsClosedByTechnicianTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfRequestsClosedByTechnicianTab();	
			}
	

	@Test(priority=33, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfRequestsFinalClosedTab() throws Exception
			{
			rm_TicketSummaryPage.totalCountOfRequestsFinalClosedTab();
			}
	

/*	@Test(priority=34, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfAllRequestsTab() throws Exception
			{
				rm_TicketSummaryPage.totalCountOfAllRequestsTab();
			}*/
			
	
	


	/*@Test(priority=32, groups = { "Resolved Tab", "Smoke Testing" })
	public void TotalCountOfRequestsCancelTab() throws Exception
	{
		technician_TicketSummaryPage.totalCountOfRequestsCancelTab();
	}

	@Test(priority=36, groups = { "Resolved Tab", "Smoke Testing" })
	public void SumOfAllRequestTab() throws Exception
	{
		technician_TicketSummaryPage.sumOfAllRequestTab();
		
		
	}
	*/
	/*@Test(priority=2, description="Count of Requests Open")
	public void testCountOfRequestsOpenTab() throws Exception
	{
	ticketSummaryPageOfSdPage.countOfRequestsOpenTab();
	}*/
		
	/*@Test(priority=5, description="Count of Un-Assigned")
	public void testCountOfUnAssignedTab() throws Exception
	{
	ticketSummaryPageOfSdPage.countOfUnAssignedTab();
	}*/

	/*@Test(priority=9, description=" Count of Assigned But No ETA ")
			public void testCountOfAssignedButNoETATab() throws Exception
			{
			ticketSummaryPageOfSdPage.countOfAssignedButNoETATab();
			}*/
	/*@Test(priority=14,description="ETA Time column of Assigned But No ETA is blank ")
	public void testETATimeOfAssignedButNoETATab() throws Exception
	{
		ticketSummaryPageOfSdPage.eTATimeOfAssignedButNoETATab();
	}*/

/*@Test(priority=15, description=" Count of ETA Expaired And No ATA ")
	public void testCountOfETAExpiredAndNoATATab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfETAExpiredAndNoATATab();
	}
*/
	
/*@Test(priority=20, description=" Work In Prograss-Count of WIP ")
		public void testCountOfWorkInProgressTab() throws Exception
		{
			ticketSummaryPageOfSdPage.countOfWorkInProgressTab();
		}
	*/

	/*@Test(priority=24, description=" Work In Prograss-Count of Requests Paused")
	public void testCountOfRequestsPausedTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfRequestsPausedTab();
		
		
	}*/

	/*@Test(priority=27, description=" Work In Prograss- Count of Pending for spares ")
	public void testCountOfPendingForSparesTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfPendingForSparesTab();
		
		
	}*/
	
	/*@Test(priority=29, description=" SLA-Count of Request SLA Cold ")
	public void testCountOfRequestSLAColdTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfRequestSLAColdTab();
		
		
	}*/
	
	/*@Test(priority=32, description=" SLA-Count of Request SLA Hot ")
	public void testCountOfRequestSLAHotTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfRequestSLAHotTab();	
	}*/
		
	
/*@Test(priority=35, description=" SLA-Count of Request SLA Warm ")
		public void testCountOfRequestSLAWarmTab() throws Exception
		{
			ticketSummaryPageOfSdPage.countOfRequestSLAWarmTab();	
		}*/
			

	/*@Test(priority=38, description=" SLA-Count of Request SLA Near To Violation ")
			public void testCountOfRequestSLANearToViolationTab() throws Exception
			{
				ticketSummaryPageOfSdPage.countOfRequestSLANearToViolationTab();	
			}*/
	

	/*@Test(priority=41, description=" SLA-Count of Request SLA Violated ")
			public void testCountOfRequestSLAViolatedTab() throws Exception
			{
				ticketSummaryPageOfSdPage.countOfRequestSLAViolatedTab();
			}*/
	
	/*@Test(priority=44, description="Resolved-Consumed with spares-Count")
	public void testCountOfConsumedWithSparesTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfConsumedWithSparesTab();
	}*/
	
	/*@Test(priority=32, description="Resolved-Requests Cancel-Count")
	public void testCountOfRequestsCancelTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfRequestsCancelTab();	
	}*/
	
	/*@Test(priority=33, description="Resolved-Requests Closed by Technician-Count")
	public void testCountOfRequestsClosedByTechnicianTab() throws Exception
	{
		ticketSummaryPageOfSdPage.countOfRequestsClosedByTechnicianTab();	
	}*/
	

	/*@Test(priority=50, description="Resolved-Requests Final Closed-Count")
			public void testCountOfRequestsFinalClosedTab() throws Exception
			{
				ticketSummaryPageOfSdPage.countOfRequestsFinalClosedTab();
			}*/
	

	/*@Test(priority=52, description="Resolved-All Requests-Count")
			public void testCountOfAllRequestsTab() throws Exception
			{
			ticketSummaryPageOfSdPage.countOfAllRequestsTab();
			}*/
	
	
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
	rm_HomePage = sd_LoginPage.rmLogin(
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
		driver.quit();
	}

	


}
