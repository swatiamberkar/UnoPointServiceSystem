package com.uno.test;

import java.io.File;
import java.lang.reflect.Method;
import java.text.ParseException;

import io.qameta.allure.Description;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.BasicFlowPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_EditTicketPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;

public class BasicFlowTest extends BaseCode {

	public static int count;
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_CreateNewPage createNewPageOfSdRole;
	SD_ViewTicketPage viewTicketPageofSdRole;
	BasicFlowPage basicFlow;
	SD_EditTicketPage ticketFromOfViewTicketPage;
	public static String methodName= null;
	String currentDir = System.getProperty("user.dir");

	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\AssetData.xlsx";
	String sheetId = "Sheet1";

	public BasicFlowTest() {

		super();

	}

	// @Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		initialization();

		loginPageOfSdRole = new SD_LoginPage();
		Thread.sleep(1000);
		homePageOfSdRole = loginPageOfSdRole.login(
				properties.getProperty("loginIdForSd"),
				properties.getProperty("password"));
/*
		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000);
		basicFlow = ticketPageOfSdRole.demoPage();
		Thread.sleep(1000);
*/
		/*
		 * basicFlow = ticketPageOfSdRole.demoFlow();
		 * 
		 * basicFlow.checkUpdateButtonWithoutEnteringData();
		 */
		/*
		 * homePageOfSdRole = new SD_HomePage(); ticketPageOfSdRole =
		 * homePageOfSdRole.ticketTab(); Thread.sleep(1000);
		 * ticketFromOfViewTicketPage = ticketPageOfSdRole.EditTicket();
		 * Thread.sleep(1000);
		 * ticketFromOfViewTicketPage.checkUpdateButtonWithoutEnteringData();
		 */
	}

	@BeforeMethod(alwaysRun = true)
	public void Claim(Method method) throws Exception {

		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());
		
		homePageOfSdRole = new SD_HomePage();
		ticketPageOfSdRole = homePageOfSdRole.ticketTab();
		Thread.sleep(1000);
		basicFlow = ticketPageOfSdRole.demoPage();
		Thread.sleep(1000);

	}

	/*
	 * @Test(priority = 1, groups = { "Basic Flow" })
	 * 
	 * @Description("check that ticket is log or not") public void
	 * CreateTicket() throws Exception { basicFlow.createNewTicket();
	 * 
	 * }
	 * 
	 * @Test(priority = 2, groups = { "Basic Flow" })
	 * 
	 * @Description(
	 * " after click on Update details button then same details should get filled in Preliminary analysis tab and "
	 * + "'Incident update successfully' notification should display ") public
	 * void AssignTSD() throws Exception { basicFlow.assignTSD();
	 * 
	 * }
	 * 
	 * @Test(priority = 3, groups = { "Basic Flow" })
	 * 
	 * @Description(
	 * "if user enter all the details in ETA Technician tab then ATA date and time should be display in time spent line "
	 * ) public void AssignTechnicianAndPunchETA() throws Exception {
	 * basicFlow.assignTechnicianAndPunchETA();
	 * 
	 * }
	 * 
	 * @Test(priority = 4, groups = { "Basic Flow" })
	 * 
	 * @Description(
	 * "if user enter all the details in ATA tab then ATA date and time should be display in time spent line "
	 * ) public void PunchATA() throws Exception { basicFlow.punchATA();
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 5, groups = { "Basic Flow" }) public void AddSpare()
	 * throws Exception { basicFlow.addSpare();
	 * 
	 * }
	 * 
	 * @Test(priority = 6, groups = { "Basic Flow" }) public void
	 * TechnicianClose() throws Exception { basicFlow.technicianClose();
	 * 
	 * }
	 * 
	 * @Test(priority = 7, groups = { "Basic Flow" }) public void CloseTicket()
	 * throws Exception { basicFlow.closeTicket();
	 * 
	 * }
	 */
	// invocationCount=10
	/*
	 * @Test(priority = 1, groups = { "Basic Flow" }) public void TicketFlow()
	 * throws Exception { basicFlow.createNewTicket(); //basicFlow.assignTSD();
	 * basicFlow.assignTechnicianAndPunchETA(); Thread.sleep(9000);
	 * basicFlow.punchATA(); basicFlow.addSpare(); basicFlow.technicianClose();
	 * Thread.sleep(20000); basicFlow.closeTicket();
	 * 
	 * }
	 */

	// invocationCount=2
	
	  @Test(priority = 7, groups = { "Basic Flow" }, invocationCount=5) 
	  public void TicketFlowUptoTechClose() throws Exception {
	  basicFlow.createNewTicket(); 
	   Thread.sleep(10000);
	  basicFlow.assignTechnicianAndPunchETA(); 
	   Thread.sleep(10000);
	  basicFlow.punchATA(); 
	  Thread.sleep(20000); 
	  basicFlow.addSpareTab();
	  Thread.sleep(20000);
	  basicFlow.technicianClose();
	  Thread.sleep(50000);
	  basicFlow.closeTicket();
	  
	  
	  
	  }
	 


	@DataProvider
	public String[][] assetData() throws Exception {
		TestUtil data = new TestUtil();
		// Object data[][] = TestUtility.getSheetdata(sheetName);
		return data.getCellData(xlFilePath, sheetId);
	

	}
	/*@Test(priority = 1, dataProvider = "assetData", groups = { "Basic Flow" },invocationCount=	10)
	public void TicketFlowByExcel(String siteCodetxt,String customerContactNametxt,
			String customerContactNotxt, String customerContactEmailIDtxt,
			String customerAddressTxt, String regionTxt, String stateTxt,
			String popLocationTxt, String cityTxt, String distancetxt,
			String averageTravelTimeTxt, String customerSLATxt,
			String ourSLATxt, String responseTimeTxt,
			String productCategoryInProductTxt,
			String productSubCategoryInProductTxt, 
			String assetIdTxt, String makeInProductTxt,
			String productModelNoTxt, String engineerGradeTxt,
			String engineerTxt, String pmFrequencyTxt,
			String contractReferenceAvailableTxt, String contractRefNoTxt)
			throws Exception {
		basicFlow.createNewTicketWithAsset(siteCodetxt,customerContactNametxt, customerContactNotxt,
				customerContactEmailIDtxt, customerAddressTxt, regionTxt,
				stateTxt, popLocationTxt, cityTxt, distancetxt,
				averageTravelTimeTxt, customerSLATxt, ourSLATxt,
				responseTimeTxt, productCategoryInProductTxt,
				productSubCategoryInProductTxt, assetIdTxt,
				makeInProductTxt, productModelNoTxt, engineerGradeTxt,
				engineerTxt, pmFrequencyTxt, contractReferenceAvailableTxt,
				contractRefNoTxt);
		// basicFlow.assignTSD();
*/
		/*
		 * basicFlow.assignTechnicianAndPunchETA(); Thread.sleep(9000);
		 * basicFlow.punchATA(); basicFlow.addSpare(serialNo);
		 * basicFlow.technicianClose(serialNo); Thread.sleep(30000);
		 * basicFlow.closeTicket(serialNo);
		 

	}*/

	
	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());

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

			
			  driver.quit(); initialization();
			  
			  loginPageOfSdRole = new SD_LoginPage(); homePageOfSdRole =
			  loginPageOfSdRole.login( properties.getProperty("username"),
			  properties.getProperty("password"));
			 
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
